package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "canAccessFile", "reqURL", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "listAllPlugins", "", "mergeNewComingPkgList", "_pkgList", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wechat-full-sdk_release"})
public final class bu
  implements q
{
  public static final a nIu;
  public volatile boolean closed;
  private final ReentrantReadWriteLock lock;
  private final String nIo;
  private final WxaPkgWrappingInfo nIp;
  private ArrayMap<String, ModulePkgInfo> nIq;
  private final ConcurrentHashMap<String, WxaPkg> nIr;
  private final ConcurrentHashMap<String, q.a> nIs;
  private boolean nIt;
  
  static
  {
    AppMethodBeat.i(183032);
    nIu = new a((byte)0);
    AppMethodBeat.o(183032);
  }
  
  public bu(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183031);
    this.nIo = paramAppBrandRuntime.getAppId();
    Object localObject = paramAppBrandRuntime.d(AppBrandSysConfigLU.class, false);
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((AppBrandSysConfigLU)localObject).nYR;
    if (localObject == null) {
      p.iCn();
    }
    this.nIp = ((WxaPkgWrappingInfo)localObject);
    this.nIr = new ConcurrentHashMap();
    this.nIs = new ConcurrentHashMap(100);
    Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "<init> appId:" + paramAppBrandRuntime.getAppId() + ", pkg:" + this.nIp);
    this.lock = new ReentrantReadWriteLock();
    AppMethodBeat.o(183031);
  }
  
  public static final bu P(AppBrandRuntime paramAppBrandRuntime)
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
    locala.nEw = paramWxaPkg;
    locala.nEx = paramWxaPkg.bGk();
    locala.fileName = paramInfo.fileName;
    locala.nEy = paramInfo.nEy;
    locala.nEz = paramInfo.nEz;
    AppMethodBeat.o(183030);
    return locala;
  }
  
  private final WxaPkg h(String paramString, a<WxaPkg> parama)
  {
    AppMethodBeat.i(246020);
    WxaPkg localWxaPkg2 = (WxaPkg)this.nIr.get(paramString);
    WxaPkg localWxaPkg1 = localWxaPkg2;
    if (localWxaPkg2 == null)
    {
      parama = (WxaPkg)parama.invoke();
      if (parama != null)
      {
        parama.bGl();
        Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.nIo + ", name:" + paramString + ", pkgInnerVersion:" + parama.bHo());
        ((Map)this.nIr).put(paramString, parama);
        AppMethodBeat.o(246020);
        return parama;
      }
      localWxaPkg1 = null;
    }
    AppMethodBeat.o(246020);
    return localWxaPkg1;
  }
  
  private final <T> T t(a<? extends T> parama)
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
  
  public final WxaPkg acD(final String paramString)
  {
    AppMethodBeat.i(183022);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183022);
      return null;
    }
    paramString = (WxaPkg)t((a)new c(this, paramString));
    AppMethodBeat.o(183022);
    return paramString;
  }
  
  public final InputStream acE(String paramString)
  {
    AppMethodBeat.i(183025);
    paramString = acF(paramString);
    if (paramString != null)
    {
      paramString = paramString.nEw.acB(paramString.fileName);
      AppMethodBeat.o(183025);
      return paramString;
    }
    AppMethodBeat.o(183025);
    return null;
  }
  
  public final q.a acF(final String paramString)
  {
    AppMethodBeat.i(183026);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183026);
      return null;
    }
    paramString = (q.a)t((a)new j(this, paramString));
    AppMethodBeat.o(183026);
    return paramString;
  }
  
  public final boolean acG(String paramString)
  {
    AppMethodBeat.i(183023);
    if (acF(paramString) != null)
    {
      AppMethodBeat.o(183023);
      return true;
    }
    AppMethodBeat.o(183023);
    return false;
  }
  
  public final void bGF()
  {
    AppMethodBeat.i(183021);
    if (this.nIt)
    {
      AppMethodBeat.o(183021);
      return;
    }
    s((a)new bu.k(this));
    this.nIt = true;
    AppMethodBeat.o(183021);
  }
  
  public final List<ModulePkgInfo> bGG()
  {
    AppMethodBeat.i(183028);
    Object localObject = this.nIp.nIb;
    p.j(localObject, "pkgWrappingInfo.moduleList");
    localObject = (List)localObject;
    AppMethodBeat.o(183028);
    return localObject;
  }
  
  public final List<String> bGH()
  {
    AppMethodBeat.i(246026);
    List localList = (List)t((a)new h(this));
    AppMethodBeat.o(246026);
    return localList;
  }
  
  public final List<WxaPluginPkgInfo> bHJ()
  {
    AppMethodBeat.i(246021);
    Object localObject2 = this.nIp.nId;
    if (localObject2 != null)
    {
      Object localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).nIm;
      if (localObject1 == null) {
        p.bGy("mSecondaryMap");
      }
      if (((ArrayMap)localObject1).size() <= 0)
      {
        AppMethodBeat.o(246021);
        return null;
      }
      localObject1 = new LinkedList();
      localObject2 = ((WxaRuntimeModulePluginListMap)localObject2).nIm;
      if (localObject2 == null) {
        p.bGy("mSecondaryMap");
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (LinkedList)((Map.Entry)((Iterator)localObject2).next()).getValue();
        p.j(localObject3, "namedPluginList");
        localObject3 = (WxaPluginPkgInfo)j.lp((List)localObject3);
        if (localObject3 != null) {
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      localObject1 = (List)localObject1;
      AppMethodBeat.o(246021);
      return localObject1;
    }
    AppMethodBeat.o(246021);
    return null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(183027);
    s((a)new b(this));
    this.closed = true;
    AppMethodBeat.o(183027);
  }
  
  public final <T> T s(a<? extends T> parama)
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static bu P(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(183003);
      p.k(paramAppBrandRuntime, "$this$getMergeDirReader");
      Object localObject = bl.N(paramAppBrandRuntime);
      paramAppBrandRuntime = (AppBrandRuntime)localObject;
      if (!(localObject instanceof bl)) {
        paramAppBrandRuntime = null;
      }
      paramAppBrandRuntime = (bl)paramAppBrandRuntime;
      if (paramAppBrandRuntime != null) {}
      for (paramAppBrandRuntime = paramAppBrandRuntime.bHE();; paramAppBrandRuntime = null)
      {
        localObject = paramAppBrandRuntime;
        if (!(paramAppBrandRuntime instanceof bu)) {
          localObject = null;
        }
        paramAppBrandRuntime = (bu)localObject;
        AppMethodBeat.o(183003);
        return paramAppBrandRuntime;
      }
    }
    
    public static String a(String paramString, WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      AppMethodBeat.i(183005);
      p.k(paramString, "hostModule");
      p.k(paramWxaPluginPkgInfo, "plugin");
      if (p.h(paramString, "__APP__"))
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
        p.j(paramWxaPluginPkgInfo, "this.prefixPath");
        AppMethodBeat.o(183004);
        return paramWxaPluginPkgInfo;
      }
      paramWxaPluginPkgInfo = "__extended__/" + paramWxaPluginPkgInfo.provider;
      AppMethodBeat.o(183004);
      return paramWxaPluginPkgInfo;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<x>
  {
    b(bu parambu)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<WxaPkg>
  {
    c(bu parambu, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements a<LinkedList<String>>
  {
    h(bu parambu)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements a<q.a>
  {
    j(bu parambu, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bu
 * JD-Core Version:    0.7.0.1
 */