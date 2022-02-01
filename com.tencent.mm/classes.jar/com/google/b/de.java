package com.google.b;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class de
  extends AbstractList<String>
  implements bk, RandomAccess
{
  private final bk cbE;
  
  public de(bk parambk)
  {
    this.cbE = parambk;
  }
  
  public final List<?> Iw()
  {
    return this.cbE.Iw();
  }
  
  public final bk Ix()
  {
    return this;
  }
  
  public final void d(g paramg)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.cbE.getRaw(paramInt);
  }
  
  public final Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> bYp = de.a(de.this).iterator();
      
      public final boolean hasNext()
      {
        return this.bYp.hasNext();
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
      ListIterator<String> cbF = de.a(de.this).listIterator(paramInt);
      
      public final boolean hasNext()
      {
        return this.cbF.hasNext();
      }
      
      public final boolean hasPrevious()
      {
        return this.cbF.hasPrevious();
      }
      
      public final int nextIndex()
      {
        return this.cbF.nextIndex();
      }
      
      public final int previousIndex()
      {
        return this.cbF.previousIndex();
      }
      
      public final void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public final int size()
  {
    return this.cbE.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.de
 * JD-Core Version:    0.7.0.1
 */