package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ce
{
  public static boolean aR(Object paramObject)
  {
    AppMethodBeat.i(77828);
    if ((paramObject instanceof Boolean)) {
      try
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        AppMethodBeat.o(77828);
        return bool;
      }
      catch (Exception paramObject) {}
    }
    AppMethodBeat.o(77828);
    return false;
  }
  
  public static String f(Object paramObject, String paramString)
  {
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = (String)paramObject;
        return paramObject;
      }
      catch (Exception paramObject) {}
    }
    return paramString;
  }
  
  public static int getInt(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(77827);
    if ((paramObject instanceof Integer)) {
      try
      {
        int i = ((Integer)paramObject).intValue();
        AppMethodBeat.o(77827);
        return i;
      }
      catch (Exception paramObject) {}
    }
    AppMethodBeat.o(77827);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ce
 * JD-Core Version:    0.7.0.1
 */