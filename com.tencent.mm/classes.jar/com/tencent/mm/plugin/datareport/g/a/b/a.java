package com.tencent.mm.plugin.datareport.g.a.b;

import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.datareport.g.b;
import com.tencent.mm.plugin.datareport.j.c;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends com.tencent.mm.plugin.datareport.g.a.a
  implements b
{
  private com.tencent.mm.plugin.datareport.g.b.a xhB;
  private MMHandler xhD;
  
  public a()
  {
    AppMethodBeat.i(262941);
    this.xhD = c.a(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(262941);
  }
  
  public final void a(com.tencent.mm.plugin.datareport.g.b.a parama)
  {
    if (parama == null) {
      return;
    }
    this.xhB = parama;
  }
  
  public final void eT(View paramView)
  {
    AppMethodBeat.i(262987);
    if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (paramView == null))
    {
      AppMethodBeat.o(262987);
      return;
    }
    Log.d("ViewEventMonitor", "[onHellViewClick]");
    Message localMessage = this.xhD.obtainMessage(1007);
    localMessage.obj = com.tencent.mm.vending.j.a.U(paramView, Long.valueOf(System.currentTimeMillis()));
    this.xhD.sendMessage(localMessage);
    AppMethodBeat.o(262987);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(262970);
    Log.i("ViewEventMonitor", "[startMonitor]");
    e locale = (e)h.ax(e.class);
    if (locale != null) {
      locale.a(this);
    }
    AppMethodBeat.o(262970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.g.a.b.a
 * JD-Core Version:    0.7.0.1
 */