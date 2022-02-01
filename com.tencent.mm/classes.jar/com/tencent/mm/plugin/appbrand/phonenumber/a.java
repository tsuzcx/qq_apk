package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.drawable.Drawable;
import android.os.Looper;
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
import com.tencent.luggage.m.a.c;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.widget.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.t;
import com.tencent.mm.plugin.appbrand.widget.dialog.u;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAuthorizeUserAgreementComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_position", "", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "rightIconContentDesc", "getRightIconContentDesc", "setRightIconContentDesc", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "userAgreementComponent", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeUserAgreementComponent;", "dismiss", "", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "isUserUserAgreementChecked", "onBackPressedEvent", "onCancel", "onCheckAcceptAllow", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "onShown", "setIExternalToolsHelper", "externalToolsHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "setPosition", "position", "setUserAgreementCheckBoxWording", "wording", "setUserAgreementCheckedAlertListener", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/UserAgreementCheckedAlertListener;", "showRightIcon", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.widget.dialog.n, q
{
  public static final a.a tFX;
  private String iconUrl;
  private View lNf;
  private DialogInterface.OnDismissListener mOnDismissListener;
  private RecyclerView mRecyclerView;
  private TextView pJc;
  private int plU;
  private View plc;
  private ImageView rIe;
  private View rIr;
  private Button rIs;
  private Button rIt;
  private r rIu;
  private String rIw;
  private String rgX;
  private ImageView tFY;
  private DialogInterface.OnShowListener tFZ;
  private b tGa;
  private Drawable tGb;
  private String tGc;
  e tgW;
  private String tgZ;
  private TextView tha;
  private String thb;
  private TextView thc;
  private TextView thm;
  private LinearLayout thn;
  private TextView tho;
  
  static
  {
    AppMethodBeat.i(319049);
    tFX = new a.a((byte)0);
    AppMethodBeat.o(319049);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(319013);
    View localView = View.inflate(t.fw(paramContext), a.e.app_brand_request_dialog, null);
    s.s(localView, "inflate(context.wrapScre…and_request_dialog, null)");
    this.plc = localView;
    localView = this.plc.findViewById(a.d.user_agreement_layout);
    s.s(localView, "mRootView.findViewById(R.id.user_agreement_layout)");
    this.tgW = new e(paramContext, localView);
    paramContext = this.plc.findViewById(a.d.request_icon);
    s.s(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.rIe = ((ImageView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_name);
    s.s(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.pJc = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_cancel);
    s.s(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.rIt = ((Button)paramContext);
    this.rIt.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    paramContext = this.plc.findViewById(a.d.request_ok);
    s.s(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.rIs = ((Button)paramContext);
    this.rIs.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    paramContext = this.plc.findViewById(a.d.request_desc);
    s.s(paramContext, "mRootView.findViewById(R.id.request_desc)");
    this.thm = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.simple_detail_desc);
    s.s(paramContext, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.tha = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_content);
    s.s(paramContext, "mRootView.findViewById(R.id.request_content)");
    this.thn = ((LinearLayout)paramContext);
    paramContext = this.plc.findViewById(a.d.request_right_icon);
    s.s(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.tFY = ((ImageView)paramContext);
    paramContext = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)this.tFY, null, null, false, null, null, Integer.valueOf(com.tencent.luggage.m.a.b.Edge_1_5_A), 4094);
    paramContext = this.plc.findViewById(a.d.request_apply_wording);
    s.s(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.thc = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.request_recyclerview);
    s.s(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.mRecyclerView = ((RecyclerView)paramContext);
    paramContext = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)this.mRecyclerView, null, null, true, null, null, null, 8182);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.mRecyclerView.setItemAnimator(null);
    paramContext = this.plc.findViewById(a.d.request_loading);
    s.s(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.lNf = paramContext;
    paramContext = this.plc.findViewById(a.d.button_group);
    s.s(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.rIr = paramContext;
    paramContext = this.plc.findViewById(a.d.request_function);
    s.s(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.tho = ((TextView)paramContext);
    paramContext = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)this.tho, Button.class, null, false, null, null, Integer.valueOf(com.tencent.luggage.m.a.b.Edge_1_5_A), 4092);
    this.plU = 2;
    AppMethodBeat.o(319013);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(319033);
    s.u(parama, "this$0");
    parama.dismiss();
    AppMethodBeat.o(319033);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(319022);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    paramView = parama.tGa;
    if (paramView != null) {
      paramView.CQ(2);
    }
    paramView = parama.rIu;
    if (paramView != null) {
      paramView.c((com.tencent.mm.plugin.appbrand.widget.dialog.n)parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(319022);
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(319042);
    s.u(parama, "this$0");
    com.tencent.mm.ui.widget.a.c.f((Dialog)parama);
    AppMethodBeat.o(319042);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(319028);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    if (!parama.tgW.cBy())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(319028);
      return;
    }
    paramView = parama.tGa;
    if (paramView != null)
    {
      parama.tgW.cBy();
      paramView.CQ(1);
    }
    paramView = parama.rIu;
    if (paramView != null) {
      paramView.c((com.tencent.mm.plugin.appbrand.widget.dialog.n)parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(319028);
  }
  
  public final void N(Drawable paramDrawable)
  {
    AppMethodBeat.i(319093);
    this.tGb = paramDrawable;
    this.tFY.setVisibility(8);
    if (paramDrawable != null)
    {
      this.tFY.setImageDrawable(this.tGb);
      this.tFY.setVisibility(0);
    }
    AppMethodBeat.o(319093);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(319095);
    this.tFY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(319095);
  }
  
  protected final void a(b paramb)
  {
    this.tGa = paramb;
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(319140);
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
        localObject = this.plc.getContext();
        s.s(localObject, "mRootView.context");
        t.a((Context)localObject, this.plc, this.rIr, paramr.getDefaultDisplay().getRotation(), false, this.tgW.cPR());
      }
      AppMethodBeat.o(319140);
      return;
    }
  }
  
  public final void afu(String paramString)
  {
    AppMethodBeat.i(319099);
    this.tGc = paramString;
    this.tFY.setContentDescription((CharSequence)paramString);
    AppMethodBeat.o(319099);
  }
  
  public boolean bQg()
  {
    return false;
  }
  
  public final void bQh()
  {
    AppMethodBeat.i(319144);
    com.tencent.mm.plugin.appbrand.widget.a.a.dQ(this.plc);
    AppMethodBeat.o(319144);
  }
  
  public final boolean bQi()
  {
    return false;
  }
  
  protected final View cHe()
  {
    return this.plc;
  }
  
  protected final LinearLayout cHf()
  {
    return this.thn;
  }
  
  protected final RecyclerView cHg()
  {
    return this.mRecyclerView;
  }
  
  protected final TextView cHh()
  {
    return this.tho;
  }
  
  protected final View cHi()
  {
    return this.lNf;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(319157);
    if (!s.p(Looper.getMainLooper(), Looper.myLooper()))
    {
      new MMHandler(Looper.getMainLooper()).post(new a..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(319157);
      return;
    }
    try
    {
      super.dismiss();
      return;
    }
    finally
    {
      onDismiss();
      new MMHandler(Looper.getMainLooper()).post(new a..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(319157);
    }
  }
  
  public final View getContentView()
  {
    return this.plc;
  }
  
  public final int getPosition()
  {
    return this.plU;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void kC(boolean paramBoolean)
  {
    AppMethodBeat.i(319193);
    ImageView localImageView = this.tFY;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(319193);
      return;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(319161);
    b localb = this.tGa;
    if (localb != null) {
      localb.CQ(3);
    }
    AppMethodBeat.o(319161);
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(319149);
    DialogInterface.OnDismissListener localOnDismissListener = this.mOnDismissListener;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss((DialogInterface)this);
    }
    AppMethodBeat.o(319149);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(319102);
    this.rIw = paramString;
    TextView localTextView = this.pJc;
    if (paramString == null) {}
    for (paramString = (CharSequence)"";; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(319102);
      return;
    }
  }
  
  public final void setApplyWording(String paramString)
  {
    AppMethodBeat.i(319124);
    this.rgX = paramString;
    this.thc.setText((CharSequence)paramString);
    TextView localTextView = this.thc;
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (kotlin.n.n.bp(paramString)))
    {
      i = 1;
      if (i != 0) {
        break label68;
      }
    }
    label68:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(319124);
      return;
      i = 0;
      break;
    }
  }
  
  public void setIExternalToolsHelper(aj paramaj)
  {
    AppMethodBeat.i(319177);
    this.tgW.setIExternalToolsHelper(paramaj);
    AppMethodBeat.o(319177);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(319090);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.rIe, this.iconUrl, a.c.miniprogram_default_avatar, (b.h)g.org);
    AppMethodBeat.o(319090);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(319183);
    this.plU = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(319183);
      return;
      this.plc.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_center_style_bg));
      AppMethodBeat.o(319183);
      return;
      this.plc.setBackground(androidx.core.content.a.m(getContext(), a.c.appbrand_user_auth_request_dialog_bg));
    }
  }
  
  public final void setRequestDesc(String paramString)
  {
    AppMethodBeat.i(319108);
    this.tgZ = paramString;
    this.thm.setText((CharSequence)paramString);
    AppMethodBeat.o(319108);
  }
  
  public final void setSimpleDetailDesc(String paramString)
  {
    AppMethodBeat.i(319117);
    this.thb = paramString;
    if (paramString != null)
    {
      this.tha.setVisibility(0);
      this.tha.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(319117);
  }
  
  public void setUserAgreementCheckBoxWording(String paramString)
  {
    AppMethodBeat.i(319173);
    s.u(paramString, "wording");
    this.tgW.setUserAgreementCheckBoxWording(paramString);
    AppMethodBeat.o(319173);
  }
  
  public void setUserAgreementCheckedAlertListener(u paramu)
  {
    AppMethodBeat.i(319182);
    this.tgW.setUserAgreementCheckedAlertListener(paramu);
    AppMethodBeat.o(319182);
  }
  
  public final void xt(int paramInt)
  {
    AppMethodBeat.i(319153);
    Object localObject = t.uFu;
    localObject = this.plc.getContext();
    s.s(localObject, "mRootView.context");
    t.a((Context)localObject, this.plc, this.rIr, paramInt, false, this.tgW.cPR());
    AppMethodBeat.o(319153);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog$Listener;", "", "onMsg", "", "resultCode", "", "userAgreementChecked", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void CQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a
 * JD-Core Version:    0.7.0.1
 */