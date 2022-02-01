package com.d.a.a.b;

import com.d.a.a.a.a;
import com.d.a.a.a.b;
import com.d.a.a.a.c;
import com.d.a.a.a.d;
import java.util.Collection;
import java.util.Iterator;

public final class h
{
  private static r<Object> cjP = new h.1();
  private static final Iterator<Object> cjQ = new h.2();
  
  static <T> Iterator<T> KQ()
  {
    return cjQ;
  }
  
  public static <F, T> Iterator<T> a(Iterator<F> paramIterator, final a<? super F, ? extends T> parama)
  {
    b.checkNotNull(parama);
    new p(paramIterator)
    {
      final T aw(F paramAnonymousF)
      {
        return parama.apply(paramAnonymousF);
      }
    };
  }
  
  static void a(Iterator<?> paramIterator)
  {
    b.checkNotNull(paramIterator);
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      paramIterator.remove();
    }
  }
  
  public static boolean a(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    paramCollection = d.b(paramCollection);
    b.checkNotNull(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (paramCollection.apply(paramIterator.next()))
      {
        paramIterator.remove();
        bool = true;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.b.h
 * JD-Core Version:    0.7.0.1
 */