package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.ip;
import com.tencent.mm.autogen.mmdata.rpt.dd;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.accessibility.e;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.cgi.br;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.cgi.dr;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_CODE_SELECT_DISTRICT", "REQUEST_CODE_SELECT_SEX", "TAG", "", "avatarPath", "avatarView", "Landroid/widget/ImageView;", "canSelectSex", "", "changeAvatarView", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getChangeAvatarView", "()Landroid/widget/LinearLayout;", "changeAvatarView$delegate", "Lkotlin/Lazy;", "clearNameBtn", "Landroid/view/View;", "createBtn", "Landroid/widget/Button;", "createScene", "districtLayout", "districtTV", "Landroid/widget/TextView;", "editBottomSpace", "editMiddleSpace", "editNickNameLimit", "editTopSpace", "goToPageAfterCreateSucc", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "locationArrowIcon", "locationIcon", "locationInfoIcon", "mvStatus", "nickEdt", "Landroid/widget/EditText;", "nicknameMaxLength", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "routerToProfile", "scene", "scrollContainer", "scrollViewOriginHeight", "sexArrowIcon", "sexInfoIcon", "sexLayout", "getSexLayout", "sexLayout$delegate", "sexTV", "tipsCheckCB", "Landroid/widget/CheckBox;", "tipsWarningTV", "titleTv", "topErrorTip", "wxProfileLayout", "getWxProfileLayout", "wxProfileLayout$delegate", "wxProfileSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getWxProfileSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "wxProfileSwitchBtn$delegate", "createContact", "", "generateKey", "avatarFileMD5", "avatarLen", "getLayoutId", "hideError", "initContentView", "isLastSelectDistrictEmpty", "notifyChanged", "user", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickEditDistrict", "view", "onClickEditSex", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTipsCheckBoxClick", "requestCreateUser", "imgUrl", "sendCreateResult", "result", "setAvatar", "path", "setDistrictTV", "countryCodeName", "provinceCodeName", "cityCodeName", "setMvView", "setSpanTouch", "descTv", "text", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "spanLinks", "context", "Landroid/content/Context;", "h5urlList", "", "allText", "linkTextList", "logTag", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateDistrict", "isAuto", "updateSex", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderCreateContactUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, AvatarStorage.a, com.tencent.mm.ui.widget.c.a
{
  private static String FPL;
  private static String FPM;
  private static int FPN;
  private static int FPO;
  private static int FPP;
  private static String FPQ;
  private static String FPR;
  private static String FPS;
  private static String FPT;
  private static String FPU;
  private static String FPV;
  private static boolean FPW;
  private static String FPX;
  private static final HashMap<String, String> FPY;
  private static final int FPZ;
  public static final FinderCreateContactUI.a FPc;
  private static final int FQa;
  private static String pZp;
  private String AmC;
  private bys AwM;
  private final int BoG;
  private final int BoH;
  private int EaB;
  private ProgressDialog FPA;
  private int FPB;
  private int FPC;
  private int FPD;
  private boolean FPE;
  private final j FPF;
  private final j FPG;
  private final j FPH;
  private final j FPI;
  private boolean FPJ;
  private int FPK;
  private View FPd;
  private EditText FPe;
  private TextView FPf;
  private TextView FPg;
  private View FPh;
  private View FPi;
  private View FPj;
  private View FPk;
  private View FPl;
  private View FPm;
  private Button FPn;
  private View FPo;
  private View FPp;
  private View FPq;
  private InputPanelFrameLayout FPr;
  private View FPs;
  private TextView FPt;
  private TextView FPu;
  private View FPv;
  private CheckBox FPw;
  private TextView FPx;
  private final int FPy;
  private final int FPz;
  private final String TAG;
  private ImageView pKM;
  private int scene;
  private TextView titleTv;
  
  static
  {
    AppMethodBeat.i(167188);
    FPc = new FinderCreateContactUI.a((byte)0);
    pZp = "";
    FPL = "";
    FPM = "";
    FPQ = "";
    FPR = "";
    FPS = "";
    FPT = "";
    FPU = "";
    FPV = "";
    FPW = true;
    FPX = "";
    FPY = new HashMap();
    l locall = l.Hcd;
    FPZ = l.frx();
    locall = l.Hcd;
    FQa = l.fry();
    AppMethodBeat.o(167188);
  }
  
  public FinderCreateContactUI()
  {
    AppMethodBeat.i(346587);
    this.TAG = "Finder.FinderCreateContactUI";
    this.BoG = 1000;
    this.BoH = 1001;
    this.FPy = 1002;
    this.FPz = 1003;
    this.FPD = 20;
    this.FPE = true;
    this.FPF = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.FPG = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.FPH = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.FPI = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.FPJ = true;
    AppMethodBeat.o(346587);
  }
  
  private static void TC(int paramInt)
  {
    AppMethodBeat.i(346685);
    ip localip = new ip();
    localip.hKc.result = paramInt;
    localip.publish();
    AppMethodBeat.o(346685);
  }
  
  private final void Xh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(346674);
    Object localObject1 = this.FPt;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("topErrorTip");
      localObject1 = null;
      ((TextView)localObject1).setText((CharSequence)"");
      localObject1 = this.FPt;
      if (localObject1 != null) {
        break label68;
      }
      kotlin.g.b.s.bIx("topErrorTip");
      localObject1 = localObject2;
    }
    label68:
    for (;;)
    {
      ((TextView)localObject1).setVisibility(8);
      AppMethodBeat.o(346674);
      return;
      break;
    }
  }
  
  private static final ah a(FinderCreateContactUI paramFinderCreateContactUI, b.a parama)
  {
    AppMethodBeat.i(346796);
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    String str;
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      str = ((bts)parama.ott).nickName;
      if (str == null) {
        break label163;
      }
      if (((CharSequence)str).length() <= 0) {
        break label158;
      }
      i = 1;
      if (i != 1) {
        break label163;
      }
      i = 1;
      label66:
      if (i != 0)
      {
        EditText localEditText = paramFinderCreateContactUI.FPe;
        parama = localEditText;
        if (localEditText == null)
        {
          kotlin.g.b.s.bIx("nickEdt");
          parama = null;
        }
        if (Util.isNullOrNil((CharSequence)parama.getText()))
        {
          parama = paramFinderCreateContactUI.FPe;
          if (parama != null) {
            break label168;
          }
          kotlin.g.b.s.bIx("nickEdt");
          parama = null;
        }
      }
    }
    label158:
    label163:
    label168:
    for (;;)
    {
      parama.append((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)paramFinderCreateContactUI.getContext(), (CharSequence)str));
      FPX = str;
      paramFinderCreateContactUI = ah.aiuX;
      AppMethodBeat.o(346796);
      return paramFinderCreateContactUI;
      i = 0;
      break;
      i = 0;
      break label66;
    }
  }
  
  private void a(Context paramContext, List<String> paramList1, String paramString1, List<String> paramList2, TextView paramTextView, String paramString2)
  {
    AppMethodBeat.i(346780);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramList1, "h5urlList");
    kotlin.g.b.s.u(paramString1, "allText");
    kotlin.g.b.s.u(paramList2, "linkTextList");
    kotlin.g.b.s.u(paramTextView, "descTv");
    kotlin.g.b.s.u(paramString2, "logTag");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString1);
    paramList2 = ((Iterable)paramList2).iterator();
    int i = 0;
    while (paramList2.hasNext())
    {
      Object localObject = paramList2.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (String)localObject;
      int j = n.a((CharSequence)paramString1, (String)localObject, 0, false, 6);
      int k = j + ((String)localObject).length();
      if ((j >= 0) && (k <= paramString1.length())) {
        localSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.q((String)paramList1.get(i), MMApplicationContext.getContext().getResources().getColor(e.b.link_color), MMApplicationContext.getContext().getResources().getColor(e.b.BW_0_Alpha_0_2), (kotlin.g.a.b)new FinderCreateContactUI.h(paramString2, paramContext)), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText((CharSequence)localSpannableString);
    a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(346780);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(346664);
    kotlin.g.b.s.u(paramTextView, "descTv");
    kotlin.g.b.s.u(paramSpannable, "text");
    paramTextView.setOnTouchListener(new FinderCreateContactUI..ExternalSyntheticLambda7(paramSpannable, paramTextView, this));
    AppMethodBeat.o(346664);
  }
  
  private static final void a(FinderCreateContactUI paramFinderCreateContactUI)
  {
    AppMethodBeat.i(346939);
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    View localView2 = paramFinderCreateContactUI.FPd;
    View localView1 = localView2;
    if (localView2 == null)
    {
      kotlin.g.b.s.bIx("scrollContainer");
      localView1 = null;
    }
    paramFinderCreateContactUI.EaB = localView1.getMeasuredHeight();
    AppMethodBeat.o(346939);
  }
  
  private static final void a(FinderCreateContactUI paramFinderCreateContactUI, View paramView)
  {
    AppMethodBeat.i(346812);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCreateContactUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    com.tencent.mm.pluginsdk.ui.tools.t.a((Activity)paramFinderCreateContactUI, paramFinderCreateContactUI.BoG, 1, 5, null, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346812);
  }
  
  private static final void a(FinderCreateContactUI paramFinderCreateContactUI, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(346893);
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    paramFinderCreateContactUI = paramFinderCreateContactUI.FPv;
    if (paramFinderCreateContactUI == null)
    {
      kotlin.g.b.s.bIx("clearNameBtn");
      paramFinderCreateContactUI = null;
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = 0;; i = 8)
    {
      paramFinderCreateContactUI.setVisibility(i);
      AppMethodBeat.o(346893);
      return;
      break;
    }
  }
  
  private static final void a(boolean paramBoolean, FinderCreateContactUI paramFinderCreateContactUI, int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(346971);
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    if (paramBoolean)
    {
      localObject3 = paramFinderCreateContactUI.FPd;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("scrollContainer");
        localObject1 = null;
      }
      localObject4 = new FrameLayout.LayoutParams(((View)localObject1).getLayoutParams());
      ((FrameLayout.LayoutParams)localObject4).height = (paramFinderCreateContactUI.EaB - paramInt);
      localObject3 = paramFinderCreateContactUI.FPd;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("scrollContainer");
        localObject1 = null;
      }
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject3 = paramFinderCreateContactUI.FPo;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("editTopSpace");
        localObject1 = null;
      }
      localObject3 = new LinearLayout.LayoutParams(((View)localObject1).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject3).height = com.tencent.mm.cd.a.br((Context)paramFinderCreateContactUI, e.c.Edge_2A);
      localObject1 = paramFinderCreateContactUI.FPo;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("editTopSpace");
        localObject1 = null;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = paramFinderCreateContactUI.FPp;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("editMiddleSpace");
          localObject1 = null;
        }
        localObject3 = new LinearLayout.LayoutParams(((View)localObject1).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject3).height = com.tencent.mm.cd.a.br((Context)paramFinderCreateContactUI, e.c.Edge_9A);
        localObject1 = paramFinderCreateContactUI.FPp;
        if (localObject1 != null) {
          break label336;
        }
        kotlin.g.b.s.bIx("editMiddleSpace");
        localObject1 = null;
        label243:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = paramFinderCreateContactUI.FPq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("editBottomSpace");
          localObject1 = null;
        }
        localObject1 = new LinearLayout.LayoutParams(((View)localObject1).getLayoutParams());
        ((LinearLayout.LayoutParams)localObject1).height = com.tencent.mm.cd.a.br((Context)paramFinderCreateContactUI, e.c.Edge_2A);
        paramFinderCreateContactUI = paramFinderCreateContactUI.FPq;
        if (paramFinderCreateContactUI != null) {
          break label339;
        }
        kotlin.g.b.s.bIx("editBottomSpace");
        paramFinderCreateContactUI = (FinderCreateContactUI)localObject2;
      }
      label336:
      label339:
      for (;;)
      {
        paramFinderCreateContactUI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(346971);
        return;
        break;
        break label243;
      }
    }
    localObject2 = paramFinderCreateContactUI.FPd;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("scrollContainer");
      localObject1 = null;
    }
    Object localObject4 = new FrameLayout.LayoutParams(((View)localObject1).getLayoutParams());
    ((FrameLayout.LayoutParams)localObject4).height = -1;
    localObject2 = paramFinderCreateContactUI.FPd;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("scrollContainer");
      localObject1 = null;
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject2 = paramFinderCreateContactUI.FPo;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("editTopSpace");
      localObject1 = null;
    }
    localObject2 = new LinearLayout.LayoutParams(((View)localObject1).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject2).height = com.tencent.mm.cd.a.br((Context)paramFinderCreateContactUI, e.c.Edge_8A);
    localObject1 = paramFinderCreateContactUI.FPo;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("editTopSpace");
      localObject1 = null;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = paramFinderCreateContactUI.FPp;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("editMiddleSpace");
        localObject1 = null;
      }
      localObject4 = new LinearLayout.LayoutParams(((View)localObject1).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject4).height = -2;
      ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
      localObject2 = paramFinderCreateContactUI.FPp;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("editMiddleSpace");
        localObject1 = null;
      }
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject2 = paramFinderCreateContactUI.FPq;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("editBottomSpace");
        localObject1 = null;
      }
      localObject1 = new LinearLayout.LayoutParams(((View)localObject1).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject1).height = com.tencent.mm.cd.a.br((Context)paramFinderCreateContactUI, e.c.Edge_12A);
      paramFinderCreateContactUI = paramFinderCreateContactUI.FPq;
      if (paramFinderCreateContactUI != null) {
        break label653;
      }
      kotlin.g.b.s.bIx("editBottomSpace");
      paramFinderCreateContactUI = (FinderCreateContactUI)localObject3;
    }
    label653:
    for (;;)
    {
      paramFinderCreateContactUI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(346971);
      return;
      break;
    }
  }
  
  private static final boolean a(Spannable paramSpannable, TextView paramTextView, FinderCreateContactUI paramFinderCreateContactUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(346994);
    kotlin.g.b.s.u(paramSpannable, "$text");
    kotlin.g.b.s.u(paramTextView, "$descTv");
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    int j = paramMotionEvent.getAction();
    if (paramView == null)
    {
      paramSpannable = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(346994);
      throw paramSpannable;
    }
    paramView = (TextView)paramView;
    switch (j)
    {
    case 2: 
    default: 
      switch (j)
      {
      }
      break;
    }
    for (;;)
    {
      boolean bool = false;
      Log.i(paramFinderCreateContactUI.TAG, "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
      AppMethodBeat.o(346994);
      return bool;
      Object localObject1 = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
      if (localObject1 == null) {
        break;
      }
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof com.tencent.mm.pluginsdk.ui.span.t))
        {
          ((com.tencent.mm.pluginsdk.ui.span.t)localObject2).setIsPressed(false);
          paramTextView.invalidate();
        }
        i += 1;
      }
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      int m = paramView.getPaddingLeft();
      int n = paramView.getPaddingTop();
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      localObject1 = paramView.getLayout();
      i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
      localObject1 = (ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class);
      if (localObject1.length != 0)
      {
        localObject1 = localObject1[0];
        switch (j)
        {
        }
        for (;;)
        {
          bool = true;
          break;
          ((ClickableSpan)localObject1).onClick((View)paramView);
          continue;
          if ((localObject1 instanceof com.tencent.mm.pluginsdk.ui.span.t))
          {
            ((com.tencent.mm.pluginsdk.ui.span.t)localObject1).setIsPressed(true);
            paramTextView.invalidate();
          }
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject1), paramSpannable.getSpanEnd(localObject1));
        }
      }
      Selection.removeSelection(paramSpannable);
    }
  }
  
  private static final boolean a(FinderCreateContactUI paramFinderCreateContactUI, MenuItem paramMenuItem)
  {
    Object localObject = null;
    AppMethodBeat.i(346929);
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    paramMenuItem = v.FrN;
    v.SA(5);
    paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
    int i = paramFinderCreateContactUI.scene;
    int j = FPP;
    int k = FPO;
    int m = FPN;
    int n = paramFinderCreateContactUI.FPB;
    boolean bool2 = FPW;
    String str = FPX;
    EditText localEditText = paramFinderCreateContactUI.FPe;
    paramMenuItem = localEditText;
    if (localEditText == null)
    {
      kotlin.g.b.s.bIx("nickEdt");
      paramMenuItem = null;
    }
    boolean bool1;
    if (!kotlin.g.b.s.p(str, paramMenuItem.getText().toString()))
    {
      bool1 = true;
      paramMenuItem = as.GSQ;
      paramMenuItem = as.a.hu((Context)paramFinderCreateContactUI);
      if (paramMenuItem != null) {
        break label169;
      }
    }
    label169:
    for (paramMenuItem = localObject;; paramMenuItem = paramMenuItem.fou())
    {
      com.tencent.mm.plugin.finder.report.z.a(i, 0, j, false, k, m, n, bool2, bool1, paramMenuItem);
      paramFinderCreateContactUI.setResult(FQa);
      TC(2);
      paramFinderCreateContactUI.finish();
      AppMethodBeat.o(346929);
      return true;
      bool1 = false;
      break;
    }
  }
  
  private static final boolean a(FinderCreateContactUI paramFinderCreateContactUI, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(346876);
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    if (5 == paramInt)
    {
      paramTextView = paramFinderCreateContactUI.FPe;
      paramFinderCreateContactUI = paramTextView;
      if (paramTextView == null)
      {
        kotlin.g.b.s.bIx("nickEdt");
        paramFinderCreateContactUI = null;
      }
      paramFinderCreateContactUI.clearFocus();
    }
    AppMethodBeat.o(346876);
    return false;
  }
  
  private static void aAY(String paramString)
  {
    AppMethodBeat.i(346711);
    avl localavl1 = new avl();
    avl localavl2 = new avl();
    String str = FPM;
    int i;
    if (kotlin.g.b.s.p(str, "female"))
    {
      localavl1.sex = 2;
      i = 0;
      if (!kotlin.g.b.s.p(FPQ, "unshow")) {
        break label133;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramString = new br(FPL, "", paramString, localavl1, i, j, localavl2, FPW);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
      AppMethodBeat.o(346711);
      return;
      if (kotlin.g.b.s.p(str, "male"))
      {
        localavl1.sex = 1;
        i = 0;
        break;
      }
      localavl1.sex = 0;
      i = 1;
      break;
      label133:
      localavl1.country = FPQ;
      localavl1.province = FPR;
      localavl1.city = FPS;
    }
  }
  
  private final void am(String paramString1, final String paramString2, final String paramString3)
  {
    Object localObject1 = null;
    AppMethodBeat.i(346639);
    Log.i(this.TAG, kotlin.g.b.s.X("showError ", paramString1));
    Object localObject2 = com.tencent.mm.plugin.findersdk.a.k.PATTERN.matcher((CharSequence)paramString1);
    if (((Matcher)localObject2).find())
    {
      String str1 = ((Matcher)localObject2).group(1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (((Matcher)localObject2).start(0) > 0)
      {
        i = ((Matcher)localObject2).start(0);
        if (paramString1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(346639);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        kotlin.g.b.s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(str2);
      }
      localStringBuilder.append(str1);
      if (((Matcher)localObject2).end(0) < paramString1.length())
      {
        i = ((Matcher)localObject2).end(0);
        j = paramString1.length();
        if (paramString1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(346639);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        kotlin.g.b.s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      kotlin.g.b.s.s(paramString1, "sb.toString()");
      int i = ((Matcher)localObject2).start(0);
      int j = str1.length();
      localObject2 = new SpannableString((CharSequence)paramString1);
      kotlin.g.b.s.s(str1, "content");
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.plugin.finder.view.q(str1, getContext().getResources().getColor(e.b.Link), getContext().getResources().getColor(e.b.Link_Alpha_0_6), (kotlin.g.a.b)new g(this, paramString2, paramString3)), i, i + j, 17);
      paramString1 = this.FPt;
      if (paramString1 == null)
      {
        kotlin.g.b.s.bIx("topErrorTip");
        paramString1 = null;
        paramString1.setText((CharSequence)localObject2);
        paramString2 = this.FPt;
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          kotlin.g.b.s.bIx("topErrorTip");
          paramString1 = null;
        }
        a(paramString1, (Spannable)localObject2);
        label372:
        paramString1 = this.FPt;
        if (paramString1 != null) {
          break label435;
        }
        kotlin.g.b.s.bIx("topErrorTip");
        paramString1 = localObject1;
      }
    }
    label435:
    for (;;)
    {
      paramString1.setVisibility(0);
      AppMethodBeat.o(346639);
      return;
      break;
      paramString3 = this.FPt;
      paramString2 = paramString3;
      if (paramString3 == null)
      {
        kotlin.g.b.s.bIx("topErrorTip");
        paramString2 = null;
      }
      paramString2.setText((CharSequence)paramString1);
      break label372;
    }
  }
  
  private final void an(String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    AppMethodBeat.i(178431);
    RegionCodeDecoder.jcF();
    String str2 = RegionCodeDecoder.getLocName(paramString1);
    RegionCodeDecoder.jcF();
    String str1 = RegionCodeDecoder.pL(paramString1, paramString2);
    RegionCodeDecoder.jcF();
    paramString2 = RegionCodeDecoder.bJ(paramString1, paramString2, paramString3);
    if (!Util.isNullOrNil(paramString2))
    {
      paramString1 = this.FPg;
      if (paramString1 == null)
      {
        kotlin.g.b.s.bIx("districtTV");
        paramString1 = null;
        paramString1.setText((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).IF(str1) + ' ' + paramString2));
        paramString1 = this.FPm;
        if (paramString1 != null) {
          break label152;
        }
        kotlin.g.b.s.bIx("districtLayout");
        paramString1 = localObject1;
      }
      label152:
      for (;;)
      {
        paramString1.setVisibility(0);
        AppMethodBeat.o(178431);
        return;
        break;
      }
    }
    if (!Util.isNullOrNil(str1))
    {
      paramString2 = this.FPg;
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        kotlin.g.b.s.bIx("districtTV");
        paramString1 = null;
      }
      paramString1.setText((CharSequence)(str2 + ' ' + str1));
      paramString1 = this.FPm;
      if (paramString1 == null)
      {
        kotlin.g.b.s.bIx("districtLayout");
        paramString1 = localObject2;
      }
      for (;;)
      {
        paramString1.setVisibility(0);
        AppMethodBeat.o(178431);
        return;
      }
    }
    if (!Util.isNullOrNil(str2))
    {
      paramString2 = this.FPg;
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        kotlin.g.b.s.bIx("districtTV");
        paramString1 = null;
      }
      paramString1.setText((CharSequence)str2);
      paramString1 = this.FPm;
      if (paramString1 == null)
      {
        kotlin.g.b.s.bIx("districtLayout");
        paramString1 = localObject3;
      }
      for (;;)
      {
        paramString1.setVisibility(0);
        AppMethodBeat.o(178431);
        return;
      }
    }
    paramString1 = this.FPm;
    if (paramString1 == null)
    {
      kotlin.g.b.s.bIx("districtLayout");
      paramString1 = localObject4;
    }
    for (;;)
    {
      paramString1.setVisibility(8);
      AppMethodBeat.o(178431);
      return;
    }
  }
  
  private static final void b(FinderCreateContactUI paramFinderCreateContactUI, View paramView)
  {
    AppMethodBeat.i(346864);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderCreateContactUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    Log.i(paramFinderCreateContactUI.TAG, "doClick create contact btn");
    paramView = paramFinderCreateContactUI.AwM;
    if (paramView == null) {}
    for (paramView = null; paramView == null; paramView = ah.aiuX)
    {
      Log.i(paramFinderCreateContactUI.TAG, "doClick create contact btn,prepareResp = null");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346864);
      return;
      localObject1 = ad.Ghf;
      localObject1 = paramFinderCreateContactUI.getContext();
      kotlin.g.b.s.s(localObject1, "context");
      if (!ad.a((Context)localObject1, paramView, (kotlin.g.a.a)new c(paramFinderCreateContactUI)))
      {
        Log.i(paramFinderCreateContactUI.TAG, "doClick create contact btn,bind phone return");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(346864);
        return;
      }
    }
    localObject2 = new dd();
    localObject1 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    ((dd)localObject2).ijk = ((dd)localObject2).F("SessionId", paramView, true);
    ((dd)localObject2).iyS = paramFinderCreateContactUI.FPB;
    Object localObject3 = paramFinderCreateContactUI.getString(e.h.avatar_desc);
    kotlin.g.b.s.s(localObject3, "getString(R.string.avatar_desc)");
    String str = paramFinderCreateContactUI.getString(e.h.finder_nickname);
    kotlin.g.b.s.s(str, "getString(R.string.finder_nickname)");
    kotlin.g.b.s.s(paramFinderCreateContactUI.getString(e.h.settings_sex), "getString(R.string.settings_sex)");
    localObject1 = paramFinderCreateContactUI.AmC;
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    pZp = paramView;
    localObject1 = paramFinderCreateContactUI.FPe;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("nickEdt");
      paramView = null;
    }
    paramView = paramView.getText();
    int i;
    if (paramView == null)
    {
      paramView = "";
      FPL = paramView;
      FPW = paramFinderCreateContactUI.faQ().afTT;
      paramView = new ArrayList();
      if (g.bCx(FPL) > paramFinderCreateContactUI.FPD) {
        paramView.add(str);
      }
      localObject1 = new ArrayList();
      if (((CharSequence)pZp).length() != 0) {
        break label885;
      }
      i = 1;
      label450:
      if (i == 0) {
        break label890;
      }
      ((ArrayList)localObject1).add(localObject3);
      label462:
      if (((CharSequence)FPL).length() != 0) {
        break label899;
      }
      i = 1;
      label478:
      if (i == 0) {
        break label904;
      }
      ((ArrayList)localObject1).add(str);
      label490:
      if (((CharSequence)FPM).length() != 0) {
        break label913;
      }
      i = 1;
      label506:
      if (i == 0) {
        ((dd)localObject2).iyQ = 1L;
      }
      if (!Util.isNullOrNil(FPQ)) {
        ((dd)localObject2).iqE = 1L;
      }
      if (!paramView.isEmpty()) {
        break label1099;
      }
      if (!((ArrayList)localObject1).isEmpty()) {
        break label995;
      }
      localObject1 = paramFinderCreateContactUI.FPw;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("tipsCheckCB");
        paramView = null;
      }
      if (!paramView.isChecked()) {
        break label931;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 31L, 1L);
      Log.i(paramFinderCreateContactUI.TAG, "createContact avatarPath " + paramFinderCreateContactUI.AmC + " length=" + com.tencent.mm.vfs.y.bEl(pZp) / 1024L, new Object[] { pZp });
      paramView = com.tencent.mm.vfs.y.bub(pZp);
      int j = (int)com.tencent.mm.vfs.y.bEl(pZp);
      localObject1 = eQ(paramView, j);
      localObject3 = (String)FPY.get(localObject1);
      if (((CharSequence)localObject1).length() != 0) {
        break label918;
      }
      i = 1;
      label694:
      if ((i == 0) && (localObject3 != null)) {
        break label923;
      }
      localObject1 = pZp;
      localObject3 = dr.ADr;
      paramView = new dr((String)localObject1, dr.dWz(), paramView, j);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramView, 0);
      label740:
      paramFinderCreateContactUI.FPA = ((ProgressDialog)com.tencent.mm.ui.base.k.a((Context)paramFinderCreateContactUI, paramFinderCreateContactUI.getString(e.h.app_sending), true, null));
      ((dd)localObject2).iyK = 1L;
    }
    for (;;)
    {
      ((dd)localObject2).bMH();
      paramFinderCreateContactUI = paramFinderCreateContactUI.TAG;
      paramView = ((dd)localObject2).aIF();
      kotlin.g.b.s.s(paramView, "struct.toShowString()");
      Log.i(paramFinderCreateContactUI, kotlin.g.b.s.X("report19815 ", n.bV(paramView, "\r\n", " ")));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346864);
      return;
      paramView = paramView.toString();
      if (paramView == null)
      {
        paramView = "";
        break;
      }
      localObject1 = n.bq((CharSequence)paramView).toString();
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramView = "";
      break;
      label885:
      i = 0;
      break label450;
      label890:
      ((dd)localObject2).iyN = 1L;
      break label462;
      label899:
      i = 0;
      break label478;
      label904:
      ((dd)localObject2).iyO = 1L;
      break label490;
      label913:
      i = 0;
      break label506;
      label918:
      i = 0;
      break label694;
      label923:
      aAY((String)localObject3);
      break label740;
      label931:
      Log.i(paramFinderCreateContactUI.TAG, "not check agreement");
      paramView = paramFinderCreateContactUI.getString(e.h.finder_agreement_not_check_tip);
      kotlin.g.b.s.s(paramView, "getString(R.string.finder_agreement_not_check_tip)");
      paramFinderCreateContactUI.am(paramView, null, null);
      ((dd)localObject2).iyK = 2L;
      ((dd)localObject2).iyL = 3L;
      ((dd)localObject2).nh(paramFinderCreateContactUI.getString(e.h.finder_agreement_not_check_tip));
      continue;
      label995:
      Log.i(paramFinderCreateContactUI.TAG, kotlin.g.b.s.X("empty attr ", localObject1));
      paramView = Util.listToString((List)localObject1, paramFinderCreateContactUI.getString(e.h.finder_error_tips_splitor));
      localObject1 = paramFinderCreateContactUI.getString(e.h.finder_input_not_empty_tip, new Object[] { paramView });
      kotlin.g.b.s.s(localObject1, "getString(R.string.finde…_empty_tip, errorTypeStr)");
      paramFinderCreateContactUI.am((String)localObject1, null, null);
      ((dd)localObject2).iyK = 2L;
      ((dd)localObject2).iyL = 2L;
      ((dd)localObject2).nh(paramFinderCreateContactUI.getString(e.h.finder_input_not_empty_tip, new Object[] { paramView }));
      continue;
      label1099:
      paramView = Util.listToString((List)paramView, paramFinderCreateContactUI.getString(e.h.finder_error_tips_splitor));
      localObject1 = paramFinderCreateContactUI.getString(e.h.finder_input_too_long_tip, new Object[] { paramView });
      kotlin.g.b.s.s(localObject1, "getString(R.string.finde…o_long_tip, errorTypeStr)");
      paramFinderCreateContactUI.am((String)localObject1, null, null);
      ((dd)localObject2).iyK = 2L;
      ((dd)localObject2).iyL = 1L;
      ((dd)localObject2).nh(paramFinderCreateContactUI.getString(e.h.finder_input_too_long_tip, new Object[] { paramView }));
    }
  }
  
  private static final void c(FinderCreateContactUI paramFinderCreateContactUI, View paramView)
  {
    AppMethodBeat.i(346885);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCreateContactUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    paramView = paramFinderCreateContactUI.FPe;
    paramFinderCreateContactUI = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("nickEdt");
      paramFinderCreateContactUI = null;
    }
    paramFinderCreateContactUI.getText().clear();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346885);
  }
  
  private static final void d(FinderCreateContactUI paramFinderCreateContactUI, View paramView)
  {
    AppMethodBeat.i(347003);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCreateContactUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    paramView = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    paramFinderCreateContactUI = paramFinderCreateContactUI.getString(e.h.finder_sex_tip);
    kotlin.g.b.s.s(paramFinderCreateContactUI, "getString(R.string.finder_sex_tip)");
    com.tencent.mm.plugin.findersdk.d.a.aDg(paramFinderCreateContactUI);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347003);
  }
  
  private static final void e(FinderCreateContactUI paramFinderCreateContactUI, View paramView)
  {
    AppMethodBeat.i(347017);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderCreateContactUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderCreateContactUI, "this$0");
    paramView = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    paramFinderCreateContactUI = paramFinderCreateContactUI.getString(e.h.finder_location_tip_gps);
    kotlin.g.b.s.s(paramFinderCreateContactUI, "getString(R.string.finder_location_tip_gps)");
    com.tencent.mm.plugin.findersdk.d.a.aDg(paramFinderCreateContactUI);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(347017);
  }
  
  private static String eQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(346697);
    if (paramString != null)
    {
      paramString = paramString + '_' + paramInt;
      AppMethodBeat.o(346697);
      return paramString;
    }
    AppMethodBeat.o(346697);
    return "";
  }
  
  private final LinearLayout faP()
  {
    AppMethodBeat.i(346600);
    LinearLayout localLinearLayout = (LinearLayout)this.FPH.getValue();
    AppMethodBeat.o(346600);
    return localLinearLayout;
  }
  
  private final MMSwitchBtn faQ()
  {
    AppMethodBeat.i(346614);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)this.FPI.getValue();
    AppMethodBeat.o(346614);
    return localMMSwitchBtn;
  }
  
  private final void faR()
  {
    View localView2 = null;
    View localView1 = null;
    AppMethodBeat.i(167185);
    Object localObject = FPM;
    if (kotlin.g.b.s.p(localObject, "male"))
    {
      localObject = this.FPf;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("sexTV");
        localObject = null;
        ((TextView)localObject).setText((CharSequence)getString(e.h.sex_male));
        localObject = this.FPf;
        if (localObject != null) {
          break label150;
        }
        kotlin.g.b.s.bIx("sexTV");
        localObject = null;
        label72:
        ((TextView)localObject).setTextColor(com.tencent.mm.cd.a.w((Context)this, e.b.normal_text_color));
        if (!this.FPE) {
          break label308;
        }
        localView2 = this.FPk;
        localObject = localView2;
        if (localView2 == null)
        {
          kotlin.g.b.s.bIx("sexArrowIcon");
          localObject = null;
        }
        ((View)localObject).setVisibility(0);
        localObject = this.FPl;
        if (localObject != null) {
          break label305;
        }
        kotlin.g.b.s.bIx("sexInfoIcon");
        localObject = localView1;
      }
    }
    label150:
    label302:
    label305:
    for (;;)
    {
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(167185);
      return;
      break;
      break label72;
      if (kotlin.g.b.s.p(localObject, "female"))
      {
        localObject = this.FPf;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("sexTV");
          localObject = null;
          label180:
          ((TextView)localObject).setText((CharSequence)getString(e.h.sex_female));
          localObject = this.FPf;
          if (localObject != null) {
            break label231;
          }
          kotlin.g.b.s.bIx("sexTV");
          localObject = null;
        }
        label231:
        for (;;)
        {
          ((TextView)localObject).setTextColor(com.tencent.mm.cd.a.w((Context)this, e.b.normal_text_color));
          break;
          break label180;
        }
      }
      localObject = this.FPf;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("sexTV");
        localObject = null;
        label251:
        ((TextView)localObject).setText((CharSequence)getString(e.h.finder_settings_select_sex));
        localObject = this.FPf;
        if (localObject != null) {
          break label302;
        }
        kotlin.g.b.s.bIx("sexTV");
        localObject = null;
      }
      for (;;)
      {
        ((TextView)localObject).setTextColor(com.tencent.mm.cd.a.w((Context)this, e.b.hint_text_color));
        break;
        break label251;
      }
    }
    label308:
    localView1 = this.FPk;
    localObject = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("sexArrowIcon");
      localObject = null;
    }
    ((View)localObject).setVisibility(8);
    localObject = this.FPl;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("sexInfoIcon");
      localObject = localView2;
    }
    for (;;)
    {
      ((View)localObject).setOnClickListener(new FinderCreateContactUI..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(167185);
      return;
    }
  }
  
  private static boolean faS()
  {
    AppMethodBeat.i(346750);
    if (((CharSequence)FPQ).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label89;
      }
      if (((CharSequence)FPR).length() != 0) {
        break label79;
      }
      i = 1;
      label42:
      if (i == 0) {
        break label89;
      }
      if (((CharSequence)FPS).length() != 0) {
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
      AppMethodBeat.o(346750);
      return true;
      i = 0;
      break;
      i = 0;
      break label42;
    }
    label89:
    AppMethodBeat.o(346750);
    return false;
  }
  
  private final void setAvatar(String paramString)
  {
    AppMethodBeat.i(167187);
    if (!Util.isNullOrNil(paramString))
    {
      Bitmap localBitmap = BitmapUtil.extractThumbNail(paramString, 256, 256, false);
      if (localBitmap != null)
      {
        ImageView localImageView = this.pKM;
        paramString = localImageView;
        if (localImageView == null)
        {
          kotlin.g.b.s.bIx("avatarView");
          paramString = null;
        }
        paramString.setImageBitmap(localBitmap);
      }
    }
    AppMethodBeat.o(167187);
  }
  
  private final void uf(boolean paramBoolean)
  {
    Object localObject1 = null;
    View localView = null;
    AppMethodBeat.i(346742);
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).GJZ;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null)
        {
          localObject1 = (FinderCreateContactUI)this;
          FPQ = "unshow";
          FPR = "";
          FPS = "";
          localObject1 = ((FinderCreateContactUI)localObject1).FPm;
          if (localObject1 != null) {
            break label403;
          }
          kotlin.g.b.s.bIx("districtLayout");
          localObject1 = localView;
        }
      }
      label403:
      for (;;)
      {
        ((View)localObject1).setVisibility(8);
        FPO = 3;
        Log.i(this.TAG, "updateDistrict " + FPQ + ' ' + FPR + ' ' + FPS);
        AppMethodBeat.o(346742);
        return;
        Object localObject2 = ((cig)localObject1).pSo;
        kotlin.g.b.s.s(localObject2, "it.Country");
        FPQ = (String)localObject2;
        localObject2 = ((cig)localObject1).pSg;
        kotlin.g.b.s.s(localObject2, "it.Province");
        FPR = (String)localObject2;
        localObject2 = ((cig)localObject1).pSh;
        kotlin.g.b.s.s(localObject2, "it.City");
        FPS = (String)localObject2;
        localObject2 = ((cig)localObject1).pSo;
        kotlin.g.b.s.s(localObject2, "it.Country");
        FPT = (String)localObject2;
        localObject2 = ((cig)localObject1).pSg;
        kotlin.g.b.s.s(localObject2, "it.Province");
        FPU = (String)localObject2;
        localObject1 = ((cig)localObject1).pSh;
        kotlin.g.b.s.s(localObject1, "it.City");
        FPV = (String)localObject1;
        localObject2 = this.FPh;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("locationIcon");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(0);
        localObject2 = this.FPi;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("locationArrowIcon");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(0);
        localObject2 = this.FPj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("locationInfoIcon");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(8);
        localObject2 = this.FPj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("locationInfoIcon");
          localObject1 = null;
        }
        ((View)localObject1).setOnClickListener(new FinderCreateContactUI..ExternalSyntheticLambda2(this));
        FPO = 1;
        an(FPQ, FPR, FPS);
        localObject1 = ah.aiuX;
        break;
      }
    }
    localView = this.FPh;
    if (localView == null) {
      kotlin.g.b.s.bIx("locationIcon");
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(8);
      an(FPQ, FPR, FPS);
      break;
      localObject1 = localView;
    }
  }
  
  private static final void ug(boolean paramBoolean)
  {
    FPW = paramBoolean;
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(347496);
    int j;
    if (kotlin.g.b.s.p(paramString, com.tencent.mm.model.z.bAM()))
    {
      Log.i(this.TAG, "[notifyChanged] user:" + paramString + ",avatarPath:" + this.AmC);
      com.tencent.mm.modelavatar.q.bFp();
      paramString = AvatarStorage.Q(com.tencent.mm.model.z.bAM(), false);
      j = (int)com.tencent.mm.vfs.y.bEl(paramString);
      CharSequence localCharSequence = (CharSequence)this.AmC;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label134;
      }
    }
    label134:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (j > 0))
      {
        Log.i(this.TAG, kotlin.g.b.s.X("[notifyChanged] filesize:", Integer.valueOf(j)));
        this.AmC = paramString;
      }
      AppMethodBeat.o(347496);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_create_contact_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(167184);
    if (paramInt1 == this.BoG) {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.b.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.d((Activity)this, getIntent(), this.BoH);
      }
    }
    for (;;)
    {
      Xh();
      AppMethodBeat.o(167184);
      return;
      if (paramInt1 == this.BoH)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          this.AmC = paramIntent.getStringExtra("key_result_img_path");
          paramIntent = this.AmC;
          if (paramIntent != null) {
            pZp = paramIntent;
          }
          Log.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.y.bEl(this.AmC) / 1024L) });
          FPP = 2;
          setAvatar(this.AmC);
        }
      }
      else
      {
        Object localObject;
        if (paramInt1 == this.FPy)
        {
          if ((paramIntent != null) && (paramInt2 == -1))
          {
            localObject = paramIntent.getStringExtra("key_output_sex");
            paramIntent = (Intent)localObject;
            if (localObject == null) {
              paramIntent = "";
            }
            FPM = paramIntent;
            faR();
            FPN = 2;
          }
        }
        else if ((paramInt1 == this.FPz) && (paramIntent != null) && (paramInt2 == -1))
        {
          String str = paramIntent.getStringExtra("Country");
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          FPQ = (String)localObject;
          str = paramIntent.getStringExtra("Contact_Province");
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          FPR = (String)localObject;
          localObject = paramIntent.getStringExtra("Contact_City");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          FPS = paramIntent;
          uf(false);
          FPO = 2;
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    Object localObject2 = null;
    AppMethodBeat.i(167178);
    setResult(FQa);
    TC(2);
    super.onBackPressed();
    Object localObject1 = v.FrN;
    v.SA(5);
    localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    int i = this.scene;
    int j = FPP;
    int k = FPO;
    int m = FPN;
    int n = this.FPB;
    boolean bool2 = FPW;
    String str = FPX;
    EditText localEditText = this.FPe;
    localObject1 = localEditText;
    if (localEditText == null)
    {
      kotlin.g.b.s.bIx("nickEdt");
      localObject1 = null;
    }
    boolean bool1;
    if (!kotlin.g.b.s.p(str, ((EditText)localObject1).getText().toString()))
    {
      bool1 = true;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)this);
      if (localObject1 != null) {
        break label169;
      }
    }
    label169:
    for (localObject1 = localObject2;; localObject1 = ((as)localObject1).fou())
    {
      com.tencent.mm.plugin.finder.report.z.a(i, 0, j, false, k, m, n, bool2, bool1, (bui)localObject1);
      AppMethodBeat.o(167178);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onClickEditDistrict(View paramView)
  {
    AppMethodBeat.i(167177);
    EditText localEditText = this.FPe;
    paramView = localEditText;
    if (localEditText == null)
    {
      kotlin.g.b.s.bIx("nickEdt");
      paramView = null;
    }
    paramView.clearFocus();
    hideVKB();
    onInputPanelChange(false, 0);
    paramView = new Intent();
    paramView.putExtra("GetAddress", true);
    paramView.putExtra("ShowSelectedLocation", true);
    paramView.putExtra("SetSelectLocation", true);
    paramView.putExtra("SelectedCountryCode", FPQ);
    paramView.putExtra("SelectedProvinceCode", FPR);
    paramView.putExtra("SelectedCityCode", FPS);
    paramView.putExtra("NeedUnshowItem", false);
    com.tencent.mm.br.c.d((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, this.FPz);
    AppMethodBeat.o(167177);
  }
  
  public final void onClickEditSex(View paramView)
  {
    AppMethodBeat.i(167176);
    Object localObject = this.FPe;
    paramView = (View)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("nickEdt");
      paramView = null;
    }
    paramView.clearFocus();
    hideVKB();
    onInputPanelChange(false, 0);
    if (this.FPE)
    {
      paramView = new Intent();
      paramView.putExtra("key_input_sex", FPM);
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramView, this.FPy);
    }
    AppMethodBeat.o(167176);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    TextView localTextView2 = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(167175);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(e.b.white));
    getController().s((Activity)this, getResources().getColor(e.b.white));
    paramBundle = findViewById(e.e.scroll_container);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.scroll_container)");
    this.FPd = paramBundle;
    paramBundle = findViewById(e.e.finder_avatar_iv);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_avatar_iv)");
    this.pKM = ((ImageView)paramBundle);
    paramBundle = findViewById(e.e.finder_create_title);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_create_title)");
    this.titleTv = ((TextView)paramBundle);
    paramBundle = findViewById(e.e.finder_nick_tv);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_nick_tv)");
    this.FPe = ((EditText)paramBundle);
    paramBundle = findViewById(e.e.finder_sex_tv);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_sex_tv)");
    this.FPf = ((TextView)paramBundle);
    paramBundle = findViewById(e.e.finder_district_tv);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_district_tv)");
    this.FPg = ((TextView)paramBundle);
    paramBundle = findViewById(e.e.district_layout);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.district_layout)");
    this.FPm = paramBundle;
    paramBundle = findViewById(e.e.location_icon);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.location_icon)");
    this.FPh = paramBundle;
    paramBundle = findViewById(e.e.arrow_icon);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.arrow_icon)");
    this.FPi = paramBundle;
    paramBundle = findViewById(e.e.info_icon);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.info_icon)");
    this.FPj = paramBundle;
    paramBundle = findViewById(e.e.sex_arrow_icon);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.sex_arrow_icon)");
    this.FPk = paramBundle;
    paramBundle = findViewById(e.e.sex_info_icon);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.sex_info_icon)");
    this.FPl = paramBundle;
    paramBundle = findViewById(e.e.finder_contact_create_btn);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_contact_create_btn)");
    this.FPn = ((Button)paramBundle);
    paramBundle = findViewById(e.e.input_panel);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.input_panel)");
    this.FPr = ((InputPanelFrameLayout)paramBundle);
    paramBundle = findViewById(e.e.finder_input_container);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_input_container)");
    this.FPs = paramBundle;
    paramBundle = findViewById(e.e.edt_top_space);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.edt_top_space)");
    this.FPo = paramBundle;
    paramBundle = findViewById(e.e.edt_middle_space);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.edt_middle_space)");
    this.FPp = paramBundle;
    paramBundle = findViewById(e.e.edt_bottom_space);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.edt_bottom_space)");
    this.FPq = paramBundle;
    paramBundle = findViewById(e.e.top_error_tip);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.top_error_tip)");
    this.FPt = ((TextView)paramBundle);
    paramBundle = findViewById(e.e.finder_nickname_edit_limit);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_nickname_edit_limit)");
    this.FPu = ((TextView)paramBundle);
    paramBundle = findViewById(e.e.clear_text_btn);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.clear_text_btn)");
    this.FPv = paramBundle;
    Object localObject1 = this.FPv;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("clearNameBtn");
      paramBundle = null;
    }
    paramBundle.setVisibility(8);
    paramBundle = findViewById(e.e.tips_check_cb);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.tips_check_cb)");
    this.FPw = ((CheckBox)paramBundle);
    paramBundle = findViewById(e.e.tips_warning_tv);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.tips_warning_tv)");
    this.FPx = ((TextView)paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    Object localObject2;
    label878:
    int i;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eSw().bmg()).intValue() == 1)
    {
      faP().setVisibility(0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addO, Integer.valueOf(1));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addP, Integer.valueOf(1));
      Log.i(this.TAG, "showWxProfileTips set USERINFO_FINDER_WXPROFILE_ENTRY_EDU_INT_SYNC 1");
      ((LinearLayout)this.FPF.getValue()).setOnClickListener(new FinderCreateContactUI..ExternalSyntheticLambda5(this));
      localObject1 = this.FPn;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("createBtn");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(new FinderCreateContactUI..ExternalSyntheticLambda4(this));
      localObject2 = (TextWatcher)new d(this);
      localObject1 = this.FPe;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("nickEdt");
        paramBundle = null;
      }
      paramBundle.addTextChangedListener((TextWatcher)localObject2);
      localObject1 = this.FPe;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("nickEdt");
        paramBundle = null;
      }
      paramBundle.setOnEditorActionListener(new FinderCreateContactUI..ExternalSyntheticLambda8(this));
      localObject1 = this.FPv;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("clearNameBtn");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(new FinderCreateContactUI..ExternalSyntheticLambda1(this));
      localObject1 = this.FPe;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("nickEdt");
        paramBundle = null;
      }
      paramBundle.setOnFocusChangeListener(new FinderCreateContactUI..ExternalSyntheticLambda6(this));
      setBackBtn(new FinderCreateContactUI..ExternalSyntheticLambda0(this));
      paramBundle = this.FPr;
      if (paramBundle != null) {
        break label1689;
      }
      kotlin.g.b.s.bIx("inputPanel");
      paramBundle = null;
      paramBundle.setExternalListener((com.tencent.mm.ui.widget.c.a)this);
      localObject1 = this.FPd;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("scrollContainer");
        paramBundle = null;
      }
      paramBundle.post(new FinderCreateContactUI..ExternalSyntheticLambda11(this));
      if (FPL != null)
      {
        paramBundle = this.FPe;
        if (paramBundle != null) {
          break label1692;
        }
        kotlin.g.b.s.bIx("nickEdt");
        paramBundle = null;
        label944:
        paramBundle.setText((CharSequence)FPL);
      }
      if (((CharSequence)pZp).length() != 0) {
        break label1695;
      }
      i = 1;
      label970:
      if (i == 0) {
        break label1700;
      }
      localObject1 = this.pKM;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("avatarView");
        paramBundle = null;
      }
      a.b.g(paramBundle, com.tencent.mm.model.z.bAM());
      com.tencent.mm.modelavatar.q.bFp();
      this.AmC = AvatarStorage.Q(com.tencent.mm.model.z.bAM(), false);
      if ((int)com.tencent.mm.vfs.y.bEl(this.AmC) == 0)
      {
        Log.i(this.TAG, "WX avatar file size is zero");
        com.tencent.mm.modelavatar.q.bFp().a((AvatarStorage.a)this);
        this.AmC = "";
      }
      label1056:
      paramBundle = this.AmC;
      com.tencent.mm.modelavatar.q.bFp();
      if (!kotlin.g.b.s.p(paramBundle, AvatarStorage.Q(com.tencent.mm.model.z.bAM(), false))) {
        break label1718;
      }
      FPP = 1;
      label1083:
      if (((CharSequence)FPM).length() != 0) {
        break label1764;
      }
      i = 1;
      label1099:
      if (i == 0) {
        break label1795;
      }
      switch (com.tencent.mm.kernel.h.baE().ban().getInt(12290, 0))
      {
      default: 
        ((LinearLayout)this.FPG.getValue()).setVisibility(8);
        FPN = 3;
      }
    }
    for (;;)
    {
      faQ().setCheck(FPW);
      faQ().setSwitchListener(FinderCreateContactUI..ExternalSyntheticLambda9.INSTANCE);
      Log.i(this.TAG, kotlin.g.b.s.X("lastWxProfileChecked = ", Boolean.valueOf(FPW)));
      paramBundle = new ArrayList();
      localObject1 = am.aixg;
      localObject1 = String.format("https://" + WeChatHosts.domainString(e.h.host_weixin_qq_com) + "/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[] { LocaleUtil.getCurrentLanguage((Context)this) }, 1));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = am.aixg;
      localObject1 = String.format("https://" + WeChatHosts.domainString(e.h.host_weixin_qq_com) + "/cgi-bin/readtemplate?t=finder_privacy", Arrays.copyOf(new Object[0], 0));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(getString(e.h.finder_create_contact_agreement));
      ((ArrayList)localObject1).add(getString(e.h.finder_create_contact_privacy_pr));
      localObject2 = (Context)this;
      List localList1 = (List)paramBundle;
      String str = getString(e.h.finder_create_contact_warning);
      kotlin.g.b.s.s(str, "getString(R.string.finder_create_contact_warning)");
      List localList2 = (List)localObject1;
      localObject1 = this.FPx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("tipsWarningTV");
        paramBundle = null;
      }
      a((Context)localObject2, localList1, str, localList2, paramBundle, this.TAG);
      faR();
      Log.i(this.TAG, kotlin.g.b.s.X("isLastSelectDistrictEmpty = ", Boolean.valueOf(faS())));
      uf(faS());
      com.tencent.mm.kernel.h.aZW().a(3922, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a(3759, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
      this.FPB = getIntent().getIntExtra("key_create_scene", 0);
      this.FPC = getIntent().getIntExtra("key_mv_status", 0);
      this.FPJ = getIntent().getBooleanExtra("key_router_to_profile", true);
      this.FPK = getIntent().getIntExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 0);
      if (getIntent().hasExtra("key_prepare_resp"))
      {
        this.AwM = new bys();
        paramBundle = getIntent().getByteArrayExtra("key_prepare_resp");
        if (paramBundle == null) {}
      }
      try
      {
        localObject1 = this.AwM;
        if (localObject1 != null) {
          ((bys)localObject1).parseFrom(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = ah.aiuX;
        }
        this.FPD = ((Integer)paramBundle).intValue();
        paramBundle = this.AwM;
        if (paramBundle == null) {
          break label1877;
        }
        Log.i(this.TAG, kotlin.g.b.s.X("nicknameMaxLength ： ", Integer.valueOf(paramBundle.FPD)));
        if (paramBundle.FPD <= 0) {
          break label1877;
        }
        this.FPD = paramBundle.FPD;
        com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 30L, 1L);
        paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSx().bmg()).intValue() != 1) {
          break label1939;
        }
        new an().bFJ().a((com.tencent.mm.vending.e.b)this).g(new FinderCreateContactUI..ExternalSyntheticLambda10(this));
        switch (this.FPC)
        {
        }
      }
      paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.aday, Integer.valueOf(20));
      if (paramBundle != null) {
        break label1822;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(167175);
      throw paramBundle;
      faP().setVisibility(8);
      break;
      label1689:
      break label878;
      label1692:
      break label944;
      label1695:
      i = 0;
      break label970;
      label1700:
      this.AmC = pZp;
      setAvatar(this.AmC);
      break label1056;
      label1718:
      paramBundle = (CharSequence)this.AmC;
      if ((paramBundle == null) || (paramBundle.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1757;
        }
        FPP = 3;
        break;
      }
      label1757:
      FPP = 2;
      break label1083;
      label1764:
      i = 0;
      break label1099;
      FPM = "male";
      FPN = 1;
      continue;
      FPM = "female";
      FPN = 1;
      continue;
      label1795:
      Log.i(this.TAG, kotlin.g.b.s.X("lastSelectSex = ", FPM));
    }
    label1822:
    label1877:
    AppMethodBeat.o(167175);
    label1939:
    return;
    localTextView2 = this.titleTv;
    paramBundle = localTextView2;
    if (localTextView2 == null)
    {
      kotlin.g.b.s.bIx("titleTv");
      paramBundle = null;
    }
    paramBundle.setText(getResources().getText(e.h.finder_create_finder_mv_title));
    paramBundle = this.FPn;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("createBtn");
      paramBundle = localTextView1;
    }
    for (;;)
    {
      paramBundle.setText(getResources().getText(e.h.finder_create_contact_mv_save_confirm));
      AppMethodBeat.o(167175);
      return;
    }
    localTextView1 = this.titleTv;
    paramBundle = localTextView1;
    if (localTextView1 == null)
    {
      kotlin.g.b.s.bIx("titleTv");
      paramBundle = null;
    }
    paramBundle.setText(getResources().getText(e.h.finder_create_finder_mv_title));
    paramBundle = this.FPn;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("createBtn");
      paramBundle = localTextView2;
    }
    for (;;)
    {
      paramBundle.setText(getResources().getText(e.h.finder_create_contact_mv_post_confirm));
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167182);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3922, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3759, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    com.tencent.mm.modelavatar.q.bFp().b((AvatarStorage.a)this);
    AppMethodBeat.o(167182);
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167180);
    View localView2 = this.FPd;
    View localView1 = localView2;
    if (localView2 == null)
    {
      kotlin.g.b.s.bIx("scrollContainer");
      localView1 = null;
    }
    localView1.post(new FinderCreateContactUI..ExternalSyntheticLambda12(paramBoolean, this, paramInt));
    AppMethodBeat.o(167180);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347360);
    super.onResume();
    if (this.AwM == null)
    {
      di localdi = new di(15);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localdi, 0);
    }
    AppMethodBeat.o(347360);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(167183);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject;
    if ((paramp instanceof br))
    {
      paramString = this.FPA;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = ((br)paramp).dVC();
        if (paramp == null)
        {
          paramString = null;
          if (paramString == null) {
            TC(3);
          }
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)FinderCreateContactUI.e.FQc);
          AppMethodBeat.o(167183);
          return;
        }
        paramString = com.tencent.mm.plugin.finder.utils.z.GgY;
        com.tencent.mm.plugin.finder.utils.z.feX();
        paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramInt1 = this.scene;
        paramInt2 = FPP;
        int i = FPO;
        int j = FPN;
        int k = this.FPB;
        boolean bool2 = FPW;
        String str = FPX;
        localObject = this.FPe;
        paramString = (String)localObject;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("nickEdt");
          paramString = null;
        }
        boolean bool1;
        if (!kotlin.g.b.s.p(str, paramString.getText().toString()))
        {
          bool1 = true;
          label194:
          paramString = as.GSQ;
          paramString = as.a.hu((Context)this);
          if (paramString != null) {
            break label336;
          }
        }
        label336:
        for (paramString = null;; paramString = paramString.fou())
        {
          com.tencent.mm.plugin.finder.report.z.a(paramInt1, 1, paramInt2, true, i, j, k, bool2, bool1, paramString);
          com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 32L, 1L);
          paramString = new Intent();
          if (this.FPJ)
          {
            paramString.putExtra("finder_username", paramp.username);
            paramString.putExtra("KEY_FINDER_SELF_FLAG", true);
            localObject = as.GSQ;
            as.a.a((Context)this, paramString, 0L, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)this, paramString);
          }
          setResult(FPZ);
          finish();
          TC(1);
          paramString = paramp;
          break;
          bool1 = false;
          break label194;
        }
      }
      switch (paramInt2)
      {
      }
      for (;;)
      {
        paramString = c.c.b(((br)paramp).rr.otC);
        if (paramString != null) {
          break;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
        AppMethodBeat.o(167183);
        throw paramString;
        com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 37L, 1L);
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 38L, 1L);
      }
      localObject = ((awe)paramString).verifyInfo;
      if (localObject == null)
      {
        paramString = null;
        if (paramString == null)
        {
          paramString = (FinderCreateContactUI)this;
          paramp = paramString.getString(e.h.finder_create_contact_failed_tip);
          kotlin.g.b.s.s(paramp, "getString(R.string.finde…reate_contact_failed_tip)");
          paramString.am(paramp, null, null);
        }
        setResult(FQa);
        AppMethodBeat.o(167183);
        return;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("verify info: ", com.tencent.mm.ae.f.dg(localObject)));
      if (((bqt)localObject).ZYI == 1)
      {
        paramString = this.FPe;
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("nickEdt");
          paramString = null;
          label550:
          paramString.setTextColor(com.tencent.mm.cd.a.w((Context)this, e.b.red));
        }
      }
      else
      {
        if (Util.isNullOrNil(((bqt)localObject).ZYF)) {
          break label619;
        }
        paramp = ((bqt)localObject).ZYF;
        paramString = paramp;
        if (paramp == null) {
          paramString = "";
        }
        am(paramString, ((bqt)localObject).ZYK, ((bqt)localObject).ZYJ);
      }
      for (;;)
      {
        paramString = ah.aiuX;
        break;
        break label550;
        label619:
        paramString = getString(e.h.finder_create_contact_failed_tip);
        kotlin.g.b.s.s(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
        am(paramString, null, null);
      }
    }
    if ((paramp instanceof dr))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((dr)paramp).ADt;
        localObject = ((dr)paramp).fileMD5;
        paramInt1 = ((dr)paramp).osy;
        if (paramString != null)
        {
          paramp = eQ((String)localObject, paramInt1);
          if (((CharSequence)paramp).length() <= 0) {
            break label745;
          }
        }
        label745:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            ((Map)FPY).put(paramp, paramString);
          }
          aAY(paramString);
          AppMethodBeat.o(167183);
          return;
        }
      }
      paramString = this.FPA;
      if (paramString != null) {
        paramString.dismiss();
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 33L, 1L);
      paramString = getString(e.h.finder_create_contact_failed_tip);
      kotlin.g.b.s.s(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
      am(paramString, null, null);
      AppMethodBeat.o(167183);
      return;
    }
    if ((paramp instanceof di)) {
      this.AwM = ((di)paramp).dVy();
    }
    AppMethodBeat.o(167183);
  }
  
  public final void onTipsCheckBoxClick(View paramView)
  {
    Object localObject = null;
    AppMethodBeat.i(347394);
    CheckBox localCheckBox = this.FPw;
    paramView = localCheckBox;
    if (localCheckBox == null)
    {
      kotlin.g.b.s.bIx("tipsCheckCB");
      paramView = null;
    }
    localCheckBox = this.FPw;
    if (localCheckBox == null)
    {
      kotlin.g.b.s.bIx("tipsCheckCB");
      if (localObject.isChecked()) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(347394);
      return;
      localObject = localCheckBox;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(347262);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(e.class);
    AppMethodBeat.o(347262);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    b(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements TextWatcher
  {
    d(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      Object localObject1 = null;
      AppMethodBeat.i(167168);
      Object localObject2 = FinderCreateContactUI.b(this.FQb);
      paramEditable = (Editable)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("nickEdt");
        paramEditable = null;
      }
      com.tencent.mm.ui.tools.b.c.i(paramEditable).oF(1, FinderCreateContactUI.c(this.FQb)).b(g.a.afII).Nc(true).a((com.tencent.mm.ui.tools.b.c.a)new a(this.FQb));
      paramEditable = FinderCreateContactUI.FPc;
      localObject2 = FinderCreateContactUI.b(this.FQb);
      paramEditable = (Editable)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("nickEdt");
        paramEditable = null;
      }
      paramEditable = paramEditable.getText();
      if (paramEditable == null)
      {
        paramEditable = "";
        kotlin.g.b.s.u(paramEditable, "<set-?>");
        FinderCreateContactUI.aAZ(paramEditable);
        paramEditable = FinderCreateContactUI.b(this.FQb);
        if (paramEditable != null) {
          break label197;
        }
        kotlin.g.b.s.bIx("nickEdt");
        paramEditable = localObject1;
      }
      label197:
      for (;;)
      {
        paramEditable.setTextColor(com.tencent.mm.cd.a.w((Context)this.FQb, e.b.normal_text_color));
        AppMethodBeat.o(167168);
        return;
        paramEditable = paramEditable.toString();
        if (paramEditable == null)
        {
          paramEditable = "";
          break;
        }
        localObject2 = n.bq((CharSequence)paramEditable).toString();
        paramEditable = (Editable)localObject2;
        if (localObject2 != null) {
          break;
        }
        paramEditable = "";
        break;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.ui.tools.b.c.a
    {
      a(FinderCreateContactUI paramFinderCreateContactUI) {}
      
      public final void Tw(String paramString)
      {
        Object localObject2 = null;
        Object localObject1 = null;
        AppMethodBeat.i(167167);
        int i = g.ej(FinderCreateContactUI.c(this.FQb), paramString);
        paramString = FinderCreateContactUI.d(this.FQb);
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("editNickNameLimit");
          paramString = null;
          paramString.setText((CharSequence)String.valueOf(i));
          TextView localTextView = FinderCreateContactUI.d(this.FQb);
          paramString = localTextView;
          if (localTextView == null)
          {
            kotlin.g.b.s.bIx("editNickNameLimit");
            paramString = null;
          }
          paramString.setTextColor(this.FQb.getResources().getColor(e.b.BW_0_Alpha_0_3));
          if (i > kotlin.k.k.qu((int)(FinderCreateContactUI.c(this.FQb) * 0.1F), 1)) {
            break label156;
          }
          paramString = FinderCreateContactUI.d(this.FQb);
          if (paramString != null) {
            break label153;
          }
          kotlin.g.b.s.bIx("editNickNameLimit");
          paramString = localObject1;
        }
        label153:
        for (;;)
        {
          paramString.setVisibility(0);
          FinderCreateContactUI.e(this.FQb);
          AppMethodBeat.o(167167);
          return;
          break;
        }
        label156:
        paramString = FinderCreateContactUI.d(this.FQb);
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("editNickNameLimit");
          paramString = localObject2;
        }
        for (;;)
        {
          paramString.setVisibility(4);
          break;
        }
      }
      
      public final void Tx(String paramString)
      {
        Object localObject = null;
        AppMethodBeat.i(347195);
        paramString = FinderCreateContactUI.d(this.FQb);
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("editNickNameLimit");
          paramString = null;
          paramString.setText((CharSequence)String.valueOf(FinderCreateContactUI.c(this.FQb)));
          paramString = FinderCreateContactUI.d(this.FQb);
          if (paramString != null) {
            break label88;
          }
          kotlin.g.b.s.bIx("editNickNameLimit");
          paramString = localObject;
        }
        label88:
        for (;;)
        {
          paramString.setTextColor(this.FQb.getResources().getColor(e.b.BW_0_Alpha_0_3));
          AppMethodBeat.o(347195);
          return;
          break;
        }
      }
      
      public final void eY(String paramString)
      {
        Object localObject2 = null;
        AppMethodBeat.i(167166);
        Object localObject1 = FinderCreateContactUI.d(this.FQb);
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("editNickNameLimit");
          localObject1 = null;
          ((TextView)localObject1).setText((CharSequence)String.valueOf(g.ej(FinderCreateContactUI.c(this.FQb), paramString)));
          localObject1 = FinderCreateContactUI.d(this.FQb);
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("editNickNameLimit");
            paramString = null;
          }
          paramString.setVisibility(0);
          paramString = FinderCreateContactUI.d(this.FQb);
          if (paramString != null) {
            break label145;
          }
          kotlin.g.b.s.bIx("editNickNameLimit");
          paramString = localObject2;
        }
        label145:
        for (;;)
        {
          paramString.setTextColor(this.FQb.getResources().getColor(e.b.Red_100));
          paramString = this.FQb;
          localObject1 = this.FQb.getString(e.h.finder_nickname_too_long_tip);
          kotlin.g.b.s.s(localObject1, "getString(R.string.finder_nickname_too_long_tip)");
          FinderCreateContactUI.a(paramString, (String)localObject1);
          AppMethodBeat.o(167166);
          return;
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    f(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    g(FinderCreateContactUI paramFinderCreateContactUI, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    i(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<MMSwitchBtn>
  {
    j(FinderCreateContactUI paramFinderCreateContactUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI
 * JD-Core Version:    0.7.0.1
 */