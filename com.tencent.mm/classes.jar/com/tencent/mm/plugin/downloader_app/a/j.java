package com.tencent.mm.plugin.downloader_app.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.c.b;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<String> xsJ;
  private static LinkedList<String> xsK;
  private static d.d xsL;
  
  static
  {
    AppMethodBeat.i(8920);
    xsJ = new LinkedList();
    xsK = new LinkedList();
    AppMethodBeat.o(8920);
  }
  
  public static void Em(String paramString)
  {
    AppMethodBeat.i(8916);
    xsK.remove(paramString);
    xsJ.remove(paramString);
    if (b.dvf() != null) {
      b.dvf().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
    AppMethodBeat.o(8916);
  }
  
  public static int ani(String paramString)
  {
    AppMethodBeat.i(8913);
    if (xsK.contains(paramString))
    {
      i = k.xsM;
      AppMethodBeat.o(8913);
      return i;
    }
    int i = k.UN_INSTALLED;
    AppMethodBeat.o(8913);
    return i;
  }
  
  public static void anj(String paramString)
  {
    AppMethodBeat.i(8915);
    if (!contains(paramString))
    {
      xsJ.addFirst(paramString);
      if (b.dvf() != null)
      {
        com.tencent.mm.plugin.downloader_app.c.a locala = new com.tencent.mm.plugin.downloader_app.c.a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.dvf().insert(locala);
      }
    }
    AppMethodBeat.o(8915);
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(8914);
    if ((xsK.contains(paramString)) || (xsJ.contains(paramString)))
    {
      AppMethodBeat.o(8914);
      return true;
    }
    AppMethodBeat.o(8914);
    return false;
  }
  
  public static boolean duM()
  {
    AppMethodBeat.i(8917);
    if (xsJ.size() > 0)
    {
      AppMethodBeat.o(8917);
      return true;
    }
    AppMethodBeat.o(8917);
    return false;
  }
  
  public static void duP()
  {
    AppMethodBeat.i(175275);
    Iterator localIterator = xsJ.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.amJ((String)localIterator.next());
      if ((locala != null) && (locala.field_status == 1)) {
        f.duv().kT(locala.field_downloadId);
      }
    }
    AppMethodBeat.o(175275);
  }
  
  public static void dvc()
  {
    Object localObject1 = null;
    AppMethodBeat.i(8909);
    if (b.dvf() == null)
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
        if (((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status == k.xsM)
        {
          if (xsK.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
            continue;
          }
          xsK.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
          continue;
          localObject2 = b.dvf().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
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
        if (!xsJ.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
          xsJ.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
        }
      }
    }
    label216:
    if (xsL == null) {
      xsL = new d.d()
      {
        public final void S(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8908);
          com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramAnonymousLong);
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
            j.Co(locala.field_appId);
            AppMethodBeat.o(8908);
            return;
          }
          if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
          {
            g localg = h.s(locala.field_appId, true, false);
            if ((localg != null) && (u.y(MMApplicationContext.getContext(), localg.field_packageName)))
            {
              Log.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
              AppMethodBeat.o(8908);
              return;
            }
            j.OJ(locala.field_appId);
          }
          AppMethodBeat.o(8908);
        }
      };
    }
    d.a(xsL);
    AppMethodBeat.o(8909);
  }
  
  public static LinkedList<String> dvd()
  {
    AppMethodBeat.i(8911);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(xsJ);
    localLinkedList.addAll(xsK);
    AppMethodBeat.o(8911);
    return localLinkedList;
  }
  
  public static LinkedList<String> dve()
  {
    AppMethodBeat.i(8912);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(xsJ);
    AppMethodBeat.o(8912);
    return localLinkedList;
  }
  
  public static void stop()
  {
    AppMethodBeat.i(8910);
    xsJ.clear();
    xsK.clear();
    if (xsL != null) {
      d.b(xsL);
    }
    xsL = null;
    AppMethodBeat.o(8910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.j
 * JD-Core Version:    0.7.0.1
 */