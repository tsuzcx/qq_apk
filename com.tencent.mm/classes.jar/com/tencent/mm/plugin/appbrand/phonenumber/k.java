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
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.f.a;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "content", "", "context", "Landroid/content/Context;", "height", "", "shouldInLargeScreenCompatMode", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;Ljava/lang/String;Landroid/content/Context;IZ)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getHeight", "()I", "rootView", "titleTv", "applyStyleByRotation", "", "cancel", "dismiss", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getContentView", "getPosition", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "show", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  implements g, com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  @Deprecated
  public static final a nzo;
  private final String content;
  final Context context;
  private final TextView hXC;
  private final int height;
  private int jCs;
  private final View lJG;
  private final ImageView lJH;
  private final View lJI;
  private m lJJ;
  private final ag nzm;
  private final boolean nzn;
  private final TextView titleTv;
  
  static
  {
    AppMethodBeat.i(230145);
    nzo = new a((byte)0);
    AppMethodBeat.o(230145);
  }
  
  public k(ag paramag, String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230144);
    this.nzm = paramag;
    this.content = paramString;
    this.context = paramContext;
    this.height = paramInt;
    this.nzn = paramBoolean;
    if (this.nzm == null) {
      Log.w("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
    }
    this.jCs = 2;
    paramag = View.inflate(this.context, 2131493057, null);
    p.g(paramag, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.lJI = paramag;
    paramag = this.lJI.findViewById(2131305888);
    p.g(paramag, "rootView.findViewById(R.…e_number_explain_content)");
    this.lJG = paramag;
    paramag = this.lJG;
    if (paramag != null) {
      paramag.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.height));
    }
    paramag = this.lJI.findViewById(2131305889);
    p.g(paramag, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.lJH = ((ImageView)paramag);
    paramag = this.lJH;
    if (paramag != null) {
      paramag.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148060);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = k.a(this.nzp);
          if (paramAnonymousView != null) {
            paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.nzp);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148060);
        }
      });
    }
    paramag = this.lJI.findViewById(2131305891);
    p.g(paramag, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramag);
    this.titleTv.setText(this.lJI.getContext().getText(2131756123));
    paramag = this.lJI.findViewById(2131305890);
    p.g(paramag, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.hXC = ((TextView)paramag);
    this.hXC.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void YF(String paramAnonymousString)
      {
        AppMethodBeat.i(148061);
        ag localag = k.b(this.nzp);
        if (localag != null)
        {
          localag.a(this.nzp.context, paramAnonymousString, null);
          AppMethodBeat.o(148061);
          return;
        }
        AppMethodBeat.o(148061);
      }
    }));
    this.hXC.setMovementMethod(LinkMovementMethod.getInstance());
    this.hXC.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(230144);
  }
  
  private final void bTt()
  {
    AppMethodBeat.i(230142);
    Object localObject2 = this.context.getSystemService("window");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof WindowManager)) {
      localObject1 = null;
    }
    localObject1 = (WindowManager)localObject1;
    if (localObject1 != null)
    {
      localObject2 = n.OrG;
      localObject2 = this.lJI.getContext();
      p.g(localObject2, "contentView.context");
      View localView = this.lJI;
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.g(localObject1, "it.defaultDisplay");
      n.a((Context)localObject2, localView, null, ((Display)localObject1).getRotation(), this.nzn);
      AppMethodBeat.o(230142);
      return;
    }
    AppMethodBeat.o(230142);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(230141);
    this.lJJ = paramm;
    bTt();
    AppMethodBeat.o(230141);
  }
  
  public final boolean bjb()
  {
    return false;
  }
  
  public final boolean bjc()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(230139);
    m localm = this.lJJ;
    if (localm != null)
    {
      localm.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
      AppMethodBeat.o(230139);
      return;
    }
    AppMethodBeat.o(230139);
  }
  
  public final View getContentView()
  {
    return this.lJI;
  }
  
  public final int getPosition()
  {
    return this.jCs;
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(230138);
    p.h(paramd, "component");
    setPosition(this.jCs);
    p.h(paramd, "$this$findPromptViewContainer");
    p.h(paramd, "$this$findPromptViewContainer");
    f.a.j(paramd).b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    AppMethodBeat.o(230138);
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(230140);
    this.jCs = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(230140);
      return;
      this.lJI.setBackground(android.support.v4.content.b.l(this.context, 2131231096));
      AppMethodBeat.o(230140);
      return;
      this.lJI.setBackground(android.support.v4.content.b.l(this.context, 2131231095));
    }
  }
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(230143);
    bTt();
    AppMethodBeat.o(230143);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */