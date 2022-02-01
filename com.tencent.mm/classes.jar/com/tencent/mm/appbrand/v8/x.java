package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class x
{
  private static int hoj = -1;
  private static int hok = -1;
  private static a hol;
  
  public static void a(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(144122);
    int i;
    if (hol != null)
    {
      if (hoj <= 0) {
        break label146;
      }
      i = hoj;
      if (hok <= 0) {
        break label157;
      }
    }
    for (int j = hok;; j = hok)
    {
      paramString = String.format("%d,%d,%d,%d,%d,%s,%d,%d,%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      Log.v("MicroMsg.V8GCReporter", "report str:%s", new Object[] { paramString });
      hol.iM(paramString);
      AppMethodBeat.o(144122);
      return;
      label146:
      aEu();
      i = hoj;
      break;
      label157:
      aEu();
    }
  }
  
  public static void a(a parama)
  {
    hol = parama;
  }
  
  private static void aEu()
  {
    int i = 0;
    AppMethodBeat.i(144123);
    Object localObject = V8.getFlags();
    Log.i("MicroMsg.V8GCReporter", "initV8GCSpaceSizeFromFlags : %s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      hoj = 1;
      hok = 8;
      AppMethodBeat.o(144123);
      return;
    }
    localObject = ((String)localObject).split(" ", -1);
    if (i < localObject.length)
    {
      int j = h(localObject[i], "--min_semi_space_size", 1);
      if (j != -2147483648) {
        hoj = j;
      }
      for (;;)
      {
        i += 1;
        break;
        j = h(localObject[i], "--max_semi_space_size", 8);
        if (j != -2147483648) {
          hok = j;
        }
      }
    }
    AppMethodBeat.o(144123);
  }
  
  private static int h(String paramString1, String paramString2, int paramInt)
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
    public abstract void iM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.x
 * JD-Core Version:    0.7.0.1
 */