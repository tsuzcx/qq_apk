package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public final class g
  implements a
{
  public static final a mlY;
  private final boolean enabled;
  private final com.tencent.mm.plugin.appbrand.p jFm;
  private final String mlS;
  private final String mlT;
  private final String mlW;
  private final ConcurrentHashMap<String, ef> mlX;
  
  static
  {
    AppMethodBeat.i(50993);
    mlY = new a((byte)0);
    AppMethodBeat.o(50993);
  }
  
  private g(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(50992);
    this.jFm = paramp;
    paramp = this.jFm.aWe().aZL();
    d.g.b.p.g(paramp, "runtime.libReader.versionBuildInfo()");
    this.mlS = paramp;
    label104:
    int i;
    switch (this.jFm.aWk())
    {
    default: 
      paramp = String.valueOf(this.jFm.Fc());
      this.mlT = paramp;
      paramp = this.jFm.aXx().kaR;
      if (paramp != null)
      {
        paramp = paramp.mlP;
        CharSequence localCharSequence = (CharSequence)paramp;
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
    for (this.mlW = "";; this.mlW = (paramp + '_' + this.mlS.hashCode() + '_' + this.mlT))
    {
      this.mlX = new ConcurrentHashMap();
      AppMethodBeat.o(50992);
      return;
      paramp = "TEST";
      break;
      paramp = "DEMO";
      break;
      paramp = null;
      break label104;
      label173:
      i = 0;
      break label124;
      label178:
      this.enabled = true;
    }
  }
  
  private final String Uq(String paramString)
  {
    AppMethodBeat.i(50985);
    StringBuilder localStringBuilder = new StringBuilder().append(this.mlW).append('_');
    paramString = URLEncoder.encode(paramString, "UTF-8");
    d.g.b.p.g(paramString, "URLEncoder.encode(this, \"UTF-8\")");
    paramString = paramString + ".rc";
    AppMethodBeat.o(50985);
    return paramString;
  }
  
  private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel Ur(String paramString)
  {
    AppMethodBeat.i(50986);
    String str = this.jFm.getAppId();
    d.g.b.p.g(str, "runtime.appId");
    paramString = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(str, this.mlS, this.mlT, paramString);
    AppMethodBeat.o(50986);
    return paramString;
  }
  
  private final ef Us(String paramString)
  {
    AppMethodBeat.i(50988);
    ef localef2 = (ef)this.mlX.get(paramString);
    ef localef1 = localef2;
    String str;
    int i;
    if (localef2 == null)
    {
      str = Uq(paramString);
      long l = o.aZR(str);
      localef1 = localef2;
      if (l > 0L)
      {
        localef1 = new ef();
        i = (int)l;
      }
    }
    try
    {
      localef1.parseFrom(o.bb(str, 0, i));
      ((Map)this.mlX).put(paramString, localef1);
      AppMethodBeat.o(50988);
      return localef1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        o.deleteFile(str);
      }
    }
  }
  
  public static final g z(com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(223829);
    d.g.b.p.h(paramp, "rt");
    if (paramp.aWe() == null)
    {
      ae.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "try create provider but rt.libReader is NULL, appId:" + paramp.getAppId());
      AppMethodBeat.o(223829);
      return null;
    }
    paramp = new g(paramp, (byte)0);
    AppMethodBeat.o(223829);
    return paramp;
  }
  
  public final String Ul(String paramString)
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
    Object localObject = Us(paramString);
    if (localObject != null) {
      str = ((ef)localObject).content;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        f.a((b)new WebRenderingCacheIPCOperations.a(), Ur(paramString));
      }
      AppMethodBeat.o(50989);
      return str;
    }
  }
  
  public final String Um(String paramString)
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
    paramString = Us(paramString);
    if (paramString != null)
    {
      paramString = paramString.FOA;
      AppMethodBeat.o(50990);
      return paramString;
    }
    AppMethodBeat.o(50990);
    return null;
  }
  
  public final String Un(String paramString)
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
    paramString = Us(paramString);
    if (paramString != null)
    {
      paramString = paramString.FOB;
      AppMethodBeat.o(50991);
      return paramString;
    }
    AppMethodBeat.o(50991);
    return null;
  }
  
  public final void i(String paramString1, String paramString2, String paramString3, String paramString4)
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
      ae.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.jFm.getAppId() + "] path[" + paramString1 + ']');
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
      ae.i("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", i + ']');
      if (paramString2 != null) {
        break label259;
      }
      o.deleteFile(Uq(paramString1));
      f.a((b)new WebRenderingCacheIPCOperations.c(), Ur(paramString1));
      AppMethodBeat.o(50987);
      return;
      i = -1;
      break;
    }
    label259:
    localObject = (Map)this.mlX;
    ef localef = new ef();
    localef.content = paramString2;
    localef.FOA = paramString3;
    localef.FOB = paramString4;
    paramString2 = Uq(paramString1);
    try
    {
      o.C(paramString2, localef.toByteArray());
      paramString3 = (b)new WebRenderingCacheIPCOperations.b();
      paramString4 = Ur(paramString1);
      paramString4.filePath = paramString2;
      f.a(paramString3, paramString4);
      ((Map)localObject).put(paramString1, localef);
      AppMethodBeat.o(50987);
      return;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.jFm.getAppId() + "] path[" + paramString1 + "] e=" + paramString2);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.g
 * JD-Core Version:    0.7.0.1
 */