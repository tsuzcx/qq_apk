package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.preload.model.a.a;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMediaCacheLogic;", "", "()V", "TAG", "", "isOpenMultiBitRateDownload", "", "lock", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "memoryCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "checkFileFormat", "", "mediaId", "fileFormat", "deleteAll", "deleteBelowFileFormat", "originalMediaId", "findBestVideoToPlay", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "query", "isCheckFileExit", "queryByOriginalMediaId", "", "replace", "cache", "store", "url", "filePath", "codingFormat", "", "cacheSize", "", "totalSize", "state", "updatePlayed", "hasPlayed", "updateProgress", "plugin-finder_release"})
public final class c
{
  private static final boolean KUi;
  private static final HashMap<String, r> KXE;
  public static final c KXF;
  private static final Object lock;
  public static final com.tencent.mm.plugin.finder.storage.g qnb;
  
  static
  {
    AppMethodBeat.i(167109);
    KXF = new c();
    qnb = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaCacheStorage();
    lock = new Object();
    KXE = new HashMap();
    b localb = b.qJA;
    KUi = b.fUN();
    AppMethodBeat.o(167109);
  }
  
  public static boolean a(String paramString1, String arg1, String paramString3, String paramString4, int paramInt1, String paramString5, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(199095);
    k.h(paramString1, "mediaId");
    k.h(???, "originalMediaId");
    k.h(paramString3, "url");
    k.h(paramString4, "filePath");
    k.h(paramString5, "fileFormat");
    r localr = new r();
    localr.field_mediaId = paramString1;
    localr.field_originMediaId = ???;
    localr.field_url = paramString3;
    localr.field_filePath = paramString4;
    localr.field_reqFormat = paramInt1;
    localr.field_cacheSize = paramLong1;
    localr.field_totalSize = paramLong2;
    localr.field_fileFormat = paramString5;
    localr.field_state = paramInt2;
    synchronized (lock)
    {
      KXE.get(paramString1);
      boolean bool = d(localr);
      AppMethodBeat.o(199095);
      return bool;
    }
  }
  
  public static boolean aIG()
  {
    boolean bool = true;
    AppMethodBeat.i(199096);
    int i = qnb.db.delete(qnb.getTableName(), "rowid >= ?", new String[] { "0" });
    synchronized (lock)
    {
      KXE.clear();
      ad.i("Finder.MediaCacheLogic", "[deleteAll] ret=".concat(String.valueOf(i)));
      if (i >= 0)
      {
        AppMethodBeat.o(199096);
        return bool;
      }
      bool = false;
    }
  }
  
  public static List<r> aVB(String paramString)
  {
    AppMethodBeat.i(199094);
    k.h(paramString, "originalMediaId");
    long l1 = System.currentTimeMillis();
    Object localObject1 = qnb;
    k.h(paramString, "originMediaId");
    long l2 = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = "select * from FinderMediaCacheInfo  where originMediaId = '" + paramString + "' ";
    localObject1 = ((com.tencent.mm.plugin.finder.storage.g)localObject1).db.rawQuery((String)localObject2, null);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new r();
        ((r)localObject2).convertFrom((Cursor)localObject1);
        localLinkedList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
    }
    ad.i("Finder.FinderMediaCacheStorage", "[getByOriginMediaId] cost=" + (System.currentTimeMillis() - l2) + "ms");
    ad.i("Finder.MediaCacheLogic", "[queryByOriginalMediaId] cost=" + (System.currentTimeMillis() - l1) + "ms originalMediaId=" + paramString + " size=" + localLinkedList.size());
    paramString = (List)localLinkedList;
    AppMethodBeat.o(199094);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.finder.loader.l b(bmd parambmd)
  {
    AppMethodBeat.i(199097);
    k.h(parambmd, "media");
    Object localObject1 = parambmd.mediaId;
    k.g(localObject1, "media.mediaId");
    Object localObject2 = ((Iterable)j.a((Iterable)aVB((String)localObject1), (Comparator)new a())).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!((r)localObject1).cnn());
    for (;;)
    {
      localObject1 = (r)localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.preload.model.a.qEC;
      parambmd = new com.tencent.mm.plugin.finder.loader.l(parambmd, a.a.aVr(((r)localObject1).field_fileFormat), ((r)localObject1).field_reqFormat, null, 8);
      AppMethodBeat.o(199097);
      return parambmd;
      localObject1 = null;
    }
    parambmd = ((a.b)j.iy(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getMediaPreloadModel().a(parambmd, false))).qUh;
    AppMethodBeat.o(199097);
    return parambmd;
  }
  
  public static boolean d(r paramr)
  {
    AppMethodBeat.i(199089);
    k.h(paramr, "cache");
    paramr.field_updateTime = ce.asS();
    ??? = qnb;
    Object localObject2 = paramr.field_mediaId;
    k.g(localObject2, "cache.field_mediaId");
    k.h(localObject2, "mediaId");
    localObject2 = "select * from FinderMediaCacheInfo  where mediaId = '" + (String)localObject2 + "' ";
    ??? = ((com.tencent.mm.plugin.finder.storage.g)???).db.rawQuery((String)localObject2, null);
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
        bool2 = qnb.c(paramr);
      }
      synchronized (lock)
      {
        localObject2 = (Map)KXE;
        String str = paramr.field_mediaId;
        k.g(str, "cache.field_mediaId");
        ((Map)localObject2).put(str, paramr);
        localObject2 = y.JfV;
        ad.i("Finder.MediaCacheLogic", "replaced[" + bool2 + "] isExist=" + bool1 + ' ' + paramr);
        AppMethodBeat.o(199089);
        return bool2;
        bool1 = false;
        continue;
        bool2 = qnb.b(paramr);
      }
    }
  }
  
  public static r dm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(199092);
    k.h(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    Object localObject1;
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = new r();
      ((r)localObject1).field_mediaId = paramString;
      AppMethodBeat.o(199092);
      return localObject1;
    }
    synchronized (lock)
    {
      localObject1 = (r)KXE.get(paramString);
      if (localObject1 == null)
      {
        localObject1 = qnb;
        k.h(paramString, "mediaId");
        long l = System.currentTimeMillis();
        ??? = "select * from FinderMediaCacheInfo  where mediaId = '" + paramString + "' ";
        ??? = ((com.tencent.mm.plugin.finder.storage.g)localObject1).db.rawQuery((String)???, null);
        localObject1 = new r();
        ((r)localObject1).field_mediaId = paramString;
        if ((??? != null) && (((Cursor)???).moveToFirst()))
        {
          ((r)localObject1).convertFrom((Cursor)???);
          ((Cursor)???).close();
        }
        ad.i("Finder.FinderMediaCacheStorage", "[getByMediaId] cost=" + (System.currentTimeMillis() - l) + "ms");
      }
    }
    for (;;)
    {
      synchronized (lock)
      {
        ((Map)KXE).put(paramString, localObject1);
        y localy = y.JfV;
        k.g(localObject1, "synchronized(lock) { mem…        dbCache\n        }");
        if (paramBoolean)
        {
          if (((CharSequence)((r)localObject1).getFilePath()).length() <= 0) {
            break label395;
          }
          i = 1;
          if ((i != 0) && (!i.eK(((r)localObject1).getFilePath())))
          {
            ((r)localObject1).reset();
            ((r)localObject1).field_state = -2;
            d((r)localObject1);
            ad.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " not found file. state=" + ((r)localObject1).field_state + " filePath=" + ((r)localObject1).getFilePath());
          }
        }
        AppMethodBeat.o(199092);
        return localObject1;
        paramString = finally;
        AppMethodBeat.o(199092);
        throw paramString;
      }
      label395:
      i = 0;
    }
  }
  
  public static boolean f(String arg0, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(199090);
    k.h(???, "mediaId");
    com.tencent.mm.plugin.finder.storage.g localg = qnb;
    r localr = dm(???, false);
    localr.field_cacheSize = paramLong1;
    localr.field_totalSize = paramLong2;
    localr.field_state = paramInt;
    Object localObject4;
    for (;;)
    {
      synchronized (lock)
      {
        ((Map)KXE).put(???, localr);
        ??? = y.JfV;
        if (paramInt < 2) {
          break label474;
        }
        ??? = (CharSequence)localr.field_fileFormat;
        if ((??? == null) || (???.length() == 0))
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label474;
          }
          ??? = localr.field_originMediaId;
          k.g(???, "this.field_originMediaId");
          localObject3 = localr.field_fileFormat;
          k.g(localObject3, "this.field_fileFormat");
          synchronized (lock)
          {
            Object localObject5 = (Map)KXE;
            localObject4 = (Map)new LinkedHashMap();
            localObject5 = ((Map)localObject5).entrySet().iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject5).next();
            if (!k.g(((r)localEntry.getValue()).field_originMediaId, ???)) {
              break label319;
            }
            String str = ((r)localEntry.getValue()).field_fileFormat;
            k.g(str, "it.value.field_fileFormat");
            if (((String)localObject3).compareTo(str) >= 0) {
              break label319;
            }
            paramInt = 1;
            if (paramInt == 0) {
              continue;
            }
            ((Map)localObject4).put(localEntry.getKey(), localEntry.getValue());
          }
        }
      }
      paramInt = 0;
      continue;
      label319:
      paramInt = 0;
    }
    Object localObject3 = ((Map)localObject4).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      if (qnb.delete(((r)((Map.Entry)localObject4).getValue()).systemRowid))
      {
        KXE.remove(((Map.Entry)localObject4).getKey());
        ad.i("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId=" + (String)??? + " fileFormat=" + ((r)((Map.Entry)localObject4).getValue()).field_fileFormat + " systemRowid" + ((r)((Map.Entry)localObject4).getValue()).systemRowid);
      }
    }
    ??? = y.JfV;
    label474:
    boolean bool = localObject1.c(localr);
    AppMethodBeat.o(199090);
    return bool;
  }
  
  public static void ki(String paramString1, String arg1)
  {
    AppMethodBeat.i(199091);
    k.h(paramString1, "mediaId");
    k.h(???, "fileFormat");
    r localr;
    if (KUi)
    {
      localr = dm(paramString1, false);
      if ((k.g(localr.field_fileFormat, ???) ^ true))
      {
        ad.w("Finder.MediaCacheLogic", "[fileFormat] " + localr.field_fileFormat + " => " + ??? + " mediaId=" + paramString1);
        localr.field_fileFormat = ???;
      }
    }
    synchronized (lock)
    {
      ((Map)KXE).put(paramString1, localr);
      paramString1 = y.JfV;
      qnb.c(localr);
      AppMethodBeat.o(199091);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(199088);
      int i = d.b.a.a((Comparable)((r)paramT1).field_fileFormat, (Comparable)((r)paramT2).field_fileFormat);
      AppMethodBeat.o(199088);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.c
 * JD-Core Version:    0.7.0.1
 */