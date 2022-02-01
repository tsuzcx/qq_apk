package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.n.n;
import d.y;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "canAccessFile", "reqURL", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "mergeNewComingPkgList", "_pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wechat-full-sdk_release"})
public final class bl
  implements q
{
  public static final a iPj;
  public volatile boolean closed;
  private final String iPd;
  private final WxaPkgWrappingInfo iPe;
  private ArrayMap<String, ModulePkgInfo> iPf;
  private final ConcurrentHashMap<String, WxaPkg> iPg;
  private final ConcurrentHashMap<String, q.a> iPh;
  private boolean iPi;
  private final ReentrantReadWriteLock lock;
  
  static
  {
    AppMethodBeat.i(183032);
    iPj = new a((byte)0);
    AppMethodBeat.o(183032);
  }
  
  public bl(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183031);
    this.iPd = paramAppBrandRuntime.getAppId();
    paramAppBrandRuntime = paramAppBrandRuntime.c(AppBrandSysConfigLU.class, false);
    if (paramAppBrandRuntime == null) {
      k.fvU();
    }
    paramAppBrandRuntime = ((AppBrandSysConfigLU)paramAppBrandRuntime).jdS;
    if (paramAppBrandRuntime == null) {
      k.fvU();
    }
    this.iPe = paramAppBrandRuntime;
    this.iPg = new ConcurrentHashMap();
    this.iPh = new ConcurrentHashMap(100);
    this.lock = new ReentrantReadWriteLock();
    AppMethodBeat.o(183031);
  }
  
  public static final bl V(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183035);
    paramAppBrandRuntime = a.V(paramAppBrandRuntime);
    AppMethodBeat.o(183035);
    return paramAppBrandRuntime;
  }
  
  private static q.a a(WxaPkg.Info paramInfo, WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(183030);
    q.a locala = new q.a();
    locala.iLP = paramWxaPkg;
    locala.iLQ = paramWxaPkg.aQf();
    locala.fileName = paramInfo.fileName;
    locala.iLR = paramInfo.iLR;
    locala.iLS = paramInfo.iLS;
    AppMethodBeat.o(183030);
    return locala;
  }
  
  private final WxaPkg d(String paramString, a<WxaPkg> parama)
  {
    AppMethodBeat.i(186855);
    WxaPkg localWxaPkg2 = (WxaPkg)this.iPg.get(paramString);
    WxaPkg localWxaPkg1 = localWxaPkg2;
    if (localWxaPkg2 == null)
    {
      parama = (WxaPkg)parama.invoke();
      if (parama != null)
      {
        parama.aPe();
        ad.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.iPd + ", name:" + paramString + ", pkgInnerVersion:" + parama.version());
        ((Map)this.iPg).put(paramString, parama);
        AppMethodBeat.o(186855);
        return parama;
      }
      localWxaPkg1 = null;
    }
    AppMethodBeat.o(186855);
    return localWxaPkg1;
  }
  
  private final <T> T m(a<? extends T> parama)
  {
    AppMethodBeat.i(183019);
    this.lock.readLock().lock();
    parama = parama.invoke();
    this.lock.readLock().unlock();
    AppMethodBeat.o(183019);
    return parama;
  }
  
  public final WxaPkg DO(final String paramString)
  {
    AppMethodBeat.i(183022);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183022);
      return null;
    }
    paramString = (WxaPkg)m((a)new c(this, paramString));
    AppMethodBeat.o(183022);
    return paramString;
  }
  
  public final InputStream DP(String paramString)
  {
    AppMethodBeat.i(183025);
    paramString = DQ(paramString);
    if (paramString != null)
    {
      paramString = paramString.iLP.DM(paramString.fileName);
      AppMethodBeat.o(183025);
      return paramString;
    }
    AppMethodBeat.o(183025);
    return null;
  }
  
  public final q.a DQ(final String paramString)
  {
    AppMethodBeat.i(183026);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183026);
      return null;
    }
    paramString = (q.a)m((a)new k(this, paramString));
    AppMethodBeat.o(183026);
    return paramString;
  }
  
  public final boolean DR(String paramString)
  {
    AppMethodBeat.i(183023);
    if (DQ(paramString) != null)
    {
      AppMethodBeat.o(183023);
      return true;
    }
    AppMethodBeat.o(183023);
    return false;
  }
  
  public final List<String> aPA()
  {
    AppMethodBeat.i(186856);
    List localList = (List)m((a)new i(this));
    AppMethodBeat.o(186856);
    return localList;
  }
  
  public final List<WxaPkg.Info> aPx()
  {
    AppMethodBeat.i(183024);
    List localList = (List)m((a)new d(this));
    AppMethodBeat.o(183024);
    return localList;
  }
  
  public final void aPy()
  {
    AppMethodBeat.i(183021);
    if (this.iPi)
    {
      AppMethodBeat.o(183021);
      return;
    }
    l((a)new l(this));
    this.iPi = true;
    AppMethodBeat.o(183021);
  }
  
  public final List<ModulePkgInfo> aPz()
  {
    AppMethodBeat.i(183028);
    Object localObject = this.iPe.iOT;
    k.g(localObject, "pkgWrappingInfo.moduleList");
    localObject = (List)localObject;
    AppMethodBeat.o(183028);
    return localObject;
  }
  
  public final void close()
  {
    AppMethodBeat.i(183027);
    l((a)new b(this));
    this.closed = true;
    AppMethodBeat.o(183027);
  }
  
  public final <T> T l(a<? extends T> parama)
  {
    AppMethodBeat.i(183018);
    this.lock.writeLock().lock();
    parama = parama.invoke();
    this.lock.writeLock().unlock();
    AppMethodBeat.o(183018);
    return parama;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static bl V(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(183003);
      k.h(paramAppBrandRuntime, "$this$getMergeDirReader");
      Object localObject = be.U(paramAppBrandRuntime);
      paramAppBrandRuntime = (AppBrandRuntime)localObject;
      if (!(localObject instanceof be)) {
        paramAppBrandRuntime = null;
      }
      paramAppBrandRuntime = (be)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null) {}
      for (paramAppBrandRuntime = paramAppBrandRuntime.aQw();; paramAppBrandRuntime = null)
      {
        localObject = paramAppBrandRuntime;
        if (!(paramAppBrandRuntime instanceof bl)) {
          localObject = null;
        }
        paramAppBrandRuntime = (bl)localObject;
        AppMethodBeat.o(183003);
        return paramAppBrandRuntime;
      }
    }
    
    public static String a(String paramString, WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      AppMethodBeat.i(183005);
      k.h(paramString, "hostModule");
      k.h(paramWxaPluginPkgInfo, "plugin");
      if (k.g(paramString, "__APP__"))
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
        k.g(paramWxaPluginPkgInfo, "this.prefixPath");
        AppMethodBeat.o(183004);
        return paramWxaPluginPkgInfo;
      }
      paramWxaPluginPkgInfo = "__extended__/" + paramWxaPluginPkgInfo.provider;
      AppMethodBeat.o(183004);
      return paramWxaPluginPkgInfo;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(bl parambl)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<WxaPkg>
  {
    c(bl parambl, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "kotlin.jvm.PlatformType", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<List<WxaPkg.Info>>
  {
    d(bl parambl)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class e
    extends d.g.b.l
    implements b<q.a, y>
  {
    e(bl parambl)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<WxaPkg>
  {
    f(ModulePkgInfo paramModulePkgInfo)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class g
    extends d.g.b.l
    implements b<q.a, y>
  {
    g(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<WxaPkg>
  {
    h(WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements a<LinkedList<String>>
  {
    i(bl parambl)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class j
    extends d.g.b.l
    implements a<y>
  {
    public j(bl parambl, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class k
    extends d.g.b.l
    implements a<q.a>
  {
    k(bl parambl, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements a<y>
  {
    l(bl parambl)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bl
 * JD-Core Version:    0.7.0.1
 */