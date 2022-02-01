package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.e;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  private static d kXg;
  public static final a kXh;
  public int eeE;
  private final k kWU;
  public final c kWV;
  private final f kWW;
  long kWX;
  public int kWY;
  public int kWZ;
  public boolean kXa;
  public int kXb;
  private final f kXc;
  private boolean kXd;
  private h.a kXe;
  public kotlin.g.a.q<? super Integer, ? super LinkedList<dko>, ? super Integer, x> kXf;
  long lastUpdateTime;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(50317);
    kXh = new a((byte)0);
    AppMethodBeat.o(50317);
  }
  
  private d()
  {
    AppMethodBeat.i(50323);
    this.kWU = new k();
    this.kWV = new c();
    this.kWW = kotlin.g.ah((a)d.h.kXm);
    this.kXb = 1;
    this.kXc = kotlin.g.ah((a)d.c.kXj);
    this.kXe = ((h.a)new b(this));
    this.kXf = ((kotlin.g.a.q)d.g.kXl);
    AppMethodBeat.o(50323);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50322);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      AppMethodBeat.o(50322);
      return;
    }
    Object localObject1 = new aat();
    ((aat)localObject1).Lmb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    ((aat)localObject1).longitude = paramFloat1;
    ((aat)localObject1).latitude = paramFloat2;
    if ((BuildInfo.DEBUG) && (paramInt != 0) && (this.kXd))
    {
      localObject1 = this.kWU;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new dko();
      ((k)localObject1).a((dko)localObject2);
      ((dko)localObject2).qGI = "####客户端mock数据####大视频";
      ((dko)localObject2).nHh = 6;
      ((dko)localObject2).MOv = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((dko)localObject2).MOx = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      dko[] arrayOfdko = new dko[4];
      int i = 0;
      if (i < 4)
      {
        dko localdko = new dko();
        ((k)localObject1).a(localdko);
        localdko.MOz = new bzt();
        localdko.MOz.Mfp = 1500;
        localdko.MOz.Mfo = 1750;
        localdko.nHh = 5;
        switch (i)
        {
        default: 
          localdko.qGI = "####客户端mock数据####商品ft";
          localdko.MOz.Mfr = false;
          localdko.MOz.Mfq = true;
        }
        for (;;)
        {
          String str = localdko.qGI;
          localdko.qGI = (str + paramInt);
          arrayOfdko[i] = localdko;
          i += 1;
          break;
          localdko.qGI = "####客户端mock数据####商品tt";
          localdko.MOz.Mfr = true;
          localdko.MOz.Mfq = true;
          continue;
          localdko.qGI = "####客户端mock数据####商品tf";
          localdko.MOz.Mfr = true;
          localdko.MOz.Mfq = false;
          continue;
          localdko.qGI = "####客户端mock数据####商品ff";
          localdko.MOz.Mfr = false;
          localdko.MOz.Mfq = false;
        }
      }
      p.h(localObject2, "$this$addAll");
      p.h(arrayOfdko, "elements");
      ((Collection)localObject2).addAll((Collection)e.asList(arrayOfdko));
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(50322);
        return;
      }
    }
    h.a(paramInt, (aat)localObject1, this.sessionId, this.kXe, this.kXb);
    AppMethodBeat.o(50322);
  }
  
  private final void a(int paramInt1, LinkedList<dko> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(50320);
    kotlin.g.a.q localq = this.kXf;
    if (localq != null)
    {
      localq.d(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
      AppMethodBeat.o(50320);
      return;
    }
    AppMethodBeat.o(50320);
  }
  
  private final LinkedList<Integer> byJ()
  {
    AppMethodBeat.i(50318);
    LinkedList localLinkedList = (LinkedList)this.kWW.getValue();
    AppMethodBeat.o(50318);
    return localLinkedList;
  }
  
  public final LinkedList<dko> byK()
  {
    AppMethodBeat.i(50319);
    LinkedList localLinkedList = (LinkedList)this.kXc.getValue();
    AppMethodBeat.o(50319);
    return localLinkedList;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public final d byM()
    {
      try
      {
        AppMethodBeat.i(50305);
        if (d.byL() == null) {
          d.h(new d((byte)0));
        }
        d locald = d.byL();
        if (locald == null) {
          p.hyc();
        }
        AppMethodBeat.o(50305);
        return locald;
      }
      finally {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
  public static final class b
    implements h.a
  {
    public final void a(bud parambud)
    {
      AppMethodBeat.i(50306);
      p.h(parambud, "response");
      d.a(this.kXi, parambud);
      AppMethodBeat.o(50306);
    }
    
    public final void byN()
    {
      AppMethodBeat.i(50307);
      d.a(this.kXi, 1, null, 6);
      AppMethodBeat.o(50307);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
  static final class d
    implements c.a
  {
    d(d paramd) {}
    
    public final void J(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(50310);
      Iterator localIterator = d.g(this.kXi).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        d locald = this.kXi;
        p.g(localInteger, "item");
        d.a(locald, localInteger.intValue(), paramFloat1, paramFloat2);
      }
      d.g(this.kXi).clear();
      AppMethodBeat.o(50310);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class e
    extends kotlin.g.b.q
    implements a<x>
  {
    public e(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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