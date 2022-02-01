package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static int uXX;
  public static int uXY;
  public static int uXZ;
  public static int uYa;
  public static int uYb;
  public static int uYc;
  public static long uYd;
  public static long uYe;
  public static long uYf;
  public static int video_count;
  
  public static void Ff(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      uYc += 1;
      return;
      uXZ += 1;
      continue;
      uYb += 1;
      continue;
      uYa += 1;
      continue;
      video_count += 1;
      continue;
      uXX += 1;
      continue;
      uXY += 1;
    }
  }
  
  public static void cVl()
  {
    AppMethodBeat.i(21272);
    Log.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(21272);
  }
  
  public static void cVm()
  {
    AppMethodBeat.i(21273);
    Log.d("MicroMsg.TestInfo", "netTime" + (Util.nowMilliSecond() - uYe));
    AppMethodBeat.o(21273);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(21274);
    String str = "total_count: " + uYc + "text_count: " + uXZ + "normal_count : " + uXY + " image_count: " + uXX + " voice_count : " + uYa + " video_count " + video_count + " app_count : " + uYb + " time: " + (Util.nowMilliSecond() - uYd) + " net: " + uYf;
    AppMethodBeat.o(21274);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(21271);
    uXX = 0;
    uXY = 0;
    uXZ = 0;
    video_count = 0;
    uYa = 0;
    uYb = 0;
    uYc = 0;
    long l = Util.nowMilliSecond();
    uYd = l;
    uYf = l - uYe;
    AppMethodBeat.o(21271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */