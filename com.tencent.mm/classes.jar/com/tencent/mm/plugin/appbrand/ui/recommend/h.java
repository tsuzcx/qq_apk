package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  private long mmB;
  private long mmC;
  private long mmD;
  private boolean mmE;
  private HashMap<String, afa> mmF;
  private LinkedList<wy> mmG;
  private HashMap<String, wy> mmH;
  
  public h()
  {
    AppMethodBeat.i(49300);
    this.mmB = 0L;
    this.mmC = 0L;
    this.mmD = 0L;
    this.mmE = false;
    this.mmF = new HashMap();
    this.mmG = new LinkedList();
    this.mmH = new HashMap();
    AppMethodBeat.o(49300);
  }
  
  private static void a(LinkedList<wy> paramLinkedList, LinkedList<afa> paramLinkedList1)
  {
    AppMethodBeat.i(49307);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (wy)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((wy)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((wy)localObject).lRr).append(",");
        localStringBuilder.append("item_count:").append(((wy)localObject).Erp).append(",");
        localStringBuilder.append("footnote_count:").append(((wy)localObject).Erq).append(",");
        localStringBuilder.append("strategy_info:").append(((wy)localObject).lRs).append(",");
        localStringBuilder.append("appid:").append(((wy)localObject).djj).append(",");
        localStringBuilder.append("page_path:").append(((wy)localObject).lRt).append(",");
        localStringBuilder.append("page_param:").append(((wy)localObject).lRu).append(",");
        localStringBuilder.append("card_type:").append(((wy)localObject).lRv).append(",");
        localStringBuilder.append("pass_str:").append(((wy)localObject).lRw).append(",");
        localStringBuilder.append("},");
        ac.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (afa)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.lRr).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.lRs).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.Exv).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.djj).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.lRt).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.lRu).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.lRv).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.lRw).append(",");
        ((StringBuilder)localObject).append("},");
        ac.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(49307);
  }
  
  private void bwV()
  {
    AppMethodBeat.i(49302);
    this.mmC = bs.aNx();
    this.mmB = this.mmC;
    this.mmE = false;
    this.mmF.clear();
    this.mmG.clear();
    this.mmH.clear();
    this.mmD = 0L;
    AppMethodBeat.o(49302);
  }
  
  private LinkedList<afa> bwY()
  {
    AppMethodBeat.i(49305);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mmF.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.mmF.get(str));
    }
    ac.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.mmF.size()) });
    AppMethodBeat.o(49305);
    return localLinkedList;
  }
  
  private static wy c(int paramInt, cmp paramcmp)
  {
    AppMethodBeat.i(49310);
    wy localwy = new wy();
    localwy.username = paramcmp.Fdk;
    localwy.lRr = paramcmp.lRr;
    localwy.lRs = paramcmp.lRs;
    localwy.lRt = paramcmp.lRt;
    localwy.lRu = paramcmp.lRu;
    localwy.lRv = paramcmp.lRv;
    localwy.lRw = paramcmp.lRw;
    localwy.position = (paramInt + 1);
    paramcmp = j.aVu().d(paramcmp.Fdk, new String[0]);
    if (paramcmp != null) {
      localwy.djj = paramcmp.field_appId;
    }
    AppMethodBeat.o(49310);
    return localwy;
  }
  
  public final void P(String paramString, long paramLong)
  {
    AppMethodBeat.i(49312);
    if (this.mmF.containsKey(paramString))
    {
      afa localafa = (afa)this.mmF.get(paramString);
      localafa.Exv = ((int)(localafa.Exv + paramLong));
      this.mmF.put(paramString, localafa);
    }
    AppMethodBeat.o(49312);
  }
  
  public final void a(int paramInt, cmp paramcmp)
  {
    AppMethodBeat.i(49308);
    if (paramcmp == null)
    {
      AppMethodBeat.o(49308);
      return;
    }
    ac.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", new Object[] { Integer.valueOf(paramInt), paramcmp.Fdk, paramcmp.FzV, Integer.valueOf(paramcmp.lRv), paramcmp.lRr });
    if (this.mmH.containsKey(paramcmp.lRr))
    {
      paramcmp = (wy)this.mmH.get(paramcmp.lRr);
      paramcmp.Erp += 1;
      AppMethodBeat.o(49308);
      return;
    }
    wy localwy = c(paramInt, paramcmp);
    localwy.Erp = 1;
    localwy.Erq = 0;
    this.mmH.put(paramcmp.lRr, localwy);
    this.mmG.add(localwy);
    AppMethodBeat.o(49308);
  }
  
  public final void b(int paramInt, cmp paramcmp)
  {
    AppMethodBeat.i(49309);
    if (paramcmp == null)
    {
      AppMethodBeat.o(49309);
      return;
    }
    ac.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", new Object[] { Integer.valueOf(paramInt), paramcmp.Fdk, paramcmp.FzV, Integer.valueOf(paramcmp.lRv), paramcmp.lRr });
    if (this.mmH.containsKey(paramcmp.lRr))
    {
      paramcmp = (wy)this.mmH.get(paramcmp.lRr);
      paramcmp.Erq += 1;
      AppMethodBeat.o(49309);
      return;
    }
    wy localwy = c(paramInt, paramcmp);
    localwy.Erp = 0;
    localwy.Erq = 1;
    this.mmH.put(paramcmp.lRr, localwy);
    this.mmG.add(localwy);
    AppMethodBeat.o(49309);
  }
  
  public final void bwU()
  {
    AppMethodBeat.i(49301);
    bwV();
    AppMethodBeat.o(49301);
  }
  
  public final void bwW()
  {
    AppMethodBeat.i(49303);
    this.mmC = bs.aNx();
    AppMethodBeat.o(49303);
  }
  
  public final void bwX()
  {
    AppMethodBeat.i(49304);
    this.mmD = (bs.aNx() - this.mmC + this.mmD);
    this.mmC = bs.aNx();
    AppMethodBeat.o(49304);
  }
  
  public final void d(int paramInt, cmp paramcmp)
  {
    AppMethodBeat.i(49311);
    if (this.mmF.containsKey(paramcmp.lRr))
    {
      localafa = (afa)this.mmF.get(paramcmp.lRr);
      localafa.count += 1;
      this.mmF.put(paramcmp.lRr, localafa);
      AppMethodBeat.o(49311);
      return;
    }
    afa localafa = new afa();
    localafa.username = paramcmp.Fdk;
    localafa.count = 1;
    localafa.lRr = paramcmp.lRr;
    localafa.lRs = paramcmp.lRs;
    localafa.Exv = 0;
    localafa.lRt = paramcmp.lRt;
    localafa.lRu = paramcmp.lRu;
    localafa.lRv = paramcmp.lRv;
    localafa.lRw = paramcmp.lRw;
    localafa.position = (paramInt + 1);
    WxaAttributes localWxaAttributes = j.aVu().d(paramcmp.Fdk, new String[0]);
    if (localWxaAttributes != null) {
      localafa.djj = localWxaAttributes.field_appId;
    }
    this.mmF.put(paramcmp.lRr, localafa);
    AppMethodBeat.o(49311);
  }
  
  public final void hF(boolean paramBoolean)
  {
    this.mmE = paramBoolean;
  }
  
  public final void qZ(long paramLong)
  {
    long l1 = 86400L;
    AppMethodBeat.i(49306);
    if (this.mmG.size() == 0)
    {
      if (this.mmF.size() > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        ac.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        AppMethodBeat.o(49306);
        return;
      }
    }
    ac.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
    long l2 = bs.aNx() - this.mmC;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (l2 >= 86400L)
    {
      localLinkedList1 = new LinkedList();
      localLinkedList1.addAll(this.mmG);
      localLinkedList2 = bwY();
      if (!this.mmE) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 0)
    {
      ac.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.mmG.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(this.mmB) });
      a(this.mmG, localLinkedList2);
      int j = (int)l1;
      int k = (int)this.mmB;
      ac.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
      e.bxj().postToWorker(new f.1(paramLong, localLinkedList2, localLinkedList1, i, j, k));
      bwV();
      AppMethodBeat.o(49306);
      return;
      l1 = this.mmD + l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */