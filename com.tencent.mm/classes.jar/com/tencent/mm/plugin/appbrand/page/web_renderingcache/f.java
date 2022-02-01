package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements a
{
  public static final f.a tDs;
  private final boolean enabled;
  private final w qxC;
  private final String tDp;
  private final String tDq;
  private final String tDt;
  private final ConcurrentHashMap<String, fj> tDu;
  
  static
  {
    AppMethodBeat.i(50993);
    tDs = new f.a((byte)0);
    AppMethodBeat.o(50993);
  }
  
  private f(w paramw)
  {
    AppMethodBeat.i(50992);
    this.qxC = paramw;
    paramw = this.qxC.cbl().cfE();
    s.s(paramw, "runtime.libReader.versionBuildInfo()");
    this.tDp = paramw;
    label105:
    int i;
    switch (this.qxC.qsh.eul)
    {
    default: 
      paramw = String.valueOf(this.qxC.asw());
      this.tDq = paramw;
      paramw = this.qxC.getInitConfig().qYl;
      if (paramw == null)
      {
        paramw = null;
        CharSequence localCharSequence = (CharSequence)paramw;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label177;
        }
        i = 1;
        label125:
        if (i == 0) {
          break label182;
        }
        this.enabled = false;
      }
      break;
    }
    for (this.tDt = "";; this.tDt = (paramw + '_' + this.tDp.hashCode() + '_' + this.tDq))
    {
      this.tDu = new ConcurrentHashMap();
      AppMethodBeat.o(50992);
      return;
      paramw = "TEST";
      break;
      paramw = "DEMO";
      break;
      paramw = paramw.tDl;
      break label105;
      label177:
      i = 0;
      break label125;
      label182:
      this.enabled = true;
    }
  }
  
  public static final f O(w paramw)
  {
    AppMethodBeat.i(325212);
    s.u(paramw, "rt");
    if (paramw.cbl() == null)
    {
      Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", s.X("try create provider but rt.libReader is NULL, appId:", paramw.mAppId));
      AppMethodBeat.o(325212);
      return null;
    }
    paramw = new f(paramw, (byte)0);
    AppMethodBeat.o(325212);
    return paramw;
  }
  
  private final String afg(String paramString)
  {
    AppMethodBeat.i(50985);
    StringBuilder localStringBuilder = new StringBuilder().append(this.tDt).append('_');
    paramString = URLEncoder.encode(paramString, "UTF-8");
    s.s(paramString, "encode(this, \"UTF-8\")");
    paramString = paramString + ".rc";
    AppMethodBeat.o(50985);
    return paramString;
  }
  
  private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel afh(String paramString)
  {
    AppMethodBeat.i(50986);
    String str = this.qxC.mAppId;
    s.s(str, "runtime.appId");
    paramString = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(str, this.tDp, this.tDq, paramString);
    AppMethodBeat.o(50986);
    return paramString;
  }
  
  private final fj afi(String paramString)
  {
    AppMethodBeat.i(50988);
    fj localfj2 = (fj)this.tDu.get(paramString);
    fj localfj1 = localfj2;
    String str;
    int i;
    if (localfj2 == null)
    {
      str = afg(paramString);
      long l = y.bEl(str);
      localfj1 = localfj2;
      if (l > 0L)
      {
        localfj1 = new fj();
        i = (int)l;
      }
    }
    try
    {
      localfj1.parseFrom(y.bi(str, 0, i));
      ((Map)this.tDu).put(paramString, localfj1);
      AppMethodBeat.o(50988);
      return localfj1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.deleteFile(str);
      }
    }
  }
  
  public final String afd(String paramString)
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
    Object localObject = afi(paramString);
    if (localObject == null)
    {
      localObject = (CharSequence)str;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label129;
      }
    }
    label129:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        e.a((d)new WebRenderingCacheIPCOperations.a(), afh(paramString));
      }
      AppMethodBeat.o(50989);
      return str;
      str = ((fj)localObject).content;
      break;
    }
  }
  
  public final String afe(String paramString)
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
    paramString = afi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(50990);
      return null;
    }
    paramString = paramString.YGS;
    AppMethodBeat.o(50990);
    return paramString;
  }
  
  public final String aff(String paramString)
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
    paramString = afi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(50991);
      return null;
    }
    paramString = paramString.YGT;
    AppMethodBeat.o(50991);
    return paramString;
  }
  
  public final void k(String paramString1, String paramString2, String paramString3, String paramString4)
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
      Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.qxC.mAppId + "] path[" + paramString1 + ']');
      AppMethodBeat.o(50987);
      return;
    }
    Object localObject = new StringBuilder("save path[").append(paramString1).append("] content[");
    if (paramString2 == null)
    {
      i = -1;
      localObject = ((StringBuilder)localObject).append(i).append("] webviewData[");
      if (paramString3 != null) {
        break label243;
      }
      i = -1;
      label152:
      localObject = ((StringBuilder)localObject).append(i).append("] serviceData[");
      if (paramString4 != null) {
        break label252;
      }
    }
    label243:
    label252:
    for (i = j;; i = paramString4.length())
    {
      Log.i("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", i + ']');
      if (paramString2 != null) {
        break label262;
      }
      y.deleteFile(afg(paramString1));
      e.a((d)new WebRenderingCacheIPCOperations.c(), afh(paramString1));
      AppMethodBeat.o(50987);
      return;
      i = paramString2.length();
      break;
      i = paramString3.length();
      break label152;
    }
    label262:
    localObject = (Map)this.tDu;
    fj localfj = new fj();
    localfj.content = paramString2;
    localfj.YGS = paramString3;
    localfj.YGT = paramString4;
    paramString2 = afg(paramString1);
    try
    {
      paramString3 = localfj.toByteArray();
      y.f(paramString2, paramString3, paramString3.length);
      paramString3 = (d)new WebRenderingCacheIPCOperations.b();
      paramString4 = afh(paramString1);
      paramString4.filePath = paramString2;
      paramString2 = ah.aiuX;
      e.a(paramString3, paramString4);
      ((Map)localObject).put(paramString1, localfj);
      AppMethodBeat.o(50987);
      return;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.qxC.mAppId + "] path[" + paramString1 + "] e=" + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.f
 * JD-Core Version:    0.7.0.1
 */