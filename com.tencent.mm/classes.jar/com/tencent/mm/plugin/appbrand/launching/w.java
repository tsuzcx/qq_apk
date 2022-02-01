package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "", "ERROR", "Factory", "IReporter", "Request", "Response", "SOURCE", "VERSION", "plugin-appbrand-integration_release"})
public abstract interface w
{
  public static final b pUP = b.pVc;
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "OK", "FAILED", "LOCAL_FILE_NOT_FOUND", "PKG_INTEGRITY_FAILED", "PKG_INVALID", "SEVER_FILE_NOT_FOUND", "DISK_FULL", "PKG_RECORD_NULL", "PKG_RECORD_INVALID", "CGI_GET_URL_FAILED", "ENV_ERR", "plugin-appbrand-integration_release"})
  public static enum a
  {
    public final int code;
    
    static
    {
      AppMethodBeat.i(180556);
      a locala1 = new a("OK", 0, 0);
      pUQ = locala1;
      a locala2 = new a("FAILED", 1, 101);
      pUR = locala2;
      a locala3 = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
      pUS = locala3;
      a locala4 = new a("PKG_INTEGRITY_FAILED", 3, 104);
      pUT = locala4;
      a locala5 = new a("PKG_INVALID", 4, 105);
      pUU = locala5;
      a locala6 = new a("SEVER_FILE_NOT_FOUND", 5, 106);
      pUV = locala6;
      a locala7 = new a("DISK_FULL", 6, 110);
      pUW = locala7;
      a locala8 = new a("PKG_RECORD_NULL", 7, 111);
      pUX = locala8;
      a locala9 = new a("PKG_RECORD_INVALID", 8, 112);
      pUY = locala9;
      a locala10 = new a("CGI_GET_URL_FAILED", 9, 113);
      pUZ = locala10;
      a locala11 = new a("ENV_ERR", 10, 200);
      pVa = locala11;
      pVb = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11 };
      AppMethodBeat.o(180556);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Factory;", "", "()V", "waitForPkg", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "scene", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    static
    {
      AppMethodBeat.i(180564);
      pVc = new b();
      AppMethodBeat.o(180564);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
    static final class a
      extends q
      implements b<WxaPkgLoadProgress, kotlin.x>
    {
      public static final a pVd;
      
      static
      {
        AppMethodBeat.i(180560);
        pVd = new a();
        AppMethodBeat.o(180560);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(w.d paramd, b paramb1, kotlin.g.a.m paramm, b paramb2, x paramx, ack paramack, w.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(264848);
        Object localObject2 = new m(this.nKq, this.ouf, this.pTS, this.pVe, this.pVf, this.pVg, this.pVh);
        Object localObject1 = m.pUd;
        localObject1 = m.b.a(((m)localObject2).bZL(), ((m)localObject2).pTW, ((m)localObject2).pTY.cBU, ((m)localObject2).pTY.pVk);
        int i;
        if (localObject1 == null)
        {
          if (((((m)localObject2).pTY.pVk instanceof w.g.b)) && (j.a.za(((m)localObject2).pTY.cBU))) {
            i = 1;
          }
          while (i != 0)
          {
            ((m)localObject2).bZM();
            AppMethodBeat.o(264848);
            return;
            if ((((m)localObject2).pTW.bGV()) && (j.a.za(((m)localObject2).pTY.cBU))) {
              i = 1;
            } else if ((((m)localObject2).pTW.bGV()) && (j.a.vB(((m)localObject2).pTY.cBU)) && ((((m)localObject2).pTY.pVk instanceof w.g.a))) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
        if (localObject1 == null)
        {
          ((m)localObject2).pTZ.invoke(w.a.pUX, null);
          AppMethodBeat.o(264848);
          return;
        }
        Object localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_versionMd5;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label290;
          }
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.md5 is EMPTY, will download with request " + ((m)localObject2).pTY);
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label505;
          }
          ((m)localObject2).bZM();
          AppMethodBeat.o(264848);
          return;
          i = 0;
          break;
          label290:
          localObject3 = (CharSequence)((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath;
          if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label354;
            }
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "record.path is EMPTY, will download with request " + ((m)localObject2).pTY);
            i = 1;
            break;
          }
          label354:
          if (((((m)localObject2).pTY.pVk instanceof w.g.b)) && (((w.g.b)((m)localObject2).pTY.pVk).pVr))
          {
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(forceUpdate) requested, will download with request " + ((m)localObject2).pTY);
            i = 1;
          }
          else if (((((m)localObject2).pTY.pVk instanceof w.g.b)) && (((w.g.b)((m)localObject2).pTY.pVk).version > ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_version))
          {
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "LATEST(version:" + ((w.g.b)((m)localObject2).pTY.pVk).version + " requested, > record.version(" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_version + "))");
            i = 1;
          }
          else
          {
            i = 0;
          }
        }
        label505:
        localObject3 = WxaPkgIntegrityChecker.acX(((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath);
        Object localObject4;
        if (p.h(((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_versionMd5, localObject3))
        {
          localObject4 = (CharSequence)localObject3;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
          for (i = 1; i == 0; i = 0)
          {
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with LegacyMd5, invoke onSuccess, request=" + ((m)localObject2).pTY + ", version:" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_version + ", md5:" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_versionMd5 + ", path:" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath);
            localObject3 = ((m)localObject2).pTV;
            localObject4 = m.c.pUq;
            localObject2 = ((m)localObject2).pTY;
            localObject4 = ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath;
            p.j(localObject4, "record.field_pkgPath");
            ((b)localObject3).invoke(m.c.a((w.d)localObject2, (String)localObject4, ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_versionMd5, ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_version, (w.f)new w.f.a(0)));
            AppMethodBeat.o(264848);
            return;
          }
        }
        if (p.h(((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_NewMd5, localObject3))
        {
          localObject4 = (CharSequence)localObject3;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {
            i = 1;
          }
          while (i == 0) {
            if ((((m)localObject2).pTY.pVl) && (WxaPkg.acQ(((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath) > 0))
            {
              Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, but forceNoEncrypt, waitForDownload instead, request=" + ((m)localObject2).pTY);
              ((m)localObject2).bZM();
              AppMethodBeat.o(264848);
              return;
              i = 0;
            }
            else
            {
              Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached with NewMd5, invoke onSuccess, request=" + ((m)localObject2).pTY + ", version:" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_version + ", NewMd5:" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_NewMd5 + ", path:" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath);
              localObject3 = ((m)localObject2).pTV;
              localObject4 = m.c.pUq;
              localObject2 = ((m)localObject2).pTY;
              localObject4 = ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath;
              p.j(localObject4, "record.field_pkgPath");
              ((b)localObject3).invoke(m.c.a((w.d)localObject2, (String)localObject4, ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_NewMd5, ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_version, (w.f)new w.f.a(0)));
              AppMethodBeat.o(264848);
              return;
            }
          }
        }
        if (u.agG(((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_pkgPath)) {
          Log.e("MicroMsg.AppBrand.CommonPkgFetcher", "start(), check existed pkg fileMd5(" + (String)localObject3 + ")!=recordMd5(" + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_versionMd5 + '|' + ((com.tencent.mm.plugin.appbrand.appcache.g)localObject1).field_NewMd5 + "), request=" + ((m)localObject2).pTY);
        }
        localObject3 = m.c.pUq;
        localObject1 = m.c.a(((m)localObject2).bZL(), ((m)localObject2).pTY, (com.tencent.mm.plugin.appbrand.appcache.g)localObject1);
        if (localObject1 != null)
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), pkg cached by reuse logic, request=" + ((m)localObject2).pTY);
          ((m)localObject2).pTV.invoke(localObject1);
          AppMethodBeat.o(264848);
          return;
        }
        Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "start(), no cached pkg, will download with request " + ((m)localObject2).pTY);
        ((m)localObject2).bZM();
        AppMethodBeat.o(264848);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "onPkgUpdated", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(w.d paramd, w.e parame);
    
    public abstract void b(w.d paramd);
    
    public abstract void b(w.d paramd, w.e parame);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "", "appId", "", "moduleName", "packageType", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "forceNoEncrypt", "", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;Z)V", "getAppId", "()Ljava/lang/String;", "getForceNoEncrypt", "()Z", "localQueryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "getLocalQueryKey", "()Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "localQueryKey$delegate", "Lkotlin/Lazy;", "getModuleName", "getPackageType", "()I", "requestId", "getRequestId", "requestId$delegate", "getVersion", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-appbrand-integration_release"})
  public static final class d
  {
    public final String appId;
    public final String cAy;
    final int cBU;
    public final int fyH;
    private final f pVi;
    final f pVj;
    public final w.g pVk;
    public final boolean pVl;
    
    public d(String paramString1, String paramString2, int paramInt1, int paramInt2, w.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(180569);
      this.appId = paramString1;
      this.cAy = paramString2;
      this.fyH = paramInt1;
      this.cBU = paramInt2;
      this.pVk = paramg;
      this.pVl = paramBoolean;
      this.pVi = kotlin.g.ar((a)new a(this));
      this.pVj = kotlin.g.ar((a)new b(this));
      AppMethodBeat.o(180569);
    }
    
    public final ae bZS()
    {
      AppMethodBeat.i(180568);
      ae localae = (ae)this.pVi.getValue();
      AppMethodBeat.o(180568);
      return localae;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180571);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((!p.h(this.appId, paramObject.appId)) || (!p.h(this.cAy, paramObject.cAy)) || (this.fyH != paramObject.fyH) || (this.cBU != paramObject.cBU) || (!p.h(this.pVk, paramObject.pVk)) || (this.pVl != paramObject.pVl)) {}
        }
      }
      else
      {
        AppMethodBeat.o(180571);
        return true;
      }
      AppMethodBeat.o(180571);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180567);
      String str = "Request{ appId=" + this.appId + ',' + " module_name=" + this.cAy + ',' + " package_type=" + this.fyH + ',' + " version_type=" + this.cBU + " app_version=" + this.pVk + " forceNoEncrypt=" + this.pVl + "}";
      AppMethodBeat.o(180567);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "invoke"})
    static final class a
      extends q
      implements a<ae>
    {
      a(w.d paramd)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements a<String>
    {
      b(w.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "pkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;)V", "getPkgInfo", "()Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "getSource", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
  public static final class e
  {
    public final IPkgInfo pVn;
    final w.f pVo;
    
    public e(IPkgInfo paramIPkgInfo, w.f paramf)
    {
      AppMethodBeat.i(180572);
      this.pVn = paramIPkgInfo;
      this.pVo = paramf;
      AppMethodBeat.o(180572);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180575);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!p.h(this.pVn, paramObject.pVn)) || (!p.h(this.pVo, paramObject.pVo))) {}
        }
      }
      else
      {
        AppMethodBeat.o(180575);
        return true;
      }
      AppMethodBeat.o(180575);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(180574);
      Object localObject = this.pVn;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.pVo;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(180574);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(180573);
      String str = "Response(pkgInfo=" + this.pVn + ", source=" + this.pVo + ')';
      AppMethodBeat.o(180573);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "", "()V", "CACHED", "REMOTE", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$CACHED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$REMOTE;", "plugin-appbrand-integration_release"})
  public static abstract class f
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$CACHED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "reason", "", "(I)V", "getReason", "()I", "toString", "", "Companion", "plugin-appbrand-integration_release"})
    public static final class a
      extends w.f
    {
      public static final a pVp;
      final int bnA;
      
      static
      {
        AppMethodBeat.i(274296);
        pVp = new a((byte)0);
        AppMethodBeat.o(274296);
      }
      
      public a(int paramInt)
      {
        super();
        this.bnA = paramInt;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(274295);
        StringBuilder localStringBuilder = new StringBuilder("CACHED(");
        String str;
        switch (this.bnA)
        {
        default: 
          str = "";
        }
        for (;;)
        {
          str = str + ")";
          AppMethodBeat.o(274295);
          return str;
          str = "SELF";
          continue;
          str = "SHARED_MODULE";
          continue;
          str = "SHARED_TEMPLATE";
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$CACHED$Companion;", "", "()V", "SELF", "", "SHARED_MODULE", "SHARED_TEMPLATE", "plugin-appbrand-integration_release"})
      public static final class a {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE$REMOTE;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "()V", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends w.f
    {
      public static final b pVq;
      
      static
      {
        AppMethodBeat.i(280602);
        pVq = new b();
        AppMethodBeat.o(280602);
      }
      
      private b()
      {
        super();
      }
      
      public final String toString()
      {
        return "REMOTE";
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "", "()V", "toInt", "", "DESC", "LATEST", "SPECIFIED", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$DESC;", "plugin-appbrand-integration_release"})
  public static abstract class g
  {
    public int bZT()
    {
      return -1;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$DESC;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "desc", "", "(Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toInt", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends w.g
    {
      final String desc;
      
      public a(String paramString)
      {
        super();
        AppMethodBeat.i(245767);
        this.desc = paramString;
        AppMethodBeat.o(245767);
      }
      
      public final int bZT()
      {
        return 0;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(245770);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!p.h(this.desc, paramObject.desc)) {}
          }
        }
        else
        {
          AppMethodBeat.o(245770);
          return true;
        }
        AppMethodBeat.o(245770);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(245768);
        String str = this.desc;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(245768);
          return i;
        }
        AppMethodBeat.o(245768);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(245766);
        String str = "DESC(" + this.desc + ')';
        AppMethodBeat.o(245766);
        return str;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "forceUpdate", "", "(IZ)V", "getForceUpdate", "()Z", "getVersion", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toForceUpdate", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends w.g
    {
      final boolean pVr;
      final int version;
      
      public b()
      {
        this(0, false, 3);
      }
      
      private b(int paramInt, boolean paramBoolean)
      {
        super();
        this.version = paramInt;
        this.pVr = paramBoolean;
      }
      
      public final b bZU()
      {
        AppMethodBeat.i(282491);
        b localb = new b(this.version, true);
        AppMethodBeat.o(282491);
        return localb;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if ((this.version != paramObject.version) || (this.pVr != paramObject.pVr)) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(180579);
        String str = "LATEST(" + this.version + "|forceUpdate:" + this.pVr + ')';
        AppMethodBeat.o(180579);
        return str;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "templateId", "", "(IJ)V", "getTemplateId", "()J", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toInt", "toLong", "toString", "", "plugin-appbrand-integration_release"})
    public static final class c
      extends w.g
    {
      final long obN;
      public final int version;
      
      public c(int paramInt, long paramLong)
      {
        super();
        this.version = paramInt;
        this.obN = paramLong;
      }
      
      public final int bZT()
      {
        return this.version;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof c))
          {
            paramObject = (c)paramObject;
            if ((this.version != paramObject.version) || (this.obN != paramObject.obN)) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        int i = this.version;
        long l = this.obN;
        return i * 31 + (int)(l ^ l >>> 32);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(180580);
        if (this.obN >= 0L)
        {
          str = "VERSION(" + this.version + '|' + this.obN + ')';
          AppMethodBeat.o(180580);
          return str;
        }
        String str = "VERSION(" + this.version + ')';
        AppMethodBeat.o(180580);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.w
 * JD-Core Version:    0.7.0.1
 */