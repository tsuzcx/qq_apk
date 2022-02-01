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
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_position", "", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "showRightIcon", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public class a
  extends Dialog
  implements k
{
  public static final a.a miY;
  private DialogInterface.OnDismissListener XM;
  RecyclerView anl;
  View fTl;
  View iCR;
  int iDw;
  private String iconUrl;
  private ImageView kAX;
  private TextView kAY;
  private View kBl;
  private Button kBm;
  private Button kBn;
  private m kBo;
  private String kBq;
  private TextView lPI;
  private TextView lPK;
  private TextView lPU;
  LinearLayout lPV;
  TextView lPW;
  ImageView miU;
  private DialogInterface.OnShowListener miV;
  b miW;
  Drawable miX;
  
  static
  {
    AppMethodBeat.i(148016);
    miY = new a.a((byte)0);
    AppMethodBeat.o(148016);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148015);
    paramContext = View.inflate(n.bq(paramContext), 2131493051, null);
    p.g(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.iCR = paramContext;
    paramContext = this.iCR.findViewById(2131304100);
    p.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.kAX = ((ImageView)paramContext);
    paramContext = this.iCR.findViewById(2131304102);
    p.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.kAY = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131304096);
    p.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.kBn = ((Button)paramContext);
    paramContext = this.iCR.findViewById(2131304103);
    p.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.kBm = ((Button)paramContext);
    paramContext = this.iCR.findViewById(2131304098);
    p.g(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.lPU = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131304825);
    p.g(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.lPI = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131304097);
    p.g(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.lPV = ((LinearLayout)paramContext);
    paramContext = this.iCR.findViewById(2131304106);
    p.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.miU = ((ImageView)paramContext);
    paramContext = this.iCR.findViewById(2131304095);
    p.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.lPK = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131304104);
    p.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.anl = ((RecyclerView)paramContext);
    this.anl.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramContext = this.iCR.findViewById(2131304101);
    p.g(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.fTl = paramContext;
    paramContext = this.iCR.findViewById(2131297653);
    p.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.kBl = paramContext;
    paramContext = this.iCR.findViewById(2131304099);
    p.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.lPW = ((TextView)paramContext);
    this.kBm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148007);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.miZ.miW;
        if (paramAnonymousView != null) {
          paramAnonymousView.uX(1);
        }
        paramAnonymousView = a.a(this.miZ);
        if (paramAnonymousView != null) {
          paramAnonymousView.c((k)this.miZ);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148007);
      }
    });
    this.kBn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148008);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.miZ.miW;
        if (paramAnonymousView != null) {
          paramAnonymousView.uX(2);
        }
        paramAnonymousView = a.a(this.miZ);
        if (paramAnonymousView != null) {
          paramAnonymousView.c((k)this.miZ);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148008);
      }
    });
    this.anl.setItemAnimator(null);
    this.iDw = 2;
    AppMethodBeat.o(148015);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(192380);
    this.miU.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(192380);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(148009);
    Object localObject = this.miV;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.kBo = paramm;
    localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.swJ;
      localObject = this.iCR.getContext();
      p.g(localObject, "mRootView.context");
      View localView1 = this.iCR;
      View localView2 = this.kBl;
      paramm = paramm.getDefaultDisplay();
      p.g(paramm, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, paramm.getRotation(), false);
      AppMethodBeat.o(148009);
      return;
    }
    AppMethodBeat.o(148009);
  }
  
  public boolean aOv()
  {
    return false;
  }
  
  public final boolean aOw()
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
    return this.iCR;
  }
  
  public final int getPosition()
  {
    return this.iDw;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148013);
    b localb = this.miW;
    if (localb != null)
    {
      localb.uX(3);
      AppMethodBeat.o(148013);
      return;
    }
    AppMethodBeat.o(148013);
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(148010);
    DialogInterface.OnDismissListener localOnDismissListener = this.XM;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(148010);
      return;
    }
    AppMethodBeat.o(148010);
  }
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(148011);
    Object localObject = n.swJ;
    localObject = this.iCR.getContext();
    p.g(localObject, "mRootView.context");
    n.a((Context)localObject, this.iCR, this.kBl, paramInt, false);
    AppMethodBeat.o(148011);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(192381);
    this.kBq = paramString;
    TextView localTextView = this.kAY;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(192381);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(192379);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.aDV().a(this.kAX, this.iconUrl, 2131233241, (b.h)g.hLC);
    AppMethodBeat.o(192379);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(192382);
    this.iDw = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192382);
      return;
      this.iCR.setBackground(android.support.v4.content.b.l(getContext(), 2131231061));
      AppMethodBeat.o(192382);
      return;
      this.iCR.setBackground(android.support.v4.content.b.l(getContext(), 2131231060));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void uX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a
 * JD-Core Version:    0.7.0.1
 */