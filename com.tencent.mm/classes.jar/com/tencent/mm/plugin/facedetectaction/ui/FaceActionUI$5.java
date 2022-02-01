package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetectaction.b.d;

final class FaceActionUI$5
  implements View.OnClickListener
{
  FaceActionUI$5(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104244);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    d.rxC.onBackPressed();
    this.rys.finish();
    a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(104244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.5
 * JD-Core Version:    0.7.0.1
 */