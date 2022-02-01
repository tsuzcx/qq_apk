package com.tencent.mm.plugin.brandservice.b;

import android.util.Base64;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.am.q;
import com.tencent.mm.am.r;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
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
import kotlinx.coroutines.ao;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"})
public final class h
{
  public static final String TAG = "MicroMsg.MPDataLogic";
  private static final ConcurrentHashMap<String, Integer> mSU;
  private static final q mSV;
  public static long mSW;
  public static Queue<List<Object>> mSX;
  public static final h mSY;
  
  static
  {
    AppMethodBeat.i(6512);
    mSY = new h();
    TAG = "MicroMsg.MPDataLogic";
    mSU = new ConcurrentHashMap();
    mSV = new q();
    mSX = (Queue)new LinkedList();
    AppMethodBeat.o(6512);
  }
  
  public static String Pj(String paramString)
  {
    AppMethodBeat.i(6506);
    k.h(paramString, "url");
    paramString = "_mpdata_" + com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.PA(paramString);
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static boolean Pk(String paramString)
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
  
  public static String Q(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static void b(LinkedList<fm> paramLinkedList, final int paramInt)
  {
    AppMethodBeat.i(6510);
    k.h(paramLinkedList, "items");
    if (bt.gL((List)paramLinkedList))
    {
      AppMethodBeat.o(6510);
      return;
    }
    lt locallt = new lt();
    int i = bCl();
    mSV.duration = (i * 1000);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (fm)localObject2;
      if (!mSU.contains(((fm)localObject3).gKn)) {
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
      String str = ((fm)localObject3).gKn;
      q localq = mSV;
      k.g(str, "id");
      k.h(str, "key");
      paramLinkedList = null;
      long l = localq.avV();
      i = (int)(l % r.avW());
      label249:
      boolean bool;
      if (l == localq.gXO[i].longValue())
      {
        paramLinkedList = localq.gXP[i];
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
        i = Math.abs(i - 1) % r.avW();
        if (l != localq.gXO[i].longValue()) {
          break label249;
        }
        paramLinkedList = localq.gXP[i];
        break label249;
        bool = false;
        break label261;
      }
    }
    paramLinkedList = (Iterable)localObject1;
    i = ax.aFC(TAG).decodeInt("BizAppMsgRelatedInfoMaxUrlCount", 10);
    com.tencent.mm.sdk.platformtools.ad.v(TAG, "maxUrlCount = ".concat(String.valueOf(i)));
    paramLinkedList = d.a.j.b(paramLinkedList, Math.max(i, 2));
    locallt.CIk.addAll((Collection)paramLinkedList);
    if (bt.gL((List)locallt.CIk))
    {
      AppMethodBeat.o(6510);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "getAppMsgRelatedInfo size=" + locallt.CIk.size());
    locallt.Scene = paramInt;
    paramLinkedList = locallt.CIk;
    k.g(paramLinkedList, "req.UrlInfo");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (fm)paramLinkedList.next();
      mSU.put(((fm)localObject1).gKn, Integer.valueOf(1));
      localObject2 = mSV;
      localObject3 = ((fm)localObject1).gKn;
      k.g(localObject3, "info.ClientId");
      ((q)localObject2).xe((String)localObject3);
      if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() == 0) {
        com.tencent.mm.sdk.platformtools.ad.v(TAG, "getAppMsgRelatedInfo url=" + ((fm)localObject1).Url + ", clientId=" + ((fm)localObject1).gKn);
      }
    }
    paramLinkedList = new b.a();
    paramLinkedList.c((com.tencent.mm.bx.a)locallt);
    paramLinkedList.d((com.tencent.mm.bx.a)new lu());
    paramLinkedList.wg("/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo");
    paramLinkedList.nB(2864);
    paramLinkedList.nD(0);
    paramLinkedList.nE(0);
    IPCRunCgi.a(paramLinkedList.atI(), (IPCRunCgi.a)new c(locallt, paramInt));
    AppMethodBeat.o(6510);
  }
  
