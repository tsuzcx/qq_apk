package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  LinkedList<String> ICd;
  LinkedList<g> ICe;
  
  public b()
  {
    AppMethodBeat.i(41351);
    this.ICe = new LinkedList();
    this.ICd = new LinkedList();
    AppMethodBeat.o(41351);
  }
  
  private void fFR()
  {
    AppMethodBeat.i(41354);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((d)com.tencent.mm.kernel.h.ax(d.class)).bzH().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
    if (localObject2 == null) {}
    while (!((List)localObject1).isEmpty())
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((!Util.isNullOrNil((String)localObject2)) && (!this.ICd.contains(localObject2)))
        {
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.s((String)localObject2, false, false);
          if ((localObject3 != null) && (!this.ICe.contains(localObject3)))
          {
            this.ICe.add(localObject3);
            this.ICd.add(localObject2);
          }
        }
      }
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new com.tencent.mm.plugin.downloader.f.a();
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).convertFrom((Cursor)localObject2);
        if ((!Util.isNullOrNil(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId)) && (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId.startsWith("wx")) && (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status == 3) && (y.ZC(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath)) && (!((List)localObject1).contains(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId))) {
          ((List)localObject1).add(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
        }
      }
      ((Cursor)localObject2).close();
    }
    AppMethodBeat.o(41354);
  }
  
  private void hJ(Context paramContext)
  {
    AppMethodBeat.i(41353);
    Cursor localCursor = com.tencent.mm.plugin.openapi.a.gxn().iIy();
    if (localCursor == null)
    {
      Log.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
      AppMethodBeat.o(41353);
      return;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        g localg = new g();
        localg.convertFrom(localCursor);
        if ((com.tencent.mm.pluginsdk.model.app.h.a(paramContext, localg)) && (!this.ICd.contains(localg.field_appId)))
        {
          Log.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[] { localg.field_appName, localg.field_appId });
          this.ICe.add(localg);
          this.ICd.add(localg.field_appId);
        }
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(41353);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(41355);
    Log.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
    if (this.ICe != null) {
      this.ICe.clear();
    }
    if (this.ICd != null) {
      this.ICd.clear();
    }
    AppMethodBeat.o(41355);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(41352);
    if (this.ICe == null)
    {
      this.ICe = new LinkedList();
      if (this.ICd != null) {
        break label122;
      }
      this.ICd = new LinkedList();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      hJ(paramContext);
      long l2 = System.currentTimeMillis();
      fFR();
      long l3 = System.currentTimeMillis();
      Log.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(l3 - l1) });
      AppMethodBeat.o(41352);
      return;
      this.ICe.clear();
      break;
      label122:
      this.ICd.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.b
 * JD-Core Version:    0.7.0.1
 */