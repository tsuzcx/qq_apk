package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.mm.sdk.platformtools.bk;

public final class d
{
  public static Integer bf(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        int i = (int)Double.parseDouble((String)paramObject);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  static <T extends Enum> T h(String paramString, Class<T> paramClass)
  {
    if (!paramClass.isEnum()) {
      i = 0;
    }
    Object[] arrayOfObject;
    while ((bk.bl(paramString)) || (paramString.length() > i))
    {
      return null;
      arrayOfObject = paramClass.getEnumConstants();
      int k = arrayOfObject.length;
      j = 0;
      i = 0;
      while (j < k)
      {
        i = Math.max(((Enum)arrayOfObject[j]).name().length(), i);
        j += 1;
      }
    }
    paramString = paramString.toUpperCase();
    paramClass = (Enum[])paramClass.getEnumConstants();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      arrayOfObject = paramClass[i];
      if (paramString.equals(((Enum)arrayOfObject).name())) {
        return (Enum)arrayOfObject;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.d
 * JD-Core Version:    0.7.0.1
 */