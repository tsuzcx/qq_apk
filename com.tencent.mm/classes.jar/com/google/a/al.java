package com.google.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class al
{
  private static final al bXN = new a((byte)0);
  private static final al bXO = new b((byte)0);
  
  static al GS()
  {
    return bXN;
  }
  
  static al GT()
  {
    return bXO;
  }
  
  abstract void a(Object paramObject, long paramLong);
  
  abstract <L> void a(Object paramObject1, Object paramObject2, long paramLong);
  
  static final class a
    extends al
  {
    private static final Class<?> bXP = Collections.unmodifiableList(Collections.emptyList()).getClass();
    
    private a()
    {
      super();
    }
    
    private static <E> List<E> b(Object paramObject, long paramLong)
    {
      return (List)ch.k(paramObject, paramLong);
    }
    
    final void a(Object paramObject, long paramLong)
    {
      Object localObject = (List)ch.k(paramObject, paramLong);
      if ((localObject instanceof ak)) {}
      for (localObject = ((ak)localObject).GR();; localObject = Collections.unmodifiableList((List)localObject))
      {
        ch.a(paramObject, paramLong, localObject);
        do
        {
          do
          {
            return;
          } while (bXP.isAssignableFrom(localObject.getClass()));
          if ((!(localObject instanceof bk)) || (!(localObject instanceof ae.e))) {
            break;
          }
        } while (!((ae.e)localObject).yJ());
        ((ae.e)localObject).yK();
        return;
      }
    }
    
    final <E> void a(Object paramObject1, Object paramObject2, long paramLong)
    {
      List localList1 = b(paramObject2, paramLong);
      int i = localList1.size();
      List localList2 = b(paramObject1, paramLong);
      if (localList2.isEmpty()) {
        if ((localList2 instanceof ak))
        {
          paramObject2 = new aj(i);
          ch.a(paramObject1, paramLong, paramObject2);
          label57:
          i = paramObject2.size();
          int j = localList1.size();
          if ((i > 0) && (j > 0)) {
            paramObject2.addAll(localList1);
          }
          if (i <= 0) {
            break label311;
          }
        }
      }
      for (;;)
      {
        ch.a(paramObject1, paramLong, paramObject2);
        return;
        if (((localList2 instanceof bk)) && ((localList2 instanceof ae.e)))
        {
          paramObject2 = ((ae.e)localList2).gI(i);
          break;
        }
        paramObject2 = new ArrayList(i);
        break;
        if (bXP.isAssignableFrom(localList2.getClass()))
        {
          paramObject2 = new ArrayList(i + localList2.size());
          paramObject2.addAll(localList2);
          ch.a(paramObject1, paramLong, paramObject2);
          break label57;
        }
        if ((localList2 instanceof cg))
        {
          paramObject2 = new aj(i + localList2.size());
          paramObject2.addAll((cg)localList2);
          ch.a(paramObject1, paramLong, paramObject2);
          break label57;
        }
        paramObject2 = localList2;
        if (!(localList2 instanceof bk)) {
          break label57;
        }
        paramObject2 = localList2;
        if (!(localList2 instanceof ae.e)) {
          break label57;
        }
        paramObject2 = localList2;
        if (((ae.e)localList2).yJ()) {
          break label57;
        }
        paramObject2 = ((ae.e)localList2).gI(localList2.size() + i);
        ch.a(paramObject1, paramLong, paramObject2);
        break label57;
        label311:
        paramObject2 = localList1;
      }
    }
  }
  
  static final class b
    extends al
  {
    private b()
    {
      super();
    }
    
    private static <E> ae.e<E> c(Object paramObject, long paramLong)
    {
      return (ae.e)ch.k(paramObject, paramLong);
    }
    
    final void a(Object paramObject, long paramLong)
    {
      c(paramObject, paramLong).yK();
    }
    
    final <E> void a(Object paramObject1, Object paramObject2, long paramLong)
    {
      ae.e locale1 = c(paramObject1, paramLong);
      ae.e locale2 = c(paramObject2, paramLong);
      int i = locale1.size();
      int j = locale2.size();
      paramObject2 = locale1;
      if (i > 0)
      {
        paramObject2 = locale1;
        if (j > 0)
        {
          paramObject2 = locale1;
          if (!locale1.yJ()) {
            paramObject2 = locale1.gI(j + i);
          }
          paramObject2.addAll(locale2);
        }
      }
      if (i > 0) {}
      for (;;)
      {
        ch.a(paramObject1, paramLong, paramObject2);
        return;
        paramObject2 = locale2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.al
 * JD-Core Version:    0.7.0.1
 */