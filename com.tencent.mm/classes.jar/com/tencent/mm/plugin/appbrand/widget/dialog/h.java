package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.c.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.ui.ak;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "shouldInLargeScreenCompatMode", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;Z)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mRootWrapperFrameLayout", "Landroid/widget/FrameLayout;", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "changeListHeightByRotation", "", "rotation", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getContentView", "getDialogHeight", "getLastPointerDownTouchEvent", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public final class h
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.permission.a.b, k
{
  public static final a MxM;
  private View KvT;
  private b.c MxK;
  private FrameLayout MxL;
  private DialogInterface.OnDismissListener XZ;
  private final List<i.a> cvc;
  private View hSw;
  private String iconUrl;
  private final View jBN;
  private int jCs;
  private TextView jVh;
  private String lGX;
  private ImageView lIM;
  private ImageView lIO;
  private Button lJa;
  private Button lJb;
  private m lJc;
  private String lJe;
  private MaxHeightRecyclerView nbM;
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
  private TextView nce;
  private DialogInterface.OnShowListener nyE;
  private final boolean nzn;
  
  static
  {
    AppMethodBeat.i(148265);
    MxM = new a((byte)0);
    AppMethodBeat.o(148265);
  }
  
  public h(Context paramContext, b.c paramc, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(230241);
    this.nzn = paramBoolean;
    paramContext = View.inflate(n.eA(paramContext), 2131493090, null);
    p.g(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.jBN = paramContext;
    this.MxK = paramc;
    this.lGX = "";
    this.cvc = ((List)new ArrayList());
    paramContext = this.jBN.findViewById(2131306967);
    p.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.lIM = ((ImageView)paramContext);
    paramContext = this.jBN.findViewById(2131306969);
    p.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.jVh = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131306962);
    p.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.lJb = ((Button)paramContext);
    paramContext = this.jBN.findViewById(2131306970);
    p.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.lJa = ((Button)paramContext);
    paramContext = this.jBN.findViewById(2131306965);
    p.g(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.nce = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131307910);
    p.g(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.nbR = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131306964);
    p.g(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.nbV = ((LinearLayout)paramContext);
    paramContext = this.jBN.findViewById(2131306973);
    p.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.lIO = ((ImageView)paramContext);
    paramContext = this.jBN.findViewById(2131306961);
    p.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.nbT = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131306971);
    p.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.nbM = ((MaxHeightRecyclerView)paramContext);
    this.nbM.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.nbW = new i(this.cvc);
    this.nbW.nbX = this.nbX;
    this.nbM.setAdapter((RecyclerView.a)this.nbW);
    paramContext = this.jBN.findViewById(2131306968);
    p.g(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.hSw = paramContext;
    paramContext = this.jBN.findViewById(2131297917);
    p.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.KvT = paramContext;
    paramContext = this.jBN.findViewById(2131306966);
    p.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.nbY = ((TextView)paramContext);
    this.lJa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148227);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = h.a(this.oqV, true);
        localObject = h.b(this.oqV);
        i.a locala = h.c(this.oqV);
        if (locala != null) {}
        for (int i = locala.lGW;; i = 0)
        {
          ((b.c)localObject).a(1, paramAnonymousView, i);
          paramAnonymousView = h.d(this.oqV);
          if (paramAnonymousView != null) {
            paramAnonymousView.c((k)this.oqV);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148227);
          return;
        }
      }
    });
    this.lJb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148228);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = h.a(this.oqV, false);
        b.c.a.a(h.b(this.oqV), 2, paramAnonymousView);
        paramAnonymousView = h.d(this.oqV);
        if (paramAnonymousView != null) {
          paramAnonymousView.c((k)this.oqV);
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148228);
      }
    });
    this.nbM.setItemAnimator(null);
    this.jCs = 2;
    AppMethodBeat.o(230241);
  }
  
  private final void wN(int paramInt)
  {
    AppMethodBeat.i(148252);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (final double d = 1.5D;; d = 2.5D)
    {
      this.nbM.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, d));
      this.nbM.invalidate();
      AppMethodBeat.o(148252);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(d paramd, String paramString, ag paramag)
  {
    AppMethodBeat.i(230240);
    p.h(paramd, "component");
    Context localContext = getContext();
    p.g(localContext, "this.context");
    paramString = new com.tencent.mm.plugin.appbrand.phonenumber.k(paramag, paramString, localContext, this.jBN.getMeasuredHeight(), paramd.getWindowAndroid().OD());
    paramd = paramd.getWindowAndroid();
    p.g(paramd, "component.windowAndroid");
    if (paramd.bsj()) {
      paramString.setPosition(1);
    }
    paramd = (com.tencent.mm.plugin.appbrand.permission.g)paramString;
    AppMethodBeat.o(230240);
    return paramd;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(148250);
    setPosition(this.jCs);
    Object localObject = this.nyE;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.lJc = paramm;
    localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.OrG;
      localObject = getContentView().getContext();
      p.g(localObject, "contentView.context");
      View localView1 = getContentView();
      View localView2 = this.KvT;
      Display localDisplay = paramm.getDefaultDisplay();
      p.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), this.nzn);
      paramm = paramm.getDefaultDisplay();
      p.g(paramm, "it.defaultDisplay");
      wN(paramm.getRotation());
      AppMethodBeat.o(148250);
      return;
    }
    AppMethodBeat.o(148250);
  }
  
  public final boolean bjb()
  {
    return false;
  }
  
  public final boolean bjc()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(148253);
    super.dismiss();
    DialogInterface.OnDismissListener localOnDismissListener = this.XZ;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(148253);
      return;
    }
    AppMethodBeat.o(148253);
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(230235);
    if (((h)this).MxL == null)
    {
      this.MxL = ((FrameLayout)new d(this, getContext()));
      localObject = this.MxL;
      if (localObject == null) {
        p.btv("mRootWrapperFrameLayout");
      }
      ((FrameLayout)localObject).addView(this.jBN, new ViewGroup.LayoutParams(-1, -1));
    }
    Object localObject = this.MxL;
    if (localObject == null) {
      p.btv("mRootWrapperFrameLayout");
    }
    localObject = (View)localObject;
    AppMethodBeat.o(230235);
    return localObject;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.nbP;
  }
  
  public final int getPosition()
  {
    return this.jCs;
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(230239);
    p.h(paramd, "component");
    setPosition(this.jCs);
    p.h(paramd, "$this$findPromptViewContainer");
    p.h(paramd, "$this$findPromptViewContainer");
    com.tencent.mm.plugin.appbrand.permission.h.a.k(paramd).b((k)this);
    AppMethodBeat.o(230239);
  }
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(148261);
    ImageView localImageView = this.lIO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(148261);
      return;
    }
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148254);
    b.c.a.a(this.MxK, 3, new ArrayList());
    AppMethodBeat.o(148254);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(148245);
    this.lJe = paramString;
    TextView localTextView = this.jVh;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(148245);
      return;
    }
  }
  
  public final void setApplyWording(String paramString)
  {
    AppMethodBeat.i(148248);
    this.nbU = paramString;
    this.nbT.setText((CharSequence)paramString);
    AppMethodBeat.o(148248);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148260);
    this.lIO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148260);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148259);
    this.nbY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148259);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(148257);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      this.nbY.setText((CharSequence)"");
      this.nbY.setVisibility(4);
      AppMethodBeat.o(148257);
      return;
    }
    this.nbY.setText((CharSequence)paramString);
    this.nbY.setVisibility(0);
    AppMethodBeat.o(148257);
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(148258);
    this.nbY.setTextColor(paramInt);
    AppMethodBeat.o(148258);
  }
  
  public final void setFunctionButtonVisibility(int paramInt)
  {
    AppMethodBeat.i(230236);
    this.nbY.setVisibility(paramInt);
    AppMethodBeat.o(230236);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(148249);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.lIM, this.iconUrl, ak.bXP(), (b.h)com.tencent.mm.modelappbrand.a.g.iJB);
    AppMethodBeat.o(148249);
  }
  
  public final void setItemCheckedListener(i.b paramb)
  {
    this.nbX = paramb;
    this.nbW.nbX = paramb;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(148255);
    if (paramString != null)
    {
      this.lJb.setText((CharSequence)paramString);
      AppMethodBeat.o(148255);
      return;
    }
    AppMethodBeat.o(148255);
  }
  
  public final void setOnListItemLongClickListener(i.d paramd)
  {
    AppMethodBeat.i(230238);
    p.h(paramd, "listener");
    this.nbW.oqX = paramd;
    AppMethodBeat.o(230238);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(230237);
    this.jCs = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(230237);
      return;
      this.jBN.setBackground(android.support.v4.content.b.l(getContext(), 2131231096));
      AppMethodBeat.o(230237);
      return;
      this.jBN.setBackground(android.support.v4.content.b.l(getContext(), 2131231095));
    }
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(148256);
    if (paramString != null)
    {
      this.lJa.setText((CharSequence)paramString);
      AppMethodBeat.o(148256);
      return;
    }
    AppMethodBeat.o(148256);
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(148246);
    this.nbQ = paramString;
    this.nce.setText((CharSequence)paramString);
    AppMethodBeat.o(148246);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(148263);
    p.h(paramString, "scope");
    this.lGX = paramString;
    AppMethodBeat.o(148263);
  }
  
  public final void setSelectListItem(List<i.a> paramList)
  {
    AppMethodBeat.i(148262);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(148262);
        return;
      }
      this.cvc.clear();
      this.cvc.addAll((Collection)paramList);
      this.nbW.notifyDataSetChanged();
      this.nbV.setVisibility(0);
      this.nbR.setVisibility(8);
      this.hSw.setVisibility(8);
      AppMethodBeat.o(148262);
      return;
    }
    AppMethodBeat.o(148262);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(148247);
    this.nbS = paramString;
    if (paramString != null)
    {
      this.nbR.setVisibility(0);
      this.nbR.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(148247);
  }
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(148251);
    Object localObject = n.OrG;
    localObject = getContentView().getContext();
    p.g(localObject, "contentView.context");
    n.a((Context)localObject, getContentView(), this.KvT, paramInt, this.nzn);
    wN(paramInt);
    AppMethodBeat.o(148251);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(double paramDouble) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(169658);
      double d = d;
      int j = 0;
      int k = 0;
      if (d > 0.0D)
      {
        Object localObject = h.a(this.oqV).getLayoutManager();
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView.LayoutManager)localObject).getChildAt(k);
          if (localObject != null)
          {
            i = ((View)localObject).getMeasuredHeight();
            label59:
            if (d < 1.0D) {
              break label114;
            }
          }
        }
        for (;;)
        {
          d -= 1.0D;
          k += 1;
          j = i + j;
          break;
          localObject = this.oqV.getContext();
          p.g(localObject, "context");
          i = ((Context)localObject).getResources().getDimensionPixelSize(2131165912);
          break label59;
          label114:
          i = (int)(i * d);
        }
      }
      h.a(this.oqV).setMaxHeight(j);
      h.a(this.oqV).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(169658);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$getContentView$2", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends FrameLayout
  {
    d(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(230234);
      if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
        h.a(this.oqV, MotionEvent.obtain(paramMotionEvent));
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(230234);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h
 * JD-Core Version:    0.7.0.1
 */