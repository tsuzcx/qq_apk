package androidx.compose.ui.e.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/Stack;", "T", "", "backing", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "constructor-impl", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "size", "", "getSize-impl", "(Ljava/util/ArrayList;)I", "clear", "", "clear-impl", "(Ljava/util/ArrayList;)V", "equals", "", "other", "equals-impl", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "(Ljava/util/ArrayList;)Z", "isNotEmpty", "isNotEmpty-impl", "peek", "peek-impl", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "pop", "pop-impl", "push", "value", "push-impl", "toString", "", "toString-impl", "(Ljava/util/ArrayList;)Ljava/lang/String;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h<T>
{
  public static final int b(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(206395);
    s.u(paramArrayList, "arg0");
    int i = paramArrayList.size();
    AppMethodBeat.o(206395);
    return i;
  }
  
  public static final boolean b(ArrayList<T> paramArrayList, T paramT)
  {
    AppMethodBeat.i(206400);
    s.u(paramArrayList, "arg0");
    boolean bool = paramArrayList.add(paramT);
    AppMethodBeat.o(206400);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.ui.e.d.h
 * JD-Core Version:    0.7.0.1
 */