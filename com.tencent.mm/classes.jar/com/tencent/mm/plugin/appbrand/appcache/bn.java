package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "canAccessFile", "reqURL", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "mergeNewComingPkgList", "_pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wechat-full-sdk_release"})
public final class bn
  implements q
{
  public static final a jMp;
  public volatile boolean closed;
  private final String jMj;
  private final WxaPkgWrappingInfo jMk;
  private ArrayMap<String, ModulePkgInfo> jMl;
  private final ConcurrentHashMap<String, WxaPkg> jMm;
  private final ConcurrentHashMap<String, q.a> jMn;
  private boolean jMo;
  private final ReentrantReadWriteLock lock;
  
  static
  {
    AppMethodBeat.i(183032);
    jMp = new a((byte)0);
    AppMethodBeat.o(183032);
  }
  
  public bn(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183031);
    this.jMj = paramAppBrandRuntime.getAppId();
    paramAppBrandRuntime = paramAppBrandRuntime.c(AppBrandSysConfigLU.class, false);
    if (paramAppBrandRuntime == null) {
      p.gkB();
    }
    paramAppBrandRuntime = ((AppBrandSysConfigLU)paramAppBrandRuntime).kbw;
    if (paramAppBrandRuntime == null) {
      p.gkB();
    }
    this.jMk = paramAppBrandRuntime;
    this.jMm = new ConcurrentHashMap();
    this.jMn = new ConcurrentHashMap(100);
    this.lock = new ReentrantReadWriteLock();
    AppMethodBeat.o(183031);
  }
  
  public static final bn N(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183035);
    paramAppBrandRuntime = a.N(paramAppBrandRuntime);
    AppMethodBeat.o(183035);
    return paramAppBrandRuntime;
  }
  
  private static q.a a(WxaPkg.Info paramInfo, WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(183030);
    q.a locala = new q.a();
    locala.jIL = paramWxaPkg;
    locala.jIM = paramWxaPkg.baT();
    locala.fileName = paramInfo.fileName;
    locala.jIN = paramInfo.jIN;
    locala.jIO = paramInfo.jIO;
    AppMethodBeat.o(183030);
    return locala;
  }
  
  private final WxaPkg h(String paramString, a<WxaPkg> parama)
  {
    AppMethodBeat.i(220942);
    WxaPkg localWxaPkg2 = (WxaPkg)this.jMm.get(paramString);
    WxaPkg localWxaPkg1 = localWxaPkg2;
    if (localWxaPkg2 == null)
    {
      parama = (WxaPkg)parama.invoke();
      if (parama != null)
      {
        parama.aZO();
        ae.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.jMj + ", name:" + paramString + ", pkgInnerVersion:" + parama.version());
        ((Map)this.jMm).put(paramString, parama);
        AppMethodBeat.o(220942);
        return parama;
      }
      localWxaPkg1 = null;
    }
    AppMethodBeat.o(220942);
    return localWxaPkg1;
  }
  
  private final <T> T s(a<? extends T> parama)
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
  
  public final WxaPkg LK(final String paramString)
  {
    AppMethodBeat.i(183022);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183022);
      return null;
    }
    paramString = (WxaPkg)s((a)new c(this, paramString));
    AppMethodBeat.o(183022);
    return paramString;
  }
  
  public final InputStream LL(String paramString)
  {
    AppMethodBeat.i(183025);
    paramString = LM(paramString);
    if (paramString != null)
    {
      paramString = paramString.jIL.LI(paramString.fileName);
      AppMethodBeat.o(183025);
      return paramString;
    }
    AppMethodBeat.o(183025);
    return null;
  }
  
  public final q.a LM(final String paramString)
  {
    AppMethodBeat.i(183026);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183026);
      return null;
    }
    paramString = (q.a)s((a)new k(this, paramString));
    AppMethodBeat.o(183026);
    return paramString;
  }
  
  public final boolean LN(String paramString)
  {
    AppMethodBeat.i(183023);
    if (LM(paramString) != null)
    {
      AppMethodBeat.o(183023);
      return true;
    }
    AppMethodBeat.o(183023);
    return false;
  }
  
  public final List<WxaPkg.Info> bah()
  {
    AppMethodBeat.i(183024);
    List localList = (List)s((a)new d(this));
    AppMethodBeat.o(183024);
    return localList;
  }
  
  public final void bai()
  {
    AppMethodBeat.i(183021);
    if (this.jMo)
    {
      AppMethodBeat.o(183021);
      return;
    }
    r((a)new l(this));
    this.jMo = true;
    AppMethodBeat.o(183021);
  }
  
  public final List<ModulePkgInfo> baj()
  {
    AppMethodBeat.i(183028);
    Object localObject = this.jMk.jLY;
    p.g(localObject, "pkgWrappingInfo.moduleList");
    localObject = (List)localObject;
    AppMethodBeat.o(183028);
    return localObject;
  }
  
  public final List<String> bak()
  {
    AppMethodBeat.i(220943);
    List localList = (List)s((a)new i(this));
    AppMethodBeat.o(220943);
    return localList;
  }
  
  public final void close()
  {
    AppMethodBeat.i(183027);
    r((a)new b(this));
    this.closed = true;
    AppMethodBeat.o(183027);
  }
  
  public final <T> T r(a<? extends T> parama)
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static bn N(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(183003);
      p.h(paramAppBrandRuntime, "$this$getMergeDirReader");
      Object localObject = bg.M(paramAppBrandRuntime);
      paramAppBrandRuntime = (AppBrandRuntime)localObject;
      if (!(localObject instanceof bg)) {
        paramAppBrandRuntime = null;
      }
      paramAppBrandRuntime = (bg)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null) {}
      for (paramAppBrandRuntime = paramAppBrandRuntime.bbl();; paramAppBrandRuntime = null)
      {
        localObject = paramAppBrandRuntime;
        if (!(paramAppBrandRuntime instanceof bn)) {
          localObject = null;
        }
        paramAppBrandRuntime = (bn)localObject;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<z>
  {
    b(bn parambn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class c
    extends d.g.b.q
    implements a<WxaPkg>
  {
    c(bn parambn, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "kotlin.jvm.PlatformType", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements a<List<WxaPkg.Info>>
  {
    d(bn parambn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class e
    extends d.g.b.q
    implements b<q.a, z>
  {
    e(bn parambn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class f
    extends d.g.b.q
    implements a<WxaPkg>
  {
    f(ModulePkgInfo paramModulePkgInfo)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class g
    extends d.g.b.q
    implements b<q.a, z>
  {
    g(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class h
    extends d.g.b.q
    implements a<WxaPkg>
  {
    h(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements a<LinkedList<String>>
  {
    i(bn parambn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class j
    extends d.g.b.q
    implements a<z>
  {
    public j(bn parambn, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class k
    extends d.g.b.q
    implements a<q.a>
  {
    k(bn parambn, String paramString)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements a<z>
  {
    l(bn parambn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bn
 * JD-Core Version:    0.7.0.1
 */