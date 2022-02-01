package com.tencent.mm.plugin.facedetectaction.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;

final class FaceAgreementUI$8
  implements j.a
{
  FaceAgreementUI$8(FaceAgreementUI paramFaceAgreementUI) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(262613);
    Log.i("MicroMsg.FaceAgreementUI", "click disagree ");
    FaceAgreementUI.m(this.Abf).cyW();
    h.OAn.idkeyStat(917L, 66L, 1L, false);
    AppMethodBeat.o(262613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.8
 * JD-Core Version:    0.7.0.1
 */