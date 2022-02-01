package com.tencent.mm.plugin.brandservice.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.al.q;
import com.tencent.mm.al.r;
import com.tencent.mm.al.s;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.d.b.a.e;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
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
import kotlinx.coroutines.ag;
import kotlinx.coroutines.as;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bh;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"})
public final class g
{
  public static final String TAG = "MicroMsg.MPDataLogic";
  private static final ConcurrentHashMap<String, Integer> nvm;
  private static final q nvn;
  public static long nvo;
  public static Queue<List<Object>> nvp;
  public static final g nvq;
  
  static
  {
    AppMethodBeat.i(6512);
    nvq = new g();
    TAG = "MicroMsg.MPDataLogic";
    nvm = new ConcurrentHashMap();
    nvn = new q();
    nvp = (Queue)new LinkedList();
    AppMethodBeat.o(6512);
  }
  
  public static String R(int paramInt1, int paramInt2, int paramInt3)
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
      k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
      localObject3 = Base64.encodeToString((byte[])localObject3, 2);
      k.g(localObject3, "Base64.encodeToString(\"$…eArray(), Base64.NO_WRAP)");
      localObject3 = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(UrlExKt.appendUrlParam("https://mp.weixin.qq.com/", "__biz", (String)localObject3), "mid", String.valueOf(paramInt2)), "idx", String.valueOf(paramInt3));
      localObject1 = localObject3;
    }
  }
  
  public static String Tt(String paramString)
  {
    AppMethodBeat.i(6506);
    k.h(paramString, "url");
    paramString = "_mpdata_" + com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TL(paramString);
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static boolean Tu(String paramString)
  {
    AppMethodBeat.i(6507);
    k.h(paramString, "url");
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
  
  public static void b(LinkedList<fo> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(6510);
    k.h(paramLinkedList, "items");
    if (bs.gY((List)paramLinkedList))
    {
      AppMethodBeat.o(6510);
      return;
    }
    ma localma = new ma();
    int i = bJo();
    nvn.duration = (i * 1000);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (fo)localObject2;
      if (!nvm.contains(((fo)localObject3).hkN)) {
        paramLinkedList.add(localObject2);
      }
    }
    paramLinkedList = (Iterable)paramLinkedList;
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramLinkedList.iterator();
    label261:
    label322:
    label328:
    label331:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      String str = ((fo)localObject3).hkN;
      q localq = nvn;
      k.g(str, "id");
      k.h(str, "key");
      paramLinkedList = null;
      long l = localq.aCN();
      i = (int)(l % r.aCO());
      label249:
      boolean bool;
      if (l == localq.hyn[i].longValue())
      {
        paramLinkedList = localq.hyo[i];
        if (paramLinkedList == null) {
          break label322;
        }
        bool = paramLinkedList.contains(str);
        if (!bool) {
          break label328;
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label331;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        i = Math.abs(i - 1) % r.aCO();
        if (l != localq.hyn[i].longValue()) {
          break label249;
        }
        paramLinkedList = localq.hyo[i];
        break label249;
        bool = false;
        break label261;
      }
    }
    paramLinkedList = (Iterable)localObject1;
    i = aw.aKT(TAG).decodeInt("BizAppMsgRelatedInfoMaxUrlCount", 10);
    ac.v(TAG, "maxUrlCount = ".concat(String.valueOf(i)));
    paramLinkedList = j.b(paramLinkedList, Math.max(i, 2));
    localma.EaM.addAll((Collection)paramLinkedList);
    if (bs.gY((List)localma.EaM))
    {
      AppMethodBeat.o(6510);
      return;
    }
    ac.i(TAG, "getAppMsgRelatedInfo size=" + localma.EaM.size());
    localma.Scene = paramInt;
    paramLinkedList = localma.EaM;
    k.g(paramLinkedList, "req.UrlInfo");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (fo)paramLinkedList.next();
      nvm.put(((fo)localObject1).hkN, Integer.valueOf(1));
      localObject2 = nvn;
      localObject3 = ((fo)localObject1).hkN;
      k.g(localObject3, "info.ClientId");
      ((q)localObject2).Bk((String)localObject3);
      if (ac.getLogLevel() == 0) {
        ac.v(TAG, "getAppMsgRelatedInfo url=" + ((fo)localObject1).Url + ", clientId=" + ((fo)localObject1).hkN);
      }
    }
    paramLinkedList = new b.a();
    paramLinkedList.c((com.tencent.mm.bw.a)localma);
    paramLinkedList.d((com.tencent.mm.bw.a)new mb());
    paramLinkedList.Am("/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo");
    paramLinkedList.op(2864);
    paramLinkedList.or(0);
    paramLinkedList.os(0);
    IPCRunCgi.a(paramLinkedList.aAz(), (IPCRunCgi.a)new c(localma, paramInt));
    AppMethodBeat.o(6510);
  }
  
  public static int bJo()
  {
    AppMethodBeat.i(6511);
    int i = aw.aKT(TAG).decodeInt("BizAppMsgRelatedInfoRefreshIntervalSec", 300);
    ac.v(TAG, "refreshIntervalSec = ".concat(String.valueOf(i)));
    i = Math.min(i, 86400);
    AppMethodBeat.o(6511);
    return i;
  }
  
  public static void j(String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(6509);
    k.h(paramString, "url");
    long l = System.currentTimeMillis();
    kotlinx.coroutines.f.b((ag)bh.LRM, (d.d.f)ay.gdP(), (m)new b(l, paramString, paramInt1, paramInt3, 2, paramInt2, null), 2);
    AppMethodBeat.o(6509);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"})
  public static final class a
  {
    public static final a nvr;
    
    static
    {
      AppMethodBeat.i(6500);
      nvr = new a();
      AppMethodBeat.o(6500);
    }
    
    public static p Tv(String paramString)
    {
      AppMethodBeat.i(6498);
      if (paramString == null)
      {
        AppMethodBeat.o(6498);
        return null;
      }
      Object localObject1 = g.nvq;
      localObject1 = g.Tt(paramString);
      Object localObject3 = (aw)s.hyr.aKv((String)localObject1);
      if (localObject3 != null)
      {
        Object localObject2 = new fi();
        localObject3 = ((aw)localObject3).decodeBytes((String)localObject1);
        if (bs.cv((byte[])localObject3))
        {
          AppMethodBeat.o(6498);
          return null;
        }
        try
        {
          ((fi)localObject2).parseFrom((byte[])localObject3);
          localObject3 = ((fi)localObject2).DSr;
          if (localObject3 != null) {
            ((p)localObject3).Url = paramString;
          }
          if (ac.getLogLevel() == 0)
          {
            paramString = g.nvq;
            ac.v(g.bJp(), "found:" + (String)localObject1 + " last modify:" + ((fi)localObject2).lastUpdateTime);
          }
          paramString = ((fi)localObject2).DSr;
          AppMethodBeat.o(6498);
          return paramString;
        }
        catch (IOException paramString)
        {
          localObject2 = g.nvq;
          ac.printErrStackTrace(g.bJp(), (Throwable)paramString, "get:".concat(String.valueOf(localObject1)), new Object[0]);
        }
      }
      AppMethodBeat.o(6498);
      return null;
    }
    
    public static void a(p paramp)
    {
      AppMethodBeat.i(6499);
      k.h(paramp, "relatedInfo");
      try
      {
        localObject = new fi();
        ((fi)localObject).DSr = paramp;
        ((fi)localObject).lastUpdateTime = System.currentTimeMillis();
        paramp = ((fi)localObject).toByteArray();
        aw localaw = (aw)s.hyr.eUr();
        if (localaw != null)
        {
          localaw.encode(((fi)localObject).DSr.hkN, paramp);
          AppMethodBeat.o(6499);
          return;
        }
        AppMethodBeat.o(6499);
        return;
      }
      catch (Exception paramp)
      {
        Object localObject = g.nvq;
        ac.e(g.bJp(), "save ex " + paramp.getMessage());
        AppMethodBeat.o(6499);
      }
    }
  }
  
  @e(c="com.tencent.mm.plugin.brandservice.model.MPDataLogic$getAppMsgRelatedInfo$1", f="MPDataLogic.kt", l={187}, m="invokeSuspend")
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends d.d.b.a.i
    implements m<ag, d.d.d<? super y>, Object>
  {
    int label;
    private ag nvs;
    Object nvt;
    
    b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6502);
      k.h(paramd, "completion");
      paramd = new b(this.nvu, paramInt1, paramInt3, this.nut, paramInt2, this.nur, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(6502);
      return paramd;
    }
    
    public final Object cO(Object arg1)
    {
      AppMethodBeat.i(6501);
      ??? = d.d.a.a.KUd;
      Object localObject1;
      Object localObject5;
      switch (this.label)
      {
      default: 
        ??? = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6501);
        throw ???;
      case 0: 
        localObject1 = this.nvs;
        ??? = g.nvq;
        synchronized (g.bJq())
        {
          localObject5 = g.nvq;
          g.rl(this.nvu);
          localObject5 = g.nvq;
          g.bJq().add(j.ab(new Object[] { paramInt1, Integer.valueOf(paramInt3), Integer.valueOf(this.nut) }));
          this.nvt = localObject1;
          this.label = 1;
          if (as.b(1000L, this) == ???)
          {
            AppMethodBeat.o(6501);
            return ???;
          }
        }
      }
      ??? = g.nvq;
      for (;;)
      {
        synchronized (g.bJq())
        {
          localObject1 = g.nvq;
          if (g.bJr() == this.nvu)
          {
            localObject1 = g.nvq;
            localObject1 = (Collection)g.bJq();
            if (localObject1 == null) {
              break label969;
            }
            if (((Collection)localObject1).isEmpty()) {
              break label969;
            }
          }
          else
          {
            localObject1 = y.KTp;
            AppMethodBeat.o(6501);
            return localObject1;
          }
          i = 0;
          break label971;
          localObject1 = g.nvq;
          localObject1 = new ArrayList((Collection)g.bJq());
          ??? = g.nvq;
          g.bJq().clear();
          ??? = g.nvq;
          ac.v(g.bJp(), "getAppMsgRelatedInfo size:" + ((ArrayList)localObject1).size());
          localObject1 = (Iterable)j.i((Iterable)localObject1);
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
          if (???.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TJ((String)localObject6))) {
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
            ??? = new fo();
            localObject6 = ((List)localObject5).get(0);
            if (localObject6 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((fo)???).Url = ((String)localObject6);
            localObject6 = g.nvq;
            localObject6 = ((fo)???).Url;
            k.g(localObject6, "appMsgUrlInfo.Url");
            ((fo)???).hkN = g.Tt((String)localObject6);
            localObject6 = ((List)localObject5).get(1);
            if (localObject6 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((fo)???).hkQ = ((Integer)localObject6).intValue();
            ((fo)???).ReqType = 1;
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
                ((fo)???).ReqType = ((Integer)localObject5).intValue();
              }
            }
            ???.add(???);
          }
          localObject3 = g.nvq;
          g.b(???, this.nur);
        }
        ??? = y.KTp;
        AppMethodBeat.o(6501);
        return ???;
        label969:
        i = 1;
        label971:
        if (i == 0) {}
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6503);
      paramObject1 = ((b)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(6503);
      return paramObject1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(ma paramma, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(6505);
      Object localObject = g.nvq;
      ac.i(g.bJp(), "getAppMsgRelatedInfo errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      paramString = this.nvw.EaM;
      k.g(paramString, "req.UrlInfo");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject = (fo)paramString.next();
        g localg = g.nvq;
        g.bJs().remove(((fo)localObject).hkN);
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(6505);
        return;
      }
      k.g(paramb, "rr");
      paramString = paramb.aBD();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
        AppMethodBeat.o(6505);
        throw paramString;
      }
      paramString = (mb)paramString;
      paramb = g.nvq;
      paramb = aw.aKT(g.bJp());
      paramb.encode("BizAppMsgRelatedInfoRefreshIntervalSec", paramString.EaO);
      com.tencent.mm.plugin.brandservice.ui.b.a.nPA = paramString.EaO;
      paramb.encode("BizAppMsgRelatedInfoMaxUrlCount", paramString.EaP);
      if (bs.gY((List)paramString.EaN))
      {
        paramString = g.nvq;
        ac.w(g.bJp(), "getAppMsgRelatedInfo RelatedInfo is empty");
        AppMethodBeat.o(6505);
        return;
      }
      h.JZN.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6504);
          Object localObject = g.nvq;
          localObject = paramString.EaN;
          k.g(localObject, "response.RelatedInfo");
          LinkedList localLinkedList = this.nvx.nvw.EaM;
          k.g(localLinkedList, "req.UrlInfo");
          g.a((LinkedList)localObject, localLinkedList, this.nvx.hAy);
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