package com.tencent.mm.danmaku.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c
{
  public static Object b(Class<?> paramClass, String paramString, Object paramObject)
  {
    AppMethodBeat.i(285072);
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      AppMethodBeat.o(285072);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(285072);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.danmaku.f.c
 * JD-Core Version:    0.7.0.1
 */