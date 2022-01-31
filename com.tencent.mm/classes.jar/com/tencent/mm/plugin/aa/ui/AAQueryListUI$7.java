package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class AAQueryListUI$7
  implements a.a
{
  AAQueryListUI$7(AAQueryListUI paramAAQueryListUI) {}
  
  public final void aoW()
  {
    AppMethodBeat.i(40736);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", AAQueryListUI.m(this.gpD));
    d.b(this.gpD, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(40736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.7
 * JD-Core Version:    0.7.0.1
 */