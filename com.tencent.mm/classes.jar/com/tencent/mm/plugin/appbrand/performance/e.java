package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements Closeable
{
  private final int Kq;
  private volatile RandomAccessFile lHI;
  private volatile RandomAccessFile lHJ;
  private boolean lHK;
  private long lHL;
  private long lHM;
  private long lHN;
  
  public e(int paramInt)
  {
    this.Kq = paramInt;
  }
  
  public final double brQ()
  {
    AppMethodBeat.i(147594);
    if (this.lHK)
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
        if (this.lHJ == null)
        {
          d2 = d3;
          this.lHJ = i.cY("/proc/" + this.Kq + "/stat", false);
        }
        d2 = d3;
        this.lHJ.seek(0L);
        d2 = d3;
        Object localObject1 = this.lHJ.readLine();
        d2 = d3;
        boolean bool = bs.isNullOrNil((String)localObject1);
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
        if (this.lHI == null)
        {
          d2 = d3;
          this.lHI = i.cY("/proc/stat", false);
        }
        d2 = d3;
        this.lHI.seek(0L);
        d2 = d3;
        localObject2 = this.lHI.readLine();
        d2 = d3;
        if (!bs.isNullOrNil((String)localObject2)) {
          continue;
        }
        l1 = 0L;
        d2 = d3;
        l2 = bs.aLz(localObject1[13]);
        d2 = d3;
        l3 = bs.aLz(localObject1[14]);
        d1 = d3;
        d2 = d3;
        if (this.lHL != 0L)
        {
          d2 = d3;
          double d4 = (l2 - this.lHM) * 100L / (l1 - this.lHL);
          d2 = d3;
          d1 = (l3 - this.lHN) * 100L / (l1 - this.lHL);
          d2 = d3;
          d4 = Math.max(0.0D, d4);
          d2 = d3;
          d1 = Math.max(0.0D, d1) + d4;
        }
        d2 = d1;
        this.lHL = l1;
        d2 = d1;
        this.lHM = l2;
        d2 = d1;
        this.lHN = l3;
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
        ac.e(" MicroMsg.CpuSampler", "read pid stat file error: ".concat(String.valueOf(localException)));
        this.lHK = true;
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
        l1 = bs.aLz(localObject2[2]);
        d2 = d3;
        l2 = bs.aLz(localObject2[3]);
        d2 = d3;
        l3 = bs.aLz(localObject2[4]);
        d2 = d3;
        l4 = bs.aLz(localObject2[5]);
        d2 = d3;
        l5 = bs.aLz(localObject2[6]);
        d2 = d3;
        l6 = bs.aLz(localObject2[7]);
        d2 = d3;
        l7 = bs.aLz(localObject2[8]);
        d2 = d3;
        l8 = bs.aLz(localObject2[9]);
        l1 = l8 + (l1 + l2 + l3 + l4 + l5 + l6 + l7);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(147595);
    try
    {
      if (this.lHJ != null) {
        this.lHJ.close();
      }
      try
      {
        label19:
        if (this.lHI != null) {
          this.lHI.close();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.e
 * JD-Core Version:    0.7.0.1
 */