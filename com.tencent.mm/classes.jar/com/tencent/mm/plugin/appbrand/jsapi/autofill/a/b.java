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
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "title", "", "content", "context", "Landroid/content/Context;", "minHeight", "", "maxHeight", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getMaxHeight", "()I", "getMinHeight", "rootView", "getTitle", "titleTv", "cancel", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class b
  implements k
{
  private final String content;
  private final Context context;
  private final TextView heO;
  private final View kFf;
  private final ImageView kFg;
  private final View kFh;
  private final m kFi;
  final d.g.a.b<String, z> kFj;
  final int maxHeight;
  final int minHeight;
  private final String title;
  private final TextView titleTv;
  
  public b(m paramm, String paramString1, String paramString2, Context paramContext, int paramInt1, int paramInt2, d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(50482);
    this.kFi = paramm;
    this.title = paramString1;
    this.content = paramString2;
    this.context = paramContext;
    this.minHeight = paramInt1;
    this.maxHeight = paramInt2;
    this.kFj = paramb;
    paramm = View.inflate(this.context, 2131493018, null);
    p.g(paramm, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.kFh = paramm;
    paramm = this.kFh.findViewById(2131303220);
    p.g(paramm, "rootView.findViewById(R.…e_number_explain_content)");
    this.kFf = paramm;
    this.kFf.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.kFf.setMinimumHeight(this.minHeight);
    this.kFf.addOnLayoutChangeListener((View.OnLayoutChangeListener)new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(50479);
        if ((Math.abs(paramAnonymousInt4 - paramAnonymousInt2) > this.kFk.maxHeight) && (this.kFk.maxHeight > this.kFk.minHeight)) {
          b.a(this.kFk).post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(50478);
              b.a(this.kFl.kFk).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.kFl.kFk.maxHeight));
              AppMethodBeat.o(50478);
            }
          });
        }
        AppMethodBeat.o(50479);
      }
    });
    paramm = this.kFh.findViewById(2131303221);
    p.g(paramm, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.kFg = ((ImageView)paramm);
    paramm = this.kFg;
    if (paramm != null) {
      paramm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(50480);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = b.b(this.kFk);
          if (paramAnonymousView != null) {
            paramAnonymousView.c((k)this.kFk);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(50480);
        }
      });
    }
    paramm = this.kFh.findViewById(2131303223);
    p.g(paramm, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramm);
    this.titleTv.setText((CharSequence)this.title);
    paramm = this.kFh.findViewById(2131303222);
    p.g(paramm, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.heO = ((TextView)paramm);
    this.heO.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void Pu(String paramAnonymousString)
      {
        AppMethodBeat.i(50481);
        d.g.a.b localb = this.kFk.kFj;
        p.g(paramAnonymousString, "url");
        localb.invoke(paramAnonymousString);
        AppMethodBeat.o(50481);
      }
    }));
    this.heO.setMovementMethod(LinkMovementMethod.getInstance());
    this.heO.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(50482);
  }
  
  public final void a(m paramm) {}
  
  public final boolean aOS()
  {
    return false;
  }
  
  public final boolean aOT()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss() {}
  
  public final View getContentView()
  {
    return this.kFh;
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
  
  public final void qB(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b
 * JD-Core Version:    0.7.0.1
 */