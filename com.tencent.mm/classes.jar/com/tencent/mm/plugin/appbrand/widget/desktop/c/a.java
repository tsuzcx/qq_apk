package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  public double hil;
  public double him;
  private List<Double> naM;
  public double naN;
  
  public a()
  {
    AppMethodBeat.i(49848);
    this.naM = new ArrayList(100);
    this.naN = 0.0D;
    this.hil = 1.7976931348623157E+308D;
    this.him = 4.9E-324D;
    AppMethodBeat.o(49848);
  }
  
  public final void ahc()
  {
    AppMethodBeat.i(49849);
    if (this.naM == null)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.naM.size() > 10000)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.naM.size() != 0)
    {
      Iterator localIterator = this.naM.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.hil = Math.min(this.hil, d2);
        this.him = Math.max(this.him, d2);
      }
      this.naN = (d1 / this.naM.size());
    }
    AppMethodBeat.o(49849);
  }
  
  public final void ahd()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(49850);
    double d3 = c.naO.guM;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.naM.add(Double.valueOf(d1));
        AppMethodBeat.o(49850);
        return;
      }
      d1 = d3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.a
 * JD-Core Version:    0.7.0.1
 */