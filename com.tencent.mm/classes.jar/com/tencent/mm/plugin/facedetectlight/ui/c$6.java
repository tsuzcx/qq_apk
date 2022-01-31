package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.mm.plugin.facedetectlight.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;

final class c$6
  implements UploadVideoRequester
{
  c$6(c paramc) {}
  
  public final void request(String paramString, UploadVideoRequester.UploadVideoResponse paramUploadVideoResponse)
  {
    AppMethodBeat.i(797);
    ab.i("MicroMsg.FaceReflectLogic", "start uplaod data ：%s", new Object[] { paramString });
    FaceDetectReporter.buB().N(6, System.currentTimeMillis());
    al.d(new c.6.1(this));
    if (bo.isNullOrNil(paramString))
    {
      paramUploadVideoResponse.onFailed(-1, "uploadString is empty");
      AppMethodBeat.o(797);
      return;
    }
    Object localObject = this.msb;
    ab.i("MicroMsg.FaceReflectLogic", "stopVideoRecordIfNeed, isNeedVideo: %s", new Object[] { Boolean.valueOf(a.bvo().mnp) });
    if (a.bvo().mnp) {
      a.bvo().a(new c.7((c)localObject));
    }
    this.msb.msa = paramUploadVideoResponse;
    paramUploadVideoResponse = this.msb;
    ab.i("MicroMsg.FaceReflectLogic", "saveAndUploadReflectResult");
    long l = bo.yB();
    localObject = YTAGFaceReflectForWXJNIInterface.getEncodeString(paramUploadVideoResponse.mrJ);
    ab.i("MicroMsg.FaceReflectLogic", " mResult is ".concat(String.valueOf(localObject)));
    l = bo.av(l);
    if (localObject != null) {
      FaceDetectReporter.buB().L(((YTAGFaceReflectResult)localObject).result, l);
    }
    localObject = c.a((YTAGFaceReflectResult)localObject);
    ab.i("MicroMsg.FaceReflectLogic", "save face result file path: %s", new Object[] { localObject });
    if (!bo.isNullOrNil((String)localObject))
    {
      paramUploadVideoResponse.msa.onSuccess(paramString);
      paramUploadVideoResponse.mrP.Nw((String)localObject);
      AppMethodBeat.o(797);
      return;
    }
    paramUploadVideoResponse.mrP.u(90018, "system error", "");
    AppMethodBeat.o(797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.6
 * JD-Core Version:    0.7.0.1
 */