package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public final class g
  implements a
{
  public static final a nww;
  private final boolean enabled;
  private final q kGW;
  private final String nwq;
  private final String nwr;
  private final String nwu;
  private final ConcurrentHashMap<String, es> nwv;
  
  static
  {
    AppMethodBeat.i(50993);
    nww = new a((byte)0);
    AppMethodBeat.o(50993);
  }
  
  private g(q paramq)
  {
    AppMethodBeat.i(50992);
    this.kGW = paramq;
    paramq = this.kGW.bqZ().bvc();
    p.g(paramq, "runtime.libReader.versionBuildInfo()");
    this.nwq = paramq;
    label104:
    int i;
    switch (this.kGW.brf())
    {
    default: 
      paramq = String.valueOf(this.kGW.OJ());
      this.nwr = paramq;
      paramq = this.kGW.bsC().ldV;
      if (paramq != null)
      {
        paramq = paramq.nwn;
        CharSequence localCharSequence = (CharSequence)paramq;
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
    for (this.nwu = "";; this.nwu = (paramq + '_' + this.nwq.hashCode() + '_' + this.nwr))
    {
      this.nwv = new ConcurrentHashMap();
      AppMethodBeat.o(50992);
      return;
      paramq = "TEST";
      break;
      paramq = "DEMO";
      break;
      paramq = null;
      break label104;
      label173:
      i = 0;
      break label124;
      label178:
      this.enabled = true;
    }
  }
  
  public static final g D(q paramq)
  {
    AppMethodBeat.i(229254);
    p.h(paramq, "rt");
    if (paramq.bqZ() == null)
    {
      Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "try create provider but rt.libReader is NULL, appId:" + paramq.getAppId());
      AppMethodBeat.o(229254);
      return null;
    }
    paramq = new g(paramq, (byte)0);
    AppMethodBeat.o(229254);
    return paramq;
  }
  
  private final String aee(String paramString)
  {
    AppMethodBeat.i(50985);
    StringBuilder localStringBuilder = new StringBuilder().append(this.nwu).append('_');
    paramString = URLEncoder.encode(paramString, "UTF-8");
    p.g(paramString, "URLEncoder.encode(this, \"UTF-8\")");
    paramString = paramString + ".rc";
    AppMethodBeat.o(50985);
    return paramString;
  }
  
  private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel aef(String paramString)
  {
    AppMethodBeat.i(50986);
    String str = this.kGW.getAppId();
    p.g(str, "runtime.appId");
    paramString = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(str, this.nwq, this.nwr, paramString);
    AppMethodBeat.o(50986);
    return paramString;
  }
  
  private final es aeg(String paramString)
  {
    AppMethodBeat.i(50988);
    es locales2 = (es)this.nwv.get(paramString);
    es locales1 = locales2;
    String str;
    int i;
    if (locales2 == null)
    {
      str = aee(paramString);
      long l = s.boW(str);
      locales1 = locales2;
      if (l > 0L)
      {
        locales1 = new es();
        i = (int)l;
      }
    }
    try
    {
      locales1.parseFrom(s.aW(str, 0, i));
      ((Map)this.nwv).put(paramString, locales1);
      AppMethodBeat.o(50988);
      return locales1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        s.deleteFile(str);
      }
    }
  }
  
  public final String adZ(String paramString)
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
    Object localObject = aeg(paramString);
    if (localObject != null) {
      str = ((es)localObject).content;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        f.a((b)new WebRenderingCacheIPCOperations.a(), aef(paramString));
      }
      AppMethodBeat.o(50989);
      return str;
    }
  }
  
  public final String aea(String paramString)
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
    paramString = aeg(paramString);
    if (paramString != null)
    {
      paramString = paramString.KIi;
      AppMethodBeat.o(50990);
      return paramString;
    }
    AppMethodBeat.o(50990);
    return null;
  }
  
  public final String aeb(String paramString)
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
    paramString = aeg(paramString);
    if (paramString != null)
    {
      paramString = paramString.KIj;
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
      Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.kGW.getAppId() + "] path[" + paramString1 + ']');
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
      Log.i("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", i + ']');
      if (paramString2 != null) {
        break label259;
      }
      s.deleteFile(aee(paramString1));
      f.a((b)new WebRenderingCacheIPCOperations.c(), aef(paramString1));
      AppMethodBeat.o(50987);
      return;
      i = -1;
      break;
    }
    label259:
    localObject = (Map)this.nwv;
    es locales = new es();
    locales.content = paramString2;
    locales.KIi = paramString3;
    locales.KIj = paramString4;
    paramString2 = aee(paramString1);
    try
    {
      s.C(paramString2, locales.toByteArray());
      paramString3 = (b)new WebRenderingCacheIPCOperations.b();
      paramString4 = aef(paramString1);
      paramString4.filePath = paramString2;
      f.a(paramString3, paramString4);
      ((Map)localObject).put(paramString1, locales);
      AppMethodBeat.o(50987);
      return;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.kGW.getAppId() + "] path[" + paramString1 + "] e=" + paramString2);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.g
 * JD-Core Version:    0.7.0.1
 */