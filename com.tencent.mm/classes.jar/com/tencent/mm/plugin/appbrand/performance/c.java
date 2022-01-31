package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.RandomAccessFile;

public final class c
{
  private final int gWr;
  private volatile RandomAccessFile gWs;
  private volatile RandomAccessFile gWt;
  private boolean gWu;
  private long gWv;
  private long gWw;
  private long gWx;
  
  public c(int paramInt)
  {
    this.gWr = paramInt;
  }
  
  public final double anI()
  {
    if (this.gWu) {
      return 0.0D;
    }
    double d3 = 0.0D;
    double d2 = d3;
    for (;;)
    {
      long l1;
      long l2;
      long l3;
      try
      {
        if (this.gWt == null)
        {
          d2 = d3;
          this.gWt = new RandomAccessFile("/proc/" + this.gWr + "/stat", "r");
        }
        d2 = d3;
        this.gWt.seek(0L);
        d2 = d3;
        Object localObject1 = this.gWt.readLine();
        d2 = d3;
        if (bk.bl((String)localObject1)) {
          return 0.0D;
        }
        d2 = d3;
        localObject1 = ((String)localObject1).split(" ");
        d2 = d3;
        if (localObject1.length < 17) {
          return 0.0D;
        }
        d2 = d3;
        if (this.gWs == null)
        {
          d2 = d3;
          this.gWs = new RandomAccessFile("/proc/stat", "r");
        }
        d2 = d3;
        this.gWs.seek(0L);
        d2 = d3;
        localObject2 = this.gWs.readLine();
        d2 = d3;
        if (bk.bl((String)localObject2))
        {
          l1 = 0L;
          d2 = d3;
          l2 = bk.ZS(localObject1[13]);
          d2 = d3;
          l3 = bk.ZS(localObject1[14]);
          double d1 = d3;
          d2 = d3;
          if (this.gWv != 0L)
          {
            d2 = d3;
            double d4 = (l2 - this.gWw) * 100L / (l1 - this.gWv);
            d2 = d3;
            d1 = (l3 - this.gWx) * 100L / (l1 - this.gWv);
            d2 = d3;
            d4 = Math.max(0.0D, d4);
            d2 = d3;
            d1 = Math.max(0.0D, d1) + d4;
          }
          d2 = d1;
          this.gWv = l1;
          d2 = d1;
          this.gWw = l2;
          d2 = d1;
          this.gWx = l3;
          return d1;
        }
      }
      catch (Exception localException)
      {
        y.e(" MicroMsg.CpuSampler", "read pid stat file error: " + localException);
        this.gWu = true;
        return d2;
      }
      d2 = d3;
      Object localObject2 = ((String)localObject2).split(" ");
      d2 = d3;
      if (localObject2.length < 9)
      {
        l1 = 0L;
      }
      else
      {
        d2 = d3;
        l1 = bk.ZS(localObject2[2]);
        d2 = d3;
        l2 = bk.ZS(localObject2[3]);
        d2 = d3;
        l3 = bk.ZS(localObject2[4]);
        d2 = d3;
        long l4 = bk.ZS(localObject2[5]);
        d2 = d3;
        long l5 = bk.ZS(localObject2[6]);
        d2 = d3;
        long l6 = bk.ZS(localObject2[7]);
        d2 = d3;
        long l7 = bk.ZS(localObject2[8]);
        d2 = d3;
        long l8 = bk.ZS(localObject2[9]);
        l1 = l8 + (l1 + l2 + l3 + l4 + l5 + l6 + l7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.c
 * JD-Core Version:    0.7.0.1
 */