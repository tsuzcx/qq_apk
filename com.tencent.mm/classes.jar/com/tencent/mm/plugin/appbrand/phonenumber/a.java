package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_position", "", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "showRightIcon", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"})
public class a
  extends Dialog
  implements k
{
  public static final a nyH;
  private DialogInterface.OnDismissListener XZ;
  View gAy;
  private String iconUrl;
  View jBN;
  int jCs;
  private TextView jVh;
  private ImageView lIM;
  private View lIZ;
  private Button lJa;
  private Button lJb;
  private m lJc;
  private String lJe;
  RecyclerView mRecyclerView;
  private TextView nbR;
  private TextView nbT;
  private TextView nce;
  LinearLayout ncf;
  TextView ncg;
  ImageView nyD;
  private DialogInterface.OnShowListener nyE;
  b nyF;
  Drawable nyG;
  
  static
  {
    AppMethodBeat.i(148016);
    nyH = new a((byte)0);
    AppMethodBeat.o(148016);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(148015);
    paramContext = View.inflate(n.eA(paramContext), 2131493090, null);
    p.g(paramContext, "View.inflate(context.wra…and_request_dialog, null)");
    this.jBN = paramContext;
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
    this.ncf = ((LinearLayout)paramContext);
    paramContext = this.jBN.findViewById(2131306973);
    p.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.nyD = ((ImageView)paramContext);
    paramContext = this.jBN.findViewById(2131306961);
    p.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.nbT = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131306971);
    p.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.mRecyclerView = ((RecyclerView)paramContext);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramContext = this.jBN.findViewById(2131306968);
    p.g(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.gAy = paramContext;
    paramContext = this.jBN.findViewById(2131297917);
    p.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.lIZ = paramContext;
    paramContext = this.jBN.findViewById(2131306966);
    p.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.ncg = ((TextView)paramContext);
    this.lJa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148007);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.nyI.nyF;
        if (paramAnonymousView != null) {
          paramAnonymousView.yU(1);
        }
        paramAnonymousView = a.a(this.nyI);
        if (paramAnonymousView != null) {
          paramAnonymousView.c((k)this.nyI);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148007);
      }
    });
    this.lJb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148008);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.nyI.nyF;
        if (paramAnonymousView != null) {
          paramAnonymousView.yU(2);
        }
        paramAnonymousView = a.a(this.nyI);
        if (paramAnonymousView != null) {
          paramAnonymousView.c((k)this.nyI);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148008);
      }
    });
    this.mRecyclerView.setItemAnimator(null);
    this.jCs = 2;
    AppMethodBeat.o(148015);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(230133);
    this.nyD.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(230133);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(148009);
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
      localObject = this.jBN.getContext();
      p.g(localObject, "mRootView.context");
      View localView1 = this.jBN;
      View localView2 = this.lIZ;
      paramm = paramm.getDefaultDisplay();
      p.g(paramm, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, paramm.getRotation(), false);
      AppMethodBeat.o(148009);
      return;
    }
    AppMethodBeat.o(148009);
  }
  
  public boolean bjb()
  {
    return false;
  }
  
  public final boolean bjc()
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
    return this.jBN;
  }
  
  public final int getPosition()
  {
    return this.jCs;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(148013);
    b localb = this.nyF;
    if (localb != null)
    {
      localb.yU(3);
      AppMethodBeat.o(148013);
      return;
    }
    AppMethodBeat.o(148013);
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(148010);
    DialogInterface.OnDismissListener localOnDismissListener = this.XZ;
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
    AppMethodBeat.i(230134);
    this.lJe = paramString;
    TextView localTextView = this.jVh;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(230134);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(230132);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.lIM, this.iconUrl, 2131233911, (b.h)g.iJB);
    AppMethodBeat.o(230132);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(230135);
    this.jCs = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(230135);
      return;
      this.jBN.setBackground(android.support.v4.content.b.l(getContext(), 2131231096));
      AppMethodBeat.o(230135);
      return;
      this.jBN.setBackground(android.support.v4.content.b.l(getContext(), 2131231095));
    }
  }
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(148011);
    Object localObject = n.OrG;
    localObject = this.jBN.getContext();
    p.g(localObject, "mRootView.context");
    n.a((Context)localObject, this.jBN, this.lIZ, paramInt, false);
    AppMethodBeat.o(148011);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
  {
    public abstract void yU(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a
 * JD-Core Version:    0.7.0.1
 */