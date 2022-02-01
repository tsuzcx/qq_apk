package com.google.d;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class dr
  extends AbstractList<String>
  implements bp, RandomAccess
{
  private final bp dWf;
  
  public dr(bp parambp)
  {
    this.dWf = parambp;
  }
  
  public final List<?> aiu()
  {
    return this.dWf.aiu();
  }
  
  public final bp aiv()
  {
    return this;
  }
  
  public final void d(h paramh)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.dWf.getRaw(paramInt);
  }
  
  public final Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> dRZ = dr.a(dr.this).iterator();
      
      public final boolean hasNext()
      {
        return this.dRZ.hasNext();
      }
      
      public final void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public final ListIterator<String> listIterator(final int paramInt)
  {
    new ListIterator()
    {
      ListIterator<String> dWg = dr.a(dr.this).listIterator(paramInt);
      
      public final boolean hasNext()
      {
        return this.dWg.hasNext();
      }
      
      public final boolean hasPrevious()
      {
        return this.dWg.hasPrevious();
      }
      
      public final int nextIndex()
      {
        return this.dWg.nextIndex();
      }
      
      public final int previousIndex()
      {
        return this.dWg.previousIndex();
      }
      
      public final void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public final h ll(int paramInt)
  {
    return this.dWf.ll(paramInt);
  }
  
  public final int size()
  {
    return this.dWf.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.dr
 * JD-Core Version:    0.7.0.1
 */