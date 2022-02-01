package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xz;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  extends b
{
  TextView bFR;
  View rSI;
  View wrJ;
  private IListener<xz> wrK;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251940);
    this.wrK = new IListener() {};
    Log.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.add(this.wrK);
    this.rSI = this.view.findViewById(b.c.banner);
    this.wrJ = this.view.findViewById(b.c.banner_line);
    this.bFR = ((TextView)this.view.findViewById(b.c.nw_btn));
    this.rSI.setOnClickListener(new a.1(this));
    if (com.tencent.mm.plugin.expt.e.a.dga().dgb())
    {
      show();
      AppMethodBeat.o(251940);
      return;
    }
    close();
    AppMethodBeat.o(251940);
  }
  
  final void close()
  {
    AppMethodBeat.i(251943);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256930);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner close");
        a.this.rSI.setVisibility(8);
        a.this.wrJ.setVisibility(8);
        AppMethodBeat.o(256930);
      }
    });
    AppMethodBeat.o(251943);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(251945);
    Log.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.removeListener(this.wrK);
    AppMethodBeat.o(251945);
  }
  
  public final int getLayoutId()
  {
    return b.d.expt_report_banner;
  }
  
  final void show()
  {
    AppMethodBeat.i(251941);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258269);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner show");
        a.this.bFR.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.e.a.dga().wpM);
        a.this.rSI.setVisibility(0);
        a.this.wrJ.setVisibility(0);
        AppMethodBeat.o(258269);
      }
    });
    AppMethodBeat.o(251941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.a
 * JD-Core Version:    0.7.0.1
 */