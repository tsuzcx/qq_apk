package com.tencent.matrix.report;

import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/matrix/report/MatrixFinderReporter;", "", "()V", "ID_KEY", "", "KV_ID", "getDeviceLevelIndex", "level", "", "getDeviceLevelSnsIndex", "isAddressScene", "", "scene", "isCareScene", "isChattingScene", "isFinderScene", "isFinderTlScene", "isSnsTlScene", "onAnr", "", "onFPS", "content", "Lorg/json/JSONObject;", "plugin-report_release"})
public final class h
{
  public static final h dad = new h();
  
  public static boolean fA(String paramString)
  {
    p.k(paramString, "scene");
    return (n.pu(paramString, "ChattingUIFragment")) || (n.pu(paramString, "ChattingUI"));
  }
  
  public static boolean fB(String paramString)
  {
    p.k(paramString, "scene");
    return n.pu(paramString, "AddressUIFragment");
  }
  
  static int fC(String paramString)
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
  
  static int fD(String paramString)
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
  
  public static boolean fy(String paramString)
  {
    p.k(paramString, "scene");
    return n.pu(paramString, "SnsTimeLineUI");
  }
  
  public static boolean fz(String paramString)
  {
    p.k(paramString, "scene");
    return n.a((CharSequence)paramString, (CharSequence)"Finder", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.h
 * JD-Core Version:    0.7.0.1
 */