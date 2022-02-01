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
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bd;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b.a;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_CODE_SELECT_DISTRICT", "REQUEST_CODE_SELECT_SEX", "TAG", "", "avatarPath", "avatarView", "Landroid/widget/ImageView;", "cameraContainer", "Landroid/view/View;", "canSelectSex", "", "createBtn", "Landroid/widget/Button;", "districtLayout", "districtTV", "Landroid/widget/TextView;", "editBottomSpace", "editMiddleSpace", "editNickNameLimit", "editTopSpace", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "locationArrowIcon", "locationIcon", "locationInfoIcon", "nickEdt", "Landroid/widget/EditText;", "nicknameMaxLength", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollContainer", "scrollViewOriginHeight", "sexArrowIcon", "sexInfoIcon", "sexTV", "tipsCheckCB", "Landroid/widget/CheckBox;", "tipsWarningTV", "topErrorTip", "createContact", "", "getLayoutId", "hideError", "initContentView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickEditDistrict", "view", "onClickEditSex", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTipsCheckBoxClick", "setAvatar", "path", "setDistrictTV", "countryCodeName", "provinceCodeName", "cityCodeName", "setSpanTouch", "descTv", "text", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "spanLinks", "context", "Landroid/content/Context;", "h5urlList", "", "allText", "linkTextList", "logTag", "updateDistrict", "updateSex", "Companion", "plugin-finder_release"})
public final class FinderCreateContactUI
  extends MMFinderUI
  implements com.tencent.mm.al.f, b.a
{
  private static String jlb;
  private static String sBM;
  private static String sBN;
  private static String sBO;
  private static String sBP;
  private static String sBQ;
  public static final a sBR;
  private final String TAG = "Finder.FinderCreateContactUI";
  private HashMap _$_findViewCache;
  private ImageView iWu;
  private String rBN;
  private TextView sBA;
  private TextView sBB;
  private CheckBox sBC;
  private TextView sBD;
  private final int sBE = 1000;
  private final int sBF = 1001;
  private final int sBG = 1002;
  private final int sBH = 1003;
  private ProgressDialog sBI;
  private int sBJ;
  private int sBK = 20;
  private boolean sBL = true;
  private View sBj;
  private EditText sBk;
  private TextView sBl;
  private TextView sBm;
  private View sBn;
  private View sBo;
  private View sBp;
  private View sBq;
  private View sBr;
  private View sBs;
  private Button sBt;
  private View sBu;
  private View sBv;
  private View sBw;
  private InputPanelFrameLayout sBx;
  private View sBy;
  private View sBz;
  private int scene;
  private asp shx;
  
  static
  {
    AppMethodBeat.i(167188);
    sBR = new a((byte)0);
    jlb = "";
    sBM = "";
    sBN = "";
    sBO = "";
    sBP = "";
    sBQ = "";
    AppMethodBeat.o(167188);
  }
  
  private void a(Context paramContext, List<String> paramList1, String paramString1, List<String> paramList2, TextView paramTextView, String paramString2)
  {
    AppMethodBeat.i(203951);
    p.h(paramContext, "context");
    p.h(paramList1, "h5urlList");
    p.h(paramString1, "allText");
    p.h(paramList2, "linkTextList");
    p.h(paramTextView, "descTv");
    p.h(paramString2, "logTag");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString1);
    paramList2 = ((Iterable)paramList2).iterator();
    int i = 0;
    while (paramList2.hasNext())
    {
      Object localObject = paramList2.next();
      if (i < 0) {
        j.gfB();
      }
      localObject = (String)localObject;
      int j = d.n.n.a((CharSequence)paramString1, (String)localObject, 0, false, 6);
      int k = j + ((String)localObject).length();
      if ((j >= 0) && (k <= paramString1.length()))
      {
        localObject = (String)paramList1.get(i);
        Context localContext = aj.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        int m = localContext.getResources().getColor(2131100547);
        localContext = aj.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.i((String)localObject, m, localContext.getResources().getColor(2131099658), (d.g.a.b)new FinderCreateContactUI.j(paramString1, localSpannableString, paramList1, paramString2, paramContext)), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText((CharSequence)localSpannableString);
    a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(203951);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(203950);
    p.h(paramTextView, "descTv");
    p.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderCreateContactUI.h(this, paramSpannable, paramTextView));
    AppMethodBeat.o(203950);
  }
  
  private final void ac(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(203948);
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = com.tencent.mm.plugin.i.a.d.jrU.matcher((CharSequence)paramString1);
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
          AppMethodBeat.o(203948);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
          AppMethodBeat.o(203948);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      p.g(paramString1, "sb.toString()");
      int i = ((Matcher)localObject).start(0);
      int j = str1.length();
      paramString1 = new SpannableString((CharSequence)paramString1);
      p.g(str1, "content");
      localObject = getContext();
      p.g(localObject, "context");
      int k = ((AppCompatActivity)localObject).getResources().getColor(2131099769);
      localObject = getContext();
      p.g(localObject, "context");
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.i(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099776), false, (d.g.a.b)new i(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.sBA;
      if (paramString2 == null) {
        p.bcb("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.sBA;
      if (paramString2 == null) {
        p.bcb("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.sBA;
      if (paramString1 == null) {
        p.bcb("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(203948);
      return;
      paramString2 = this.sBA;
      if (paramString2 == null) {
        p.bcb("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
    }
  }
  
  private final void ad(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178431);
    RegionCodeDecoder.fsz();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.fsz();
    String str2 = RegionCodeDecoder.ma(paramString1, paramString2);
    RegionCodeDecoder.fsz();
    paramString1 = RegionCodeDecoder.bg(paramString1, paramString2, paramString3);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = this.sBm;
      if (paramString2 == null) {
        p.bcb("districtTV");
      }
      paramString2.setText((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zh(str2) + " " + paramString1));
      paramString1 = this.sBs;
      if (paramString1 == null) {
        p.bcb("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bt.isNullOrNil(str2))
    {
      paramString1 = this.sBm;
      if (paramString1 == null) {
        p.bcb("districtTV");
      }
      paramString1.setText((CharSequence)(str1 + ' ' + str2));
      paramString1 = this.sBs;
      if (paramString1 == null) {
        p.bcb("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bt.isNullOrNil(str1))
    {
      paramString1 = this.sBm;
      if (paramString1 == null) {
        p.bcb("districtTV");
      }
      paramString1.setText((CharSequence)str1);
      paramString1 = this.sBs;
      if (paramString1 == null) {
        p.bcb("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    paramString1 = this.sBs;
    if (paramString1 == null) {
      p.bcb("districtLayout");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(178431);
  }
  
  private final void cJB()
  {
    AppMethodBeat.i(167185);
    Object localObject = sBN;
    switch (((String)localObject).hashCode())
    {
    default: 
      localObject = this.sBl;
      if (localObject == null) {
        p.bcb("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759351));
      localObject = this.sBl;
      if (localObject == null) {
        p.bcb("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100490));
    }
    for (;;)
    {
      if (!this.sBL) {
        break label295;
      }
      localObject = this.sBq;
      if (localObject == null) {
        p.bcb("sexArrowIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.sBr;
      if (localObject == null) {
        p.bcb("sexInfoIcon");
      }
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(167185);
      return;
      if (!((String)localObject).equals("female")) {
        break;
      }
      localObject = this.sBl;
      if (localObject == null) {
        p.bcb("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763532));
      localObject = this.sBl;
      if (localObject == null) {
        p.bcb("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100711));
      continue;
      if (!((String)localObject).equals("male")) {
        break;
      }
      localObject = this.sBl;
      if (localObject == null) {
        p.bcb("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763533));
      localObject = this.sBl;
      if (localObject == null) {
        p.bcb("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100711));
    }
    label295:
    localObject = this.sBq;
    if (localObject == null) {
      p.bcb("sexArrowIcon");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.sBr;
    if (localObject == null) {
      p.bcb("sexInfoIcon");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.sBr;
    if (localObject == null) {
      p.bcb("sexInfoIcon");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new l(this));
    AppMethodBeat.o(167185);
  }
  
  private final void cJC()
  {
    AppMethodBeat.i(167186);
    Object localObject = this.sBm;
    if (localObject == null) {
      p.bcb("districtTV");
    }
    ((TextView)localObject).setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100711));
    localObject = com.tencent.mm.ui.component.a.KiD;
    localObject = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).sYY;
    if (localObject != null)
    {
      String str = ((azz)localObject).jdl;
      p.g(str, "it.Country");
      sBO = str;
      str = ((azz)localObject).jdd;
      p.g(str, "it.Province");
      sBP = str;
      localObject = ((azz)localObject).jde;
      p.g(localObject, "it.City");
      sBQ = (String)localObject;
      localObject = this.sBn;
      if (localObject == null) {
        p.bcb("locationIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.sBo;
      if (localObject == null) {
        p.bcb("locationArrowIcon");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.sBp;
      if (localObject == null) {
        p.bcb("locationInfoIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.sBp;
      if (localObject == null) {
        p.bcb("locationInfoIcon");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new k(this));
      ad(sBO, sBP, sBQ);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "updateDistrict " + sBO + ' ' + sBP + ' ' + sBQ);
      AppMethodBeat.o(167186);
      return;
      localObject = (FinderCreateContactUI)this;
      sBO = "unshow";
      sBP = "";
      sBQ = "";
      localObject = ((FinderCreateContactUI)localObject).sBs;
      if (localObject == null) {
        p.bcb("districtLayout");
      }
      ((View)localObject).setVisibility(8);
    }
  }
  
  private final void setAvatar(String paramString)
  {
    AppMethodBeat.i(167187);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.sdk.platformtools.g.d(paramString, 256, 256, false);
      if (paramString != null)
      {
        Object localObject = this.iWu;
        if (localObject == null) {
          p.bcb("avatarView");
        }
        ((ImageView)localObject).setImageBitmap(paramString);
        paramString = this.sBz;
        if (paramString == null) {
          p.bcb("cameraContainer");
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
        localObject = this.sBz;
        if (localObject == null) {
          p.bcb("cameraContainer");
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramString);
        paramString = this.sBz;
        if (paramString == null) {
          p.bcb("cameraContainer");
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
    AppMethodBeat.i(203953);
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
    AppMethodBeat.o(203953);
    return localView1;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167180);
    if (paramBoolean)
    {
      localObject = this.sBj;
      if (localObject == null) {
        p.bcb("scrollContainer");
      }
      localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((FrameLayout.LayoutParams)localObject).height = (this.sBJ - paramInt);
      localView = this.sBj;
      if (localView == null) {
        p.bcb("scrollContainer");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.sBu;
      if (localObject == null) {
        p.bcb("editTopSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.ax((Context)this, 2131165289);
      localView = this.sBu;
      if (localView == null) {
        p.bcb("editTopSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.sBv;
      if (localObject == null) {
        p.bcb("editMiddleSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.ax((Context)this, 2131165302);
      localView = this.sBv;
      if (localView == null) {
        p.bcb("editMiddleSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.sBw;
      if (localObject == null) {
        p.bcb("editBottomSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.ax((Context)this, 2131165289);
      localView = this.sBw;
      if (localView == null) {
        p.bcb("editBottomSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(167180);
      return;
    }
    Object localObject = this.sBj;
    if (localObject == null) {
      p.bcb("scrollContainer");
    }
    localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((FrameLayout.LayoutParams)localObject).height = this.sBJ;
    View localView = this.sBj;
    if (localView == null) {
      p.bcb("scrollContainer");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.sBu;
    if (localObject == null) {
      p.bcb("editTopSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.ax((Context)this, 2131165301);
    localView = this.sBu;
    if (localView == null) {
      p.bcb("editTopSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.sBv;
    if (localObject == null) {
      p.bcb("editMiddleSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = -2;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localView = this.sBv;
    if (localView == null) {
      p.bcb("editMiddleSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.sBw;
    if (localObject == null) {
      p.bcb("editBottomSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cc.a.ax((Context)this, 2131165277);
    localView = this.sBw;
    if (localView == null) {
      p.bcb("editBottomSpace");
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
    if (paramInt1 == this.sBE)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.j((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.azA());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.sBF);
        AppMethodBeat.o(167184);
      }
    }
    else if (paramInt1 == this.sBF)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        this.rBN = paramIntent.getStringExtra("key_result_img_path");
        paramIntent = this.rBN;
        if (paramIntent != null) {
          jlb = paramIntent;
        }
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(this.rBN) / 1024L) });
        setAvatar(this.rBN);
        AppMethodBeat.o(167184);
      }
    }
    else
    {
      Object localObject;
      if (paramInt1 == this.sBG)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          localObject = paramIntent.getStringExtra("key_output_sex");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          sBN = paramIntent;
          cJB();
          AppMethodBeat.o(167184);
        }
      }
      else if ((paramInt1 == this.sBH) && (paramIntent != null) && (paramInt2 == -1))
      {
        String str = paramIntent.getStringExtra("Country");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        sBO = (String)localObject;
        str = paramIntent.getStringExtra("Contact_Province");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        sBP = (String)localObject;
        localObject = paramIntent.getStringExtra("Contact_City");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        sBQ = paramIntent;
        cJC();
      }
    }
    AppMethodBeat.o(167184);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167178);
    super.onBackPressed();
    Object localObject = com.tencent.mm.plugin.finder.report.f.soC;
    com.tencent.mm.plugin.finder.report.f.EW(5);
    localObject = com.tencent.mm.plugin.finder.report.h.soM;
    com.tencent.mm.plugin.finder.report.h.h(this.scene, 0, false, false);
    AppMethodBeat.o(167178);
  }
  
  public final void onClickEditDistrict(View paramView)
  {
    AppMethodBeat.i(167177);
    paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGo() == 1)
    {
      paramView = this.sBk;
      if (paramView == null) {
        p.bcb("nickEdt");
      }
      paramView.clearFocus();
      hideVKB();
      g(false, 0);
      paramView = new Intent();
      paramView.putExtra("GetAddress", true);
      paramView.putExtra("ShowSelectedLocation", true);
      paramView.putExtra("SetSelectLocation", true);
      paramView.putExtra("SelectedCountryCode", sBO);
      paramView.putExtra("SelectedProvinceCode", sBP);
      paramView.putExtra("SelectedCityCode", sBQ);
      paramView.putExtra("NeedUnshowItem", true);
      com.tencent.mm.bs.d.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, this.sBH);
    }
    AppMethodBeat.o(167177);
  }
  
  public final void onClickEditSex(View paramView)
  {
    AppMethodBeat.i(167176);
    paramView = this.sBk;
    if (paramView == null) {
      p.bcb("nickEdt");
    }
    paramView.clearFocus();
    hideVKB();
    g(false, 0);
    if (this.sBL)
    {
      paramView = new Intent();
      paramView.putExtra("key_input_sex", sBN);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramView, this.sBG);
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
    p.g(paramBundle, "findViewById(R.id.scroll_container)");
    this.sBj = paramBundle;
    paramBundle = findViewById(2131299973);
    p.g(paramBundle, "findViewById(R.id.finder_avatar_iv)");
    this.iWu = ((ImageView)paramBundle);
    paramBundle = findViewById(2131300016);
    p.g(paramBundle, "findViewById(R.id.finder_nick_tv)");
    this.sBk = ((EditText)paramBundle);
    paramBundle = findViewById(2131300069);
    p.g(paramBundle, "findViewById(R.id.finder_sex_tv)");
    this.sBl = ((TextView)paramBundle);
    paramBundle = findViewById(2131299989);
    p.g(paramBundle, "findViewById(R.id.finder_district_tv)");
    this.sBm = ((TextView)paramBundle);
    paramBundle = findViewById(2131299152);
    p.g(paramBundle, "findViewById(R.id.district_layout)");
    this.sBs = paramBundle;
    paramBundle = findViewById(2131301524);
    p.g(paramBundle, "findViewById(R.id.location_icon)");
    this.sBn = paramBundle;
    paramBundle = findViewById(2131296941);
    p.g(paramBundle, "findViewById(R.id.arrow_icon)");
    this.sBo = paramBundle;
    paramBundle = findViewById(2131301007);
    p.g(paramBundle, "findViewById(R.id.info_icon)");
    this.sBp = paramBundle;
    paramBundle = findViewById(2131307976);
    p.g(paramBundle, "findViewById(R.id.sex_arrow_icon)");
    this.sBq = paramBundle;
    paramBundle = findViewById(2131307977);
    p.g(paramBundle, "findViewById(R.id.sex_info_icon)");
    this.sBr = paramBundle;
    paramBundle = findViewById(2131299984);
    p.g(paramBundle, "findViewById(R.id.finder_contact_create_btn)");
    this.sBt = ((Button)paramBundle);
    paramBundle = findViewById(2131301033);
    p.g(paramBundle, "findViewById(R.id.input_panel)");
    this.sBx = ((InputPanelFrameLayout)paramBundle);
    paramBundle = findViewById(2131300001);
    p.g(paramBundle, "findViewById(R.id.finder_input_container)");
    this.sBy = paramBundle;
    paramBundle = findViewById(2131299311);
    p.g(paramBundle, "findViewById(R.id.edt_top_space)");
    this.sBu = paramBundle;
    paramBundle = findViewById(2131299310);
    p.g(paramBundle, "findViewById(R.id.edt_middle_space)");
    this.sBv = paramBundle;
    paramBundle = findViewById(2131299308);
    p.g(paramBundle, "findViewById(R.id.edt_bottom_space)");
    this.sBw = paramBundle;
    paramBundle = findViewById(2131299976);
    p.g(paramBundle, "findViewById(R.id.finder_camera_container)");
    this.sBz = paramBundle;
    paramBundle = findViewById(2131306005);
    p.g(paramBundle, "findViewById(R.id.top_error_tip)");
    this.sBA = ((TextView)paramBundle);
    paramBundle = findViewById(2131300018);
    p.g(paramBundle, "findViewById(R.id.finder_nickname_edit_limit)");
    this.sBB = ((TextView)paramBundle);
    paramBundle = findViewById(2131308030);
    p.g(paramBundle, "findViewById(R.id.tips_check_cb)");
    this.sBC = ((CheckBox)paramBundle);
    paramBundle = findViewById(2131308032);
    p.g(paramBundle, "findViewById(R.id.tips_warning_tv)");
    this.sBD = ((TextView)paramBundle);
    paramBundle = this.iWu;
    if (paramBundle == null) {
      p.bcb("avatarView");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = this.sBt;
    if (paramBundle == null) {
      p.bcb("createBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = (TextWatcher)new g(this);
    Object localObject1 = this.sBk;
    if (localObject1 == null) {
      p.bcb("nickEdt");
    }
    ((EditText)localObject1).addTextChangedListener(paramBundle);
    paramBundle = this.sBk;
    if (paramBundle == null) {
      p.bcb("nickEdt");
    }
    paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    paramBundle = this.sBx;
    if (paramBundle == null) {
      p.bcb("inputPanel");
    }
    paramBundle.setExternalListener((b.a)this);
    paramBundle = this.sBj;
    if (paramBundle == null) {
      p.bcb("scrollContainer");
    }
    paramBundle.post((Runnable)new f(this));
    if (sBM != null)
    {
      paramBundle = this.sBk;
      if (paramBundle == null) {
        p.bcb("nickEdt");
      }
      paramBundle.setText((CharSequence)sBM);
    }
    if (jlb != null)
    {
      this.rBN = jlb;
      setAvatar(this.rBN);
    }
    paramBundle = com.tencent.mm.kernel.g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    int i = paramBundle.ajl().getInt(12290, 0);
    if (i == 1)
    {
      sBN = "male";
      this.sBL = false;
    }
    for (;;)
    {
      paramBundle = new ArrayList();
      localObject1 = d.g.b.ad.MLZ;
      localObject1 = String.format("https://weixin.qq.com/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[] { ac.iM((Context)this) }, 1));
      p.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = d.g.b.ad.MLZ;
      localObject1 = String.format("https://weixin.qq.com/cgi-bin/readtemplate?t=finder_privacy", Arrays.copyOf(new Object[0], 0));
      p.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(getString(2131765895));
      ((ArrayList)localObject2).add(getString(2131766233));
      localObject1 = (Context)this;
      paramBundle = (List)paramBundle;
      String str = getString(2131766234);
      p.g(str, "getString(R.string.finder_create_contact_warning)");
      localObject2 = (List)localObject2;
      TextView localTextView = this.sBD;
      if (localTextView == null) {
        p.bcb("tipsWarningTV");
      }
      a((Context)localObject1, paramBundle, str, (List)localObject2, localTextView, this.TAG);
      cJB();
      cJC();
      com.tencent.mm.kernel.g.aiU().a(3922, (com.tencent.mm.al.f)this);
      com.tencent.mm.kernel.g.aiU().a(3759, (com.tencent.mm.al.f)this);
      this.scene = getIntent().getIntExtra("scene", 0);
      this.shx = new asp();
      paramBundle = getIntent().getByteArrayExtra("key_prepare_resp");
      if (paramBundle != null) {}
      try
      {
        localObject1 = this.shx;
        if (localObject1 != null) {
          ((asp)localObject1).parseFrom(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = d.z.MKo;
        }
      }
      paramBundle = this.shx;
      if ((paramBundle != null) && (paramBundle.sBK > 0)) {
        this.sBK = paramBundle.sBK;
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 30L, 1L);
      AppMethodBeat.o(167175);
      return;
      if (i == 2)
      {
        sBN = "female";
        this.sBL = false;
      }
      else
      {
        this.sBL = true;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167182);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(3922, (com.tencent.mm.al.f)this);
    com.tencent.mm.kernel.g.aiU().b(3759, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(167182);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(167183);
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.finder.cgi.z))
    {
      paramString = this.sBI;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((com.tencent.mm.plugin.finder.cgi.z)paramn).cya();
        if (paramn != null)
        {
          paramString = com.tencent.mm.plugin.finder.report.h.soM;
          com.tencent.mm.plugin.finder.report.h.h(this.scene, 1, true, true);
          com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 32L, 1L);
          paramString = new Intent();
          paramString.putExtra("finder_username", paramn.username);
          paramString.putExtra("KEY_FINDER_SELF_FLAG", true);
          paramn = FinderReporterUIC.tcM;
          FinderReporterUIC.a.a((Context)this, paramString, 0L, 0, false, 124);
          paramn = com.tencent.mm.plugin.finder.utils.a.sKD;
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramString);
          finish();
          AppMethodBeat.o(167183);
          return;
        }
        AppMethodBeat.o(167183);
        return;
      }
      if (paramInt2 == -4003) {
        com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 37L, 1L);
      }
      for (;;)
      {
        paramString = ((com.tencent.mm.plugin.finder.cgi.z)paramn).rr.aEF();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
        AppMethodBeat.o(167183);
        throw paramString;
        if (paramInt2 == -4008) {
          com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 38L, 1L);
        }
      }
      paramString = ((amg)paramString).verifyInfo;
      if (paramString != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "verify info: " + com.tencent.mm.ad.f.bF(paramString));
        if (paramString.Gog == 1)
        {
          paramn = this.sBk;
          if (paramn == null) {
            p.bcb("nickEdt");
          }
          paramn.setTextColor(com.tencent.mm.cc.a.n((Context)this, 2131100798));
        }
        if (!bt.isNullOrNil(paramString.God))
        {
          paramn = paramString.God;
          p.g(paramn, "it.bannerWording");
          ac(paramn, paramString.Goi, paramString.Goh);
          AppMethodBeat.o(167183);
          return;
        }
        paramString = getString(2131759176);
        p.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
        ac(paramString, null, null);
        AppMethodBeat.o(167183);
        return;
      }
      paramString = (FinderCreateContactUI)this;
      paramn = paramString.getString(2131759176);
      p.g(paramn, "getString(R.string.finde…reate_contact_failed_tip)");
      paramString.ac(paramn, null, null);
      AppMethodBeat.o(167183);
      return;
    }
    if ((paramn instanceof bd))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new alx();
        if (p.i(sBN, "female"))
        {
          paramInt1 = 0;
          paramString.ePk = 2;
          if (!p.i(sBO, "unshow")) {
            break label587;
          }
          paramInt2 = 1;
        }
        for (;;)
        {
          paramString = new com.tencent.mm.plugin.finder.cgi.z(sBM, "", ((bd)paramn).rJX, paramString, paramInt1, paramInt2);
          com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)paramString);
          AppMethodBeat.o(167183);
          return;
          if (p.i(sBN, "male"))
          {
            paramInt1 = 0;
            paramString.ePk = 1;
            break;
          }
          paramInt1 = 1;
          paramString.ePk = 0;
          break;
          label587:
          paramInt2 = 0;
          paramString.country = sBO;
          paramString.ePu = sBP;
          paramString.ePv = sBQ;
        }
      }
      paramString = this.sBI;
      if (paramString != null) {
        paramString.dismiss();
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 33L, 1L);
      paramString = getString(2131759176);
      p.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
      ac(paramString, null, null);
    }
    AppMethodBeat.o(167183);
  }
  
  public final void onTipsCheckBoxClick(View paramView)
  {
    AppMethodBeat.i(203947);
    paramView = this.sBC;
    if (paramView == null) {
      p.bcb("tipsCheckCB");
    }
    CheckBox localCheckBox = this.sBC;
    if (localCheckBox == null) {
      p.bcb("tipsCheckCB");
    }
    if (!localCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(203947);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI$Companion;", "", "()V", "lastAvatarPath", "", "getLastAvatarPath", "()Ljava/lang/String;", "setLastAvatarPath", "(Ljava/lang/String;)V", "lastNickName", "getLastNickName", "setLastNickName", "lastSelectCityCode", "getLastSelectCityCode", "setLastSelectCityCode", "lastSelectCountryCode", "getLastSelectCountryCode", "setLastSelectCountryCode", "lastSelectProvinceCode", "getLastSelectProvinceCode", "setLastSelectProvinceCode", "lastSelectSex", "getLastSelectSex", "setLastSelectSex", "plugin-finder_release"})
  public static final class a
  {
    public static void aiH(String paramString)
    {
      AppMethodBeat.i(203944);
      p.h(paramString, "<set-?>");
      FinderCreateContactUI.aiG(paramString);
      AppMethodBeat.o(203944);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167160);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      com.tencent.mm.pluginsdk.ui.tools.q.o((Activity)this.sBS, FinderCreateContactUI.a(this.sBS));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167160);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167161);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      com.tencent.mm.sdk.platformtools.ad.i(FinderCreateContactUI.b(this.sBS), "doClick create contact btn");
      Object localObject2 = new am();
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((am)localObject2).hG(paramView);
      Object localObject5 = this.sBS.getString(2131756087);
      Object localObject4 = this.sBS.getString(2131759280);
      Object localObject3 = this.sBS.getString(2131763400);
      paramView = FinderCreateContactUI.sBR;
      localObject1 = FinderCreateContactUI.c(this.sBS);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      p.h(paramView, "<set-?>");
      FinderCreateContactUI.aiF(paramView);
      paramView = FinderCreateContactUI.sBR;
      paramView = FinderCreateContactUI.d(this.sBS).getText();
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
            break label218;
          }
        }
      }
      paramView = "";
      label218:
      FinderCreateContactUI.a.aiH(paramView);
      paramView = new ArrayList();
      localObject1 = FinderCreateContactUI.sBR;
      if (com.tencent.mm.ui.tools.f.aXj(FinderCreateContactUI.cJE()) > FinderCreateContactUI.e(this.sBS)) {
        paramView.add(localObject4);
      }
      localObject1 = new ArrayList();
      FinderCreateContactUI.a locala = FinderCreateContactUI.sBR;
      int i;
      if (((CharSequence)FinderCreateContactUI.cJD()).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label504;
        }
        ((ArrayList)localObject1).add(localObject5);
        label297:
        localObject5 = FinderCreateContactUI.sBR;
        if (((CharSequence)FinderCreateContactUI.cJE()).length() != 0) {
          break label513;
        }
        i = 1;
        label318:
        if (i == 0) {
          break label518;
        }
        ((ArrayList)localObject1).add(localObject4);
        label329:
        localObject4 = FinderCreateContactUI.sBR;
        if (((CharSequence)FinderCreateContactUI.cJF()).length() != 0) {
          break label527;
        }
        i = 1;
        label350:
        if (i == 0) {
          break label532;
        }
        ((ArrayList)localObject1).add(localObject3);
        label361:
        localObject3 = FinderCreateContactUI.sBR;
        if (!bt.isNullOrNil(FinderCreateContactUI.cJG())) {
          ((am)localObject2).RP();
        }
        if (!paramView.isEmpty()) {
          break label741;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          break label619;
        }
        if (!FinderCreateContactUI.f(this.sBS).isChecked()) {
          break label541;
        }
        FinderCreateContactUI.g(this.sBS);
        ((am)localObject2).de(1L);
      }
      for (;;)
      {
        ((am)localObject2).aLk();
        paramView = FinderCreateContactUI.b(this.sBS);
        localObject1 = new StringBuilder("report19815 ");
        localObject2 = ((am)localObject2).RE();
        p.g(localObject2, "struct.toShowString()");
        com.tencent.mm.sdk.platformtools.ad.i(paramView, d.n.n.h((String)localObject2, "\r\n", " ", false));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167161);
        return;
        i = 0;
        break;
        label504:
        ((am)localObject2).RM();
        break label297;
        label513:
        i = 0;
        break label318;
        label518:
        ((am)localObject2).RN();
        break label329;
        label527:
        i = 0;
        break label350;
        label532:
        ((am)localObject2).RO();
        break label361;
        label541:
        com.tencent.mm.sdk.platformtools.ad.i(FinderCreateContactUI.b(this.sBS), "not check agreement");
        paramView = this.sBS;
        localObject1 = this.sBS.getString(2131764859);
        p.g(localObject1, "getString(R.string.finder_agreement_not_check_tip)");
        FinderCreateContactUI.a(paramView, (String)localObject1);
        ((am)localObject2).de(2L);
        ((am)localObject2).df(3L);
        ((am)localObject2).hH(this.sBS.getString(2131764859));
        continue;
        label619:
        com.tencent.mm.sdk.platformtools.ad.i(FinderCreateContactUI.b(this.sBS), "empty attr ".concat(String.valueOf(localObject1)));
        paramView = bt.m((List)localObject1, this.sBS.getString(2131766272));
        localObject1 = this.sBS;
        localObject3 = this.sBS.getString(2131766426, new Object[] { paramView });
        p.g(localObject3, "getString(R.string.finde…_empty_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((am)localObject2).de(2L);
        ((am)localObject2).df(2L);
        ((am)localObject2).hH(this.sBS.getString(2131766426, new Object[] { paramView }));
        continue;
        label741:
        paramView = bt.m((List)paramView, this.sBS.getString(2131766272));
        localObject1 = this.sBS;
        localObject3 = this.sBS.getString(2131766427, new Object[] { paramView });
        p.g(localObject3, "getString(R.string.finde…o_long_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((am)localObject2).de(2L);
        ((am)localObject2).df(1L);
        ((am)localObject2).hH(this.sBS.getString(2131766427, new Object[] { paramView }));
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class d
    implements TextView.OnEditorActionListener
  {
    d(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(167162);
      if (5 == paramInt) {
        FinderCreateContactUI.d(this.sBS).clearFocus();
      }
      AppMethodBeat.o(167162);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167163);
      paramMenuItem = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.EW(5);
      paramMenuItem = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.h(FinderCreateContactUI.j(this.sBS), 0, false, false);
      this.sBS.finish();
      AppMethodBeat.o(167163);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167164);
      FinderCreateContactUI.a(this.sBS, FinderCreateContactUI.k(this.sBS).getMeasuredHeight());
      AppMethodBeat.o(167164);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class g
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167168);
      com.tencent.mm.ui.tools.b.c.d(FinderCreateContactUI.d(this.sBS)).kc(1, FinderCreateContactUI.e(this.sBS)).a(f.a.KIN).fKP().a((c.a)new a(this));
      paramEditable = FinderCreateContactUI.sBR;
      paramEditable = FinderCreateContactUI.d(this.sBS).getText();
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
      FinderCreateContactUI.a.aiH(paramEditable);
      FinderCreateContactUI.d(this.sBS).setTextColor(com.tencent.mm.cc.a.n((Context)this.sBS, 2131100711));
      AppMethodBeat.o(167168);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements c.a
    {
      public final void JZ(String paramString)
      {
        AppMethodBeat.i(167167);
        int i = com.tencent.mm.ui.tools.f.cU(FinderCreateContactUI.e(this.sBT.sBS), paramString);
        FinderCreateContactUI.h(this.sBT.sBS).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.h(this.sBT.sBS).setTextColor(this.sBT.sBS.getResources().getColor(2131099660));
        if (i <= d.k.h.lp((int)(FinderCreateContactUI.e(this.sBT.sBS) * 0.1F), 1)) {
          FinderCreateContactUI.h(this.sBT.sBS).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.i(this.sBT.sBS);
          AppMethodBeat.o(167167);
          return;
          FinderCreateContactUI.h(this.sBT.sBS).setVisibility(4);
        }
      }
      
      public final void aUu()
      {
        AppMethodBeat.i(167165);
        FinderCreateContactUI.h(this.sBT.sBS).setText((CharSequence)String.valueOf(FinderCreateContactUI.e(this.sBT.sBS)));
        FinderCreateContactUI.h(this.sBT.sBS).setTextColor(this.sBT.sBS.getResources().getColor(2131099660));
        AppMethodBeat.o(167165);
      }
      
      public final void cU(String paramString)
      {
        AppMethodBeat.i(167166);
        FinderCreateContactUI.h(this.sBT.sBS).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.f.cU(FinderCreateContactUI.e(this.sBT.sBS), paramString)));
        FinderCreateContactUI.h(this.sBT.sBS).setVisibility(0);
        FinderCreateContactUI.h(this.sBT.sBS).setTextColor(this.sBT.sBS.getResources().getColor(2131099804));
        paramString = this.sBT.sBS;
        String str = this.sBT.sBS.getString(2131759284);
        p.g(str, "getString(R.string.finder_nickname_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167166);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    i(FinderCreateContactUI paramFinderCreateContactUI, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$1$1"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178430);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.spam.a.suA;
      paramView = this.sBS.getString(2131759252);
      p.g(paramView, "getString(R.string.finder_location_tip_gps)");
      com.tencent.mm.plugin.finder.spam.a.aim(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178430);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203946);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.spam.a.suA;
      paramView = this.sBS.getString(2131766497);
      p.g(paramView, "getString(R.string.finder_sex_tip)");
      com.tencent.mm.plugin.finder.spam.a.aim(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI
 * JD-Core Version:    0.7.0.1
 */