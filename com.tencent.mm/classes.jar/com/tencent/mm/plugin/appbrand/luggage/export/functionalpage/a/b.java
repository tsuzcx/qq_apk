package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.app.Activity;
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
import androidx.core.g.z;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.permission.a.b.d.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.u;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.statusbar.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.appbrand.widget.dialog.k.a;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/widget/LinearLayout;", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getListener", "()Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "loadingView", "Landroid/view/View;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDescTv", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mNameTv", "mScope", "mSelectListLayout", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestContainer", "Landroid/widget/RelativeLayout;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "userAgreementComponent", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent;", "adjustRequestContainerHeight", "", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "getLastPointerDownTouchEvent", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isUserUserAgreementChecked", "onCheckAcceptAllow", "onCreateView", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setIExternalToolsHelper", "externalToolsHelper", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "setUserAgreementCheckBoxWording", "wording", "setUserAgreementCheckedAlertListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/UserAgreementCheckedAlertListener;", "show", "showExplainIv", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.permission.a.b
{
  private String eYt;
  private final List<k.a> ell;
  private String iconUrl;
  private View njN;
  private TextView pJc;
  private TextView pJi;
  private ImageView rIe;
  private ImageView rIg;
  private Button rIs;
  private Button rIt;
  private String rIw;
  private String rgX;
  private final int tgS;
  private MaxHeightRecyclerView tgT;
  private RelativeLayout tgU;
  private LinearLayout tgV;
  private e tgW;
  private com.tencent.mm.plugin.appbrand.permission.a.b.d tgX;
  private MotionEvent tgY;
  private String tgZ;
  private TextView tha;
  private String thb;
  private TextView thc;
  private LinearLayout thd;
  private k the;
  private k.b thf;
  private TextView thg;
  private com.tencent.mm.plugin.appbrand.g thh;
  
  public b(com.tencent.mm.plugin.appbrand.g paramg, com.tencent.mm.plugin.appbrand.permission.a.b.d paramd)
  {
    super(paramg);
    AppMethodBeat.i(319977);
    this.tgS = androidx.core.content.a.w(getContext(), ba.c.white);
    this.tgX = paramd;
    this.eYt = "";
    this.ell = ((List)new ArrayList());
    LayoutInflater.from(getContext()).inflate(ba.g.app_brand_functional_page_js_authorize_prompt_ui, (ViewGroup)this, true);
    paramg = getContext();
    s.s(paramg, "context");
    paramd = findViewById(ba.f.user_agreement_layout);
    s.s(paramd, "findViewById(R.id.user_agreement_layout)");
    this.tgW = new e(paramg, paramd);
    paramg = findViewById(ba.f.button_group);
    s.s(paramg, "findViewById<View>(R.id.button_group)");
    a.dx(paramg);
    paramg = findViewById(ba.f.request_right_icon);
    s.s(paramg, "findViewById(R.id.request_right_icon)");
    this.rIg = ((ImageView)paramg);
    paramg = (RelativeLayout)findViewById(ba.f.request_container);
    paramd = LayoutInflater.from(getContext()).inflate(ba.g.app_brand_functional_page_js_authorize_bottom_button_group, (ViewGroup)paramg, false);
    localObject = paramd.getLayoutParams();
    if (localObject == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(319977);
      throw paramg;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).addRule(3, ba.f.request_content);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramg.addView(paramd);
    s.s(paramg, "container");
    this.tgU = paramg;
    cBx();
    findViewById(ba.f.functional_page_custom_actionbar_close).setOnClickListener(new b..ExternalSyntheticLambda1(this));
    paramg = findViewById(ba.f.request_name);
    s.s(paramg, "findViewById(R.id.request_name)");
    this.pJc = ((TextView)paramg);
    paramg = findViewById(ba.f.request_desc);
    s.s(paramg, "findViewById(R.id.request_desc)");
    this.pJi = ((TextView)paramg);
    paramg = findViewById(ba.f.simple_detail_desc);
    s.s(paramg, "findViewById(R.id.simple_detail_desc)");
    this.tha = ((TextView)paramg);
    paramg = findViewById(ba.f.request_apply_wording);
    s.s(paramg, "findViewById(R.id.request_apply_wording)");
    this.thc = ((TextView)paramg);
    paramg = findViewById(ba.f.request_icon);
    s.s(paramg, "findViewById(R.id.request_icon)");
    this.rIe = ((ImageView)paramg);
    paramg = findViewById(ba.f.request_content);
    s.s(paramg, "findViewById(R.id.request_content)");
    this.thd = ((LinearLayout)paramg);
    paramg = findViewById(ba.f.request_recyclerview);
    s.s(paramg, "findViewById(R.id.request_recyclerview)");
    this.tgT = ((MaxHeightRecyclerView)paramg);
    paramg = this.tgT;
    if (paramg == null)
    {
      s.bIx("recyclerView");
      paramg = null;
      getContext();
      paramg.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.the = new k(this.ell);
      paramg = this.tgT;
      if (paramg != null) {
        break label731;
      }
      s.bIx("recyclerView");
      paramg = null;
    }
    label731:
    for (;;)
    {
      localObject = this.the;
      paramd = (com.tencent.mm.plugin.appbrand.permission.a.b.d)localObject;
      if (localObject == null)
      {
        s.bIx("mAdapter");
        paramd = null;
      }
      paramg.setAdapter((RecyclerView.a)paramd);
      paramd = this.tgT;
      paramg = paramd;
      if (paramd == null)
      {
        s.bIx("recyclerView");
        paramg = null;
      }
      paramg.setItemAnimator(null);
      paramg = findViewById(ba.f.request_loading);
      s.s(paramg, "findViewById(R.id.request_loading)");
      this.njN = paramg;
      paramg = findViewById(ba.f.request_function);
      s.s(paramg, "findViewById(R.id.request_function)");
      this.thg = ((TextView)paramg);
      paramg = findViewById(ba.f.request_cancel);
      ((Button)paramg).setOnClickListener(new b..ExternalSyntheticLambda2(this));
      paramd = ah.aiuX;
      s.s(paramg, "findViewById<Button>(R.i…)\n            }\n        }");
      this.rIt = ((Button)paramg);
      paramg = findViewById(ba.f.request_ok);
      ((Button)paramg).setOnClickListener(new b..ExternalSyntheticLambda0(this));
      paramd = ah.aiuX;
      s.s(paramg, "findViewById<Button>(R.i…)\n            }\n        }");
      this.rIs = ((Button)paramg);
      paramg = findViewById(ba.f.button_group);
      s.s(paramg, "findViewById(R.id.button_group)");
      this.tgV = ((LinearLayout)paramg);
      AppMethodBeat.o(319977);
      return;
      break;
    }
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(320035);
    s.u(paramb, "this$0");
    a.dx((View)paramb);
    AppMethodBeat.o(320035);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(320016);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.cBw();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(320016);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(320022);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = paramb.kc(false);
    localObject = paramb.getListener();
    if (localObject != null) {
      b.d.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.d)localObject, 2, paramView);
    }
    localObject = paramb.thh;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("component");
      paramView = null;
    }
    paramb.i(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(320022);
  }
  
  private static final void c(b paramb, View paramView)
  {
    AppMethodBeat.i(320031);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    if (!paramb.cBy())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(320031);
      return;
    }
    paramView = paramb.kc(true);
    localObject1 = paramb.getListener();
    if (localObject1 != null)
    {
      localObject2 = paramb.getSelectedItem();
      if (localObject2 != null) {
        break label192;
      }
    }
    label192:
    for (int i = 0;; i = ((k.a)localObject2).rFX)
    {
      ((com.tencent.mm.plugin.appbrand.permission.a.b.d)localObject1).a(1, paramView, i, paramb.cBy());
      localObject1 = paramb.thh;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("component");
        paramView = null;
      }
      paramb.i(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(320031);
      return;
    }
  }
  
  private final void cBw()
  {
    AppMethodBeat.i(319982);
    Object localObject = this.tgX;
    if (localObject != null) {
      b.d.a.a((com.tencent.mm.plugin.appbrand.permission.a.b.d)localObject, 3, new ArrayList());
    }
    com.tencent.mm.plugin.appbrand.g localg = this.thh;
    localObject = localg;
    if (localg == null)
    {
      s.bIx("component");
      localObject = null;
    }
    i((com.tencent.mm.plugin.appbrand.g)localObject);
    AppMethodBeat.o(319982);
  }
  
  private final void cBx()
  {
    AppMethodBeat.i(319987);
    RelativeLayout localRelativeLayout = this.tgU;
    Object localObject = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      s.bIx("requestContainer");
      localObject = null;
    }
    localObject = (View)localObject;
    ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a((View)localObject, this));
    AppMethodBeat.o(319987);
  }
  
  private boolean cBy()
  {
    AppMethodBeat.i(319991);
    e locale2 = this.tgW;
    e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("userAgreementComponent");
      locale1 = null;
    }
    boolean bool = locale1.cBy();
    AppMethodBeat.o(319991);
    return bool;
  }
  
  private final k.a getSelectedItem()
  {
    AppMethodBeat.i(320009);
    Object localObject2 = this.the;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mAdapter");
      localObject1 = null;
    }
    localObject1 = ((k)localObject1).bMQ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k.a)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((k.a)localObject2).plZ == true)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(320009);
        return localObject2;
      }
    }
    AppMethodBeat.o(320009);
    return null;
  }
  
  private final ArrayList<String> kc(boolean paramBoolean)
  {
    AppMethodBeat.i(320001);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)this.eYt))
    {
      localArrayList.add(this.eYt);
      AppMethodBeat.o(320001);
      return localArrayList;
    }
    Object localObject2 = this.the;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mAdapter");
      localObject1 = null;
    }
    localObject1 = ((k)localObject1).bMQ;
    if (((List)localObject1).size() == 1)
    {
      localObject1 = (k.a)((List)localObject1).get(0);
      if (localObject1 != null)
      {
        localObject1 = ((k.a)localObject1).scope;
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
      AppMethodBeat.o(320001);
      return localArrayList;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    label208:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k.a)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((k.a)localObject2).plZ == paramBoolean)) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (((k.a)localObject2).scope == null)) {
          break label208;
        }
        localObject2 = ((k.a)localObject2).scope;
        s.checkNotNull(localObject2);
        localArrayList.add(localObject2);
        break;
      }
    }
    AppMethodBeat.o(320001);
    return localArrayList;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, aj paramaj)
  {
    AppMethodBeat.i(320234);
    s.u(paramg, "component");
    paramg = paramg.getContext();
    s.s(paramg, "component.context");
    paramg = new d(paramg);
    paramg.setExplainContent(paramString);
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramg;
    AppMethodBeat.o(320234);
    return paramg;
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(320094);
    super.dispatchConfigurationChanged(paramConfiguration);
    RelativeLayout localRelativeLayout = this.tgU;
    paramConfiguration = localRelativeLayout;
    if (localRelativeLayout == null)
    {
      s.bIx("requestContainer");
      paramConfiguration = null;
    }
    ((View)paramConfiguration).addOnLayoutChangeListener((View.OnLayoutChangeListener)new b(this));
    AppMethodBeat.o(320094);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(320086);
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
            AppMethodBeat.o(320086);
            return true;
            i = 0;
          }
          else if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
          {
            cBw();
            AppMethodBeat.o(320086);
            return true;
          }
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(320086);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(320078);
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
      this.tgY = MotionEvent.obtain(paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(320078);
    return bool;
  }
  
  public final String getAppBrandName()
  {
    return this.rIw;
  }
  
  public final String getApplyWording()
  {
    return this.rgX;
  }
  
  public final String getIconUrl()
  {
    return this.iconUrl;
  }
  
  public final k.b getItemCheckedListener()
  {
    return this.thf;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.tgY;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.a.b.d getListener()
  {
    return this.tgX;
  }
  
  public final String getRequestDesc()
  {
    return this.tgZ;
  }
  
  public final String getSimpleDetailDesc()
  {
    return this.thb;
  }
  
  public final void h(final com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(320228);
    s.u(paramg, "component");
    this.thh = paramg;
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
      ((View)localObject).getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new c((View)localObject, paramg));
      int i = this.tgS;
      if (aw.isDarkMode()) {
        break label215;
      }
      bool = true;
      label138:
      aj(i, bool);
      setBackgroundColor(this.tgS);
      localObject = this.thh;
      paramg = (com.tencent.mm.plugin.appbrand.g)localObject;
      if (localObject == null)
      {
        s.bIx("component");
        paramg = null;
      }
      paramg = paramg.getContext();
      if (!(paramg instanceof AppBrandUI)) {
        break label220;
      }
    }
    label215:
    label220:
    for (paramg = (AppBrandUI)paramg;; paramg = null)
    {
      if (paramg != null) {
        AppBrandContainerFragmentActivity.e(paramg, this.tgS);
      }
      AppMethodBeat.o(320228);
      return;
      localObject = null;
      break;
      bool = false;
      break label138;
    }
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(320231);
    s.u(paramg, "component");
    animate().cancel();
    animate().translationY(getMeasuredHeight()).setDuration(300L).withEndAction(new b..ExternalSyntheticLambda3(this)).start();
    AppMethodBeat.o(320231);
  }
  
  public final void kb(boolean paramBoolean)
  {
    AppMethodBeat.i(320176);
    Object localObject = this.rIg;
    if (localObject == null)
    {
      s.bIx("mExplainIv");
      localObject = null;
      if (!paramBoolean) {
        break label90;
      }
    }
    label90:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      ImageView localImageView = this.rIg;
      localObject = localImageView;
      if (localImageView == null)
      {
        s.bIx("mExplainIv");
        localObject = null;
      }
      ((ImageView)localObject).setImageDrawable(bb.m(getContext(), ba.h.icon_info, androidx.core.content.a.w(getContext(), ba.c.BW_0_Alpha_0_3)));
      AppMethodBeat.o(320176);
      return;
      break;
    }
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(320105);
    this.rIw = paramString;
    TextView localTextView2 = this.pJc;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("mNameTv");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(320105);
  }
  
  public final void setApplyWording(String paramString)
  {
    AppMethodBeat.i(320139);
    this.rgX = paramString;
    TextView localTextView2 = this.thc;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("mApplyWordingTv");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(320139);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(320181);
    ImageView localImageView2 = this.rIg;
    ImageView localImageView1 = localImageView2;
    if (localImageView2 == null)
    {
      s.bIx("mExplainIv");
      localImageView1 = null;
    }
    localImageView1.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(320181);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(320200);
    TextView localTextView2 = this.thg;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("funcTv");
      localTextView1 = null;
    }
    localTextView1.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(320200);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(320186);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = this.thg;
      if (paramString == null)
      {
        s.bIx("funcTv");
        paramString = null;
        paramString.setText((CharSequence)"");
        paramString = this.thg;
        if (paramString != null) {
          break label78;
        }
        s.bIx("funcTv");
        paramString = localObject1;
      }
      label78:
      for (;;)
      {
        paramString.setVisibility(4);
        AppMethodBeat.o(320186);
        return;
        break;
      }
    }
    TextView localTextView = this.thg;
    localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("funcTv");
      localObject1 = null;
    }
    localObject1.setText((CharSequence)paramString);
    paramString = this.thg;
    if (paramString == null)
    {
      s.bIx("funcTv");
      paramString = localObject2;
    }
    for (;;)
    {
      paramString.setVisibility(0);
      AppMethodBeat.o(320186);
      return;
    }
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(320196);
    TextView localTextView2 = this.thg;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("funcTv");
      localTextView1 = null;
    }
    localTextView1.setTextColor(paramInt);
    AppMethodBeat.o(320196);
  }
  
  public final void setFunctionButtonVisibility(int paramInt)
  {
    AppMethodBeat.i(320191);
    TextView localTextView2 = this.thg;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("funcTv");
      localTextView1 = null;
    }
    localTextView1.setVisibility(paramInt);
    AppMethodBeat.o(320191);
  }
  
  public final void setIExternalToolsHelper(aj paramaj)
  {
    AppMethodBeat.i(320216);
    e locale2 = this.tgW;
    e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("userAgreementComponent");
      locale1 = null;
    }
    locale1.setIExternalToolsHelper(paramaj);
    AppMethodBeat.o(320216);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(320146);
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
      AppMethodBeat.o(320146);
      return;
    }
  }
  
  public final void setItemCheckedListener(k.b paramb)
  {
    AppMethodBeat.i(320165);
    this.thf = paramb;
    k localk2 = this.the;
    k localk1 = localk2;
    if (localk2 == null)
    {
      s.bIx("mAdapter");
      localk1 = null;
    }
    localk1.thf = paramb;
    AppMethodBeat.o(320165);
  }
  
  public final void setListener(com.tencent.mm.plugin.appbrand.permission.a.b.d paramd)
  {
    this.tgX = paramd;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(320203);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Button localButton = this.rIt;
        localObject = localButton;
        if (localButton == null)
        {
          s.bIx("mBtnReject");
          localObject = null;
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(320203);
      return;
    }
  }
  
  public final void setOnListItemLongClickListener(k.d paramd)
  {
    AppMethodBeat.i(320170);
    s.u(paramd, "listener");
    k localk2 = this.the;
    k localk1 = localk2;
    if (localk2 == null)
    {
      s.bIx("mAdapter");
      localk1 = null;
    }
    localk1.uCV = paramd;
    AppMethodBeat.o(320170);
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(320208);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Button localButton = this.rIs;
        localObject = localButton;
        if (localButton == null)
        {
          s.bIx("mBtnAccept");
          localObject = null;
        }
        ((Button)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(320208);
      return;
    }
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(320116);
    this.tgZ = paramString;
    TextView localTextView2 = this.pJi;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("mDescTv");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(320116);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(320151);
    s.u(paramString, "scope");
    this.eYt = paramString;
    AppMethodBeat.o(320151);
  }
  
  public final void setSelectListItem(List<k.a> paramList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(320156);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(320156);
        return;
      }
      this.ell.clear();
      this.ell.addAll((Collection)paramList);
      Object localObject2 = this.the;
      paramList = (List<k.a>)localObject2;
      if (localObject2 == null)
      {
        s.bIx("mAdapter");
        paramList = null;
      }
      paramList.bZE.notifyChanged();
      localObject2 = this.thd;
      paramList = (List<k.a>)localObject2;
      if (localObject2 == null)
      {
        s.bIx("mSelectListLayout");
        paramList = null;
      }
      paramList.setVisibility(0);
      localObject2 = this.tha;
      paramList = (List<k.a>)localObject2;
      if (localObject2 == null)
      {
        s.bIx("mSimpleDetailDescTv");
        paramList = null;
      }
      paramList.setVisibility(8);
      paramList = this.njN;
      if (paramList != null) {
        break label156;
      }
      s.bIx("loadingView");
      paramList = localObject1;
    }
    label156:
    for (;;)
    {
      paramList.setVisibility(8);
      AppMethodBeat.o(320156);
      return;
    }
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(320127);
    this.thb = paramString;
    Object localObject1 = (CharSequence)paramString;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        TextView localTextView = this.tha;
        localObject1 = localTextView;
        if (localTextView == null)
        {
          s.bIx("mSimpleDetailDescTv");
          localObject1 = null;
        }
        ((TextView)localObject1).setText((CharSequence)paramString);
        paramString = this.tha;
        if (paramString != null) {
          break label103;
        }
        s.bIx("mSimpleDetailDescTv");
        paramString = localObject2;
      }
    }
    label103:
    for (;;)
    {
      paramString.setVisibility(0);
      AppMethodBeat.o(320127);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setUserAgreementCheckBoxWording(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(320213);
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
      AppMethodBeat.o(320213);
      throw paramString;
    }
    paramString = (RelativeLayout.LayoutParams)paramString;
    paramString.bottomMargin = com.tencent.mm.view.d.e(getContext(), 24.0F);
    paramString.removeRule(12);
    AppMethodBeat.o(320213);
  }
  
  public final void setUserAgreementCheckedAlertListener(u paramu)
  {
    AppMethodBeat.i(320220);
    e locale2 = this.tgW;
    e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("userAgreementComponent");
      locale1 = null;
    }
    locale1.setUserAgreementCheckedAlertListener(paramu);
    AppMethodBeat.o(320220);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public a(View paramView, b paramb) {}
    
    public final boolean onPreDraw()
    {
      Object localObject3 = null;
      AppMethodBeat.i(319999);
      this.thi.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject2 = b.b(jdField_this);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("requestContainer");
        localObject1 = null;
      }
      localObject1 = ((RelativeLayout)localObject1).getParent();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = (ViewGroup)localObject1;
        if (localObject1 != null)
        {
          int i = ((ViewGroup)localObject1).getMeasuredHeight();
          RelativeLayout localRelativeLayout = b.b(jdField_this);
          localObject2 = localRelativeLayout;
          if (localRelativeLayout == null)
          {
            s.bIx("requestContainer");
            localObject2 = null;
          }
          if (i > ((RelativeLayout)localObject2).getMeasuredHeight())
          {
            localRelativeLayout = b.b(jdField_this);
            localObject2 = localRelativeLayout;
            if (localRelativeLayout == null)
            {
              s.bIx("requestContainer");
              localObject2 = null;
            }
            localObject2 = ((RelativeLayout)localObject2).getLayoutParams();
            if (localObject2 != null) {
              ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup)localObject1).getMeasuredHeight();
            }
            localObject1 = b.b(jdField_this);
            if (localObject1 != null) {
              break label178;
            }
            s.bIx("requestContainer");
            localObject1 = localObject3;
          }
        }
      }
      label178:
      for (;;)
      {
        ((RelativeLayout)localObject1).requestLayout();
        AppMethodBeat.o(319999);
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
    public b(b paramb) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(319983);
      s.u(paramView, "view");
      paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      b.c(this.thj);
      AppMethodBeat.o(319983);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ViewTreeObserver.OnPreDrawListener
  {
    public c(View paramView, com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(319998);
      this.thi.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = this.thi;
      ((View)localObject).setTranslationY(((View)localObject).getMeasuredHeight());
      localObject = ((View)localObject).animate().setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationY(0.0F).setDuration(300L);
      ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new b.d(paramg));
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(319998);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(319980);
      paramAnimator = AndroidContextUtil.castActivityOrNull(this.rEE.getContext());
      if (paramAnimator != null) {
        c.ch(paramAnimator).jCH();
      }
      AppMethodBeat.o(319980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b
 * JD-Core Version:    0.7.0.1
 */