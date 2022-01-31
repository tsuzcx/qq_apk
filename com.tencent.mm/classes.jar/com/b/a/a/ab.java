package com.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab
  extends c
{
  private static ab bsH;
  WifiManager bmz;
  private final BroadcastReceiver bsI;
  private final IntentFilter bsJ;
  private ac bsK;
  private long bsL;
  
  private ab()
  {
    AppMethodBeat.i(55585);
    this.bsI = new ab.1(this);
    this.bsJ = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    this.bsL = 10000L;
    AppMethodBeat.o(55585);
  }
  
  private boolean isAvailable()
  {
    return this.bmz != null;
  }
  
  static ab tL()
  {
    AppMethodBeat.i(55586);
    if (bsH == null) {
      bsH = new ab();
    }
    ab localab = bsH;
    AppMethodBeat.o(55586);
    return localab;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(55589);
    if (!isAvailable())
    {
      AppMethodBeat.o(55589);
      return;
    }
    paramContext.registerReceiver(this.bsI, this.bsJ, null, paramHandler);
    this.bsL = parama.bmu;
    parama = this.bmz;
    if (paramHandler != null) {}
    for (;;)
    {
      this.bsK = new ac(parama, paramHandler);
      this.bsK.p(this.bsL, 0L);
      AppMethodBeat.o(55589);
      return;
      paramHandler = new Handler(paramContext.getMainLooper());
    }
  }
  
  /* Error */
  final void a(Handler paramHandler, d.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 103
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnull +17 -> 25
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 105	com/b/a/a/c:a	(Landroid/os/Handler;Lcom/b/a/a/d$a;)V
    //   17: ldc 103
    //   19: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: new 76	com/b/a/a/d$a
    //   28: dup
    //   29: ldc2_w 46
    //   32: invokespecial 108	com/b/a/a/d$a:<init>	(J)V
    //   35: astore_2
    //   36: goto -25 -> 11
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ab
    //   0	44	1	paramHandler	Handler
    //   0	44	2	parama	d.a
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   11	22	39	finally
    //   25	36	39	finally
  }
  
  final void al(Context paramContext)
  {
    AppMethodBeat.i(55588);
    this.bmz = ((WifiManager)paramContext.getSystemService("wifi"));
    AppMethodBeat.o(55588);
  }
  
  final void am(Context paramContext)
  {
    AppMethodBeat.i(55590);
    if (!isAvailable())
    {
      AppMethodBeat.o(55590);
      return;
    }
    paramContext.unregisterReceiver(this.bsI);
    this.bsK.stop();
    AppMethodBeat.o(55590);
  }
  
  final void td() {}
  
  final void te()
  {
    AppMethodBeat.i(55591);
    if ((!isAvailable()) || (!this.isRunning) || (this.bsL >= 90000L))
    {
      AppMethodBeat.o(55591);
      return;
    }
    this.bsK.p(90000L, 0L);
    AppMethodBeat.o(55591);
  }
  
  final void tf()
  {
    AppMethodBeat.i(55592);
    if ((!isAvailable()) || (!this.isRunning) || (this.bsL >= 90000L))
    {
      AppMethodBeat.o(55592);
      return;
    }
    this.bsK.p(this.bsL, 0L);
    AppMethodBeat.o(55592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.ab
 * JD-Core Version:    0.7.0.1
 */