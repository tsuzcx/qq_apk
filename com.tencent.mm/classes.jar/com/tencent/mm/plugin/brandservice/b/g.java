package com.tencent.mm.plugin.brandservice.b;

import android.util.Base64;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.al.r;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "defaultRefreshIntervalSec", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"})
public final class g
{
  public static final String TAG = "MicroMsg.MPDataLogic";
  private static final ConcurrentHashMap<String, Integer> pns;
  private static final r pnt;
  public static long pnu;
  public static Queue<List<Object>> pnv;
  public static final g pnw;
  
  static
  {
    AppMethodBeat.i(6512);
    pnw = new g();
    TAG = "MicroMsg.MPDataLogic";
    pns = new ConcurrentHashMap();
    pnt = new r();
    pnv = (Queue)new LinkedList();
    AppMethodBeat.o(6512);
  }
  
  public static String U(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6508);
    Object localObject1 = "https://" + WeChatHosts.domainString(2131761726) + "/";
    String str1 = "https://" + WeChatHosts.domainString(2131761726) + "/";
    Object localObject2;
    Charset localCharset;
    try
    {
      localObject2 = String.valueOf(paramInt1);
      localCharset = kotlin.n.d.UTF_8;
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(6508);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException) {}
    for (;;)
    {
      AppMethodBeat.o(6508);
      return str1;
      localObject2 = ((String)localObject2).getBytes(localCharset);
      kotlin.g.b.p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject2 = Base64.encodeToString((byte[])localObject2, 2);
      kotlin.g.b.p.g(localObject2, "Base64.encodeToString(\"$…eArray(), Base64.NO_WRAP)");
      String str2 = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(localException, "__biz", (String)localObject2), "mid", String.valueOf(paramInt2)), "idx", String.valueOf(paramInt3));
      str1 = str2;
    }
  }
  
  public static String ahJ(String paramString)
  {
    AppMethodBeat.i(6506);
    kotlin.g.b.p.h(paramString, "url");
    paramString = "_mpdata_" + c.aie(paramString);
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static boolean ahK(String paramString)
  {
    AppMethodBeat.i(6507);
    kotlin.g.b.p.h(paramString, "url");
    int i = 0;
    while (i < 3)
    {
      if (UrlExKt.getUrlParam(paramString, new String[] { "__biz", "mid", "idx" }[i]) == null)
      {
        AppMethodBeat.o(6507);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(6507);
    return false;
  }
  
  public static void b(LinkedList<gg> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(6510);
    kotlin.g.b.p.h(paramLinkedList, "items");
    if (Util.isNullOrNil((List)paramLinkedList))
    {
      AppMethodBeat.o(6510);
      return;
    }
    nj localnj = new nj();
    int i = clK();
    pnt.duration = (i * 1000);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (gg)localObject2;
      if (!pns.contains(((gg)localObject3).izX)) {
        paramLinkedList.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label233:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = ((gg)localObject2).izX;
      r localr = pnt;
      kotlin.g.b.p.g(localObject3, "id");
      if (localr.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label233;
        }
        paramLinkedList.add(localObject2);
        break;
      }
    }
    paramLinkedList = (Iterable)paramLinkedList;
    i = MultiProcessMMKV.getMMKV(TAG).decodeInt("BizAppMsgRelatedInfoMaxUrlCount", 10);
    Log.v(TAG, "maxUrlCount = ".concat(String.valueOf(i)));
    paramLinkedList = kotlin.a.j.b(paramLinkedList, Math.max(i, 2));
    localnj.KSM.addAll((Collection)paramLinkedList);
    if (Util.isNullOrNil((List)localnj.KSM))
    {
      AppMethodBeat.o(6510);
      return;
    }
    Log.i(TAG, "getAppMsgRelatedInfo size=" + localnj.KSM.size());
    localnj.Scene = paramInt;
    paramLinkedList = localnj.KSM;
    kotlin.g.b.p.g(paramLinkedList, "req.UrlInfo");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (gg)paramLinkedList.next();
      pns.put(((gg)localObject1).izX, Integer.valueOf(1));
      localObject2 = pnt;
      localObject3 = ((gg)localObject1).izX;
      kotlin.g.b.p.g(localObject3, "info.ClientId");
      ((r)localObject2).add((String)localObject3);
      if (Log.getLogLevel() == 0) {
        Log.v(TAG, "getAppMsgRelatedInfo url=" + ((gg)localObject1).Url + ", clientId=" + ((gg)localObject1).izX);
      }
    }
    paramLinkedList = new d.a();
    paramLinkedList.c((com.tencent.mm.bw.a)localnj);
    paramLinkedList.d((com.tencent.mm.bw.a)new nk());
    paramLinkedList.MB("/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo");
    paramLinkedList.sG(2864);
    paramLinkedList.sI(0);
    paramLinkedList.sJ(0);
    IPCRunCgi.a(paramLinkedList.aXF(), (IPCRunCgi.a)new c(localnj, paramInt));
    AppMethodBeat.o(6510);
  }
  
  public static int clK()
  {
    int i = 300;
    AppMethodBeat.i(6511);
    int j = MultiProcessMMKV.getMMKV(TAG).decodeInt("BizAppMsgRelatedInfoRefreshIntervalSec", 300);
    Log.v(TAG, "refreshIntervalSec = ".concat(String.valueOf(j)));
    j = Math.min(j, 86400);
    if (j <= 0) {}
    for (;;)
    {
      AppMethodBeat.o(6511);
      return i;
      i = j;
    }
  }
  
  public static void j(String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(6509);
    kotlin.g.b.p.h(paramString, "url");
    long l = System.currentTimeMillis();
    kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new b(l, paramString, paramInt1, paramInt3, 2, paramInt2, null), 2);
    AppMethodBeat.o(6509);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"})
  public static final class a
  {
    public static final a pnx;
    
    static
    {
      AppMethodBeat.i(6500);
      pnx = new a();
      AppMethodBeat.o(6500);
    }
    
    public static void a(com.tencent.mm.ag.p paramp)
    {
      AppMethodBeat.i(6499);
      kotlin.g.b.p.h(paramp, "relatedInfo");
      try
      {
        localObject = new ga();
        ((ga)localObject).KJP = paramp;
        ((ga)localObject).lastUpdateTime = System.currentTimeMillis();
        paramp = ((ga)localObject).toByteArray();
        MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)com.tencent.mm.al.t.iOP.getSlot();
        if (localMultiProcessMMKV != null)
        {
          localMultiProcessMMKV.encode(((ga)localObject).KJP.izX, paramp);
          AppMethodBeat.o(6499);
          return;
        }
        AppMethodBeat.o(6499);
        return;
      }
      catch (Exception paramp)
      {
        Object localObject = g.pnw;
        Log.e(g.clL(), "save ex " + paramp.getMessage());
        AppMethodBeat.o(6499);
      }
    }
    
    public static com.tencent.mm.ag.p ahL(String paramString)
    {
      AppMethodBeat.i(6498);
      if (paramString == null)
      {
        AppMethodBeat.o(6498);
        return null;
      }
      Object localObject1 = g.pnw;
      localObject1 = g.ahJ(paramString);
      Object localObject3 = (MultiProcessMMKV)com.tencent.mm.al.t.iOP.findSlot((String)localObject1);
      if (localObject3 != null)
      {
        Object localObject2 = new ga();
        localObject3 = ((MultiProcessMMKV)localObject3).decodeBytes((String)localObject1);
        if (Util.isNullOrNil((byte[])localObject3))
        {
          AppMethodBeat.o(6498);
          return null;
        }
        try
        {
          ((ga)localObject2).parseFrom((byte[])localObject3);
          localObject3 = ((ga)localObject2).KJP;
          if (localObject3 != null) {
            ((com.tencent.mm.ag.p)localObject3).Url = paramString;
          }
          if (Log.getLogLevel() == 0)
          {
            paramString = g.pnw;
            Log.v(g.clL(), "found:" + (String)localObject1 + " last modify:" + ((ga)localObject2).lastUpdateTime);
          }
          paramString = ((ga)localObject2).KJP;
          AppMethodBeat.o(6498);
          return paramString;
        }
        catch (IOException paramString)
        {
          localObject2 = g.pnw;
          Log.printErrStackTrace(g.clL(), (Throwable)paramString, "get:".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
      AppMethodBeat.o(6498);
      return null;
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.brandservice.model.MPDataLogic$getAppMsgRelatedInfo$1", f="MPDataLogic.kt", hxM={190}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6502);
      kotlin.g.b.p.h(paramd, "completion");
      paramd = new b(this.pny, paramInt1, paramInt3, this.pms, paramInt2, this.pmo, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(6502);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6503);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(6503);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object arg1)
    {
      AppMethodBeat.i(6501);
      Object localObject1 = kotlin.d.a.a.SXO;
      Object localObject5;
      switch (this.label)
      {
      default: 
        ??? = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6501);
        throw ???;
      case 0: 
        ResultKt.throwOnFailure(???);
        ??? = this.p$;
        ??? = g.pnw;
        synchronized (g.clM())
        {
          localObject5 = g.pnw;
          g.BD(this.pny);
          localObject5 = g.pnw;
          g.clM().add(kotlin.a.j.ac(new Object[] { paramInt1, Integer.valueOf(paramInt3), Integer.valueOf(this.pms) }));
          this.L$0 = ???;
          this.label = 1;
          if (au.a(1000L, this) == localObject1)
          {
            AppMethodBeat.o(6501);
            return localObject1;
          }
        }
      case 1: 
        ResultKt.throwOnFailure(???);
      }
      ??? = g.pnw;
      for (;;)
      {
        synchronized (g.clM())
        {
          localObject1 = g.pnw;
          if (g.clN() == this.pny)
          {
            localObject1 = g.pnw;
            localObject1 = (Collection)g.clM();
            if (localObject1 == null) {
              break label977;
            }
            if (((Collection)localObject1).isEmpty()) {
              break label977;
            }
          }
          else
          {
            localObject1 = x.SXb;
            AppMethodBeat.o(6501);
            return localObject1;
          }
          i = 0;
          break label979;
          localObject1 = g.pnw;
          localObject1 = new ArrayList((Collection)g.clM());
          ??? = g.pnw;
          g.clM().clear();
          ??? = g.pnw;
          Log.v(g.clL(), "getAppMsgRelatedInfo size:" + ((ArrayList)localObject1).size());
          localObject1 = (Iterable)kotlin.a.j.m((Iterable)localObject1);
          ??? = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label423;
          }
          ??? = ((Iterator)localObject1).next();
          localObject5 = (List)???;
          if ((localObject5 != null) && ((((List)localObject5).get(0) instanceof String)))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            ???.add(???);
          }
        }
        int i = 0;
        continue;
        label423:
        ??? = (Iterable)???;
        ??? = new HashSet();
        Object localObject3 = new ArrayList();
        ??? = ((Iterable)???).iterator();
        Object localObject6;
        while (((Iterator)???).hasNext())
        {
          localObject5 = ((Iterator)???).next();
          localObject6 = ((List)localObject5).get(0);
          if (localObject6 == null)
          {
            ??? = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(6501);
            throw ???;
          }
          if (???.add(c.aib((String)localObject6))) {
            ((ArrayList)localObject3).add(localObject5);
          }
        }
        localObject3 = (List)localObject3;
        if (!((List)localObject3).isEmpty())
        {
          ??? = new LinkedList();
          ??? = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList();
          ??? = ((Iterable)???).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject5 = ((Iterator)???).next();
            localObject6 = ((List)localObject5).get(0);
            if (localObject6 == null)
            {
              ??? = new kotlin.t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6501);
              throw ???;
            }
            if (UrlExKt.isMpArticleUrl((String)localObject6)) {
              ((Collection)localObject3).add(localObject5);
            }
          }
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (List)((Iterator)localObject3).next();
            ??? = new gg();
            localObject6 = ((List)localObject5).get(0);
            if (localObject6 == null)
            {
              ??? = new kotlin.t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((gg)???).Url = ((String)localObject6);
            localObject6 = g.pnw;
            localObject6 = ((gg)???).Url;
            kotlin.g.b.p.g(localObject6, "appMsgUrlInfo.Url");
            ((gg)???).izX = g.ahJ((String)localObject6);
            localObject6 = ((List)localObject5).get(1);
            if (localObject6 == null)
            {
              ??? = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((gg)???).iAb = ((Integer)localObject6).intValue();
            ((gg)???).ReqType = 1;
            if (((List)localObject5).size() > paramInt2)
            {
              localObject6 = ((List)localObject5).get(paramInt2);
              if (localObject6 == null)
              {
                ??? = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(6501);
                throw ???;
              }
              if (((Integer)localObject6).intValue() > 0)
              {
                localObject5 = ((List)localObject5).get(paramInt2);
                if (localObject5 == null)
                {
                  ??? = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                  AppMethodBeat.o(6501);
                  throw ???;
                }
                ((gg)???).ReqType = ((Integer)localObject5).intValue();
              }
            }
            ???.add(???);
          }
          localObject3 = g.pnw;
          g.b(???, this.pmo);
        }
        ??? = x.SXb;
        AppMethodBeat.o(6501);
        return ???;
        label977:
        i = 1;
        label979:
        if (i == 0) {}
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(nj paramnj, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(6505);
      Object localObject = g.pnw;
      Log.i(g.clL(), "getAppMsgRelatedInfo errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      paramString = this.pnA.KSM;
      kotlin.g.b.p.g(paramString, "req.UrlInfo");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject = (gg)paramString.next();
        g localg = g.pnw;
        g.clO().remove(((gg)localObject).izX);
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(6505);
        return;
      }
      kotlin.g.b.p.g(paramd, "rr");
      paramString = paramd.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
        AppMethodBeat.o(6505);
        throw paramString;
      }
      paramString = (nk)paramString;
      paramd = g.pnw;
      paramd = MultiProcessMMKV.getMMKV(g.clL());
      paramd.encode("BizAppMsgRelatedInfoRefreshIntervalSec", paramString.KSO);
      com.tencent.mm.plugin.brandservice.ui.b.a.pMl = paramString.KSO;
      paramd.encode("BizAppMsgRelatedInfoMaxUrlCount", paramString.KSP);
      if (Util.isNullOrNil((List)paramString.KSN))
      {
        paramString = g.pnw;
        Log.w(g.clL(), "getAppMsgRelatedInfo RelatedInfo is empty");
        AppMethodBeat.o(6505);
        return;
      }
      h.RTc.b((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6504);
          Object localObject = g.pnw;
          localObject = paramString.KSN;
          kotlin.g.b.p.g(localObject, "response.RelatedInfo");
          LinkedList localLinkedList = this.pnB.pnA.KSM;
          kotlin.g.b.p.g(localLinkedList, "req.UrlInfo");
          g.a((LinkedList)localObject, localLinkedList, this.pnB.$scene);
          AppMethodBeat.o(6504);
        }
      }, "getAppMsgRelatedInfo");
      AppMethodBeat.o(6505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.g
 * JD-Core Version:    0.7.0.1
 */