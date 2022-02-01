package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FaceDetectPrepareUI$3
  implements View.OnClickListener
{
  FaceDetectPrepareUI$3(FaceDetectPrepareUI paramFaceDetectPrepareUI, int paramInt1, int paramInt2, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(103921);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.rkL.a(this.val$errType, this.val$errCode, this.val$errMsg, null);
    a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(103921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */