package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.protocal.protobuf.acc;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "", "ERROR", "Factory", "IReporter", "Request", "Response", "SOURCE", "VERSION", "plugin-appbrand-integration_release"})
public abstract interface x
{
  public static final b mTR = b.mUe;
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "OK", "FAILED", "LOCAL_FILE_NOT_FOUND", "PKG_INTEGRITY_FAILED", "PKG_INVALID", "SEVER_FILE_NOT_FOUND", "DISK_FULL", "PKG_RECORD_NULL", "PKG_RECORD_INVALID", "CGI_GET_URL_FAILED", "ENV_ERR", "plugin-appbrand-integration_release"})
  public static enum a
  {
    public final int code;
    
    static
    {
      AppMethodBeat.i(180556);
      a locala1 = new a("OK", 0, 0);
      mTS = locala1;
      a locala2 = new a("FAILED", 1, 101);
      mTT = locala2;
      a locala3 = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
      mTU = locala3;
      a locala4 = new a("PKG_INTEGRITY_FAILED", 3, 104);
      mTV = locala4;
      a locala5 = new a("PKG_INVALID", 4, 105);
      mTW = locala5;
      a locala6 = new a("SEVER_FILE_NOT_FOUND", 5, 106);
      mTX = locala6;
      a locala7 = new a("DISK_FULL", 6, 110);
      mTY = locala7;
      a locala8 = new a("PKG_RECORD_NULL", 7, 111);
      mTZ = locala8;
      a locala9 = new a("PKG_RECORD_INVALID", 8, 112);
      mUa = locala9;
      a locala10 = new a("CGI_GET_URL_FAILED", 9, 113);
      mUb = locala10;
      a locala11 = new a("ENV_ERR", 10, 200);
      mUc = locala11;
      mUd = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11 };
      AppMethodBeat.o(180556);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Factory;", "", "()V", "waitForPkg", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "scene", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    static
    {
      AppMethodBeat.i(180564);
      mUe = new b();
      AppMethodBeat.o(180564);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
    static final class a
      extends q
      implements b<WxaPkgLoadProgress, kotlin.x>
    {
      public static final a mUf;
      
      static
      {
        AppMethodBeat.i(180560);
        mUf = new a();
        AppMethodBeat.o(180560);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements a<kotlin.x>
    {
      b(x.d paramd, b paramb1, m paramm, b paramb2, y paramy, acc paramacc, x.c paramc)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "onPkgUpdated", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void b(x.d paramd);
    
    public abstract void b(x.d paramd, x.e parame);
    
    public abstract void c(x.d paramd, x.e parame);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "", "appId", "", "moduleName", "packageType", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "forceNoEncrypt", "", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;Z)V", "getAppId", "()Ljava/lang/String;", "getForceNoEncrypt", "()Z", "localQueryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "getLocalQueryKey", "()Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "localQueryKey$delegate", "Lkotlin/Lazy;", "getModuleName", "getPackageType", "()I", "getVersion", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-appbrand-integration_release"})
  public static final class d
  {
    public final String appId;
    public final String cBp;
    final int iOo;
    private final f mUk;
    public final x.g mUl;
    public final boolean mUm;
    public final int packageType;
    
    public d(String paramString1, String paramString2, int paramInt1, int paramInt2, x.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(180569);
      this.appId = paramString1;
      this.cBp = paramString2;
      this.packageType = paramInt1;
      this.iOo = paramInt2;
      this.mUl = paramg;
      this.mUm = paramBoolean;
      this.mUk = g.ah((a)new a(this));
      AppMethodBeat.o(180569);
    }
    
    public final ad bNz()
    {
      AppMethodBeat.i(180568);
      ad localad = (ad)this.mUk.getValue();
      AppMethodBeat.o(180568);
      return localad;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180571);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((!p.j(this.appId, paramObject.appId)) || (!p.j(this.cBp, paramObject.cBp)) || (this.packageType != paramObject.packageType) || (this.iOo != paramObject.iOo) || (!p.j(this.mUl, paramObject.mUl)) || (this.mUm != paramObject.mUm)) {}
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
      String str = "Request{ appId=" + this.appId + ',' + " module_name=" + this.cBp + ',' + " package_type=" + this.packageType + ',' + " version_type=" + this.iOo + " app_version=" + this.mUl + " forceNoEncrypt=" + this.mUm + "}";
      AppMethodBeat.o(180567);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "invoke"})
    static final class a
      extends q
      implements a<ad>
    {
      a(x.d paramd)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "pkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;)V", "getPkgInfo", "()Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "getSource", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
  public static final class e
  {
    public final IPkgInfo mUo;
    final x.f mUp;
    
    public e(IPkgInfo paramIPkgInfo, x.f paramf)
    {
      AppMethodBeat.i(180572);
      this.mUo = paramIPkgInfo;
      this.mUp = paramf;
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
          if ((!p.j(this.mUo, paramObject.mUo)) || (!p.j(this.mUp, paramObject.mUp))) {}
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
      Object localObject = this.mUo;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.mUp;
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
      String str = "Response(pkgInfo=" + this.mUo + ", source=" + this.mUp + ')';
      AppMethodBeat.o(180573);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "", "(Ljava/lang/String;I)V", "CACHED", "REMOTE", "plugin-appbrand-integration_release"})
  public static enum f
  {
    static
    {
      AppMethodBeat.i(180576);
      f localf1 = new f("CACHED", 0);
      mUq = localf1;
      f localf2 = new f("REMOTE", 1);
      mUr = localf2;
      mUs = new f[] { localf1, localf2 };
      AppMethodBeat.o(180576);
    }
    
    private f() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "", "()V", "LATEST", "SPECIFIED", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "plugin-appbrand-integration_release"})
  public static abstract class g
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "forceUpdate", "", "(IZ)V", "getForceUpdate", "()Z", "getVersion", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toForceUpdate", "toString", "", "plugin-appbrand-integration_release"})
    public static final class a
      extends x.g
    {
      final boolean mUt;
      final int version;
      
      public a()
      {
        this(0, false, 3);
      }
      
      private a(int paramInt, boolean paramBoolean)
      {
        super();
        this.version = paramInt;
        this.mUt = paramBoolean;
      }
      
      public final a bNA()
      {
        AppMethodBeat.i(228659);
        a locala = new a(this.version, true);
        AppMethodBeat.o(228659);
        return locala;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.version != paramObject.version) || (this.mUt != paramObject.mUt)) {}
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
        String str = "LATEST(" + this.version + "|forceUpdate:" + this.mUt + ')';
        AppMethodBeat.o(180579);
        return str;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toInt", "toLong", "", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends x.g
    {
      public final int version;
      
      public b(int paramInt)
      {
        super();
        this.version = paramInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if (this.version != paramObject.version) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        return this.version;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(180580);
        String str = "VERSION(" + this.version + ')';
        AppMethodBeat.o(180580);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.x
 * JD-Core Version:    0.7.0.1
 */