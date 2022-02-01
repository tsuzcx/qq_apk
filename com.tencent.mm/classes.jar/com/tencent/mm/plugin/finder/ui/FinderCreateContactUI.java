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
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.be;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_CODE_SELECT_DISTRICT", "REQUEST_CODE_SELECT_SEX", "TAG", "", "avatarPath", "avatarView", "Landroid/widget/ImageView;", "cameraContainer", "Landroid/view/View;", "canSelectSex", "", "createBtn", "Landroid/widget/Button;", "districtLayout", "districtTV", "Landroid/widget/TextView;", "editBottomSpace", "editMiddleSpace", "editNickNameLimit", "editTopSpace", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "locationArrowIcon", "locationIcon", "locationInfoIcon", "nickEdt", "Landroid/widget/EditText;", "nicknameMaxLength", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollContainer", "scrollViewOriginHeight", "sexArrowIcon", "sexInfoIcon", "sexTV", "tipsCheckCB", "Landroid/widget/CheckBox;", "tipsWarningTV", "topErrorTip", "createContact", "", "getLayoutId", "hideError", "initContentView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickEditDistrict", "view", "onClickEditSex", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "keyboardHeight", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTipsCheckBoxClick", "setAvatar", "path", "setDistrictTV", "countryCodeName", "provinceCodeName", "cityCodeName", "setSpanTouch", "descTv", "text", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "spanLinks", "context", "Landroid/content/Context;", "h5urlList", "", "allText", "linkTextList", "logTag", "updateDistrict", "updateSex", "Companion", "plugin-finder_release"})
public final class FinderCreateContactUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f, b.a
{
  private static String jnV;
  private static String sML;
  private static String sMM;
  private static String sMN;
  private static String sMO;
  private static String sMP;
  public static final a sMQ;
  private final String TAG = "Finder.FinderCreateContactUI";
  private HashMap _$_findViewCache;
  private ImageView iZn;
  private String rJY;
  private TextView sMA;
  private CheckBox sMB;
  private TextView sMC;
  private final int sMD = 1000;
  private final int sME = 1001;
  private final int sMF = 1002;
  private final int sMG = 1003;
  private ProgressDialog sMH;
  private int sMI;
  private int sMJ = 20;
  private boolean sMK = true;
  private View sMi;
  private EditText sMj;
  private TextView sMk;
  private TextView sMl;
  private View sMm;
  private View sMn;
  private View sMo;
  private View sMp;
  private View sMq;
  private View sMr;
  private Button sMs;
  private View sMt;
  private View sMu;
  private View sMv;
  private InputPanelFrameLayout sMw;
  private View sMx;
  private View sMy;
  private TextView sMz;
  private int scene;
  private atf sqs;
  
  static
  {
    AppMethodBeat.i(167188);
    sMQ = new a((byte)0);
    jnV = "";
    sML = "";
    sMM = "";
    sMN = "";
    sMO = "";
    sMP = "";
    AppMethodBeat.o(167188);
  }
  
