package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.m.a.a.a.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f
  extends com.tencent.mm.plugin.appbrand.p
{
  com.tencent.mm.plugin.m.a.a.a lVh;
  
  public f(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
  }
  
  public final r aWB()
  {
    AppMethodBeat.i(47570);
    g localg2 = e.SU(this.mAppId);
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = new g();
    }
    AppMethodBeat.o(47570);
    return localg1;
  }
  
  public final t aWC()
  {
    AppMethodBeat.i(47569);
    c localc = new c(com.tencent.mm.sdk.f.a.jw(this.mContext), this);
    AppMethodBeat.o(47569);
    return localc;
  }
  
  public final void aXC()
  {
    AppMethodBeat.i(175012);
    super.aXC();
    com.tencent.mm.plugin.m.a.a.a locala = this.lVh;
    if (locala.lZl != null)
    {
      Object localObject1 = bg.M((AppBrandRuntime)locala.lZl);
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IWxaPkgRuntimeReader");
        AppMethodBeat.o(175012);
        throw ((Throwable)localObject1);
      }
      localObject1 = (q)localObject1;
      HashMap localHashMap1 = new HashMap();
      List localList = (List)new ArrayList();
      Object localObject2 = ((q)localObject1).bah();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)d.a.v.NhH;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxaPkg.Info)((Iterator)localObject1).next();
        HashMap localHashMap2 = new HashMap();
        Map localMap = (Map)localHashMap2;
        String str = ((WxaPkg.Info)localObject2).fileName;
        d.g.b.p.g(str, "info.fileName");
        localMap.put("fileName", str);
        localMap = (Map)localHashMap2;
        str = ((WxaPkg.Info)localObject2).jKL;
        d.g.b.p.g(str, "info.pkgFilePath");
        localMap.put("pkgFilePath", str);
        ((Map)localHashMap2).put("fileOffset", Integer.valueOf(((WxaPkg.Info)localObject2).jIN));
        ((Map)localHashMap2).put("fileLength", Integer.valueOf(((WxaPkg.Info)localObject2).jIO));
        localList.add(localHashMap2);
      }
      localObject1 = (Map)localHashMap1;
      localObject2 = new com.google.a.g().yv().toJson(localList);
      d.g.b.p.g(localObject2, "GsonBuilder().create().toJson(filesInfo)");
      ((Map)localObject1).put("filesInfo", localObject2);
      localObject1 = locala.vNY;
      localObject2 = com.tencent.mm.plugin.m.a.a.a.a.vOn;
      com.tencent.mm.plugin.m.a.a.a.a.dmP().g(((d)localObject1).vOc, "sendFilesInfo", localHashMap1);
    }
    AppMethodBeat.o(175012);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(47572);
    super.onCreate();
    this.lVh = new com.tencent.mm.plugin.m.a.a.a(com.tencent.mm.sdk.f.a.jw(this.mContext), this, "wxa", "com.tencent.mm/appbrand_flutter_ui");
    AppMethodBeat.o(47572);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47568);
    super.onResume();
    e.SS(this.mAppId);
    AppMethodBeat.o(47568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.f
 * JD-Core Version:    0.7.0.1
 */