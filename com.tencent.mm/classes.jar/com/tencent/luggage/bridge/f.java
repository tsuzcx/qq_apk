package com.tencent.luggage.bridge;

import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private s bht;
  private LinkedList<e> bhu;
  private boolean bhv;
  
  f(s params)
  {
    this.bht = params;
    this.bhu = new LinkedList();
    this.bhv = false;
  }
  
  private void b(e parame)
  {
    this.bht.aX(String.format("luggageBridge._processMessageFromJava(%s);", new Object[] { parame.toString() }));
  }
  
  /* Error */
  public final void a(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/luggage/bridge/f:bhv	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 51	com/tencent/luggage/bridge/f:b	(Lcom/tencent/luggage/bridge/e;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 23	com/tencent/luggage/bridge/f:bhu	Ljava/util/LinkedList;
    //   21: aload_1
    //   22: invokevirtual 55	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: goto -12 -> 14
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	f
    //   0	34	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
    //   17	26	29	finally
  }
  
  final void pP()
  {
    try
    {
      this.bhv = true;
      Iterator localIterator = this.bhu.iterator();
      while (localIterator.hasNext()) {
        b((e)localIterator.next());
      }
      this.bhu.clear();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.bridge.f
 * JD-Core Version:    0.7.0.1
 */