package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  implements a
{
  private Context jVF;
  private List<Double> jVG;
  private int jVH;
  public double jVI;
  public double jVJ;
  public double jVK;
  public double jVL;
  public double jVM;
  
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
    this.jVG = new ArrayList(100);
    this.jVH = 0;
    this.jVI = 0.0D;
    this.jVJ = 0.0D;
    this.jVK = 2147483647.0D;
    this.jVL = 0.0D;
    this.jVM = 0.0D;
    this.jVF = paramContext;
    this.jVI = cF(paramContext);
    Log.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.jVI);
    AppMethodBeat.o(136194);
  }
  
  private static double cF(Context paramContext)
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
  
  public final void aEV()
  {
    AppMethodBeat.i(136195);
    this.jVH = this.jVG.size();
    if (this.jVH == 0)
    {
      Log.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      AppMethodBeat.o(136195);
      return;
    }
    Iterator localIterator = this.jVG.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.jVJ = Math.max(this.jVJ, localDouble2.doubleValue());
      this.jVK = Math.min(this.jVK, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.jVH);
    this.jVM = (localDouble1.doubleValue() - this.jVI);
    this.jVJ -= this.jVI;
    this.jVK -= this.jVI;
    localIterator = this.jVG.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.jVL = Math.sqrt(l / this.jVH);
    AppMethodBeat.o(136195);
  }
  
  public final void aEW()
  {
    AppMethodBeat.i(136196);
    if (this.jVG == null)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.jVG.size() > 10000)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.jVF != null)
    {
      double d = cF(this.jVF);
      this.jVI = Math.min(d, this.jVI);
      if (this.jVI == d) {
        Log.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.jVI);
      }
      this.jVG.add(Double.valueOf(d));
    }
    AppMethodBeat.o(136196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */