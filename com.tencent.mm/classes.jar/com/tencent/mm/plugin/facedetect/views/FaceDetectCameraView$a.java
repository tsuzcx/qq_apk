package com.tencent.mm.plugin.facedetect.views;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class FaceDetectCameraView$a
  extends ah
{
  private WeakReference<FaceDetectCameraView> Hz;
  
  private FaceDetectCameraView$a(FaceDetectCameraView paramFaceDetectCameraView)
  {
    super(Looper.getMainLooper());
    this.Hz = new WeakReference(paramFaceDetectCameraView);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((this.Hz == null) || (this.Hz.get() == null)) {
      y.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
    }
    label29:
    do
    {
      do
      {
        do
        {
          break label29;
          do
          {
            return;
          } while (paramMessage.what != 1);
          paramMessage = (FaceCharacteristicsResult)paramMessage.obj;
          if (!FaceCharacteristicsResult.qJ(paramMessage.errCode)) {
            break;
          }
        } while (FaceDetectCameraView.a((FaceDetectCameraView)this.Hz.get()) == null);
        FaceDetectCameraView.a((FaceDetectCameraView)this.Hz.get()).d(paramMessage);
        return;
        if (!FaceCharacteristicsResult.qI(paramMessage.errCode)) {
          break;
        }
      } while (FaceDetectCameraView.a((FaceDetectCameraView)this.Hz.get()) == null);
      FaceDetectCameraView.a((FaceDetectCameraView)this.Hz.get()).a(paramMessage.errCode, paramMessage.aox);
      return;
    } while (FaceDetectCameraView.a((FaceDetectCameraView)this.Hz.get()) == null);
    FaceDetectCameraView.a((FaceDetectCameraView)this.Hz.get()).c(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.a
 * JD-Core Version:    0.7.0.1
 */