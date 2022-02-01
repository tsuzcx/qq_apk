package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class f$2
  implements View.OnKeyListener
{
  f$2(f paramf) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(49380);
    b localb = new b();
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.bm(paramKeyEvent);
    a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
    if (paramInt == 4)
    {
      this.omx.dismiss();
      a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(49380);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/MMPopupWindowWithMask$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(49380);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.f.2
 * JD-Core Version:    0.7.0.1
 */