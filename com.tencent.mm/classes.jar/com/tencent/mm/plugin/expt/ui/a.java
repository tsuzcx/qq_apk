package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.um;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class a
  extends b
{
  View mxV;
  View pJQ;
  private c<um> pJR;
  TextView ss;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(190926);
    this.pJR = new c() {};
    ad.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.ESL.b(this.pJR);
    this.mxV = this.view.findViewById(2131297178);
    this.pJQ = this.view.findViewById(2131297182);
    this.ss = ((TextView)this.view.findViewById(2131302978));
    this.mxV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190921);
        paramAnonymousView = new f.a(aj.getContext());
        paramAnonymousView.aMo("cancel expt debug now!").wZ(true);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(190920);
            if (paramAnonymous2Boolean) {
              ((com.tencent.mm.plugin.expt.a.a)g.ab(com.tencent.mm.plugin.expt.a.a.class)).cbj();
            }
            AppMethodBeat.o(190920);
          }
        }).b(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymous2DialogInterface) {}
        }).show();
        AppMethodBeat.o(190921);
      }
    });
    if (com.tencent.mm.plugin.expt.b.a.cdS().cdT())
    {
      show();
      AppMethodBeat.o(190926);
      return;
    }
    close();
    AppMethodBeat.o(190926);
  }
  
  final void close()
  {
    AppMethodBeat.i(190928);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190923);
        ad.i("MicroMsg.ExptReportBanner", "expt report banner close");
        a.this.mxV.setVisibility(8);
        a.this.pJQ.setVisibility(8);
        AppMethodBeat.o(190923);
      }
    });
    AppMethodBeat.o(190928);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(190929);
    ad.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.ESL.d(this.pJR);
    AppMethodBeat.o(190929);
  }
  
  public final int getLayoutId()
  {
    return 2131493897;
  }
  
  final void show()
  {
    AppMethodBeat.i(190927);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190922);
        ad.i("MicroMsg.ExptReportBanner", "expt report banner show");
        a.this.ss.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.b.a.cdS().pIj);
        a.this.mxV.setVisibility(0);
        a.this.pJQ.setVisibility(0);
        AppMethodBeat.o(190922);
      }
    });
    AppMethodBeat.o(190927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.a
 * JD-Core Version:    0.7.0.1
 */