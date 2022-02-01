package com.tencent.mm.plugin.expt.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  extends b
{
  View oQL;
  View sLO;
  private IListener<wt> sLP;
  TextView vr;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(220666);
    this.sLP = new IListener() {};
    Log.i("MicroMsg.ExptReportBanner", "expt report banner initialize %d", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.add(this.sLP);
    this.oQL = this.view.findViewById(2131297322);
    this.sLO = this.view.findViewById(2131297326);
    this.vr = ((TextView)this.view.findViewById(2131305567));
    this.oQL.setOnClickListener(new a.1(this));
    if (com.tencent.mm.plugin.expt.e.a.cRf().cRg())
    {
      show();
      AppMethodBeat.o(220666);
      return;
    }
    close();
    AppMethodBeat.o(220666);
  }
  
  final void close()
  {
    AppMethodBeat.i(220668);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220663);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner close");
        a.this.oQL.setVisibility(8);
        a.this.sLO.setVisibility(8);
        AppMethodBeat.o(220663);
      }
    });
    AppMethodBeat.o(220668);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(220669);
    Log.i("MicroMsg.ExptReportBanner", "expt report banner destroy %d", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.removeListener(this.sLP);
    AppMethodBeat.o(220669);
  }
  
  public final int getLayoutId()
  {
    return 2131494052;
  }
  
  final void show()
  {
    AppMethodBeat.i(220667);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220662);
        Log.i("MicroMsg.ExptReportBanner", "expt report banner show");
        a.this.vr.setText("expt debug now!!! key=" + com.tencent.mm.plugin.expt.e.a.cRf().sJO);
        a.this.oQL.setVisibility(0);
        a.this.sLO.setVisibility(0);
        AppMethodBeat.o(220662);
      }
    });
    AppMethodBeat.o(220667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.a
 * JD-Core Version:    0.7.0.1
 */