package com.tencent.mm.plugin.aa.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMEditText;

final class LaunchAAUI$31
  implements View.OnTouchListener
{
  LaunchAAUI$31(LaunchAAUI paramLaunchAAUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63665);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    LaunchAAUI.a(this.jab).setCursorVisible(true);
    a.a(false, this, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(63665);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.31
 * JD-Core Version:    0.7.0.1
 */