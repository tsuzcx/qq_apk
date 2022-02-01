package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import d.f;
import d.g;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "", "ERROR", "Factory", "IReporter", "Request", "Response", "SOURCE", "VERSION", "plugin-appbrand-integration_release"})
public abstract interface y
{
  public static final b lHJ = b.lHV;
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "OK", "FAILED", "LOCAL_FILE_NOT_FOUND", "PKG_INTEGRITY_FAILED", "PKG_INVALID", "SEVER_FILE_NOT_FOUND", "DISK_FULL", "PKG_RECORD_NULL", "PKG_RECORD_INVALID", "ENV_ERR", "plugin-appbrand-integration_release"})
  public static enum a
  {
    final int code;
    
    static
    {
      AppMethodBeat.i(180556);
      a locala1 = new a("OK", 0, 0);
      lHK = locala1;
      a locala2 = new a("FAILED", 1, 101);
      lHL = locala2;
      a locala3 = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
      lHM = locala3;
      a locala4 = new a("PKG_INTEGRITY_FAILED", 3, 104);
      lHN = locala4;
      a locala5 = new a("PKG_INVALID", 4, 105);
      lHO = locala5;
      a locala6 = new a("SEVER_FILE_NOT_FOUND", 5, 106);
      lHP = locala6;
      a locala7 = new a("DISK_FULL", 6, 110);
      lHQ = locala7;
      a locala8 = new a("PKG_RECORD_NULL", 7, 111);
      lHR = locala8;
      a locala9 = new a("PKG_RECORD_INVALID", 8, 112);
      lHS = locala9;
      a locala10 = new a("ENV_ERR", 9, 200);
      lHT = locala10;
      lHU = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10 };
      AppMethodBeat.o(180556);
    }
    
    private a(int paramInt)
    {
      this.code = paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Factory;", "", "()V", "waitForPkg", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    static
    {
      AppMethodBeat.i(180564);
      lHV = new b();
      AppMethodBeat.o(180564);
    }
    
    public static void a(y.d paramd, final b<? super y.e, d.z> paramb, final m<? super y.a, ? super String, d.z> paramm, final b<? super WxaPkgLoadProgress, d.z> paramb1, final z paramz, final y.c paramc)
    {
      AppMethodBeat.i(180562);
      p.h(paramd, "request");
      p.h(paramb, "onSuccess");
      p.h(paramm, "onError");
      p.h(paramb1, "onProgress");
      p.h(paramz, "cgiExecutor");
      c.b(null, (a)new b(paramd, paramb, paramm, paramb1, paramz, paramc));
      AppMethodBeat.o(180562);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
    static final class a
      extends q
      implements b<WxaPkgLoadProgress, d.z>
    {
      public static final a lHW;
      
      static
      {
        AppMethodBeat.i(180560);
        lHW = new a();
        AppMethodBeat.o(180560);
      }
      
      a()
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements a<d.z>
    {
      b(y.d paramd, b paramb1, m paramm, b paramb2, z paramz, y.c paramc)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "", "onPkgCached", "", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "onPkgMissed", "onPkgUpdated", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void b(y.d paramd);
    
    public abstract void b(y.d paramd, y.e parame);
    
    public abstract void c(y.d paramd, y.e parame);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "", "appId", "", "moduleName", "packageType", "", "versionType", "version", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "forceNoEncrypt", "", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;Z)V", "getAppId", "()Ljava/lang/String;", "getForceNoEncrypt", "()Z", "localQueryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "getLocalQueryKey", "()Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "localQueryKey$delegate", "Lkotlin/Lazy;", "getModuleName", "getPackageType", "()I", "getVersion", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "plugin-appbrand-integration_release"})
  public static final class d
  {
    final String appId;
    final String coW;
    final int dnF;
    final int hQh;
    private final f lIa;
    final y.g lIb;
    final boolean lIc;
    
    public d(String paramString1, String paramString2, int paramInt1, int paramInt2, y.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(180569);
      this.appId = paramString1;
      this.coW = paramString2;
      this.dnF = paramInt1;
      this.hQh = paramInt2;
      this.lIb = paramg;
      this.lIc = paramBoolean;
      this.lIa = g.O((a)new a(this));
      AppMethodBeat.o(180569);
    }
    
    public final ac brh()
    {
      AppMethodBeat.i(180568);
      ac localac = (ac)this.lIa.getValue();
      AppMethodBeat.o(180568);
      return localac;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(180571);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((!p.i(this.appId, paramObject.appId)) || (!p.i(this.coW, paramObject.coW)) || (this.dnF != paramObject.dnF) || (this.hQh != paramObject.hQh) || (!p.i(this.lIb, paramObject.lIb)) || (this.lIc != paramObject.lIc)) {}
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
      String str = "Request{ appId=" + this.appId + ',' + " module_name=" + this.coW + ',' + " package_type=" + this.dnF + ',' + " version_type=" + this.hQh + " app_version=" + this.lIb + " forceNoEncrypt=" + this.lIc + "}";
      AppMethodBeat.o(180567);
      return str;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "invoke"})
    static final class a
      extends q
      implements a<ac>
    {
      a(y.d paramd)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "pkgInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;)V", "getPkgInfo", "()Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "getSource", "()Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
  public static final class e
  {
    final IPkgInfo lIe;
    final y.f lIf;
    
    public e(IPkgInfo paramIPkgInfo, y.f paramf)
    {
      AppMethodBeat.i(180572);
      this.lIe = paramIPkgInfo;
      this.lIf = paramf;
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
          if ((!p.i(this.lIe, paramObject.lIe)) || (!p.i(this.lIf, paramObject.lIf))) {}
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
      Object localObject = this.lIe;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.lIf;
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
      String str = "Response(pkgInfo=" + this.lIe + ", source=" + this.lIf + ")";
      AppMethodBeat.o(180573);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "", "(Ljava/lang/String;I)V", "CACHED", "REMOTE", "plugin-appbrand-integration_release"})
  public static enum f
  {
    static
    {
      AppMethodBeat.i(180576);
      f localf1 = new f("CACHED", 0);
      lIg = localf1;
      f localf2 = new f("REMOTE", 1);
      lIh = localf2;
      lIi = new f[] { localf1, localf2 };
      AppMethodBeat.o(180576);
    }
    
    private f() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "", "()V", "LATEST", "SPECIFIED", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "plugin-appbrand-integration_release"})
  public static abstract class g
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$LATEST;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "forceUpdate", "", "(IZ)V", "getForceUpdate", "()Z", "getVersion", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    public static final class a
      extends y.g
    {
      final boolean lIj;
      final int version;
      
      public a()
      {
        this(0, 3);
      }
      
      private a(int paramInt)
      {
        super();
        this.version = paramInt;
        this.lIj = false;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.version != paramObject.version) || (this.lIj != paramObject.lIj)) {}
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
        String str = "LATEST(" + this.version + "|forceUpdate:" + this.lIj + ')';
        AppMethodBeat.o(180579);
        return str;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION$SPECIFIED;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "version", "", "(I)V", "getVersion", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toInt", "toLong", "", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends y.g
    {
      final int version;
      
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y
 * JD-Core Version:    0.7.0.1
 */