package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  private long lKE;
  private long lKF;
  private long lKG;
  private boolean lKH;
  private HashMap<String, aeb> lKI;
  private LinkedList<wn> lKJ;
  private HashMap<String, wn> lKK;
  
  public h()
  {
    AppMethodBeat.i(49300);
    this.lKE = 0L;
    this.lKF = 0L;
    this.lKG = 0L;
    this.lKH = false;
    this.lKI = new HashMap();
    this.lKJ = new LinkedList();
    this.lKK = new HashMap();
    AppMethodBeat.o(49300);
  }
  
  private static void a(LinkedList<wn> paramLinkedList, LinkedList<aeb> paramLinkedList1)
  {
    AppMethodBeat.i(49307);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (wn)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((wn)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((wn)localObject).lpv).append(",");
        localStringBuilder.append("item_count:").append(((wn)localObject).CYF).append(",");
        localStringBuilder.append("footnote_count:").append(((wn)localObject).CYG).append(",");
        localStringBuilder.append("strategy_info:").append(((wn)localObject).lpw).append(",");
        localStringBuilder.append("appid:").append(((wn)localObject).dlB).append(",");
        localStringBuilder.append("page_path:").append(((wn)localObject).lpx).append(",");
        localStringBuilder.append("page_param:").append(((wn)localObject).lpy).append(",");
        localStringBuilder.append("card_type:").append(((wn)localObject).lpz).append(",");
        localStringBuilder.append("pass_str:").append(((wn)localObject).lpA).append(",");
        localStringBuilder.append("},");
        ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (aeb)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.lpv).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.lpw).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.Dep).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.dlB).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.lpx).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.lpy).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.lpz).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.lpA).append(",");
        ((StringBuilder)localObject).append("},");
        ad.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(49307);
  }
  
  private void bpY()
  {
    AppMethodBeat.i(49302);
    this.lKF = bt.aGK();
    this.lKE = this.lKF;
    this.lKH = false;
    this.lKI.clear();
    this.lKJ.clear();
    this.lKK.clear();
    this.lKG = 0L;
    AppMethodBeat.o(49302);
  }
  
  private LinkedList<aeb> bqb()
  {
    AppMethodBeat.i(49305);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.lKI.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.lKI.get(str));
    }
    ad.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.lKI.size()) });
    AppMethodBeat.o(49305);
    return localLinkedList;
  }
  
  private static wn c(int paramInt, chm paramchm)
  {
    AppMethodBeat.i(49310);
    wn localwn = new wn();
    localwn.username = paramchm.DHP;
    localwn.lpv = paramchm.lpv;
    localwn.lpw = paramchm.lpw;
    localwn.lpx = paramchm.lpx;
    localwn.lpy = paramchm.lpy;
    localwn.lpz = paramchm.lpz;
    localwn.lpA = paramchm.lpA;
    localwn.position = (paramInt + 1);
    paramchm = j.aOC().d(paramchm.DHP, new String[0]);
    if (paramchm != null) {
      localwn.dlB = paramchm.field_appId;
    }
    AppMethodBeat.o(49310);
    return localwn;
  }
  
  public final void O(String paramString, long paramLong)
  {
    AppMethodBeat.i(49312);
    if (this.lKI.containsKey(paramString))
    {
      aeb localaeb = (aeb)this.lKI.get(paramString);
      localaeb.Dep = ((int)(localaeb.Dep + paramLong));
      this.lKI.put(paramString, localaeb);
    }
    AppMethodBeat.o(49312);
  }
  
  public final void a(int paramInt, chm paramchm)
  {
    AppMethodBeat.i(49308);
    if (paramchm == null)
    {
      AppMethodBeat.o(49308);
      return;
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", new Object[] { Integer.valueOf(paramInt), paramchm.DHP, paramchm.Eda, Integer.valueOf(paramchm.lpz), paramchm.lpv });
    if (this.lKK.containsKey(paramchm.lpv))
    {
      paramchm = (wn)this.lKK.get(paramchm.lpv);
      paramchm.CYF += 1;
      AppMethodBeat.o(49308);
      return;
    }
    wn localwn = c(paramInt, paramchm);
    localwn.CYF = 1;
    localwn.CYG = 0;
    this.lKK.put(paramchm.lpv, localwn);
    this.lKJ.add(localwn);
    AppMethodBeat.o(49308);
  }
  
  public final void b(int paramInt, chm paramchm)
  {
    AppMethodBeat.i(49309);
    if (paramchm == null)
    {
      AppMethodBeat.o(49309);
      return;
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", new Object[] { Integer.valueOf(paramInt), paramchm.DHP, paramchm.Eda, Integer.valueOf(paramchm.lpz), paramchm.lpv });
    if (this.lKK.containsKey(paramchm.lpv))
    {
      paramchm = (wn)this.lKK.get(paramchm.lpv);
      paramchm.CYG += 1;
      AppMethodBeat.o(49309);
      return;
    }
    wn localwn = c(paramInt, paramchm);
    localwn.CYF = 0;
    localwn.CYG = 1;
    this.lKK.put(paramchm.lpv, localwn);
    this.lKJ.add(localwn);
    AppMethodBeat.o(49309);
  }
  
  public final void bpX()
  {
    AppMethodBeat.i(49301);
    bpY();
    AppMethodBeat.o(49301);
  }
  
  public final void bpZ()
  {
    AppMethodBeat.i(49303);
    this.lKF = bt.aGK();
    AppMethodBeat.o(49303);
  }
  
  public final void bqa()
  {
    AppMethodBeat.i(49304);
    this.lKG = (bt.aGK() - this.lKF + this.lKG);
    this.lKF = bt.aGK();
    AppMethodBeat.o(49304);
  }
  
  public final void d(int paramInt, chm paramchm)
  {
    AppMethodBeat.i(49311);
    if (this.lKI.containsKey(paramchm.lpv))
    {
      localaeb = (aeb)this.lKI.get(paramchm.lpv);
      localaeb.count += 1;
      this.lKI.put(paramchm.lpv, localaeb);
      AppMethodBeat.o(49311);
      return;
    }
    aeb localaeb = new aeb();
    localaeb.username = paramchm.DHP;
    localaeb.count = 1;
    localaeb.lpv = paramchm.lpv;
    localaeb.lpw = paramchm.lpw;
    localaeb.Dep = 0;
    localaeb.lpx = paramchm.lpx;
    localaeb.lpy = paramchm.lpy;
    localaeb.lpz = paramchm.lpz;
    localaeb.lpA = paramchm.lpA;
    localaeb.position = (paramInt + 1);
    WxaAttributes localWxaAttributes = j.aOC().d(paramchm.DHP, new String[0]);
    if (localWxaAttributes != null) {
      localaeb.dlB = localWxaAttributes.field_appId;
    }
    this.lKI.put(paramchm.lpv, localaeb);
    AppMethodBeat.o(49311);
  }
  
  public final void hi(boolean paramBoolean)
  {
    this.lKH = paramBoolean;
  }
  
  public final void nn(long paramLong)
  {
    long l1 = 86400L;
    AppMethodBeat.i(49306);
    if (this.lKJ.size() == 0)
    {
      if (this.lKI.size() > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        ad.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        AppMethodBeat.o(49306);
        return;
      }
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
    long l2 = bt.aGK() - this.lKF;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (l2 >= 86400L)
    {
      localLinkedList1 = new LinkedList();
      localLinkedList1.addAll(this.lKJ);
      localLinkedList2 = bqb();
      if (!this.lKH) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.lKJ.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(this.lKE) });
      a(this.lKJ, localLinkedList2);
      int j = (int)l1;
      int k = (int)this.lKE;
      ad.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
      e.bqm().postToWorker(new f.1(paramLong, localLinkedList2, localLinkedList1, i, j, k));
      bpY();
      AppMethodBeat.o(49306);
      return;
      l1 = this.lKG + l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */