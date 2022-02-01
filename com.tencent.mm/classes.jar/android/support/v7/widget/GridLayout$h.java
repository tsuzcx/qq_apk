package android.support.v7.widget;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

final class GridLayout$h<K, V>
{
  public final int[] apt;
  public final K[] apu;
  public final V[] apv;
  
  GridLayout$h(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    this.apt = c(paramArrayOfK);
    this.apu = a(paramArrayOfK, this.apt);
    this.apv = a(paramArrayOfV, this.apt);
  }
  
  private static <K> K[] a(K[] paramArrayOfK, int[] paramArrayOfInt)
  {
    int j = paramArrayOfK.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfK.getClass().getComponentType(), GridLayout.j(paramArrayOfInt) + 1);
    int i = 0;
    while (i < j)
    {
      arrayOfObject[paramArrayOfInt[i]] = paramArrayOfK[i];
      i += 1;
    }
    return arrayOfObject;
  }
  
  private static <K> int[] c(K[] paramArrayOfK)
  {
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
    return arrayOfInt;
  }
  
  public final V bT(int paramInt)
  {
    return this.apv[this.apt[paramInt]];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.h
 * JD-Core Version:    0.7.0.1
 */