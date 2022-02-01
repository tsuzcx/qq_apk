package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

public final class a
  extends b
{
  View mZW;
  View qsx;
  private c<uw> qsy;
  TextView tr;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195323);
    this.qsy = new c() {};
    ac.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.GpY.b(this.qsy);
    this.mZW = this.view.findViewById(2131297178);
    this.qsx = this.view.findViewById(2131297182);
    this.tr = ((TextView)this.view.findViewById(2131302978));
    this.mZW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195318);
        paramAnonymousView = new f.a(ai.getContext());
        paramAnonymousView.aRQ("cancel expt debug now!").yi(true);
        paramAnonymousView.c(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(195317);
            if (paramAnonymous2Boolean) {
              ((com.tencent.mm.plugin.expt.a.a)g.ab(com.tencent.mm.plugin.expt.a.a.class)).cis();
            }
            AppMethodBeat.o(195317);
          }
        }).b(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymous2DialogInterface) {}
        }).show();
        AppMethodBeat.o(195318);
      }
    });
    if (com.tencent.mm.plugin.expt.b.a.clz().clA())
    {
      show();
      AppMethodBeat.o(195323);
      return;
    }
    close();
    AppMethodBeat.o(195323);
  }
  
  final void close()
  {
    AppMethodBeat.i(195325);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195320);
        ac.i("MicroMsg.ExptReportBanner", "expt report banner close");
        a.this.mZW.setVisibility(8);
        a.this.qsx.setVisibility(8);
        AppMethodBeat.o(195320);
      }
    });
    AppMethodBeat.o(195325);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(195326);
    ac.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.GpY.d(this.qsy);
    AppMethodBeat.o(195326);
  }
  
  public final int getLayoutId()
  {
    return 2131493897;
  }
  
  final void show()
  {
    AppMethodBeat.i(195324);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195319);
        ac.i("MicroMsg.ExptReportBanner", "expt report banner show");
        a.this.tr.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.b.a.clz().qqQ);
        a.this.mZW.setVisibility(0);
        a.this.qsx.setVisibility(0);
        AppMethodBeat.o(195319);
      }
    });
    AppMethodBeat.o(195324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.a
 * JD-Core Version:    0.7.0.1
 */