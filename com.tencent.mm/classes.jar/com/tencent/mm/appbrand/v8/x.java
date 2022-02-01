package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class x
{
  private static int cQW = -1;
  private static int cQX = -1;
  private static a cQY;
  
  private static void LY()
  {
    int i = 0;
    AppMethodBeat.i(144123);
    Object localObject = V8.getFlags();
    ad.i("MicroMsg.V8GCReporter", "initV8GCSpaceSizeFromFlags : %s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      cQW = 1;
      cQX = 8;
      AppMethodBeat.o(144123);
      return;
    }
    localObject = ((String)localObject).split(" ", -1);
    if (i < localObject.length)
    {
      int j = f(localObject[i], "--min_semi_space_size", 1);
      if (j != -2147483648) {
        cQW = j;
      }
      for (;;)
      {
        i += 1;
        break;
        j = f(localObject[i], "--max_semi_space_size", 8);
        if (j != -2147483648) {
          cQX = j;
        }
      }
    }
    AppMethodBeat.o(144123);
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(144122);
    int i;
    if (cQY != null)
    {
      if (cQW <= 0) {
        break label146;
      }
      i = cQW;
      if (cQX <= 0) {
        break label157;
      }
    }
    for (int j = cQX;; j = cQX)
    {
      paramString = String.format("%d,%d,%d,%d,%d,%s,%d,%d,%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      ad.v("MicroMsg.V8GCReporter", "report str:%s", new Object[] { paramString });
      cQY.eW(paramString);
      AppMethodBeat.o(144122);
      return;
      label146:
      LY();
      i = cQW;
      break;
      label157:
      LY();
    }
  }
  
  public static void a(a parama)
  {
    cQY = parama;
  }
  
  private static int f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(144124);
    paramString2 = paramString2 + "=";
    if (paramString1.indexOf(paramString2) >= 0)
    {
      paramInt = bt.getInt(paramString1.replaceFirst(paramString2, ""), paramInt);
      AppMethodBeat.o(144124);
      return paramInt;
    }
    AppMethodBeat.o(144124);
    return -2147483648;
  }
  
  public static abstract interface a
  {
    public abstract void eW(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.x
 * JD-Core Version:    0.7.0.1
 */