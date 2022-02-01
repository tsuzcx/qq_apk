package com.tencent.matrix.report;

import com.tencent.matrix.e.a.a;
import com.tencent.mm.autogen.mmdata.rpt.nt;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class m
{
  private static boolean eYU = true;
  
  public static void g(String paramString, JSONObject paramJSONObject)
  {
    int i;
    if (paramString.endsWith("SnsTimeLineUI")) {
      if (eYU)
      {
        eYU = false;
        i = 0;
      }
    }
    while (i == 0)
    {
      Log.d("MatrixSnsReporter", "onSnsFPS ignore.");
      return;
      i = 1;
      continue;
      eYU = true;
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
      paramString = new nt();
      paramString.jfS = ((int)(d1 * 100.0D));
      paramString.jfT = i;
      paramString.jfU = j;
      paramString.jfV = k;
      paramString.jfW = m;
      paramString.jfX = n;
      paramString.jfY = i1;
      paramString.jfZ = ((int)(100.0D * d2));
      paramString.bMH();
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MatrixSnsReporter", paramString, "data:%s", new Object[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.m
 * JD-Core Version:    0.7.0.1
 */