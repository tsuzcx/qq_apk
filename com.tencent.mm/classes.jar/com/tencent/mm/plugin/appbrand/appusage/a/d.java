package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.j;
import d.a.e;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  private static d jUk;
  public static final a jUl;
  public int dMM;
  private final k jTY;
  public final c jTZ;
  private final f jUa;
  long jUb;
  public int jUc;
  public int jUd;
  public boolean jUe;
  public int jUf;
  private final f jUg;
  private boolean jUh;
  private h.a jUi;
  public d.g.a.q<? super Integer, ? super LinkedList<csl>, ? super Integer, z> jUj;
  long lastUpdateTime;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(50317);
    jUl = new a((byte)0);
    AppMethodBeat.o(50317);
  }
  
  private d()
  {
    AppMethodBeat.i(50323);
    this.jTY = new k();
    this.jTZ = new c();
    this.jUa = d.g.O((a)d.h.jUq);
    this.jUf = 1;
    this.jUg = d.g.O((a)d.c.jUn);
    this.jUi = ((h.a)new b(this));
    this.jUj = ((d.g.a.q)d.g.jUp);
    AppMethodBeat.o(50323);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50322);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(50322);
      return;
    }
    Object localObject1 = new ze();
    ((ze)localObject1).Grf = az.getNetTypeString(ak.getContext());
    ((ze)localObject1).longitude = paramFloat1;
    ((ze)localObject1).latitude = paramFloat2;
    if ((j.DEBUG) && (paramInt != 0) && (this.jUh))
    {
      localObject1 = this.jTY;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new csl();
      ((k)localObject1).a((csl)localObject2);
      ((csl)localObject2).prd = "####客户端mock数据####大视频";
      ((csl)localObject2).mwj = 6;
      ((csl)localObject2).HDB = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((csl)localObject2).HDD = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      csl[] arrayOfcsl = new csl[4];
      int i = 0;
      if (i < 4)
      {
        csl localcsl = new csl();
        ((k)localObject1).a(localcsl);
        localcsl.HDF = new bnc();
        localcsl.HDF.Hap = 1500;
        localcsl.HDF.Hao = 1750;
        localcsl.mwj = 5;
        switch (i)
        {
        default: 
          localcsl.prd = "####客户端mock数据####商品ft";
          localcsl.HDF.Har = false;
          localcsl.HDF.Haq = true;
        }
        for (;;)
        {
          String str = localcsl.prd;
          localcsl.prd = (str + paramInt);
          arrayOfcsl[i] = localcsl;
          i += 1;
          break;
          localcsl.prd = "####客户端mock数据####商品tt";
          localcsl.HDF.Har = true;
          localcsl.HDF.Haq = true;
          continue;
          localcsl.prd = "####客户端mock数据####商品tf";
          localcsl.HDF.Har = true;
          localcsl.HDF.Haq = false;
          continue;
          localcsl.prd = "####客户端mock数据####商品ff";
          localcsl.HDF.Har = false;
          localcsl.HDF.Haq = false;
        }
      }
      p.h(localObject2, "$this$addAll");
      p.h(arrayOfcsl, "elements");
      ((Collection)localObject2).addAll((Collection)e.asList(arrayOfcsl));
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(50322);
        return;
      }
    }
    h.a(paramInt, (ze)localObject1, this.sessionId, this.jUi, this.jUf);
    AppMethodBeat.o(50322);
  }
  
  private final void a(int paramInt1, LinkedList<csl> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(50320);
    d.g.a.q localq = this.jUj;
    if (localq != null)
    {
      localq.d(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
      AppMethodBeat.o(50320);
      return;
    }
    AppMethodBeat.o(50320);
  }
  
  private final LinkedList<Integer> bdr()
  {
    AppMethodBeat.i(50318);
    LinkedList localLinkedList = (LinkedList)this.jUa.getValue();
    AppMethodBeat.o(50318);
    return localLinkedList;
  }
  
  public final LinkedList<csl> bds()
  {
    AppMethodBeat.i(50319);
    LinkedList localLinkedList = (LinkedList)this.jUg.getValue();
    AppMethodBeat.o(50319);
    return localLinkedList;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public final d bdu()
    {
      try
      {
        AppMethodBeat.i(50305);
        if (d.bdt() == null) {
          d.h(new d((byte)0));
        }
        d locald = d.bdt();
        if (locald == null) {
          p.gkB();
        }
        AppMethodBeat.o(50305);
        return locald;
      }
      finally {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
  public static final class b
    implements h.a
  {
    public final void a(bid parambid)
    {
      AppMethodBeat.i(50306);
      p.h(parambid, "response");
      d.a(this.jUm, parambid);
      AppMethodBeat.o(50306);
    }
    
    public final void bdv()
    {
      AppMethodBeat.i(50307);
      d.a(this.jUm, 1, null, 6);
      AppMethodBeat.o(50307);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
  static final class d
    implements c.a
  {
    d(d paramd) {}
    
    public final void F(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(50310);
      Iterator localIterator = d.g(this.jUm).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        d locald = this.jUm;
        p.g(localInteger, "item");
        d.a(locald, localInteger.intValue(), paramFloat1, paramFloat2);
      }
      d.g(this.jUm).clear();
      AppMethodBeat.o(50310);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.q
    implements a<z>
  {
    public e(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class f
    extends d.g.b.q
    implements a<z>
  {
    public f(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d
 * JD-Core Version:    0.7.0.1
 */