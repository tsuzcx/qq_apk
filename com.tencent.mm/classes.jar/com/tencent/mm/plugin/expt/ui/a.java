package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.zs;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  extends b
{
  TextView dyR;
  View vdX;
  View zNP;
  private IListener<zs> zNQ;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(299606);
    this.zNQ = new ExptReportBanner.4(this, f.hfK);
    Log.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", new Object[] { Integer.valueOf(hashCode()) });
    this.zNQ.alive();
    this.vdX = this.view.findViewById(b.c.banner);
    this.zNP = this.view.findViewById(b.c.banner_line);
    this.dyR = ((TextView)this.view.findViewById(b.c.nw_btn));
    this.vdX.setOnClickListener(new a.1(this));
    if (com.tencent.mm.plugin.expt.kvdebug.a.dMK().dML())
    {
      show();
      AppMethodBeat.o(299606);
      return;
    }
    close();
    AppMethodBeat.o(299606);
  }
  
  final void close()
  {
    AppMethodBeat.i(299619);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299615);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner close");
        a.this.vdX.setVisibility(8);
        a.this.zNP.setVisibility(8);
        AppMethodBeat.o(299615);
      }
    });
    AppMethodBeat.o(299619);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(299625);
    Log.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", new Object[] { Integer.valueOf(hashCode()) });
    this.zNQ.dead();
    AppMethodBeat.o(299625);
  }
  
  public final int getLayoutId()
  {
    return b.d.expt_report_banner;
  }
  
  final void show()
  {
    AppMethodBeat.i(299614);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299610);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner show");
        a.this.dyR.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.kvdebug.a.dMK().zLP);
        a.this.vdX.setVisibility(0);
        a.this.zNP.setVisibility(0);
        AppMethodBeat.o(299610);
      }
    });
    AppMethodBeat.o(299614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.a
 * JD-Core Version:    0.7.0.1
 */