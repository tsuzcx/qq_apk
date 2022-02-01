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
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.a.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Companion", "Downloader", "ResponseAssembler", "plugin-appbrand-integration_release"})
public final class n
  implements y
{
  private static final WxaPkgLoadProgress lLp;
  @Deprecated
  public static final a lLq;
  private final d.g.a.b<WxaPkgLoadProgress, d.z> lKU;
  private final d.g.a.b<y.e, d.z> lLh;
  private final ad lLi;
  private bh lLj;
  private bd lLk;
  private final y.d lLl;
  private final d.g.a.m<y.a, String, d.z> lLm;
  private final z lLn;
  private final y.c lLo;
  
  static
  {
    AppMethodBeat.i(180517);
    lLq = new a((byte)0);
    lLp = new WxaPkgLoadProgress(0, 0L, 0L);
    AppMethodBeat.o(180517);
  }
  
  public n(y.d paramd, final d.g.a.b<? super y.e, d.z> paramb, d.g.a.m<? super y.a, ? super String, d.z> paramm, d.g.a.b<? super WxaPkgLoadProgress, d.z> paramb1, z paramz, y.c paramc)
  {
    AppMethodBeat.i(180516);
    this.lLl = paramd;
    this.lLm = paramm;
    this.lKU = paramb1;
    this.lLn = paramz;
    this.lLo = paramc;
    this.lLh = ((d.g.a.b)new d(this, paramb));
    this.lLi = this.lLl.brR();
    AppMethodBeat.o(180516);
  }
  
  private final void brK()
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(180513);
    Object localObject2 = this.lLo;
    if (localObject2 != null) {
      ((y.c)localObject2).b(this.lLl);
    }
    localObject2 = new z.b();
    ((z.b)localObject2).setAppId(this.lLl.appId);
    int i = this.lLl.doK;
    int[] arrayOfInt = com.tencent.mm.cn.a.LYb;
    p.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (e.contains(arrayOfInt, i)) {}
    for (;;)
    {
      ((z.b)localObject2).coY = ((String)localObject1);
      ((z.b)localObject2).doK = this.lLl.doK;
      ((z.b)localObject2).hSZ = this.lLl.hSZ;
      if (j.a.rT(this.lLl.hSZ))
      {
        localObject1 = com.tencent.mm.cn.a.LYa;
        p.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.lLl.doK)) {
          break label351;
        }
        if (!((z.b)localObject2).lMM) {
          break;
        }
        localObject1 = m.bN(this.lLi.toString(), 0);
        if (localObject1 != null)
        {
          ((z.b)localObject2).lLN = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          ((z.b)localObject2).lMK = WxaPkg.LX(((WxaPkgWrappingInfo)localObject1).pkgPath());
        }
      }
      if (!this.lLl.lMC) {
        break label365;
      }
      i = j;
      label205:
      ((z.b)localObject2).lMK = i;
      localObject1 = this.lLl.lMB;
      if (!(localObject1 instanceof y.g.b)) {
        break label370;
      }
      ((z.b)localObject2).aDD = ((y.g.b)localObject1).version;
      label238:
      z.a.a(this.lLn, (z.b)localObject2, (d.g.a.b)new f(this, (z.b)localObject2), (d.g.a.q)new g(this));
      AppMethodBeat.o(180513);
      return;
      arrayOfInt = com.tencent.mm.cn.a.LYa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (!e.contains(arrayOfInt, i)) {
        localObject1 = this.lLl.coY;
      }
    }
    if ((this.lLl.lMB instanceof y.g.b)) {}
    for (i = ((y.g.b)this.lLl.lMB).version;; i = 0)
    {
      localObject1 = m.bO(this.lLi.toString(), i);
      break;
      label351:
      localObject1 = m.Su(this.lLi.toString());
      break;
      label365:
      i = 1;
      break label205;
      label370:
      if (!(localObject1 instanceof y.g.a)) {
        break label238;
      }
      ((z.b)localObject2).aDD = ((y.g.a)localObject1).version;
      ((z.b)localObject2).lMM = true;
      break label238;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(180512);
    Object localObject1 = j.aZu();
    if (localObject1 == null)
    {
      ((d.g.a.a)new e(this)).invoke();
      AppMethodBeat.o(180512);
      return;
    }
    this.lLj = ((bh)localObject1);
    if (((this.lLl.lMB instanceof y.g.b)) && (j.a.rT(this.lLl.hSZ)))
    {
      localObject1 = this.lLj;
      if (localObject1 == null) {
        p.bdF("storage");
      }
      localObject2 = ((bh)localObject1).a(this.lLi.toString(), ((y.g.b)this.lLl.lMB).version, this.lLl.hSZ, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.cn.a.LYa;
        p.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.lLl.doK)) {
          break label241;
        }
        localObject1 = new bd();
        ((bd)localObject1).field_appId = this.lLi.toString();
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label246;
      }
      this.lLm.p(y.a.lMr, null);
      AppMethodBeat.o(180512);
      return;
      localObject1 = this.lLj;
      if (localObject1 == null) {
        p.bdF("storage");
      }
      localObject2 = ((bh)localObject1).a(this.lLi.toString(), this.lLl.hSZ, new String[0]);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        break;
        label241:
        localObject1 = null;
      }
    }
    label246:
    this.lLk = ((bd)localObject1);
    localObject1 = this.lLk;
    if (localObject1 == null) {
      p.bdF("record");
    }
    localObject1 = (CharSequence)((bd)localObject1).field_versionMd5;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label341;
      }
      ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.md5 is EMPTY, will download with request " + this.lLl);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label610;
      }
      brK();
      AppMethodBeat.o(180512);
      return;
      i = 0;
      break;
      label341:
      localObject1 = this.lLk;
      if (localObject1 == null) {
        p.bdF("record");
      }
      localObject1 = (CharSequence)((bd)localObject1).field_pkgPath;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label419;
        }
        ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.path is EMPTY, will download with request " + this.lLl);
        i = 1;
        break;
      }
      label419:
      if (((this.lLl.lMB instanceof y.g.a)) && (((y.g.a)this.lLl.lMB).lMJ))
      {
        ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(forceUpdate) requested, will download with request " + this.lLl);
        i = 1;
      }
      else
      {
        if ((this.lLl.lMB instanceof y.g.a))
        {
          i = ((y.g.a)this.lLl.lMB).version;
          localObject1 = this.lLk;
          if (localObject1 == null) {
            p.bdF("record");
          }
          if (i > ((bd)localObject1).field_version)
          {
            localObject1 = new StringBuilder("LATEST(version:").append(((y.g.a)this.lLl.lMB).version).append(" requested, > record.version(");
            localObject2 = this.lLk;
            if (localObject2 == null) {
              p.bdF("record");
            }
            ae.i("MicroMsg.AppBrand.CommonPkgFetcher", ((bd)localObject2).field_version + "))");
            i = 1;
            continue;
          }
        }
        i = 0;
      }
    }
    label610:
    localObject1 = this.lLk;
    if (localObject1 == null) {
      p.bdF("record");
    }
    localObject1 = WxaPkgIntegrityChecker.Me(((bd)localObject1).field_pkgPath);
    Object localObject2 = this.lLk;
    if (localObject2 == null) {
      p.bdF("record");
    }
    Object localObject3;
    Object localObject4;
    bd localbd;
    if (p.i(((bd)localObject2).field_versionMd5, localObject1))
    {
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1; i == 0; i = 0)
      {
        ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with LegacyMd5, invoke onSuccess, request=" + this.lLl);
        localObject1 = this.lLh;
        localObject2 = c.lLC;
        localObject2 = this.lLl;
        localObject3 = this.lLk;
        if (localObject3 == null) {
          p.bdF("record");
        }
        localObject3 = ((bd)localObject3).field_pkgPath;
        p.g(localObject3, "record.field_pkgPath");
        localObject4 = this.lLk;
        if (localObject4 == null) {
          p.bdF("record");
        }
        localObject4 = ((bd)localObject4).field_versionMd5;
        localbd = this.lLk;
        if (localbd == null) {
          p.bdF("record");
        }
        ((d.g.a.b)localObject1).invoke(c.a((y.d)localObject2, (String)localObject3, (String)localObject4, localbd.field_version, y.f.lMG));
        AppMethodBeat.o(180512);
        return;
      }
    }
    localObject2 = this.lLk;
    if (localObject2 == null) {
      p.bdF("record");
    }
    if (p.i(((bd)localObject2).field_NewMd5, localObject1))
    {
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
        i = 1;
      }
      while (i == 0)
      {
        if (this.lLl.lMC)
        {
          localObject1 = this.lLk;
          if (localObject1 == null) {
            p.bdF("record");
          }
          if (WxaPkg.LX(((bd)localObject1).field_pkgPath) > 0)
          {
            ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=" + this.lLl);
            brK();
            AppMethodBeat.o(180512);
            return;
            i = 0;
            continue;
          }
        }
        ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, invoke onSuccess, request=" + this.lLl);
        localObject1 = this.lLh;
        localObject2 = c.lLC;
        localObject2 = this.lLl;
        localObject3 = this.lLk;
        if (localObject3 == null) {
          p.bdF("record");
        }
        localObject3 = ((bd)localObject3).field_pkgPath;
        p.g(localObject3, "record.field_pkgPath");
        localObject4 = this.lLk;
        if (localObject4 == null) {
          p.bdF("record");
        }
        localObject4 = ((bd)localObject4).field_NewMd5;
        localbd = this.lLk;
        if (localbd == null) {
          p.bdF("record");
        }
        ((d.g.a.b)localObject1).invoke(c.a((y.d)localObject2, (String)localObject3, (String)localObject4, localbd.field_version, y.f.lMG));
        AppMethodBeat.o(180512);
        return;
      }
    }
    localObject2 = this.lLk;
    if (localObject2 == null) {
      p.bdF("record");
    }
    if (o.fB(((bd)localObject2).field_pkgPath))
    {
      localObject1 = new StringBuilder("start(), check existed pkg fileMd5(").append((String)localObject1).append(")!=recordMd5(");
      localObject2 = this.lLk;
      if (localObject2 == null) {
        p.bdF("record");
      }
      localObject1 = ((StringBuilder)localObject1).append(((bd)localObject2).field_versionMd5).append('|');
      localObject2 = this.lLk;
      if (localObject2 == null) {
        p.bdF("record");
      }
      ae.e("MicroMsg.AppBrand.CommonPkgFetcher", ((bd)localObject2).field_NewMd5 + "), request=" + this.lLl);
    }
    localObject1 = c.lLC;
    localObject1 = this.lLl;
    localObject2 = this.lLk;
    if (localObject2 == null) {
      p.bdF("record");
    }
    localObject1 = c.a((y.d)localObject1, (bd)localObject2);
    if (localObject1 != null)
    {
      ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached by reuse logic, request=" + this.lLl);
      this.lLh.invoke(localObject1);
      AppMethodBeat.o(180512);
      return;
    }
    ae.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), no cached pkg, will download with request " + this.lLl);
    brK();
    AppMethodBeat.o(180512);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Companion;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V", "plugin-appbrand-integration_release"})
  final class b
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      implements Runnable
    {
      a(n.b paramb, z.b paramb1, bax[] paramArrayOfbax) {}
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "plugin-appbrand-integration_release"})
  static final class c
  {
    public static final c lLC;
    
    static
    {
      AppMethodBeat.i(223512);
      lLC = new c();
      AppMethodBeat.o(223512);
    }
    
    public static y.e a(y.d paramd, bd parambd)
    {
      AppMethodBeat.i(223510);
      p.h(paramd, "request");
      p.h(parambd, "record");
      ad localad = paramd.brR();
      bh localbh = j.aZu();
      if (((paramd.lMB instanceof y.g.b)) && (j.a.rT(paramd.hSZ)))
      {
        Object localObject = (CharSequence)parambd.field_versionMd5;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          n.brM();
          ae.e("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg record.md5 is EMPTY, request=".concat(String.valueOf(paramd)));
          AppMethodBeat.o(223510);
          return null;
        }
        parambd = m.a(localad, paramd.hSZ, ((y.g.b)paramd.lMB).version, new String[] { parambd.field_versionMd5, parambd.field_NewMd5 });
        if (parambd != null)
        {
          localObject = ba.aO(localad.toString(), ((y.g.b)paramd.lMB).version);
          o.mF(parambd.field_pkgPath, (String)localObject);
          localbh.e(localad.toString(), paramd.hSZ, ((y.g.b)paramd.lMB).version, (String)localObject);
          p.g(localObject, "targetPkgPath");
          paramd = a(paramd, (String)localObject, null, ((y.g.b)paramd.lMB).version, y.f.lMG);
          AppMethodBeat.o(223510);
          return paramd;
        }
      }
      AppMethodBeat.o(223510);
      return null;
    }
    
    public static y.e a(y.d paramd, String paramString1, String paramString2, int paramInt, y.f paramf)
    {
      int i = 0;
      AppMethodBeat.i(223511);
      p.h(paramd, "request");
      p.h(paramString1, "wxaPkgFilePath");
      p.h(paramf, "source");
      Object localObject = com.tencent.mm.cn.a.LYa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.doK))
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
          paramString2 = WxaPkgIntegrityChecker.Me(paramString1);
        }
        ((WxaPluginPkgInfo)localObject).md5 = paramString2;
        paramd = (bl)j.T(bl.class);
        paramString1 = ((WxaPluginPkgInfo)localObject).provider;
        p.g(paramString1, "provider");
        ((WxaPluginPkgInfo)localObject).stringVersion = paramd.aX(paramString1, ((WxaPluginPkgInfo)localObject).version);
        paramd = (IPkgInfo)localObject;
        paramd = new y.e(paramd, paramf);
        AppMethodBeat.o(223511);
        return paramd;
      }
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString1;
      ((ModulePkgInfo)localObject).name = paramd.coY;
      paramd = (CharSequence)paramString2;
      if ((paramd == null) || (paramd.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paramString2 = WxaPkgIntegrityChecker.Me(paramString1);
        }
        ((ModulePkgInfo)localObject).md5 = paramString2;
        ((ModulePkgInfo)localObject).pkgVersion = paramInt;
        paramd = (IPkgInfo)localObject;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<y.e, d.z>
  {
    d(n paramn, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    e(n paramn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<bax[], d.z>
  {
    f(n paramn, z.b paramb)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
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