  private void a(Context paramContext, List<String> paramList1, String paramString1, List<String> paramList2, TextView paramTextView, String paramString2)
  {
    AppMethodBeat.i(204547);
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
        d.a.j.gkd();
      }
      localObject = (String)localObject;
      int j = d.n.n.a((CharSequence)paramString1, (String)localObject, 0, false, 6);
      int k = j + ((String)localObject).length();
      if ((j >= 0) && (k <= paramString1.length()))
      {
        localObject = (String)paramList1.get(i);
        Context localContext = ak.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        int m = localContext.getResources().getColor(2131100547);
        localContext = ak.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.j((String)localObject, m, localContext.getResources().getColor(2131099658), (d.g.a.b)new FinderCreateContactUI.j(paramString1, localSpannableString, paramList1, paramString2, paramContext)), j, k, 17);
      }
      i += 1;
    }
    paramTextView.setText((CharSequence)localSpannableString);
    a(paramTextView, (Spannable)localSpannableString);
    AppMethodBeat.o(204547);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(204546);
    p.h(paramTextView, "descTv");
    p.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderCreateContactUI.h(this, paramSpannable, paramTextView));
    AppMethodBeat.o(204546);
  }
  
  private final void ad(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(204544);
    ae.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = com.tencent.mm.plugin.i.a.d.juN.matcher((CharSequence)paramString1);
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
          AppMethodBeat.o(204544);
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
          AppMethodBeat.o(204544);
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
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.j(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099776), false, (d.g.a.b)new i(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.sMz;
      if (paramString2 == null) {
        p.bdF("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.sMz;
      if (paramString2 == null) {
        p.bdF("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.sMz;
      if (paramString1 == null) {
        p.bdF("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(204544);
      return;
      paramString2 = this.sMz;
      if (paramString2 == null) {
        p.bdF("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
    }
  }
  
  private final void ae(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178431);
    RegionCodeDecoder.fwA();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.fwA();
    String str2 = RegionCodeDecoder.mh(paramString1, paramString2);
    RegionCodeDecoder.fwA();
    paramString1 = RegionCodeDecoder.bh(paramString1, paramString2, paramString3);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = this.sMl;
      if (paramString2 == null) {
        p.bdF("districtTV");
      }
      paramString2.setText((CharSequence)(((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zR(str2) + " " + paramString1));
      paramString1 = this.sMr;
      if (paramString1 == null) {
        p.bdF("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bu.isNullOrNil(str2))
    {
      paramString1 = this.sMl;
      if (paramString1 == null) {
        p.bdF("districtTV");
      }
      paramString1.setText((CharSequence)(str1 + ' ' + str2));
      paramString1 = this.sMr;
      if (paramString1 == null) {
        p.bdF("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    if (!bu.isNullOrNil(str1))
    {
      paramString1 = this.sMl;
      if (paramString1 == null) {
        p.bdF("districtTV");
      }
      paramString1.setText((CharSequence)str1);
      paramString1 = this.sMr;
      if (paramString1 == null) {
        p.bdF("districtLayout");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(178431);
      return;
    }
    paramString1 = this.sMr;
    if (paramString1 == null) {
      p.bdF("districtLayout");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(178431);
  }
  
  private final void cMe()
  {
    AppMethodBeat.i(167185);
    Object localObject = sMM;
    switch (((String)localObject).hashCode())
    {
    default: 
      localObject = this.sMk;
      if (localObject == null) {
        p.bdF("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759351));
      localObject = this.sMk;
      if (localObject == null) {
        p.bdF("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100490));
    }
    for (;;)
    {
      if (!this.sMK) {
        break label295;
      }
      localObject = this.sMp;
      if (localObject == null) {
        p.bdF("sexArrowIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.sMq;
      if (localObject == null) {
        p.bdF("sexInfoIcon");
      }
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(167185);
      return;
      if (!((String)localObject).equals("female")) {
        break;
      }
      localObject = this.sMk;
      if (localObject == null) {
        p.bdF("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763532));
      localObject = this.sMk;
      if (localObject == null) {
        p.bdF("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100711));
      continue;
      if (!((String)localObject).equals("male")) {
        break;
      }
      localObject = this.sMk;
      if (localObject == null) {
        p.bdF("sexTV");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131763533));
      localObject = this.sMk;
      if (localObject == null) {
        p.bdF("sexTV");
      }
      ((TextView)localObject).setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100711));
    }
    label295:
    localObject = this.sMp;
    if (localObject == null) {
      p.bdF("sexArrowIcon");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.sMq;
    if (localObject == null) {
      p.bdF("sexInfoIcon");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.sMq;
    if (localObject == null) {
      p.bdF("sexInfoIcon");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new l(this));
    AppMethodBeat.o(167185);
  }
  
  private final void cMf()
  {
    AppMethodBeat.i(167186);
    Object localObject = this.sMl;
    if (localObject == null) {
      p.bdF("districtTV");
    }
    ((TextView)localObject).setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100711));
    localObject = com.tencent.mm.ui.component.a.KEX;
    localObject = ((FinderGlobalLocationVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).tkm;
    if (localObject != null)
    {
      String str = ((bap)localObject).jge;
      p.g(str, "it.Country");
      sMN = str;
      str = ((bap)localObject).jfW;
      p.g(str, "it.Province");
      sMO = str;
      localObject = ((bap)localObject).jfX;
      p.g(localObject, "it.City");
      sMP = (String)localObject;
      localObject = this.sMm;
      if (localObject == null) {
        p.bdF("locationIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.sMn;
      if (localObject == null) {
        p.bdF("locationArrowIcon");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.sMo;
      if (localObject == null) {
        p.bdF("locationInfoIcon");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.sMo;
      if (localObject == null) {
        p.bdF("locationInfoIcon");
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new k(this));
      ae(sMN, sMO, sMP);
    }
    for (;;)
    {
      ae.i(this.TAG, "updateDistrict " + sMN + ' ' + sMO + ' ' + sMP);
      AppMethodBeat.o(167186);
      return;
      localObject = (FinderCreateContactUI)this;
      sMN = "unshow";
      sMO = "";
      sMP = "";
      localObject = ((FinderCreateContactUI)localObject).sMr;
      if (localObject == null) {
        p.bdF("districtLayout");
      }
      ((View)localObject).setVisibility(8);
    }
  }
  
  private final void setAvatar(String paramString)
  {
    AppMethodBeat.i(167187);
    if (!bu.isNullOrNil(paramString))
    {
      paramString = h.d(paramString, 256, 256, false);
      if (paramString != null)
      {
        Object localObject = this.iZn;
        if (localObject == null) {
          p.bdF("avatarView");
        }
        ((ImageView)localObject).setImageBitmap(paramString);
        paramString = this.sMy;
        if (paramString == null) {
          p.bdF("cameraContainer");
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
        localObject = this.sMy;
        if (localObject == null) {
          p.bdF("cameraContainer");
        }
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)paramString);
        paramString = this.sMy;
        if (paramString == null) {
          p.bdF("cameraContainer");
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
    AppMethodBeat.i(204549);
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
    AppMethodBeat.o(204549);
    return localView1;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167180);
    if (paramBoolean)
    {
      localObject = this.sMi;
      if (localObject == null) {
        p.bdF("scrollContainer");
      }
      localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((FrameLayout.LayoutParams)localObject).height = (this.sMI - paramInt);
      localView = this.sMi;
      if (localView == null) {
        p.bdF("scrollContainer");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.sMt;
      if (localObject == null) {
        p.bdF("editTopSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.ax((Context)this, 2131165289);
      localView = this.sMt;
      if (localView == null) {
        p.bdF("editTopSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.sMu;
      if (localObject == null) {
        p.bdF("editMiddleSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.ax((Context)this, 2131165302);
      localView = this.sMu;
      if (localView == null) {
        p.bdF("editMiddleSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.sMv;
      if (localObject == null) {
        p.bdF("editBottomSpace");
      }
      localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.ax((Context)this, 2131165289);
      localView = this.sMv;
      if (localView == null) {
        p.bdF("editBottomSpace");
      }
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(167180);
      return;
    }
    Object localObject = this.sMi;
    if (localObject == null) {
      p.bdF("scrollContainer");
    }
    localObject = new FrameLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((FrameLayout.LayoutParams)localObject).height = this.sMI;
    View localView = this.sMi;
    if (localView == null) {
      p.bdF("scrollContainer");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.sMt;
    if (localObject == null) {
      p.bdF("editTopSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.ax((Context)this, 2131165301);
    localView = this.sMt;
    if (localView == null) {
      p.bdF("editTopSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.sMu;
    if (localObject == null) {
      p.bdF("editMiddleSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = -2;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localView = this.sMu;
    if (localView == null) {
      p.bdF("editMiddleSpace");
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.sMv;
    if (localObject == null) {
      p.bdF("editBottomSpace");
    }
    localObject = new LinearLayout.LayoutParams(((View)localObject).getLayoutParams());
    ((LinearLayout.LayoutParams)localObject).height = com.tencent.mm.cb.a.ax((Context)this, 2131165277);
    localView = this.sMv;
    if (localView == null) {
      p.bdF("editBottomSpace");
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
    if (paramInt1 == this.sMD)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.a.j((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.azQ());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.b((Activity)this, getIntent(), this.sME);
        AppMethodBeat.o(167184);
      }
    }
    else if (paramInt1 == this.sME)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        this.rJY = paramIntent.getStringExtra("key_result_img_path");
        paramIntent = this.rJY;
        if (paramIntent != null) {
          jnV = paramIntent;
        }
        ae.i(this.TAG, "avatar file length %d KB", new Object[] { Long.valueOf(o.aZR(this.rJY) / 1024L) });
        setAvatar(this.rJY);
        AppMethodBeat.o(167184);
      }
    }
    else
    {
      Object localObject;
      if (paramInt1 == this.sMF)
      {
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          localObject = paramIntent.getStringExtra("key_output_sex");
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = "";
          }
          sMM = paramIntent;
          cMe();
          AppMethodBeat.o(167184);
        }
      }
      else if ((paramInt1 == this.sMG) && (paramIntent != null) && (paramInt2 == -1))
      {
        String str = paramIntent.getStringExtra("Country");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        sMN = (String)localObject;
        str = paramIntent.getStringExtra("Contact_Province");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        sMO = (String)localObject;
        localObject = paramIntent.getStringExtra("Contact_City");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        sMP = paramIntent;
        cMf();
      }
    }
    AppMethodBeat.o(167184);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167178);
    super.onBackPressed();
    Object localObject = com.tencent.mm.plugin.finder.report.g.syJ;
    com.tencent.mm.plugin.finder.report.g.Fs(5);
    localObject = i.syT;
    i.h(this.scene, 0, false, false);
    AppMethodBeat.o(167178);
  }
  
  public final void onClickEditDistrict(View paramView)
  {
    AppMethodBeat.i(167177);
    paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIl() == 1)
    {
      paramView = this.sMj;
      if (paramView == null) {
        p.bdF("nickEdt");
      }
      paramView.clearFocus();
      hideVKB();
      g(false, 0);
      paramView = new Intent();
      paramView.putExtra("GetAddress", true);
      paramView.putExtra("ShowSelectedLocation", true);
      paramView.putExtra("SetSelectLocation", true);
      paramView.putExtra("SelectedCountryCode", sMN);
      paramView.putExtra("SelectedProvinceCode", sMO);
      paramView.putExtra("SelectedCityCode", sMP);
      paramView.putExtra("NeedUnshowItem", true);
      com.tencent.mm.br.d.c((Context)getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, this.sMG);
    }
    AppMethodBeat.o(167177);
  }
  
  public final void onClickEditSex(View paramView)
  {
    AppMethodBeat.i(167176);
    paramView = this.sMj;
    if (paramView == null) {
      p.bdF("nickEdt");
    }
    paramView.clearFocus();
    hideVKB();
    g(false, 0);
    if (this.sMK)
    {
      paramView = new Intent();
      paramView.putExtra("key_input_sex", sMM);
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.a((MMActivity)this, paramView, this.sMF);
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
    this.sMi = paramBundle;
    paramBundle = findViewById(2131299973);
    p.g(paramBundle, "findViewById(R.id.finder_avatar_iv)");
    this.iZn = ((ImageView)paramBundle);
    paramBundle = findViewById(2131300016);
    p.g(paramBundle, "findViewById(R.id.finder_nick_tv)");
    this.sMj = ((EditText)paramBundle);
    paramBundle = findViewById(2131300069);
    p.g(paramBundle, "findViewById(R.id.finder_sex_tv)");
    this.sMk = ((TextView)paramBundle);
    paramBundle = findViewById(2131299989);
    p.g(paramBundle, "findViewById(R.id.finder_district_tv)");
    this.sMl = ((TextView)paramBundle);
    paramBundle = findViewById(2131299152);
    p.g(paramBundle, "findViewById(R.id.district_layout)");
    this.sMr = paramBundle;
    paramBundle = findViewById(2131301524);
    p.g(paramBundle, "findViewById(R.id.location_icon)");
    this.sMm = paramBundle;
    paramBundle = findViewById(2131296941);
    p.g(paramBundle, "findViewById(R.id.arrow_icon)");
    this.sMn = paramBundle;
    paramBundle = findViewById(2131301007);
    p.g(paramBundle, "findViewById(R.id.info_icon)");
    this.sMo = paramBundle;
    paramBundle = findViewById(2131307976);
    p.g(paramBundle, "findViewById(R.id.sex_arrow_icon)");
    this.sMp = paramBundle;
    paramBundle = findViewById(2131307977);
    p.g(paramBundle, "findViewById(R.id.sex_info_icon)");
    this.sMq = paramBundle;
    paramBundle = findViewById(2131299984);
    p.g(paramBundle, "findViewById(R.id.finder_contact_create_btn)");
    this.sMs = ((Button)paramBundle);
    paramBundle = findViewById(2131301033);
    p.g(paramBundle, "findViewById(R.id.input_panel)");
    this.sMw = ((InputPanelFrameLayout)paramBundle);
    paramBundle = findViewById(2131300001);
    p.g(paramBundle, "findViewById(R.id.finder_input_container)");
    this.sMx = paramBundle;
    paramBundle = findViewById(2131299311);
    p.g(paramBundle, "findViewById(R.id.edt_top_space)");
    this.sMt = paramBundle;
    paramBundle = findViewById(2131299310);
    p.g(paramBundle, "findViewById(R.id.edt_middle_space)");
    this.sMu = paramBundle;
    paramBundle = findViewById(2131299308);
    p.g(paramBundle, "findViewById(R.id.edt_bottom_space)");
    this.sMv = paramBundle;
    paramBundle = findViewById(2131299976);
    p.g(paramBundle, "findViewById(R.id.finder_camera_container)");
    this.sMy = paramBundle;
    paramBundle = findViewById(2131306005);
    p.g(paramBundle, "findViewById(R.id.top_error_tip)");
    this.sMz = ((TextView)paramBundle);
    paramBundle = findViewById(2131300018);
    p.g(paramBundle, "findViewById(R.id.finder_nickname_edit_limit)");
    this.sMA = ((TextView)paramBundle);
    paramBundle = findViewById(2131308030);
    p.g(paramBundle, "findViewById(R.id.tips_check_cb)");
    this.sMB = ((CheckBox)paramBundle);
    paramBundle = findViewById(2131308032);
    p.g(paramBundle, "findViewById(R.id.tips_warning_tv)");
    this.sMC = ((TextView)paramBundle);
    paramBundle = this.iZn;
    if (paramBundle == null) {
      p.bdF("avatarView");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new FinderCreateContactUI.b(this));
    paramBundle = this.sMs;
    if (paramBundle == null) {
      p.bdF("createBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = (TextWatcher)new g(this);
    Object localObject1 = this.sMj;
    if (localObject1 == null) {
      p.bdF("nickEdt");
    }
    ((EditText)localObject1).addTextChangedListener(paramBundle);
    paramBundle = this.sMj;
    if (paramBundle == null) {
      p.bdF("nickEdt");
    }
    paramBundle.setOnEditorActionListener((TextView.OnEditorActionListener)new FinderCreateContactUI.d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    paramBundle = this.sMw;
    if (paramBundle == null) {
      p.bdF("inputPanel");
    }
    paramBundle.setExternalListener((b.a)this);
    paramBundle = this.sMi;
    if (paramBundle == null) {
      p.bdF("scrollContainer");
    }
    paramBundle.post((Runnable)new f(this));
    if (sML != null)
    {
      paramBundle = this.sMj;
      if (paramBundle == null) {
        p.bdF("nickEdt");
      }
      paramBundle.setText((CharSequence)sML);
    }
    if (jnV != null)
    {
      this.rJY = jnV;
      setAvatar(this.rJY);
    }
    paramBundle = com.tencent.mm.kernel.g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    int i = paramBundle.ajA().getInt(12290, 0);
    if (i == 1)
    {
      sMM = "male";
      this.sMK = false;
    }
    for (;;)
    {
      paramBundle = new ArrayList();
      localObject1 = d.g.b.ad.Njc;
      localObject1 = String.format("https://weixin.qq.com/cgi-bin/readtemplate?lang=%s&t=weixin_agreement&s=video", Arrays.copyOf(new Object[] { com.tencent.mm.sdk.platformtools.ad.iR((Context)this) }, 1));
      p.g(localObject1, "java.lang.String.format(format, *args)");
      paramBundle.add(localObject1);
      localObject1 = d.g.b.ad.Njc;
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
      TextView localTextView = this.sMC;
      if (localTextView == null) {
        p.bdF("tipsWarningTV");
      }
      a((Context)localObject1, paramBundle, str, (List)localObject2, localTextView, this.TAG);
      cMe();
      cMf();
      com.tencent.mm.kernel.g.ajj().a(3922, (com.tencent.mm.ak.f)this);
      com.tencent.mm.kernel.g.ajj().a(3759, (com.tencent.mm.ak.f)this);
      this.scene = getIntent().getIntExtra("scene", 0);
      this.sqs = new atf();
      paramBundle = getIntent().getByteArrayExtra("key_prepare_resp");
      if (paramBundle != null) {}
      try
      {
        localObject1 = this.sqs;
        if (localObject1 != null) {
          ((atf)localObject1).parseFrom(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = z.Nhr;
        }
      }
      paramBundle = this.sqs;
      if ((paramBundle != null) && (paramBundle.sMJ > 0)) {
        this.sMJ = paramBundle.sMJ;
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 30L, 1L);
      AppMethodBeat.o(167175);
      return;
      if (i == 2)
      {
        sMM = "female";
        this.sMK = false;
      }
      else
      {
        this.sMK = true;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167182);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(3922, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ajj().b(3759, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(167182);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(167183);
    ae.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof aa))
    {
      paramString = this.sMH;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = ((aa)paramn).czB();
        if (paramn != null)
        {
          paramString = i.syT;
          i.h(this.scene, 1, true, true);
          com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 32L, 1L);
          paramString = new Intent();
          paramString.putExtra("finder_username", paramn.username);
          paramString.putExtra("KEY_FINDER_SELF_FLAG", true);
          paramn = FinderReporterUIC.tnG;
          FinderReporterUIC.a.a((Context)this, paramString, 0L, 0, false, 124);
          paramn = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this, paramString);
          finish();
          AppMethodBeat.o(167183);
          return;
        }
        AppMethodBeat.o(167183);
        return;
      }
      if (paramInt2 == -4003) {
        com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 37L, 1L);
      }
      for (;;)
      {
        paramString = ((aa)paramn).rr.aEV();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateUserResponse");
        AppMethodBeat.o(167183);
        throw paramString;
        if (paramInt2 == -4008) {
          com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 38L, 1L);
        }
      }
      aqk localaqk = ((ams)paramString).verifyInfo;
      if (localaqk != null)
      {
        ae.i(this.TAG, "verify info: " + com.tencent.mm.ac.f.bF(localaqk));
        if (localaqk.GHm == 1)
        {
          paramString = this.sMj;
          if (paramString == null) {
            p.bdF("nickEdt");
          }
          paramString.setTextColor(com.tencent.mm.cb.a.n((Context)this, 2131100798));
        }
        if (!bu.isNullOrNil(localaqk.GHj))
        {
          paramn = localaqk.GHj;
          paramString = paramn;
          if (paramn == null) {
            paramString = "";
          }
          ad(paramString, localaqk.GHo, localaqk.GHn);
          AppMethodBeat.o(167183);
          return;
        }
        paramString = getString(2131759176);
        p.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
        ad(paramString, null, null);
        AppMethodBeat.o(167183);
        return;
      }
      paramString = (FinderCreateContactUI)this;
      paramn = paramString.getString(2131759176);
      p.g(paramn, "getString(R.string.finde…reate_contact_failed_tip)");
      paramString.ad(paramn, null, null);
      AppMethodBeat.o(167183);
      return;
    }
    if ((paramn instanceof be))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = new amj();
        if (p.i(sMM, "female"))
        {
          paramInt1 = 0;
          paramString.eQV = 2;
          if (!p.i(sMN, "unshow")) {
            break label594;
          }
          paramInt2 = 1;
        }
        for (;;)
        {
          paramString = new aa(sML, "", ((be)paramn).rSl, paramString, paramInt1, paramInt2);
          com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)paramString);
          AppMethodBeat.o(167183);
          return;
          if (p.i(sMM, "male"))
          {
            paramInt1 = 0;
            paramString.eQV = 1;
            break;
          }
          paramInt1 = 1;
          paramString.eQV = 0;
          break;
          label594:
          paramInt2 = 0;
          paramString.country = sMN;
          paramString.eRf = sMO;
          paramString.eRg = sMP;
        }
      }
      paramString = this.sMH;
      if (paramString != null) {
        paramString.dismiss();
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 33L, 1L);
      paramString = getString(2131759176);
      p.g(paramString, "getString(R.string.finde…reate_contact_failed_tip)");
      ad(paramString, null, null);
    }
    AppMethodBeat.o(167183);
  }
  
  public final void onTipsCheckBoxClick(View paramView)
  {
    AppMethodBeat.i(204543);
    paramView = this.sMB;
    if (paramView == null) {
      p.bdF("tipsCheckCB");
    }
    CheckBox localCheckBox = this.sMB;
    if (localCheckBox == null) {
      p.bdF("tipsCheckCB");
    }
    if (!localCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(204543);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderCreateContactUI$Companion;", "", "()V", "lastAvatarPath", "", "getLastAvatarPath", "()Ljava/lang/String;", "setLastAvatarPath", "(Ljava/lang/String;)V", "lastNickName", "getLastNickName", "setLastNickName", "lastSelectCityCode", "getLastSelectCityCode", "setLastSelectCityCode", "lastSelectCountryCode", "getLastSelectCountryCode", "setLastSelectCountryCode", "lastSelectProvinceCode", "getLastSelectProvinceCode", "setLastSelectProvinceCode", "lastSelectSex", "getLastSelectSex", "setLastSelectSex", "plugin-finder_release"})
  public static final class a
  {
    public static void ajE(String paramString)
    {
      AppMethodBeat.i(204540);
      p.h(paramString, "<set-?>");
      FinderCreateContactUI.ajD(paramString);
      AppMethodBeat.o(204540);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167161);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      ae.i(FinderCreateContactUI.b(this.sMR), "doClick create contact btn");
      Object localObject2 = new am();
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((am)localObject2).hO(paramView);
      Object localObject5 = this.sMR.getString(2131756087);
      Object localObject4 = this.sMR.getString(2131759280);
      Object localObject3 = this.sMR.getString(2131763400);
      paramView = FinderCreateContactUI.sMQ;
      localObject1 = FinderCreateContactUI.c(this.sMR);
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      p.h(paramView, "<set-?>");
      FinderCreateContactUI.ajC(paramView);
      paramView = FinderCreateContactUI.sMQ;
      paramView = FinderCreateContactUI.d(this.sMR).getText();
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
      FinderCreateContactUI.a.ajE(paramView);
      paramView = new ArrayList();
      localObject1 = FinderCreateContactUI.sMQ;
      if (com.tencent.mm.ui.tools.f.aYK(FinderCreateContactUI.cMh()) > FinderCreateContactUI.e(this.sMR)) {
        paramView.add(localObject4);
      }
      localObject1 = new ArrayList();
      FinderCreateContactUI.a locala = FinderCreateContactUI.sMQ;
      int i;
      if (((CharSequence)FinderCreateContactUI.cMg()).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label504;
        }
        ((ArrayList)localObject1).add(localObject5);
        label297:
        localObject5 = FinderCreateContactUI.sMQ;
        if (((CharSequence)FinderCreateContactUI.cMh()).length() != 0) {
          break label513;
        }
        i = 1;
        label318:
        if (i == 0) {
          break label518;
        }
        ((ArrayList)localObject1).add(localObject4);
        label329:
        localObject4 = FinderCreateContactUI.sMQ;
        if (((CharSequence)FinderCreateContactUI.cMi()).length() != 0) {
          break label527;
        }
        i = 1;
        label350:
        if (i == 0) {
          break label532;
        }
        ((ArrayList)localObject1).add(localObject3);
        label361:
        localObject3 = FinderCreateContactUI.sMQ;
        if (!bu.isNullOrNil(FinderCreateContactUI.cMj())) {
          ((am)localObject2).RO();
        }
        if (!paramView.isEmpty()) {
          break label741;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          break label619;
        }
        if (!FinderCreateContactUI.f(this.sMR).isChecked()) {
          break label541;
        }
        FinderCreateContactUI.g(this.sMR);
        ((am)localObject2).de(1L);
      }
      for (;;)
      {
        ((am)localObject2).aLH();
        paramView = FinderCreateContactUI.b(this.sMR);
        localObject1 = new StringBuilder("report19815 ");
        localObject2 = ((am)localObject2).RD();
        p.g(localObject2, "struct.toShowString()");
        ae.i(paramView, d.n.n.h((String)localObject2, "\r\n", " ", false));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167161);
        return;
        i = 0;
        break;
        label504:
        ((am)localObject2).RL();
        break label297;
        label513:
        i = 0;
        break label318;
        label518:
        ((am)localObject2).RM();
        break label329;
        label527:
        i = 0;
        break label350;
        label532:
        ((am)localObject2).RN();
        break label361;
        label541:
        ae.i(FinderCreateContactUI.b(this.sMR), "not check agreement");
        paramView = this.sMR;
        localObject1 = this.sMR.getString(2131764859);
        p.g(localObject1, "getString(R.string.finder_agreement_not_check_tip)");
        FinderCreateContactUI.a(paramView, (String)localObject1);
        ((am)localObject2).de(2L);
        ((am)localObject2).df(3L);
        ((am)localObject2).hP(this.sMR.getString(2131764859));
        continue;
        label619:
        ae.i(FinderCreateContactUI.b(this.sMR), "empty attr ".concat(String.valueOf(localObject1)));
        paramView = bu.m((List)localObject1, this.sMR.getString(2131766272));
        localObject1 = this.sMR;
        localObject3 = this.sMR.getString(2131766426, new Object[] { paramView });
        p.g(localObject3, "getString(R.string.finde…_empty_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((am)localObject2).de(2L);
        ((am)localObject2).df(2L);
        ((am)localObject2).hP(this.sMR.getString(2131766426, new Object[] { paramView }));
        continue;
        label741:
        paramView = bu.m((List)paramView, this.sMR.getString(2131766272));
        localObject1 = this.sMR;
        localObject3 = this.sMR.getString(2131766427, new Object[] { paramView });
        p.g(localObject3, "getString(R.string.finde…o_long_tip, errorTypeStr)");
        FinderCreateContactUI.a((FinderCreateContactUI)localObject1, (String)localObject3);
        ((am)localObject2).de(2L);
        ((am)localObject2).df(1L);
        ((am)localObject2).hP(this.sMR.getString(2131766427, new Object[] { paramView }));
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167163);
      paramMenuItem = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.Fs(5);
      paramMenuItem = i.syT;
      i.h(FinderCreateContactUI.j(this.sMR), 0, false, false);
      this.sMR.finish();
      AppMethodBeat.o(167163);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(167164);
      FinderCreateContactUI.a(this.sMR, FinderCreateContactUI.k(this.sMR).getMeasuredHeight());
      AppMethodBeat.o(167164);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class g
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167168);
      com.tencent.mm.ui.tools.b.c.d(FinderCreateContactUI.d(this.sMR)).kj(1, FinderCreateContactUI.e(this.sMR)).a(f.a.Lfh).fPi().a((c.a)new a(this));
      paramEditable = FinderCreateContactUI.sMQ;
      paramEditable = FinderCreateContactUI.d(this.sMR).getText();
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
      FinderCreateContactUI.a.ajE(paramEditable);
      FinderCreateContactUI.d(this.sMR).setTextColor(com.tencent.mm.cb.a.n((Context)this.sMR, 2131100711));
      AppMethodBeat.o(167168);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$initContentView$nicknameTextWatcher$1$afterTextChanged$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
    public static final class a
      implements c.a
    {
      public final void Ky(String paramString)
      {
        AppMethodBeat.i(167167);
        int i = com.tencent.mm.ui.tools.f.cU(FinderCreateContactUI.e(this.sMS.sMR), paramString);
        FinderCreateContactUI.h(this.sMS.sMR).setText((CharSequence)String.valueOf(i));
        FinderCreateContactUI.h(this.sMS.sMR).setTextColor(this.sMS.sMR.getResources().getColor(2131099660));
        if (i <= d.k.j.lw((int)(FinderCreateContactUI.e(this.sMS.sMR) * 0.1F), 1)) {
          FinderCreateContactUI.h(this.sMS.sMR).setVisibility(0);
        }
        for (;;)
        {
          FinderCreateContactUI.i(this.sMS.sMR);
          AppMethodBeat.o(167167);
          return;
          FinderCreateContactUI.h(this.sMS.sMR).setVisibility(4);
        }
      }
      
      public final void aUT()
      {
        AppMethodBeat.i(167165);
        FinderCreateContactUI.h(this.sMS.sMR).setText((CharSequence)String.valueOf(FinderCreateContactUI.e(this.sMS.sMR)));
        FinderCreateContactUI.h(this.sMS.sMR).setTextColor(this.sMS.sMR.getResources().getColor(2131099660));
        AppMethodBeat.o(167165);
      }
      
      public final void cW(String paramString)
      {
        AppMethodBeat.i(167166);
        FinderCreateContactUI.h(this.sMS.sMR).setText((CharSequence)String.valueOf(com.tencent.mm.ui.tools.f.cU(FinderCreateContactUI.e(this.sMS.sMR), paramString)));
        FinderCreateContactUI.h(this.sMS.sMR).setVisibility(0);
        FinderCreateContactUI.h(this.sMS.sMR).setTextColor(this.sMS.sMR.getResources().getColor(2131099804));
        paramString = this.sMS.sMR;
        String str = this.sMS.sMR.getString(2131759284);
        p.g(str, "getString(R.string.finder_nickname_too_long_tip)");
        FinderCreateContactUI.a(paramString, str);
        AppMethodBeat.o(167166);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<String, z>
  {
    i(FinderCreateContactUI paramFinderCreateContactUI, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$1$1"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178430);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.spam.a.sEK;
      paramView = this.sMR.getString(2131759252);
      p.g(paramView, "getString(R.string.finder_location_tip_gps)");
      com.tencent.mm.plugin.finder.spam.a.ajj(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateDistrict$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178430);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderCreateContactUI paramFinderCreateContactUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204542);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.spam.a.sEK;
      paramView = this.sMR.getString(2131766497);
      p.g(paramView, "getString(R.string.finder_sex_tip)");
      com.tencent.mm.plugin.finder.spam.a.ajj(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateContactUI$updateSex$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(204542);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCreateContactUI
 * JD-Core Version:    0.7.0.1
 */