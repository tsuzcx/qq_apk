package com.tencent.mm.plugin.handoff.b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.handoff.model.HandOffFile.a;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.k;
import d.o;
import d.u;
import d.v;
import d.z;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/service/HandOffService;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "FIX_DELAY", "", "MSG_FIX", "", "TAG", "", "fileCache", "Landroid/support/v4/util/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "fileStack", "", "fixHandler", "Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "isForeground", "", "isInQB", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "openRequestFromAppBrand", "qbFile", "statusManager", "Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "wc", "webPageStack", "add", "", "handOff", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addWindowFromBall", "allList", "ballInfo2HandOff", "cache", "cancelUpload", "id", "del", "key", "delAllFloatingWindow", "doFix", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "mainThread", "runnable", "Lkotlin/Function0;", "mod", "modFromBallInfo", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onRegister", "onUnregister", "onWebViewCreate", "onWebViewDestroy", "restoreFromBallInfoList", "ballInfoList", "", "sendOpenRequest", "uploadFail", "arg", "uploadStart", "info", "uploadSuccess", "appId", "sdkVersion", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "upsert", "FixHandler", "plugin-handoff_release"})
public final class a
  implements com.tencent.mm.kernel.c.b, com.tencent.mm.plugin.handoff.a.a, k.a
{
  public static boolean cCq;
  static HandOff uPB;
  private static HandOff uPC;
  private static ConcurrentHashMap<String, HandOff> uPD;
  private static final android.support.v4.e.a<String, o<HandOffFile, c>> uPE;
  private static final Set<String> uPF;
  private static final Set<String> uPG;
  public static boolean uPH;
  private static final d uPI;
  private static final a.a uPJ;
  private static ConcurrentHashMap<String, HandOff> uPK;
  public static final a uPL;
  
  static
  {
    AppMethodBeat.i(10371);
    uPL = new a();
    uPD = new ConcurrentHashMap();
    uPE = new android.support.v4.e.a();
    uPF = (Set)new LinkedHashSet();
    uPG = (Set)new LinkedHashSet();
    cCq = true;
    uPI = new d();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    uPJ = new a.a(localLooper);
    uPK = new ConcurrentHashMap();
    AppMethodBeat.o(10371);
  }
  
  public static void A(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(188388);
    if (p.i(Looper.myLooper(), Looper.getMainLooper()))
    {
      parama.invoke();
      AppMethodBeat.o(188388);
      return;
    }
    a.a locala = uPJ;
    if (parama != null) {
      parama = new b(parama);
    }
    for (;;)
    {
      locala.post((Runnable)parama);
      AppMethodBeat.o(188388);
      return;
    }
  }
  
  @SuppressLint({"SwitchIntDef"})
  private static final HandOff P(BallInfo paramBallInfo)
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
      p.g(str1, "ballInfo.key");
      ((HandOff)localObject).setKey(str1);
      ((HandOff)localObject).createTime = paramBallInfo.createTime;
      AppMethodBeat.o(10341);
      return localObject;
      localObject = bu.nullAsNil(paramBallInfo.name);
      str1 = bu.nullAsNil(paramBallInfo.ioY.getString("rawUrl"));
      String str2 = bu.nullAsNil(paramBallInfo.dEM);
      p.g(localObject, "title");
      p.g(str1, "url");
      p.g(str2, "icon");
      localObject = (HandOff)new HandOffURL((String)localObject, str1, str2, 2, null, null, null, 112);
      continue;
      localObject = bu.nullAsNil(paramBallInfo.dEM);
      str1 = bu.nullAsNil(paramBallInfo.name);
      str2 = bu.nullAsNil(paramBallInfo.ioY.getString("appId"));
      String str3 = bu.nullAsNil(paramBallInfo.ioY.getString("username"));
      p.g(localObject, "icon");
      p.g(str1, "title");
      p.g(str2, "appId");
      p.g(str3, "username");
      localObject = (HandOff)new HandOffMP((String)localObject, str1, str2, "", str3, 2);
      continue;
      localObject = HandOffFile.uPw;
      localObject = (HandOff)HandOffFile.a.O(paramBallInfo);
    }
    AppMethodBeat.o(10341);
    return null;
  }
  
  private void l(HandOff paramHandOff)
  {
    AppMethodBeat.i(10353);
    p.h(paramHandOff, "handOff");
    ((Map)uPD).put(paramHandOff.key, paramHandOff);
    if (((paramHandOff instanceof HandOffFile)) && (((HandOffFile)paramHandOff).doj == 2) && (p.i(paramHandOff.id, "-1")))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(af.class);
      p.g(locala, "MMKernel.plugin(IPluginFav::class.java)");
      ((af)locala).getFavItemInfoStorage().add((k.a)this);
    }
    A((d.g.a.a)new b(paramHandOff));
    AppMethodBeat.o(10353);
  }
  
  private static void m(HandOff paramHandOff)
  {
    AppMethodBeat.i(10354);
    p.h(paramHandOff, "handOff");
    HandOff localHandOff = (HandOff)uPD.get(paramHandOff.key);
    if (localHandOff != null)
    {
      localHandOff.k(paramHandOff);
      A((d.g.a.a)new f(localHandOff));
      AppMethodBeat.o(10354);
      return;
    }
    AppMethodBeat.o(10354);
  }
  
  public final void L(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10351);
    p.h(paramBallInfo, "ballInfo");
    paramBallInfo = P(paramBallInfo);
    if (paramBallInfo != null)
    {
      uPL.l(paramBallInfo);
      AppMethodBeat.o(10351);
      return;
    }
    AppMethodBeat.o(10351);
  }
  
  public final void M(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10352);
    p.h(paramBallInfo, "ballInfo");
    paramBallInfo = P(paramBallInfo);
    if (paramBallInfo != null)
    {
      m(paramBallInfo);
      AppMethodBeat.o(10352);
      return;
    }
    AppMethodBeat.o(10352);
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10346);
    p.h(paramHandOff, "handOff");
    uPF.add(paramHandOff.key);
    e(paramHandOff);
    uPJ.removeMessages(1);
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onWebViewCreate: numWebPages = " + uPF.size());
    AppMethodBeat.o(10346);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(10370);
    p.h(paramString, "event");
    p.h(paramm, "eventData");
    Object localObject = com.tencent.mm.kernel.g.ad(af.class);
    p.g(localObject, "MMKernel.plugin(IPluginFav::class.java)");
    localObject = ((af)localObject).getFavItemInfoStorage().vU(Long.parseLong(paramString));
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_type == 8) && (paramm.duP == 3))
    {
      paramString = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.oeJ;
      p.g(paramString, "favItemInfo.field_favProto.dataList");
      paramm = (ajx)j.jm((List)paramString);
      if (paramm != null)
      {
        paramString = (CharSequence)paramm.fks();
        int i;
        if ((paramString == null) || (paramString.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label364;
          }
          str = paramm.fkv();
          paramString = uPD.values();
          p.g(paramString, "items.values");
          Iterator localIterator = ((Iterable)paramString).iterator();
          label169:
          if (!localIterator.hasNext()) {
            break label282;
          }
          paramString = localIterator.next();
          HandOff localHandOff = (HandOff)paramString;
          if ((!(localHandOff instanceof HandOffFile)) || (!p.i(((HandOffFile)localHandOff).md5, str)) || (!p.i(((HandOffFile)localHandOff).uPr, "-1"))) {
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
        String str = paramm.fks();
        p.g(str, "favDataItem.cdnDataUrl");
        paramString.aog(str);
        paramm = paramm.fkt();
        p.g(paramm, "favDataItem.cdnDataKey");
        paramString.aoh(paramm);
        paramm = String.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject).field_id);
        p.h(paramm, "<set-?>");
        paramString.uPr = paramm;
        m((HandOff)paramString);
        AppMethodBeat.o(10370);
        return;
      }
    }
    label364:
    AppMethodBeat.o(10370);
  }
  
  public final boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(10358);
    p.h(paramString, "id");
    p.h(paramc, "info");
    Iterator localIterator = ((Map)uPD).entrySet().iterator();
    while (localIterator.hasNext())
    {
      HandOff localHandOff = (HandOff)((Map.Entry)localIterator.next()).getValue();
      if (((localHandOff instanceof HandOffFile)) && (p.i(localHandOff.id, paramString)))
      {
        ((Map)uPE).put(paramString, new o(localHandOff, paramc));
        AppMethodBeat.o(10358);
        return true;
      }
    }
    AppMethodBeat.o(10358);
    return false;
  }
  
  public final void akM()
  {
    AppMethodBeat.i(10342);
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onRegister");
    AppMethodBeat.o(10342);
  }
  
  public final void akN()
  {
    AppMethodBeat.i(10343);
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onUnregister");
    AppMethodBeat.o(10343);
  }
  
  public final void an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10361);
    p.h(paramString1, "id");
    p.h(paramString2, "cdnURL");
    p.h(paramString3, "aesKey");
    o localo = (o)uPE.get(paramString1);
    if (localo != null)
    {
      ((HandOffFile)localo.first).aog(paramString2);
      ((HandOffFile)localo.first).aoh(paramString3);
      uPI.o((HandOff)localo.first);
      uPE.remove(paramString1);
      AppMethodBeat.o(10361);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("HandOffService", "error in file upload success, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10361);
  }
  
  public final HandOff aod(String paramString)
  {
    AppMethodBeat.i(10350);
    p.h(paramString, "id");
    Object localObject = uPD.values();
    p.g(localObject, "items.values");
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      HandOff localHandOff = (HandOff)localObject;
      if (((localHandOff instanceof HandOffFile)) && (p.i(localHandOff.id, paramString)))
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
  
  public final void aoe(String paramString)
  {
    AppMethodBeat.i(10363);
    p.h(paramString, "id");
    o localo = (o)uPE.get(paramString);
    if (localo != null)
    {
      ((c)localo.second).field_status = 105L;
      uPE.remove(paramString);
      AppMethodBeat.o(10363);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("HandOffService", "error in cancel file upload, handoff with md5 [" + paramString + "] lost!");
    AppMethodBeat.o(10363);
  }
  
  public final boolean az(String paramString, long paramLong)
  {
    AppMethodBeat.i(10359);
    p.h(paramString, "id");
    Object localObject = (o)uPE.get(paramString);
    if (localObject != null)
    {
      paramString = uPI;
      localObject = (HandOff)((o)localObject).first;
      p.h(localObject, "handOff");
      paramString.b(7, (Collection)j.listOf(localObject));
      AppMethodBeat.o(10359);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ae.w("HandOffService", "error in file uploading, handoff with id [" + paramString + "] lost!");
    AppMethodBeat.o(10359);
    return false;
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10347);
    p.h(paramHandOff, "handOff");
    if (uPF.contains(paramHandOff.key))
    {
      uPF.remove(paramHandOff.key);
      del(paramHandOff.key);
    }
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onWebViewDestroy: numWebPages = " + uPF.size());
    AppMethodBeat.o(10347);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10348);
    p.h(paramHandOff, "handOff");
    uPG.add(paramHandOff.key);
    e(paramHandOff);
    uPJ.removeMessages(1);
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onFileCreate: filePages = " + uPG.size() + ", key = " + paramHandOff.key);
    AppMethodBeat.o(10348);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10349);
    p.h(paramHandOff, "handOff");
    if (uPG.contains(paramHandOff.key))
    {
      uPG.remove(paramHandOff.key);
      del(paramHandOff.key);
    }
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onFileDestroy: filePages = " + uPG.size() + ", key = " + paramHandOff.key);
    AppMethodBeat.o(10349);
  }
  
  public final void deA()
  {
    AppMethodBeat.i(10344);
    uPJ.removeMessages(1);
    uPJ.sendEmptyMessageDelayed(1, 10000L);
    AppMethodBeat.o(10344);
  }
  
  public final void deB()
  {
    AppMethodBeat.i(10357);
    com.tencent.mm.sdk.platformtools.ae.d("HandOffService", "passive all list");
    if (cCq)
    {
      A((d.g.a.a)c.uPN);
      AppMethodBeat.o(10357);
      return;
    }
    A((d.g.a.a)d.uPO);
    AppMethodBeat.o(10357);
  }
  
  public final HandOff deC()
  {
    return uPB;
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10356);
    p.h(paramString, "key");
    paramString = (HandOff)uPD.remove(paramString);
    if (paramString != null)
    {
      A((d.g.a.a)new e(paramString));
      AppMethodBeat.o(10356);
      return;
    }
    AppMethodBeat.o(10356);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10355);
    p.h(paramHandOff, "handOff");
    if (uPD.containsKey(paramHandOff.key))
    {
      m(paramHandOff.deE());
      AppMethodBeat.o(10355);
      return;
    }
    l(paramHandOff.deE());
    AppMethodBeat.o(10355);
  }
  
  public final void em(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10345);
    p.h(paramList, "ballInfoList");
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "restore from ballInfoList");
    uPD.clear();
    uPE.clear();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    HandOff localHandOff;
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = P((BallInfo)((Iterator)localObject).next());
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
      paramList.add(u.R(localHandOff.key, localHandOff));
    }
    d.a.ae.a((Iterable)paramList, (Map)uPD);
    try
    {
      com.tencent.mm.kernel.g.ajP();
      if (com.tencent.mm.kernel.a.aiY())
      {
        paramList = uPI;
        localObject = uPD.values();
        p.g(localObject, "items.values");
        paramList.j((Collection)localObject);
        AppMethodBeat.o(10345);
        return;
      }
    }
    catch (Exception paramList)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("HandOffService", (Throwable)paramList, "restoreFromBallInfoList fail, exp:%s", new Object[] { paramList });
      AppMethodBeat.o(10345);
    }
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(188389);
    p.h(paramHandOff, "handOff");
    ((Map)uPK).put(paramHandOff.key, paramHandOff);
    paramHandOff = uPI;
    Collection localCollection = uPK.values();
    p.g(localCollection, "openRequestFromAppBrand.values");
    p.h(localCollection, "handOffList");
    paramHandOff.b(10, localCollection);
    uPK.clear();
    AppMethodBeat.o(188389);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10362);
    p.h(paramString1, "id");
    p.h(paramString2, "appId");
    p.h(paramString3, "mediaId");
    o localo = (o)uPE.get(paramString1);
    if (localo != null)
    {
      HandOffFile localHandOffFile = (HandOffFile)localo.first;
      p.h(paramString2, "<set-?>");
      localHandOffFile.appId = paramString2;
      ((HandOffFile)localo.first).nSG = paramInt;
      paramString2 = (HandOffFile)localo.first;
      p.h(paramString3, "<set-?>");
      paramString2.mediaId = paramString3;
      uPI.o((HandOff)localo.first);
      uPE.remove(paramString1);
      AppMethodBeat.o(10362);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("HandOffService", "error in file upload success, handoff with md5 [" + paramString1 + "] lost!");
    AppMethodBeat.o(10362);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10364);
    if (paramHandOff != null) {}
    for (paramHandOff = paramHandOff.deE();; paramHandOff = null)
    {
      uPB = paramHandOff;
      AppMethodBeat.o(10364);
      return;
    }
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10365);
    p.h(paramHandOff, "handOff");
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onQBFileCreate");
    uPH = true;
    uPC = paramHandOff;
    c(paramHandOff);
    AppMethodBeat.o(10365);
  }
  
  public final void hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10360);
    p.h(paramString1, "id");
    p.h(paramString2, "arg");
    Object localObject = (o)uPE.get(paramString1);
    if (localObject != null)
    {
      paramString2 = uPI;
      localObject = (HandOff)((o)localObject).first;
      p.h(localObject, "handOff");
      paramString2.b(8, (Collection)j.listOf(localObject));
      uPE.remove(paramString1);
      AppMethodBeat.o(10360);
      return;
    }
    paramString2 = new k("opcode=\"\\d+\"").e((CharSequence)paramString2, "opcode=\"8\"");
    paramString2 = new k("seq=\"\\d+\"").e((CharSequence)paramString2, "seq=\"<![CSEQ]>\"");
    localObject = uPI;
    p.h(paramString2, "msg");
    ((d)localObject).uQk.add(paramString2);
    ((d)localObject).deM();
    com.tencent.mm.sdk.platformtools.ae.w("HandOffService", "error in file upload fail, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10360);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10366);
    p.h(paramHandOff, "handOff");
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onQBFileDestroy");
    uPH = false;
    paramHandOff = uPC;
    if (paramHandOff != null)
    {
      uPL.d(paramHandOff);
      uPC = null;
      AppMethodBeat.o(10366);
      return;
    }
    AppMethodBeat.o(10366);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10367);
    p.h(paramHandOff, "handOff");
    com.tencent.mm.sdk.platformtools.ae.i("HandOffService", "onQBFileDestroy");
    HandOff localHandOff = uPC;
    if (localHandOff != null)
    {
      localHandOff.k(paramHandOff);
      uPL.e(localHandOff);
      AppMethodBeat.o(10367);
      return;
    }
    AppMethodBeat.o(10367);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    public static final c uPN;
    
    static
    {
      AppMethodBeat.i(188378);
      uPN = new c();
      AppMethodBeat.o(188378);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    public static final d uPO;
    
    static
    {
      AppMethodBeat.i(188380);
      uPO = new d();
      AppMethodBeat.o(188380);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(HandOff paramHandOff)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class g
    extends q
    implements d.g.a.a<z>
  {
    public static final g uPQ;
    
    static
    {
      AppMethodBeat.i(188384);
      uPQ = new g();
      AppMethodBeat.o(188384);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class h
    extends q
    implements d.g.a.a<z>
  {
    public static final h uPR;
    
    static
    {
      AppMethodBeat.i(188386);
      uPR = new h();
      AppMethodBeat.o(188386);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.a
 * JD-Core Version:    0.7.0.1
 */