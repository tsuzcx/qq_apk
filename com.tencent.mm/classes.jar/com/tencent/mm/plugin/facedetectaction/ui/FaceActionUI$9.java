package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceActionUI$9
  implements View.OnClickListener
{
  FaceActionUI$9(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104248);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.FaceActionUI", "click finish");
    this.AaH.f("fail", 90010, "", "");
    a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(104248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.9
 * JD-Core Version:    0.7.0.1
 */