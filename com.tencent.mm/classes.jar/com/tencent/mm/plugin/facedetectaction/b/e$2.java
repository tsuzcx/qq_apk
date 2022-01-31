package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  implements Runnable
{
  e$2(e parame, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(703);
    try
    {
      a.bvo().EC();
      byte[][] arrayOfByte = this.mqN;
      int j = arrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte1 = arrayOfByte[i];
        a.bvo().aV(arrayOfByte1);
        i += 1;
      }
      a.bvo().a(new e.2.1(this));
      AppMethodBeat.o(703);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", localException, "recordFrameImpl error", new Object[0]);
      if (this.mqO.mqL != null) {
        this.mqO.mqL.onError();
      }
      AppMethodBeat.o(703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.2
 * JD-Core Version:    0.7.0.1
 */