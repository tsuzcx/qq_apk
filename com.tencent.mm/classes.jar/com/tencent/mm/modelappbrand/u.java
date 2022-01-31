package com.tencent.mm.modelappbrand;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> dZT = new HashMap();
  private static Map<String, Long> dZU = new HashMap();
  private static Map<String, Long> dZV = new HashMap();
  private static Map<String, Long> dZW = new HashMap();
  private static Map<String, u.a> dZX = new HashMap();
  
  public static void Jz()
  {
    y.i("SearchWidgetStartTrace", "hasInitData %s", new Object[] { Boolean.valueOf(true) });
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    u.a locala2 = (u.a)dZX.get(paramString1);
    u.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new u.a();
    }
    locala1.bOL = paramString2;
    locala1.dWx = paramInt1;
    locala1.dZZ = paramInt2;
    locala1.dZY = paramString3;
    dZX.put(paramString1, locala1);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.e("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
  }
  
  public static void jA(String paramString)
  {
    y.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
  }
  
  public static int jx(String paramString)
  {
    paramString = (u.a)dZX.get(paramString);
    if (paramString != null) {
      return paramString.dWx;
    }
    return 0;
  }
  
  public static String jy(String paramString)
  {
    u.a locala = (u.a)dZX.get(paramString);
    if (locala != null) {
      paramString = locala.dZY;
    }
    return paramString;
  }
  
  public static int jz(String paramString)
  {
    paramString = (u.a)dZX.get(paramString);
    if (paramString != null) {
      return paramString.dZZ;
    }
    return 0;
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    y.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      if (!dZT.containsKey(paramString)) {
        break label65;
      }
    }
    label65:
    for (long l = ((Long)dZT.get(paramString)).longValue(); l > 0L; l = 0L)
    {
      System.currentTimeMillis();
      return;
    }
    y.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */