package com.e.a.a.b;

import com.e.a.a.a.a;
import com.e.a.a.a.b;
import com.e.a.a.a.e;
import com.e.a.a.a.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class h
{
  private static r<Object> cdK = new h.1();
  private static final Iterator<Object> cdL = new Iterator()
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
      a.bn(false);
    }
  };
  
  static <T> Iterator<T> Bd()
  {
    return cdL;
  }
  
  public static <F, T> Iterator<T> a(Iterator<F> paramIterator, final b<? super F, ? extends T> paramb)
  {
    a.checkNotNull(paramb);
    new p(paramIterator)
    {
      final T ar(F paramAnonymousF)
      {
        return paramb.apply(paramAnonymousF);
      }
    };
  }
  
  static void a(Iterator<?> paramIterator)
  {
    a.checkNotNull(paramIterator);
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      paramIterator.remove();
    }
  }
  
  public static boolean a(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    paramCollection = f.d(paramCollection);
    a.checkNotNull(paramCollection);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.a.b.h
 * JD-Core Version:    0.7.0.1
 */