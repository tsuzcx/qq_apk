package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private s bZk;
  private LinkedList<e> bZl;
  private boolean bZm;
  
  f(s params)
  {
    AppMethodBeat.i(140319);
    this.bZk = params;
    this.bZl = new LinkedList();
    this.bZm = false;
    AppMethodBeat.o(140319);
  }
  
  private void b(e parame)
  {
    AppMethodBeat.i(140321);
    this.bZk.bO(String.format("luggageBridge._processMessageFromJava(%s);", new Object[] { parame.toString() }));
    AppMethodBeat.o(140321);
  }
  
  final void AH()
  {
    try
    {
      AppMethodBeat.i(140322);
      ad.i("Java2JsMessageQueue", "ready");
      this.bZm = true;
      Iterator localIterator = this.bZl.iterator();
      while (localIterator.hasNext()) {
        b((e)localIterator.next());
      }
      this.bZl.clear();
    }
    finally {}
    AppMethodBeat.o(140322);
  }
  
  /* Error */
  public final void a(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 91
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 32	com/tencent/luggage/bridge/f:bZm	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 86	com/tencent/luggage/bridge/f:b	(Lcom/tencent/luggage/bridge/e;)V
    //   19: ldc 91
    //   21: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 30	com/tencent/luggage/bridge/f:bZl	Ljava/util/LinkedList;
    //   31: aload_1
    //   32: invokevirtual 95	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   35: pop
    //   36: ldc 91
    //   38: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -17 -> 24
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	f
    //   0	49	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	24	44	finally
    //   27	41	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.f
 * JD-Core Version:    0.7.0.1
 */