package com.tencent.mm.plugin.downloader_app.d;

import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.storage.be;

final class b$1
  implements Runnable
{
  b$1(a parama, int paramInt) {}
  
  public final void run()
  {
    f localf = com.tencent.mm.pluginsdk.model.app.g.bx(this.iOZ.field_appId, false);
    if (localf != null)
    {
      if (this.fH != 0) {
        break label70;
      }
      if (((j)com.tencent.mm.kernel.g.r(j.class)).FB().abO("downloaderapp") <= 0) {
        b.a(0, localf.field_appId, localf.field_appName, this.iOZ.field_totalSize, localf.field_appIconUrl);
      }
    }
    label70:
    while (this.fH != 1) {
      return;
    }
    b.a(1, localf.field_appId, localf.field_appName, this.iOZ.field_totalSize, localf.field_appIconUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.b.1
 * JD-Core Version:    0.7.0.1
 */