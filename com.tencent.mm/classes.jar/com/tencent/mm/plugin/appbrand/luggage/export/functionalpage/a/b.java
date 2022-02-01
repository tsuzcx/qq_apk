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
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.permission.a.b.c.a;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "getListener", "()Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "loadingView", "Landroid/view/View;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDescTv", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mNameTv", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestContainer", "Landroid/widget/RelativeLayout;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "adjustRequestContainerHeight", "", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "getLastPointerDownTouchEvent", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "onCreateView", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class b
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.permission.a.b
{
  private final List<o.a> cjg;
  private View gZB;
  private String iconUrl;
  private String kCE;
  private Button kEB;
  private Button kEC;
  private String kEF;
  private ImageView kEm;
  private TextView kEn;
  private ImageView kEp;
  private TextView lHT;
  private final int lUd;
  private MaxHeightRecyclerView lUe;
  private RelativeLayout lUf;
  private com.tencent.mm.plugin.appbrand.permission.a.b.c lUg;
  private MotionEvent lUh;
  private String lUi;
  private TextView lUj;
  private String lUk;
  private TextView lUl;
  private String lUm;
  private LinearLayout lUn;
  private o lUo;
  private o.b lUp;
  private TextView lUq;
  private com.tencent.mm.plugin.appbrand.d lUr;
  
  public b(com.tencent.mm.plugin.appbrand.d paramd, com.tencent.mm.plugin.appbrand.permission.a.b.c paramc)
  {
    super(paramd);
    AppMethodBeat.i(223741);
    this.lUd = android.support.v4.content.b.n(getContext(), 2131101179);
    this.lUg = paramc;
    this.kCE = "";
    this.cjg = ((List)new ArrayList());
    LayoutInflater.from(getContext()).inflate(2131496378, (ViewGroup)this, true);
    paramd = findViewById(2131297653);
    p.g(paramd, "findViewById<View>(R.id.button_group)");
    a.cG(paramd);
    paramd = findViewById(2131304106);
    p.g(paramd, "findViewById(R.id.request_right_icon)");
    this.kEp = ((ImageView)paramd);
    paramd = (RelativeLayout)findViewById(2131308187);
    paramc = LayoutInflater.from(getContext()).inflate(2131496377, (ViewGroup)paramd, false);
    p.g(paramc, "group");
    localObject = paramc.getLayoutParams();
    if (localObject == null)
    {
      paramd = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(223741);
      throw paramd;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131304097);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramd.addView(paramc);
    p.g(paramd, "container");
    this.lUf = paramd;
    bth();
    findViewById(2131308120).setOnClickListener((View.OnClickListener)new b.f(this));
    paramd = findViewById(2131304102);
    p.g(paramd, "findViewById(R.id.request_name)");
    this.kEn = ((TextView)paramd);
    paramd = findViewById(2131304098);
    p.g(paramd, "findViewById(R.id.request_desc)");
    this.lHT = ((TextView)paramd);
    paramd = findViewById(2131304825);
    p.g(paramd, "findViewById(R.id.simple_detail_desc)");
    this.lUj = ((TextView)paramd);
    paramd = findViewById(2131304095);
    p.g(paramd, "findViewById(R.id.request_apply_wording)");
    this.lUl = ((TextView)paramd);
    paramd = findViewById(2131304100);
    p.g(paramd, "findViewById(R.id.request_icon)");
    this.kEm = ((ImageView)paramd);
    paramd = findViewById(2131304097);
    p.g(paramd, "findViewById(R.id.request_content)");
    this.lUn = ((LinearLayout)paramd);
    paramd = findViewById(2131304104);
    p.g(paramd, "findViewById(R.id.request_recyclerview)");
    this.lUe = ((MaxHeightRecyclerView)paramd);
    paramd = this.lUe;
    if (paramd == null) {
      p.bdF("recyclerView");
    }
    getContext();
    paramd.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.lUo = new o(this.cjg);
    paramd = this.lUe;
    if (paramd == null) {
      p.bdF("recyclerView");
    }
    paramc = this.lUo;
    if (paramc == null) {
      p.bdF("mAdapter");
    }
    paramd.setAdapter((RecyclerView.a)paramc);
    paramd = this.lUe;
    if (paramd == null) {
      p.bdF("recyclerView");
    }
    paramd.setItemAnimator(null);
    paramd = findViewById(2131304101);
    p.g(paramd, "findViewById(R.id.request_loading)");
    this.gZB = paramd;
    paramd = findViewById(2131304099);
    p.g(paramd, "findViewById(R.id.request_function)");
    this.lUq = ((TextView)paramd);
    paramd = findViewById(2131304096);
    ((Button)paramd).setOnClickListener((View.OnClickListener)new d(this));
    p.g(paramd, "findViewById<Button>(R.i…)\n            }\n        }");
    this.kEC = ((Button)paramd);
    paramd = findViewById(2131304103);
    ((Button)paramd).setOnClickListener((View.OnClickListener)new e(this));
    p.g(paramd, "findViewById<Button>(R.i…)\n            }\n        }");
    this.kEB = ((Button)paramd);
    AppMethodBeat.o(223741);
  }
  
  private final void btg()
  {
    AppMethodBeat.i(223718);
    Object localObject = this.lUg;
    if (localObject != null) {
      b.c.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject, 3, new ArrayList());
    }
    localObject = this.lUr;
    if (localObject == null) {
      p.bdF("component");
    }
    i((com.tencent.mm.plugin.appbrand.d)localObject);
    AppMethodBeat.o(223718);
  }
  
  private final void bth()
  {
    AppMethodBeat.i(223719);
    Object localObject = this.lUf;
    if (localObject == null) {
      p.bdF("requestContainer");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(223719);
  }
  
  private final o.a getSelectedItem()
  {
    AppMethodBeat.i(223737);
    Object localObject = this.lUo;
    if (localObject == null) {
      p.bdF("mAdapter");
    }
    localObject = ((o)localObject).hMc.iterator();
    while (((Iterator)localObject).hasNext())
    {
      o.a locala = (o.a)((Iterator)localObject).next();
      if ((locala != null) && (locala.iGv == true))
      {
        AppMethodBeat.o(223737);
        return locala;
      }
    }
    AppMethodBeat.o(223737);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d paramd, String paramString, ac paramac)
  {
    AppMethodBeat.i(223740);
    p.h(paramd, "component");
    paramd = paramd.getContext();
    p.g(paramd, "component.context");
    paramd = new d(paramd);
    paramd.setExplainContent(paramString);
    paramd = (com.tencent.mm.plugin.appbrand.permission.g)paramd;
    AppMethodBeat.o(223740);
    return paramd;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(223720);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.lUf;
    if (paramConfiguration == null) {
      p.bdF("requestContainer");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(223720);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(223717);
    if ((t.aC((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(223717);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          btg();
          AppMethodBeat.o(223717);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(223717);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(223716);
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
      this.lUh = MotionEvent.obtain(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(223716);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.kEF;
  }
  
  public final String getApplyWording()
  {
    return this.lUm;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final o.b getItemCheckedListener()
  {
    return this.lUp;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.lUh;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b.c getListener()
  {
    return this.lUg;
  }
  
  public final String getRequestDesc()
  {
    return this.lUi;
  }
  
  public final String getSimpleDetailDesc()
  {
    return this.lUk;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(223738);
    p.h(paramd, "component");
    this.lUr = paramd;
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
    int i = this.lUd;
    if (!al.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      M(i, bool);
      setBackgroundColor(this.lUd);
      paramd = this.lUr;
      if (paramd == null) {
        p.bdF("component");
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
      paramd.setNavigationbarColor(this.lUd);
      AppMethodBeat.o(223738);
      return;
    }
    AppMethodBeat.o(223738);
  }
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(223730);
    ImageView localImageView = this.kEp;
    if (localImageView == null) {
      p.bdF("mExplainIv");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      localImageView = this.kEp;
      if (localImageView == null) {
        p.bdF("mExplainIv");
      }
      localImageView.setImageDrawable(android.support.v4.content.b.l(getContext(), 2131230993));
      AppMethodBeat.o(223730);
      return;
    }
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(223739);
    p.h(paramd, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(223739);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(223721);
    this.kEF = paramString;
    TextView localTextView = this.kEn;
    if (localTextView == null) {
      p.bdF("mNameTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(223721);
  }
  
  public final void setApplyWording(String paramString)
  {
    AppMethodBeat.i(223724);
    this.lUm = paramString;
    TextView localTextView = this.lUl;
    if (localTextView == null) {
      p.bdF("mApplyWordingTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(223724);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(223731);
    ImageView localImageView = this.kEp;
    if (localImageView == null) {
      p.bdF("mExplainIv");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(223731);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(223734);
    TextView localTextView = this.lUq;
    if (localTextView == null) {
      p.bdF("funcTv");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(223734);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(223732);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = this.lUq;
      if (paramString == null) {
        p.bdF("funcTv");
      }
      paramString.setText((CharSequence)"");
      paramString = this.lUq;
      if (paramString == null) {
        p.bdF("funcTv");
      }
      paramString.setVisibility(4);
      AppMethodBeat.o(223732);
      return;
    }
    TextView localTextView = this.lUq;
    if (localTextView == null) {
      p.bdF("funcTv");
    }
    localTextView.setText((CharSequence)paramString);
    paramString = this.lUq;
    if (paramString == null) {
      p.bdF("funcTv");
    }
    paramString.setVisibility(0);
    AppMethodBeat.o(223732);
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(223733);
    TextView localTextView = this.lUq;
    if (localTextView == null) {
      p.bdF("funcTv");
    }
    localTextView.setTextColor(paramInt);
    AppMethodBeat.o(223733);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(223725);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.aEl();
    ImageView localImageView = this.kEm;
    if (localImageView == null) {
      p.bdF("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), 2131233241, (b.h)com.tencent.mm.modelappbrand.a.g.hOv);
    AppMethodBeat.o(223725);
  }
  
  public final void setItemCheckedListener(o.b paramb)
  {
    AppMethodBeat.i(223728);
    this.lUp = paramb;
    o localo = this.lUo;
    if (localo == null) {
      p.bdF("mAdapter");
    }
    localo.lUp = paramb;
    AppMethodBeat.o(223728);
  }
  
  public final void setListener(com.tencent.mm.plugin.appbrand.permission.a.b.c paramc)
  {
    this.lUg = paramc;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(223735);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.kEC;
        if (localObject == null) {
          p.bdF("mBtnReject");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(223735);
      return;
    }
  }
  
  public final void setOnListItemLongClickListener(o.c paramc)
  {
    AppMethodBeat.i(223729);
    p.h(paramc, "listener");
    o localo = this.lUo;
    if (localo == null) {
      p.bdF("mAdapter");
    }
    localo.nhp = paramc;
    AppMethodBeat.o(223729);
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(223736);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.kEB;
        if (localObject == null) {
          p.bdF("mBtnAccept");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(223736);
      return;
    }
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(223722);
    this.lUi = paramString;
    TextView localTextView = this.lHT;
    if (localTextView == null) {
      p.bdF("mDescTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(223722);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(223726);
    p.h(paramString, "scope");
    this.kCE = paramString;
    AppMethodBeat.o(223726);
  }
  
  public final void setSelectListItem(List<o.a> paramList)
  {
    AppMethodBeat.i(223727);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(223727);
        return;
      }
      this.cjg.clear();
      this.cjg.addAll((Collection)paramList);
      paramList = this.lUo;
      if (paramList == null) {
        p.bdF("mAdapter");
      }
      paramList.notifyDataSetChanged();
      paramList = this.lUn;
      if (paramList == null) {
        p.bdF("mSelectListLayout");
      }
      paramList.setVisibility(0);
      paramList = this.lUj;
      if (paramList == null) {
        p.bdF("mSimpleDetailDescTv");
      }
      paramList.setVisibility(8);
      paramList = this.gZB;
      if (paramList == null) {
        p.bdF("loadingView");
      }
      paramList.setVisibility(8);
      AppMethodBeat.o(223727);
      return;
    }
    AppMethodBeat.o(223727);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(223723);
    this.lUk = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.lUj;
        if (localObject == null) {
          p.bdF("mSimpleDetailDescTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
        paramString = this.lUj;
        if (paramString == null) {
          p.bdF("mSimpleDetailDescTv");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(223723);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, b paramb) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(223709);
      this.lUs.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = b.d(jdField_this).getParent();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 == null) {}
      for (;;)
      {
        AppMethodBeat.o(223709);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(223710);
      a.cG((View)this.lUt);
      AppMethodBeat.o(223710);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    public c(b paramb) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(223711);
      p.h(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      b.e(this.lUt);
      AppMethodBeat.o(223711);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$3$1"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223712);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = b.a(this.lUt, false);
      localObject = this.lUt.getListener();
      if (localObject != null) {
        b.c.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject, 2, paramView);
      }
      this.lUt.i(b.b(this.lUt));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(223712);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$4$1"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223713);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = b.a(this.lUt, true);
      localObject = this.lUt.getListener();
      o.a locala;
      if (localObject != null)
      {
        locala = b.c(this.lUt);
        if (locala == null) {
          break label116;
        }
      }
      label116:
      for (int i = locala.kCD;; i = 0)
      {
        ((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject).a(1, paramView, i);
        this.lUt.i(b.b(this.lUt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223713);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b
 * JD-Core Version:    0.7.0.1
 */