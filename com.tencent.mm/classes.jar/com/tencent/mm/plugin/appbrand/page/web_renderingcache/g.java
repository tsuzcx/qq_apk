package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public final class g
  implements a
{
  public static final a lHn;
  private final boolean enabled;
  private final o jPl;
  private final String lHh;
  private final String lHi;
  private final String lHl;
  private final ConcurrentHashMap<String, eb> lHm;
  
  static
  {
    AppMethodBeat.i(50993);
    lHn = new a((byte)0);
    AppMethodBeat.o(50993);
  }
  
  private g(o paramo)
  {
    AppMethodBeat.i(50992);
    this.jPl = paramo;
    paramo = this.jPl.aSt().aVT();
    k.g(paramo, "runtime.libReader.versionBuildInfo()");
    this.lHh = paramo;
    label104:
    int i;
    switch (this.jPl.aSy())
    {
    default: 
      paramo = String.valueOf(this.jPl.Dy());
      this.lHi = paramo;
      paramo = this.jPl.aTS().jDG;
      if (paramo != null)
      {
        paramo = paramo.lHe;
        CharSequence localCharSequence = (CharSequence)paramo;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label173;
        }
        i = 1;
        label124:
        if (i == 0) {
          break label178;
        }
        this.enabled = false;
      }
      break;
    }
    for (this.lHl = "";; this.lHl = (paramo + '_' + this.lHh.hashCode() + '_' + this.lHi))
    {
      this.lHm = new ConcurrentHashMap();
      AppMethodBeat.o(50992);
      return;
      paramo = "TEST";
      break;
      paramo = "DEMO";
      break;
      paramo = null;
      break label104;
      label173:
      i = 0;
      break label124;
      label178:
      this.enabled = true;
    }
  }
  
  public static final g H(o paramo)
  {
    AppMethodBeat.i(187351);
    k.h(paramo, "rt");
    if (paramo.aSt() == null)
    {
      ac.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "try create provider but rt.libReader is NULL, appId:" + paramo.getAppId());
      AppMethodBeat.o(187351);
      return null;
    }
    paramo = new g(paramo, (byte)0);
    AppMethodBeat.o(187351);
    return paramo;
  }
  
  private final String Qc(String paramString)
  {
    AppMethodBeat.i(50985);
    StringBuilder localStringBuilder = new StringBuilder().append(this.lHl).append('_');
    paramString = URLEncoder.encode(paramString, "UTF-8");
    k.g(paramString, "URLEncoder.encode(this, \"UTF-8\")");
    paramString = paramString + ".rc";
    AppMethodBeat.o(50985);
    return paramString;
  }
  
  private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel Qd(String paramString)
  {
    AppMethodBeat.i(50986);
    String str = this.jPl.getAppId();
    k.g(str, "runtime.appId");
    paramString = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(str, this.lHh, this.lHi, paramString);
    AppMethodBeat.o(50986);
    return paramString;
  }
  
  private final eb Qe(String paramString)
  {
    AppMethodBeat.i(50988);
    eb localeb2 = (eb)this.lHm.get(paramString);
    eb localeb1 = localeb2;
    String str;
    int i;
    if (localeb2 == null)
    {
      str = Qc(paramString);
      long l = i.aSp(str);
      localeb1 = localeb2;
      if (l > 0L)
      {
        localeb1 = new eb();
        i = (int)l;
      }
    }
    try
    {
      localeb1.parseFrom(i.aU(str, 0, i));
      ((Map)this.lHm).put(paramString, localeb1);
      AppMethodBeat.o(50988);
      return localeb1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.deleteFile(str);
      }
    }
  }
  
  public final String PX(String paramString)
  {
    String str = null;
    AppMethodBeat.i(50989);
    if (this.enabled)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label50;
      }
    }
    label50:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50989);
      return null;
    }
    Object localObject = Qe(paramString);
    if (localObject != null) {
      str = ((eb)localObject).content;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        f.a((b)new WebRenderingCacheIPCOperations.a(), Qd(paramString));
      }
      AppMethodBeat.o(50989);
      return str;
    }
  }
  
  public final String PY(String paramString)
  {
    AppMethodBeat.i(50990);
    if (this.enabled)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label45;
      }
    }
    label45:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50990);
      return null;
    }
    paramString = Qe(paramString);
    if (paramString != null)
    {
      paramString = paramString.DQK;
      AppMethodBeat.o(50990);
      return paramString;
    }
    AppMethodBeat.o(50990);
    return null;
  }
  
  public final String PZ(String paramString)
  {
    AppMethodBeat.i(50991);
    if (this.enabled)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label45;
      }
    }
    label45:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50991);
      return null;
    }
    paramString = Qe(paramString);
    if (paramString != null)
    {
      paramString = paramString.DQL;
      AppMethodBeat.o(50991);
      return paramString;
    }
    AppMethodBeat.o(50991);
    return null;
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int j = -1;
    AppMethodBeat.i(50987);
    if (this.enabled)
    {
      localObject = (CharSequence)paramString1;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label95;
      }
    }
    label95:
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.jPl.getAppId() + "] path[" + paramString1 + ']');
      AppMethodBeat.o(50987);
      return;
    }
    Object localObject = new StringBuilder("save path[").append(paramString1).append("] content[");
    if (paramString2 != null)
    {
      i = paramString2.length();
      localObject = ((StringBuilder)localObject).append(i).append("] webviewData[");
      if (paramString3 == null) {
        break label253;
      }
    }
    label253:
    for (i = paramString3.length();; i = -1)
    {
      localObject = ((StringBuilder)localObject).append(i).append("] serviceData[");
      i = j;
      if (paramString4 != null) {
        i = paramString4.length();
      }
      ac.i("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", i + ']');
      if (paramString2 != null) {
        break label259;
      }
      i.deleteFile(Qc(paramString1));
      f.a((b)new WebRenderingCacheIPCOperations.c(), Qd(paramString1));
      AppMethodBeat.o(50987);
      return;
      i = -1;
      break;
    }
    label259:
    localObject = (Map)this.lHm;
    eb localeb = new eb();
    localeb.content = paramString2;
    localeb.DQK = paramString3;
    localeb.DQL = paramString4;
    paramString2 = Qc(paramString1);
    try
    {
      i.B(paramString2, localeb.toByteArray());
      paramString3 = (b)new WebRenderingCacheIPCOperations.b();
      paramString4 = Qd(paramString1);
      paramString4.filePath = paramString2;
      f.a(paramString3, paramString4);
      ((Map)localObject).put(paramString1, localeb);
      AppMethodBeat.o(50987);
      return;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ac.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.jPl.getAppId() + "] path[" + paramString1 + "] e=" + paramString2);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.g
 * JD-Core Version:    0.7.0.1
 */