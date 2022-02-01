package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.q;
import com.tencent.mm.plugin.appbrand.phonenumber.u;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mContentLayout", "Landroid/widget/LinearLayout;", "mFuncTv", "mIconIv", "Landroid/widget/ImageView;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mLoadingView", "Landroid/view/View;", "mNameTv", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mRequestDescTv", "mRootView", "Landroid/widget/RelativeLayout;", "mSimpleDetailDescTv", "Lkotlin/Function0;", "", "onAccept", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onPhoneItemSelect", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "adjustRequestContainerHeight", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "onCreateView", "show", "showPrivacyExplainEntry", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  private String iconUrl;
  private View jkB;
  private TextView mMu;
  private RecyclerView mRecyclerView;
  private ArrayList<PhoneItem> oFB;
  private kotlin.g.a.a<x> oFC;
  private kotlin.g.a.a<x> oFE;
  private kotlin.g.a.a<x> oFH;
  private kotlin.g.a.a<x> oFI;
  private kotlin.g.a.a<x> oFJ;
  private ImageView oFa;
  private Button oFo;
  private Button oFp;
  private String oFs;
  private final int qbZ;
  private TextView qcf;
  private TextView qch;
  private final com.tencent.mm.plugin.appbrand.g qcn;
  private RelativeLayout qcr;
  private TextView qcs;
  private LinearLayout qct;
  private TextView qcu;
  private q qcv;
  private kotlin.g.a.a<x> qcw;
  private kotlin.g.a.b<? super PhoneItem, x> qcx;
  
  public c(com.tencent.mm.plugin.appbrand.g paramg)
  {
    super((Context)localObject1);
    AppMethodBeat.i(274870);
    this.qcn = paramg;
    this.oFB = new ArrayList();
    this.oFC = ((kotlin.g.a.a)c.d.qcz);
    this.qcw = ((kotlin.g.a.a)c.j.qcC);
    this.oFE = ((kotlin.g.a.a)c.f.qcB);
    this.oFH = ((kotlin.g.a.a)c.k.qcD);
    this.oFI = ((kotlin.g.a.a)c.e.qcA);
    this.oFJ = ((kotlin.g.a.a)c.l.qcE);
    this.qcx = ((kotlin.g.a.b)c.m.qcF);
    this.qbZ = androidx.core.content.a.w(getContext(), au.c.white);
    LayoutInflater.from(getContext()).inflate(au.g.app_brand_functional_page_js_authorize_prompt_ui, (ViewGroup)this, true);
    paramg = findViewById(au.f.button_group);
    p.j(paramg, "findViewById<View>(R.id.button_group)");
    a.cP(paramg);
    paramg = (RelativeLayout)findViewById(au.f.request_container);
    localObject1 = LayoutInflater.from(getContext()).inflate(au.g.app_brand_functional_page_js_authorize_bottom_button_group, (ViewGroup)paramg, false);
    p.j(localObject1, "group");
    localObject2 = ((View)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramg = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(274870);
      throw paramg;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, au.f.request_content);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    paramg.addView((View)localObject1);
    p.j(paramg, "container");
    this.qcr = paramg;
    cbe();
    findViewById(au.f.functional_page_custom_actionbar_close).setOnClickListener((View.OnClickListener)new c.g(this));
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_icon);
    p.j(paramg, "mRootView.findViewById(R.id.request_icon)");
    this.oFa = ((ImageView)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_name);
    p.j(paramg, "mRootView.findViewById(R.id.request_name)");
    this.mMu = ((TextView)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_cancel);
    p.j(paramg, "mRootView.findViewById(R.id.request_cancel)");
    this.oFp = ((Button)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_ok);
    p.j(paramg, "mRootView.findViewById(R.id.request_ok)");
    this.oFo = ((Button)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_desc);
    p.j(paramg, "mRootView.findViewById(R.id.request_desc)");
    this.qcs = ((TextView)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.simple_detail_desc);
    p.j(paramg, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.qcf = ((TextView)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_content);
    p.j(paramg, "mRootView.findViewById(R.id.request_content)");
    this.qct = ((LinearLayout)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_apply_wording);
    p.j(paramg, "mRootView.findViewById(R.id.request_apply_wording)");
    this.qch = ((TextView)paramg);
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_recyclerview);
    p.j(paramg, "mRootView.findViewById(R.id.request_recyclerview)");
    this.mRecyclerView = ((RecyclerView)paramg);
    paramg = this.mRecyclerView;
    if (paramg == null) {
      p.bGy("mRecyclerView");
    }
    getContext();
    paramg.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_loading);
    p.j(paramg, "mRootView.findViewById(R.id.request_loading)");
    this.jkB = paramg;
    paramg = this.qcr;
    if (paramg == null) {
      p.bGy("mRootView");
    }
    paramg = paramg.findViewById(au.f.request_function);
    p.j(paramg, "mRootView.findViewById(R.id.request_function)");
    this.qcu = ((TextView)paramg);
    paramg = this.oFo;
    if (paramg == null) {
      p.bGy("mBtnAccept");
    }
    paramg.setOnClickListener((View.OnClickListener)new h(this));
    paramg = this.oFp;
    if (paramg == null) {
      p.bGy("mBtnReject");
    }
    paramg.setOnClickListener((View.OnClickListener)new i(this));
    paramg = this.mRecyclerView;
    if (paramg == null) {
      p.bGy("mRecyclerView");
    }
    paramg.setItemAnimator(null);
    AppMethodBeat.o(274870);
  }
  
  private final void cbd()
  {
    AppMethodBeat.i(274869);
    getOnCancel().invoke();
    j(this.qcn);
    AppMethodBeat.o(274869);
  }
  
  private final void cbe()
  {
    AppMethodBeat.i(274866);
    Object localObject = this.qcr;
    if (localObject == null) {
      p.bGy("mRootView");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new c.a((View)localObject, this));
    AppMethodBeat.o(274866);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, ag paramag)
  {
    AppMethodBeat.i(274865);
    p.k(paramg, "component");
    paramg = paramg.getContext();
    p.j(paramg, "component.context");
    paramg = new d(paramg);
    paramg.setExplainContent(paramString);
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramg;
    AppMethodBeat.o(274865);
    return paramg;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(274867);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.qcr;
    if (paramConfiguration == null) {
      p.bGy("mRootView");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new c.c(this));
    AppMethodBeat.o(274867);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(274868);
    if ((w.al((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(274868);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          cbd();
          AppMethodBeat.o(274868);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(274868);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.oFs;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final kotlin.g.a.a<x> getOnAccept()
  {
    return this.oFC;
  }
  
  public final kotlin.g.a.a<x> getOnAddPhoneNumber()
  {
    return this.oFI;
  }
  
  public final kotlin.g.a.a<x> getOnCancel()
  {
    return this.oFE;
  }
  
  public final kotlin.g.a.a<x> getOnDeny()
  {
    return this.qcw;
  }
  
  public final kotlin.g.a.a<x> getOnExplain()
  {
    return this.oFH;
  }
  
  public final kotlin.g.a.a<x> getOnManagePhoneNumber()
  {
    return this.oFJ;
  }
  
  public final kotlin.g.a.b<PhoneItem, x> getOnPhoneItemSelect()
  {
    return this.qcx;
  }
  
  public final ArrayList<PhoneItem> getPhoneItems()
  {
    return this.oFB;
  }
  
  public final void i(final com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(274862);
    p.k(paramg, "component");
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
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new o((View)localObject, paramg));
    int i = this.qbZ;
    if (!ar.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      T(i, bool);
      setBackgroundColor(this.qbZ);
      localObject = this.qcn.getContext();
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject;
      if (!(localObject instanceof AppBrandUI)) {
        paramg = null;
      }
      paramg = (AppBrandUI)paramg;
      if (paramg == null) {
        break;
      }
      paramg.De(this.qbZ);
      AppMethodBeat.o(274862);
      return;
    }
    AppMethodBeat.o(274862);
  }
  
  @SuppressLint({"ResourceType"})
  public final void id(boolean paramBoolean)
  {
    AppMethodBeat.i(274861);
    ImageView localImageView = (ImageView)findViewById(au.f.request_right_icon);
    p.j(localImageView, "optionBtn");
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localImageView.setImageDrawable(androidx.core.content.a.m(getContext(), au.h.icon_info));
      localImageView.setOnClickListener((View.OnClickListener)new c.p(this));
      AppMethodBeat.o(274861);
      return;
    }
    localImageView.setOnClickListener(null);
    AppMethodBeat.o(274861);
  }
  
  public final void j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(274864);
    p.k(paramg, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(274864);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(274848);
    this.oFs = paramString;
    TextView localTextView = this.mMu;
    if (localTextView == null) {
      p.bGy("mNameTv");
    }
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(274848);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(274850);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.bhh();
    ImageView localImageView = this.oFa;
    if (localImageView == null) {
      p.bGy("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), au.e.miniprogram_default_avatar, (b.h)com.tencent.mm.modelappbrand.a.g.lzF);
    AppMethodBeat.o(274850);
  }
  
  public final void setOnAccept(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(274852);
    p.k(parama, "value");
    this.oFC = parama;
    parama = this.oFo;
    if (parama == null) {
      p.bGy("mBtnAccept");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.oFo;
        if (parama == null) {
          p.bGy("mBtnAccept");
        }
        Context localContext = getContext();
        p.j(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(au.i.appbrand_request_accept));
      }
      AppMethodBeat.o(274852);
      return;
    }
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(274857);
    p.k(parama, "<set-?>");
    this.oFI = parama;
    AppMethodBeat.o(274857);
  }
  
  public final void setOnCancel(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(274854);
    p.k(parama, "<set-?>");
    this.oFE = parama;
    AppMethodBeat.o(274854);
  }
  
  public final void setOnDeny(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(274853);
    p.k(parama, "value");
    this.qcw = parama;
    parama = this.oFp;
    if (parama == null) {
      p.bGy("mBtnReject");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.oFp;
        if (parama == null) {
          p.bGy("mBtnReject");
        }
        Context localContext = getContext();
        p.j(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(au.i.appbrand_request_reject));
      }
      AppMethodBeat.o(274853);
      return;
    }
  }
  
  public final void setOnExplain(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(274855);
    p.k(parama, "<set-?>");
    this.oFH = parama;
    AppMethodBeat.o(274855);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(274858);
    p.k(parama, "<set-?>");
    this.oFJ = parama;
    AppMethodBeat.o(274858);
  }
  
  public final void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, x> paramb)
  {
    AppMethodBeat.i(274860);
    p.k(paramb, "value");
    this.qcx = paramb;
    paramb = this.oFo;
    if (paramb == null) {
      p.bGy("mBtnAccept");
    }
    paramb = paramb.getText();
    if ((paramb == null) || (paramb.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramb = this.oFo;
        if (paramb == null) {
          p.bGy("mBtnAccept");
        }
        Context localContext = getContext();
        p.j(localContext, "context");
        paramb.setText((CharSequence)localContext.getResources().getString(au.i.appbrand_request_accept));
      }
      AppMethodBeat.o(274860);
      return;
    }
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(274851);
    p.k(paramArrayList, "value");
    this.oFB = paramArrayList;
    this.qcn.P((Runnable)new n(this));
    AppMethodBeat.o(274851);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(275240);
      a.cP((View)this.qcy);
      AppMethodBeat.o(275240);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(275007);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      this.qcy.getOnAccept().invoke();
      localObject = c.a(this.qcy).oFB.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramView = (PhoneItem)((Iterator)localObject).next();
        if (paramView.qBK)
        {
          localObject = this.qcy.getOnPhoneItemSelect();
          p.j(paramView, "phoneItem");
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
      }
      this.qcy.j(c.b(this.qcy));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275007);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280657);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.qcy.getOnDeny().invoke();
      this.qcy.j(c.b(this.qcy));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280657);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(279369);
      Object localObject = this.qcy;
      String str = c.b(this.qcy).getAppId();
      p.j(str, "component.appId");
      Context localContext = this.qcy.getContext();
      p.j(localContext, "context");
      c.a((c)localObject, new q(str, localContext, this.qcy.getPhoneItems()));
      c.c(this.qcy).setAdapter((RecyclerView.a)c.a(this.qcy));
      c.d(this.qcy).setVisibility(0);
      if (this.qcy.getPhoneItems().size() == 0)
      {
        c.e(this.qcy).setVisibility(0);
        c.c(this.qcy).setVisibility(8);
        c.f(this.qcy).setVisibility(8);
        AppMethodBeat.o(279369);
        return;
      }
      if (this.qcy.getPhoneItems().size() == 1)
      {
        c.e(this.qcy).setVisibility(8);
        c.c(this.qcy).setVisibility(0);
        localObject = c.c(this.qcy).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        c.f(this.qcy).setVisibility(0);
        c.f(this.qcy).setText((CharSequence)this.qcy.getContext().getString(au.i.appbrand_phone_number_use_other_phone_number));
        c.f(this.qcy).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(252851);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            this.qcG.qcy.getOnAddPhoneNumber().invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252851);
          }
        });
        localObject = u.qCp;
        u.cgE();
        AppMethodBeat.o(279369);
        return;
      }
      c.e(this.qcy).setVisibility(8);
      c.c(this.qcy).setVisibility(0);
      c.f(this.qcy).setVisibility(0);
      localObject = c.c(this.qcy).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      c.f(this.qcy).setText((CharSequence)this.qcy.getContext().getString(au.i.appbrand_phone_number_manager_phone_number));
      c.f(this.qcy).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(280104);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.qcG.qcy.getOnManagePhoneNumber().invoke();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(280104);
        }
      });
      localObject = u.qCp;
      u.cgE();
      AppMethodBeat.o(279369);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class o
    implements ViewTreeObserver.OnPreDrawListener
  {
    public o(View paramView, com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(281064);
      this.qco.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.qco;
      ((View)localObject).setTranslationY(((View)localObject).getMeasuredHeight());
      localObject = ((View)localObject).animate().setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationY(0.0F).setDuration(300L);
      ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new a(this));
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(281064);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$$special$$inlined$apply$lambda$1"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(c.o paramo) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(245625);
        paramAnimator = AndroidContextUtil.castActivityOrNull(this.qcH.pnJ.getContext());
        if (paramAnimator != null)
        {
          com.tencent.mm.ui.statusbar.c.bA(paramAnimator).hXX();
          AppMethodBeat.o(245625);
          return;
        }
        AppMethodBeat.o(245625);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c
 * JD-Core Version:    0.7.0.1
 */