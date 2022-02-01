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
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.ae;
import d.a.j;
import d.g.b.p;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/service/HandOffService;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "FIX_DELAY", "", "MSG_FIX", "", "TAG", "", "fileCache", "Landroid/support/v4/util/ArrayMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "fileStack", "", "fixHandler", "Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "isForeground", "", "isInQB", "items", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "qbFile", "statusManager", "Lcom/tencent/mm/plugin/handoff/service/StatusManager;", "wc", "webPageStack", "add", "", "handOff", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addWindowFromBall", "allList", "ballInfo2HandOff", "cache", "cancelUpload", "id", "del", "key", "delAllFloatingWindow", "doFix", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "mainThread", "runnable", "Lkotlin/Function0;", "mod", "modFromBallInfo", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onRegister", "onUnregister", "onWebViewCreate", "onWebViewDestroy", "restoreFromBallInfoList", "ballInfoList", "", "uploadFail", "arg", "uploadStart", "info", "uploadSuccess", "appId", "sdkVersion", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "upsert", "FixHandler", "plugin-handoff_release"})
public final class a
  implements b, com.tencent.mm.plugin.handoff.a.a, k.a
{
  public static boolean cBJ;
  static HandOff uDW;
  private static HandOff uDX;
  private static ConcurrentHashMap<String, HandOff> uDY;
  private static final android.support.v4.e.a<String, o<HandOffFile, com.tencent.mm.pluginsdk.model.app.c>> uDZ;
  private static final Set<String> uEa;
  private static final Set<String> uEb;
  public static boolean uEc;
  private static final c uEd;
  private static final a uEe;
  public static final a uEf;
  
  static
  {
    AppMethodBeat.i(10371);
    uEf = new a();
    uDY = new ConcurrentHashMap();
    uDZ = new android.support.v4.e.a();
    uEa = (Set)new LinkedHashSet();
    uEb = (Set)new LinkedHashSet();
    cBJ = true;
    uEd = new c();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    uEe = new a(localLooper);
    AppMethodBeat.o(10371);
  }
  
  @SuppressLint({"SwitchIntDef"})
  private static final HandOff N(BallInfo paramBallInfo)
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
      localObject = bt.nullAsNil(paramBallInfo.name);
      str1 = bt.nullAsNil(paramBallInfo.ime.getString("rawUrl"));
      String str2 = bt.nullAsNil(paramBallInfo.dDH);
      p.g(localObject, "title");
      p.g(str1, "url");
      p.g(str2, "icon");
      localObject = (HandOff)new HandOffURL((String)localObject, str1, str2, 2, null, null, null, 112);
      continue;
      localObject = bt.nullAsNil(paramBallInfo.dDH);
      str1 = bt.nullAsNil(paramBallInfo.name);
      str2 = bt.nullAsNil(paramBallInfo.ime.getString("appId"));
      String str3 = bt.nullAsNil(paramBallInfo.ime.getString("username"));
      p.g(localObject, "icon");
      p.g(str1, "title");
      p.g(str2, "appId");
      p.g(str3, "username");
      localObject = (HandOff)new HandOffMP((String)localObject, str1, str2, "", str3, 2);
      continue;
      localObject = HandOffFile.uDR;
      localObject = (HandOff)HandOffFile.a.M(paramBallInfo);
    }
    AppMethodBeat.o(10341);
    return null;
  }
  
  public static void X(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(221241);
    if (p.i(Looper.myLooper(), Looper.getMainLooper()))
    {
      parama.invoke();
      AppMethodBeat.o(221241);
      return;
    }
    a locala = uEe;
    if (parama != null) {
      parama = new d(parama);
    }
    for (;;)
    {
      locala.post((Runnable)parama);
      AppMethodBeat.o(221241);
      return;
    }
  }
  
  private void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(10353);
    p.h(paramHandOff, "handOff");
    ((Map)uDY).put(paramHandOff.key, paramHandOff);
    if (((paramHandOff instanceof HandOffFile)) && (((HandOffFile)paramHandOff).dnh == 2) && (p.i(paramHandOff.id, "-1")))
    {
      com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(af.class);
      p.g(locala, "MMKernel.plugin(IPluginFav::class.java)");
      ((af)locala).getFavItemInfoStorage().add((k.a)this);
    }
    X((d.g.a.a)new a.b(paramHandOff));
    AppMethodBeat.o(10353);
  }
  
  private static void l(HandOff paramHandOff)
  {
    AppMethodBeat.i(10354);
    p.h(paramHandOff, "handOff");
    HandOff localHandOff = (HandOff)uDY.get(paramHandOff.key);
    if (localHandOff != null)
    {
      localHandOff.j(paramHandOff);
      X((d.g.a.a)new a.f(localHandOff));
      AppMethodBeat.o(10354);
      return;
    }
    AppMethodBeat.o(10354);
  }
  
  public final void J(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10351);
    p.h(paramBallInfo, "ballInfo");
    paramBallInfo = N(paramBallInfo);
    if (paramBallInfo != null)
    {
      uEf.k(paramBallInfo);
      AppMethodBeat.o(10351);
      return;
    }
    AppMethodBeat.o(10351);
  }
  
  public final void K(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10352);
    p.h(paramBallInfo, "ballInfo");
    paramBallInfo = N(paramBallInfo);
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
    p.h(paramHandOff, "handOff");
    uEa.add(paramHandOff.key);
    e(paramHandOff);
    uEe.removeMessages(1);
    ad.i("HandOffService", "onWebViewCreate: numWebPages = " + uEa.size());
    AppMethodBeat.o(10346);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(10370);
    p.h(paramString, "event");
    p.h(paramm, "eventData");
    Object localObject = com.tencent.mm.kernel.g.ad(af.class);
    p.g(localObject, "MMKernel.plugin(IPluginFav::class.java)");
    localObject = ((af)localObject).getFavItemInfoStorage().vE(Long.parseLong(paramString));
    if ((localObject != null) && (((com.tencent.mm.plugin.fav.a.g)localObject).field_type == 8) && (paramm.dtK == 3))
    {
      paramString = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.nZa;
      p.g(paramString, "favItemInfo.field_favProto.dataList");
      paramm = (ajn)j.jd((List)paramString);
      if (paramm != null)
      {
        paramString = (CharSequence)paramm.fgC();
        int i;
        if ((paramString == null) || (paramString.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label364;
          }
          str = paramm.fgF();
          paramString = uDY.values();
          p.g(paramString, "items.values");
          Iterator localIterator = ((Iterable)paramString).iterator();
          label169:
          if (!localIterator.hasNext()) {
            break label282;
          }
          paramString = localIterator.next();
          HandOff localHandOff = (HandOff)paramString;
          if ((!(localHandOff instanceof HandOffFile)) || (!p.i(((HandOffFile)localHandOff).md5, str)) || (!p.i(((HandOffFile)localHandOff).uDM, "-1"))) {
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
        String str = paramm.fgC();
        p.g(str, "favDataItem.cdnDataUrl");
        paramString.anf(str);
        paramm = paramm.fgD();
        p.g(paramm, "favDataItem.cdnDataKey");
        paramString.ang(paramm);
        paramm = String.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject).field_id);
        p.h(paramm, "<set-?>");
        paramString.uDM = paramm;
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
    p.h(paramString, "id");
    p.h(paramc, "info");
    Iterator localIterator = ((Map)uDY).entrySet().iterator();
    while (localIterator.hasNext())
    {
      HandOff localHandOff = (HandOff)((Map.Entry)localIterator.next()).getValue();
      if (((localHandOff instanceof HandOffFile)) && (p.i(localHandOff.id, paramString)))
      {
        ((Map)uDZ).put(paramString, new o(localHandOff, paramc));
        AppMethodBeat.o(10358);
        return true;
      }
    }
    AppMethodBeat.o(10358);
    return false;
  }
  
  public final void akx()
  {
    AppMethodBeat.i(10342);
    ad.i("HandOffService", "onRegister");
    AppMethodBeat.o(10342);
  }
  
  public final void aky()
  {
    AppMethodBeat.i(10343);
    ad.i("HandOffService", "onUnregister");
    AppMethodBeat.o(10343);
  }
  
  public final void an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10361);
    p.h(paramString1, "id");
    p.h(paramString2, "cdnURL");
    p.h(paramString3, "aesKey");
    o localo = (o)uDZ.get(paramString1);
    if (localo != null)
    {
      ((HandOffFile)localo.first).anf(paramString2);
      ((HandOffFile)localo.first).ang(paramString3);
      uEd.n((HandOff)localo.first);
      uDZ.remove(paramString1);
      AppMethodBeat.o(10361);
      return;
    }
    ad.e("HandOffService", "error in file upload success, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10361);
  }
  
  public final HandOff anc(String paramString)
  {
    AppMethodBeat.i(10350);
    p.h(paramString, "id");
    Object localObject = uDY.values();
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
  
  public final void and(String paramString)
  {
    AppMethodBeat.i(10363);
    p.h(paramString, "id");
    o localo = (o)uDZ.get(paramString);
    if (localo != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.c)localo.second).field_status = 105L;
      uDZ.remove(paramString);
      AppMethodBeat.o(10363);
      return;
    }
    ad.e("HandOffService", "error in cancel file upload, handoff with md5 [" + paramString + "] lost!");
    AppMethodBeat.o(10363);
  }
  
  public final boolean az(String paramString, long paramLong)
  {
    AppMethodBeat.i(10359);
    p.h(paramString, "id");
    Object localObject = (o)uDZ.get(paramString);
    if (localObject != null)
    {
      paramString = uEd;
      localObject = (HandOff)((o)localObject).first;
      p.h(localObject, "handOff");
      paramString.b(7, (Collection)j.listOf(localObject));
      AppMethodBeat.o(10359);
      return true;
    }
    ad.w("HandOffService", "error in file uploading, handoff with id [" + paramString + "] lost!");
    AppMethodBeat.o(10359);
    return false;
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10347);
    p.h(paramHandOff, "handOff");
    if (uEa.contains(paramHandOff.key))
    {
      uEa.remove(paramHandOff.key);
      del(paramHandOff.key);
    }
    ad.i("HandOffService", "onWebViewDestroy: numWebPages = " + uEa.size());
    AppMethodBeat.o(10347);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10348);
    p.h(paramHandOff, "handOff");
    uEb.add(paramHandOff.key);
    e(paramHandOff);
    uEe.removeMessages(1);
    ad.i("HandOffService", "onFileCreate: filePages = " + uEb.size() + ", key = " + paramHandOff.key);
    AppMethodBeat.o(10348);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10349);
    p.h(paramHandOff, "handOff");
    if (uEb.contains(paramHandOff.key))
    {
      uEb.remove(paramHandOff.key);
      del(paramHandOff.key);
    }
    ad.i("HandOffService", "onFileDestroy: filePages = " + uEb.size() + ", key = " + paramHandOff.key);
    AppMethodBeat.o(10349);
  }
  
  public final void dbJ()
  {
    AppMethodBeat.i(10344);
    uEe.removeMessages(1);
    uEe.sendEmptyMessageDelayed(1, 10000L);
    AppMethodBeat.o(10344);
  }
  
  public final void dbK()
  {
    AppMethodBeat.i(10357);
    ad.d("HandOffService", "passive all list");
    if (cBJ)
    {
      X((d.g.a.a)a.c.Odr);
      AppMethodBeat.o(10357);
      return;
    }
    X((d.g.a.a)a.d.Ods);
    AppMethodBeat.o(10357);
  }
  
  public final HandOff dbL()
  {
    return uDW;
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10356);
    p.h(paramString, "key");
    paramString = (HandOff)uDY.remove(paramString);
    if (paramString != null)
    {
      X((d.g.a.a)new a.e(paramString));
      AppMethodBeat.o(10356);
      return;
    }
    AppMethodBeat.o(10356);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10355);
    p.h(paramHandOff, "handOff");
    if (uDY.containsKey(paramHandOff.key))
    {
      l(paramHandOff.dbN());
      AppMethodBeat.o(10355);
      return;
    }
    k(paramHandOff.dbN());
    AppMethodBeat.o(10355);
  }
  
  public final void ei(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10345);
    p.h(paramList, "ballInfoList");
    ad.i("HandOffService", "restore from ballInfoList");
    uDY.clear();
    uDZ.clear();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    HandOff localHandOff;
    while (((Iterator)localObject).hasNext())
    {
      localHandOff = N((BallInfo)((Iterator)localObject).next());
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
      paramList.add(u.S(localHandOff.key, localHandOff));
    }
    ae.a((Iterable)paramList, (Map)uDY);
    try
    {
      com.tencent.mm.kernel.g.ajA();
      if (com.tencent.mm.kernel.a.aiJ())
      {
        paramList = uEd;
        localObject = uDY.values();
        p.g(localObject, "items.values");
        paramList.j((Collection)localObject);
        AppMethodBeat.o(10345);
        return;
      }
    }
    catch (Exception paramList)
    {
      ad.printErrStackTrace("HandOffService", (Throwable)paramList, "restoreFromBallInfoList fail, exp:%s", new Object[] { paramList });
      AppMethodBeat.o(10345);
    }
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(10364);
    if (paramHandOff != null) {}
    for (paramHandOff = paramHandOff.dbN();; paramHandOff = null)
    {
      uDW = paramHandOff;
      AppMethodBeat.o(10364);
      return;
    }
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10362);
    p.h(paramString1, "id");
    p.h(paramString2, "appId");
    p.h(paramString3, "mediaId");
    o localo = (o)uDZ.get(paramString1);
    if (localo != null)
    {
      HandOffFile localHandOffFile = (HandOffFile)localo.first;
      p.h(paramString2, "<set-?>");
      localHandOffFile.appId = paramString2;
      ((HandOffFile)localo.first).nNb = paramInt;
      paramString2 = (HandOffFile)localo.first;
      p.h(paramString3, "<set-?>");
      paramString2.mediaId = paramString3;
      uEd.n((HandOff)localo.first);
      uDZ.remove(paramString1);
      AppMethodBeat.o(10362);
      return;
    }
    ad.e("HandOffService", "error in file upload success, handoff with md5 [" + paramString1 + "] lost!");
    AppMethodBeat.o(10362);
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10365);
    p.h(paramHandOff, "handOff");
    ad.i("HandOffService", "onQBFileCreate");
    uEc = true;
    uDX = paramHandOff;
    c(paramHandOff);
    AppMethodBeat.o(10365);
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10366);
    p.h(paramHandOff, "handOff");
    ad.i("HandOffService", "onQBFileDestroy");
    uEc = false;
    paramHandOff = uDX;
    if (paramHandOff != null)
    {
      uEf.d(paramHandOff);
      uDX = null;
      AppMethodBeat.o(10366);
      return;
    }
    AppMethodBeat.o(10366);
  }
  
  public final void hr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10360);
    p.h(paramString1, "id");
    p.h(paramString2, "arg");
    Object localObject = (o)uDZ.get(paramString1);
    if (localObject != null)
    {
      paramString2 = uEd;
      localObject = (HandOff)((o)localObject).first;
      p.h(localObject, "handOff");
      paramString2.b(8, (Collection)j.listOf(localObject));
      uDZ.remove(paramString1);
      AppMethodBeat.o(10360);
      return;
    }
    paramString2 = new k("opcode=\"\\d+\"").e((CharSequence)paramString2, "opcode=\"8\"");
    paramString2 = new k("seq=\"\\d+\"").e((CharSequence)paramString2, "seq=\"<![CSEQ]>\"");
    localObject = uEd;
    p.h(paramString2, "msg");
    ((c)localObject).uEx.add(paramString2);
    ((c)localObject).dbU();
    ad.w("HandOffService", "error in file upload fail, handoff with id [" + paramString1 + "] lost!");
    AppMethodBeat.o(10360);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10367);
    p.h(paramHandOff, "handOff");
    ad.i("HandOffService", "onQBFileDestroy");
    HandOff localHandOff = uDX;
    if (localHandOff != null)
    {
      localHandOff.j(paramHandOff);
      uEf.e(localHandOff);
      AppMethodBeat.o(10367);
      return;
    }
    AppMethodBeat.o(10367);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/service/HandOffService$FixHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
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
      paramMessage = a.uEf;
      a.dbR();
      AppMethodBeat.o(10339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.a
 * JD-Core Version:    0.7.0.1
 */