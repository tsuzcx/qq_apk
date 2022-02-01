package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "", "ERROR", "Factory", "IReporter", "Request", "Response", "SOURCE", "VERSION", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface y
{
  public static final b sZF = b.sZS;
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "OK", "FAILED", "LOCAL_FILE_NOT_FOUND", "PKG_INVALID", "SEVER_FILE_NOT_FOUND", "DISK_FULL", "PKG_RECORD_NULL", "PKG_RECORD_INVALID", "CGI_GET_URL_FAILED", "CGI_GET_URL_FAILED_EXPIRED_VERSION", "ENV_ERR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    public final int code;
    
    static
    {
      AppMethodBeat.i(180556);
      sZG = new a("OK", 0, 0);
      sZH = new a("FAILED", 1, 101);
      sZI = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
      sZJ = new a("PKG_INVALID", 3, 105);
      sZK = new a("SEVER_FILE_NOT_FOUND", 4, 106);
      sZL = new a("DISK_FULL", 5, 110);
      sZM = new a("PKG_RECORD_NULL", 6, 111);
      sZN = new a("PKG_RECORD_INVALID", 7, 112);
      sZO = new a("CGI_GET_URL_FAILED", 8, 113);
      sZP = new a("CGI_GET_URL_FAILED_EXPIRED_VERSION", 9, 114);
      sZQ = new a("ENV_ERR", 10, 120);
      sZR = new a[] { sZG, sZH, sZI, sZJ, sZK, sZL, sZM, sZN, sZO, sZP, sZQ };
      AppMethodBeat.o(180556);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Factory;", "", "()V", "waitForPkg", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "scene", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    static
    {
      AppMethodBeat.i(180564);
      sZS = new b();
      AppMethodBeat.o(180564);
    }
    
    private static final void a(y.d paramd, b paramb1, m paramm, b paramb2, z paramz, aeo paramaeo, y.c paramc)
    {
      AppMethodBeat.i(320696);
      s.u(paramd, "$request");
      s.u(paramb1, "$onSuccess");
      s.u(paramm, "$onError");
      s.u(paramb2, "$onProgress");
      s.u(paramz, "$cgiExecutor");
      s.u(paramaeo, "$cgiCommRequestSource");
      paramb1 = new n(paramd, paramb1, paramm, paramb2, paramz, paramaeo, paramc);
      paramd = n.b.a(paramb1.czW(), paramb1.sZf, paramb1.sZa.euz, paramb1.sZa.sZU);
      int i;
      if (paramd == null)
      {
        if (((paramb1.sZa.sZU instanceof y.g.b)) && (k.a.zn(paramb1.sZa.euz))) {
          i = 1;
        }
        while (i != 0)
        {
          paramb1.czX();
          AppMethodBeat.o(320696);
          return;
          if ((paramb1.sZf.cgr()) && (k.a.zn(paramb1.sZa.euz))) {
            i = 1;
          } else if ((paramb1.sZf.cgr()) && (k.a.vK(paramb1.sZa.euz)) && ((paramb1.sZa.sZU instanceof y.g.a))) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      if (paramd == null)
      {
        paramb1.sZe.invoke(y.a.sZM, null);
        AppMethodBeat.o(320696);
        return;
      }
      paramm = (CharSequence)paramd.field_versionMd5;
      if ((paramm == null) || (paramm.length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label303;
        }
        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("record.md5 is EMPTY, will download with request ", paramb1.sZa));
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label502;
        }
        paramb1.czX();
        AppMethodBeat.o(320696);
        return;
        i = 0;
        break;
        label303:
        paramm = (CharSequence)paramd.field_pkgPath;
        if ((paramm == null) || (paramm.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label358;
          }
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("record.path is EMPTY, will download with request ", paramb1.sZa));
          i = 1;
          break;
        }
        label358:
        if (((paramb1.sZa.sZU instanceof y.g.b)) && (((y.g.b)paramb1.sZa.sZU).tae))
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("LATEST(forceUpdate) requested, will download with request ", paramb1.sZa));
          i = 1;
        }
        else if (((paramb1.sZa.sZU instanceof y.g.b)) && (((y.g.b)paramb1.sZa.sZU).version > paramd.field_version))
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(version:" + ((y.g.b)paramb1.sZa.sZU).version + " requested, > record.version(" + paramd.field_version + "))");
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
      label502:
      long l2 = 1000L * ((l)com.tencent.mm.plugin.appbrand.app.n.ag(l.class)).VO(paramb1.sZa.appId);
      if (l2 > 0L) {
        try
        {
          l1 = new com.tencent.mm.vfs.u(paramd.field_pkgPath).lastModified();
          if ((l2 > l1) && (l1 < Util.nowMilliSecond()))
          {
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), request:" + paramb1.sZa + ", before check file checksum, lastModified(" + l1 + ") is marked as invalid until " + l2);
            paramd = ((l)com.tencent.mm.plugin.appbrand.app.n.ag(l.class)).VP(paramb1.sZa.appId);
            if (paramd == null)
            {
              i = -1;
              paramb1.sZh = i;
              paramd = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
              com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramb1.sZh, 189L);
              paramb1.czX();
              AppMethodBeat.o(320696);
              return;
            }
          }
        }
        catch (Exception paramm)
        {
          for (;;)
          {
            long l1 = 9223372036854775807L;
            continue;
            i = paramd.field_reportId;
          }
        }
      }
      paramm = WxaPkgIntegrityChecker.Vu(paramd.field_pkgPath);
      if (s.p(paramd.field_versionMd5, paramm))
      {
        paramb2 = (CharSequence)paramm;
        if ((paramb2 == null) || (paramb2.length() == 0)) {}
        for (i = 1; i == 0; i = 0)
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with LegacyMd5, invoke onSuccess, request=" + paramb1.sZa + ", version:" + paramd.field_version + ", md5:" + paramd.field_versionMd5 + ", path:" + paramd.field_pkgPath);
          paramm = paramb1.sZd;
          paramb2 = n.c.sZn;
          paramb1 = paramb1.sZa;
          paramb2 = paramd.field_pkgPath;
          s.s(paramb2, "record.field_pkgPath");
          paramm.invoke(n.c.a(paramb1, paramb2, paramd.field_versionMd5, paramd.field_version, (y.f)new y.f.a(0)));
          AppMethodBeat.o(320696);
          return;
        }
      }
      if (s.p(paramd.field_NewMd5, paramm))
      {
        paramb2 = (CharSequence)paramm;
        if ((paramb2 == null) || (paramb2.length() == 0)) {
          i = 1;
        }
        while (i == 0) {
          if ((paramb1.sZa.sZV) && (WxaPkg.Vo(paramd.field_pkgPath) > 0))
          {
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=", paramb1.sZa));
            paramb1.czX();
            AppMethodBeat.o(320696);
            return;
            i = 0;
          }
          else
          {
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, invoke onSuccess, request=" + paramb1.sZa + ", version:" + paramd.field_version + ", NewMd5:" + paramd.field_NewMd5 + ", path:" + paramd.field_pkgPath);
            paramm = paramb1.sZd;
            paramb2 = n.c.sZn;
            paramb1 = paramb1.sZa;
            paramb2 = paramd.field_pkgPath;
            s.s(paramb2, "record.field_pkgPath");
            paramm.invoke(n.c.a(paramb1, paramb2, paramd.field_NewMd5, paramd.field_version, (y.f)new y.f.a(0)));
            AppMethodBeat.o(320696);
            return;
          }
        }
      }
      if (com.tencent.mm.vfs.y.ZC(paramd.field_pkgPath)) {
        Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "start(), check existed pkg fileMd5(" + paramm + ")!=recordMd5(" + paramd.field_versionMd5 + '|' + paramd.field_NewMd5 + "), request=" + paramb1.sZa);
      }
      paramm = n.c.sZn;
      paramd = n.c.a(paramb1.czW(), paramb1.sZa, paramd);
      if (paramd != null)
      {
        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("start(), pkg cached by reuse logic, request=", paramb1.sZa));
        paramb1.sZd.invoke(paramd);
        AppMethodBeat.o(320696);
        return;
      }
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("start(), no cached pkg, will download with request ", paramb1.sZa));
      paramb1.czX();
      AppMethodBeat.o(320696);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "onPkgUpdated", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(y.d paramd, y.e parame);
    
    public abstract void b(y.d paramd);
    
    public abstract void b(y.d paramd, y.e parame);
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static void a(y.c paramc, y.d paramd)
      {
        AppMethodBeat.i(320610);
        s.u(paramc, "this");
        s.u(paramd, "request");
        AppMethodBeat.o(320610);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "", "appId", "", "moduleName", "packageType", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "forceNoEncrypt", "", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;Z)V", "getAppId", "()Ljava/lang/String;", "getForceNoEncrypt", "()Z", "localQueryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "getLocalQueryKey", "()Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "localQueryKey$delegate", "Lkotlin/Lazy;", "getModuleName", "getPackageType", "()I", "requestId", "getRequestId", "requestId$delegate", "getVersion", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    public final String appId;
    public final String esT;
    final int euz;
    public final int hDq;
    public final y.g sZU;
    public final boolean sZV;
    private final j sZW;
    final j sZX;
    
    public d(String paramString1, String paramString2, int paramInt1, int paramInt2, y.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(180569);
      this.appId = paramString1;
      this.esT = paramString2;
      this.hDq = paramInt1;
      this.euz = paramInt2;
      this.sZU = paramg;
      this.sZV = paramBoolean;
      this.sZW = k.cm((kotlin.g.a.a)new a(this));
      this.sZX = k.cm((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(180569);
    }
    
    public final af cAe()
    {
      AppMethodBeat.i(180568);
      af localaf = (af)this.sZW.getValue();
      AppMethodBeat.o(180568);
      return localaf;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180571);
      if (this == paramObject)
      {
        AppMethodBeat.o(180571);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(180571);
        return false;
      }
      paramObject = (d)paramObject;
      if (!s.p(this.appId, paramObject.appId))
      {
        AppMethodBeat.o(180571);
        return false;
      }
      if (!s.p(this.esT, paramObject.esT))
      {
        AppMethodBeat.o(180571);
        return false;
      }
      if (this.hDq != paramObject.hDq)
      {
        AppMethodBeat.o(180571);
        return false;
      }
      if (this.euz != paramObject.euz)
      {
        AppMethodBeat.o(180571);
        return false;
      }
      if (!s.p(this.sZU, paramObject.sZU))
      {
        AppMethodBeat.o(180571);
        return false;
      }
      if (this.sZV != paramObject.sZV)
      {
        AppMethodBeat.o(180571);
        return false;
      }
      AppMethodBeat.o(180571);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180567);
      String str = "Request{ appId=" + this.appId + ", module_name=" + this.esT + ", package_type=" + this.hDq + ", version_type=" + this.euz + " app_version=" + this.sZU + " forceNoEncrypt=" + this.sZV + '}';
      AppMethodBeat.o(180567);
      return str;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<af>
    {
      a(y.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<String>
    {
      b(y.d paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y
 * JD-Core Version:    0.7.0.1
 */