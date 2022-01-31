package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
{
  public static int jAD;
  public static int jAE;
  public static int jAF;
  public static int jAG;
  public static int jAH;
  public static int jAI;
  public static int jAJ;
  public static long jAK;
  public static long jAL;
  public static long jAM;
  
  public static void aTk()
  {
    AppMethodBeat.i(17218);
    ab.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(17218);
  }
  
  public static void aTl()
  {
    AppMethodBeat.i(17219);
    ab.d("MicroMsg.TestInfo", "netTime" + (bo.aoy() - jAL));
    AppMethodBeat.o(17219);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(17220);
    String str = "total_count: " + jAJ + "text_count: " + jAF + "normal_count : " + jAE + " image_count: " + jAD + " voice_count : " + jAH + " video_count " + jAG + " app_count : " + jAI + " time: " + (bo.aoy() - jAK) + " net: " + jAM;
    AppMethodBeat.o(17220);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(17217);
    jAD = 0;
    jAE = 0;
    jAF = 0;
    jAG = 0;
    jAH = 0;
    jAI = 0;
    jAJ = 0;
    long l = bo.aoy();
    jAK = l;
    jAM = l - jAL;
    AppMethodBeat.o(17217);
  }
  
  public static void ri(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      jAJ += 1;
      return;
      jAF += 1;
      continue;
      jAI += 1;
      continue;
      jAH += 1;
      continue;
      jAG += 1;
      continue;
      jAD += 1;
      continue;
      jAE += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */