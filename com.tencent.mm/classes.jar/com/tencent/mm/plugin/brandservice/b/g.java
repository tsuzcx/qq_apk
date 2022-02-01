package com.tencent.mm.plugin.brandservice.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.am.r;
import com.tencent.mm.am.t;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"})
public final class g
{
  public static final String TAG = "MicroMsg.MPDataLogic";
  private static final ConcurrentHashMap<String, Integer> nWK;
  private static final r nWL;
  public static long nWM;
  public static Queue<List<Object>> nWN;
  public static final g nWO;
  
  static
  {
    AppMethodBeat.i(6512);
    nWO = new g();
    TAG = "MicroMsg.MPDataLogic";
    nWK = new ConcurrentHashMap();
    nWL = new r();
    nWN = (Queue)new LinkedList();
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
  
  public static String Xa(String paramString)
  {
    AppMethodBeat.i(6506);
    d.g.b.p.h(paramString, "url");
    paramString = "_mpdata_" + com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xt(paramString);
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static boolean Xb(String paramString)
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
    if (bt.hj((List)paramLinkedList))
    {
      AppMethodBeat.o(6510);
      return;
    }
    mp localmp = new mp();
    int i = bNH();
    nWL.duration = (i * 1000);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (ft)localObject2;
      if (!nWK.contains(((ft)localObject3).hCW)) {
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
      localObject3 = ((ft)localObject2).hCW;
      r localr = nWL;
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
    i = ax.aQz(TAG).decodeInt("BizAppMsgRelatedInfoMaxUrlCount", 10);
    ad.v(TAG, "maxUrlCount = ".concat(String.valueOf(i)));
    paramLinkedList = d.a.j.b(paramLinkedList, Math.max(i, 2));
    localmp.FGv.addAll((Collection)paramLinkedList);
    if (bt.hj((List)localmp.FGv))
    {
      AppMethodBeat.o(6510);
      return;
    }
    ad.i(TAG, "getAppMsgRelatedInfo size=" + localmp.FGv.size());
    localmp.Scene = paramInt;
    paramLinkedList = localmp.FGv;
    d.g.b.p.g(paramLinkedList, "req.UrlInfo");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (ft)paramLinkedList.next();
      nWK.put(((ft)localObject1).hCW, Integer.valueOf(1));
      localObject2 = nWL;
      localObject3 = ((ft)localObject1).hCW;
      d.g.b.p.g(localObject3, "info.ClientId");
      ((r)localObject2).Ej((String)localObject3);
      if (ad.getLogLevel() == 0) {
        ad.v(TAG, "getAppMsgRelatedInfo url=" + ((ft)localObject1).Url + ", clientId=" + ((ft)localObject1).hCW);
      }
    }
    paramLinkedList = new b.a();
    paramLinkedList.c((com.tencent.mm.bx.a)localmp);
    paramLinkedList.d((com.tencent.mm.bx.a)new mq());
    paramLinkedList.Dl("/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo");
    paramLinkedList.oP(2864);
    paramLinkedList.oR(0);
    paramLinkedList.oS(0);
    IPCRunCgi.a(paramLinkedList.aDC(), (IPCRunCgi.a)new c(localmp, paramInt));
    AppMethodBeat.o(6510);
  }
  
  public static int bNH()
  {
    AppMethodBeat.i(6511);
    int i = ax.aQz(TAG).decodeInt("BizAppMsgRelatedInfoRefreshIntervalSec", 300);
    ad.v(TAG, "refreshIntervalSec = ".concat(String.valueOf(i)));
    i = Math.min(i, 86400);
    AppMethodBeat.o(6511);
    return i;
  }
  
  public static void j(String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(6509);
    d.g.b.p.h(paramString, "url");
    long l = System.currentTimeMillis();
    kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvp(), (m)new b(l, paramString, paramInt1, paramInt3, 2, paramInt2, null), 2);
    AppMethodBeat.o(6509);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"})
  public static final class a
  {
    public static final a nWP;
    
    static
    {
      AppMethodBeat.i(6500);
      nWP = new a();
      AppMethodBeat.o(6500);
    }
    
    public static com.tencent.mm.ai.p Xc(String paramString)
    {
      AppMethodBeat.i(6498);
      if (paramString == null)
      {
        AppMethodBeat.o(6498);
        return null;
      }
      Object localObject1 = g.nWO;
      localObject1 = g.Xa(paramString);
      Object localObject3 = (ax)t.hQL.aQb((String)localObject1);
      if (localObject3 != null)
      {
        Object localObject2 = new fn();
        localObject3 = ((ax)localObject3).decodeBytes((String)localObject1);
        if (bt.cC((byte[])localObject3))
        {
          AppMethodBeat.o(6498);
          return null;
        }
        try
        {
          ((fn)localObject2).parseFrom((byte[])localObject3);
          localObject3 = ((fn)localObject2).FxK;
          if (localObject3 != null) {
            ((com.tencent.mm.ai.p)localObject3).Url = paramString;
          }
          if (ad.getLogLevel() == 0)
          {
            paramString = g.nWO;
            ad.v(g.bNI(), "found:" + (String)localObject1 + " last modify:" + ((fn)localObject2).lastUpdateTime);
          }
          paramString = ((fn)localObject2).FxK;
          AppMethodBeat.o(6498);
          return paramString;
        }
        catch (IOException paramString)
        {
          localObject2 = g.nWO;
          ad.printErrStackTrace(g.bNI(), (Throwable)paramString, "get:".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
      AppMethodBeat.o(6498);
      return null;
    }
    
    public static void a(com.tencent.mm.ai.p paramp)
    {
      AppMethodBeat.i(6499);
      d.g.b.p.h(paramp, "relatedInfo");
      try
      {
        localObject = new fn();
        ((fn)localObject).FxK = paramp;
        ((fn)localObject).lastUpdateTime = System.currentTimeMillis();
        paramp = ((fn)localObject).toByteArray();
        ax localax = (ax)t.hQL.fjV();
        if (localax != null)
        {
          localax.encode(((fn)localObject).FxK.hCW, paramp);
          AppMethodBeat.o(6499);
          return;
        }
        AppMethodBeat.o(6499);
        return;
      }
      catch (Exception paramp)
      {
        Object localObject = g.nWO;
        ad.e(g.bNI(), "save ex " + paramp.getMessage());
        AppMethodBeat.o(6499);
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.model.MPDataLogic$getAppMsgRelatedInfo$1", f="MPDataLogic.kt", gfL={187}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6502);
      d.g.b.p.h(paramd, "completion");
      paramd = new b(this.nWS, paramInt1, paramInt3, this.nVP, paramInt2, this.nVJ, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(6502);
      return paramd;
    }
    
    public final Object cQ(Object arg1)
    {
      AppMethodBeat.i(6501);
      ??? = d.d.a.a.MLc;
      Object localObject1;
      Object localObject5;
      switch (this.label)
      {
      default: 
        ??? = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6501);
        throw ???;
      case 0: 
        localObject1 = this.nWQ;
        ??? = g.nWO;
        synchronized (g.bNJ())
        {
          localObject5 = g.nWO;
          g.tj(this.nWS);
          localObject5 = g.nWO;
          g.bNJ().add(d.a.j.ac(new Object[] { paramInt1, Integer.valueOf(paramInt3), Integer.valueOf(this.nVP) }));
          this.nWR = localObject1;
          this.label = 1;
          if (at.a(1000L, this) == ???)
          {
            AppMethodBeat.o(6501);
            return ???;
          }
        }
      }
      ??? = g.nWO;
      for (;;)
      {
        synchronized (g.bNJ())
        {
          localObject1 = g.nWO;
          if (g.bNK() == this.nWS)
          {
            localObject1 = g.nWO;
            localObject1 = (Collection)g.bNJ();
            if (localObject1 == null) {
              break label969;
            }
            if (((Collection)localObject1).isEmpty()) {
              break label969;
            }
          }
          else
          {
            localObject1 = z.MKo;
            AppMethodBeat.o(6501);
            return localObject1;
          }
          i = 0;
          break label971;
          localObject1 = g.nWO;
          localObject1 = new ArrayList((Collection)g.bNJ());
          ??? = g.nWO;
          g.bNJ().clear();
          ??? = g.nWO;
          ad.v(g.bNI(), "getAppMsgRelatedInfo size:" + ((ArrayList)localObject1).size());
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
          if (???.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xr((String)localObject6))) {
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
            localObject6 = g.nWO;
            localObject6 = ((ft)???).Url;
            d.g.b.p.g(localObject6, "appMsgUrlInfo.Url");
            ((ft)???).hCW = g.Xa((String)localObject6);
            localObject6 = ((List)localObject5).get(1);
            if (localObject6 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((ft)???).hCZ = ((Integer)localObject6).intValue();
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
          localObject3 = g.nWO;
          g.b(???, this.nVJ);
        }
        ??? = z.MKo;
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
      paramObject1 = ((b)a(paramObject1, (d.d.d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(6503);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(mp parammp, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(6505);
      Object localObject = g.nWO;
      ad.i(g.bNI(), "getAppMsgRelatedInfo errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      paramString = this.nWU.FGv;
      d.g.b.p.g(paramString, "req.UrlInfo");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject = (ft)paramString.next();
        g localg = g.nWO;
        g.bNL().remove(((ft)localObject).hCW);
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(6505);
        return;
      }
      d.g.b.p.g(paramb, "rr");
      paramString = paramb.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
        AppMethodBeat.o(6505);
        throw paramString;
      }
      paramString = (mq)paramString;
      paramb = g.nWO;
      paramb = ax.aQz(g.bNI());
      paramb.encode("BizAppMsgRelatedInfoRefreshIntervalSec", paramString.FGx);
      com.tencent.mm.plugin.brandservice.ui.b.a.osg = paramString.FGx;
      paramb.encode("BizAppMsgRelatedInfoMaxUrlCount", paramString.FGy);
      if (bt.hj((List)paramString.FGw))
      {
        paramString = g.nWO;
        ad.w(g.bNI(), "getAppMsgRelatedInfo RelatedInfo is empty");
        AppMethodBeat.o(6505);
        return;
      }
      h.LTJ.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6504);
          Object localObject = g.nWO;
          localObject = paramString.FGw;
          d.g.b.p.g(localObject, "response.RelatedInfo");
          LinkedList localLinkedList = this.nWV.nWU.FGv;
          d.g.b.p.g(localLinkedList, "req.UrlInfo");
          g.a((LinkedList)localObject, localLinkedList, this.nWV.hST);
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