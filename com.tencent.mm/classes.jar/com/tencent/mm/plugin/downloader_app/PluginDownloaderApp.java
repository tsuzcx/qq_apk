package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.plugin.downloader_app.a.j;

public class PluginDownloaderApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.downloader_app.api.f
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(8782);
    if (paramg.aIE())
    {
      h.b(com.tencent.mm.plugin.downloader_app.api.d.class, new d());
      h.b(com.tencent.mm.plugin.downloader_app.api.b.class, new a());
    }
    h.b(com.tencent.mm.plugin.downloader_app.api.c.class, new c());
    AppMethodBeat.o(8782);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(8783);
    com.tencent.mm.plugin.downloader_app.a.d.cPR();
    j.cQJ();
    paramc = e.cQB();
    ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(16, paramc.old);
    ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).a(paramc.nCC);
    com.tencent.mm.plugin.downloader.b.a.a(paramc.umf);
    AppMethodBeat.o(8783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(8784);
    com.tencent.mm.plugin.downloader_app.a.d.cPS();
    j.stop();
    e locale = e.cQB();
    ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(16, locale.old);
    ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).b(locale.nCC);
    com.tencent.mm.plugin.downloader.b.a.b(locale.umf);
    AppMethodBeat.o(8784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.PluginDownloaderApp
 * JD-Core Version:    0.7.0.1
 */