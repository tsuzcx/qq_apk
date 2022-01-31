package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  implements a
{
  private Context eAH;
  private List<Double> eAI;
  private int eAJ;
  public double eAK;
  public double eAL;
  public double eAM;
  public double eAN;
  public double eAO;
  
  static
  {
    AppMethodBeat.i(57079);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(57079);
      return;
    }
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(57075);
    this.eAI = new ArrayList(100);
    this.eAJ = 0;
    this.eAK = 0.0D;
    this.eAL = 0.0D;
    this.eAM = 2147483647.0D;
    this.eAN = 0.0D;
    this.eAO = 0.0D;
    this.eAH = paramContext;
    this.eAK = bP(paramContext);
    ab.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.eAK);
    AppMethodBeat.o(57075);
  }
  
  private static double bP(Context paramContext)
  {
    AppMethodBeat.i(57078);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if ((!$assertionsDisabled) && (paramContext == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(57078);
      throw paramContext;
    }
    paramContext.getMemoryInfo(localMemoryInfo);
    double d = (localMemoryInfo.totalMem - localMemoryInfo.availMem) / 1024.0D / 1024.0D;
    AppMethodBeat.o(57078);
    return d;
  }
  
  public final void Pv()
  {
    AppMethodBeat.i(57076);
    this.eAJ = this.eAI.size();
    if (this.eAJ == 0)
    {
      ab.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      AppMethodBeat.o(57076);
      return;
    }
    Iterator localIterator = this.eAI.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.eAL = Math.max(this.eAL, localDouble2.doubleValue());
      this.eAM = Math.min(this.eAM, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.eAJ);
    this.eAO = (localDouble1.doubleValue() - this.eAK);
    this.eAL -= this.eAK;
    this.eAM -= this.eAK;
    localIterator = this.eAI.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.eAN = Math.sqrt(l / this.eAJ);
    AppMethodBeat.o(57076);
  }
  
  public final void Pw()
  {
    AppMethodBeat.i(57077);
    if (this.eAI == null)
    {
      AppMethodBeat.o(57077);
      return;
    }
    if (this.eAI.size() > 10000)
    {
      AppMethodBeat.o(57077);
      return;
    }
    if (this.eAH != null)
    {
      double d = bP(this.eAH);
      this.eAK = Math.min(d, this.eAK);
      if (this.eAK == d) {
        ab.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.eAK);
      }
      this.eAI.add(Double.valueOf(d));
    }
    AppMethodBeat.o(57077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */