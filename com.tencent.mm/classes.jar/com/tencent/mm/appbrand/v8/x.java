package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class x
{
  private static int daG = -1;
  private static int daH = -1;
  private static a daI;
  
  private static void ND()
  {
    int i = 0;
    AppMethodBeat.i(144123);
    Object localObject = V8.getFlags();
    ae.i("MicroMsg.V8GCReporter", "initV8GCSpaceSizeFromFlags : %s", new Object[] { localObject });
    if (bu.isNullOrNil((String)localObject))
    {
      daG = 1;
      daH = 8;
      AppMethodBeat.o(144123);
      return;
    }
    localObject = ((String)localObject).split(" ", -1);
    if (i < localObject.length)
    {
      int j = f(localObject[i], "--min_semi_space_size", 1);
      if (j != -2147483648) {
        daG = j;
      }
      for (;;)
      {
        i += 1;
        break;
        j = f(localObject[i], "--max_semi_space_size", 8);
        if (j != -2147483648) {
          daH = j;
        }
      }
    }
    AppMethodBeat.o(144123);
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(144122);
    int i;
    if (daI != null)
    {
      if (daG <= 0) {
        break label146;
      }
      i = daG;
      if (daH <= 0) {
        break label157;
      }
    }
    for (int j = daH;; j = daH)
    {
      paramString = String.format("%d,%d,%d,%d,%d,%s,%d,%d,%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      ae.v("MicroMsg.V8GCReporter", "report str:%s", new Object[] { paramString });
      daI.fN(paramString);
      AppMethodBeat.o(144122);
      return;
      label146:
      ND();
      i = daG;
      break;
      label157:
      ND();
    }
  }
  
  public static void a(a parama)
  {
    daI = parama;
  }
  
  private static int f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(144124);
    paramString2 = paramString2 + "=";
    if (paramString1.indexOf(paramString2) >= 0)
    {
      paramInt = bu.getInt(paramString1.replaceFirst(paramString2, ""), paramInt);
      AppMethodBeat.o(144124);
      return paramInt;
    }
    AppMethodBeat.o(144124);
    return -2147483648;
  }
  
  public static abstract interface a
  {
    public abstract void fN(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.x
 * JD-Core Version:    0.7.0.1
 */