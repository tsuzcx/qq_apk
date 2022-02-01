package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.enb;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a qQT;
  private static d qRg;
  public int ieV;
  long lastUpdateTime;
  private final j qQU;
  public final c qQV;
  private final kotlin.j qQW;
  long qQX;
  public int qQY;
  public int qQZ;
  public boolean qRa;
  public int qRb;
  private final kotlin.j qRc;
  private boolean qRd;
  private g.a qRe;
  public q<? super Integer, ? super LinkedList<enb>, ? super Integer, ah> qRf;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(50317);
    qQT = new a((byte)0);
    AppMethodBeat.o(50317);
  }
  
  private d()
  {
    AppMethodBeat.i(50323);
    this.qQU = new j();
    this.qQV = new c();
    this.qQW = k.cm((a)d.g.qRl);
    this.qRb = 1;
    this.qRc = k.cm((a)d.c.qRi);
    this.qRe = ((g.a)new b(this));
    this.qRf = ((q)d.f.qRk);
    AppMethodBeat.o(50323);
  }
  
  private final void a(int paramInt1, LinkedList<enb> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(50320);
    q localq = this.qRf;
    if (localq != null) {
      localq.invoke(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(50320);
  }
  
  private static final void a(d paramd, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(319373);
    s.u(paramd, "this$0");
    Iterator localIterator = paramd.cjy().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      s.s(localInteger, "item");
      paramd.b(localInteger.intValue(), paramFloat1, paramFloat2);
    }
    paramd.cjy().clear();
    AppMethodBeat.o(319373);
  }
  
  private final void b(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50322);
    if (!h.baz())
    {
      AppMethodBeat.o(50322);
      return;
    }
    Object localObject1 = new acz();
    ((acz)localObject1).ZlB = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    ((acz)localObject1).longitude = paramFloat1;
    ((acz)localObject1).latitude = paramFloat2;
    if ((BuildInfo.DEBUG) && (paramInt != 0) && (this.qRd))
    {
      localObject1 = this.qQU;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new enb();
      ((j)localObject1).a((enb)localObject2);
      ((enb)localObject2).recommend_reason = "####客户端mock数据####大视频";
      ((enb)localObject2).tNW = 6;
      ((enb)localObject2).abrq = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((enb)localObject2).abrs = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      enb[] arrayOfenb = new enb[4];
      int i = 0;
      if (i < 4)
      {
        enb localenb = new enb();
        ((j)localObject1).a(localenb);
        localenb.abrv = new cxp();
        localenb.abrv.aaif = 1500;
        localenb.abrv.DVv = 1750;
        localenb.tNW = 5;
        switch (i)
        {
        default: 
          localenb.recommend_reason = "####客户端mock数据####商品ft";
          localenb.abrv.aaCY = false;
          localenb.abrv.aaCX = true;
        }
        for (;;)
        {
          localenb.recommend_reason = s.X(localenb.recommend_reason, Integer.valueOf(paramInt));
          arrayOfenb[i] = localenb;
          i += 1;
          break;
          localenb.recommend_reason = "####客户端mock数据####商品tt";
          localenb.abrv.aaCY = true;
          localenb.abrv.aaCX = true;
          continue;
          localenb.recommend_reason = "####客户端mock数据####商品tf";
          localenb.abrv.aaCY = true;
          localenb.abrv.aaCX = false;
          continue;
          localenb.recommend_reason = "####客户端mock数据####商品ff";
          localenb.abrv.aaCY = false;
          localenb.abrv.aaCX = false;
        }
      }
      p.a((Collection)localObject2, arrayOfenb);
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(50322);
        return;
      }
    }
    g.a(paramInt, (acz)localObject1, this.sessionId, this.qRe, this.qRb);
    AppMethodBeat.o(50322);
  }
  
  private final LinkedList<Integer> cjy()
  {
    AppMethodBeat.i(50318);
    LinkedList localLinkedList = (LinkedList)this.qQW.getValue();
    AppMethodBeat.o(50318);
    return localLinkedList;
  }
  
  public final LinkedList<enb> cjz()
  {
    AppMethodBeat.i(50319);
    LinkedList localLinkedList = (LinkedList)this.qRc.getValue();
    AppMethodBeat.o(50319);
    return localLinkedList;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "get", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final d cjB()
    {
      try
      {
        AppMethodBeat.i(50305);
        if (d.cjA() == null) {
          d.a(new d((byte)0));
        }
        d locald = d.cjA();
        s.checkNotNull(locald);
        AppMethodBeat.o(50305);
        return locald;
      }
      finally {}
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(d paramd) {}
    
    public final void a(crc paramcrc)
    {
      AppMethodBeat.i(50306);
      s.u(paramcrc, "response");
      d.a(this.qRh, paramcrc);
      AppMethodBeat.o(50306);
    }
    
    public final void cjC()
    {
      AppMethodBeat.i(50307);
      d.a(this.qRh, 1, null, 6);
      AppMethodBeat.o(50307);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements a<ah>
  {
    public e(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d
 * JD-Core Version:    0.7.0.1
 */