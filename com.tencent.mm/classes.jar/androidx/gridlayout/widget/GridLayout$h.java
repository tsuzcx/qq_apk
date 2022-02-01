package androidx.gridlayout.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

final class GridLayout$h<K, V>
{
  public final int[] Zm;
  public final K[] Zn;
  public final V[] Zo;
  
  GridLayout$h(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    AppMethodBeat.i(255583);
    this.Zm = c(paramArrayOfK);
    this.Zn = a(paramArrayOfK, this.Zm);
    this.Zo = a(paramArrayOfV, this.Zm);
    AppMethodBeat.o(255583);
  }
  
  private static <K> K[] a(K[] paramArrayOfK, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(255587);
    int j = paramArrayOfK.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfK.getClass().getComponentType(), GridLayout.g(paramArrayOfInt) + 1);
    int i = 0;
    while (i < j)
    {
      arrayOfObject[paramArrayOfInt[i]] = paramArrayOfK[i];
      i += 1;
    }
    AppMethodBeat.o(255587);
    return arrayOfObject;
  }
  
  private static <K> int[] c(K[] paramArrayOfK)
  {
    AppMethodBeat.i(255586);
    int j = paramArrayOfK.length;
    int[] arrayOfInt = new int[j];
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < j)
    {
      K ? = paramArrayOfK[i];
      Integer localInteger2 = (Integer)localHashMap.get(?);
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null)
      {
        localInteger1 = Integer.valueOf(localHashMap.size());
        localHashMap.put(?, localInteger1);
      }
      arrayOfInt[i] = localInteger1.intValue();
      i += 1;
    }
    AppMethodBeat.o(255586);
    return arrayOfInt;
  }
  
  public final V ce(int paramInt)
  {
    return this.Zo[this.Zm[paramInt]];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.gridlayout.widget.GridLayout.h
 * JD-Core Version:    0.7.0.1
 */