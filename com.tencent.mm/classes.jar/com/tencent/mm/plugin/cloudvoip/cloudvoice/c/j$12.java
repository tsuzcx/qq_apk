package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.y;

final class j$12
  implements l.a
{
  j$12(j paramj, a parama, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk, boolean paramBoolean)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: session result: %d, %d, %s, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramk, Boolean.valueOf(paramBoolean) });
    this.iFU.H(new j.12.1(this, paramInt1, paramInt2, paramk, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.12
 * JD-Core Version:    0.7.0.1
 */