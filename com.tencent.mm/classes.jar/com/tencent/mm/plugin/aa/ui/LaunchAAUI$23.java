package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMEditText;

final class LaunchAAUI$23
  implements View.OnTouchListener
{
  LaunchAAUI$23(LaunchAAUI paramLaunchAAUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63659);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    this.jab.hideTenpayKB();
    this.jab.hideVKB();
    if (LaunchAAUI.a(this.jab).findFocus() != null) {
      LaunchAAUI.a(this.jab).setCursorVisible(false);
    }
    a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(63659);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.23
 * JD-Core Version:    0.7.0.1
 */