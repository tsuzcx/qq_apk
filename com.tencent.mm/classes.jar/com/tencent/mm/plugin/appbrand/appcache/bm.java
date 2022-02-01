package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.n.n;
import d.z;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "canAccessFile", "reqURL", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "mergeNewComingPkgList", "_pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wechat-full-sdk_release"})
public final class bm
  implements q
{
  public static final a jJo;
  public volatile boolean closed;
  private final String jJi;
  private final WxaPkgWrappingInfo jJj;
  private ArrayMap<String, ModulePkgInfo> jJk;
  private final ConcurrentHashMap<String, WxaPkg> jJl;
  private final ConcurrentHashMap<String, q.a> jJm;
  private boolean jJn;
  private final ReentrantReadWriteLock lock;
  
  static
  {
    AppMethodBeat.i(183032);
    jJo = new a((byte)0);
    AppMethodBeat.o(183032);
  }
  
  public bm(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183031);
    this.jJi = paramAppBrandRuntime.getAppId();
    paramAppBrandRuntime = paramAppBrandRuntime.c(AppBrandSysConfigLU.class, false);
    if (paramAppBrandRuntime == null) {
      p.gfZ();
    }
    paramAppBrandRuntime = ((AppBrandSysConfigLU)paramAppBrandRuntime).jYh;
    if (paramAppBrandRuntime == null) {
      p.gfZ();
    }
    this.jJj = paramAppBrandRuntime;
    this.jJl = new ConcurrentHashMap();
    this.jJm = new ConcurrentHashMap(100);
    this.lock = new ReentrantReadWriteLock();
    AppMethodBeat.o(183031);
  }
  
  public static final bm P(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183035);
    paramAppBrandRuntime = a.P(paramAppBrandRuntime);
    AppMethodBeat.o(183035);
    return paramAppBrandRuntime;
  }
  
  private static q.a a(WxaPkg.Info paramInfo, WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(183030);
    q.a locala = new q.a();
    locala.jFM = paramWxaPkg;
    locala.jFN = paramWxaPkg.bau();
    locala.fileName = paramInfo.fileName;
    locala.jFO = paramInfo.jFO;
    locala.jFP = paramInfo.jFP;
    AppMethodBeat.o(183030);
    return locala;
  }
  
  private final WxaPkg h(String paramString, a<WxaPkg> parama)
  {
    AppMethodBeat.i(192341);
    WxaPkg localWxaPkg2 = (WxaPkg)this.jJl.get(paramString);
    WxaPkg localWxaPkg1 = localWxaPkg2;
    if (localWxaPkg2 == null)
    {
      parama = (WxaPkg)parama.invoke();
      if (parama != null)
      {
        parama.aZr();
        ad.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.jJi + ", name:" + paramString + ", pkgInnerVersion:" + parama.version());
        ((Map)this.jJl).put(paramString, parama);
        AppMethodBeat.o(192341);
        return parama;
      }
      localWxaPkg1 = null;
    }
    AppMethodBeat.o(192341);
    return localWxaPkg1;
  }
  
  private final <T> T r(a<? extends T> parama)
  {
    AppMethodBeat.i(183019);
    ReentrantReadWriteLock.ReadLock localReadLock = this.lock.readLock();
    localReadLock.lock();
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      localReadLock.unlock();
      AppMethodBeat.o(183019);
    }
  }
  
  public final WxaPkg Lj(final String paramString)
  {
    AppMethodBeat.i(183022);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183022);
      return null;
    }
    paramString = (WxaPkg)r((a)new c(this, paramString));
    AppMethodBeat.o(183022);
    return paramString;
  }
  
  public final InputStream Lk(String paramString)
  {
    AppMethodBeat.i(183025);
    paramString = Ll(paramString);
    if (paramString != null)
    {
      paramString = paramString.jFM.Lh(paramString.fileName);
      AppMethodBeat.o(183025);
      return paramString;
    }
    AppMethodBeat.o(183025);
    return null;
  }
  
  public final q.a Ll(final String paramString)
  {
    AppMethodBeat.i(183026);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183026);
      return null;
    }
    paramString = (q.a)r((a)new k(this, paramString));
    AppMethodBeat.o(183026);
    return paramString;
  }
  
  public final boolean Lm(String paramString)
  {
    AppMethodBeat.i(183023);
    if (Ll(paramString) != null)
    {
      AppMethodBeat.o(183023);
      return true;
    }
    AppMethodBeat.o(183023);
    return false;
  }
  
  public final List<WxaPkg.Info> aZK()
  {
    AppMethodBeat.i(183024);
    List localList = (List)r((a)new d(this));
    AppMethodBeat.o(183024);
    return localList;
  }
  
  public final void aZL()
  {
    AppMethodBeat.i(183021);
    if (this.jJn)
    {
      AppMethodBeat.o(183021);
      return;
    }
    q((a)new l(this));
    this.jJn = true;
    AppMethodBeat.o(183021);
  }
  
  public final List<ModulePkgInfo> aZM()
  {
    AppMethodBeat.i(183028);
    Object localObject = this.jJj.jIX;
    p.g(localObject, "pkgWrappingInfo.moduleList");
    localObject = (List)localObject;
    AppMethodBeat.o(183028);
    return localObject;
  }
  
  public final List<String> aZN()
  {
    AppMethodBeat.i(192342);
    List localList = (List)r((a)new i(this));
    AppMethodBeat.o(192342);
    return localList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(183027);
    q((a)new b(this));
    this.closed = true;
    AppMethodBeat.o(183027);
  }
  
  public final <T> T q(a<? extends T> parama)
  {
    m = 0;
    int k = 0;
    AppMethodBeat.i(183018);
    Object localObject = this.lock;
    ReentrantReadWriteLock.ReadLock localReadLock = ((ReentrantReadWriteLock)localObject).readLock();
    if (((ReentrantReadWriteLock)localObject).getWriteHoldCount() == 0) {}
    for (int i = ((ReentrantReadWriteLock)localObject).getReadHoldCount();; i = 0)
    {
      j = 0;
      while (j < i)
      {
        localReadLock.unlock();
        j += 1;
      }
    }
    localObject = ((ReentrantReadWriteLock)localObject).writeLock();
    ((ReentrantReadWriteLock.WriteLock)localObject).lock();
    for (;;)
    {
      try
      {
        parama = parama.invoke();
        j = k;
        if (j < i)
        {
          localReadLock.lock();
          j += 1;
          continue;
        }
        ((ReentrantReadWriteLock.WriteLock)localObject).unlock();
        AppMethodBeat.o(183018);
        return parama;
      }
      finally
      {
        j = m;
      }
      if (j >= i) {
        continue;
      }
      localReadLock.lock();
      j += 1;
    }
    ((ReentrantReadWriteLock.WriteLock)localObject).unlock();
    AppMethodBeat.o(183018);
    throw parama;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static bm P(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(183003);
      p.h(paramAppBrandRuntime, "$this$getMergeDirReader");
      Object localObject = bf.O(paramAppBrandRuntime);
      paramAppBrandRuntime = (AppBrandRuntime)localObject;
      if (!(localObject instanceof bf)) {
        paramAppBrandRuntime = null;
      }
      paramAppBrandRuntime = (bf)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null) {}
      for (paramAppBrandRuntime = paramAppBrandRuntime.baM();; paramAppBrandRuntime = null)
      {
        localObject = paramAppBrandRuntime;
        if (!(paramAppBrandRuntime instanceof bm)) {
          localObject = null;
        }
        paramAppBrandRuntime = (bm)localObject;
        AppMethodBeat.o(183003);
        return paramAppBrandRuntime;
      }
    }
    
    public static String a(String paramString, WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      AppMethodBeat.i(183005);
      p.h(paramString, "hostModule");
      p.h(paramWxaPluginPkgInfo, "plugin");
      if (p.i(paramString, "__APP__"))
      {
        paramString = b(paramWxaPluginPkgInfo);
        AppMethodBeat.o(183005);
        return paramString;
      }
      if (n.a((CharSequence)paramString, '/'))
      {
        paramString = paramString + b(paramWxaPluginPkgInfo);
        AppMethodBeat.o(183005);
        return paramString;
      }
      paramString = paramString + '/' + b(paramWxaPluginPkgInfo);
      AppMethodBeat.o(183005);
      return paramString;
    }
    
    static String b(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      AppMethodBeat.i(183004);
      CharSequence localCharSequence = (CharSequence)paramWxaPluginPkgInfo.prefixPath;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramWxaPluginPkgInfo = paramWxaPluginPkgInfo.prefixPath;
        p.g(paramWxaPluginPkgInfo, "this.prefixPath");
        AppMethodBeat.o(183004);
        return paramWxaPluginPkgInfo;
      }
      paramWxaPluginPkgInfo = "__extended__/" + paramWxaPluginPkgInfo.provider;
      AppMethodBeat.o(183004);
      return paramWxaPluginPkgInfo;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<z>
  {
    b(bm parambm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class c
    extends d.g.b.q
    implements a<WxaPkg>
  {
    c(bm parambm, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "kotlin.jvm.PlatformType", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements a<List<WxaPkg.Info>>
  {
    d(bm parambm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class e
    extends d.g.b.q
    implements b<q.a, z>
  {
    e(bm parambm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class f
    extends d.g.b.q
    implements a<WxaPkg>
  {
    f(ModulePkgInfo paramModulePkgInfo)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class g
    extends d.g.b.q
    implements b<q.a, z>
  {
    g(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class h
    extends d.g.b.q
    implements a<WxaPkg>
  {
    h(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements a<LinkedList<String>>
  {
    i(bm parambm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class j
    extends d.g.b.q
    implements a<z>
  {
    public j(bm parambm, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class k
    extends d.g.b.q
    implements a<q.a>
  {
    k(bm parambm, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements a<z>
  {
    l(bm parambm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bm
 * JD-Core Version:    0.7.0.1
 */