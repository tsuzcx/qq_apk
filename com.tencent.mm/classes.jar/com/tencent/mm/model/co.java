package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class co
{
  public static String c(Object paramObject, String paramString)
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
  
  public static boolean cg(Object paramObject)
  {
    AppMethodBeat.i(150192);
    if ((paramObject instanceof Boolean)) {
      try
      {
        boolean bool = ((Boolean)paramObject).booleanValue();
        AppMethodBeat.o(150192);
        return bool;
      }
      catch (Exception paramObject) {}
    }
    AppMethodBeat.o(150192);
    return false;
  }
  
  public static int getInt(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(150191);
    if ((paramObject instanceof Integer)) {
      try
      {
        int i = ((Integer)paramObject).intValue();
        AppMethodBeat.o(150191);
        return i;
      }
      catch (Exception paramObject) {}
    }
    AppMethodBeat.o(150191);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.co
 * JD-Core Version:    0.7.0.1
 */