package com.tencent.mm.plugin.brandservice.b;

import android.util.Base64;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ao.r;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.protocal.protobuf.nb;
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
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "defaultRefreshIntervalSec", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"})
public final class h
{
  public static final String TAG = "MicroMsg.MPDataLogic";
  private static final ConcurrentHashMap<String, Integer> swt;
  private static final r swu;
  public static long swv;
  public static Queue<List<Object>> sww;
  public static final h swx;
  
  static
  {
    AppMethodBeat.i(6512);
    swx = new h();
    TAG = "MicroMsg.MPDataLogic";
    swt = new ConcurrentHashMap();
    swu = new r();
    sww = (Queue)new LinkedList();
    AppMethodBeat.o(6512);
  }
  
  public static String V(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6508);
    Object localObject1 = "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/";
    String str1 = "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/";
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
      kotlin.g.b.p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject2 = Base64.encodeToString((byte[])localObject2, 2);
      kotlin.g.b.p.j(localObject2, "Base64.encodeToString(\"$…eArray(), Base64.NO_WRAP)");
      String str2 = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(localException, "__biz", (String)localObject2), "mid", String.valueOf(paramInt2)), "idx", String.valueOf(paramInt3));
      str1 = str2;
    }
  }
  
  public static String apv(String paramString)
  {
    AppMethodBeat.i(6506);
    kotlin.g.b.p.k(paramString, "url");
    paramString = "_mpdata_" + c.apQ(paramString);
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static boolean apw(String paramString)
  {
    AppMethodBeat.i(6507);
    kotlin.g.b.p.k(paramString, "url");
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
  
  public static void b(LinkedList<fu> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(6510);
    kotlin.g.b.p.k(paramLinkedList, "items");
    if (Util.isNullOrNil((List)paramLinkedList))
    {
      AppMethodBeat.o(6510);
      return;
    }
    na localna = new na();
    int i = czo();
    swu.duration = (i * 1000);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (fu)localObject2;
      if (!swt.contains(((fu)localObject3).lps)) {
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
      localObject3 = ((fu)localObject2).lps;
      r localr = swu;
      kotlin.g.b.p.j(localObject3, "id");
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
    paramLinkedList = kotlin.a.j.c(paramLinkedList, Math.max(i, 2));
    localna.RTO.addAll((Collection)paramLinkedList);
    if (Util.isNullOrNil((List)localna.RTO))
    {
      AppMethodBeat.o(6510);
      return;
    }
    Log.i(TAG, "getAppMsgRelatedInfo size=" + localna.RTO.size());
    localna.CPw = paramInt;
    paramLinkedList = localna.RTO;
    kotlin.g.b.p.j(paramLinkedList, "req.UrlInfo");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (fu)paramLinkedList.next();
      swt.put(((fu)localObject1).lps, Integer.valueOf(1));
      localObject2 = swu;
      localObject3 = ((fu)localObject1).lps;
      kotlin.g.b.p.j(localObject3, "info.ClientId");
      ((r)localObject2).add((String)localObject3);
      if (Log.getLogLevel() == 0) {
        Log.v(TAG, "getAppMsgRelatedInfo url=" + ((fu)localObject1).Url + ", clientId=" + ((fu)localObject1).lps);
      }
    }
    paramLinkedList = new d.a();
    paramLinkedList.c((com.tencent.mm.cd.a)localna);
    paramLinkedList.d((com.tencent.mm.cd.a)new nb());
    paramLinkedList.TW("/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo");
    paramLinkedList.vD(2864);
    paramLinkedList.vF(0);
    paramLinkedList.vG(0);
    IPCRunCgi.a(paramLinkedList.bgN(), (IPCRunCgi.a)new c(localna, paramInt));
    AppMethodBeat.o(6510);
  }
  
  public static int czo()
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
  
  public static void k(String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(6509);
    kotlin.g.b.p.k(paramString, "url");
    long l = System.currentTimeMillis();
    g.b((ak)br.abxo, (f)bc.iRs(), (m)new b(l, paramString, paramInt1, paramInt3, 2, paramInt2, null), 2);
    AppMethodBeat.o(6509);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"})
  public static final class a
  {
    public static final a swy;
    
    static
    {
      AppMethodBeat.i(6500);
      swy = new a();
      AppMethodBeat.o(6500);
    }
    
    public static void a(com.tencent.mm.aj.p paramp)
    {
      AppMethodBeat.i(6499);
      kotlin.g.b.p.k(paramp, "relatedInfo");
      try
      {
        localObject = new fo();
        ((fo)localObject).RKF = paramp;
        ((fo)localObject).lastUpdateTime = System.currentTimeMillis();
        paramp = ((fo)localObject).toByteArray();
        ((MultiProcessMMKV)com.tencent.mm.ao.t.lFf.getSlotForWrite()).encode(((fo)localObject).RKF.lps, paramp);
        AppMethodBeat.o(6499);
        return;
      }
      catch (Exception paramp)
      {
        Object localObject = h.swx;
        Log.e(h.czp(), "save ex " + paramp.getMessage());
        AppMethodBeat.o(6499);
      }
    }
    
    public static com.tencent.mm.aj.p apx(String paramString)
    {
      AppMethodBeat.i(6498);
      if (paramString == null)
      {
        AppMethodBeat.o(6498);
        return null;
      }
      Object localObject1 = h.swx;
      localObject1 = h.apv(paramString);
      Object localObject3 = (MultiProcessMMKV)com.tencent.mm.ao.t.lFf.findSlot((String)localObject1);
      if (localObject3 != null)
      {
        Object localObject2 = new fo();
        localObject3 = ((MultiProcessMMKV)localObject3).decodeBytes((String)localObject1);
        if (Util.isNullOrNil((byte[])localObject3))
        {
          AppMethodBeat.o(6498);
          return null;
        }
        try
        {
          ((fo)localObject2).parseFrom((byte[])localObject3);
          localObject3 = ((fo)localObject2).RKF;
          if (localObject3 != null) {
            ((com.tencent.mm.aj.p)localObject3).Url = paramString;
          }
          if (Log.getLogLevel() == 0)
          {
            paramString = h.swx;
            Log.v(h.czp(), "found:" + (String)localObject1 + " last modify:" + ((fo)localObject2).lastUpdateTime);
          }
          paramString = ((fo)localObject2).RKF;
          AppMethodBeat.o(6498);
          return paramString;
        }
        catch (IOException paramString)
        {
          localObject2 = h.swx;
          Log.printErrStackTrace(h.czp(), (Throwable)paramString, "get:".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
      AppMethodBeat.o(6498);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6502);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new b(this.msQ, paramInt1, paramInt3, this.soK, paramInt2, this.soG, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(6502);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6503);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(6503);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object arg1)
    {
      AppMethodBeat.i(6501);
      Object localObject1 = kotlin.d.a.a.aaAA;
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
        ??? = h.swx;
        synchronized (h.czq())
        {
          localObject5 = h.swx;
          h.HQ(this.msQ);
          localObject5 = h.swx;
          h.czq().add(kotlin.a.j.ag(new Object[] { paramInt1, Integer.valueOf(paramInt3), Integer.valueOf(this.soK) }));
          this.L$0 = ???;
          this.label = 1;
          if (aw.a(1000L, this) == localObject1)
          {
            AppMethodBeat.o(6501);
            return localObject1;
          }
        }
      case 1: 
        ResultKt.throwOnFailure(???);
      }
      ??? = h.swx;
      for (;;)
      {
        synchronized (h.czq())
        {
          localObject1 = h.swx;
          if (h.czr() == this.msQ)
          {
            localObject1 = h.swx;
            localObject1 = (Collection)h.czq();
            if (localObject1 == null) {
              break label977;
            }
            if (((Collection)localObject1).isEmpty()) {
              break label977;
            }
          }
          else
          {
            localObject1 = x.aazN;
            AppMethodBeat.o(6501);
            return localObject1;
          }
          i = 0;
          break label979;
          localObject1 = h.swx;
          localObject1 = new ArrayList((Collection)h.czq());
          ??? = h.swx;
          h.czq().clear();
          ??? = h.swx;
          Log.v(h.czp(), "getAppMsgRelatedInfo size:" + ((ArrayList)localObject1).size());
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
          if (???.add(c.apN((String)localObject6))) {
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
            ??? = new fu();
            localObject6 = ((List)localObject5).get(0);
            if (localObject6 == null)
            {
              ??? = new kotlin.t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((fu)???).Url = ((String)localObject6);
            localObject6 = h.swx;
            localObject6 = ((fu)???).Url;
            kotlin.g.b.p.j(localObject6, "appMsgUrlInfo.Url");
            ((fu)???).lps = h.apv((String)localObject6);
            localObject6 = ((List)localObject5).get(1);
            if (localObject6 == null)
            {
              ??? = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((fu)???).lpx = ((Integer)localObject6).intValue();
            ((fu)???).lpw = 1;
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
                ((fu)???).lpw = ((Integer)localObject5).intValue();
              }
            }
            ???.add(???);
          }
          localObject3 = h.swx;
          h.b(???, this.soG);
        }
        ??? = x.aazN;
        AppMethodBeat.o(6501);
        return ???;
        label977:
        i = 1;
        label979:
        if (i == 0) {}
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(na paramna, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(6505);
      Object localObject = h.swx;
      Log.i(h.czp(), "getAppMsgRelatedInfo errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      paramString = this.swA.RTO;
      kotlin.g.b.p.j(paramString, "req.UrlInfo");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject = (fu)paramString.next();
        h localh = h.swx;
        h.czs().remove(((fu)localObject).lps);
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(6505);
        return;
      }
      kotlin.g.b.p.j(paramd, "rr");
      paramString = paramd.bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
        AppMethodBeat.o(6505);
        throw paramString;
      }
      paramString = (nb)paramString;
      paramd = h.swx;
      paramd = MultiProcessMMKV.getMMKV(h.czp());
      paramd.encode("BizAppMsgRelatedInfoRefreshIntervalSec", paramString.RTQ);
      com.tencent.mm.plugin.brandservice.ui.b.a.sTj = paramString.RTQ;
      paramd.encode("BizAppMsgRelatedInfoMaxUrlCount", paramString.RTR);
      if (Util.isNullOrNil((List)paramString.RTP))
      {
        paramString = h.swx;
        Log.w(h.czp(), "getAppMsgRelatedInfo RelatedInfo is empty");
        AppMethodBeat.o(6505);
        return;
      }
      com.tencent.e.h.ZvG.d((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6504);
          Object localObject = h.swx;
          localObject = paramString.RTP;
          kotlin.g.b.p.j(localObject, "response.RelatedInfo");
          LinkedList localLinkedList = this.swB.swA.RTO;
          kotlin.g.b.p.j(localLinkedList, "req.UrlInfo");
          h.a((LinkedList)localObject, localLinkedList, this.swB.$scene);
          AppMethodBeat.o(6504);
        }
      }, "getAppMsgRelatedInfo");
      AppMethodBeat.o(6505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.h
 * JD-Core Version:    0.7.0.1
 */