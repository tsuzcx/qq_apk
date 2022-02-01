package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "service", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "content", "", "context", "Landroid/content/Context;", "height", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;Ljava/lang/String;Landroid/content/Context;I)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "getHeight", "()I", "rootView", "getService", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "titleTv", "cancel", "", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "luggage-wechat-full-sdk_release"})
public final class k
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  private final String content;
  public final Context context;
  private final TextView gIq;
  private final int height;
  public int ikf;
  final h kdB;
  private final View khc;
  private final ImageView khd;
  public final View khe;
  private final m khf;
  private final TextView titleTv;
  
  public k(m paramm, h paramh, String paramString, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148062);
    this.khf = paramm;
    this.kdB = paramh;
    this.content = paramString;
    this.context = paramContext;
    this.height = paramInt;
    this.ikf = 2;
    paramm = View.inflate(this.context, 2131493018, null);
    d.g.b.k.g(paramm, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.khe = paramm;
    paramm = this.khe.findViewById(2131303220);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…e_number_explain_content)");
    this.khc = paramm;
    paramm = this.khc;
    if (paramm != null) {
      paramm.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.height));
    }
    paramm = this.khe.findViewById(2131303221);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.khd = ((ImageView)paramm);
    paramm = this.khd;
    if (paramm != null) {
      paramm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148060);
          paramAnonymousView = k.a(this.lJQ);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.lJQ);
            AppMethodBeat.o(148060);
            return;
          }
          AppMethodBeat.o(148060);
        }
      });
    }
    paramm = this.khe.findViewById(2131303223);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramm);
    this.titleTv.setText(this.khe.getContext().getText(2131756008));
    paramm = this.khe.findViewById(2131303222);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.gIq = ((TextView)paramm);
    this.gIq.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void Ls(String paramAnonymousString)
      {
        AppMethodBeat.i(148061);
        b localb = this.lJQ.kdB.K(ac.class);
        if (localb == null) {
          d.g.b.k.fOy();
        }
        ((ac)localb).a(this.lJQ.context, paramAnonymousString, null);
        AppMethodBeat.o(148061);
      }
    }));
    this.gIq.setMovementMethod(LinkMovementMethod.getInstance());
    this.gIq.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(148062);
  }
  
  public final void a(m paramm) {}
  
  public final boolean aLl()
  {
    return false;
  }
  
  public final boolean aLm()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss() {}
  
  public final View getContentView()
  {
    return this.khe;
  }
  
  public final int getPosition()
  {
    return this.ikf;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void pW(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */