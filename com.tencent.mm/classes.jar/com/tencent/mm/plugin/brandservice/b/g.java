package com.tencent.mm.plugin.brandservice.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.al.r;
import com.tencent.mm.al.t;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.m;
import d.l;
import d.v;
import d.z;
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
import kotlinx.coroutines.ah;
import kotlinx.coroutines.at;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "defaultRefreshIntervalSec", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"})
public final class g
{
  public static final String TAG = "MicroMsg.MPDataLogic";
  private static final ConcurrentHashMap<String, Integer> oct;
  private static final r ocu;
  public static long ocv;
  public static Queue<List<Object>> ocw;
  public static final g ocx;
  
  static
  {
    AppMethodBeat.i(6512);
    ocx = new g();
    TAG = "MicroMsg.MPDataLogic";
    oct = new ConcurrentHashMap();
    ocu = new r();
    ocw = (Queue)new LinkedList();
    AppMethodBeat.o(6512);
  }
  
  public static String T(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6508);
    Object localObject1 = "https://mp.weixin.qq.com/";
    Charset localCharset;
    try
    {
      Object localObject2 = String.valueOf(paramInt1);
      localCharset = d.n.d.UTF_8;
      if (localObject2 == null)
      {
        localObject2 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(6508);
        throw ((Throwable)localObject2);
      }
    }
    catch (Exception localException) {}
    for (;;)
    {
      AppMethodBeat.o(6508);
      return localObject1;
      Object localObject3 = localException.getBytes(localCharset);
      d.g.b.p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      localObject3 = Base64.encodeToString((byte[])localObject3, 2);
      d.g.b.p.g(localObject3, "Base64.encodeToString(\"$…eArray(), Base64.NO_WRAP)");
      localObject3 = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(UrlExKt.appendUrlParam("https://mp.weixin.qq.com/", "__biz", (String)localObject3), "mid", String.valueOf(paramInt2)), "idx", String.valueOf(paramInt3));
      localObject1 = localObject3;
    }
  }
  
  public static String XM(String paramString)
  {
    AppMethodBeat.i(6506);
    d.g.b.p.h(paramString, "url");
    paramString = "_mpdata_" + com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Yg(paramString);
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static boolean XN(String paramString)
  {
    AppMethodBeat.i(6507);
    d.g.b.p.h(paramString, "url");
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
  
  public static void b(LinkedList<ft> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(6510);
    d.g.b.p.h(paramLinkedList, "items");
    if (bu.ht((List)paramLinkedList))
    {
      AppMethodBeat.o(6510);
      return;
    }
    mr localmr = new mr();
    int i = bOE();
    ocu.duration = (i * 1000);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (ft)localObject2;
      if (!oct.contains(((ft)localObject3).hFO)) {
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
      localObject3 = ((ft)localObject2).hFO;
      r localr = ocu;
      d.g.b.p.g(localObject3, "id");
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
    i = ay.aRW(TAG).decodeInt("BizAppMsgRelatedInfoMaxUrlCount", 10);
    ae.v(TAG, "maxUrlCount = ".concat(String.valueOf(i)));
    paramLinkedList = d.a.j.b(paramLinkedList, Math.max(i, 2));
    localmr.FYR.addAll((Collection)paramLinkedList);
    if (bu.ht((List)localmr.FYR))
    {
      AppMethodBeat.o(6510);
      return;
    }
    ae.i(TAG, "getAppMsgRelatedInfo size=" + localmr.FYR.size());
    localmr.Scene = paramInt;
    paramLinkedList = localmr.FYR;
    d.g.b.p.g(paramLinkedList, "req.UrlInfo");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (ft)paramLinkedList.next();
      oct.put(((ft)localObject1).hFO, Integer.valueOf(1));
      localObject2 = ocu;
      localObject3 = ((ft)localObject1).hFO;
      d.g.b.p.g(localObject3, "info.ClientId");
      ((r)localObject2).EL((String)localObject3);
      if (ae.getLogLevel() == 0) {
        ae.v(TAG, "getAppMsgRelatedInfo url=" + ((ft)localObject1).Url + ", clientId=" + ((ft)localObject1).hFO);
      }
    }
    paramLinkedList = new b.a();
    paramLinkedList.c((com.tencent.mm.bw.a)localmr);
    paramLinkedList.d((com.tencent.mm.bw.a)new ms());
    paramLinkedList.DN("/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo");
    paramLinkedList.oS(2864);
    paramLinkedList.oU(0);
    paramLinkedList.oV(0);
    IPCRunCgi.a(paramLinkedList.aDS(), (IPCRunCgi.a)new c(localmr, paramInt));
    AppMethodBeat.o(6510);
  }
  
  public static int bOE()
  {
    int i = 300;
    AppMethodBeat.i(6511);
    int j = ay.aRW(TAG).decodeInt("BizAppMsgRelatedInfoRefreshIntervalSec", 300);
    ae.v(TAG, "refreshIntervalSec = ".concat(String.valueOf(j)));
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
    d.g.b.p.h(paramString, "url");
    long l = System.currentTimeMillis();
    kotlinx.coroutines.f.b((ah)bk.OfO, (d.d.f)az.gzR(), (m)new b(l, paramString, paramInt1, paramInt3, 2, paramInt2, null), 2);
    AppMethodBeat.o(6509);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"})
  public static final class a
  {
    public static final a ocy;
    
    static
    {
      AppMethodBeat.i(6500);
      ocy = new a();
      AppMethodBeat.o(6500);
    }
    
    public static com.tencent.mm.ah.p XO(String paramString)
    {
      AppMethodBeat.i(6498);
      if (paramString == null)
      {
        AppMethodBeat.o(6498);
        return null;
      }
      Object localObject1 = g.ocx;
      localObject1 = g.XM(paramString);
      Object localObject3 = (ay)t.hTD.aRy((String)localObject1);
      if (localObject3 != null)
      {
        Object localObject2 = new fn();
        localObject3 = ((ay)localObject3).decodeBytes((String)localObject1);
        if (bu.cF((byte[])localObject3))
        {
          AppMethodBeat.o(6498);
          return null;
        }
        try
        {
          ((fn)localObject2).parseFrom((byte[])localObject3);
          localObject3 = ((fn)localObject2).FQi;
          if (localObject3 != null) {
            ((com.tencent.mm.ah.p)localObject3).Url = paramString;
          }
          if (ae.getLogLevel() == 0)
          {
            paramString = g.ocx;
            ae.v(g.bOF(), "found:" + (String)localObject1 + " last modify:" + ((fn)localObject2).lastUpdateTime);
          }
          paramString = ((fn)localObject2).FQi;
          AppMethodBeat.o(6498);
          return paramString;
        }
        catch (IOException paramString)
        {
          localObject2 = g.ocx;
          ae.printErrStackTrace(g.bOF(), (Throwable)paramString, "get:".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
      AppMethodBeat.o(6498);
      return null;
    }
    
    public static void a(com.tencent.mm.ah.p paramp)
    {
      AppMethodBeat.i(6499);
      d.g.b.p.h(paramp, "relatedInfo");
      try
      {
        localObject = new fn();
        ((fn)localObject).FQi = paramp;
        ((fn)localObject).lastUpdateTime = System.currentTimeMillis();
        paramp = ((fn)localObject).toByteArray();
        ay localay = (ay)t.hTD.fnP();
        if (localay != null)
        {
          localay.encode(((fn)localObject).FQi.hFO, paramp);
          AppMethodBeat.o(6499);
          return;
        }
        AppMethodBeat.o(6499);
        return;
      }
      catch (Exception paramp)
      {
        Object localObject = g.ocx;
        ae.e(g.bOF(), "save ex " + paramp.getMessage());
        AppMethodBeat.o(6499);
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.model.MPDataLogic$getAppMsgRelatedInfo$1", f="MPDataLogic.kt", gkn={187}, m="invokeSuspend")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    
    b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6502);
      d.g.b.p.h(paramd, "completion");
      paramd = new b(this.ocB, paramInt1, paramInt3, this.obx, paramInt2, this.obr, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(6502);
      return paramd;
    }
    
    public final Object cR(Object arg1)
    {
      AppMethodBeat.i(6501);
      ??? = d.d.a.a.Nif;
      Object localObject1;
      Object localObject5;
      switch (this.label)
      {
      default: 
        ??? = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6501);
        throw ???;
      case 0: 
        localObject1 = this.ocz;
        ??? = g.ocx;
        synchronized (g.bOG())
        {
          localObject5 = g.ocx;
          g.tx(this.ocB);
          localObject5 = g.ocx;
          g.bOG().add(d.a.j.ab(new Object[] { paramInt1, Integer.valueOf(paramInt3), Integer.valueOf(this.obx) }));
          this.ocA = localObject1;
          this.label = 1;
          if (at.a(1000L, this) == ???)
          {
            AppMethodBeat.o(6501);
            return ???;
          }
        }
      }
      ??? = g.ocx;
      for (;;)
      {
        synchronized (g.bOG())
        {
          localObject1 = g.ocx;
          if (g.bOH() == this.ocB)
          {
            localObject1 = g.ocx;
            localObject1 = (Collection)g.bOG();
            if (localObject1 == null) {
              break label969;
            }
            if (((Collection)localObject1).isEmpty()) {
              break label969;
            }
          }
          else
          {
            localObject1 = z.Nhr;
            AppMethodBeat.o(6501);
            return localObject1;
          }
          i = 0;
          break label971;
          localObject1 = g.ocx;
          localObject1 = new ArrayList((Collection)g.bOG());
          ??? = g.ocx;
          g.bOG().clear();
          ??? = g.ocx;
          ae.v(g.bOF(), "getAppMsgRelatedInfo size:" + ((ArrayList)localObject1).size());
          localObject1 = (Iterable)d.a.j.i((Iterable)localObject1);
          ??? = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label415;
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
        label415:
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
            ??? = new v("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(6501);
            throw ???;
          }
          if (???.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Yd((String)localObject6))) {
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
              ??? = new v("null cannot be cast to non-null type kotlin.String");
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
            ??? = new ft();
            localObject6 = ((List)localObject5).get(0);
            if (localObject6 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((ft)???).Url = ((String)localObject6);
            localObject6 = g.ocx;
            localObject6 = ((ft)???).Url;
            d.g.b.p.g(localObject6, "appMsgUrlInfo.Url");
            ((ft)???).hFO = g.XM((String)localObject6);
            localObject6 = ((List)localObject5).get(1);
            if (localObject6 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((ft)???).hFR = ((Integer)localObject6).intValue();
            ((ft)???).ReqType = 1;
            if (((List)localObject5).size() > paramInt2)
            {
              localObject6 = ((List)localObject5).get(paramInt2);
              if (localObject6 == null)
              {
                ??? = new v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(6501);
                throw ???;
              }
              if (((Integer)localObject6).intValue() > 0)
              {
                localObject5 = ((List)localObject5).get(paramInt2);
                if (localObject5 == null)
                {
                  ??? = new v("null cannot be cast to non-null type kotlin.Int");
                  AppMethodBeat.o(6501);
                  throw ???;
                }
                ((ft)???).ReqType = ((Integer)localObject5).intValue();
              }
            }
            ???.add(???);
          }
          localObject3 = g.ocx;
          g.b(???, this.obr);
        }
        ??? = z.Nhr;
        AppMethodBeat.o(6501);
        return ???;
        label969:
        i = 1;
        label971:
        if (i == 0) {}
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6503);
      paramObject1 = ((b)a(paramObject1, (d.d.d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(6503);
      return paramObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(mr parammr, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(6505);
      Object localObject = g.ocx;
      ae.i(g.bOF(), "getAppMsgRelatedInfo errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      paramString = this.ocD.FYR;
      d.g.b.p.g(paramString, "req.UrlInfo");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject = (ft)paramString.next();
        g localg = g.ocx;
        g.bOI().remove(((ft)localObject).hFO);
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(6505);
        return;
      }
      d.g.b.p.g(paramb, "rr");
      paramString = paramb.aEV();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
        AppMethodBeat.o(6505);
        throw paramString;
      }
      paramString = (ms)paramString;
      paramb = g.ocx;
      paramb = ay.aRW(g.bOF());
      paramb.encode("BizAppMsgRelatedInfoRefreshIntervalSec", paramString.FYT);
      com.tencent.mm.plugin.brandservice.ui.b.a.oyH = paramString.FYT;
      paramb.encode("BizAppMsgRelatedInfoMaxUrlCount", paramString.FYU);
      if (bu.ht((List)paramString.FYS))
      {
        paramString = g.ocx;
        ae.w(g.bOF(), "getAppMsgRelatedInfo RelatedInfo is empty");
        AppMethodBeat.o(6505);
        return;
      }
      h.MqF.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6504);
          Object localObject = g.ocx;
          localObject = paramString.FYS;
          d.g.b.p.g(localObject, "response.RelatedInfo");
          LinkedList localLinkedList = this.ocE.ocD.FYR;
          d.g.b.p.g(localLinkedList, "req.UrlInfo");
          g.a((LinkedList)localObject, localLinkedList, this.ocE.hVL);
          AppMethodBeat.o(6504);
        }
      }, "getAppMsgRelatedInfo");
      AppMethodBeat.o(6505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.g
 * JD-Core Version:    0.7.0.1
 */