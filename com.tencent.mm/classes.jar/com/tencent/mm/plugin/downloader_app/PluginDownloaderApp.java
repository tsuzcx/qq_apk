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
    if (paramg.bbA())
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
    com.tencent.mm.plugin.downloader_app.a.d.duo();
    j.dvc();
    paramc = e.duU();
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(16, paramc.roL);
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(paramc.qCv);
    com.tencent.mm.plugin.downloader.event.a.a(paramc.xsr);
    AppMethodBeat.o(8783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(8784);
    com.tencent.mm.plugin.downloader_app.a.d.cuD();
    j.stop();
    e locale = e.duU();
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(16, locale.roL);
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b(locale.qCv);
    com.tencent.mm.plugin.downloader.event.a.b(locale.xsr);
    AppMethodBeat.o(8784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.PluginDownloaderApp
 * JD-Core Version:    0.7.0.1
 */