  public static int bCl()
  {
    AppMethodBeat.i(6511);
    int i = ax.aFC(TAG).decodeInt("BizAppMsgRelatedInfoRefreshIntervalSec", 300);
    com.tencent.mm.sdk.platformtools.ad.v(TAG, "refreshIntervalSec = ".concat(String.valueOf(i)));
    i = Math.min(i, 86400);
    AppMethodBeat.o(6511);
    return i;
  }
  
  public static void j(String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(6509);
    k.h(paramString, "url");
    long l = System.currentTimeMillis();
    kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, (d.d.f)at.fLg(), (m)new b(l, paramString, paramInt1, paramInt3, 2, paramInt2, null), 2);
    AppMethodBeat.o(6509);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"})
  public static final class a
  {
    public static final a mSZ;
    
    static
    {
      AppMethodBeat.i(6500);
      mSZ = new a();
      AppMethodBeat.o(6500);
    }
    
    public static p Pl(String paramString)
    {
      AppMethodBeat.i(6498);
      if (paramString == null)
      {
        AppMethodBeat.o(6498);
        return null;
      }
      Object localObject1 = h.mSY;
      localObject1 = h.Pj(paramString);
      Object localObject3 = (ax)s.gXS.aFe((String)localObject1);
      if (localObject3 != null)
      {
        Object localObject2 = new fg();
        localObject3 = ((ax)localObject3).decodeBytes((String)localObject1);
        if (bt.cw((byte[])localObject3))
        {
          AppMethodBeat.o(6498);
          return null;
        }
        try
        {
          ((fg)localObject2).parseFrom((byte[])localObject3);
          localObject3 = ((fg)localObject2).CzV;
          if (localObject3 != null) {
            ((p)localObject3).Url = paramString;
          }
          if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() == 0)
          {
            paramString = h.mSY;
            com.tencent.mm.sdk.platformtools.ad.v(h.bCm(), "found:" + (String)localObject1 + " last modify:" + ((fg)localObject2).lastUpdateTime);
          }
          paramString = ((fg)localObject2).CzV;
          AppMethodBeat.o(6498);
          return paramString;
        }
        catch (IOException paramString)
        {
          localObject2 = h.mSY;
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(h.bCm(), (Throwable)paramString, "get:".concat(String.valueOf(localObject1)), new Object[0]);
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
        localObject = new fg();
        ((fg)localObject).CzV = paramp;
        ((fg)localObject).lastUpdateTime = System.currentTimeMillis();
        paramp = ((fg)localObject).toByteArray();
        ax localax = (ax)s.gXS.eEX();
        if (localax != null)
        {
          localax.encode(((fg)localObject).CzV.gKn, paramp);
          AppMethodBeat.o(6499);
          return;
        }
        AppMethodBeat.o(6499);
        return;
      }
      catch (Exception paramp)
      {
        Object localObject = h.mSY;
        com.tencent.mm.sdk.platformtools.ad.e(h.bCm(), "save ex " + paramp.getMessage());
        AppMethodBeat.o(6499);
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.model.MPDataLogic$getAppMsgRelatedInfo$1", f="MPDataLogic.kt", l={187}, m="invokeSuspend")
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6502);
      k.h(paramd, "completion");
      paramd = new b(this.mTc, paramInt1, paramInt3, this.mSd, paramInt2, this.mSb, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(6502);
      return paramd;
    }
    
    public final Object cP(Object arg1)
    {
      AppMethodBeat.i(6501);
      ??? = d.d.a.a.JgJ;
      Object localObject1;
      Object localObject5;
      switch (this.label)
      {
      default: 
        ??? = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6501);
        throw ???;
      case 0: 
        localObject1 = this.mTa;
        ??? = h.mSY;
        synchronized (h.bCn())
        {
          localObject5 = h.mSY;
          h.nz(this.mTc);
          localObject5 = h.mSY;
          h.bCn().add(d.a.j.Z(new Object[] { paramInt1, Integer.valueOf(paramInt3), Integer.valueOf(this.mSd) }));
          this.mTb = localObject1;
          this.label = 1;
          if (ao.a(1000L, this) == ???)
          {
            AppMethodBeat.o(6501);
            return ???;
          }
        }
      }
      ??? = h.mSY;
      for (;;)
      {
        synchronized (h.bCn())
        {
          localObject1 = h.mSY;
          if (h.bCo() == this.mTc)
          {
            localObject1 = h.mSY;
            localObject1 = (Collection)h.bCn();
            if (localObject1 == null) {
              break label969;
            }
            if (((Collection)localObject1).isEmpty()) {
              break label969;
            }
          }
          else
          {
            localObject1 = y.JfV;
            AppMethodBeat.o(6501);
            return localObject1;
          }
          i = 0;
          break label971;
          localObject1 = h.mSY;
          localObject1 = new ArrayList((Collection)h.bCn());
          ??? = h.mSY;
          h.bCn().clear();
          ??? = h.mSY;
          com.tencent.mm.sdk.platformtools.ad.v(h.bCm(), "getAppMsgRelatedInfo size:" + ((ArrayList)localObject1).size());
          localObject1 = (Iterable)d.a.j.j((Iterable)localObject1);
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
          if (???.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Py((String)localObject6))) {
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
            ??? = new fm();
            localObject6 = ((List)localObject5).get(0);
            if (localObject6 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((fm)???).Url = ((String)localObject6);
            localObject6 = h.mSY;
            localObject6 = ((fm)???).Url;
            k.g(localObject6, "appMsgUrlInfo.Url");
            ((fm)???).gKn = h.Pj((String)localObject6);
            localObject6 = ((List)localObject5).get(1);
            if (localObject6 == null)
            {
              ??? = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(6501);
              throw ???;
            }
            ((fm)???).gKq = ((Integer)localObject6).intValue();
            ((fm)???).ReqType = 1;
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
                ((fm)???).ReqType = ((Integer)localObject5).intValue();
              }
            }
            ???.add(???);
          }
          localObject3 = h.mSY;
          h.b(???, this.mSb);
        }
        ??? = y.JfV;
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
      paramObject1 = ((b)a(paramObject1, (d.d.d)paramObject2)).cP(y.JfV);
      AppMethodBeat.o(6503);
      return paramObject1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(lt paramlt, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(6505);
      Object localObject = h.mSY;
      com.tencent.mm.sdk.platformtools.ad.i(h.bCm(), "getAppMsgRelatedInfo errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      paramString = this.mTe.CIk;
      k.g(paramString, "req.UrlInfo");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject = (fm)paramString.next();
        h localh = h.mSY;
        h.bCp().remove(((fm)localObject).gKn);
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(6505);
        return;
      }
      k.g(paramb, "rr");
      paramString = paramb.auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
        AppMethodBeat.o(6505);
        throw paramString;
      }
      paramString = (lu)paramString;
      paramb = h.mSY;
      paramb = ax.aFC(h.bCm());
      paramb.encode("BizAppMsgRelatedInfoRefreshIntervalSec", paramString.CIm);
      com.tencent.mm.plugin.brandservice.ui.b.a.nmA = paramString.CIm;
      paramb.encode("BizAppMsgRelatedInfoMaxUrlCount", paramString.CIn);
      if (bt.gL((List)paramString.CIl))
      {
        paramString = h.mSY;
        com.tencent.mm.sdk.platformtools.ad.w(h.bCm(), "getAppMsgRelatedInfo RelatedInfo is empty");
        AppMethodBeat.o(6505);
        return;
      }
      com.tencent.e.h.Iye.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6504);
          Object localObject = h.mSY;
          localObject = paramString.CIl;
          k.g(localObject, "response.RelatedInfo");
          LinkedList localLinkedList = this.mTf.mTe.CIk;
          k.g(localLinkedList, "req.UrlInfo");
          h.a((LinkedList)localObject, localLinkedList, this.mTf.gZZ);
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