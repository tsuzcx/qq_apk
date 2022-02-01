package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static int rMJ;
  public static int rMK;
  public static int rML;
  public static int rMM;
  public static int rMN;
  public static int rMO;
  public static long rMP;
  public static long rMQ;
  public static long rMR;
  public static int video_count;
  
  public static void EE(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      rMO += 1;
      return;
      rML += 1;
      continue;
      rMN += 1;
      continue;
      rMM += 1;
      continue;
      video_count += 1;
      continue;
      rMJ += 1;
      continue;
      rMK += 1;
    }
  }
  
  public static void csB()
  {
    AppMethodBeat.i(21272);
    Log.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(21272);
  }
  
  public static void csC()
  {
    AppMethodBeat.i(21273);
    Log.d("MicroMsg.TestInfo", "netTime" + (Util.nowMilliSecond() - rMQ));
    AppMethodBeat.o(21273);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(21274);
    String str = "total_count: " + rMO + "text_count: " + rML + "normal_count : " + rMK + " image_count: " + rMJ + " voice_count : " + rMM + " video_count " + video_count + " app_count : " + rMN + " time: " + (Util.nowMilliSecond() - rMP) + " net: " + rMR;
    AppMethodBeat.o(21274);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(21271);
    rMJ = 0;
    rMK = 0;
    rML = 0;
    video_count = 0;
    rMM = 0;
    rMN = 0;
    rMO = 0;
    long l = Util.nowMilliSecond();
    rMP = l;
    rMR = l - rMQ;
    AppMethodBeat.o(21271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */