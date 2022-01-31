package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.game.j;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.o;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class f
{
  public long gbK = -1L;
  public int gbL = 0;
  public long gbM = -1L;
  public volatile double gbN = 0.0D;
  public double gbO = 0.0D;
  public List<Double> gbP = new CopyOnWriteArrayList();
  public List<Double> gbQ = new CopyOnWriteArrayList();
  public volatile boolean gbR = false;
  public boolean gbS = false;
  public long gbT = -1L;
  public long gbU = 0L;
  public volatile double gbV = 0.0D;
  
  public static f ty(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.plugin.appbrand.a.qn(paramString).aad().getCurrentPage().getCurrentPageView();
        if (!(paramString instanceof com.tencent.mm.plugin.appbrand.game.page.f)) {
          break label58;
        }
        paramString = ((com.tencent.mm.plugin.appbrand.game.page.f)paramString).gcy.getMBRenderer();
        if (paramString != null)
        {
          paramString = paramString.fZC;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        c.printErrStackTrace("MicroMsg.WAGameFPSInspector", paramString, "get QualityEvent of WAGame but fail.", new Object[0]);
      }
      return null;
      label58:
      paramString = null;
    }
  }
  
  public final double cx(long paramLong)
  {
    int i = this.gbQ.size();
    double d = g.a((Double[])Arrays.copyOf(this.gbQ.toArray(new Double[0]), (int)Math.min(i, 3L * paramLong)));
    this.gbQ.clear();
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.f
 * JD-Core Version:    0.7.0.1
 */