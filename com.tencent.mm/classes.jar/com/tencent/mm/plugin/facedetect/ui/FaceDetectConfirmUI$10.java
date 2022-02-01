package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FaceDetectConfirmUI$10
  implements View.OnClickListener
{
  FaceDetectConfirmUI$10(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(271906);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    FaceDetectConfirmUI.j(this.zVB);
    a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(271906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.10
 * JD-Core Version:    0.7.0.1
 */