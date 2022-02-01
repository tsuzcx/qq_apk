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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class a
  extends Dialog
  implements k
{
  public View iCR;
  public String iconUrl;
  public ImageView kAX;
  public TextView kAY;
  public TextView kAZ;
  public d.g.a.a<z> kBA;
  public d.g.a.a<z> kBB;
  public d.g.a.a<z> kBC;
  public d.g.a.a<z> kBD;
  public d.g.a.a<z> kBE;
  public d.g.a.a<z> kBF;
  public d.g.a.a<z> kBG;
  private ImageView kBa;
  public ViewGroup kBb;
  public TextView kBc;
  public TextView kBd;
  private ViewGroup kBe;
  public TextView kBf;
  private MaxHeightRecyclerView kBg;
  private TextView kBh;
  public ViewGroup kBi;
  public CheckBox kBj;
  public TextView kBk;
  private View kBl;
  public Button kBm;
  private Button kBn;
  private com.tencent.mm.plugin.appbrand.widget.dialog.m kBo;
  private q kBp;
  public String kBq;
  public String kBr;
  public String kBs;
  public String kBt;
  public Boolean kBu;
  public String kBv;
  public String kBw;
  public String kBx;
  public String kBy;
  public ArrayList<PhoneItem> kBz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50477);
    paramContext = View.inflate(paramContext, 2131493034, null);
    p.g(paramContext, "View.inflate(context, R.…uth_request_dialog, null)");
    this.iCR = paramContext;
    this.kBz = new ArrayList();
    paramContext = this.iCR.findViewById(2131304100);
    p.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.kAX = ((ImageView)paramContext);
    paramContext = this.iCR.findViewById(2131304102);
    p.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.kAY = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131304095);
    p.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.kAZ = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131304106);
    p.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.kBa = ((ImageView)paramContext);
    this.kBa.setOnClickListener((View.OnClickListener)new a.1(this));
    paramContext = this.iCR.findViewById(2131300904);
    p.g(paramContext, "mRootView.findViewById(R…d.id_card_info_container)");
    this.kBb = ((ViewGroup)paramContext);
    paramContext = this.iCR.findViewById(2131300906);
    p.g(paramContext, "mRootView.findViewById(R…d_card_info_request_desc)");
    this.kBc = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131300905);
    p.g(paramContext, "mRootView.findViewById(R…id_card_info_detail_desc)");
    this.kBd = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131303214);
    p.g(paramContext, "mRootView.findViewById(R…phone_num_info_container)");
    this.kBe = ((ViewGroup)paramContext);
    paramContext = this.iCR.findViewById(2131303215);
    p.g(paramContext, "mRootView.findViewById(R…ne_num_info_request_desc)");
    this.kBf = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131304104);
    p.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.kBg = ((MaxHeightRecyclerView)paramContext);
    this.kBg.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.kBg.setItemAnimator(null);
    paramContext = this.iCR.findViewById(2131304099);
    p.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.kBh = ((TextView)paramContext);
    this.kBh.setOnClickListener((View.OnClickListener)new a.2(this));
    paramContext = this.iCR.findViewById(2131303538);
    p.g(paramContext, "mRootView.findViewById(R.id.protocal_container)");
    this.kBi = ((ViewGroup)paramContext);
    paramContext = this.iCR.findViewById(2131300908);
    p.g(paramContext, "mRootView.findViewById(R.id.idcard_checkbox)");
    this.kBj = ((CheckBox)paramContext);
    paramContext = this.iCR.findViewById(2131304790);
    p.g(paramContext, "mRootView.findViewById(R.id.show_protocal)");
    this.kBk = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131297653);
    p.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.kBl = paramContext;
    paramContext = this.iCR.findViewById(2131304096);
    p.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.kBn = ((Button)paramContext);
    paramContext = this.iCR.findViewById(2131304103);
    p.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.kBm = ((Button)paramContext);
    this.kBm.setOnClickListener((View.OnClickListener)new a.3(this));
    this.kBj.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a.4(this));
    this.kBn.setOnClickListener((View.OnClickListener)new a.5(this));
    this.kBA = ((d.g.a.a)a.a.kBI);
    this.kBB = ((d.g.a.a)a.g.kBO);
    this.kBC = ((d.g.a.a)a.c.kBK);
    this.kBD = ((d.g.a.a)a.f.kBN);
    this.kBE = ((d.g.a.a)a.d.kBL);
    this.kBF = ((d.g.a.a)a.b.kBJ);
    this.kBG = ((d.g.a.a)a.e.kBM);
    AppMethodBeat.o(50477);
  }
  
  private final void sO(int paramInt)
  {
    AppMethodBeat.i(50476);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (double d = 1.5D;; d = 2.5D)
    {
      MaxHeightRecyclerView localMaxHeightRecyclerView = this.kBg;
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
    this.kBo = paramm;
    Object localObject = getContext().getSystemService("window");
    paramm = (com.tencent.mm.plugin.appbrand.widget.dialog.m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.swJ;
      localObject = getContext();
      p.g(localObject, "context");
      View localView1 = this.iCR;
      View localView2 = this.kBl;
      Display localDisplay = paramm.getDefaultDisplay();
      p.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), false);
      paramm = paramm.getDefaultDisplay();
      p.g(paramm, "it.defaultDisplay");
      sO(paramm.getRotation());
      AppMethodBeat.o(50475);
      return;
    }
    AppMethodBeat.o(50475);
  }
  
  public final boolean aOv()
  {
    return false;
  }
  
  public final boolean aOw()
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
    return this.iCR;
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
    this.kBC.invoke();
    AppMethodBeat.o(50473);
  }
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(50474);
    Object localObject = n.swJ;
    localObject = getContext();
    p.g(localObject, "context");
    n.a((Context)localObject, this.iCR, this.kBl, paramInt, false);
    sO(paramInt);
    AppMethodBeat.o(50474);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(50471);
    p.h(paramArrayList, "value");
    this.kBz.clear();
    this.kBz.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.z.m.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(50471);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50469);
      Object localObject = this.kBH;
      Context localContext = this.kBH.getContext();
      p.g(localContext, "context");
      a.a((a)localObject, new q("", localContext, this.kBH.kBz));
      a.b(this.kBH).setAdapter((RecyclerView.a)a.a(this.kBH));
      if (this.kBH.kBz.size() == 0)
      {
        a.c(this.kBH).setVisibility(8);
        AppMethodBeat.o(50469);
        return;
      }
      if (this.kBH.kBz.size() == 1)
      {
        a.c(this.kBH).setVisibility(0);
        localObject = a.b(this.kBH).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        a.d(this.kBH).setText((CharSequence)this.kBH.getContext().getString(2131756029));
        AppMethodBeat.o(50469);
        return;
      }
      a.c(this.kBH).setVisibility(0);
      localObject = a.b(this.kBH).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      a.d(this.kBH).setText((CharSequence)this.kBH.getContext().getString(2131756027));
      AppMethodBeat.o(50469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */