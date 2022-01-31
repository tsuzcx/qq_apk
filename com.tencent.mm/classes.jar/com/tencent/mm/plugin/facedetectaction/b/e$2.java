package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements Runnable
{
  e$2(e parame, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    try
    {
      a.aPj().uq();
      byte[][] arrayOfByte = this.jWw;
      int j = arrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte1 = arrayOfByte[i];
        a.aPj().ax(arrayOfByte1);
        i += 1;
      }
      a.aPj().a(new e.2.1(this));
      return;
    }
    catch (Exception localException)
    {
      do
      {
        y.printErrStackTrace("MicroMsg.FaceCheckVideoRecordMgr", localException, "recordFrameImpl error", new Object[0]);
      } while (this.jWx.jWu == null);
      this.jWx.jWu.onError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.2
 * JD-Core Version:    0.7.0.1
 */