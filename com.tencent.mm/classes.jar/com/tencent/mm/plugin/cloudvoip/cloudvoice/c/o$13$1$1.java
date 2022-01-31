package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$13$1$1
  implements q.a
{
  o$13$1$1(o.13.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(135531);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp != null) && (paramp.isValid()))
    {
      l.Jl(paramp.kMp);
      AppMethodBeat.o(135531);
      return;
    }
    ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: refresh session key error!");
    o.a(this.kLX.kLW.kLI, o.a.kMh);
    AppMethodBeat.o(135531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.13.1.1
 * JD-Core Version:    0.7.0.1
 */