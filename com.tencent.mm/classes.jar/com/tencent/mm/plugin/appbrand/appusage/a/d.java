package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import d.a.j;
import d.f;
import d.g.a.a;
import d.g.a.q;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  private static d iWG;
  public static final a iWH;
  public int dBx;
  public boolean iWA;
  public int iWB;
  private final f iWC;
  private boolean iWD;
  private h.a iWE;
  public q<? super Integer, ? super LinkedList<chm>, ? super Integer, y> iWF;
  private final k iWu;
  public final c iWv;
  private final f iWw;
  long iWx;
  public int iWy;
  public int iWz;
  long lastUpdateTime;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(50317);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(d.class), "rList", "getRList()Ljava/util/LinkedList;")), (d.l.k)w.a(new u(w.bk(d.class), "dataList", "getDataList()Ljava/util/LinkedList;")) };
    iWH = new a((byte)0);
    AppMethodBeat.o(50317);
  }
  
  private d()
  {
    AppMethodBeat.i(50323);
    this.iWu = new k();
    this.iWv = new c();
    this.iWw = d.g.E((a)d.h.iWM);
    this.iWB = 1;
    this.iWC = d.g.E((a)d.c.iWJ);
    this.iWE = ((h.a)new b(this));
    this.iWF = ((q)d.g.iWL);
    AppMethodBeat.o(50323);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50322);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(50322);
      return;
    }
    Object localObject1 = new wq();
    ((wq)localObject1).CYL = ay.getNetTypeString(aj.getContext());
    ((wq)localObject1).longitude = paramFloat1;
    ((wq)localObject1).latitude = paramFloat2;
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) && (paramInt != 0) && (this.iWD))
    {
      localObject1 = this.iWu;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new chm();
      ((k)localObject1).a((chm)localObject2);
      ((chm)localObject2).odv = "####客户端mock数据####大视频";
      ((chm)localObject2).lpz = 6;
      ((chm)localObject2).EcV = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((chm)localObject2).EcX = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      chm[] arrayOfchm = new chm[4];
      int i = 0;
      if (i < 4)
      {
        chm localchm = new chm();
        ((k)localObject1).a(localchm);
        localchm.EcZ = new bek();
        localchm.EcZ.DBV = 1500;
        localchm.EcZ.DBU = 1750;
        localchm.lpz = 5;
        switch (i)
        {
        default: 
          localchm.odv = "####客户端mock数据####商品ft";
          localchm.EcZ.DBX = false;
          localchm.EcZ.DBW = true;
        }
        for (;;)
        {
          String str = localchm.odv;
          localchm.odv = (str + paramInt);
          arrayOfchm[i] = localchm;
          i += 1;
          break;
          localchm.odv = "####客户端mock数据####商品tt";
          localchm.EcZ.DBX = true;
          localchm.EcZ.DBW = true;
          continue;
          localchm.odv = "####客户端mock数据####商品tf";
          localchm.EcZ.DBX = true;
          localchm.EcZ.DBW = false;
          continue;
          localchm.odv = "####客户端mock数据####商品ff";
          localchm.EcZ.DBX = false;
          localchm.EcZ.DBW = false;
        }
      }
      j.addAll((Collection)localObject2, arrayOfchm);
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(50322);
        return;
      }
    }
    h.a(paramInt, (wq)localObject1, this.sessionId, this.iWE, this.iWB);
    AppMethodBeat.o(50322);
  }
  
  private final void a(int paramInt1, LinkedList<chm> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(50320);
    q localq = this.iWF;
    if (localq != null)
    {
      localq.d(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
      AppMethodBeat.o(50320);
      return;
    }
    AppMethodBeat.o(50320);
  }
  
  private final LinkedList<Integer> aSr()
  {
    AppMethodBeat.i(50318);
    LinkedList localLinkedList = (LinkedList)this.iWw.getValue();
    AppMethodBeat.o(50318);
    return localLinkedList;
  }
  
  public final LinkedList<chm> aSs()
  {
    AppMethodBeat.i(50319);
    LinkedList localLinkedList = (LinkedList)this.iWC.getValue();
    AppMethodBeat.o(50319);
    return localLinkedList;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public final d aSu()
    {
      try
      {
        AppMethodBeat.i(50305);
        if (d.aSt() == null) {
          d.h(new d((byte)0));
        }
        d locald = d.aSt();
        if (locald == null) {
          d.g.b.k.fvU();
        }
        AppMethodBeat.o(50305);
        return locald;
      }
      finally {}
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
  public static final class b
    implements h.a
  {
    public final void a(azp paramazp)
    {
      AppMethodBeat.i(50306);
      d.g.b.k.h(paramazp, "response");
      d.a(this.iWI, paramazp);
      AppMethodBeat.o(50306);
    }
    
    public final void aSv()
    {
      AppMethodBeat.i(50307);
      d.a(this.iWI, 1, null, 6);
      AppMethodBeat.o(50307);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
  static final class d
    implements c.a
  {
    d(d paramd) {}
    
    public final void B(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(50310);
      Iterator localIterator = d.g(this.iWI).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        d locald = this.iWI;
        d.g.b.k.g(localInteger, "item");
        d.a(locald, localInteger.intValue(), paramFloat1, paramFloat2);
      }
      d.g(this.iWI).clear();
      AppMethodBeat.o(50310);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.l
    implements a<y>
  {
    public e(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class f
    extends d.g.b.l
    implements a<y>
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