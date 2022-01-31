package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements c.a
{
  short[] gbH;
  
  a$2(a parama) {}
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286);
    ab.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + paramInt1 + " detailState = " + paramInt2);
    this.mjm.buL();
    if (a.e(this.mjm) != null) {
      a.e(this.mjm).onError(2);
    }
    AppMethodBeat.o(286);
  }
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(285);
    ab.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramInt) });
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
    a.a(this.mjm, this.gbH, paramInt / 2);
    if (a.g(this.mjm) != null)
    {
      a.g(this.mjm).f(this.gbH, paramInt / 2);
      if (a.d(this.mjm) == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = a.d(this.mjm).a(new g.a(paramArrayOfByte, paramInt));; paramInt = -1)
    {
      if ((-1 == paramInt) && (a.e(this.mjm) != null))
      {
        a.e(this.mjm).onError(3);
        this.mjm.buL();
        ab.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
        AppMethodBeat.o(285);
        return;
      }
      AppMethodBeat.o(285);
      return;
      if (a.e(this.mjm) != null)
      {
        a.e(this.mjm).onError(1);
        this.mjm.buL();
      }
      ab.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
      AppMethodBeat.o(285);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a.2
 * JD-Core Version:    0.7.0.1
 */