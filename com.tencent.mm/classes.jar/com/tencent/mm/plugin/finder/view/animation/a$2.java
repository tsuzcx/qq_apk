package com.tencent.mm.plugin.finder.view.animation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class a$2
  implements Runnable
{
  a$2(a parama, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(168650);
    Iterator localIterator = this.bUS.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      this.GGj.a(locala);
    }
    this.bUS.clear();
    this.GGj.bUL.remove(this.bUS);
    AppMethodBeat.o(168650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.2
 * JD-Core Version:    0.7.0.1
 */