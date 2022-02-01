package com.tencent.matrix.report;

import d.g.b.k;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/matrix/report/MatrixFinderReporter;", "", "()V", "ID_KEY", "", "KV_ID", "getDeviceLevelIndex", "level", "", "getDeviceLevelSnsIndex", "isCareScene", "", "scene", "isFinderScene", "isFinderTlScene", "isSnsTlScene", "onAnr", "", "onFPS", "content", "Lorg/json/JSONObject;", "plugin-report_release"})
public final class e
{
  public static final e cui = new e();
  
  public static boolean cN(String paramString)
  {
    k.h(paramString, "scene");
    return n.nc(paramString, "SnsTimeLineUI");
  }
  
  public static boolean cO(String paramString)
  {
    k.h(paramString, "scene");
    return n.a((CharSequence)paramString, (CharSequence)"Finder", false);
  }
  
  static int cP(String paramString)
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
  
  static int cQ(String paramString)
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