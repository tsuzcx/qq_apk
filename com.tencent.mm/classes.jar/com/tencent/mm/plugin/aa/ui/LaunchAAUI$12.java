package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LaunchAAUI$12
  implements View.OnTouchListener
{
  LaunchAAUI$12(LaunchAAUI paramLaunchAAUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40834);
    this.grm.hideTenpayKB();
    this.grm.hideVKB();
    AppMethodBeat.o(40834);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.12
 * JD-Core Version:    0.7.0.1
 */