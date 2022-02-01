package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.a.f;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/StateListIterator;", "T", "", "list", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;I)V", "index", "getList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "modification", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "validateModification", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class v<T>
  implements ListIterator<T>, f
{
  private int asY;
  private final r<T> ato;
  private int index;
  
  public v(r<T> paramr, int paramInt)
  {
    AppMethodBeat.i(202471);
    this.ato = paramr;
    this.index = (paramInt - 1);
    this.asY = this.ato.rL();
    AppMethodBeat.o(202471);
  }
  
  private final void rP()
  {
    AppMethodBeat.i(202477);
    if (this.ato.rL() != this.asY)
    {
      ConcurrentModificationException localConcurrentModificationException = new ConcurrentModificationException();
      AppMethodBeat.o(202477);
      throw localConcurrentModificationException;
    }
    AppMethodBeat.o(202477);
  }
  
  public final void add(T paramT)
  {
    AppMethodBeat.i(202515);
    rP();
    this.ato.add(this.index + 1, paramT);
    this.index += 1;
    this.asY = this.ato.rL();
    AppMethodBeat.o(202515);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(202525);
    if (this.index < this.ato.size() - 1)
    {
      AppMethodBeat.o(202525);
      return true;
    }
    AppMethodBeat.o(202525);
    return false;
  }
  
  public final boolean hasPrevious()
  {
    return this.index >= 0;
  }
  
  public final T next()
  {
    AppMethodBeat.i(202537);
    rP();
    int i = this.index + 1;
    s.X(i, this.ato.size());
    Object localObject = this.ato.get(i);
    this.index = i;
    AppMethodBeat.o(202537);
    return localObject;
  }
  
  public final int nextIndex()
  {
    return this.index + 1;
  }
  
  public final T previous()
  {
    AppMethodBeat.i(202498);
    rP();
    s.X(this.index, this.ato.size());
    Object localObject = this.ato.get(this.index);
    this.index -= 1;
    AppMethodBeat.o(202498);
    return localObject;
  }
  
  public final int previousIndex()
  {
    return this.index;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(202551);
    rP();
    this.ato.remove(this.index);
    this.index -= 1;
    this.asY = this.ato.rL();
    AppMethodBeat.o(202551);
  }
  
  public final void set(T paramT)
  {
    AppMethodBeat.i(202569);
    rP();
    this.ato.set(this.index, paramT);
    this.asY = this.ato.rL();
    AppMethodBeat.o(202569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.v
 * JD-Core Version:    0.7.0.1
 */