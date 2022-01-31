package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.LinkedList;

public final class c
{
  private static final LinkedList<Runnable> gWF = new LinkedList();
  private static final c.a gWG = new c.a((byte)0);
  private static boolean gWH = false;
  private final c.b gWD;
  private final String gWE;
  private final String mAppId;
  
  private c(c.b paramb, String paramString1, String paramString2)
  {
    this.gWD = paramb;
    this.mAppId = paramString1;
    this.gWE = paramString2;
  }
  
  public static void a(String paramString1, String paramString2, c.b paramb)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return;
    }
    paramb = new c.4(paramString1, paramString2, paramb);
    com.tencent.mm.plugin.appbrand.v.c.DS().O(new c.5(paramb, paramString1, paramString2));
  }
  
  public static boolean bZ(String paramString1, String paramString2)
  {
    return gWG.ca(paramString1, paramString2);
  }
  
  public static void vW(String paramString)
  {
    c.a locala = gWG;
    if (!bk.bl(paramString)) {
      try
      {
        locala.gWQ.remove(paramString);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.c
 * JD-Core Version:    0.7.0.1
 */