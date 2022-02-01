package com.d.a.a.a;

import com.d.a.a.b.h;
import com.d.a.a.b.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckReturnValue;

public class b
{
  private final String bOX;
  
  private b(b paramb)
  {
    this.bOX = paramb.bOX;
  }
  
  public b(String paramString)
  {
    this.bOX = ((String)checkNotNull(paramString));
  }
  
  public static boolean a(Set<?> paramSet, Collection<?> paramCollection)
  {
    checkNotNull(paramCollection);
    Object localObject = paramCollection;
    if ((paramCollection instanceof m)) {
      localObject = ((m)paramCollection).KS();
    }
    if (((localObject instanceof Set)) && (((Collection)localObject).size() > paramSet.size())) {
      return h.a(paramSet.iterator(), (Collection)localObject);
    }
    return a(paramSet, ((Collection)localObject).iterator());
  }
  
  public static boolean a(Set<?> paramSet, Iterator<?> paramIterator)
  {
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramSet.remove(paramIterator.next());
    }
    return bool;
  }
  
  public static int at(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  public static boolean b(Set<?> paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        try
        {
          if (paramSet.size() == paramObject.size())
          {
            boolean bool = paramSet.containsAll(paramObject);
            if (bool) {}
          }
          else
          {
            return false;
          }
        }
        catch (NullPointerException paramSet)
        {
          return false;
        }
        catch (ClassCastException paramSet)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  public static void bX(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf("no calls to next() since the last call to remove()"));
    }
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  @CheckReturnValue
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  @CheckReturnValue
  public b cU(final String paramString)
  {
    checkNotNull(paramString);
    new b(this, paramString)
    {
      public final b cU(String paramAnonymousString)
      {
        throw new UnsupportedOperationException("already specified useForNull");
      }
    };
  }
  
  public static final class a
  {
    private a(String paramString)
    {
      b.checkNotNull(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */