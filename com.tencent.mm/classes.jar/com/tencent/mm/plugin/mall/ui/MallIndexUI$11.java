package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

final class MallIndexUI$11
  implements Runnable
{
  MallIndexUI$11(MallIndexUI paramMallIndexUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(66108);
    int k = a.ks(this.ERF.getContext());
    int n = a.fromDPToPix(this.ERF.getContext(), 53);
    int[] arrayOfInt = new int[2];
    this.ERF.EQx.getLocationInWindow(arrayOfInt);
    int m = this.ERF.EQG.getBottom() + arrayOfInt[1] - k;
    int j = this.ERF.EQx.getHeight() - this.ERF.EQG.getHeight() + arrayOfInt[1];
    int i = j;
    if (m > 0) {
      i = j + m;
    }
    j = k - i - n;
    n = a.fromDPToPix(this.ERF.getContext(), 33);
    Log.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.ERF.EQG.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
    if (j > n)
    {
      this.ERF.EQG.setPadding(0, j, 0, n);
      AppMethodBeat.o(66108);
      return;
    }
    this.ERF.EQG.setPadding(0, n, 0, n);
    AppMethodBeat.o(66108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.11
 * JD-Core Version:    0.7.0.1
 */