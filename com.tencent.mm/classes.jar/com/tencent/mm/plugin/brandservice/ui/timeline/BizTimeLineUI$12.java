package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BizTimeLineUI$12
  implements Runnable
{
  BizTimeLineUI$12(BizTimeLineUI paramBizTimeLineUI, ProgressDialog paramProgressDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(14195);
    if ((this.efE != null) && (this.efE.isShowing())) {
      this.efE.dismiss();
    }
    if (this.jXh.isFinishing())
    {
      ab.w("MicroMsg.BizTimeLineUI", "checkInitListView isFinishing, just return");
      AppMethodBeat.o(14195);
      return;
    }
    BizTimeLineUI.a(this.jXh);
    AppMethodBeat.o(14195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.12
 * JD-Core Version:    0.7.0.1
 */