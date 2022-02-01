package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
{
  public static int nAa;
  public static long nAb;
  public static long nAc;
  public static long nAd;
  public static int nzU;
  public static int nzV;
  public static int nzW;
  public static int nzX;
  public static int nzY;
  public static int nzZ;
  
  public static void bIx()
  {
    AppMethodBeat.i(21272);
    ae.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(21272);
  }
  
  public static void bIy()
  {
    AppMethodBeat.i(21273);
    ae.d("MicroMsg.TestInfo", "netTime" + (bu.fpO() - nAc));
    AppMethodBeat.o(21273);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(21274);
    String str = "total_count: " + nAa + "text_count: " + nzW + "normal_count : " + nzV + " image_count: " + nzU + " voice_count : " + nzY + " video_count " + nzX + " app_count : " + nzZ + " time: " + (bu.fpO() - nAb) + " net: " + nAd;
    AppMethodBeat.o(21274);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(21271);
    nzU = 0;
    nzV = 0;
    nzW = 0;
    nzX = 0;
    nzY = 0;
    nzZ = 0;
    nAa = 0;
    long l = bu.fpO();
    nAb = l;
    nAd = l - nAc;
    AppMethodBeat.o(21271);
  }
  
  public static void xx(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      nAa += 1;
      return;
      nzW += 1;
      continue;
      nzZ += 1;
      continue;
      nzY += 1;
      continue;
      nzX += 1;
      continue;
      nzU += 1;
      continue;
      nzV += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */