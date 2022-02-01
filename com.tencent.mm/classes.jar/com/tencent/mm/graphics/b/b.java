package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  implements a
{
  private Context guB;
  private List<Double> guC;
  private int guD;
  public double guE;
  public double guF;
  public double guG;
  public double guH;
  public double guI;
  
  static
  {
    AppMethodBeat.i(136198);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(136198);
      return;
    }
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(136194);
    this.guC = new ArrayList(100);
    this.guD = 0;
    this.guE = 0.0D;
    this.guF = 0.0D;
    this.guG = 2147483647.0D;
    this.guH = 0.0D;
    this.guI = 0.0D;
    this.guB = paramContext;
    this.guE = cl(paramContext);
    ad.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.guE);
    AppMethodBeat.o(136194);
  }
  
  private static double cl(Context paramContext)
  {
    AppMethodBeat.i(136197);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if ((!$assertionsDisabled) && (paramContext == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(136197);
      throw paramContext;
    }
    paramContext.getMemoryInfo(localMemoryInfo);
    double d = (localMemoryInfo.totalMem - localMemoryInfo.availMem) / 1024.0D / 1024.0D;
    AppMethodBeat.o(136197);
    return d;
  }
  
  public final void ahc()
  {
    AppMethodBeat.i(136195);
    this.guD = this.guC.size();
    if (this.guD == 0)
    {
      ad.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      AppMethodBeat.o(136195);
      return;
    }
    Iterator localIterator = this.guC.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.guF = Math.max(this.guF, localDouble2.doubleValue());
      this.guG = Math.min(this.guG, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.guD);
    this.guI = (localDouble1.doubleValue() - this.guE);
    this.guF -= this.guE;
    this.guG -= this.guE;
    localIterator = this.guC.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.guH = Math.sqrt(l / this.guD);
    AppMethodBeat.o(136195);
  }
  
  public final void ahd()
  {
    AppMethodBeat.i(136196);
    if (this.guC == null)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.guC.size() > 10000)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.guB != null)
    {
      double d = cl(this.guB);
      this.guE = Math.min(d, this.guE);
      if (this.guE == d) {
        ad.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.guE);
      }
      this.guC.add(Double.valueOf(d));
    }
    AppMethodBeat.o(136196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */