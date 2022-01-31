package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  LinkedList<String> nlR;
  LinkedList<f> nlS;
  
  public b()
  {
    AppMethodBeat.i(111189);
    this.nlS = new LinkedList();
    this.nlR = new LinkedList();
    AppMethodBeat.o(111189);
  }
  
  private void bFP()
  {
    AppMethodBeat.i(111192);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((d)com.tencent.mm.kernel.g.E(d.class)).YG().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
    if (localObject2 == null) {}
    while (!((List)localObject1).isEmpty())
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((!bo.isNullOrNil((String)localObject2)) && (!this.nlR.contains(localObject2)))
        {
          localObject3 = com.tencent.mm.pluginsdk.model.app.g.ca((String)localObject2, false);
          if ((localObject3 != null) && (!this.nlS.contains(localObject3)))
          {
            this.nlS.add(localObject3);
            this.nlR.add(localObject2);
          }
        }
      }
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.downloader.g.a();
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).convertFrom((Cursor)localObject2);
        if ((!bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId)) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId.startsWith("wx")) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_status == 3) && (e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath)) && (!((List)localObject1).contains(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId))) {
          ((List)localObject1).add(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId);
        }
      }
      ((Cursor)localObject2).close();
    }
    AppMethodBeat.o(111192);
  }
  
  private void ea(Context paramContext)
  {
    AppMethodBeat.i(111191);
    Cursor localCursor = com.tencent.mm.plugin.s.a.cac().dlD();
    if (localCursor == null)
    {
      ab.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
      AppMethodBeat.o(111191);
      return;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        f localf = new f();
        localf.convertFrom(localCursor);
        if ((com.tencent.mm.pluginsdk.model.app.g.a(paramContext, localf)) && (!this.nlR.contains(localf.field_appId)))
        {
          ab.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[] { localf.field_appName, localf.field_appId });
          this.nlS.add(localf);
          this.nlR.add(localf.field_appId);
        }
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(111191);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(111193);
    ab.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
    if (this.nlS != null) {
      this.nlS.clear();
    }
    if (this.nlR != null) {
      this.nlR.clear();
    }
    AppMethodBeat.o(111193);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(111190);
    if (this.nlS == null)
    {
      this.nlS = new LinkedList();
      if (this.nlR != null) {
        break label122;
      }
      this.nlR = new LinkedList();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      ea(paramContext);
      long l2 = System.currentTimeMillis();
      bFP();
      long l3 = System.currentTimeMillis();
      ab.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      AppMethodBeat.o(111190);
      return;
      this.nlS.clear();
      break;
      label122:
      this.nlR.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.b
 * JD-Core Version:    0.7.0.1
 */