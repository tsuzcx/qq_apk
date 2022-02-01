package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.j;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/WeChatOpenMaterialDataSourceAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "()V", "OPEN_MATERIALS_CACHE_PREFIX", "", "PREFETCH_OPEN_MATERIALS_DELAY_MILLS", "", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsByCgi", "fetchOpenMaterialsQuickly", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "parseRawRsp", "rawCgiRsp", "parseRawRspAndCallback", "parseRsp", "rsp", "Lcom/tencent/mm/protocal/protobuf/GetMaterialRecommWxaCardResponse;", "parseRspAndCallback", "prefetchOpenMaterialsOnLaunchAppBrand", "toOpenMaterialDetailModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "Lcom/tencent/mm/protocal/protobuf/MaterialRecommWxaCard;", "toOpenMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "Lcom/tencent/mm/protocal/protobuf/MaterialRecentlyUsedWxaCard;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b
{
  public static final e trJ;
  
  static
  {
    AppMethodBeat.i(323736);
    trJ = new e();
    AppMethodBeat.o(323736);
  }
  
  private static AppBrandOpenMaterialCollection a(cnd paramcnd, MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323698);
    Object localObject1 = paramcnd.aauH;
    s.s(localObject1, "rsp.recently_used_card_list");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dmp)((Iterator)localObject2).next();
      s.s(localObject3, "it");
      localObject4 = new AppBrandOpenMaterialModel(((dmp)localObject3).appid, ((dmp)localObject3).Tqb, ((dmp)localObject3).aaST, ((dmp)localObject3).icon_url, ((dmp)localObject3).aaSS);
      ((AppBrandOpenMaterialModel)localObject4).appName = ((dmp)localObject3).xkX;
      ((Collection)localObject1).add(localObject4);
    }
    localObject1 = (List)localObject1;
    paramcnd = paramcnd.aauI;
    s.s(paramcnd, "rsp.recomm_card_list");
    localObject2 = (Iterable)paramcnd;
    paramcnd = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dmq)((Iterator)localObject2).next();
      s.s(localObject3, "it");
      localObject4 = new AppBrandOpenMaterialDetailModel(((dmq)localObject3).appid, ((dmq)localObject3).Tqb, ((dmq)localObject3).aaST, ((dmq)localObject3).icon_url, ((dmq)localObject3).aaSS, (List)((dmq)localObject3).aazl, ((dmq)localObject3).score, ((dmq)localObject3).desc);
      ((AppBrandOpenMaterialDetailModel)localObject4).appName = ((dmq)localObject3).nickname;
      paramcnd.add(localObject4);
    }
    paramcnd = new AppBrandOpenMaterialCollection(paramMaterialModel, (List)localObject1, (List)paramcnd);
    AppMethodBeat.o(323698);
    return paramcnd;
  }
  
  private static AppBrandOpenMaterialCollection a(String paramString, MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323688);
    cnd localcnd;
    Charset localCharset;
    try
    {
      localcnd = new cnd();
      localCharset = kotlin.n.d.ISO_8859_1;
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(323688);
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", s.X("parseRawRsp, fail since ", paramString));
      paramString = null;
    }
    for (;;)
    {
      AppMethodBeat.o(323688);
      return paramString;
      paramString = paramString.getBytes(localCharset);
      s.s(paramString, "(this as java.lang.String).getBytes(charset)");
      localcnd.parseFrom(paramString);
      paramString = a(localcnd, paramMaterialModel);
    }
  }
  
  private static final void a(j paramj, final MaterialModel paramMaterialModel, int paramInt1, int paramInt2, final String paramString, c paramc)
  {
    AppMethodBeat.i(323720);
    s.u(paramMaterialModel, "$materialModel");
    Log.i("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsByCgi#onCgiBack, errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(c.c.b(paramc.otC) instanceof cnd))
      {
        Log.w("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsByCgi#onCgiBack, responseProtoBuf is not GetMaterialRecommWxaCardResponse");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramj, paramMaterialModel));
        AppMethodBeat.o(323720);
        return;
      }
      paramString = c.c.b(paramc.otC);
      if (paramString == null)
      {
        paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetMaterialRecommWxaCardResponse");
        AppMethodBeat.o(323720);
        throw paramj;
      }
      paramString = (cnd)paramString;
      if (paramj != null) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramj, paramString, paramMaterialModel));
      }
      paramj = s.X("OpenMaterialsRsp###", paramMaterialModel.mimeType);
      Log.d("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", s.X("fetchOpenMaterialsByCgi#onCgiBack, cacheKey: ", paramj));
      paramMaterialModel = f.qBv;
      paramMaterialModel = f.aBP();
      if (paramMaterialModel != null)
      {
        paramString = paramString.toByteArray();
        s.s(paramString, "rsp.toByteArray()");
        paramMaterialModel.putString(paramj, new String(paramString, kotlin.n.d.ISO_8859_1));
      }
      AppMethodBeat.o(323720);
      return;
    }
    Log.w("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsByCgi#onCgiBack, cgi back not ok");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramj, paramMaterialModel));
    AppMethodBeat.o(323720);
  }
  
  private static void b(MaterialModel paramMaterialModel, j paramj)
  {
    AppMethodBeat.i(323680);
    c.a locala = new c.a();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getmaterialrecommwxacard";
    locala.funcId = 5049;
    cnc localcnc = new cnc();
    localcnc.aauG = paramMaterialModel.mimeType;
    ah localah = ah.aiuX;
    locala.otE = ((com.tencent.mm.bx.a)localcnc);
    locala.otF = ((com.tencent.mm.bx.a)new cnd());
    IPCRunCgi.a(locala.bEF(), new e..ExternalSyntheticLambda0(paramj, paramMaterialModel));
    AppMethodBeat.o(323680);
  }
  
  private static final void g(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323706);
    s.u(paramMaterialModel, "$materialModel");
    b(paramMaterialModel, null);
    AppMethodBeat.o(323706);
  }
  
  public final AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323779);
    s.u(paramMaterialModel, "materialModel");
    label179:
    label182:
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = s.X("OpenMaterialsRsp###", paramMaterialModel.mimeType);
        Log.d("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", s.X("fetchOpenMaterialsQuickly, cacheKey: ", localObject1));
        Object localObject3 = f.qBv;
        localObject3 = f.aBP();
        if (localObject3 == null)
        {
          localObject1 = null;
          if (localObject1 != null)
          {
            if (((CharSequence)localObject1).length() != 0) {
              break label179;
            }
            i = 1;
          }
          else
          {
            Log.i("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterialsQuickly, rawCgiRsp is empty");
            localObject1 = AppBrandOpenMaterialCollection.h(paramMaterialModel);
            s.s(localObject1, "dummy(materialModel)");
            return localObject1;
          }
        }
        else
        {
          localObject1 = ((MultiProcessMMKV)localObject3).getString((String)localObject1, null);
          continue;
          localObject3 = a((String)localObject1, paramMaterialModel);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = AppBrandOpenMaterialCollection.h(paramMaterialModel);
            s.s(localObject1, "dummy(materialModel)");
          }
          return localObject1;
        }
      }
      finally
      {
        b(paramMaterialModel, null);
        AppMethodBeat.o(323779);
      }
      for (;;)
      {
        if (i == 0) {
          break label182;
        }
        break;
        i = 0;
      }
    }
  }
  
  public final void a(final MaterialModel paramMaterialModel, final j paramj)
  {
    AppMethodBeat.i(323764);
    s.u(paramMaterialModel, "materialModel");
    s.u(paramj, "fetchOpenMaterialsCallback");
    String str = s.X("OpenMaterialsRsp###", paramMaterialModel.mimeType);
    Log.d("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", s.X("fetchOpenMaterials, cacheKey: ", str));
    Object localObject = f.qBv;
    localObject = f.aBP();
    if (localObject == null)
    {
      str = null;
      if (str != null) {
        if (((CharSequence)str).length() != 0) {
          break label120;
        }
      }
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label125;
      }
      Log.i("MicroMsg.AppBrand.WeChatOpenMaterialDataSource", "fetchOpenMaterials, rawCgiRsp is empty");
      b(paramMaterialModel, paramj);
      AppMethodBeat.o(323764);
      return;
      str = ((MultiProcessMMKV)localObject).getString(str, null);
      break;
    }
    label125:
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(a(str, paramMaterialModel), paramj, paramMaterialModel));
    b(paramMaterialModel, null);
    AppMethodBeat.o(323764);
  }
  
  public final void c(MaterialModel paramMaterialModel)
  {
    AppMethodBeat.i(323755);
    s.u(paramMaterialModel, "materialModel");
    h.ahAA.p(new e..ExternalSyntheticLambda1(paramMaterialModel), 5000L);
    AppMethodBeat.o(323755);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(j paramj, MaterialModel paramMaterialModel)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(j paramj, MaterialModel paramMaterialModel)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, j paramj, MaterialModel paramMaterialModel)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(j paramj, cnd paramcnd, MaterialModel paramMaterialModel)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.e
 * JD-Core Version:    0.7.0.1
 */