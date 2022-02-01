package com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.q;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.t;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onChecked", "Lkotlin/Function1;", "getOnChecked", "()Lkotlin/jvm/functions/Function1;", "setOnChecked", "(Lkotlin/jvm/functions/Function1;)V", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "setOnPhoneItemSelect", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "initWeCoinAuthDialog", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "onShown", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Dialog
  implements n
{
  private kotlin.g.a.a<ah> Uu;
  private String iconUrl;
  private TextView pJc;
  public View plc;
  private Boolean rIA;
  private String rIB;
  private String rIC;
  private String rID;
  private String rIE;
  private ArrayList<PhoneItem> rIF;
  private kotlin.g.a.a<ah> rIG;
  private kotlin.g.a.a<ah> rIH;
  public kotlin.g.a.b<? super Boolean, ah> rII;
  private kotlin.g.a.a<ah> rIJ;
  public kotlin.g.a.a<ah> rIK;
  private kotlin.g.a.a<ah> rIL;
  private kotlin.g.a.a<ah> rIM;
  public ImageView rIe;
  private TextView rIf;
  public ImageView rIg;
  private ViewGroup rIh;
  private TextView rIi;
  private TextView rIj;
  private ViewGroup rIk;
  private TextView rIl;
  private MaxHeightRecyclerView rIm;
  private TextView rIn;
  private ViewGroup rIo;
  private CheckBox rIp;
  private TextView rIq;
  private View rIr;
  private Button rIs;
  private Button rIt;
  private r rIu;
  private q rIv;
  private String rIw;
  private String rIx;
  private String rIy;
  private String rIz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50477);
    paramContext = View.inflate(paramContext, ba.g.app_brand_real_name_auth_request_dialog, null);
    s.s(paramContext, "inflate(context, R.layou…uth_request_dialog, null)");
    this.plc = paramContext;
    this.rIF = new ArrayList();
    paramContext = this.plc.findViewById(ba.f.request_icon);
    s.s(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.rIe = ((ImageView)paramContext);
    paramContext = this.plc.findViewById(ba.f.request_name);
    s.s(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.pJc = ((TextView)paramContext);
    paramContext = this.plc.findViewById(ba.f.request_apply_wording);
    s.s(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.rIf = ((TextView)paramContext);
    paramContext = this.plc.findViewById(ba.f.request_right_icon);
    s.s(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.rIg = ((ImageView)paramContext);
    this.rIg.setOnClickListener(new a..ExternalSyntheticLambda3(this));
    paramContext = this.plc.findViewById(ba.f.id_card_info_container);
    s.s(paramContext, "mRootView.findViewById(R…d.id_card_info_container)");
    this.rIh = ((ViewGroup)paramContext);
    paramContext = this.plc.findViewById(ba.f.id_card_info_request_desc);
    s.s(paramContext, "mRootView.findViewById(R…d_card_info_request_desc)");
    this.rIi = ((TextView)paramContext);
    paramContext = this.plc.findViewById(ba.f.id_card_info_detail_desc);
    s.s(paramContext, "mRootView.findViewById(R…id_card_info_detail_desc)");
    this.rIj = ((TextView)paramContext);
    paramContext = this.plc.findViewById(ba.f.phone_num_info_container);
    s.s(paramContext, "mRootView.findViewById(R…phone_num_info_container)");
    this.rIk = ((ViewGroup)paramContext);
    paramContext = this.plc.findViewById(ba.f.phone_num_info_request_desc);
    s.s(paramContext, "mRootView.findViewById(R…ne_num_info_request_desc)");
    this.rIl = ((TextView)paramContext);
    paramContext = this.plc.findViewById(ba.f.request_recyclerview);
    s.s(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.rIm = ((MaxHeightRecyclerView)paramContext);
    this.rIm.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.rIm.setItemAnimator(null);
    paramContext = this.plc.findViewById(ba.f.request_function);
    s.s(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.rIn = ((TextView)paramContext);
    this.rIn.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    paramContext = this.plc.findViewById(ba.f.protocal_container);
    s.s(paramContext, "mRootView.findViewById(R.id.protocal_container)");
    this.rIo = ((ViewGroup)paramContext);
    paramContext = this.plc.findViewById(ba.f.idcard_checkbox);
    s.s(paramContext, "mRootView.findViewById(R.id.idcard_checkbox)");
    this.rIp = ((CheckBox)paramContext);
    paramContext = this.plc.findViewById(ba.f.show_protocal);
    s.s(paramContext, "mRootView.findViewById(R.id.show_protocal)");
    this.rIq = ((TextView)paramContext);
    paramContext = this.plc.findViewById(ba.f.button_group);
    s.s(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.rIr = paramContext;
    paramContext = this.plc.findViewById(ba.f.request_cancel);
    s.s(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.rIt = ((Button)paramContext);
    paramContext = this.plc.findViewById(ba.f.request_ok);
    s.s(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.rIs = ((Button)paramContext);
    this.rIs.setOnClickListener(new a..ExternalSyntheticLambda2(this));
    this.rIp.setOnCheckedChangeListener(new a..ExternalSyntheticLambda5(this));
    this.rIt.setOnClickListener(new a..ExternalSyntheticLambda4(this));
    this.rIG = ((kotlin.g.a.a)a.a.rIN);
    this.rIH = ((kotlin.g.a.a)a.h.rIU);
    this.Uu = ((kotlin.g.a.a)a.c.rIP);
    this.rII = ((kotlin.g.a.b)a.d.rIQ);
    this.rIJ = ((kotlin.g.a.a)a.g.rIT);
    this.rIK = ((kotlin.g.a.a)a.e.rIR);
    this.rIL = ((kotlin.g.a.a)a.b.rIO);
    this.rIM = ((kotlin.g.a.a)a.f.rIS);
    AppMethodBeat.o(50477);
  }
  
  private final void At(int paramInt)
  {
    AppMethodBeat.i(50476);
    switch (paramInt)
    {
    }
    for (double d = 2.5D;; d = 1.5D)
    {
      this.rIm.setMaxHeight((int)(d * getContext().getResources().getDimensionPixelSize(ba.d.authorize_dialog_select_list_item_height)));
      AppMethodBeat.o(50476);
      return;
    }
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(326700);
    s.u(parama, "this$0");
    Object localObject = parama.getContext();
    s.s(localObject, "context");
    parama.rIv = new q("", (Context)localObject, parama.rIF);
    parama.rIm.setAdapter((RecyclerView.a)parama.rIv);
    if (parama.rIF.size() == 0)
    {
      parama.rIk.setVisibility(8);
      AppMethodBeat.o(326700);
      return;
    }
    if (parama.rIF.size() == 1)
    {
      parama.rIk.setVisibility(0);
      localObject = parama.rIm.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      parama.rIn.setText((CharSequence)parama.getContext().getString(ba.i.appbrand_phone_number_use_other_phone_number));
      AppMethodBeat.o(326700);
      return;
    }
    parama.rIk.setVisibility(0);
    localObject = parama.rIm.getAdapter();
    if (localObject != null) {
      ((RecyclerView.a)localObject).bZE.notifyChanged();
    }
    parama.rIn.setText((CharSequence)parama.getContext().getString(ba.i.appbrand_phone_number_manager_phone_number));
    AppMethodBeat.o(326700);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(326693);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.rIJ.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(326693);
  }
  
  private static final void a(a parama, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(326722);
    s.u(parama, "this$0");
    parama.rII.invoke(Boolean.valueOf(paramBoolean));
    parama.rIs.setEnabled(paramBoolean);
    AppMethodBeat.o(326722);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(326707);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.rIK.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(326707);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(326710);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    if (parama.rIF.size() == 1) {
      parama.rIL.invoke();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(326710);
      return;
      parama.rIM.invoke();
    }
  }
  
  private static final void d(a parama, View paramView)
  {
    AppMethodBeat.i(326715);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.rIG.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(326715);
  }
  
  private static final void e(a parama, View paramView)
  {
    AppMethodBeat.i(326727);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.rIH.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(326727);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(50475);
    this.rIu = paramr;
    paramr = getContext().getSystemService("window");
    if ((paramr instanceof WindowManager)) {}
    for (paramr = (WindowManager)paramr;; paramr = null)
    {
      if (paramr != null)
      {
        Object localObject = t.uFu;
        localObject = getContext();
        s.s(localObject, "context");
        t.a((Context)localObject, this.plc, this.rIr, paramr.getDefaultDisplay().getRotation(), false);
        At(paramr.getDefaultDisplay().getRotation());
      }
      AppMethodBeat.o(50475);
      return;
    }
  }
  
  public final void aad(String paramString)
  {
    AppMethodBeat.i(326777);
    this.rIx = paramString;
    TextView localTextView = this.rIf;
    if (paramString == null) {}
    for (paramString = (CharSequence)"";; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(326777);
      return;
    }
  }
  
  public final void aae(String paramString)
  {
    AppMethodBeat.i(326785);
    this.rIy = paramString;
    TextView localTextView = this.rIi;
    if (paramString == null) {}
    for (paramString = (CharSequence)"";; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(326785);
      return;
    }
  }
  
  public final void aaf(String paramString)
  {
    AppMethodBeat.i(326787);
    this.rIz = paramString;
    TextView localTextView = this.rIl;
    if (paramString == null) {}
    for (paramString = (CharSequence)"";; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(326787);
      return;
    }
  }
  
  public final void aag(String paramString)
  {
    AppMethodBeat.i(326796);
    this.rIB = paramString;
    Button localButton = this.rIs;
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = (CharSequence)paramString;; paramString = getContext().getText(ba.i.app_brand_idcard_show_default_confirm_text))
    {
      localButton.setText(paramString);
      AppMethodBeat.o(326796);
      return;
    }
  }
  
  public final void aah(String paramString)
  {
    AppMethodBeat.i(326800);
    this.rIC = paramString;
    CheckBox localCheckBox = this.rIp;
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = (CharSequence)paramString;; paramString = getContext().getText(ba.i.app_brand_idcard_show_legal_agreement_prefix))
    {
      localCheckBox.setText(paramString);
      AppMethodBeat.o(326800);
      return;
    }
  }
  
  public final void aai(String paramString)
  {
    AppMethodBeat.i(326806);
    this.rID = paramString;
    if (paramString != null)
    {
      this.rIq.setText((CharSequence)paramString);
      this.rIq.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(326806);
  }
  
  public final void aaj(String paramString)
  {
    AppMethodBeat.i(326814);
    this.rIE = paramString;
    if (Util.isNullOrNil(paramString))
    {
      this.rIh.setVisibility(8);
      this.rIo.setVisibility(8);
      AppMethodBeat.o(326814);
      return;
    }
    this.rIh.setVisibility(0);
    this.rIj.setText((CharSequence)paramString);
    this.rIo.setVisibility(0);
    AppMethodBeat.o(326814);
  }
  
  public final void ao(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(326824);
    s.u(parama, "<set-?>");
    this.rIG = parama;
    AppMethodBeat.o(326824);
  }
  
  public final void ap(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(326829);
    s.u(parama, "<set-?>");
    this.rIH = parama;
    AppMethodBeat.o(326829);
  }
  
  public final void aq(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(326838);
    s.u(parama, "<set-?>");
    this.rIJ = parama;
    AppMethodBeat.o(326838);
  }
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void bQh() {}
  
  public final boolean bQi()
  {
    return false;
  }
  
  public final PhoneItem cqv()
  {
    AppMethodBeat.i(326887);
    Iterator localIterator = this.rIF.iterator();
    while (localIterator.hasNext())
    {
      PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
      if (localPhoneItem.tGP)
      {
        AppMethodBeat.o(326887);
        return localPhoneItem;
      }
    }
    AppMethodBeat.o(326887);
    return null;
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
    return this.plc;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void m(Boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(326792);
    this.rIA = paramBoolean;
    Object localObject = this.rIp;
    if (paramBoolean == null)
    {
      bool1 = false;
      ((CheckBox)localObject).setChecked(bool1);
      localObject = this.rIs;
      if (paramBoolean != null) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = paramBoolean.booleanValue())
    {
      ((Button)localObject).setEnabled(bool1);
      AppMethodBeat.o(326792);
      return;
      bool1 = paramBoolean.booleanValue();
      break;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(50473);
    this.Uu.invoke();
    AppMethodBeat.o(50473);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(326772);
    this.rIw = paramString;
    TextView localTextView = this.pJc;
    if (paramString == null) {}
    for (paramString = (CharSequence)"";; paramString = (CharSequence)paramString)
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(326772);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(326767);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.rIe, paramString, com.tencent.mm.modelappbrand.a.a.bEX(), (b.h)g.org);
    AppMethodBeat.o(326767);
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(326842);
    s.u(parama, "<set-?>");
    this.rIL = parama;
    AppMethodBeat.o(326842);
  }
  
  public final void setOnCancel(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(326834);
    s.u(parama, "<set-?>");
    this.Uu = parama;
    AppMethodBeat.o(326834);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(326849);
    s.u(parama, "<set-?>");
    this.rIM = parama;
    AppMethodBeat.o(326849);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(50471);
    s.u(paramArrayList, "value");
    this.rIF.clear();
    this.rIF.addAll((Collection)paramArrayList);
    o.runOnUiThread(new a..ExternalSyntheticLambda6(this));
    AppMethodBeat.o(50471);
  }
  
  public final void xt(int paramInt)
  {
    AppMethodBeat.i(50474);
    Object localObject = t.uFu;
    localObject = getContext();
    s.s(localObject, "context");
    t.a((Context)localObject, this.plc, this.rIr, paramInt, false);
    At(paramInt);
    AppMethodBeat.o(50474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.realname_auth.a
 * JD-Core Version:    0.7.0.1
 */