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
  private final int Jv;
  private volatile RandomAccessFile lhP;
  private volatile RandomAccessFile lhQ;
  private boolean lhR;
  private long lhS;
  private long lhT;
  private long lhU;
  
  public e(int paramInt)
  {
    this.Jv = paramInt;
  }
  
  public final double blb()
  {
    AppMethodBeat.i(147594);
    if (this.lhR)
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
        if (this.lhQ == null)
        {
          d2 = d3;
          this.lhQ = i.cS("/proc/" + this.Jv + "/stat", false);
        }
        d2 = d3;
        this.lhQ.seek(0L);
        d2 = d3;
        Object localObject1 = this.lhQ.readLine();
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
        if (this.lhP == null)
        {
          d2 = d3;
          this.lhP = i.cS("/proc/stat", false);
        }
        d2 = d3;
        this.lhP.seek(0L);
        d2 = d3;
        localObject2 = this.lhP.readLine();
        d2 = d3;
        if (!bt.isNullOrNil((String)localObject2)) {
          continue;
        }
        l1 = 0L;
        d2 = d3;
        l2 = bt.aGi(localObject1[13]);
        d2 = d3;
        l3 = bt.aGi(localObject1[14]);
        d1 = d3;
        d2 = d3;
        if (this.lhS != 0L)
        {
          d2 = d3;
          double d4 = (l2 - this.lhT) * 100L / (l1 - this.lhS);
          d2 = d3;
          d1 = (l3 - this.lhU) * 100L / (l1 - this.lhS);
          d2 = d3;
          d4 = Math.max(0.0D, d4);
          d2 = d3;
          d1 = Math.max(0.0D, d1) + d4;
        }
        d2 = d1;
        this.lhS = l1;
        d2 = d1;
        this.lhT = l2;
        d2 = d1;
        this.lhU = l3;
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
        this.lhR = true;
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
        l1 = bt.aGi(localObject2[2]);
        d2 = d3;
        l2 = bt.aGi(localObject2[3]);
        d2 = d3;
        l3 = bt.aGi(localObject2[4]);
        d2 = d3;
        l4 = bt.aGi(localObject2[5]);
        d2 = d3;
        l5 = bt.aGi(localObject2[6]);
        d2 = d3;
        l6 = bt.aGi(localObject2[7]);
        d2 = d3;
        l7 = bt.aGi(localObject2[8]);
        d2 = d3;
        l8 = bt.aGi(localObject2[9]);
        l1 = l8 + (l1 + l2 + l3 + l4 + l5 + l6 + l7);
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(147595);
    try
    {
      if (this.lhQ != null) {
        this.lhQ.close();
      }
      try
      {
        label19:
        if (this.lhP != null) {
          this.lhP.close();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.e
 * JD-Core Version:    0.7.0.1
 */