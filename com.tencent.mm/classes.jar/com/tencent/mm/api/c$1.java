package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements r
{
  c$1(c paramc) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(73797);
    ab.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", new Object[] { parame.name() });
    AppMethodBeat.o(73797);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(73798);
    ab.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", new Object[] { parame.name(), Integer.valueOf(paramInt) });
    AppMethodBeat.o(73798);
  }
  
  public final void bk(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.c.1
 * JD-Core Version:    0.7.0.1
 */