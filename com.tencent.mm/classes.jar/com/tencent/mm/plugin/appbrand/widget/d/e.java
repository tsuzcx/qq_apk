package com.tencent.mm.plugin.appbrand.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public final double x;
  public final double y;
  
  public e(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e)) {
      return false;
    }
    return (this.x == ((e)paramObject).x) && (this.y == ((e)paramObject).y);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(146598);
    String str = "Point{x=" + this.x + ", y=" + this.y + '}';
    AppMethodBeat.o(146598);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.e
 * JD-Core Version:    0.7.0.1
 */