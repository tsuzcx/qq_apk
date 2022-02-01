package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public final class f
  implements a
{
  public static final f.a qyz;
  private final boolean enabled;
  private final t nAH;
  private final String qyt;
  private final String qyu;
  private final String qyx;
  private final ConcurrentHashMap<String, ep> qyy;
  
  static
  {
    AppMethodBeat.i(50993);
    qyz = new f.a((byte)0);
    AppMethodBeat.o(50993);
  }
  
  private f(t paramt)
  {
    AppMethodBeat.i(50992);
    this.nAH = paramt;
    paramt = this.nAH.bBP().bGh();
    p.j(paramt, "runtime.libReader.versionBuildInfo()");
    this.qyt = paramt;
    label104:
    int i;
    switch (this.nAH.bBV())
    {
    default: 
      paramt = String.valueOf(this.nAH.Sg());
      this.qyu = paramt;
      paramt = this.nAH.bDy().nYj;
      if (paramt != null)
      {
        paramt = paramt.qyq;
        CharSequence localCharSequence = (CharSequence)paramt;
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
    for (this.qyx = "";; this.qyx = (paramt + '_' + this.qyt.hashCode() + '_' + this.qyu))
    {
      this.qyy = new ConcurrentHashMap();
      AppMethodBeat.o(50992);
      return;
      paramt = "TEST";
      break;
      paramt = "DEMO";
      break;
      paramt = null;
      break label104;
      label173:
      i = 0;
      break label124;
      label178:
      this.enabled = true;
    }
  }
  
  public static final f E(t paramt)
  {
    AppMethodBeat.i(248356);
    p.k(paramt, "rt");
    if (paramt.bBP() == null)
    {
      Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "try create provider but rt.libReader is NULL, appId:" + paramt.getAppId());
      AppMethodBeat.o(248356);
      return null;
    }
    paramt = new f(paramt, (byte)0);
    AppMethodBeat.o(248356);
    return paramt;
  }
  
  private final String alY(String paramString)
  {
    AppMethodBeat.i(50985);
    StringBuilder localStringBuilder = new StringBuilder().append(this.qyx).append('_');
    paramString = URLEncoder.encode(paramString, "UTF-8");
    p.j(paramString, "URLEncoder.encode(this, \"UTF-8\")");
    paramString = paramString + ".rc";
    AppMethodBeat.o(50985);
    return paramString;
  }
  
  private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel alZ(String paramString)
  {
    AppMethodBeat.i(50986);
    String str = this.nAH.getAppId();
    p.j(str, "runtime.appId");
    paramString = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(str, this.qyt, this.qyu, paramString);
    AppMethodBeat.o(50986);
    return paramString;
  }
  
  private final ep ama(String paramString)
  {
    AppMethodBeat.i(50988);
    ep localep2 = (ep)this.qyy.get(paramString);
    ep localep1 = localep2;
    String str;
    int i;
    if (localep2 == null)
    {
      str = alY(paramString);
      long l = u.bBQ(str);
      localep1 = localep2;
      if (l > 0L)
      {
        localep1 = new ep();
        i = (int)l;
      }
    }
    try
    {
      localep1.parseFrom(u.aY(str, 0, i));
      ((Map)this.qyy).put(paramString, localep1);
      AppMethodBeat.o(50988);
      return localep1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        u.deleteFile(str);
      }
    }
  }
  
  public final String alU(String paramString)
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
    Object localObject = ama(paramString);
    if (localObject != null) {
      str = ((ep)localObject).content;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        e.a((d)new WebRenderingCacheIPCOperations.a(), alZ(paramString));
      }
      AppMethodBeat.o(50989);
      return str;
    }
  }
  
  public final String alV(String paramString)
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
    paramString = ama(paramString);
    if (paramString != null)
    {
      paramString = paramString.RJy;
      AppMethodBeat.o(50990);
      return paramString;
    }
    AppMethodBeat.o(50990);
    return null;
  }
  
  public final String alW(String paramString)
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
    paramString = ama(paramString);
    if (paramString != null)
    {
      paramString = paramString.RJz;
      AppMethodBeat.o(50991);
      return paramString;
    }
    AppMethodBeat.o(50991);
    return null;
  }
  
  public final void l(String paramString1, String paramString2, String paramString3, String paramString4)
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
      Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.nAH.getAppId() + "] path[" + paramString1 + ']');
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
      u.deleteFile(alY(paramString1));
      e.a((d)new WebRenderingCacheIPCOperations.c(), alZ(paramString1));
      AppMethodBeat.o(50987);
      return;
      i = -1;
      break;
    }
    label259:
    localObject = (Map)this.qyy;
    ep localep = new ep();
    localep.content = paramString2;
    localep.RJy = paramString3;
    localep.RJz = paramString4;
    paramString2 = alY(paramString1);
    try
    {
      u.H(paramString2, localep.toByteArray());
      paramString3 = (d)new WebRenderingCacheIPCOperations.b();
      paramString4 = alZ(paramString1);
      paramString4.filePath = paramString2;
      e.a(paramString3, paramString4);
      ((Map)localObject).put(paramString1, localep);
      AppMethodBeat.o(50987);
      return;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.nAH.getAppId() + "] path[" + paramString1 + "] e=" + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.f
 * JD-Core Version:    0.7.0.1
 */