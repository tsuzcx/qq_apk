package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ap;

final class i$9
  implements View.OnKeyListener
{
  i$9(i parami) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(136367);
    b localb = new b();
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$17", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    paramView = this.ndJ;
    boolean bool;
    if (67 == paramInt)
    {
      bool = true;
      paramView.tak = bool;
      if (!this.ndJ.tak) {
        break label143;
      }
      this.ndJ.lEc.removeCallbacks(this.ndJ.tal);
      this.ndJ.lEc.postDelayed(this.ndJ.tal, 1000L);
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandInputInvokeHandler$17", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(136367);
      return false;
      bool = false;
      break;
      label143:
      this.ndJ.tal.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.9
 * JD-Core Version:    0.7.0.1
 */