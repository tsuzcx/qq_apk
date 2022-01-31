package com.tencent.mm.plugin.downloader_app.detail.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;

final class g$1
  implements a.b
{
  g$1(g paramg, bh.a parama) {}
  
  public final void a(a.a parama, long paramLong)
  {
    AppMethodBeat.i(136079);
    if (parama == a.a.kZY)
    {
      this.law.c(null, null);
      AppMethodBeat.o(136079);
      return;
    }
    if (parama == a.a.kZZ)
    {
      this.law.c("fail", null);
      AppMethodBeat.o(136079);
      return;
    }
    if (parama == a.a.laa) {
      this.law.c("wait_for_wifi", null);
    }
    AppMethodBeat.o(136079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.g.1
 * JD-Core Version:    0.7.0.1
 */