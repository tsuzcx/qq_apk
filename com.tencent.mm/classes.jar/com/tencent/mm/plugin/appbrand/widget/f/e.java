package com.tencent.mm.plugin.appbrand.widget.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final double rBr;
  public final double rBs;
  
  public e(double paramDouble1, double paramDouble2)
  {
    this.rBr = paramDouble1;
    this.rBs = paramDouble2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e)) {
      return false;
    }
    return (this.rBr == ((e)paramObject).rBr) && (this.rBs == ((e)paramObject).rBs);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146598);
    String str = "Point{x=" + this.rBr + ", y=" + this.rBs + '}';
    AppMethodBeat.o(146598);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.e
 * JD-Core Version:    0.7.0.1
 */