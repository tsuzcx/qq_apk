package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$q
{
  List<b.o> aPt = null;
  
  final void a(b.o paramo)
  {
    AppMethodBeat.i(212937);
    if (this.aPt == null) {
      this.aPt = new ArrayList();
    }
    int i = 0;
    while (i < this.aPt.size())
    {
      if (((b.o)this.aPt.get(i)).aPq.aPv > paramo.aPq.aPv)
      {
        this.aPt.add(i, paramo);
        AppMethodBeat.o(212937);
        return;
      }
      i += 1;
    }
    this.aPt.add(paramo);
    AppMethodBeat.o(212937);
  }
  
  final void a(q paramq)
  {
    AppMethodBeat.i(212938);
    if (paramq.aPt == null)
    {
      AppMethodBeat.o(212938);
      return;
    }
    if (this.aPt == null) {
      this.aPt = new ArrayList(paramq.aPt.size());
    }
    paramq = paramq.aPt.iterator();
    while (paramq.hasNext()) {
      a((b.o)paramq.next());
    }
    AppMethodBeat.o(212938);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212939);
    if (this.aPt == null)
    {
      AppMethodBeat.o(212939);
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = this.aPt.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((b.o)localIterator.next()).toString()).append('\n');
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(212939);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.b.q
 * JD-Core Version:    0.7.0.1
 */