package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class IPCallCountryCodeScrollbar$1
  implements Runnable
{
  IPCallCountryCodeScrollbar$1(IPCallCountryCodeScrollbar paramIPCallCountryCodeScrollbar, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(22106);
    if (this.nSE.nSx.length <= 0)
    {
      AppMethodBeat.o(22106);
      return;
    }
    int i = (int)IPCallCountryCodeScrollbar.a(this.nSE).measureText(this.nSE.nSx[(this.nSE.nSx.length - 1)]) + a.fromDPToPix(this.nSE.getContext(), 8);
    if (i > this.nSD)
    {
      ViewGroup.LayoutParams localLayoutParams = this.nSE.getLayoutParams();
      localLayoutParams.width = i;
      localLayoutParams.height = this.fZ;
      this.nSE.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(22106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar.1
 * JD-Core Version:    0.7.0.1
 */