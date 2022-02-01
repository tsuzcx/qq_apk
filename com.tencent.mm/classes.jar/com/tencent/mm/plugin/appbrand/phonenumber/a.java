package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_position", "", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "showRightIcon", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public class a
  extends Dialog
  implements j
{
  public static final a.a qAS;
  private DialogInterface.OnDismissListener ft;
  private String iconUrl;
  View jkB;
  private TextView mMu;
  RecyclerView mRecyclerView;
  private View mrI;
  private int msq;
  private ImageView oFa;
  private View oFn;
  private Button oFo;
  private Button oFp;
  private com.tencent.mm.plugin.appbrand.widget.dialog.l oFq;
  private String oFs;
  private ImageView qAO;
  private DialogInterface.OnShowListener qAP;
  b qAQ;
  private Drawable qAR;
  private TextView qcf;
  private TextView qch;
  private TextView qcs;
  private LinearLayout qct;
  TextView qcu;
  
  static
  {
    AppMethodBeat.i(148016);
    qAS = new a.a((byte)0);
    AppMethodBeat.o(148016);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148015);
    paramContext = View.inflate(m.eA(paramContext), a.e.app_brand_request_dialog, null);
    p.j(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.mrI = paramContext;
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
    this.qct = ((LinearLayout)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_right_icon);
    p.j(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.qAO = ((ImageView)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_apply_wording);
    p.j(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.qch = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.request_recyclerview);
    p.j(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.mRecyclerView = ((RecyclerView)paramContext);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramContext = this.mrI.findViewById(a.d.request_loading);
    p.j(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.jkB = paramContext;
    paramContext = this.mrI.findViewById(a.d.button_group);
    p.j(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.oFn = paramContext;
    paramContext = this.mrI.findViewById(a.d.request_function);
    p.j(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.qcu = ((TextView)paramContext);
    this.oFo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148007);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.qAT.qAQ;
        if (paramAnonymousView != null) {
          paramAnonymousView.Cz(1);
        }
        paramAnonymousView = a.a(this.qAT);
        if (paramAnonymousView != null) {
          paramAnonymousView.b((j)this.qAT);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148007);
      }
    });
    this.oFp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148008);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.qAT.qAQ;
        if (paramAnonymousView != null) {
          paramAnonymousView.Cz(2);
        }
        paramAnonymousView = a.a(this.qAT);
        if (paramAnonymousView != null) {
          paramAnonymousView.b((j)this.qAT);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148008);
      }
    });
    this.mRecyclerView.setItemAnimator(null);
    this.msq = 2;
    AppMethodBeat.o(148015);
  }
  
  public final void E(Drawable paramDrawable)
  {
    AppMethodBeat.i(251967);
    this.qAR = paramDrawable;
    this.qAO.setVisibility(8);
    if (paramDrawable != null)
    {
      this.qAO.setImageDrawable(this.qAR);
      this.qAO.setVisibility(0);
    }
    AppMethodBeat.o(251967);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251969);
    this.qAO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(251969);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.l paraml)
  {
    AppMethodBeat.i(148009);
    Object localObject = this.qAP;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.oFq = paraml;
    localObject = getContext().getSystemService("window");
    paraml = (com.tencent.mm.plugin.appbrand.widget.dialog.l)localObject;
    if (!(localObject instanceof WindowManager)) {
      paraml = null;
    }
    paraml = (WindowManager)paraml;
    if (paraml != null)
    {
      localObject = m.ruC;
      localObject = this.mrI.getContext();
      p.j(localObject, "mRootView.context");
      View localView1 = this.mrI;
      View localView2 = this.oFn;
      paraml = paraml.getDefaultDisplay();
      p.j(paraml, "it.defaultDisplay");
      m.a((Context)localObject, localView1, localView2, paraml.getRotation(), false);
      AppMethodBeat.o(148009);
      return;
    }
    AppMethodBeat.o(148009);
  }
  
  public boolean bsB()
  {
    return false;
  }
  
  public final boolean bsC()
  {
    return false;
  }
  
  protected final View cgn()
  {
    return this.mrI;
  }
  
  protected final LinearLayout cgo()
  {
    return this.qct;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(148012);
    super.dismiss();
    onDismiss();
    AppMethodBeat.o(148012);
  }
  
  public final View getContentView()
  {
    return this.mrI;
  }
  
  public final int getPosition()
  {
    return this.msq;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void jp(boolean paramBoolean)
  {
    AppMethodBeat.i(148014);
    ImageView localImageView = this.qAO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(148014);
      return;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148013);
    b localb = this.qAQ;
    if (localb != null)
    {
      localb.Cz(3);
      AppMethodBeat.o(148013);
      return;
    }
    AppMethodBeat.o(148013);
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(148010);
    DialogInterface.OnDismissListener localOnDismissListener = this.ft;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(148010);
      return;
    }
    AppMethodBeat.o(148010);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(251970);
    this.oFs = paramString;
    TextView localTextView = this.mMu;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(251970);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(251966);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.oFa, this.iconUrl, a.c.miniprogram_default_avatar, (b.h)g.lzF);
    AppMethodBeat.o(251966);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(251983);
    this.msq = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251983);
      return;
      this.mrI.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_center_style_bg));
      AppMethodBeat.o(251983);
      return;
      this.mrI.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_bg));
    }
  }
  
  public final void xu(int paramInt)
  {
    AppMethodBeat.i(148011);
    Object localObject = m.ruC;
    localObject = this.mrI.getContext();
    p.j(localObject, "mRootView.context");
    m.a((Context)localObject, this.mrI, this.oFn, paramInt, false);
    AppMethodBeat.o(148011);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void Cz(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a
 * JD-Core Version:    0.7.0.1
 */