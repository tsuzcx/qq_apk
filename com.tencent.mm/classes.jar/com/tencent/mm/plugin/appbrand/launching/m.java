package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq.a;
import com.tencent.mm.plugin.appbrand.appcache.bs;
import com.tencent.mm.plugin.appbrand.appcache.bx;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import kotlin.a.e;
import kotlin.f;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "getStorage", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "storage$delegate", "Lkotlin/Lazy;", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Downloader", "Factory", "ResponseAssembler", "plugin-appbrand-integration_release"})
public final class m
  implements w
{
  private static final WxaPkgLoadProgress pUc;
  @Deprecated
  public static final b pUd;
  private final ack pTH;
  private final kotlin.g.a.b<WxaPkgLoadProgress, kotlin.x> pTK;
  final kotlin.g.a.b<w.e, kotlin.x> pTV;
  final ae pTW;
  private final f pTX;
  final w.d pTY;
  final kotlin.g.a.m<w.a, String, kotlin.x> pTZ;
  private final x pUa;
  private final w.c pUb;
  
  static
  {
    AppMethodBeat.i(180517);
    pUd = new b((byte)0);
    pUc = new WxaPkgLoadProgress(0, 0L, 0L);
    AppMethodBeat.o(180517);
  }
  
  public m(w.d paramd, final kotlin.g.a.b<? super w.e, kotlin.x> paramb, kotlin.g.a.m<? super w.a, ? super String, kotlin.x> paramm, kotlin.g.a.b<? super WxaPkgLoadProgress, kotlin.x> paramb1, x paramx, ack paramack, w.c paramc)
  {
    AppMethodBeat.i(273241);
    this.pTY = paramd;
    this.pTZ = paramm;
    this.pTK = paramb1;
    this.pUa = paramx;
    this.pTH = paramack;
    this.pUb = paramc;
    this.pTV = ((kotlin.g.a.b)new d(this, paramb));
    this.pTW = this.pTY.bZS();
    this.pTX = kotlin.g.ar((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(273241);
  }
  
  final s<? extends com.tencent.mm.plugin.appbrand.appcache.g> bZL()
  {
    AppMethodBeat.i(273239);
    s locals = (s)this.pTX.getValue();
    AppMethodBeat.o(273239);
    return locals;
  }
  
  final void bZM()
  {
    Object localObject1 = null;
    AppMethodBeat.i(180513);
    Object localObject2 = this.pUb;
    if (localObject2 != null) {
      ((w.c)localObject2).b(this.pTY);
    }
    localObject2 = new x.a();
    ((x.a)localObject2).setAppId(this.pTY.appId);
    int i = this.pTY.fyH;
    int[] arrayOfInt = com.tencent.mm.cx.a.YYC;
    p.j(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (e.contains(arrayOfInt, i)) {}
    for (;;)
    {
      ((x.a)localObject2).cAy = ((String)localObject1);
      ((x.a)localObject2).fyH = this.pTY.fyH;
      ((x.a)localObject2).cBU = this.pTY.cBU;
      if (j.a.za(this.pTY.cBU))
      {
        localObject1 = com.tencent.mm.cx.a.YYB;
        p.j(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.pTY.fyH)) {
          break label344;
        }
        if (!((x.a)localObject2).pVv) {
          break;
        }
        localObject1 = l.cq(this.pTW.toString(), 0);
        if (localObject1 != null)
        {
          ((x.a)localObject2).pVt = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          ((x.a)localObject2).pVs = WxaPkg.acQ(((WxaPkgWrappingInfo)localObject1).pkgPath());
        }
      }
      if (!this.pTY.pVl) {
        break label358;
      }
      i = 0;
      label194:
      ((x.a)localObject2).pVs = i;
      localObject1 = this.pTY.pVk;
      if (!(localObject1 instanceof w.g.c)) {
        break label363;
      }
      ((x.a)localObject2).appVersion = ((w.g.c)localObject1).version;
      label225:
      this.pUa.a((x.a)localObject2, (kotlin.g.a.b)new f(this, (x.a)localObject2), (kotlin.g.a.q)new g(this), 0, this.pTH);
      AppMethodBeat.o(180513);
      return;
      arrayOfInt = com.tencent.mm.cx.a.YYB;
      p.j(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (!e.contains(arrayOfInt, i)) {
        localObject1 = this.pTY.cAy;
      }
    }
    if ((this.pTY.pVk instanceof w.g.c)) {}
    for (i = ((w.g.c)this.pTY.pVk).version;; i = 0)
    {
      localObject1 = l.cr(this.pTW.toString(), i);
      break;
      label344:
      localObject1 = l.ajV(this.pTW.toString());
      break;
      label358:
      i = 1;
      break label194;
      label363:
      if ((localObject1 instanceof w.g.b))
      {
        ((x.a)localObject2).appVersion = ((w.g.b)localObject1).version;
        ((x.a)localObject2).pVv = true;
        break label225;
      }
      if (!(localObject1 instanceof w.g.a)) {
        break label225;
      }
      ((x.a)localObject2).appVersion = 0;
      ((x.a)localObject2).nGm = ((w.g.a)localObject1).desc;
      break label225;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "pkgChecksumMd5", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;Ljava/lang/String;)V", "plugin-appbrand-integration_release"})
  final class a
  {
    public final void a(final x.a parama, final btv[] paramArrayOfbtv, final String paramString)
    {
      AppMethodBeat.i(276734);
      p.k(parama, "request");
      p.k(paramArrayOfbtv, "urls");
      m.bZO();
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, print urls --START--");
      int k = paramArrayOfbtv.length;
      int j = 0;
      int i = 0;
      if (j < k)
      {
        btv localbtv = paramArrayOfbtv[j];
        m.bZO();
        StringBuilder localStringBuilder = new StringBuilder("Downloader.start, print url, index:").append(i).append(", item:{url:");
        if (localbtv != null)
        {
          localObject = localbtv.url;
          label88:
          localStringBuilder = localStringBuilder.append((String)localObject).append(", md5:");
          if (localbtv == null) {
            break label236;
          }
          localObject = localbtv.md5;
          label114:
          localStringBuilder = localStringBuilder.append((String)localObject).append(", app_version:");
          if (localbtv == null) {
            break label242;
          }
          localObject = Integer.valueOf(localbtv.RYM);
          label143:
          localObject = localStringBuilder.append(localObject).append(", is_patch:");
          if (localbtv == null) {
            break label248;
          }
          bool = localbtv.TdU;
          label169:
          localObject = ((StringBuilder)localObject).append(bool).append(", is_zstd:");
          if (localbtv == null) {
            break label254;
          }
        }
        label236:
        label242:
        label248:
        label254:
        for (boolean bool = localbtv.TdV;; bool = false)
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", bool + '}');
          j += 1;
          i += 1;
          break;
          localObject = null;
          break label88;
          localObject = null;
          break label114;
          localObject = null;
          break label143;
          bool = false;
          break label169;
        }
      }
      m.bZO();
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, print urls --END--");
      Object localObject = m.a(this.pUe);
      m.bZO();
      ((kotlin.g.a.b)localObject).invoke(m.bZN());
      d.LOGIC.arrange((Runnable)new a(this, parama, paramArrayOfbtv, paramString));
      AppMethodBeat.o(276734);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      implements Runnable
    {
      a(m.a parama, x.a parama1, btv[] paramArrayOfbtv, String paramString) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Factory;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "FOR", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "QUERY_FACTORY", "storage", "key", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "versionType", "", "version", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "RECORD_FACTORY", "plugin-appbrand-integration_release"})
  static final class b {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "plugin-appbrand-integration_release"})
  static final class c
  {
    public static final c pUq;
    
    static
    {
      AppMethodBeat.i(280371);
      pUq = new c();
      AppMethodBeat.o(280371);
    }
    
    public static w.e a(final s<?> params, final w.d paramd, com.tencent.mm.plugin.appbrand.appcache.g paramg)
    {
      AppMethodBeat.i(280368);
      p.k(params, "storage");
      p.k(paramd, "request");
      p.k(paramg, "record");
      if (!(params instanceof bm))
      {
        AppMethodBeat.o(280368);
        return null;
      }
      Object localObject2 = paramd.bZS();
      if (((paramd.pVk instanceof w.g.c)) && (j.a.za(paramd.cBU)))
      {
        Object localObject1 = (CharSequence)paramg.field_versionMd5;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label158;
          }
          localObject1 = (CharSequence)paramg.field_NewMd5;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label153;
          }
        }
        label153:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label158;
          }
          m.bZO();
          Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg record.md5 is EMPTY, request=".concat(String.valueOf(paramd)));
          AppMethodBeat.o(280368);
          return null;
          i = 0;
          break;
        }
        label158:
        localObject1 = new a((ae)localObject2, paramd, params);
        params = l.a((ae)localObject2, paramd.cBU, ((w.g.c)paramd.pVk).version, new String[] { paramg.field_versionMd5, paramg.field_NewMd5 });
        if (params != null)
        {
          params = params.field_pkgPath;
          p.j(params, "reusable.field_pkgPath");
          params = a(paramd, ((a)localObject1).invoke(params), null, ((w.g.c)paramd.pVk).version, (w.f)new w.f.a(1));
          AppMethodBeat.o(280368);
          return params;
        }
        params = Long.valueOf(((w.g.c)paramd.pVk).obN);
        label296:
        long l;
        if (((Number)params).longValue() >= 0L)
        {
          i = 1;
          if (i == 0) {
            break label554;
          }
          if (params == null) {
            break label569;
          }
          l = ((Number)params).longValue();
          paramg = ((Iterable)((bx)com.tencent.mm.plugin.appbrand.app.m.W(bx.class)).c(l, paramg.field_versionMd5, paramg.field_NewMd5)).iterator();
        }
        label386:
        label554:
        label564:
        label567:
        for (;;)
        {
          if (!paramg.hasNext()) {
            break label569;
          }
          localObject2 = (bh)paramg.next();
          if (u.agG(((bh)localObject2).field_pkgPath))
          {
            params = WxaPkgWrappingInfo.n(new com.tencent.mm.vfs.q(((bh)localObject2).field_pkgPath));
            CharSequence localCharSequence = (CharSequence)params;
            if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
              break label564;
            }
          }
          for (i = 1;; i = 0)
          {
            if ((i != 0) || ((!p.h(params, ((bh)localObject2).field_versionMd5)) && (!p.h(params, ((bh)localObject2).field_NewMd5)))) {
              break label567;
            }
            m.bZO();
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg matched pkg for templateId:" + l + ", appId:" + paramd.appId + ", appVersion:" + paramd.pVk + ", fileMd5:" + params);
            paramg = ((bh)localObject2).field_pkgPath;
            p.j(paramg, "templateRecord.field_pkgPath");
            params = a(paramd, ((a)localObject1).invoke(paramg), params, ((w.g.c)paramd.pVk).version, (w.f)new w.f.a(2));
            AppMethodBeat.o(280368);
            return params;
            i = 0;
            break;
            params = null;
            break label296;
            params = null;
            break label386;
          }
        }
      }
      label569:
      AppMethodBeat.o(280368);
      return null;
    }
    
    public static w.e a(w.d paramd, String paramString1, String paramString2, int paramInt, w.f paramf)
    {
      int i = 0;
      AppMethodBeat.i(280370);
      p.k(paramd, "request");
      p.k(paramString1, "wxaPkgFilePath");
      p.k(paramf, "source");
      Object localObject = com.tencent.mm.cx.a.YYB;
      p.j(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.fyH))
      {
        localObject = new WxaPluginPkgInfo();
        ((WxaPluginPkgInfo)localObject).pkgPath = paramString1;
        ((WxaPluginPkgInfo)localObject).provider = paramd.appId;
        ((WxaPluginPkgInfo)localObject).version = paramInt;
        paramd = (CharSequence)paramString2;
        if (paramd != null)
        {
          paramInt = i;
          if (paramd.length() != 0) {}
        }
        else
        {
          paramInt = 1;
        }
        if (paramInt != 0) {
          paramString2 = WxaPkgIntegrityChecker.acX(paramString1);
        }
        ((WxaPluginPkgInfo)localObject).md5 = paramString2;
        paramd = (bs)com.tencent.mm.plugin.appbrand.app.m.W(bs.class);
        paramString1 = ((WxaPluginPkgInfo)localObject).provider;
        p.j(paramString1, "provider");
        ((WxaPluginPkgInfo)localObject).stringVersion = paramd.bs(paramString1, ((WxaPluginPkgInfo)localObject).version);
        paramd = (IPkgInfo)localObject;
        paramd = new w.e(paramd, paramf);
        AppMethodBeat.o(280370);
        return paramd;
      }
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString1;
      ((ModulePkgInfo)localObject).name = paramd.cAy;
      paramd = (CharSequence)paramString2;
      if ((paramd == null) || (paramd.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paramString2 = WxaPkgIntegrityChecker.acX(paramString1);
        }
        ((ModulePkgInfo)localObject).md5 = paramString2;
        ((ModulePkgInfo)localObject).pkgVersion = paramInt;
        paramd = (IPkgInfo)localObject;
        break;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"copySharedFileToTargetPath", "", "sharedFile", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<String, String>
    {
      a(ae paramae, w.d paramd, s params)
      {
        super();
      }
      
      public final String invoke(String paramString)
      {
        AppMethodBeat.i(269614);
        p.k(paramString, "sharedFile");
        String str = bd.bl(this.pUr.toString(), ((w.g.c)paramd.pVk).version);
        u.on(paramString, str);
        ((bm)params).f(this.pUr.toString(), paramd.cBU, ((w.g.c)paramd.pVk).version, str);
        p.j(str, "targetPkgPath");
        AppMethodBeat.o(269614);
        return str;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<w.e, kotlin.x>
  {
    d(m paramm, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<s<? extends com.tencent.mm.plugin.appbrand.appcache.g>>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<btv[], kotlin.x>
  {
    f(m paramm, x.a parama)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(m.f paramf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, String, kotlin.x>
  {
    g(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m
 * JD-Core Version:    0.7.0.1
 */