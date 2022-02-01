package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

final class FaceProNative$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(103548);
    if ((!FaceProNative.hasDetectInit) && (PluginFace.isEnabled()))
    {
      int i = FaceProNative.nativeFacedetectInitBin(i.aY(p.ctp(), 0, -1));
      if (i == -1)
      {
        ad.w("MicroMsg.FaceProNative", "detectFaceCnt init failed: %s", new Object[] { p.ctp() });
        AppMethodBeat.o(103548);
        return;
      }
      ad.i("MicroMsg.FaceProNative", "detectFaceCnt init:%d, %s", new Object[] { Integer.valueOf(i), p.ctp() });
      FaceProNative.hasDetectInit = true;
    }
    AppMethodBeat.o(103548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.1
 * JD-Core Version:    0.7.0.1
 */