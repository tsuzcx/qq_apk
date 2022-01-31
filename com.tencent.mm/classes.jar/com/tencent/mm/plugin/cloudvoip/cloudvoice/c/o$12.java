package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$12
  implements q.a
{
  o$12(o paramo, b paramb, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(135530);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: session result: %d, %d, %s, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp, Boolean.valueOf(paramBoolean) });
    this.kLI.O(new o.12.1(this, paramInt1, paramInt2, paramp, paramBoolean, paramString));
    AppMethodBeat.o(135530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.12
 * JD-Core Version:    0.7.0.1
 */