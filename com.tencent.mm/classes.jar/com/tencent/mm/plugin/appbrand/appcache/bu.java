package com.tencent.mm.plugin.appbrand.appcache;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;
import org.apache.commons.b.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "closed", "", "filesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "filesMapInitialized", "hostWxaAppId", "kotlin.jvm.PlatformType", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "modulesMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "pkgWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "pkgsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;", "pluginAppConfigFileList", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSeparatedPluginAppConfigFileList;", "canAccessFile", "reqURL", "print", "close", "", "findAppropriateModuleInfo", "resourcePath", "getMainPkgInfo", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg$Info;", "getModuleList", "guardedMergeModule", "module", "guardedMergePlugin", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "guardedObtainPkgInstance", "name", "lazyCreator", "Lkotlin/Function0;", "listAllFilenames", "listAllPlugins", "", "mergeNewComingPkgList", "_pkgList", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "openReadPartialInfo", "openReadStream", "Ljava/io/InputStream;", "refreshModuleList", "requireRead", "T", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWrite", "openRead", "toFileEntry", "wxaPkg", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bu
  implements s
{
  public static final a qIe;
  public volatile boolean closed;
  private final ReentrantReadWriteLock lock;
  private final String qIf;
  private final WxaPkgWrappingInfo qIg;
  private final m qIh;
  private ArrayMap<String, ModulePkgInfo> qIi;
  private final ConcurrentHashMap<String, WxaPkg> qIj;
  private final ConcurrentHashMap<String, s.a> qIk;
  private boolean qIl;
  
  static
  {
    AppMethodBeat.i(183032);
    qIe = new a((byte)0);
    AppMethodBeat.o(183032);
  }
  
  public bu(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183031);
    this.qIf = paramAppBrandRuntime.mAppId;
    Object localObject = paramAppBrandRuntime.d(com.tencent.mm.plugin.appbrand.config.n.class, false);
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = ((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY;
    kotlin.g.b.s.checkNotNull(localObject);
    this.qIg = ((WxaPkgWrappingInfo)localObject);
    this.qIj = new ConcurrentHashMap();
    this.qIk = new ConcurrentHashMap(100);
    Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "<init> appId:" + paramAppBrandRuntime.mAppId + ", pkg:" + this.qIg + ", hash:" + hashCode());
    if (paramAppBrandRuntime.cbR())
    {
      localObject = new m();
      paramAppBrandRuntime.qst.add(localObject);
      paramAppBrandRuntime = ah.aiuX;
    }
    for (this.qIh = ((m)localObject);; this.qIh = null)
    {
      this.lock = new ReentrantReadWriteLock();
      AppMethodBeat.o(183031);
      return;
    }
  }
  
  public static final bu T(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(183035);
    paramAppBrandRuntime = a.T(paramAppBrandRuntime);
    AppMethodBeat.o(183035);
    return paramAppBrandRuntime;
  }
  
  private static s.a a(WxaPkg.Info paramInfo, WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(183030);
    s.a locala = new s.a();
    locala.qEt = paramWxaPkg;
    locala.qEu = paramWxaPkg.cfJ();
    locala.fileName = paramInfo.fileName;
    locala.qEv = paramInfo.qEv;
    locala.qEw = paramInfo.qEw;
    AppMethodBeat.o(183030);
    return locala;
  }
  
  private final <T> T al(a<? extends T> parama)
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
  
  private final WxaPkg m(String paramString, a<WxaPkg> parama)
  {
    AppMethodBeat.i(320224);
    WxaPkg localWxaPkg = (WxaPkg)this.qIj.get(paramString);
    if (localWxaPkg == null)
    {
      parama = (WxaPkg)parama.invoke();
      if (parama == null)
      {
        AppMethodBeat.o(320224);
        return null;
      }
      parama.cfK();
      Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "guardedObtainPkgInstance, appId:" + this.qIf + ", name:" + paramString + ", pkgInnerVersion:" + parama.cgO());
      ((Map)this.qIj).put(paramString, parama);
      AppMethodBeat.o(320224);
      return parama;
    }
    AppMethodBeat.o(320224);
    return localWxaPkg;
  }
  
  public final WxaPkg Vc(final String paramString)
  {
    AppMethodBeat.i(183022);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183022);
      return null;
    }
    paramString = (WxaPkg)al((a)new c(this, paramString));
    AppMethodBeat.o(183022);
    return paramString;
  }
  
  public final InputStream Vd(String paramString)
  {
    AppMethodBeat.i(183025);
    paramString = Ve(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183025);
      return null;
    }
    paramString = paramString.qEt.Va(paramString.fileName);
    AppMethodBeat.o(183025);
    return paramString;
  }
  
  public final s.a Ve(final String paramString)
  {
    AppMethodBeat.i(183026);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(183026);
      return null;
    }
    paramString = (s.a)al((a)new j(this, paramString));
    AppMethodBeat.o(183026);
    return paramString;
  }
  
  public final boolean Vf(String paramString)
  {
    AppMethodBeat.i(183023);
    if (Ve(paramString) != null)
    {
      AppMethodBeat.o(183023);
      return true;
    }
    AppMethodBeat.o(183023);
    return false;
  }
  
  public final <T> T ak(a<? extends T> parama)
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
  
  public final boolean an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(320261);
    if (Ve(paramString) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramBoolean) {
        Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "canAccessFile appId:" + this.qIf + ", url:" + paramString + ", ret:" + bool + ", hash:" + hashCode());
      }
      AppMethodBeat.o(320261);
      return bool;
    }
  }
  
  public final void cge()
  {
    AppMethodBeat.i(183021);
    if (this.qIl)
    {
      AppMethodBeat.o(183021);
      return;
    }
    ak((a)new bu.k(this));
    this.qIl = true;
    AppMethodBeat.o(183021);
  }
  
  public final List<ModulePkgInfo> cgf()
  {
    AppMethodBeat.i(183028);
    Object localObject = this.qIg.qHR;
    kotlin.g.b.s.s(localObject, "pkgWrappingInfo.moduleList");
    localObject = (List)localObject;
    AppMethodBeat.o(183028);
    return localObject;
  }
  
  public final List<String> cgg()
  {
    AppMethodBeat.i(320268);
    List localList = (List)al((a)new h(this));
    AppMethodBeat.o(320268);
    return localList;
  }
  
  public final List<WxaPluginPkgInfo> chf()
  {
    AppMethodBeat.i(320256);
    WxaRuntimeModulePluginListMap localWxaRuntimeModulePluginListMap = this.qIg.qHT;
    if (localWxaRuntimeModulePluginListMap == null)
    {
      AppMethodBeat.o(320256);
      return null;
    }
    Object localObject2 = localWxaRuntimeModulePluginListMap.qId;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mSecondaryMap");
      localObject1 = null;
    }
    if (((ArrayMap)localObject1).size() <= 0)
    {
      AppMethodBeat.o(320256);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject2 = localWxaRuntimeModulePluginListMap.qId;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mSecondaryMap");
      localObject1 = null;
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LinkedList)((Map.Entry)((Iterator)localObject1).next()).getValue();
      kotlin.g.b.s.s(localObject2, "namedPluginList");
      localObject2 = (WxaPluginPkgInfo)p.oL((List)localObject2);
      if (localObject2 != null) {
        localLinkedList.add(localObject2);
      }
    }
    localObject1 = (List)localLinkedList;
    AppMethodBeat.o(320256);
    return localObject1;
  }
  
  public final void close()
  {
    AppMethodBeat.i(183027);
    Log.i("Luggage.FULL.WxaRuntimePkgMergeDirReader", "close, appId:" + this.qIf + ", hash:" + hashCode());
    ak((a)new b(this));
    this.closed = true;
    AppMethodBeat.o(183027);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader$Companion;", "", "()V", "TAG", "", "getPluginFileAccessPrefixMergedWithModule", "hostModule", "plugin", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "getMergeDirReader", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgMergeDirReader;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "realPrefixForRuntimeAccess", "toUtf8String", "Ljava/io/InputStream;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String M(InputStream paramInputStream)
    {
      AppMethodBeat.i(320290);
      if (paramInputStream == null)
      {
        AppMethodBeat.o(320290);
        return null;
      }
      paramInputStream = d.a(paramInputStream, StandardCharsets.UTF_8);
      AppMethodBeat.o(320290);
      return paramInputStream;
    }
    
    public static bu T(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(183003);
      kotlin.g.b.s.u(paramAppBrandRuntime, "<this>");
      paramAppBrandRuntime = bl.R(paramAppBrandRuntime);
      if ((paramAppBrandRuntime instanceof bl))
      {
        paramAppBrandRuntime = (bl)paramAppBrandRuntime;
        if (paramAppBrandRuntime != null) {
          break label58;
        }
      }
      label58:
      for (paramAppBrandRuntime = null;; paramAppBrandRuntime = paramAppBrandRuntime.qHs)
      {
        if (!(paramAppBrandRuntime instanceof bu)) {
          break label66;
        }
        paramAppBrandRuntime = (bu)paramAppBrandRuntime;
        AppMethodBeat.o(183003);
        return paramAppBrandRuntime;
        paramAppBrandRuntime = null;
        break;
      }
      label66:
      AppMethodBeat.o(183003);
      return null;
    }
    
    public static String a(String paramString, WxaPluginPkgInfo paramWxaPluginPkgInfo)
    {
      AppMethodBeat.i(183005);
      kotlin.g.b.s.u(paramString, "hostModule");
      kotlin.g.b.s.u(paramWxaPluginPkgInfo, "plugin");
      if (kotlin.g.b.s.p(paramString, "__APP__"))
      {
        paramString = b(paramWxaPluginPkgInfo);
        AppMethodBeat.o(183005);
        return paramString;
      }
      if (kotlin.n.n.a((CharSequence)paramString, '/'))
      {
        paramString = kotlin.g.b.s.X(paramString, b(paramWxaPluginPkgInfo));
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
        kotlin.g.b.s.s(paramWxaPluginPkgInfo, "{\n                this.prefixPath\n            }");
        AppMethodBeat.o(183004);
        return paramWxaPluginPkgInfo;
      }
      paramWxaPluginPkgInfo = kotlin.g.b.s.X("__extended__/", paramWxaPluginPkgInfo.provider);
      AppMethodBeat.o(183004);
      return paramWxaPluginPkgInfo;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(bu parambu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<WxaPkg>
  {
    c(bu parambu, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<LinkedList<String>>
  {
    h(bu parambu)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements a<s.a>
  {
    j(bu parambu, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bu
 * JD-Core Version:    0.7.0.1
 */