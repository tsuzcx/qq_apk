package com.tencent.matrix.report;

import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/matrix/report/MatrixFinderReporter;", "", "()V", "ID_KEY", "", "KV_ID", "getDeviceLevelIndex", "level", "", "getDeviceLevelSnsIndex", "isAddressScene", "", "scene", "isCareScene", "isChattingScene", "isFinderScene", "isFinderTlScene", "isSnsTlScene", "onAnr", "", "onFPS", "content", "Lorg/json/JSONObject;", "plugin-report_release"})
public final class e
{
  public static final e cFK = new e();
  
  public static boolean dT(String paramString)
  {
    p.h(paramString, "scene");
    return n.nG(paramString, "SnsTimeLineUI");
  }
  
  public static boolean dU(String paramString)
  {
    p.h(paramString, "scene");
    return n.a((CharSequence)paramString, (CharSequence)"Finder", false);
  }
  
  public static boolean dV(String paramString)
  {
    p.h(paramString, "scene");
    return (n.nG(paramString, "ChattingUIFragment")) || (n.nG(paramString, "ChattingUI"));
  }
  
  public static boolean dW(String paramString)
  {
    p.h(paramString, "scene");
    return n.nG(paramString, "AddressUIFragment");
  }
  
  static int dX(String paramString)
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
  
  static int dY(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.e
 * JD-Core Version:    0.7.0.1
 */