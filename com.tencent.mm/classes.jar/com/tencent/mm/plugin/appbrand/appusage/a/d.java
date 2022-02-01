package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.e;
import d.f;
import d.g.a.a;
import d.g.a.q;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  private static d jwW;
  public static final a jwX;
  public int dzl;
  private final k jwK;
  public final c jwL;
  private final f jwM;
  long jwN;
  public int jwO;
  public int jwP;
  public boolean jwQ;
  public int jwR;
  private final f jwS;
  private boolean jwT;
  private h.a jwU;
  public q<? super Integer, ? super LinkedList<cmp>, ? super Integer, y> jwV;
  long lastUpdateTime;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(50317);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(d.class), "rList", "getRList()Ljava/util/LinkedList;")), (d.l.k)w.a(new u(w.bn(d.class), "dataList", "getDataList()Ljava/util/LinkedList;")) };
    jwX = new a((byte)0);
    AppMethodBeat.o(50317);
  }
  
  private d()
  {
    AppMethodBeat.i(50323);
    this.jwK = new k();
    this.jwL = new c();
    this.jwM = d.g.K((a)d.h.jxc);
    this.jwR = 1;
    this.jwS = d.g.K((a)d.c.jwZ);
    this.jwU = ((h.a)new b(this));
    this.jwV = ((q)d.g.jxb);
    AppMethodBeat.o(50323);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(50322);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(50322);
      return;
    }
    Object localObject1 = new xc();
    ((xc)localObject1).Erw = ax.getNetTypeString(ai.getContext());
    ((xc)localObject1).longitude = paramFloat1;
    ((xc)localObject1).latitude = paramFloat2;
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) && (paramInt != 0) && (this.jwT))
    {
      localObject1 = this.jwK;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new cmp();
      ((k)localObject1).a((cmp)localObject2);
      ((cmp)localObject2).oGU = "####客户端mock数据####大视频";
      ((cmp)localObject2).lRv = 6;
      ((cmp)localObject2).FzQ = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((cmp)localObject2).FzS = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      cmp[] arrayOfcmp = new cmp[4];
      int i = 0;
      if (i < 4)
      {
        cmp localcmp = new cmp();
        ((k)localObject1).a(localcmp);
        localcmp.FzU = new bic();
        localcmp.FzU.EXr = 1500;
        localcmp.FzU.EXq = 1750;
        localcmp.lRv = 5;
        switch (i)
        {
        default: 
          localcmp.oGU = "####客户端mock数据####商品ft";
          localcmp.FzU.EXt = false;
          localcmp.FzU.EXs = true;
        }
        for (;;)
        {
          String str = localcmp.oGU;
          localcmp.oGU = (str + paramInt);
          arrayOfcmp[i] = localcmp;
          i += 1;
          break;
          localcmp.oGU = "####客户端mock数据####商品tt";
          localcmp.FzU.EXt = true;
          localcmp.FzU.EXs = true;
          continue;
          localcmp.oGU = "####客户端mock数据####商品tf";
          localcmp.FzU.EXt = true;
          localcmp.FzU.EXs = false;
          continue;
          localcmp.oGU = "####客户端mock数据####商品ff";
          localcmp.FzU.EXt = false;
          localcmp.FzU.EXs = false;
        }
      }
      d.g.b.k.h(localObject2, "$this$addAll");
      d.g.b.k.h(arrayOfcmp, "elements");
      ((Collection)localObject2).addAll((Collection)e.asList(arrayOfcmp));
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(50322);
        return;
      }
    }
    h.a(paramInt, (xc)localObject1, this.sessionId, this.jwU, this.jwR);
    AppMethodBeat.o(50322);
  }
  
  private final void a(int paramInt1, LinkedList<cmp> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(50320);
    q localq = this.jwV;
    if (localq != null)
    {
      localq.d(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
      AppMethodBeat.o(50320);
      return;
    }
    AppMethodBeat.o(50320);
  }
  
  private final LinkedList<Integer> aZo()
  {
    AppMethodBeat.i(50318);
    LinkedList localLinkedList = (LinkedList)this.jwM.getValue();
    AppMethodBeat.o(50318);
    return localLinkedList;
  }
  
  public final LinkedList<cmp> aZp()
  {
    AppMethodBeat.i(50319);
    LinkedList localLinkedList = (LinkedList)this.jwS.getValue();
    AppMethodBeat.o(50319);
    return localLinkedList;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public final d aZr()
    {
      try
      {
        AppMethodBeat.i(50305);
        if (d.aZq() == null) {
          d.h(new d((byte)0));
        }
        d locald = d.aZq();
        if (locald == null) {
          d.g.b.k.fOy();
        }
        AppMethodBeat.o(50305);
        return locald;
      }
      finally {}
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
  public static final class b
    implements h.a
  {
    public final void a(bdh parambdh)
    {
      AppMethodBeat.i(50306);
      d.g.b.k.h(parambdh, "response");
      d.a(this.jwY, parambdh);
      AppMethodBeat.o(50306);
    }
    
    public final void aZs()
    {
      AppMethodBeat.i(50307);
      d.a(this.jwY, 1, null, 6);
      AppMethodBeat.o(50307);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
  static final class d
    implements c.a
  {
    d(d paramd) {}
    
    public final void E(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(50310);
      Iterator localIterator = d.g(this.jwY).iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        d locald = this.jwY;
        d.g.b.k.g(localInteger, "item");
        d.a(locald, localInteger.intValue(), paramFloat1, paramFloat2);
      }
      d.g(this.jwY).clear();
      AppMethodBeat.o(50310);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class e
    extends d.g.b.l
    implements a<y>
  {
    public e(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d
 * JD-Core Version:    0.7.0.1
 */