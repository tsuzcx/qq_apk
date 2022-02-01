package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetectaction.model.c;

final class FaceActionUI$6
  implements View.OnClickListener
{
  FaceActionUI$6(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104244);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (FaceActionUI.n(this.AaH) == 3) {
      this.AaH.f("fail", FaceActionUI.o(this.AaH), "", FaceActionUI.p(this.AaH));
    }
    for (;;)
    {
      this.AaH.finish();
      a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(104244);
      return;
      c.zZJ.onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.6
 * JD-Core Version:    0.7.0.1
 */