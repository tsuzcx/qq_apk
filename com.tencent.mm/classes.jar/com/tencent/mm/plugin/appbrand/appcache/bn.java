package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "canAccessFile", "reqURL", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "mergeNewComingPkgList", "_pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wechat-full-sdk_release"})
public final class bn
  implements q
{
  public static final a kOt;
  public volatile boolean closed;
  private final String kOn;
  private final WxaPkgWrappingInfo kOo;
  private ArrayMap<String, ModulePkgInfo> kOp;
  private final ConcurrentHashMap<String, WxaPkg> kOq;
  private final ConcurrentHashMap<String, q.a> kOr;
  private boolean kOs;
  private final ReentrantReadWriteLock lock;
  
  static
  {
    AppMethodBeat.i(183032);
    kOt = new a((byte)0);
    AppMethodBeat.o(183032);
  }
  
  public bn(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183031);
    this.kOn = paramAppBrandRuntime.getAppId();
    Object localObject = paramAppBrandRuntime.d(AppBrandSysConfigLU.class, false);
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((AppBrandSysConfigLU)localObject).leE;
    if (localObject == null) {
      p.hyc();
    }
    this.kOo = ((WxaPkgWrappingInfo)localObject);
    this.kOq = new ConcurrentHashMap();
    this.kOr = new ConcurrentHashMap(100);
    Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "<init> appId:" + paramAppBrandRuntime.getAppId() + ", pkg:" + this.kOo);
    this.lock = new ReentrantReadWriteLock();
    AppMethodBeat.o(183031);
  }
  
  public static final bn O(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183035);
    paramAppBrandRuntime = a.O(paramAppBrandRuntime);
    AppMethodBeat.o(183035);
    return paramAppBrandRuntime;
  }
  
  private static q.a a(WxaPkg.Info paramInfo, WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(183030);
    q.a locala = new q.a();
    locala.kKH = paramWxaPkg;
    locala.kKI = paramWxaPkg.bwh();
    locala.fileName = paramInfo.fileName;
    locala.kKJ = paramInfo.kKJ;
    locala.kKK = paramInfo.kKK;
    AppMethodBeat.o(183030);
    return locala;
  }
  
  private final WxaPkg h(String paramString, a<WxaPkg> parama)
  {
    AppMethodBeat.i(230052);
    WxaPkg localWxaPkg2 = (WxaPkg)this.kOq.get(paramString);
    WxaPkg localWxaPkg1 = localWxaPkg2;
    if (localWxaPkg2 == null)
    {
      parama = (WxaPkg)parama.invoke();
      if (parama != null)
      {
        parama.bvf();
        Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.kOn + ", name:" + paramString + ", pkgInnerVersion:" + parama.version());
        ((Map)this.kOq).put(paramString, parama);
        AppMethodBeat.o(230052);
        return parama;
      }
      localWxaPkg1 = null;
    }
    AppMethodBeat.o(230052);
    return localWxaPkg1;
  }
  
  private final <T> T u(a<? extends T> parama)
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
  
  public final WxaPkg UT(final String paramString)
  {
    AppMethodBeat.i(183022);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183022);
      return null;
    }
    paramString = (WxaPkg)u((a)new c(this, paramString));
    AppMethodBeat.o(183022);
    return paramString;
  }
  
  public final InputStream UU(String paramString)
  {
    AppMethodBeat.i(183025);
    paramString = UV(paramString);
    if (paramString != null)
    {
      paramString = paramString.kKH.UR(paramString.fileName);
      AppMethodBeat.o(183025);
      return paramString;
    }
    AppMethodBeat.o(183025);
    return null;
  }
  
  public final q.a UV(final String paramString)
  {
    AppMethodBeat.i(183026);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183026);
      return null;
    }
    paramString = (q.a)u((a)new j(this, paramString));
    AppMethodBeat.o(183026);
    return paramString;
  }
  
  public final boolean UW(String paramString)
  {
    AppMethodBeat.i(183023);
    if (UV(paramString) != null)
    {
      AppMethodBeat.o(183023);
      return true;
    }
    AppMethodBeat.o(183023);
    return false;
  }
  
  public final List<String> bvA()
  {
    AppMethodBeat.i(230053);
    List localList = (List)u((a)new h(this));
    AppMethodBeat.o(230053);
    return localList;
  }
  
  public final void bvy()
  {
    AppMethodBeat.i(183021);
    if (this.kOs)
    {
      AppMethodBeat.o(183021);
      return;
    }
    t((a)new k(this));
    this.kOs = true;
    AppMethodBeat.o(183021);
  }
  
  public final List<ModulePkgInfo> bvz()
  {
    AppMethodBeat.i(183028);
    Object localObject = this.kOo.kNZ;
    p.g(localObject, "pkgWrappingInfo.moduleList");
    localObject = (List)localObject;
    AppMethodBeat.o(183028);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(183027);
    t((a)new b(this));
    this.closed = true;
    AppMethodBeat.o(183027);
  }
  
  public final <T> T t(a<? extends T> parama)
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static bn O(AppBrandRuntime paramAppBrandRuntime)
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
      for (paramAppBrandRuntime = paramAppBrandRuntime.bwy();; paramAppBrandRuntime = null)
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
      if (p.j(paramString, "__APP__"))
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<x>
  {
    b(bn parambn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<WxaPkg>
  {
    c(bn parambn, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<q.a, x>
  {
    d(bn parambn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements a<WxaPkg>
  {
    e(ModulePkgInfo paramModulePkgInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements b<q.a, x>
  {
    f(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements a<WxaPkg>
  {
    g(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements a<LinkedList<String>>
  {
    h(bn parambn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class i
    extends kotlin.g.b.q
    implements a<x>
  {
    public i(bn parambn, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements a<q.a>
  {
    j(bn parambn, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements a<x>
  {
    k(bn parambn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bn
 * JD-Core Version:    0.7.0.1
 */