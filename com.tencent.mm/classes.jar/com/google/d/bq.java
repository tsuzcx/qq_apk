package com.google.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class bq
{
  private static final bq dTn = new a((byte)0);
  private static final bq dTo = new b((byte)0);
  
  static bq aiw()
  {
    return dTn;
  }
  
  static bq aix()
  {
    return dTo;
  }
  
  abstract <L> List<L> a(Object paramObject, long paramLong);
  
  abstract void b(Object paramObject, long paramLong);
  
  static final class a
    extends bq
  {
    private static final Class<?> dTp = Collections.unmodifiableList(Collections.emptyList()).getClass();
    
    private a()
    {
      super();
    }
    
    final <L> List<L> a(Object paramObject, long paramLong)
    {
      List localList = (List)ds.o(paramObject, paramLong);
      if (localList.isEmpty()) {
        if ((localList instanceof bp))
        {
          localObject = new bo(10);
          ds.a(paramObject, paramLong, localObject);
        }
      }
      do
      {
        do
        {
          do
          {
            return localObject;
            if (((localList instanceof ct)) && ((localList instanceof bj.i)))
            {
              localObject = ((bj.i)localList).jI(10);
              break;
            }
            localObject = new ArrayList(10);
            break;
            if (dTp.isAssignableFrom(localList.getClass()))
            {
              localObject = new ArrayList(localList.size() + 10);
              ((ArrayList)localObject).addAll(localList);
              ds.a(paramObject, paramLong, localObject);
              return localObject;
            }
            if ((localList instanceof dr))
            {
              localObject = new bo(localList.size() + 10);
              ((bo)localObject).addAll((dr)localList);
              ds.a(paramObject, paramLong, localObject);
              return localObject;
            }
            localObject = localList;
          } while (!(localList instanceof ct));
          localObject = localList;
        } while (!(localList instanceof bj.i));
        localObject = localList;
      } while (((bj.i)localList).ZO());
      Object localObject = ((bj.i)localList).jI(localList.size() + 10);
      ds.a(paramObject, paramLong, localObject);
      return localObject;
    }
    
    final void b(Object paramObject, long paramLong)
    {
      Object localObject = (List)ds.o(paramObject, paramLong);
      if ((localObject instanceof bp)) {}
      for (localObject = ((bp)localObject).aiv();; localObject = Collections.unmodifiableList((List)localObject))
      {
        ds.a(paramObject, paramLong, localObject);
        do
        {
          do
          {
            return;
          } while (dTp.isAssignableFrom(localObject.getClass()));
          if ((!(localObject instanceof ct)) || (!(localObject instanceof bj.i))) {
            break;
          }
        } while (!((bj.i)localObject).ZO());
        ((bj.i)localObject).ZP();
        return;
      }
    }
  }
  
  static final class b
    extends bq
  {
    private b()
    {
      super();
    }
    
    private static <E> bj.i<E> c(Object paramObject, long paramLong)
    {
      return (bj.i)ds.o(paramObject, paramLong);
    }
    
    final <L> List<L> a(Object paramObject, long paramLong)
    {
      bj.i locali = c(paramObject, paramLong);
      if (!locali.ZO())
      {
        int i = locali.size();
        if (i == 0) {
          i = 10;
        }
        for (;;)
        {
          locali = locali.jI(i);
          ds.a(paramObject, paramLong, locali);
          return locali;
          i *= 2;
        }
      }
      return locali;
    }
    
    final void b(Object paramObject, long paramLong)
    {
      c(paramObject, paramLong).ZP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bq
 * JD-Core Version:    0.7.0.1
 */