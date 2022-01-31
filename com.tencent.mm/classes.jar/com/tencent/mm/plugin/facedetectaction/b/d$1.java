package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements b.a
{
  d$1(d paramd) {}
  
  public final void a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramArrayOfByte != null) {
      d.a(this.jWr, paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d.1
 * JD-Core Version:    0.7.0.1
 */