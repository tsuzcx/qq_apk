package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class FaceDetectUI$1
  implements View.OnClickListener
{
  FaceDetectUI$1(FaceDetectUI paramFaceDetectUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(103977);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
    FaceDetectUI.a(this.rtn);
    a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(103977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.1
 * JD-Core Version:    0.7.0.1
 */