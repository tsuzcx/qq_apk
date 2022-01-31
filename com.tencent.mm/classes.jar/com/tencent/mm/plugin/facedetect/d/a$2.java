package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.f.b.g.a;
import com.tencent.mm.modelvoiceaddr.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements c.a
{
  short[] eMa;
  
  a$2(a parama) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + paramInt1 + " detailState = " + paramInt2);
    this.jOW.aOH();
    if (a.e(this.jOW) != null) {
      a.e(this.jOW).onError(2);
    }
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    y.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramInt) });
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
    a.a(this.jOW, this.eMa, paramInt / 2);
    if (a.g(this.jOW) != null)
    {
      a.g(this.jOW).d(this.eMa, paramInt / 2);
      if (a.d(this.jOW) == null) {
        break label249;
      }
    }
    label249:
    for (paramInt = a.d(this.jOW).a(new g.a(paramArrayOfByte, paramInt));; paramInt = -1)
    {
      if ((-1 == paramInt) && (a.e(this.jOW) != null))
      {
        a.e(this.jOW).onError(3);
        this.jOW.aOH();
        y.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
      }
      return;
      if (a.e(this.jOW) != null)
      {
        a.e(this.jOW).onError(1);
        this.jOW.aOH();
      }
      y.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a.2
 * JD-Core Version:    0.7.0.1
 */