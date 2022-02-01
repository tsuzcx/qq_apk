package com.d.a.a.a;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

public final class d
{
  static
  {
    new b(",");
  }
  
  public static <T> c<T> b(Collection<? extends T> paramCollection)
  {
    return new a(paramCollection, (byte)0);
  }
  
  static final class a<T>
    implements c<T>, Serializable
  {
    private final Collection<?> cjq;
    
    private a(Collection<?> paramCollection)
    {
      this.cjq = ((Collection)b.checkNotNull(paramCollection));
    }
    
    public final boolean apply(@Nullable T paramT)
    {
      try
      {
        boolean bool = this.cjq.contains(paramT);
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
        return this.cjq.equals(paramObject.cjq);
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.cjq.hashCode();
    }
    
    public final String toString()
    {
      return "Predicates.in(" + this.cjq + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */