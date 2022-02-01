package com.tencent.mm.plugin.appbrand.widget.desktop.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  public double hkZ;
  public double hla;
  private List<Double> nfU;
  public double nfV;
  
  public a()
  {
    AppMethodBeat.i(49848);
    this.nfU = new ArrayList(100);
    this.nfV = 0.0D;
    this.hkZ = 1.7976931348623157E+308D;
    this.hla = 4.9E-324D;
    AppMethodBeat.o(49848);
  }
  
  public final void ahr()
  {
    AppMethodBeat.i(49849);
    if (this.nfU == null)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.nfU.size() > 10000)
    {
      AppMethodBeat.o(49849);
      return;
    }
    if (this.nfU.size() != 0)
    {
      Iterator localIterator = this.nfU.iterator();
      double d2;
      for (double d1 = 0.0D; localIterator.hasNext(); d1 += d2)
      {
        d2 = ((Double)localIterator.next()).doubleValue();
        this.hkZ = Math.min(this.hkZ, d2);
        this.hla = Math.max(this.hla, d2);
      }
      this.nfV = (d1 / this.nfU.size());
    }
    AppMethodBeat.o(49849);
  }
  
  public final void ahs()
  {
    double d1 = 60.0D;
    double d2 = 0.0D;
    AppMethodBeat.i(49850);
    double d3 = c.nfW.gxt;
    if (d3 > 60.0D) {}
    for (;;)
    {
      if (d1 < 0.0D) {
        d1 = d2;
      }
      for (;;)
      {
        this.nfU.add(Double.valueOf(d1));
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