package com.tencent.mm.plugin.appbrand.jsapi.a.a;

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
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class a
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  public View hIZ;
  public String iconUrl;
  public ImageView jFL;
  public TextView jFM;
  public TextView jFN;
  private ImageView jFO;
  public ViewGroup jFP;
  public TextView jFQ;
  public TextView jFR;
  private ViewGroup jFS;
  public TextView jFT;
  private MaxHeightRecyclerView jFU;
  private TextView jFV;
  public ViewGroup jFW;
  public CheckBox jFX;
  public TextView jFY;
  private View jFZ;
  public Button jGa;
  private Button jGb;
  private m jGc;
  private q jGd;
  public String jGe;
  public String jGf;
  public String jGg;
  public String jGh;
  public Boolean jGi;
  public String jGj;
  public String jGk;
  public String jGl;
  public String jGm;
  public ArrayList<PhoneItem> jGn;
  public d.g.a.a<y> jGo;
  public d.g.a.a<y> jGp;
  public d.g.a.a<y> jGq;
  public d.g.a.a<y> jGr;
  public d.g.a.a<y> jGs;
  public d.g.a.a<y> jGt;
  public d.g.a.a<y> jGu;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50477);
    paramContext = View.inflate(paramContext, 2131493034, null);
    d.g.b.k.g(paramContext, "View.inflate(context, R.…uth_request_dialog, null)");
    this.hIZ = paramContext;
    this.jGn = new ArrayList();
    paramContext = this.hIZ.findViewById(2131304100);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.jFL = ((ImageView)paramContext);
    paramContext = this.hIZ.findViewById(2131304102);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.jFM = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131304095);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.jFN = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131304106);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.jFO = ((ImageView)paramContext);
    this.jFO.setOnClickListener((View.OnClickListener)new a.1(this));
    paramContext = this.hIZ.findViewById(2131300904);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…d.id_card_info_container)");
    this.jFP = ((ViewGroup)paramContext);
    paramContext = this.hIZ.findViewById(2131300906);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…d_card_info_request_desc)");
    this.jFQ = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131300905);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…id_card_info_detail_desc)");
    this.jFR = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131303214);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…phone_num_info_container)");
    this.jFS = ((ViewGroup)paramContext);
    paramContext = this.hIZ.findViewById(2131303215);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…ne_num_info_request_desc)");
    this.jFT = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131304104);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.jFU = ((MaxHeightRecyclerView)paramContext);
    this.jFU.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.jFU.setItemAnimator(null);
    paramContext = this.hIZ.findViewById(2131304099);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.jFV = ((TextView)paramContext);
    this.jFV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50458);
        switch (this.jGv.jGn.size())
        {
        default: 
          this.jGv.jGu.invoke();
          AppMethodBeat.o(50458);
          return;
        }
        this.jGv.jGt.invoke();
        AppMethodBeat.o(50458);
      }
    });
    paramContext = this.hIZ.findViewById(2131303538);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.protocal_container)");
    this.jFW = ((ViewGroup)paramContext);
    paramContext = this.hIZ.findViewById(2131300908);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.idcard_checkbox)");
    this.jFX = ((CheckBox)paramContext);
    paramContext = this.hIZ.findViewById(2131304790);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.show_protocal)");
    this.jFY = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131297653);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.jFZ = paramContext;
    paramContext = this.hIZ.findViewById(2131304096);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.jGb = ((Button)paramContext);
    paramContext = this.hIZ.findViewById(2131304103);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.jGa = ((Button)paramContext);
    this.jGa.setOnClickListener((View.OnClickListener)new a.3(this));
    this.jFX.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a.4(this));
    this.jGb.setOnClickListener((View.OnClickListener)new a.5(this));
    this.jGo = ((d.g.a.a)a.a.jGw);
    this.jGp = ((d.g.a.a)a.g.jGC);
    this.jGq = ((d.g.a.a)a.c.jGy);
    this.jGr = ((d.g.a.a)a.f.jGB);
    this.jGs = ((d.g.a.a)a.d.jGz);
    this.jGt = ((d.g.a.a)a.b.jGx);
    this.jGu = ((d.g.a.a)a.e.jGA);
    AppMethodBeat.o(50477);
  }
  
  private final void rx(int paramInt)
  {
    AppMethodBeat.i(50476);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (double d = 1.5D;; d = 2.5D)
    {
      MaxHeightRecyclerView localMaxHeightRecyclerView = this.jFU;
      Context localContext = getContext();
      d.g.b.k.g(localContext, "context");
      localMaxHeightRecyclerView.setMaxHeight((int)(d * localContext.getResources().getDimensionPixelSize(2131165886)));
      AppMethodBeat.o(50476);
      return;
    }
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(50475);
    this.jGc = paramm;
    Object localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.KDx;
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      View localView1 = this.hIZ;
      View localView2 = this.jFZ;
      Display localDisplay = paramm.getDefaultDisplay();
      d.g.b.k.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), false);
      paramm = paramm.getDefaultDisplay();
      d.g.b.k.g(paramm, "it.defaultDisplay");
      rx(paramm.getRotation());
      AppMethodBeat.o(50475);
      return;
    }
    AppMethodBeat.o(50475);
  }
  
  public final boolean aEu()
  {
    return false;
  }
  
  public final boolean aEv()
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
    return this.hIZ;
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
    this.jGq.invoke();
    AppMethodBeat.o(50473);
  }
  
  public final void pi(int paramInt)
  {
    AppMethodBeat.i(50474);
    Object localObject = n.KDx;
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    n.a((Context)localObject, this.hIZ, this.jFZ, paramInt, false);
    rx(paramInt);
    AppMethodBeat.o(50474);
  }
  
  public final void s(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(50471);
    d.g.b.k.h(paramArrayList, "value");
    this.jGn.clear();
    this.jGn.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.aa.l.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(50471);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50469);
      Object localObject = this.jGv;
      Context localContext = this.jGv.getContext();
      d.g.b.k.g(localContext, "context");
      a.a((a)localObject, new q("", localContext, this.jGv.jGn));
      a.b(this.jGv).setAdapter((RecyclerView.a)a.a(this.jGv));
      if (this.jGv.jGn.size() == 0)
      {
        a.c(this.jGv).setVisibility(8);
        AppMethodBeat.o(50469);
        return;
      }
      if (this.jGv.jGn.size() == 1)
      {
        a.c(this.jGv).setVisibility(0);
        localObject = a.b(this.jGv).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        a.d(this.jGv).setText((CharSequence)this.jGv.getContext().getString(2131756029));
        AppMethodBeat.o(50469);
        return;
      }
      a.c(this.jGv).setVisibility(0);
      localObject = a.b(this.jGv).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      a.d(this.jGv).setText((CharSequence)this.jGv.getContext().getString(2131756027));
      AppMethodBeat.o(50469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a.a
 * JD-Core Version:    0.7.0.1
 */