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
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.a.e;
import d.g.a.q;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Companion", "Downloader", "ResponseAssembler", "plugin-appbrand-integration_release"})
public final class n
  implements y
{
  private static final WxaPkgLoadProgress ljH;
  @Deprecated
  public static final a ljI;
  private final ab ljA;
  private bf ljB;
  private bb ljC;
  private final y.d ljD;
  private final d.g.a.m<y.a, String, d.y> ljE;
  private final z ljF;
  private final y.c ljG;
  private final d.g.a.b<WxaPkgLoadProgress, d.y> ljn;
  private final d.g.a.b<y.e, d.y> ljz;
  
  static
  {
    AppMethodBeat.i(180517);
    ljI = new a((byte)0);
    ljH = new WxaPkgLoadProgress(0, 0L, 0L);
    AppMethodBeat.o(180517);
  }
  
  public n(y.d paramd, final d.g.a.b<? super y.e, d.y> paramb, d.g.a.m<? super y.a, ? super String, d.y> paramm, d.g.a.b<? super WxaPkgLoadProgress, d.y> paramb1, z paramz, y.c paramc)
  {
    AppMethodBeat.i(180516);
    this.ljD = paramd;
    this.ljE = paramm;
    this.ljn = paramb1;
    this.ljF = paramz;
    this.ljG = paramc;
    this.ljz = ((d.g.a.b)new d(this, paramb));
    this.ljA = this.ljD.bnv();
    AppMethodBeat.o(180516);
  }
  
  private final void bno()
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(180513);
    Object localObject2 = this.ljG;
    if (localObject2 != null) {
      ((y.c)localObject2).b(this.ljD);
    }
    localObject2 = new z.b();
    ((z.b)localObject2).setAppId(this.ljD.appId);
    int i = this.ljD.dcj;
    int[] arrayOfInt = com.tencent.mm.co.a.JHX;
    k.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (e.contains(arrayOfInt, i)) {}
    for (;;)
    {
      ((z.b)localObject2).ceF = ((String)localObject1);
      ((z.b)localObject2).dcj = this.ljD.dcj;
      ((z.b)localObject2).hxM = this.ljD.hxM;
      if (j.a.rq(this.ljD.hxM))
      {
        localObject1 = com.tencent.mm.co.a.JHW;
        k.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.ljD.dcj)) {
          break label351;
        }
        if (!((z.b)localObject2).lle) {
          break;
        }
        localObject1 = m.bH(this.ljA.toString(), 0);
        if (localObject1 != null)
        {
          ((z.b)localObject2).lkf = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          ((z.b)localObject2).llc = WxaPkg.Ic(((WxaPkgWrappingInfo)localObject1).pkgPath());
        }
      }
      if (!this.ljD.lkU) {
        break label365;
      }
      i = j;
      label205:
      ((z.b)localObject2).llc = i;
      localObject1 = this.ljD.lkT;
      if (!(localObject1 instanceof y.g.b)) {
        break label370;
      }
      ((z.b)localObject2).aBM = ((y.g.b)localObject1).version;
      label238:
      z.a.a(this.ljF, (z.b)localObject2, (d.g.a.b)new f(this, (z.b)localObject2), (q)new g(this));
      AppMethodBeat.o(180513);
      return;
      arrayOfInt = com.tencent.mm.co.a.JHW;
      k.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (!e.contains(arrayOfInt, i)) {
        localObject1 = this.ljD.ceF;
      }
    }
    if ((this.ljD.lkT instanceof y.g.b)) {}
    for (i = ((y.g.b)this.ljD.lkT).version;; i = 0)
    {
      localObject1 = m.bI(this.ljA.toString(), i);
      break;
      label351:
      localObject1 = m.On(this.ljA.toString());
      break;
      label365:
      i = 1;
      break label205;
      label370:
      ((z.b)localObject2).lle = true;
      break label238;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(180512);
    Object localObject1 = j.aVC();
    if (localObject1 == null)
    {
      ((d.g.a.a)new e(this)).invoke();
      AppMethodBeat.o(180512);
      return;
    }
    this.ljB = ((bf)localObject1);
    if (((this.ljD.lkT instanceof y.g.b)) && (j.a.rq(this.ljD.hxM)))
    {
      localObject1 = this.ljB;
      if (localObject1 == null) {
        k.aVY("storage");
      }
      localObject2 = ((bf)localObject1).a(this.ljA.toString(), ((y.g.b)this.ljD.lkT).version, this.ljD.hxM, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.co.a.JHW;
        k.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.ljD.dcj)) {
          break label241;
        }
        localObject1 = new bb();
        ((bb)localObject1).field_appId = this.ljA.toString();
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label246;
      }
      this.ljE.n(y.a.lkJ, null);
      AppMethodBeat.o(180512);
      return;
      localObject1 = this.ljB;
      if (localObject1 == null) {
        k.aVY("storage");
      }
      localObject2 = ((bf)localObject1).a(this.ljA.toString(), this.ljD.hxM, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        break;
        label241:
        localObject1 = null;
      }
    }
    label246:
    this.ljC = ((bb)localObject1);
    localObject1 = this.ljC;
    if (localObject1 == null) {
      k.aVY("record");
    }
    localObject1 = (CharSequence)((bb)localObject1).field_versionMd5;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label341;
      }
      ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.md5 is EMPTY, will download with request " + this.ljD);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label484;
      }
      bno();
      AppMethodBeat.o(180512);
      return;
      i = 0;
      break;
      label341:
      localObject1 = this.ljC;
      if (localObject1 == null) {
        k.aVY("record");
      }
      localObject1 = (CharSequence)((bb)localObject1).field_pkgPath;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label419;
        }
        ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.path is EMPTY, will download with request " + this.ljD);
        i = 1;
        break;
      }
      label419:
      if (((this.ljD.lkT instanceof y.g.a)) && (((y.g.a)this.ljD.lkT).llb))
      {
        ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(forceUpdate) requested, will download with request " + this.ljD);
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    label484:
    localObject1 = this.ljC;
    if (localObject1 == null) {
      k.aVY("record");
    }
    localObject1 = WxaPkgIntegrityChecker.Ij(((bb)localObject1).field_pkgPath);
    Object localObject2 = this.ljC;
    if (localObject2 == null) {
      k.aVY("record");
    }
    Object localObject3;
    Object localObject4;
    bb localbb;
    if (k.g(((bb)localObject2).field_versionMd5, localObject1))
    {
      ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with LegacyMd5, invoke onSuccess, request=" + this.ljD);
      localObject1 = this.ljz;
      localObject2 = c.ljU;
      localObject2 = this.ljD;
      localObject3 = this.ljC;
      if (localObject3 == null) {
        k.aVY("record");
      }
      localObject3 = ((bb)localObject3).field_pkgPath;
      k.g(localObject3, "record.field_pkgPath");
      localObject4 = this.ljC;
      if (localObject4 == null) {
        k.aVY("record");
      }
      localObject4 = ((bb)localObject4).field_versionMd5;
      localbb = this.ljC;
      if (localbb == null) {
        k.aVY("record");
      }
      ((d.g.a.b)localObject1).ay(c.a((y.d)localObject2, (String)localObject3, (String)localObject4, localbb.field_version, y.f.lkY));
      AppMethodBeat.o(180512);
      return;
    }
    localObject2 = this.ljC;
    if (localObject2 == null) {
      k.aVY("record");
    }
    if (k.g(((bb)localObject2).field_NewMd5, localObject1))
    {
      if (this.ljD.lkU)
      {
        localObject1 = this.ljC;
        if (localObject1 == null) {
          k.aVY("record");
        }
        if (WxaPkg.Ic(((bb)localObject1).field_pkgPath) > 0)
        {
          ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=" + this.ljD);
          bno();
          AppMethodBeat.o(180512);
          return;
        }
      }
      ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, invoke onSuccess, request=" + this.ljD);
      localObject1 = this.ljz;
      localObject2 = c.ljU;
      localObject2 = this.ljD;
      localObject3 = this.ljC;
      if (localObject3 == null) {
        k.aVY("record");
      }
      localObject3 = ((bb)localObject3).field_pkgPath;
      k.g(localObject3, "record.field_pkgPath");
      localObject4 = this.ljC;
      if (localObject4 == null) {
        k.aVY("record");
      }
      localObject4 = ((bb)localObject4).field_NewMd5;
      localbb = this.ljC;
      if (localbb == null) {
        k.aVY("record");
      }
      ((d.g.a.b)localObject1).ay(c.a((y.d)localObject2, (String)localObject3, (String)localObject4, localbb.field_version, y.f.lkY));
      AppMethodBeat.o(180512);
      return;
    }
    localObject2 = this.ljC;
    if (localObject2 == null) {
      k.aVY("record");
    }
    if (i.eA(((bb)localObject2).field_pkgPath))
    {
      localObject1 = new StringBuilder("start(), check existed pkg fileMd5(").append((String)localObject1).append(")!=recordMd5(");
      localObject2 = this.ljC;
      if (localObject2 == null) {
        k.aVY("record");
      }
      localObject1 = ((StringBuilder)localObject1).append(((bb)localObject2).field_versionMd5).append('|');
      localObject2 = this.ljC;
      if (localObject2 == null) {
        k.aVY("record");
      }
      ac.e("MicroMsg.AppBrand.CommonPkgFetcher", ((bb)localObject2).field_NewMd5 + "), request=" + this.ljD);
    }
    localObject1 = c.ljU;
    localObject1 = this.ljD;
    localObject2 = this.ljC;
    if (localObject2 == null) {
      k.aVY("record");
    }
    localObject1 = c.a((y.d)localObject1, (bb)localObject2);
    if (localObject1 != null)
    {
      ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached by reuse logic, request=" + this.ljD);
      this.ljz.ay(localObject1);
      AppMethodBeat.o(180512);
      return;
    }
    ac.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), no cached pkg, will download with request " + this.ljD);
    bno();
    AppMethodBeat.o(180512);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Companion;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V", "plugin-appbrand-integration_release"})
  final class b
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      implements Runnable
    {
      a(n.b paramb, z.b paramb1, awj[] paramArrayOfawj) {}
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "plugin-appbrand-integration_release"})
  static final class c
  {
    public static final c ljU;
    
    static
    {
      AppMethodBeat.i(187293);
      ljU = new c();
      AppMethodBeat.o(187293);
    }
    
    public static y.e a(y.d paramd, bb parambb)
    {
      AppMethodBeat.i(187291);
      k.h(paramd, "request");
      k.h(parambb, "record");
      ab localab = paramd.bnv();
      bf localbf = j.aVC();
      if (((paramd.lkT instanceof y.g.b)) && (j.a.rq(paramd.hxM)))
      {
        Object localObject = (CharSequence)parambb.field_versionMd5;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          n.bnq();
          ac.e("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg record.md5 is EMPTY, request=".concat(String.valueOf(paramd)));
          AppMethodBeat.o(187291);
          return null;
        }
        parambb = m.a(localab, paramd.hxM, ((y.g.b)paramd.lkT).version, new String[] { parambb.field_versionMd5, parambb.field_NewMd5 });
        if (parambb != null)
        {
          localObject = ay.aJ(localab.toString(), ((y.g.b)paramd.lkT).version);
          i.lZ(parambb.field_pkgPath, (String)localObject);
          localbf.e(localab.toString(), paramd.hxM, ((y.g.b)paramd.lkT).version, (String)localObject);
          k.g(localObject, "targetPkgPath");
          paramd = a(paramd, (String)localObject, null, ((y.g.b)paramd.lkT).version, y.f.lkY);
          AppMethodBeat.o(187291);
          return paramd;
        }
      }
      AppMethodBeat.o(187291);
      return null;
    }
    
    public static y.e a(y.d paramd, String paramString1, String paramString2, int paramInt, y.f paramf)
    {
      int i = 0;
      AppMethodBeat.i(187292);
      k.h(paramd, "request");
      k.h(paramString1, "wxaPkgFilePath");
      k.h(paramf, "source");
      Object localObject = com.tencent.mm.co.a.JHW;
      k.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.dcj))
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
          paramString2 = WxaPkgIntegrityChecker.Ij(paramString1);
        }
        ((WxaPluginPkgInfo)localObject).md5 = paramString2;
        paramd = (bj)j.T(bj.class);
        paramString1 = ((WxaPluginPkgInfo)localObject).provider;
        k.g(paramString1, "provider");
        ((WxaPluginPkgInfo)localObject).stringVersion = paramd.aS(paramString1, ((WxaPluginPkgInfo)localObject).version);
        paramd = (IPkgInfo)localObject;
        paramd = new y.e(paramd, paramf);
        AppMethodBeat.o(187292);
        return paramd;
      }
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString1;
      ((ModulePkgInfo)localObject).name = paramd.ceF;
      paramd = (CharSequence)paramString2;
      if ((paramd == null) || (paramd.length() == 0)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          paramString2 = WxaPkgIntegrityChecker.Ij(paramString1);
        }
        ((ModulePkgInfo)localObject).md5 = paramString2;
        paramd = (IPkgInfo)localObject;
        break;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<y.e, d.y>
  {
    d(n paramn, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    e(n paramn)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<awj[], d.y>
  {
    f(n paramn, z.b paramb)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      a(n.f paramf)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements q<Integer, Integer, String, d.y>
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