package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FaceTutorial$1
  implements View.OnClickListener
{
  FaceTutorial$1(FaceTutorial paramFaceTutorial) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104035);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/facedetect/ui/FaceTutorial$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.rlL.rlK != null) {
      this.rlL.rlK.onCancel();
    }
    this.rlL.dismiss();
    a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceTutorial$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(104035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial.1
 * JD-Core Version:    0.7.0.1
 */