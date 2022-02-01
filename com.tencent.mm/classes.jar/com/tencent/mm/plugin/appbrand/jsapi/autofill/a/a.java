package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
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
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "IDCardInfo", "getIDCardInfo", "()Ljava/lang/String;", "setIDCardInfo", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "confirmWording", "getConfirmWording", "setConfirmWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "", "isAuthCheck", "()Ljava/lang/Boolean;", "setAuthCheck", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mConfirmAssess", "Landroid/widget/CheckBox;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIDCardContainer", "Landroid/view/ViewGroup;", "mIDCardInfoTv", "Landroid/widget/TextView;", "mIconIv", "mNameTv", "mPhoneNumActionTv", "mPhoneNumContainer", "mPhoneWordingTv", "mProtocalContainer", "mProtocalTv", "mRealnameWordingTv", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "mRequestTv", "mRootView", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onChecked", "Lkotlin/Function1;", "getOnChecked", "()Lkotlin/jvm/functions/Function1;", "setOnChecked", "(Lkotlin/jvm/functions/Function1;)V", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "setOnPhoneItemSelect", "onProtocalJump", "getOnProtocalJump", "setOnProtocalJump", "onReject", "getOnReject", "setOnReject", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneWording", "getPhoneWording", "setPhoneWording", "protocolJumpWording", "getProtocolJumpWording", "setProtocolJumpWording", "protocolPrefixWording", "getProtocolPrefixWording", "setProtocolPrefixWording", "realnameWording", "getRealnameWording", "setRealnameWording", "requstWording", "getRequstWording", "setRequstWording", "changeListHeightByRotation", "rotation", "", "dismiss", "getContentView", "getDialogHeight", "getPosition", "getSelectedPhoneItem", "initWeCoinAuthDialog", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class a
  extends Dialog
  implements k
{
  private String iconUrl;
  public View jBN;
  private TextView jVh;
  public ImageView lIM;
  private TextView lIN;
  public ImageView lIO;
  private ViewGroup lIP;
  private TextView lIQ;
  private TextView lIR;
  private ViewGroup lIS;
  private TextView lIT;
  private MaxHeightRecyclerView lIU;
  private TextView lIV;
  private ViewGroup lIW;
  private CheckBox lIX;
  private TextView lIY;
  private View lIZ;
  private Button lJa;
  private Button lJb;
  private com.tencent.mm.plugin.appbrand.widget.dialog.m lJc;
  private com.tencent.mm.plugin.appbrand.phonenumber.q lJd;
  private String lJe;
  private String lJf;
  private String lJg;
  private String lJh;
  private Boolean lJi;
  private String lJj;
  private String lJk;
  private String lJl;
  private String lJm;
  ArrayList<PhoneItem> lJn;
  kotlin.g.a.a<x> lJo;
  kotlin.g.a.a<x> lJp;
  private kotlin.g.a.a<x> lJq;
  public kotlin.g.a.b<? super Boolean, x> lJr;
  kotlin.g.a.a<x> lJs;
  public kotlin.g.a.a<x> lJt;
  kotlin.g.a.a<x> lJu;
  kotlin.g.a.a<x> lJv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50477);
    paramContext = View.inflate(paramContext, 2131493073, null);
    p.g(paramContext, "View.inflate(context, R.…uth_request_dialog, null)");
    this.jBN = paramContext;
    this.lJn = new ArrayList();
    paramContext = this.jBN.findViewById(2131306967);
    p.g(paramContext, "mRootView.findViewById(R.id.request_icon)");
    this.lIM = ((ImageView)paramContext);
    paramContext = this.jBN.findViewById(2131306969);
    p.g(paramContext, "mRootView.findViewById(R.id.request_name)");
    this.jVh = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131306961);
    p.g(paramContext, "mRootView.findViewById(R.id.request_apply_wording)");
    this.lIN = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131306973);
    p.g(paramContext, "mRootView.findViewById(R.id.request_right_icon)");
    this.lIO = ((ImageView)paramContext);
    this.lIO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50457);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.lJw.lJt.invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(50457);
      }
    });
    paramContext = this.jBN.findViewById(2131302515);
    p.g(paramContext, "mRootView.findViewById(R…d.id_card_info_container)");
    this.lIP = ((ViewGroup)paramContext);
    paramContext = this.jBN.findViewById(2131302517);
    p.g(paramContext, "mRootView.findViewById(R…d_card_info_request_desc)");
    this.lIQ = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131302516);
    p.g(paramContext, "mRootView.findViewById(R…id_card_info_detail_desc)");
    this.lIR = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131305882);
    p.g(paramContext, "mRootView.findViewById(R…phone_num_info_container)");
    this.lIS = ((ViewGroup)paramContext);
    paramContext = this.jBN.findViewById(2131305883);
    p.g(paramContext, "mRootView.findViewById(R…ne_num_info_request_desc)");
    this.lIT = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131306971);
    p.g(paramContext, "mRootView.findViewById(R.id.request_recyclerview)");
    this.lIU = ((MaxHeightRecyclerView)paramContext);
    this.lIU.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.lIU.setItemAnimator(null);
    paramContext = this.jBN.findViewById(2131306966);
    p.g(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.lIV = ((TextView)paramContext);
    this.lIV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50458);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        switch (this.lJw.lJn.size())
        {
        default: 
          this.lJw.lJv.invoke();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(50458);
          return;
          this.lJw.lJu.invoke();
        }
      }
    });
    paramContext = this.jBN.findViewById(2131306307);
    p.g(paramContext, "mRootView.findViewById(R.id.protocal_container)");
    this.lIW = ((ViewGroup)paramContext);
    paramContext = this.jBN.findViewById(2131302519);
    p.g(paramContext, "mRootView.findViewById(R.id.idcard_checkbox)");
    this.lIX = ((CheckBox)paramContext);
    paramContext = this.jBN.findViewById(2131307872);
    p.g(paramContext, "mRootView.findViewById(R.id.show_protocal)");
    this.lIY = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131297917);
    p.g(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.lIZ = paramContext;
    paramContext = this.jBN.findViewById(2131306962);
    p.g(paramContext, "mRootView.findViewById(R.id.request_cancel)");
    this.lJb = ((Button)paramContext);
    paramContext = this.jBN.findViewById(2131306970);
    p.g(paramContext, "mRootView.findViewById(R.id.request_ok)");
    this.lJa = ((Button)paramContext);
    this.lJa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50459);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.lJw.lJo.invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(50459);
      }
    });
    this.lIX.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(50460);
        this.lJw.lJr.invoke(Boolean.valueOf(paramAnonymousBoolean));
        a.e(this.lJw).setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(50460);
      }
    });
    this.lJb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50461);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.lJw.lJp.invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(50461);
      }
    });
    this.lJo = ((kotlin.g.a.a)a.lJx);
    this.lJp = ((kotlin.g.a.a)h.lJE);
    this.lJq = ((kotlin.g.a.a)c.lJz);
    this.lJr = ((kotlin.g.a.b)d.lJA);
    this.lJs = ((kotlin.g.a.a)g.lJD);
    this.lJt = ((kotlin.g.a.a)e.lJB);
    this.lJu = ((kotlin.g.a.a)b.lJy);
    this.lJv = ((kotlin.g.a.a)f.lJC);
    AppMethodBeat.o(50477);
  }
  
  private final void wN(int paramInt)
  {
    AppMethodBeat.i(50476);
    if ((paramInt == 1) || (paramInt == 3)) {}
    for (double d = 1.5D;; d = 2.5D)
    {
      MaxHeightRecyclerView localMaxHeightRecyclerView = this.lIU;
      Context localContext = getContext();
      p.g(localContext, "context");
      localMaxHeightRecyclerView.setMaxHeight((int)(d * localContext.getResources().getDimensionPixelSize(2131165912)));
      AppMethodBeat.o(50476);
      return;
    }
  }
  
  public final void Zs(String paramString)
  {
    AppMethodBeat.i(228328);
    this.lJf = paramString;
    TextView localTextView = this.lIN;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(228328);
      return;
    }
  }
  
  public final void Zt(String paramString)
  {
    AppMethodBeat.i(228329);
    this.lJg = paramString;
    TextView localTextView = this.lIQ;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(228329);
      return;
    }
  }
  
  public final void Zu(String paramString)
  {
    AppMethodBeat.i(228330);
    this.lJh = paramString;
    TextView localTextView = this.lIT;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(228330);
      return;
    }
  }
  
  public final void Zv(String paramString)
  {
    AppMethodBeat.i(228332);
    this.lJj = paramString;
    Button localButton = this.lJa;
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = (CharSequence)paramString;; paramString = getContext().getText(2131755498))
    {
      localButton.setText(paramString);
      AppMethodBeat.o(228332);
      return;
    }
  }
  
  public final void Zw(String paramString)
  {
    AppMethodBeat.i(228333);
    this.lJk = paramString;
    CheckBox localCheckBox = this.lIX;
    if (!Util.isNullOrNil(paramString)) {}
    for (paramString = (CharSequence)paramString;; paramString = getContext().getText(2131755499))
    {
      localCheckBox.setText(paramString);
      AppMethodBeat.o(228333);
      return;
    }
  }
  
  public final void Zx(final String paramString)
  {
    AppMethodBeat.i(228334);
    this.lJl = paramString;
    if (paramString != null)
    {
      this.lIY.setText((CharSequence)paramString);
      this.lIY.setOnClickListener((View.OnClickListener)new j(this, paramString));
    }
    AppMethodBeat.o(228334);
  }
  
  public final void Zy(String paramString)
  {
    AppMethodBeat.i(228335);
    this.lJm = paramString;
    if (Util.isNullOrNil(paramString))
    {
      this.lIP.setVisibility(8);
      this.lIW.setVisibility(8);
      AppMethodBeat.o(228335);
      return;
    }
    this.lIP.setVisibility(0);
    this.lIR.setText((CharSequence)paramString);
    this.lIW.setVisibility(0);
    AppMethodBeat.o(228335);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.m paramm)
  {
    AppMethodBeat.i(50475);
    this.lJc = paramm;
    Object localObject = getContext().getSystemService("window");
    paramm = (com.tencent.mm.plugin.appbrand.widget.dialog.m)localObject;
    if (!(localObject instanceof WindowManager)) {
      paramm = null;
    }
    paramm = (WindowManager)paramm;
    if (paramm != null)
    {
      localObject = n.OrG;
      localObject = getContext();
      p.g(localObject, "context");
      View localView1 = this.jBN;
      View localView2 = this.lIZ;
      Display localDisplay = paramm.getDefaultDisplay();
      p.g(localDisplay, "it.defaultDisplay");
      n.a((Context)localObject, localView1, localView2, localDisplay.getRotation(), false);
      paramm = paramm.getDefaultDisplay();
      p.g(paramm, "it.defaultDisplay");
      wN(paramm.getRotation());
      AppMethodBeat.o(50475);
      return;
    }
    AppMethodBeat.o(50475);
  }
  
  public final PhoneItem bEU()
  {
    AppMethodBeat.i(228342);
    Iterator localIterator = this.lJn.iterator();
    while (localIterator.hasNext())
    {
      PhoneItem localPhoneItem = (PhoneItem)localIterator.next();
      if (localPhoneItem.nzz)
      {
        AppMethodBeat.o(228342);
        return localPhoneItem;
      }
    }
    AppMethodBeat.o(228342);
    return null;
  }
  
  public final boolean bjb()
  {
    return false;
  }
  
  public final boolean bjc()
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
  
  public final void g(Boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(228331);
    this.lJi = paramBoolean;
    Object localObject = this.lIX;
    if (paramBoolean != null) {}
    for (boolean bool1 = paramBoolean.booleanValue();; bool1 = false)
    {
      ((CheckBox)localObject).setChecked(bool1);
      localObject = this.lJa;
      bool1 = bool2;
      if (paramBoolean != null) {
        bool1 = paramBoolean.booleanValue();
      }
      ((Button)localObject).setEnabled(bool1);
      AppMethodBeat.o(228331);
      return;
    }
  }
  
  public final View getContentView()
  {
    return this.jBN;
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
    this.lJq.invoke();
    AppMethodBeat.o(50473);
  }
  
  public final void setAppBrandName(String paramString)
  {
    AppMethodBeat.i(228327);
    this.lJe = paramString;
    TextView localTextView = this.jVh;
    if (paramString != null) {}
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      localTextView.setText(paramString);
      AppMethodBeat.o(228327);
      return;
    }
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(228326);
    this.iconUrl = paramString;
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.lIM, paramString, com.tencent.mm.modelappbrand.a.a.aXX(), (b.h)g.iJB);
    AppMethodBeat.o(228326);
  }
  
  public final void setOnAccept(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228336);
    p.h(parama, "<set-?>");
    this.lJo = parama;
    AppMethodBeat.o(228336);
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228340);
    p.h(parama, "<set-?>");
    this.lJu = parama;
    AppMethodBeat.o(228340);
  }
  
  public final void setOnCancel(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228338);
    p.h(parama, "<set-?>");
    this.lJq = parama;
    AppMethodBeat.o(228338);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228341);
    p.h(parama, "<set-?>");
    this.lJv = parama;
    AppMethodBeat.o(228341);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(50471);
    p.h(paramArrayList, "value");
    this.lJn.clear();
    this.lJn.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread((Runnable)new i(this));
    AppMethodBeat.o(50471);
  }
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(50474);
    Object localObject = n.OrG;
    localObject = getContext();
    p.g(localObject, "context");
    n.a((Context)localObject, this.jBN, this.lIZ, paramInt, false);
    wN(paramInt);
    AppMethodBeat.o(50474);
  }
  
  public final void x(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228337);
    p.h(parama, "<set-?>");
    this.lJp = parama;
    AppMethodBeat.o(228337);
  }
  
  public final void y(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(228339);
    p.h(parama, "<set-?>");
    this.lJs = parama;
    AppMethodBeat.o(228339);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final a lJx;
    
    static
    {
      AppMethodBeat.i(50462);
      lJx = new a();
      AppMethodBeat.o(50462);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final b lJy;
    
    static
    {
      AppMethodBeat.i(50463);
      lJy = new b();
      AppMethodBeat.o(50463);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final c lJz;
    
    static
    {
      AppMethodBeat.i(50464);
      lJz = new c();
      AppMethodBeat.o(50464);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    public static final d lJA;
    
    static
    {
      AppMethodBeat.i(228325);
      lJA = new d();
      AppMethodBeat.o(228325);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final e lJB;
    
    static
    {
      AppMethodBeat.i(50465);
      lJB = new e();
      AppMethodBeat.o(50465);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final f lJC;
    
    static
    {
      AppMethodBeat.i(50466);
      lJC = new f();
      AppMethodBeat.o(50466);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final g lJD;
    
    static
    {
      AppMethodBeat.i(50467);
      lJD = new g();
      AppMethodBeat.o(50467);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final h lJE;
    
    static
    {
      AppMethodBeat.i(50468);
      lJE = new h();
      AppMethodBeat.o(50468);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50469);
      Object localObject = this.lJw;
      Context localContext = this.lJw.getContext();
      p.g(localContext, "context");
      a.a((a)localObject, new com.tencent.mm.plugin.appbrand.phonenumber.q("", localContext, this.lJw.lJn));
      a.b(this.lJw).setAdapter((RecyclerView.a)a.a(this.lJw));
      if (this.lJw.lJn.size() == 0)
      {
        a.c(this.lJw).setVisibility(8);
        AppMethodBeat.o(50469);
        return;
      }
      if (this.lJw.lJn.size() == 1)
      {
        a.c(this.lJw).setVisibility(0);
        localObject = a.b(this.lJw).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        a.d(this.lJw).setText((CharSequence)this.lJw.getContext().getString(2131756144));
        AppMethodBeat.o(50469);
        return;
      }
      a.c(this.lJw).setVisibility(0);
      localObject = a.b(this.lJw).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      a.d(this.lJw).setText((CharSequence)this.lJw.getContext().getString(2131756142));
      AppMethodBeat.o(50469);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$1$1"})
  static final class j
    implements View.OnClickListener
  {
    j(a parama, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50470);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.lJw.lJs.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/AppBrandRealnameAuthDialog$protocolJumpWording$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(50470);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */