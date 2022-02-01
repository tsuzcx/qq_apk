package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class LaunchAAUI$43
  implements View.OnTouchListener
{
  LaunchAAUI$43(LaunchAAUI paramLaunchAAUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63665);
    LaunchAAUI.a(this.jXQ).setCursorVisible(true);
    AppMethodBeat.o(63665);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.43
 * JD-Core Version:    0.7.0.1
 */