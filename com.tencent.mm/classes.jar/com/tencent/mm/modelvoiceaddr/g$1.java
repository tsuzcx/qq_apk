package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements c.a
{
  short[] eMa;
  
  g$1(g paramg) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.eMb.bA(10, -1);
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    y.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()) });
    int i;
    if (this.eMa != null)
    {
      i = j;
      if (this.eMa.length >= paramInt / 2) {}
    }
    else
    {
      this.eMa = new short[paramInt / 2];
      i = j;
    }
    while (i < paramInt / 2)
    {
      this.eMa[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    g.a(this.eMb, this.eMa, paramInt / 2);
    if (g.d(this.eMb) != null)
    {
      g.d(this.eMb).d(this.eMa, paramInt / 2);
      return;
    }
    this.eMb.bA(9, -1);
    y.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g.1
 * JD-Core Version:    0.7.0.1
 */