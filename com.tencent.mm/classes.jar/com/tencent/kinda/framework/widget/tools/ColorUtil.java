package com.tencent.kinda.framework.widget.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class ColorUtil
{
  public static long MergeColors(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(145147);
    long l1 = paramLong1;
    if (paramLong1 < 0L) {
      l1 = absColor(paramLong1);
    }
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = absColor(paramLong2);
    }
    long l2 = getRed(l1);
    paramLong2 = getGreen(l1);
    l1 = getBlue(l1);
    long l4 = getAlpha(paramLong1);
    long l5 = getRed(paramLong1);
    long l3 = getGreen(paramLong1);
    paramLong1 = getBlue(paramLong1);
    double d1 = (float)l4 / 255.0F;
    double d2 = l5;
    l2 = (l2 * (1.0D - d1) + d2 * d1);
    d2 = l3;
    paramLong2 = (paramLong2 * (1.0D - d1) + d2 * d1);
    d2 = paramLong1;
    paramLong1 = (l1 * (1.0D - d1) + d2 * d1);
    AppMethodBeat.o(145147);
    return l2 << 16 | 0xFF000000 | paramLong2 << 8 | paramLong1;
  }
  
  public static long absColor(long paramLong)
  {
    AppMethodBeat.i(145148);
    if (paramLong >= 0L)
    {
      AppMethodBeat.o(145148);
      return paramLong;
    }
    paramLong = Math.abs(1L + paramLong);
    Object localObject = new ArrayList();
    while (paramLong > 16L)
    {
      ((ArrayList)localObject).add(Integer.valueOf((int)(paramLong - (paramLong >> 4 << 4))));
      paramLong >>= 4;
    }
    ((ArrayList)localObject).add(Integer.valueOf((int)paramLong));
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(15 - ((Integer)((Iterator)localObject).next()).intValue()));
    }
    int i = localArrayList.size();
    paramLong = 0L;
    i -= 1;
    while (i >= 0)
    {
      paramLong = paramLong * 16L + ((Integer)localArrayList.get(i)).intValue();
      i -= 1;
    }
    AppMethodBeat.o(145148);
    return paramLong;
  }
  
  private static long getAlpha(long paramLong)
  {
    return paramLong >> 24;
  }
  
  private static long getBlue(long paramLong)
  {
    return paramLong - (paramLong >> 8 << 8);
  }
  
  private static long getGreen(long paramLong)
  {
    return (paramLong >> 8) - (paramLong >> 16 << 8);
  }
  
  private static long getRed(long paramLong)
  {
    return (paramLong >> 16) - (paramLong >> 24 << 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ColorUtil
 * JD-Core Version:    0.7.0.1
 */