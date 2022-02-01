package com.d.a.a.a;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

public final class f
{
  private static final a bSW = new a(",");
  
  public static <T> e<T> d(Collection<? extends T> paramCollection)
  {
    return new a(paramCollection, (byte)0);
  }
  
  static final class a<T>
    implements e<T>, Serializable
  {
    private final Collection<?> bSX;
    
    private a(Collection<?> paramCollection)
    {
      this.bSX = ((Collection)a.checkNotNull(paramCollection));
    }
    
    public final boolean apply(@Nullable T paramT)
    {
      try
      {
        boolean bool = this.bSX.contains(paramT);
        return bool;
      }
      catch (ClassCastException paramT)
      {
        return false;
      }
      catch (NullPointerException paramT) {}
      return false;
    }
    
    public final boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        return this.bSX.equals(paramObject.bSX);
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.bSX.hashCode();
    }
    
    public final String toString()
    {
      return "Predicates.in(" + this.bSX + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */