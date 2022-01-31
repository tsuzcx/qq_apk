package com.tencent.mm.plugin.appbrand.debugger;

import java.util.LinkedList;

final class n$3
  implements Runnable
{
  n$3(n paramn) {}
  
  public final void run()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (n.a(this.fSL).mLock)
    {
      localLinkedList.addAll(n.b(this.fSL));
      n.b(this.fSL).clear();
      n.c(this.fSL);
      n.a(this.fSL, localLinkedList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.n.3
 * JD-Core Version:    0.7.0.1
 */