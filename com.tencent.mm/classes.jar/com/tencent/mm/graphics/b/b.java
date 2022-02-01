package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  implements a
{
  private Context gaR;
  private List<Double> gaS;
  private int gaT;
  public double gaU;
  public double gaV;
  public double gaW;
  public double gaX;
  public double gaY;
  
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
    this.gaS = new ArrayList(100);
    this.gaT = 0;
    this.gaU = 0.0D;
    this.gaV = 0.0D;
    this.gaW = 2147483647.0D;
    this.gaX = 0.0D;
    this.gaY = 0.0D;
    this.gaR = paramContext;
    this.gaU = co(paramContext);
    ac.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.gaU);
    AppMethodBeat.o(136194);
  }
  
  private static double co(Context paramContext)
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
  
  public final void aeq()
  {
    AppMethodBeat.i(136195);
    this.gaT = this.gaS.size();
    if (this.gaT == 0)
    {
      ac.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      AppMethodBeat.o(136195);
      return;
    }
    Iterator localIterator = this.gaS.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.gaV = Math.max(this.gaV, localDouble2.doubleValue());
      this.gaW = Math.min(this.gaW, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.gaT);
    this.gaY = (localDouble1.doubleValue() - this.gaU);
    this.gaV -= this.gaU;
    this.gaW -= this.gaU;
    localIterator = this.gaS.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.gaX = Math.sqrt(l / this.gaT);
    AppMethodBeat.o(136195);
  }
  
  public final void aer()
  {
    AppMethodBeat.i(136196);
    if (this.gaS == null)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.gaS.size() > 10000)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.gaR != null)
    {
      double d = co(this.gaR);
      this.gaU = Math.min(d, this.gaU);
      if (this.gaU == d) {
        ac.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.gaU);
      }
      this.gaS.add(Double.valueOf(d));
    }
    AppMethodBeat.o(136196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */