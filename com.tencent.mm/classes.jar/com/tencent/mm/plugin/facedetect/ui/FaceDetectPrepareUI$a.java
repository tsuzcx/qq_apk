package com.tencent.mm.plugin.facedetect.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class FaceDetectPrepareUI$a
  extends Handler
{
  private WeakReference<FaceDetectPrepareUI> mkX;
  
  private FaceDetectPrepareUI$a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    AppMethodBeat.i(424);
    this.mkX = null;
    this.mkX = new WeakReference(paramFaceDetectPrepareUI);
    AppMethodBeat.o(424);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(425);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[] { Integer.valueOf(paramMessage.what) });
    if ((this.mkX != null) && (this.mkX.get() != null)) {
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(425);
      return;
      FaceDetectPrepareUI.a((FaceDetectPrepareUI)this.mkX.get(), paramMessage);
      AppMethodBeat.o(425);
      return;
      FaceDetectPrepareUI.b((FaceDetectPrepareUI)this.mkX.get(), paramMessage);
      AppMethodBeat.o(425);
      return;
      FaceDetectPrepareUI.c((FaceDetectPrepareUI)this.mkX.get(), paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.a
 * JD-Core Version:    0.7.0.1
 */