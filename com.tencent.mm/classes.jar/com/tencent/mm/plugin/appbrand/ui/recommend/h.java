package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  private long iWs;
  private long iWt;
  private long iWu;
  private boolean iWv;
  private HashMap<String, aam> iWw;
  private LinkedList<tr> iWx;
  private HashMap<String, tr> iWy;
  
  public h()
  {
    AppMethodBeat.i(133566);
    this.iWs = 0L;
    this.iWt = 0L;
    this.iWu = 0L;
    this.iWv = false;
    this.iWw = new HashMap();
    this.iWx = new LinkedList();
    this.iWy = new HashMap();
    AppMethodBeat.o(133566);
  }
  
  private static void a(LinkedList<tr> paramLinkedList, LinkedList<aam> paramLinkedList1)
  {
    AppMethodBeat.i(133571);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (tr)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((tr)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((tr)localObject).iFH).append(",");
        localStringBuilder.append("item_count:").append(((tr)localObject).wMm).append(",");
        localStringBuilder.append("footnote_count:").append(((tr)localObject).wMn).append(",");
        localStringBuilder.append("strategy_info:").append(((tr)localObject).iFI).append(",");
        localStringBuilder.append("appid:").append(((tr)localObject).cwc).append(",");
        localStringBuilder.append("page_path:").append(((tr)localObject).iFJ).append(",");
        localStringBuilder.append("page_param:").append(((tr)localObject).iFK).append(",");
        localStringBuilder.append("card_type:").append(((tr)localObject).iFL).append(",");
        localStringBuilder.append("pass_str:").append(((tr)localObject).iFM).append(",");
        localStringBuilder.append("},");
        ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (aam)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.iFH).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.iFI).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.wRc).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.cwc).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.iFJ).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.iFK).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.iFL).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.iFM).append(",");
        ((StringBuilder)localObject).append("},");
        ab.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(133571);
  }
  
  private void aNG()
  {
    AppMethodBeat.i(133568);
    this.iWt = bo.aox();
    this.iWs = this.iWt;
    this.iWv = false;
    this.iWw.clear();
    this.iWx.clear();
    this.iWy.clear();
    this.iWu = 0L;
    AppMethodBeat.o(133568);
  }
  
  private LinkedList<aam> aNJ()
  {
    AppMethodBeat.i(133569);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.iWw.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.iWw.get(str));
    }
    ab.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.iWw.size()) });
    AppMethodBeat.o(133569);
    return localLinkedList;
  }
  
  private static tr c(int paramInt, bsi parambsi)
  {
    AppMethodBeat.i(133574);
    tr localtr = new tr();
    localtr.username = parambsi.xFL;
    localtr.iFH = parambsi.iFH;
    localtr.iFI = parambsi.iFI;
    localtr.iFJ = parambsi.iFJ;
    localtr.iFK = parambsi.iFK;
    localtr.iFL = parambsi.iFL;
    localtr.iFM = parambsi.iFM;
    localtr.position = (paramInt + 1);
    parambsi = g.auF().d(parambsi.xFL, new String[0]);
    if (parambsi != null) {
      localtr.cwc = parambsi.field_appId;
    }
    AppMethodBeat.o(133574);
    return localtr;
  }
  
  public final void F(String paramString, long paramLong)
  {
    AppMethodBeat.i(133576);
    if (this.iWw.containsKey(paramString))
    {
      aam localaam = (aam)this.iWw.get(paramString);
      localaam.wRc = ((int)(localaam.wRc + paramLong));
      this.iWw.put(paramString, localaam);
    }
    AppMethodBeat.o(133576);
  }
  
  public final void a(int paramInt, bsi parambsi)
  {
    AppMethodBeat.i(133572);
    if (parambsi == null)
    {
      AppMethodBeat.o(133572);
      return;
    }
    ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", new Object[] { Integer.valueOf(paramInt), parambsi.xFL, parambsi.xFR, Integer.valueOf(parambsi.iFL), parambsi.iFH });
    if (this.iWy.containsKey(parambsi.iFH))
    {
      parambsi = (tr)this.iWy.get(parambsi.iFH);
      parambsi.wMm += 1;
      AppMethodBeat.o(133572);
      return;
    }
    tr localtr = c(paramInt, parambsi);
    localtr.wMm = 1;
    localtr.wMn = 0;
    this.iWy.put(parambsi.iFH, localtr);
    this.iWx.add(localtr);
    AppMethodBeat.o(133572);
  }
  
  public final void aNF()
  {
    AppMethodBeat.i(133567);
    aNG();
    AppMethodBeat.o(133567);
  }
  
  public final void aNH()
  {
    AppMethodBeat.i(138700);
    this.iWt = bo.aox();
    AppMethodBeat.o(138700);
  }
  
  public final void aNI()
  {
    AppMethodBeat.i(138701);
    this.iWu = (bo.aox() - this.iWt + this.iWu);
    this.iWt = bo.aox();
    AppMethodBeat.o(138701);
  }
  
  public final void b(int paramInt, bsi parambsi)
  {
    AppMethodBeat.i(133573);
    if (parambsi == null)
    {
      AppMethodBeat.o(133573);
      return;
    }
    ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", new Object[] { Integer.valueOf(paramInt), parambsi.xFL, parambsi.xFR, Integer.valueOf(parambsi.iFL), parambsi.iFH });
    if (this.iWy.containsKey(parambsi.iFH))
    {
      parambsi = (tr)this.iWy.get(parambsi.iFH);
      parambsi.wMn += 1;
      AppMethodBeat.o(133573);
      return;
    }
    tr localtr = c(paramInt, parambsi);
    localtr.wMm = 0;
    localtr.wMn = 1;
    this.iWy.put(parambsi.iFH, localtr);
    this.iWx.add(localtr);
    AppMethodBeat.o(133573);
  }
  
  public final void d(int paramInt, bsi parambsi)
  {
    AppMethodBeat.i(133575);
    if (this.iWw.containsKey(parambsi.iFH))
    {
      localaam = (aam)this.iWw.get(parambsi.iFH);
      localaam.count += 1;
      this.iWw.put(parambsi.iFH, localaam);
      AppMethodBeat.o(133575);
      return;
    }
    aam localaam = new aam();
    localaam.username = parambsi.xFL;
    localaam.count = 1;
    localaam.iFH = parambsi.iFH;
    localaam.iFI = parambsi.iFI;
    localaam.wRc = 0;
    localaam.iFJ = parambsi.iFJ;
    localaam.iFK = parambsi.iFK;
    localaam.iFL = parambsi.iFL;
    localaam.iFM = parambsi.iFM;
    localaam.position = (paramInt + 1);
    WxaAttributes localWxaAttributes = g.auF().d(parambsi.xFL, new String[0]);
    if (localWxaAttributes != null) {
      localaam.cwc = localWxaAttributes.field_appId;
    }
    this.iWw.put(parambsi.iFH, localaam);
    AppMethodBeat.o(133575);
  }
  
  public final void eV(boolean paramBoolean)
  {
    this.iWv = paramBoolean;
  }
  
  public final void hG(long paramLong)
  {
    long l1 = 86400L;
    AppMethodBeat.i(133570);
    if (this.iWx.size() == 0)
    {
      if (this.iWw.size() > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        ab.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        AppMethodBeat.o(133570);
        return;
      }
    }
    ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
    long l2 = bo.aox() - this.iWt;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (l2 >= 86400L)
    {
      localLinkedList1 = new LinkedList();
      localLinkedList1.addAll(this.iWx);
      localLinkedList2 = aNJ();
      if (!this.iWv) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.iWx.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(this.iWs) });
      a(this.iWx, localLinkedList2);
      int j = (int)l1;
      int k = (int)this.iWs;
      ab.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
      e.aNS().ac(new f.1(paramLong, localLinkedList2, localLinkedList1, i, j, k));
      aNG();
      AppMethodBeat.o(133570);
      return;
      l1 = this.iWu + l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */