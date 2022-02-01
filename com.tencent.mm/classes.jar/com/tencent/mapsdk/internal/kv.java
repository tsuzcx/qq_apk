package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class kv
{
  public static final Random a;
  
  static
  {
    AppMethodBeat.i(222348);
    a = new Random();
    AppMethodBeat.o(222348);
  }
  
  private static double a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    AppMethodBeat.i(222340);
    if ((paramPointF1.equals(paramPointF2)) || (paramPointF3.equals(paramPointF1)) || (paramPointF3.equals(paramPointF2)))
    {
      AppMethodBeat.o(222340);
      return 0.0D;
    }
    double d = Math.abs(0.5D * (paramPointF1.x * paramPointF2.y + paramPointF2.x * paramPointF3.y + paramPointF3.x * paramPointF1.y - paramPointF2.x * paramPointF1.y - paramPointF3.x * paramPointF2.y - paramPointF1.x * paramPointF3.y)) * 2.0D / Math.sqrt(Math.pow(paramPointF1.x - paramPointF2.x, 2.0D) + Math.pow(paramPointF1.y - paramPointF2.y, 2.0D));
    AppMethodBeat.o(222340);
    return d;
  }
  
  private static <E> int a(ArrayList<E> paramArrayList, int paramInt1, int paramInt2, Comparator<? super E> paramComparator)
  {
    AppMethodBeat.i(222300);
    int i = a.nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
    Object localObject = paramArrayList.get(i);
    a(paramArrayList, i, paramInt2);
    int j = paramInt1;
    i = paramInt1;
    paramInt1 = j;
    if (i < paramInt2)
    {
      if (paramComparator.compare(paramArrayList.get(i), localObject) > 0) {
        break label104;
      }
      j = paramInt1 + 1;
      a(paramArrayList, paramInt1, i);
      paramInt1 = j;
    }
    label104:
    for (;;)
    {
      i += 1;
      break;
      a(paramArrayList, paramInt1, paramInt2);
      AppMethodBeat.o(222300);
      return paramInt1;
    }
  }
  
  private static List<PointF> a(List<PointF> paramList, double paramDouble)
  {
    int j = 0;
    AppMethodBeat.i(222281);
    int i = paramList.size();
    if ((paramList.isEmpty()) || (i < 3))
    {
      AppMethodBeat.o(222281);
      return paramList;
    }
    i = paramList.size() - 1;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(0));
    while (((PointF)paramList.get(0)).equals(paramList.get(i)))
    {
      int k = i - 1;
      i = k;
      if (k <= 0)
      {
        AppMethodBeat.o(222281);
        return paramList;
      }
    }
    localArrayList.add(Integer.valueOf(i));
    a(paramList, 0, i, paramDouble, localArrayList);
    Object localObject = new kv.1();
    b(localArrayList, 0, localArrayList.size() - 1, (Comparator)localObject);
    localObject = new ArrayList();
    i = j;
    while (i < localArrayList.size())
    {
      ((ArrayList)localObject).add(paramList.get(((Integer)localArrayList.get(i)).intValue()));
      i += 1;
    }
    AppMethodBeat.o(222281);
    return localObject;
  }
  
  private static <E> void a(ArrayList<E> paramArrayList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222292);
    Object localObject = paramArrayList.get(paramInt1);
    paramArrayList.set(paramInt1, paramArrayList.get(paramInt2));
    paramArrayList.set(paramInt2, localObject);
    AppMethodBeat.o(222292);
  }
  
  private static <E> void a(ArrayList<E> paramArrayList, Comparator<? super E> paramComparator)
  {
    AppMethodBeat.i(222315);
    b(paramArrayList, 0, paramArrayList.size() - 1, paramComparator);
    AppMethodBeat.o(222315);
  }
  
  private static void a(List<PointF> paramList, int paramInt1, int paramInt2, double paramDouble, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(222327);
    double d1 = 0.0D;
    int j = 0;
    int i = paramInt1;
    label14:
    PointF localPointF1;
    PointF localPointF2;
    PointF localPointF3;
    double d2;
    if (i < paramInt2)
    {
      localPointF1 = (PointF)paramList.get(paramInt1);
      localPointF2 = (PointF)paramList.get(paramInt2);
      localPointF3 = (PointF)paramList.get(i);
      if ((localPointF1.equals(localPointF2)) || (localPointF3.equals(localPointF1)) || (localPointF3.equals(localPointF2)))
      {
        d2 = 0.0D;
        label90:
        if (d2 <= d1) {
          break label341;
        }
        j = i;
      }
    }
    for (;;)
    {
      i += 1;
      d1 = d2;
      break label14;
      float f1 = localPointF1.x;
      float f2 = localPointF2.y;
      float f3 = localPointF2.x;
      float f4 = localPointF3.y;
      float f5 = localPointF3.x;
      float f6 = localPointF1.y;
      float f7 = localPointF2.x;
      float f8 = localPointF1.y;
      float f9 = localPointF3.x;
      float f10 = localPointF2.y;
      float f11 = localPointF1.x;
      d2 = Math.abs(0.5D * (f1 * f2 + f3 * f4 + f5 * f6 - f7 * f8 - f9 * f10 - localPointF3.y * f11));
      double d3 = Math.pow(localPointF1.x - localPointF2.x, 2.0D);
      d2 = d2 * 2.0D / Math.sqrt(Math.pow(localPointF1.y - localPointF2.y, 2.0D) + d3);
      break label90;
      if ((d1 > paramDouble) && (j != 0))
      {
        paramArrayList.add(Integer.valueOf(j));
        a(paramList, paramInt1, j, paramDouble, paramArrayList);
        paramInt1 = j;
        break;
      }
      AppMethodBeat.o(222327);
      return;
      label341:
      d2 = d1;
    }
  }
  
  private static <E> void b(ArrayList<E> paramArrayList, int paramInt1, int paramInt2, Comparator<? super E> paramComparator)
  {
    AppMethodBeat.i(222307);
    int i;
    int j;
    if (paramInt2 > paramInt1)
    {
      i = a.nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
      Object localObject = paramArrayList.get(i);
      a(paramArrayList, i, paramInt2);
      i = paramInt1;
      j = paramInt1;
      label46:
      if (j < paramInt2)
      {
        if (paramComparator.compare(paramArrayList.get(j), localObject) > 0) {
          break label127;
        }
        int k = i + 1;
        a(paramArrayList, i, j);
        i = k;
      }
    }
    label127:
    for (;;)
    {
      j += 1;
      break label46;
      a(paramArrayList, i, paramInt2);
      b(paramArrayList, paramInt1, i - 1, paramComparator);
      paramInt1 = i + 1;
      break;
      AppMethodBeat.o(222307);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kv
 * JD-Core Version:    0.7.0.1
 */