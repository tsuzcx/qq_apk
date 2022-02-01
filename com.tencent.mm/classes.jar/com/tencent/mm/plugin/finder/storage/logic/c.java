package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.model.a.a;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMediaCacheLogic;", "", "()V", "TAG", "", "THREAD_TAG", "isOpenMultiBitRateDownload", "", "lock", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "memoryCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "checkFileFormat", "", "mediaId", "fileFormat", "deleteAll", "deleteBelowFileFormat", "originalMediaId", "findBestVideoToPlay", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "query", "isCheckFileExit", "queryByOriginalMediaId", "", "replace", "cache", "store", "url", "filePath", "codingFormat", "", "cacheSize", "", "totalSize", "state", "duration", "urlToken", "decodeKey", "syncMemoryCacheToDB", "updateMoovReady", "updateMoovReadyMemory", "updatePlayed", "hasPlayed", "updateProgress", "updateProgressMemory", "plugin-finder_release"})
public final class c
{
  private static final Object lock;
  public static final com.tencent.mm.plugin.finder.storage.q rGa;
  private static final HashMap<String, y> sAu;
  public static final c sAv;
  private static final boolean slr;
  
  static
  {
    AppMethodBeat.i(167109);
    sAv = new c();
    rGa = ((PluginFinder)g.ad(PluginFinder.class)).getMediaCacheStorage();
    lock = new Object();
    sAu = new HashMap();
    b localb = b.sxa;
    slr = b.cGE();
    AppMethodBeat.o(167109);
  }
  
