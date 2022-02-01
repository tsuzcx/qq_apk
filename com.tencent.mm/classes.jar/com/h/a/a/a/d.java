package com.h.a.a.a;

import java.io.Serializable;
import java.util.Collection;

public final class d
{
  static
  {
    new b(",");
  }
  
  public static <T> c<T> q(Collection<? extends T> paramCollection)
  {
    return new a(paramCollection, (byte)0);
  }
  
  static final class a<T>
    implements c<T>, Serializable
  {
    private final Collection<?> dZO;
    
    private a(Collection<?> paramCollection)
    {
      this.dZO = ((Collection)b.checkNotNull(paramCollection));
    }
    
    public final boolean apply(T paramT)
    {
      try
      {
        boolean bool = this.dZO.contains(paramT);
        return bool;
      }
      catch (ClassCastException paramT)
      {
        return false;
      }
      catch (NullPointerException paramT) {}
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        return this.dZO.equals(paramObject.dZO);
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.dZO.hashCode();
    }
    
    public final String toString()
    {
      return "Predicates.in(" + this.dZO + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */