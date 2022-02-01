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
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.permission.f;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mContentLayout", "Landroid/widget/LinearLayout;", "mFuncTv", "mIconIv", "Landroid/widget/ImageView;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mLoadingView", "Landroid/view/View;", "mNameTv", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mRequestDescTv", "mRootView", "Landroid/widget/RelativeLayout;", "mSimpleDetailDescTv", "Lkotlin/Function0;", "", "onAccept", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onPhoneItemSelect", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "adjustRequestContainerHeight", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "onCreateView", "show", "showPrivacyExplainEntry", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  private RecyclerView anl;
  private View fTl;
  private String iconUrl;
  private ImageView kAX;
  private TextView kAY;
  private d.g.a.a<z> kBA;
  private d.g.a.a<z> kBC;
  private d.g.a.a<z> kBE;
  private d.g.a.a<z> kBF;
  private d.g.a.a<z> kBG;
  private Button kBm;
  private Button kBn;
  private String kBq;
  private ArrayList<PhoneItem> kBz;
  private final int lPC;
  private TextView lPI;
  private TextView lPK;
  private final com.tencent.mm.plugin.appbrand.d lPQ;
  private RelativeLayout lPT;
  private TextView lPU;
  private LinearLayout lPV;
  private TextView lPW;
  private q lPX;
  private d.g.a.a<z> lPY;
  private d.g.a.b<? super PhoneItem, z> lPZ;
  
  public c(com.tencent.mm.plugin.appbrand.d paramd)
  {
    super((Context)localObject1);
    AppMethodBeat.i(189525);
    this.lPQ = paramd;
    this.kBz = new ArrayList();
    this.kBA = ((d.g.a.a)c.d.lQb);
    this.lPY = ((d.g.a.a)c.j.lQe);
    this.kBC = ((d.g.a.a)c.f.lQd);
    this.kBE = ((d.g.a.a)c.k.lQf);
    this.kBF = ((d.g.a.a)c.e.lQc);
    this.kBG = ((d.g.a.a)c.l.lQg);
    this.lPZ = ((d.g.a.b)c.m.lQh);
    this.lPC = android.support.v4.content.b.n(getContext(), 2131101179);
    LayoutInflater.from(getContext()).inflate(2131496378, (ViewGroup)this, true);
    paramd = findViewById(2131297653);
    p.g(paramd, "findViewById<View>(R.id.button_group)");
    a.cF(paramd);
    paramd = (RelativeLayout)findViewById(2131308187);
    localObject1 = LayoutInflater.from(getContext()).inflate(2131496377, (ViewGroup)paramd, false);
    p.g(localObject1, "group");
    localObject2 = ((View)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramd = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(189525);
      throw paramd;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131304097);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    paramd.addView((View)localObject1);
    p.g(paramd, "container");
    this.lPT = paramd;
    bsw();
    findViewById(2131308120).setOnClickListener((View.OnClickListener)new c.g(this));
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304100);
    p.g(paramd, "mRootView.findViewById(R.id.request_icon)");
    this.kAX = ((ImageView)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304102);
    p.g(paramd, "mRootView.findViewById(R.id.request_name)");
    this.kAY = ((TextView)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304096);
    p.g(paramd, "mRootView.findViewById(R.id.request_cancel)");
    this.kBn = ((Button)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304103);
    p.g(paramd, "mRootView.findViewById(R.id.request_ok)");
    this.kBm = ((Button)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304098);
    p.g(paramd, "mRootView.findViewById(R.id.request_desc)");
    this.lPU = ((TextView)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304825);
    p.g(paramd, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.lPI = ((TextView)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304097);
    p.g(paramd, "mRootView.findViewById(R.id.request_content)");
    this.lPV = ((LinearLayout)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304095);
    p.g(paramd, "mRootView.findViewById(R.id.request_apply_wording)");
    this.lPK = ((TextView)paramd);
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304104);
    p.g(paramd, "mRootView.findViewById(R.id.request_recyclerview)");
    this.anl = ((RecyclerView)paramd);
    paramd = this.anl;
    if (paramd == null) {
      p.bcb("mRecyclerView");
    }
    getContext();
    paramd.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304101);
    p.g(paramd, "mRootView.findViewById(R.id.request_loading)");
    this.fTl = paramd;
    paramd = this.lPT;
    if (paramd == null) {
      p.bcb("mRootView");
    }
    paramd = paramd.findViewById(2131304099);
    p.g(paramd, "mRootView.findViewById(R.id.request_function)");
    this.lPW = ((TextView)paramd);
    paramd = this.kBm;
    if (paramd == null) {
      p.bcb("mBtnAccept");
    }
    paramd.setOnClickListener((View.OnClickListener)new h(this));
    paramd = this.kBn;
    if (paramd == null) {
      p.bcb("mBtnReject");
    }
    paramd.setOnClickListener((View.OnClickListener)new i(this));
    paramd = this.anl;
    if (paramd == null) {
      p.bcb("mRecyclerView");
    }
    paramd.setItemAnimator(null);
    AppMethodBeat.o(189525);
  }
  
  private final void bsv()
  {
    AppMethodBeat.i(189524);
    getOnCancel().invoke();
    i(this.lPQ);
    AppMethodBeat.o(189524);
  }
  
  private final void bsw()
  {
    AppMethodBeat.i(189521);
    Object localObject = this.lPT;
    if (localObject == null) {
      p.bcb("mRootView");
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(189521);
  }
  
  public final f a(com.tencent.mm.plugin.appbrand.d paramd, String paramString, ac paramac)
  {
    AppMethodBeat.i(189520);
    p.h(paramd, "component");
    paramd = paramd.getContext();
    p.g(paramd, "component.context");
    paramd = new d(paramd);
    paramd.setExplainContent(paramString);
    paramd = (f)paramd;
    AppMethodBeat.o(189520);
    return paramd;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(189522);
    super.dispatchConfigurationChanged(paramConfiguration);
    paramConfiguration = this.lPT;
    if (paramConfiguration == null) {
      p.bcb("mRootView");
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new c(this));
    AppMethodBeat.o(189522);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(189523);
    if ((t.aC((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(189523);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          bsv();
          AppMethodBeat.o(189523);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(189523);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.kBq;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final d.g.a.a<z> getOnAccept()
  {
    return this.kBA;
  }
  
  public final d.g.a.a<z> getOnAddPhoneNumber()
  {
    return this.kBF;
  }
  
  public final d.g.a.a<z> getOnCancel()
  {
    return this.kBC;
  }
  
  public final d.g.a.a<z> getOnDeny()
  {
    return this.lPY;
  }
  
  public final d.g.a.a<z> getOnExplain()
  {
    return this.kBE;
  }
  
  public final d.g.a.a<z> getOnManagePhoneNumber()
  {
    return this.kBG;
  }
  
  public final d.g.a.b<PhoneItem, z> getOnPhoneItemSelect()
  {
    return this.lPZ;
  }
  
  public final ArrayList<PhoneItem> getPhoneItems()
  {
    return this.kBz;
  }
  
  public final void gr(boolean paramBoolean)
  {
    AppMethodBeat.i(189517);
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
      AppMethodBeat.o(189517);
      return;
    }
    localImageView.setOnClickListener(null);
    AppMethodBeat.o(189517);
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(189518);
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
    int i = this.lPC;
    if (!al.isDarkMode()) {}
    for (boolean bool = true;; bool = false)
    {
      L(i, bool);
      setBackgroundColor(this.lPC);
      localContext = this.lPQ.getContext();
      paramd = localContext;
      if (!(localContext instanceof AppBrandUI)) {
        paramd = null;
      }
      paramd = (AppBrandUI)paramd;
      if (paramd == null) {
        break;
      }
      paramd.setNavigationbarColor(this.lPC);
      AppMethodBeat.o(189518);
      return;
    }
    AppMethodBeat.o(189518);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(189519);
    p.h(paramd, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction((Runnable)new b(this)).start();
    AppMethodBeat.o(189519);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(189507);
    this.kBq = paramString;
    TextView localTextView = this.kAY;
    if (localTextView == null) {
      p.bcb("mNameTv");
    }
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(189507);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(189508);
    this.iconUrl = paramString;
    paramString = com.tencent.mm.modelappbrand.a.b.aDV();
    ImageView localImageView = this.kAX;
    if (localImageView == null) {
      p.bcb("mIconIv");
    }
    paramString.a(localImageView, getIconUrl(), 2131233241, (b.h)g.hLC);
    AppMethodBeat.o(189508);
  }
  
  public final void setOnAccept(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(189510);
    p.h(parama, "value");
    this.kBA = parama;
    parama = this.kBm;
    if (parama == null) {
      p.bcb("mBtnAccept");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.kBm;
        if (parama == null) {
          p.bcb("mBtnAccept");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(2131756036));
      }
      AppMethodBeat.o(189510);
      return;
    }
  }
  
  public final void setOnAddPhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(189514);
    p.h(parama, "<set-?>");
    this.kBF = parama;
    AppMethodBeat.o(189514);
  }
  
  public final void setOnCancel(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(189512);
    p.h(parama, "<set-?>");
    this.kBC = parama;
    AppMethodBeat.o(189512);
  }
  
  public final void setOnDeny(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(189511);
    p.h(parama, "value");
    this.lPY = parama;
    parama = this.kBn;
    if (parama == null) {
      p.bcb("mBtnReject");
    }
    parama = parama.getText();
    if ((parama == null) || (parama.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.kBn;
        if (parama == null) {
          p.bcb("mBtnReject");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        parama.setText((CharSequence)localContext.getResources().getString(2131756037));
      }
      AppMethodBeat.o(189511);
      return;
    }
  }
  
  public final void setOnExplain(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(189513);
    p.h(parama, "<set-?>");
    this.kBE = parama;
    AppMethodBeat.o(189513);
  }
  
  public final void setOnManagePhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(189515);
    p.h(parama, "<set-?>");
    this.kBG = parama;
    AppMethodBeat.o(189515);
  }
  
  public final void setOnPhoneItemSelect(d.g.a.b<? super PhoneItem, z> paramb)
  {
    AppMethodBeat.i(189516);
    p.h(paramb, "value");
    this.lPZ = paramb;
    paramb = this.kBm;
    if (paramb == null) {
      p.bcb("mBtnAccept");
    }
    paramb = paramb.getText();
    if ((paramb == null) || (paramb.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramb = this.kBm;
        if (paramb == null) {
          p.bcb("mBtnAccept");
        }
        Context localContext = getContext();
        p.g(localContext, "context");
        paramb.setText((CharSequence)localContext.getResources().getString(2131756036));
      }
      AppMethodBeat.o(189516);
      return;
    }
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(189509);
    p.h(paramArrayList, "value");
    this.kBz = paramArrayList;
    this.lPQ.M((Runnable)new n(this));
    AppMethodBeat.o(189509);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, c paramc) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(189488);
      this.lPR.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = c.g(jdField_this).getParent();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 == null) {}
      for (;;)
      {
        AppMethodBeat.o(189488);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(189489);
      a.cF((View)this.lQa);
      AppMethodBeat.o(189489);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
  public static final class c
    implements View.OnLayoutChangeListener
  {
    public c(c paramc) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(189490);
      p.h(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      c.h(this.lQa);
      AppMethodBeat.o(189490);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(189495);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      this.lQa.getOnAccept().invoke();
      localObject = c.a(this.lQa).kBz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramView = (PhoneItem)((Iterator)localObject).next();
        if (paramView.mjQ)
        {
          localObject = this.lQa.getOnPhoneItemSelect();
          p.g(paramView, "phoneItem");
          ((d.g.a.b)localObject).invoke(paramView);
        }
      }
      this.lQa.i(c.b(this.lQa));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(189495);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(189496);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.lQa.getOnDeny().invoke();
      this.lQa.i(c.b(this.lQa));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(189496);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(189504);
      Object localObject = this.lQa;
      String str = c.b(this.lQa).getAppId();
      p.g(str, "component.appId");
      Context localContext = this.lQa.getContext();
      p.g(localContext, "context");
      c.a((c)localObject, new q(str, localContext, this.lQa.getPhoneItems()));
      c.c(this.lQa).setAdapter((RecyclerView.a)c.a(this.lQa));
      c.d(this.lQa).setVisibility(0);
      if (this.lQa.getPhoneItems().size() == 0)
      {
        c.e(this.lQa).setVisibility(0);
        c.c(this.lQa).setVisibility(8);
        c.f(this.lQa).setVisibility(8);
        AppMethodBeat.o(189504);
        return;
      }
      if (this.lQa.getPhoneItems().size() == 1)
      {
        c.e(this.lQa).setVisibility(8);
        c.c(this.lQa).setVisibility(0);
        localObject = c.c(this.lQa).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        c.f(this.lQa).setVisibility(0);
        c.f(this.lQa).setText((CharSequence)this.lQa.getContext().getString(2131756029));
        c.f(this.lQa).setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(189502);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            this.lQi.lQa.getOnAddPhoneNumber().invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189502);
          }
        });
        localObject = u.mkv;
        u.bwy();
        AppMethodBeat.o(189504);
        return;
      }
      c.e(this.lQa).setVisibility(8);
      c.c(this.lQa).setVisibility(0);
      c.f(this.lQa).setVisibility(0);
      localObject = c.c(this.lQa).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      c.f(this.lQa).setText((CharSequence)this.lQa.getContext().getString(2131756027));
      c.f(this.lQa).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189503);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          this.lQi.lQa.getOnManagePhoneNumber().invoke();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189503);
        }
      });
      localObject = u.mkv;
      u.bwy();
      AppMethodBeat.o(189504);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c
 * JD-Core Version:    0.7.0.1
 */