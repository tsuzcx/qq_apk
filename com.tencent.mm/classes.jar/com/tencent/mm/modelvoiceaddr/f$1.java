package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.audio.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.qqpinyin.voicerecoapi.c;

final class f$1
  implements com.tencent.mm.audio.b.c.a
{
  f$1(f paramf) {}
  
  public final void bS(int paramInt1, int paramInt2) {}
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(116693);
    ab.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.qqpinyin.voicerecoapi.c.a locala = new com.tencent.qqpinyin.voicerecoapi.c.a();
    short[] arrayOfShort = new short[paramInt / 2];
    int i = 0;
    while (i < paramInt / 2)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    if (this.gbz.gbx != null) {
      this.gbz.gbx.a(arrayOfShort, paramInt / 2, locala);
    }
    f.a(this.gbz, arrayOfShort, paramInt / 2);
    if (this.gbz.gbw != null) {}
    for (paramInt = this.gbz.gbw.a(new g.a(paramArrayOfByte, paramInt));; paramInt = -1)
    {
      if (-1 == paramInt)
      {
        f.a(this.gbz);
        ab.e("MicroMsg.SceneVoiceAddr", "write to file failed");
        AppMethodBeat.o(116693);
        return;
      }
      paramArrayOfByte = this.gbz;
      paramArrayOfByte.gbr = (paramInt + paramArrayOfByte.gbr);
      if ((this.gbz.gbr > 3300) && (!this.gbz.gbs))
      {
        ab.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
        this.gbz.handler.sendEmptyMessage(0);
        this.gbz.gbs = true;
      }
      if ((locala.BhO == 2) || (locala.BhO == 3))
      {
        ab.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.BhO);
        f.a(this.gbz);
      }
      AppMethodBeat.o(116693);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f.1
 * JD-Core Version:    0.7.0.1
 */