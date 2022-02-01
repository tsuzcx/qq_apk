package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.model.a.a;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.vlog.model.l.a;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.k;
import d.y;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMediaCacheLogic;", "", "()V", "TAG", "", "isOpenMultiBitRateDownload", "", "lock", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "memoryCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "checkFileFormat", "", "mediaId", "fileFormat", "deleteAll", "deleteBelowFileFormat", "originalMediaId", "findBestVideoToPlay", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "query", "isCheckFileExit", "queryByOriginalMediaId", "", "replace", "cache", "store", "url", "filePath", "codingFormat", "", "cacheSize", "", "totalSize", "state", "updateMoovReady", "updatePlayed", "hasPlayed", "updateProgress", "plugin-finder_release"})
public final class c
{
  private static final Object lock;
  public static final com.tencent.mm.plugin.finder.storage.l qVE;
  private static final HashMap<String, w> rFn;
  public static final c rFo;
  private static final boolean rwd;
  
  static
  {
    AppMethodBeat.i(167109);
    rFo = new c();
    qVE = ((PluginFinder)g.ad(PluginFinder.class)).getMediaCacheStorage();
    lock = new Object();
    rFn = new HashMap();
    b localb = b.rCU;
    rwd = b.cAk();
    AppMethodBeat.o(167109);
  }
  
  public static boolean a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(203060);
    k.h(paramString, "mediaId");
    com.tencent.mm.plugin.finder.storage.l locall = qVE;
    w localw = ba(paramString, false);
    if (!localw.field_moovReady)
    {
      ??? = MediaPreloadCore.rvo;
      if (MediaPreloadCore.a.a(localw).rvp)
      {
        localw.field_moovReady = true;
        ??? = com.tencent.mm.plugin.vlog.model.l.AnC;
        ??? = com.tencent.mm.plugin.vlog.model.l.aye(localw.getFilePath());
        if (??? != null)
        {
          localw.field_audioBitrate = 0;
          localw.field_videoBitrate = ((l.a)???).bitrate;
          localw.field_frameRate = d.h.a.cj(((l.a)???).clj);
        }
      }
      ac.i("Finder.MediaCacheLogic", "update moov ready " + localw.field_mediaId + " moovReady:" + localw.field_moovReady + " audio:" + localw.field_audioBitrate + " video:" + localw.field_videoBitrate + " frameRate:" + localw.field_frameRate);
    }
    localw.field_cacheSize = paramLong1;
    localw.field_totalSize = paramLong2;
    localw.field_state = paramInt;
    for (;;)
    {
      synchronized (lock)
      {
        ((Map)rFn).put(paramString, localw);
        Object localObject2 = y.KTp;
        if (paramInt >= 2)
        {
          ??? = (CharSequence)localw.field_fileFormat;
          if ((??? != null) && (((CharSequence)???).length() != 0)) {
            break label400;
          }
          i = 1;
          if (i == 0)
          {
            ??? = localw.field_originMediaId;
            k.g(???, "this.field_originMediaId");
            localObject2 = localw.field_fileFormat;
            k.g(localObject2, "this.field_fileFormat");
            nq((String)???, (String)localObject2);
          }
        }
        ac.d("Finder.MediaCacheLogic", "[updateProgress] mediaId=" + paramString + " cacheSize=" + paramLong1 + " totalSize=" + paramLong2 + " state=" + paramInt + " moovReady=" + localw.field_moovReady);
        boolean bool = locall.c(localw);
        AppMethodBeat.o(203060);
        return bool;
      }
      label400:
      int i = 0;
    }
  }
  
  public static boolean a(String paramString1, String arg1, String paramString3, String paramString4, int paramInt1, String paramString5, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(203065);
    k.h(paramString1, "mediaId");
    k.h(???, "originalMediaId");
    k.h(paramString3, "url");
    k.h(paramString4, "filePath");
    k.h(paramString5, "fileFormat");
    w localw = new w();
    localw.field_mediaId = paramString1;
    localw.field_originMediaId = ???;
    localw.field_url = paramString3;
    localw.field_filePath = paramString4;
    localw.field_reqFormat = paramInt1;
    localw.field_cacheSize = paramLong1;
    localw.field_totalSize = paramLong2;
    localw.field_fileFormat = paramString5;
    localw.field_state = paramInt2;
    synchronized (lock)
    {
      rFn.get(paramString1);
      boolean bool = d(localw);
      AppMethodBeat.o(203065);
      return bool;
    }
  }
  
  public static boolean aPx()
  {
    boolean bool = true;
    AppMethodBeat.i(203066);
    int i = qVE.db.delete(qVE.getTableName(), "rowid >= ?", new String[] { "0" });
    synchronized (lock)
    {
      rFn.clear();
      ac.i("Finder.MediaCacheLogic", "[deleteAll] ret=".concat(String.valueOf(i)));
      if (i >= 0)
      {
        AppMethodBeat.o(203066);
        return bool;
      }
      bool = false;
    }
  }
  
  public static boolean aeh(String paramString)
  {
    AppMethodBeat.i(203059);
    k.h(paramString, "mediaId");
    com.tencent.mm.plugin.finder.storage.l locall = qVE;
    paramString = ba(paramString, false);
    paramString.field_moovReady = true;
    boolean bool = locall.c(paramString);
    AppMethodBeat.o(203059);
    return bool;
  }
  
  public static List<w> aej(String paramString)
  {
    AppMethodBeat.i(203064);
    k.h(paramString, "originalMediaId");
    long l1 = System.currentTimeMillis();
    Object localObject1 = qVE;
    k.h(paramString, "originMediaId");
    long l2 = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = "select * from FinderMediaCacheInfo  where originMediaId = '" + paramString + "' ";
    localObject1 = ((com.tencent.mm.plugin.finder.storage.l)localObject1).db.rawQuery((String)localObject2, null);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new w();
        ((w)localObject2).convertFrom((Cursor)localObject1);
        localLinkedList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
    }
    ac.i("Finder.FinderMediaCacheStorage", "[getByOriginMediaId] cost=" + (System.currentTimeMillis() - l2) + "ms");
    ac.i("Finder.MediaCacheLogic", "[queryByOriginalMediaId] cost=" + (System.currentTimeMillis() - l1) + "ms originalMediaId=" + paramString + " size=" + localLinkedList.size());
    paramString = (List)localLinkedList;
    AppMethodBeat.o(203064);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.finder.loader.l b(bqs parambqs)
  {
    AppMethodBeat.i(203067);
    k.h(parambqs, "media");
    Object localObject1 = parambqs.mediaId;
    k.g(localObject1, "media.mediaId");
    Object localObject2 = ((Iterable)j.a((Iterable)aej((String)localObject1), (Comparator)new c.a())).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!((w)localObject1).cwH());
    for (;;)
    {
      localObject1 = (w)localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.preload.model.a.rvO;
      parambqs = new com.tencent.mm.plugin.finder.loader.l(parambqs, a.a.adK(((w)localObject1).field_fileFormat), ((w)localObject1).field_reqFormat, null, 8);
      AppMethodBeat.o(203067);
      return parambqs;
      localObject1 = null;
    }
    parambqs = ((a.b)j.iO(((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel().a(parambqs, false))).rvQ;
    AppMethodBeat.o(203067);
    return parambqs;
  }
  
  public static w ba(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203062);
    k.h(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    Object localObject1;
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = new w();
      ((w)localObject1).field_mediaId = paramString;
      AppMethodBeat.o(203062);
      return localObject1;
    }
    synchronized (lock)
    {
      localObject1 = (w)rFn.get(paramString);
      if (localObject1 == null)
      {
        localObject1 = qVE;
        k.h(paramString, "mediaId");
        long l = System.currentTimeMillis();
        ??? = "select * from FinderMediaCacheInfo  where mediaId = '" + paramString + "' ";
        ??? = ((com.tencent.mm.plugin.finder.storage.l)localObject1).db.rawQuery((String)???, null);
        localObject1 = new w();
        ((w)localObject1).field_mediaId = paramString;
        if ((??? != null) && (((Cursor)???).moveToFirst()))
        {
          ((w)localObject1).convertFrom((Cursor)???);
          ((Cursor)???).close();
        }
        ac.i("Finder.FinderMediaCacheStorage", "[getByMediaId] cost=" + (System.currentTimeMillis() - l) + "ms");
      }
    }
    for (;;)
    {
      synchronized (lock)
      {
        ((Map)rFn).put(paramString, localObject1);
        y localy = y.KTp;
        k.g(localObject1, "synchronized(lock) { mem…        dbCache\n        }");
        if (paramBoolean)
        {
          if (((CharSequence)((w)localObject1).getFilePath()).length() <= 0) {
            break label396;
          }
          i = 1;
          if ((i != 0) && (!i.eA(((w)localObject1).getFilePath())))
          {
            ((w)localObject1).reset();
            ((w)localObject1).field_state = -2;
            d((w)localObject1);
            ac.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " not found file. state=" + ((w)localObject1).field_state + " filePath=" + ((w)localObject1).getFilePath());
          }
        }
        AppMethodBeat.o(203062);
        return localObject1;
        paramString = finally;
        AppMethodBeat.o(203062);
        throw paramString;
      }
      label396:
      i = 0;
    }
  }
  
  public static boolean d(w paramw)
  {
    AppMethodBeat.i(203058);
    k.h(paramw, "cache");
    paramw.field_updateTime = ce.azJ();
    ??? = qVE;
    Object localObject2 = paramw.field_mediaId;
    k.g(localObject2, "cache.field_mediaId");
    k.h(localObject2, "mediaId");
    localObject2 = "select * from FinderMediaCacheInfo  where mediaId = '" + (String)localObject2 + "' ";
    ??? = ((com.tencent.mm.plugin.finder.storage.l)???).db.rawQuery((String)localObject2, null);
    k.g(???, "cursor");
    boolean bool1;
    if (((Cursor)???).getCount() > 0) {
      bool1 = true;
    }
    for (;;)
    {
      ((Cursor)???).close();
      boolean bool2;
      if (bool1) {
        bool2 = qVE.c(paramw);
      }
      synchronized (lock)
      {
        localObject2 = (Map)rFn;
        String str = paramw.field_mediaId;
        k.g(str, "cache.field_mediaId");
        ((Map)localObject2).put(str, paramw);
        localObject2 = y.KTp;
        ac.i("Finder.MediaCacheLogic", "replaced[" + bool2 + "] isExist=" + bool1 + ' ' + paramw);
        AppMethodBeat.o(203058);
        return bool2;
        bool1 = false;
        continue;
        bool2 = qVE.b(paramw);
      }
    }
  }
  
  public static void gf(String paramString1, String arg1)
  {
    AppMethodBeat.i(203061);
    k.h(paramString1, "mediaId");
    k.h(???, "fileFormat");
    w localw;
    if (rwd)
    {
      localw = ba(paramString1, false);
      if ((k.g(localw.field_fileFormat, ???) ^ true))
      {
        ac.w("Finder.MediaCacheLogic", "[fileFormat] " + localw.field_fileFormat + " => " + ??? + " mediaId=" + paramString1);
        localw.field_fileFormat = ???;
      }
    }
    synchronized (lock)
    {
      ((Map)rFn).put(paramString1, localw);
      paramString1 = y.KTp;
      qVE.c(localw);
      AppMethodBeat.o(203061);
      return;
    }
  }
  
  private static void nq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210192);
    Object localObject2;
    for (;;)
    {
      synchronized (lock)
      {
        Object localObject3 = (Map)rFn;
        localObject2 = (Map)new LinkedHashMap();
        localObject3 = ((Map)localObject3).entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        if (k.g(((w)localEntry.getValue()).field_originMediaId, paramString1))
        {
          String str = ((w)localEntry.getValue()).field_fileFormat;
          k.g(str, "it.value.field_fileFormat");
          if (paramString2.compareTo(str) < 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
          }
        }
      }
      int i = 0;
    }
    paramString2 = ((Map)localObject2).entrySet().iterator();
    while (paramString2.hasNext())
    {
      localObject2 = (Map.Entry)paramString2.next();
      if (qVE.delete(((w)((Map.Entry)localObject2).getValue()).systemRowid))
      {
        rFn.remove(((Map.Entry)localObject2).getKey());
        ac.i("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId=" + paramString1 + " fileFormat=" + ((w)((Map.Entry)localObject2).getValue()).field_fileFormat + " systemRowid" + ((w)((Map.Entry)localObject2).getValue()).systemRowid);
      }
    }
    paramString1 = y.KTp;
    AppMethodBeat.o(210192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.c
 * JD-Core Version:    0.7.0.1
 */