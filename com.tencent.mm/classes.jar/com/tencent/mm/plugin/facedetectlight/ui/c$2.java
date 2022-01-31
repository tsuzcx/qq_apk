package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.facedetectlight.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import java.util.Arrays;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(789);
    c localc = this.msb;
    ab.i("MicroMsg.FaceReflectLogic", " beginFaceReflectiton()");
    localc.mrP.bvT();
    ab.i("MicroMsg.FaceReflectLogic", " mBioID is " + localc.mrJ);
    ab.i("MicroMsg.FaceReflectLogic", " mConfig is " + Arrays.toString(localc.mlk));
    ab.i("MicroMsg.FaceReflectLogic", "mConfig.length is " + localc.mlk.length);
    String str = YTAGFaceReflectForWXJNIInterface.decrypt(localc.mrJ, localc.mlk, localc.mlk.length);
    ab.i("MicroMsg.FaceReflectLogic", " real Config is ".concat(String.valueOf(str)));
    YTAGReflectLiveCheckInterface.setRGBConfigRequest(new c.4(localc, str));
    localc.mState = 1;
    try
    {
      FaceDetectReporter.buB().N(0, System.currentTimeMillis());
      FaceDetectReporter.buB().M(6, System.currentTimeMillis());
      YTAGReflectLiveCheckInterface.start(localc.mContext, localc.mrD.eqF, localc.hIs, localc.mrG, new c.5(localc));
      localc = this.msb;
      ab.i("MicroMsg.FaceReflectLogic", " setUploadDataCallback()");
      YTAGReflectLiveCheckInterface.setUploadVideoRequester(new c.6(localc));
      AppMethodBeat.o(789);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FaceReflectLogic", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.2
 * JD-Core Version:    0.7.0.1
 */