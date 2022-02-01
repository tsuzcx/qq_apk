package com.google.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class c
{
  private static String bk(Object paramObject)
  {
    AppMethodBeat.i(208707);
    try
    {
      String str = String.valueOf(paramObject);
      AppMethodBeat.o(208707);
      return str;
    }
    catch (Exception localException)
    {
      paramObject = paramObject.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(paramObject));
      Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for ".concat(String.valueOf(paramObject)), localException);
      paramObject = "<" + paramObject + " threw " + localException.getClass().getName() + ">";
      AppMethodBeat.o(208707);
    }
    return paramObject;
  }
  
  public static String h(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(208701);
    paramString = String.valueOf(paramString);
    int i = 0;
    while (i <= 0)
    {
      paramVarArgs[0] = bk(paramVarArgs[0]);
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 16);
    i = 0;
    int k;
    for (int j = 0; i <= 0; j = k + 2)
    {
      k = paramString.indexOf("%s", 0);
      if (k == -1) {
        break;
      }
      localStringBuilder.append(paramString, 0, k);
      i += 1;
      localStringBuilder.append(paramVarArgs[0]);
    }
    localStringBuilder.append(paramString, j, paramString.length());
    if (i <= 0)
    {
      localStringBuilder.append(" [");
      localStringBuilder.append(paramVarArgs[0]);
      localStringBuilder.append(']');
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(208701);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.c
 * JD-Core Version:    0.7.0.1
 */