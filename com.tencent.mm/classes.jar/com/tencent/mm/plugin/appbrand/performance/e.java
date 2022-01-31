package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements Closeable
{
  private final int iAW;
  private volatile RandomAccessFile iAX;
  private volatile RandomAccessFile iAY;
  private boolean iAZ;
  private long iBa;
  private long iBb;
  private long iBc;
  
  public e(int paramInt)
  {
    this.iAW = paramInt;
  }
  
  public final double aKr()
  {
    AppMethodBeat.i(102242);
    if (this.iAZ)
    {
      AppMethodBeat.o(102242);
      return 0.0D;
    }
    double d3 = 0.0D;
    d2 = d3;
    for (;;)
    {
      try
      {
        if (this.iAY == null)
        {
          d2 = d3;
          this.iAY = new RandomAccessFile("/proc/" + this.iAW + "/stat", "r");
        }
        d2 = d3;
        this.iAY.seek(0L);
        d2 = d3;
        Object localObject1 = this.iAY.readLine();
        d2 = d3;
        boolean bool = bo.isNullOrNil((String)localObject1);
        if (bool)
        {
          AppMethodBeat.o(102242);
          return 0.0D;
        }
        d2 = d3;
        localObject1 = ((String)localObject1).split(" ");
        d2 = d3;
        int i = localObject1.length;
        if (i < 17)
        {
          AppMethodBeat.o(102242);
          return 0.0D;
        }
        d2 = d3;
        if (this.iAX == null)
        {
          d2 = d3;
          this.iAX = new RandomAccessFile("/proc/stat", "r");
        }
        d2 = d3;
        this.iAX.seek(0L);
        d2 = d3;
        localObject2 = this.iAX.readLine();
        d2 = d3;
        if (!bo.isNullOrNil((String)localObject2)) {
          continue;
        }
        l1 = 0L;
        d2 = d3;
        l2 = bo.apW(localObject1[13]);
        d2 = d3;
        l3 = bo.apW(localObject1[14]);
        d1 = d3;
        d2 = d3;
        if (this.iBa != 0L)
        {
          d2 = d3;
          double d4 = (l2 - this.iBb) * 100L / (l1 - this.iBa);
          d2 = d3;
          d1 = (l3 - this.iBc) * 100L / (l1 - this.iBa);
          d2 = d3;
          d4 = Math.max(0.0D, d4);
          d2 = d3;
          d1 = Math.max(0.0D, d1) + d4;
        }
        d2 = d1;
        this.iBa = l1;
        d2 = d1;
        this.iBb = l2;
        d2 = d1;
        this.iBc = l3;
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l8;
        ab.e(" MicroMsg.CpuSampler", "read pid stat file error: ".concat(String.valueOf(localException)));
        this.iAZ = true;
        double d1 = d2;
        continue;
      }
      AppMethodBeat.o(102242);
      return d1;
      d2 = d3;
      localObject2 = ((String)localObject2).split(" ");
      d2 = d3;
      if (localObject2.length < 9)
      {
        l1 = 0L;
      }
      else
      {
        d2 = d3;
        l1 = bo.apW(localObject2[2]);
        d2 = d3;
        l2 = bo.apW(localObject2[3]);
        d2 = d3;
        l3 = bo.apW(localObject2[4]);
        d2 = d3;
        l4 = bo.apW(localObject2[5]);
        d2 = d3;
        l5 = bo.apW(localObject2[6]);
        d2 = d3;
        l6 = bo.apW(localObject2[7]);
        d2 = d3;
        l7 = bo.apW(localObject2[8]);
        d2 = d3;
        l8 = bo.apW(localObject2[9]);
        l1 = l8 + (l1 + l2 + l3 + l4 + l5 + l6 + l7);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(140978);
    try
    {
      if (this.iAY != null) {
        this.iAY.close();
      }
      try
      {
        label19:
        if (this.iAX != null) {
          this.iAX.close();
        }
        AppMethodBeat.o(140978);
        return;
      }
      catch (IOException localIOException1)
      {
        AppMethodBeat.o(140978);
        return;
      }
    }
    catch (IOException localIOException2)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.e
 * JD-Core Version:    0.7.0.1
 */