package com.tencent.mm.plugin.downloader_app.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.c.b;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<String> oLG;
  private static LinkedList<String> oLH;
  private static d.d oLI;
  
  static
  {
    AppMethodBeat.i(8920);
    oLG = new LinkedList();
    oLH = new LinkedList();
    AppMethodBeat.o(8920);
  }
  
  public static int WW(String paramString)
  {
    AppMethodBeat.i(8913);
    if (oLH.contains(paramString))
    {
      i = k.oLJ;
      AppMethodBeat.o(8913);
      return i;
    }
    int i = k.UN_INSTALLED;
    AppMethodBeat.o(8913);
    return i;
  }
  
  public static void WX(String paramString)
  {
    AppMethodBeat.i(8915);
    if (!contains(paramString))
    {
      oLG.addFirst(paramString);
      if (b.bYz() != null)
      {
        com.tencent.mm.plugin.downloader_app.c.a locala = new com.tencent.mm.plugin.downloader_app.c.a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.bYz().insert(locala);
      }
    }
    AppMethodBeat.o(8915);
  }
  
  public static boolean bYa()
  {
    AppMethodBeat.i(8917);
    if (oLG.size() > 0)
    {
      AppMethodBeat.o(8917);
      return true;
    }
    AppMethodBeat.o(8917);
    return false;
  }
  
  public static void bYd()
  {
    AppMethodBeat.i(175275);
    Iterator localIterator = oLG.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Ww((String)localIterator.next());
      if ((locala != null) && (locala.field_status == 1)) {
        f.bXJ().rU(locala.field_downloadId);
      }
    }
    AppMethodBeat.o(175275);
  }
  
  public static void bYw()
  {
    Object localObject1 = null;
    AppMethodBeat.i(8909);
    if (b.bYz() == null)
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
        ac.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", new Object[] { ((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status) });
        if (((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status == k.oLJ)
        {
          if (oLH.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
            continue;
          }
          oLH.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
          continue;
          localObject2 = b.bYz().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
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
        if (!oLG.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
          oLG.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
        }
      }
    }
    label216:
    if (oLI == null) {
      oLI = new d.d()
      {
        public final void K(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8908);
          com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.sc(paramAnonymousLong);
          if (locala == null)
          {
            AppMethodBeat.o(8908);
            return;
          }
          ac.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", new Object[] { Integer.valueOf(paramAnonymousInt), locala.field_appId });
          if (!j.contains(locala.field_appId))
          {
            AppMethodBeat.o(8908);
            return;
          }
          if (paramAnonymousInt == 9)
          {
            j.rv(locala.field_appId);
            AppMethodBeat.o(8908);
            return;
          }
          if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
          {
            g localg = h.k(locala.field_appId, true, false);
            if ((localg != null) && (q.t(ai.getContext(), localg.field_packageName)))
            {
              ac.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
              AppMethodBeat.o(8908);
              return;
            }
            j.CU(locala.field_appId);
          }
          AppMethodBeat.o(8908);
        }
      };
    }
    d.a(oLI);
    AppMethodBeat.o(8909);
  }
  
  public static LinkedList<String> bYx()
  {
    AppMethodBeat.i(8911);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(oLG);
    localLinkedList.addAll(oLH);
    AppMethodBeat.o(8911);
    return localLinkedList;
  }
  
  public static LinkedList<String> bYy()
  {
    AppMethodBeat.i(8912);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(oLG);
    AppMethodBeat.o(8912);
    return localLinkedList;
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(8914);
    if ((oLH.contains(paramString)) || (oLG.contains(paramString)))
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
    oLG.clear();
    oLH.clear();
    if (oLI != null) {
      d.b(oLI);
    }
    oLI = null;
    AppMethodBeat.o(8910);
  }
  
  public static void tc(String paramString)
  {
    AppMethodBeat.i(8916);
    oLH.remove(paramString);
    oLG.remove(paramString);
    if (b.bYz() != null) {
      b.bYz().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
    AppMethodBeat.o(8916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.j
 * JD-Core Version:    0.7.0.1
 */