package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/Stack;", "T", "", "()V", "backing", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "size", "", "getSize", "()I", "clear", "", "isEmpty", "", "isNotEmpty", "peek", "()Ljava/lang/Object;", "index", "(I)Ljava/lang/Object;", "pop", "push", "value", "(Ljava/lang/Object;)Z", "toArray", "", "()[Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bl<T>
{
  final ArrayList<T> aqh;
  
  public bl()
  {
    AppMethodBeat.i(201986);
    this.aqh = new ArrayList();
    AppMethodBeat.o(201986);
  }
  
  public final boolean U(T paramT)
  {
    AppMethodBeat.i(201989);
    boolean bool = this.aqh.add(paramT);
    AppMethodBeat.o(201989);
    return bool;
  }
  
  public final T peek()
  {
    AppMethodBeat.i(201999);
    Object localObject = this.aqh.get(this.aqh.size() - 1);
    AppMethodBeat.o(201999);
    return localObject;
  }
  
  public final T pop()
  {
    AppMethodBeat.i(201993);
    Object localObject = this.aqh.remove(this.aqh.size() - 1);
    AppMethodBeat.o(201993);
    return localObject;
  }
  
  public final boolean qn()
  {
    AppMethodBeat.i(202002);
    if (!this.aqh.isEmpty())
    {
      AppMethodBeat.o(202002);
      return true;
    }
    AppMethodBeat.o(202002);
    return false;
  }
  
  public final T[] toArray()
  {
    AppMethodBeat.i(202006);
    int i = 0;
    int j = this.aqh.size();
    Object[] arrayOfObject = new Object[j];
    while (i < j)
    {
      arrayOfObject[i] = this.aqh.get(i);
      i += 1;
    }
    AppMethodBeat.o(202006);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bl
 * JD-Core Version:    0.7.0.1
 */