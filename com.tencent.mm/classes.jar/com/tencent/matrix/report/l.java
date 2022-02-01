package com.tencent.matrix.report;

import com.tencent.matrix.e.a.a;
import com.tencent.mm.f.b.a.kv;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class l
{
  private static boolean dau = true;
  
  public static void g(String paramString, JSONObject paramJSONObject)
  {
    int i;
    if (paramString.endsWith("SnsTimeLineUI")) {
      if (dau)
      {
        dau = false;
        i = 0;
      }
    }
    while (i == 0)
    {
      Log.d("MatrixSnsReporter", "onSnsFPS ignore.");
      return;
      i = 1;
      continue;
      dau = true;
      i = 0;
    }
    try
    {
      double d1 = paramJSONObject.getDouble("fps");
      i = ((a.a)paramJSONObject.get("machine")).value;
      paramString = paramJSONObject.getJSONObject("dropLevel");
      int j = paramString.getInt("DROPPED_BEST");
      int k = paramString.getInt("DROPPED_NORMAL");
      int m = paramString.getInt("DROPPED_MIDDLE");
      int n = paramString.getInt("DROPPED_HIGH");
      int i1 = paramString.getInt("DROPPED_FROZEN");
      int i2 = k + m + n + i1;
      float f1 = 1.0F * k / i2;
      float f2 = 14.0F * m / i2;
      float f3 = 25.0F * n / i2;
      double d2 = 60.0F * i1 / i2 + (f1 + f2 + f3);
      paramString = new kv();
      paramString.gPc = ((int)(d1 * 100.0D));
      paramString.gPd = i;
      paramString.gPe = j;
      paramString.gPf = k;
      paramString.gPg = m;
      paramString.gPh = n;
      paramString.gPi = i1;
      paramString.gPj = ((int)(100.0D * d2));
      paramString.bpa();
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MatrixSnsReporter", paramString, "data:%s", new Object[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.l
 * JD-Core Version:    0.7.0.1
 */