package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class p
{
  private static String Ul(String paramString)
  {
    AppMethodBeat.i(48072);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(48072);
      return "";
    }
    try
    {
      String str = bt.nullAsNil(q.encode(paramString));
      AppMethodBeat.o(48072);
      return str;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", new Object[] { paramString, localException });
      AppMethodBeat.o(48072);
    }
    return "";
  }
  
  public static Object[] l(Object... paramVarArgs)
  {
    AppMethodBeat.i(48073);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      AppMethodBeat.o(48073);
      return new Object[0];
    }
    Object[] arrayOfObject = new Object[paramVarArgs.length];
    int k = paramVarArgs.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Object localObject2 = paramVarArgs[j];
      Object localObject1;
      if (localObject2 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        arrayOfObject[i] = String.valueOf(localObject1);
        j += 1;
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof String))
        {
          localObject1 = localObject2;
          if (((String)localObject2).contains(",")) {
            localObject1 = Ul((String)localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(48073);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.p
 * JD-Core Version:    0.7.0.1
 */