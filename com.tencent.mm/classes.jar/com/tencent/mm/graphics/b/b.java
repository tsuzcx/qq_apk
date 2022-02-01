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
  private List<Double> mvA;
  private int mvB;
  public double mvC;
  public double mvD;
  public double mvE;
  public double mvF;
  public double mvG;
  private Context mvz;
  
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
    this.mvA = new ArrayList(100);
    this.mvB = 0;
    this.mvC = 0.0D;
    this.mvD = 0.0D;
    this.mvE = 2147483647.0D;
    this.mvF = 0.0D;
    this.mvG = 0.0D;
    this.mvz = paramContext;
    this.mvC = du(paramContext);
    Log.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.mvC);
    AppMethodBeat.o(136194);
  }
  
  private static double du(Context paramContext)
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
  
  public final void aXX()
  {
    AppMethodBeat.i(136195);
    this.mvB = this.mvA.size();
    if (this.mvB == 0)
    {
      Log.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      AppMethodBeat.o(136195);
      return;
    }
    Iterator localIterator = this.mvA.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.mvD = Math.max(this.mvD, localDouble2.doubleValue());
      this.mvE = Math.min(this.mvE, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.mvB);
    this.mvG = (localDouble1.doubleValue() - this.mvC);
    this.mvD -= this.mvC;
    this.mvE -= this.mvC;
    localIterator = this.mvA.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.mvF = Math.sqrt(l / this.mvB);
    AppMethodBeat.o(136195);
  }
  
  public final void aXY()
  {
    AppMethodBeat.i(136196);
    if (this.mvA == null)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.mvA.size() > 10000)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.mvz != null)
    {
      double d = du(this.mvz);
      this.mvC = Math.min(d, this.mvC);
      if (this.mvC == d) {
        Log.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.mvC);
      }
      this.mvA.add(Double.valueOf(d));
    }
    AppMethodBeat.o(136196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */