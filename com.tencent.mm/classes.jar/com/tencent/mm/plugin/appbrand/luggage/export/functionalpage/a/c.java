package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.t;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.q;
import com.tencent.mm.plugin.appbrand.phonenumber.u;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mContentLayout", "Landroid/widget/LinearLayout;", "mFuncTv", "mIconIv", "Landroid/widget/ImageView;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mLoadingView", "Landroid/view/View;", "mNameTv", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mRequestDescTv", "mRootView", "Landroid/widget/RelativeLayout;", "mSimpleDetailDescTv", "Lkotlin/Function0;", "", "onAccept", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onPhoneItemSelect", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "adjustRequestContainerHeight", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "onCreateView", "show", "showPrivacyExplainEntry", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  private RecyclerView anl;
  private View fVr;
  private String iconUrl;
  private Button kEB;
  private Button kEC;
  private String kEF;
  private ArrayList<PhoneItem> kEO;
  private d.g.a.a<z> kEP;
  private d.g.a.a<z> kER;
  private d.g.a.a<z> kET;
  private d.g.a.a<z> kEU;
  private d.g.a.a<z> kEV;
  private ImageView kEm;
  private TextView kEn;
  private d.g.a.b<? super PhoneItem, z> lUA;
  private final int lUd;
  private TextView lUj;
  private TextView lUl;
  private final com.tencent.mm.plugin.appbrand.d lUr;
  private RelativeLayout lUu;
  private TextView lUv;
  private LinearLayout lUw;
  private TextView lUx;
  private q lUy;
  private d.g.a.a<z> lUz;
  
  public c(com.tencent.mm.plugin.appbrand.d paramd)
  {
    super((Context)localObject1);
    AppMethodBeat.i(223785);
    this.lUr = paramd;
    this.kEO = new ArrayList();
    this.kEP = ((d.g.a.a)c.d.lUC);
    this.lUz = ((d.g.a.a)c.j.lUF);
    this.kER = ((d.g.a.a)c.f.lUE);
    this.kET = ((d.g.a.a)c.k.lUG);
    this.kEU = ((d.g.a.a)c.e.lUD);
    this.kEV = ((d.g.a.a)c.l.lUH);
    this.lUA = ((d.g.a.b)c.m.lUI);
    this.lUd = android.support.v4.content.b.n(getContext(), 2131101179);
    LayoutInflater.from(getContext()).inflate(2131496378, (ViewGroup)this, true);
    paramd = findViewById(2131297653);
    p.g(paramd, "findViewById<View>(R.id.button_group)");
    a.cG(paramd);
    paramd = (RelativeLayout)findViewById(2131308187);
    localObject1 = LayoutInflater.from(getContext()).inflate(2131496377, (ViewGroup)paramd, false);
    p.g(localObject1, "group");
    localObject2 = ((View)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramd = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(223785);
      throw paramd;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131304097);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    paramd.addView((View)localObject1);
    p.g(paramd, "container");
    this.lUu = paramd;
    bth();
    findViewById(2131308120).setOnClickListener((View.OnClickListener)new c.g(this));
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304100);
    p.g(paramd, "mRootView.findViewById(R.id.request_icon)");
    this.kEm = ((ImageView)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304102);
    p.g(paramd, "mRootView.findViewById(R.id.request_name)");
    this.kEn = ((TextView)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304096);
    p.g(paramd, "mRootView.findViewById(R.id.request_cancel)");
    this.kEC = ((Button)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304103);
    p.g(paramd, "mRootView.findViewById(R.id.request_ok)");
    this.kEB = ((Button)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304098);
    p.g(paramd, "mRootView.findViewById(R.id.request_desc)");
    this.lUv = ((TextView)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304825);
    p.g(paramd, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.lUj = ((TextView)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304097);
    p.g(paramd, "mRootView.findViewById(R.id.request_content)");
    this.lUw = ((LinearLayout)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304095);
    p.g(paramd, "mRootView.findViewById(R.id.request_apply_wording)");
    this.lUl = ((TextView)paramd);
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304104);
    p.g(paramd, "mRootView.findViewById(R.id.request_recyclerview)");
    this.anl = ((RecyclerView)paramd);
    paramd = this.anl;
    if (paramd == null) {
      p.bdF("mRecyclerView");
    }
    getContext();
    paramd.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304101);
    p.g(paramd, "mRootView.findViewById(R.id.request_loading)");
    this.fVr = paramd;
    paramd = this.lUu;
    if (paramd == null) {
      p.bdF("mRootView");
    }
    paramd = paramd.findViewById(2131304099);
    p.g(paramd, "mRootView.findViewById(R.id.request_function)");
    this.lUx = ((TextView)paramd);
    paramd = this.kEB;
    if (paramd == null) {
      p.bdF("mBtnAccept");
    }
    paramd.setOnClickListener((View.OnClickListener)new h(this));
    paramd = this.kEC;
    if (paramd == null) {
      p.bdF("mBtnReject");
    }
    paramd.setOnClickListener((View.OnClickListener)new i(this));
    paramd = this.anl;
    if (paramd == null) {
      p.bdF("mRecyclerView");
    }
    paramd.setItemAnimator(null);
    AppMethodBeat.o(223785);
  }
  
  private final void btg()
  {
    AppMethodBeat.i(223784);
    getOnCancel().invoke();
    i(this.lUr);
    AppMethodBeat.o(223784);
  }
  
  private final void bth()
  {
    AppMethodBeat.i(223781);
    Object localObject = this.lUu;
    if (localObject == null) {
      p.bdF("mRootView");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(223781);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d paramd, String paramString, ac paramac)
  {
    AppMethodBeat.i(223780);
    p.h(paramd, "component");
    paramd = paramd.getContext();
    p.g(paramd, "component.context");
    paramd = new d(paramd);
    paramd.setExplainContent(paramString);
    paramd = (com.tencent.mm.plugin.appbrand.permission.g)paramd;
    AppMethodBeat.o(223780);
    return paramd;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(223782);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.lUu;
    if (paramConfiguration == null) {
      p.bdF("mRootView");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(223782);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(223783);
    if ((t.aC((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(223783);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          btg();
          AppMethodBeat.o(223783);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(223783);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.kEF;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final d.g.a.a<z> getOnAccept()
  {
    return this.kEP;
  }
  
  public final d.g.a.a<z> getOnAddPhoneNumber()
  {
    return this.kEU;
  }
  
  public final d.g.a.a<z> getOnCancel()
  {
    return this.kER;
  }
  
  public final d.g.a.a<z> getOnDeny()
  {
    return this.lUz;
  }
  
  public final d.g.a.a<z> getOnExplain()
  {
    return this.kET;
  }
  
  public final d.g.a.a<z> getOnManagePhoneNumber()
  {
    return this.kEV;
  }
  
  public final d.g.a.b<PhoneItem, z> getOnPhoneItemSelect()
  {
    return this.lUA;
  }
  
  public final ArrayList<PhoneItem> getPhoneItems()
  {
    return this.kEO;
  }
  
  public final void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(223777);
    ImageView localImageView = (ImageView)findViewById(2131304106);
    p.g(localImageView, "optionBtn");
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localImageView.setImageDrawable(android.support.v4.content.b.l(getContext(), 2131230993));
      localImageView.setOnClickListener((View.OnClickListener)new c.p(this));
      AppMethodBeat.o(223777);
      return;
    }
    localImageView.setOnClickListener(null);
    AppMethodBeat.o(223777);
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(223778);
    p.h(paramd, "component");
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
    paramd.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new c.o(paramd));
    int i = this.lUd;
    if (!al.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      M(i, bool);
      setBackgroundColor(this.lUd);
      localContext = this.lUr.getContext();
      paramd = localContext;
      if (!(localContext instanceof AppBrandUI)) {
        paramd = null;
      }
      paramd = (AppBrandUI)paramd;
      if (paramd == null) {
        break;
      }
      paramd.setNavigationbarColor(this.lUd);
      AppMethodBeat.o(223778);
      return;
    }
    AppMethodBeat.o(223778);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(223779);
    p.h(paramd, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(223779);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(223767);
    this.kEF = paramString;
    TextView localTextView = this.kEn;
    if (localTextView == null) {
      p.bdF("mNameTv");
    }
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(223767);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(223768);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.aEl();
    ImageView localImageView = this.kEm;
    if (localImageView == null) {
      p.bdF("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), 2131233241, (b.h)com.tencent.mm.modelappbrand.a.g.hOv);
    AppMethodBeat.o(223768);
  }
  
  public final void setOnAccept(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223770);
    p.h(parama, "value");
    this.kEP = parama;
    parama = this.kEB;
    if (parama == null) {
      p.bdF("mBtnAccept");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.kEB;
        if (parama == null) {
          p.bdF("mBtnAccept");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(2131756036));
      }
      AppMethodBeat.o(223770);
      return;
    }
  }
  
  public final void setOnAddPhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223774);
    p.h(parama, "<set-?>");
    this.kEU = parama;
    AppMethodBeat.o(223774);
  }
  
  public final void setOnCancel(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223772);
    p.h(parama, "<set-?>");
    this.kER = parama;
    AppMethodBeat.o(223772);
  }
  
  public final void setOnDeny(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223771);
    p.h(parama, "value");
    this.lUz = parama;
    parama = this.kEC;
    if (parama == null) {
      p.bdF("mBtnReject");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.kEC;
        if (parama == null) {
          p.bdF("mBtnReject");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(2131756037));
      }
      AppMethodBeat.o(223771);
      return;
    }
  }
  
  public final void setOnExplain(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223773);
    p.h(parama, "<set-?>");
    this.kET = parama;
    AppMethodBeat.o(223773);
  }
  
  public final void setOnManagePhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(223775);
    p.h(parama, "<set-?>");
    this.kEV = parama;
    AppMethodBeat.o(223775);
  }
  
  public final void setOnPhoneItemSelect(d.g.a.b<? super PhoneItem, z> paramb)
  {
    AppMethodBeat.i(223776);
    p.h(paramb, "value");
    this.lUA = paramb;
    paramb = this.kEB;
    if (paramb == null) {
      p.bdF("mBtnAccept");
    }
    paramb = paramb.getText();
    if ((paramb == null) || (paramb.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramb = this.kEB;
        if (paramb == null) {
          p.bdF("mBtnAccept");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        paramb.setText((CharSequence)localContext.getResources().getString(2131756036));
      }
      AppMethodBeat.o(223776);
      return;
    }
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(223769);
    p.h(paramArrayList, "value");
    this.kEO = paramArrayList;
    this.lUr.K((Runnable)new n(this));
    AppMethodBeat.o(223769);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, c paramc) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(223748);
      this.lUs.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = c.g(jdField_this).getParent();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 == null) {}
      for (;;)
      {
        AppMethodBeat.o(223748);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(223749);
      a.cG((View)this.lUB);
      AppMethodBeat.o(223749);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    public c(c paramc) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(223750);
      p.h(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      c.h(this.lUB);
      AppMethodBeat.o(223750);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223755);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      this.lUB.getOnAccept().invoke();
      localObject = c.a(this.lUB).kEO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramView = (PhoneItem)((Iterator)localObject).next();
        if (paramView.moN)
        {
          localObject = this.lUB.getOnPhoneItemSelect();
          p.g(paramView, "phoneItem");
          ((d.g.a.b)localObject).invoke(paramView);
        }
      }
      this.lUB.i(c.b(this.lUB));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(223755);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223756);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.lUB.getOnDeny().invoke();
      this.lUB.i(c.b(this.lUB));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(223756);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(223764);
      Object localObject = this.lUB;
      String str = c.b(this.lUB).getAppId();
      p.g(str, "component.appId");
      Context localContext = this.lUB.getContext();
      p.g(localContext, "context");
      c.a((c)localObject, new q(str, localContext, this.lUB.getPhoneItems()));
      c.c(this.lUB).setAdapter((RecyclerView.a)c.a(this.lUB));
      c.d(this.lUB).setVisibility(0);
      if (this.lUB.getPhoneItems().size() == 0)
      {
        c.e(this.lUB).setVisibility(0);
        c.c(this.lUB).setVisibility(8);
        c.f(this.lUB).setVisibility(8);
        AppMethodBeat.o(223764);
        return;
      }
      if (this.lUB.getPhoneItems().size() == 1)
      {
        c.e(this.lUB).setVisibility(8);
        c.c(this.lUB).setVisibility(0);
        localObject = c.c(this.lUB).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        c.f(this.lUB).setVisibility(0);
        c.f(this.lUB).setText((CharSequence)this.lUB.getContext().getString(2131756029));
        c.f(this.lUB).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(223762);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            this.lUJ.lUB.getOnAddPhoneNumber().invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(223762);
          }
        });
        localObject = u.mps;
        u.bxp();
        AppMethodBeat.o(223764);
        return;
      }
      c.e(this.lUB).setVisibility(8);
      c.c(this.lUB).setVisibility(0);
      c.f(this.lUB).setVisibility(0);
      localObject = c.c(this.lUB).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      c.f(this.lUB).setText((CharSequence)this.lUB.getContext().getString(2131756027));
      c.f(this.lUB).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(223763);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          this.lUJ.lUB.getOnManagePhoneNumber().invoke();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(223763);
        }
      });
      localObject = u.mps;
      u.bxp();
      AppMethodBeat.o(223764);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c
 * JD-Core Version:    0.7.0.1
 */