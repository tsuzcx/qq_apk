package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  implements a
{
  private Context dDg;
  private List<Double> dDh = new ArrayList(100);
  private int dDi = 0;
  public double dDj = 0.0D;
  public double dDk = 0.0D;
  public double dDl = 2147483647.0D;
  public double dDm = 0.0D;
  public double dDn = 0.0D;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public b(Context paramContext)
  {
    this.dDg = paramContext;
    this.dDj = bl(paramContext);
    y.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.dDj);
  }
  
  private static double bl(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    assert (paramContext != null);
    paramContext.getMemoryInfo(localMemoryInfo);
    return (localMemoryInfo.totalMem - localMemoryInfo.availMem) / 1024.0D / 1024.0D;
  }
  
  public final void BJ()
  {
    this.dDi = this.dDh.size();
    if (this.dDi == 0)
    {
      y.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
      return;
    }
    Iterator localIterator = this.dDh.iterator();
    Double localDouble1 = Double.valueOf(0.0D);
    Double localDouble2;
    while (localIterator.hasNext())
    {
      localDouble2 = (Double)localIterator.next();
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + localDouble2.doubleValue());
      this.dDk = Math.max(this.dDk, localDouble2.doubleValue());
      this.dDl = Math.min(this.dDl, localDouble2.doubleValue());
    }
    localDouble1 = Double.valueOf(localDouble1.doubleValue() / this.dDi);
    this.dDn = (localDouble1.doubleValue() - this.dDj);
    this.dDk -= this.dDj;
    this.dDl -= this.dDj;
    localIterator = this.dDh.iterator();
    double d;
    for (long l = 0L; localIterator.hasNext(); l = (Math.pow(localDouble2.doubleValue() - localDouble1.doubleValue(), 2.0D) + d))
    {
      localDouble2 = (Double)localIterator.next();
      d = l;
    }
    this.dDm = Math.sqrt(l / this.dDi);
  }
  
  public final void BK()
  {
    if (this.dDh == null) {}
    while ((this.dDh.size() > 10000) || (this.dDg == null)) {
      return;
    }
    double d = bl(this.dDg);
    this.dDj = Math.min(d, this.dDj);
    if (this.dDj == d) {
      y.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.dDj);
    }
    this.dDh.add(Double.valueOf(d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.graphics.b.b
 * JD-Core Version:    0.7.0.1
 */