package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.i;
import d.a.e;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  private static d jQS;
  public static final a jQT;
  public int dLx;
  private final k jQG;
  public final c jQH;
  private final f jQI;
  long jQJ;
  public int jQK;
  public int jQL;
  public boolean jQM;
  public int jQN;
  private final f jQO;
  private boolean jQP;
  private h.a jQQ;
  public d.g.a.q<? super Integer, ? super LinkedList<crr>, ? super Integer, z> jQR;
  long lastUpdateTime;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(50317);
    jQT = new a((byte)0);
    AppMethodBeat.o(50317);
  }
  
  private d()
  {
    AppMethodBeat.i(50323);
    this.jQG = new k();
    this.jQH = new c();
    this.jQI = d.g.O((a)d.h.jQY);
    this.jQN = 1;
    this.jQO = d.g.O((a)d.c.jQV);
    this.jQQ = ((h.a)new b(this));
    this.jQR = ((d.g.a.q)d.g.jQX);
    AppMethodBeat.o(50323);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50322);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(50322);
      return;
    }
    Object localObject1 = new zb();
    ((zb)localObject1).FYG = ay.getNetTypeString(aj.getContext());
    ((zb)localObject1).longitude = paramFloat1;
    ((zb)localObject1).latitude = paramFloat2;
    if ((i.DEBUG) && (paramInt != 0) && (this.jQP))
    {
      localObject1 = this.jQG;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new crr();
      ((k)localObject1).a((crr)localObject2);
      ((crr)localObject2).pky = "####客户端mock数据####大视频";
      ((crr)localObject2).mrl = 6;
      ((crr)localObject2).Hkb = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((crr)localObject2).Hkd = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      crr[] arrayOfcrr = new crr[4];
      int i = 0;
      if (i < 4)
      {
        crr localcrr = new crr();
        ((k)localObject1).a(localcrr);
        localcrr.Hkf = new bmk();
        localcrr.Hkf.GGN = 1500;
        localcrr.Hkf.GGM = 1750;
        localcrr.mrl = 5;
        switch (i)
        {
        default: 
          localcrr.pky = "####客户端mock数据####商品ft";
          localcrr.Hkf.GGP = false;
          localcrr.Hkf.GGO = true;
        }
        for (;;)
        {
          String str = localcrr.pky;
          localcrr.pky = (str + paramInt);
          arrayOfcrr[i] = localcrr;
          i += 1;
          break;
          localcrr.pky = "####客户端mock数据####商品tt";
          localcrr.Hkf.GGP = true;
          localcrr.Hkf.GGO = true;
          continue;
          localcrr.pky = "####客户端mock数据####商品tf";
          localcrr.Hkf.GGP = true;
          localcrr.Hkf.GGO = false;
          continue;
          localcrr.pky = "####客户端mock数据####商品ff";
          localcrr.Hkf.GGP = false;
          localcrr.Hkf.GGO = false;
        }
      }
      p.h(localObject2, "$this$addAll");
      p.h(arrayOfcrr, "elements");
      ((Collection)localObject2).addAll((Collection)e.asList(arrayOfcrr));
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(50322);
        return;
      }
    }
    h.a(paramInt, (zb)localObject1, this.sessionId, this.jQQ, this.jQN);
    AppMethodBeat.o(50322);
  }
  
  private final void a(int paramInt1, LinkedList<crr> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(50320);
    d.g.a.q localq = this.jQR;
    if (localq != null)
    {
      localq.d(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
      AppMethodBeat.o(50320);
      return;
    }
    AppMethodBeat.o(50320);
  }
  
  private final LinkedList<Integer> bcM()
  {
    AppMethodBeat.i(50318);
    LinkedList localLinkedList = (LinkedList)this.jQI.getValue();
    AppMethodBeat.o(50318);
    return localLinkedList;
  }
  
  public final LinkedList<crr> bcN()
  {
    AppMethodBeat.i(50319);
    LinkedList localLinkedList = (LinkedList)this.jQO.getValue();
    AppMethodBeat.o(50319);
    return localLinkedList;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public final d bcP()
    {
      try
      {
        AppMethodBeat.i(50305);
        if (d.bcO() == null) {
          d.h(new d((byte)0));
        }
        d locald = d.bcO();
        if (locald == null) {
          p.gfZ();
        }
        AppMethodBeat.o(50305);
        return locald;
      }
      finally {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
  public static final class b
    implements h.a
  {
    public final void a(bhn parambhn)
    {
      AppMethodBeat.i(50306);
      p.h(parambhn, "response");
      d.a(this.jQU, parambhn);
      AppMethodBeat.o(50306);
    }
    
    public final void bcQ()
    {
      AppMethodBeat.i(50307);
      d.a(this.jQU, 1, null, 6);
      AppMethodBeat.o(50307);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
  static final class d
    implements c.a
  {
    d(d paramd) {}
    
    public final void F(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(50310);
      Iterator localIterator = d.g(this.jQU).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        d locald = this.jQU;
        p.g(localInteger, "item");
        d.a(locald, localInteger.intValue(), paramFloat1, paramFloat2);
      }
      d.g(this.jQU).clear();
      AppMethodBeat.o(50310);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.q
    implements a<z>
  {
    public e(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d
 * JD-Core Version:    0.7.0.1
 */