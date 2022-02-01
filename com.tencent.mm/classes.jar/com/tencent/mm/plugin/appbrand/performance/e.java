package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e
  implements Closeable
{
  private final int Mg;
  private volatile RandomAccessFile mms;
  private volatile RandomAccessFile mmt;
  private boolean mmu;
  private long mmv;
  private long mmw;
  private long mmx;
  
  public e(int paramInt)
  {
    this.Mg = paramInt;
  }
  
  public final double bwL()
  {
    AppMethodBeat.i(147594);
    if (this.mmu)
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
        if (this.mmt == null)
        {
          d2 = d3;
          this.mmt = o.dg("/proc/" + this.Mg + "/stat", false);
        }
        d2 = d3;
        this.mmt.seek(0L);
        d2 = d3;
        Object localObject1 = this.mmt.readLine();
        d2 = d3;
        boolean bool = bu.isNullOrNil((String)localObject1);
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
        if (this.mms == null)
        {
          d2 = d3;
          this.mms = o.dg("/proc/stat", false);
        }
        d2 = d3;
        this.mms.seek(0L);
        d2 = d3;
        localObject2 = this.mms.readLine();
        d2 = d3;
        if (!bu.isNullOrNil((String)localObject2)) {
          continue;
        }
        l1 = 0L;
        d2 = d3;
        l2 = bu.aSC(localObject1[13]);
        d2 = d3;
        l3 = bu.aSC(localObject1[14]);
        d1 = d3;
        d2 = d3;
        if (this.mmv != 0L)
        {
          d2 = d3;
          double d4 = (l2 - this.mmw) * 100L / (l1 - this.mmv);
          d2 = d3;
          d1 = (l3 - this.mmx) * 100L / (l1 - this.mmv);
          d2 = d3;
          d4 = Math.max(0.0D, d4);
          d2 = d3;
          d1 = Math.max(0.0D, d1) + d4;
        }
        d2 = d1;
        this.mmv = l1;
        d2 = d1;
        this.mmw = l2;
        d2 = d1;
        this.mmx = l3;
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
        ae.e(" MicroMsg.CpuSampler", "read pid stat file error: ".concat(String.valueOf(localException)));
        this.mmu = true;
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
        l1 = bu.aSC(localObject2[2]);
        d2 = d3;
        l2 = bu.aSC(localObject2[3]);
        d2 = d3;
        l3 = bu.aSC(localObject2[4]);
        d2 = d3;
        l4 = bu.aSC(localObject2[5]);
        d2 = d3;
        l5 = bu.aSC(localObject2[6]);
        d2 = d3;
        l6 = bu.aSC(localObject2[7]);
        d2 = d3;
        l7 = bu.aSC(localObject2[8]);
        d2 = d3;
        l8 = bu.aSC(localObject2[9]);
        l1 = l8 + (l1 + l2 + l3 + l4 + l5 + l6 + l7);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(147595);
    try
    {
      if (this.mmt != null) {
        this.mmt.close();
      }
      try
      {
        label19:
        if (this.mms != null) {
          this.mms.close();
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