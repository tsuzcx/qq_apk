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
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hh;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.k;
import d.g.b.z;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_CODE_SELECT_DISTRICT", "REQUEST_CODE_SELECT_SEX", "TAG", "", "avatarPath", "avatarView", "Landroid/widget/ImageView;", "cameraContainer", "Landroid/view/View;", "canSelectSex", "", "createBtn", "Landroid/widget/Button;", "districtLayout", "districtTV", "Landroid/widget/TextView;", "editBottomSpace", "editMiddleSpace", "editNickNameLimit", "editSignatureLimit", "editTopSpace", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "locationArrowIcon", "locationIcon", "locationInfoIcon", "nickEdt", "Landroid/widget/EditText;", "nicknameMaxLength", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollContainer", "scrollViewOriginHeight", "sexArrowIcon", "sexInfoIcon", "sexTV", "signatureEdt", "signatureMaxLength", "tipsCheckCB", "Landroid/widget/CheckBox;", "tipsWarningTV", "topErrorTip", "createContact", "", "getLayoutId", "hideError", "initContentView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickEditDistrict", "view", "onClickEditSex", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTipsCheckBoxClick", "setAvatar", "path", "setDistrictTV", "countryCodeName", "provinceCodeName", "cityCodeName", "setSpanTouch", "descTv", "text", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "spanLinks", "context", "Landroid/content/Context;", "h5urlList", "", "allText", "linkTextList", "logTag", "updateDistrict", "updateSex", "Companion", "plugin-finder_release"})
public final class FinderCreateContactUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, b.a
{
  private static String irO;
  private static String qLG;
  private static String qLH;
  private static String qLI;
  private static String qLJ;
  private static String qLK;
  private static String qLL;
  public static final a qLM;
  private View KXP;
  private View KXQ;
  private View KXR;
  private View KXS;
  private CheckBox KXT;
  private TextView KXU;
  private int KXV = 20;
  private int KXW = 400;
  private boolean KXX = true;
  private final String TAG = "Finder.FinderCreateContactUI";
  private HashMap _$_findViewCache;
  private ImageView ida;
  private alv qBp;
  private final int qLA = 1000;
  private final int qLB = 1001;
  private final int qLC = 1002;
  private final int qLD = 1003;
  private ProgressDialog qLE;
  private int qLF;
  private View qLd;
  private EditText qLe;
  private EditText qLf;
  private TextView qLg;
  private TextView qLh;
  private View qLi;
  private View qLl;
  private Button qLm;
  private View qLn;
  private View qLo;
  private View qLp;
  private InputPanelFrameLayout qLq;
  private View qLr;
  private View qLs;
  private TextView qLt;
  private TextView qLu;
  private TextView qLv;
  private String qjl;
  private int scene;
  
  static
  {
    AppMethodBeat.i(167188);
    qLM = new a((byte)0);
    irO = "";
    qLG = "";
    qLH = "";
    qLI = "";
    qLJ = "";
    qLK = "";
    qLL = "";
    AppMethodBeat.o(167188);
  }
  
