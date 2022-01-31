package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.plugin.downloader_app.b.j;

public class PluginDownloaderApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.downloader_app.a.f
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(136027);
    if (paramg.SD())
    {
      com.tencent.mm.kernel.g.b(e.class, new c());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.a.d.class, new b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.a.c.class, new a());
    }
    AppMethodBeat.o(136027);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(136028);
    com.tencent.mm.plugin.downloader_app.b.d.bje();
    j.bjT();
    AppMethodBeat.o(136028);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(136029);
    com.tencent.mm.plugin.downloader_app.b.d.bjf();
    j.stop();
    AppMethodBeat.o(136029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.PluginDownloaderApp
 * JD-Core Version:    0.7.0.1
 */