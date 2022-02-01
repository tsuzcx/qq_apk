package com.c.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ab
  extends c
{
  private static ab bSK;
  WifiManager bMH;
  private final BroadcastReceiver bSL;
  private final IntentFilter bSM;
  private ac bSN;
  private long bSO;
  
  private ab()
  {
    AppMethodBeat.i(87930);
    this.bSL = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(87929);
        if (paramAnonymousIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"))
        {
          paramAnonymousContext = ab.this;
          try
          {
            paramAnonymousIntent = paramAnonymousContext.bMH.getScanResults();
            if ((paramAnonymousIntent != null) && (!paramAnonymousIntent.isEmpty())) {
              break label67;
            }
            paramAnonymousContext = new Exception("WifiScanMsg: null or empty scan result list");
            AppMethodBeat.o(87929);
            throw paramAnonymousContext;
          }
          catch (Exception paramAnonymousContext) {}
        }
        else
        {
          AppMethodBeat.o(87929);
          return;
        }
        label67:
        paramAnonymousContext.c(new ab.a(paramAnonymousIntent));
        AppMethodBeat.o(87929);
      }
    };
    this.bSM = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    this.bSO = 10000L;
    AppMethodBeat.o(87930);
  }
  
  private boolean isAvailable()
  {
    return this.bMH != null;
  }
  
  static ab zm()
  {
    AppMethodBeat.i(87931);
    if (bSK == null) {
      bSK = new ab();
    }
    ab localab = bSK;
    AppMethodBeat.o(87931);
    return localab;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    AppMethodBeat.i(87934);
    if (!isAvailable())
    {
      AppMethodBeat.o(87934);
      return;
    }
    paramContext.registerReceiver(this.bSL, this.bSM, null, paramHandler);
    this.bSO = parama.bMC;
    parama = this.bMH;
    if (paramHandler != null) {}
    for (;;)
    {
      this.bSN = new ac(parama, paramHandler);
      this.bSN.n(this.bSO, 0L);
      AppMethodBeat.o(87934);
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
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnull +17 -> 25
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 105	com/c/a/a/c:a	(Landroid/os/Handler;Lcom/c/a/a/d$a;)V
    //   17: ldc 103
    //   19: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: new 76	com/c/a/a/d$a
    //   28: dup
    //   29: ldc2_w 47
    //   32: invokespecial 108	com/c/a/a/d$a:<init>	(J)V
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
  
  final void as(Context paramContext)
  {
    AppMethodBeat.i(87933);
    this.bMH = ((WifiManager)paramContext.getSystemService("wifi"));
    AppMethodBeat.o(87933);
  }
  
  final void at(Context paramContext)
  {
    AppMethodBeat.i(87935);
    if (!isAvailable())
    {
      AppMethodBeat.o(87935);
      return;
    }
    paramContext.unregisterReceiver(this.bSL);
    this.bSN.stop();
    AppMethodBeat.o(87935);
  }
  
  final void yE() {}
  
  final void yF()
  {
    AppMethodBeat.i(87936);
    if ((!isAvailable()) || (!this.isRunning) || (this.bSO >= 90000L))
    {
      AppMethodBeat.o(87936);
      return;
    }
    this.bSN.n(90000L, 0L);
    AppMethodBeat.o(87936);
  }
  
  final void yG()
  {
    AppMethodBeat.i(87937);
    if ((!isAvailable()) || (!this.isRunning) || (this.bSO >= 90000L))
    {
      AppMethodBeat.o(87937);
      return;
    }
    this.bSN.n(this.bSO, 0L);
    AppMethodBeat.o(87937);
  }
  
  static final class a
    extends p
  {
    final List<ScanResult> bSQ;
    
    a(List<ScanResult> paramList)
    {
      super();
      this.bSQ = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.ab
 * JD-Core Version:    0.7.0.1
 */