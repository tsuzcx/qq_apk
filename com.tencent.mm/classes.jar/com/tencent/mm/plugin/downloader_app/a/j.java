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
  private static LinkedList<String> qLl;
  private static LinkedList<String> qLm;
  private static d.d qLn;
  
  static
  {
    AppMethodBeat.i(8920);
    qLl = new LinkedList();
    qLm = new LinkedList();
    AppMethodBeat.o(8920);
  }
  
  public static void EN(String paramString)
  {
    AppMethodBeat.i(8916);
    qLm.remove(paramString);
    qLl.remove(paramString);
    if (b.cCi() != null) {
      b.cCi().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
    AppMethodBeat.o(8916);
  }
  
  public static int alA(String paramString)
  {
    AppMethodBeat.i(8913);
    if (qLm.contains(paramString))
    {
      i = k.qLo;
      AppMethodBeat.o(8913);
      return i;
    }
    int i = k.UN_INSTALLED;
    AppMethodBeat.o(8913);
    return i;
  }
  
  public static void alB(String paramString)
  {
    AppMethodBeat.i(8915);
    if (!contains(paramString))
    {
      qLl.addFirst(paramString);
      if (b.cCi() != null)
      {
        com.tencent.mm.plugin.downloader_app.c.a locala = new com.tencent.mm.plugin.downloader_app.c.a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.cCi().insert(locala);
      }
    }
    AppMethodBeat.o(8915);
  }
  
  public static boolean cBP()
  {
    AppMethodBeat.i(8917);
    if (qLl.size() > 0)
    {
      AppMethodBeat.o(8917);
      return true;
    }
    AppMethodBeat.o(8917);
    return false;
  }
  
  public static void cBS()
  {
    AppMethodBeat.i(175275);
    Iterator localIterator = qLl.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.alb((String)localIterator.next());
      if ((locala != null) && (locala.field_status == 1)) {
        f.cBv().Cp(locala.field_downloadId);
      }
    }
    AppMethodBeat.o(175275);
  }
  
  public static void cCf()
  {
    Object localObject1 = null;
    AppMethodBeat.i(8909);
    if (b.cCi() == null)
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
        if (((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status == k.qLo)
        {
          if (qLm.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
            continue;
          }
          qLm.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
          continue;
          localObject2 = b.cCi().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
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
        if (!qLl.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
          qLl.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
        }
      }
    }
    label216:
    if (qLn == null) {
      qLn = new d.d()
      {
        public final void O(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8908);
          com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Cw(paramAnonymousLong);
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
            j.CS(locala.field_appId);
            AppMethodBeat.o(8908);
            return;
          }
          if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
          {
            g localg = h.o(locala.field_appId, true, false);
            if ((localg != null) && (q.s(MMApplicationContext.getContext(), localg.field_packageName)))
            {
              Log.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
              AppMethodBeat.o(8908);
              return;
            }
            j.Pn(locala.field_appId);
          }
          AppMethodBeat.o(8908);
        }
      };
    }
    d.a(qLn);
    AppMethodBeat.o(8909);
  }
  
  public static LinkedList<String> cCg()
  {
    AppMethodBeat.i(8911);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(qLl);
    localLinkedList.addAll(qLm);
    AppMethodBeat.o(8911);
    return localLinkedList;
  }
  
  public static LinkedList<String> cCh()
  {
    AppMethodBeat.i(8912);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(qLl);
    AppMethodBeat.o(8912);
    return localLinkedList;
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(8914);
    if ((qLm.contains(paramString)) || (qLl.contains(paramString)))
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
    qLl.clear();
    qLm.clear();
    if (qLn != null) {
      d.b(qLn);
    }
    qLn = null;
    AppMethodBeat.o(8910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.j
 * JD-Core Version:    0.7.0.1
 */