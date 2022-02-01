package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  private long mSg;
  private long mSh;
  private long mSi;
  private boolean mSj;
  private HashMap<String, aht> mSk;
  private LinkedList<za> mSl;
  private HashMap<String, za> mSm;
  
  public h()
  {
    AppMethodBeat.i(49300);
    this.mSg = 0L;
    this.mSh = 0L;
    this.mSi = 0L;
    this.mSj = false;
    this.mSk = new HashMap();
    this.mSl = new LinkedList();
    this.mSm = new HashMap();
    AppMethodBeat.o(49300);
  }
  
  private static void a(LinkedList<za> paramLinkedList, LinkedList<aht> paramLinkedList1)
  {
    AppMethodBeat.i(49307);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (za)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((za)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((za)localObject).mwf).append(",");
        localStringBuilder.append("item_count:").append(((za)localObject).GqY).append(",");
        localStringBuilder.append("footnote_count:").append(((za)localObject).GqZ).append(",");
        localStringBuilder.append("strategy_info:").append(((za)localObject).mwg).append(",");
        localStringBuilder.append("appid:").append(((za)localObject).dwb).append(",");
        localStringBuilder.append("page_path:").append(((za)localObject).mwh).append(",");
        localStringBuilder.append("page_param:").append(((za)localObject).mwi).append(",");
        localStringBuilder.append("card_type:").append(((za)localObject).mwj).append(",");
        localStringBuilder.append("pass_str:").append(((za)localObject).mwk).append(",");
        localStringBuilder.append("},");
        ae.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (aht)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.mwf).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.mwg).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.GxG).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.dwb).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.mwh).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.mwi).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.mwj).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.mwk).append(",");
        ((StringBuilder)localObject).append("},");
        ae.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(49307);
  }
  
  private void bBV()
  {
    AppMethodBeat.i(49302);
    this.mSh = bu.aRi();
    this.mSg = this.mSh;
    this.mSj = false;
    this.mSk.clear();
    this.mSl.clear();
    this.mSm.clear();
    this.mSi = 0L;
    AppMethodBeat.o(49302);
  }
  
  private LinkedList<aht> bBY()
  {
    AppMethodBeat.i(49305);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mSk.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.mSk.get(str));
    }
    ae.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.mSk.size()) });
    AppMethodBeat.o(49305);
    return localLinkedList;
  }
  
  private static za c(int paramInt, csl paramcsl)
  {
    AppMethodBeat.i(49310);
    za localza = new za();
    localza.username = paramcsl.Hgn;
    localza.mwf = paramcsl.mwf;
    localza.mwg = paramcsl.mwg;
    localza.mwh = paramcsl.mwh;
    localza.mwi = paramcsl.mwi;
    localza.mwj = paramcsl.mwj;
    localza.mwk = paramcsl.mwk;
    localza.position = (paramInt + 1);
    paramcsl = j.aZl().d(paramcsl.Hgn, new String[0]);
    if (paramcsl != null) {
      localza.dwb = paramcsl.field_appId;
    }
    AppMethodBeat.o(49310);
    return localza;
  }
  
  public final void W(String paramString, long paramLong)
  {
    AppMethodBeat.i(49312);
    if (this.mSk.containsKey(paramString))
    {
      aht localaht = (aht)this.mSk.get(paramString);
      localaht.GxG = ((int)(localaht.GxG + paramLong));
      this.mSk.put(paramString, localaht);
    }
    AppMethodBeat.o(49312);
  }
  
  public final void a(int paramInt, csl paramcsl)
  {
    AppMethodBeat.i(49308);
    if (paramcsl == null)
    {
      AppMethodBeat.o(49308);
      return;
    }
    ae.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", new Object[] { Integer.valueOf(paramInt), paramcsl.Hgn, paramcsl.HDG, Integer.valueOf(paramcsl.mwj), paramcsl.mwf });
    if (this.mSm.containsKey(paramcsl.mwf))
    {
      paramcsl = (za)this.mSm.get(paramcsl.mwf);
      paramcsl.GqY += 1;
      AppMethodBeat.o(49308);
      return;
    }
    za localza = c(paramInt, paramcsl);
    localza.GqY = 1;
    localza.GqZ = 0;
    this.mSm.put(paramcsl.mwf, localza);
    this.mSl.add(localza);
    AppMethodBeat.o(49308);
  }
  
  public final void b(int paramInt, csl paramcsl)
  {
    AppMethodBeat.i(49309);
    if (paramcsl == null)
    {
      AppMethodBeat.o(49309);
      return;
    }
    ae.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", new Object[] { Integer.valueOf(paramInt), paramcsl.Hgn, paramcsl.HDG, Integer.valueOf(paramcsl.mwj), paramcsl.mwf });
    if (this.mSm.containsKey(paramcsl.mwf))
    {
      paramcsl = (za)this.mSm.get(paramcsl.mwf);
      paramcsl.GqZ += 1;
      AppMethodBeat.o(49309);
      return;
    }
    za localza = c(paramInt, paramcsl);
    localza.GqY = 0;
    localza.GqZ = 1;
    this.mSm.put(paramcsl.mwf, localza);
    this.mSl.add(localza);
    AppMethodBeat.o(49309);
  }
  
  public final void bBU()
  {
    AppMethodBeat.i(49301);
    bBV();
    AppMethodBeat.o(49301);
  }
  
  public final void bBW()
  {
    AppMethodBeat.i(49303);
    this.mSh = bu.aRi();
    AppMethodBeat.o(49303);
  }
  
  public final void bBX()
  {
    AppMethodBeat.i(49304);
    this.mSi = (bu.aRi() - this.mSh + this.mSi);
    this.mSh = bu.aRi();
    AppMethodBeat.o(49304);
  }
  
  public final void d(int paramInt, csl paramcsl)
  {
    AppMethodBeat.i(49311);
    if (this.mSk.containsKey(paramcsl.mwf))
    {
      localaht = (aht)this.mSk.get(paramcsl.mwf);
      localaht.count += 1;
      this.mSk.put(paramcsl.mwf, localaht);
      AppMethodBeat.o(49311);
      return;
    }
    aht localaht = new aht();
    localaht.username = paramcsl.Hgn;
    localaht.count = 1;
    localaht.mwf = paramcsl.mwf;
    localaht.mwg = paramcsl.mwg;
    localaht.GxG = 0;
    localaht.mwh = paramcsl.mwh;
    localaht.mwi = paramcsl.mwi;
    localaht.mwj = paramcsl.mwj;
    localaht.mwk = paramcsl.mwk;
    localaht.position = (paramInt + 1);
    WxaAttributes localWxaAttributes = j.aZl().d(paramcsl.Hgn, new String[0]);
    if (localWxaAttributes != null) {
      localaht.dwb = localWxaAttributes.field_appId;
    }
    this.mSk.put(paramcsl.mwf, localaht);
    AppMethodBeat.o(49311);
  }
  
  public final void hP(boolean paramBoolean)
  {
    this.mSj = paramBoolean;
  }
  
  public final void tl(long paramLong)
  {
    long l1 = 86400L;
    AppMethodBeat.i(49306);
    if (this.mSl.size() == 0)
    {
      if (this.mSk.size() > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        ae.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        AppMethodBeat.o(49306);
        return;
      }
    }
    ae.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
    long l2 = bu.aRi() - this.mSh;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (l2 >= 86400L)
    {
      localLinkedList1 = new LinkedList();
      localLinkedList1.addAll(this.mSl);
      localLinkedList2 = bBY();
      if (!this.mSj) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 0)
    {
      ae.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.mSl.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(this.mSg) });
      a(this.mSl, localLinkedList2);
      int j = (int)l1;
      int k = (int)this.mSg;
      ae.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
      f.bCj().postToWorker(new f.1(paramLong, localLinkedList2, localLinkedList1, i, j, k));
      bBV();
      AppMethodBeat.o(49306);
      return;
      l1 = this.mSi + l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */