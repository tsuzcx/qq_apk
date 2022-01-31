package com.tencent.mm.plugin.facedetect.ui;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(383);
    a.b(this.mkZ).setAnimationListener(new a.1.1(this));
    a.a(this.mkZ).startAnimation(a.b(this.mkZ));
    AppMethodBeat.o(383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a.1
 * JD-Core Version:    0.7.0.1
 */