package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.u;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.a.b.c.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.d;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.statusbar.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getListener", "()Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "loadingView", "Landroid/view/View;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDescTv", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mNameTv", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestContainer", "Landroid/widget/RelativeLayout;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "adjustRequestContainerHeight", "", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "getLastPointerDownTouchEvent", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "onCreateView", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class b
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.permission.a.b
{
  private final List<i.a> cvc;
  private View hSw;
  private String iconUrl;
  private TextView jVh;
  private TextView jVn;
  private String lGX;
  private ImageView lIM;
  private ImageView lIO;
  private Button lJa;
  private Button lJb;
  private String lJe;
  private final int nbL;
  private MaxHeightRecyclerView nbM;
  private RelativeLayout nbN;
  private com.tencent.mm.plugin.appbrand.permission.a.b.c nbO;
  private MotionEvent nbP;
  private String nbQ;
  private TextView nbR;
  private String nbS;
  private TextView nbT;
  private String nbU;
  private LinearLayout nbV;
  private i nbW;
  private i.b nbX;
  private TextView nbY;
  private com.tencent.mm.plugin.appbrand.d nbZ;
  
  public b(com.tencent.mm.plugin.appbrand.d paramd, com.tencent.mm.plugin.appbrand.permission.a.b.c paramc)
  {
    super(paramd);
    AppMethodBeat.i(228966);
    this.nbL = android.support.v4.content.b.n(getContext(), 2131101424);
    this.nbO = paramc;
    this.lGX = "";
    this.cvc = ((List)new ArrayList());
    LayoutInflater.from(getContext()).inflate(2131493032, (ViewGroup)this, true);
    paramd = findViewById(2131297917);
    p.g(paramd, "findViewById<View>(R.id.button_group)");
    a.cw(paramd);
    paramd = findViewById(2131306973);
    p.g(paramd, "findViewById(R.id.request_right_icon)");
    this.lIO = ((ImageView)paramd);
    paramd = (RelativeLayout)findViewById(2131306963);
    paramc = LayoutInflater.from(getContext()).inflate(2131493031, (ViewGroup)paramd, false);
    p.g(paramc, "group");
    localObject = paramc.getLayoutParams();
    if (localObject == null)
    {
      paramd = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(228966);
      throw paramd;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131306964);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramd.addView(paramc);
    p.g(paramd, "container");
    this.nbN = paramd;
    bOO();
    findViewById(2131301850).setOnClickListener((View.OnClickListener)new f(this));
    paramd = findViewById(2131306969);
    p.g(paramd, "findViewById(R.id.request_name)");
    this.jVh = ((TextView)paramd);
    paramd = findViewById(2131306965);
    p.g(paramd, "findViewById(R.id.request_desc)");
    this.jVn = ((TextView)paramd);
    paramd = findViewById(2131307910);
    p.g(paramd, "findViewById(R.id.simple_detail_desc)");
    this.nbR = ((TextView)paramd);
    paramd = findViewById(2131306961);
    p.g(paramd, "findViewById(R.id.request_apply_wording)");
    this.nbT = ((TextView)paramd);
    paramd = findViewById(2131306967);
    p.g(paramd, "findViewById(R.id.request_icon)");
    this.lIM = ((ImageView)paramd);
    paramd = findViewById(2131306964);
    p.g(paramd, "findViewById(R.id.request_content)");
    this.nbV = ((LinearLayout)paramd);
    paramd = findViewById(2131306971);
    p.g(paramd, "findViewById(R.id.request_recyclerview)");
    this.nbM = ((MaxHeightRecyclerView)paramd);
    paramd = this.nbM;
    if (paramd == null) {
      p.btv("recyclerView");
    }
    getContext();
    paramd.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.nbW = new i(this.cvc);
    paramd = this.nbM;
    if (paramd == null) {
      p.btv("recyclerView");
    }
    paramc = this.nbW;
    if (paramc == null) {
      p.btv("mAdapter");
    }
    paramd.setAdapter((RecyclerView.a)paramc);
    paramd = this.nbM;
    if (paramd == null) {
      p.btv("recyclerView");
    }
    paramd.setItemAnimator(null);
    paramd = findViewById(2131306968);
    p.g(paramd, "findViewById(R.id.request_loading)");
    this.hSw = paramd;
    paramd = findViewById(2131306966);
    p.g(paramd, "findViewById(R.id.request_function)");
    this.nbY = ((TextView)paramd);
    paramd = findViewById(2131306962);
    ((Button)paramd).setOnClickListener((View.OnClickListener)new d(this));
    p.g(paramd, "findViewById<Button>(R.i…)\n            }\n        }");
    this.lJb = ((Button)paramd);
    paramd = findViewById(2131306970);
    ((Button)paramd).setOnClickListener((View.OnClickListener)new e(this));
    p.g(paramd, "findViewById<Button>(R.i…)\n            }\n        }");
    this.lJa = ((Button)paramd);
    AppMethodBeat.o(228966);
  }
  
  private final void bON()
  {
    AppMethodBeat.i(228942);
    Object localObject = this.nbO;
    if (localObject != null) {
      b.c.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject, 3, new ArrayList());
    }
    localObject = this.nbZ;
    if (localObject == null) {
      p.btv("component");
    }
    i((com.tencent.mm.plugin.appbrand.d)localObject);
    AppMethodBeat.o(228942);
  }
  
  private final void bOO()
  {
    AppMethodBeat.i(228943);
    Object localObject = this.nbN;
    if (localObject == null) {
      p.btv("requestContainer");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(228943);
  }
  
  private final i.a getSelectedItem()
  {
    AppMethodBeat.i(228962);
    Object localObject = this.nbW;
    if (localObject == null) {
      p.btv("mAdapter");
    }
    localObject = ((i)localObject).iHf.iterator();
    while (((Iterator)localObject).hasNext())
    {
      i.a locala = (i.a)((Iterator)localObject).next();
      if ((locala != null) && (locala.jCx == true))
      {
        AppMethodBeat.o(228962);
        return locala;
      }
    }
    AppMethodBeat.o(228962);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d paramd, String paramString, ag paramag)
  {
    AppMethodBeat.i(228965);
    p.h(paramd, "component");
    paramd = paramd.getContext();
    p.g(paramd, "component.context");
    paramd = new d(paramd);
    paramd.setExplainContent(paramString);
    paramd = (com.tencent.mm.plugin.appbrand.permission.g)paramd;
    AppMethodBeat.o(228965);
    return paramd;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(228944);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.nbN;
    if (paramConfiguration == null) {
      p.btv("requestContainer");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(228944);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(228941);
    if ((u.aD((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(228941);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          bON();
          AppMethodBeat.o(228941);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(228941);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(228940);
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
      this.nbP = MotionEvent.obtain(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(228940);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.lJe;
  }
  
  public final String getApplyWording()
  {
    return this.nbU;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final i.b getItemCheckedListener()
  {
    return this.nbX;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.nbP;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b.c getListener()
  {
    return this.nbO;
  }
  
  public final String getRequestDesc()
  {
    return this.nbQ;
  }
  
  public final String getSimpleDetailDesc()
  {
    return this.nbS;
  }
  
  public final void h(final com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(228963);
    p.h(paramd, "component");
    this.nbZ = paramd;
    Context localContext = paramd.getContext();
    Object localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if (localObject != null)
    {
      localObject = (ViewGroup)((Activity)localObject).findViewById(16908290);
      if (localObject != null) {
        ((ViewGroup)localObject).addView((View)this, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    bringToFront();
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    localObject = (View)this;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new g((View)localObject, paramd));
    int i = this.nbL;
    if (!ao.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      S(i, bool);
      setBackgroundColor(this.nbL);
      paramd = this.nbZ;
      if (paramd == null) {
        p.btv("component");
      }
      localObject = paramd.getContext();
      paramd = (com.tencent.mm.plugin.appbrand.d)localObject;
      if (!(localObject instanceof AppBrandUI)) {
        paramd = null;
      }
      paramd = (AppBrandUI)paramd;
      if (paramd == null) {
        break;
      }
      paramd.setNavigationbarColor(this.nbL);
      AppMethodBeat.o(228963);
      return;
    }
    AppMethodBeat.o(228963);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(228964);
    p.h(paramd, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(228964);
  }
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(228954);
    ImageView localImageView = this.lIO;
    if (localImageView == null) {
      p.btv("mExplainIv");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      localImageView = this.lIO;
      if (localImageView == null) {
        p.btv("mExplainIv");
      }
      localImageView.setImageDrawable(android.support.v4.content.b.l(getContext(), 2131231024));
      AppMethodBeat.o(228954);
      return;
    }
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(228945);
    this.lJe = paramString;
    TextView localTextView = this.jVh;
    if (localTextView == null) {
      p.btv("mNameTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(228945);
  }
  
  public final void setApplyWording(String paramString)
  {
    AppMethodBeat.i(228948);
    this.nbU = paramString;
    TextView localTextView = this.nbT;
    if (localTextView == null) {
      p.btv("mApplyWordingTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(228948);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(228955);
    ImageView localImageView = this.lIO;
    if (localImageView == null) {
      p.btv("mExplainIv");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(228955);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(228959);
    TextView localTextView = this.nbY;
    if (localTextView == null) {
      p.btv("funcTv");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(228959);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(228956);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = this.nbY;
      if (paramString == null) {
        p.btv("funcTv");
      }
      paramString.setText((CharSequence)"");
      paramString = this.nbY;
      if (paramString == null) {
        p.btv("funcTv");
      }
      paramString.setVisibility(4);
      AppMethodBeat.o(228956);
      return;
    }
    TextView localTextView = this.nbY;
    if (localTextView == null) {
      p.btv("funcTv");
    }
    localTextView.setText((CharSequence)paramString);
    paramString = this.nbY;
    if (paramString == null) {
      p.btv("funcTv");
    }
    paramString.setVisibility(0);
    AppMethodBeat.o(228956);
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(228958);
    TextView localTextView = this.nbY;
    if (localTextView == null) {
      p.btv("funcTv");
    }
    localTextView.setTextColor(paramInt);
    AppMethodBeat.o(228958);
  }
  
  public final void setFunctionButtonVisibility(int paramInt)
  {
    AppMethodBeat.i(228957);
    TextView localTextView = this.nbY;
    if (localTextView == null) {
      p.btv("funcTv");
    }
    localTextView.setVisibility(paramInt);
    AppMethodBeat.o(228957);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(228949);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.aXY();
    ImageView localImageView = this.lIM;
    if (localImageView == null) {
      p.btv("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), 2131233911, (b.h)com.tencent.mm.modelappbrand.a.g.iJB);
    AppMethodBeat.o(228949);
  }
  
  public final void setItemCheckedListener(i.b paramb)
  {
    AppMethodBeat.i(228952);
    this.nbX = paramb;
    i locali = this.nbW;
    if (locali == null) {
      p.btv("mAdapter");
    }
    locali.nbX = paramb;
    AppMethodBeat.o(228952);
  }
  
  public final void setListener(com.tencent.mm.plugin.appbrand.permission.a.b.c paramc)
  {
    this.nbO = paramc;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(228960);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.lJb;
        if (localObject == null) {
          p.btv("mBtnReject");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(228960);
      return;
    }
  }
  
  public final void setOnListItemLongClickListener(i.d paramd)
  {
    AppMethodBeat.i(228953);
    p.h(paramd, "listener");
    i locali = this.nbW;
    if (locali == null) {
      p.btv("mAdapter");
    }
    locali.oqX = paramd;
    AppMethodBeat.o(228953);
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(228961);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.lJa;
        if (localObject == null) {
          p.btv("mBtnAccept");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(228961);
      return;
    }
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(228946);
    this.nbQ = paramString;
    TextView localTextView = this.jVn;
    if (localTextView == null) {
      p.btv("mDescTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(228946);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(228950);
    p.h(paramString, "scope");
    this.lGX = paramString;
    AppMethodBeat.o(228950);
  }
  
  public final void setSelectListItem(List<i.a> paramList)
  {
    AppMethodBeat.i(228951);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(228951);
        return;
      }
      this.cvc.clear();
      this.cvc.addAll((Collection)paramList);
      paramList = this.nbW;
      if (paramList == null) {
        p.btv("mAdapter");
      }
      paramList.notifyDataSetChanged();
      paramList = this.nbV;
      if (paramList == null) {
        p.btv("mSelectListLayout");
      }
      paramList.setVisibility(0);
      paramList = this.nbR;
      if (paramList == null) {
        p.btv("mSimpleDetailDescTv");
      }
      paramList.setVisibility(8);
      paramList = this.hSw;
      if (paramList == null) {
        p.btv("loadingView");
      }
      paramList.setVisibility(8);
      AppMethodBeat.o(228951);
      return;
    }
    AppMethodBeat.o(228951);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(228947);
    this.nbS = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.nbR;
        if (localObject == null) {
          p.btv("mSimpleDetailDescTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
        paramString = this.nbR;
        if (paramString == null) {
          p.btv("mSimpleDetailDescTv");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(228947);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, b paramb) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(228932);
      this.nca.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = b.d(jdField_this).getParent();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 == null) {}
      for (;;)
      {
        AppMethodBeat.o(228932);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(228933);
      a.cw((View)this.ncb);
      AppMethodBeat.o(228933);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    public c(b paramb) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(228934);
      p.h(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      b.e(this.ncb);
      AppMethodBeat.o(228934);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$3$1"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228935);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = b.a(this.ncb, false);
      localObject = this.ncb.getListener();
      if (localObject != null) {
        b.c.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject, 2, paramView);
      }
      this.ncb.i(b.b(this.ncb));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228935);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$4$1"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228936);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = b.a(this.ncb, true);
      localObject = this.ncb.getListener();
      i.a locala;
      if (localObject != null)
      {
        locala = b.c(this.ncb);
        if (locala == null) {
          break label116;
        }
      }
      label116:
      for (int i = locala.lGW;; i = 0)
      {
        ((com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject).a(1, paramView, i);
        this.ncb.i(b.b(this.ncb));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(228936);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228937);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      b.a(this.ncb);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228937);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class g
    implements ViewTreeObserver.OnPreDrawListener
  {
    public g(View paramView, com.tencent.mm.plugin.appbrand.d paramd) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(228939);
      this.nca.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.nca;
      ((View)localObject).setTranslationY(((View)localObject).getMeasuredHeight());
      localObject = ((View)localObject).animate().setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationY(0.0F).setDuration(300L);
      ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new a(this));
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(228939);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$$special$$inlined$apply$lambda$1"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(b.g paramg) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(228938);
        paramAnimator = AndroidContextUtil.castActivityOrNull(this.ncc.mpE.getContext());
        if (paramAnimator != null)
        {
          c.bt(paramAnimator).requestApplyInsets();
          AppMethodBeat.o(228938);
          return;
        }
        AppMethodBeat.o(228938);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b
 * JD-Core Version:    0.7.0.1
 */