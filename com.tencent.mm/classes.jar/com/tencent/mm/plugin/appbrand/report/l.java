package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
{
  private static String EG(String paramString)
  {
    AppMethodBeat.i(132569);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132569);
      return "";
    }
    try
    {
      String str = bo.nullAsNil(q.encode(paramString));
      AppMethodBeat.o(132569);
      return str;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", new Object[] { paramString, localException });
      AppMethodBeat.o(132569);
    }
    return "";
  }
  
  public static Object[] k(Object... paramVarArgs)
  {
    AppMethodBeat.i(132570);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      AppMethodBeat.o(132570);
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
            localObject1 = EG((String)localObject2);
          }
        }
      }
    }
    AppMethodBeat.o(132570);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.l
 * JD-Core Version:    0.7.0.1
 */