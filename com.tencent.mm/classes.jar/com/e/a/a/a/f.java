package com.e.a.a.a;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

public final class f
{
  private static final a cdj = new a(",");
  
  public static <T> e<T> d(Collection<? extends T> paramCollection)
  {
    return new a(paramCollection, (byte)0);
  }
  
  static final class a<T>
    implements e<T>, Serializable
  {
    private final Collection<?> cdk;
    
    private a(Collection<?> paramCollection)
    {
      this.cdk = ((Collection)a.checkNotNull(paramCollection));
    }
    
    public final boolean apply(@Nullable T paramT)
    {
      try
      {
        boolean bool = this.cdk.contains(paramT);
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
        return this.cdk.equals(paramObject.cdk);
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.cdk.hashCode();
    }
    
    public final String toString()
    {
      return "Predicates.in(" + this.cdk + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */