package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceActionUI$7
  implements View.OnClickListener
{
  FaceActionUI$7(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104245);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
    FaceActionUI.q(this.sYw);
    this.sYw.g("fail", FaceActionUI.o(this.sYw), "", FaceActionUI.p(this.sYw));
    a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(104245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.7
 * JD-Core Version:    0.7.0.1
 */