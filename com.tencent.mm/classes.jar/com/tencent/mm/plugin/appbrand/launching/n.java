package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.plugin.appbrand.appcache.bh.b;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.a.e;
import d.g.a.q;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "makeResponse", "wxaPkgFilePath", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Companion", "Downloader", "plugin-appbrand-integration_release"})
public final class n
  implements y
{
  private static final WxaPkgLoadProgress kIn;
  @Deprecated
  public static final a kIo;
  private final d.g.a.b<WxaPkgLoadProgress, d.y> kHT;
  private final d.g.a.b<y.e, d.y> kIf;
  private final ab kIg;
  private bf kIh;
  private bb kIi;
  private final y.d kIj;
  private final d.g.a.m<y.a, String, d.y> kIk;
  private final z kIl;
  private final y.c kIm;
  
  static
  {
    AppMethodBeat.i(180517);
    kIo = new a((byte)0);
    kIn = new WxaPkgLoadProgress(0, 0L, 0L);
    AppMethodBeat.o(180517);
  }
  
  public n(y.d paramd, final d.g.a.b<? super y.e, d.y> paramb, d.g.a.m<? super y.a, ? super String, d.y> paramm, d.g.a.b<? super WxaPkgLoadProgress, d.y> paramb1, z paramz, y.c paramc)
  {
    AppMethodBeat.i(180516);
    this.kIj = paramd;
    this.kIk = paramm;
    this.kHT = paramb1;
    this.kIl = paramz;
    this.kIm = paramc;
    this.kIf = ((d.g.a.b)new c(this, paramb));
    this.kIg = this.kIj.bgB();
    AppMethodBeat.o(180516);
  }
  
  private final y.e a(String paramString, y.f paramf)
  {
    AppMethodBeat.i(180515);
    Object localObject = com.tencent.mm.cp.a.Igu;
    k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
    if (e.contains((int[])localObject, this.kIj.deP))
    {
      localObject = new WxaPluginPkgInfo();
      ((WxaPluginPkgInfo)localObject).pkgPath = paramString;
      ((WxaPluginPkgInfo)localObject).provider = this.kIj.appId;
      paramString = this.kIi;
      if (paramString == null) {
        k.aPZ("record");
      }
      ((WxaPluginPkgInfo)localObject).version = paramString.field_version;
      paramString = this.kIi;
      if (paramString == null) {
        k.aPZ("record");
      }
      ((WxaPluginPkgInfo)localObject).md5 = paramString.field_versionMd5;
      paramString = (bj)j.T(bj.class);
      String str = ((WxaPluginPkgInfo)localObject).provider;
      k.g(str, "provider");
      ((WxaPluginPkgInfo)localObject).stringVersion = paramString.aO(str, ((WxaPluginPkgInfo)localObject).version);
    }
    for (paramString = (IPkgInfo)localObject;; paramString = (IPkgInfo)localObject)
    {
      paramString = new y.e(paramString, paramf);
      AppMethodBeat.o(180515);
      return paramString;
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString;
      ((ModulePkgInfo)localObject).name = this.kIj.chK;
      paramString = this.kIi;
      if (paramString == null) {
        k.aPZ("record");
      }
      ((ModulePkgInfo)localObject).md5 = paramString.field_versionMd5;
    }
  }
  
  private final void bgu()
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(180513);
    Object localObject2 = this.kIm;
    if (localObject2 != null) {
      ((y.c)localObject2).b(this.kIj);
    }
    localObject2 = new z.b();
    ((z.b)localObject2).setAppId(this.kIj.appId);
    int i = this.kIj.deP;
    int[] arrayOfInt = com.tencent.mm.cp.a.Igv;
    k.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (e.contains(arrayOfInt, i)) {}
    for (;;)
    {
      ((z.b)localObject2).chK = ((String)localObject1);
      ((z.b)localObject2).deP = this.kIj.deP;
      ((z.b)localObject2).gXn = this.kIj.gXn;
      if (j.a.qD(this.kIj.gXn))
      {
        localObject1 = com.tencent.mm.cp.a.Igu;
        k.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.kIj.deP)) {
          break label354;
        }
        if (!((z.b)localObject2).kJI) {
          break;
        }
        localObject1 = m.bD(this.kIg.toString(), 0);
        if (localObject1 != null)
        {
          ((z.b)localObject2).kIJ = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          ((z.b)localObject2).kJG = WxaPkg.DZ(((WxaPkgWrappingInfo)localObject1).pkgPath());
        }
      }
      if (!this.kIj.kJy) {
        break label368;
      }
      i = j;
      label207:
      ((z.b)localObject2).kJG = i;
      localObject1 = this.kIj.kJx;
      if (!(localObject1 instanceof y.g.b)) {
        break label373;
      }
      ((z.b)localObject2).aAS = ((y.g.b)localObject1).version;
      label240:
      z.a.a(this.kIl, (z.b)localObject2, (d.g.a.b)new e(this, (z.b)localObject2), (q)new f(this));
      AppMethodBeat.o(180513);
      return;
      arrayOfInt = com.tencent.mm.cp.a.Igu;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (!e.contains(arrayOfInt, i)) {
        localObject1 = this.kIj.chK;
      }
    }
    if ((this.kIj.kJx instanceof y.g.b)) {}
    for (i = ((y.g.b)this.kIj.kJx).version;; i = 0)
    {
      localObject1 = m.bE(this.kIg.toString(), i);
      break;
      label354:
      localObject1 = m.Kg(this.kIg.toString());
      break;
      label368:
      i = 1;
      break label207;
      label373:
      ((z.b)localObject2).kJI = true;
      break label240;
    }
  }
  
  private final y.e g(bb parambb)
  {
    AppMethodBeat.i(180514);
    if (((this.kIj.kJx instanceof y.g.b)) && (j.a.qD(this.kIj.gXn)))
    {
      Object localObject = (CharSequence)parambb.field_versionMd5;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ad.e("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg record.md5 is EMPTY, request=" + this.kIj);
        AppMethodBeat.o(180514);
        return null;
      }
      localObject = m.a(this.kIg, this.kIj.gXn, ((y.g.b)this.kIj.kJx).version, parambb.field_versionMd5);
      if (localObject != null)
      {
        parambb = ay.aF(this.kIg.toString(), ((y.g.b)this.kIj.kJx).version);
        i.lC(((bb)localObject).field_pkgPath, parambb);
        localObject = this.kIh;
        if (localObject == null) {
          k.aPZ("storage");
        }
        ((bf)localObject).d(this.kIg.toString(), this.kIj.gXn, ((y.g.b)this.kIj.kJx).version, parambb);
        k.g(parambb, "targetPkgPath");
        parambb = a(parambb, y.f.kJC);
        AppMethodBeat.o(180514);
        return parambb;
      }
    }
    AppMethodBeat.o(180514);
    return null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(180512);
    Object localObject1 = j.aOK();
    if (localObject1 == null)
    {
      ((d.g.a.a)new d(this)).invoke();
      AppMethodBeat.o(180512);
      return;
    }
    this.kIh = ((bf)localObject1);
    if (((this.kIj.kJx instanceof y.g.b)) && (j.a.qD(this.kIj.gXn)))
    {
      localObject1 = this.kIh;
      if (localObject1 == null) {
        k.aPZ("storage");
      }
      localObject2 = ((bf)localObject1).a(this.kIg.toString(), ((y.g.b)this.kIj.kJx).version, this.kIj.gXn, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.cp.a.Igu;
        k.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.kIj.deP)) {
          break label241;
        }
        localObject1 = new bb();
        ((bb)localObject1).field_appId = this.kIg.toString();
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label246;
      }
      this.kIk.n(y.a.kJn, null);
      AppMethodBeat.o(180512);
      return;
      localObject1 = this.kIh;
      if (localObject1 == null) {
        k.aPZ("storage");
      }
      localObject2 = ((bf)localObject1).a(this.kIg.toString(), this.kIj.gXn, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        break;
        label241:
        localObject1 = null;
      }
    }
    label246:
    this.kIi = ((bb)localObject1);
    localObject1 = this.kIi;
    if (localObject1 == null) {
      k.aPZ("record");
    }
    localObject1 = (CharSequence)((bb)localObject1).field_versionMd5;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label340;
      }
      ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.md5 is EMPTY, will download with request " + this.kIj);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label482;
      }
      bgu();
      AppMethodBeat.o(180512);
      return;
      i = 0;
      break;
      label340:
      localObject1 = this.kIi;
      if (localObject1 == null) {
        k.aPZ("record");
      }
      localObject1 = (CharSequence)((bb)localObject1).field_pkgPath;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label417;
        }
        ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.path is EMPTY, will download with request " + this.kIj);
        i = 1;
        break;
      }
      label417:
      if (((this.kIj.kJx instanceof y.g.a)) && (((y.g.a)this.kIj.kJx).kJF))
      {
        ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(forceUpdate) requested, will download with request " + this.kIj);
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    label482:
    localObject1 = this.kIi;
    if (localObject1 == null) {
      k.aPZ("record");
    }
    localObject1 = WxaPkgIntegrityChecker.Eg(((bb)localObject1).field_pkgPath);
    Object localObject2 = this.kIi;
    if (localObject2 == null) {
      k.aPZ("record");
    }
    if (k.g(((bb)localObject2).field_versionMd5, localObject1))
    {
      if (this.kIj.kJy)
      {
        localObject1 = this.kIi;
        if (localObject1 == null) {
          k.aPZ("record");
        }
        if (WxaPkg.DZ(((bb)localObject1).field_pkgPath) > 0)
        {
          ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "pkg cached, but forceNoEncrypt, waitForDownload instead, request=" + this.kIj);
          bgu();
          AppMethodBeat.o(180512);
          return;
        }
      }
      ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "pkg cached, invoke onSuccess, request=" + this.kIj);
      localObject1 = this.kIf;
      localObject2 = this.kIi;
      if (localObject2 == null) {
        k.aPZ("record");
      }
      localObject2 = ((bb)localObject2).field_pkgPath;
      k.g(localObject2, "record.field_pkgPath");
      ((d.g.a.b)localObject1).aA(a((String)localObject2, y.f.kJC));
      AppMethodBeat.o(180512);
      return;
    }
    localObject2 = this.kIi;
    if (localObject2 == null) {
      k.aPZ("record");
    }
    if (i.eK(((bb)localObject2).field_pkgPath))
    {
      localObject1 = new StringBuilder("start() check existed pkg fileMd5(").append((String)localObject1).append(")!=recordMd5(");
      localObject2 = this.kIi;
      if (localObject2 == null) {
        k.aPZ("record");
      }
      ad.e("MicroMsg.AppBrand.CommonPkgFetcher", ((bb)localObject2).field_versionMd5 + "), request=" + this.kIj);
    }
    localObject1 = this.kIi;
    if (localObject1 == null) {
      k.aPZ("record");
    }
    localObject1 = g((bb)localObject1);
    if (localObject1 != null)
    {
      ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "pkg cached by reuse logic, request=" + this.kIj);
      this.kIf.aA(localObject1);
      AppMethodBeat.o(180512);
      return;
    }
    ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "no cached pkg, will download with request " + this.kIj);
    bgu();
    AppMethodBeat.o(180512);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Companion;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$IWxaPkgUpdateCallback;", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V", "plugin-appbrand-integration_release"})
  final class b
    implements bh.a
  {
    public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      AppMethodBeat.i(180503);
      k.h(paramWxaPkgLoadProgress, "progressInfo");
      n.a(this.kIp).aA(paramWxaPkgLoadProgress);
      AppMethodBeat.o(180503);
    }
    
    public final void a(String paramString, b.a.a parama, bh.b paramb)
    {
      AppMethodBeat.i(180505);
      k.h(paramString, "appId");
      k.h(parama, "errCode");
      if (b.a.a.iPs == parama)
      {
        paramString = n.d(this.kIp);
        parama = this.kIp;
        if (paramb == null) {
          k.fvU();
        }
        paramb = paramb.filePath;
        k.g(paramb, "response!!.filePath");
        paramString.aA(n.a(parama, paramb, y.f.kJD));
        AppMethodBeat.o(180505);
        return;
      }
      n.b(this.kIp).n(n.a(parama), null);
      AppMethodBeat.o(180505);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      implements Runnable
    {
      a(n.b paramb, z.b paramb1, atf[] paramArrayOfatf) {}
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<d.y>
      {
        a(n.b.a parama)
        {
          super();
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<y.e, d.y>
  {
    c(n paramn, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    d(n paramn)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<atf[], d.y>
  {
    e(n paramn, z.b paramb)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      a(n.e parame)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements q<Integer, Integer, String, d.y>
  {
    f(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.n
 * JD-Core Version:    0.7.0.1
 */