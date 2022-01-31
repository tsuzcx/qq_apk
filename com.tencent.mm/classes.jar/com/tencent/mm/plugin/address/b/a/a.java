package com.tencent.mm.plugin.address.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public com.tencent.mm.plugin.j.a.a gKJ;
  
  public a()
  {
    AppMethodBeat.i(16719);
    this.gKJ = new com.tencent.mm.plugin.j.a.a();
    AppMethodBeat.o(16719);
  }
  
  public final b mZ(int paramInt)
  {
    AppMethodBeat.i(16720);
    Iterator localIterator = this.gKJ.nLl.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.nLm == paramInt)
      {
        AppMethodBeat.o(16720);
        return localb;
      }
    }
    AppMethodBeat.o(16720);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.a.a
 * JD-Core Version:    0.7.0.1
 */