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
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi.a;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.a.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Companion", "Downloader", "ResponseAssembler", "plugin-appbrand-integration_release"})
public final class n
  implements y
{
  private static final WxaPkgLoadProgress lGP;
  @Deprecated
  public static final a lGQ;
  private final d.g.a.b<y.e, d.z> lGH;
  private final ac lGI;
  private bg lGJ;
  private bc lGK;
  private final y.d lGL;
  private final d.g.a.m<y.a, String, d.z> lGM;
  private final z lGN;
  private final y.c lGO;
  private final d.g.a.b<WxaPkgLoadProgress, d.z> lGu;
  
  static
  {
    AppMethodBeat.i(180517);
    lGQ = new a((byte)0);
    lGP = new WxaPkgLoadProgress(0, 0L, 0L);
    AppMethodBeat.o(180517);
  }
  
  public n(y.d paramd, final d.g.a.b<? super y.e, d.z> paramb, d.g.a.m<? super y.a, ? super String, d.z> paramm, d.g.a.b<? super WxaPkgLoadProgress, d.z> paramb1, z paramz, y.c paramc)
  {
    AppMethodBeat.i(180516);
    this.lGL = paramd;
    this.lGM = paramm;
    this.lGu = paramb1;
    this.lGN = paramz;
    this.lGO = paramc;
    this.lGH = ((d.g.a.b)new d(this, paramb));
    this.lGI = this.lGL.brh();
    AppMethodBeat.o(180516);
  }
  
  private final void bra()
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(180513);
    Object localObject2 = this.lGO;
    if (localObject2 != null) {
      ((y.c)localObject2).b(this.lGL);
    }
    localObject2 = new z.b();
    ((z.b)localObject2).setAppId(this.lGL.appId);
    int i = this.lGL.dnF;
    int[] arrayOfInt = com.tencent.mm.co.a.LBb;
    p.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (e.contains(arrayOfInt, i)) {}
    for (;;)
    {
      ((z.b)localObject2).coW = ((String)localObject1);
      ((z.b)localObject2).dnF = this.lGL.dnF;
      ((z.b)localObject2).hQh = this.lGL.hQh;
      if (j.a.rQ(this.lGL.hQh))
      {
        localObject1 = com.tencent.mm.co.a.LBa;
        p.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.lGL.dnF)) {
          break label351;
        }
        if (!((z.b)localObject2).lIm) {
          break;
        }
        localObject1 = m.bK(this.lGI.toString(), 0);
        if (localObject1 != null)
        {
          ((z.b)localObject2).lHn = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          ((z.b)localObject2).lIk = WxaPkg.Lu(((WxaPkgWrappingInfo)localObject1).pkgPath());
        }
      }
      if (!this.lGL.lIc) {
        break label365;
      }
      i = j;
      label205:
      ((z.b)localObject2).lIk = i;
      localObject1 = this.lGL.lIb;
      if (!(localObject1 instanceof y.g.b)) {
        break label370;
      }
      ((z.b)localObject2).aDD = ((y.g.b)localObject1).version;
      label238:
      z.a.a(this.lGN, (z.b)localObject2, (d.g.a.b)new f(this, (z.b)localObject2), (d.g.a.q)new g(this));
      AppMethodBeat.o(180513);
      return;
      arrayOfInt = com.tencent.mm.co.a.LBa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (!e.contains(arrayOfInt, i)) {
        localObject1 = this.lGL.coW;
      }
    }
    if ((this.lGL.lIb instanceof y.g.b)) {}
    for (i = ((y.g.b)this.lGL.lIb).version;; i = 0)
    {
      localObject1 = m.bL(this.lGI.toString(), i);
      break;
      label351:
      localObject1 = m.RL(this.lGI.toString());
      break;
      label365:
      i = 1;
      break label205;
      label370:
      if (!(localObject1 instanceof y.g.a)) {
        break label238;
      }
      ((z.b)localObject2).aDD = ((y.g.a)localObject1).version;
      ((z.b)localObject2).lIm = true;
      break label238;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(180512);
    Object localObject1 = j.aYX();
    if (localObject1 == null)
    {
      ((d.g.a.a)new e(this)).invoke();
      AppMethodBeat.o(180512);
      return;
    }
    this.lGJ = ((bg)localObject1);
    if (((this.lGL.lIb instanceof y.g.b)) && (j.a.rQ(this.lGL.hQh)))
    {
      localObject1 = this.lGJ;
      if (localObject1 == null) {
        p.bcb("storage");
      }
      localObject2 = ((bg)localObject1).a(this.lGI.toString(), ((y.g.b)this.lGL.lIb).version, this.lGL.hQh, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.co.a.LBa;
        p.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.lGL.dnF)) {
          break label241;
        }
        localObject1 = new bc();
        ((bc)localObject1).field_appId = this.lGI.toString();
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label246;
      }
      this.lGM.p(y.a.lHR, null);
      AppMethodBeat.o(180512);
      return;
      localObject1 = this.lGJ;
      if (localObject1 == null) {
        p.bcb("storage");
      }
      localObject2 = ((bg)localObject1).a(this.lGI.toString(), this.lGL.hQh, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        break;
        label241:
        localObject1 = null;
      }
    }
    label246:
    this.lGK = ((bc)localObject1);
    localObject1 = this.lGK;
    if (localObject1 == null) {
      p.bcb("record");
    }
    localObject1 = (CharSequence)((bc)localObject1).field_versionMd5;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label341;
      }
      ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.md5 is EMPTY, will download with request " + this.lGL);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label484;
      }
      bra();
      AppMethodBeat.o(180512);
      return;
      i = 0;
      break;
      label341:
      localObject1 = this.lGK;
      if (localObject1 == null) {
        p.bcb("record");
      }
      localObject1 = (CharSequence)((bc)localObject1).field_pkgPath;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label419;
        }
        ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.path is EMPTY, will download with request " + this.lGL);
        i = 1;
        break;
      }
      label419:
      if (((this.lGL.lIb instanceof y.g.a)) && (((y.g.a)this.lGL.lIb).lIj))
      {
        ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(forceUpdate) requested, will download with request " + this.lGL);
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    label484:
    localObject1 = this.lGK;
    if (localObject1 == null) {
      p.bcb("record");
    }
    localObject1 = WxaPkgIntegrityChecker.LB(((bc)localObject1).field_pkgPath);
    Object localObject2 = this.lGK;
    if (localObject2 == null) {
      p.bcb("record");
    }
    Object localObject3;
    Object localObject4;
    bc localbc;
    if (p.i(((bc)localObject2).field_versionMd5, localObject1))
    {
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1; i == 0; i = 0)
      {
        ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with LegacyMd5, invoke onSuccess, request=" + this.lGL);
        localObject1 = this.lGH;
        localObject2 = c.lHc;
        localObject2 = this.lGL;
        localObject3 = this.lGK;
        if (localObject3 == null) {
          p.bcb("record");
        }
        localObject3 = ((bc)localObject3).field_pkgPath;
        p.g(localObject3, "record.field_pkgPath");
        localObject4 = this.lGK;
        if (localObject4 == null) {
          p.bcb("record");
        }
        localObject4 = ((bc)localObject4).field_versionMd5;
        localbc = this.lGK;
        if (localbc == null) {
          p.bcb("record");
        }
        ((d.g.a.b)localObject1).invoke(c.a((y.d)localObject2, (String)localObject3, (String)localObject4, localbc.field_version, y.f.lIg));
        AppMethodBeat.o(180512);
        return;
      }
    }
    localObject2 = this.lGK;
    if (localObject2 == null) {
      p.bcb("record");
    }
    if (p.i(((bc)localObject2).field_NewMd5, localObject1))
    {
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
        i = 1;
      }
      while (i == 0)
      {
        if (this.lGL.lIc)
        {
          localObject1 = this.lGK;
          if (localObject1 == null) {
            p.bcb("record");
          }
          if (WxaPkg.Lu(((bc)localObject1).field_pkgPath) > 0)
          {
            ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=" + this.lGL);
            bra();
            AppMethodBeat.o(180512);
            return;
            i = 0;
            continue;
          }
        }
        ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, invoke onSuccess, request=" + this.lGL);
        localObject1 = this.lGH;
        localObject2 = c.lHc;
        localObject2 = this.lGL;
        localObject3 = this.lGK;
        if (localObject3 == null) {
          p.bcb("record");
        }
        localObject3 = ((bc)localObject3).field_pkgPath;
        p.g(localObject3, "record.field_pkgPath");
        localObject4 = this.lGK;
        if (localObject4 == null) {
          p.bcb("record");
        }
        localObject4 = ((bc)localObject4).field_NewMd5;
        localbc = this.lGK;
        if (localbc == null) {
          p.bcb("record");
        }
        ((d.g.a.b)localObject1).invoke(c.a((y.d)localObject2, (String)localObject3, (String)localObject4, localbc.field_version, y.f.lIg));
        AppMethodBeat.o(180512);
        return;
      }
    }
    localObject2 = this.lGK;
    if (localObject2 == null) {
      p.bcb("record");
    }
    if (i.fv(((bc)localObject2).field_pkgPath))
    {
      localObject1 = new StringBuilder("start(), check existed pkg fileMd5(").append((String)localObject1).append(")!=recordMd5(");
      localObject2 = this.lGK;
      if (localObject2 == null) {
        p.bcb("record");
      }
      localObject1 = ((StringBuilder)localObject1).append(((bc)localObject2).field_versionMd5).append('|');
      localObject2 = this.lGK;
      if (localObject2 == null) {
        p.bcb("record");
      }
      ad.e("MicroMsg.AppBrand.CommonPkgFetcher", ((bc)localObject2).field_NewMd5 + "), request=" + this.lGL);
    }
    localObject1 = c.lHc;
    localObject1 = this.lGL;
    localObject2 = this.lGK;
    if (localObject2 == null) {
      p.bcb("record");
    }
    localObject1 = c.a((y.d)localObject1, (bc)localObject2);
    if (localObject1 != null)
    {
      ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached by reuse logic, request=" + this.lGL);
      this.lGH.invoke(localObject1);
      AppMethodBeat.o(180512);
      return;
    }
    ad.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), no cached pkg, will download with request " + this.lGL);
    bra();
    AppMethodBeat.o(180512);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Companion;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V", "plugin-appbrand-integration_release"})
  final class b
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      implements Runnable
    {
      a(n.b paramb, z.b paramb1, bah[] paramArrayOfbah) {}
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
      static final class a
        extends d.g.b.q
        implements d.g.a.a<d.z>
      {
        a(n.b.a parama)
        {
          super();
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "plugin-appbrand-integration_release"})
  static final class c
  {
    public static final c lHc;
    
    static
    {
      AppMethodBeat.i(189255);
      lHc = new c();
      AppMethodBeat.o(189255);
    }
    
    public static y.e a(y.d paramd, bc parambc)
    {
      AppMethodBeat.i(189253);
      p.h(paramd, "request");
      p.h(parambc, "record");
      ac localac = paramd.brh();
      bg localbg = j.aYX();
      if (((paramd.lIb instanceof y.g.b)) && (j.a.rQ(paramd.hQh)))
      {
        Object localObject = (CharSequence)parambc.field_versionMd5;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          n.brc();
          ad.e("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg record.md5 is EMPTY, request=".concat(String.valueOf(paramd)));
          AppMethodBeat.o(189253);
          return null;
        }
        parambc = m.a(localac, paramd.hQh, ((y.g.b)paramd.lIb).version, new String[] { parambc.field_versionMd5, parambc.field_NewMd5 });
        if (parambc != null)
        {
          localObject = az.aL(localac.toString(), ((y.g.b)paramd.lIb).version);
          i.mz(parambc.field_pkgPath, (String)localObject);
          localbg.e(localac.toString(), paramd.hQh, ((y.g.b)paramd.lIb).version, (String)localObject);
          p.g(localObject, "targetPkgPath");
          paramd = a(paramd, (String)localObject, null, ((y.g.b)paramd.lIb).version, y.f.lIg);
          AppMethodBeat.o(189253);
          return paramd;
        }
      }
      AppMethodBeat.o(189253);
      return null;
    }
    
    public static y.e a(y.d paramd, String paramString1, String paramString2, int paramInt, y.f paramf)
    {
      int i = 0;
      AppMethodBeat.i(189254);
      p.h(paramd, "request");
      p.h(paramString1, "wxaPkgFilePath");
      p.h(paramf, "source");
      Object localObject = com.tencent.mm.co.a.LBa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.dnF))
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
          paramString2 = WxaPkgIntegrityChecker.LB(paramString1);
        }
        ((WxaPluginPkgInfo)localObject).md5 = paramString2;
        paramd = (bk)j.T(bk.class);
        paramString1 = ((WxaPluginPkgInfo)localObject).provider;
        p.g(paramString1, "provider");
        ((WxaPluginPkgInfo)localObject).stringVersion = paramd.aU(paramString1, ((WxaPluginPkgInfo)localObject).version);
        paramd = (IPkgInfo)localObject;
        paramd = new y.e(paramd, paramf);
        AppMethodBeat.o(189254);
        return paramd;
      }
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString1;
      ((ModulePkgInfo)localObject).name = paramd.coW;
      paramd = (CharSequence)paramString2;
      if ((paramd == null) || (paramd.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paramString2 = WxaPkgIntegrityChecker.LB(paramString1);
        }
        ((ModulePkgInfo)localObject).md5 = paramString2;
        ((ModulePkgInfo)localObject).pkgVersion = paramInt;
        paramd = (IPkgInfo)localObject;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<y.e, d.z>
  {
    d(n paramn, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    e(n paramn)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<bah[], d.z>
  {
    f(n paramn, z.b paramb)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      a(n.f paramf)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.q<Integer, Integer, String, d.z>
  {
    g(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.n
 * JD-Core Version:    0.7.0.1
 */