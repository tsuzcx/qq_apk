package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class a$1
  implements j
{
  a$1(a parama) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(137037);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
    h.b(paramb);
    AppMethodBeat.o(137037);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(137036);
    if (paramk == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
      AppMethodBeat.o(137036);
      return;
    }
    com.tencent.mm.ag.b localb = paramk.DE();
    paramk.Dx();
    paramk.Du();
    paramk.release();
    paramk = this.cfx.ceG;
    if (localb != null) {}
    try
    {
      if (this.cfx.cfv.contains(localb.filePath)) {
        this.cfx.cfv.remove(localb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(137036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.a.1
 * JD-Core Version:    0.7.0.1
 */