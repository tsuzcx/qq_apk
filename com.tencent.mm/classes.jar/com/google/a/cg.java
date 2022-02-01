package com.google.a;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class cg
  extends AbstractList<String>
  implements ak, RandomAccess
{
  private final ak cab;
  
  public cg(ak paramak)
  {
    this.cab = paramak;
  }
  
  public final List<?> GQ()
  {
    return this.cab.GQ();
  }
  
  public final ak GR()
  {
    return this;
  }
  
  public final void d(g paramg)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.cab.getRaw(paramInt);
  }
  
  public final Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> bWx = cg.a(cg.this).iterator();
      
      public final boolean hasNext()
      {
        return this.bWx.hasNext();
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
      ListIterator<String> cac = cg.a(cg.this).listIterator(paramInt);
      
      public final boolean hasNext()
      {
        return this.cac.hasNext();
      }
      
      public final boolean hasPrevious()
      {
        return this.cac.hasPrevious();
      }
      
      public final int nextIndex()
      {
        return this.cac.nextIndex();
      }
      
      public final int previousIndex()
      {
        return this.cac.previousIndex();
      }
      
      public final void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public final int size()
  {
    return this.cab.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.cg
 * JD-Core Version:    0.7.0.1
 */