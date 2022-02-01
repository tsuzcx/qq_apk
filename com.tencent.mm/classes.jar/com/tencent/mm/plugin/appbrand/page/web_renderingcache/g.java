package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public final class g
  implements a
{
  public static final a lhu;
  private final boolean enabled;
  private final o joZ;
  private final String lho;
  private final String lhp;
  private final String lhs;
  private final ConcurrentHashMap<String, dz> lht;
  
  static
  {
    AppMethodBeat.i(50993);
    lhu = new a((byte)0);
    AppMethodBeat.o(50993);
  }
  
  private g(o paramo)
  {
    AppMethodBeat.i(50992);
    this.joZ = paramo;
    paramo = this.joZ.aLC().aPb();
    k.g(paramo, "runtime.libReader.versionBuildInfo()");
    this.lho = paramo;
    label104:
    int i;
    switch (this.joZ.aLI())
    {
    default: 
      paramo = String.valueOf(this.joZ.DV());
      this.lhp = paramo;
      paramo = this.joZ.aNc().jdt;
      if (paramo != null)
      {
        paramo = paramo.lhl;
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
    for (this.lhs = "";; this.lhs = (paramo + '_' + this.lho.hashCode() + '_' + this.lhp))
    {
      this.lht = new ConcurrentHashMap();
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
    AppMethodBeat.i(196413);
    k.h(paramo, "rt");
    if (paramo.aLC() == null)
    {
      ad.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "try create provider but rt.libReader is NULL, appId:" + paramo.getAppId());
      AppMethodBeat.o(196413);
      return null;
    }
    paramo = new g(paramo, (byte)0);
    AppMethodBeat.o(196413);
    return paramo;
  }
  
  private final String LW(String paramString)
  {
    AppMethodBeat.i(50985);
    StringBuilder localStringBuilder = new StringBuilder().append(this.lhs).append('_');
    paramString = URLEncoder.encode(paramString, "UTF-8");
    k.g(paramString, "URLEncoder.encode(this, \"UTF-8\")");
    paramString = paramString + ".rc";
    AppMethodBeat.o(50985);
    return paramString;
  }
  
  private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel LX(String paramString)
  {
    AppMethodBeat.i(50986);
    String str = this.joZ.getAppId();
    k.g(str, "runtime.appId");
    paramString = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(str, this.lho, this.lhp, paramString);
    AppMethodBeat.o(50986);
    return paramString;
  }
  
  private final dz LY(String paramString)
  {
    AppMethodBeat.i(50988);
    dz localdz2 = (dz)this.lht.get(paramString);
    dz localdz1 = localdz2;
    String str;
    int i;
    if (localdz2 == null)
    {
      str = LW(paramString);
      long l = i.aMN(str);
      localdz1 = localdz2;
      if (l > 0L)
      {
        localdz1 = new dz();
        i = (int)l;
      }
    }
    try
    {
      localdz1.parseFrom(i.aR(str, 0, i));
      ((Map)this.lht).put(paramString, localdz1);
      AppMethodBeat.o(50988);
      return localdz1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        i.deleteFile(str);
      }
    }
  }
  
  public final String LR(String paramString)
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
    Object localObject = LY(paramString);
    if (localObject != null) {
      str = ((dz)localObject).content;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        f.a((b)new WebRenderingCacheIPCOperations.a(), LX(paramString));
      }
      AppMethodBeat.o(50989);
      return str;
    }
  }
  
  public final String LS(String paramString)
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
    paramString = LY(paramString);
    if (paramString != null)
    {
      paramString = paramString.Cyo;
      AppMethodBeat.o(50990);
      return paramString;
    }
    AppMethodBeat.o(50990);
    return null;
  }
  
  public final String LT(String paramString)
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
    paramString = LY(paramString);
    if (paramString != null)
    {
      paramString = paramString.Cyp;
      AppMethodBeat.o(50991);
      return paramString;
    }
    AppMethodBeat.o(50991);
    return null;
  }
  
  public final void h(String paramString1, String paramString2, String paramString3, String paramString4)
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
      ad.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.joZ.getAppId() + "] path[" + paramString1 + ']');
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
      i.deleteFile(LW(paramString1));
      f.a((b)new WebRenderingCacheIPCOperations.c(), LX(paramString1));
      AppMethodBeat.o(50987);
      return;
      i = -1;
      break;
    }
    label259:
    localObject = (Map)this.lht;
    dz localdz = new dz();
    localdz.content = paramString2;
    localdz.Cyo = paramString3;
    localdz.Cyp = paramString4;
    paramString2 = LW(paramString1);
    try
    {
      i.B(paramString2, localdz.toByteArray());
      paramString3 = (b)new WebRenderingCacheIPCOperations.b();
      paramString4 = LX(paramString1);
      paramString4.filePath = paramString2;
      f.a(paramString3, paramString4);
      ((Map)localObject).put(paramString1, localdz);
      AppMethodBeat.o(50987);
      return;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.joZ.getAppId() + "] path[" + paramString1 + "] e=" + paramString2);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.g
 * JD-Core Version:    0.7.0.1
 */