package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class ForceNotifyListUI$b$1
  implements View.OnTouchListener
{
  ForceNotifyListUI$b$1(ForceNotifyListUI.b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(51067);
    j.q(paramView, "view");
    j.q(paramMotionEvent, "event");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51067);
      return false;
      ForceNotifyListUI.e(this.mHO.mHI)[0] = ((int)paramMotionEvent.getRawX());
      ForceNotifyListUI.e(this.mHO.mHI)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.b.1
 * JD-Core Version:    0.7.0.1
 */