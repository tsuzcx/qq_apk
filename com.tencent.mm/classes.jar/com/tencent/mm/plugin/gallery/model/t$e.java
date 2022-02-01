package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t$e
{
  int HII = 0;
  double HIJ;
  double HIK;
  double HIL;
  double HIM;
  public String id;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(111365);
    if (paramObject == null)
    {
      AppMethodBeat.o(111365);
      return false;
    }
    boolean bool = ((e)paramObject).id.equals(this.id);
    AppMethodBeat.o(111365);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(111366);
    String str = "crop area info -> cropType:" + this.HII + " left:" + this.HIJ + " top:" + this.HIK + " right:" + this.HIL + " bottom:" + this.HIM + " id:" + this.id;
    AppMethodBeat.o(111366);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.t.e
 * JD-Core Version:    0.7.0.1
 */