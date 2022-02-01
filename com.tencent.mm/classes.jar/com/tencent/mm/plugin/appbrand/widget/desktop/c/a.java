package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  public double gOl;
  public double gOm;
  private List<Double> mAe;
  public double mAf;
  
  public a()
  {
    AppMethodBeat.i(49848);
    this.mAe = new ArrayList(100);
    this.mAf = 0.0D;
    this.gOl = 1.7976931348623157E+308D;
    this.gOm = 4.9E-324D;
    AppMethodBeat.o(49848);
  }
  
  public final void aeq()
  {
    AppMethodBeat.i(49849);
    if (this.mAe == null)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.mAe.size() > 10000)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.mAe.size() != 0)
    {
      Iterator localIterator = this.mAe.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.gOl = Math.min(this.gOl, d2);
        this.gOm = Math.max(this.gOm, d2);
      }
      this.mAf = (d1 / this.mAe.size());
    }
    AppMethodBeat.o(49849);
  }
  
  public final void aer()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(49850);
    double d3 = c.mAg.gbc;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.mAe.add(Double.valueOf(d1));
        AppMethodBeat.o(49850);
        return;
      }
      d1 = d3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.a
 * JD-Core Version:    0.7.0.1
 */