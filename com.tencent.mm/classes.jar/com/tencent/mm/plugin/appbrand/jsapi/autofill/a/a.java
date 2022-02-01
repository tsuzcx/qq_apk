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
import android.widget.CompoundButton;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class a
  extends Dialog
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  public String iconUrl;
  public View ijA;
  private m kgA;
  private q kgB;
  public String kgC;
  public String kgD;
  public String kgE;
  public String kgF;
  public Boolean kgG;
  public String kgH;
  public String kgI;
  public String kgJ;
  public String kgK;
  public ArrayList<PhoneItem> kgL;
  public d.g.a.a<y> kgM;
  public d.g.a.a<y> kgN;
  public d.g.a.a<y> kgO;
  public d.g.a.a<y> kgP;
  public d.g.a.a<y> kgQ;
  public d.g.a.a<y> kgR;
  public d.g.a.a<y> kgS;
  public ImageView kgj;
  public TextView kgk;
  public TextView kgl;
  private ImageView kgm;
  public ViewGroup kgn;
  public TextView kgo;
  public TextView kgp;
  private ViewGroup kgq;
  public TextView kgr;
  private MaxHeightRecyclerView kgs;
  private TextView kgt;
  public ViewGroup kgu;
  public CheckBox kgv;
  public TextView kgw;
  private View kgx;
  public Button kgy;
  private Button kgz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50477);
    paramContext = View.inflate(paramContext, 2131493034, null);
    d.g.b.k.g(paramContext, "View.inflate(context, R.…uth_request_dialog, null)");
    this.ijA = paramContext;
    this.kgL = new ArrayList();
    paramContext = this.ijA.findViewById(2131304100);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.kgj = ((ImageView)paramContext);
    paramContext = this.ijA.findViewById(2131304102);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.kgk = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304095);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.kgl = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304106);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.kgm = ((ImageView)paramContext);
    this.kgm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50457);
        this.kgT.kgQ.invoke();
        AppMethodBeat.o(50457);
      }
    });
    paramContext = this.ijA.findViewById(2131300904);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…d.id_card_info_container)");
    this.kgn = ((ViewGroup)paramContext);
    paramContext = this.ijA.findViewById(2131300906);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…d_card_info_request_desc)");
    this.kgo = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131300905);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…id_card_info_detail_desc)");
    this.kgp = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131303214);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…phone_num_info_container)");
    this.kgq = ((ViewGroup)paramContext);
    paramContext = this.ijA.findViewById(2131303215);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…ne_num_info_request_desc)");
    this.kgr = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131304104);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.kgs = ((MaxHeightRecyclerView)paramContext);
    this.kgs.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.kgs.setItemAnimator(null);
    paramContext = this.ijA.findViewById(2131304099);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.kgt = ((TextView)paramContext);
    this.kgt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50458);
        switch (this.kgT.kgL.size())
        {
        default: 
          this.kgT.kgS.invoke();
          AppMethodBeat.o(50458);
          return;
        }
        this.kgT.kgR.invoke();
        AppMethodBeat.o(50458);
      }
    });
    paramContext = this.ijA.findViewById(2131303538);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.protocal_container)");
    this.kgu = ((ViewGroup)paramContext);
    paramContext = this.ijA.findViewById(2131300908);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.idcard_checkbox)");
    this.kgv = ((CheckBox)paramContext);
    paramContext = this.ijA.findViewById(2131304790);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.show_protocal)");
    this.kgw = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131297653);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.kgx = paramContext;
    paramContext = this.ijA.findViewById(2131304096);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.kgz = ((Button)paramContext);
    paramContext = this.ijA.findViewById(2131304103);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.kgy = ((Button)paramContext);
    this.kgy.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50459);
        this.kgT.kgM.invoke();
        AppMethodBeat.o(50459);
      }
    });
    this.kgv.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(50460);
        a.e(this.kgT).setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(50460);
      }
    });
    this.kgz.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50461);
        this.kgT.kgN.invoke();
        AppMethodBeat.o(50461);
      }
    });
    this.kgM = ((d.g.a.a)a.a.kgU);
    this.kgN = ((d.g.a.a)a.g.kha);
    this.kgO = ((d.g.a.a)a.c.kgW);
    this.kgP = ((d.g.a.a)a.f.kgZ);
    this.kgQ = ((d.g.a.a)a.d.kgX);
    this.kgR = ((d.g.a.a)a.b.kgV);
    this.kgS = ((d.g.a.a)a.e.kgY);
    AppMethodBeat.o(50477);
  }
  
  private final void sm(int paramInt)
  {
    AppMethodBeat.i(50476);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (double d = 1.5D;; d = 2.5D)
    {
      MaxHeightRecyclerView localMaxHeightRecyclerView = this.kgs;
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
    this.kgA = paramm;
    Object localObject = getContext().getSystemService("window");
    paramm = (m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.mCn;
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      View localView1 = this.ijA;
      View localView2 = this.kgx;
      Display localDisplay = paramm.getDefaultDisplay();
      d.g.b.k.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), false);
      paramm = paramm.getDefaultDisplay();
      d.g.b.k.g(paramm, "it.defaultDisplay");
      sm(paramm.getRotation());
      AppMethodBeat.o(50475);
      return;
    }
    AppMethodBeat.o(50475);
  }
  
  public final boolean aLl()
  {
    return false;
  }
  
  public final boolean aLm()
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
    return this.ijA;
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
    this.kgO.invoke();
    AppMethodBeat.o(50473);
  }
  
  public final void pW(int paramInt)
  {
    AppMethodBeat.i(50474);
    Object localObject = n.mCn;
    localObject = getContext();
    d.g.b.k.g(localObject, "context");
    n.a((Context)localObject, this.ijA, this.kgx, paramInt, false);
    sm(paramInt);
    AppMethodBeat.o(50474);
  }
  
  public final void x(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(50471);
    d.g.b.k.h(paramArrayList, "value");
    this.kgL.clear();
    this.kgL.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.z.l.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(50471);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50469);
      Object localObject = this.kgT;
      Context localContext = this.kgT.getContext();
      d.g.b.k.g(localContext, "context");
      a.a((a)localObject, new q("", localContext, this.kgT.kgL));
      a.b(this.kgT).setAdapter((RecyclerView.a)a.a(this.kgT));
      if (this.kgT.kgL.size() == 0)
      {
        a.c(this.kgT).setVisibility(8);
        AppMethodBeat.o(50469);
        return;
      }
      if (this.kgT.kgL.size() == 1)
      {
        a.c(this.kgT).setVisibility(0);
        localObject = a.b(this.kgT).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        a.d(this.kgT).setText((CharSequence)this.kgT.getContext().getString(2131756029));
        AppMethodBeat.o(50469);
        return;
      }
      a.c(this.kgT).setVisibility(0);
      localObject = a.b(this.kgT).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      a.d(this.kgT).setText((CharSequence)this.kgT.getContext().getString(2131756027));
      AppMethodBeat.o(50469);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$1$1"})
  public static final class i
    implements View.OnClickListener
  {
    public i(a parama, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50470);
      this.kgT.kgP.invoke();
      AppMethodBeat.o(50470);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */