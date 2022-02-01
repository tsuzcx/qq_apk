package com.tencent.matrix.report;

import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/matrix/report/MatrixFinderReporter;", "", "()V", "ID_KEY", "", "KV_ID", "getDeviceLevelIndex", "level", "", "getDeviceLevelIndex2", "isAddressScene", "", "scene", "isCareScene", "isChattingScene", "isFinderAnchorLiveTlScene", "isFinderScene", "isFinderTlScene", "isFinderVisitorLiveTlScene", "isSnsTlScene", "onAnr", "", "onFPS", "content", "Lorg/json/JSONObject;", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i eYD = new i();
  
  public static boolean gZ(String paramString)
  {
    s.u(paramString, "scene");
    return n.a((CharSequence)paramString, (CharSequence)"FinderLiveVisitorWithoutAffinityUI", false);
  }
  
  public static boolean ha(String paramString)
  {
    s.u(paramString, "scene");
    return n.a((CharSequence)paramString, (CharSequence)"FinderLiveAnchorWithoutAffinityUI", false);
  }
  
  public static boolean hb(String paramString)
  {
    s.u(paramString, "scene");
    return n.rs(paramString, "SnsTimeLineUI");
  }
  
  public static boolean hc(String paramString)
  {
    s.u(paramString, "scene");
    return n.a((CharSequence)paramString, (CharSequence)"Finder", false);
  }
  
  public static boolean hd(String paramString)
  {
    s.u(paramString, "scene");
    return (n.rs(paramString, "ChattingUIFragment")) || (n.rs(paramString, "ChattingUI"));
  }
  
  public static boolean he(String paramString)
  {
    s.u(paramString, "scene");
    return n.rs(paramString, "AddressUIFragment");
  }
  
  static int hf(String paramString)
  {
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      return 20;
      if (paramString.equals("HIGH")) {
        do
        {
          return 10;
          if (!paramString.equals("BEST")) {
            break;
          }
          return 0;
        } while (paramString.equals("MIDDLE"));
      }
    }
  }
  
  static int hg(String paramString)
  {
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      return 6;
      if (paramString.equals("HIGH")) {
        do
        {
          return 3;
          if (!paramString.equals("BEST")) {
            break;
          }
          return 0;
        } while (paramString.equals("MIDDLE"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.i
 * JD-Core Version:    0.7.0.1
 */