package com.tencent.mm.plugin.game.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.event.b;
import com.tencent.mm.sdk.platformtools.bo;

final class e$2
  extends b
{
  e$2(e parame) {}
  
  public final void bFx()
  {
    AppMethodBeat.i(135930);
    if (!bo.isNullOrNil(e.a(this.nkA))) {
      this.nkA.post(new e.2.1(this));
    }
    AppMethodBeat.o(135930);
  }
  
  public final void bFy()
  {
    AppMethodBeat.i(135931);
    this.nkA.post(new e.2.2(this));
    AppMethodBeat.o(135931);
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(135932);
    this.nkA.post(new e.2.3(this, paramBoolean));
    AppMethodBeat.o(135932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e.2
 * JD-Core Version:    0.7.0.1
 */