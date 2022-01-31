package com.tencent.mm.plugin.facedetect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.l;

final class FaceDetectConfirmUI$6
  implements DialogInterface.OnClickListener
{
  FaceDetectConfirmUI$6(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(367);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("err_code", l.vH(90022));
    paramDialogInterface.putExtra("err_msg", "get confirm info error");
    FaceDetectReporter.buB().b(FaceDetectConfirmUI.h(this.mkL), false, 3, 2, 90022);
    FaceDetectReporter.buB().miP = System.currentTimeMillis();
    FaceDetectReporter.buB().ci(FaceDetectConfirmUI.i(this.mkL), FaceDetectConfirmUI.h(this.mkL));
    FaceDetectConfirmUI.a(this.mkL, paramDialogInterface);
    this.mkL.finish();
    AppMethodBeat.o(367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.6
 * JD-Core Version:    0.7.0.1
 */