package androidx.activity.result;

import androidx.lifecycle.j;
import androidx.lifecycle.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class c$b
{
  final j ez;
  private final ArrayList<o> mObservers;
  
  c$b(j paramj)
  {
    AppMethodBeat.i(199228);
    this.ez = paramj;
    this.mObservers = new ArrayList();
    AppMethodBeat.o(199228);
  }
  
  final void a(o paramo)
  {
    AppMethodBeat.i(199237);
    this.ez.addObserver(paramo);
    this.mObservers.add(paramo);
    AppMethodBeat.o(199237);
  }
  
  final void bo()
  {
    AppMethodBeat.i(199241);
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      this.ez.removeObserver(localo);
    }
    this.mObservers.clear();
    AppMethodBeat.o(199241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.activity.result.c.b
 * JD-Core Version:    0.7.0.1
 */