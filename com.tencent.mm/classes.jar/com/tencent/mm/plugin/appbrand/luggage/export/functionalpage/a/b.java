package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.t;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.permission.a.b.c.a;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getListener", "()Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "loadingView", "Landroid/view/View;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDescTv", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mNameTv", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestContainer", "Landroid/widget/RelativeLayout;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "adjustRequestContainerHeight", "", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "getLastPointerDownTouchEvent", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "onCreateView", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class b
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.permission.a.b
{
  private final List<o.a> cje;
  private View gWO;
  private String iconUrl;
  private ImageView kAX;
  private TextView kAY;
  private ImageView kBa;
  private Button kBm;
  private Button kBn;
  private String kBq;
  private String kzp;
  private TextView lDu;
  private final int lPC;
  private MaxHeightRecyclerView lPD;
  private RelativeLayout lPE;
  private com.tencent.mm.plugin.appbrand.permission.a.b.c lPF;
  private MotionEvent lPG;
  private String lPH;
  private TextView lPI;
  private String lPJ;
  private TextView lPK;
  private String lPL;
  private LinearLayout lPM;
  private o lPN;
  private o.b lPO;
  private TextView lPP;
  private com.tencent.mm.plugin.appbrand.d lPQ;
  
  public b(com.tencent.mm.plugin.appbrand.d paramd, com.tencent.mm.plugin.appbrand.permission.a.b.c paramc)
  {
    super(paramd);
    AppMethodBeat.i(189481);
    this.lPC = android.support.v4.content.b.n(getContext(), 2131101179);
    this.lPF = paramc;
    this.kzp = "";
    this.cje = ((List)new ArrayList());
    LayoutInflater.from(getContext()).inflate(2131496378, (ViewGroup)this, true);
    paramd = findViewById(2131297653);
    p.g(paramd, "findViewById<View>(R.id.button_group)");
    a.cF(paramd);
    paramd = findViewById(2131304106);
    p.g(paramd, "findViewById(R.id.request_right_icon)");
    this.kBa = ((ImageView)paramd);
    paramd = (RelativeLayout)findViewById(2131308187);
    paramc = LayoutInflater.from(getContext()).inflate(2131496377, (ViewGroup)paramd, false);
    p.g(paramc, "group");
    localObject = paramc.getLayoutParams();
    if (localObject == null)
    {
      paramd = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(189481);
      throw paramd;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131304097);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramd.addView(paramc);
    p.g(paramd, "container");
    this.lPE = paramd;
    bsw();
    findViewById(2131308120).setOnClickListener((View.OnClickListener)new b.f(this));
    paramd = findViewById(2131304102);
    p.g(paramd, "findViewById(R.id.request_name)");
    this.kAY = ((TextView)paramd);
    paramd = findViewById(2131304098);
    p.g(paramd, "findViewById(R.id.request_desc)");
    this.lDu = ((TextView)paramd);
    paramd = findViewById(2131304825);
    p.g(paramd, "findViewById(R.id.simple_detail_desc)");
    this.lPI = ((TextView)paramd);
    paramd = findViewById(2131304095);
    p.g(paramd, "findViewById(R.id.request_apply_wording)");
    this.lPK = ((TextView)paramd);
    paramd = findViewById(2131304100);
    p.g(paramd, "findViewById(R.id.request_icon)");
    this.kAX = ((ImageView)paramd);
    paramd = findViewById(2131304097);
    p.g(paramd, "findViewById(R.id.request_content)");
    this.lPM = ((LinearLayout)paramd);
    paramd = findViewById(2131304104);
    p.g(paramd, "findViewById(R.id.request_recyclerview)");
    this.lPD = ((MaxHeightRecyclerView)paramd);
    paramd = this.lPD;
    if (paramd == null) {
      p.bcb("recyclerView");
    }
    getContext();
    paramd.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.lPN = new o(this.cje);
    paramd = this.lPD;
    if (paramd == null) {
      p.bcb("recyclerView");
    }
    paramc = this.lPN;
    if (paramc == null) {
      p.bcb("mAdapter");
    }
    paramd.setAdapter((RecyclerView.a)paramc);
    paramd = this.lPD;
    if (paramd == null) {
      p.bcb("recyclerView");
    }
    paramd.setItemAnimator(null);
    paramd = findViewById(2131304101);
    p.g(paramd, "findViewById(R.id.request_loading)");
    this.gWO = paramd;
    paramd = findViewById(2131304099);
    p.g(paramd, "findViewById(R.id.request_function)");
    this.lPP = ((TextView)paramd);
    paramd = findViewById(2131304096);
    ((Button)paramd).setOnClickListener((View.OnClickListener)new d(this));
    p.g(paramd, "findViewById<Button>(R.i…)\n            }\n        }");
    this.kBn = ((Button)paramd);
    paramd = findViewById(2131304103);
    ((Button)paramd).setOnClickListener((View.OnClickListener)new e(this));
    p.g(paramd, "findViewById<Button>(R.i…)\n            }\n        }");
    this.kBm = ((Button)paramd);
    AppMethodBeat.o(189481);
  }
  
  private final void bsv()
  {
    AppMethodBeat.i(189458);
    Object localObject = this.lPF;
    if (localObject != null) {
      b.c.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject, 3, new ArrayList());
    }
    localObject = this.lPQ;
    if (localObject == null) {
      p.bcb("component");
    }
    i((com.tencent.mm.plugin.appbrand.d)localObject);
    AppMethodBeat.o(189458);
  }
  
  private final void bsw()
  {
    AppMethodBeat.i(189459);
    Object localObject = this.lPE;
    if (localObject == null) {
      p.bcb("requestContainer");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(189459);
  }
  
  private final o.a getSelectedItem()
  {
    AppMethodBeat.i(189477);
    Object localObject = this.lPN;
    if (localObject == null) {
      p.bcb("mAdapter");
    }
    localObject = ((o)localObject).hJj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      o.a locala = (o.a)((Iterator)localObject).next();
      if ((locala != null) && (locala.iDC == true))
      {
        AppMethodBeat.o(189477);
        return locala;
      }
    }
    AppMethodBeat.o(189477);
    return null;
  }
  
  public final f a(com.tencent.mm.plugin.appbrand.d paramd, String paramString, ac paramac)
  {
    AppMethodBeat.i(189480);
    p.h(paramd, "component");
    paramd = paramd.getContext();
    p.g(paramd, "component.context");
    paramd = new d(paramd);
    paramd.setExplainContent(paramString);
    paramd = (f)paramd;
    AppMethodBeat.o(189480);
    return paramd;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(189460);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.lPE;
    if (paramConfiguration == null) {
      p.bcb("requestContainer");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(189460);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(189457);
    if ((t.aC((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(189457);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          bsv();
          AppMethodBeat.o(189457);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(189457);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189456);
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
      this.lPG = MotionEvent.obtain(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(189456);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.kBq;
  }
  
  public final String getApplyWording()
  {
    return this.lPL;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final o.b getItemCheckedListener()
  {
    return this.lPO;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.lPG;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b.c getListener()
  {
    return this.lPF;
  }
  
  public final String getRequestDesc()
  {
    return this.lPH;
  }
  
  public final String getSimpleDetailDesc()
  {
    return this.lPJ;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(189478);
    p.h(paramd, "component");
    this.lPQ = paramd;
    Context localContext = paramd.getContext();
    paramd = localContext;
    if (!(localContext instanceof Activity)) {
      paramd = null;
    }
    paramd = (Activity)paramd;
    if (paramd != null)
    {
      paramd = (ViewGroup)paramd.findViewById(16908290);
      if (paramd != null) {
        paramd.addView((View)this, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    bringToFront();
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    paramd = (View)this;
    paramd.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new b.g(paramd));
    int i = this.lPC;
    if (!al.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      L(i, bool);
      setBackgroundColor(this.lPC);
      paramd = this.lPQ;
      if (paramd == null) {
        p.bcb("component");
      }
      localContext = paramd.getContext();
      paramd = localContext;
      if (!(localContext instanceof AppBrandUI)) {
        paramd = null;
      }
      paramd = (AppBrandUI)paramd;
      if (paramd == null) {
        break;
      }
      paramd.setNavigationbarColor(this.lPC);
      AppMethodBeat.o(189478);
      return;
    }
    AppMethodBeat.o(189478);
  }
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(189470);
    ImageView localImageView = this.kBa;
    if (localImageView == null) {
      p.bcb("mExplainIv");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      localImageView = this.kBa;
      if (localImageView == null) {
        p.bcb("mExplainIv");
      }
      localImageView.setImageDrawable(android.support.v4.content.b.l(getContext(), 2131230993));
      AppMethodBeat.o(189470);
      return;
    }
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(189479);
    p.h(paramd, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(189479);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(189461);
    this.kBq = paramString;
    TextView localTextView = this.kAY;
    if (localTextView == null) {
      p.bcb("mNameTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(189461);
  }
  
  public final void setApplyWording(String paramString)
  {
    AppMethodBeat.i(189464);
    this.lPL = paramString;
    TextView localTextView = this.lPK;
    if (localTextView == null) {
      p.bcb("mApplyWordingTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(189464);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(189471);
    ImageView localImageView = this.kBa;
    if (localImageView == null) {
      p.bcb("mExplainIv");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(189471);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(189474);
    TextView localTextView = this.lPP;
    if (localTextView == null) {
      p.bcb("funcTv");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(189474);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(189472);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = this.lPP;
      if (paramString == null) {
        p.bcb("funcTv");
      }
      paramString.setText((CharSequence)"");
      paramString = this.lPP;
      if (paramString == null) {
        p.bcb("funcTv");
      }
      paramString.setVisibility(4);
      AppMethodBeat.o(189472);
      return;
    }
    TextView localTextView = this.lPP;
    if (localTextView == null) {
      p.bcb("funcTv");
    }
    localTextView.setText((CharSequence)paramString);
    paramString = this.lPP;
    if (paramString == null) {
      p.bcb("funcTv");
    }
    paramString.setVisibility(0);
    AppMethodBeat.o(189472);
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(189473);
    TextView localTextView = this.lPP;
    if (localTextView == null) {
      p.bcb("funcTv");
    }
    localTextView.setTextColor(paramInt);
    AppMethodBeat.o(189473);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(189465);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.aDV();
    ImageView localImageView = this.kAX;
    if (localImageView == null) {
      p.bcb("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), 2131233241, (b.h)g.hLC);
    AppMethodBeat.o(189465);
  }
  
  public final void setItemCheckedListener(o.b paramb)
  {
    AppMethodBeat.i(189468);
    this.lPO = paramb;
    o localo = this.lPN;
    if (localo == null) {
      p.bcb("mAdapter");
    }
    localo.lPO = paramb;
    AppMethodBeat.o(189468);
  }
  
  public final void setListener(com.tencent.mm.plugin.appbrand.permission.a.b.c paramc)
  {
    this.lPF = paramc;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(189475);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.kBn;
        if (localObject == null) {
          p.bcb("mBtnReject");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(189475);
      return;
    }
  }
  
  public final void setOnListItemLongClickListener(o.c paramc)
  {
    AppMethodBeat.i(189469);
    p.h(paramc, "listener");
    o localo = this.lPN;
    if (localo == null) {
      p.bcb("mAdapter");
    }
    localo.ncg = paramc;
    AppMethodBeat.o(189469);
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(189476);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.kBm;
        if (localObject == null) {
          p.bcb("mBtnAccept");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(189476);
      return;
    }
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(189462);
    this.lPH = paramString;
    TextView localTextView = this.lDu;
    if (localTextView == null) {
      p.bcb("mDescTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(189462);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(189466);
    p.h(paramString, "scope");
    this.kzp = paramString;
    AppMethodBeat.o(189466);
  }
  
  public final void setSelectListItem(List<o.a> paramList)
  {
    AppMethodBeat.i(189467);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(189467);
        return;
      }
      this.cje.clear();
      this.cje.addAll((Collection)paramList);
      paramList = this.lPN;
      if (paramList == null) {
        p.bcb("mAdapter");
      }
      paramList.notifyDataSetChanged();
      paramList = this.lPM;
      if (paramList == null) {
        p.bcb("mSelectListLayout");
      }
      paramList.setVisibility(0);
      paramList = this.lPI;
      if (paramList == null) {
        p.bcb("mSimpleDetailDescTv");
      }
      paramList.setVisibility(8);
      paramList = this.gWO;
      if (paramList == null) {
        p.bcb("loadingView");
      }
      paramList.setVisibility(8);
      AppMethodBeat.o(189467);
      return;
    }
    AppMethodBeat.o(189467);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(189463);
    this.lPJ = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.lPI;
        if (localObject == null) {
          p.bcb("mSimpleDetailDescTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
        paramString = this.lPI;
        if (paramString == null) {
          p.bcb("mSimpleDetailDescTv");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(189463);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, b paramb) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(189449);
      this.lPR.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = b.d(jdField_this).getParent();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 == null) {}
      for (;;)
      {
        AppMethodBeat.o(189449);
        return true;
        if (((ViewGroup)localObject1).getMeasuredHeight() > b.d(jdField_this).getMeasuredHeight())
        {
          localObject2 = b.d(jdField_this).getLayoutParams();
          if (localObject2 != null) {
            ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup)localObject1).getMeasuredHeight();
          }
          b.d(jdField_this).requestLayout();
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(189450);
      a.cF((View)this.lPS);
      AppMethodBeat.o(189450);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    public c(b paramb) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(189451);
      p.h(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      b.e(this.lPS);
      AppMethodBeat.o(189451);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$3$1"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(189452);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = b.a(this.lPS, false);
      localObject = this.lPS.getListener();
      if (localObject != null) {
        b.c.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject, 2, paramView);
      }
      this.lPS.i(b.b(this.lPS));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(189452);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$4$1"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(189453);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = b.a(this.lPS, true);
      localObject = this.lPS.getListener();
      o.a locala;
      if (localObject != null)
      {
        locala = b.c(this.lPS);
        if (locala == null) {
          break label116;
        }
      }
      label116:
      for (int i = locala.kzo;; i = 0)
      {
        ((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject).a(1, paramView, i);
        this.lPS.i(b.b(this.lPS));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189453);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b
 * JD-Core Version:    0.7.0.1
 */