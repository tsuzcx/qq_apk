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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "title", "", "content", "context", "Landroid/content/Context;", "minHeight", "", "maxHeight", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getMaxHeight", "()I", "getMinHeight", "rootView", "getTitle", "titleTv", "cancel", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class b
  implements k
{
  private final String content;
  private final Context context;
  private final TextView hXC;
  private final View lJG;
  private final ImageView lJH;
  private final View lJI;
  private final m lJJ;
  final kotlin.g.a.b<String, x> lJK;
  final int maxHeight;
  final int minHeight;
  private final String title;
  private final TextView titleTv;
  
  public b(m paramm, String paramString1, String paramString2, Context paramContext, int paramInt1, int paramInt2, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(50482);
    this.lJJ = paramm;
    this.title = paramString1;
    this.content = paramString2;
    this.context = paramContext;
    this.minHeight = paramInt1;
    this.maxHeight = paramInt2;
    this.lJK = paramb;
    paramm = View.inflate(this.context, 2131493057, null);
    p.g(paramm, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.lJI = paramm;
    paramm = this.lJI.findViewById(2131305888);
    p.g(paramm, "rootView.findViewById(R.…e_number_explain_content)");
    this.lJG = paramm;
    this.lJG.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.lJG.setMinimumHeight(this.minHeight);
    this.lJG.addOnLayoutChangeListener((View.OnLayoutChangeListener)new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(50479);
        if ((Math.abs(paramAnonymousInt4 - paramAnonymousInt2) > this.lJL.maxHeight) && (this.lJL.maxHeight > this.lJL.minHeight)) {
          b.a(this.lJL).post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(50478);
              b.a(this.lJM.lJL).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.lJM.lJL.maxHeight));
              AppMethodBeat.o(50478);
            }
          });
        }
        AppMethodBeat.o(50479);
      }
    });
    paramm = this.lJI.findViewById(2131305889);
    p.g(paramm, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.lJH = ((ImageView)paramm);
    paramm = this.lJH;
    if (paramm != null) {
      paramm.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(50480);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = b.b(this.lJL);
          if (paramAnonymousView != null) {
            paramAnonymousView.c((k)this.lJL);
          }
          a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(50480);
        }
      });
    }
    paramm = this.lJI.findViewById(2131305891);
    p.g(paramm, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.titleTv = ((TextView)paramm);
    this.titleTv.setText((CharSequence)this.title);
    paramm = this.lJI.findViewById(2131305890);
    p.g(paramm, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.hXC = ((TextView)paramm);
    this.hXC.setText(c.a(this.content, false, (c.a)new c.a()
    {
      public final void YF(String paramAnonymousString)
      {
        AppMethodBeat.i(50481);
        kotlin.g.a.b localb = this.lJL.lJK;
        p.g(paramAnonymousString, "url");
        localb.invoke(paramAnonymousString);
        AppMethodBeat.o(50481);
      }
    }));
    this.hXC.setMovementMethod(LinkMovementMethod.getInstance());
    this.hXC.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(50482);
  }
  
  public final void a(m paramm) {}
  
  public final boolean bjb()
  {
    return false;
  }
  
  public final boolean bjc()
  {
    return true;
  }
  
  public final void cancel() {}
  
  public final void dismiss() {}
  
  public final View getContentView()
  {
    return this.lJI;
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
  
  public final void ut(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b
 * JD-Core Version:    0.7.0.1
 */