package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  LinkedList<String> kNU = new LinkedList();
  LinkedList<f> kNV = new LinkedList();
  
  private void aYQ()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = ((com.tencent.mm.plugin.downloader.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.downloader.a.c.class)).FC().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
    if (localObject2 == null) {}
    while (!((List)localObject1).isEmpty())
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((!bk.bl((String)localObject2)) && (!this.kNU.contains(localObject2)))
        {
          localObject3 = com.tencent.mm.pluginsdk.model.app.g.by((String)localObject2, false);
          if ((localObject3 != null) && (!this.kNV.contains(localObject3)))
          {
            this.kNV.add(localObject3);
            this.kNU.add(localObject2);
          }
        }
      }
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.downloader.f.a();
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).d((Cursor)localObject2);
        if ((!bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId)) && (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId.startsWith("wx")) && (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status == 3) && (e.bK(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath)) && (!((List)localObject1).contains(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId))) {
          ((List)localObject1).add(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
        }
      }
      ((Cursor)localObject2).close();
    }
  }
  
  private void dn(Context paramContext)
  {
    Cursor localCursor = com.tencent.mm.plugin.z.a.brn().ckT();
    if (localCursor == null)
    {
      y.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
      return;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        f localf = new f();
        localf.d(localCursor);
        if ((com.tencent.mm.pluginsdk.model.app.g.a(paramContext, localf)) && (!this.kNU.contains(localf.field_appId)))
        {
          y.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[] { localf.field_appName, localf.field_appId });
          this.kNV.add(localf);
          this.kNU.add(localf.field_appId);
        }
      } while (localCursor.moveToNext());
    }
    localCursor.close();
  }
  
  public final void clearCache()
  {
    y.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
    if (this.kNV != null) {
      this.kNV.clear();
    }
    if (this.kNU != null) {
      this.kNU.clear();
    }
  }
  
  public final void init(Context paramContext)
  {
    if (this.kNV == null)
    {
      this.kNV = new LinkedList();
      if (this.kNU != null) {
        break label112;
      }
      this.kNU = new LinkedList();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      dn(paramContext);
      long l2 = System.currentTimeMillis();
      aYQ();
      long l3 = System.currentTimeMillis();
      y.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      return;
      this.kNV.clear();
      break;
      label112:
      this.kNU.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.c
 * JD-Core Version:    0.7.0.1
 */