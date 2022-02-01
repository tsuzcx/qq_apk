package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceAgreementUI$1
  implements View.OnClickListener
{
  FaceAgreementUI$1(FaceAgreementUI paramFaceAgreementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(262622);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    Log.i("MicroMsg.FaceAgreementUI", "needShowProtocal : %s", new Object[] { Boolean.valueOf(FaceAgreementUI.a(this.Abf)) });
    if (FaceAgreementUI.a(this.Abf)) {
      FaceAgreementUI.b(this.Abf);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262622);
      return;
      paramView = new Intent(this.Abf, FaceFlashPermissionUI.class);
      localObject = this.Abf.getIntent().getExtras();
      if (localObject != null) {
        paramView.putExtras((Bundle)localObject);
      }
      paramView.putExtra("needContract", FaceAgreementUI.a(this.Abf));
      this.Abf.startActivityForResult(paramView, 1);
      h.OAn.idkeyStat(917L, 67L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.1
 * JD-Core Version:    0.7.0.1
 */