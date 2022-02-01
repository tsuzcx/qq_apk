package com.tencent.mm.plugin.finder.viewmodel.component;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class ac$b
  implements View.OnTouchListener
{
  ac$b(aa.f paramf, LinearLayout paramLinearLayout) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282894);
    p.j(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      ((ViewGroup)this.uXh.aaBC).removeView((View)this.BkK);
    }
    AppMethodBeat.o(282894);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ac.b
 * JD-Core Version:    0.7.0.1
 */