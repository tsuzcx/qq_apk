package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetectaction.b.d;

final class FaceActionUI$6
  implements View.OnClickListener
{
  FaceActionUI$6(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104244);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (FaceActionUI.n(this.sYw) == 3) {
      this.sYw.g("fail", FaceActionUI.o(this.sYw), "", FaceActionUI.p(this.sYw));
    }
    for (;;)
    {
      this.sYw.finish();
      a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(104244);
      return;
      d.sXz.onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.6
 * JD-Core Version:    0.7.0.1
 */