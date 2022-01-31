package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.downloader_app.b.k;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.downloader_app.a.a
{
  private com.tencent.mm.plugin.downloader_app.c.c iRr;
  
  public final void a(Context paramContext, Intent paramIntent, i parami)
  {
    if (paramContext == null)
    {
      if (parami != null) {
        parami.aGo();
      }
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = localIntent.getExtras();
    if (!q.GK())
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(b.h.downloaderapp_uninstall_msg), paramContext.getString(b.h.downloaderapp_uninstall_title), paramContext.getString(b.h.downloaderapp_go_to_install), paramContext.getString(b.h.downloaderapp_install_cancel), false, new a.2(this, paramIntent, paramContext, parami), new a.3(this, parami));
      return;
    }
    localIntent.setClass(paramContext, DownloadMainUI.class);
    paramContext.startActivity(localIntent);
    if (parami != null) {
      parami.aGo();
    }
    g.DP().Dz().c(ac.a.uzR, Boolean.valueOf(false));
  }
  
  public final boolean aGb()
  {
    return k.aGb();
  }
  
  public final void aGc()
  {
    LinkedList localLinkedList = k.aGr();
    if (bk.dk(localLinkedList)) {
      return;
    }
    Object localObject = com.tencent.mm.plugin.downloader.model.c.M(localLinkedList);
    localLinkedList = new LinkedList();
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.downloader.f.a locala = (com.tencent.mm.plugin.downloader.f.a)((Iterator)localObject).next();
        if (locala.field_status == 1) {
          com.tencent.mm.plugin.downloader.model.d.aFP().dc(locala.field_downloadId);
        }
        if (com.tencent.mm.vfs.e.bK(locala.field_filePath))
        {
          y.i("MicroMsg.DownloaderAppService", "closeDownloaderApp, delete file: %s", new Object[] { locala.field_filePath });
          com.tencent.mm.vfs.e.deleteFile(locala.field_filePath);
        }
        localLinkedList.add(Long.valueOf(locala.field_downloadId));
      }
    }
    com.tencent.mm.cg.a.postDelayed(new a.1(this, localLinkedList), 1000L);
  }
  
  public final void aGd() {}
  
  public final com.tencent.mm.plugin.downloader_app.c.c aGe()
  {
    return this.iRr;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("DOWNLOADTASKITEM_TABLE".hashCode()), new a.5(this));
    return localHashMap;
  }
  
  public final void e(Context paramContext, Bundle paramBundle)
  {
    if (paramContext == null) {}
    String str;
    do
    {
      return;
      str = paramBundle.getString("rawUrl");
    } while (bk.bl(str));
    com.tencent.mm.plugin.downloader_app.detail.d.setUrl(str);
    com.tencent.mm.cg.a.postDelayed(new a.4(this, paramContext, paramBundle), 200L);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2)
  {
    this.iRr = new com.tencent.mm.plugin.downloader_app.c.c(paramh1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a
 * JD-Core Version:    0.7.0.1
 */