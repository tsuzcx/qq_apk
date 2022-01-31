package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectConfirmUI$4
  implements View.OnClickListener
{
  FaceDetectConfirmUI$4(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(366);
    ab.d("MicroMsg.FaceDetectConfirmUI", "check_alive_type is %s", new Object[] { Integer.valueOf(FaceDetectConfirmUI.d(this.mkL)) });
    paramView = new Intent(this.mkL, FaceDetectPrepareUI.class);
    Bundle localBundle = this.mkL.getIntent().getExtras();
    if (localBundle != null)
    {
      localBundle.putInt("check_alive_type_response", FaceDetectConfirmUI.d(this.mkL));
      localBundle.putString("key_feedback_url", FaceDetectConfirmUI.e(this.mkL));
      localBundle.putString("business_tips", FaceDetectConfirmUI.f(this.mkL));
      localBundle.putFloat("mLight_threshold", FaceDetectConfirmUI.g(this.mkL));
      ab.i("MicroMsg.FaceDetectConfirmUI", "carson check_alive_type_response is " + FaceDetectConfirmUI.d(this.mkL));
      paramView.putExtras(localBundle);
      this.mkL.startActivityForResult(paramView, 1);
      AppMethodBeat.o(366);
      return;
    }
    ab.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
    AppMethodBeat.o(366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.4
 * JD-Core Version:    0.7.0.1
 */