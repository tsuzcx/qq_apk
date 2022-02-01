package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
{
  b.q aQf = null;
  f aQg = null;
  String aQh = null;
  h.b aQi = null;
  String aQj = null;
  h.b aQk = null;
  
  public final g p(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(214747);
    this.aQk = new h.b(0.0F, 0.0F, paramFloat1, paramFloat2);
    AppMethodBeat.o(214747);
    return this;
  }
  
  public final boolean qD()
  {
    AppMethodBeat.i(214746);
    if (this.aQf != null)
    {
      b.q localq = this.aQf;
      if (localq.aPt != null) {}
      for (int i = localq.aPt.size(); i > 0; i = 0)
      {
        AppMethodBeat.o(214746);
        return true;
      }
    }
    AppMethodBeat.o(214746);
    return false;
  }
  
  public final boolean qE()
  {
    return this.aQg != null;
  }
  
  public final boolean qF()
  {
    return this.aQj != null;
  }
  
  public final boolean qG()
  {
    return this.aQi != null;
  }
  
  public final boolean qH()
  {
    return this.aQh != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.g
 * JD-Core Version:    0.7.0.1
 */