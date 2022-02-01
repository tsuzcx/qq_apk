package com.tencent.mm.plugin.emoji.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.w.c;

final class h$1
  implements Runnable
{
  h$1(h paramh, c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(108592);
    Intent localIntent = aa.ehS();
    aa.b(localIntent, 24);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsInitToSearch", true);
    d.b(this.oxr.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
    com.tencent.mm.plugin.report.service.h.vKh.f(13054, new Object[] { Integer.valueOf(this.fpl), Integer.valueOf(0), "" });
    AppMethodBeat.o(108592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h.1
 * JD-Core Version:    0.7.0.1
 */