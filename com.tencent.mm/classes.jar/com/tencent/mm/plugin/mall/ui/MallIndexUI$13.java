package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

final class MallIndexUI$13
  implements Runnable
{
  MallIndexUI$13(MallIndexUI paramMallIndexUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(43218);
    int k = a.gx(this.oAt.getContext());
    int n = a.fromDPToPix(this.oAt.getContext(), 53);
    int[] arrayOfInt = new int[2];
    this.oAt.ozq.getLocationInWindow(arrayOfInt);
    int m = this.oAt.ozA.getBottom() + arrayOfInt[1] - k;
    int j = this.oAt.ozq.getHeight() - this.oAt.ozA.getHeight() + arrayOfInt[1];
    int i = j;
    if (m > 0) {
      i = j + m;
    }
    j = k - i - n;
    n = a.fromDPToPix(this.oAt.getContext(), 33);
    ab.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.oAt.ozA.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
    if (j > n)
    {
      this.oAt.ozA.setPadding(0, j, 0, n);
      AppMethodBeat.o(43218);
      return;
    }
    this.oAt.ozA.setPadding(0, n, 0, n);
    AppMethodBeat.o(43218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.13
 * JD-Core Version:    0.7.0.1
 */