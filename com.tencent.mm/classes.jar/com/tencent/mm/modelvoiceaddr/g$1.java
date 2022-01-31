package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements c.a
{
  short[] gbH;
  
  g$1(g paramg) {}
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116705);
    ab.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.gbI.cL(10, -1);
    AppMethodBeat.o(116705);
  }
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(116704);
    ab.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()) });
    int i;
    if (this.gbH != null)
    {
      i = j;
      if (this.gbH.length >= paramInt / 2) {}
    }
    else
    {
      this.gbH = new short[paramInt / 2];
      i = j;
    }
    while (i < paramInt / 2)
    {
      this.gbH[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    g.a(this.gbI, this.gbH, paramInt / 2);
    if (g.d(this.gbI) != null)
    {
      g.d(this.gbI).f(this.gbH, paramInt / 2);
      AppMethodBeat.o(116704);
      return;
    }
    this.gbI.cL(9, -1);
    ab.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
    AppMethodBeat.o(116704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.1
 * JD-Core Version:    0.7.0.1
 */