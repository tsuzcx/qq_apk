package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static int oKS;
  public static int oKT;
  public static int oKU;
  public static int oKV;
  public static int oKW;
  public static int oKX;
  public static int oKY;
  public static long oKZ;
  public static long oLa;
  public static long oLb;
  
  public static void Bd(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      oKY += 1;
      return;
      oKU += 1;
      continue;
      oKX += 1;
      continue;
      oKW += 1;
      continue;
      oKV += 1;
      continue;
      oKS += 1;
      continue;
      oKT += 1;
    }
  }
  
  public static void cfo()
  {
    AppMethodBeat.i(21272);
    Log.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(21272);
  }
  
  public static void cfp()
  {
    AppMethodBeat.i(21273);
    Log.d("MicroMsg.TestInfo", "netTime" + (Util.nowMilliSecond() - oLa));
    AppMethodBeat.o(21273);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(21274);
    String str = "total_count: " + oKY + "text_count: " + oKU + "normal_count : " + oKT + " image_count: " + oKS + " voice_count : " + oKW + " video_count " + oKV + " app_count : " + oKX + " time: " + (Util.nowMilliSecond() - oKZ) + " net: " + oLb;
    AppMethodBeat.o(21274);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(21271);
    oKS = 0;
    oKT = 0;
    oKU = 0;
    oKV = 0;
    oKW = 0;
    oKX = 0;
    oKY = 0;
    long l = Util.nowMilliSecond();
    oKZ = l;
    oLb = l - oLa;
    AppMethodBeat.o(21271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */