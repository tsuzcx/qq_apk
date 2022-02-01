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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mContentLayout", "Landroid/widget/LinearLayout;", "mFuncTv", "mIconIv", "Landroid/widget/ImageView;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mLoadingView", "Landroid/view/View;", "mNameTv", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mRequestDescTv", "mRootView", "Landroid/widget/RelativeLayout;", "mSimpleDetailDescTv", "Lkotlin/Function0;", "", "onAccept", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onPhoneItemSelect", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "adjustRequestContainerHeight", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "onCreateView", "show", "showPrivacyExplainEntry", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  private View gAy;
  private String iconUrl;
  private TextView jVh;
  private ImageView lIM;
  private Button lJa;
  private Button lJb;
  private String lJe;
  private ArrayList<PhoneItem> lJn;
  private kotlin.g.a.a<x> lJo;
  private kotlin.g.a.a<x> lJq;
  private kotlin.g.a.a<x> lJt;
  private kotlin.g.a.a<x> lJu;
  private kotlin.g.a.a<x> lJv;
  private RecyclerView mRecyclerView;
  private final int nbL;
  private TextView nbR;
  private TextView nbT;
  private final com.tencent.mm.plugin.appbrand.d nbZ;
  private RelativeLayout ncd;
  private TextView nce;
  private LinearLayout ncf;
  private TextView ncg;
  private com.tencent.mm.plugin.appbrand.phonenumber.q nch;
  private kotlin.g.a.a<x> nci;
  private kotlin.g.a.b<? super PhoneItem, x> ncj;
  
  public c(com.tencent.mm.plugin.appbrand.d paramd)
  {
    super((Context)localObject1);
    AppMethodBeat.i(229011);
    this.nbZ = paramd;
    this.lJn = new ArrayList();
    this.lJo = ((kotlin.g.a.a)d.ncl);
    this.nci = ((kotlin.g.a.a)j.nco);
    this.lJq = ((kotlin.g.a.a)f.ncn);
    this.lJt = ((kotlin.g.a.a)k.ncp);
    this.lJu = ((kotlin.g.a.a)e.ncm);
    this.lJv = ((kotlin.g.a.a)l.ncq);
    this.ncj = ((kotlin.g.a.b)m.ncr);
    this.nbL = android.support.v4.content.b.n(getContext(), 2131101424);
    LayoutInflater.from(getContext()).inflate(2131493032, (ViewGroup)this, true);
    paramd = findViewById(2131297917);
    p.g(paramd, "findViewById<View>(R.id.button_group)");
    a.cw(paramd);
    paramd = (RelativeLayout)findViewById(2131306963);
    localObject1 = LayoutInflater.from(getContext()).inflate(2131493031, (ViewGroup)paramd, false);
    p.g(localObject1, "group");
    localObject2 = ((View)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramd = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(229011);
      throw paramd;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131306964);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    paramd.addView((View)localObject1);
    p.g(paramd, "container");
    this.ncd = paramd;
    bOO();
    findViewById(2131301850).setOnClickListener((View.OnClickListener)new g(this));
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306967);
    p.g(paramd, "mRootView.findViewById(R.id.request_icon)");
    this.lIM = ((ImageView)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306969);
    p.g(paramd, "mRootView.findViewById(R.id.request_name)");
    this.jVh = ((TextView)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306962);
    p.g(paramd, "mRootView.findViewById(R.id.request_cancel)");
    this.lJb = ((Button)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306970);
    p.g(paramd, "mRootView.findViewById(R.id.request_ok)");
    this.lJa = ((Button)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306965);
    p.g(paramd, "mRootView.findViewById(R.id.request_desc)");
    this.nce = ((TextView)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131307910);
    p.g(paramd, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.nbR = ((TextView)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306964);
    p.g(paramd, "mRootView.findViewById(R.id.request_content)");
    this.ncf = ((LinearLayout)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306961);
    p.g(paramd, "mRootView.findViewById(R.id.request_apply_wording)");
    this.nbT = ((TextView)paramd);
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306971);
    p.g(paramd, "mRootView.findViewById(R.id.request_recyclerview)");
    this.mRecyclerView = ((RecyclerView)paramd);
    paramd = this.mRecyclerView;
    if (paramd == null) {
      p.btv("mRecyclerView");
    }
    getContext();
    paramd.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306968);
    p.g(paramd, "mRootView.findViewById(R.id.request_loading)");
    this.gAy = paramd;
    paramd = this.ncd;
    if (paramd == null) {
      p.btv("mRootView");
    }
    paramd = paramd.findViewById(2131306966);
    p.g(paramd, "mRootView.findViewById(R.id.request_function)");
    this.ncg = ((TextView)paramd);
    paramd = this.lJa;
    if (paramd == null) {
      p.btv("mBtnAccept");
    }
    paramd.setOnClickListener((View.OnClickListener)new h(this));
    paramd = this.lJb;
    if (paramd == null) {
      p.btv("mBtnReject");
    }
    paramd.setOnClickListener((View.OnClickListener)new i(this));
    paramd = this.mRecyclerView;
    if (paramd == null) {
      p.btv("mRecyclerView");
    }
    paramd.setItemAnimator(null);
    AppMethodBeat.o(229011);
  }
  
  private final void bON()
  {
    AppMethodBeat.i(229010);
    getOnCancel().invoke();
    i(this.nbZ);
    AppMethodBeat.o(229010);
  }
  
  private final void bOO()
  {
    AppMethodBeat.i(229007);
    Object localObject = this.ncd;
    if (localObject == null) {
      p.btv("mRootView");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(229007);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d paramd, String paramString, ag paramag)
  {
    AppMethodBeat.i(229006);
    p.h(paramd, "component");
    paramd = paramd.getContext();
    p.g(paramd, "component.context");
    paramd = new d(paramd);
    paramd.setExplainContent(paramString);
    paramd = (com.tencent.mm.plugin.appbrand.permission.g)paramd;
    AppMethodBeat.o(229006);
    return paramd;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(229008);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.ncd;
    if (paramConfiguration == null) {
      p.btv("mRootView");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(229008);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(229009);
    if ((android.support.v4.view.u.aD((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(229009);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          bON();
          AppMethodBeat.o(229009);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(229009);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.lJe;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final kotlin.g.a.a<x> getOnAccept()
  {
    return this.lJo;
  }
  
  public final kotlin.g.a.a<x> getOnAddPhoneNumber()
  {
    return this.lJu;
  }
  
  public final kotlin.g.a.a<x> getOnCancel()
  {
    return this.lJq;
  }
  
  public final kotlin.g.a.a<x> getOnDeny()
  {
    return this.nci;
  }
  
  public final kotlin.g.a.a<x> getOnExplain()
  {
    return this.lJt;
  }
  
  public final kotlin.g.a.a<x> getOnManagePhoneNumber()
  {
    return this.lJv;
  }
  
  public final kotlin.g.a.b<PhoneItem, x> getOnPhoneItemSelect()
  {
    return this.ncj;
  }
  
  public final ArrayList<PhoneItem> getPhoneItems()
  {
    return this.lJn;
  }
  
  public final void h(final com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(229004);
    p.h(paramd, "component");
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
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new o((View)localObject, paramd));
    int i = this.nbL;
    if (!ao.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      S(i, bool);
      setBackgroundColor(this.nbL);
      localObject = this.nbZ.getContext();
      paramd = (com.tencent.mm.plugin.appbrand.d)localObject;
      if (!(localObject instanceof AppBrandUI)) {
        paramd = null;
      }
      paramd = (AppBrandUI)paramd;
      if (paramd == null) {
        break;
      }
      paramd.setNavigationbarColor(this.nbL);
      AppMethodBeat.o(229004);
      return;
    }
    AppMethodBeat.o(229004);
  }
  
  public final void hm(boolean paramBoolean)
  {
    AppMethodBeat.i(229003);
    ImageView localImageView = (ImageView)findViewById(2131306973);
    p.g(localImageView, "optionBtn");
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localImageView.setImageDrawable(android.support.v4.content.b.l(getContext(), 2131231024));
      localImageView.setOnClickListener((View.OnClickListener)new p(this));
      AppMethodBeat.o(229003);
      return;
    }
    localImageView.setOnClickListener(null);
    AppMethodBeat.o(229003);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(229005);
    p.h(paramd, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(229005);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(228993);
    this.lJe = paramString;
    TextView localTextView = this.jVh;
    if (localTextView == null) {
      p.btv("mNameTv");
    }
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(228993);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(228994);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.aXY();
    ImageView localImageView = this.lIM;
    if (localImageView == null) {
      p.btv("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), 2131233911, (b.h)com.tencent.mm.modelappbrand.a.g.iJB);
    AppMethodBeat.o(228994);
  }
  
  public final void setOnAccept(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228996);
    p.h(parama, "value");
    this.lJo = parama;
    parama = this.lJa;
    if (parama == null) {
      p.btv("mBtnAccept");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.lJa;
        if (parama == null) {
          p.btv("mBtnAccept");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(2131756151));
      }
      AppMethodBeat.o(228996);
      return;
    }
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(229000);
    p.h(parama, "<set-?>");
    this.lJu = parama;
    AppMethodBeat.o(229000);
  }
  
  public final void setOnCancel(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228998);
    p.h(parama, "<set-?>");
    this.lJq = parama;
    AppMethodBeat.o(228998);
  }
  
  public final void setOnDeny(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228997);
    p.h(parama, "value");
    this.nci = parama;
    parama = this.lJb;
    if (parama == null) {
      p.btv("mBtnReject");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.lJb;
        if (parama == null) {
          p.btv("mBtnReject");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(2131756152));
      }
      AppMethodBeat.o(228997);
      return;
    }
  }
  
  public final void setOnExplain(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228999);
    p.h(parama, "<set-?>");
    this.lJt = parama;
    AppMethodBeat.o(228999);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(229001);
    p.h(parama, "<set-?>");
    this.lJv = parama;
    AppMethodBeat.o(229001);
  }
  
  public final void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, x> paramb)
  {
    AppMethodBeat.i(229002);
    p.h(paramb, "value");
    this.ncj = paramb;
    paramb = this.lJa;
    if (paramb == null) {
      p.btv("mBtnAccept");
    }
    paramb = paramb.getText();
    if ((paramb == null) || (paramb.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramb = this.lJa;
        if (paramb == null) {
          p.btv("mBtnAccept");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        paramb.setText((CharSequence)localContext.getResources().getString(2131756151));
      }
      AppMethodBeat.o(229002);
      return;
    }
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(228995);
    p.h(paramArrayList, "value");
    this.lJn = paramArrayList;
    this.nbZ.P((Runnable)new n(this));
    AppMethodBeat.o(228995);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, c paramc) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(228973);
      this.nca.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = c.g(jdField_this).getParent();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 == null) {}
      for (;;)
      {
        AppMethodBeat.o(228973);
        return true;
        if (((ViewGroup)localObject1).getMeasuredHeight() > c.g(jdField_this).getMeasuredHeight())
        {
          localObject2 = c.g(jdField_this).getLayoutParams();
          if (localObject2 != null) {
            ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup)localObject1).getMeasuredHeight();
          }
          c.g(jdField_this).requestLayout();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(228974);
      a.cw((View)this.nck);
      AppMethodBeat.o(228974);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    public c(c paramc) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(228975);
      p.h(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      c.h(this.nck);
      AppMethodBeat.o(228975);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final d ncl;
    
    static
    {
      AppMethodBeat.i(228976);
      ncl = new d();
      AppMethodBeat.o(228976);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final e ncm;
    
    static
    {
      AppMethodBeat.i(228977);
      ncm = new e();
      AppMethodBeat.o(228977);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final f ncn;
    
    static
    {
      AppMethodBeat.i(228978);
      ncn = new f();
      AppMethodBeat.o(228978);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228979);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      c.i(this.nck);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228979);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228980);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      this.nck.getOnAccept().invoke();
      localObject = c.a(this.nck).lJn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramView = (PhoneItem)((Iterator)localObject).next();
        if (paramView.nzz)
        {
          localObject = this.nck.getOnPhoneItemSelect();
          p.g(paramView, "phoneItem");
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
      }
      this.nck.i(c.b(this.nck));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228980);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228981);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.nck.getOnDeny().invoke();
      this.nck.i(c.b(this.nck));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228981);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final j nco;
    
    static
    {
      AppMethodBeat.i(228982);
      nco = new j();
      AppMethodBeat.o(228982);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final k ncp;
    
    static
    {
      AppMethodBeat.i(228983);
      ncp = new k();
      AppMethodBeat.o(228983);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final l ncq;
    
    static
    {
      AppMethodBeat.i(228984);
      ncq = new l();
      AppMethodBeat.o(228984);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<PhoneItem, x>
  {
    public static final m ncr;
    
    static
    {
      AppMethodBeat.i(228986);
      ncr = new m();
      AppMethodBeat.o(228986);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(228989);
      Object localObject = this.nck;
      String str = c.b(this.nck).getAppId();
      p.g(str, "component.appId");
      Context localContext = this.nck.getContext();
      p.g(localContext, "context");
      c.a((c)localObject, new com.tencent.mm.plugin.appbrand.phonenumber.q(str, localContext, this.nck.getPhoneItems()));
      c.c(this.nck).setAdapter((RecyclerView.a)c.a(this.nck));
      c.d(this.nck).setVisibility(0);
      if (this.nck.getPhoneItems().size() == 0)
      {
        c.e(this.nck).setVisibility(0);
        c.c(this.nck).setVisibility(8);
        c.f(this.nck).setVisibility(8);
        AppMethodBeat.o(228989);
        return;
      }
      if (this.nck.getPhoneItems().size() == 1)
      {
        c.e(this.nck).setVisibility(8);
        c.c(this.nck).setVisibility(0);
        localObject = c.c(this.nck).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        c.f(this.nck).setVisibility(0);
        c.f(this.nck).setText((CharSequence)this.nck.getContext().getString(2131756144));
        c.f(this.nck).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(228987);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            this.ncs.nck.getOnAddPhoneNumber().invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228987);
          }
        });
        localObject = com.tencent.mm.plugin.appbrand.phonenumber.u.nAe;
        com.tencent.mm.plugin.appbrand.phonenumber.u.bTz();
        AppMethodBeat.o(228989);
        return;
      }
      c.e(this.nck).setVisibility(8);
      c.c(this.nck).setVisibility(0);
      c.f(this.nck).setVisibility(0);
      localObject = c.c(this.nck).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      c.f(this.nck).setText((CharSequence)this.nck.getContext().getString(2131756142));
      c.f(this.nck).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(228988);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.ncs.nck.getOnManagePhoneNumber().invoke();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(228988);
        }
      });
      localObject = com.tencent.mm.plugin.appbrand.phonenumber.u.nAe;
      com.tencent.mm.plugin.appbrand.phonenumber.u.bTz();
      AppMethodBeat.o(228989);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class o
    implements ViewTreeObserver.OnPreDrawListener
  {
    public o(View paramView, com.tencent.mm.plugin.appbrand.d paramd) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(228991);
      this.nca.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.nca;
      ((View)localObject).setTranslationY(((View)localObject).getMeasuredHeight());
      localObject = ((View)localObject).animate().setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationY(0.0F).setDuration(300L);
      ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new a(this));
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(228991);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$$special$$inlined$apply$lambda$1"})
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(c.o paramo) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(228990);
        paramAnimator = AndroidContextUtil.castActivityOrNull(this.nct.mpE.getContext());
        if (paramAnimator != null)
        {
          com.tencent.mm.ui.statusbar.c.bt(paramAnimator).requestApplyInsets();
          AppMethodBeat.o(228990);
          return;
        }
        AppMethodBeat.o(228990);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228992);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.nck.getOnExplain().invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(228992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c
 * JD-Core Version:    0.7.0.1
 */