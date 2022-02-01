package com.tencent.mm.plugin.facedetect.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(103816);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/facedetect/motion/NormalFaceMotion$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    c.a(this.sSm);
    a.a(this, "com/tencent/mm/plugin/facedetect/motion/NormalFaceMotion$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(103816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c.1
 * JD-Core Version:    0.7.0.1
 */