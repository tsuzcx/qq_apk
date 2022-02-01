package android.support.transition;

import java.util.ArrayList;

final class Transition$b
{
  static <T> ArrayList<T> a(ArrayList<T> paramArrayList, T paramT)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    if (!((ArrayList)localObject).contains(paramT)) {
      ((ArrayList)localObject).add(paramT);
    }
    return localObject;
  }
  
  static <T> ArrayList<T> b(ArrayList<T> paramArrayList, T paramT)
  {
    ArrayList<T> localArrayList = paramArrayList;
    if (paramArrayList != null)
    {
      paramArrayList.remove(paramT);
      localArrayList = paramArrayList;
      if (paramArrayList.isEmpty()) {
        localArrayList = null;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.Transition.b
 * JD-Core Version:    0.7.0.1
 */