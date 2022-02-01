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
  private Context hjW;
  private List<Double> hjX;
  private int hjY;
  public double hjZ;
  public double hka;
  public double hkb;
  public double hkc;
  public double hkd;
  
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
    this.hjX = new ArrayList(100);
    this.hjY = 0;
    this.hjZ = 0.0D;
    this.hka = 0.0D;
    this.hkb = 2147483647.0D;
    this.hkc = 0.0D;
    this.hkd = 0.0D;
    this.hjW = paramContext;
    this.hjZ = cJ(paramContext);
    Log.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.hjZ);
    AppMethodBeat.o(136194);
  }
  
  private static double cJ(Context paramContext)
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
  
  public final void axD()
  {
    AppMethodBeat.i(136195);
    this.hjY = this.hjX.size();
    if (this.hjY == 0)
    {
      Log.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      AppMethodBeat.o(136195);
      return;
    }
    Iterator localIterator = this.hjX.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.hka = Math.max(this.hka, localDouble2.doubleValue());
      this.hkb = Math.min(this.hkb, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.hjY);
    this.hkd = (localDouble1.doubleValue() - this.hjZ);
    this.hka -= this.hjZ;
    this.hkb -= this.hjZ;
    localIterator = this.hjX.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.hkc = Math.sqrt(l / this.hjY);
    AppMethodBeat.o(136195);
  }
  
  public final void axE()
  {
    AppMethodBeat.i(136196);
    if (this.hjX == null)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.hjX.size() > 10000)
    {
      AppMethodBeat.o(136196);
      return;
    }
    if (this.hjW != null)
    {
      double d = cJ(this.hjW);
      this.hjZ = Math.min(d, this.hjZ);
      if (this.hjZ == d) {
        Log.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.hjZ);
      }
      this.hjX.add(Double.valueOf(d));
    }
    AppMethodBeat.o(136196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */