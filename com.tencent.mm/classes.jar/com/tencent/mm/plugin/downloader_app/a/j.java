package com.tencent.mm.plugin.downloader_app.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.c.b;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<String> umx;
  private static LinkedList<String> umy;
  private static d.d umz;
  
  static
  {
    AppMethodBeat.i(8920);
    umx = new LinkedList();
    umy = new LinkedList();
    AppMethodBeat.o(8920);
  }
  
  public static void LG(String paramString)
  {
    AppMethodBeat.i(8916);
    umy.remove(paramString);
    umx.remove(paramString);
    if (b.cQM() != null) {
      b.cQM().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
    AppMethodBeat.o(8916);
  }
  
  public static int att(String paramString)
  {
    AppMethodBeat.i(8913);
    if (umy.contains(paramString))
    {
      i = k.umA;
      AppMethodBeat.o(8913);
      return i;
    }
    int i = k.UN_INSTALLED;
    AppMethodBeat.o(8913);
    return i;
  }
  
  public static void atu(String paramString)
  {
    AppMethodBeat.i(8915);
    if (!contains(paramString))
    {
      umx.addFirst(paramString);
      if (b.cQM() != null)
      {
        com.tencent.mm.plugin.downloader_app.c.a locala = new com.tencent.mm.plugin.downloader_app.c.a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.cQM().insert(locala);
      }
    }
    AppMethodBeat.o(8915);
  }
  
  public static void cQJ()
  {
    Object localObject1 = null;
    AppMethodBeat.i(8909);
    if (b.cQM() == null)
    {
      if (localObject1 != null) {
        localObject1 = ((LinkedList)localObject1).iterator();
      }
    }
    else {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label216;
        }
        Object localObject2 = (com.tencent.mm.plugin.downloader_app.c.a)((Iterator)localObject1).next();
        Log.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", new Object[] { ((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status) });
        if (((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status == k.umA)
        {
          if (umy.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
            continue;
          }
          umy.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
          continue;
          localObject2 = b.cQM().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new LinkedList();
          while (((Cursor)localObject2).moveToNext())
          {
            com.tencent.mm.plugin.downloader_app.c.a locala = new com.tencent.mm.plugin.downloader_app.c.a();
            locala.convertFrom((Cursor)localObject2);
            ((LinkedList)localObject1).add(locala);
          }
          ((Cursor)localObject2).close();
          break;
        }
        if (!umx.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
          umx.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
        }
      }
    }
    label216:
    if (umz == null) {
      umz = new d.d()
      {
        public final void O(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8908);
          com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramAnonymousLong);
          if (locala == null)
          {
            AppMethodBeat.o(8908);
            return;
          }
          Log.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", new Object[] { Integer.valueOf(paramAnonymousInt), locala.field_appId });
          if (!j.contains(locala.field_appId))
          {
            AppMethodBeat.o(8908);
            return;
          }
          if (paramAnonymousInt == 9)
          {
            j.JI(locala.field_appId);
            AppMethodBeat.o(8908);
            return;
          }
          if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
          {
            g localg = h.o(locala.field_appId, true, false);
            if ((localg != null) && (q.u(MMApplicationContext.getContext(), localg.field_packageName)))
            {
              Log.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
              AppMethodBeat.o(8908);
              return;
            }
            j.WK(locala.field_appId);
          }
          AppMethodBeat.o(8908);
        }
      };
    }
    d.a(umz);
    AppMethodBeat.o(8909);
  }
  
  public static LinkedList<String> cQK()
  {
    AppMethodBeat.i(8911);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(umx);
    localLinkedList.addAll(umy);
    AppMethodBeat.o(8911);
    return localLinkedList;
  }
  
  public static LinkedList<String> cQL()
  {
    AppMethodBeat.i(8912);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(umx);
    AppMethodBeat.o(8912);
    return localLinkedList;
  }
  
  public static boolean cQt()
  {
    AppMethodBeat.i(8917);
    if (umx.size() > 0)
    {
      AppMethodBeat.o(8917);
      return true;
    }
    AppMethodBeat.o(8917);
    return false;
  }
  
  public static void cQw()
  {
    AppMethodBeat.i(175275);
    Iterator localIterator = umx.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.asU((String)localIterator.next());
      if ((locala != null) && (locala.field_status == 1)) {
        f.cPZ().Iy(locala.field_downloadId);
      }
    }
    AppMethodBeat.o(175275);
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(8914);
    if ((umy.contains(paramString)) || (umx.contains(paramString)))
    {
      AppMethodBeat.o(8914);
      return true;
    }
    AppMethodBeat.o(8914);
    return false;
  }
  
  public static void stop()
  {
    AppMethodBeat.i(8910);
    umx.clear();
    umy.clear();
    if (umz != null) {
      d.b(umz);
    }
    umz = null;
    AppMethodBeat.o(8910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.j
 * JD-Core Version:    0.7.0.1
 */