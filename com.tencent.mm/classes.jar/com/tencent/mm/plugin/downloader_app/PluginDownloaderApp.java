package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.api.b;

public class PluginDownloaderApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.downloader_app.api.f
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(8782);
    if (paramg.akw())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.api.d.class, new d());
      com.tencent.mm.kernel.g.b(b.class, new a());
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.api.c.class, new c());
    AppMethodBeat.o(8782);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(8783);
    com.tencent.mm.plugin.downloader_app.a.d.ccd();
    j.cda();
    paramc = e.ccS();
    ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(16, paramc.kjw);
    com.tencent.mm.plugin.downloader.b.a.a(paramc.poW);
    AppMethodBeat.o(8783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(8784);
    com.tencent.mm.plugin.downloader_app.a.d.cce();
    j.stop();
    e locale = e.ccS();
    ((com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(16, locale.kjw);
    com.tencent.mm.plugin.downloader.b.a.b(locale.poW);
    AppMethodBeat.o(8784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.PluginDownloaderApp
 * JD-Core Version:    0.7.0.1
 */