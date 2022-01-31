package a.a;

import a.d.b.g;
import java.util.Arrays;
import java.util.List;

public class d
  extends c
{
  public static final <T> List<T> asList(T[] paramArrayOfT)
  {
    g.k(paramArrayOfT, "$receiver");
    paramArrayOfT = Arrays.asList(paramArrayOfT);
    g.j(paramArrayOfT, "ArraysUtilJVM.asList(this)");
    return paramArrayOfT;
  }
  
  public static final int i(int[] paramArrayOfInt, int paramInt)
  {
    g.k(paramArrayOfInt, "$receiver");
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      if (paramInt == paramArrayOfInt[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.a.d
 * JD-Core Version:    0.7.0.1
 */