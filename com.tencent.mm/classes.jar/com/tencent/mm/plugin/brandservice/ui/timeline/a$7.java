package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$7
  implements View.OnTouchListener
{
  a$7(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(14104);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(14104);
      return false;
      a.a(this.jVZ, (int)paramMotionEvent.getRawX());
      a.b(this.jVZ, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.7
 * JD-Core Version:    0.7.0.1
 */