  private final void Z(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178431);
    RegionCodeDecoder.eMO();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.eMO();
    String str2 = RegionCodeDecoder.lf(paramString1, paramString2);
    RegionCodeDecoder.eMO();
    paramString1 = RegionCodeDecoder.aU(paramString1, paramString2, paramString3);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = this.qLh;
      if (paramString2 == null) {
        k.aPZ("districtTV");
      }
      paramString2.setText((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sj(str2) + " " + paramString1));
      paramString1 = this.qLl;
      if (paramString1 == null) {
        k.aPZ("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bt.isNullOrNil(str2))
    {
      paramString1 = this.qLh;
      if (paramString1 == null) {
        k.aPZ("districtTV");
      }
      paramString1.setText((CharSequence)(str1 + ' ' + str2));
      paramString1 = this.qLl;
      if (paramString1 == null) {
        k.aPZ("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bt.isNullOrNil(str1))
    {
      paramString1 = this.qLh;
      if (paramString1 == null) {
        k.aPZ("districtTV");
      }
      paramString1.setText((CharSequence)str1);
      paramString1 = this.qLl;
      if (paramString1 == null) {
        k.aPZ("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    paramString1 = this.qLl;
    if (paramString1 == null) {
      k.aPZ("districtLayout");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(178431);
  }
  
  private void a(Context paramContext, List<String> paramList1, String paramString1, List<String> paramList2, TextView paramTextView, String paramString2)
  {
    AppMethodBeat.i(199131);
    k.h(paramContext, "context");
    k.h(paramList1, "h5urlList");
    k.h(paramString1, "allText");
    k.h(paramList2, "linkTextList");
    k.h(paramTextView, "descTv");
    k.h(paramString2, "logTag");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString1);
    paramList2 = ((Iterable)paramList2).iterator();
    int i = 0;
    while (paramList2.hasNext())
    {
      Object localObject = paramList2.next();
      if (i < 0) {
        j.fvx();
      }
      localObject = (String)localObject;
      int j = d.n.n.a((CharSequence)paramString1, (String)localObject, 0, false, 6);
      int k = j + ((String)localObject).length();
      if ((j >= 0) && (k <= paramString1.length()))
      {
        localObject = (String)paramList1.get(i);
        Context localContext = aj.getContext();
        k.g(localContext, "MMApplicationContext.getContext()");
        int m = localContext.getResources().getColor(2131100547);
        localContext = aj.getContext();
        k.g(localContext, "MMApplicationContext.getContext()");
        localSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.e((String)localObject, m, localContext.getResources().getColor(2131099658), (d.g.a.b)new FinderCreateContactUI.l(paramString1, localSpannableString, paramList1, paramString2, paramContext)), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText((CharSequence)localSpannableString);
    a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(199131);
  }
  
  private void a(final TextView paramTextView, final Spannable paramSpannable)
  {
    AppMethodBeat.i(199130);
    k.h(paramTextView, "descTv");
    k.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new i(this, paramSpannable, paramTextView));
    AppMethodBeat.o(199130);
  }
  
  private final void bg(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(199128);
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = com.tencent.mm.plugin.i.a.l.iyI.matcher((CharSequence)paramString1);
    if (((Matcher)localObject).find())
    {
      String str1 = ((Matcher)localObject).group(1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (((Matcher)localObject).start(0) > 0)
      {
        i = ((Matcher)localObject).start(0);
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199128);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        k.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(str2);
      }
      localStringBuilder.append(str1);
      if (((Matcher)localObject).end(0) < paramString1.length())
      {
        i = ((Matcher)localObject).end(0);
        j = paramString1.length();
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199128);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        k.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      k.g(paramString1, "sb.toString()");
      int i = ((Matcher)localObject).start(0);
      int j = str1.length();
      paramString1 = new SpannableString((CharSequence)paramString1);
      k.g(str1, "content");
      localObject = getContext();
      k.g(localObject, "context");
      int k = ((AppCompatActivity)localObject).getResources().getColor(2131099769);
      localObject = getContext();
      k.g(localObject, "context");
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.e(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099776), false, (d.g.a.b)new j(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.qLt;
      if (paramString2 == null) {
        k.aPZ("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.qLt;
      if (paramString2 == null) {
        k.aPZ("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.qLt;
      if (paramString1 == null) {
        k.aPZ("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(199128);
      return;
      paramString2 = this.qLt;
      if (paramString2 == null) {
        k.aPZ("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
    }
  }
  
  private final void cqU()
  {
    AppMethodBeat.i(167185);
    Object localObject = qLI;
    switch (((String)localObject).hashCode())
    {
    default: 
      localObject = this.qLg;
      if (localObject == null) {
        k.aPZ("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759351));
      localObject = this.qLg;
      if (localObject == null) {
        k.aPZ("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cd.a.n((Context)this, 2131100490));
    }
    for (;;)
    {
      if (!this.KXX) {
        break label295;
      }
      localObject = this.KXR;
      if (localObject == null) {
        k.aPZ("sexArrowIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.KXS;
      if (localObject == null) {
        k.aPZ("sexInfoIcon");
      }
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(167185);
      return;
      if (!((String)localObject).equals("female")) {
        break;
      }
      localObject = this.qLg;
      if (localObject == null) {
        k.aPZ("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763532));
      localObject = this.qLg;
      if (localObject == null) {
        k.aPZ("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cd.a.n((Context)this, 2131100711));
      continue;
      if (!((String)localObject).equals("male")) {
        break;
      }
      localObject = this.qLg;
      if (localObject == null) {
        k.aPZ("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763533));
      localObject = this.qLg;
      if (localObject == null) {
        k.aPZ("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cd.a.n((Context)this, 2131100711));
    }
    label295:
    localObject = this.KXR;
    if (localObject == null) {
      k.aPZ("sexArrowIcon");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.KXS;
    if (localObject == null) {
      k.aPZ("sexInfoIcon");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.KXS;
    if (localObject == null) {
      k.aPZ("sexInfoIcon");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new FinderCreateContactUI.m(this));
    AppMethodBeat.o(167185);
  }
  
  private final void cqV()
  {
    AppMethodBeat.i(167186);
    Object localObject = this.qLh;
    if (localObject == null) {
      k.aPZ("districtTV");
    }
    ((TextView)localObject).setTextColor(com.tencent.mm.cd.a.n((Context)this, 2131100711));
    localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class)).LgS;
    if (localObject != null)
    {
      String str = ((asx)localObject).ijV;
      k.g(str, "it.Country");
      qLJ = str;
      str = ((asx)localObject).ijN;
      k.g(str, "it.Province");
      qLK = str;
      localObject = ((asx)localObject).ijO;
      k.g(localObject, "it.City");
      qLL = (String)localObject;
      localObject = this.qLi;
      if (localObject == null) {
        k.aPZ("locationIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.KXP;
      if (localObject == null) {
        k.aPZ("locationArrowIcon");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.KXQ;
      if (localObject == null) {
        k.aPZ("locationInfoIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.KXQ;
      if (localObject == null) {
        k.aPZ("locationInfoIcon");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new k(this));
      Z(qLJ, qLK, qLL);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "updateDistrict " + qLJ + ' ' + qLK + ' ' + qLL);
      AppMethodBeat.o(167186);
      return;
      localObject = (FinderCreateContactUI)this;
      qLJ = "unshow";
      qLK = "";
      qLL = "";
      localObject = ((FinderCreateContactUI)localObject).qLl;
      if (localObject == null) {
        k.aPZ("districtLayout");
      }
      ((View)localObject).setVisibility(8);
    }
  }
  
  private final void setAvatar(String paramString)
  {
    AppMethodBeat.i(167187);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.sdk.platformtools.f.e(paramString, 256, 256, false);
      if (paramString != null)
      {
        Object localObject = this.ida;
        if (localObject == null) {
          k.aPZ("avatarView");
        }
        ((ImageView)localObject).setImageBitmap(paramString);
        paramString = this.qLs;
        if (paramString == null) {
          k.aPZ("cameraContainer");
        }
        paramString = paramString.getLayoutParams();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(167187);
          throw paramString;
        }
        paramString = (FrameLayout.LayoutParams)paramString;
        paramString.gravity = 80;
        localObject = this.qLs;
        if (localObject == null) {
          k.aPZ("cameraContainer");
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramString);
        paramString = this.qLs;
        if (paramString == null) {
          k.aPZ("cameraContainer");
        }
        paramString.setBackgroundColor(getResources().getColor(2131099734));
        AppMethodBeat.o(167187);
        return;
      }
    }
    AppMethodBeat.o(167187);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199133);
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
    AppMethodBeat.o(199133);
    return localView1;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167180);
    if (paramBoolean)
    {
      localObject = this.qLd;
      if (localObject == null) {
        k.aPZ("scrollContainer");
      }
      localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((FrameLayout.LayoutParams)localObject).height = (this.qLF - paramInt);
      localView = this.qLd;
      if (localView == null) {
        k.aPZ("scrollContainer");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.qLn;
      if (localObject == null) {
        k.aPZ("editTopSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cd.a.ao((Context)this, 2131165289);
      localView = this.qLn;
      if (localView == null) {
        k.aPZ("editTopSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.qLo;
      if (localObject == null) {
        k.aPZ("editMiddleSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cd.a.ao((Context)this, 2131165302);
      localView = this.qLo;
      if (localView == null) {
        k.aPZ("editMiddleSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.qLp;
      if (localObject == null) {
        k.aPZ("editBottomSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cd.a.ao((Context)this, 2131165289);
      localView = this.qLp;
      if (localView == null) {
        k.aPZ("editBottomSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(167180);
      return;
    }
    Object localObject = this.qLd;
    if (localObject == null) {
      k.aPZ("scrollContainer");
    }
    localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((FrameLayout.LayoutParams)localObject).height = this.qLF;
    View localView = this.qLd;
    if (localView == null) {
      k.aPZ("scrollContainer");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.qLn;
    if (localObject == null) {
      k.aPZ("editTopSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cd.a.ao((Context)this, 2131165301);
    localView = this.qLn;
    if (localView == null) {
      k.aPZ("editTopSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.qLo;
    if (localObject == null) {
      k.aPZ("editMiddleSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = -2;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localView = this.qLo;
    if (localView == null) {
      k.aPZ("editMiddleSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.qLp;
    if (localObject == null) {
      k.aPZ("editBottomSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cd.a.ao((Context)this, 2131165277);
    localView = this.qLp;
    if (localView == null) {
      k.aPZ("editBottomSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(167180);
  }
  
  public final int getLayoutId()
  {
    return 2131494024;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(167184);
    if (paramInt1 == this.qLA)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.apW());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.qLB);
        AppMethodBeat.o(167184);
      }
    }
    else if (paramInt1 == this.qLB)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        this.qjl = paramIntent.getStringExtra("key_result_img_path");
        paramIntent = this.qjl;
        if (paramIntent != null) {
          irO = paramIntent;
        }
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(i.aMN(this.qjl) / 1024L) });
        setAvatar(this.qjl);
        AppMethodBeat.o(167184);
      }
    }
    else
    {
      Object localObject;
      if (paramInt1 == this.qLC)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          localObject = paramIntent.getStringExtra("key_output_sex");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          qLI = paramIntent;
          cqU();
          AppMethodBeat.o(167184);
        }
      }
      else if ((paramInt1 == this.qLD) && (paramIntent != null) && (paramInt2 == -1))
      {
        String str = paramIntent.getStringExtra("Country");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        qLJ = (String)localObject;
        str = paramIntent.getStringExtra("Contact_Province");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        qLK = (String)localObject;
        localObject = paramIntent.getStringExtra("Contact_City");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        qLL = paramIntent;
        cqV();
      }
    }
    AppMethodBeat.o(167184);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167178);
    super.onBackPressed();
    Object localObject = com.tencent.mm.plugin.finder.report.a.qFo;
    com.tencent.mm.plugin.finder.report.a.CL(5);
    localObject = com.tencent.mm.plugin.finder.report.b.qFq;
    com.tencent.mm.plugin.finder.report.b.a(this.scene, false, false, false);
    AppMethodBeat.o(167178);
  }
  
  public final void onClickEditDistrict(View paramView)
  {
    AppMethodBeat.i(167177);
    paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cqd() == 1)
    {
      paramView = this.qLe;
      if (paramView == null) {
        k.aPZ("nickEdt");
      }
      paramView.clearFocus();
      paramView = this.qLf;
      if (paramView == null) {
        k.aPZ("signatureEdt");
      }
      paramView.clearFocus();
      hideVKB();
      g(false, 0);
      paramView = new Intent();
      paramView.putExtra("GetAddress", true);
      paramView.putExtra("ShowSelectedLocation", true);
      paramView.putExtra("SetSelectLocation", true);
      paramView.putExtra("SelectedCountryCode", qLJ);
      paramView.putExtra("SelectedProvinceCode", qLK);
      paramView.putExtra("SelectedCityCode", qLL);
      paramView.putExtra("NeedUnshowItem", true);
      com.tencent.mm.bs.d.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, this.qLD);
    }
    AppMethodBeat.o(167177);
  }
  
  public final void onClickEditSex(View paramView)
  {
    AppMethodBeat.i(167176);
    paramView = this.qLe;
    if (paramView == null) {
      k.aPZ("nickEdt");
    }
    paramView.clearFocus();
    paramView = this.qLf;
    if (paramView == null) {
      k.aPZ("signatureEdt");
    }
    paramView.clearFocus();
    hideVKB();
    g(false, 0);
    if (this.KXX)
    {
      paramView = new Intent();
      paramView.putExtra("key_input_sex", qLI);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramView, this.qLC);
    }
    AppMethodBeat.o(167176);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167175);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    getController().q((Activity)this, getResources().getColor(2131101179));
    paramBundle = findViewById(2131304371);
    k.g(paramBundle, "findViewById(R.id.scroll_container)");
    this.qLd = paramBundle;
    paramBundle = findViewById(2131299973);
    k.g(paramBundle, "findViewById(R.id.finder_avatar_iv)");
    this.ida = ((ImageView)paramBundle);
    paramBundle = findViewById(2131300016);
    k.g(paramBundle, "findViewById(R.id.finder_nick_tv)");
    this.qLe = ((EditText)paramBundle);
    paramBundle = findViewById(2131300071);
    k.g(paramBundle, "findViewById(R.id.finder_signature_tv)");
    this.qLf = ((EditText)paramBundle);
    paramBundle = findViewById(2131300069);
    k.g(paramBundle, "findViewById(R.id.finder_sex_tv)");
    this.qLg = ((TextView)paramBundle);
    paramBundle = findViewById(2131299989);
    k.g(paramBundle, "findViewById(R.id.finder_district_tv)");
    this.qLh = ((TextView)paramBundle);
    paramBundle = findViewById(2131299152);
    k.g(paramBundle, "findViewById(R.id.district_layout)");
    this.qLl = paramBundle;
    paramBundle = findViewById(2131301524);
    k.g(paramBundle, "findViewById(R.id.location_icon)");
    this.qLi = paramBundle;
    paramBundle = findViewById(2131296941);
    k.g(paramBundle, "findViewById(R.id.arrow_icon)");
    this.KXP = paramBundle;
    paramBundle = findViewById(2131301007);
    k.g(paramBundle, "findViewById(R.id.info_icon)");
    this.KXQ = paramBundle;
    paramBundle = findViewById(2131307868);
    k.g(paramBundle, "findViewById(R.id.sex_arrow_icon)");
    this.KXR = paramBundle;
    paramBundle = findViewById(2131307869);
    k.g(paramBundle, "findViewById(R.id.sex_info_icon)");
    this.KXS = paramBundle;
    paramBundle = findViewById(2131299984);
    k.g(paramBundle, "findViewById(R.id.finder_contact_create_btn)");
    this.qLm = ((Button)paramBundle);
    paramBundle = findViewById(2131301033);
    k.g(paramBundle, "findViewById(R.id.input_panel)");
    this.qLq = ((InputPanelFrameLayout)paramBundle);
    paramBundle = findViewById(2131300001);
    k.g(paramBundle, "findViewById(R.id.finder_input_container)");
    this.qLr = paramBundle;
    paramBundle = findViewById(2131299311);
    k.g(paramBundle, "findViewById(R.id.edt_top_space)");
    this.qLn = paramBundle;
    paramBundle = findViewById(2131299310);
    k.g(paramBundle, "findViewById(R.id.edt_middle_space)");
    this.qLo = paramBundle;
    paramBundle = findViewById(2131299308);
    k.g(paramBundle, "findViewById(R.id.edt_bottom_space)");
    this.qLp = paramBundle;
    paramBundle = findViewById(2131299976);
    k.g(paramBundle, "findViewById(R.id.finder_camera_container)");
    this.qLs = paramBundle;
    paramBundle = findViewById(2131306005);
    k.g(paramBundle, "findViewById(R.id.top_error_tip)");
    this.qLt = ((TextView)paramBundle);
    paramBundle = findViewById(2131300018);
    k.g(paramBundle, "findViewById(R.id.finder_nickname_edit_limit)");
    this.qLu = ((TextView)paramBundle);
    paramBundle = findViewById(2131300070);
    k.g(paramBundle, "findViewById(R.id.finder_signature_edit_limit)");
    this.qLv = ((TextView)paramBundle);
    paramBundle = findViewById(2131307893);
    k.g(paramBundle, "findViewById(R.id.tips_check_cb)");
    this.KXT = ((CheckBox)paramBundle);
    paramBundle = findViewById(2131307895);
    k.g(paramBundle, "findViewById(R.id.tips_warning_tv)");
    this.KXU = ((TextView)paramBundle);
    paramBundle = this.ida;
    if (paramBundle == null) {
      k.aPZ("avatarView");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = this.qLm;
    if (paramBundle == null) {
      k.aPZ("createBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = (TextWatcher)new g(this);
    Object localObject1 = this.qLe;
    if (localObject1 == null) {
      k.aPZ("nickEdt");
    }
    ((EditText)localObject1).addTextChangedListener(paramBundle);
    paramBundle = this.qLe;
    if (paramBundle == null) {
      k.aPZ("nickEdt");
    }
    paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new d(this));
    paramBundle = (TextWatcher)new h(this);
    localObject1 = this.qLf;
    if (localObject1 == null) {
      k.aPZ("signatureEdt");
    }
    ((EditText)localObject1).addTextChangedListener(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    paramBundle = this.qLq;
    if (paramBundle == null) {
      k.aPZ("inputPanel");
    }
    paramBundle.setExternalListener((b.a)this);
    paramBundle = this.qLd;
    if (paramBundle == null) {
      k.aPZ("scrollContainer");
    }
    paramBundle.post((Runnable)new f(this));
    if (qLG != null)
    {
      paramBundle = this.qLe;
      if (paramBundle == null) {
        k.aPZ("nickEdt");
      }
      paramBundle.setText((CharSequence)qLG);
    }
    if (qLH != null)
    {
      paramBundle = this.qLf;
      if (paramBundle == null) {
        k.aPZ("signatureEdt");
      }
      paramBundle.setText((CharSequence)qLH);
    }
    if (irO != null)
    {
      this.qjl = irO;
      setAvatar(this.qjl);
    }
    paramBundle = com.tencent.mm.kernel.g.afB();
    k.g(paramBundle, "MMKernel.storage()");
    int i = paramBundle.afk().getInt(12290, 0);
    if (i == 1)
    {
      qLI = "male";
      this.KXX = false;
    }
    for (;;)
    {
      paramBundle = new ArrayList();
      localObject1 = z.Jhz;
      localObject1 = String.format("https://weixin.qq.com/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[] { ac.ir((Context)this) }, 1));
      k.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = z.Jhz;
      localObject1 = String.format("https://weixin.qq.com/cgi-bin/readtemplate?t=finder_privacy", Arrays.copyOf(new Object[0], 0));
      k.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(getString(2131765434));
      ((ArrayList)localObject2).add(getString(2131765435));
      localObject1 = (Context)this;
      paramBundle = (List)paramBundle;
      String str = getString(2131765436);
      k.g(str, "getString(R.string.finder_create_contact_warning)");
      localObject2 = (List)localObject2;
      TextView localTextView = this.KXU;
      if (localTextView == null) {
        k.aPZ("tipsWarningTV");
      }
      a((Context)localObject1, paramBundle, str, (List)localObject2, localTextView, this.TAG);
      cqU();
      cqV();
      com.tencent.mm.kernel.g.aeS().a(3922, (com.tencent.mm.al.g)this);
      com.tencent.mm.kernel.g.aeS().a(3759, (com.tencent.mm.al.g)this);
      this.scene = getIntent().getIntExtra("scene", 0);
      this.qBp = new alv();
      paramBundle = getIntent().getByteArrayExtra("key_prepare_resp");
      if (paramBundle != null) {}
      try
      {
        localObject1 = this.qBp;
        if (localObject1 != null) {
          ((alv)localObject1).parseFrom(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = y.JfV;
        }
      }
      paramBundle = this.qBp;
      if (paramBundle != null)
      {
        if (paramBundle.KXV > 0) {
          this.KXV = paramBundle.KXV;
        }
        if (paramBundle.KXW > 0) {
          this.KXW = paramBundle.KXW;
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 30L, 1L);
      AppMethodBeat.o(167175);
      return;
      if (i == 2)
      {
        qLI = "female";
        this.KXX = false;
      }
      else
      {
        this.KXX = true;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167182);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3922, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(3759, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(167182);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(167183);
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.finder.cgi.l))
    {
      paramString = this.qLE;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((com.tencent.mm.plugin.finder.cgi.l)paramn).ckE();
        if (paramn != null)
        {
          paramString = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.a(this.scene, true, true, true);
          com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 32L, 1L);
          paramString = new Intent();
          paramString.putExtra("finder_username", paramn.username);
          paramString.putExtra("KEY_FINDER_SELF_FLAG", true);
          paramn = FinderReporterUIC.Ljl;
          FinderReporterUIC.a.a((Context)this, paramString, 0L, 0, false, 124);
          paramn = com.tencent.mm.plugin.finder.utils.a.qSb;
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramString);
          finish();
        }
        AppMethodBeat.o(167183);
        return;
      }
      if (paramInt2 == -4003) {
        com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 37L, 1L);
      }
      for (;;)
      {
        paramString = ((com.tencent.mm.plugin.finder.cgi.l)paramn).rr.auM();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
        AppMethodBeat.o(167183);
        throw paramString;
        if (paramInt2 == -4008) {
          com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 38L, 1L);
        }
      }
      paramString = ((aic)paramString).verifyInfo;
      if (paramString != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "verify info: " + com.tencent.mm.ad.f.bG(paramString));
        if (paramString.DlT == 1)
        {
          paramn = this.qLe;
          if (paramn == null) {
            k.aPZ("nickEdt");
          }
          paramn.setTextColor(com.tencent.mm.cd.a.n((Context)this, 2131100798));
        }
        while (!bt.isNullOrNil(paramString.DlQ))
        {
          paramn = paramString.DlQ;
          k.g(paramn, "it.bannerWording");
          bg(paramn, paramString.LxU, paramString.LxT);
          AppMethodBeat.o(167183);
          return;
          if (paramString.DlT == 2)
          {
            paramn = this.qLf;
            if (paramn == null) {
              k.aPZ("signatureEdt");
            }
            paramn.setTextColor(com.tencent.mm.cd.a.n((Context)this, 2131100798));
          }
        }
        paramString = getString(2131759176);
        k.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
        bg(paramString, null, null);
        AppMethodBeat.o(167183);
        return;
      }
      paramString = (FinderCreateContactUI)this;
      paramn = paramString.getString(2131759176);
      k.g(paramn, "getString(R.string.finde…reate_contact_failed_tip)");
      paramString.bg(paramn, null, null);
      AppMethodBeat.o(167183);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.finder.cgi.ad))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new ahz();
        if (k.g(qLI, "female"))
        {
          paramInt1 = 0;
          paramString.evp = 2;
          if (!k.g(qLJ, "unshow")) {
            break label624;
          }
          paramInt2 = 1;
        }
        for (;;)
        {
          paramString = new com.tencent.mm.plugin.finder.cgi.l(qLG, qLH, ((com.tencent.mm.plugin.finder.cgi.ad)paramn).qpB, paramString, paramInt1, paramInt2);
          com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramString);
          AppMethodBeat.o(167183);
          return;
          if (k.g(qLI, "male"))
          {
            paramInt1 = 0;
            paramString.evp = 1;
            break;
          }
          paramInt1 = 1;
          paramString.evp = 0;
          break;
          label624:
          paramInt2 = 0;
          paramString.country = qLJ;
          paramString.evz = qLK;
          paramString.evA = qLL;
        }
      }
      paramString = this.qLE;
      if (paramString != null) {
        paramString.dismiss();
      }
      com.tencent.mm.plugin.report.service.h.vKh.m(1279L, 33L, 1L);
      paramString = getString(2131759176);
      k.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
      bg(paramString, null, null);
    }
    AppMethodBeat.o(167183);
  }
  
  public final void onTipsCheckBoxClick(View paramView)
  {
    AppMethodBeat.i(199127);
    paramView = this.KXT;
    if (paramView == null) {
      k.aPZ("tipsCheckCB");
    }
    CheckBox localCheckBox = this.KXT;
    if (localCheckBox == null) {
      k.aPZ("tipsCheckCB");
    }
    if (!localCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(199127);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI$Companion;", "", "()V", "lastAvatarPath", "", "getLastAvatarPath", "()Ljava/lang/String;", "setLastAvatarPath", "(Ljava/lang/String;)V", "lastNickName", "getLastNickName", "setLastNickName", "lastSelectCityCode", "getLastSelectCityCode", "setLastSelectCityCode", "lastSelectCountryCode", "getLastSelectCountryCode", "setLastSelectCountryCode", "lastSelectProvinceCode", "getLastSelectProvinceCode", "setLastSelectProvinceCode", "lastSelectSex", "getLastSelectSex", "setLastSelectSex", "lastSignature", "getLastSignature", "setLastSignature", "plugin-finder_release"})
  public static final class a
  {
    public static void aVD(String paramString)
    {
      AppMethodBeat.i(199123);
      k.h(paramString, "<set-?>");
      FinderCreateContactUI.ZB(paramString);
      AppMethodBeat.o(199123);
    }
    
    public static void aVE(String paramString)
    {
      AppMethodBeat.i(199124);
      k.h(paramString, "<set-?>");
      FinderCreateContactUI.ZC(paramString);
      AppMethodBeat.o(199124);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167160);
      com.tencent.mm.pluginsdk.ui.tools.q.o((Activity)this.qLN, FinderCreateContactUI.a(this.qLN));
      AppMethodBeat.o(167160);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167161);
      com.tencent.mm.sdk.platformtools.ad.i(FinderCreateContactUI.b(this.qLN), "doClick create contact btn");
      Object localObject2 = new hh();
      Object localObject1 = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((hh)localObject2).NJ(paramView);
      Object localObject6 = this.qLN.getString(2131756087);
      Object localObject5 = this.qLN.getString(2131759280);
      Object localObject4 = this.qLN.getString(2131759356);
      Object localObject3 = this.qLN.getString(2131763400);
      paramView = FinderCreateContactUI.qLM;
      localObject1 = FinderCreateContactUI.f(this.qLN);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      k.h(paramView, "<set-?>");
      FinderCreateContactUI.aVC(paramView);
      paramView = FinderCreateContactUI.qLM;
      paramView = FinderCreateContactUI.d(this.qLN).getText();
      if (paramView != null)
      {
        paramView = paramView.toString();
        if (paramView != null)
        {
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(167161);
            throw paramView;
          }
          localObject1 = d.n.n.trim((CharSequence)paramView).toString();
          paramView = (View)localObject1;
          if (localObject1 != null) {
            break label200;
          }
        }
      }
      paramView = "";
      label200:
      FinderCreateContactUI.a.aVD(paramView);
      paramView = FinderCreateContactUI.qLM;
      paramView = FinderCreateContactUI.h(this.qLN).getText();
      if (paramView != null)
      {
        paramView = paramView.toString();
        if (paramView != null)
        {
          if (paramView == null)
          {
            paramView = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(167161);
            throw paramView;
          }
          localObject1 = d.n.n.trim((CharSequence)paramView).toString();
          paramView = (View)localObject1;
          if (localObject1 != null) {
            break label273;
          }
        }
      }
      paramView = "";
      label273:
      FinderCreateContactUI.a.aVE(paramView);
      paramView = new ArrayList();
      localObject1 = FinderCreateContactUI.qLM;
      if (com.tencent.mm.ui.tools.f.aLJ(FinderCreateContactUI.fVn()) > FinderCreateContactUI.l(this.qLN)) {
        paramView.add(localObject5);
      }
      localObject1 = FinderCreateContactUI.qLM;
      if (com.tencent.mm.ui.tools.f.aLJ(FinderCreateContactUI.fVo()) > FinderCreateContactUI.m(this.qLN)) {
        paramView.add(localObject4);
      }
      localObject1 = new ArrayList();
      FinderCreateContactUI.a locala = FinderCreateContactUI.qLM;
      int i;
      if (((CharSequence)FinderCreateContactUI.fVm()).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label606;
        }
        ((ArrayList)localObject1).add(localObject6);
        label379:
        localObject6 = FinderCreateContactUI.qLM;
        if (((CharSequence)FinderCreateContactUI.fVn()).length() != 0) {
          break label615;
        }
        i = 1;
        label400:
        if (i == 0) {
          break label620;
        }
        ((ArrayList)localObject1).add(localObject5);
        label411:
        localObject5 = FinderCreateContactUI.qLM;
        if (((CharSequence)FinderCreateContactUI.fVo()).length() != 0) {
          break label629;
        }
        i = 1;
        label432:
        if (i == 0) {
          break label634;
        }
        ((ArrayList)localObject1).add(localObject4);
        label443:
        localObject4 = FinderCreateContactUI.qLM;
        if (((CharSequence)FinderCreateContactUI.fVp()).length() != 0) {
          break label643;
        }
        i = 1;
        label464:
        if (i == 0) {
          break label648;
        }
        ((ArrayList)localObject1).add(localObject3);
        label475:
        localObject3 = FinderCreateContactUI.qLM;
        if (!bt.isNullOrNil(FinderCreateContactUI.fVq())) {
          ((hh)localObject2).Qb();
        }
        if (!paramView.isEmpty()) {
          break label853;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          break label731;
        }
        if (!FinderCreateContactUI.n(this.qLN).isChecked()) {
          break label657;
        }
        FinderCreateContactUI.c(this.qLN);
        ((hh)localObject2).xX(1L);
      }
      for (;;)
      {
        ((hh)localObject2).aBj();
        paramView = FinderCreateContactUI.b(this.qLN);
        localObject1 = new StringBuilder("report19815 ");
        localObject2 = ((hh)localObject2).PW();
        k.g(localObject2, "struct.toShowString()");
        com.tencent.mm.sdk.platformtools.ad.i(paramView, d.n.n.h((String)localObject2, "\r\n", " ", false));
        AppMethodBeat.o(167161);
        return;
        i = 0;
        break;
        label606:
        ((hh)localObject2).uD();
        break label379;
        label615:
        i = 0;
        break label400;
        label620:
        ((hh)localObject2).Ie();
        break label411;
        label629:
        i = 0;
        break label432;
        label634:
        ((hh)localObject2).If();
        break label443;
        label643:
        i = 0;
        break label464;
        label648:
        ((hh)localObject2).NS();
        break label475;
        label657:
        com.tencent.mm.sdk.platformtools.ad.i(FinderCreateContactUI.b(this.qLN), "not check agreement");
        paramView = this.qLN;
        localObject1 = this.qLN.getString(2131763113);
        k.g(localObject1, "getString(R.string.finder_agreement_not_check_tip)");
        FinderCreateContactUI.a(paramView, (String)localObject1);
        ((hh)localObject2).xX(2L);
        ((hh)localObject2).xY(3L);
        ((hh)localObject2).Qg(this.qLN.getString(2131763113));
        continue;
        label731:
        com.tencent.mm.sdk.platformtools.ad.i(FinderCreateContactUI.b(this.qLN), "empty attr ".concat(String.valueOf(localObject1)));
        paramView = bt.n((List)localObject1, this.qLN.getString(2131765440));
        localObject1 = this.qLN;
        localObject3 = this.qLN.getString(2131766404, new Object[] { paramView });
        k.g(localObject3, "getString(R.string.finde…_empty_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((hh)localObject2).xX(2L);
        ((hh)localObject2).xY(2L);
        ((hh)localObject2).Qg(this.qLN.getString(2131766404, new Object[] { paramView }));
        continue;
        label853:
        paramView = bt.n((List)paramView, this.qLN.getString(2131765440));
        localObject1 = this.qLN;
        localObject3 = this.qLN.getString(2131766405, new Object[] { paramView });
        k.g(localObject3, "getString(R.string.finde…o_long_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((hh)localObject2).xX(2L);
        ((hh)localObject2).xY(1L);
        ((hh)localObject2).Qg(this.qLN.getString(2131766405, new Object[] { paramView }));
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class d
    implements TextView.OnEditorActionListener
  {
    d(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(167162);
      if (5 == paramInt)
      {
        FinderCreateContactUI.d(this.qLN).clearFocus();
        FinderCreateContactUI.h(this.qLN).requestFocus();
      }
      AppMethodBeat.o(167162);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167163);
      paramMenuItem = com.tencent.mm.plugin.finder.report.a.qFo;
      com.tencent.mm.plugin.finder.report.a.CL(5);
      paramMenuItem = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(FinderCreateContactUI.j(this.qLN), false, false, false);
      this.qLN.finish();
      AppMethodBeat.o(167163);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167164);
      FinderCreateContactUI.a(this.qLN, FinderCreateContactUI.k(this.qLN).getMeasuredHeight());
      AppMethodBeat.o(167164);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class g
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167168);
      com.tencent.mm.ui.tools.b.c.d(FinderCreateContactUI.d(this.qLN)).jE(1, FinderCreateContactUI.l(this.qLN)).a(f.a.Hrm).feh().a((c.a)new a(this));
      paramEditable = FinderCreateContactUI.qLM;
      paramEditable = FinderCreateContactUI.d(this.qLN).getText();
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (paramEditable != null)
        {
          if (paramEditable == null)
          {
            paramEditable = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(167168);
            throw paramEditable;
          }
          String str = d.n.n.trim((CharSequence)paramEditable).toString();
          paramEditable = str;
          if (str != null) {
            break label118;
          }
        }
      }
      paramEditable = "";
      label118:
      FinderCreateContactUI.a.aVD(paramEditable);
      FinderCreateContactUI.d(this.qLN).setTextColor(com.tencent.mm.cd.a.n((Context)this.qLN, 2131100711));
      AppMethodBeat.o(167168);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements c.a
    {
      public final void CH(String paramString)
      {
        AppMethodBeat.i(167167);
        int i = com.tencent.mm.ui.tools.f.cJ(FinderCreateContactUI.l(this.qLO.qLN), paramString);
        FinderCreateContactUI.e(this.qLO.qLN).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.e(this.qLO.qLN).setTextColor(this.qLO.qLN.getResources().getColor(2131099660));
        if (i <= d.k.h.kK((int)(FinderCreateContactUI.l(this.qLO.qLN) * 0.1F), 1)) {
          FinderCreateContactUI.e(this.qLO.qLN).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.g(this.qLO.qLN);
          AppMethodBeat.o(167167);
          return;
          FinderCreateContactUI.e(this.qLO.qLN).setVisibility(4);
        }
      }
      
      public final void aKr()
      {
        AppMethodBeat.i(167165);
        FinderCreateContactUI.e(this.qLO.qLN).setText((CharSequence)String.valueOf(FinderCreateContactUI.l(this.qLO.qLN)));
        FinderCreateContactUI.e(this.qLO.qLN).setTextColor(this.qLO.qLN.getResources().getColor(2131099660));
        AppMethodBeat.o(167165);
      }
      
      public final void ck(String paramString)
      {
        AppMethodBeat.i(167166);
        FinderCreateContactUI.e(this.qLO.qLN).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.f.cJ(FinderCreateContactUI.l(this.qLO.qLN), paramString)));
        FinderCreateContactUI.e(this.qLO.qLN).setVisibility(0);
        FinderCreateContactUI.e(this.qLO.qLN).setTextColor(this.qLO.qLN.getResources().getColor(2131099804));
        paramString = this.qLO.qLN;
        String str = this.qLO.qLN.getString(2131759284);
        k.g(str, "getString(R.string.finder_nickname_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167166);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$signatureTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class h
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167172);
      com.tencent.mm.ui.tools.b.c.d(FinderCreateContactUI.h(this.qLN)).jE(1, FinderCreateContactUI.m(this.qLN)).a(f.a.Hrm).feh().a((c.a)new a(this));
      paramEditable = FinderCreateContactUI.qLM;
      paramEditable = FinderCreateContactUI.h(this.qLN).getText();
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (paramEditable != null)
        {
          if (paramEditable == null)
          {
            paramEditable = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(167172);
            throw paramEditable;
          }
          String str = d.n.n.trim((CharSequence)paramEditable).toString();
          paramEditable = str;
          if (str != null) {
            break label118;
          }
        }
      }
      paramEditable = "";
      label118:
      FinderCreateContactUI.a.aVE(paramEditable);
      FinderCreateContactUI.h(this.qLN).setTextColor(com.tencent.mm.cd.a.n((Context)this.qLN, 2131100711));
      AppMethodBeat.o(167172);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$signatureTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements c.a
    {
      public final void CH(String paramString)
      {
        AppMethodBeat.i(167171);
        int i = com.tencent.mm.ui.tools.f.cJ(FinderCreateContactUI.m(this.qLP.qLN), paramString);
        FinderCreateContactUI.i(this.qLP.qLN).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.i(this.qLP.qLN).setTextColor(this.qLP.qLN.getResources().getColor(2131099660));
        if (i <= d.k.h.kK((int)(FinderCreateContactUI.m(this.qLP.qLN) * 0.1F), 1)) {
          FinderCreateContactUI.i(this.qLP.qLN).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.g(this.qLP.qLN);
          AppMethodBeat.o(167171);
          return;
          FinderCreateContactUI.i(this.qLP.qLN).setVisibility(4);
        }
      }
      
      public final void aKr()
      {
        AppMethodBeat.i(167169);
        FinderCreateContactUI.i(this.qLP.qLN).setText((CharSequence)String.valueOf(FinderCreateContactUI.m(this.qLP.qLN)));
        FinderCreateContactUI.i(this.qLP.qLN).setTextColor(this.qLP.qLN.getResources().getColor(2131099660));
        AppMethodBeat.o(167169);
      }
      
      public final void ck(String paramString)
      {
        AppMethodBeat.i(167170);
        FinderCreateContactUI.i(this.qLP.qLN).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.f.cJ(FinderCreateContactUI.m(this.qLP.qLN), paramString)));
        FinderCreateContactUI.i(this.qLP.qLN).setVisibility(0);
        FinderCreateContactUI.i(this.qLP.qLN).setTextColor(this.qLP.qLN.getResources().getColor(2131099804));
        paramString = this.qLP.qLN;
        String str = this.qLP.qLN.getString(2131759357);
        k.g(str, "getString(R.string.finder_signature_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167170);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class i
    implements View.OnTouchListener
  {
    i(FinderCreateContactUI paramFinderCreateContactUI, Spannable paramSpannable, TextView paramTextView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167173);
      k.g(paramMotionEvent, "event");
      int j = paramMotionEvent.getAction();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(167173);
        throw paramView;
      }
      paramView = (TextView)paramView;
      Spannable localSpannable = paramSpannable;
      Object localObject1;
      int k;
      int i;
      if ((j == 1) || (j == 3))
      {
        localObject1 = (ClickableSpan[])localSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
        if (localObject1 != null)
        {
          k = localObject1.length;
          i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 instanceof o))
            {
              ((o)localObject2).setIsPressed(false);
              paramTextView.invalidate();
            }
            i += 1;
          }
        }
      }
      if ((j == 1) || (j == 0))
      {
        i = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        int m = paramView.getPaddingLeft();
        int n = paramView.getPaddingTop();
        int i1 = paramView.getScrollX();
        int i2 = paramView.getScrollY();
        localObject1 = paramView.getLayout();
        i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
        localObject1 = (ClickableSpan[])localSpannable.getSpans(i, i, ClickableSpan.class);
        if (localObject1.length != 0)
        {
          localObject1 = localObject1[0];
          if (j == 1) {
            ((ClickableSpan)localObject1).onClick((View)paramView);
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ad.i(FinderCreateContactUI.b(this.qLN), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
        AppMethodBeat.o(167173);
        return bool;
        if (j != 0) {
          break;
        }
        if ((localObject1 instanceof o))
        {
          ((o)localObject1).setIsPressed(true);
          paramTextView.invalidate();
        }
        Selection.setSelection(localSpannable, localSpannable.getSpanStart(localObject1), localSpannable.getSpanEnd(localObject1));
        break;
        Selection.removeSelection(localSpannable);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    j(FinderCreateContactUI paramFinderCreateContactUI, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$1$1"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178430);
      paramView = com.tencent.mm.plugin.finder.spam.a.qIC;
      paramView = this.qLN.getString(2131759252);
      k.g(paramView, "getString(R.string.finder_location_tip_gps)");
      com.tencent.mm.plugin.finder.spam.a.Zs(paramView);
      AppMethodBeat.o(178430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI
 * JD-Core Version:    0.7.0.1
 */