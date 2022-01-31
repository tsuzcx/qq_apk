package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
{
  private static int ag(Class paramClass)
  {
    AppMethodBeat.i(77453);
    if (!paramClass.isEnum())
    {
      AppMethodBeat.o(77453);
      return 0;
    }
    paramClass = paramClass.getEnumConstants();
    int k = paramClass.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = Math.max(((Enum)paramClass[i]).name().length(), j);
      i += 1;
    }
    AppMethodBeat.o(77453);
    return j;
  }
  
  public static Integer bk(Object paramObject)
  {
    AppMethodBeat.i(77455);
    if (paramObject == null)
    {
      AppMethodBeat.o(77455);
      return null;
    }
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      AppMethodBeat.o(77455);
      return paramObject;
    }
    int i;
    if ((paramObject instanceof Number))
    {
      i = ((Number)paramObject).intValue();
      AppMethodBeat.o(77455);
      return Integer.valueOf(i);
    }
    if ((paramObject instanceof String)) {
      try
      {
        i = (int)Double.parseDouble((String)paramObject);
        AppMethodBeat.o(77455);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    AppMethodBeat.o(77455);
    return null;
  }
  
  static <T extends Enum> T g(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(77454);
    int i = ag(paramClass);
    if ((bo.isNullOrNil(paramString)) || (paramString.length() > i))
    {
      AppMethodBeat.o(77454);
      return null;
    }
    paramString = paramString.toUpperCase();
    paramClass = (Enum[])paramClass.getEnumConstants();
    int j = paramClass.length;
    i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      if (paramString.equals(((Enum)localObject).name()))
      {
        paramString = (Enum)localObject;
        AppMethodBeat.o(77454);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(77454);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.d
 * JD-Core Version:    0.7.0.1
 */