package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class o
{
  private static HashMap<String, String> a;
  
  static
  {
    AppMethodBeat.i(224503);
    a = new HashMap();
    AppMethodBeat.o(224503);
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(224496);
    paramString = (String)a.get(paramString);
    AppMethodBeat.o(224496);
    return paramString;
  }
  
  public static <T extends p> void a(Class<T> paramClass)
  {
    AppMethodBeat.i(224487);
    try
    {
      Object localObject = (p)paramClass.newInstance();
      if (localObject != null)
      {
        String str = ((p)localObject).className();
        localObject = str;
        if ("".equals(str)) {
          localObject = paramClass.getName();
        }
        a.put(localObject, paramClass.getName());
      }
      AppMethodBeat.o(224487);
      return;
    }
    catch (InstantiationException paramClass)
    {
      AppMethodBeat.o(224487);
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      AppMethodBeat.o(224487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.o
 * JD-Core Version:    0.7.0.1
 */