  public static y a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(203862);
    p.h(paramString, "mediaId");
    paramString = bf(paramString, false);
    paramString.field_cacheSize = paramLong1;
    paramString.field_totalSize = paramLong2;
    paramString.field_state = paramInt;
    if (!paramString.field_moovReady)
    {
      MediaPreloadCore.a locala = MediaPreloadCore.skO;
      if (MediaPreloadCore.a.a(paramString).skP) {
        paramString.field_moovReady = true;
      }
    }
    AppMethodBeat.o(203862);
    return paramString;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString6, String paramString7)
  {
    AppMethodBeat.i(203869);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "originalMediaId");
    p.h(paramString3, "url");
    p.h(paramString4, "filePath");
    p.h(paramString5, "fileFormat");
    y localy = new y();
    localy.field_mediaId = paramString1;
    localy.field_originMediaId = paramString2;
    localy.field_url = paramString3;
    localy.field_filePath = paramString4;
    localy.field_reqFormat = paramInt1;
    localy.field_cacheSize = paramLong1;
    localy.field_totalSize = paramLong2;
    localy.field_fileFormat = paramString5;
    localy.field_state = paramInt2;
    localy.field_duration = paramInt3;
    localy.field_urlToken = paramString6;
    localy.field_decodeKey = paramString7;
    boolean bool = d(localy);
    AppMethodBeat.o(203869);
    return bool;
  }
  
  public static boolean aSJ()
  {
    boolean bool = true;
    AppMethodBeat.i(203870);
    int i = rGa.db.delete(rGa.getTableName(), "rowid >= ?", new String[] { "0" });
    ad.i("Finder.MediaCacheLogic", "[deleteAll] ret=".concat(String.valueOf(i)));
    synchronized (lock)
    {
      sAu.clear();
      if (i >= 0)
      {
        AppMethodBeat.o(203870);
        return bool;
      }
      bool = false;
    }
  }
  
  public static void aiC(String paramString)
  {
    AppMethodBeat.i(203864);
    p.h(paramString, "mediaId");
    com.tencent.mm.ad.c.c("FinderMediaCacheUpdateThread", (d.g.a.a)new b(paramString));
    AppMethodBeat.o(203864);
  }
  
  public static List<y> aiE(String paramString)
  {
    AppMethodBeat.i(203868);
    p.h(paramString, "originalMediaId");
    long l = System.currentTimeMillis();
    Object localObject1 = rGa;
    p.h(paramString, "originMediaId");
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = "select *, rowid from FinderMediaCacheInfo  where originMediaId = '" + paramString + "' ";
    localObject1 = ((com.tencent.mm.plugin.finder.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new y();
        ((y)localObject2).convertFrom((Cursor)localObject1);
        localLinkedList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
    }
    ad.i("Finder.MediaCacheLogic", "[queryByOriginalMediaId] cost=" + (System.currentTimeMillis() - l) + "ms originalMediaId=" + paramString + " size=" + localLinkedList.size());
    paramString = (List)localLinkedList;
    AppMethodBeat.o(203868);
    return paramString;
  }
  
  public static m b(bvf parambvf)
  {
    AppMethodBeat.i(203872);
    p.h(parambvf, "media");
    Object localObject1 = parambvf.mediaId;
    p.g(localObject1, "media.mediaId");
    Object localObject2 = ((Iterable)j.a((Iterable)aiE((String)localObject1), (Comparator)new a())).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!((y)localObject1).cCX());
    for (;;)
    {
      localObject1 = (y)localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.preload.model.a.slu;
      parambvf = new m(parambvf, a.a.ahG(((y)localObject1).field_fileFormat), ((y)localObject1).field_reqFormat, null, 8);
      AppMethodBeat.o(203872);
      return parambvf;
      localObject1 = null;
    }
    parambvf = ((a.b)j.jc(((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel().a(parambvf, false))).slw;
    AppMethodBeat.o(203872);
    return parambvf;
  }
  
  public static y bf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203866);
    p.h(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    y localy;
    for (int i = 1; i != 0; i = 0)
    {
      localy = new y();
      localy.field_mediaId = paramString;
      AppMethodBeat.o(203866);
      return localy;
    }
    synchronized (lock)
    {
      localy = (y)sAu.get(paramString);
      if (localy == null) {
        localy = rGa.ait(paramString);
      }
    }
    for (;;)
    {
      synchronized (lock)
      {
        ((Map)sAu).put(paramString, localy);
        z localz = z.MKo;
        p.g(localy, "synchronized(lock) { mem…        dbCache\n        }");
        if (paramBoolean)
        {
          if (((CharSequence)localy.getFilePath()).length() <= 0) {
            break label257;
          }
          i = 1;
          if ((i != 0) && (!i.fv(localy.getFilePath())))
          {
            localy.reset();
            localy.field_state = -2;
            d(localy);
            ad.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " not found file. state=" + localy.field_state + " filePath=" + localy.getFilePath());
          }
        }
        AppMethodBeat.o(203866);
        return localy;
        paramString = finally;
        AppMethodBeat.o(203866);
        throw paramString;
      }
      label257:
      i = 0;
    }
  }
  
  public static boolean d(y paramy)
  {
    AppMethodBeat.i(203861);
    p.h(paramy, "cache");
    paramy.field_updateTime = cf.aCM();
    ??? = rGa;
    Object localObject2 = paramy.field_mediaId;
    p.g(localObject2, "cache.field_mediaId");
    p.h(localObject2, "mediaId");
    localObject2 = "select *, rowid from FinderMediaCacheInfo  where mediaId = '" + (String)localObject2 + "' ";
    ??? = ((com.tencent.mm.plugin.finder.storage.q)???).db.rawQuery((String)localObject2, null);
    p.g(???, "cursor");
    boolean bool1;
    if (((Cursor)???).getCount() > 0) {
      bool1 = true;
    }
    for (;;)
    {
      ((Cursor)???).close();
      boolean bool2;
      if (bool1) {
        bool2 = rGa.c(paramy);
      }
      synchronized (lock)
      {
        localObject2 = (Map)sAu;
        String str1 = paramy.field_mediaId;
        p.g(str1, "cache.field_mediaId");
        com.tencent.mm.plugin.finder.storage.q localq = rGa;
        String str2 = paramy.field_mediaId;
        p.g(str2, "cache.field_mediaId");
        ((Map)localObject2).put(str1, localq.ait(str2));
        localObject2 = z.MKo;
        ad.i("Finder.MediaCacheLogic", "replaced[" + bool2 + "] isExist=" + bool1 + ' ' + paramy);
        AppMethodBeat.o(203861);
        return bool2;
        bool1 = false;
        continue;
        bool2 = rGa.b(paramy);
      }
    }
  }
  
  public static boolean dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(203865);
    p.h(paramString, "mediaId");
    com.tencent.mm.plugin.finder.storage.q localq = rGa;
    y localy = bf(paramString, false);
    Object localObject;
    if (!localy.field_moovReady)
    {
      localObject = MediaPreloadCore.skO;
      if (MediaPreloadCore.a.a(localy).skP) {
        localy.field_moovReady = true;
      }
      ad.i("Finder.MediaCacheLogic", "update moov ready " + localy.field_mediaId + " moovReady:" + localy.field_moovReady + " audio:" + localy.field_audioBitrate + " video:" + localy.field_videoBitrate + " frameRate:" + localy.field_frameRate);
    }
    localy.field_cacheSize = 0L;
    localy.field_totalSize = 0L;
    localy.field_state = paramInt;
    if (paramInt >= 2)
    {
      localObject = (CharSequence)localy.field_fileFormat;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label327;
      }
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)localy.field_originMediaId;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label332;
        }
      }
    }
    label327:
    label332:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = localy.field_originMediaId;
        p.g(localObject, "this.field_originMediaId");
        String str = localy.field_fileFormat;
        p.g(str, "this.field_fileFormat");
        gq((String)localObject, str);
      }
      if (ad.getLogLevel() <= 1) {
        ad.d("Finder.MediaCacheLogic", "[updateProgress] mediaId=" + paramString + " cacheSize=0 totalSize=0 state=" + paramInt + " moovReady=" + localy.field_moovReady);
      }
      boolean bool = localq.c(localy);
      AppMethodBeat.o(203865);
      return bool;
      i = 0;
      break;
    }
  }
  
  public static y gp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203863);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "fileFormat");
    paramString1 = bf(paramString1, false);
    paramString1.field_moovReady = true;
    if ((p.i(paramString1.field_fileFormat, paramString2) ^ true)) {
      paramString1.field_fileFormat = paramString2;
    }
    AppMethodBeat.o(203863);
    return paramString1;
  }
  
  private static void gq(String paramString1, String arg1)
  {
    AppMethodBeat.i(203871);
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.w("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId is Empty.");
      AppMethodBeat.o(203871);
      return;
    }
    Object localObject2 = (Iterable)aiE(paramString1);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label156:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      Object localObject4 = (y)localObject3;
      if (p.i(((y)localObject4).field_originMediaId, paramString1))
      {
        localObject4 = ((y)localObject4).field_fileFormat;
        p.g(localObject4, "it.field_fileFormat");
        if (???.compareTo((String)localObject4) >= 0) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label156;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (y)((Iterator)localObject1).next();
        if (!rGa.delete(((y)localObject2).systemRowid)) {}
      }
      else
      {
        synchronized (lock)
        {
          sAu.remove(((y)localObject2).field_mediaId);
          ad.i("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId=" + paramString1 + " fileFormat=" + ((y)localObject2).field_fileFormat + " systemRowid" + ((y)localObject2).systemRowid);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(203859);
      int i = d.b.a.a((Comparable)Integer.valueOf(((y)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((y)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(203859);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.c
 * JD-Core Version:    0.7.0.1
 */