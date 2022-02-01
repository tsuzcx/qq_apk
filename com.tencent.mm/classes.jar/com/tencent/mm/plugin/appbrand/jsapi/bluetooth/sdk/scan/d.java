package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class d
{
  static boolean deepEquals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(144623);
    if ((paramObject1 == null) || (paramObject2 == null))
    {
      if (paramObject1 == paramObject2)
      {
        AppMethodBeat.o(144623);
        return true;
      }
      AppMethodBeat.o(144623);
      return false;
    }
    if (((paramObject1 instanceof Object[])) && ((paramObject2 instanceof Object[])))
    {
      bool = Arrays.deepEquals((Object[])paramObject1, (Object[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof boolean[])) && ((paramObject2 instanceof boolean[])))
    {
      bool = Arrays.equals((boolean[])paramObject1, (boolean[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[])))
    {
      bool = Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof char[])) && ((paramObject2 instanceof char[])))
    {
      bool = Arrays.equals((char[])paramObject1, (char[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof double[])) && ((paramObject2 instanceof double[])))
    {
      bool = Arrays.equals((double[])paramObject1, (double[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof float[])) && ((paramObject2 instanceof float[])))
    {
      bool = Arrays.equals((float[])paramObject1, (float[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof int[])) && ((paramObject2 instanceof int[])))
    {
      bool = Arrays.equals((int[])paramObject1, (int[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof long[])) && ((paramObject2 instanceof long[])))
    {
      bool = Arrays.equals((long[])paramObject1, (long[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    if (((paramObject1 instanceof short[])) && ((paramObject2 instanceof short[])))
    {
      bool = Arrays.equals((short[])paramObject1, (short[])paramObject2);
      AppMethodBeat.o(144623);
      return bool;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(144623);
    return bool;
  }
  
  static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(144622);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(144622);
        return true;
      }
      AppMethodBeat.o(144622);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(144622);
    return bool;
  }
  
  static String toString(Object paramObject)
  {
    AppMethodBeat.i(144621);
    if (paramObject == null)
    {
      AppMethodBeat.o(144621);
      return "null";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(144621);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.d
 * JD-Core Version:    0.7.0.1
 */