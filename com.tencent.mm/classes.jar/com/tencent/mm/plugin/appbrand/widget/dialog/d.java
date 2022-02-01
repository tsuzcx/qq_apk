package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.luggage.m.a.b;
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.permission.a.b.a;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.permission.a.b.d.a;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.ui.as;
import com.tencent.mm.plugin.appbrand.widget.a.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "shouldInLargeScreenCompatMode", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;Z)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "getButtonGroup", "()Landroid/view/View;", "setButtonGroup", "(Landroid/view/View;)V", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "getMBtnAccept", "()Landroid/widget/Button;", "setMBtnAccept", "(Landroid/widget/Button;)V", "mBtnReject", "getMBtnReject", "setMBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getMDialogContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "setMDialogContainer", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;)V", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "getMRootView", "mRootWrapperFrameLayout", "Landroid/widget/FrameLayout;", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "userAgreementComponent", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent;", "getUserAgreementComponent", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent;", "setUserAgreementComponent", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent;)V", "changeListHeightByRotation", "", "rotation", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getContentView", "getDialogHeight", "getLastPointerDownTouchEvent", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "isUserUserAgreementChecked", "onBackPressedEvent", "onCancel", "onCheckWhenAcceptClick", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "onShown", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setIExternalToolsHelper", "externalToolsHelper", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "setUserAgreementCheckBoxWording", "wording", "setUserAgreementCheckedAlertListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/UserAgreementCheckedAlertListener;", "show", "showExplainIv", "Companion", "Listener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.permission.a.b, n
{
  public static final d.a uBN;
  private String eYt;
  private final List<k.a> ell;
  private String iconUrl;
  private DialogInterface.OnDismissListener mOnDismissListener;
  private View njN;
  private TextView pJc;
  private int plU;
  private final View plc;
  private ImageView rIe;
  private ImageView rIg;
  private Button rIs;
  private Button rIt;
  private r rIu;
  private String rIw;
  private String rgX;
  private DialogInterface.OnShowListener tFZ;
  private final boolean tGF;
  private MaxHeightRecyclerView tgT;
  private e tgW;
  private MotionEvent tgY;
  private String tgZ;
  private TextView tha;
  private String thb;
  private TextView thc;
  private LinearLayout thd;
  private k the;
  private k.b thf;
  private TextView thg;
  private TextView thm;
  private View uBO;
  private b.d uBP;
  private FrameLayout uBQ;
  
  static
  {
    AppMethodBeat.i(324755);
    uBN = new d.a((byte)0);
    AppMethodBeat.o(324755);
  }
  
  public d(Context paramContext, b.d paramd, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(324707);
    this.tGF = paramBoolean;
    View localView = View.inflate(t.fw(paramContext), a.e.app_brand_request_dialog, null);
    s.s(localView, "inflate(context.wrapScre…and_request_dialog, null)");
    this.plc = localView;
    localView = this.plc.findViewById(a.d.user_agreement_layout);
    s.s(localView, "mRootView.findViewById(R.id.user_agreement_layout)");
    this.tgW = new e(paramContext, localView);
    this.uBP = paramd;
    this.eYt = "";
    this.ell = ((List)new ArrayList());
    paramContext = this.plc.findViewById(a.d.request_icon);
    s.s(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.rIe = ((ImageView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_name);
    s.s(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.pJc = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_cancel);
    s.s(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.rIt = ((Button)paramContext);
    this.rIt.setOnClickListener(new d..ExternalSyntheticLambda0(this));
    paramContext = this.plc.findViewById(a.d.request_ok);
    s.s(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.rIs = ((Button)paramContext);
    this.rIs.setOnClickListener(new d..ExternalSyntheticLambda1(this));
    paramContext = this.plc.findViewById(a.d.request_desc);
    s.s(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.thm = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.simple_detail_desc);
    s.s(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.tha = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_content);
    s.s(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.thd = ((LinearLayout)paramContext);
    paramContext = this.plc.findViewById(a.d.request_right_icon);
    s.s(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.rIg = ((ImageView)paramContext);
    paramContext = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)this.rIg, null, Integer.valueOf(a.g.app_brand_supplement_info), false, null, null, Integer.valueOf(a.b.Edge_1_5_A), 4090);
    paramContext = this.plc.findViewById(a.d.request_apply_wording);
    s.s(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.thc = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_recyclerview);
    s.s(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.tgT = ((MaxHeightRecyclerView)paramContext);
    paramContext = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)this.tgT, null, null, true, null, null, null, 8182);
    this.tgT.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.the = new k(this.ell);
    this.the.thf = this.thf;
    this.tgT.setAdapter((RecyclerView.a)this.the);
    this.tgT.setItemAnimator(null);
    paramContext = this.plc.findViewById(a.d.request_loading);
    s.s(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.njN = paramContext;
    paramContext = this.plc.findViewById(a.d.button_group);
    s.s(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.uBO = paramContext;
    paramContext = this.plc.findViewById(a.d.request_function);
    s.s(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.thg = ((TextView)paramContext);
    paramContext = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)this.thg, Button.class, null, false, null, null, Integer.valueOf(a.b.Edge_1_5_A), 4092);
    if (Build.VERSION.SDK_INT >= 22)
    {
      this.thc.setAccessibilityTraversalAfter(a.d.request_name);
      this.thc.setAccessibilityTraversalBefore(a.d.request_right_icon);
      this.thm.setAccessibilityTraversalAfter(a.d.request_apply_wording);
      this.thm.setAccessibilityTraversalBefore(a.d.request_recyclerview);
      this.thg.setAccessibilityTraversalAfter(a.d.request_recyclerview);
      this.thg.setAccessibilityTraversalBefore(a.d.request_cancel);
    }
    this.plU = 2;
    AppMethodBeat.o(324707);
  }
  
  private final void At(int paramInt)
  {
    AppMethodBeat.i(324731);
    switch (paramInt)
    {
    }
    for (double d = 2.5D;; d = 1.5D)
    {
      this.tgT.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(d, this));
      this.tgT.invalidate();
      AppMethodBeat.o(324731);
      return;
    }
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(324746);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramView = paramd.kc(false);
    b.d.a.a(paramd.uBP, 2, paramView);
    paramView = paramd.rIu;
    if (paramView != null) {
      paramView.c((n)paramd);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324746);
  }
  
  private static final void b(d paramd, View paramView)
  {
    AppMethodBeat.i(324750);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "this$0");
    if (!paramd.tgW.cBy())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(324750);
      return;
    }
    paramView = paramd.kc(true);
    localObject1 = paramd.uBP;
    localObject2 = paramd.getSelectedItem();
    if (localObject2 == null) {}
    for (int i = 0;; i = ((k.a)localObject2).rFX)
    {
      ((b.d)localObject1).a(1, paramView, i, paramd.tgW.cPS());
      paramView = paramd.rIu;
      if (paramView != null) {
        paramView.c((n)paramd);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(324750);
      return;
    }
  }
  
  private final k.a getSelectedItem()
  {
    AppMethodBeat.i(324727);
    Iterator localIterator = this.the.bMQ.iterator();
    while (localIterator.hasNext())
    {
      k.a locala = (k.a)localIterator.next();
      if ((locala != null) && (locala.plZ == true)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(324727);
        return locala;
      }
    }
    AppMethodBeat.o(324727);
    return null;
  }
  
  private r j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(324738);
    paramg = b.a.a((com.tencent.mm.plugin.appbrand.permission.a.b)this, paramg);
    AppMethodBeat.o(324738);
    return paramg;
  }
  
  private final ArrayList<String> kc(boolean paramBoolean)
  {
    AppMethodBeat.i(324722);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)this.eYt))
    {
      localArrayList.add(this.eYt);
      AppMethodBeat.o(324722);
      return localArrayList;
    }
    Object localObject = this.the.bMQ;
    if (((List)localObject).size() == 1)
    {
      localObject = (k.a)((List)localObject).get(0);
      if (localObject != null)
      {
        localObject = ((k.a)localObject).scope;
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      AppMethodBeat.o(324722);
      return localArrayList;
    }
    localObject = ((Iterable)localObject).iterator();
    label187:
    while (((Iterator)localObject).hasNext())
    {
      k.a locala = (k.a)((Iterator)localObject).next();
      if ((locala != null) && (locala.plZ == paramBoolean)) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (locala.scope == null)) {
          break label187;
        }
        localArrayList.add(locala.scope);
        break;
      }
    }
    AppMethodBeat.o(324722);
    return localArrayList;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, aj paramaj)
  {
    AppMethodBeat.i(324804);
    s.u(paramg, "component");
    Context localContext = getContext();
    s.s(localContext, "this.context");
    paramString = new com.tencent.mm.plugin.appbrand.phonenumber.k(paramaj, paramString, localContext, this.plc.getMeasuredHeight(), paramg.getWindowAndroid().asq());
    if (paramg.getWindowAndroid().asu()) {
      paramString.setPosition(1);
    }
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramString;
    AppMethodBeat.o(324804);
    return paramg;
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(324780);
    setPosition(this.plU);
    Object localObject = this.tFZ;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.rIu = paramr;
    paramr = getContext().getSystemService("window");
    if ((paramr instanceof WindowManager)) {}
    for (paramr = (WindowManager)paramr;; paramr = null)
    {
      if (paramr != null)
      {
        localObject = t.uFu;
        localObject = getContentView().getContext();
        s.s(localObject, "contentView.context");
        t.a((Context)localObject, getContentView(), this.uBO, paramr.getDefaultDisplay().getRotation(), this.tGF, this.tgW.cPR());
        At(paramr.getDefaultDisplay().getRotation());
      }
      AppMethodBeat.o(324780);
      return;
    }
  }
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void bQh()
  {
    AppMethodBeat.i(324781);
    com.tencent.mm.plugin.appbrand.widget.a.a.dQ(this.plc);
    AppMethodBeat.o(324781);
  }
  
  public final boolean bQi()
  {
    return false;
  }
  
  protected final View cHe()
  {
    return this.plc;
  }
  
  protected final Button cPL()
  {
    return this.rIs;
  }
  
  protected final Button cPM()
  {
    return this.rIt;
  }
  
  protected final View cPN()
  {
    return this.uBO;
  }
  
  public final e cPO()
  {
    return this.tgW;
  }
  
  public final r cPP()
  {
    return this.rIu;
  }
  
  public final boolean cPQ()
  {
    AppMethodBeat.i(324779);
    boolean bool = this.tgW.cBy();
    AppMethodBeat.o(324779);
    return bool;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(324783);
    super.dismiss();
    DialogInterface.OnDismissListener localOnDismissListener = this.mOnDismissListener;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss((DialogInterface)this);
    }
    AppMethodBeat.o(324783);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(324785);
    if (this.uBQ == null)
    {
      this.uBQ = ((FrameLayout)new d(this, getContext()));
      localFrameLayout = this.uBQ;
      localObject = localFrameLayout;
      if (localFrameLayout == null)
      {
        s.bIx("mRootWrapperFrameLayout");
        localObject = null;
      }
      ((FrameLayout)localObject).addView(this.plc, new ViewGroup.LayoutParams(-1, -1));
    }
    FrameLayout localFrameLayout = this.uBQ;
    Object localObject = localFrameLayout;
    if (localFrameLayout == null)
    {
      s.bIx("mRootWrapperFrameLayout");
      localObject = null;
    }
    localObject = (View)localObject;
    AppMethodBeat.o(324785);
    return localObject;
  }
  
  public MotionEvent getLastPointerDownTouchEvent()
  {
    return this.tgY;
  }
  
  public final int getPosition()
  {
    return this.plU;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(324801);
    s.u(paramg, "component");
    setPosition(this.plU);
    j(paramg).b((n)this);
    AppMethodBeat.o(324801);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(324802);
    s.u(paramg, "component");
    j(paramg).c((n)this);
    AppMethodBeat.o(324802);
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void kb(boolean paramBoolean)
  {
    AppMethodBeat.i(324796);
    ImageView localImageView = this.rIg;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(324796);
      return;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(324784);
    b.d.a.a(this.uBP, 3, new ArrayList());
    AppMethodBeat.o(324784);
  }
  
  public void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(324773);
    this.rIw = paramString;
    TextView localTextView = this.pJc;
    if (paramString == null) {}
    for (paramString = (CharSequence)"";; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(324773);
      return;
    }
  }
  
  public void setApplyWording(String paramString)
  {
    AppMethodBeat.i(324777);
    this.rgX = paramString;
    this.thc.setText((CharSequence)paramString);
    AppMethodBeat.o(324777);
  }
  
  public void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(324795);
    this.rIg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(324795);
  }
  
  public void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(324794);
    this.thg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(324794);
  }
  
  public void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(324791);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      this.thg.setText((CharSequence)"");
      this.thg.setVisibility(4);
      AppMethodBeat.o(324791);
      return;
    }
    this.thg.setText((CharSequence)paramString);
    this.thg.setVisibility(0);
    AppMethodBeat.o(324791);
  }
  
  public void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(324793);
    this.thg.setTextColor(paramInt);
    AppMethodBeat.o(324793);
  }
  
  public void setFunctionButtonVisibility(int paramInt)
  {
    AppMethodBeat.i(324792);
    this.thg.setVisibility(paramInt);
    AppMethodBeat.o(324792);
  }
  
  public void setIExternalToolsHelper(aj paramaj)
  {
    AppMethodBeat.i(324789);
    this.tgW.setIExternalToolsHelper(paramaj);
    AppMethodBeat.o(324789);
  }
  
  public void setIconUrl(String paramString)
  {
    AppMethodBeat.i(324778);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.rIe, this.iconUrl, as.cLN(), (b.h)com.tencent.mm.modelappbrand.a.g.org);
    AppMethodBeat.o(324778);
  }
  
  public void setItemCheckedListener(k.b paramb)
  {
    this.thf = paramb;
    this.the.thf = paramb;
  }
  
  public void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(324786);
    if (paramString != null) {
      this.rIt.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(324786);
  }
  
  public void setOnListItemLongClickListener(k.d paramd)
  {
    AppMethodBeat.i(324800);
    s.u(paramd, "listener");
    this.the.uCV = paramd;
    AppMethodBeat.o(324800);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(324797);
    this.plU = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(324797);
      return;
      this.plc.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_center_style_bg));
      AppMethodBeat.o(324797);
      return;
      this.plc.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_bg));
    }
  }
  
  public void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(324787);
    if (paramString != null) {
      this.rIs.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(324787);
  }
  
  public void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(324775);
    this.tgZ = paramString;
    this.thm.setText((CharSequence)paramString);
    AppMethodBeat.o(324775);
  }
  
  public void setScope(String paramString)
  {
    AppMethodBeat.i(324799);
    s.u(paramString, "scope");
    this.eYt = paramString;
    AppMethodBeat.o(324799);
  }
  
  public void setSelectListItem(List<k.a> paramList)
  {
    AppMethodBeat.i(324798);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(324798);
        return;
      }
      this.ell.clear();
      this.ell.addAll((Collection)paramList);
      this.the.bZE.notifyChanged();
      this.thd.setVisibility(0);
      this.njN.setVisibility(8);
    }
    AppMethodBeat.o(324798);
  }
  
  public void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(324776);
    this.thb = paramString;
    if (paramString != null)
    {
      this.tha.setVisibility(0);
      this.tha.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(324776);
  }
  
  public void setUserAgreementCheckBoxWording(String paramString)
  {
    AppMethodBeat.i(324788);
    s.u(paramString, "wording");
    this.tgW.setUserAgreementCheckBoxWording(paramString);
    AppMethodBeat.o(324788);
  }
  
  public void setUserAgreementCheckedAlertListener(u paramu)
  {
    AppMethodBeat.i(324790);
    this.tgW.setUserAgreementCheckedAlertListener(paramu);
    AppMethodBeat.o(324790);
  }
  
  public final void xt(int paramInt)
  {
    AppMethodBeat.i(324782);
    Object localObject = t.uFu;
    localObject = getContentView().getContext();
    s.s(localObject, "contentView.context");
    t.a((Context)localObject, getContentView(), this.uBO, paramInt, this.tGF, this.tgW.cPR());
    At(paramInt);
    AppMethodBeat.o(324782);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog$Listener;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
    extends b.d
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(double paramDouble, d paramd) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(324669);
      double d = this.uBR;
      int j = 0;
      int k = 0;
      if (d > 0.0D)
      {
        Object localObject = d.a(this.uBS).getLayoutManager();
        label42:
        int i;
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            break label122;
          }
          i = this.uBS.getContext().getResources().getDimensionPixelSize(a.b.authorize_dialog_select_list_item_height);
          label64:
          if (d < 1.0D) {
            break label131;
          }
        }
        for (;;)
        {
          d -= 1.0D;
          k += 1;
          j = i + j;
          break;
          localObject = ((RecyclerView.LayoutManager)localObject).getChildAt(k);
          if (localObject == null)
          {
            localObject = null;
            break label42;
          }
          localObject = Integer.valueOf(((View)localObject).getMeasuredHeight());
          break label42;
          label122:
          i = ((Integer)localObject).intValue();
          break label64;
          label131:
          i = (int)(i * d);
        }
      }
      d.a(this.uBS).setMaxHeight(j);
      d.a(this.uBS).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(324669);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog$getContentView$2", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends FrameLayout
  {
    d(d paramd, Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(324673);
      if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          d.a(this.uBS, MotionEvent.obtain(paramMotionEvent));
        }
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(324673);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.d
 * JD-Core Version:    0.7.0.1
 */