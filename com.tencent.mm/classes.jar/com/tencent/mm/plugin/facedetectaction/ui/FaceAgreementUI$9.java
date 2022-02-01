package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;

final class FaceAgreementUI$9
  implements j.a
{
  FaceAgreementUI$9(FaceAgreementUI paramFaceAgreementUI) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(262617);
    Log.i("MicroMsg.FaceAgreementUI", "click agree ");
    Intent localIntent = new Intent(this.Abf, FaceFlashPermissionUI.class);
    Bundle localBundle = this.Abf.getIntent().getExtras();
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    localIntent.putExtra("needContract", FaceAgreementUI.a(this.Abf));
    this.Abf.startActivityForResult(localIntent, 1);
    h.OAn.idkeyStat(917L, 65L, 1L, false);
    FaceAgreementUI.m(this.Abf).cyW();
    AppMethodBeat.o(262617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.9
 * JD-Core Version:    0.7.0.1
 */