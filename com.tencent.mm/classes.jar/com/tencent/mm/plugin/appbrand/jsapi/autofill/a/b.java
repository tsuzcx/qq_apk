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
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "title", "", "content", "context", "Landroid/content/Context;", "minHeight", "", "maxHeight", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getMaxHeight", "()I", "getMinHeight", "rootView", "getTitle", "titleTv", "cancel", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class b
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  private final String content;
  private final Context context;
  private final TextView gIq;
  private final View khc;
  private final ImageView khd;
  private final View khe;
  private final m khf;
  final d.g.a.b<String, y> khg;
  final int maxHeight;
  final int minHeight;
  private final String title;
  private final TextView titleTv;
  
  public b(m paramm, String paramString1, String paramString2, Context paramContext, int paramInt1, int paramInt2, d.g.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(50482);
    this.khf = paramm;
    this.title = paramString1;
    this.content = paramString2;
    this.context = paramContext;
    this.minHeight = paramInt1;
    this.maxHeight = paramInt2;
    this.khg = paramb;
    paramm = View.inflate(this.context, 2131493018, null);
    d.g.b.k.g(paramm, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.khe = paramm;
    paramm = this.khe.findViewById(2131303220);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…e_number_explain_content)");
    this.khc = paramm;
    this.khc.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.khc.setMinimumHeight(this.minHeight);
    this.khc.addOnLayoutChangeListener((View.OnLayoutChangeListener)new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(50479);
        if ((Math.abs(paramAnonymousInt4 - paramAnonymousInt2) > this.khh.maxHeight) && (this.khh.maxHeight > this.khh.minHeight)) {
          b.a(this.khh).post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(50478);
              b.a(this.khi.khh).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.khi.khh.maxHeight));
              AppMethodBeat.o(50478);
            }
          });
        }
        AppMethodBeat.o(50479);
      }
    });
    paramm = this.khe.findViewById(2131303221);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.khd = ((ImageView)paramm);
    paramm = this.khd;
    if (paramm != null) {
      paramm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(50480);
          paramAnonymousView = b.b(this.khh);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.khh);
            AppMethodBeat.o(50480);
            return;
          }
          AppMethodBeat.o(50480);
        }
      });
    }
    paramm = this.khe.findViewById(2131303223);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramm);
    this.titleTv.setText((CharSequence)this.title);
    paramm = this.khe.findViewById(2131303222);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.gIq = ((TextView)paramm);
    this.gIq.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void Ls(String paramAnonymousString)
      {
        AppMethodBeat.i(50481);
        d.g.a.b localb = this.khh.khg;
        d.g.b.k.g(paramAnonymousString, "url");
        localb.ay(paramAnonymousString);
        AppMethodBeat.o(50481);
      }
    }));
    this.gIq.setMovementMethod(LinkMovementMethod.getInstance());
    this.gIq.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(50482);
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
    return 2;
  }
  
  public final boolean isCancelable()
  {
    return true;
  }
  
  public final void onCancel() {}
  
  public final void pW(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b
 * JD-Core Version:    0.7.0.1
 */