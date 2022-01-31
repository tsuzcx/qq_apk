package com.tencent.mm.plugin.appbrand.widget.b;

import a.f.b.j;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
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
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.a.f;
import java.util.ArrayList;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;)V", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "", "isCancelable", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setNegativeButtonText", "cancelWording", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "Companion", "Item", "ItemAdapter", "Listener", "luggage-wechat-full-sdk_release"})
public final class i
  extends Dialog
  implements k
{
  public static final i.a jjN;
  private DialogInterface.OnDismissListener NX;
  private String hDW;
  private String iCA;
  private View iCk;
  private ImageView iCl;
  private TextView iCm;
  private Button iCn;
  private Button iCo;
  private TextView iCp;
  public TextView iCq;
  private TextView iCs;
  private DialogInterface.OnShowListener iCw;
  private l iCx;
  public RecyclerView iQe;
  private String iconUrl;
  private ImageView jjD;
  public LinearLayout jjE;
  public TextView jjF;
  private View jjG;
  public View jjH;
  private i.d jjI;
  public i.c jjJ;
  private String jjK;
  private String jjL;
  private String jjM;
  
  static
  {
    AppMethodBeat.i(102505);
    jjN = new i.a((byte)0);
    AppMethodBeat.o(102505);
  }
  
  public i(Context paramContext, i.d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(102504);
    paramContext = View.inflate(paramContext, 2130968732, null);
    j.p(paramContext, "View.inflate(context, R.…and_request_dialog, null)");
    this.iCk = paramContext;
    this.jjI = paramd;
    this.hDW = "";
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
    this.jjE = ((LinearLayout)paramContext);
    paramContext = this.iCk.findViewById(2131821390);
    j.p(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.jjD = ((ImageView)paramContext);
    paramContext = this.iCk.findViewById(2131821389);
    j.p(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.iCs = ((TextView)paramContext);
    paramContext = this.iCk.findViewById(2131821394);
    j.p(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.iQe = ((RecyclerView)paramContext);
    this.iQe.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramContext = this.iCk.findViewById(2131821395);
    j.p(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.jjH = paramContext;
    paramContext = this.iCk.findViewById(2131821397);
    j.p(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.jjG = paramContext;
    paramContext = this.iCk.findViewById(2131821396);
    j.p(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.jjF = ((TextView)paramContext);
    this.iCn.setOnClickListener((View.OnClickListener)new i.1(this));
    this.iCo.setOnClickListener((View.OnClickListener)new i.2(this));
    this.iQe.setItemAnimator(null);
    AppMethodBeat.o(102504);
  }
  
  public final void FG(String paramString)
  {
    AppMethodBeat.i(102492);
    this.iCA = paramString;
    TextView localTextView = this.iCm;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(102492);
      return;
    }
  }
  
  public final void FH(String paramString)
  {
    AppMethodBeat.i(102493);
    this.jjK = paramString;
    this.iCp.setText((CharSequence)paramString);
    AppMethodBeat.o(102493);
  }
  
  public final void FI(String paramString)
  {
    AppMethodBeat.i(102494);
    this.jjL = paramString;
    if (paramString != null)
    {
      this.iCq.setVisibility(0);
      this.iCq.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(102494);
  }
  
  public final void FJ(String paramString)
  {
    AppMethodBeat.i(102495);
    this.jjM = paramString;
    this.iCs.setText((CharSequence)paramString);
    AppMethodBeat.o(102495);
  }
  
  public final void FK(String paramString)
  {
    AppMethodBeat.i(102501);
    if (paramString != null)
    {
      this.iCo.setText((CharSequence)paramString);
      AppMethodBeat.o(102501);
      return;
    }
    AppMethodBeat.o(102501);
  }
  
  public final void FL(String paramString)
  {
    AppMethodBeat.i(102502);
    if (paramString != null)
    {
      this.iCn.setText((CharSequence)paramString);
      AppMethodBeat.o(102502);
      return;
    }
    AppMethodBeat.o(102502);
  }
  
  public final void FM(String paramString)
  {
    AppMethodBeat.i(102503);
    j.q(paramString, "scope");
    this.hDW = paramString;
    AppMethodBeat.o(102503);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(102497);
    Object localObject = this.iCw;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.iCx = paraml;
    localObject = getContext().getSystemService("window");
    paraml = (l)localObject;
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
      View localView2 = this.jjG;
      paraml = paraml.getDefaultDisplay();
      j.p(paraml, "it.defaultDisplay");
      m.a.a((Context)localObject, localView1, localView2, paraml.getRotation());
      AppMethodBeat.o(102497);
      return;
    }
    AppMethodBeat.o(102497);
  }
  
  public final boolean aKF()
  {
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(102499);
    super.dismiss();
    DialogInterface.OnDismissListener localOnDismissListener = this.NX;
    if (localOnDismissListener != null)
    {
      localOnDismissListener.onDismiss((DialogInterface)this);
      AppMethodBeat.o(102499);
      return;
    }
    AppMethodBeat.o(102499);
  }
  
  public final View getContentView()
  {
    return this.iCk;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void ka(String paramString)
  {
    AppMethodBeat.i(102496);
    this.iconUrl = paramString;
    b.acD().a(this.iCl, this.iconUrl, 2130839617, (b.f)f.fqU);
    AppMethodBeat.o(102496);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(102500);
    this.jjI.a(3, new ArrayList());
    AppMethodBeat.o(102500);
  }
  
  public final void pq(int paramInt)
  {
    AppMethodBeat.i(102498);
    Object localObject = m.jkc;
    localObject = getContext();
    j.p(localObject, "context");
    m.a.a((Context)localObject, this.iCk, this.jjG, paramInt);
    AppMethodBeat.o(102498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.i
 * JD-Core Version:    0.7.0.1
 */