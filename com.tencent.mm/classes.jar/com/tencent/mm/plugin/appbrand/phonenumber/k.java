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
import com.tencent.mm.plugin.appbrand.permission.f.a;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "content", "", "context", "Landroid/content/Context;", "height", "", "shouldInLargeScreenCompatMode", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;Ljava/lang/String;Landroid/content/Context;IZ)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getHeight", "()I", "rootView", "titleTv", "applyStyleByRotation", "", "cancel", "dismiss", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getContentView", "getPosition", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "show", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  implements g, com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  @Deprecated
  public static final k.a moC;
  private final String content;
  final Context context;
  private final TextView heO;
  private final int height;
  private int iGp;
  private final View kFf;
  private final ImageView kFg;
  private final View kFh;
  private m kFi;
  private final ac moA;
  private final boolean moB;
  private final TextView titleTv;
  
  static
  {
    AppMethodBeat.i(221005);
    moC = new k.a((byte)0);
    AppMethodBeat.o(221005);
  }
  
  public k(ac paramac, String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221004);
    this.moA = paramac;
    this.content = paramString;
    this.context = paramContext;
    this.height = paramInt;
    this.moB = paramBoolean;
    if (this.moA == null) {
      ae.w("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
    }
    this.iGp = 2;
    paramac = View.inflate(this.context, 2131493018, null);
    p.g(paramac, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.kFh = paramac;
    paramac = this.kFh.findViewById(2131303220);
    p.g(paramac, "rootView.findViewById(R.…e_number_explain_content)");
    this.kFf = paramac;
    paramac = this.kFf;
    if (paramac != null) {
      paramac.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.height));
    }
    paramac = this.kFh.findViewById(2131303221);
    p.g(paramac, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.kFg = ((ImageView)paramac);
    paramac = this.kFg;
    if (paramac != null) {
      paramac.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148060);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = k.a(this.moD);
          if (paramAnonymousView != null) {
            paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.moD);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148060);
        }
      });
    }
    paramac = this.kFh.findViewById(2131303223);
    p.g(paramac, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramac);
    this.titleTv.setText(this.kFh.getContext().getText(2131756008));
    paramac = this.kFh.findViewById(2131303222);
    p.g(paramac, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.heO = ((TextView)paramac);
    this.heO.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void Pu(String paramAnonymousString)
      {
        AppMethodBeat.i(148061);
        ac localac = k.b(this.moD);
        if (localac != null)
        {
          localac.a(this.moD.context, paramAnonymousString, null);
          AppMethodBeat.o(148061);
          return;
        }
        AppMethodBeat.o(148061);
      }
    }));
    this.heO.setMovementMethod(LinkMovementMethod.getInstance());
    this.heO.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(221004);
  }
  
  private final void bxj()
  {
    AppMethodBeat.i(221002);
    Object localObject2 = this.context.getSystemService("window");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof WindowManager)) {
      localObject1 = null;
    }
    localObject1 = (WindowManager)localObject1;
    if (localObject1 != null)
    {
      localObject2 = n.nic;
      localObject2 = this.kFh.getContext();
      p.g(localObject2, "contentView.context");
      View localView = this.kFh;
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "it.defaultDisplay");
      n.a((Context)localObject2, localView, null, ((Display)localObject1).getRotation(), this.moB);
      AppMethodBeat.o(221002);
      return;
    }
    AppMethodBeat.o(221002);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(221001);
    this.kFi = paramm;
    bxj();
    AppMethodBeat.o(221001);
  }
  
  public final boolean aOS()
  {
    return false;
  }
  
  public final boolean aOT()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(220999);
    m localm = this.kFi;
    if (localm != null)
    {
      localm.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
      AppMethodBeat.o(220999);
      return;
    }
    AppMethodBeat.o(220999);
  }
  
  public final View getContentView()
  {
    return this.kFh;
  }
  
  public final int getPosition()
  {
    return this.iGp;
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(220998);
    p.h(paramd, "component");
    setPosition(this.iGp);
    p.h(paramd, "$this$findPromptViewContainer");
    p.h(paramd, "$this$findPromptViewContainer");
    f.a.j(paramd).b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    AppMethodBeat.o(220998);
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void qB(int paramInt)
  {
    AppMethodBeat.i(221003);
    bxj();
    AppMethodBeat.o(221003);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(221000);
    this.iGp = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(221000);
      return;
      this.kFh.setBackground(android.support.v4.content.b.l(this.context, 2131231061));
      AppMethodBeat.o(221000);
      return;
      this.kFh.setBackground(android.support.v4.content.b.l(this.context, 2131231060));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */