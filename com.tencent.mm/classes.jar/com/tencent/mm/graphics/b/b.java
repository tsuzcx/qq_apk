package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  implements a
{
  private Context gxi;
  private List<Double> gxj;
  private int gxk;
  public double gxl;
  public double gxm;
  public double gxn;
  public double gxo;
  public double gxp;
  
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
    this.gxj = new ArrayList(100);
    this.gxk = 0;
    this.gxl = 0.0D;
    this.gxm = 0.0D;
    this.gxn = 2147483647.0D;
    this.gxo = 0.0D;
    this.gxp = 0.0D;
    this.gxi = paramContext;
    this.gxl = cn(paramContext);
    ae.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.gxl);
    AppMethodBeat.o(136194);
  }
  
  private static double cn(Context paramContext)
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
  
  public final void ahr()
  {
    AppMethodBeat.i(136195);
    this.gxk = this.gxj.size();
    if (this.gxk == 0)
    {
      ae.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      AppMethodBeat.o(136195);
      return;
    }
    Iterator localIterator = this.gxj.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.gxm = Math.max(this.gxm, localDouble2.doubleValue());
      this.gxn = Math.min(this.gxn, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.gxk);
    this.gxp = (localDouble1.doubleValue() - this.gxl);
    this.gxm -= this.gxl;
    this.gxn -= this.gxl;
    localIterator = this.gxj.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.gxo = Math.sqrt(l / this.gxk);
    AppMethodBeat.o(136195);
  }
  
  public final void ahs()
  {
    AppMethodBeat.i(136196);
    if (this.gxj == null)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.gxj.size() > 10000)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.gxi != null)
    {
      double d = cn(this.gxi);
      this.gxl = Math.min(d, this.gxl);
      if (this.gxl == d) {
        ae.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.gxl);
      }
      this.gxj.add(Double.valueOf(d));
    }
    AppMethodBeat.o(136196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */