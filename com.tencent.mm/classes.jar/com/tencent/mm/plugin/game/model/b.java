package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  LinkedList<String> ulA;
  LinkedList<com.tencent.mm.pluginsdk.model.app.g> ulB;
  
  public b()
  {
    AppMethodBeat.i(41351);
    this.ulB = new LinkedList();
    this.ulA = new LinkedList();
    AppMethodBeat.o(41351);
  }
  
  private void dbh()
  {
    AppMethodBeat.i(41354);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((d)com.tencent.mm.kernel.g.ab(d.class)).azM().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
    if (localObject2 == null) {}
    while (!((List)localObject1).isEmpty())
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((!bu.isNullOrNil((String)localObject2)) && (!this.ulA.contains(localObject2)))
        {
          localObject3 = h.m((String)localObject2, false, false);
          if ((localObject3 != null) && (!this.ulB.contains(localObject3)))
          {
            this.ulB.add(localObject3);
            this.ulA.add(localObject2);
          }
        }
      }
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.downloader.g.a();
        ((com.tencent.mm.plugin.downloader.g.a)localObject3).convertFrom((Cursor)localObject2);
        if ((!bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId)) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId.startsWith("wx")) && (((com.tencent.mm.plugin.downloader.g.a)localObject3).field_status == 3) && (o.fB(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_filePath)) && (!((List)localObject1).contains(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId))) {
          ((List)localObject1).add(((com.tencent.mm.plugin.downloader.g.a)localObject3).field_appId);
        }
      }
      ((Cursor)localObject2).close();
    }
    AppMethodBeat.o(41354);
  }
  
  private void fq(Context paramContext)
  {
    AppMethodBeat.i(41353);
    Cursor localCursor = com.tencent.mm.plugin.s.a.dBg().fdM();
    if (localCursor == null)
    {
      ae.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
      AppMethodBeat.o(41353);
      return;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        com.tencent.mm.pluginsdk.model.app.g localg = new com.tencent.mm.pluginsdk.model.app.g();
        localg.convertFrom(localCursor);
        if ((h.a(paramContext, localg)) && (!this.ulA.contains(localg.field_appId)))
        {
          ae.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[] { localg.field_appName, localg.field_appId });
          this.ulB.add(localg);
          this.ulA.add(localg.field_appId);
        }
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(41353);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(41355);
    ae.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
    if (this.ulB != null) {
      this.ulB.clear();
    }
    if (this.ulA != null) {
      this.ulA.clear();
    }
    AppMethodBeat.o(41355);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(41352);
    if (this.ulB == null)
    {
      this.ulB = new LinkedList();
      if (this.ulA != null) {
        break label122;
      }
      this.ulA = new LinkedList();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      fq(paramContext);
      long l2 = System.currentTimeMillis();
      dbh();
      long l3 = System.currentTimeMillis();
      ae.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      AppMethodBeat.o(41352);
      return;
      this.ulB.clear();
      break;
      label122:
      this.ulA.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.b
 * JD-Core Version:    0.7.0.1
 */