package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$1
  implements View.OnSystemUiVisibilityChangeListener
{
  o$1(Window paramWindow) {}
  
  public final void onSystemUiVisibilityChange(int paramInt)
  {
    AppMethodBeat.i(87379);
    ab.d("MicroMsg.AppBrandUIUtil", "visibility = ".concat(String.valueOf(paramInt)));
    if ((paramInt & 0x4) == 0) {
      this.ibc.getDecorView().setSystemUiVisibility(o.c(this.ibc));
    }
    AppMethodBeat.o(87379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.o.1
 * JD-Core Version:    0.7.0.1
 */