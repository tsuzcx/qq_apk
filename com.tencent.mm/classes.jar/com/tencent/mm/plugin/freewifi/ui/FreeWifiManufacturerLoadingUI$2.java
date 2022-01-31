package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class FreeWifiManufacturerLoadingUI$2
  implements View.OnClickListener
{
  FreeWifiManufacturerLoadingUI$2(FreeWifiManufacturerLoadingUI paramFreeWifiManufacturerLoadingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21010);
    this.mOf.mOe.postDelayed(new FreeWifiManufacturerLoadingUI.2.1(this), 0L);
    this.mOf.bBC();
    AppMethodBeat.o(21010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.2
 * JD-Core Version:    0.7.0.1
 */