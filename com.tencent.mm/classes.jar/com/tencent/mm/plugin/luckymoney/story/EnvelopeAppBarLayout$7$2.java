package com.tencent.mm.plugin.luckymoney.story;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EnvelopeAppBarLayout$7$2
  implements View.OnTouchListener
{
  EnvelopeAppBarLayout$7$2(EnvelopeAppBarLayout.7 param7) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199007);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    a.a(false, this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(199007);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.7.2
 * JD-Core Version:    0.7.0.1
 */