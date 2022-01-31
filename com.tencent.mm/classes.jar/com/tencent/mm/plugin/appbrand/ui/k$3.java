package com.tencent.mm.plugin.appbrand.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$3
  implements Runnable
{
  k$3(k paramk, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(102325);
    ab.i("MicroMsg.AppBrandUILoadingSplash", "onDataTransferState  state=" + this.gB);
    if (this.gB == 3)
    {
      k.f(this.iPr).setVisibility(0);
      k.f(this.iPr).setText(2131297121);
    }
    AppMethodBeat.o(102325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k.3
 * JD-Core Version:    0.7.0.1
 */