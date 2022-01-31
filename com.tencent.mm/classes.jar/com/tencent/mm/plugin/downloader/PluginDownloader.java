package com.tencent.mm.plugin.downloader;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public class PluginDownloader
  extends f
  implements com.tencent.mm.kernel.api.c, d
{
  private static a iOd;
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    y.d("MicroMsg.PluginDownloader", "execute");
    if (paramg.Ex())
    {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.downloader.a.c.class, new b());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.cdndownloader.b.a.class, new com.tencent.mm.plugin.cdndownloader.a());
      paramg = new a(com.tencent.mm.plugin.downloader.model.a.iOS);
      iOd = paramg;
      paramg.startWatching();
    }
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.PluginDownloader", "onAccountInitialized");
    com.tencent.mm.plugin.downloader.d.a.aFI();
    com.tencent.mm.plugin.cdndownloader.g.a.DS().k(new PluginDownloader.1(this), 500L);
    com.tencent.mm.plugin.downloader.b.a.aFI();
  }
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.PluginDownloader", "onAccountRelease");
    com.tencent.mm.plugin.downloader.d.a.aFJ();
    com.tencent.mm.plugin.downloader.b.a.aFJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.PluginDownloader
 * JD-Core Version:    0.7.0.1
 */