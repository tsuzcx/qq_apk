package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class m$9
  implements Runnable
{
  public m$9(m paramm, z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(144049);
    Iterator localIterator = this.dpX.dpS.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if ((localo instanceof q)) {
        ((q)localo).dqt = this.dqc;
      }
    }
    AppMethodBeat.o(144049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.m.9
 * JD-Core Version:    0.7.0.1
 */