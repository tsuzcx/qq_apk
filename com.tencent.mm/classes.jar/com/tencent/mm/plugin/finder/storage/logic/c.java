package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.model.a.a;
import com.tencent.mm.plugin.finder.preload.model.a.b;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMediaCacheLogic;", "", "()V", "TAG", "", "THREAD_TAG", "isOpenMultiBitRateDownload", "", "lock", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "memoryCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "checkFileFormat", "", "mediaId", "fileFormat", "deleteAll", "deleteBelowFileFormat", "originalMediaId", "findBestVideoToPlay", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "query", "isCheckFileExit", "queryByOriginalMediaId", "", "replace", "cache", "store", "url", "codingFormat", "", "cacheSize", "", "totalSize", "state", "duration", "urlToken", "decodeKey", "syncMemoryCacheToDB", "updateMoovReady", "updateMoovReadyMemory", "updatePlayed", "hasPlayed", "updateProgress", "updateProgressMemory", "plugin-finder_release"})
public final class c
{
  private static final Object lock;
  public static final com.tencent.mm.plugin.finder.storage.q rOl;
  private static final HashMap<String, com.tencent.mm.plugin.finder.model.z> sLs;
  public static final c sLt;
  private static final boolean suq;
  
  static
  {
    AppMethodBeat.i(167109);
    sLt = new c();
    rOl = ((PluginFinder)g.ad(PluginFinder.class)).getMediaCacheStorage();
    lock = new Object();
    sLs = new HashMap();
    b localb = b.sHP;
    suq = b.cIB();
    AppMethodBeat.o(167109);
  }
  
