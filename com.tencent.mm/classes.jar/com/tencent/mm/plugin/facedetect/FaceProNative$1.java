package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class FaceProNative$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(29);
    if (!FaceProNative.hasDetectInit)
    {
      int i = FaceProNative.nativeFacedetectInitBin(e.i(p.buH(), 0, -1));
      if (i == -1)
      {
        ab.w("MicroMsg.FaceProNative", "detectFaceCnt init failed: %s", new Object[] { p.buH() });
        AppMethodBeat.o(29);
        return;
      }
      ab.i("MicroMsg.FaceProNative", "detectFaceCnt init:%d, %s", new Object[] { Integer.valueOf(i), p.buH() });
      FaceProNative.hasDetectInit = true;
    }
    AppMethodBeat.o(29);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.1
 * JD-Core Version:    0.7.0.1
 */