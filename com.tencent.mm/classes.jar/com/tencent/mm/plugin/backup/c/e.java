package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public static int hHh;
  public static int hHi;
  public static int hHj;
  public static int hHk;
  public static int hHl;
  public static int hHm;
  public static int hHn;
  public static long hHo;
  public static long hHp;
  public static long hHq;
  
  public static void atM()
  {
    y.d("MicroMsg.TestInfo", "total_count: " + hHn + "text_count: " + hHj + "normal_count : " + hHi + " image_count: " + hHh + " voice_count : " + hHl + " video_count " + hHk + " app_count : " + hHm + " time: " + (bk.UY() - hHo) + " net: " + hHq);
  }
  
  public static void atN()
  {
    y.d("MicroMsg.TestInfo", "netTime" + (bk.UY() - hHp));
  }
  
  public static void nw(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      hHn += 1;
      return;
      hHj += 1;
      continue;
      hHm += 1;
      continue;
      hHl += 1;
      continue;
      hHk += 1;
      continue;
      hHh += 1;
      continue;
      hHi += 1;
    }
  }
  
  public static void reset()
  {
    hHh = 0;
    hHi = 0;
    hHj = 0;
    hHk = 0;
    hHl = 0;
    hHm = 0;
    hHn = 0;
    long l = bk.UY();
    hHo = l;
    hHq = l - hHp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.e
 * JD-Core Version:    0.7.0.1
 */