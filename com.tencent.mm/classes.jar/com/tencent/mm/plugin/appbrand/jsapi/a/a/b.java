package com.tencent.mm.plugin.appbrand.jsapi.a.a;

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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "title", "", "content", "context", "Landroid/content/Context;", "minHeight", "", "maxHeight", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getMaxHeight", "()I", "getMinHeight", "rootView", "getTitle", "titleTv", "cancel", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class b
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  private final String content;
  private final Context context;
  private final TextView izX;
  private final View jGE;
  private final ImageView jGF;
  private final View jGG;
  private final m jGH;
  final d.g.a.b<String, y> jGI;
  final int maxHeight;
  final int minHeight;
  private final String title;
  private final TextView titleTv;
  
  public b(m paramm, String paramString1, String paramString2, Context paramContext, int paramInt1, int paramInt2, d.g.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(50482);
    this.jGH = paramm;
    this.title = paramString1;
    this.content = paramString2;
    this.context = paramContext;
    this.minHeight = paramInt1;
    this.maxHeight = paramInt2;
    this.jGI = paramb;
    paramm = View.inflate(this.context, 2131493018, null);
    d.g.b.k.g(paramm, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.jGG = paramm;
    paramm = this.jGG.findViewById(2131303220);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…e_number_explain_content)");
    this.jGE = paramm;
    this.jGE.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.jGE.setMinimumHeight(this.minHeight);
    this.jGE.addOnLayoutChangeListener((View.OnLayoutChangeListener)new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(50479);
        if ((Math.abs(paramAnonymousInt4 - paramAnonymousInt2) > this.jGJ.maxHeight) && (this.jGJ.maxHeight > this.jGJ.minHeight)) {
          b.a(this.jGJ).post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(50478);
              b.a(this.jGK.jGJ).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.jGK.jGJ.maxHeight));
              AppMethodBeat.o(50478);
            }
          });
        }
        AppMethodBeat.o(50479);
      }
    });
    paramm = this.jGG.findViewById(2131303221);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.jGF = ((ImageView)paramm);
    paramm = this.jGF;
    if (paramm != null) {
      paramm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(50480);
          paramAnonymousView = b.b(this.jGJ);
          if (paramAnonymousView != null)
          {
            paramAnonymousView.c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.jGJ);
            AppMethodBeat.o(50480);
            return;
          }
          AppMethodBeat.o(50480);
        }
      });
    }
    paramm = this.jGG.findViewById(2131303223);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramm);
    this.titleTv.setText((CharSequence)this.title);
    paramm = this.jGG.findViewById(2131303222);
    d.g.b.k.g(paramm, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.izX = ((TextView)paramm);
    this.izX.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void Ho(String paramAnonymousString)
      {
        AppMethodBeat.i(50481);
        d.g.a.b localb = this.jGJ.jGI;
        d.g.b.k.g(paramAnonymousString, "url");
        localb.aA(paramAnonymousString);
        AppMethodBeat.o(50481);
      }
    }));
    this.izX.setMovementMethod(LinkMovementMethod.getInstance());
    this.izX.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(50482);
  }
  
  public final void a(m paramm) {}
  
  public final boolean aEu()
  {
    return false;
  }
  
  public final boolean aEv()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss() {}
  
  public final View getContentView()
  {
    return this.jGG;
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
  
  public final void pi(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a.b
 * JD-Core Version:    0.7.0.1
 */