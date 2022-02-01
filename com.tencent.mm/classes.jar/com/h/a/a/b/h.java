package com.h.a.a.b;

import com.h.a.a.a.a;
import com.h.a.a.a.b;
import com.h.a.a.a.c;
import com.h.a.a.a.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class h
{
  private static r<Object> eak = new h.1();
  private static final Iterator<Object> eal = new Iterator()
  {
    public final boolean hasNext()
    {
      return false;
    }
    
    public final Object next()
    {
      throw new NoSuchElementException();
    }
    
    public final void remove()
    {
      b.cC(false);
    }
  };
  
  public static <F, T> Iterator<T> a(Iterator<F> paramIterator, final a<? super F, ? extends T> parama)
  {
    b.checkNotNull(parama);
    new p(paramIterator)
    {
      final T bR(F paramAnonymousF)
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
    paramCollection = d.q(paramCollection);
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
  
  static <T> Iterator<T> akR()
  {
    return eal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.a.b.h
 * JD-Core Version:    0.7.0.1
 */