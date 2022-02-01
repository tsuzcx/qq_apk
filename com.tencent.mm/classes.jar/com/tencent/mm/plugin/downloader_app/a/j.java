package com.tencent.mm.plugin.downloader_app.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.c.b;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<String> ppo;
  private static LinkedList<String> ppp;
  private static d.d ppq;
  
  static
  {
    AppMethodBeat.i(8920);
    ppo = new LinkedList();
    ppp = new LinkedList();
    AppMethodBeat.o(8920);
  }
  
  public static int aaD(String paramString)
  {
    AppMethodBeat.i(8913);
    if (ppp.contains(paramString))
    {
      i = k.ppr;
      AppMethodBeat.o(8913);
      return i;
    }
    int i = k.UN_INSTALLED;
    AppMethodBeat.o(8913);
    return i;
  }
  
  public static void aaE(String paramString)
  {
    AppMethodBeat.i(8915);
    if (!contains(paramString))
    {
      ppo.addFirst(paramString);
      if (b.cdd() != null)
      {
        com.tencent.mm.plugin.downloader_app.c.a locala = new com.tencent.mm.plugin.downloader_app.c.a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.cdd().insert(locala);
      }
    }
    AppMethodBeat.o(8915);
  }
  
  public static boolean ccE()
  {
    AppMethodBeat.i(8917);
    if (ppo.size() > 0)
    {
      AppMethodBeat.o(8917);
      return true;
    }
    AppMethodBeat.o(8917);
    return false;
  }
  
  public static void ccH()
  {
    AppMethodBeat.i(175275);
    Iterator localIterator = ppo.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aad((String)localIterator.next());
      if ((locala != null) && (locala.field_status == 1)) {
        f.ccl().tT(locala.field_downloadId);
      }
    }
    AppMethodBeat.o(175275);
  }
  
  public static void cda()
  {
    Object localObject1 = null;
    AppMethodBeat.i(8909);
    if (b.cdd() == null)
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
        ad.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", new Object[] { ((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status) });
        if (((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status == k.ppr)
        {
          if (ppp.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
            continue;
          }
          ppp.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
          continue;
          localObject2 = b.cdd().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
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
        if (!ppo.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
          ppo.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
        }
      }
    }
    label216:
    if (ppq == null) {
      ppq = new d.d()
      {
        public final void M(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8908);
          com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ua(paramAnonymousLong);
          if (locala == null)
          {
            AppMethodBeat.o(8908);
            return;
          }
          ad.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", new Object[] { Integer.valueOf(paramAnonymousInt), locala.field_appId });
          if (!j.contains(locala.field_appId))
          {
            AppMethodBeat.o(8908);
            return;
          }
          if (paramAnonymousInt == 9)
          {
            j.uh(locala.field_appId);
            AppMethodBeat.o(8908);
            return;
          }
          if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
          {
            g localg = h.m(locala.field_appId, true, false);
            if ((localg != null) && (q.s(aj.getContext(), localg.field_packageName)))
            {
              ad.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
              AppMethodBeat.o(8908);
              return;
            }
            j.FZ(locala.field_appId);
          }
          AppMethodBeat.o(8908);
        }
      };
    }
    d.a(ppq);
    AppMethodBeat.o(8909);
  }
  
  public static LinkedList<String> cdb()
  {
    AppMethodBeat.i(8911);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(ppo);
    localLinkedList.addAll(ppp);
    AppMethodBeat.o(8911);
    return localLinkedList;
  }
  
  public static LinkedList<String> cdc()
  {
    AppMethodBeat.i(8912);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(ppo);
    AppMethodBeat.o(8912);
    return localLinkedList;
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(8914);
    if ((ppp.contains(paramString)) || (ppo.contains(paramString)))
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
    ppo.clear();
    ppp.clear();
    if (ppq != null) {
      d.b(ppq);
    }
    ppq = null;
    AppMethodBeat.o(8910);
  }
  
  public static void vR(String paramString)
  {
    AppMethodBeat.i(8916);
    ppp.remove(paramString);
    ppo.remove(paramString);
    if (b.cdd() != null) {
      b.cdd().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
    AppMethodBeat.o(8916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.j
 * JD-Core Version:    0.7.0.1
 */