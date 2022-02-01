package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$q
{
  List<b.o> aPm = null;
  
  final void a(b.o paramo)
  {
    AppMethodBeat.i(206433);
    if (this.aPm == null) {
      this.aPm = new ArrayList();
    }
    int i = 0;
    while (i < this.aPm.size())
    {
      if (((b.o)this.aPm.get(i)).aPj.aPo > paramo.aPj.aPo)
      {
        this.aPm.add(i, paramo);
        AppMethodBeat.o(206433);
        return;
      }
      i += 1;
    }
    this.aPm.add(paramo);
    AppMethodBeat.o(206433);
  }
  
  final void a(q paramq)
  {
    AppMethodBeat.i(206434);
    if (paramq.aPm == null)
    {
      AppMethodBeat.o(206434);
      return;
    }
    if (this.aPm == null) {
      this.aPm = new ArrayList(paramq.aPm.size());
    }
    paramq = paramq.aPm.iterator();
    while (paramq.hasNext()) {
      a((b.o)paramq.next());
    }
    AppMethodBeat.o(206434);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206435);
    if (this.aPm == null)
    {
      AppMethodBeat.o(206435);
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = this.aPm.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((b.o)localIterator.next()).toString()).append('\n');
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(206435);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.b.q
 * JD-Core Version:    0.7.0.1
 */