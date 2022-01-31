package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class AppBrandTBSDownloadProxyUI$a$1
  implements Runnable
{
  AppBrandTBSDownloadProxyUI$a$1(AppBrandTBSDownloadProxyUI.a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(133106);
    this.iOT.iOQ.tipDialog.setMessage(this.iOT.iOQ.getContext().getString(2131296887, new Object[] { String.valueOf(this.bOf) }));
    AppMethodBeat.o(133106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.a.1
 * JD-Core Version:    0.7.0.1
 */