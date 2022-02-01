package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class b$r
{
  List<b.s> aPu = null;
  int aPv = 0;
  
  final b.s dz(int paramInt)
  {
    AppMethodBeat.i(212941);
    b.s locals = (b.s)this.aPu.get(paramInt);
    AppMethodBeat.o(212941);
    return locals;
  }
  
  final boolean isEmpty()
  {
    AppMethodBeat.i(212942);
    if ((this.aPu == null) || (this.aPu.isEmpty()))
    {
      AppMethodBeat.o(212942);
      return true;
    }
    AppMethodBeat.o(212942);
    return false;
  }
  
  final void qC()
  {
    this.aPv += 1000;
  }
  
  final int size()
  {
    AppMethodBeat.i(212940);
    if (this.aPu == null)
    {
      AppMethodBeat.o(212940);
      return 0;
    }
    int i = this.aPu.size();
    AppMethodBeat.o(212940);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212943);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.aPu.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((b.s)localIterator.next()).append(' ');
    }
    localObject = '[' + this.aPv + ']';
    AppMethodBeat.o(212943);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.b.r
 * JD-Core Version:    0.7.0.1
 */