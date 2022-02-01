package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class LaunchAAUI$23
  implements View.OnTouchListener
{
  LaunchAAUI$23(LaunchAAUI paramLaunchAAUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63659);
    this.jXQ.hideTenpayKB();
    this.jXQ.hideVKB();
    if (LaunchAAUI.a(this.jXQ).findFocus() != null)
    {
      LaunchAAUI.a(this.jXQ).setCursorVisible(false);
      LaunchAAUI.a(this.jXQ).clearFocus();
    }
    AppMethodBeat.o(63659);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.23
 * JD-Core Version:    0.7.0.1
 */