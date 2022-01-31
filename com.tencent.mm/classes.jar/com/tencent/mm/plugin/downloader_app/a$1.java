package com.tencent.mm.plugin.downloader_app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.b.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

final class a$1
  implements Runnable
{
  a$1(a parama, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    Object localObject = this.iRs;
    b localb = c.FC();
    if ((localb != null) && (!bk.dk((List)localObject)))
    {
      localObject = String.format("delete from %s where %s in %s", new Object[] { "FileDownloadInfo", "downloadId", b.P((LinkedList)localObject) });
      y.i("MicroMsg.FileDownloadInfoStorage", "batchRemoveDownloadInfo: " + (String)localObject);
      localb.gk("FileDownloadInfo", (String)localObject);
    }
    k.close();
    ((com.tencent.mm.plugin.game.commlib.a.a)g.r(com.tencent.mm.plugin.game.commlib.a.a.class)).Ez("pb_appinfo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.1
 * JD-Core Version:    0.7.0.1
 */