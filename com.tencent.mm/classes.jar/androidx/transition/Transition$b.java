package androidx.transition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class Transition$b
{
  static <T> ArrayList<T> c(ArrayList<T> paramArrayList, T paramT)
  {
    AppMethodBeat.i(201428);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    if (!((ArrayList)localObject).contains(paramT)) {
      ((ArrayList)localObject).add(paramT);
    }
    AppMethodBeat.o(201428);
    return localObject;
  }
  
  static <T> ArrayList<T> d(ArrayList<T> paramArrayList, T paramT)
  {
    AppMethodBeat.i(201436);
    ArrayList<T> localArrayList = paramArrayList;
    if (paramArrayList != null)
    {
      paramArrayList.remove(paramT);
      localArrayList = paramArrayList;
      if (paramArrayList.isEmpty()) {
        localArrayList = null;
      }
    }
    AppMethodBeat.o(201436);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.Transition.b
 * JD-Core Version:    0.7.0.1
 */