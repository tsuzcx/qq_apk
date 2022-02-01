package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bme;
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
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.ae;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_CODE_SELECT_DISTRICT", "REQUEST_CODE_SELECT_SEX", "TAG", "", "avatarForReport", "avatarPath", "avatarView", "Landroid/widget/ImageView;", "canSelectSex", "", "changeAvatarView", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getChangeAvatarView", "()Landroid/widget/LinearLayout;", "changeAvatarView$delegate", "Lkotlin/Lazy;", "clearNameBtn", "Landroid/view/View;", "createBtn", "Landroid/widget/Button;", "createScene", "districtForReport", "districtLayout", "districtTV", "Landroid/widget/TextView;", "editBottomSpace", "editMiddleSpace", "editNickNameLimit", "editTopSpace", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "locationArrowIcon", "locationIcon", "locationInfoIcon", "mvStatus", "nickEdt", "Landroid/widget/EditText;", "nicknameMaxLength", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "routerToProfile", "scene", "scrollContainer", "scrollViewOriginHeight", "sexArrowIcon", "sexForReport", "sexInfoIcon", "sexLayout", "getSexLayout", "sexLayout$delegate", "sexTV", "tipsCheckCB", "Landroid/widget/CheckBox;", "tipsWarningTV", "titleTv", "topErrorTip", "wxProfileLayout", "getWxProfileLayout", "wxProfileLayout$delegate", "wxProfileSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getWxProfileSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "wxProfileSwitchBtn$delegate", "createContact", "", "generateKey", "avatarFileMD5", "avatarLen", "getLayoutId", "hideError", "initContentView", "isLastSelectDistrictEmpty", "notifyChanged", "user", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickEditDistrict", "view", "onClickEditSex", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTipsCheckBoxClick", "requestCreateUser", "imgUrl", "setAvatar", "path", "setDistrictTV", "countryCodeName", "provinceCodeName", "cityCodeName", "setMvView", "setSpanTouch", "descTv", "text", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "spanLinks", "context", "Landroid/content/Context;", "h5urlList", "", "allText", "linkTextList", "logTag", "updateDistrict", "isAuto", "updateSex", "Companion", "plugin-finder_release"})
public final class FinderCreateContactUI
  extends MMFinderUI
  implements e.a, com.tencent.mm.ak.i, b.a
{
  private static String kme;
  private static String vIO;
  private static String vIP;
  private static String vIQ;
  private static String vIR;
  private static String vIS;
  private static String vIT;
  private static String vIU;
  private static String vIV;
  private static boolean vIW;
  private static String vIX;
  private static final HashMap<String, String> vIY;
  public static final a vIZ;
  private final String TAG;
  private HashMap _$_findViewCache;
  private ImageView jWS;
  private int scene;
  private TextView titleTv;
  private String tjJ;
  private bed udb;
  private View uht;
  private ProgressDialog vIA;
  private int vIB;
  private int vIC;
  private int vID;
  private int vIE;
  private boolean vIF;
  private final kotlin.f vIG;
  private final kotlin.f vIH;
  private final kotlin.f vII;
  private final kotlin.f vIJ;
  private boolean vIK;
  private int vIL;
  private int vIM;
  private int vIN;
  private View vIc;
  private EditText vId;
  private TextView vIe;
  private TextView vIf;
  private View vIg;
  private View vIh;
  private View vIi;
  private View vIj;
  private View vIk;
  private View vIl;
  private Button vIm;
  private View vIn;
  private View vIo;
  private View vIp;
  private InputPanelFrameLayout vIq;
  private TextView vIr;
  private TextView vIs;
  private View vIt;
  private CheckBox vIu;
  private TextView vIv;
  private final int vIw;
  private final int vIx;
  private final int vIy;
  private final int vIz;
  
  static
  {
    AppMethodBeat.i(167188);
    vIZ = new a((byte)0);
    kme = "";
    vIO = "";
    vIP = "";
    vIQ = "";
    vIR = "";
    vIS = "";
    vIT = "";
    vIU = "";
    vIV = "";
    vIW = true;
    vIX = "";
    vIY = new HashMap();
    AppMethodBeat.o(167188);
  }
  
  public FinderCreateContactUI()
  {
    AppMethodBeat.i(252265);
    this.TAG = "Finder.FinderCreateContactUI";
    this.vIw = 1000;
    this.vIx = 1001;
    this.vIy = 1002;
    this.vIz = 1003;
    this.vIE = 20;
    this.vIF = true;
    this.vIG = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.vIH = kotlin.g.ah((kotlin.g.a.a)new n(this));
    this.vII = kotlin.g.ah((kotlin.g.a.a)new s(this));
    this.vIJ = kotlin.g.ah((kotlin.g.a.a)new t(this));
    this.vIK = true;
    AppMethodBeat.o(252265);
  }
  
  private void a(Context paramContext, List<String> paramList1, String paramString1, List<String> paramList2, TextView paramTextView, String paramString2)
  {
    AppMethodBeat.i(252263);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramList1, "h5urlList");
    kotlin.g.b.p.h(paramString1, "allText");
    kotlin.g.b.p.h(paramList2, "linkTextList");
    kotlin.g.b.p.h(paramTextView, "descTv");
    kotlin.g.b.p.h(paramString2, "logTag");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString1);
    paramList2 = ((Iterable)paramList2).iterator();
    int i = 0;
    while (paramList2.hasNext())
    {
      Object localObject = paramList2.next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject = (String)localObject;
      int j = kotlin.n.n.a((CharSequence)paramString1, (String)localObject, 0, false, 6);
      int k = j + ((String)localObject).length();
      if ((j >= 0) && (k <= paramString1.length()))
      {
        localObject = (String)paramList1.get(i);
        Context localContext = MMApplicationContext.getContext();
        kotlin.g.b.p.g(localContext, "MMApplicationContext.getContext()");
        int m = localContext.getResources().getColor(2131100685);
        localContext = MMApplicationContext.getContext();
        kotlin.g.b.p.g(localContext, "MMApplicationContext.getContext()");
        localSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject, m, localContext.getResources().getColor(2131099660), (kotlin.g.a.b)new FinderCreateContactUI.p(paramString1, localSpannableString, paramList1, paramString2, paramContext)), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText((CharSequence)localSpannableString);
    a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(252263);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252257);
    kotlin.g.b.p.h(paramTextView, "descTv");
    kotlin.g.b.p.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderCreateContactUI.m(this, paramSpannable, paramTextView));
    AppMethodBeat.o(252257);
  }
  
  private final void aj(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(252255);
    Log.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = com.tencent.mm.plugin.i.a.k.PATTERN.matcher((CharSequence)paramString1);
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
          AppMethodBeat.o(252255);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        kotlin.g.b.p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
          AppMethodBeat.o(252255);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        kotlin.g.b.p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      kotlin.g.b.p.g(paramString1, "sb.toString()");
      int i = ((Matcher)localObject).start(0);
      int j = str1.length();
      paramString1 = new SpannableString((CharSequence)paramString1);
      kotlin.g.b.p.g(str1, "content");
      localObject = getContext();
      kotlin.g.b.p.g(localObject, "context");
      int k = ((AppCompatActivity)localObject).getResources().getColor(2131099783);
      localObject = getContext();
      kotlin.g.b.p.g(localObject, "context");
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.l(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099790), (kotlin.g.a.b)new o(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.vIr;
      if (paramString2 == null) {
        kotlin.g.b.p.btv("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.vIr;
      if (paramString2 == null) {
        kotlin.g.b.p.btv("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.vIr;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(252255);
      return;
      paramString2 = this.vIr;
      if (paramString2 == null) {
        kotlin.g.b.p.btv("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
    }
  }
  
  private final void ak(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178431);
    RegionCodeDecoder.gEm();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.gEm();
    String str2 = RegionCodeDecoder.mV(paramString1, paramString2);
    RegionCodeDecoder.gEm();
    paramString1 = RegionCodeDecoder.br(paramString1, paramString2, paramString3);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = this.vIf;
      if (paramString2 == null) {
        kotlin.g.b.p.btv("districtTV");
      }
      paramString2.setText((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).It(str2) + " " + paramString1));
      paramString1 = this.vIl;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!Util.isNullOrNil(str2))
    {
      paramString1 = this.vIf;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("districtTV");
      }
      paramString1.setText((CharSequence)(str1 + ' ' + str2));
      paramString1 = this.vIl;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!Util.isNullOrNil(str1))
    {
      paramString1 = this.vIf;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("districtTV");
      }
      paramString1.setText((CharSequence)str1);
      paramString1 = this.vIl;
      if (paramString1 == null) {
        kotlin.g.b.p.btv("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    paramString1 = this.vIl;
    if (paramString1 == null) {
      kotlin.g.b.p.btv("districtLayout");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(178431);
  }
  
  private static void avK(String paramString)
  {
    AppMethodBeat.i(252260);
    app localapp1 = new app();
    app localapp2 = new app();
    String str = vIP;
    int i;
    switch (str.hashCode())
    {
    default: 
      localapp1.fuA = 0;
      i = 1;
      label67:
      if (!kotlin.g.b.p.j(vIQ, "unshow")) {
        break;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramString = new at(vIO, "", paramString, localapp1, i, j, localapp2, vIW);
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramString);
      AppMethodBeat.o(252260);
      return;
      if (!str.equals("female")) {
        break;
      }
      localapp1.fuA = 2;
      i = 0;
      break label67;
      if (!str.equals("male")) {
        break;
      }
      localapp1.fuA = 1;
      i = 0;
      break label67;
      localapp1.country = vIQ;
      localapp1.fuJ = vIR;
      localapp1.fuK = vIS;
    }
  }
  
  private final void cO()
  {
    AppMethodBeat.i(252258);
    TextView localTextView = this.vIr;
    if (localTextView == null) {
      kotlin.g.b.p.btv("topErrorTip");
    }
    localTextView.setText((CharSequence)"");
    localTextView = this.vIr;
    if (localTextView == null) {
      kotlin.g.b.p.btv("topErrorTip");
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(252258);
  }
  
  private static String dI(String paramString, int paramInt)
  {
    AppMethodBeat.i(252259);
    if (paramString != null)
    {
      paramString = paramString + '_' + paramInt;
      AppMethodBeat.o(252259);
      return paramString;
    }
    AppMethodBeat.o(252259);
    return "";
  }
  
  private final LinearLayout dzf()
  {
    AppMethodBeat.i(252252);
    LinearLayout localLinearLayout = (LinearLayout)this.vII.getValue();
    AppMethodBeat.o(252252);
    return localLinearLayout;
  }
  
  private final MMSwitchBtn dzg()
  {
    AppMethodBeat.i(252253);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)this.vIJ.getValue();
    AppMethodBeat.o(252253);
    return localMMSwitchBtn;
  }
  
  private final void dzh()
  {
    AppMethodBeat.i(167185);
    Object localObject = vIP;
    switch (((String)localObject).hashCode())
    {
    default: 
      localObject = this.vIe;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131760561));
      localObject = this.vIe;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100594));
    }
    for (;;)
    {
      if (!this.vIF) {
        break label295;
      }
      localObject = this.vIj;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexArrowIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.vIk;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexInfoIcon");
      }
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(167185);
      return;
      if (!((String)localObject).equals("female")) {
        break;
      }
      localObject = this.vIe;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131765720));
      localObject = this.vIe;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100904));
      continue;
      if (!((String)localObject).equals("male")) {
        break;
      }
      localObject = this.vIe;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131765721));
      localObject = this.vIe;
      if (localObject == null) {
        kotlin.g.b.p.btv("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100904));
    }
    label295:
    localObject = this.vIj;
    if (localObject == null) {
      kotlin.g.b.p.btv("sexArrowIcon");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.vIk;
    if (localObject == null) {
      kotlin.g.b.p.btv("sexInfoIcon");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new r(this));
    AppMethodBeat.o(167185);
  }
  
  private static boolean dzi()
  {
    AppMethodBeat.i(252262);
    if (((CharSequence)vIQ).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label89;
      }
      if (((CharSequence)vIR).length() != 0) {
        break label79;
      }
      i = 1;
      label42:
      if (i == 0) {
        break label89;
      }
      if (((CharSequence)vIS).length() != 0) {
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
      AppMethodBeat.o(252262);
      return true;
      i = 0;
      break;
      i = 0;
      break label42;
    }
    label89:
    AppMethodBeat.o(252262);
    return false;
  }
  
  private final void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(252261);
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
      if (localObject1 != null)
      {
        localObject2 = ((bme)localObject1).keh;
        kotlin.g.b.p.g(localObject2, "it.Country");
        vIQ = (String)localObject2;
        localObject2 = ((bme)localObject1).kdZ;
        kotlin.g.b.p.g(localObject2, "it.Province");
        vIR = (String)localObject2;
        localObject2 = ((bme)localObject1).kea;
        kotlin.g.b.p.g(localObject2, "it.City");
        vIS = (String)localObject2;
        localObject2 = ((bme)localObject1).keh;
        kotlin.g.b.p.g(localObject2, "it.Country");
        vIT = (String)localObject2;
        localObject2 = ((bme)localObject1).kdZ;
        kotlin.g.b.p.g(localObject2, "it.Province");
        vIU = (String)localObject2;
        localObject1 = ((bme)localObject1).kea;
        kotlin.g.b.p.g(localObject1, "it.City");
        vIV = (String)localObject1;
        localObject1 = this.vIg;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("locationIcon");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.vIh;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("locationArrowIcon");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.vIi;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("locationInfoIcon");
        }
        ((View)localObject1).setVisibility(8);
        localObject1 = this.vIi;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("locationInfoIcon");
        }
        ((View)localObject1).setOnClickListener((View.OnClickListener)new q(this));
        this.vIM = 1;
        ak(vIQ, vIR, vIS);
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "updateDistrict " + vIQ + ' ' + vIR + ' ' + vIS);
      AppMethodBeat.o(252261);
      return;
      localObject1 = (FinderCreateContactUI)this;
      vIQ = "unshow";
      vIR = "";
      vIS = "";
      localObject2 = ((FinderCreateContactUI)localObject1).vIl;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("districtLayout");
      }
      ((View)localObject2).setVisibility(8);
      ((FinderCreateContactUI)localObject1).vIM = 3;
      continue;
      localObject1 = this.vIg;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("locationIcon");
      }
      ((View)localObject1).setVisibility(8);
      ak(vIQ, vIR, vIS);
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
        ImageView localImageView = this.jWS;
        if (localImageView == null) {
          kotlin.g.b.p.btv("avatarView");
        }
        localImageView.setImageBitmap(paramString);
        AppMethodBeat.o(167187);
        return;
      }
    }
    AppMethodBeat.o(167187);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(252264);
    int j;
    if (kotlin.g.b.p.j(paramString, z.aTY()))
    {
      Log.i(this.TAG, "[notifyChanged] user:" + paramString + ",avatarPath:" + this.tjJ);
      com.tencent.mm.aj.p.aYn();
      paramString = com.tencent.mm.aj.e.L(z.aTY(), false);
      j = (int)com.tencent.mm.vfs.s.boW(paramString);
      CharSequence localCharSequence = (CharSequence)this.tjJ;
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
        this.tjJ = paramString;
      }
      AppMethodBeat.o(252264);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252270);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252270);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252269);
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
    AppMethodBeat.o(252269);
    return localView1;
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167180);
    if (paramBoolean)
    {
      localObject = this.vIc;
      if (localObject == null) {
        kotlin.g.b.p.btv("scrollContainer");
      }
      localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((FrameLayout.LayoutParams)localObject).height = (this.vID - paramInt);
      localView = this.vIc;
      if (localView == null) {
        kotlin.g.b.p.btv("scrollContainer");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.vIn;
      if (localObject == null) {
        kotlin.g.b.p.btv("editTopSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.aG((Context)this, 2131165296);
      localView = this.vIn;
      if (localView == null) {
        kotlin.g.b.p.btv("editTopSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.vIo;
      if (localObject == null) {
        kotlin.g.b.p.btv("editMiddleSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.aG((Context)this, 2131165313);
      localView = this.vIo;
      if (localView == null) {
        kotlin.g.b.p.btv("editMiddleSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.vIp;
      if (localObject == null) {
        kotlin.g.b.p.btv("editBottomSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.aG((Context)this, 2131165296);
      localView = this.vIp;
      if (localView == null) {
        kotlin.g.b.p.btv("editBottomSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(167180);
      return;
    }
    Object localObject = this.vIc;
    if (localObject == null) {
      kotlin.g.b.p.btv("scrollContainer");
    }
    localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((FrameLayout.LayoutParams)localObject).height = -1;
    View localView = this.vIc;
    if (localView == null) {
      kotlin.g.b.p.btv("scrollContainer");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.vIn;
    if (localObject == null) {
      kotlin.g.b.p.btv("editTopSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.aG((Context)this, 2131165312);
    localView = this.vIn;
    if (localView == null) {
      kotlin.g.b.p.btv("editTopSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.vIo;
    if (localObject == null) {
      kotlin.g.b.p.btv("editMiddleSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = -2;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localView = this.vIo;
    if (localView == null) {
      kotlin.g.b.p.btv("editMiddleSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.vIp;
    if (localObject == null) {
      kotlin.g.b.p.btv("editBottomSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.aG((Context)this, 2131165281);
    localView = this.vIp;
    if (localView == null) {
      kotlin.g.b.p.btv("editBottomSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(167180);
  }
  
  public final int getLayoutId()
  {
    return 2131494232;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(167184);
    if (paramInt1 == this.vIw) {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.aSY());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.vIx);
      }
    }
    for (;;)
    {
      cO();
      AppMethodBeat.o(167184);
      return;
      if (paramInt1 == this.vIx)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          this.tjJ = paramIntent.getStringExtra("key_result_img_path");
          paramIntent = this.tjJ;
          if (paramIntent != null) {
            kme = paramIntent;
          }
          Log.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.s.boW(this.tjJ) / 1024L) });
          this.vIN = 2;
          setAvatar(this.tjJ);
        }
      }
      else
      {
        Object localObject;
        if (paramInt1 == this.vIy)
        {
          if ((paramIntent != null) && (paramInt2 == -1))
          {
            localObject = paramIntent.getStringExtra("key_output_sex");
            paramIntent = (Intent)localObject;
            if (localObject == null) {
              paramIntent = "";
            }
            vIP = paramIntent;
            dzh();
            this.vIL = 2;
          }
        }
        else if ((paramInt1 == this.vIz) && (paramIntent != null) && (paramInt2 == -1))
        {
          String str = paramIntent.getStringExtra("Country");
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          vIQ = (String)localObject;
          str = paramIntent.getStringExtra("Contact_Province");
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          vIR = (String)localObject;
          localObject = paramIntent.getStringExtra("Contact_City");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          vIS = paramIntent;
          ox(false);
          this.vIM = 2;
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167178);
    super.onBackPressed();
    Object localObject = com.tencent.mm.plugin.finder.report.i.vfo;
    com.tencent.mm.plugin.finder.report.i.Ks(5);
    localObject = com.tencent.mm.plugin.finder.report.k.vfA;
    int i = this.scene;
    int j = this.vIN;
    int k = this.vIM;
    int m = this.vIL;
    int n = this.vIB;
    boolean bool = vIW;
    localObject = vIX;
    EditText localEditText = this.vId;
    if (localEditText == null) {
      kotlin.g.b.p.btv("nickEdt");
    }
    com.tencent.mm.plugin.finder.report.k.a(i, 0, j, false, k, m, n, bool, kotlin.g.b.p.j(localObject, localEditText.getText().toString()) ^ true);
    AppMethodBeat.o(167178);
  }
  
  public final void onClickEditDistrict(View paramView)
  {
    AppMethodBeat.i(167177);
    paramView = this.vId;
    if (paramView == null) {
      kotlin.g.b.p.btv("nickEdt");
    }
    paramView.clearFocus();
    hideVKB();
    f(false, 0);
    paramView = new Intent();
    paramView.putExtra("GetAddress", true);
    paramView.putExtra("ShowSelectedLocation", true);
    paramView.putExtra("SetSelectLocation", true);
    paramView.putExtra("SelectedCountryCode", vIQ);
    paramView.putExtra("SelectedProvinceCode", vIR);
    paramView.putExtra("SelectedCityCode", vIS);
    paramView.putExtra("NeedUnshowItem", false);
    com.tencent.mm.br.c.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, this.vIz);
    AppMethodBeat.o(167177);
  }
  
  public final void onClickEditSex(View paramView)
  {
    AppMethodBeat.i(167176);
    paramView = this.vId;
    if (paramView == null) {
      kotlin.g.b.p.btv("nickEdt");
    }
    paramView.clearFocus();
    hideVKB();
    f(false, 0);
    if (this.vIF)
    {
      paramView = new Intent();
      paramView.putExtra("key_input_sex", vIP);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramView, this.vIy);
    }
    AppMethodBeat.o(167176);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167175);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    getController().p((Activity)this, getResources().getColor(2131101424));
    paramBundle = findViewById(2131307333);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.scroll_container)");
    this.vIc = paramBundle;
    paramBundle = findViewById(2131300774);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_avatar_iv)");
    this.jWS = ((ImageView)paramBundle);
    paramBundle = findViewById(2131300799);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_create_title)");
    this.titleTv = ((TextView)paramBundle);
    paramBundle = findViewById(2131301379);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_nick_tv)");
    this.vId = ((EditText)paramBundle);
    paramBundle = findViewById(2131301483);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_sex_tv)");
    this.vIe = ((TextView)paramBundle);
    paramBundle = findViewById(2131300803);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_district_tv)");
    this.vIf = ((TextView)paramBundle);
    paramBundle = findViewById(2131299680);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.district_layout)");
    this.vIl = paramBundle;
    paramBundle = findViewById(2131303730);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.location_icon)");
    this.vIg = paramBundle;
    paramBundle = findViewById(2131297048);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.arrow_icon)");
    this.vIh = paramBundle;
    paramBundle = findViewById(2131302651);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.info_icon)");
    this.vIi = paramBundle;
    paramBundle = findViewById(2131307723);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.sex_arrow_icon)");
    this.vIj = paramBundle;
    paramBundle = findViewById(2131307724);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.sex_info_icon)");
    this.vIk = paramBundle;
    paramBundle = findViewById(2131300796);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_contact_create_btn)");
    this.vIm = ((Button)paramBundle);
    paramBundle = findViewById(2131302683);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.input_panel)");
    this.vIq = ((InputPanelFrameLayout)paramBundle);
    paramBundle = findViewById(2131300853);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_input_container)");
    this.uht = paramBundle;
    paramBundle = findViewById(2131299915);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.edt_top_space)");
    this.vIn = paramBundle;
    paramBundle = findViewById(2131299914);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.edt_middle_space)");
    this.vIo = paramBundle;
    paramBundle = findViewById(2131299912);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.edt_bottom_space)");
    this.vIp = paramBundle;
    paramBundle = findViewById(2131309314);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.top_error_tip)");
    this.vIr = ((TextView)paramBundle);
    paramBundle = findViewById(2131301381);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.finder_nickname_edit_limit)");
    this.vIs = ((TextView)paramBundle);
    paramBundle = findViewById(2131298749);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.clear_text_btn)");
    this.vIt = paramBundle;
    paramBundle = this.vIt;
    if (paramBundle == null) {
      kotlin.g.b.p.btv("clearNameBtn");
    }
    paramBundle.setVisibility(8);
    paramBundle = findViewById(2131309174);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.tips_check_cb)");
    this.vIu = ((CheckBox)paramBundle);
    paramBundle = findViewById(2131309189);
    kotlin.g.b.p.g(paramBundle, "findViewById(R.id.tips_warning_tv)");
    this.vIv = ((TextView)paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
    Object localObject1;
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dsL().value()).intValue() == 1)
    {
      paramBundle = dzf();
      kotlin.g.b.p.g(paramBundle, "wxProfileLayout");
      paramBundle.setVisibility(0);
      paramBundle = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(paramBundle, "MMKernel.storage()");
      paramBundle.azQ().set(ar.a.Omv, Integer.valueOf(1));
      ((LinearLayout)this.vIG.getValue()).setOnClickListener((View.OnClickListener)new c(this));
      paramBundle = this.vIm;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("createBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      paramBundle = (TextWatcher)new k(this);
      localObject1 = this.vId;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("nickEdt");
      }
      ((EditText)localObject1).addTextChangedListener(paramBundle);
      paramBundle = this.vId;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("nickEdt");
      }
      paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new e(this));
      paramBundle = this.vIt;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("clearNameBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      paramBundle = this.vId;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("nickEdt");
      }
      paramBundle.setOnFocusChangeListener((View.OnFocusChangeListener)new g(this));
      setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
      paramBundle = this.vIq;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("inputPanel");
      }
      paramBundle.setExternalListener((b.a)this);
      paramBundle = this.vIc;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("scrollContainer");
      }
      paramBundle.post((Runnable)new i(this));
      if (vIO != null)
      {
        paramBundle = this.vId;
        if (paramBundle == null) {
          kotlin.g.b.p.btv("nickEdt");
        }
        paramBundle.setText((CharSequence)vIO);
      }
      if (((CharSequence)kme).length() != 0) {
        break label1616;
      }
      i = 1;
      label923:
      if (i == 0) {
        break label1621;
      }
      paramBundle = this.jWS;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("avatarView");
      }
      a.b.c(paramBundle, z.aTY());
      com.tencent.mm.aj.p.aYn();
      this.tjJ = com.tencent.mm.aj.e.L(z.aTY(), false);
      if ((int)com.tencent.mm.vfs.s.boW(this.tjJ) == 0)
      {
        Log.i(this.TAG, "WX avatar file size is zero");
        com.tencent.mm.aj.p.aYn().a((e.a)this);
        this.tjJ = "";
      }
      label1002:
      paramBundle = this.tjJ;
      com.tencent.mm.aj.p.aYn();
      if (!kotlin.g.b.p.j(paramBundle, com.tencent.mm.aj.e.L(z.aTY(), false))) {
        break label1639;
      }
      this.vIN = 1;
      label1030:
      if (((CharSequence)vIP).length() != 0) {
        break label1687;
      }
      i = 1;
      label1046:
      if (i == 0) {
        break label1745;
      }
      paramBundle = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(paramBundle, "MMKernel.storage()");
      i = paramBundle.azQ().getInt(12290, 0);
      if (i != 1) {
        break label1692;
      }
      vIP = "male";
      this.vIL = 1;
    }
    for (;;)
    {
      paramBundle = dzg();
      kotlin.g.b.p.g(paramBundle, "wxProfileSwitchBtn");
      paramBundle.setCheck(vIW);
      dzg().setSwitchListener((MMSwitchBtn.a)j.vJb);
      Log.i(this.TAG, "lastWxProfileChecked = " + vIW);
      paramBundle = new ArrayList();
      localObject1 = ae.SYK;
      localObject1 = String.format("https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[] { LocaleUtil.getCurrentLanguage((Context)this) }, 1));
      kotlin.g.b.p.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = ae.SYK;
      localObject1 = String.format("https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/readtemplate?t=finder_privacy", Arrays.copyOf(new Object[0], 0));
      kotlin.g.b.p.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(getString(2131759623));
      ((ArrayList)localObject2).add(getString(2131759633));
      localObject1 = (Context)this;
      paramBundle = (List)paramBundle;
      String str = getString(2131759635);
      kotlin.g.b.p.g(str, "getString(R.string.finder_create_contact_warning)");
      localObject2 = (List)localObject2;
      TextView localTextView = this.vIv;
      if (localTextView == null) {
        kotlin.g.b.p.btv("tipsWarningTV");
      }
      a((Context)localObject1, paramBundle, str, (List)localObject2, localTextView, this.TAG);
      dzh();
      Log.i(this.TAG, "isLastSelectDistrictEmpty = " + dzi());
      ox(dzi());
      com.tencent.mm.kernel.g.azz().a(3922, (com.tencent.mm.ak.i)this);
      com.tencent.mm.kernel.g.azz().a(3759, (com.tencent.mm.ak.i)this);
      this.scene = getIntent().getIntExtra("scene", 0);
      this.vIB = getIntent().getIntExtra("key_create_scene", 3);
      this.vIC = getIntent().getIntExtra("key_mv_status", 0);
      this.vIK = getIntent().getBooleanExtra("key_router_to_profile", true);
      this.udb = new bed();
      paramBundle = getIntent().getByteArrayExtra("key_prepare_resp");
      if (paramBundle != null) {}
      try
      {
        localObject1 = this.udb;
        if (localObject1 != null) {
          ((bed)localObject1).parseFrom(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = x.SXb;
        }
        this.vIE = ((Integer)paramBundle).intValue();
        paramBundle = this.udb;
        if (paramBundle == null) {
          break label1844;
        }
        Log.i(this.TAG, "nicknameMaxLength ： " + paramBundle.vIE);
        if (paramBundle.vIE <= 0) {
          break label1844;
        }
        this.vIE = paramBundle.vIE;
        h.CyF.n(1279L, 30L, 1L);
        paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Number)com.tencent.mm.plugin.finder.storage.c.dsM().value()).intValue() != 1) {
          break label1909;
        }
        new y().aYI().a((com.tencent.mm.vending.e.b)this).g((com.tencent.mm.vending.c.a)new l(this));
        switch (this.vIC)
        {
        }
      }
      paramBundle = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(paramBundle, "MMKernel.storage()");
      paramBundle = paramBundle.azQ().get(ar.a.Okg, Integer.valueOf(20));
      if (paramBundle != null) {
        break label1782;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(167175);
      throw paramBundle;
      paramBundle = dzf();
      kotlin.g.b.p.g(paramBundle, "wxProfileLayout");
      paramBundle.setVisibility(8);
      break;
      label1616:
      i = 0;
      break label923;
      label1621:
      this.tjJ = kme;
      setAvatar(this.tjJ);
      break label1002;
      label1639:
      paramBundle = (CharSequence)this.tjJ;
      if ((paramBundle == null) || (paramBundle.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1679;
        }
        this.vIN = 3;
        break;
      }
      label1679:
      this.vIN = 2;
      break label1030;
      label1687:
      i = 0;
      break label1046;
      label1692:
      if (i == 2)
      {
        vIP = "female";
        this.vIL = 1;
      }
      else
      {
        paramBundle = (LinearLayout)this.vIH.getValue();
        kotlin.g.b.p.g(paramBundle, "sexLayout");
        paramBundle.setVisibility(8);
        this.vIL = 3;
        continue;
        label1745:
        Log.i(this.TAG, "lastSelectSex = " + vIP);
      }
    }
    for (;;)
    {
      label1782:
      AppMethodBeat.o(167175);
      label1844:
      label1909:
      return;
      paramBundle = this.titleTv;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("titleTv");
      }
      paramBundle.setText(getResources().getText(2131759638));
      paramBundle = this.vIm;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("createBtn");
      }
      paramBundle.setText(getResources().getText(2131759630));
      AppMethodBeat.o(167175);
      return;
      paramBundle = this.titleTv;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("titleTv");
      }
      paramBundle.setText(getResources().getText(2131759638));
      paramBundle = this.vIm;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("createBtn");
      }
      paramBundle.setText(getResources().getText(2131759629));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167182);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3922, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().b(3759, (com.tencent.mm.ak.i)this);
    com.tencent.mm.aj.p.aYn().b((e.a)this);
    AppMethodBeat.o(167182);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(167183);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    if ((paramq instanceof at))
    {
      paramString = this.vIA;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((at)paramq).cYe();
        if (paramString != null)
        {
          paramq = com.tencent.mm.plugin.finder.utils.n.vVR;
          com.tencent.mm.plugin.finder.utils.n.dBS();
          paramq = com.tencent.mm.plugin.finder.report.k.vfA;
          paramInt1 = this.scene;
          paramInt2 = this.vIN;
          int i = this.vIM;
          int j = this.vIL;
          int k = this.vIB;
          boolean bool = vIW;
          paramq = vIX;
          localObject = this.vId;
          if (localObject == null) {
            kotlin.g.b.p.btv("nickEdt");
          }
          com.tencent.mm.plugin.finder.report.k.a(paramInt1, 1, paramInt2, true, i, j, k, bool, kotlin.g.b.p.j(paramq, ((EditText)localObject).getText().toString()) ^ true);
          h.CyF.n(1279L, 32L, 1L);
          paramq = new Intent();
          if (this.vIK)
          {
            paramq.putExtra("finder_username", paramString.username);
            paramq.putExtra("KEY_FINDER_SELF_FLAG", true);
            paramString = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a((Context)this, paramq, 0L, 0, false, 124);
            paramString = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramq);
          }
          finish();
          AppMethodBeat.o(167183);
          return;
        }
        AppMethodBeat.o(167183);
        return;
      }
      if (paramInt2 == -4003) {
        h.CyF.n(1279L, 37L, 1L);
      }
      for (;;)
      {
        paramString = ((at)paramq).rr.aYK();
        if (paramString != null) {
          break;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
        AppMethodBeat.o(167183);
        throw paramString;
        if (paramInt2 == -4008) {
          h.CyF.n(1279L, 38L, 1L);
        }
      }
      localObject = ((aqf)paramString).verifyInfo;
      if (localObject != null)
      {
        Log.i(this.TAG, "verify info: " + com.tencent.mm.ac.g.bN(localObject));
        if (((azn)localObject).LJr == 1)
        {
          paramString = this.vId;
          if (paramString == null) {
            kotlin.g.b.p.btv("nickEdt");
          }
          paramString.setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100994));
        }
        if (!Util.isNullOrNil(((azn)localObject).LJo))
        {
          paramq = ((azn)localObject).LJo;
          paramString = paramq;
          if (paramq == null) {
            paramString = "";
          }
          aj(paramString, ((azn)localObject).LJt, ((azn)localObject).LJs);
          AppMethodBeat.o(167183);
          return;
        }
        paramString = getString(2131759628);
        kotlin.g.b.p.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
        aj(paramString, null, null);
        AppMethodBeat.o(167183);
        return;
      }
      paramString = (FinderCreateContactUI)this;
      paramq = paramString.getString(2131759628);
      kotlin.g.b.p.g(paramq, "getString(R.string.finde…reate_contact_failed_tip)");
      paramString.aj(paramq, null, null);
      AppMethodBeat.o(167183);
      return;
    }
    if ((paramq instanceof cl))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((cl)paramq).twt;
        localObject = ((cl)paramq).fileMD5;
        paramInt1 = ((cl)paramq).iKP;
        if (paramString != null)
        {
          paramq = dI((String)localObject, paramInt1);
          if (((CharSequence)paramq).length() <= 0) {
            break label656;
          }
        }
        label656:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            ((Map)vIY).put(paramq, paramString);
          }
          avK(paramString);
          AppMethodBeat.o(167183);
          return;
        }
      }
      paramString = this.vIA;
      if (paramString != null) {
        paramString.dismiss();
      }
      h.CyF.n(1279L, 33L, 1L);
      paramString = getString(2131759628);
      kotlin.g.b.p.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
      aj(paramString, null, null);
    }
    AppMethodBeat.o(167183);
  }
  
  public final void onTipsCheckBoxClick(View paramView)
  {
    AppMethodBeat.i(252254);
    paramView = this.vIu;
    if (paramView == null) {
      kotlin.g.b.p.btv("tipsCheckCB");
    }
    CheckBox localCheckBox = this.vIu;
    if (localCheckBox == null) {
      kotlin.g.b.p.btv("tipsCheckCB");
    }
    if (!localCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(252254);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI$Companion;", "", "()V", "MV_POST", "", "MV_SAVE", "avatarSvrUrlMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAvatarSvrUrlMap", "()Ljava/util/HashMap;", "lastAvatarPath", "getLastAvatarPath", "()Ljava/lang/String;", "setLastAvatarPath", "(Ljava/lang/String;)V", "lastNickName", "getLastNickName", "setLastNickName", "lastSelectCityCode", "getLastSelectCityCode", "setLastSelectCityCode", "lastSelectCountryCode", "getLastSelectCountryCode", "setLastSelectCountryCode", "lastSelectProvinceCode", "getLastSelectProvinceCode", "setLastSelectProvinceCode", "lastSelectSex", "getLastSelectSex", "setLastSelectSex", "lastUsedCgiName", "getLastUsedCgiName", "setLastUsedCgiName", "lastWxProfileChecked", "", "getLastWxProfileChecked", "()Z", "setLastWxProfileChecked", "(Z)V", "realCityCode", "getRealCityCode", "setRealCityCode", "realCountryCode", "getRealCountryCode", "setRealCountryCode", "realProvinceCode", "getRealProvinceCode", "setRealProvinceCode", "plugin-finder_release"})
  public static final class a
  {
    public static void avO(String paramString)
    {
      AppMethodBeat.i(252237);
      kotlin.g.b.p.h(paramString, "<set-?>");
      FinderCreateContactUI.avM(paramString);
      AppMethodBeat.o(252237);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    b(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167160);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      com.tencent.mm.pluginsdk.ui.tools.s.a((Activity)this.vJa, FinderCreateContactUI.b(this.vJa), 1, 5, null, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167160);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167161);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      Log.i(FinderCreateContactUI.c(this.vJa), "doClick create contact btn");
      Object localObject2 = new bo();
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((bo)localObject2).jL(paramView);
      ((bo)localObject2).eo(FinderCreateContactUI.d(this.vJa));
      Object localObject4 = this.vJa.getString(2131756221);
      kotlin.g.b.p.g(localObject4, "getString(R.string.avatar_desc)");
      Object localObject3 = this.vJa.getString(2131760332);
      kotlin.g.b.p.g(localObject3, "getString(R.string.finder_nickname)");
      kotlin.g.b.p.g(this.vJa.getString(2131765582), "getString(R.string.settings_sex)");
      paramView = FinderCreateContactUI.vIZ;
      localObject1 = FinderCreateContactUI.e(this.vJa);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      kotlin.g.b.p.h(paramView, "<set-?>");
      FinderCreateContactUI.avL(paramView);
      paramView = FinderCreateContactUI.vIZ;
      paramView = FinderCreateContactUI.a(this.vJa).getText();
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
          localObject1 = kotlin.n.n.trim((CharSequence)paramView).toString();
          paramView = (View)localObject1;
          if (localObject1 != null) {
            break label249;
          }
        }
      }
      paramView = "";
      label249:
      FinderCreateContactUI.a.avO(paramView);
      paramView = FinderCreateContactUI.vIZ;
      paramView = FinderCreateContactUI.f(this.vJa);
      kotlin.g.b.p.g(paramView, "wxProfileSwitchBtn");
      FinderCreateContactUI.oy(paramView.isCheck());
      paramView = new ArrayList();
      localObject1 = FinderCreateContactUI.vIZ;
      if (com.tencent.mm.ui.tools.f.bnP(FinderCreateContactUI.dzk()) > FinderCreateContactUI.g(this.vJa)) {
        paramView.add(localObject3);
      }
      localObject1 = new ArrayList();
      FinderCreateContactUI.a locala = FinderCreateContactUI.vIZ;
      int i;
      if (((CharSequence)FinderCreateContactUI.dzj()).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label562;
        }
        ((ArrayList)localObject1).add(localObject4);
        label353:
        localObject4 = FinderCreateContactUI.vIZ;
        if (((CharSequence)FinderCreateContactUI.dzk()).length() != 0) {
          break label571;
        }
        i = 1;
        label374:
        if (i == 0) {
          break label576;
        }
        ((ArrayList)localObject1).add(localObject3);
        label385:
        localObject3 = FinderCreateContactUI.vIZ;
        if (((CharSequence)FinderCreateContactUI.dzl()).length() != 0) {
          break label585;
        }
        i = 1;
        label406:
        if (i == 0) {
          ((bo)localObject2).acE();
        }
        localObject3 = FinderCreateContactUI.vIZ;
        if (!Util.isNullOrNil(FinderCreateContactUI.dzm())) {
          ((bo)localObject2).acF();
        }
        if (!paramView.isEmpty()) {
          break label790;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          break label668;
        }
        if (!FinderCreateContactUI.h(this.vJa).isChecked()) {
          break label590;
        }
        FinderCreateContactUI.i(this.vJa);
        ((bo)localObject2).em(1L);
      }
      for (;;)
      {
        ((bo)localObject2).bfK();
        paramView = FinderCreateContactUI.c(this.vJa);
        localObject1 = new StringBuilder("report19815 ");
        localObject2 = ((bo)localObject2).abW();
        kotlin.g.b.p.g(localObject2, "struct.toShowString()");
        Log.i(paramView, kotlin.n.n.j((String)localObject2, "\r\n", " ", false));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167161);
        return;
        i = 0;
        break;
        label562:
        ((bo)localObject2).acC();
        break label353;
        label571:
        i = 0;
        break label374;
        label576:
        ((bo)localObject2).acD();
        break label385;
        label585:
        i = 0;
        break label406;
        label590:
        Log.i(FinderCreateContactUI.c(this.vJa), "not check agreement");
        paramView = this.vJa;
        localObject1 = this.vJa.getString(2131759531);
        kotlin.g.b.p.g(localObject1, "getString(R.string.finder_agreement_not_check_tip)");
        FinderCreateContactUI.a(paramView, (String)localObject1);
        ((bo)localObject2).em(2L);
        ((bo)localObject2).en(3L);
        ((bo)localObject2).jM(this.vJa.getString(2131759531));
        continue;
        label668:
        Log.i(FinderCreateContactUI.c(this.vJa), "empty attr ".concat(String.valueOf(localObject1)));
        paramView = Util.listToString((List)localObject1, this.vJa.getString(2131759683));
        localObject1 = this.vJa;
        localObject3 = this.vJa.getString(2131759816, new Object[] { paramView });
        kotlin.g.b.p.g(localObject3, "getString(R.string.finde…_empty_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((bo)localObject2).em(2L);
        ((bo)localObject2).en(2L);
        ((bo)localObject2).jM(this.vJa.getString(2131759816, new Object[] { paramView }));
        continue;
        label790:
        paramView = Util.listToString((List)paramView, this.vJa.getString(2131759683));
        localObject1 = this.vJa;
        localObject3 = this.vJa.getString(2131759817, new Object[] { paramView });
        kotlin.g.b.p.g(localObject3, "getString(R.string.finde…o_long_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((bo)localObject2).em(2L);
        ((bo)localObject2).en(1L);
        ((bo)localObject2).jM(this.vJa.getString(2131759817, new Object[] { paramView }));
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class e
    implements TextView.OnEditorActionListener
  {
    e(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(167162);
      if (5 == paramInt) {
        FinderCreateContactUI.a(this.vJa).clearFocus();
      }
      AppMethodBeat.o(167162);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252239);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderCreateContactUI.a(this.vJa).getText().clear();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252239);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
  static final class g
    implements View.OnFocusChangeListener
  {
    g(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onFocusChange(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(252240);
      paramView = FinderCreateContactUI.l(this.vJa);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        AppMethodBeat.o(252240);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252241);
      paramMenuItem = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.Ks(5);
      paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
      int i = FinderCreateContactUI.m(this.vJa);
      int j = FinderCreateContactUI.n(this.vJa);
      int k = FinderCreateContactUI.o(this.vJa);
      int m = FinderCreateContactUI.p(this.vJa);
      int n = FinderCreateContactUI.d(this.vJa);
      paramMenuItem = FinderCreateContactUI.vIZ;
      boolean bool = FinderCreateContactUI.dzn();
      paramMenuItem = FinderCreateContactUI.vIZ;
      com.tencent.mm.plugin.finder.report.k.a(i, 0, j, false, k, m, n, bool, kotlin.g.b.p.j(FinderCreateContactUI.dzo(), FinderCreateContactUI.a(this.vJa).getText().toString()) ^ true);
      this.vJa.finish();
      AppMethodBeat.o(252241);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252242);
      FinderCreateContactUI.a(this.vJa, FinderCreateContactUI.q(this.vJa).getMeasuredHeight());
      AppMethodBeat.o(252242);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "selected", "", "onStatusChange"})
  static final class j
    implements MMSwitchBtn.a
  {
    public static final j vJb;
    
    static
    {
      AppMethodBeat.i(252244);
      vJb = new j();
      AppMethodBeat.o(252244);
    }
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(252243);
      FinderCreateContactUI.a locala = FinderCreateContactUI.vIZ;
      FinderCreateContactUI.oy(paramBoolean);
      AppMethodBeat.o(252243);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class k
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167168);
      com.tencent.mm.ui.tools.b.c.f(FinderCreateContactUI.a(this.vJa)).lv(1, FinderCreateContactUI.g(this.vJa)).a(f.a.Qui).CN(true).a((c.a)new a(this));
      paramEditable = FinderCreateContactUI.vIZ;
      paramEditable = FinderCreateContactUI.a(this.vJa).getText();
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
          String str = kotlin.n.n.trim((CharSequence)paramEditable).toString();
          paramEditable = str;
          if (str != null) {
            break label119;
          }
        }
      }
      paramEditable = "";
      label119:
      FinderCreateContactUI.a.avO(paramEditable);
      FinderCreateContactUI.a(this.vJa).setTextColor(com.tencent.mm.cb.a.n((Context)this.vJa, 2131100904));
      AppMethodBeat.o(167168);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements c.a
    {
      public final void Tw(String paramString)
      {
        AppMethodBeat.i(167167);
        int i = com.tencent.mm.ui.tools.f.dp(FinderCreateContactUI.g(this.vJc.vJa), paramString);
        FinderCreateContactUI.j(this.vJc.vJa).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.j(this.vJc.vJa).setTextColor(this.vJc.vJa.getResources().getColor(2131099662));
        if (i <= kotlin.k.j.mZ((int)(FinderCreateContactUI.g(this.vJc.vJa) * 0.1F), 1)) {
          FinderCreateContactUI.j(this.vJc.vJa).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.k(this.vJc.vJa);
          AppMethodBeat.o(167167);
          return;
          FinderCreateContactUI.j(this.vJc.vJa).setVisibility(4);
        }
      }
      
      public final void Tx(String paramString)
      {
        AppMethodBeat.i(252245);
        FinderCreateContactUI.j(this.vJc.vJa).setText((CharSequence)String.valueOf(FinderCreateContactUI.g(this.vJc.vJa)));
        FinderCreateContactUI.j(this.vJc.vJa).setTextColor(this.vJc.vJa.getResources().getColor(2131099662));
        AppMethodBeat.o(252245);
      }
      
      public final void dv(String paramString)
      {
        AppMethodBeat.i(167166);
        FinderCreateContactUI.j(this.vJc.vJa).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.f.dp(FinderCreateContactUI.g(this.vJc.vJa), paramString)));
        FinderCreateContactUI.j(this.vJc.vJa).setVisibility(0);
        FinderCreateContactUI.j(this.vJc.vJa).setTextColor(this.vJc.vJa.getResources().getColor(2131099819));
        paramString = this.vJc.vJa;
        String str = this.vJc.vJa.getString(2131760336);
        kotlin.g.b.p.g(str, "getString(R.string.finder_nickname_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167166);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class l<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    l(FinderCreateContactUI paramFinderCreateContactUI) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    n(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    o(FinderCreateContactUI paramFinderCreateContactUI, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$1$1"})
  static final class q
    implements View.OnClickListener
  {
    q(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178430);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.spam.a.vwk;
      paramView = this.vJa.getString(2131760242);
      kotlin.g.b.p.g(paramView, "getString(R.string.finder_location_tip_gps)");
      com.tencent.mm.plugin.finder.spam.a.avm(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178430);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(252249);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.spam.a.vwk;
      paramView = this.vJa.getString(2131760565);
      kotlin.g.b.p.g(paramView, "getString(R.string.finder_sex_tip)");
      com.tencent.mm.plugin.finder.spam.a.avm(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(252249);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    s(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMSwitchBtn>
  {
    t(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI
 * JD-Core Version:    0.7.0.1
 */