package androidx.transition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class Transition$b
{
  static <T> ArrayList<T> a(ArrayList<T> paramArrayList, T paramT)
  {
    AppMethodBeat.i(192564);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    if (!((ArrayList)localObject).contains(paramT)) {
      ((ArrayList)localObject).add(paramT);
    }
    AppMethodBeat.o(192564);
    return localObject;
  }
  
  static <T> ArrayList<T> b(ArrayList<T> paramArrayList, T paramT)
  {
    AppMethodBeat.i(192568);
    ArrayList<T> localArrayList = paramArrayList;
    if (paramArrayList != null)
    {
      paramArrayList.remove(paramT);
      localArrayList = paramArrayList;
      if (paramArrayList.isEmpty()) {
        localArrayList = null;
      }
    }
    AppMethodBeat.o(192568);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.Transition.b
 * JD-Core Version:    0.7.0.1
 */