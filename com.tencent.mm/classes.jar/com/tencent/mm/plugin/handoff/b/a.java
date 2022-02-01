package com.tencent.mm.plugin.handoff.b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffFile.a;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.ae;
import d.a.j;
import d.l;
import d.o;
import d.u;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffService;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "FIX_DELAY", "", "MSG_FIX", "", "TAG", "", "fileCache", "Landroid/support/v4/util/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "fileStack", "", "fixHandler", "Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "isForeground", "", "isInQB", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "qbFile", "statusManager", "Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "wc", "webPageStack", "add", "", "handOff", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addWindowFromBall", "allList", "ballInfo2HandOff", "cache", "cancelUpload", "id", "del", "key", "delAllFloatingWindow", "doFix", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "mod", "modFromBallInfo", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onRegister", "onUnregister", "onWebViewCreate", "onWebViewDestroy", "restoreFromBallInfoList", "ballInfoList", "", "uploadFail", "arg", "uploadStart", "info", "uploadSuccess", "appId", "sdkVersion", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "upsert", "FixHandler", "plugin-handoff_release"})
public final class a
  implements b, com.tencent.mm.plugin.handoff.a.a, k.a
{
  private static boolean cqM;
  static HandOff tBn;
  private static HandOff tBo;
  private static ConcurrentHashMap<String, HandOff> tBp;
  private static final android.support.v4.e.a<String, o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c>> tBq;
  private static final Set<String> tBr;
  private static final Set<String> tBs;
  private static boolean tBt;
  private static final c tBu;
  private static final a tBv;
  public static final a tBw;
  
  static
  {
    AppMethodBeat.i(10371);
    tBw = new a();
    tBp = new ConcurrentHashMap();
    tBq = new android.support.v4.e.a();
    tBr = (Set)new LinkedHashSet();
    tBs = (Set)new LinkedHashSet();
    cqM = true;
    tBu = new c();
    Looper localLooper = Looper.getMainLooper();
    d.g.b.k.g(localLooper, "Looper.getMainLooper()");
    tBv = new a(localLooper);
    AppMethodBeat.o(10371);
  }
  
  @SuppressLint({"SwitchIntDef"})
  private static final HandOff M(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10341);
    Object localObject;
    switch (paramBallInfo.type)
    {
    case 3: 
    default: 
      localObject = null;
    }
    while (localObject != null)
    {
      String str1 = paramBallInfo.key;
      d.g.b.k.g(str1, "ballInfo.key");
      ((HandOff)localObject).setKey(str1);
      ((HandOff)localObject).createTime = paramBallInfo.createTime;
      AppMethodBeat.o(10341);
      return localObject;
      localObject = bs.nullAsNil(paramBallInfo.name);
      str1 = bs.nullAsNil(paramBallInfo.hSN.getString("rawUrl"));
      String str2 = bs.nullAsNil(paramBallInfo.drM);
      d.g.b.k.g(localObject, "title");
      d.g.b.k.g(str1, "url");
      d.g.b.k.g(str2, "icon");
      localObject = (HandOff)new HandOffURL((String)localObject, str1, str2, 2, null, null, null, 112);
      continue;
      localObject = bs.nullAsNil(paramBallInfo.drM);
      str1 = bs.nullAsNil(paramBallInfo.name);
      str2 = bs.nullAsNil(paramBallInfo.hSN.getString("appId"));
      String str3 = bs.nullAsNil(paramBallInfo.hSN.getString("username"));
      d.g.b.k.g(localObject, "icon");
      d.g.b.k.g(str1, "title");
      d.g.b.k.g(str2, "appId");
      d.g.b.k.g(str3, "username");
      localObject = (HandOff)new HandOffMP((String)localObject, str1, str2, "", str3, 2);
      continue;
      localObject = HandOffFile.tBi;
      localObject = (HandOff)HandOffFile.a.L(paramBallInfo);
    }
    AppMethodBeat.o(10341);
    return null;
  }
  
  public static void cSI()
  {
    AppMethodBeat.i(10368);
    ac.i("HandOffService", "onAppForeground");
    cqM = true;
    c localc = tBu;
    Collection localCollection = tBp.values();
    d.g.b.k.g(localCollection, "items.values");
    localc.l(localCollection);
    AppMethodBeat.o(10368);
  }
  
  public static void cSJ()
  {
    AppMethodBeat.i(10369);
    ac.i("HandOffService", "onAppBackground");
    cqM = false;
    if (!tBt)
    {
      c localc = tBu;
      Collection localCollection = tBp.values();
      d.g.b.k.g(localCollection, "items.values");
      Object localObject1 = (Iterable)localCollection;
      localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label116:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((HandOff)localObject2).tBa == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label116;
          }
          localCollection.add(localObject2);
          break;
        }
      }
      localc.k((Collection)localCollection);
    }
    AppMethodBeat.o(10369);
  }
  
  private void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(10353);
    d.g.b.k.h(paramHandOff, "handOff");
    ((Map)tBp).put(paramHandOff.key, paramHandOff);
    if (((paramHandOff instanceof HandOffFile)) && (((HandOffFile)paramHandOff).dbL == 2) && (d.g.b.k.g(paramHandOff.id, "-1")))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(af.class);
      d.g.b.k.g(locala, "MMKernel.plugin(IPluginFav::class.java)");
      ((af)locala).getFavItemInfoStorage().add((k.a)this);
    }
    tBu.k(paramHandOff);
    AppMethodBeat.o(10353);
  }
  
  private static void l(HandOff paramHandOff)
  {
    AppMethodBeat.i(10354);
    d.g.b.k.h(paramHandOff, "handOff");
    HandOff localHandOff = (HandOff)tBp.get(paramHandOff.key);
    if (localHandOff != null)
    {
      localHandOff.j(paramHandOff);
      paramHandOff = tBu;
      d.g.b.k.g(localHandOff, "it");
      paramHandOff.l(localHandOff);
      AppMethodBeat.o(10354);
      return;
    }
    AppMethodBeat.o(10354);
  }
  
  public final void I(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10351);
    d.g.b.k.h(paramBallInfo, "ballInfo");
    paramBallInfo = M(paramBallInfo);
    if (paramBallInfo != null)
    {
      tBw.k(paramBallInfo);
      AppMethodBeat.o(10351);
      return;
    }
    AppMethodBeat.o(10351);
  }
  
  public final void J(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10352);
    d.g.b.k.h(paramBallInfo, "ballInfo");
    paramBallInfo = M(paramBallInfo);
    if (paramBallInfo != null)
    {
      l(paramBallInfo);
      AppMethodBeat.o(10352);
      return;
    }
    AppMethodBeat.o(10352);
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10346);
    d.g.b.k.h(paramHandOff, "handOff");
    tBr.add(paramHandOff.key);
    e(paramHandOff);
    tBv.removeMessages(1);
    ac.i("HandOffService", "onWebViewCreate: numWebPages = " + tBr.size());
    AppMethodBeat.o(10346);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(10370);
    d.g.b.k.h(paramString, "event");
    d.g.b.k.h(paramm, "eventData");
    Object localObject = com.tencent.mm.kernel.g.ad(af.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginFav::class.java)");
    localObject = ((af)localObject).getFavItemInfoStorage().tH(Long.parseLong(paramString));
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_type == 8) && (paramm.jRj == 3))
    {
      paramString = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.nxC;
      d.g.b.k.g(paramString, "favItemInfo.field_favProto.dataList");
      paramm = (agx)j.iP((List)paramString);
      if (paramm != null)
      {
        paramString = (CharSequence)paramm.eRy();
        int i;
        if ((paramString == null) || (paramString.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label364;
          }
          str = paramm.eRB();
          paramString = tBp.values();
          d.g.b.k.g(paramString, "items.values");
          Iterator localIterator = ((Iterable)paramString).iterator();
          label169:
          if (!localIterator.hasNext()) {
            break label282;
          }
          paramString = localIterator.next();
          HandOff localHandOff = (HandOff)paramString;
          if ((!(localHandOff instanceof HandOffFile)) || (!d.g.b.k.g(((HandOffFile)localHandOff).md5, str)) || (!d.g.b.k.g(((HandOffFile)localHandOff).tBd, "-1"))) {
            break label277;
          }
          i = 1;
          label236:
          if (i == 0) {
            break label280;
          }
        }
        for (;;)
        {
          paramString = (HandOff)paramString;
          if (paramString == null) {
            break label364;
          }
          if (paramString != null) {
            break label287;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.handoff.model.HandOffFile");
          AppMethodBeat.o(10370);
          throw paramString;
          i = 0;
          break;
          label277:
          i = 0;
          break label236;
          label280:
          break label169;
          label282:
          paramString = null;
        }
        label287:
        paramString = (HandOffFile)paramString;
        String str = paramm.eRy();
        d.g.b.k.g(str, "favDataItem.cdnDataUrl");
        paramString.ais(str);
        paramm = paramm.eRz();
        d.g.b.k.g(paramm, "favDataItem.cdnDataKey");
        paramString.ait(paramm);
        paramm = String.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject).field_id);
        d.g.b.k.h(paramm, "<set-?>");
        paramString.tBd = paramm;
        l((HandOff)paramString);
        AppMethodBeat.o(10370);
        return;
      }
    }
    label364:
    AppMethodBeat.o(10370);
  }
  
  public final boolean a(String paramString, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(10358);
    d.g.b.k.h(paramString, "id");
    d.g.b.k.h(paramc, "info");
    Iterator localIterator = ((Map)tBp).entrySet().iterator();
    while (localIterator.hasNext())
    {
      HandOff localHandOff = (HandOff)((Map.Entry)localIterator.next()).getValue();
      if (((localHandOff instanceof HandOffFile)) && (d.g.b.k.g(localHandOff.id, paramString)))
      {
        ((Map)tBq).put(paramString, new o(localHandOff, paramc));
        AppMethodBeat.o(10358);
        return true;
      }
    }
    AppMethodBeat.o(10358);
    return false;
  }
  
  public final void ag(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10361);
    d.g.b.k.h(paramString1, "id");
    d.g.b.k.h(paramString2, "cdnURL");
    d.g.b.k.h(paramString3, "aesKey");
    o localo = (o)tBq.get(paramString1);
    if (localo != null)
    {
      ((HandOffFile)localo.first).ais(paramString2);
      ((HandOffFile)localo.first).ait(paramString3);
      tBu.n((HandOff)localo.first);
      tBq.remove(paramString1);
      AppMethodBeat.o(10361);
      return;
    }
    ac.e("HandOffService", "error in file upload success, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10361);
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(10342);
    ac.i("HandOffService", "onRegister");
    AppMethodBeat.o(10342);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(10343);
    ac.i("HandOffService", "onUnregister");
    AppMethodBeat.o(10343);
  }
  
  public final HandOff aip(String paramString)
  {
    AppMethodBeat.i(10350);
    d.g.b.k.h(paramString, "id");
    Object localObject = tBp.values();
    d.g.b.k.g(localObject, "items.values");
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      HandOff localHandOff = (HandOff)localObject;
      if (((localHandOff instanceof HandOffFile)) && (d.g.b.k.g(localHandOff.id, paramString)))
      {
        i = 1;
        label84:
        if (i == 0) {
          break label106;
        }
      }
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (HandOff)paramString;
      AppMethodBeat.o(10350);
      return paramString;
      i = 0;
      break label84;
      label106:
      break;
    }
  }
  
  public final void aiq(String paramString)
  {
    AppMethodBeat.i(10363);
    d.g.b.k.h(paramString, "id");
    o localo = (o)tBq.get(paramString);
    if (localo != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.c)localo.second).field_status = 105L;
      tBq.remove(paramString);
      AppMethodBeat.o(10363);
      return;
    }
    ac.e("HandOffService", "error in cancel file upload, handoff with md5 [" + paramString + "] lost!");
    AppMethodBeat.o(10363);
  }
  
  public final boolean aw(String paramString, long paramLong)
  {
    AppMethodBeat.i(10359);
    d.g.b.k.h(paramString, "id");
    Object localObject = (o)tBq.get(paramString);
    if (localObject != null)
    {
      paramString = tBu;
      localObject = (HandOff)((o)localObject).first;
      d.g.b.k.h(localObject, "handOff");
      paramString.b(7, (Collection)j.listOf(localObject));
      AppMethodBeat.o(10359);
      return true;
    }
    ac.w("HandOffService", "error in file uploading, handoff with id [" + paramString + "] lost!");
    AppMethodBeat.o(10359);
    return false;
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10347);
    d.g.b.k.h(paramHandOff, "handOff");
    if (tBr.contains(paramHandOff.key))
    {
      tBr.remove(paramHandOff.key);
      del(paramHandOff.key);
    }
    ac.i("HandOffService", "onWebViewDestroy: numWebPages = " + tBr.size());
    AppMethodBeat.o(10347);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10348);
    d.g.b.k.h(paramHandOff, "handOff");
    tBs.add(paramHandOff.key);
    e(paramHandOff);
    tBv.removeMessages(1);
    ac.i("HandOffService", "onFileCreate: filePages = " + tBs.size() + ", key = " + paramHandOff.key);
    AppMethodBeat.o(10348);
  }
  
  public final void cSC()
  {
    AppMethodBeat.i(10344);
    tBv.removeMessages(1);
    tBv.sendEmptyMessageDelayed(1, 10000L);
    AppMethodBeat.o(10344);
  }
  
  public final void cSD()
  {
    AppMethodBeat.i(10357);
    ac.d("HandOffService", "passive all list");
    if (cqM)
    {
      localc = tBu;
      localCollection = tBp.values();
      d.g.b.k.g(localCollection, "items.values");
      localc.l(localCollection);
      AppMethodBeat.o(10357);
      return;
    }
    c localc = tBu;
    Collection localCollection = tBp.values();
    d.g.b.k.g(localCollection, "items.values");
    Object localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label166:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      HandOff localHandOff = (HandOff)localObject2;
      if ((localHandOff.tBa == 2) || ((tBt) && (localHandOff.getDataType() == 1))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label166;
        }
        localCollection.add(localObject2);
        break;
      }
    }
    localc.l((Collection)localCollection);
    AppMethodBeat.o(10357);
  }
  
  public final HandOff cSE()
  {
    return tBn;
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10349);
    d.g.b.k.h(paramHandOff, "handOff");
    if (tBs.contains(paramHandOff.key))
    {
      tBs.remove(paramHandOff.key);
      del(paramHandOff.key);
    }
    ac.i("HandOffService", "onFileDestroy: filePages = " + tBs.size() + ", key = " + paramHandOff.key);
    AppMethodBeat.o(10349);
  }
  
  public final void dV(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10345);
    d.g.b.k.h(paramList, "ballInfoList");
    ac.i("HandOffService", "restore from ballInfoList");
    tBp.clear();
    tBq.clear();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    HandOff localHandOff;
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = M((BallInfo)((Iterator)localObject).next());
      if (localHandOff != null) {
        paramList.add(localHandOff);
      }
    }
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = (HandOff)((Iterator)localObject).next();
      paramList.add(u.Q(localHandOff.key, localHandOff));
    }
    ae.a((Iterable)paramList, (Map)tBp);
    try
    {
      com.tencent.mm.kernel.g.agP();
      if (com.tencent.mm.kernel.a.afX())
      {
        paramList = tBu;
        localObject = tBp.values();
        d.g.b.k.g(localObject, "items.values");
        paramList.j((Collection)localObject);
        AppMethodBeat.o(10345);
        return;
      }
    }
    catch (Exception paramList)
    {
      ac.printErrStackTrace("HandOffService", (Throwable)paramList, "restoreFromBallInfoList fail, exp:%s", new Object[] { paramList });
      AppMethodBeat.o(10345);
    }
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10356);
    d.g.b.k.h(paramString, "key");
    paramString = (HandOff)tBp.remove(paramString);
    if (paramString != null)
    {
      c localc = tBu;
      d.g.b.k.g(paramString, "it");
      localc.m(paramString);
      AppMethodBeat.o(10356);
      return;
    }
    AppMethodBeat.o(10356);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10355);
    d.g.b.k.h(paramHandOff, "handOff");
    if (tBp.containsKey(paramHandOff.key))
    {
      l(paramHandOff.cSG());
      AppMethodBeat.o(10355);
      return;
    }
    k(paramHandOff.cSG());
    AppMethodBeat.o(10355);
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(10364);
    if (paramHandOff != null) {}
    for (paramHandOff = paramHandOff.cSG();; paramHandOff = null)
    {
      tBn = paramHandOff;
      AppMethodBeat.o(10364);
      return;
    }
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10362);
    d.g.b.k.h(paramString1, "id");
    d.g.b.k.h(paramString2, "appId");
    d.g.b.k.h(paramString3, "mediaId");
    o localo = (o)tBq.get(paramString1);
    if (localo != null)
    {
      HandOffFile localHandOffFile = (HandOffFile)localo.first;
      d.g.b.k.h(paramString2, "<set-?>");
      localHandOffFile.appId = paramString2;
      ((HandOffFile)localo.first).nmu = paramInt;
      paramString2 = (HandOffFile)localo.first;
      d.g.b.k.h(paramString3, "<set-?>");
      paramString2.mediaId = paramString3;
      tBu.n((HandOff)localo.first);
      tBq.remove(paramString1);
      AppMethodBeat.o(10362);
      return;
    }
    ac.e("HandOffService", "error in file upload success, handoff with md5 [" + paramString1 + "] lost!");
    AppMethodBeat.o(10362);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10365);
    d.g.b.k.h(paramHandOff, "handOff");
    ac.i("HandOffService", "onQBFileCreate");
    tBt = true;
    tBo = paramHandOff;
    c(paramHandOff);
    AppMethodBeat.o(10365);
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10366);
    d.g.b.k.h(paramHandOff, "handOff");
    ac.i("HandOffService", "onQBFileDestroy");
    tBt = false;
    paramHandOff = tBo;
    if (paramHandOff != null)
    {
      tBw.d(paramHandOff);
      tBo = null;
      AppMethodBeat.o(10366);
      return;
    }
    AppMethodBeat.o(10366);
  }
  
  public final void hf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10360);
    d.g.b.k.h(paramString1, "id");
    d.g.b.k.h(paramString2, "arg");
    Object localObject = (o)tBq.get(paramString1);
    if (localObject != null)
    {
      paramString2 = tBu;
      localObject = (HandOff)((o)localObject).first;
      d.g.b.k.h(localObject, "handOff");
      paramString2.b(8, (Collection)j.listOf(localObject));
      tBq.remove(paramString1);
      AppMethodBeat.o(10360);
      return;
    }
    paramString2 = new d.n.k("opcode=\"\\d+\"").d((CharSequence)paramString2, "opcode=\"8\"");
    paramString2 = new d.n.k("seq=\"\\d+\"").d((CharSequence)paramString2, "seq=\"<![CSEQ]>\"");
    localObject = tBu;
    d.g.b.k.h(paramString2, "msg");
    ((c)localObject).tBO.add(paramString2);
    ((c)localObject).cSN();
    ac.w("HandOffService", "error in file upload fail, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10360);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10367);
    d.g.b.k.h(paramHandOff, "handOff");
    ac.i("HandOffService", "onQBFileDestroy");
    HandOff localHandOff = tBo;
    if (localHandOff != null)
    {
      localHandOff.j(paramHandOff);
      tBw.e(localHandOff);
      AppMethodBeat.o(10367);
      return;
    }
    AppMethodBeat.o(10367);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
  public static final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(10340);
      AppMethodBeat.o(10340);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(10339);
      paramMessage = a.tBw;
      a.cSK();
      AppMethodBeat.o(10339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.a
 * JD-Core Version:    0.7.0.1
 */