package com.tencent.mm.plugin.appbrand.appusage.a;

import a.a.e;
import a.f.a.a;
import a.f.a.q;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Collection;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d
{
  private static d hdq;
  public static final d.a hdr;
  public int cKB;
  private final k hde;
  public final c hdf;
  private final a.f hdg;
  long hdh;
  public int hdi;
  public int hdj;
  public boolean hdk;
  public int hdl;
  private final a.f hdm;
  private boolean hdn;
  private h.a hdo;
  public q<? super Integer, ? super LinkedList<bsi>, ? super Integer, y> hdp;
  long lastUpdateTime;
  public long sessionId;
  
  static
  {
    AppMethodBeat.i(134580);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(d.class), "rList", "getRList()Ljava/util/LinkedList;")), (a.j.k)v.a(new t(v.aG(d.class), "dataList", "getDataList()Ljava/util/LinkedList;")) };
    hdr = new d.a((byte)0);
    AppMethodBeat.o(134580);
  }
  
  private d()
  {
    AppMethodBeat.i(134586);
    this.hde = new k();
    this.hdf = new c();
    this.hdg = a.g.j((a)d.h.hdw);
    this.hdl = 1;
    this.hdm = a.g.j((a)d.c.hdt);
    this.hdo = ((h.a)new d.b(this));
    this.hdp = ((q)d.g.hdv);
    AppMethodBeat.o(134586);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(134585);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(134585);
      return;
    }
    Object localObject1 = new ts();
    ((ts)localObject1).wMo = at.getNetTypeString(ah.getContext());
    ((ts)localObject1).longitude = paramFloat1;
    ((ts)localObject1).latitude = paramFloat2;
    if ((com.tencent.mm.sdk.platformtools.f.DEBUG) && (paramInt != 0) && (this.hdn))
    {
      localObject1 = this.hde;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new bsi();
      ((k)localObject1).a((bsi)localObject2);
      ((bsi)localObject2).kWF = "####客户端mock数据####大视频";
      ((bsi)localObject2).iFL = 6;
      ((bsi)localObject2).xFM = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
      ((bsi)localObject2).xFO = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
      localLinkedList.addLast(localObject2);
      localObject2 = (Collection)localLinkedList;
      bsi[] arrayOfbsi = new bsi[4];
      int i = 0;
      if (i < 4)
      {
        bsi localbsi = new bsi();
        ((k)localObject1).a(localbsi);
        localbsi.xFQ = new atj();
        localbsi.xFQ.xiD = 1500;
        localbsi.xFQ.xiC = 1750;
        localbsi.iFL = 5;
        switch (i)
        {
        default: 
          localbsi.kWF = "####客户端mock数据####商品ft";
          localbsi.xFQ.xiF = false;
          localbsi.xFQ.xiE = true;
        }
        for (;;)
        {
          String str = localbsi.kWF;
          localbsi.kWF = (str + paramInt);
          arrayOfbsi[i] = localbsi;
          i += 1;
          break;
          localbsi.kWF = "####客户端mock数据####商品tt";
          localbsi.xFQ.xiF = true;
          localbsi.xFQ.xiE = true;
          continue;
          localbsi.kWF = "####客户端mock数据####商品tf";
          localbsi.xFQ.xiF = true;
          localbsi.xFQ.xiE = false;
          continue;
          localbsi.kWF = "####客户端mock数据####商品ff";
          localbsi.xFQ.xiF = false;
          localbsi.xFQ.xiE = false;
        }
      }
      j.q(localObject2, "receiver$0");
      j.q(arrayOfbsi, "elements");
      ((Collection)localObject2).addAll((Collection)e.asList(arrayOfbsi));
      if (paramInt == 2) {}
      for (paramInt = 0;; paramInt = localLinkedList.size())
      {
        Thread.sleep(2000L);
        a(0, localLinkedList, paramInt);
        AppMethodBeat.o(134585);
        return;
      }
    }
    h.a(paramInt, (ts)localObject1, this.sessionId, this.hdo, this.hdl);
    AppMethodBeat.o(134585);
  }
  
  private final void a(int paramInt1, LinkedList<bsi> paramLinkedList, int paramInt2)
  {
    AppMethodBeat.i(134583);
    q localq = this.hdp;
    if (localq != null)
    {
      localq.d(Integer.valueOf(paramInt1), paramLinkedList, Integer.valueOf(paramInt2));
      AppMethodBeat.o(134583);
      return;
    }
    AppMethodBeat.o(134583);
  }
  
  private final LinkedList<Integer> axO()
  {
    AppMethodBeat.i(134581);
    LinkedList localLinkedList = (LinkedList)this.hdg.getValue();
    AppMethodBeat.o(134581);
    return localLinkedList;
  }
  
  public final LinkedList<bsi> axP()
  {
    AppMethodBeat.i(134582);
    LinkedList localLinkedList = (LinkedList)this.hdm.getValue();
    AppMethodBeat.o(134582);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.d
 * JD-Core Version:    0.7.0.1
 */