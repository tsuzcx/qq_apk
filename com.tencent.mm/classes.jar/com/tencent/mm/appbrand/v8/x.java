package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class x
{
  private static int drk = -1;
  private static int drl = -1;
  private static a drm;
  
  private static void XO()
  {
    int i = 0;
    AppMethodBeat.i(144123);
    Object localObject = V8.getFlags();
    Log.i("MicroMsg.V8GCReporter", "initV8GCSpaceSizeFromFlags : %s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      drk = 1;
      drl = 8;
      AppMethodBeat.o(144123);
      return;
    }
    localObject = ((String)localObject).split(" ", -1);
    if (i < localObject.length)
    {
      int j = e(localObject[i], "--min_semi_space_size", 1);
      if (j != -2147483648) {
        drk = j;
      }
      for (;;)
      {
        i += 1;
        break;
        j = e(localObject[i], "--max_semi_space_size", 8);
        if (j != -2147483648) {
          drl = j;
        }
      }
    }
    AppMethodBeat.o(144123);
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(144122);
    int i;
    if (drm != null)
    {
      if (drk <= 0) {
        break label146;
      }
      i = drk;
      if (drl <= 0) {
        break label157;
      }
    }
    for (int j = drl;; j = drl)
    {
      paramString = String.format("%d,%d,%d,%d,%d,%s,%d,%d,%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      Log.v("MicroMsg.V8GCReporter", "report str:%s", new Object[] { paramString });
      drm.gz(paramString);
      AppMethodBeat.o(144122);
      return;
      label146:
      XO();
      i = drk;
      break;
      label157:
      XO();
    }
  }
  
  public static void a(a parama)
  {
    drm = parama;
  }
  
  private static int e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(144124);
    paramString2 = paramString2 + "=";
    if (paramString1.indexOf(paramString2) >= 0)
    {
      paramInt = Util.getInt(paramString1.replaceFirst(paramString2, ""), paramInt);
      AppMethodBeat.o(144124);
      return paramInt;
    }
    AppMethodBeat.o(144124);
    return -2147483648;
  }
  
  public static abstract interface a
  {
    public abstract void gz(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.x
 * JD-Core Version:    0.7.0.1
 */