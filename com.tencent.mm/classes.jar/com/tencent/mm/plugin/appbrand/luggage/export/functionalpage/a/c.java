package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
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
import androidx.core.g.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.n;
import com.tencent.mm.plugin.appbrand.phonenumber.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "buttonGroup", "Landroid/widget/LinearLayout;", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mContentLayout", "mFuncTv", "mIconIv", "Landroid/widget/ImageView;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mLoadingView", "Landroid/view/View;", "mNameTv", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mRequestDescTv", "mRootView", "Landroid/widget/RelativeLayout;", "mSimpleDetailDescTv", "Lkotlin/Function1;", "", "", "onAccept", "getOnAccept", "()Lkotlin/jvm/functions/Function1;", "setOnAccept", "(Lkotlin/jvm/functions/Function1;)V", "onAddPhoneNumber", "Lkotlin/Function0;", "getOnAddPhoneNumber", "()Lkotlin/jvm/functions/Function0;", "setOnAddPhoneNumber", "(Lkotlin/jvm/functions/Function0;)V", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onPhoneItemSelect", "getOnPhoneItemSelect", "setOnPhoneItemSelect", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "userAgreementComponent", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent;", "adjustRequestContainerHeight", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "event", "Landroid/view/KeyEvent;", "isUserUserAgreementChecked", "onCheckAcceptAllow", "onCreateView", "setDialogApplyWording", "wording", "setDialogRequestDesc", "setDialogSubDesc", "desc", "setIExternalToolsHelper", "externalToolsHelper", "setUserAgreementCheckBoxWording", "setUserAgreementCheckedAlertListener", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/UserAgreementCheckedAlertListener;", "show", "showPrivacyExplainEntry", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
{
  private kotlin.g.a.a<ah> Uu;
  private String iconUrl;
  private View lNf;
  private RecyclerView mRecyclerView;
  private TextView pJc;
  private ArrayList<PhoneItem> rIF;
  private kotlin.g.a.a<ah> rIK;
  private kotlin.g.a.a<ah> rIL;
  private kotlin.g.a.a<ah> rIM;
  private ImageView rIe;
  private Button rIs;
  private Button rIt;
  private String rIw;
  private final int tgS;
  private LinearLayout tgV;
  private e tgW;
  private TextView tha;
  private TextView thc;
  private final com.tencent.mm.plugin.appbrand.g thh;
  private RelativeLayout thl;
  private TextView thm;
  private LinearLayout thn;
  private TextView tho;
  private q thp;
  private kotlin.g.a.b<? super Boolean, ah> thq;
  private kotlin.g.a.a<ah> thr;
  private kotlin.g.a.b<? super PhoneItem, ah> ths;
  
  public c(com.tencent.mm.plugin.appbrand.g paramg)
  {
    super((Context)localObject1);
    AppMethodBeat.i(319981);
    this.thh = paramg;
    this.rIF = new ArrayList();
    this.thq = ((kotlin.g.a.b)c.c.thu);
    this.thr = ((kotlin.g.a.a)c.f.thx);
    this.Uu = ((kotlin.g.a.a)c.e.thw);
    this.rIK = ((kotlin.g.a.a)c.g.thy);
    this.rIL = ((kotlin.g.a.a)c.d.thv);
    this.rIM = ((kotlin.g.a.a)c.h.thz);
    this.ths = ((kotlin.g.a.b)c.i.thA);
    this.tgS = androidx.core.content.a.w(getContext(), ba.c.white);
    LayoutInflater.from(getContext()).inflate(ba.g.app_brand_functional_page_js_authorize_prompt_ui, (ViewGroup)this, true);
    paramg = findViewById(ba.f.button_group);
    s.s(paramg, "findViewById<View>(R.id.button_group)");
    a.dx(paramg);
    paramg = (RelativeLayout)findViewById(ba.f.request_container);
    localObject1 = LayoutInflater.from(getContext()).inflate(ba.g.app_brand_functional_page_js_authorize_bottom_button_group, (ViewGroup)paramg, false);
    localObject2 = ((View)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(319981);
      throw paramg;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ba.f.request_content);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    paramg.addView((View)localObject1);
    s.s(paramg, "container");
    this.thl = paramg;
    localObject2 = getContext();
    s.s(localObject2, "context");
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.user_agreement_layout);
    s.s(paramg, "mRootView.findViewById(R.id.user_agreement_layout)");
    this.tgW = new e((Context)localObject2, paramg);
    cBx();
    findViewById(ba.f.functional_page_custom_actionbar_close).setOnClickListener(new c..ExternalSyntheticLambda4(this));
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_icon);
    s.s(paramg, "mRootView.findViewById(R.id.request_icon)");
    this.rIe = ((ImageView)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_name);
    s.s(paramg, "mRootView.findViewById(R.id.request_name)");
    this.pJc = ((TextView)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_cancel);
    s.s(paramg, "mRootView.findViewById(R.id.request_cancel)");
    this.rIt = ((Button)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_ok);
    s.s(paramg, "mRootView.findViewById(R.id.request_ok)");
    this.rIs = ((Button)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_desc);
    s.s(paramg, "mRootView.findViewById(R.id.request_desc)");
    this.thm = ((TextView)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.simple_detail_desc);
    s.s(paramg, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.tha = ((TextView)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_content);
    s.s(paramg, "mRootView.findViewById(R.id.request_content)");
    this.thn = ((LinearLayout)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_apply_wording);
    s.s(paramg, "mRootView.findViewById(R.id.request_apply_wording)");
    this.thc = ((TextView)paramg);
    localObject1 = this.thl;
    paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mRootView");
      paramg = null;
    }
    paramg = paramg.findViewById(ba.f.request_recyclerview);
    s.s(paramg, "mRootView.findViewById(R.id.request_recyclerview)");
    this.mRecyclerView = ((RecyclerView)paramg);
    paramg = this.mRecyclerView;
    if (paramg == null)
    {
      s.bIx("mRecyclerView");
      paramg = null;
    }
    for (;;)
    {
      getContext();
      paramg.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject1 = this.thl;
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mRootView");
        paramg = null;
      }
      paramg = paramg.findViewById(ba.f.request_loading);
      s.s(paramg, "mRootView.findViewById(R.id.request_loading)");
      this.lNf = paramg;
      localObject1 = this.thl;
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mRootView");
        paramg = null;
      }
      paramg = paramg.findViewById(ba.f.request_function);
      s.s(paramg, "mRootView.findViewById(R.id.request_function)");
      this.tho = ((TextView)paramg);
      localObject1 = this.rIs;
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mBtnAccept");
        paramg = null;
      }
      paramg.setOnClickListener(new c..ExternalSyntheticLambda3(this));
      localObject1 = this.rIt;
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mBtnReject");
        paramg = null;
      }
      paramg.setOnClickListener(new c..ExternalSyntheticLambda2(this));
      localObject1 = this.mRecyclerView;
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mRecyclerView");
        paramg = null;
      }
      paramg.setItemAnimator(null);
      paramg = findViewById(ba.f.button_group);
      s.s(paramg, "findViewById(R.id.button_group)");
      this.tgV = ((LinearLayout)paramg);
      AppMethodBeat.o(319981);
      return;
    }
  }
  
  private static final void a(c paramc)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    AppMethodBeat.i(320017);
    s.u(paramc, "this$0");
    Object localObject1 = paramc.thh.getAppId();
    s.s(localObject1, "component.appId");
    Object localObject2 = paramc.getContext();
    s.s(localObject2, "context");
    paramc.thp = new q((String)localObject1, (Context)localObject2, paramc.getPhoneItems());
    localObject1 = paramc.mRecyclerView;
    if (localObject1 == null)
    {
      s.bIx("mRecyclerView");
      localObject1 = null;
      q localq = paramc.thp;
      localObject2 = localq;
      if (localq == null)
      {
        s.bIx("mItemAdapter");
        localObject2 = null;
      }
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject2 = paramc.thn;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mContentLayout");
        localObject1 = null;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      if (paramc.getPhoneItems().size() != 0) {
        break label232;
      }
      localObject2 = paramc.lNf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mLoadingView");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(0);
      localObject2 = paramc.mRecyclerView;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mRecyclerView");
        localObject1 = null;
      }
      ((RecyclerView)localObject1).setVisibility(8);
      paramc = paramc.tho;
      if (paramc != null) {
        break label229;
      }
      s.bIx("mFuncTv");
      paramc = localObject5;
    }
    label229:
    for (;;)
    {
      paramc.setVisibility(8);
      AppMethodBeat.o(320017);
      return;
      break;
    }
    label232:
    if (paramc.getPhoneItems().size() == 1)
    {
      localObject2 = paramc.lNf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mLoadingView");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(8);
      localObject2 = paramc.mRecyclerView;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mRecyclerView");
        localObject1 = null;
      }
      ((RecyclerView)localObject1).setVisibility(0);
      localObject2 = paramc.mRecyclerView;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mRecyclerView");
        localObject1 = null;
      }
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 != null) {
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
      }
      localObject2 = paramc.tho;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mFuncTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(0);
      localObject1 = paramc.tho;
      if (localObject1 == null)
      {
        s.bIx("mFuncTv");
        localObject1 = null;
        ((TextView)localObject1).setText((CharSequence)paramc.getContext().getString(ba.i.appbrand_phone_number_use_other_phone_number));
        localObject2 = paramc.tho;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("mFuncTv");
          localObject1 = null;
        }
        ((TextView)localObject1).setOnClickListener(new c..ExternalSyntheticLambda0(paramc));
        localObject1 = com.tencent.mm.plugin.appbrand.phonenumber.u.tHm;
        if (com.tencent.mm.plugin.appbrand.phonenumber.u.cHB().cHs()) {
          break label679;
        }
        paramc = paramc.tho;
        if (paramc != null) {
          break label464;
        }
        s.bIx("mFuncTv");
        paramc = localObject3;
      }
      for (;;)
      {
        paramc.setVisibility(8);
        AppMethodBeat.o(320017);
        return;
        break;
      }
    }
    else
    {
      localObject2 = paramc.lNf;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mLoadingView");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(8);
      localObject2 = paramc.mRecyclerView;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mRecyclerView");
        localObject1 = null;
      }
      ((RecyclerView)localObject1).setVisibility(0);
      localObject2 = paramc.tho;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mFuncTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(0);
      localObject2 = paramc.mRecyclerView;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mRecyclerView");
        localObject1 = null;
      }
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      if (localObject1 != null) {
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
      }
      localObject1 = paramc.tho;
      if (localObject1 != null) {
        break label686;
      }
      s.bIx("mFuncTv");
      localObject1 = null;
      ((TextView)localObject1).setText((CharSequence)paramc.getContext().getString(ba.i.appbrand_phone_number_manager_phone_number));
      localObject2 = paramc.tho;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mFuncTv");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(new c..ExternalSyntheticLambda5(paramc));
      localObject1 = com.tencent.mm.plugin.appbrand.phonenumber.u.tHm;
      if (!com.tencent.mm.plugin.appbrand.phonenumber.u.cHB().cHs())
      {
        paramc = paramc.tho;
        if (paramc != null) {
          break label689;
        }
        s.bIx("mFuncTv");
        paramc = localObject4;
      }
    }
    label679:
    label686:
    label689:
    for (;;)
    {
      label464:
      paramc.setVisibility(8);
      AppMethodBeat.o(320017);
      return;
      break;
    }
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(319997);
    s.u(paramc, "this$0");
    paramc.getOnAddPhoneNumber().invoke();
    AppMethodBeat.o(319997);
  }
  
  private static final void b(c paramc)
  {
    AppMethodBeat.i(320029);
    s.u(paramc, "this$0");
    a.dx((View)paramc);
    AppMethodBeat.o(320029);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(320005);
    s.u(paramc, "this$0");
    paramc.getOnManagePhoneNumber().invoke();
    AppMethodBeat.o(320005);
  }
  
  private static final void c(c paramc, View paramView)
  {
    AppMethodBeat.i(320024);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.getOnExplain().invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(320024);
  }
  
  private final void cBw()
  {
    AppMethodBeat.i(319990);
    getOnCancel().invoke();
    i(this.thh);
    AppMethodBeat.o(319990);
  }
  
  private final void cBx()
  {
    AppMethodBeat.i(319986);
    RelativeLayout localRelativeLayout = this.thl;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      s.bIx("mRootView");
      localObject = null;
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(319986);
  }
  
  private static final void d(c paramc, View paramView)
  {
    AppMethodBeat.i(320034);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.cBw();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(320034);
  }
  
  private static final void e(c paramc, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(320042);
    Object localObject2 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramc);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    s.u(paramc, "this$0");
    localObject2 = paramc.tgW;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("userAgreementComponent");
      paramView = null;
    }
    if (!paramView.cBy())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(320042);
      return;
    }
    localObject3 = paramc.getOnAccept();
    localObject2 = paramc.tgW;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("userAgreementComponent");
      paramView = null;
    }
    ((kotlin.g.a.b)localObject3).invoke(Boolean.valueOf(paramView.cBy()));
    paramView = paramc.thp;
    if (paramView == null)
    {
      s.bIx("mItemAdapter");
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramView.rIF.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramView = (PhoneItem)((Iterator)localObject1).next();
        if (paramView.tGP)
        {
          localObject1 = paramc.getOnPhoneItemSelect();
          s.s(paramView, "phoneItem");
          ((kotlin.g.a.b)localObject1).invoke(paramView);
        }
      }
      paramc.i(paramc.thh);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(320042);
      return;
    }
  }
  
  private static final void f(c paramc, View paramView)
  {
    AppMethodBeat.i(320050);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.getOnDeny().invoke();
    paramc.i(paramc.thh);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(320050);
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, aj paramaj)
  {
    AppMethodBeat.i(320227);
    s.u(paramg, "component");
    paramg = paramg.getContext();
    s.s(paramg, "component.context");
    paramg = new d(paramg);
    paramg.setExplainContent(paramString);
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramg;
    AppMethodBeat.o(320227);
    return paramg;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(320230);
    super.dispatchConfigurationChanged(paramConfiguration);
    RelativeLayout localRelativeLayout = this.thl;
    paramConfiguration = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      s.bIx("mRootView");
      paramConfiguration = null;
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new b(this));
    AppMethodBeat.o(320230);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(320233);
    if (z.ay((View)this))
    {
      int i;
      if ((paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode())) {
        i = 1;
      }
      while (i != 0)
      {
        KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
          {
            localDispatcherState.startTracking(paramKeyEvent, this);
            AppMethodBeat.o(320233);
            return true;
            i = 0;
          }
          else if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
          {
            cBw();
            AppMethodBeat.o(320233);
            return true;
          }
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(320233);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.rIw;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getOnAccept()
  {
    return this.thq;
  }
  
  public final kotlin.g.a.a<ah> getOnAddPhoneNumber()
  {
    return this.rIL;
  }
  
  public final kotlin.g.a.a<ah> getOnCancel()
  {
    return this.Uu;
  }
  
  public final kotlin.g.a.a<ah> getOnDeny()
  {
    return this.thr;
  }
  
  public final kotlin.g.a.a<ah> getOnExplain()
  {
    return this.rIK;
  }
  
  public final kotlin.g.a.a<ah> getOnManagePhoneNumber()
  {
    return this.rIM;
  }
  
  public final kotlin.g.a.b<PhoneItem, ah> getOnPhoneItemSelect()
  {
    return this.ths;
  }
  
  public final ArrayList<PhoneItem> getPhoneItems()
  {
    return this.rIF;
  }
  
  public final void h(final com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(320219);
    s.u(paramg, "component");
    Object localObject = paramg.getContext();
    boolean bool;
    if ((localObject instanceof Activity))
    {
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
      ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new j((View)localObject, paramg));
      int i = this.tgS;
      if (aw.isDarkMode()) {
        break label192;
      }
      bool = true;
      label133:
      aj(i, bool);
      setBackgroundColor(this.tgS);
      paramg = this.thh.getContext();
      if (!(paramg instanceof AppBrandUI)) {
        break label197;
      }
    }
    label192:
    label197:
    for (paramg = (AppBrandUI)paramg;; paramg = null)
    {
      if (paramg != null) {
        AppBrandContainerFragmentActivity.e(paramg, this.tgS);
      }
      AppMethodBeat.o(320219);
      return;
      localObject = null;
      break;
      bool = false;
      break label133;
    }
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(320221);
    s.u(paramg, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction(new c..ExternalSyntheticLambda6(this)).start();
    AppMethodBeat.o(320221);
  }
  
  public final void jc(boolean paramBoolean)
  {
    AppMethodBeat.i(320214);
    ImageView localImageView = (ImageView)findViewById(ba.f.request_right_icon);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localImageView.setImageDrawable(bb.m(getContext(), ba.h.icon_info, androidx.core.content.a.w(getContext(), ba.c.BW_0_Alpha_0_3)));
      localImageView.setOnClickListener(new c..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(320214);
      return;
    }
    localImageView.setOnClickListener(null);
    AppMethodBeat.o(320214);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(320108);
    this.rIw = paramString;
    TextView localTextView = this.pJc;
    if (localTextView == null)
    {
      s.bIx("mNameTv");
      localTextView = null;
      if (paramString != null) {
        break label54;
      }
    }
    label54:
    for (paramString = (CharSequence)"";; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(320108);
      return;
      break;
    }
  }
  
  public final void setDialogApplyWording(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(320209);
    s.u(paramString, "wording");
    Object localObject1 = this.thc;
    int i;
    if (localObject1 == null)
    {
      s.bIx("mApplyWordingTv");
      localObject1 = null;
      if (((CharSequence)paramString).length() <= 0) {
        break label94;
      }
      i = 1;
      label47:
      if (i == 0) {
        break label99;
      }
      i = 0;
      label53:
      ((TextView)localObject1).setVisibility(i);
      localObject1 = this.thc;
      if (localObject1 != null) {
        break label105;
      }
      s.bIx("mApplyWordingTv");
      localObject1 = localObject2;
    }
    label94:
    label99:
    label105:
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)paramString);
      AppMethodBeat.o(320209);
      return;
      break;
      i = 0;
      break label47;
      i = 8;
      break label53;
    }
  }
  
  public final void setDialogRequestDesc(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(320204);
    s.u(paramString, "wording");
    int i;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i != 0)
      {
        TextView localTextView2 = this.thm;
        TextView localTextView1 = localTextView2;
        if (localTextView2 == null)
        {
          s.bIx("mRequestDescTv");
          localTextView1 = null;
        }
        localTextView1.setText((CharSequence)paramString);
        paramString = this.thm;
        if (paramString != null) {
          break label99;
        }
        s.bIx("mRequestDescTv");
        paramString = localObject;
      }
    }
    label99:
    for (;;)
    {
      paramString.setVisibility(0);
      AppMethodBeat.o(320204);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setDialogSubDesc(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(320198);
    s.u(paramString, "desc");
    int i;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i != 0)
      {
        TextView localTextView2 = this.tha;
        TextView localTextView1 = localTextView2;
        if (localTextView2 == null)
        {
          s.bIx("mSimpleDetailDescTv");
          localTextView1 = null;
        }
        localTextView1.setText((CharSequence)paramString);
        paramString = this.tha;
        if (paramString != null) {
          break label99;
        }
        s.bIx("mSimpleDetailDescTv");
        paramString = localObject;
      }
    }
    label99:
    for (;;)
    {
      paramString.setVisibility(0);
      AppMethodBeat.o(320198);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setIExternalToolsHelper(aj paramaj)
  {
    AppMethodBeat.i(320236);
    e locale2 = this.tgW;
    e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("userAgreementComponent");
      locale1 = null;
    }
    locale1.setIExternalToolsHelper(paramaj);
    AppMethodBeat.o(320236);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(320121);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.bEY();
    paramString = this.rIe;
    if (paramString == null)
    {
      s.bIx("mIconIv");
      paramString = null;
    }
    for (;;)
    {
      localb.a(paramString, getIconUrl(), ba.e.miniprogram_default_avatar, (b.h)com.tencent.mm.modelappbrand.a.g.org);
      AppMethodBeat.o(320121);
      return;
    }
  }
  
  public final void setOnAccept(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(320143);
    s.u(paramb, "value");
    this.thq = paramb;
    Button localButton = this.rIs;
    paramb = localButton;
    if (localButton == null)
    {
      s.bIx("mBtnAccept");
      paramb = null;
    }
    paramb = paramb.getText();
    int i;
    if ((paramb == null) || (paramb.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        paramb = this.rIs;
        if (paramb != null) {
          break label115;
        }
        s.bIx("mBtnAccept");
        paramb = localObject;
      }
    }
    label115:
    for (;;)
    {
      paramb.setText((CharSequence)getContext().getResources().getString(ba.i.appbrand_request_accept));
      AppMethodBeat.o(320143);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(320177);
    s.u(parama, "<set-?>");
    this.rIL = parama;
    AppMethodBeat.o(320177);
  }
  
  public final void setOnCancel(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(320158);
    s.u(parama, "<set-?>");
    this.Uu = parama;
    AppMethodBeat.o(320158);
  }
  
  public final void setOnDeny(kotlin.g.a.a<ah> parama)
  {
    Object localObject = null;
    AppMethodBeat.i(320150);
    s.u(parama, "value");
    this.thr = parama;
    Button localButton = this.rIt;
    parama = localButton;
    if (localButton == null)
    {
      s.bIx("mBtnReject");
      parama = null;
    }
    parama = parama.getText();
    int i;
    if ((parama == null) || (parama.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        parama = this.rIt;
        if (parama != null) {
          break label115;
        }
        s.bIx("mBtnReject");
        parama = localObject;
      }
    }
    label115:
    for (;;)
    {
      parama.setText((CharSequence)getContext().getResources().getString(ba.i.appbrand_request_reject));
      AppMethodBeat.o(320150);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setOnExplain(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(320168);
    s.u(parama, "<set-?>");
    this.rIK = parama;
    AppMethodBeat.o(320168);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(320185);
    s.u(parama, "<set-?>");
    this.rIM = parama;
    AppMethodBeat.o(320185);
  }
  
  public final void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, ah> paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(320195);
    s.u(paramb, "value");
    this.ths = paramb;
    Button localButton = this.rIs;
    paramb = localButton;
    if (localButton == null)
    {
      s.bIx("mBtnAccept");
      paramb = null;
    }
    paramb = paramb.getText();
    int i;
    if ((paramb == null) || (paramb.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        paramb = this.rIs;
        if (paramb != null) {
          break label115;
        }
        s.bIx("mBtnAccept");
        paramb = localObject;
      }
    }
    label115:
    for (;;)
    {
      paramb.setText((CharSequence)getContext().getResources().getString(ba.i.appbrand_request_accept));
      AppMethodBeat.o(320195);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(320132);
    s.u(paramArrayList, "value");
    this.rIF = paramArrayList;
    this.thh.V(new c..ExternalSyntheticLambda7(this));
    AppMethodBeat.o(320132);
  }
  
  public final void setUserAgreementCheckBoxWording(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(320235);
    s.u(paramString, "wording");
    e locale2 = this.tgW;
    e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("userAgreementComponent");
      locale1 = null;
    }
    locale1.setUserAgreementCheckBoxWording(paramString);
    paramString = this.tgV;
    if (paramString == null)
    {
      s.bIx("buttonGroup");
      paramString = localObject;
    }
    for (;;)
    {
      paramString = paramString.getLayoutParams();
      if (paramString != null) {
        break;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(320235);
      throw paramString;
    }
    paramString = (RelativeLayout.LayoutParams)paramString;
    paramString.bottomMargin = com.tencent.mm.view.d.e(getContext(), 24.0F);
    paramString.removeRule(12);
    AppMethodBeat.o(320235);
  }
  
  public final void setUserAgreementCheckedAlertListener(com.tencent.mm.plugin.appbrand.widget.dialog.u paramu)
  {
    AppMethodBeat.i(320240);
    e locale2 = this.tgW;
    e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("userAgreementComponent");
      locale1 = null;
    }
    locale1.setUserAgreementCheckedAlertListener(paramu);
    AppMethodBeat.o(320240);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, c paramc) {}
    
    public final boolean onPreDraw()
    {
      Object localObject3 = null;
      AppMethodBeat.i(319951);
      this.thi.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = c.c(jdField_this);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("mRootView");
        localObject1 = null;
      }
      localObject1 = ((RelativeLayout)localObject1).getParent();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 != null)
        {
          int i = ((ViewGroup)localObject1).getMeasuredHeight();
          RelativeLayout localRelativeLayout = c.c(jdField_this);
          localObject2 = localRelativeLayout;
          if (localRelativeLayout == null)
          {
            s.bIx("mRootView");
            localObject2 = null;
          }
          if (i > ((RelativeLayout)localObject2).getMeasuredHeight())
          {
            localRelativeLayout = c.c(jdField_this);
            localObject2 = localRelativeLayout;
            if (localRelativeLayout == null)
            {
              s.bIx("mRootView");
              localObject2 = null;
            }
            localObject2 = ((RelativeLayout)localObject2).getLayoutParams();
            if (localObject2 != null) {
              ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup)localObject1).getMeasuredHeight();
            }
            localObject1 = c.c(jdField_this);
            if (localObject1 != null) {
              break label178;
            }
            s.bIx("mRootView");
            localObject1 = localObject3;
          }
        }
      }
      label178:
      for (;;)
      {
        ((RelativeLayout)localObject1).requestLayout();
        AppMethodBeat.o(319951);
        return true;
        localObject1 = null;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements View.OnLayoutChangeListener
  {
    public b(c paramc) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(319947);
      s.u(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      c.d(this.tht);
      AppMethodBeat.o(319947);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements ViewTreeObserver.OnPreDrawListener
  {
    public j(View paramView, com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(319933);
      this.thi.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.thi;
      ((View)localObject).setTranslationY(((View)localObject).getMeasuredHeight());
      localObject = ((View)localObject).animate().setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationY(0.0F).setDuration(300L);
      ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new c.k(paramg));
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(319933);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends AnimatorListenerAdapter
  {
    k(com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(319930);
      paramAnimator = AndroidContextUtil.castActivityOrNull(this.rEE.getContext());
      if (paramAnimator != null) {
        com.tencent.mm.ui.statusbar.c.ch(paramAnimator).jCH();
      }
      AppMethodBeat.o(319930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c
 * JD-Core Version:    0.7.0.1
 */