package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.y;

final class l$1
  implements View.OnSystemUiVisibilityChangeListener
{
  l$1(Window paramWindow) {}
  
  public final void onSystemUiVisibilityChange(int paramInt)
  {
    y.d("MicroMsg.AppBrandUIUtil", "visibility = " + paramInt);
    if ((paramInt & 0x4) == 0) {
      this.heE.getDecorView().setSystemUiVisibility(l.d(this.heE));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l.1
 * JD-Core Version:    0.7.0.1
 */