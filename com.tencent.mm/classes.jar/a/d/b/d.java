package a.d.b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collection<TE;>;
import java.util.Iterator;

public final class d
{
  private static final Object[] xos = new Object[0];
  
  public static <T, E> T[] a(Collection<E> paramCollection, T[] paramArrayOfT)
  {
    int i = paramCollection.size();
    Object localObject;
    Iterator localIterator;
    if (paramArrayOfT.length >= i)
    {
      localObject = paramArrayOfT;
      localIterator = paramCollection.iterator();
      i = 0;
      label25:
      if (i >= localObject.length) {
        break label98;
      }
      if (localIterator.hasNext()) {
        break label81;
      }
      if (paramArrayOfT == localObject) {
        break label75;
      }
      paramCollection = Arrays.copyOf((Object[])localObject, i);
    }
    label75:
    label81:
    label98:
    do
    {
      return paramCollection;
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
      break;
      localObject[i] = null;
      return localObject;
      localObject[i] = localIterator.next();
      i += 1;
      break label25;
      paramCollection = (Collection<E>)localObject;
    } while (!localIterator.hasNext());
    return a((Object[])localObject, localIterator);
  }
  
  private static <T> T[] a(T[] paramArrayOfT, Iterator<?> paramIterator)
  {
    int i = paramArrayOfT.length;
    while (paramIterator.hasNext())
    {
      int m = paramArrayOfT.length;
      Object localObject = paramArrayOfT;
      if (i == m)
      {
        int k = (m / 2 + 1) * 3;
        int j = k;
        if (k <= m)
        {
          if (m == 2147483647) {
            throw new OutOfMemoryError("Required array size too large");
          }
          j = 2147483647;
        }
        localObject = Arrays.copyOf(paramArrayOfT, j);
      }
      localObject[i] = paramIterator.next();
      i += 1;
      paramArrayOfT = (T[])localObject;
    }
    if (i == paramArrayOfT.length) {
      return paramArrayOfT;
    }
    return Arrays.copyOf(paramArrayOfT, i);
  }
  
  public static Object[] f(Collection<?> paramCollection)
  {
    int j = paramCollection.size();
    if (j == 0) {
      paramCollection = xos;
    }
    Object[] arrayOfObject;
    Iterator localIterator;
    do
    {
      return paramCollection;
      arrayOfObject = new Object[j];
      localIterator = paramCollection.iterator();
      int i = 0;
      while (i < j)
      {
        if (!localIterator.hasNext()) {
          return Arrays.copyOf(arrayOfObject, i);
        }
        arrayOfObject[i] = localIterator.next();
        i += 1;
      }
      paramCollection = arrayOfObject;
    } while (!localIterator.hasNext());
    return a(arrayOfObject, localIterator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.d.b.d
 * JD-Core Version:    0.7.0.1
 */