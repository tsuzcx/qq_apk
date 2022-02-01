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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.cgi.u;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_CODE_SELECT_DISTRICT", "REQUEST_CODE_SELECT_SEX", "TAG", "", "avatarPath", "avatarView", "Landroid/widget/ImageView;", "cameraContainer", "Landroid/view/View;", "canSelectSex", "", "createBtn", "Landroid/widget/Button;", "districtLayout", "districtTV", "Landroid/widget/TextView;", "editBottomSpace", "editMiddleSpace", "editNickNameLimit", "editSignatureLimit", "editTopSpace", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "locationArrowIcon", "locationIcon", "locationInfoIcon", "nickEdt", "Landroid/widget/EditText;", "nicknameMaxLength", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollContainer", "scrollViewOriginHeight", "sexArrowIcon", "sexInfoIcon", "sexTV", "signatureEdt", "signatureMaxLength", "tipsCheckCB", "Landroid/widget/CheckBox;", "tipsWarningTV", "topErrorTip", "createContact", "", "getLayoutId", "hideError", "initContentView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickEditDistrict", "view", "onClickEditSex", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTipsCheckBoxClick", "setAvatar", "path", "setDistrictTV", "countryCodeName", "provinceCodeName", "cityCodeName", "setSpanTouch", "descTv", "text", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "spanLinks", "context", "Landroid/content/Context;", "h5urlList", "", "allText", "linkTextList", "logTag", "updateDistrict", "updateSex", "Companion", "plugin-finder_release"})
public final class FinderCreateContactUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g, b.a
{
  private static String iRT;
  private static String rGA;
  public static final a rGB;
  private static String rGv;
  private static String rGw;
  private static String rGx;
  private static String rGy;
  private static String rGz;
  private final String TAG = "Finder.FinderCreateContactUI";
  private HashMap _$_findViewCache;
  private ImageView iDk;
  private String qRN;
  private View rFP;
  private EditText rFQ;
  private EditText rFR;
  private TextView rFS;
  private TextView rFT;
  private View rFU;
  private View rFV;
  private View rFW;
  private View rFX;
  private View rFY;
  private View rFZ;
  private Button rGa;
  private View rGb;
  private View rGc;
  private View rGd;
  private InputPanelFrameLayout rGe;
  private View rGf;
  private View rGg;
  private TextView rGh;
  private TextView rGi;
  private TextView rGj;
  private CheckBox rGk;
  private TextView rGl;
  private final int rGm = 1000;
  private final int rGn = 1001;
  private final int rGo = 1002;
  private final int rGp = 1003;
  private ProgressDialog rGq;
  private int rGr;
  private int rGs = 20;
  private int rGt = 400;
  private boolean rGu = true;
  private aoy rsp;
  private int scene;
  
  static
  {
    AppMethodBeat.i(167188);
    rGB = new a((byte)0);
    iRT = "";
    rGv = "";
    rGw = "";
    rGx = "";
    rGy = "";
    rGz = "";
    rGA = "";
    AppMethodBeat.o(167188);
  }
  
