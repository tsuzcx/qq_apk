package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  public static Object[] j(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
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
        if ((localObject2 instanceof String)) {
          if (!((String)localObject2).contains(","))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).contains("/")) {}
          }
          else
          {
            localObject1 = wb((String)localObject2);
          }
        }
      }
    }
    return arrayOfObject;
  }
  
  private static String wb(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      String str = bk.pm(q.encode(paramString));
      return str;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", new Object[] { paramString, localException });
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */