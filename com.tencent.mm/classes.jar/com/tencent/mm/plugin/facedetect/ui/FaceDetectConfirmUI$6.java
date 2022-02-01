package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FaceDetectConfirmUI$6
  implements View.OnClickListener
{
  FaceDetectConfirmUI$6(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(271903);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = FaceDetectConfirmUI.b(this.zVB);
    if (!FaceDetectConfirmUI.b(this.zVB).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271903);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.6
 * JD-Core Version:    0.7.0.1
 */