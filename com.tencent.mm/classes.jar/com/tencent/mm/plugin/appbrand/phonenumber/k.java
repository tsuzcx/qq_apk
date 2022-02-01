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
import com.tencent.luggage.l.a.c;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.g.a;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "content", "", "context", "Landroid/content/Context;", "height", "", "shouldInLargeScreenCompatMode", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;Ljava/lang/String;Landroid/content/Context;IZ)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getHeight", "()I", "rootView", "titleTv", "applyStyleByRotation", "", "cancel", "dismiss", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getContentView", "getPosition", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "show", "Companion", "luggage-wechat-full-sdk_release"})
public final class k
  implements com.tencent.mm.plugin.appbrand.permission.g, j
{
  @Deprecated
  public static final k.a qBz;
  private final String content;
  final Context context;
  private final int height;
  private final TextView kMh;
  private int msq;
  private final View oFU;
  private final ImageView oFV;
  private final View oFW;
  private com.tencent.mm.plugin.appbrand.widget.dialog.l oFX;
  private final ag qBx;
  private final boolean qBy;
  private final TextView titleTv;
  
  static
  {
    AppMethodBeat.i(234758);
    qBz = new k.a((byte)0);
    AppMethodBeat.o(234758);
  }
  
  public k(ag paramag, String paramString, Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(234757);
    this.qBx = paramag;
    this.content = paramString;
    this.context = paramContext;
    this.height = paramInt;
    this.qBy = paramBoolean;
    if (this.qBx == null) {
      Log.w("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
    }
    this.msq = 2;
    paramag = View.inflate(this.context, a.e.app_brand_phone_number_explain_dialog, null);
    p.j(paramag, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.oFW = paramag;
    paramag = this.oFW.findViewById(a.d.phone_number_explain_content);
    p.j(paramag, "rootView.findViewById(R.…e_number_explain_content)");
    this.oFU = paramag;
    paramag = this.oFU;
    if (paramag != null) {
      paramag.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.height));
    }
    paramag = this.oFW.findViewById(a.d.phone_number_explain_dialog_back);
    p.j(paramag, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.oFV = ((ImageView)paramag);
    paramag = this.oFV;
    if (paramag != null) {
      paramag.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148060);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = k.a(this.qBA);
          if (paramAnonymousView != null) {
            paramAnonymousView.b((j)this.qBA);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148060);
        }
      });
    }
    paramag = this.oFW.findViewById(a.d.phone_number_explain_dialog_title);
    p.j(paramag, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramag);
    this.titleTv.setText(this.oFW.getContext().getText(a.g.appbrand_permission_authorize_explain_title));
    paramag = this.oFW.findViewById(a.d.phone_number_explain_dialog_content);
    p.j(paramag, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.kMh = ((TextView)paramag);
    this.kMh.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void agt(String paramAnonymousString)
      {
        AppMethodBeat.i(148061);
        ag localag = k.b(this.qBA);
        if (localag != null)
        {
          localag.a(this.qBA.context, paramAnonymousString, null);
          AppMethodBeat.o(148061);
          return;
        }
        AppMethodBeat.o(148061);
      }
    }));
    this.kMh.setMovementMethod(LinkMovementMethod.getInstance());
    this.kMh.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(234757);
  }
  
  private final void cgy()
  {
    AppMethodBeat.i(234753);
    Object localObject2 = this.context.getSystemService("window");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof WindowManager)) {
      localObject1 = null;
    }
    localObject1 = (WindowManager)localObject1;
    if (localObject1 != null)
    {
      localObject2 = m.ruC;
      localObject2 = this.oFW.getContext();
      p.j(localObject2, "contentView.context");
      View localView = this.oFW;
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      p.j(localObject1, "it.defaultDisplay");
      m.a((Context)localObject2, localView, null, ((Display)localObject1).getRotation(), this.qBy);
      AppMethodBeat.o(234753);
      return;
    }
    AppMethodBeat.o(234753);
  }
  
  private static com.tencent.mm.plugin.appbrand.widget.dialog.l o(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(234759);
    p.k(paramg, "$this$findPromptViewContainer");
    paramg = g.a.l(paramg);
    AppMethodBeat.o(234759);
    return paramg;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.l paraml)
  {
    AppMethodBeat.i(234752);
    this.oFX = paraml;
    cgy();
    AppMethodBeat.o(234752);
  }
  
  public final boolean bsB()
  {
    return false;
  }
  
  public final boolean bsC()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss()
  {
    AppMethodBeat.i(234746);
    com.tencent.mm.plugin.appbrand.widget.dialog.l locall = this.oFX;
    if (locall != null)
    {
      locall.b((j)this);
      AppMethodBeat.o(234746);
      return;
    }
    AppMethodBeat.o(234746);
  }
  
  public final View getContentView()
  {
    return this.oFW;
  }
  
  public final int getPosition()
  {
    return this.msq;
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(234744);
    p.k(paramg, "component");
    setPosition(this.msq);
    o(paramg).a((j)this);
    AppMethodBeat.o(234744);
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(234745);
    p.k(paramg, "component");
    o(paramg).b((j)this);
    AppMethodBeat.o(234745);
  }
  
  public final void onCancel() {}
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(234750);
    this.msq = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(234750);
      return;
      this.oFW.setBackground(androidx.core.content.a.m(this.context, a.c.appbrand_user_auth_request_dialog_center_style_bg));
      AppMethodBeat.o(234750);
      return;
      this.oFW.setBackground(androidx.core.content.a.m(this.context, a.c.appbrand_user_auth_request_dialog_bg));
    }
  }
  
  public final void xu(int paramInt)
  {
    AppMethodBeat.i(234754);
    cgy();
    AppMethodBeat.o(234754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */