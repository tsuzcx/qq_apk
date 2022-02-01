package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.Log;

final class MallIndexUIv2$16
  implements Runnable
{
  MallIndexUIv2$16(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final void run()
  {
    AppMethodBeat.i(276840);
    int k = a.ks(this.ERS.getContext());
    int n = a.fromDPToPix(this.ERS.getContext(), 53);
    int[] arrayOfInt = new int[2];
    this.ERS.EQx.getLocationInWindow(arrayOfInt);
    int m = this.ERS.EQG.getBottom() + arrayOfInt[1] - k;
    int j = this.ERS.EQx.getHeight() - this.ERS.EQG.getHeight() + arrayOfInt[1];
    int i = j;
    if (m > 0) {
      i = j + m;
    }
    j = k - i - n;
    n = a.fromDPToPix(this.ERS.getContext(), 33);
    Log.d("MicorMsg.MallIndexUIv2", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.ERS.EQG.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
    if (j > n)
    {
      this.ERS.EQG.setPadding(a.aZ(this.ERS.getContext(), a.d.Edge_2A), j, a.aZ(this.ERS.getContext(), a.d.Edge_2A), n);
      AppMethodBeat.o(276840);
      return;
    }
    this.ERS.EQG.setPadding(a.aZ(this.ERS.getContext(), a.d.Edge_2A), n, a.aZ(this.ERS.getContext(), a.d.Edge_2A), n);
    AppMethodBeat.o(276840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.16
 * JD-Core Version:    0.7.0.1
 */