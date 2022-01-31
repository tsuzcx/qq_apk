package com.tencent.mm.plugin.facedetectlight.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;

final class b$6
  implements UploadVideoRequester
{
  b$6(b paramb) {}
  
  public final void request(String paramString, UploadVideoRequester.UploadVideoResponse paramUploadVideoResponse)
  {
    y.i("MicroMsg.FaceReflectLogic", "start uplaod data ：%s", new Object[] { paramString });
    ai.d(new b.6.1(this));
    if (bk.bl(paramString))
    {
      paramUploadVideoResponse.onFailed(-1, "uploadString is empty");
      return;
    }
    Object localObject = this.jXK;
    y.i("MicroMsg.FaceReflectLogic", "stopVideoRecordIfNeed, isNeedVideo: %s", new Object[] { Boolean.valueOf(a.aPj().jST) });
    if (a.aPj().jST) {
      a.aPj().a(new b.7((b)localObject));
    }
    this.jXK.jXJ = paramUploadVideoResponse;
    localObject = this.jXK;
    y.i("MicroMsg.FaceReflectLogic", "saveAndUploadReflectResult");
    long l = bk.UZ();
    paramUploadVideoResponse = YTAGFaceReflectForWXJNIInterface.getEncodeString(((b)localObject).jXr);
    y.i("MicroMsg.FaceReflectLogic", " mResult is " + paramUploadVideoResponse);
    l = bk.cp(l);
    if (paramUploadVideoResponse != null) {
      FaceDetectReporter.aOy().u(paramUploadVideoResponse.result, l);
    }
    paramUploadVideoResponse = b.a(paramUploadVideoResponse);
    y.i("MicroMsg.FaceReflectLogic", "save face result file path: %s", new Object[] { paramUploadVideoResponse });
    if (!bk.bl(paramUploadVideoResponse))
    {
      ((b)localObject).jXJ.onSuccess(paramString);
      paramString = ((b)localObject).jXm;
      y.i("MicroMsg.FaceReflectUI", "callbackDetectSuccess()");
      localObject = new Bundle();
      ((Bundle)localObject).putString("key_bio_buffer_path", paramUploadVideoResponse);
      paramString.a(0, 0, "collect data ok", (Bundle)localObject);
      return;
    }
    ((b)localObject).jXm.k(90018, "system error", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.6
 * JD-Core Version:    0.7.0.1
 */