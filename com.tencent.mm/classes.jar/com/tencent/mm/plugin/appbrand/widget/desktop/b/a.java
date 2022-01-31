package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  private List<Double> jiK;
  public double jiL;
  public double jiM;
  public double jiN;
  
  public a()
  {
    AppMethodBeat.i(134236);
    this.jiK = new ArrayList(100);
    this.jiL = 0.0D;
    this.jiM = 1.7976931348623157E+308D;
    this.jiN = 4.9E-324D;
    AppMethodBeat.o(134236);
  }
  
  public final void Pv()
  {
    AppMethodBeat.i(134237);
    if (this.jiK == null)
    {
      AppMethodBeat.o(134237);
      return;
    }
    if (this.jiK.size() > 10000)
    {
      AppMethodBeat.o(134237);
      return;
    }
    if (this.jiK.size() != 0)
    {
      Iterator localIterator = this.jiK.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.jiM = Math.min(this.jiM, d2);
        this.jiN = Math.max(this.jiN, d2);
      }
      this.jiL = (d1 / this.jiK.size());
    }
    AppMethodBeat.o(134237);
  }
  
  public final void Pw()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(134238);
    double d3 = c.jiO.eAR;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.jiK.add(Double.valueOf(d1));
        AppMethodBeat.o(134238);
        return;
      }
      d1 = d3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.a
 * JD-Core Version:    0.7.0.1
 */