  public static com.tencent.mm.plugin.finder.model.z a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(204454);
    p.h(paramString, "mediaId");
    paramString = bi(paramString, false);
    paramString.field_cacheSize = paramLong1;
    paramString.field_totalSize = paramLong2;
    paramString.field_state = paramInt;
    if (!paramString.field_moovReady)
    {
      MediaPreloadCore.a locala = MediaPreloadCore.stL;
      if (MediaPreloadCore.a.a(paramString).stM) {
        paramString.field_moovReady = true;
      }
    }
    AppMethodBeat.o(204454);
    return paramString;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(224305);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "originalMediaId");
    p.h(paramString3, "url");
    p.h(paramString4, "fileFormat");
    com.tencent.mm.plugin.finder.model.z localz = new com.tencent.mm.plugin.finder.model.z();
    localz.field_mediaId = paramString1;
    localz.field_originMediaId = paramString2;
    localz.field_url = paramString3;
    localz.field_reqFormat = paramInt1;
    localz.field_cacheSize = paramLong1;
    localz.field_totalSize = paramLong2;
    localz.field_fileFormat = paramString4;
    localz.field_state = paramInt2;
    localz.field_duration = paramInt3;
    localz.field_urlToken = paramString5;
    localz.field_decodeKey = paramString6;
    boolean bool = d(localz);
    AppMethodBeat.o(224305);
    return bool;
  }
  
  public static boolean aTi()
  {
    boolean bool = true;
    AppMethodBeat.i(204462);
    int i = rOl.db.delete(rOl.getTableName(), "rowid >= ?", new String[] { "0" });
    ae.i("Finder.MediaCacheLogic", "[deleteAll] ret=".concat(String.valueOf(i)));
    synchronized (lock)
    {
      sLs.clear();
      if (i >= 0)
      {
        AppMethodBeat.o(204462);
        return bool;
      }
      bool = false;
    }
  }
  
  public static List<com.tencent.mm.plugin.finder.model.z> ajB(String paramString)
  {
    AppMethodBeat.i(204460);
    p.h(paramString, "originalMediaId");
    long l = System.currentTimeMillis();
    Object localObject1 = rOl;
    p.h(paramString, "originMediaId");
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = "select *, rowid from FinderMediaCacheInfoV2  where originMediaId = '" + paramString + "' ";
    localObject1 = ((com.tencent.mm.plugin.finder.storage.q)localObject1).db.rawQuery((String)localObject2, null);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new com.tencent.mm.plugin.finder.model.z();
        ((com.tencent.mm.plugin.finder.model.z)localObject2).convertFrom((Cursor)localObject1);
        localLinkedList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
    }
    ae.i("Finder.MediaCacheLogic", "[queryByOriginalMediaId] cost=" + (System.currentTimeMillis() - l) + "ms originalMediaId=" + paramString + " size=" + localLinkedList.size());
    paramString = (List)localLinkedList;
    AppMethodBeat.o(204460);
    return paramString;
  }
  
  public static void ajz(String paramString)
  {
    AppMethodBeat.i(204456);
    p.h(paramString, "mediaId");
    com.tencent.mm.ac.c.c("FinderMediaCacheUpdateThread", (d.g.a.a)new b(paramString));
    AppMethodBeat.o(204456);
  }
  
  public static m b(bvz parambvz)
  {
    AppMethodBeat.i(204464);
    p.h(parambvz, "media");
    Object localObject2 = parambvz.mediaId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = ((Iterable)j.a((Iterable)ajB((String)localObject1), (Comparator)new a())).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!((com.tencent.mm.plugin.finder.model.z)localObject1).cEK());
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.finder.model.z)localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.preload.model.a.sut;
      parambvz = new m(parambvz, a.a.aiD(((com.tencent.mm.plugin.finder.model.z)localObject1).field_fileFormat), ((com.tencent.mm.plugin.finder.model.z)localObject1).field_reqFormat, null, 8);
      AppMethodBeat.o(204464);
      return parambvz;
      localObject1 = null;
    }
    parambvz = ((a.b)j.jl(((PluginFinder)g.ad(PluginFinder.class)).getMediaPreloadModel().a(parambvz, false))).suv;
    AppMethodBeat.o(204464);
    return parambvz;
  }
  
  public static com.tencent.mm.plugin.finder.model.z bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204458);
    p.h(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    com.tencent.mm.plugin.finder.model.z localz;
    for (int i = 1; i != 0; i = 0)
    {
      localz = new com.tencent.mm.plugin.finder.model.z();
      localz.field_mediaId = paramString;
      AppMethodBeat.o(204458);
      return localz;
    }
    synchronized (lock)
    {
      localz = (com.tencent.mm.plugin.finder.model.z)sLs.get(paramString);
      if (localz == null) {
        localz = rOl.ajq(paramString);
      }
    }
    for (;;)
    {
      synchronized (lock)
      {
        ((Map)sLs).put(paramString, localz);
        d.z localz1 = d.z.Nhr;
        p.g(localz, "synchronized(lock) { mem…        dbCache\n        }");
        if (paramBoolean)
        {
          if (((CharSequence)localz.getFilePath()).length() <= 0) {
            break label257;
          }
          i = 1;
          if ((i != 0) && (!o.fB(localz.getFilePath())))
          {
            localz.reset();
            localz.field_state = -2;
            d(localz);
            ae.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " not found file. state=" + localz.field_state + " filePath=" + localz.getFilePath());
          }
        }
        AppMethodBeat.o(204458);
        return localz;
        paramString = finally;
        AppMethodBeat.o(204458);
        throw paramString;
      }
      label257:
      i = 0;
    }
  }
  
  public static boolean d(com.tencent.mm.plugin.finder.model.z paramz)
  {
    AppMethodBeat.i(204453);
    p.h(paramz, "cache");
    paramz.field_updateTime = ch.aDc();
    ??? = rOl;
    Object localObject2 = paramz.field_mediaId;
    p.g(localObject2, "cache.field_mediaId");
    p.h(localObject2, "mediaId");
    localObject2 = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + (String)localObject2 + "' ";
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
        bool2 = rOl.c(paramz);
      }
      synchronized (lock)
      {
        localObject2 = (Map)sLs;
        String str1 = paramz.field_mediaId;
        p.g(str1, "cache.field_mediaId");
        com.tencent.mm.plugin.finder.storage.q localq = rOl;
        String str2 = paramz.field_mediaId;
        p.g(str2, "cache.field_mediaId");
        ((Map)localObject2).put(str1, localq.ajq(str2));
        localObject2 = d.z.Nhr;
        ae.i("Finder.MediaCacheLogic", "replaced[" + bool2 + "] isExist=" + bool1 + ' ' + paramz);
        AppMethodBeat.o(204453);
        return bool2;
        bool1 = false;
        continue;
        bool2 = rOl.b(paramz);
      }
    }
  }
  
  public static boolean dy(String paramString, int paramInt)
  {
    AppMethodBeat.i(204457);
    p.h(paramString, "mediaId");
    com.tencent.mm.plugin.finder.storage.q localq = rOl;
    com.tencent.mm.plugin.finder.model.z localz = bi(paramString, false);
    Object localObject;
    if (!localz.field_moovReady)
    {
      localObject = MediaPreloadCore.stL;
      if (MediaPreloadCore.a.a(localz).stM) {
        localz.field_moovReady = true;
      }
      ae.i("Finder.MediaCacheLogic", "update moov ready " + localz.field_mediaId + " moovReady:" + localz.field_moovReady + " audio:" + localz.field_audioBitrate + " video:" + localz.field_videoBitrate + " frameRate:" + localz.field_frameRate);
    }
    localz.field_cacheSize = 0L;
    localz.field_totalSize = 0L;
    localz.field_state = paramInt;
    if (paramInt >= 2)
    {
      localObject = (CharSequence)localz.field_fileFormat;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label327;
      }
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)localz.field_originMediaId;
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
        localObject = localz.field_originMediaId;
        p.g(localObject, "this.field_originMediaId");
        String str = localz.field_fileFormat;
        p.g(str, "this.field_fileFormat");
        gv((String)localObject, str);
      }
      if (ae.getLogLevel() <= 1) {
        ae.d("Finder.MediaCacheLogic", "[updateProgress] mediaId=" + paramString + " cacheSize=0 totalSize=0 state=" + paramInt + " moovReady=" + localz.field_moovReady);
      }
      boolean bool = localq.c(localz);
      AppMethodBeat.o(204457);
      return bool;
      i = 0;
      break;
    }
  }
  
  public static com.tencent.mm.plugin.finder.model.z gu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204455);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "fileFormat");
    paramString1 = bi(paramString1, false);
    paramString1.field_moovReady = true;
    if ((p.i(paramString1.field_fileFormat, paramString2) ^ true)) {
      paramString1.field_fileFormat = paramString2;
    }
    AppMethodBeat.o(204455);
    return paramString1;
  }
  
  private static void gv(String paramString1, String arg1)
  {
    AppMethodBeat.i(204463);
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.w("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId is Empty.");
      AppMethodBeat.o(204463);
      return;
    }
    Object localObject2 = (Iterable)ajB(paramString1);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label156:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      Object localObject4 = (com.tencent.mm.plugin.finder.model.z)localObject3;
      if (p.i(((com.tencent.mm.plugin.finder.model.z)localObject4).field_originMediaId, paramString1))
      {
        localObject4 = ((com.tencent.mm.plugin.finder.model.z)localObject4).field_fileFormat;
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
        localObject2 = (com.tencent.mm.plugin.finder.model.z)((Iterator)localObject1).next();
        if (!rOl.delete(((com.tencent.mm.plugin.finder.model.z)localObject2).systemRowid)) {}
      }
      else
      {
        synchronized (lock)
        {
          sLs.remove(((com.tencent.mm.plugin.finder.model.z)localObject2).field_mediaId);
          ae.i("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId=" + paramString1 + " fileFormat=" + ((com.tencent.mm.plugin.finder.model.z)localObject2).field_fileFormat + " systemRowid" + ((com.tencent.mm.plugin.finder.model.z)localObject2).systemRowid);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(204451);
      int i = d.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.model.z)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.finder.model.z)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(204451);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<d.z>
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