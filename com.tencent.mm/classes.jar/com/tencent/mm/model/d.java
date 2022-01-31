package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
{
  private b cko;
  private b.a fkB;
  d.a fkC;
  private boolean fkD;
  private Context zF;
  
  public d()
  {
    AppMethodBeat.i(77795);
    this.fkD = false;
    this.zF = ah.getContext();
    AppMethodBeat.o(77795);
  }
  
  public final boolean a(d.a parama)
  {
    AppMethodBeat.i(77796);
    this.fkC = parama;
    parama = new d.b(this, (byte)0);
    if (this.cko == null) {
      this.cko = new b(this.zF);
    }
    if (this.fkB != parama) {
      this.fkB = parama;
    }
    this.cko.a(this.fkB);
    if (this.cko == null)
    {
      AppMethodBeat.o(77796);
      return false;
    }
    if (this.fkD)
    {
      AppMethodBeat.o(77796);
      return false;
    }
    this.cko.requestFocus();
    this.fkD = true;
    boolean bool = this.fkD;
    AppMethodBeat.o(77796);
    return bool;
  }
  
  public final boolean cJ(boolean paramBoolean)
  {
    AppMethodBeat.i(77797);
    if (this.cko != null) {}
    for (boolean bool = this.cko.Mh();; bool = false)
    {
      this.fkD = false;
      if (paramBoolean)
      {
        this.cko = null;
        this.fkB = null;
        this.fkC = null;
      }
      AppMethodBeat.o(77797);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.d
 * JD-Core Version:    0.7.0.1
 */