package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "content", "", "context", "Landroid/content/Context;", "height", "", "shouldInLargeScreenCompatMode", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;Ljava/lang/String;Landroid/content/Context;IZ)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getHeight", "()I", "rootView", "titleTv", "applyStyleByRotation", "", "cancel", "dismiss", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getContentView", "getPosition", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "show", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  implements f, com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  @Deprecated
  public static final k.a mjF;
  private final String content;
  final Context context;
  private final TextView hca;
  private final int height;
  private int iDw;
  private final View kBQ;
  private final ImageView kBR;
  private final View kBS;
  private m kBT;
  private final ac mjD;
  private final boolean mjE;
  private final TextView titleTv;
  
  static
  {
    AppMethodBeat.i(192392);
    mjF = new k.a((byte)0);
    AppMethodBeat.o(192392);
  }
  
  public k(ac paramac, String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192391);
    this.mjD = paramac;
    this.content = paramString;
    this.context = paramContext;
    this.height = paramInt;
    this.mjE = paramBoolean;
    if (this.mjD == null) {
      ad.w("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
    }
    this.iDw = 2;
    paramac = View.inflate(this.context, 2131493018, null);
    p.g(paramac, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.kBS = paramac;
    paramac = this.kBS.findViewById(2131303220);
    p.g(paramac, "rootView.findViewById(R.…e_number_explain_content)");
    this.kBQ = paramac;
    paramac = this.kBQ;
    if (paramac != null) {
      paramac.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.height));
    }
    paramac = this.kBS.findViewById(2131303221);
    p.g(paramac, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.kBR = ((ImageView)paramac);
    paramac = this.kBR;
    if (paramac != null) {
      paramac.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148060);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = k.a(this.mjG);
          if (paramAnonymousView != null) {
            paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.mjG);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148060);
        }
      });
    }
    paramac = this.kBS.findViewById(2131303223);
    p.g(paramac, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramac);
    this.titleTv.setText(this.kBS.getContext().getText(2131756008));
    paramac = this.kBS.findViewById(2131303222);
    p.g(paramac, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.hca = ((TextView)paramac);
    this.hca.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void OM(String paramAnonymousString)
      {
        AppMethodBeat.i(148061);
        ac localac = k.b(this.mjG);
        if (localac != null)
        {
          localac.a(this.mjG.context, paramAnonymousString, null);
          AppMethodBeat.o(148061);
          return;
        }
        AppMethodBeat.o(148061);
      }
    }));
    this.hca.setMovementMethod(LinkMovementMethod.getInstance());
    this.hca.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(192391);
  }
  
  private final void bws()
  {
    AppMethodBeat.i(192389);
    Object localObject2 = this.context.getSystemService("window");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof WindowManager)) {
      localObject1 = null;
    }
    localObject1 = (WindowManager)localObject1;
    if (localObject1 != null)
    {
      localObject2 = n.swJ;
      localObject2 = this.kBS.getContext();
      p.g(localObject2, "contentView.context");
      View localView = this.kBS;
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "it.defaultDisplay");
      n.a((Context)localObject2, localView, null, ((Display)localObject1).getRotation(), this.mjE);
      AppMethodBeat.o(192389);
      return;
    }
    AppMethodBeat.o(192389);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(192388);
    this.kBT = paramm;
    bws();
    AppMethodBeat.o(192388);
  }
  
  public final boolean aOv()
  {
    return false;
  }
  
  public final boolean aOw()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(192386);
    m localm = this.kBT;
    if (localm != null)
    {
      localm.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
      AppMethodBeat.o(192386);
      return;
    }
    AppMethodBeat.o(192386);
  }
  
  public final View getContentView()
  {
    return this.kBS;
  }
  
  public final int getPosition()
  {
    return this.iDw;
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(192385);
    p.h(paramd, "component");
    setPosition(this.iDw);
    paramd.aVE().b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    AppMethodBeat.o(192385);
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(192390);
    bws();
    AppMethodBeat.o(192390);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(192387);
    this.iDw = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192387);
      return;
      this.kBS.setBackground(android.support.v4.content.b.l(this.context, 2131231061));
      AppMethodBeat.o(192387);
      return;
      this.kBS.setBackground(android.support.v4.content.b.l(this.context, 2131231060));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */