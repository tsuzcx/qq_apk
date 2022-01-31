package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.f.b.g.a;
import com.tencent.mm.f.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqpinyin.voicerecoapi.c;

final class f$1
  implements com.tencent.mm.f.b.c.a
{
  f$1(f paramf) {}
  
  public final void aU(int paramInt1, int paramInt2) {}
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    y.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.qqpinyin.voicerecoapi.c.a locala = new com.tencent.qqpinyin.voicerecoapi.c.a();
    short[] arrayOfShort = new short[paramInt / 2];
    int i = 0;
    while (i < paramInt / 2)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    if (this.eLS.eLQ != null) {
      this.eLS.eLQ.a(arrayOfShort, paramInt / 2, locala);
    }
    f.a(this.eLS, arrayOfShort, paramInt / 2);
    if (this.eLS.eLP != null) {}
    for (paramInt = this.eLS.eLP.a(new g.a(paramArrayOfByte, paramInt));; paramInt = -1)
    {
      if (-1 == paramInt)
      {
        f.a(this.eLS);
        y.e("MicroMsg.SceneVoiceAddr", "write to file failed");
      }
      do
      {
        return;
        paramArrayOfByte = this.eLS;
        paramArrayOfByte.eLK = (paramInt + paramArrayOfByte.eLK);
        if ((this.eLS.eLK > 3300) && (!this.eLS.eLL))
        {
          y.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
          this.eLS.handler.sendEmptyMessage(0);
          this.eLS.eLL = true;
        }
      } while ((locala.wKn != 2) && (locala.wKn != 3));
      y.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + locala.wKn);
      f.a(this.eLS);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.f.1
 * JD-Core Version:    0.7.0.1
 */