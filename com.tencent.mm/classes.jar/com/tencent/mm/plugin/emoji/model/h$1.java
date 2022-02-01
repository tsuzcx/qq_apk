package com.tencent.mm.plugin.emoji.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.flutter.c;
import com.tencent.mm.plugin.websearch.api.z;

final class h$1
  implements Runnable
{
  h$1(h paramh, c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(108592);
    Intent localIntent = z.exm();
    z.b(localIntent, 24);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsInitToSearch", true);
    d.b(this.paR.context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
    com.tencent.mm.plugin.report.service.h.wUl.f(13054, new Object[] { Integer.valueOf(this.fsL), Integer.valueOf(0), "" });
    AppMethodBeat.o(108592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.h.1
 * JD-Core Version:    0.7.0.1
 */