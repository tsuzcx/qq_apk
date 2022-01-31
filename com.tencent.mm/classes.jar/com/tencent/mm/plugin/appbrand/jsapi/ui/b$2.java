package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements View.OnSystemUiVisibilityChangeListener
{
  b$2(b paramb, Window paramWindow, int paramInt) {}
  
  public final void onSystemUiVisibilityChange(int paramInt)
  {
    AppMethodBeat.i(74807);
    if ((paramInt & 0x4) == 0) {
      this.ibc.getDecorView().setSystemUiVisibility(this.ibd);
    }
    AppMethodBeat.o(74807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.b.2
 * JD-Core Version:    0.7.0.1
 */