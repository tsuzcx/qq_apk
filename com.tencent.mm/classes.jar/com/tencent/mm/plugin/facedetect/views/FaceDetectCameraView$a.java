package com.tencent.mm.plugin.facedetect.views;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

final class FaceDetectCameraView$a
  extends ak
{
  private WeakReference<FaceDetectCameraView> Hg;
  
  private FaceDetectCameraView$a(FaceDetectCameraView paramFaceDetectCameraView)
  {
    super(Looper.getMainLooper());
    AppMethodBeat.i(574);
    this.Hg = new WeakReference(paramFaceDetectCameraView);
    AppMethodBeat.o(574);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(575);
    super.handleMessage(paramMessage);
    if ((this.Hg == null) || (this.Hg.get() == null))
    {
      ab.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
      AppMethodBeat.o(575);
      return;
    }
    if (paramMessage.what == 1)
    {
      paramMessage = (FaceCharacteristicsResult)paramMessage.obj;
      if (FaceCharacteristicsResult.vE(paramMessage.errCode))
      {
        if (FaceDetectCameraView.a((FaceDetectCameraView)this.Hg.get()) != null)
        {
          FaceDetectCameraView.a((FaceDetectCameraView)this.Hg.get()).d(paramMessage);
          AppMethodBeat.o(575);
        }
      }
      else if (FaceCharacteristicsResult.vD(paramMessage.errCode))
      {
        if (FaceDetectCameraView.a((FaceDetectCameraView)this.Hg.get()) != null)
        {
          FaceDetectCameraView.a((FaceDetectCameraView)this.Hg.get()).a(paramMessage.errCode, paramMessage.errMsg);
          AppMethodBeat.o(575);
        }
      }
      else if (FaceDetectCameraView.a((FaceDetectCameraView)this.Hg.get()) != null) {
        FaceDetectCameraView.a((FaceDetectCameraView)this.Hg.get()).c(paramMessage);
      }
    }
    AppMethodBeat.o(575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.a
 * JD-Core Version:    0.7.0.1
 */