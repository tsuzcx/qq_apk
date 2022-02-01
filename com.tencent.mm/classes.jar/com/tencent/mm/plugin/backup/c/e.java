package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  public static int msa;
  public static int msb;
  public static int msc;
  public static int msd;
  public static int mse;
  public static int msf;
  public static int msg;
  public static long msh;
  public static long msi;
  public static long msj;
  
  public static void bwv()
  {
    AppMethodBeat.i(21272);
    ad.d("MicroMsg.TestInfo", getInfo());
    AppMethodBeat.o(21272);
  }
  
  public static void bww()
  {
    AppMethodBeat.i(21273);
    ad.d("MicroMsg.TestInfo", "netTime" + (bt.eGO() - msi));
    AppMethodBeat.o(21273);
  }
  
  private static String getInfo()
  {
    AppMethodBeat.i(21274);
    String str = "total_count: " + msg + "text_count: " + msc + "normal_count : " + msb + " image_count: " + msa + " voice_count : " + mse + " video_count " + msd + " app_count : " + msf + " time: " + (bt.eGO() - msh) + " net: " + msj;
    AppMethodBeat.o(21274);
    return str;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(21271);
    msa = 0;
    msb = 0;
    msc = 0;
    msd = 0;
    mse = 0;
    msf = 0;
    msg = 0;
    long l = bt.eGO();
    msh = l;
    msj = l - msi;
    AppMethodBeat.o(21271);
  }
  
  public static void vV(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      msg += 1;
      return;
      msc += 1;
      continue;
      msf += 1;
      continue;
      mse += 1;
      continue;
      msd += 1;
      continue;
      msa += 1;
      continue;
      msb += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */