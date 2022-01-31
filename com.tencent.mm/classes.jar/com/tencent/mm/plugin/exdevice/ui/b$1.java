package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements ExdeviceLikeView.a
{
  b$1(b paramb, com.tencent.mm.plugin.exdevice.f.b.a.d paramd) {}
  
  public final boolean bqO()
  {
    AppMethodBeat.i(20093);
    if (b.a(this.lOF) != null)
    {
      boolean bool = b.a(this.lOF).LW(this.lOE.field_username);
      AppMethodBeat.o(20093);
      return bool;
    }
    AppMethodBeat.o(20093);
    return true;
  }
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(20092);
    ab.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramInt) });
    if (b.a(this.lOF) != null) {
      b.a(this.lOF).ce(this.lOE.field_username, paramInt);
    }
    AppMethodBeat.o(20092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b.1
 * JD-Core Version:    0.7.0.1
 */