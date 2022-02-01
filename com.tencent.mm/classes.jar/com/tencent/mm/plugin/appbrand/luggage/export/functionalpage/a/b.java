package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
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
import androidx.core.g.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.a.b.d.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.d;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.statusbar.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getListener", "()Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "loadingView", "Landroid/view/View;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDescTv", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mNameTv", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestContainer", "Landroid/widget/RelativeLayout;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "adjustRequestContainerHeight", "", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "getLastPointerDownTouchEvent", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "onCreateView", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class b
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.permission.a.b
{
  private final List<h.a> ctq;
  private String iconUrl;
  private View kGT;
  private TextView mMA;
  private TextView mMu;
  private String oCG;
  private ImageView oFa;
  private ImageView oFc;
  private Button oFo;
  private Button oFp;
  private String oFs;
  private final int qbZ;
  private MaxHeightRecyclerView qca;
  private RelativeLayout qcb;
  private com.tencent.mm.plugin.appbrand.permission.a.b.d qcc;
  private MotionEvent qcd;
  private String qce;
  private TextView qcf;
  private String qcg;
  private TextView qch;
  private String qci;
  private LinearLayout qcj;
  private h qck;
  private h.b qcl;
  private TextView qcm;
  private com.tencent.mm.plugin.appbrand.g qcn;
  
  public b(com.tencent.mm.plugin.appbrand.g paramg, com.tencent.mm.plugin.appbrand.permission.a.b.d paramd)
  {
    super(paramg);
    AppMethodBeat.i(271148);
    this.qbZ = androidx.core.content.a.w(getContext(), au.c.white);
    this.qcc = paramd;
    this.oCG = "";
    this.ctq = ((List)new ArrayList());
    LayoutInflater.from(getContext()).inflate(au.g.app_brand_functional_page_js_authorize_prompt_ui, (ViewGroup)this, true);
    paramg = findViewById(au.f.button_group);
    p.j(paramg, "findViewById<View>(R.id.button_group)");
    a.cP(paramg);
    paramg = findViewById(au.f.request_right_icon);
    p.j(paramg, "findViewById(R.id.request_right_icon)");
    this.oFc = ((ImageView)paramg);
    paramg = (RelativeLayout)findViewById(au.f.request_container);
    paramd = LayoutInflater.from(getContext()).inflate(au.g.app_brand_functional_page_js_authorize_bottom_button_group, (ViewGroup)paramg, false);
    p.j(paramd, "group");
    localObject = paramd.getLayoutParams();
    if (localObject == null)
    {
      paramg = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(271148);
      throw paramg;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).addRule(3, au.f.request_content);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramg.addView(paramd);
    p.j(paramg, "container");
    this.qcb = paramg;
    cbe();
    findViewById(au.f.functional_page_custom_actionbar_close).setOnClickListener((View.OnClickListener)new b.f(this));
    paramg = findViewById(au.f.request_name);
    p.j(paramg, "findViewById(R.id.request_name)");
    this.mMu = ((TextView)paramg);
    paramg = findViewById(au.f.request_desc);
    p.j(paramg, "findViewById(R.id.request_desc)");
    this.mMA = ((TextView)paramg);
    paramg = findViewById(au.f.simple_detail_desc);
    p.j(paramg, "findViewById(R.id.simple_detail_desc)");
    this.qcf = ((TextView)paramg);
    paramg = findViewById(au.f.request_apply_wording);
    p.j(paramg, "findViewById(R.id.request_apply_wording)");
    this.qch = ((TextView)paramg);
    paramg = findViewById(au.f.request_icon);
    p.j(paramg, "findViewById(R.id.request_icon)");
    this.oFa = ((ImageView)paramg);
    paramg = findViewById(au.f.request_content);
    p.j(paramg, "findViewById(R.id.request_content)");
    this.qcj = ((LinearLayout)paramg);
    paramg = findViewById(au.f.request_recyclerview);
    p.j(paramg, "findViewById(R.id.request_recyclerview)");
    this.qca = ((MaxHeightRecyclerView)paramg);
    paramg = this.qca;
    if (paramg == null) {
      p.bGy("recyclerView");
    }
    getContext();
    paramg.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.qck = new h(this.ctq);
    paramg = this.qca;
    if (paramg == null) {
      p.bGy("recyclerView");
    }
    paramd = this.qck;
    if (paramd == null) {
      p.bGy("mAdapter");
    }
    paramg.setAdapter((RecyclerView.a)paramd);
    paramg = this.qca;
    if (paramg == null) {
      p.bGy("recyclerView");
    }
    paramg.setItemAnimator(null);
    paramg = findViewById(au.f.request_loading);
    p.j(paramg, "findViewById(R.id.request_loading)");
    this.kGT = paramg;
    paramg = findViewById(au.f.request_function);
    p.j(paramg, "findViewById(R.id.request_function)");
    this.qcm = ((TextView)paramg);
    paramg = findViewById(au.f.request_cancel);
    ((Button)paramg).setOnClickListener((View.OnClickListener)new d(this));
    p.j(paramg, "findViewById<Button>(R.i…)\n            }\n        }");
    this.oFp = ((Button)paramg);
    paramg = findViewById(au.f.request_ok);
    ((Button)paramg).setOnClickListener((View.OnClickListener)new e(this));
    p.j(paramg, "findViewById<Button>(R.i…)\n            }\n        }");
    this.oFo = ((Button)paramg);
    AppMethodBeat.o(271148);
  }
  
  private final void cbd()
  {
    AppMethodBeat.i(271116);
    Object localObject = this.qcc;
    if (localObject != null) {
      b.d.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.d)localObject, 3, new ArrayList());
    }
    localObject = this.qcn;
    if (localObject == null) {
      p.bGy("component");
    }
    j((com.tencent.mm.plugin.appbrand.g)localObject);
    AppMethodBeat.o(271116);
  }
  
  private final void cbe()
  {
    AppMethodBeat.i(271117);
    Object localObject = this.qcb;
    if (localObject == null) {
      p.bGy("requestContainer");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new b.a((View)localObject, this));
    AppMethodBeat.o(271117);
  }
  
  private final h.a getSelectedItem()
  {
    AppMethodBeat.i(271143);
    Object localObject = this.qck;
    if (localObject == null) {
      p.bGy("mAdapter");
    }
    localObject = ((h)localObject).lxh.iterator();
    while (((Iterator)localObject).hasNext())
    {
      h.a locala = (h.a)((Iterator)localObject).next();
      if ((locala != null) && (locala.msB == true))
      {
        AppMethodBeat.o(271143);
        return locala;
      }
    }
    AppMethodBeat.o(271143);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, ag paramag)
  {
    AppMethodBeat.i(271147);
    p.k(paramg, "component");
    paramg = paramg.getContext();
    p.j(paramg, "component.context");
    paramg = new d(paramg);
    paramg.setExplainContent(paramString);
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramg;
    AppMethodBeat.o(271147);
    return paramg;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(271119);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.qcb;
    if (paramConfiguration == null) {
      p.bGy("requestContainer");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new b.c(this));
    AppMethodBeat.o(271119);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(271115);
    if ((w.al((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(271115);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          cbd();
          AppMethodBeat.o(271115);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(271115);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(271114);
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
      this.qcd = MotionEvent.obtain(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(271114);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.oFs;
  }
  
  public final String getApplyWording()
  {
    return this.qci;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final h.b getItemCheckedListener()
  {
    return this.qcl;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.qcd;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b.d getListener()
  {
    return this.qcc;
  }
  
  public final String getRequestDesc()
  {
    return this.qce;
  }
  
  public final String getSimpleDetailDesc()
  {
    return this.qcg;
  }
  
  public final void i(final com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(271144);
    p.k(paramg, "component");
    this.qcn = paramg;
    Context localContext = paramg.getContext();
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
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new g((View)localObject, paramg));
    int i = this.qbZ;
    if (!ar.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      T(i, bool);
      setBackgroundColor(this.qbZ);
      paramg = this.qcn;
      if (paramg == null) {
        p.bGy("component");
      }
      localObject = paramg.getContext();
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject;
      if (!(localObject instanceof AppBrandUI)) {
        paramg = null;
      }
      paramg = (AppBrandUI)paramg;
      if (paramg == null) {
        break;
      }
      paramg.De(this.qbZ);
      AppMethodBeat.o(271144);
      return;
    }
    AppMethodBeat.o(271144);
  }
  
  public final void iU(boolean paramBoolean)
  {
    AppMethodBeat.i(271131);
    ImageView localImageView = this.oFc;
    if (localImageView == null) {
      p.bGy("mExplainIv");
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      localImageView = this.oFc;
      if (localImageView == null) {
        p.bGy("mExplainIv");
      }
      Context localContext = getContext();
      p.j(localContext, "context");
      localImageView.setImageDrawable(com.tencent.mm.svg.a.a.h(localContext.getResources(), au.h.icon_info));
      AppMethodBeat.o(271131);
      return;
    }
  }
  
  public final void j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(271145);
    p.k(paramg, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(271145);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(271121);
    this.oFs = paramString;
    TextView localTextView = this.mMu;
    if (localTextView == null) {
      p.bGy("mNameTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(271121);
  }
  
  public final void setApplyWording(String paramString)
  {
    AppMethodBeat.i(271124);
    this.qci = paramString;
    TextView localTextView = this.qch;
    if (localTextView == null) {
      p.bGy("mApplyWordingTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(271124);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(271133);
    ImageView localImageView = this.oFc;
    if (localImageView == null) {
      p.bGy("mExplainIv");
    }
    localImageView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(271133);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(271140);
    TextView localTextView = this.qcm;
    if (localTextView == null) {
      p.bGy("funcTv");
    }
    localTextView.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(271140);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(271135);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = this.qcm;
      if (paramString == null) {
        p.bGy("funcTv");
      }
      paramString.setText((CharSequence)"");
      paramString = this.qcm;
      if (paramString == null) {
        p.bGy("funcTv");
      }
      paramString.setVisibility(4);
      AppMethodBeat.o(271135);
      return;
    }
    TextView localTextView = this.qcm;
    if (localTextView == null) {
      p.bGy("funcTv");
    }
    localTextView.setText((CharSequence)paramString);
    paramString = this.qcm;
    if (paramString == null) {
      p.bGy("funcTv");
    }
    paramString.setVisibility(0);
    AppMethodBeat.o(271135);
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(271139);
    TextView localTextView = this.qcm;
    if (localTextView == null) {
      p.bGy("funcTv");
    }
    localTextView.setTextColor(paramInt);
    AppMethodBeat.o(271139);
  }
  
  public final void setFunctionButtonVisibility(int paramInt)
  {
    AppMethodBeat.i(271137);
    TextView localTextView = this.qcm;
    if (localTextView == null) {
      p.bGy("funcTv");
    }
    localTextView.setVisibility(paramInt);
    AppMethodBeat.o(271137);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(271125);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.bhh();
    ImageView localImageView = this.oFa;
    if (localImageView == null) {
      p.bGy("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), au.e.miniprogram_default_avatar, (b.h)com.tencent.mm.modelappbrand.a.g.lzF);
    AppMethodBeat.o(271125);
  }
  
  public final void setItemCheckedListener(h.b paramb)
  {
    AppMethodBeat.i(271128);
    this.qcl = paramb;
    h localh = this.qck;
    if (localh == null) {
      p.bGy("mAdapter");
    }
    localh.qcl = paramb;
    AppMethodBeat.o(271128);
  }
  
  public final void setListener(com.tencent.mm.plugin.appbrand.permission.a.b.d paramd)
  {
    this.qcc = paramd;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(271141);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.oFp;
        if (localObject == null) {
          p.bGy("mBtnReject");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(271141);
      return;
    }
  }
  
  public final void setOnListItemLongClickListener(h.d paramd)
  {
    AppMethodBeat.i(271129);
    p.k(paramd, "listener");
    h localh = this.qck;
    if (localh == null) {
      p.bGy("mAdapter");
    }
    localh.rsu = paramd;
    AppMethodBeat.o(271129);
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(271142);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.oFo;
        if (localObject == null) {
          p.bGy("mBtnAccept");
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(271142);
      return;
    }
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(271122);
    this.qce = paramString;
    TextView localTextView = this.mMA;
    if (localTextView == null) {
      p.bGy("mDescTv");
    }
    localTextView.setText((CharSequence)paramString);
    AppMethodBeat.o(271122);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(271126);
    p.k(paramString, "scope");
    this.oCG = paramString;
    AppMethodBeat.o(271126);
  }
  
  public final void setSelectListItem(List<h.a> paramList)
  {
    AppMethodBeat.i(271127);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(271127);
        return;
      }
      this.ctq.clear();
      this.ctq.addAll((Collection)paramList);
      paramList = this.qck;
      if (paramList == null) {
        p.bGy("mAdapter");
      }
      paramList.notifyDataSetChanged();
      paramList = this.qcj;
      if (paramList == null) {
        p.bGy("mSelectListLayout");
      }
      paramList.setVisibility(0);
      paramList = this.qcf;
      if (paramList == null) {
        p.bGy("mSimpleDetailDescTv");
      }
      paramList.setVisibility(8);
      paramList = this.kGT;
      if (paramList == null) {
        p.bGy("loadingView");
      }
      paramList.setVisibility(8);
      AppMethodBeat.o(271127);
      return;
    }
    AppMethodBeat.o(271127);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(271123);
    this.qcg = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.qcf;
        if (localObject == null) {
          p.bGy("mSimpleDetailDescTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
        paramString = this.qcf;
        if (paramString == null) {
          p.bGy("mSimpleDetailDescTv");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(271123);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(282988);
      a.cP((View)this.qcp);
      AppMethodBeat.o(282988);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$3$1"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264410);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = b.a(this.qcp, false);
      localObject = this.qcp.getListener();
      if (localObject != null) {
        b.d.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.d)localObject, 2, paramView);
      }
      this.qcp.j(b.b(this.qcp));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264410);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$4$1"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271879);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = b.a(this.qcp, true);
      localObject = this.qcp.getListener();
      h.a locala;
      if (localObject != null)
      {
        locala = b.c(this.qcp);
        if (locala == null) {
          break label116;
        }
      }
      label116:
      for (int i = locala.oCE;; i = 0)
      {
        ((com.tencent.mm.plugin.appbrand.permission.a.b.d)localObject).a(1, paramView, i);
        this.qcp.j(b.b(this.qcp));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271879);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class g
    implements ViewTreeObserver.OnPreDrawListener
  {
    public g(View paramView, com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(272438);
      this.qco.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.qco;
      ((View)localObject).setTranslationY(((View)localObject).getMeasuredHeight());
      localObject = ((View)localObject).animate().setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationY(0.0F).setDuration(300L);
      ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new a(this));
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(272438);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$$special$$inlined$apply$lambda$1"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(b.g paramg) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(266330);
        paramAnimator = AndroidContextUtil.castActivityOrNull(this.qcq.pnJ.getContext());
        if (paramAnimator != null)
        {
          c.bA(paramAnimator).hXX();
          AppMethodBeat.o(266330);
          return;
        }
        AppMethodBeat.o(266330);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b
 * JD-Core Version:    0.7.0.1
 */