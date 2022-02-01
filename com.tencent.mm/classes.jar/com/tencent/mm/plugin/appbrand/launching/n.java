package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vfs.s;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Companion", "Downloader", "ResponseAssembler", "plugin-appbrand-integration_release"})
public final class n
  implements x
{
  private static final WxaPkgLoadProgress mTf;
  @Deprecated
  public static final a mTg;
  private final acc mSK;
  private final kotlin.g.a.b<WxaPkgLoadProgress, kotlin.x> mSN;
  private final kotlin.g.a.b<x.e, kotlin.x> mSY;
  private final ad mSZ;
  private bh mTa;
  private final x.d mTb;
  private final kotlin.g.a.m<x.a, String, kotlin.x> mTc;
  private final y mTd;
  private final x.c mTe;
  
  static
  {
    AppMethodBeat.i(180517);
    mTg = new a((byte)0);
    mTf = new WxaPkgLoadProgress(0, 0L, 0L);
    AppMethodBeat.o(180517);
  }
  
  public n(x.d paramd, final kotlin.g.a.b<? super x.e, kotlin.x> paramb, kotlin.g.a.m<? super x.a, ? super String, kotlin.x> paramm, kotlin.g.a.b<? super WxaPkgLoadProgress, kotlin.x> paramb1, y paramy, acc paramacc, x.c paramc)
  {
    AppMethodBeat.i(228646);
    this.mTb = paramd;
    this.mTc = paramm;
    this.mSN = paramb1;
    this.mTd = paramy;
    this.mSK = paramacc;
    this.mTe = paramc;
    this.mSY = ((kotlin.g.a.b)new d(this, paramb));
    this.mSZ = this.mTb.bNz();
    AppMethodBeat.o(228646);
  }
  
  private final void bNu()
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(180513);
    Object localObject2 = this.mTe;
    if (localObject2 != null) {
      ((x.c)localObject2).b(this.mTb);
    }
    localObject2 = new y.b();
    ((y.b)localObject2).setAppId(this.mTb.appId);
    int i = this.mTb.packageType;
    int[] arrayOfInt = com.tencent.mm.cp.a.Rxb;
    p.g(arrayOfInt, "ConstantsWxaPackageProto…_INTEGRATED_PACKAGE_TYPES");
    if (e.contains(arrayOfInt, i)) {}
    for (;;)
    {
      ((y.b)localObject2).cBp = ((String)localObject1);
      ((y.b)localObject2).packageType = this.mTb.packageType;
      ((y.b)localObject2).iOo = this.mTb.iOo;
      if (j.a.vP(this.mTb.iOo))
      {
        localObject1 = com.tencent.mm.cp.a.Rxa;
        p.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
        if (!e.contains((int[])localObject1, this.mTb.packageType)) {
          break label357;
        }
        if (!((y.b)localObject2).mUx) {
          break;
        }
        localObject1 = m.bS(this.mSZ.toString(), 0);
        if (localObject1 != null)
        {
          ((y.b)localObject2).mUv = ((WxaPkgWrappingInfo)localObject1).pkgVersion;
          ((y.b)localObject2).mUu = WxaPkg.Vg(((WxaPkgWrappingInfo)localObject1).pkgPath());
        }
      }
      if (!this.mTb.mUm) {
        break label371;
      }
      i = j;
      label206:
      ((y.b)localObject2).mUu = i;
      localObject1 = this.mTb.mUl;
      if (!(localObject1 instanceof x.g.b)) {
        break label376;
      }
      ((y.b)localObject2).appVersion = ((x.g.b)localObject1).version;
      label239:
      y.a.a(this.mTd, (y.b)localObject2, (kotlin.g.a.b)new f(this, (y.b)localObject2), (kotlin.g.a.q)new g(this), this.mSK);
      AppMethodBeat.o(180513);
      return;
      arrayOfInt = com.tencent.mm.cp.a.Rxa;
      p.g(arrayOfInt, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (!e.contains(arrayOfInt, i)) {
        localObject1 = this.mTb.cBp;
      }
    }
    if ((this.mTb.mUl instanceof x.g.b)) {}
    for (i = ((x.g.b)this.mTb.mUl).version;; i = 0)
    {
      localObject1 = m.bT(this.mSZ.toString(), i);
      break;
      label357:
      localObject1 = m.abZ(this.mSZ.toString());
      break;
      label371:
      i = 1;
      break label206;
      label376:
      if (!(localObject1 instanceof x.g.a)) {
        break label239;
      }
      ((y.b)localObject2).appVersion = ((x.g.a)localObject1).version;
      ((y.b)localObject2).mUx = true;
      break label239;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(180512);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.n.buL();
    if (localObject1 == null)
    {
      ((kotlin.g.a.a)new e(this)).invoke();
      AppMethodBeat.o(180512);
      return;
    }
    this.mTa = ((bh)localObject1);
    if (((this.mTb.mUl instanceof x.g.b)) && (j.a.vP(this.mTb.iOo)))
    {
      localObject1 = this.mTa;
      if (localObject1 == null) {
        p.btv("storage");
      }
      localObject2 = ((bh)localObject1).a(this.mSZ.toString(), ((x.g.b)this.mTb.mUl).version, this.mTb.iOo, new String[0]);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label261;
      }
      localObject1 = com.tencent.mm.cp.a.Rxa;
      p.g(localObject1, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if ((!e.contains((int[])localObject1, this.mTb.packageType)) && (!(this.mTb.mUl instanceof x.g.a))) {
        break label264;
      }
      localObject1 = new bd();
      ((bd)localObject1).field_appId = this.mSZ.toString();
      ((bd)localObject1).field_debugType = this.mTb.iOo;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label269;
      }
      this.mTc.invoke(x.a.mTZ, null);
      AppMethodBeat.o(180512);
      return;
      localObject1 = this.mTa;
      if (localObject1 == null) {
        p.btv("storage");
      }
      localObject1 = ((bh)localObject1).a(this.mSZ.toString(), this.mTb.iOo, new String[0]);
      if (localObject1 == null) {
        break;
      }
      label261:
      continue;
      label264:
      localObject1 = null;
    }
    label269:
    Object localObject2 = (CharSequence)((bd)localObject1).field_versionMd5;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label344;
      }
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.md5 is EMPTY, will download with request " + this.mTb);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label564;
      }
      bNu();
      AppMethodBeat.o(180512);
      return;
      i = 0;
      break;
      label344:
      localObject2 = (CharSequence)((bd)localObject1).field_pkgPath;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label407;
        }
        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.path is EMPTY, will download with request " + this.mTb);
        i = 1;
        break;
      }
      label407:
      if (((this.mTb.mUl instanceof x.g.a)) && (((x.g.a)this.mTb.mUl).mUt))
      {
        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(forceUpdate) requested, will download with request " + this.mTb);
        i = 1;
      }
      else if (((this.mTb.mUl instanceof x.g.a)) && (((x.g.a)this.mTb.mUl).version > ((bd)localObject1).field_version))
      {
        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(version:" + ((x.g.a)this.mTb.mUl).version + " requested, > record.version(" + ((bd)localObject1).field_version + "))");
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    label564:
    localObject2 = WxaPkgIntegrityChecker.Vn(((bd)localObject1).field_pkgPath);
    Object localObject3;
    String str;
    if (p.j(((bd)localObject1).field_versionMd5, localObject2))
    {
      localObject3 = (CharSequence)localObject2;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with LegacyMd5, invoke onSuccess, request=" + this.mTb + ", version:" + ((bd)localObject1).field_version + ", md5:" + ((bd)localObject1).field_versionMd5 + ", path:" + ((bd)localObject1).field_pkgPath);
        localObject2 = this.mSY;
        localObject3 = c.mTs;
        localObject3 = this.mTb;
        str = ((bd)localObject1).field_pkgPath;
        p.g(str, "record.field_pkgPath");
        ((kotlin.g.a.b)localObject2).invoke(c.a((x.d)localObject3, str, ((bd)localObject1).field_versionMd5, ((bd)localObject1).field_version, x.f.mUq));
        AppMethodBeat.o(180512);
        return;
      }
    }
    if (p.j(((bd)localObject1).field_NewMd5, localObject2))
    {
      localObject3 = (CharSequence)localObject2;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {
        i = 1;
      }
      while (i == 0) {
        if ((this.mTb.mUm) && (WxaPkg.Vg(((bd)localObject1).field_pkgPath) > 0))
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=" + this.mTb);
          bNu();
          AppMethodBeat.o(180512);
          return;
          i = 0;
        }
        else
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, invoke onSuccess, request=" + this.mTb + ", version:" + ((bd)localObject1).field_version + ", NewMd5:" + ((bd)localObject1).field_NewMd5 + ", path:" + ((bd)localObject1).field_pkgPath);
          localObject2 = this.mSY;
          localObject3 = c.mTs;
          localObject3 = this.mTb;
          str = ((bd)localObject1).field_pkgPath;
          p.g(str, "record.field_pkgPath");
          ((kotlin.g.a.b)localObject2).invoke(c.a((x.d)localObject3, str, ((bd)localObject1).field_NewMd5, ((bd)localObject1).field_version, x.f.mUq));
          AppMethodBeat.o(180512);
          return;
        }
      }
    }
    if (s.YS(((bd)localObject1).field_pkgPath)) {
      Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "start(), check existed pkg fileMd5(" + (String)localObject2 + ")!=recordMd5(" + ((bd)localObject1).field_versionMd5 + '|' + ((bd)localObject1).field_NewMd5 + "), request=" + this.mTb);
    }
    localObject2 = c.mTs;
    localObject1 = c.a(this.mTb, (bd)localObject1);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached by reuse logic, request=" + this.mTb);
      this.mSY.invoke(localObject1);
      AppMethodBeat.o(180512);
      return;
    }
    Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), no cached pkg, will download with request " + this.mTb);
    bNu();
    AppMethodBeat.o(180512);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Companion;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V", "plugin-appbrand-integration_release"})
  final class b
  {
    public final void a(final y.b paramb, final bmm[] paramArrayOfbmm)
    {
      AppMethodBeat.i(228640);
      p.h(paramb, "request");
      p.h(paramArrayOfbmm, "urls");
      n.bNw();
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, print urls --START--");
      int k = paramArrayOfbmm.length;
      int j = 0;
      int i = 0;
      if (j < k)
      {
        bmm localbmm = paramArrayOfbmm[j];
        n.bNw();
        StringBuilder localStringBuilder = new StringBuilder("Downloader.start, print url, index:").append(i).append(", item:{url:");
        if (localbmm != null)
        {
          localObject = localbmm.url;
          label86:
          localStringBuilder = localStringBuilder.append((String)localObject).append(", md5:");
          if (localbmm == null) {
            break label232;
          }
          localObject = localbmm.md5;
          label112:
          localStringBuilder = localStringBuilder.append((String)localObject).append(", app_version:");
          if (localbmm == null) {
            break label238;
          }
          localObject = Integer.valueOf(localbmm.KXD);
          label141:
          localObject = localStringBuilder.append(localObject).append(", is_patch:");
          if (localbmm == null) {
            break label244;
          }
          bool = localbmm.LVl;
          label167:
          localObject = ((StringBuilder)localObject).append(bool).append(", is_zstd:");
          if (localbmm == null) {
            break label250;
          }
        }
        label232:
        label238:
        label244:
        label250:
        for (boolean bool = localbmm.LVm;; bool = false)
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", bool + '}');
          j += 1;
          i += 1;
          break;
          localObject = null;
          break label86;
          localObject = null;
          break label112;
          localObject = null;
          break label141;
          bool = false;
          break label167;
        }
      }
      n.bNw();
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "Downloader.start, print urls --END--");
      Object localObject = n.a(this.mTh);
      n.bNw();
      ((kotlin.g.a.b)localObject).invoke(n.bNv());
      d.LOGIC.arrange((Runnable)new a(this, paramb, paramArrayOfbmm));
      AppMethodBeat.o(228640);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      implements Runnable
    {
      a(n.b paramb, y.b paramb1, bmm[] paramArrayOfbmm) {}
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<kotlin.x>
      {
        a(n.b.a parama)
        {
          super();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "plugin-appbrand-integration_release"})
  static final class c
  {
    public static final c mTs;
    
    static
    {
      AppMethodBeat.i(228645);
      mTs = new c();
      AppMethodBeat.o(228645);
    }
    
    public static x.e a(x.d paramd, bd parambd)
    {
      AppMethodBeat.i(228643);
      p.h(paramd, "request");
      p.h(parambd, "record");
      ad localad = paramd.bNz();
      bh localbh = com.tencent.mm.plugin.appbrand.app.n.buL();
      if (((paramd.mUl instanceof x.g.b)) && (j.a.vP(paramd.iOo)))
      {
        Object localObject = (CharSequence)parambd.field_versionMd5;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          n.bNw();
          Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg record.md5 is EMPTY, request=".concat(String.valueOf(paramd)));
          AppMethodBeat.o(228643);
          return null;
        }
        parambd = m.a(localad, paramd.iOo, ((x.g.b)paramd.mUl).version, new String[] { parambd.field_versionMd5, parambd.field_NewMd5 });
        if (parambd != null)
        {
          localObject = ba.aT(localad.toString(), ((x.g.b)paramd.mUl).version);
          s.nw(parambd.field_pkgPath, (String)localObject);
          localbh.e(localad.toString(), paramd.iOo, ((x.g.b)paramd.mUl).version, (String)localObject);
          p.g(localObject, "targetPkgPath");
          paramd = a(paramd, (String)localObject, null, ((x.g.b)paramd.mUl).version, x.f.mUq);
          AppMethodBeat.o(228643);
          return paramd;
        }
      }
      AppMethodBeat.o(228643);
      return null;
    }
    
    public static x.e a(x.d paramd, String paramString1, String paramString2, int paramInt, x.f paramf)
    {
      int i = 0;
      AppMethodBeat.i(228644);
      p.h(paramd, "request");
      p.h(paramString1, "wxaPkgFilePath");
      p.h(paramf, "source");
      Object localObject = com.tencent.mm.cp.a.Rxa;
      p.g(localObject, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
      if (e.contains((int[])localObject, paramd.packageType))
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
          paramString2 = WxaPkgIntegrityChecker.Vn(paramString1);
        }
        ((WxaPluginPkgInfo)localObject).md5 = paramString2;
        paramd = (bl)com.tencent.mm.plugin.appbrand.app.n.W(bl.class);
        paramString1 = ((WxaPluginPkgInfo)localObject).provider;
        p.g(paramString1, "provider");
        ((WxaPluginPkgInfo)localObject).stringVersion = paramd.ba(paramString1, ((WxaPluginPkgInfo)localObject).version);
        paramd = (IPkgInfo)localObject;
        paramd = new x.e(paramd, paramf);
        AppMethodBeat.o(228644);
        return paramd;
      }
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString1;
      ((ModulePkgInfo)localObject).name = paramd.cBp;
      paramd = (CharSequence)paramString2;
      if ((paramd == null) || (paramd.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paramString2 = WxaPkgIntegrityChecker.Vn(paramString1);
        }
        ((ModulePkgInfo)localObject).md5 = paramString2;
        ((ModulePkgInfo)localObject).pkgVersion = paramInt;
        paramd = (IPkgInfo)localObject;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<x.e, kotlin.x>
  {
    d(n paramn, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    e(n paramn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bmm[], kotlin.x>
  {
    f(n paramn, y.b paramb)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(n.f paramf)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Integer, Integer, String, kotlin.x>
  {
    g(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.n
 * JD-Core Version:    0.7.0.1
 */