package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.plugin.downloader_app.a.j;

public class PluginDownloaderApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.downloader_app.api.f
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(8782);
    if (paramg.aBb())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.api.d.class, new d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.api.b.class, new a());
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.api.c.class, new c());
    AppMethodBeat.o(8782);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(8783);
    com.tencent.mm.plugin.downloader_app.a.d.cBn();
    j.cCf();
    paramc = e.cBX();
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(16, paramc.lqt);
    com.tencent.mm.plugin.downloader.b.a.a(paramc.qKT);
    AppMethodBeat.o(8783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(8784);
    com.tencent.mm.plugin.downloader_app.a.d.cBo();
    j.stop();
    e locale = e.cBX();
    ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(16, locale.lqt);
    com.tencent.mm.plugin.downloader.b.a.b(locale.qKT);
    AppMethodBeat.o(8784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.PluginDownloaderApp
 * JD-Core Version:    0.7.0.1
 */