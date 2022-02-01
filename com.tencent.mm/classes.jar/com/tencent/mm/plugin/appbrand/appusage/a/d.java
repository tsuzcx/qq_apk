package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  private static d nRs;
  public static final a nRt;
  public int fYT;
  long lastUpdateTime;
  private final k nRg;
  public final c nRh;
  private final f nRi;
  long nRj;
  public int nRk;
  public int nRl;
  public boolean nRm;
  public int nRn;
  private final f nRo;
  private boolean nRp;
  private h.a nRq;
  public kotlin.g.a.q<? super Integer, ? super LinkedList<dud>, ? super Integer, x> nRr;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(50317);
    nRt = new a((byte)0);
    AppMethodBeat.o(50317);
  }
  
  private d()
  {
    AppMethodBeat.i(50323);
    this.nRg = new k();
    this.nRh = new c();
    this.nRi = g.ar((a)d.h.nRy);
    this.nRn = 1;
    this.nRo = g.ar((a)d.c.nRv);
    this.nRq = ((h.a)new b(this));
    this.nRr = ((kotlin.g.a.q)d.g.nRx);
    AppMethodBeat.o(50323);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50322);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(50322);
      return;
    }
    Object localObject1 = new aaz();
    ((aaz)localObject1).Snp = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    ((aaz)localObject1).longitude = paramFloat1;
    ((aaz)localObject1).latitude = paramFloat2;
    if ((BuildInfo.DEBUG) && (paramInt != 0) && (this.nRp))
    {
      localObject1 = this.nRg;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new dud();
      ((k)localObject1).a((dud)localObject2);
      ((dud)localObject2).ufJ = "####客户端mock数据####大视频";
      ((dud)localObject2).qJt = 6;
      ((dud)localObject2).Uao = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((dud)localObject2).Uaq = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      dud[] arrayOfdud = new dud[4];
      int i = 0;
      if (i < 4)
      {
        dud localdud = new dud();
        ((k)localObject1).a(localdud);
        localdud.Uat = new cho();
        localdud.Uat.ToT = 1500;
        localdud.Uat.ToS = 1750;
        localdud.qJt = 5;
        switch (i)
        {
        default: 
          localdud.ufJ = "####客户端mock数据####商品ft";
          localdud.Uat.ToV = false;
          localdud.Uat.ToU = true;
        }
        for (;;)
        {
          String str = localdud.ufJ;
          localdud.ufJ = (str + paramInt);
          arrayOfdud[i] = localdud;
          i += 1;
          break;
          localdud.ufJ = "####客户端mock数据####商品tt";
          localdud.Uat.ToV = true;
          localdud.Uat.ToU = true;
          continue;
          localdud.ufJ = "####客户端mock数据####商品tf";
          localdud.Uat.ToV = true;
          localdud.Uat.ToU = false;
          continue;
          localdud.ufJ = "####客户端mock数据####商品ff";
          localdud.Uat.ToV = false;
          localdud.Uat.ToU = false;
        }
      }
      j.a((Collection)localObject2, arrayOfdud);
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(50322);
        return;
      }
    }
    h.a(paramInt, (aaz)localObject1, this.sessionId, this.nRq, this.nRn);
    AppMethodBeat.o(50322);
  }
  
  private final void a(int paramInt1, LinkedList<dud> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(50320);
    kotlin.g.a.q localq = this.nRr;
    if (localq != null)
    {
      localq.c(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
      AppMethodBeat.o(50320);
      return;
    }
    AppMethodBeat.o(50320);
  }
  
  private final LinkedList<Integer> bJX()
  {
    AppMethodBeat.i(50318);
    LinkedList localLinkedList = (LinkedList)this.nRi.getValue();
    AppMethodBeat.o(50318);
    return localLinkedList;
  }
  
  public final LinkedList<dud> bJY()
  {
    AppMethodBeat.i(50319);
    LinkedList localLinkedList = (LinkedList)this.nRo.getValue();
    AppMethodBeat.o(50319);
    return localLinkedList;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public final d bKa()
    {
      try
      {
        AppMethodBeat.i(50305);
        if (d.bJZ() == null) {
          d.h(new d((byte)0));
        }
        d locald = d.bJZ();
        if (locald == null) {
          p.iCn();
        }
        AppMethodBeat.o(50305);
        return locald;
      }
      finally {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
  public static final class b
    implements h.a
  {
    public final void a(cbv paramcbv)
    {
      AppMethodBeat.i(50306);
      p.k(paramcbv, "response");
      d.a(this.nRu, paramcbv);
      AppMethodBeat.o(50306);
    }
    
    public final void bKb()
    {
      AppMethodBeat.i(50307);
      d.a(this.nRu, 1, null, 6);
      AppMethodBeat.o(50307);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class f
    extends kotlin.g.b.q
    implements a<x>
  {
    public f(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d
 * JD-Core Version:    0.7.0.1
 */