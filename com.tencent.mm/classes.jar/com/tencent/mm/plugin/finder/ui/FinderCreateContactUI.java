package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.f.b.a.ce;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.cgi.cp;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_CODE_SELECT_DISTRICT", "REQUEST_CODE_SELECT_SEX", "TAG", "", "avatarPath", "avatarView", "Landroid/widget/ImageView;", "canSelectSex", "", "changeAvatarView", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getChangeAvatarView", "()Landroid/widget/LinearLayout;", "changeAvatarView$delegate", "Lkotlin/Lazy;", "clearNameBtn", "Landroid/view/View;", "createBtn", "Landroid/widget/Button;", "createScene", "districtLayout", "districtTV", "Landroid/widget/TextView;", "editBottomSpace", "editMiddleSpace", "editNickNameLimit", "editTopSpace", "goToPageAfterCreateSucc", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "locationArrowIcon", "locationIcon", "locationInfoIcon", "mvStatus", "nickEdt", "Landroid/widget/EditText;", "nicknameMaxLength", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "routerToProfile", "scene", "scrollContainer", "scrollViewOriginHeight", "sexArrowIcon", "sexInfoIcon", "sexLayout", "getSexLayout", "sexLayout$delegate", "sexTV", "tipsCheckCB", "Landroid/widget/CheckBox;", "tipsWarningTV", "titleTv", "topErrorTip", "wxProfileLayout", "getWxProfileLayout", "wxProfileLayout$delegate", "wxProfileSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getWxProfileSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "wxProfileSwitchBtn$delegate", "createContact", "", "generateKey", "avatarFileMD5", "avatarLen", "getLayoutId", "hideError", "initContentView", "isLastSelectDistrictEmpty", "notifyChanged", "user", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickEditDistrict", "view", "onClickEditSex", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTipsCheckBoxClick", "requestCreateUser", "imgUrl", "setAvatar", "path", "setDistrictTV", "countryCodeName", "provinceCodeName", "cityCodeName", "setMvView", "setSpanTouch", "descTv", "text", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "spanLinks", "context", "Landroid/content/Context;", "h5urlList", "", "allText", "linkTextList", "logTag", "updateDistrict", "isAuto", "updateSex", "Companion", "plugin-finder_release"})
public final class FinderCreateContactUI
  extends MMFinderUI
  implements f.a, com.tencent.mm.an.i, com.tencent.mm.ui.widget.c.a
{
  private static String ApH;
  private static String ApI;
  private static int ApJ = 0;
  private static int ApK = 0;
  private static int ApL = 0;
  private static String ApM;
  private static String ApN;
  private static String ApO;
  private static String ApP;
  private static String ApQ;
  private static String ApR;
  private static boolean ApS = false;
  private static String ApT;
  private static final HashMap<String, String> ApU;
  private static final int ApV = 1;
  private static final int ApW = 2;
  public static final a ApX;
  private static String ndV;
  private View AoZ;
  private boolean ApA;
  private final kotlin.f ApB;
  private final kotlin.f ApC;
  private final kotlin.f ApD;
  private final kotlin.f ApE;
  private boolean ApF;
  private int ApG;
  private EditText Apa;
  private TextView Apb;
  private TextView Apc;
  private View Apd;
  private View Ape;
  private View Apf;
  private View Apg;
  private View Aph;
  private View Api;
  private Button Apj;
  private View Apk;
  private View Apl;
  private View Apm;
  private InputPanelFrameLayout Apn;
  private TextView Apo;
  private TextView App;
  private View Apq;
  private CheckBox Apr;
  private TextView Aps;
  private final int Apt;
  private final int Apu;
  private ProgressDialog Apv;
  private int Apw;
  private int Apx;
  private int Apy;
  private int Apz;
  private final String TAG;
  private HashMap _$_findViewCache;
  private ImageView mOe;
  private int scene;
  private TextView titleTv;
  private String wQa;
  private ble wZz;
  private final int xOK;
  private final int xOL;
  private View ybx;
  
  static
  {
    AppMethodBeat.i(167188);
    ApX = new a((byte)0);
    ndV = "";
    ApH = "";
    ApI = "";
    ApM = "";
    ApN = "";
    ApO = "";
    ApP = "";
    ApQ = "";
    ApR = "";
    ApS = true;
    ApT = "";
    ApU = new HashMap();
    ApV = 1;
    ApW = 2;
    AppMethodBeat.o(167188);
  }
  
  public FinderCreateContactUI()
  {
    AppMethodBeat.i(290365);
    this.TAG = "Finder.FinderCreateContactUI";
    this.xOK = 1000;
    this.xOL = 1001;
    this.Apt = 1002;
    this.Apu = 1003;
    this.Apz = 20;
    this.ApA = true;
    this.ApB = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.ApC = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.ApD = kotlin.g.ar((kotlin.g.a.a)new t(this));
    this.ApE = kotlin.g.ar((kotlin.g.a.a)new u(this));
    this.ApF = true;
    AppMethodBeat.o(290365);
  }
  
  private void a(Context paramContext, List<String> paramList1, String paramString1, List<String> paramList2, TextView paramTextView, String paramString2)
  {
    AppMethodBeat.i(290363);
    p.k(paramContext, "context");
    p.k(paramList1, "h5urlList");
    p.k(paramString1, "allText");
    p.k(paramList2, "linkTextList");
    p.k(paramTextView, "descTv");
    p.k(paramString2, "logTag");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString1);
    paramList2 = ((Iterable)paramList2).iterator();
    int i = 0;
    while (paramList2.hasNext())
    {
      Object localObject = paramList2.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject = (String)localObject;
      int j = kotlin.n.n.a((CharSequence)paramString1, (String)localObject, 0, false, 6);
      int k = j + ((String)localObject).length();
      if ((j >= 0) && (k <= paramString1.length()))
      {
        localObject = (String)paramList1.get(i);
        Context localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        int m = localContext.getResources().getColor(b.c.link_color);
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localSpannableString.setSpan(new o((String)localObject, m, localContext.getResources().getColor(b.c.BW_0_Alpha_0_2), (kotlin.g.a.b)new FinderCreateContactUI.q(paramString1, localSpannableString, paramList1, paramString2, paramContext)), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText((CharSequence)localSpannableString);
    a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(290363);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(290356);
    p.k(paramTextView, "descTv");
    p.k(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderCreateContactUI.n(this, paramSpannable, paramTextView));
    AppMethodBeat.o(290356);
  }
  
  private static void aFb(String paramString)
  {
    AppMethodBeat.i(290359);
    ard localard1 = new ard();
    ard localard2 = new ard();
    String str = ApI;
    int i;
    switch (str.hashCode())
    {
    default: 
      localard1.sex = 0;
      i = 1;
      label67:
      if (!p.h(ApM, "unshow")) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramString = new aw(ApH, "", paramString, localard1, i, j, localard2, ApS);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramString);
      AppMethodBeat.o(290359);
      return;
      if (!str.equals("female")) {
        break;
      }
      localard1.sex = 2;
      i = 0;
      break label67;
      if (!str.equals("male")) {
        break;
      }
      localard1.sex = 1;
      i = 0;
      break label67;
      localard1.country = ApM;
      localard1.province = ApN;
      localard1.city = ApO;
    }
  }
  
  private final void ag(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(290353);
    Log.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = com.tencent.mm.plugin.findersdk.a.j.PATTERN.matcher((CharSequence)paramString1);
    if (((Matcher)localObject).find())
    {
      String str1 = ((Matcher)localObject).group(1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (((Matcher)localObject).start(0) > 0)
      {
        i = ((Matcher)localObject).start(0);
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(290353);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        p.j(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(str2);
      }
      localStringBuilder.append(str1);
      if (((Matcher)localObject).end(0) < paramString1.length())
      {
        i = ((Matcher)localObject).end(0);
        j = paramString1.length();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(290353);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        p.j(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      p.j(paramString1, "sb.toString()");
      int i = ((Matcher)localObject).start(0);
      int j = str1.length();
      paramString1 = new SpannableString((CharSequence)paramString1);
      p.j(str1, "content");
      localObject = getContext();
      p.j(localObject, "context");
      int k = ((AppCompatActivity)localObject).getResources().getColor(b.c.Link);
      localObject = getContext();
      p.j(localObject, "context");
      paramString1.setSpan(new o(str1, k, ((AppCompatActivity)localObject).getResources().getColor(b.c.Link_Alpha_0_6), (kotlin.g.a.b)new p(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.Apo;
      if (paramString2 == null) {
        p.bGy("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.Apo;
      if (paramString2 == null) {
        p.bGy("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.Apo;
      if (paramString1 == null) {
        p.bGy("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(290353);
      return;
      paramString2 = this.Apo;
      if (paramString2 == null) {
        p.bGy("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
    }
  }
  
  private final void ah(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178431);
    RegionCodeDecoder.hAC();
    String str1 = RegionCodeDecoder.bxo(paramString1);
    RegionCodeDecoder.hAC();
    String str2 = RegionCodeDecoder.nN(paramString1, paramString2);
    RegionCodeDecoder.hAC();
    paramString1 = RegionCodeDecoder.bm(paramString1, paramString2, paramString3);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = this.Apc;
      if (paramString2 == null) {
        p.bGy("districtTV");
      }
      paramString2.setText((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PL(str2) + " " + paramString1));
      paramString1 = this.Api;
      if (paramString1 == null) {
        p.bGy("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!Util.isNullOrNil(str2))
    {
      paramString1 = this.Apc;
      if (paramString1 == null) {
        p.bGy("districtTV");
      }
      paramString1.setText((CharSequence)(str1 + ' ' + str2));
      paramString1 = this.Api;
      if (paramString1 == null) {
        p.bGy("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!Util.isNullOrNil(str1))
    {
      paramString1 = this.Apc;
      if (paramString1 == null) {
        p.bGy("districtTV");
      }
      paramString1.setText((CharSequence)str1);
      paramString1 = this.Api;
      if (paramString1 == null) {
        p.bGy("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    paramString1 = this.Api;
    if (paramString1 == null) {
      p.bGy("districtLayout");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(178431);
  }
  
  private final LinearLayout dZW()
  {
    AppMethodBeat.i(290348);
    LinearLayout localLinearLayout = (LinearLayout)this.ApD.getValue();
    AppMethodBeat.o(290348);
    return localLinearLayout;
  }
  
  private final MMSwitchBtn dZX()
  {
    AppMethodBeat.i(290349);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)this.ApE.getValue();
    AppMethodBeat.o(290349);
    return localMMSwitchBtn;
  }
  
  private final void dZY()
  {
    AppMethodBeat.i(167185);
    Object localObject = ApI;
    switch (((String)localObject).hashCode())
    {
    default: 
      localObject = this.Apb;
      if (localObject == null) {
        p.bGy("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(b.j.finder_settings_select_sex));
      localObject = this.Apb;
      if (localObject == null) {
        p.bGy("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.ci.a.w((Context)this, b.c.hint_text_color));
    }
    for (;;)
    {
      if (!this.ApA) {
        break label295;
      }
      localObject = this.Apg;
      if (localObject == null) {
        p.bGy("sexArrowIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.Aph;
      if (localObject == null) {
        p.bGy("sexInfoIcon");
      }
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(167185);
      return;
      if (!((String)localObject).equals("female")) {
        break;
      }
      localObject = this.Apb;
      if (localObject == null) {
        p.bGy("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(b.j.sex_female));
      localObject = this.Apb;
      if (localObject == null) {
        p.bGy("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.ci.a.w((Context)this, b.c.normal_text_color));
      continue;
      if (!((String)localObject).equals("male")) {
        break;
      }
      localObject = this.Apb;
      if (localObject == null) {
        p.bGy("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(b.j.sex_male));
      localObject = this.Apb;
      if (localObject == null) {
        p.bGy("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.ci.a.w((Context)this, b.c.normal_text_color));
    }
    label295:
    localObject = this.Apg;
    if (localObject == null) {
      p.bGy("sexArrowIcon");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.Aph;
    if (localObject == null) {
      p.bGy("sexInfoIcon");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new s(this));
    AppMethodBeat.o(167185);
  }
  
  private static boolean dZZ()
  {
    AppMethodBeat.i(290362);
    if (((CharSequence)ApM).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label89;
      }
      if (((CharSequence)ApN).length() != 0) {
        break label79;
      }
      i = 1;
      label42:
      if (i == 0) {
        break label89;
      }
      if (((CharSequence)ApO).length() != 0) {
        break label84;
      }
    }
    label79:
    label84:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label89;
      }
      AppMethodBeat.o(290362);
      return true;
      i = 0;
      break;
      i = 0;
      break label42;
    }
    label89:
    AppMethodBeat.o(290362);
    return false;
  }
  
  private static String ef(String paramString, int paramInt)
  {
    AppMethodBeat.i(290358);
    if (paramString != null)
    {
      paramString = paramString + '_' + paramInt;
      AppMethodBeat.o(290358);
      return paramString;
    }
    AppMethodBeat.o(290358);
    return "";
  }
  
  private final void qK(boolean paramBoolean)
  {
    AppMethodBeat.i(290361);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).Bgf;
      if (localObject != null)
      {
        String str = ((btn)localObject).mVH;
        p.j(str, "it.Country");
        ApM = str;
        str = ((btn)localObject).mVz;
        p.j(str, "it.Province");
        ApN = str;
        str = ((btn)localObject).mVA;
        p.j(str, "it.City");
        ApO = str;
        str = ((btn)localObject).mVH;
        p.j(str, "it.Country");
        ApP = str;
        str = ((btn)localObject).mVz;
        p.j(str, "it.Province");
        ApQ = str;
        localObject = ((btn)localObject).mVA;
        p.j(localObject, "it.City");
        ApR = (String)localObject;
        localObject = this.Apd;
        if (localObject == null) {
          p.bGy("locationIcon");
        }
        ((View)localObject).setVisibility(0);
        localObject = this.Ape;
        if (localObject == null) {
          p.bGy("locationArrowIcon");
        }
        ((View)localObject).setVisibility(0);
        localObject = this.Apf;
        if (localObject == null) {
          p.bGy("locationInfoIcon");
        }
        ((View)localObject).setVisibility(8);
        localObject = this.Apf;
        if (localObject == null) {
          p.bGy("locationInfoIcon");
        }
        ((View)localObject).setOnClickListener((View.OnClickListener)new r(this));
        ApK = 1;
        ah(ApM, ApN, ApO);
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "updateDistrict " + ApM + ' ' + ApN + ' ' + ApO);
      AppMethodBeat.o(290361);
      return;
      localObject = (FinderCreateContactUI)this;
      ApM = "unshow";
      ApN = "";
      ApO = "";
      localObject = ((FinderCreateContactUI)localObject).Api;
      if (localObject == null) {
        p.bGy("districtLayout");
      }
      ((View)localObject).setVisibility(8);
      ApK = 3;
      continue;
      localObject = this.Apd;
      if (localObject == null) {
        p.bGy("locationIcon");
      }
      ((View)localObject).setVisibility(8);
      ah(ApM, ApN, ApO);
    }
  }
  
  private final void setAvatar(String paramString)
  {
    AppMethodBeat.i(167187);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = BitmapUtil.extractThumbNail(paramString, 256, 256, false);
      if (paramString != null)
      {
        ImageView localImageView = this.mOe;
        if (localImageView == null) {
          p.bGy("avatarView");
        }
        localImageView.setImageBitmap(paramString);
        AppMethodBeat.o(167187);
        return;
      }
    }
    AppMethodBeat.o(167187);
  }
  
  private final void xK()
  {
    AppMethodBeat.i(290357);
    TextView localTextView = this.Apo;
    if (localTextView == null) {
      p.bGy("topErrorTip");
    }
    localTextView.setText((CharSequence)"");
    localTextView = this.Apo;
    if (localTextView == null) {
      p.bGy("topErrorTip");
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(290357);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(290364);
    int j;
    if (p.h(paramString, z.bcZ()))
    {
      Log.i(this.TAG, "[notifyChanged] user:" + paramString + ",avatarPath:" + this.wQa);
      com.tencent.mm.am.q.bhz();
      paramString = com.tencent.mm.am.f.N(z.bcZ(), false);
      j = (int)com.tencent.mm.vfs.u.bBQ(paramString);
      CharSequence localCharSequence = (CharSequence)this.wQa;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label134;
      }
    }
    label134:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (j > 0))
      {
        Log.i(this.TAG, "[notifyChanged] filesize:".concat(String.valueOf(j)));
        this.wQa = paramString;
      }
      AppMethodBeat.o(290364);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290376);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290376);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290375);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(290375);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_create_contact_ui;
  }
  
  public final void h(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(167180);
    View localView = this.AoZ;
    if (localView == null) {
      p.bGy("scrollContainer");
    }
    localView.post((Runnable)new m(this, paramBoolean, paramInt));
    AppMethodBeat.o(167180);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(167184);
    if (paramInt1 == this.xOK) {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.b.h((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.c((Activity)this, getIntent(), this.xOL);
      }
    }
    for (;;)
    {
      xK();
      AppMethodBeat.o(167184);
      return;
      if (paramInt1 == this.xOL)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          this.wQa = paramIntent.getStringExtra("key_result_img_path");
          paramIntent = this.wQa;
          if (paramIntent != null) {
            ndV = paramIntent;
          }
          Log.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.u.bBQ(this.wQa) / 1024L) });
          ApL = 2;
          setAvatar(this.wQa);
        }
      }
      else
      {
        Object localObject;
        if (paramInt1 == this.Apt)
        {
          if ((paramIntent != null) && (paramInt2 == -1))
          {
            localObject = paramIntent.getStringExtra("key_output_sex");
            paramIntent = (Intent)localObject;
            if (localObject == null) {
              paramIntent = "";
            }
            ApI = paramIntent;
            dZY();
            ApJ = 2;
          }
        }
        else if ((paramInt1 == this.Apu) && (paramIntent != null) && (paramInt2 == -1))
        {
          String str = paramIntent.getStringExtra("Country");
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          ApM = (String)localObject;
          str = paramIntent.getStringExtra("Contact_Province");
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          ApN = (String)localObject;
          localObject = paramIntent.getStringExtra("Contact_City");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          ApO = paramIntent;
          qK(false);
          ApK = 2;
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167178);
    setResult(ApW);
    super.onBackPressed();
    Object localObject = k.zWs;
    k.Pw(5);
    localObject = com.tencent.mm.plugin.finder.report.n.zWF;
    int i = this.scene;
    int j = ApL;
    int k = ApK;
    int m = ApJ;
    int n = this.Apw;
    boolean bool1 = ApS;
    localObject = ApT;
    EditText localEditText = this.Apa;
    if (localEditText == null) {
      p.bGy("nickEdt");
    }
    boolean bool2 = p.h(localObject, localEditText.getText().toString());
    localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this);
    if (localObject != null) {}
    for (localObject = ((aj)localObject).ekY();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.n.a(i, 0, j, false, k, m, n, bool1, bool2 ^ true, (bid)localObject);
      AppMethodBeat.o(167178);
      return;
    }
  }
  
  public final void onClickEditDistrict(View paramView)
  {
    AppMethodBeat.i(167177);
    paramView = this.Apa;
    if (paramView == null) {
      p.bGy("nickEdt");
    }
    paramView.clearFocus();
    hideVKB();
    h(false, 0);
    paramView = new Intent();
    paramView.putExtra("GetAddress", true);
    paramView.putExtra("ShowSelectedLocation", true);
    paramView.putExtra("SetSelectLocation", true);
    paramView.putExtra("SelectedCountryCode", ApM);
    paramView.putExtra("SelectedProvinceCode", ApN);
    paramView.putExtra("SelectedCityCode", ApO);
    paramView.putExtra("NeedUnshowItem", false);
    com.tencent.mm.by.c.d((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, this.Apu);
    AppMethodBeat.o(167177);
  }
  
  public final void onClickEditSex(View paramView)
  {
    AppMethodBeat.i(167176);
    paramView = this.Apa;
    if (paramView == null) {
      p.bGy("nickEdt");
    }
    paramView.clearFocus();
    hideVKB();
    h(false, 0);
    if (this.ApA)
    {
      paramView = new Intent();
      paramView.putExtra("key_input_sex", ApI);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramView, this.Apt);
    }
    AppMethodBeat.o(167176);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167175);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(b.c.white));
    getController().q((Activity)this, getResources().getColor(b.c.white));
    paramBundle = findViewById(b.f.scroll_container);
    p.j(paramBundle, "findViewById(R.id.scroll_container)");
    this.AoZ = paramBundle;
    paramBundle = findViewById(b.f.finder_avatar_iv);
    p.j(paramBundle, "findViewById(R.id.finder_avatar_iv)");
    this.mOe = ((ImageView)paramBundle);
    paramBundle = findViewById(b.f.finder_create_title);
    p.j(paramBundle, "findViewById(R.id.finder_create_title)");
    this.titleTv = ((TextView)paramBundle);
    paramBundle = findViewById(b.f.finder_nick_tv);
    p.j(paramBundle, "findViewById(R.id.finder_nick_tv)");
    this.Apa = ((EditText)paramBundle);
    paramBundle = findViewById(b.f.finder_sex_tv);
    p.j(paramBundle, "findViewById(R.id.finder_sex_tv)");
    this.Apb = ((TextView)paramBundle);
    paramBundle = findViewById(b.f.finder_district_tv);
    p.j(paramBundle, "findViewById(R.id.finder_district_tv)");
    this.Apc = ((TextView)paramBundle);
    paramBundle = findViewById(b.f.district_layout);
    p.j(paramBundle, "findViewById(R.id.district_layout)");
    this.Api = paramBundle;
    paramBundle = findViewById(b.f.location_icon);
    p.j(paramBundle, "findViewById(R.id.location_icon)");
    this.Apd = paramBundle;
    paramBundle = findViewById(b.f.arrow_icon);
    p.j(paramBundle, "findViewById(R.id.arrow_icon)");
    this.Ape = paramBundle;
    paramBundle = findViewById(b.f.info_icon);
    p.j(paramBundle, "findViewById(R.id.info_icon)");
    this.Apf = paramBundle;
    paramBundle = findViewById(b.f.sex_arrow_icon);
    p.j(paramBundle, "findViewById(R.id.sex_arrow_icon)");
    this.Apg = paramBundle;
    paramBundle = findViewById(b.f.sex_info_icon);
    p.j(paramBundle, "findViewById(R.id.sex_info_icon)");
    this.Aph = paramBundle;
    paramBundle = findViewById(b.f.finder_contact_create_btn);
    p.j(paramBundle, "findViewById(R.id.finder_contact_create_btn)");
    this.Apj = ((Button)paramBundle);
    paramBundle = findViewById(b.f.input_panel);
    p.j(paramBundle, "findViewById(R.id.input_panel)");
    this.Apn = ((InputPanelFrameLayout)paramBundle);
    paramBundle = findViewById(b.f.finder_input_container);
    p.j(paramBundle, "findViewById(R.id.finder_input_container)");
    this.ybx = paramBundle;
    paramBundle = findViewById(b.f.edt_top_space);
    p.j(paramBundle, "findViewById(R.id.edt_top_space)");
    this.Apk = paramBundle;
    paramBundle = findViewById(b.f.edt_middle_space);
    p.j(paramBundle, "findViewById(R.id.edt_middle_space)");
    this.Apl = paramBundle;
    paramBundle = findViewById(b.f.edt_bottom_space);
    p.j(paramBundle, "findViewById(R.id.edt_bottom_space)");
    this.Apm = paramBundle;
    paramBundle = findViewById(b.f.top_error_tip);
    p.j(paramBundle, "findViewById(R.id.top_error_tip)");
    this.Apo = ((TextView)paramBundle);
    paramBundle = findViewById(b.f.finder_nickname_edit_limit);
    p.j(paramBundle, "findViewById(R.id.finder_nickname_edit_limit)");
    this.App = ((TextView)paramBundle);
    paramBundle = findViewById(b.f.clear_text_btn);
    p.j(paramBundle, "findViewById(R.id.clear_text_btn)");
    this.Apq = paramBundle;
    paramBundle = this.Apq;
    if (paramBundle == null) {
      p.bGy("clearNameBtn");
    }
    paramBundle.setVisibility(8);
    paramBundle = findViewById(b.f.tips_check_cb);
    p.j(paramBundle, "findViewById(R.id.tips_check_cb)");
    this.Apr = ((CheckBox)paramBundle);
    paramBundle = findViewById(b.f.tips_warning_tv);
    p.j(paramBundle, "findViewById(R.id.tips_warning_tv)");
    this.Aps = ((TextView)paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
    Object localObject1;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dUd().aSr()).intValue() == 1)
    {
      paramBundle = dZW();
      p.j(paramBundle, "wxProfileLayout");
      paramBundle.setVisibility(0);
      paramBundle = com.tencent.mm.kernel.h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      paramBundle.aHp().set(ar.a.VBs, Integer.valueOf(1));
      paramBundle = com.tencent.mm.kernel.h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      paramBundle.aHp().set(ar.a.VBt, Integer.valueOf(1));
      Log.i(this.TAG, "showWxProfileTips set USERINFO_FINDER_WXPROFILE_ENTRY_EDU_INT_SYNC 1");
      ((LinearLayout)this.ApB.getValue()).setOnClickListener((View.OnClickListener)new c(this));
      paramBundle = this.Apj;
      if (paramBundle == null) {
        p.bGy("createBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      paramBundle = (TextWatcher)new k(this);
      localObject1 = this.Apa;
      if (localObject1 == null) {
        p.bGy("nickEdt");
      }
      ((EditText)localObject1).addTextChangedListener(paramBundle);
      paramBundle = this.Apa;
      if (paramBundle == null) {
        p.bGy("nickEdt");
      }
      paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new e(this));
      paramBundle = this.Apq;
      if (paramBundle == null) {
        p.bGy("clearNameBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      paramBundle = this.Apa;
      if (paramBundle == null) {
        p.bGy("nickEdt");
      }
      paramBundle.setOnFocusChangeListener((View.OnFocusChangeListener)new g(this));
      setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
      paramBundle = this.Apn;
      if (paramBundle == null) {
        p.bGy("inputPanel");
      }
      paramBundle.setExternalListener((com.tencent.mm.ui.widget.c.a)this);
      paramBundle = this.AoZ;
      if (paramBundle == null) {
        p.bGy("scrollContainer");
      }
      paramBundle.post((Runnable)new i(this));
      if (ApH != null)
      {
        paramBundle = this.Apa;
        if (paramBundle == null) {
          p.bGy("nickEdt");
        }
        paramBundle.setText((CharSequence)ApH);
      }
      if (((CharSequence)ndV).length() != 0) {
        break label1675;
      }
      i = 1;
      label958:
      if (i == 0) {
        break label1680;
      }
      paramBundle = this.mOe;
      if (paramBundle == null) {
        p.bGy("avatarView");
      }
      a.b.c(paramBundle, z.bcZ());
      com.tencent.mm.am.q.bhz();
      this.wQa = com.tencent.mm.am.f.N(z.bcZ(), false);
      if ((int)com.tencent.mm.vfs.u.bBQ(this.wQa) == 0)
      {
        Log.i(this.TAG, "WX avatar file size is zero");
        com.tencent.mm.am.q.bhz().a((f.a)this);
        this.wQa = "";
      }
      label1037:
      paramBundle = this.wQa;
      com.tencent.mm.am.q.bhz();
      if (!p.h(paramBundle, com.tencent.mm.am.f.N(z.bcZ(), false))) {
        break label1698;
      }
      ApL = 1;
      label1064:
      if (((CharSequence)ApI).length() != 0) {
        break label1744;
      }
      i = 1;
      label1080:
      if (i == 0) {
        break label1800;
      }
      paramBundle = com.tencent.mm.kernel.h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      i = paramBundle.aHp().getInt(12290, 0);
      if (i != 1) {
        break label1749;
      }
      ApI = "male";
      ApJ = 1;
    }
    label1800:
    for (;;)
    {
      paramBundle = dZX();
      p.j(paramBundle, "wxProfileSwitchBtn");
      paramBundle.setCheck(ApS);
      dZX().setSwitchListener((MMSwitchBtn.a)j.Aqa);
      Log.i(this.TAG, "lastWxProfileChecked = " + ApS);
      paramBundle = new ArrayList();
      localObject1 = af.aaBG;
      localObject1 = String.format("https://" + WeChatHosts.domainString(b.j.host_weixin_qq_com) + "/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[] { LocaleUtil.getCurrentLanguage((Context)this) }, 1));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = af.aaBG;
      localObject1 = String.format("https://" + WeChatHosts.domainString(b.j.host_weixin_qq_com) + "/cgi-bin/readtemplate?t=finder_privacy", Arrays.copyOf(new Object[0], 0));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(getString(b.j.finder_create_contact_agreement));
      ((ArrayList)localObject2).add(getString(b.j.finder_create_contact_privacy_pr));
      localObject1 = (Context)this;
      paramBundle = (List)paramBundle;
      String str = getString(b.j.finder_create_contact_warning);
      p.j(str, "getString(R.string.finder_create_contact_warning)");
      localObject2 = (List)localObject2;
      TextView localTextView = this.Aps;
      if (localTextView == null) {
        p.bGy("tipsWarningTV");
      }
      a((Context)localObject1, paramBundle, str, (List)localObject2, localTextView, this.TAG);
      dZY();
      Log.i(this.TAG, "isLastSelectDistrictEmpty = " + dZZ());
      qK(dZZ());
      com.tencent.mm.kernel.h.aGY().a(3922, (com.tencent.mm.an.i)this);
      com.tencent.mm.kernel.h.aGY().a(3759, (com.tencent.mm.an.i)this);
      com.tencent.mm.kernel.h.aGY().a(3761, (com.tencent.mm.an.i)this);
      this.Apw = getIntent().getIntExtra("key_create_scene", 0);
      this.Apx = getIntent().getIntExtra("key_mv_status", 0);
      this.ApF = getIntent().getBooleanExtra("key_router_to_profile", true);
      this.ApG = getIntent().getIntExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 0);
      if (getIntent().hasExtra("key_prepare_resp"))
      {
        this.wZz = new ble();
        paramBundle = getIntent().getByteArrayExtra("key_prepare_resp");
        if (paramBundle == null) {}
      }
      try
      {
        localObject1 = this.wZz;
        if (localObject1 != null) {
          ((ble)localObject1).parseFrom(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = x.aazN;
        }
        this.Apz = ((Integer)paramBundle).intValue();
        paramBundle = this.wZz;
        if (paramBundle == null) {
          break label1899;
        }
        Log.i(this.TAG, "nicknameMaxLength ： " + paramBundle.Apz);
        if (paramBundle.Apz <= 0) {
          break label1899;
        }
        this.Apz = paramBundle.Apz;
        com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 30L, 1L);
        paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dUe().aSr()).intValue() != 1) {
          break label1964;
        }
        new y().bhW().a((com.tencent.mm.vending.e.b)this).g((com.tencent.mm.vending.c.a)new l(this));
        switch (this.Apx)
        {
        }
      }
      paramBundle = com.tencent.mm.kernel.h.aHG();
      p.j(paramBundle, "MMKernel.storage()");
      paramBundle = paramBundle.aHp().get(ar.a.VyC, Integer.valueOf(20));
      if (paramBundle != null) {
        break label1837;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(167175);
      throw paramBundle;
      paramBundle = dZW();
      p.j(paramBundle, "wxProfileLayout");
      paramBundle.setVisibility(8);
      break;
      label1675:
      i = 0;
      break label958;
      label1680:
      this.wQa = ndV;
      setAvatar(this.wQa);
      break label1037;
      label1698:
      paramBundle = (CharSequence)this.wQa;
      if ((paramBundle == null) || (paramBundle.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1737;
        }
        ApL = 3;
        break;
      }
      label1737:
      ApL = 2;
      break label1064;
      label1744:
      i = 0;
      break label1080;
      label1749:
      if (i == 2)
      {
        ApI = "female";
        ApJ = 1;
      }
      else
      {
        paramBundle = (LinearLayout)this.ApC.getValue();
        p.j(paramBundle, "sexLayout");
        paramBundle.setVisibility(8);
        ApJ = 3;
        continue;
        Log.i(this.TAG, "lastSelectSex = " + ApI);
      }
    }
    for (;;)
    {
      label1837:
      label1899:
      AppMethodBeat.o(167175);
      label1964:
      return;
      paramBundle = this.titleTv;
      if (paramBundle == null) {
        p.bGy("titleTv");
      }
      paramBundle.setText(getResources().getText(b.j.finder_create_finder_mv_title));
      paramBundle = this.Apj;
      if (paramBundle == null) {
        p.bGy("createBtn");
      }
      paramBundle.setText(getResources().getText(b.j.finder_create_contact_mv_save_confirm));
      AppMethodBeat.o(167175);
      return;
      paramBundle = this.titleTv;
      if (paramBundle == null) {
        p.bGy("titleTv");
      }
      paramBundle.setText(getResources().getText(b.j.finder_create_finder_mv_title));
      paramBundle = this.Apj;
      if (paramBundle == null) {
        p.bGy("createBtn");
      }
      paramBundle.setText(getResources().getText(b.j.finder_create_contact_mv_post_confirm));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167182);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3922, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(3759, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
    com.tencent.mm.am.q.bhz().b((f.a)this);
    AppMethodBeat.o(167182);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(290351);
    super.onResume();
    if (this.wZz == null)
    {
      ch localch = new ch(15);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localch);
    }
    AppMethodBeat.o(290351);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(167183);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    if ((paramq instanceof aw))
    {
      paramString = this.Apv;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = ((aw)paramq).dnV();
        if (paramq != null)
        {
          paramString = s.ADL;
          s.edf();
          paramString = com.tencent.mm.plugin.finder.report.n.zWF;
          paramInt1 = this.scene;
          paramInt2 = ApL;
          int i = ApK;
          int j = ApJ;
          int k = this.Apw;
          boolean bool1 = ApS;
          paramString = ApT;
          localObject = this.Apa;
          if (localObject == null) {
            p.bGy("nickEdt");
          }
          boolean bool2 = p.h(paramString, ((EditText)localObject).getText().toString());
          paramString = aj.Bnu;
          paramString = aj.a.fZ((Context)this);
          if (paramString != null) {}
          for (paramString = paramString.ekY();; paramString = null)
          {
            com.tencent.mm.plugin.finder.report.n.a(paramInt1, 1, paramInt2, true, i, j, k, bool1, bool2 ^ true, paramString);
            com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 32L, 1L);
            paramString = new Intent();
            if (this.ApF)
            {
              paramString.putExtra("finder_username", paramq.username);
              paramString.putExtra("KEY_FINDER_SELF_FLAG", true);
              paramq = aj.Bnu;
              aj.a.a((Context)this, paramString, 0L, 0, false, 124);
              paramq = com.tencent.mm.plugin.finder.utils.a.ACH;
              com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramString);
            }
            setResult(ApV);
            finish();
            AppMethodBeat.o(167183);
            return;
          }
        }
        AppMethodBeat.o(167183);
        return;
      }
      if (paramInt2 == -4003) {
        com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 37L, 1L);
      }
      for (;;)
      {
        paramString = ((aw)paramq).rr.bhY();
        if (paramString != null) {
          break;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
        AppMethodBeat.o(167183);
        throw paramString;
        if (paramInt2 == -4008) {
          com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 38L, 1L);
        }
      }
      localObject = ((arv)paramString).verifyInfo;
      if (localObject != null)
      {
        Log.i(this.TAG, "verify info: " + com.tencent.mm.ae.g.bN(localObject));
        if (((bfm)localObject).SQi == 1)
        {
          paramString = this.Apa;
          if (paramString == null) {
            p.bGy("nickEdt");
          }
          paramString.setTextColor(com.tencent.mm.ci.a.w((Context)this, b.c.red));
        }
        if (!Util.isNullOrNil(((bfm)localObject).SQf))
        {
          paramq = ((bfm)localObject).SQf;
          paramString = paramq;
          if (paramq == null) {
            paramString = "";
          }
          ag(paramString, ((bfm)localObject).SQk, ((bfm)localObject).SQj);
        }
      }
      for (;;)
      {
        setResult(ApW);
        AppMethodBeat.o(167183);
        return;
        paramString = getString(b.j.finder_create_contact_failed_tip);
        p.j(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
        ag(paramString, null, null);
        continue;
        paramString = (FinderCreateContactUI)this;
        paramq = paramString.getString(b.j.finder_create_contact_failed_tip);
        p.j(paramq, "getString(R.string.finde…reate_contact_failed_tip)");
        paramString.ag(paramq, null, null);
      }
    }
    if ((paramq instanceof cp))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((cp)paramq).xei;
        localObject = ((cp)paramq).fileMD5;
        paramInt1 = ((cp)paramq).lAW;
        if (paramString != null)
        {
          paramq = ef((String)localObject, paramInt1);
          if (((CharSequence)paramq).length() <= 0) {
            break label686;
          }
        }
        label686:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            ((Map)ApU).put(paramq, paramString);
          }
          aFb(paramString);
          AppMethodBeat.o(167183);
          return;
        }
      }
      paramString = this.Apv;
      if (paramString != null) {
        paramString.dismiss();
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 33L, 1L);
      paramString = getString(b.j.finder_create_contact_failed_tip);
      p.j(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
      ag(paramString, null, null);
      AppMethodBeat.o(167183);
      return;
    }
    if ((paramq instanceof ch)) {
      this.wZz = ((ch)paramq).dnR();
    }
    AppMethodBeat.o(167183);
  }
  
  public final void onTipsCheckBoxClick(View paramView)
  {
    AppMethodBeat.i(290352);
    paramView = this.Apr;
    if (paramView == null) {
      p.bGy("tipsCheckCB");
    }
    CheckBox localCheckBox = this.Apr;
    if (localCheckBox == null) {
      p.bGy("tipsCheckCB");
    }
    if (!localCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(290352);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI$Companion;", "", "()V", "CREATE_RESULT_FAILED", "", "getCREATE_RESULT_FAILED", "()I", "CREATE_RESULT_OK", "getCREATE_RESULT_OK", "MV_POST", "MV_SAVE", "avatarForReport", "avatarSvrUrlMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAvatarSvrUrlMap", "()Ljava/util/HashMap;", "districtForReport", "lastAvatarPath", "getLastAvatarPath", "()Ljava/lang/String;", "setLastAvatarPath", "(Ljava/lang/String;)V", "lastNickName", "getLastNickName", "setLastNickName", "lastSelectCityCode", "getLastSelectCityCode", "setLastSelectCityCode", "lastSelectCountryCode", "getLastSelectCountryCode", "setLastSelectCountryCode", "lastSelectProvinceCode", "getLastSelectProvinceCode", "setLastSelectProvinceCode", "lastSelectSex", "getLastSelectSex", "setLastSelectSex", "lastUsedCgiName", "getLastUsedCgiName", "setLastUsedCgiName", "lastWxProfileChecked", "", "getLastWxProfileChecked", "()Z", "setLastWxProfileChecked", "(Z)V", "realCityCode", "getRealCityCode", "setRealCityCode", "realCountryCode", "getRealCountryCode", "setRealCountryCode", "realProvinceCode", "getRealProvinceCode", "setRealProvinceCode", "sexForReport", "plugin-finder_release"})
  public static final class a
  {
    public static void aFf(String paramString)
    {
      AppMethodBeat.i(269353);
      p.k(paramString, "<set-?>");
      FinderCreateContactUI.aFd(paramString);
      AppMethodBeat.o(269353);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    b(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167160);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)this.ApY, FinderCreateContactUI.b(this.ApY), 1, 5, null, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167160);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167161);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      Log.i(FinderCreateContactUI.c(this.ApY), "doClick create contact btn");
      paramView = FinderCreateContactUI.d(this.ApY);
      if (paramView != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.w.ADZ;
        localObject1 = this.ApY.getContext();
        p.j(localObject1, "context");
        if (!com.tencent.mm.plugin.finder.utils.w.a((Context)localObject1, paramView, (kotlin.g.a.a)new a(this)))
        {
          Log.i(FinderCreateContactUI.c(this.ApY), "doClick create contact btn,bind phone return");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(167161);
        }
      }
      else
      {
        Log.i(FinderCreateContactUI.c(this.ApY), "doClick create contact btn,prepareResp = null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167161);
        return;
      }
      Object localObject2 = new ce();
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((ce)localObject2).lV(paramView);
      ((ce)localObject2).fc(FinderCreateContactUI.f(this.ApY));
      Object localObject4 = this.ApY.getString(b.j.avatar_desc);
      p.j(localObject4, "getString(R.string.avatar_desc)");
      Object localObject3 = this.ApY.getString(b.j.finder_nickname);
      p.j(localObject3, "getString(R.string.finder_nickname)");
      p.j(this.ApY.getString(b.j.settings_sex), "getString(R.string.settings_sex)");
      paramView = FinderCreateContactUI.ApX;
      localObject1 = FinderCreateContactUI.g(this.ApY);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      p.k(paramView, "<set-?>");
      FinderCreateContactUI.aFc(paramView);
      paramView = FinderCreateContactUI.ApX;
      paramView = FinderCreateContactUI.a(this.ApY).getText();
      if (paramView != null)
      {
        paramView = paramView.toString();
        if (paramView != null)
        {
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(167161);
            throw paramView;
          }
          localObject1 = kotlin.n.n.bb((CharSequence)paramView).toString();
          paramView = (View)localObject1;
          if (localObject1 != null) {
            break label364;
          }
        }
      }
      paramView = "";
      label364:
      FinderCreateContactUI.a.aFf(paramView);
      paramView = FinderCreateContactUI.ApX;
      paramView = FinderCreateContactUI.h(this.ApY);
      p.j(paramView, "wxProfileSwitchBtn");
      FinderCreateContactUI.qL(paramView.isCheck());
      paramView = new ArrayList();
      localObject1 = FinderCreateContactUI.ApX;
      if (com.tencent.mm.ui.tools.g.bAB(FinderCreateContactUI.eae()) > FinderCreateContactUI.i(this.ApY)) {
        paramView.add(localObject3);
      }
      localObject1 = new ArrayList();
      FinderCreateContactUI.a locala = FinderCreateContactUI.ApX;
      int i;
      if (((CharSequence)FinderCreateContactUI.ead()).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label678;
        }
        ((ArrayList)localObject1).add(localObject4);
        label468:
        localObject4 = FinderCreateContactUI.ApX;
        if (((CharSequence)FinderCreateContactUI.eae()).length() != 0) {
          break label687;
        }
        i = 1;
        label489:
        if (i == 0) {
          break label692;
        }
        ((ArrayList)localObject1).add(localObject3);
        label500:
        localObject3 = FinderCreateContactUI.ApX;
        if (((CharSequence)FinderCreateContactUI.eaf()).length() != 0) {
          break label701;
        }
        i = 1;
        label521:
        if (i == 0) {
          ((ce)localObject2).ahu();
        }
        localObject3 = FinderCreateContactUI.ApX;
        if (!Util.isNullOrNil(FinderCreateContactUI.eag())) {
          ((ce)localObject2).ahv();
        }
        if (!paramView.isEmpty()) {
          break label906;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          break label784;
        }
        if (!FinderCreateContactUI.j(this.ApY).isChecked()) {
          break label706;
        }
        FinderCreateContactUI.k(this.ApY);
        ((ce)localObject2).fa(1L);
      }
      for (;;)
      {
        ((ce)localObject2).bpa();
        paramView = FinderCreateContactUI.c(this.ApY);
        localObject1 = new StringBuilder("report19815 ");
        localObject2 = ((ce)localObject2).agI();
        p.j(localObject2, "struct.toShowString()");
        Log.i(paramView, kotlin.n.n.l((String)localObject2, "\r\n", " ", false));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167161);
        return;
        i = 0;
        break;
        label678:
        ((ce)localObject2).ahs();
        break label468;
        label687:
        i = 0;
        break label489;
        label692:
        ((ce)localObject2).aht();
        break label500;
        label701:
        i = 0;
        break label521;
        label706:
        Log.i(FinderCreateContactUI.c(this.ApY), "not check agreement");
        paramView = this.ApY;
        localObject1 = this.ApY.getString(b.j.finder_agreement_not_check_tip);
        p.j(localObject1, "getString(R.string.finder_agreement_not_check_tip)");
        FinderCreateContactUI.a(paramView, (String)localObject1);
        ((ce)localObject2).fa(2L);
        ((ce)localObject2).fb(3L);
        ((ce)localObject2).lW(this.ApY.getString(b.j.finder_agreement_not_check_tip));
        continue;
        label784:
        Log.i(FinderCreateContactUI.c(this.ApY), "empty attr ".concat(String.valueOf(localObject1)));
        paramView = Util.listToString((List)localObject1, this.ApY.getString(b.j.finder_error_tips_splitor));
        localObject1 = this.ApY;
        localObject3 = this.ApY.getString(b.j.finder_input_not_empty_tip, new Object[] { paramView });
        p.j(localObject3, "getString(R.string.finde…_empty_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((ce)localObject2).fa(2L);
        ((ce)localObject2).fb(2L);
        ((ce)localObject2).lW(this.ApY.getString(b.j.finder_input_not_empty_tip, new Object[] { paramView }));
        continue;
        label906:
        paramView = Util.listToString((List)paramView, this.ApY.getString(b.j.finder_error_tips_splitor));
        localObject1 = this.ApY;
        localObject3 = this.ApY.getString(b.j.finder_input_too_long_tip, new Object[] { paramView });
        p.j(localObject3, "getString(R.string.finde…o_long_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((ce)localObject2).fa(2L);
        ((ce)localObject2).fb(1L);
        ((ce)localObject2).lW(this.ApY.getString(b.j.finder_input_too_long_tip, new Object[] { paramView }));
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderCreateContactUI.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class e
    implements TextView.OnEditorActionListener
  {
    e(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(167162);
      if (5 == paramInt) {
        FinderCreateContactUI.a(this.ApY).clearFocus();
      }
      AppMethodBeat.o(167162);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250067);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderCreateContactUI.a(this.ApY).getText().clear();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250067);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
  static final class g
    implements View.OnFocusChangeListener
  {
    g(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onFocusChange(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(246737);
      paramView = FinderCreateContactUI.n(this.ApY);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        AppMethodBeat.o(246737);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252237);
      paramMenuItem = k.zWs;
      k.Pw(5);
      paramMenuItem = com.tencent.mm.plugin.finder.report.n.zWF;
      int i = FinderCreateContactUI.o(this.ApY);
      int j = FinderCreateContactUI.eaa();
      int k = FinderCreateContactUI.eab();
      int m = FinderCreateContactUI.eac();
      int n = FinderCreateContactUI.f(this.ApY);
      paramMenuItem = FinderCreateContactUI.ApX;
      boolean bool1 = FinderCreateContactUI.eah();
      paramMenuItem = FinderCreateContactUI.ApX;
      boolean bool2 = p.h(FinderCreateContactUI.eai(), FinderCreateContactUI.a(this.ApY).getText().toString());
      paramMenuItem = aj.Bnu;
      paramMenuItem = aj.a.fZ((Context)this.ApY);
      if (paramMenuItem != null) {}
      for (paramMenuItem = paramMenuItem.ekY();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.n.a(i, 0, j, false, k, m, n, bool1, bool2 ^ true, paramMenuItem);
        paramMenuItem = this.ApY;
        FinderCreateContactUI.a locala = FinderCreateContactUI.ApX;
        paramMenuItem.setResult(FinderCreateContactUI.eak());
        this.ApY.finish();
        AppMethodBeat.o(252237);
        return true;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(274420);
      FinderCreateContactUI.a(this.ApY, FinderCreateContactUI.q(this.ApY).getMeasuredHeight());
      AppMethodBeat.o(274420);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "selected", "", "onStatusChange"})
  static final class j
    implements MMSwitchBtn.a
  {
    public static final j Aqa;
    
    static
    {
      AppMethodBeat.i(283275);
      Aqa = new j();
      AppMethodBeat.o(283275);
    }
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(283274);
      FinderCreateContactUI.a locala = FinderCreateContactUI.ApX;
      FinderCreateContactUI.qL(paramBoolean);
      AppMethodBeat.o(283274);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class k
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167168);
      com.tencent.mm.ui.tools.b.c.i(FinderCreateContactUI.a(this.ApY)).mM(1, FinderCreateContactUI.i(this.ApY)).b(com.tencent.mm.ui.tools.g.a.XSu).Hh(true).a((com.tencent.mm.ui.tools.b.c.a)new a(this));
      paramEditable = FinderCreateContactUI.ApX;
      paramEditable = FinderCreateContactUI.a(this.ApY).getText();
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (paramEditable != null)
        {
          if (paramEditable == null)
          {
            paramEditable = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(167168);
            throw paramEditable;
          }
          String str = kotlin.n.n.bb((CharSequence)paramEditable).toString();
          paramEditable = str;
          if (str != null) {
            break label119;
          }
        }
      }
      paramEditable = "";
      label119:
      FinderCreateContactUI.a.aFf(paramEditable);
      FinderCreateContactUI.a(this.ApY).setTextColor(com.tencent.mm.ci.a.w((Context)this.ApY, b.c.normal_text_color));
      AppMethodBeat.o(167168);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.ui.tools.b.c.a
    {
      public final void abc(String paramString)
      {
        AppMethodBeat.i(167167);
        int i = com.tencent.mm.ui.tools.g.dq(FinderCreateContactUI.i(this.Aqb.ApY), paramString);
        FinderCreateContactUI.l(this.Aqb.ApY).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.l(this.Aqb.ApY).setTextColor(this.Aqb.ApY.getResources().getColor(b.c.BW_0_Alpha_0_3));
        if (i <= kotlin.k.i.ov((int)(FinderCreateContactUI.i(this.Aqb.ApY) * 0.1F), 1)) {
          FinderCreateContactUI.l(this.Aqb.ApY).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.m(this.Aqb.ApY);
          AppMethodBeat.o(167167);
          return;
          FinderCreateContactUI.l(this.Aqb.ApY).setVisibility(4);
        }
      }
      
      public final void abd(String paramString)
      {
        AppMethodBeat.i(227441);
        FinderCreateContactUI.l(this.Aqb.ApY).setText((CharSequence)String.valueOf(FinderCreateContactUI.i(this.Aqb.ApY)));
        FinderCreateContactUI.l(this.Aqb.ApY).setTextColor(this.Aqb.ApY.getResources().getColor(b.c.BW_0_Alpha_0_3));
        AppMethodBeat.o(227441);
      }
      
      public final void dN(String paramString)
      {
        AppMethodBeat.i(167166);
        FinderCreateContactUI.l(this.Aqb.ApY).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.g.dq(FinderCreateContactUI.i(this.Aqb.ApY), paramString)));
        FinderCreateContactUI.l(this.Aqb.ApY).setVisibility(0);
        FinderCreateContactUI.l(this.Aqb.ApY).setTextColor(this.Aqb.ApY.getResources().getColor(b.c.Red_100));
        paramString = this.Aqb.ApY;
        String str = this.Aqb.ApY.getString(b.j.finder_nickname_too_long_tip);
        p.j(str, "getString(R.string.finder_nickname_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167166);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class l<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    l(FinderCreateContactUI paramFinderCreateContactUI) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(FinderCreateContactUI paramFinderCreateContactUI, boolean paramBoolean, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(282042);
      if (paramBoolean)
      {
        localObject = new FrameLayout.LayoutParams(FinderCreateContactUI.q(this.ApY).getLayoutParams());
        ((FrameLayout.LayoutParams)localObject).height = (FinderCreateContactUI.p(this.ApY) - paramInt);
        FinderCreateContactUI.q(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new LinearLayout.LayoutParams(FinderCreateContactUI.r(this.ApY).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.ci.a.aY((Context)this.ApY, b.d.Edge_2A);
        FinderCreateContactUI.r(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new LinearLayout.LayoutParams(FinderCreateContactUI.s(this.ApY).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.ci.a.aY((Context)this.ApY, b.d.Edge_9A);
        FinderCreateContactUI.s(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new LinearLayout.LayoutParams(FinderCreateContactUI.t(this.ApY).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.ci.a.aY((Context)this.ApY, b.d.Edge_2A);
        FinderCreateContactUI.t(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(282042);
        return;
      }
      Object localObject = new FrameLayout.LayoutParams(FinderCreateContactUI.q(this.ApY).getLayoutParams());
      ((FrameLayout.LayoutParams)localObject).height = -1;
      FinderCreateContactUI.q(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(FinderCreateContactUI.r(this.ApY).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.ci.a.aY((Context)this.ApY, b.d.Edge_8A);
      FinderCreateContactUI.r(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(FinderCreateContactUI.s(this.ApY).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = -2;
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      FinderCreateContactUI.s(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(FinderCreateContactUI.t(this.ApY).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.ci.a.aY((Context)this.ApY, b.d.Edge_12A);
      FinderCreateContactUI.t(this.ApY).setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(282042);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    o(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    p(FinderCreateContactUI paramFinderCreateContactUI, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$1$1"})
  static final class r
    implements View.OnClickListener
  {
    r(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178430);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      paramView = this.ApY.getString(b.j.finder_location_tip_gps);
      p.j(paramView, "getString(R.string.finder_location_tip_gps)");
      com.tencent.mm.plugin.findersdk.c.a.aGP(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178430);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279026);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      paramView = this.ApY.getString(b.j.finder_sex_tip);
      p.j(paramView, "getString(R.string.finder_sex_tip)");
      com.tencent.mm.plugin.findersdk.c.a.aGP(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279026);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    t(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMSwitchBtn>
  {
    u(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI
 * JD-Core Version:    0.7.0.1
 */