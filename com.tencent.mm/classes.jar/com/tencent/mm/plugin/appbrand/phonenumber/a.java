package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.plugin.appbrand.widget.b.m;
import com.tencent.mm.plugin.appbrand.widget.b.m.a;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "rightIconUrl", "getRightIconUrl", "setRightIconUrl", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "", "isCancelable", "", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "Companion", "Listener", "plugin-appbrand-integration_release"})
public class a
  extends Dialog
  implements k
{
  public static final a iCB;
  private DialogInterface.OnDismissListener NX;
  RecyclerView adt;
  View ejC;
  public String iCA;
  public View iCk;
  public ImageView iCl;
  public TextView iCm;
  private Button iCn;
  private Button iCo;
  private TextView iCp;
  private TextView iCq;
  ImageView iCr;
  private TextView iCs;
  LinearLayout iCt;
  TextView iCu;
  private View iCv;
  private DialogInterface.OnShowListener iCw;
  private com.tencent.mm.plugin.appbrand.widget.b.l iCx;
  b iCy;
  Drawable iCz;
  public String iconUrl;
  
  static
  {
    AppMethodBeat.i(143914);
    iCB = new a((byte)0);
    AppMethodBeat.o(143914);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143913);
    paramContext = View.inflate(paramContext, 2130968732, null);
    j.p(paramContext, "View.inflate(context, R.…and_request_dialog, null)");
    this.iCk = paramContext;
    paramContext = this.iCk.findViewById(2131821387);
    j.p(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.iCl = ((ImageView)paramContext);
    paramContext = this.iCk.findViewById(2131821388);
    j.p(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.iCm = ((TextView)paramContext);
    paramContext = this.iCk.findViewById(2131821398);
    j.p(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.iCo = ((Button)paramContext);
    paramContext = this.iCk.findViewById(2131821399);
    j.p(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.iCn = ((Button)paramContext);
    paramContext = this.iCk.findViewById(2131821391);
    j.p(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.iCp = ((TextView)paramContext);
    paramContext = this.iCk.findViewById(2131821392);
    j.p(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.iCq = ((TextView)paramContext);
    paramContext = this.iCk.findViewById(2131821393);
    j.p(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.iCt = ((LinearLayout)paramContext);
    paramContext = this.iCk.findViewById(2131821390);
    j.p(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.iCr = ((ImageView)paramContext);
    paramContext = this.iCk.findViewById(2131821389);
    j.p(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.iCs = ((TextView)paramContext);
    paramContext = this.iCk.findViewById(2131821394);
    j.p(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.adt = ((RecyclerView)paramContext);
    this.adt.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramContext = this.iCk.findViewById(2131821395);
    j.p(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.ejC = paramContext;
    paramContext = this.iCk.findViewById(2131821397);
    j.p(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.iCv = paramContext;
    paramContext = this.iCk.findViewById(2131821396);
    j.p(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.iCu = ((TextView)paramContext);
    this.iCn.setOnClickListener((View.OnClickListener)new a.1(this));
    this.iCo.setOnClickListener((View.OnClickListener)new a.2(this));
    this.adt.setItemAnimator(null);
    AppMethodBeat.o(143913);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.b.l paraml)
  {
    AppMethodBeat.i(143908);
    Object localObject = this.iCw;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.iCx = paraml;
    localObject = getContext().getSystemService("window");
    paraml = (com.tencent.mm.plugin.appbrand.widget.b.l)localObject;
    if (!(localObject instanceof WindowManager)) {
      paraml = null;
    }
    paraml = (WindowManager)paraml;
    if (paraml != null)
    {
      localObject = m.jkc;
      localObject = getContext();
      j.p(localObject, "context");
      View localView1 = this.iCk;
      View localView2 = this.iCv;
      paraml = paraml.getDefaultDisplay();
      j.p(paraml, "it.defaultDisplay");
      m.a.a((Context)localObject, localView1, localView2, paraml.getRotation());
      AppMethodBeat.o(143908);
      return;
    }
    AppMethodBeat.o(143908);
  }
  
  public final boolean aKF()
  {
    return false;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143911);
    super.dismiss();
    onDismiss();
    AppMethodBeat.o(143911);
  }
  
  public final View getContentView()
  {
    return this.iCk;
  }
  
  public int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(143912);
    b localb = this.iCy;
    if (localb != null)
    {
      localb.pr(3);
      AppMethodBeat.o(143912);
      return;
    }
    AppMethodBeat.o(143912);
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(143909);
    DialogInterface.OnDismissListener localOnDismissListener = this.NX;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(143909);
      return;
    }
    AppMethodBeat.o(143909);
  }
  
  public final void pq(int paramInt)
  {
    AppMethodBeat.i(143910);
    Object localObject = m.jkc;
    localObject = getContext();
    j.p(localObject, "context");
    m.a.a((Context)localObject, this.iCk, this.iCv, paramInt);
    AppMethodBeat.o(143910);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void pr(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a
 * JD-Core Version:    0.7.0.1
 */