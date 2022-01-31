package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectPrepareUI$6
  implements c
{
  FaceDetectPrepareUI$6(FaceDetectPrepareUI paramFaceDetectPrepareUI) {}
  
  public final void ad(int paramInt, String paramString)
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(90015), paramString });
    paramInt = FaceDetectPrepareUI.qR(paramInt);
    FaceDetectPrepareUI.a(this.jRg, paramInt, 90015, paramString, this.jRg.getString(a.i.face_detect_init_err));
  }
  
  public final void e(long paramLong, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(FaceDetectPrepareUI.h(this.jRg)) });
    if (FaceDetectPrepareUI.h(this.jRg)) {
      return;
    }
    FaceDetectPrepareUI.a(this.jRg, paramLong);
    FaceDetectPrepareUI.a(this.jRg, paramArrayOfByte);
    FaceDetectPrepareUI.a(this.jRg, paramLong, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */