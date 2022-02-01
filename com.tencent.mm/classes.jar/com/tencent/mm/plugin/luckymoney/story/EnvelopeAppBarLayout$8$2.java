package com.tencent.mm.plugin.luckymoney.story;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EnvelopeAppBarLayout$8$2
  implements View.OnTouchListener
{
  EnvelopeAppBarLayout$8$2(EnvelopeAppBarLayout.8 param8) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189842);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    a.a(false, this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(189842);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.8.2
 * JD-Core Version:    0.7.0.1
 */