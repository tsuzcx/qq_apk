package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import d.g.b.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f
  extends o
{
  com.tencent.mm.plugin.m.a.a.a lrw;
  
  public f(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final com.tencent.mm.plugin.appbrand.q aSM()
  {
    AppMethodBeat.i(47570);
    g localg2 = e.OI(this.mAppId);
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = new g();
    }
    AppMethodBeat.o(47570);
    return localg1;
  }
  
  public final u aSN()
  {
    AppMethodBeat.i(47569);
    c localc = new c(com.tencent.mm.sdk.f.a.jg(this.mContext), this);
    AppMethodBeat.o(47569);
    return localc;
  }
  
  public final void aTX()
  {
    AppMethodBeat.i(175012);
    super.aTX();
    com.tencent.mm.plugin.m.a.a.a locala = this.lrw;
    if (locala.lvz != null)
    {
      Object localObject1 = be.U((AppBrandRuntime)locala.lvz);
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IWxaPkgRuntimeReader");
        AppMethodBeat.o(175012);
        throw ((Throwable)localObject1);
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.appcache.q)localObject1;
      HashMap localHashMap1 = new HashMap();
      List localList = (List)new ArrayList();
      Object localObject2 = ((com.tencent.mm.plugin.appbrand.appcache.q)localObject1).aWp();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)d.a.v.KTF;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxaPkg.Info)((Iterator)localObject1).next();
        HashMap localHashMap2 = new HashMap();
        Map localMap = (Map)localHashMap2;
        String str = ((WxaPkg.Info)localObject2).fileName;
        k.g(str, "info.fileName");
        localMap.put("fileName", str);
        localMap = (Map)localHashMap2;
        str = ((WxaPkg.Info)localObject2).jnN;
        k.g(str, "info.pkgFilePath");
        localMap.put("pkgFilePath", str);
        ((Map)localHashMap2).put("fileOffset", Integer.valueOf(((WxaPkg.Info)localObject2).jlY));
        ((Map)localHashMap2).put("fileLength", Integer.valueOf(((WxaPkg.Info)localObject2).jlZ));
        localList.add(localHashMap2);
      }
      localObject1 = (Map)localHashMap1;
      localObject2 = new com.google.a.g().wY().toJson(localList);
      k.g(localObject2, "GsonBuilder().create().toJson(filesInfo)");
      ((Map)localObject1).put("filesInfo", localObject2);
      localObject1 = locala.uzr;
      localObject2 = com.tencent.mm.plugin.m.a.a.a.a.uzG;
      com.tencent.mm.plugin.m.a.a.a.a.daD().f(((d)localObject1).uzv, "sendFilesInfo", localHashMap1);
    }
    AppMethodBeat.o(175012);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(47572);
    super.onCreate();
    this.lrw = new com.tencent.mm.plugin.m.a.a.a(com.tencent.mm.sdk.f.a.jg(this.mContext), this, "wxa", "com.tencent.mm/appbrand_flutter_ui");
    AppMethodBeat.o(47572);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47568);
    super.onResume();
    e.OG(this.mAppId);
    AppMethodBeat.o(47568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.f
 * JD-Core Version:    0.7.0.1
 */