  private final void Z(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(203098);
    ac.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = com.tencent.mm.plugin.i.a.d.iYL.matcher((CharSequence)paramString1);
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
          AppMethodBeat.o(203098);
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
          AppMethodBeat.o(203098);
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
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.g(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099776), false, (d.g.a.b)new j(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.rGh;
      if (paramString2 == null) {
        k.aVY("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.rGh;
      if (paramString2 == null) {
        k.aVY("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.rGh;
      if (paramString1 == null) {
        k.aVY("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(203098);
      return;
      paramString2 = this.rGh;
      if (paramString2 == null) {
        k.aVY("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
    }
  }
  
  private void a(Context paramContext, List<String> paramList1, String paramString1, List<String> paramList2, TextView paramTextView, String paramString2)
  {
    AppMethodBeat.i(203101);
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
        j.fOc();
      }
      localObject = (String)localObject;
      int j = d.n.n.a((CharSequence)paramString1, (String)localObject, 0, false, 6);
      int k = j + ((String)localObject).length();
      if ((j >= 0) && (k <= paramString1.length()))
      {
        localObject = (String)paramList1.get(i);
        Context localContext = ai.getContext();
        k.g(localContext, "MMApplicationContext.getContext()");
        int m = localContext.getResources().getColor(2131100547);
        localContext = ai.getContext();
        k.g(localContext, "MMApplicationContext.getContext()");
        localSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.g((String)localObject, m, localContext.getResources().getColor(2131099658), (d.g.a.b)new FinderCreateContactUI.k(paramString1, localSpannableString, paramList1, paramString2, paramContext)), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText((CharSequence)localSpannableString);
    a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(203101);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(203100);
    k.h(paramTextView, "descTv");
    k.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderCreateContactUI.i(this, paramSpannable, paramTextView));
    AppMethodBeat.o(203100);
  }
  
  private final void aa(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178431);
    RegionCodeDecoder.fcs();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.fcs();
    String str2 = RegionCodeDecoder.lC(paramString1, paramString2);
    RegionCodeDecoder.fcs();
    paramString1 = RegionCodeDecoder.aX(paramString1, paramString2, paramString3);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = this.rFT;
      if (paramString2 == null) {
        k.aVY("districtTV");
      }
      paramString2.setText((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wm(str2) + " " + paramString1));
      paramString1 = this.rFZ;
      if (paramString1 == null) {
        k.aVY("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bs.isNullOrNil(str2))
    {
      paramString1 = this.rFT;
      if (paramString1 == null) {
        k.aVY("districtTV");
      }
      paramString1.setText((CharSequence)(str1 + ' ' + str2));
      paramString1 = this.rFZ;
      if (paramString1 == null) {
        k.aVY("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bs.isNullOrNil(str1))
    {
      paramString1 = this.rFT;
      if (paramString1 == null) {
        k.aVY("districtTV");
      }
      paramString1.setText((CharSequence)str1);
      paramString1 = this.rFZ;
      if (paramString1 == null) {
        k.aVY("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    paramString1 = this.rFZ;
    if (paramString1 == null) {
      k.aVY("districtLayout");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(178431);
  }
  
  private final void cBx()
  {
    AppMethodBeat.i(167185);
    Object localObject = rGx;
    switch (((String)localObject).hashCode())
    {
    default: 
      localObject = this.rFS;
      if (localObject == null) {
        k.aVY("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759351));
      localObject = this.rFS;
      if (localObject == null) {
        k.aVY("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100490));
    }
    for (;;)
    {
      if (!this.rGu) {
        break label295;
      }
      localObject = this.rFX;
      if (localObject == null) {
        k.aVY("sexArrowIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.rFY;
      if (localObject == null) {
        k.aVY("sexInfoIcon");
      }
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(167185);
      return;
      if (!((String)localObject).equals("female")) {
        break;
      }
      localObject = this.rFS;
      if (localObject == null) {
        k.aVY("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763532));
      localObject = this.rFS;
      if (localObject == null) {
        k.aVY("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100711));
      continue;
      if (!((String)localObject).equals("male")) {
        break;
      }
      localObject = this.rFS;
      if (localObject == null) {
        k.aVY("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763533));
      localObject = this.rFS;
      if (localObject == null) {
        k.aVY("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100711));
    }
    label295:
    localObject = this.rFX;
    if (localObject == null) {
      k.aVY("sexArrowIcon");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.rFY;
    if (localObject == null) {
      k.aVY("sexInfoIcon");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.rFY;
    if (localObject == null) {
      k.aVY("sexInfoIcon");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new m(this));
    AppMethodBeat.o(167185);
  }
  
  private final void cBy()
  {
    AppMethodBeat.i(167186);
    Object localObject = this.rFT;
    if (localObject == null) {
      k.aVY("districtTV");
    }
    ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100711));
    localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class)).sbI;
    if (localObject != null)
    {
      String str = ((awb)localObject).iKc;
      k.g(str, "it.Country");
      rGy = str;
      str = ((awb)localObject).iJU;
      k.g(str, "it.Province");
      rGz = str;
      localObject = ((awb)localObject).iJV;
      k.g(localObject, "it.City");
      rGA = (String)localObject;
      localObject = this.rFU;
      if (localObject == null) {
        k.aVY("locationIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.rFV;
      if (localObject == null) {
        k.aVY("locationArrowIcon");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.rFW;
      if (localObject == null) {
        k.aVY("locationInfoIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.rFW;
      if (localObject == null) {
        k.aVY("locationInfoIcon");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new l(this));
      aa(rGy, rGz, rGA);
    }
    for (;;)
    {
      ac.i(this.TAG, "updateDistrict " + rGy + ' ' + rGz + ' ' + rGA);
      AppMethodBeat.o(167186);
      return;
      localObject = (FinderCreateContactUI)this;
      rGy = "unshow";
      rGz = "";
      rGA = "";
      localObject = ((FinderCreateContactUI)localObject).rFZ;
      if (localObject == null) {
        k.aVY("districtLayout");
      }
      ((View)localObject).setVisibility(8);
    }
  }
  
  private final void setAvatar(String paramString)
  {
    AppMethodBeat.i(167187);
    if (!bs.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.sdk.platformtools.f.e(paramString, 256, 256, false);
      if (paramString != null)
      {
        Object localObject = this.iDk;
        if (localObject == null) {
          k.aVY("avatarView");
        }
        ((ImageView)localObject).setImageBitmap(paramString);
        paramString = this.rGg;
        if (paramString == null) {
          k.aVY("cameraContainer");
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
        localObject = this.rGg;
        if (localObject == null) {
          k.aVY("cameraContainer");
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramString);
        paramString = this.rGg;
        if (paramString == null) {
          k.aVY("cameraContainer");
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
    AppMethodBeat.i(203103);
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
    AppMethodBeat.o(203103);
    return localView1;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167180);
    if (paramBoolean)
    {
      localObject = this.rFP;
      if (localObject == null) {
        k.aVY("scrollContainer");
      }
      localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((FrameLayout.LayoutParams)localObject).height = (this.rGr - paramInt);
      localView = this.rFP;
      if (localView == null) {
        k.aVY("scrollContainer");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.rGb;
      if (localObject == null) {
        k.aVY("editTopSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.au((Context)this, 2131165289);
      localView = this.rGb;
      if (localView == null) {
        k.aVY("editTopSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.rGc;
      if (localObject == null) {
        k.aVY("editMiddleSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.au((Context)this, 2131165302);
      localView = this.rGc;
      if (localView == null) {
        k.aVY("editMiddleSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.rGd;
      if (localObject == null) {
        k.aVY("editBottomSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.au((Context)this, 2131165289);
      localView = this.rGd;
      if (localView == null) {
        k.aVY("editBottomSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(167180);
      return;
    }
    Object localObject = this.rFP;
    if (localObject == null) {
      k.aVY("scrollContainer");
    }
    localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((FrameLayout.LayoutParams)localObject).height = this.rGr;
    View localView = this.rFP;
    if (localView == null) {
      k.aVY("scrollContainer");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.rGb;
    if (localObject == null) {
      k.aVY("editTopSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.au((Context)this, 2131165301);
    localView = this.rGb;
    if (localView == null) {
      k.aVY("editTopSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.rGc;
    if (localObject == null) {
      k.aVY("editMiddleSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = -2;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localView = this.rGc;
    if (localView == null) {
      k.aVY("editMiddleSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.rGd;
    if (localObject == null) {
      k.aVY("editBottomSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.au((Context)this, 2131165277);
    localView = this.rGd;
    if (localView == null) {
      k.aVY("editBottomSpace");
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
    if (paramInt1 == this.rGm)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.awL());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.rGn);
        AppMethodBeat.o(167184);
      }
    }
    else if (paramInt1 == this.rGn)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        this.qRN = paramIntent.getStringExtra("key_result_img_path");
        paramIntent = this.qRN;
        if (paramIntent != null) {
          iRT = paramIntent;
        }
        ac.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(i.aSp(this.qRN) / 1024L) });
        setAvatar(this.qRN);
        AppMethodBeat.o(167184);
      }
    }
    else
    {
      Object localObject;
      if (paramInt1 == this.rGo)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          localObject = paramIntent.getStringExtra("key_output_sex");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          rGx = paramIntent;
          cBx();
          AppMethodBeat.o(167184);
        }
      }
      else if ((paramInt1 == this.rGp) && (paramIntent != null) && (paramInt2 == -1))
      {
        String str = paramIntent.getStringExtra("Country");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        rGy = (String)localObject;
        str = paramIntent.getStringExtra("Contact_Province");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        rGz = (String)localObject;
        localObject = paramIntent.getStringExtra("Contact_City");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        rGA = paramIntent;
        cBy();
      }
    }
    AppMethodBeat.o(167184);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167178);
    super.onBackPressed();
    Object localObject = com.tencent.mm.plugin.finder.report.c.rxi;
    com.tencent.mm.plugin.finder.report.c.DS(5);
    localObject = com.tencent.mm.plugin.finder.report.d.rxr;
    com.tencent.mm.plugin.finder.report.d.a(this.scene, false, false, false);
    AppMethodBeat.o(167178);
  }
  
  public final void onClickEditDistrict(View paramView)
  {
    AppMethodBeat.i(167177);
    paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czE() == 1)
    {
      paramView = this.rFQ;
      if (paramView == null) {
        k.aVY("nickEdt");
      }
      paramView.clearFocus();
      paramView = this.rFR;
      if (paramView == null) {
        k.aVY("signatureEdt");
      }
      paramView.clearFocus();
      hideVKB();
      g(false, 0);
      paramView = new Intent();
      paramView.putExtra("GetAddress", true);
      paramView.putExtra("ShowSelectedLocation", true);
      paramView.putExtra("SetSelectLocation", true);
      paramView.putExtra("SelectedCountryCode", rGy);
      paramView.putExtra("SelectedProvinceCode", rGz);
      paramView.putExtra("SelectedCityCode", rGA);
      paramView.putExtra("NeedUnshowItem", true);
      com.tencent.mm.br.d.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, this.rGp);
    }
    AppMethodBeat.o(167177);
  }
  
  public final void onClickEditSex(View paramView)
  {
    AppMethodBeat.i(167176);
    paramView = this.rFQ;
    if (paramView == null) {
      k.aVY("nickEdt");
    }
    paramView.clearFocus();
    paramView = this.rFR;
    if (paramView == null) {
      k.aVY("signatureEdt");
    }
    paramView.clearFocus();
    hideVKB();
    g(false, 0);
    if (this.rGu)
    {
      paramView = new Intent();
      paramView.putExtra("key_input_sex", rGx);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramView, this.rGo);
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
    this.rFP = paramBundle;
    paramBundle = findViewById(2131299973);
    k.g(paramBundle, "findViewById(R.id.finder_avatar_iv)");
    this.iDk = ((ImageView)paramBundle);
    paramBundle = findViewById(2131300016);
    k.g(paramBundle, "findViewById(R.id.finder_nick_tv)");
    this.rFQ = ((EditText)paramBundle);
    paramBundle = findViewById(2131300071);
    k.g(paramBundle, "findViewById(R.id.finder_signature_tv)");
    this.rFR = ((EditText)paramBundle);
    paramBundle = findViewById(2131300069);
    k.g(paramBundle, "findViewById(R.id.finder_sex_tv)");
    this.rFS = ((TextView)paramBundle);
    paramBundle = findViewById(2131299989);
    k.g(paramBundle, "findViewById(R.id.finder_district_tv)");
    this.rFT = ((TextView)paramBundle);
    paramBundle = findViewById(2131299152);
    k.g(paramBundle, "findViewById(R.id.district_layout)");
    this.rFZ = paramBundle;
    paramBundle = findViewById(2131301524);
    k.g(paramBundle, "findViewById(R.id.location_icon)");
    this.rFU = paramBundle;
    paramBundle = findViewById(2131296941);
    k.g(paramBundle, "findViewById(R.id.arrow_icon)");
    this.rFV = paramBundle;
    paramBundle = findViewById(2131301007);
    k.g(paramBundle, "findViewById(R.id.info_icon)");
    this.rFW = paramBundle;
    paramBundle = findViewById(2131307976);
    k.g(paramBundle, "findViewById(R.id.sex_arrow_icon)");
    this.rFX = paramBundle;
    paramBundle = findViewById(2131307977);
    k.g(paramBundle, "findViewById(R.id.sex_info_icon)");
    this.rFY = paramBundle;
    paramBundle = findViewById(2131299984);
    k.g(paramBundle, "findViewById(R.id.finder_contact_create_btn)");
    this.rGa = ((Button)paramBundle);
    paramBundle = findViewById(2131301033);
    k.g(paramBundle, "findViewById(R.id.input_panel)");
    this.rGe = ((InputPanelFrameLayout)paramBundle);
    paramBundle = findViewById(2131300001);
    k.g(paramBundle, "findViewById(R.id.finder_input_container)");
    this.rGf = paramBundle;
    paramBundle = findViewById(2131299311);
    k.g(paramBundle, "findViewById(R.id.edt_top_space)");
    this.rGb = paramBundle;
    paramBundle = findViewById(2131299310);
    k.g(paramBundle, "findViewById(R.id.edt_middle_space)");
    this.rGc = paramBundle;
    paramBundle = findViewById(2131299308);
    k.g(paramBundle, "findViewById(R.id.edt_bottom_space)");
    this.rGd = paramBundle;
    paramBundle = findViewById(2131299976);
    k.g(paramBundle, "findViewById(R.id.finder_camera_container)");
    this.rGg = paramBundle;
    paramBundle = findViewById(2131306005);
    k.g(paramBundle, "findViewById(R.id.top_error_tip)");
    this.rGh = ((TextView)paramBundle);
    paramBundle = findViewById(2131300018);
    k.g(paramBundle, "findViewById(R.id.finder_nickname_edit_limit)");
    this.rGi = ((TextView)paramBundle);
    paramBundle = findViewById(2131300070);
    k.g(paramBundle, "findViewById(R.id.finder_signature_edit_limit)");
    this.rGj = ((TextView)paramBundle);
    paramBundle = findViewById(2131308030);
    k.g(paramBundle, "findViewById(R.id.tips_check_cb)");
    this.rGk = ((CheckBox)paramBundle);
    paramBundle = findViewById(2131308032);
    k.g(paramBundle, "findViewById(R.id.tips_warning_tv)");
    this.rGl = ((TextView)paramBundle);
    paramBundle = this.iDk;
    if (paramBundle == null) {
      k.aVY("avatarView");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = this.rGa;
    if (paramBundle == null) {
      k.aVY("createBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = (TextWatcher)new g(this);
    Object localObject1 = this.rFQ;
    if (localObject1 == null) {
      k.aVY("nickEdt");
    }
    ((EditText)localObject1).addTextChangedListener(paramBundle);
    paramBundle = this.rFQ;
    if (paramBundle == null) {
      k.aVY("nickEdt");
    }
    paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new d(this));
    paramBundle = (TextWatcher)new h(this);
    localObject1 = this.rFR;
    if (localObject1 == null) {
      k.aVY("signatureEdt");
    }
    ((EditText)localObject1).addTextChangedListener(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    paramBundle = this.rGe;
    if (paramBundle == null) {
      k.aVY("inputPanel");
    }
    paramBundle.setExternalListener((b.a)this);
    paramBundle = this.rFP;
    if (paramBundle == null) {
      k.aVY("scrollContainer");
    }
    paramBundle.post((Runnable)new f(this));
    if (rGv != null)
    {
      paramBundle = this.rFQ;
      if (paramBundle == null) {
        k.aVY("nickEdt");
      }
      paramBundle.setText((CharSequence)rGv);
    }
    if (rGw != null)
    {
      paramBundle = this.rFR;
      if (paramBundle == null) {
        k.aVY("signatureEdt");
      }
      paramBundle.setText((CharSequence)rGw);
    }
    if (iRT != null)
    {
      this.qRN = iRT;
      setAvatar(this.qRN);
    }
    paramBundle = com.tencent.mm.kernel.g.agR();
    k.g(paramBundle, "MMKernel.storage()");
    int i = paramBundle.agA().getInt(12290, 0);
    if (i == 1)
    {
      rGx = "male";
      this.rGu = false;
    }
    for (;;)
    {
      paramBundle = new ArrayList();
      localObject1 = z.KUT;
      localObject1 = String.format("https://weixin.qq.com/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[] { ab.iC((Context)this) }, 1));
      k.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = z.KUT;
      localObject1 = String.format("https://weixin.qq.com/cgi-bin/readtemplate?t=finder_privacy", Arrays.copyOf(new Object[0], 0));
      k.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(getString(2131765895));
      ((ArrayList)localObject2).add(getString(2131766233));
      localObject1 = (Context)this;
      paramBundle = (List)paramBundle;
      String str = getString(2131766234);
      k.g(str, "getString(R.string.finder_create_contact_warning)");
      localObject2 = (List)localObject2;
      TextView localTextView = this.rGl;
      if (localTextView == null) {
        k.aVY("tipsWarningTV");
      }
      a((Context)localObject1, paramBundle, str, (List)localObject2, localTextView, this.TAG);
      cBx();
      cBy();
      com.tencent.mm.kernel.g.agi().a(3922, (com.tencent.mm.ak.g)this);
      com.tencent.mm.kernel.g.agi().a(3759, (com.tencent.mm.ak.g)this);
      this.scene = getIntent().getIntExtra("scene", 0);
      this.rsp = new aoy();
      paramBundle = getIntent().getByteArrayExtra("key_prepare_resp");
      if (paramBundle != null) {}
      try
      {
        localObject1 = this.rsp;
        if (localObject1 != null) {
          ((aoy)localObject1).parseFrom(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = y.KTp;
        }
      }
      paramBundle = this.rsp;
      if (paramBundle != null)
      {
        if (paramBundle.rGs > 0) {
          this.rGs = paramBundle.rGs;
        }
        if (paramBundle.rGt > 0) {
          this.rGt = paramBundle.rGt;
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 30L, 1L);
      AppMethodBeat.o(167175);
      return;
      if (i == 2)
      {
        rGx = "female";
        this.rGu = false;
      }
      else
      {
        this.rGu = true;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167182);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3922, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(3759, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167182);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(167183);
    ac.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof u))
    {
      paramString = this.rGq;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((u)paramn).csk();
        if (paramn != null)
        {
          paramString = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.a(this.scene, true, true, true);
          com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 32L, 1L);
          paramString = new Intent();
          paramString.putExtra("finder_username", paramn.username);
          paramString.putExtra("KEY_FINDER_SELF_FLAG", true);
          paramn = FinderReporterUIC.seQ;
          FinderReporterUIC.a.a((Context)this, paramString, 0L, 0, false, 124);
          paramn = com.tencent.mm.plugin.finder.utils.a.rOv;
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramString);
          finish();
        }
        AppMethodBeat.o(167183);
        return;
      }
      if (paramInt2 == -4003) {
        com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 37L, 1L);
      }
      for (;;)
      {
        paramString = ((u)paramn).rr.aBD();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
        AppMethodBeat.o(167183);
        throw paramString;
        if (paramInt2 == -4008) {
          com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 38L, 1L);
        }
      }
      paramString = ((ajl)paramString).verifyInfo;
      if (paramString != null)
      {
        ac.i(this.TAG, "verify info: " + com.tencent.mm.ac.f.bD(paramString));
        if (paramString.EFL == 1)
        {
          paramn = this.rFQ;
          if (paramn == null) {
            k.aVY("nickEdt");
          }
          paramn.setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100798));
        }
        while (!bs.isNullOrNil(paramString.EFI))
        {
          paramn = paramString.EFI;
          k.g(paramn, "it.bannerWording");
          Z(paramn, paramString.EFN, paramString.EFM);
          AppMethodBeat.o(167183);
          return;
          if (paramString.EFL == 2)
          {
            paramn = this.rFR;
            if (paramn == null) {
              k.aVY("signatureEdt");
            }
            paramn.setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100798));
          }
        }
        paramString = getString(2131759176);
        k.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
        Z(paramString, null, null);
        AppMethodBeat.o(167183);
        return;
      }
      paramString = (FinderCreateContactUI)this;
      paramn = paramString.getString(2131759176);
      k.g(paramn, "getString(R.string.finde…reate_contact_failed_tip)");
      paramString.Z(paramn, null, null);
      AppMethodBeat.o(167183);
      return;
    }
    if ((paramn instanceof av))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new aje();
        if (k.g(rGx, "female"))
        {
          paramInt1 = 0;
          paramString.exL = 2;
          if (!k.g(rGy, "unshow")) {
            break label624;
          }
          paramInt2 = 1;
        }
        for (;;)
        {
          paramString = new u(rGv, rGw, ((av)paramn).qYH, paramString, paramInt1, paramInt2);
          com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)paramString);
          AppMethodBeat.o(167183);
          return;
          if (k.g(rGx, "male"))
          {
            paramInt1 = 0;
            paramString.exL = 1;
            break;
          }
          paramInt1 = 1;
          paramString.exL = 0;
          break;
          label624:
          paramInt2 = 0;
          paramString.country = rGy;
          paramString.exV = rGz;
          paramString.exW = rGA;
        }
      }
      paramString = this.rGq;
      if (paramString != null) {
        paramString.dismiss();
      }
      com.tencent.mm.plugin.report.service.h.wUl.n(1279L, 33L, 1L);
      paramString = getString(2131759176);
      k.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
      Z(paramString, null, null);
    }
    AppMethodBeat.o(167183);
  }
  
  public final void onTipsCheckBoxClick(View paramView)
  {
    AppMethodBeat.i(203097);
    paramView = this.rGk;
    if (paramView == null) {
      k.aVY("tipsCheckCB");
    }
    CheckBox localCheckBox = this.rGk;
    if (localCheckBox == null) {
      k.aVY("tipsCheckCB");
    }
    if (!localCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(203097);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI$Companion;", "", "()V", "lastAvatarPath", "", "getLastAvatarPath", "()Ljava/lang/String;", "setLastAvatarPath", "(Ljava/lang/String;)V", "lastNickName", "getLastNickName", "setLastNickName", "lastSelectCityCode", "getLastSelectCityCode", "setLastSelectCityCode", "lastSelectCountryCode", "getLastSelectCountryCode", "setLastSelectCountryCode", "lastSelectProvinceCode", "getLastSelectProvinceCode", "setLastSelectProvinceCode", "lastSelectSex", "getLastSelectSex", "setLastSelectSex", "lastSignature", "getLastSignature", "setLastSignature", "plugin-finder_release"})
  public static final class a
  {
    public static void aen(String paramString)
    {
      AppMethodBeat.i(203093);
      k.h(paramString, "<set-?>");
      FinderCreateContactUI.ael(paramString);
      AppMethodBeat.o(203093);
    }
    
    public static void aeo(String paramString)
    {
      AppMethodBeat.i(203094);
      k.h(paramString, "<set-?>");
      FinderCreateContactUI.aem(paramString);
      AppMethodBeat.o(203094);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167160);
      com.tencent.mm.pluginsdk.ui.tools.q.o((Activity)this.rGC, FinderCreateContactUI.a(this.rGC));
      AppMethodBeat.o(167160);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167161);
      ac.i(FinderCreateContactUI.b(this.rGC), "doClick create contact btn");
      Object localObject2 = new com.tencent.mm.g.b.a.ae();
      Object localObject1 = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((com.tencent.mm.g.b.a.ae)localObject2).gw(paramView);
      Object localObject6 = this.rGC.getString(2131756087);
      Object localObject5 = this.rGC.getString(2131759280);
      Object localObject4 = this.rGC.getString(2131759356);
      Object localObject3 = this.rGC.getString(2131763400);
      paramView = FinderCreateContactUI.rGB;
      localObject1 = FinderCreateContactUI.c(this.rGC);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      k.h(paramView, "<set-?>");
      FinderCreateContactUI.aek(paramView);
      paramView = FinderCreateContactUI.rGB;
      paramView = FinderCreateContactUI.d(this.rGC).getText();
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
      FinderCreateContactUI.a.aen(paramView);
      paramView = FinderCreateContactUI.rGB;
      paramView = FinderCreateContactUI.e(this.rGC).getText();
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
      FinderCreateContactUI.a.aeo(paramView);
      paramView = new ArrayList();
      localObject1 = FinderCreateContactUI.rGB;
      if (com.tencent.mm.ui.tools.f.aRl(FinderCreateContactUI.cBA()) > FinderCreateContactUI.f(this.rGC)) {
        paramView.add(localObject5);
      }
      localObject1 = FinderCreateContactUI.rGB;
      if (com.tencent.mm.ui.tools.f.aRl(FinderCreateContactUI.cBB()) > FinderCreateContactUI.g(this.rGC)) {
        paramView.add(localObject4);
      }
      localObject1 = new ArrayList();
      FinderCreateContactUI.a locala = FinderCreateContactUI.rGB;
      int i;
      if (((CharSequence)FinderCreateContactUI.cBz()).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label606;
        }
        ((ArrayList)localObject1).add(localObject6);
        label379:
        localObject6 = FinderCreateContactUI.rGB;
        if (((CharSequence)FinderCreateContactUI.cBA()).length() != 0) {
          break label615;
        }
        i = 1;
        label400:
        if (i == 0) {
          break label620;
        }
        ((ArrayList)localObject1).add(localObject5);
        label411:
        localObject5 = FinderCreateContactUI.rGB;
        if (((CharSequence)FinderCreateContactUI.cBB()).length() != 0) {
          break label629;
        }
        i = 1;
        label432:
        if (i == 0) {
          break label634;
        }
        ((ArrayList)localObject1).add(localObject4);
        label443:
        localObject4 = FinderCreateContactUI.rGB;
        if (((CharSequence)FinderCreateContactUI.cBC()).length() != 0) {
          break label643;
        }
        i = 1;
        label464:
        if (i == 0) {
          break label648;
        }
        ((ArrayList)localObject1).add(localObject3);
        label475:
        localObject3 = FinderCreateContactUI.rGB;
        if (!bs.isNullOrNil(FinderCreateContactUI.cBD())) {
          ((com.tencent.mm.g.b.a.ae)localObject2).Qb();
        }
        if (!paramView.isEmpty()) {
          break label853;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          break label731;
        }
        if (!FinderCreateContactUI.h(this.rGC).isChecked()) {
          break label657;
        }
        FinderCreateContactUI.i(this.rGC);
        ((com.tencent.mm.g.b.a.ae)localObject2).cJ(1L);
      }
      for (;;)
      {
        ((com.tencent.mm.g.b.a.ae)localObject2).aHZ();
        paramView = FinderCreateContactUI.b(this.rGC);
        localObject1 = new StringBuilder("report19815 ");
        localObject2 = ((com.tencent.mm.g.b.a.ae)localObject2).PS();
        k.g(localObject2, "struct.toShowString()");
        ac.i(paramView, d.n.n.h((String)localObject2, "\r\n", " ", false));
        AppMethodBeat.o(167161);
        return;
        i = 0;
        break;
        label606:
        ((com.tencent.mm.g.b.a.ae)localObject2).PX();
        break label379;
        label615:
        i = 0;
        break label400;
        label620:
        ((com.tencent.mm.g.b.a.ae)localObject2).PY();
        break label411;
        label629:
        i = 0;
        break label432;
        label634:
        ((com.tencent.mm.g.b.a.ae)localObject2).PZ();
        break label443;
        label643:
        i = 0;
        break label464;
        label648:
        ((com.tencent.mm.g.b.a.ae)localObject2).Qa();
        break label475;
        label657:
        ac.i(FinderCreateContactUI.b(this.rGC), "not check agreement");
        paramView = this.rGC;
        localObject1 = this.rGC.getString(2131764859);
        k.g(localObject1, "getString(R.string.finder_agreement_not_check_tip)");
        FinderCreateContactUI.a(paramView, (String)localObject1);
        ((com.tencent.mm.g.b.a.ae)localObject2).cJ(2L);
        ((com.tencent.mm.g.b.a.ae)localObject2).cK(3L);
        ((com.tencent.mm.g.b.a.ae)localObject2).gx(this.rGC.getString(2131764859));
        continue;
        label731:
        ac.i(FinderCreateContactUI.b(this.rGC), "empty attr ".concat(String.valueOf(localObject1)));
        paramView = bs.n((List)localObject1, this.rGC.getString(2131766272));
        localObject1 = this.rGC;
        localObject3 = this.rGC.getString(2131766426, new Object[] { paramView });
        k.g(localObject3, "getString(R.string.finde…_empty_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((com.tencent.mm.g.b.a.ae)localObject2).cJ(2L);
        ((com.tencent.mm.g.b.a.ae)localObject2).cK(2L);
        ((com.tencent.mm.g.b.a.ae)localObject2).gx(this.rGC.getString(2131766426, new Object[] { paramView }));
        continue;
        label853:
        paramView = bs.n((List)paramView, this.rGC.getString(2131766272));
        localObject1 = this.rGC;
        localObject3 = this.rGC.getString(2131766427, new Object[] { paramView });
        k.g(localObject3, "getString(R.string.finde…o_long_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((com.tencent.mm.g.b.a.ae)localObject2).cJ(2L);
        ((com.tencent.mm.g.b.a.ae)localObject2).cK(1L);
        ((com.tencent.mm.g.b.a.ae)localObject2).gx(this.rGC.getString(2131766427, new Object[] { paramView }));
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class d
    implements TextView.OnEditorActionListener
  {
    d(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(167162);
      if (5 == paramInt)
      {
        FinderCreateContactUI.d(this.rGC).clearFocus();
        FinderCreateContactUI.e(this.rGC).requestFocus();
      }
      AppMethodBeat.o(167162);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167163);
      paramMenuItem = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.DS(5);
      paramMenuItem = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(FinderCreateContactUI.m(this.rGC), false, false, false);
      this.rGC.finish();
      AppMethodBeat.o(167163);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167164);
      FinderCreateContactUI.a(this.rGC, FinderCreateContactUI.n(this.rGC).getMeasuredHeight());
      AppMethodBeat.o(167164);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class g
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167168);
      com.tencent.mm.ui.tools.b.c.d(FinderCreateContactUI.d(this.rGC)).jQ(1, FinderCreateContactUI.f(this.rGC)).a(f.a.IRJ).fuc().a((c.a)new a(this));
      paramEditable = FinderCreateContactUI.rGB;
      paramEditable = FinderCreateContactUI.d(this.rGC).getText();
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
      FinderCreateContactUI.a.aen(paramEditable);
      FinderCreateContactUI.d(this.rGC).setTextColor(com.tencent.mm.cc.a.n((Context)this.rGC, 2131100711));
      AppMethodBeat.o(167168);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements c.a
    {
      public final void GK(String paramString)
      {
        AppMethodBeat.i(167167);
        int i = com.tencent.mm.ui.tools.f.cM(FinderCreateContactUI.f(this.rGD.rGC), paramString);
        FinderCreateContactUI.j(this.rGD.rGC).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.j(this.rGD.rGC).setTextColor(this.rGD.rGC.getResources().getColor(2131099660));
        if (i <= d.k.h.la((int)(FinderCreateContactUI.f(this.rGD.rGC) * 0.1F), 1)) {
          FinderCreateContactUI.j(this.rGD.rGC).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.k(this.rGD.rGC);
          AppMethodBeat.o(167167);
          return;
          FinderCreateContactUI.j(this.rGD.rGC).setVisibility(4);
        }
      }
      
      public final void aRi()
      {
        AppMethodBeat.i(167165);
        FinderCreateContactUI.j(this.rGD.rGC).setText((CharSequence)String.valueOf(FinderCreateContactUI.f(this.rGD.rGC)));
        FinderCreateContactUI.j(this.rGD.rGC).setTextColor(this.rGD.rGC.getResources().getColor(2131099660));
        AppMethodBeat.o(167165);
      }
      
      public final void ca(String paramString)
      {
        AppMethodBeat.i(167166);
        FinderCreateContactUI.j(this.rGD.rGC).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.f.cM(FinderCreateContactUI.f(this.rGD.rGC), paramString)));
        FinderCreateContactUI.j(this.rGD.rGC).setVisibility(0);
        FinderCreateContactUI.j(this.rGD.rGC).setTextColor(this.rGD.rGC.getResources().getColor(2131099804));
        paramString = this.rGD.rGC;
        String str = this.rGD.rGC.getString(2131759284);
        k.g(str, "getString(R.string.finder_nickname_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167166);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$signatureTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class h
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167172);
      com.tencent.mm.ui.tools.b.c.d(FinderCreateContactUI.e(this.rGC)).jQ(1, FinderCreateContactUI.g(this.rGC)).a(f.a.IRJ).fuc().a((c.a)new a(this));
      paramEditable = FinderCreateContactUI.rGB;
      paramEditable = FinderCreateContactUI.e(this.rGC).getText();
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
      FinderCreateContactUI.a.aeo(paramEditable);
      FinderCreateContactUI.e(this.rGC).setTextColor(com.tencent.mm.cc.a.n((Context)this.rGC, 2131100711));
      AppMethodBeat.o(167172);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$signatureTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements c.a
    {
      public final void GK(String paramString)
      {
        AppMethodBeat.i(167171);
        int i = com.tencent.mm.ui.tools.f.cM(FinderCreateContactUI.g(this.rGE.rGC), paramString);
        FinderCreateContactUI.l(this.rGE.rGC).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.l(this.rGE.rGC).setTextColor(this.rGE.rGC.getResources().getColor(2131099660));
        if (i <= d.k.h.la((int)(FinderCreateContactUI.g(this.rGE.rGC) * 0.1F), 1)) {
          FinderCreateContactUI.l(this.rGE.rGC).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.k(this.rGE.rGC);
          AppMethodBeat.o(167171);
          return;
          FinderCreateContactUI.l(this.rGE.rGC).setVisibility(4);
        }
      }
      
      public final void aRi()
      {
        AppMethodBeat.i(167169);
        FinderCreateContactUI.l(this.rGE.rGC).setText((CharSequence)String.valueOf(FinderCreateContactUI.g(this.rGE.rGC)));
        FinderCreateContactUI.l(this.rGE.rGC).setTextColor(this.rGE.rGC.getResources().getColor(2131099660));
        AppMethodBeat.o(167169);
      }
      
      public final void ca(String paramString)
      {
        AppMethodBeat.i(167170);
        FinderCreateContactUI.l(this.rGE.rGC).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.f.cM(FinderCreateContactUI.g(this.rGE.rGC), paramString)));
        FinderCreateContactUI.l(this.rGE.rGC).setVisibility(0);
        FinderCreateContactUI.l(this.rGE.rGC).setTextColor(this.rGE.rGC.getResources().getColor(2131099804));
        paramString = this.rGE.rGC;
        String str = this.rGE.rGC.getString(2131759357);
        k.g(str, "getString(R.string.finder_signature_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167170);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    j(FinderCreateContactUI paramFinderCreateContactUI, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178430);
      paramView = com.tencent.mm.plugin.finder.spam.a.rBD;
      paramView = this.rGC.getString(2131759252);
      k.g(paramView, "getString(R.string.finder_location_tip_gps)");
      com.tencent.mm.plugin.finder.spam.a.aea(paramView);
      AppMethodBeat.o(178430);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203096);
      paramView = com.tencent.mm.plugin.finder.spam.a.rBD;
      paramView = this.rGC.getString(2131766497);
      k.g(paramView, "getString(R.string.finder_sex_tip)");
      com.tencent.mm.plugin.finder.spam.a.aea(paramView);
      AppMethodBeat.o(203096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI
 * JD-Core Version:    0.7.0.1
 */