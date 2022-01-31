package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements b.a
{
  d$1(d paramd) {}
  
  public final void a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(689);
    ab.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramArrayOfByte != null) {
      d.a(this.mqI, paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d.1
 * JD-Core Version:    0.7.0.1
 */