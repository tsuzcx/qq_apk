package com.tencent.mm.plugin.downloader_app.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.c.b;
import com.tencent.mm.plugin.downloader_app.c.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
{
  private static LinkedList<String> pvU;
  private static LinkedList<String> pvV;
  private static d.d pvW;
  
  static
  {
    AppMethodBeat.i(8920);
    pvU = new LinkedList();
    pvV = new LinkedList();
    AppMethodBeat.o(8920);
  }
  
  public static int abu(String paramString)
  {
    AppMethodBeat.i(8913);
    if (pvV.contains(paramString))
    {
      i = k.pvX;
      AppMethodBeat.o(8913);
      return i;
    }
    int i = k.UN_INSTALLED;
    AppMethodBeat.o(8913);
    return i;
  }
  
  public static void abv(String paramString)
  {
    AppMethodBeat.i(8915);
    if (!contains(paramString))
    {
      pvU.addFirst(paramString);
      if (b.ces() != null)
      {
        com.tencent.mm.plugin.downloader_app.c.a locala = new com.tencent.mm.plugin.downloader_app.c.a();
        locala.field_appId = paramString;
        locala.field_modifyTime = System.currentTimeMillis();
        b.ces().insert(locala);
      }
    }
    AppMethodBeat.o(8915);
  }
  
  public static boolean cdT()
  {
    AppMethodBeat.i(8917);
    if (pvU.size() > 0)
    {
      AppMethodBeat.o(8917);
      return true;
    }
    AppMethodBeat.o(8917);
    return false;
  }
  
  public static void cdW()
  {
    AppMethodBeat.i(175275);
    Iterator localIterator = pvU.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.aaU((String)localIterator.next());
      if ((locala != null) && (locala.field_status == 1)) {
        f.cdA().uk(locala.field_downloadId);
      }
    }
    AppMethodBeat.o(175275);
  }
  
  public static void cep()
  {
    Object localObject1 = null;
    AppMethodBeat.i(8909);
    if (b.ces() == null)
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
        ae.d("MicroMsg.TaskManager", "initFromDB, appId:%s, status:%d", new Object[] { ((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId, Integer.valueOf(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status) });
        if (((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_status == k.pvX)
        {
          if (pvV.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
            continue;
          }
          pvV.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
          continue;
          localObject2 = b.ces().rawQuery(String.format("select * from %s order by %s desc", new Object[] { "DownloadTaskItem", "modifyTime" }), new String[0]);
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
        if (!pvU.contains(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId)) {
          pvU.add(((com.tencent.mm.plugin.downloader_app.c.a)localObject2).field_appId);
        }
      }
    }
    label216:
    if (pvW == null) {
      pvW = new d.d()
      {
        public final void L(int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(8908);
          com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramAnonymousLong);
          if (locala == null)
          {
            AppMethodBeat.o(8908);
            return;
          }
          ae.i("MicroMsg.TaskManager", "onDownloadStatusChange, event = %d, appId = %s", new Object[] { Integer.valueOf(paramAnonymousInt), locala.field_appId });
          if (!j.contains(locala.field_appId))
          {
            AppMethodBeat.o(8908);
            return;
          }
          if (paramAnonymousInt == 9)
          {
            j.uC(locala.field_appId);
            AppMethodBeat.o(8908);
            return;
          }
          if ((paramAnonymousInt == 1) || (paramAnonymousInt == 7))
          {
            g localg = h.m(locala.field_appId, true, false);
            if ((localg != null) && (q.s(ak.getContext(), localg.field_packageName)))
            {
              ae.i("MicroMsg.TaskManager", "onDownloadStatusChange, hasInstall");
              AppMethodBeat.o(8908);
              return;
            }
            j.GB(locala.field_appId);
          }
          AppMethodBeat.o(8908);
        }
      };
    }
    d.a(pvW);
    AppMethodBeat.o(8909);
  }
  
  public static LinkedList<String> ceq()
  {
    AppMethodBeat.i(8911);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(pvU);
    localLinkedList.addAll(pvV);
    AppMethodBeat.o(8911);
    return localLinkedList;
  }
  
  public static LinkedList<String> cer()
  {
    AppMethodBeat.i(8912);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(pvU);
    AppMethodBeat.o(8912);
    return localLinkedList;
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(8914);
    if ((pvV.contains(paramString)) || (pvU.contains(paramString)))
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
    pvU.clear();
    pvV.clear();
    if (pvW != null) {
      d.b(pvW);
    }
    pvW = null;
    AppMethodBeat.o(8910);
  }
  
  public static void wy(String paramString)
  {
    AppMethodBeat.i(8916);
    pvV.remove(paramString);
    pvU.remove(paramString);
    if (b.ces() != null) {
      b.ces().execSQL("DownloadTaskItem", String.format("delete from %s where %s=\"%s\"", new Object[] { "DownloadTaskItem", "appId", paramString }));
    }
    AppMethodBeat.o(8916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.j
 * JD-Core Version:    0.7.0.1
 */