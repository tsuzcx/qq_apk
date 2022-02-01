package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  public double gnA;
  public double gnz;
  private List<Double> lYc;
  public double lYd;
  
  public a()
  {
    AppMethodBeat.i(49848);
    this.lYc = new ArrayList(100);
    this.lYd = 0.0D;
    this.gnz = 1.7976931348623157E+308D;
    this.gnA = 4.9E-324D;
    AppMethodBeat.o(49848);
  }
  
  public final void acZ()
  {
    AppMethodBeat.i(49849);
    if (this.lYc == null)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.lYc.size() > 10000)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.lYc.size() != 0)
    {
      Iterator localIterator = this.lYc.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.gnz = Math.min(this.gnz, d2);
        this.gnA = Math.max(this.gnA, d2);
      }
      this.lYd = (d1 / this.lYc.size());
    }
    AppMethodBeat.o(49849);
  }
  
  public final void ada()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(49850);
    double d3 = c.lYe.fWv;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.lYc.add(Double.valueOf(d1));
        AppMethodBeat.o(49850);
        return;
      }
      d1 = d3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.a
 * JD-Core Version:    0.7.0.1
 */