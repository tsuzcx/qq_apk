package com.h.a.a.b;

import com.h.a.a.a.b;
import java.util.Collection;

public final class f
{
  static final b eaj = new b(", ").eo("null");
  
  static boolean a(Collection<?> paramCollection, Object paramObject)
  {
    b.checkNotNull(paramCollection);
    try
    {
      boolean bool = paramCollection.contains(paramObject);
      return bool;
    }
    catch (ClassCastException paramCollection)
    {
      return false;
    }
    catch (NullPointerException paramCollection) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.a.b.f
 * JD-Core Version:    0.7.0.1
 */