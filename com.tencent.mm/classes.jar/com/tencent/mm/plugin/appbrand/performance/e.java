package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements Closeable
{
  private final int acw;
  private volatile RandomAccessFile qyU;
  private volatile RandomAccessFile qyV;
  private boolean qyW;
  private long qyX;
  private long qyY;
  private long qyZ;
  
  public e(int paramInt)
  {
    this.acw = paramInt;
  }
  
  public final double cfX()
  {
    AppMethodBeat.i(147594);
    if (this.qyW)
    {
      AppMethodBeat.o(147594);
      return 0.0D;
    }
    double d3 = 0.0D;
    d2 = d3;
    for (;;)
    {
      try
      {
        if (this.qyV == null)
        {
          d2 = d3;
          this.qyV = u.dO("/proc/" + this.acw + "/stat", false);
        }
        d2 = d3;
        this.qyV.seek(0L);
        d2 = d3;
        Object localObject1 = this.qyV.readLine();
        d2 = d3;
        boolean bool = Util.isNullOrNil((String)localObject1);
        if (bool)
        {
          AppMethodBeat.o(147594);
          return 0.0D;
        }
        d2 = d3;
        localObject1 = ((String)localObject1).split(" ");
        d2 = d3;
        int i = localObject1.length;
        if (i < 17)
        {
          AppMethodBeat.o(147594);
          return 0.0D;
        }
        d2 = d3;
        if (this.qyU == null)
        {
          d2 = d3;
          this.qyU = u.dO("/proc/stat", false);
        }
        d2 = d3;
        this.qyU.seek(0L);
        d2 = d3;
        localObject2 = this.qyU.readLine();
        d2 = d3;
        if (!Util.isNullOrNil((String)localObject2)) {
          continue;
        }
        l1 = 0L;
        d2 = d3;
        l2 = Util.safeParseLong(localObject1[13]);
        d2 = d3;
        l3 = Util.safeParseLong(localObject1[14]);
        d1 = d3;
        d2 = d3;
        if (this.qyX != 0L)
        {
          d2 = d3;
          double d4 = (l2 - this.qyY) * 100L / (l1 - this.qyX);
          d2 = d3;
          d1 = (l3 - this.qyZ) * 100L / (l1 - this.qyX);
          d2 = d3;
          d4 = Math.max(0.0D, d4);
          d2 = d3;
          d1 = Math.max(0.0D, d1) + d4;
        }
        d2 = d1;
        this.qyX = l1;
        d2 = d1;
        this.qyY = l2;
        d2 = d1;
        this.qyZ = l3;
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
        Log.e(" MicroMsg.CpuSampler", "read pid stat file error: ".concat(String.valueOf(localException)));
        this.qyW = true;
        double d1 = d2;
        continue;
      }
      AppMethodBeat.o(147594);
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
        l1 = Util.safeParseLong(localObject2[2]);
        d2 = d3;
        l2 = Util.safeParseLong(localObject2[3]);
        d2 = d3;
        l3 = Util.safeParseLong(localObject2[4]);
        d2 = d3;
        l4 = Util.safeParseLong(localObject2[5]);
        d2 = d3;
        l5 = Util.safeParseLong(localObject2[6]);
        d2 = d3;
        l6 = Util.safeParseLong(localObject2[7]);
        d2 = d3;
        l7 = Util.safeParseLong(localObject2[8]);
        d2 = d3;
        l8 = Util.safeParseLong(localObject2[9]);
        l1 = l8 + (l1 + l2 + l3 + l4 + l5 + l6 + l7);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(147595);
    try
    {
      if (this.qyV != null) {
        this.qyV.close();
      }
      try
      {
        label19:
        if (this.qyU != null) {
          this.qyU.close();
        }
        AppMethodBeat.o(147595);
        return;
      }
      catch (IOException localIOException1)
      {
        AppMethodBeat.o(147595);
        return;
      }
    }
    catch (IOException localIOException2)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.e
 * JD-Core Version:    0.7.0.1
 */