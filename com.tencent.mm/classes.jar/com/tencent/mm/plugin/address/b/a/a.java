package com.tencent.mm.plugin.address.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public com.tencent.mm.plugin.j.a.a iYw;
  
  public a()
  {
    AppMethodBeat.i(20762);
    this.iYw = new com.tencent.mm.plugin.j.a.a();
    AppMethodBeat.o(20762);
  }
  
  public final b qV(int paramInt)
  {
    AppMethodBeat.i(20763);
    Iterator localIterator = this.iYw.tGN.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.tGO == paramInt)
      {
        AppMethodBeat.o(20763);
        return localb;
      }
    }
    AppMethodBeat.o(20763);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.a.a
 * JD-Core Version:    0.7.0.1
 */