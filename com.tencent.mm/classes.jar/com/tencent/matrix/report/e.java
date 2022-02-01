package com.tencent.matrix.report;

import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/matrix/report/MatrixFinderReporter;", "", "()V", "ID_KEY", "", "KV_ID", "getDeviceLevelIndex", "level", "", "getDeviceLevelSnsIndex", "isAddressScene", "", "scene", "isCareScene", "isChattingScene", "isFinderScene", "isFinderTlScene", "isSnsTlScene", "onAnr", "", "onFPS", "content", "Lorg/json/JSONObject;", "plugin-report_release"})
public final class e
{
  public static final e cWi = new e();
  
  public static boolean eD(String paramString)
  {
    p.h(paramString, "scene");
    return n.K(paramString, "SnsTimeLineUI", false);
  }
  
  public static boolean eE(String paramString)
  {
    p.h(paramString, "scene");
    return n.a((CharSequence)paramString, (CharSequence)"Finder", false);
  }
  
  public static boolean eF(String paramString)
  {
    boolean bool = false;
    p.h(paramString, "scene");
    if ((n.K(paramString, "ChattingUIFragment", false)) || (n.K(paramString, "ChattingUI", false))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean eG(String paramString)
  {
    p.h(paramString, "scene");
    return n.K(paramString, "AddressUIFragment", false);
  }
  
  static int eH(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
    case 2217378: 
      do
      {
        return 20;
      } while (!paramString.equals("HIGH"));
    }
    for (;;)
    {
      return 10;
      if (!paramString.equals("BEST")) {
        break;
      }
      return 0;
      if (!paramString.equals("MIDDLE")) {
        break;
      }
    }
  }
  
  static int eI(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
    case 2217378: 
      do
      {
        return 6;
      } while (!paramString.equals("HIGH"));
    }
    for (;;)
    {
      return 3;
      if (!paramString.equals("BEST")) {
        break;
      }
      return 0;
      if (!paramString.equals("MIDDLE")) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.e
 * JD-Core Version:    0.7.0.1
 */