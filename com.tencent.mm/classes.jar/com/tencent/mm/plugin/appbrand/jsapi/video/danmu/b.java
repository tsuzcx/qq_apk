package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.mm.cb.a;

public final class b
{
  public static int gFp = 18;
  public static int gFq = 10;
  private static int gFr = 3;
  
  public static int ala()
  {
    return gFr;
  }
  
  public static float co(Context paramContext)
  {
    return a.fromDPToPix(paramContext, gFp) * 2.0F;
  }
  
  public static int y(Context paramContext, int paramInt)
  {
    return a.fromDPToPix(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b
 * JD-Core Version:    0.7.0.1
 */