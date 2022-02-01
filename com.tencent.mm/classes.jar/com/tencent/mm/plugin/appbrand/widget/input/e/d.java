package com.tencent.mm.plugin.appbrand.widget.input.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  private static int aG(Class paramClass)
  {
    AppMethodBeat.i(131529);
    if (!paramClass.isEnum())
    {
      AppMethodBeat.o(131529);
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
    AppMethodBeat.o(131529);
    return j;
  }
  
  public static Integer cH(Object paramObject)
  {
    AppMethodBeat.i(131531);
    if (paramObject == null)
    {
      AppMethodBeat.o(131531);
      return null;
    }
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      AppMethodBeat.o(131531);
      return paramObject;
    }
    int i;
    if ((paramObject instanceof Number))
    {
      i = ((Number)paramObject).intValue();
      AppMethodBeat.o(131531);
      return Integer.valueOf(i);
    }
    if ((paramObject instanceof String)) {
      try
      {
        i = (int)Double.parseDouble((String)paramObject);
        AppMethodBeat.o(131531);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    AppMethodBeat.o(131531);
    return null;
  }
  
  public static <T extends Enum> T h(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(131530);
    int i = aG(paramClass);
    if ((Util.isNullOrNil(paramString)) || (paramString.length() > i))
    {
      AppMethodBeat.o(131530);
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
        AppMethodBeat.o(131530);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(131530);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e.d
 * JD-Core Version:    0.7.0.1
 */