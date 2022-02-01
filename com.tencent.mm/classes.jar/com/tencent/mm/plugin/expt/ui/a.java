package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  View nFO;
  View rki;
  private c<vt> rkj;
  TextView vk;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196225);
    this.rkj = new c() {};
    ae.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IvT.b(this.rkj);
    this.nFO = this.view.findViewById(2131297178);
    this.rki = this.view.findViewById(2131297182);
    this.vk = ((TextView)this.view.findViewById(2131302978));
    this.nFO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196220);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/expt/ui/ExptReportBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new f.a(ak.getContext());
        paramAnonymousView.aZq("cancel expt debug now!").zi(true);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(196219);
            if (paramAnonymous2Boolean) {
              ((com.tencent.mm.plugin.expt.b.a)g.ab(com.tencent.mm.plugin.expt.b.a.class)).cor();
            }
            AppMethodBeat.o(196219);
          }
        }).b(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymous2DialogInterface) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptReportBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196220);
      }
    });
    if (com.tencent.mm.plugin.expt.e.a.csw().csx())
    {
      show();
      AppMethodBeat.o(196225);
      return;
    }
    close();
    AppMethodBeat.o(196225);
  }
  
  final void close()
  {
    AppMethodBeat.i(196227);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196222);
        ae.i("MicroMsg.ExptReportBanner", "expt report banner close");
        a.this.nFO.setVisibility(8);
        a.this.rki.setVisibility(8);
        AppMethodBeat.o(196222);
      }
    });
    AppMethodBeat.o(196227);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(196228);
    ae.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.IvT.d(this.rkj);
    AppMethodBeat.o(196228);
  }
  
  public final int getLayoutId()
  {
    return 2131493897;
  }
  
  final void show()
  {
    AppMethodBeat.i(196226);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196221);
        ae.i("MicroMsg.ExptReportBanner", "expt report banner show");
        a.this.vk.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.e.a.csw().rik);
        a.this.nFO.setVisibility(0);
        a.this.rki.setVisibility(0);
        AppMethodBeat.o(196221);
      }
    });
    AppMethodBeat.o(196226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.a
 * JD-Core Version:    0.7.0.1
 */