package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onChecked", "Lkotlin/Function1;", "getOnChecked", "()Lkotlin/jvm/functions/Function1;", "setOnChecked", "(Lkotlin/jvm/functions/Function1;)V", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "setOnPhoneItemSelect", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "initWeCoinAuthDialog", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class a
  extends Dialog
  implements j
{
  private String iconUrl;
  private TextView mMu;
  public View mrI;
  private String oFA;
  ArrayList<PhoneItem> oFB;
  kotlin.g.a.a<x> oFC;
  kotlin.g.a.a<x> oFD;
  private kotlin.g.a.a<x> oFE;
  public kotlin.g.a.b<? super Boolean, x> oFF;
  kotlin.g.a.a<x> oFG;
  public kotlin.g.a.a<x> oFH;
  kotlin.g.a.a<x> oFI;
  kotlin.g.a.a<x> oFJ;
  public ImageView oFa;
  private TextView oFb;
  public ImageView oFc;
  private ViewGroup oFd;
  private TextView oFe;
  private TextView oFf;
  private ViewGroup oFg;
  private TextView oFh;
  private MaxHeightRecyclerView oFi;
  private TextView oFj;
  private ViewGroup oFk;
  private CheckBox oFl;
  private TextView oFm;
  private View oFn;
  private Button oFo;
  private Button oFp;
  private com.tencent.mm.plugin.appbrand.widget.dialog.l oFq;
  private com.tencent.mm.plugin.appbrand.phonenumber.q oFr;
  private String oFs;
  private String oFt;
  private String oFu;
  private String oFv;
  private Boolean oFw;
  private String oFx;
  private String oFy;
  private String oFz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50477);
    paramContext = View.inflate(paramContext, au.g.app_brand_real_name_auth_request_dialog, null);
    p.j(paramContext, "View.inflate(context, R.…uth_request_dialog, null)");
    this.mrI = paramContext;
    this.oFB = new ArrayList();
    paramContext = this.mrI.findViewById(au.f.request_icon);
    p.j(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.oFa = ((ImageView)paramContext);
    paramContext = this.mrI.findViewById(au.f.request_name);
    p.j(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.mMu = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(au.f.request_apply_wording);
    p.j(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.oFb = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(au.f.request_right_icon);
    p.j(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.oFc = ((ImageView)paramContext);
    this.oFc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50457);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.oFK.oFH.invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(50457);
      }
    });
    paramContext = this.mrI.findViewById(au.f.id_card_info_container);
    p.j(paramContext, "mRootView.findViewById(R…d.id_card_info_container)");
    this.oFd = ((ViewGroup)paramContext);
    paramContext = this.mrI.findViewById(au.f.id_card_info_request_desc);
    p.j(paramContext, "mRootView.findViewById(R…d_card_info_request_desc)");
    this.oFe = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(au.f.id_card_info_detail_desc);
    p.j(paramContext, "mRootView.findViewById(R…id_card_info_detail_desc)");
    this.oFf = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(au.f.phone_num_info_container);
    p.j(paramContext, "mRootView.findViewById(R…phone_num_info_container)");
    this.oFg = ((ViewGroup)paramContext);
    paramContext = this.mrI.findViewById(au.f.phone_num_info_request_desc);
    p.j(paramContext, "mRootView.findViewById(R…ne_num_info_request_desc)");
    this.oFh = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(au.f.request_recyclerview);
    p.j(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.oFi = ((MaxHeightRecyclerView)paramContext);
    this.oFi.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.oFi.setItemAnimator(null);
    paramContext = this.mrI.findViewById(au.f.request_function);
    p.j(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.oFj = ((TextView)paramContext);
    this.oFj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50458);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        switch (this.oFK.oFB.size())
        {
        default: 
          this.oFK.oFJ.invoke();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(50458);
          return;
          this.oFK.oFI.invoke();
        }
      }
    });
    paramContext = this.mrI.findViewById(au.f.protocal_container);
    p.j(paramContext, "mRootView.findViewById(R.id.protocal_container)");
    this.oFk = ((ViewGroup)paramContext);
    paramContext = this.mrI.findViewById(au.f.idcard_checkbox);
    p.j(paramContext, "mRootView.findViewById(R.id.idcard_checkbox)");
    this.oFl = ((CheckBox)paramContext);
    paramContext = this.mrI.findViewById(au.f.show_protocal);
    p.j(paramContext, "mRootView.findViewById(R.id.show_protocal)");
    this.oFm = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(au.f.button_group);
    p.j(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.oFn = paramContext;
    paramContext = this.mrI.findViewById(au.f.request_cancel);
    p.j(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.oFp = ((Button)paramContext);
    paramContext = this.mrI.findViewById(au.f.request_ok);
    p.j(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.oFo = ((Button)paramContext);
    this.oFo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50459);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.oFK.oFC.invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(50459);
      }
    });
    this.oFl.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(50460);
        this.oFK.oFF.invoke(Boolean.valueOf(paramAnonymousBoolean));
        a.e(this.oFK).setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(50460);
      }
    });
    this.oFp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50461);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        this.oFK.oFD.invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(50461);
      }
    });
    this.oFC = ((kotlin.g.a.a)a.oFL);
    this.oFD = ((kotlin.g.a.a)h.oFS);
    this.oFE = ((kotlin.g.a.a)c.oFN);
    this.oFF = ((kotlin.g.a.b)d.oFO);
    this.oFG = ((kotlin.g.a.a)g.oFR);
    this.oFH = ((kotlin.g.a.a)e.oFP);
    this.oFI = ((kotlin.g.a.a)b.oFM);
    this.oFJ = ((kotlin.g.a.a)f.oFQ);
    AppMethodBeat.o(50477);
  }
  
  private final void Ac(int paramInt)
  {
    AppMethodBeat.i(50476);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (double d = 1.5D;; d = 2.5D)
    {
      MaxHeightRecyclerView localMaxHeightRecyclerView = this.oFi;
      Context localContext = getContext();
      p.j(localContext, "context");
      localMaxHeightRecyclerView.setMaxHeight((int)(d * localContext.getResources().getDimensionPixelSize(au.d.authorize_dialog_select_list_item_height)));
      AppMethodBeat.o(50476);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.l paraml)
  {
    AppMethodBeat.i(50475);
    this.oFq = paraml;
    Object localObject = getContext().getSystemService("window");
    paraml = (com.tencent.mm.plugin.appbrand.widget.dialog.l)localObject;
    if (!(localObject instanceof WindowManager)) {
      paraml = null;
    }
    paraml = (WindowManager)paraml;
    if (paraml != null)
    {
      localObject = com.tencent.mm.plugin.appbrand.widget.dialog.m.ruC;
      localObject = getContext();
      p.j(localObject, "context");
      View localView1 = this.mrI;
      View localView2 = this.oFn;
      Display localDisplay = paraml.getDefaultDisplay();
      p.j(localDisplay, "it.defaultDisplay");
      com.tencent.mm.plugin.appbrand.widget.dialog.m.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), false);
      paraml = paraml.getDefaultDisplay();
      p.j(paraml, "it.defaultDisplay");
      Ac(paraml.getRotation());
      AppMethodBeat.o(50475);
      return;
    }
    AppMethodBeat.o(50475);
  }
  
  public final void ahg(String paramString)
  {
    AppMethodBeat.i(281475);
    this.oFt = paramString;
    TextView localTextView = this.oFb;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(281475);
      return;
    }
  }
  
  public final void ahh(String paramString)
  {
    AppMethodBeat.i(281476);
    this.oFu = paramString;
    TextView localTextView = this.oFe;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(281476);
      return;
    }
  }
  
  public final void ahi(String paramString)
  {
    AppMethodBeat.i(281477);
    this.oFv = paramString;
    TextView localTextView = this.oFh;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(281477);
      return;
    }
  }
  
  public final void ahj(String paramString)
  {
    AppMethodBeat.i(281479);
    this.oFx = paramString;
    Button localButton = this.oFo;
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = (CharSequence)paramString;; paramString = getContext().getText(au.i.app_brand_idcard_show_default_confirm_text))
    {
      localButton.setText(paramString);
      AppMethodBeat.o(281479);
      return;
    }
  }
  
  public final void ahk(String paramString)
  {
    AppMethodBeat.i(281480);
    this.oFy = paramString;
    CheckBox localCheckBox = this.oFl;
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = (CharSequence)paramString;; paramString = getContext().getText(au.i.app_brand_idcard_show_legal_agreement_prefix))
    {
      localCheckBox.setText(paramString);
      AppMethodBeat.o(281480);
      return;
    }
  }
  
  public final void ahl(final String paramString)
  {
    AppMethodBeat.i(281482);
    this.oFz = paramString;
    if (paramString != null)
    {
      this.oFm.setText((CharSequence)paramString);
      this.oFm.setOnClickListener((View.OnClickListener)new j(this, paramString));
    }
    AppMethodBeat.o(281482);
  }
  
  public final void ahm(String paramString)
  {
    AppMethodBeat.i(281483);
    this.oFA = paramString;
    if (Util.isNullOrNil(paramString))
    {
      this.oFd.setVisibility(8);
      this.oFk.setVisibility(8);
      AppMethodBeat.o(281483);
      return;
    }
    this.oFd.setVisibility(0);
    this.oFf.setText((CharSequence)paramString);
    this.oFk.setVisibility(0);
    AppMethodBeat.o(281483);
  }
  
  public final PhoneItem bQy()
  {
    AppMethodBeat.i(281493);
    Iterator localIterator = this.oFB.iterator();
    while (localIterator.hasNext())
    {
      PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
      if (localPhoneItem.qBK)
      {
        AppMethodBeat.o(281493);
        return localPhoneItem;
      }
    }
    AppMethodBeat.o(281493);
    return null;
  }
  
  public final boolean bsB()
  {
    return false;
  }
  
  public final boolean bsC()
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
    return this.mrI;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void j(Boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(281478);
    this.oFw = paramBoolean;
    Object localObject = this.oFl;
    if (paramBoolean != null) {}
    for (boolean bool1 = paramBoolean.booleanValue();; bool1 = false)
    {
      ((CheckBox)localObject).setChecked(bool1);
      localObject = this.oFo;
      bool1 = bool2;
      if (paramBoolean != null) {
        bool1 = paramBoolean.booleanValue();
      }
      ((Button)localObject).setEnabled(bool1);
      AppMethodBeat.o(281478);
      return;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(50473);
    this.oFE.invoke();
    AppMethodBeat.o(50473);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(281474);
    this.oFs = paramString;
    TextView localTextView = this.mMu;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(281474);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(281473);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.oFa, paramString, com.tencent.mm.modelappbrand.a.a.bhg(), (b.h)g.lzF);
    AppMethodBeat.o(281473);
  }
  
  public final void setOnAccept(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281485);
    p.k(parama, "<set-?>");
    this.oFC = parama;
    AppMethodBeat.o(281485);
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281489);
    p.k(parama, "<set-?>");
    this.oFI = parama;
    AppMethodBeat.o(281489);
  }
  
  public final void setOnCancel(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281487);
    p.k(parama, "<set-?>");
    this.oFE = parama;
    AppMethodBeat.o(281487);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281490);
    p.k(parama, "<set-?>");
    this.oFJ = parama;
    AppMethodBeat.o(281490);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(50471);
    p.k(paramArrayList, "value");
    this.oFB.clear();
    this.oFB.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread((Runnable)new i(this));
    AppMethodBeat.o(50471);
  }
  
  public final void v(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281486);
    p.k(parama, "<set-?>");
    this.oFD = parama;
    AppMethodBeat.o(281486);
  }
  
  public final void w(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(281488);
    p.k(parama, "<set-?>");
    this.oFG = parama;
    AppMethodBeat.o(281488);
  }
  
  public final void xu(int paramInt)
  {
    AppMethodBeat.i(50474);
    Object localObject = com.tencent.mm.plugin.appbrand.widget.dialog.m.ruC;
    localObject = getContext();
    p.j(localObject, "context");
    com.tencent.mm.plugin.appbrand.widget.dialog.m.a((Context)localObject, this.mrI, this.oFn, paramInt, false);
    Ac(paramInt);
    AppMethodBeat.o(50474);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final a oFL;
    
    static
    {
      AppMethodBeat.i(50462);
      oFL = new a();
      AppMethodBeat.o(50462);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final b oFM;
    
    static
    {
      AppMethodBeat.i(50463);
      oFM = new b();
      AppMethodBeat.o(50463);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final c oFN;
    
    static
    {
      AppMethodBeat.i(50464);
      oFN = new c();
      AppMethodBeat.o(50464);
    }
    
    c()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    public static final d oFO;
    
    static
    {
      AppMethodBeat.i(266024);
      oFO = new d();
      AppMethodBeat.o(266024);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final e oFP;
    
    static
    {
      AppMethodBeat.i(50465);
      oFP = new e();
      AppMethodBeat.o(50465);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final f oFQ;
    
    static
    {
      AppMethodBeat.i(50466);
      oFQ = new f();
      AppMethodBeat.o(50466);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final g oFR;
    
    static
    {
      AppMethodBeat.i(50467);
      oFR = new g();
      AppMethodBeat.o(50467);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final h oFS;
    
    static
    {
      AppMethodBeat.i(50468);
      oFS = new h();
      AppMethodBeat.o(50468);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50469);
      Object localObject = this.oFK;
      Context localContext = this.oFK.getContext();
      p.j(localContext, "context");
      a.a((a)localObject, new com.tencent.mm.plugin.appbrand.phonenumber.q("", localContext, this.oFK.oFB));
      a.b(this.oFK).setAdapter((RecyclerView.a)a.a(this.oFK));
      if (this.oFK.oFB.size() == 0)
      {
        a.c(this.oFK).setVisibility(8);
        AppMethodBeat.o(50469);
        return;
      }
      if (this.oFK.oFB.size() == 1)
      {
        a.c(this.oFK).setVisibility(0);
        localObject = a.b(this.oFK).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        a.d(this.oFK).setText((CharSequence)this.oFK.getContext().getString(au.i.appbrand_phone_number_use_other_phone_number));
        AppMethodBeat.o(50469);
        return;
      }
      a.c(this.oFK).setVisibility(0);
      localObject = a.b(this.oFK).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      a.d(this.oFK).setText((CharSequence)this.oFK.getContext().getString(au.i.appbrand_phone_number_manager_phone_number));
      AppMethodBeat.o(50469);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$1$1"})
  static final class j
    implements View.OnClickListener
  {
    j(a parama, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50470);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.oFK.oFG.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(50470);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */