package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

final class f
{
  private s eio;
  private LinkedList<e> eip;
  private boolean eiq;
  
  f(s params)
  {
    AppMethodBeat.i(140319);
    this.eio = params;
    this.eip = new LinkedList();
    this.eiq = false;
    AppMethodBeat.o(140319);
  }
  
  private void b(e parame)
  {
    AppMethodBeat.i(140321);
    this.eio.evaluateJavascript(String.format("if(typeof luggageBridge !== 'undefined') luggageBridge._processMessageFromJava(%s);", new Object[] { parame.toString() }), null);
    AppMethodBeat.o(140321);
  }
  
  /* Error */
  final void a(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 61
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 32	com/tencent/luggage/bridge/f:eiq	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 63	com/tencent/luggage/bridge/f:b	(Lcom/tencent/luggage/bridge/e;)V
    //   19: ldc 61
    //   21: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 30	com/tencent/luggage/bridge/f:eip	Ljava/util/LinkedList;
    //   31: aload_1
    //   32: invokevirtual 67	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   35: pop
    //   36: ldc 61
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
  
  final void ready()
  {
    try
    {
      AppMethodBeat.i(140322);
      Log.i("Java2JsMessageQueue", "ready");
      this.eiq = true;
      Iterator localIterator = this.eip.iterator();
      while (localIterator.hasNext()) {
        b((e)localIterator.next());
      }
      this.eip.clear();
    }
    finally {}
    AppMethodBeat.o(140322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.f
 * JD-Core Version:    0.7.0.1
 */