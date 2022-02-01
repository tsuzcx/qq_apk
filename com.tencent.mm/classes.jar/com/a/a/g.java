package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
{
  b.q aPY = null;
  f aPZ = null;
  String aQa = null;
  h.b aQb = null;
  h.b aQc = null;
  String viewId = null;
  
  public final g p(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206474);
    this.aQc = new h.b(0.0F, 0.0F, paramFloat1, paramFloat2);
    AppMethodBeat.o(206474);
    return this;
  }
  
  public final boolean qG()
  {
    AppMethodBeat.i(206473);
    if (this.aPY != null)
    {
      b.q localq = this.aPY;
      if (localq.aPm != null) {}
      for (int i = localq.aPm.size(); i > 0; i = 0)
      {
        AppMethodBeat.o(206473);
        return true;
      }
    }
    AppMethodBeat.o(206473);
    return false;
  }
  
  public final boolean qH()
  {
    return this.aPZ != null;
  }
  
  public final boolean qI()
  {
    return this.viewId != null;
  }
  
  public final boolean qJ()
  {
    return this.aQb != null;
  }
  
  public final boolean qK()
  {
    return this.aQa != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.a.a.g
 * JD-Core Version:    0.7.0.1
 */