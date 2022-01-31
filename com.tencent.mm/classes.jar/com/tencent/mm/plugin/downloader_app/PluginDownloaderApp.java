package com.tencent.mm.plugin.downloader_app;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.downloader_app.a.b;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.k;

public class PluginDownloaderApp
  extends f
  implements c, b
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.downloader_app.a.a.class, new a());
    }
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    d.aFI();
    k.aGq();
  }
  
  public void onAccountRelease()
  {
    d.aFJ();
    k.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.PluginDownloaderApp
 * JD-Core Version:    0.7.0.1
 */