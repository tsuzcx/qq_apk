package com.tencent.mm.plugin.appbrand.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager;", "", "()V", "CACHE_FILE_SUFFIX", "", "CACHE_SIZE_LIMIT", "", "MARK_FILE_SUFFIX", "TAG", "TEMP_MARK_FILE_SUFFIX", "curProcessCacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCurProcessCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "curProcessCacheDir$delegate", "Lkotlin/Lazy;", "clearMark", "", "downloadId", "doMark", "cacheInfo", "Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager$CacheInfo;", "markFile", "getCacheInfo", "Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager$CacheInfoHolder;", "srcUrl", "onCacheError", "cacheInfoHolder", "onCacheFinish", "onCacheStart", "downloadingTasksResolver", "Lkotlin/Function0;", "", "onCacheTouch", "CacheInfo", "CacheInfoHolder", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g utx;
  private static final j uty;
  
  static
  {
    AppMethodBeat.i(317910);
    utx = new g();
    uty = k.cm((a)g.c.utC);
    AppMethodBeat.o(317910);
  }
  
  private static void H(u paramu)
  {
    AppMethodBeat.i(317882);
    y.f(ah.v(paramu.jKT()), new byte[] { 0 }, 1);
    AppMethodBeat.o(317882);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(317878);
    u localu2;
    if (parama.utA)
    {
      localu2 = new u(cOb(), s.X(parama.utz, ".mark"));
      localu1 = localu2;
      if (!localu2.jKS())
      {
        Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", "doMark, markFile is not exists");
        new u(cOb(), s.X(parama.utz, ".temp.mark")).am(localu2);
      }
    }
    for (u localu1 = localu2;; localu1 = new u(cOb(), s.X(parama.utz, ".temp.mark")))
    {
      Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", s.X("doMark, needDoMarkFile(virtual): ", localu1));
      H(localu1);
      AppMethodBeat.o(317878);
      return;
    }
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(317873);
    s.u(paramb, "cacheInfoHolder");
    paramb = paramb.utB;
    Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", s.X("onCacheTouch, cacheInfo: ", paramb));
    a(paramb);
    AppMethodBeat.o(317873);
  }
  
  public static void a(b paramb, a<? extends List<String>> parama)
  {
    AppMethodBeat.i(317868);
    s.u(paramb, "cacheInfoHolder");
    s.u(parama, "downloadingTasksResolver");
    Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", s.X("onCacheStart, cacheInfo: ", paramb.utB));
    h.ahAA.g(new g..ExternalSyntheticLambda0(parama), "MicroMsg.AppBrand.ThumbCdnCacheManager");
    AppMethodBeat.o(317868);
  }
  
  private static final void ay(a parama)
  {
    AppMethodBeat.i(317902);
    s.u(parama, "$downloadingTasksResolver");
    Object localObject1 = cOb().jKX();
    if (localObject1 == null)
    {
      Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", "onCacheStart, allFiles is null");
      AppMethodBeat.o(317902);
      return;
    }
    long l1 = 0L;
    Object localObject2 = (List)parama.invoke();
    Object localObject3 = (Collection)new ArrayList();
    int k = localObject1.length;
    int i = 0;
    long l2;
    if (i < k)
    {
      Object localObject4 = localObject1[i];
      l2 = localObject4.length();
      String str = localObject4.getName();
      s.s(str, "file.name");
      if (n.rs(str, ".mark"))
      {
        Iterator localIterator = ((Iterable)localObject2).iterator();
        while (localIterator.hasNext())
        {
          parama = localIterator.next();
          if (n.U(str, (String)parama, false)) {
            label154:
            if (parama != null) {
              break label193;
            }
          }
        }
      }
      label193:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject3).add(localObject4);
        }
        i += 1;
        l1 = l2 + l1;
        break;
        parama = null;
        break label154;
      }
    }
    parama = (List)localObject3;
    Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", s.X("onCacheStart, totalSize: ", Long.valueOf(l1)));
    if (l1 < 268435456L)
    {
      Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", "onCacheStart, not need trim");
      AppMethodBeat.o(317902);
      return;
    }
    if (((Collection)parama).isEmpty()) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", "onCacheStart, markFiles is empty");
      AppMethodBeat.o(317902);
      return;
    }
    parama = p.J((Collection)parama);
    p.a(parama, g..ExternalSyntheticLambda1.INSTANCE);
    localObject1 = parama.iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (u)((Iterator)localObject1).next();
        localObject3 = ah.v(((u)localObject2).jKT());
        s.s(localObject3, "markFile.absolutePath");
        if (!n.rs((String)localObject3, ".temp.mark")) {
          break label528;
        }
        parama = ((String)localObject3).substring(0, ((String)localObject3).length() - 10);
        s.s(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      for (parama = s.X(parama, ".res");; parama = s.X(parama, ".res"))
      {
        Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", "onCacheStart, markFilePath(virtual): " + (String)localObject3 + ", cacheFilePath(virtual): " + parama);
        parama = new u(parama);
        l2 = ((u)localObject2).length() + parama.length();
        boolean bool1 = ((u)localObject2).diJ();
        boolean bool2 = parama.diJ();
        l1 -= l2;
        Log.i("MicroMsg.AppBrand.ThumbCdnCacheManager", "onCacheStart, trimSize: " + l2 + ", totalSize: " + l1 + ", markDeleted: " + bool1 + ", cacheDeleted: " + bool2);
        if (l1 >= 268435456L) {
          break;
        }
        AppMethodBeat.o(317902);
        return;
        label528:
        parama = ((String)localObject3).substring(0, ((String)localObject3).length() - 5);
        s.s(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
  }
  
  static u cOb()
  {
    AppMethodBeat.i(317858);
    u localu = (u)uty.getValue();
    AppMethodBeat.o(317858);
    return localu;
  }
  
  private static final int d(u paramu1, u paramu2)
  {
    AppMethodBeat.i(317885);
    int i = (int)(paramu1.lastModified() - paramu2.lastModified());
    AppMethodBeat.o(317885);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager$CacheInfo;", "", "srcUrl", "", "downloadId", "cachePath", "isCacheFinished", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCachePath", "()Ljava/lang/String;", "getDownloadId", "()Z", "getSrcUrl", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final String cachePath;
    private final String hsg;
    final boolean utA;
    final String utz;
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      AppMethodBeat.i(317938);
      this.hsg = paramString1;
      this.utz = paramString2;
      this.cachePath = paramString3;
      this.utA = paramBoolean;
      AppMethodBeat.o(317938);
    }
    
    private static a d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      AppMethodBeat.i(317948);
      s.u(paramString1, "srcUrl");
      s.u(paramString2, "downloadId");
      s.u(paramString3, "cachePath");
      paramString1 = new a(paramString1, paramString2, paramString3, paramBoolean);
      AppMethodBeat.o(317948);
      return paramString1;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(317999);
      if (this == paramObject)
      {
        AppMethodBeat.o(317999);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(317999);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.hsg, paramObject.hsg))
      {
        AppMethodBeat.o(317999);
        return false;
      }
      if (!s.p(this.utz, paramObject.utz))
      {
        AppMethodBeat.o(317999);
        return false;
      }
      if (!s.p(this.cachePath, paramObject.cachePath))
      {
        AppMethodBeat.o(317999);
        return false;
      }
      if (this.utA != paramObject.utA)
      {
        AppMethodBeat.o(317999);
        return false;
      }
      AppMethodBeat.o(317999);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(317978);
      String str = "CacheInfo(srcUrl=" + this.hsg + ", downloadId=" + this.utz + ", cachePath=" + this.cachePath + ", isCacheFinished=" + this.utA + ')';
      AppMethodBeat.o(317978);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager$CacheInfoHolder;", "", "_cacheInfo", "Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager$CacheInfo;", "(Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager$CacheInfo;)V", "get_cacheInfo$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbCdnCacheManager$CacheInfo;", "set_cacheInfo$plugin_appbrand_integration_release", "cacheInfo", "getCacheInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    g.a utB;
    
    public b(g.a parama)
    {
      AppMethodBeat.i(317919);
      this.utB = parama;
      AppMethodBeat.o(317919);
    }
    
    public final void b(g.a parama)
    {
      AppMethodBeat.i(317930);
      s.u(parama, "<set-?>");
      this.utB = parama;
      AppMethodBeat.o(317930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.g
 * JD-Core Version:    0.7.0.1
 */