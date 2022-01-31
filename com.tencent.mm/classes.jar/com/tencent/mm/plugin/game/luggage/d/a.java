package com.tencent.mm.plugin.game.luggage.d;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Map<Integer, Object>> kNC = new HashMap();
  
  public static void EK(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return;
      paramString = (Map)kNC.remove(Integer.valueOf(paramString.hashCode()));
    } while ((paramString == null) || (paramString.isEmpty()));
    boolean bool = ((Boolean)paramString.remove(Integer.valueOf(a.b.kNN))).booleanValue();
    paramString = y(paramString);
    y.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), paramString });
    h.nFQ.a(16142, paramString, bool, false);
  }
  
  public static void l(String paramString, Map<Integer, Object> paramMap)
  {
    if (bk.bl(paramString)) {
      return;
    }
    kNC.put(Integer.valueOf(paramString.hashCode()), paramMap);
  }
  
  public static String y(Map<Integer, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return "";
    }
    int j = ((Integer)Collections.max(paramMap.keySet())).intValue();
    int i = ((Integer)Collections.min(paramMap.keySet())).intValue();
    j = Math.min(j, 200);
    StringBuffer localStringBuffer = new StringBuffer();
    while (i <= j)
    {
      Object localObject = paramMap.get(Integer.valueOf(i));
      if (localObject != null) {
        localStringBuffer.append(localObject);
      }
      localStringBuffer.append(",");
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  public static enum a
  {
    public static int kND = 21;
    public static int kNE = 22;
    public static int kNF = 23;
    public static int kNG = 24;
    public static int kNH = 25;
    public static int kNI = 26;
    public static int kNJ = 27;
    public static int kNK = 28;
    public static int kNL = 29;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */