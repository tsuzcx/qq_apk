package com.tencent.mm.plugin.appbrand.ipc;

import java.util.Iterator;
import java.util.List;

final class MMToClientEvent$1
  implements Runnable
{
  MMToClientEvent$1(MMToClientEvent paramMMToClientEvent, List paramList) {}
  
  public final void run()
  {
    Iterator localIterator = this.gez.iterator();
    while (localIterator.hasNext()) {
      ((MMToClientEvent.c)localIterator.next()).aG(MMToClientEvent.a(this.geA));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.1
 * JD-Core Version:    0.7.0.1
 */