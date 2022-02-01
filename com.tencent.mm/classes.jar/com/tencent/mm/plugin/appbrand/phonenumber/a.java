package com.tencent.mm.plugin.appbrand.phonenumber;

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
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_position", "", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "rightIconUrl", "getRightIconUrl", "setRightIconUrl", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "showRightIcon", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public class a
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  public static final a lJk;
  private DialogInterface.OnDismissListener VX;
  RecyclerView alu;
  View fzV;
  public String iconUrl;
  public View ijA;
  public int ikf;
  private m kgA;
  public String kgC;
  public ImageView kgj;
  public TextView kgk;
  private View kgx;
  private Button kgy;
  private Button kgz;
  private TextView lJb;
  private TextView lJc;
  ImageView lJd;
  private TextView lJe;
  LinearLayout lJf;
  TextView lJg;
  private DialogInterface.OnShowListener lJh;
  b lJi;
  Drawable lJj;
  
  static
  {
    AppMethodBeat.i(148016);
    lJk = new a((byte)0);
    AppMethodBeat.o(148016);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148015);
    paramContext = View.inflate(n.ed(paramContext), 2131493051, null);
    d.g.b.k.g(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.ijA = paramContext;
    paramContext = this.ijA.findViewById(2131304100);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.kgj = ((ImageView)paramContext);
    paramContext = this.ijA.findViewById(2131304102);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.kgk = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304096);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.kgz = ((Button)paramContext);
    paramContext = this.ijA.findViewById(2131304103);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.kgy = ((Button)paramContext);
    paramContext = this.ijA.findViewById(2131304098);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.lJb = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304825);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.lJc = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304097);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.lJf = ((LinearLayout)paramContext);
    paramContext = this.ijA.findViewById(2131304106);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.lJd = ((ImageView)paramContext);
    paramContext = this.ijA.findViewById(2131304095);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.lJe = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304104);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.alu = ((RecyclerView)paramContext);
    this.alu.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramContext = this.ijA.findViewById(2131304101);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.fzV = paramContext;
    paramContext = this.ijA.findViewById(2131297653);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.kgx = paramContext;
    paramContext = this.ijA.findViewById(2131304099);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.lJg = ((TextView)paramContext);
    this.kgy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148007);
        paramAnonymousView = this.lJl.lJi;
        if (paramAnonymousView != null) {
          paramAnonymousView.ut(1);
        }
        paramAnonymousView = a.a(this.lJl);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.lJl);
          AppMethodBeat.o(148007);
          return;
        }
        AppMethodBeat.o(148007);
      }
    });
    this.kgz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148008);
        paramAnonymousView = this.lJl.lJi;
        if (paramAnonymousView != null) {
          paramAnonymousView.ut(2);
        }
        paramAnonymousView = a.a(this.lJl);
        if (paramAnonymousView != null)
        {
          paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.lJl);
          AppMethodBeat.o(148008);
          return;
        }
        AppMethodBeat.o(148008);
      }
    });
    this.alu.setItemAnimator(null);
    this.ikf = 2;
    AppMethodBeat.o(148015);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(148009);
    Object localObject = this.lJh;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.kgA = paramm;
    localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.mCn;
      localObject = this.ijA.getContext();
      d.g.b.k.g(localObject, "mRootView.context");
      View localView1 = this.ijA;
      View localView2 = this.kgx;
      paramm = paramm.getDefaultDisplay();
      d.g.b.k.g(paramm, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, paramm.getRotation(), false);
      AppMethodBeat.o(148009);
      return;
    }
    AppMethodBeat.o(148009);
  }
  
  public boolean aLl()
  {
    return false;
  }
  
  public final boolean aLm()
  {
    return false;
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
    return this.ijA;
  }
  
  public final int getPosition()
  {
    return this.ikf;
  }
  
  public final void hi(boolean paramBoolean)
  {
    AppMethodBeat.i(148014);
    ImageView localImageView = this.lJd;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(148014);
      return;
    }
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148013);
    b localb = this.lJi;
    if (localb != null)
    {
      localb.ut(3);
      AppMethodBeat.o(148013);
      return;
    }
    AppMethodBeat.o(148013);
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(148010);
    DialogInterface.OnDismissListener localOnDismissListener = this.VX;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(148010);
      return;
    }
    AppMethodBeat.o(148010);
  }
  
  public final void pW(int paramInt)
  {
    AppMethodBeat.i(148011);
    Object localObject = n.mCn;
    localObject = this.ijA.getContext();
    d.g.b.k.g(localObject, "mRootView.context");
    n.a((Context)localObject, this.ijA, this.kgx, paramInt, false);
    AppMethodBeat.o(148011);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void ut(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a
 * JD-Core Version:    0.7.0.1
 */