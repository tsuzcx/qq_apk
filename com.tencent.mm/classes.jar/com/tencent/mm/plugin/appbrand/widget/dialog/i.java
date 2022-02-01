package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.permission.a.b.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.c.a;
import com.tencent.mm.plugin.appbrand.permission.h.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "shouldInLargeScreenCompatMode", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;Z)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mRootWrapperFrameLayout", "Landroid/widget/FrameLayout;", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "changeListHeightByRotation", "", "rotation", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getContentView", "getDialogHeight", "getLastPointerDownTouchEvent", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public final class i
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.permission.a.b, k
{
  public static final i.a nhW;
  private DialogInterface.OnDismissListener XM;
  private final List<o.a> cjg;
  private View gZB;
  private final View iFK;
  private int iGp;
  private String iconUrl;
  private String kCE;
  private Button kEB;
  private Button kEC;
  private m kED;
  private String kEF;
  private ImageView kEm;
  private TextView kEn;
  private ImageView kEp;
  private MaxHeightRecyclerView lUe;
  private MotionEvent lUh;
  private String lUi;
  private TextView lUj;
  private String lUk;
  private TextView lUl;
  private String lUm;
  private LinearLayout lUn;
  private o lUo;
  private o.b lUp;
  private TextView lUq;
  private TextView lUv;
  private DialogInterface.OnShowListener mnS;
  private final boolean moB;
  private FrameLayout nhV;
  private View nhl;
  private b.c nhm;
  
  static
  {
    AppMethodBeat.i(148265);
    nhW = new i.a((byte)0);
    AppMethodBeat.o(148265);
  }
  
  public i(Context paramContext, b.c paramc, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(221066);
    this.moB = paramBoolean;
    paramContext = View.inflate(n.dv(paramContext), 2131493051, null);
    p.g(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.iFK = paramContext;
    this.nhm = paramc;
    this.kCE = "";
    this.cjg = ((List)new ArrayList());
    paramContext = this.iFK.findViewById(2131304100);
    p.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.kEm = ((ImageView)paramContext);
    paramContext = this.iFK.findViewById(2131304102);
    p.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.kEn = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131304096);
    p.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.kEC = ((Button)paramContext);
    paramContext = this.iFK.findViewById(2131304103);
    p.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.kEB = ((Button)paramContext);
    paramContext = this.iFK.findViewById(2131304098);
    p.g(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.lUv = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131304825);
    p.g(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.lUj = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131304097);
    p.g(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.lUn = ((LinearLayout)paramContext);
    paramContext = this.iFK.findViewById(2131304106);
    p.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.kEp = ((ImageView)paramContext);
    paramContext = this.iFK.findViewById(2131304095);
    p.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.lUl = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131304104);
    p.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.lUe = ((MaxHeightRecyclerView)paramContext);
    this.lUe.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.lUo = new o(this.cjg);
    this.lUo.lUp = this.lUp;
    this.lUe.setAdapter((RecyclerView.a)this.lUo);
    paramContext = this.iFK.findViewById(2131304101);
    p.g(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.gZB = paramContext;
    paramContext = this.iFK.findViewById(2131297653);
    p.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.nhl = paramContext;
    paramContext = this.iFK.findViewById(2131304099);
    p.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.lUq = ((TextView)paramContext);
    this.kEB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148227);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = i.a(this.nhh, true);
        localObject = i.b(this.nhh);
        o.a locala = i.c(this.nhh);
        if (locala != null) {}
        for (int i = locala.kCD;; i = 0)
        {
          ((b.c)localObject).a(1, paramAnonymousView, i);
          paramAnonymousView = i.d(this.nhh);
          if (paramAnonymousView != null) {
            paramAnonymousView.c((k)this.nhh);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148227);
          return;
        }
      }
    });
    this.kEC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148228);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = i.a(this.nhh, false);
        b.c.a.a(i.b(this.nhh), 2, paramAnonymousView);
        paramAnonymousView = i.d(this.nhh);
        if (paramAnonymousView != null) {
          paramAnonymousView.c((k)this.nhh);
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148228);
      }
    });
    this.lUe.setItemAnimator(null);
    this.iGp = 2;
    AppMethodBeat.o(221066);
  }
  
  private final void sR(int paramInt)
  {
    AppMethodBeat.i(148252);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (final double d = 1.5D;; d = 2.5D)
    {
      this.lUe.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c(this, d));
      this.lUe.invalidate();
      AppMethodBeat.o(148252);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(d paramd, String paramString, ac paramac)
  {
    AppMethodBeat.i(221065);
    p.h(paramd, "component");
    Context localContext = getContext();
    p.g(localContext, "this.context");
    paramString = new com.tencent.mm.plugin.appbrand.phonenumber.k(paramac, paramString, localContext, this.iFK.getMeasuredHeight(), paramd.getWindowAndroid().EX());
    paramd = paramd.getWindowAndroid();
    p.g(paramd, "component.windowAndroid");
    if (paramd.aXi()) {
      paramString.setPosition(1);
    }
    paramd = (com.tencent.mm.plugin.appbrand.permission.g)paramString;
    AppMethodBeat.o(221065);
    return paramd;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(148250);
    setPosition(this.iGp);
    Object localObject = this.mnS;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.kED = paramm;
    localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.nic;
      localObject = getContentView().getContext();
      p.g(localObject, "contentView.context");
      View localView1 = getContentView();
      View localView2 = this.nhl;
      Display localDisplay = paramm.getDefaultDisplay();
      p.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), this.moB);
      paramm = paramm.getDefaultDisplay();
      p.g(paramm, "it.defaultDisplay");
      sR(paramm.getRotation());
      AppMethodBeat.o(148250);
      return;
    }
    AppMethodBeat.o(148250);
  }
  
  public final boolean aOS()
  {
    return false;
  }
  
  public final boolean aOT()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(148253);
    super.dismiss();
    DialogInterface.OnDismissListener localOnDismissListener = this.XM;
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
    AppMethodBeat.i(221062);
    if (((i)this).nhV == null)
    {
      this.nhV = ((FrameLayout)new d(this, getContext()));
      localObject = this.nhV;
      if (localObject == null) {
        p.bdF("mRootWrapperFrameLayout");
      }
      ((FrameLayout)localObject).addView(this.iFK, new ViewGroup.LayoutParams(-1, -1));
    }
    Object localObject = this.nhV;
    if (localObject == null) {
      p.bdF("mRootWrapperFrameLayout");
    }
    localObject = (View)localObject;
    AppMethodBeat.o(221062);
    return localObject;
  }
  
  public final MotionEvent getLastPointerDownTouchEvent()
  {
    return this.lUh;
  }
  
  public final int getPosition()
  {
    return this.iGp;
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(221064);
    p.h(paramd, "component");
    setPosition(this.iGp);
    p.h(paramd, "$this$findPromptViewContainer");
    p.h(paramd, "$this$findPromptViewContainer");
    h.a.k(paramd).b((k)this);
    AppMethodBeat.o(221064);
  }
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(148261);
    ImageView localImageView = this.kEp;
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
    b.c.a.a(this.nhm, 3, new ArrayList());
    AppMethodBeat.o(148254);
  }
  
  public final void qB(int paramInt)
  {
    AppMethodBeat.i(148251);
    Object localObject = n.nic;
    localObject = getContentView().getContext();
    p.g(localObject, "contentView.context");
    n.a((Context)localObject, getContentView(), this.nhl, paramInt, this.moB);
    sR(paramInt);
    AppMethodBeat.o(148251);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(148245);
    this.kEF = paramString;
    TextView localTextView = this.kEn;
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
    this.lUm = paramString;
    this.lUl.setText((CharSequence)paramString);
    AppMethodBeat.o(148248);
  }
  
  public final void setExplainOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148260);
    this.kEp.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148260);
  }
  
  public final void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(148259);
    this.lUq.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(148259);
  }
  
  public final void setFunctionButtonText(String paramString)
  {
    AppMethodBeat.i(148257);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      this.lUq.setText((CharSequence)"");
      this.lUq.setVisibility(4);
      AppMethodBeat.o(148257);
      return;
    }
    this.lUq.setText((CharSequence)paramString);
    this.lUq.setVisibility(0);
    AppMethodBeat.o(148257);
  }
  
  public final void setFunctionButtonTextColor(int paramInt)
  {
    AppMethodBeat.i(148258);
    this.lUq.setTextColor(paramInt);
    AppMethodBeat.o(148258);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(148249);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.aEl().a(this.kEm, this.iconUrl, 2131233241, (b.h)com.tencent.mm.modelappbrand.a.g.hOv);
    AppMethodBeat.o(148249);
  }
  
  public final void setItemCheckedListener(o.b paramb)
  {
    this.lUp = paramb;
    this.lUo.lUp = paramb;
  }
  
  public final void setNegativeButtonText(String paramString)
  {
    AppMethodBeat.i(148255);
    if (paramString != null)
    {
      this.kEC.setText((CharSequence)paramString);
      AppMethodBeat.o(148255);
      return;
    }
    AppMethodBeat.o(148255);
  }
  
  public final void setOnListItemLongClickListener(o.c paramc)
  {
    AppMethodBeat.i(183077);
    p.h(paramc, "listener");
    this.lUo.nhp = paramc;
    AppMethodBeat.o(183077);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(221063);
    this.iGp = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(221063);
      return;
      this.iFK.setBackground(android.support.v4.content.b.l(getContext(), 2131231061));
      AppMethodBeat.o(221063);
      return;
      this.iFK.setBackground(android.support.v4.content.b.l(getContext(), 2131231060));
    }
  }
  
  public final void setPositiveButtonText(String paramString)
  {
    AppMethodBeat.i(148256);
    if (paramString != null)
    {
      this.kEB.setText((CharSequence)paramString);
      AppMethodBeat.o(148256);
      return;
    }
    AppMethodBeat.o(148256);
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(148246);
    this.lUi = paramString;
    this.lUv.setText((CharSequence)paramString);
    AppMethodBeat.o(148246);
  }
  
  public final void setScope(String paramString)
  {
    AppMethodBeat.i(148263);
    p.h(paramString, "scope");
    this.kCE = paramString;
    AppMethodBeat.o(148263);
  }
  
  public final void setSelectListItem(List<o.a> paramList)
  {
    AppMethodBeat.i(148262);
    if (paramList != null)
    {
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(148262);
        return;
      }
      this.cjg.clear();
      this.cjg.addAll((Collection)paramList);
      this.lUo.notifyDataSetChanged();
      this.lUn.setVisibility(0);
      this.lUj.setVisibility(8);
      this.gZB.setVisibility(8);
      AppMethodBeat.o(148262);
      return;
    }
    AppMethodBeat.o(148262);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(148247);
    this.lUk = paramString;
    if (paramString != null)
    {
      this.lUj.setVisibility(0);
      this.lUj.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(148247);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
    extends b.c
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$changeListHeightByRotation$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "luggage-wechat-full-sdk_release"})
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
        Object localObject = i.a(this.nhh).getLayoutManager();
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView.i)localObject).getChildAt(k);
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
          localObject = this.nhh.getContext();
          p.g(localObject, "context");
          i = ((Context)localObject).getResources().getDimensionPixelSize(2131165886);
          break label59;
          label114:
          i = (int)(i * d);
        }
      }
      i.a(this.nhh).setMaxHeight(j);
      i.a(this.nhh).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(169658);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$getContentView$2", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends FrameLayout
  {
    d(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(221061);
      if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
        i.a(this.nhh, MotionEvent.obtain(paramMotionEvent));
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(221061);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i
 * JD-Core Version:    0.7.0.1
 */