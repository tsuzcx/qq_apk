package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public final class g
  implements a
{
  public static final a mgZ;
  private final boolean enabled;
  private final o jCo;
  private final String mgT;
  private final String mgU;
  private final String mgX;
  private final ConcurrentHashMap<String, ef> mgY;
  
  static
  {
    AppMethodBeat.i(50993);
    mgZ = new a((byte)0);
    AppMethodBeat.o(50993);
  }
  
  private g(o paramo)
  {
    AppMethodBeat.i(50992);
    this.jCo = paramo;
    paramo = this.jCo.aVF().aZo();
    p.g(paramo, "runtime.libReader.versionBuildInfo()");
    this.mgT = paramo;
    label104:
    int i;
    switch (this.jCo.aVL())
    {
    default: 
      paramo = String.valueOf(this.jCo.EX());
      this.mgU = paramo;
      paramo = this.jCo.aXc().jXC;
      if (paramo != null)
      {
        paramo = paramo.mgQ;
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
    for (this.mgX = "";; this.mgX = (paramo + '_' + this.mgT.hashCode() + '_' + this.mgU))
    {
      this.mgY = new ConcurrentHashMap();
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
  
  private final String TH(String paramString)
  {
    AppMethodBeat.i(50985);
    StringBuilder localStringBuilder = new StringBuilder().append(this.mgX).append('_');
    paramString = URLEncoder.encode(paramString, "UTF-8");
    p.g(paramString, "URLEncoder.encode(this, \"UTF-8\")");
    paramString = paramString + ".rc";
    AppMethodBeat.o(50985);
    return paramString;
  }
  
  private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel TI(String paramString)
  {
    AppMethodBeat.i(50986);
    String str = this.jCo.getAppId();
    p.g(str, "runtime.appId");
    paramString = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(str, this.mgT, this.mgU, paramString);
    AppMethodBeat.o(50986);
    return paramString;
  }
  
  private final ef TJ(String paramString)
  {
    AppMethodBeat.i(50988);
    ef localef2 = (ef)this.mgY.get(paramString);
    ef localef1 = localef2;
    String str;
    int i;
    if (localef2 == null)
    {
      str = TH(paramString);
      long l = i.aYo(str);
      localef1 = localef2;
      if (l > 0L)
      {
        localef1 = new ef();
        i = (int)l;
      }
    }
    try
    {
      localef1.parseFrom(i.aY(str, 0, i));
      ((Map)this.mgY).put(paramString, localef1);
      AppMethodBeat.o(50988);
      return localef1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.deleteFile(str);
      }
    }
  }
  
  public static final g y(o paramo)
  {
    AppMethodBeat.i(189560);
    p.h(paramo, "rt");
    if (paramo.aVF() == null)
    {
      ad.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "try create provider but rt.libReader is NULL, appId:" + paramo.getAppId());
      AppMethodBeat.o(189560);
      return null;
    }
    paramo = new g(paramo, (byte)0);
    AppMethodBeat.o(189560);
    return paramo;
  }
  
  public final String TC(String paramString)
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
    Object localObject = TJ(paramString);
    if (localObject != null) {
      str = ((ef)localObject).content;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        f.a((b)new WebRenderingCacheIPCOperations.a(), TI(paramString));
      }
      AppMethodBeat.o(50989);
      return str;
    }
  }
  
  public final String TD(String paramString)
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
    paramString = TJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.Fwc;
      AppMethodBeat.o(50990);
      return paramString;
    }
    AppMethodBeat.o(50990);
    return null;
  }
  
  public final String TE(String paramString)
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
    paramString = TJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.Fwd;
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
      ad.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.jCo.getAppId() + "] path[" + paramString1 + ']');
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
      ad.i("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", i + ']');
      if (paramString2 != null) {
        break label259;
      }
      i.deleteFile(TH(paramString1));
      f.a((b)new WebRenderingCacheIPCOperations.c(), TI(paramString1));
      AppMethodBeat.o(50987);
      return;
      i = -1;
      break;
    }
    label259:
    localObject = (Map)this.mgY;
    ef localef = new ef();
    localef.content = paramString2;
    localef.Fwc = paramString3;
    localef.Fwd = paramString4;
    paramString2 = TH(paramString1);
    try
    {
      i.C(paramString2, localef.toByteArray());
      paramString3 = (b)new WebRenderingCacheIPCOperations.b();
      paramString4 = TI(paramString1);
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
        ad.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.jCo.getAppId() + "] path[" + paramString1 + "] e=" + paramString2);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.g
 * JD-Core Version:    0.7.0.1
 */