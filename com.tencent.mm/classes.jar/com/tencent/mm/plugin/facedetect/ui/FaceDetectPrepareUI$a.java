package com.tencent.mm.plugin.facedetect.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class FaceDetectPrepareUI$a
  extends Handler
{
  private WeakReference<FaceDetectPrepareUI> jQC = null;
  
  private FaceDetectPrepareUI$a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    this.jQC = new WeakReference(paramFaceDetectPrepareUI);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[] { Integer.valueOf(paramMessage.what) });
    if ((this.jQC != null) && (this.jQC.get() != null)) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      FaceDetectPrepareUI.a((FaceDetectPrepareUI)this.jQC.get(), paramMessage);
      return;
    case 1: 
      FaceDetectPrepareUI.b((FaceDetectPrepareUI)this.jQC.get(), paramMessage);
      return;
    }
    FaceDetectPrepareUI.c((FaceDetectPrepareUI)this.jQC.get(), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.a
 * JD-Core Version:    0.7.0.1
 */