package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
{
  b.q ayr = null;
  f ays = null;
  String ayt = null;
  h.b ayu = null;
  h.b ayv = null;
  String viewId = null;
  
  public final g k(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201805);
    this.ayv = new h.b(0.0F, 0.0F, paramFloat1, paramFloat2);
    AppMethodBeat.o(201805);
    return this;
  }
  
  public final boolean ob()
  {
    AppMethodBeat.i(201804);
    if (this.ayr != null)
    {
      b.q localq = this.ayr;
      if (localq.axF != null) {}
      for (int i = localq.axF.size(); i > 0; i = 0)
      {
        AppMethodBeat.o(201804);
        return true;
      }
    }
    AppMethodBeat.o(201804);
    return false;
  }
  
  public final boolean oc()
  {
    return this.ays != null;
  }
  
  public final boolean od()
  {
    return this.viewId != null;
  }
  
  public final boolean oe()
  {
    return this.ayu != null;
  }
  
  public final boolean of()
  {
    return this.ayt != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.a.a.g
 * JD-Core Version:    0.7.0.1
 */