package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s$e
{
  int BWl = 0;
  double BWm;
  double BWn;
  double BWo;
  double BWp;
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
    String str = "crop area info -> cropType:" + this.BWl + " left:" + this.BWm + " top:" + this.BWn + " right:" + this.BWo + " bottom:" + this.BWp + " id:" + this.id;
    AppMethodBeat.o(111366);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.s.e
 * JD-Core Version:    0.7.0.1
 */