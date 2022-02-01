package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
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
import com.tencent.luggage.l.a.b;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.a.b.a;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.permission.a.b.d.a;
import com.tencent.mm.plugin.appbrand.phonenumber.k;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.ui.ak;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "shouldInLargeScreenCompatMode", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;Z)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mRootWrapperFrameLayout", "Landroid/widget/FrameLayout;", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "changeListHeightByRotation", "", "rotation", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getContentView", "getDialogHeight", "getLastPointerDownTouchEvent", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public final class g
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.permission.a.b, j
{
  public static final g.a ruy;
  private final List<h.a> ctq;
  private DialogInterface.OnDismissListener ft;
  private String iconUrl;
  private View kGT;
  private TextView mMu;
  private final View mrI;
  private int msq;
  private String oCG;
  private ImageView oFa;
  private ImageView oFc;
  private Button oFo;
  private Button oFp;
  private l oFq;
  private String oFs;
  private DialogInterface.OnShowListener qAP;
  private final boolean qBy;
  private MaxHeightRecyclerView qca;
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
  private TextView qcs;
  private View ruu;
  private b.d ruv;
  private FrameLayout rux;
  
  static
  {
    AppMethodBeat.i(148265);
    ruy = new g.a((byte)0);
    AppMethodBeat.o(148265);
  }
  
  public g(Context paramContext, b.d paramd, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(248777);
    this.qBy = paramBoolean;
    paramContext = View.inflate(m.eA(paramContext), a.e.app_brand_request_dialog, null);
    p.j(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.mrI = paramContext;
    this.ruv = paramd;
    this.oCG = "";
    this.ctq = ((List)new ArrayList());
    paramContext = this.mrI.findViewById(a.d.request_icon);
    p.j(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.oFa = ((ImageView)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_name);
    p.j(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.mMu = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_cancel);
    p.j(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.oFp = ((Button)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_ok);
    p.j(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.oFo = ((Button)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_desc);
    p.j(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.qcs = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.simple_detail_desc);
    p.j(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.qcf = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_content);
    p.j(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.qcj = ((LinearLayout)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_right_icon);
    p.j(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.oFc = ((ImageView)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_apply_wording);
    p.j(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.qch = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_recyclerview);
    p.j(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.qca = ((MaxHeightRecyclerView)paramContext);
    this.qca.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.qck = new h(this.ctq);
    this.qck.qcl = this.qcl;
    this.qca.setAdapter((RecyclerView.a)this.qck);
    paramContext = this.mrI.findViewById(a.d.request_loading);
    p.j(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.kGT = paramContext;
    paramContext = this.mrI.findViewById(a.d.button_group);
    p.j(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.ruu = paramContext;
    paramContext = this.mrI.findViewById(a.d.request_function);
    p.j(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.qcm = ((TextView)paramContext);
    this.oFo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148227);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = g.a(this.rss, true);
        localObject = g.b(this.rss);
        h.a locala = g.c(this.rss);
        if (locala != null) {}
        for (int i = locala.oCE;; i = 0)
        {
          ((b.d)localObject).a(1, paramAnonymousView, i);
          paramAnonymousView = g.d(this.rss);
          if (paramAnonymousView != null) {
            paramAnonymousView.b((j)this.rss);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148227);
          return;
        }
      }
    });
    this.oFp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148228);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = g.a(this.rss, false);
        b.d.a.a(g.b(this.rss), 2, paramAnonymousView);
        paramAnonymousView = g.d(this.rss);
        if (paramAnonymousView != null) {
          paramAnonymousView.b((j)this.rss);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148228);
      }
    });
    this.qca.setItemAnimator(null);
    this.msq = 2;
    AppMethodBeat.o(248777);
  }
  
  private final void Ac(int paramInt)
  {
    AppMethodBeat.i(148252);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (final double d = 1.5D;; d = 2.5D)
    {
      this.qca.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, d));
      this.qca.invalidate();
      AppMethodBeat.o(148252);
      return;
    }
  }
  
  private l o(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(248781);
    p.k(paramg, "$this$findPromptViewContainer");
    paramg = b.a.n(paramg);
    AppMethodBeat.o(248781);
    return paramg;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, ag paramag)
  {
    AppMethodBeat.i(248776);
    p.k(paramg, "component");
    Context localContext = getContext();
    p.j(localContext, "this.context");
    paramString = new k(paramag, paramString, localContext, this.mrI.getMeasuredHeight(), paramg.getWindowAndroid().RZ());
    paramg = paramg.getWindowAndroid();
    p.j(paramg, "component.windowAndroid");
    if (paramg.Sd()) {
      paramString.setPosition(1);
    }
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramString;
    AppMethodBeat.o(248776);
    return paramg;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(148250);
    setPosition(this.msq);
    Object localObject = this.qAP;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.oFq = paraml;
    localObject = getContext().getSystemService("window");
    paraml = (l)localObject;
    if (!(localObject instanceof WindowManager)) {
      paraml = null;
    }
    paraml = (WindowManager)paraml;
    if (paraml != null)
    {
      localObject = m.ruC;
      localObject = getContentView().getContext();
      p.j(localObject, "contentView.context");
      View localView1 = getContentView();
      View localView2 = this.ruu;
      Display localDisplay = paraml.getDefaultDisplay();
      p.j(localDisplay, "it.defaultDisplay");
      m.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), this.qBy);
      paraml = paraml.getDefaultDisplay();
      p.j(paraml, "it.defaultDisplay");
      Ac(paraml.getRotation());
      AppMethodBeat.o(148250);
      return;
    }
    AppMethodBeat.o(148250);
  }
  
  public final boolean bsB()
  {
    return false;
  }
  
  public final boolean bsC()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(148253);
    super.dismiss();
    DialogInterface.OnDismissListener localOnDismissListener = this.ft;
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
    AppMethodBeat.i(248760);
    if (((g)this).rux == null)
    {
      this.rux = ((FrameLayout)new d(this, getContext()));
      localObject = this.rux;
      if (localObject == null) {
        p.bGy("mRootWrapperFrameLayout");
      }
      ((FrameLayout)localObject).addView(this.mrI, new ViewGroup.LayoutParams(-1, -1));
    }
    Object localObject = this.rux;
    if (localObject == null) {
      p.bGy("mRootWrapperFrameLayout");
    }
    localObject = (View)localObject;
    AppMethodBeat.o(248760);
    return localObject;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.qcd;
  }
  
  public final int getPosition()
  {
    return this.msq;
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(248774);
    p.k(paramg, "component");
    setPosition(this.msq);
    o(paramg).a((j)this);
    AppMethodBeat.o(248774);
  }
  
  public final void iU(boolean paramBoolean)
  {
    AppMethodBeat.i(148261);
    ImageView localImageView = this.oFc;
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
  
  public final void j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(248775);
    p.k(paramg, "component");
    o(paramg).b((j)this);
    AppMethodBeat.o(248775);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148254);
    b.d.a.a(this.ruv, 3, new ArrayList());
    AppMethodBeat.o(148254);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(148245);
    this.oFs = paramString;
    TextView localTextView = this.mMu;
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
    this.qci = paramString;
    this.qch.setText((CharSequence)paramString);
    AppMethodBeat.o(148248);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148260);
    this.oFc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148260);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148259);
    this.qcm.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148259);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(148257);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      this.qcm.setText((CharSequence)"");
      this.qcm.setVisibility(4);
      AppMethodBeat.o(148257);
      return;
    }
    this.qcm.setText((CharSequence)paramString);
    this.qcm.setVisibility(0);
    AppMethodBeat.o(148257);
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(148258);
    this.qcm.setTextColor(paramInt);
    AppMethodBeat.o(148258);
  }
  
  public final void setFunctionButtonVisibility(int paramInt)
  {
    AppMethodBeat.i(248767);
    this.qcm.setVisibility(paramInt);
    AppMethodBeat.o(248767);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(148249);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.oFa, this.iconUrl, ak.ckz(), (b.h)com.tencent.mm.modelappbrand.a.g.lzF);
    AppMethodBeat.o(148249);
  }
  
  public final void setItemCheckedListener(h.b paramb)
  {
    this.qcl = paramb;
    this.qck.qcl = paramb;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(148255);
    if (paramString != null)
    {
      this.oFp.setText((CharSequence)paramString);
      AppMethodBeat.o(148255);
      return;
    }
    AppMethodBeat.o(148255);
  }
  
  public final void setOnListItemLongClickListener(h.d paramd)
  {
    AppMethodBeat.i(248773);
    p.k(paramd, "listener");
    this.qck.rsu = paramd;
    AppMethodBeat.o(248773);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(248770);
    this.msq = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(248770);
      return;
      this.mrI.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_center_style_bg));
      AppMethodBeat.o(248770);
      return;
      this.mrI.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_bg));
    }
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(148256);
    if (paramString != null)
    {
      this.oFo.setText((CharSequence)paramString);
      AppMethodBeat.o(148256);
      return;
    }
    AppMethodBeat.o(148256);
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(148246);
    this.qce = paramString;
    this.qcs.setText((CharSequence)paramString);
    AppMethodBeat.o(148246);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(148263);
    p.k(paramString, "scope");
    this.oCG = paramString;
    AppMethodBeat.o(148263);
  }
  
  public final void setSelectListItem(List<h.a> paramList)
  {
    AppMethodBeat.i(148262);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(148262);
        return;
      }
      this.ctq.clear();
      this.ctq.addAll((Collection)paramList);
      this.qck.notifyDataSetChanged();
      this.qcj.setVisibility(0);
      this.qcf.setVisibility(8);
      this.kGT.setVisibility(8);
      AppMethodBeat.o(148262);
      return;
    }
    AppMethodBeat.o(148262);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(148247);
    this.qcg = paramString;
    if (paramString != null)
    {
      this.qcf.setVisibility(0);
      this.qcf.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(148247);
  }
  
  public final void xu(int paramInt)
  {
    AppMethodBeat.i(148251);
    Object localObject = m.ruC;
    localObject = getContentView().getContext();
    p.j(localObject, "contentView.context");
    m.a((Context)localObject, getContentView(), this.ruu, paramInt, this.qBy);
    Ac(paramInt);
    AppMethodBeat.o(148251);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
    extends b.d
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"})
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
        Object localObject = g.a(this.rss).getLayoutManager();
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView.LayoutManager)localObject).getChildAt(k);
          if (localObject != null)
          {
            i = ((View)localObject).getMeasuredHeight();
            label59:
            if (d < 1.0D) {
              break label115;
            }
          }
        }
        for (;;)
        {
          d -= 1.0D;
          k += 1;
          j = i + j;
          break;
          localObject = this.rss.getContext();
          p.j(localObject, "context");
          i = ((Context)localObject).getResources().getDimensionPixelSize(a.b.authorize_dialog_select_list_item_height);
          break label59;
          label115:
          i = (int)(i * d);
        }
      }
      g.a(this.rss).setMaxHeight(j);
      g.a(this.rss).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(169658);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$getContentView$2", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends FrameLayout
  {
    d(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(236189);
      if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
        g.a(this.rss, MotionEvent.obtain(paramMotionEvent));
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(236189);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.g
 * JD-Core Version:    0.7.0.1
 */