package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements Closeable
{
  private final int Mg;
  private volatile RandomAccessFile mht;
  private volatile RandomAccessFile mhu;
  private boolean mhv;
  private long mhw;
  private long mhx;
  private long mhy;
  
  public e(int paramInt)
  {
    this.Mg = paramInt;
  }
  
  public final double bvU()
  {
    AppMethodBeat.i(147594);
    if (this.mhv)
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
        if (this.mhu == null)
        {
          d2 = d3;
          this.mhu = i.dd("/proc/" + this.Mg + "/stat", false);
        }
        d2 = d3;
        this.mhu.seek(0L);
        d2 = d3;
        Object localObject1 = this.mhu.readLine();
        d2 = d3;
        boolean bool = bt.isNullOrNil((String)localObject1);
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
        if (this.mht == null)
        {
          d2 = d3;
          this.mht = i.dd("/proc/stat", false);
        }
        d2 = d3;
        this.mht.seek(0L);
        d2 = d3;
        localObject2 = this.mht.readLine();
        d2 = d3;
        if (!bt.isNullOrNil((String)localObject2)) {
          continue;
        }
        l1 = 0L;
        d2 = d3;
        l2 = bt.aRf(localObject1[13]);
        d2 = d3;
        l3 = bt.aRf(localObject1[14]);
        d1 = d3;
        d2 = d3;
        if (this.mhw != 0L)
        {
          d2 = d3;
          double d4 = (l2 - this.mhx) * 100L / (l1 - this.mhw);
          d2 = d3;
          d1 = (l3 - this.mhy) * 100L / (l1 - this.mhw);
          d2 = d3;
          d4 = Math.max(0.0D, d4);
          d2 = d3;
          d1 = Math.max(0.0D, d1) + d4;
        }
        d2 = d1;
        this.mhw = l1;
        d2 = d1;
        this.mhx = l2;
        d2 = d1;
        this.mhy = l3;
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
        ad.e(" MicroMsg.CpuSampler", "read pid stat file error: ".concat(String.valueOf(localException)));
        this.mhv = true;
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
        l1 = bt.aRf(localObject2[2]);
        d2 = d3;
        l2 = bt.aRf(localObject2[3]);
        d2 = d3;
        l3 = bt.aRf(localObject2[4]);
        d2 = d3;
        l4 = bt.aRf(localObject2[5]);
        d2 = d3;
        l5 = bt.aRf(localObject2[6]);
        d2 = d3;
        l6 = bt.aRf(localObject2[7]);
        d2 = d3;
        l7 = bt.aRf(localObject2[8]);
        d2 = d3;
        l8 = bt.aRf(localObject2[9]);
        l1 = l8 + (l1 + l2 + l3 + l4 + l5 + l6 + l7);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(147595);
    try
    {
      if (this.mhu != null) {
        this.mhu.close();
      }
      try
      {
        label19:
        if (this.mht != null) {
          this.mht.close();
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