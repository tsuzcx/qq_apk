package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  View nAt;
  View rcc;
  private c<vp> rcd;
  TextView vk;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(210558);
    this.rcd = new c() {};
    ad.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IbL.b(this.rcd);
    this.nAt = this.view.findViewById(2131297178);
    this.rcc = this.view.findViewById(2131297182);
    this.vk = ((TextView)this.view.findViewById(2131302978));
    this.nAt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210553);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptReportBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new f.a(aj.getContext());
        paramAnonymousView.aXO("cancel expt debug now!").yU(true);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(210552);
            if (paramAnonymous2Boolean) {
              ((com.tencent.mm.plugin.expt.b.a)g.ab(com.tencent.mm.plugin.expt.b.a.class)).cnb();
            }
            AppMethodBeat.o(210552);
          }
        }).b(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymous2DialogInterface) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptReportBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210553);
      }
    });
    if (com.tencent.mm.plugin.expt.e.a.cqU().cqV())
    {
      show();
      AppMethodBeat.o(210558);
      return;
    }
    close();
    AppMethodBeat.o(210558);
  }
  
  final void close()
  {
    AppMethodBeat.i(210560);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210555);
        ad.i("MicroMsg.ExptReportBanner", "expt report banner close");
        a.this.nAt.setVisibility(8);
        a.this.rcc.setVisibility(8);
        AppMethodBeat.o(210555);
      }
    });
    AppMethodBeat.o(210560);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(210561);
    ad.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IbL.d(this.rcd);
    AppMethodBeat.o(210561);
  }
  
  public final int getLayoutId()
  {
    return 2131493897;
  }
  
  final void show()
  {
    AppMethodBeat.i(210559);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210554);
        ad.i("MicroMsg.ExptReportBanner", "expt report banner show");
        a.this.vk.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.e.a.cqU().rae);
        a.this.nAt.setVisibility(0);
        a.this.rcc.setVisibility(0);
        AppMethodBeat.o(210554);
      }
    });
    AppMethodBeat.o(210559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.a
 * JD-Core Version:    0.7.0.1
 */