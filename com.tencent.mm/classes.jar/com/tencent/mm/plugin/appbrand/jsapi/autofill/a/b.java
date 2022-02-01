package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "title", "", "content", "context", "Landroid/content/Context;", "minHeight", "", "maxHeight", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getMaxHeight", "()I", "getMinHeight", "rootView", "getTitle", "titleTv", "cancel", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class b
  implements j
{
  private final String content;
  private final Context context;
  private final TextView kMh;
  final int maxHeight;
  private final View oFU;
  private final ImageView oFV;
  private final View oFW;
  private final com.tencent.mm.plugin.appbrand.widget.dialog.l oFX;
  final int oFY;
  final kotlin.g.a.b<String, x> oFZ;
  private final String title;
  private final TextView titleTv;
  
  public b(com.tencent.mm.plugin.appbrand.widget.dialog.l paraml, String paramString1, String paramString2, Context paramContext, int paramInt1, int paramInt2, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(50482);
    this.oFX = paraml;
    this.title = paramString1;
    this.content = paramString2;
    this.context = paramContext;
    this.oFY = paramInt1;
    this.maxHeight = paramInt2;
    this.oFZ = paramb;
    paraml = View.inflate(this.context, au.g.app_brand_phone_number_explain_dialog, null);
    p.j(paraml, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.oFW = paraml;
    paraml = this.oFW.findViewById(au.f.phone_number_explain_content);
    p.j(paraml, "rootView.findViewById(R.…e_number_explain_content)");
    this.oFU = paraml;
    this.oFU.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.oFU.setMinimumHeight(this.oFY);
    this.oFU.addOnLayoutChangeListener((View.OnLayoutChangeListener)new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(50479);
        if ((Math.abs(paramAnonymousInt4 - paramAnonymousInt2) > this.oGa.maxHeight) && (this.oGa.maxHeight > this.oGa.oFY)) {
          b.a(this.oGa).post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(50478);
              b.a(this.oGb.oGa).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.oGb.oGa.maxHeight));
              AppMethodBeat.o(50478);
            }
          });
        }
        AppMethodBeat.o(50479);
      }
    });
    paraml = this.oFW.findViewById(au.f.phone_number_explain_dialog_back);
    p.j(paraml, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.oFV = ((ImageView)paraml);
    paraml = this.oFV;
    if (paraml != null) {
      paraml.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(50480);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = b.b(this.oGa);
          if (paramAnonymousView != null) {
            paramAnonymousView.b((j)this.oGa);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(50480);
        }
      });
    }
    paraml = this.oFW.findViewById(au.f.phone_number_explain_dialog_title);
    p.j(paraml, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paraml);
    this.titleTv.setText((CharSequence)this.title);
    paraml = this.oFW.findViewById(au.f.phone_number_explain_dialog_content);
    p.j(paraml, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.kMh = ((TextView)paraml);
    this.kMh.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void agt(String paramAnonymousString)
      {
        AppMethodBeat.i(50481);
        kotlin.g.a.b localb = this.oGa.oFZ;
        p.j(paramAnonymousString, "url");
        localb.invoke(paramAnonymousString);
        AppMethodBeat.o(50481);
      }
    }));
    this.kMh.setMovementMethod(LinkMovementMethod.getInstance());
    this.kMh.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(50482);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.l paraml) {}
  
  public final boolean bsB()
  {
    return false;
  }
  
  public final boolean bsC()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss() {}
  
  public final View getContentView()
  {
    return this.oFW;
  }
  
  public final int getPosition()
  {
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void xu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b
 * JD-Core Version:    0.7.0.1
 */