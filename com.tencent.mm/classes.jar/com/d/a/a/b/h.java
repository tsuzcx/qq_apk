package com.d.a.a.b;

import com.d.a.a.a.a;
import com.d.a.a.a.b;
import com.d.a.a.a.e;
import com.d.a.a.a.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class h
{
  private static r<Object> bVP = new r()
  {
    public final boolean hasNext()
    {
      return false;
    }
    
    public final boolean hasPrevious()
    {
      return false;
    }
    
    public final Object next()
    {
      throw new NoSuchElementException();
    }
    
    public final int nextIndex()
    {
      return 0;
    }
    
    public final Object previous()
    {
      throw new NoSuchElementException();
    }
    
    public final int previousIndex()
    {
      return -1;
    }
  };
  private static final Iterator<Object> bVQ = new Iterator()
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
  
  public static <F, T> Iterator<T> a(Iterator<F> paramIterator, final b<? super F, ? extends T> paramb)
  {
    a.checkNotNull(paramb);
    new p(paramIterator)
    {
      final T ao(F paramAnonymousF)
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
  
  static <T> Iterator<T> zS()
  {
    return bVQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.b.h
 * JD-Core Version:    0.7.0.1
 */