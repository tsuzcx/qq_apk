package androidx.compose.runtime.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.a.f;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e$c<T>
  implements ListIterator<T>, f
{
  private int index;
  private final List<T> list;
  
  public e$c(List<T> paramList, int paramInt)
  {
    AppMethodBeat.i(202009);
    this.list = paramList;
    this.index = paramInt;
    AppMethodBeat.o(202009);
  }
  
  public final void add(T paramT)
  {
    AppMethodBeat.i(202064);
    this.list.add(this.index, paramT);
    this.index += 1;
    AppMethodBeat.o(202064);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(202014);
    if (this.index < this.list.size())
    {
      AppMethodBeat.o(202014);
      return true;
    }
    AppMethodBeat.o(202014);
    return false;
  }
  
  public final boolean hasPrevious()
  {
    return this.index > 0;
  }
  
  public final T next()
  {
    AppMethodBeat.i(202022);
    Object localObject = this.list;
    int i = this.index;
    this.index = (i + 1);
    localObject = ((List)localObject).get(i);
    AppMethodBeat.o(202022);
    return localObject;
  }
  
  public final int nextIndex()
  {
    return this.index;
  }
  
  public final T previous()
  {
    AppMethodBeat.i(202046);
    this.index -= 1;
    Object localObject = this.list.get(this.index);
    AppMethodBeat.o(202046);
    return localObject;
  }
  
  public final int previousIndex()
  {
    return this.index - 1;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(202025);
    this.index -= 1;
    this.list.remove(this.index);
    AppMethodBeat.o(202025);
  }
  
  public final void set(T paramT)
  {
    AppMethodBeat.i(202075);
    this.list.set(this.index, paramT);
    AppMethodBeat.o(202075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.a.e.c
 * JD-Core Version:    0.7.0.1
 */