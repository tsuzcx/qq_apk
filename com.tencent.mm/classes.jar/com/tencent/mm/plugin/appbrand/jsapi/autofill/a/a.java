package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.q;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class a
  extends Dialog
  implements k
{
  public View iFK;
  public String iconUrl;
  private View kEA;
  public Button kEB;
  private Button kEC;
  private com.tencent.mm.plugin.appbrand.widget.dialog.m kED;
  private q kEE;
  public String kEF;
  public String kEG;
  public String kEH;
  public String kEI;
  public Boolean kEJ;
  public String kEK;
  public String kEL;
  public String kEM;
  public String kEN;
  public ArrayList<PhoneItem> kEO;
  public d.g.a.a<z> kEP;
  public d.g.a.a<z> kEQ;
  public d.g.a.a<z> kER;
  public d.g.a.a<z> kES;
  public d.g.a.a<z> kET;
  public d.g.a.a<z> kEU;
  public d.g.a.a<z> kEV;
  public ImageView kEm;
  public TextView kEn;
  public TextView kEo;
  private ImageView kEp;
  public ViewGroup kEq;
  public TextView kEr;
  public TextView kEs;
  private ViewGroup kEt;
  public TextView kEu;
  private MaxHeightRecyclerView kEv;
  private TextView kEw;
  public ViewGroup kEx;
  public CheckBox kEy;
  public TextView kEz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50477);
    paramContext = View.inflate(paramContext, 2131493034, null);
    p.g(paramContext, "View.inflate(context, R.…uth_request_dialog, null)");
    this.iFK = paramContext;
    this.kEO = new ArrayList();
    paramContext = this.iFK.findViewById(2131304100);
    p.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.kEm = ((ImageView)paramContext);
    paramContext = this.iFK.findViewById(2131304102);
    p.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.kEn = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131304095);
    p.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.kEo = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131304106);
    p.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.kEp = ((ImageView)paramContext);
    this.kEp.setOnClickListener((View.OnClickListener)new a.1(this));
    paramContext = this.iFK.findViewById(2131300904);
    p.g(paramContext, "mRootView.findViewById(R…d.id_card_info_container)");
    this.kEq = ((ViewGroup)paramContext);
    paramContext = this.iFK.findViewById(2131300906);
    p.g(paramContext, "mRootView.findViewById(R…d_card_info_request_desc)");
    this.kEr = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131300905);
    p.g(paramContext, "mRootView.findViewById(R…id_card_info_detail_desc)");
    this.kEs = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131303214);
    p.g(paramContext, "mRootView.findViewById(R…phone_num_info_container)");
    this.kEt = ((ViewGroup)paramContext);
    paramContext = this.iFK.findViewById(2131303215);
    p.g(paramContext, "mRootView.findViewById(R…ne_num_info_request_desc)");
    this.kEu = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131304104);
    p.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.kEv = ((MaxHeightRecyclerView)paramContext);
    this.kEv.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.kEv.setItemAnimator(null);
    paramContext = this.iFK.findViewById(2131304099);
    p.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.kEw = ((TextView)paramContext);
    this.kEw.setOnClickListener((View.OnClickListener)new a.2(this));
    paramContext = this.iFK.findViewById(2131303538);
    p.g(paramContext, "mRootView.findViewById(R.id.protocal_container)");
    this.kEx = ((ViewGroup)paramContext);
    paramContext = this.iFK.findViewById(2131300908);
    p.g(paramContext, "mRootView.findViewById(R.id.idcard_checkbox)");
    this.kEy = ((CheckBox)paramContext);
    paramContext = this.iFK.findViewById(2131304790);
    p.g(paramContext, "mRootView.findViewById(R.id.show_protocal)");
    this.kEz = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131297653);
    p.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.kEA = paramContext;
    paramContext = this.iFK.findViewById(2131304096);
    p.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.kEC = ((Button)paramContext);
    paramContext = this.iFK.findViewById(2131304103);
    p.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.kEB = ((Button)paramContext);
    this.kEB.setOnClickListener((View.OnClickListener)new a.3(this));
    this.kEy.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a.4(this));
    this.kEC.setOnClickListener((View.OnClickListener)new a.5(this));
    this.kEP = ((d.g.a.a)a.a.kEX);
    this.kEQ = ((d.g.a.a)a.g.kFd);
    this.kER = ((d.g.a.a)a.c.kEZ);
    this.kES = ((d.g.a.a)a.f.kFc);
    this.kET = ((d.g.a.a)a.d.kFa);
    this.kEU = ((d.g.a.a)a.b.kEY);
    this.kEV = ((d.g.a.a)a.e.kFb);
    AppMethodBeat.o(50477);
  }
  
  private final void sR(int paramInt)
  {
    AppMethodBeat.i(50476);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (double d = 1.5D;; d = 2.5D)
    {
      MaxHeightRecyclerView localMaxHeightRecyclerView = this.kEv;
      Context localContext = getContext();
      p.g(localContext, "context");
      localMaxHeightRecyclerView.setMaxHeight((int)(d * localContext.getResources().getDimensionPixelSize(2131165886)));
      AppMethodBeat.o(50476);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.m paramm)
  {
    AppMethodBeat.i(50475);
    this.kED = paramm;
    Object localObject = getContext().getSystemService("window");
    paramm = (com.tencent.mm.plugin.appbrand.widget.dialog.m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.nic;
      localObject = getContext();
      p.g(localObject, "context");
      View localView1 = this.iFK;
      View localView2 = this.kEA;
      Display localDisplay = paramm.getDefaultDisplay();
      p.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), false);
      paramm = paramm.getDefaultDisplay();
      p.g(paramm, "it.defaultDisplay");
      sR(paramm.getRotation());
      AppMethodBeat.o(50475);
      return;
    }
    AppMethodBeat.o(50475);
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
    AppMethodBeat.i(50472);
    super.dismiss();
    onCancel();
    AppMethodBeat.o(50472);
  }
  
  public final View getContentView()
  {
    return this.iFK;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(50473);
    this.kER.invoke();
    AppMethodBeat.o(50473);
  }
  
  public final void qB(int paramInt)
  {
    AppMethodBeat.i(50474);
    Object localObject = n.nic;
    localObject = getContext();
    p.g(localObject, "context");
    n.a((Context)localObject, this.iFK, this.kEA, paramInt, false);
    sR(paramInt);
    AppMethodBeat.o(50474);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(50471);
    p.h(paramArrayList, "value");
    this.kEO.clear();
    this.kEO.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.y.m.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(50471);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50469);
      Object localObject = this.kEW;
      Context localContext = this.kEW.getContext();
      p.g(localContext, "context");
      a.a((a)localObject, new q("", localContext, this.kEW.kEO));
      a.b(this.kEW).setAdapter((RecyclerView.a)a.a(this.kEW));
      if (this.kEW.kEO.size() == 0)
      {
        a.c(this.kEW).setVisibility(8);
        AppMethodBeat.o(50469);
        return;
      }
      if (this.kEW.kEO.size() == 1)
      {
        a.c(this.kEW).setVisibility(0);
        localObject = a.b(this.kEW).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        a.d(this.kEW).setText((CharSequence)this.kEW.getContext().getString(2131756029));
        AppMethodBeat.o(50469);
        return;
      }
      a.c(this.kEW).setVisibility(0);
      localObject = a.b(this.kEW).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      a.d(this.kEW).setText((CharSequence)this.kEW.getContext().getString(2131756027));
      AppMethodBeat.o(50469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */