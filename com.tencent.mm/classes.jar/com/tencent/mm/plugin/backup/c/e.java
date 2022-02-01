package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  public static int nuA;
  public static int nuB;
  public static int nuC;
  public static int nuD;
  public static int nuE;
  public static int nuF;
  public static long nuG;
  public static long nuH;
  public static long nuI;
  public static int nuz;
  
  public static void bHA()
  {
    AppMethodBeat.i(21273);
    ad.d("MicroMsg.TestInfo", "netTime" + (bt.flT() - nuH));
    AppMethodBeat.o(21273);
  }
  
  public static void bHz()
  {
    AppMethodBeat.i(21272);
    ad.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(21272);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(21274);
    String str = "total_count: " + nuF + "text_count: " + nuB + "normal_count : " + nuA + " image_count: " + nuz + " voice_count : " + nuD + " video_count " + nuC + " app_count : " + nuE + " time: " + (bt.flT() - nuG) + " net: " + nuI;
    AppMethodBeat.o(21274);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(21271);
    nuz = 0;
    nuA = 0;
    nuB = 0;
    nuC = 0;
    nuD = 0;
    nuE = 0;
    nuF = 0;
    long l = bt.flT();
    nuG = l;
    nuI = l - nuH;
    AppMethodBeat.o(21271);
  }
  
  public static void xs(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      nuF += 1;
      return;
      nuB += 1;
      continue;
      nuE += 1;
      continue;
      nuD += 1;
      continue;
      nuC += 1;
      continue;
      nuz += 1;
      continue;
      nuA += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */