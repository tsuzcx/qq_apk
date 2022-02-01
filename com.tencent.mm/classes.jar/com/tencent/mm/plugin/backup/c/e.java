package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
{
  public static int mUb;
  public static int mUc;
  public static int mUd;
  public static int mUe;
  public static int mUf;
  public static int mUg;
  public static int mUh;
  public static long mUi;
  public static long mUj;
  public static long mUk;
  
  public static void bDr()
  {
    AppMethodBeat.i(21272);
    ac.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(21272);
  }
  
  public static void bDs()
  {
    AppMethodBeat.i(21273);
    ac.d("MicroMsg.TestInfo", "netTime" + (bs.eWj() - mUj));
    AppMethodBeat.o(21273);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(21274);
    String str = "total_count: " + mUh + "text_count: " + mUd + "normal_count : " + mUc + " image_count: " + mUb + " voice_count : " + mUf + " video_count " + mUe + " app_count : " + mUg + " time: " + (bs.eWj() - mUi) + " net: " + mUk;
    AppMethodBeat.o(21274);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(21271);
    mUb = 0;
    mUc = 0;
    mUd = 0;
    mUe = 0;
    mUf = 0;
    mUg = 0;
    mUh = 0;
    long l = bs.eWj();
    mUi = l;
    mUk = l - mUj;
    AppMethodBeat.o(21271);
  }
  
  public static void wM(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      mUh += 1;
      return;
      mUd += 1;
      continue;
      mUg += 1;
      continue;
      mUf += 1;
      continue;
      mUe += 1;
      continue;
      mUb += 1;
      continue;
      mUc += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */