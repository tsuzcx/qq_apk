package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class b$r
{
  List<b.s> aPn = null;
  int aPo = 0;
  
  final b.s du(int paramInt)
  {
    AppMethodBeat.i(206437);
    b.s locals = (b.s)this.aPn.get(paramInt);
    AppMethodBeat.o(206437);
    return locals;
  }
  
  final boolean isEmpty()
  {
    AppMethodBeat.i(206438);
    if ((this.aPn == null) || (this.aPn.isEmpty()))
    {
      AppMethodBeat.o(206438);
      return true;
    }
    AppMethodBeat.o(206438);
    return false;
  }
  
  final void qF()
  {
    this.aPo += 1000;
  }
  
  final int size()
  {
    AppMethodBeat.i(206436);
    if (this.aPn == null)
    {
      AppMethodBeat.o(206436);
      return 0;
    }
    int i = this.aPn.size();
    AppMethodBeat.o(206436);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206439);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.aPn.iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((b.s)localIterator.next()).append(' ');
    }
    localObject = '[' + this.aPo + ']';
    AppMethodBeat.o(206439);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.b.r
 * JD-Core Version:    0.7.0.1
 */