package com.d.a.a.b;

import com.d.a.a.a.a;
import java.util.Collection;
import javax.annotation.Nullable;

public final class f
{
  static final a bTw = new a(", ").by("null");
  
  static boolean a(Collection<?> paramCollection, @Nullable Object paramObject)
  {
    a.checkNotNull(paramCollection);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.b.f
 * JD-Core Version:    0.7.0.1
 */