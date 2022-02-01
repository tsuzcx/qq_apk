package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  private long ofk;
  private long ofl;
  private long ofm;
  private boolean ofn;
  private HashMap<String, akf> ofo;
  private LinkedList<aap> ofp;
  private HashMap<String, aap> ofq;
  
  public h()
  {
    AppMethodBeat.i(49300);
    this.ofk = 0L;
    this.ofl = 0L;
    this.ofm = 0L;
    this.ofn = false;
    this.ofo = new HashMap();
    this.ofp = new LinkedList();
    this.ofq = new HashMap();
    AppMethodBeat.o(49300);
  }
  
  private static void a(LinkedList<aap> paramLinkedList, LinkedList<akf> paramLinkedList1)
  {
    AppMethodBeat.i(49307);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (aap)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((aap)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((aap)localObject).nHd).append(",");
        localStringBuilder.append("item_count:").append(((aap)localObject).LlU).append(",");
        localStringBuilder.append("footnote_count:").append(((aap)localObject).LlV).append(",");
        localStringBuilder.append("strategy_info:").append(((aap)localObject).nHe).append(",");
        localStringBuilder.append("appid:").append(((aap)localObject).dNI).append(",");
        localStringBuilder.append("page_path:").append(((aap)localObject).nHf).append(",");
        localStringBuilder.append("page_param:").append(((aap)localObject).nHg).append(",");
        localStringBuilder.append("card_type:").append(((aap)localObject).nHh).append(",");
        localStringBuilder.append("pass_str:").append(((aap)localObject).nHi).append(",");
        localStringBuilder.append("},");
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (akf)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.nHd).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.nHe).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.Ltp).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.dNI).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.nHf).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.nHg).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.nHh).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.nHi).append(",");
        ((StringBuilder)localObject).append("},");
        Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(49307);
  }
  
  private void bYY()
  {
    AppMethodBeat.i(49302);
    this.ofl = Util.nowSecond();
    this.ofk = this.ofl;
    this.ofn = false;
    this.ofo.clear();
    this.ofp.clear();
    this.ofq.clear();
    this.ofm = 0L;
    AppMethodBeat.o(49302);
  }
  
  private LinkedList<akf> bZb()
  {
    AppMethodBeat.i(49305);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.ofo.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.ofo.get(str));
    }
    Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.ofo.size()) });
    AppMethodBeat.o(49305);
    return localLinkedList;
  }
  
  private static aap c(int paramInt, dko paramdko)
  {
    AppMethodBeat.i(49310);
    aap localaap = new aap();
    localaap.username = paramdko.gTT;
    localaap.nHd = paramdko.nHd;
    localaap.nHe = paramdko.nHe;
    localaap.nHf = paramdko.nHf;
    localaap.nHg = paramdko.nHg;
    localaap.nHh = paramdko.nHh;
    localaap.nHi = paramdko.nHi;
    localaap.position = (paramInt + 1);
    paramdko = n.buC().d(paramdko.gTT, new String[0]);
    if (paramdko != null) {
      localaap.dNI = paramdko.field_appId;
    }
    AppMethodBeat.o(49310);
    return localaap;
  }
  
  public final void Br(long paramLong)
  {
    long l1 = 86400L;
    AppMethodBeat.i(49306);
    if (this.ofp.size() == 0)
    {
      if (this.ofo.size() > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        AppMethodBeat.o(49306);
        return;
      }
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
    long l2 = Util.nowSecond() - this.ofl;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (l2 >= 86400L)
    {
      localLinkedList1 = new LinkedList();
      localLinkedList1.addAll(this.ofp);
      localLinkedList2 = bZb();
      if (!this.ofn) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.ofp.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(this.ofk) });
      a(this.ofp, localLinkedList2);
      int j = (int)l1;
      int k = (int)this.ofk;
      Log.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
      f.bZn().postToWorker(new f.1(paramLong, localLinkedList2, localLinkedList1, i, j, k));
      bYY();
      AppMethodBeat.o(49306);
      return;
      l1 = this.ofm + l2;
      break;
    }
  }
  
  public final void W(String paramString, long paramLong)
  {
    AppMethodBeat.i(49312);
    if (this.ofo.containsKey(paramString))
    {
      akf localakf = (akf)this.ofo.get(paramString);
      localakf.Ltp = ((int)(localakf.Ltp + paramLong));
      this.ofo.put(paramString, localakf);
    }
    AppMethodBeat.o(49312);
  }
  
  public final void a(int paramInt, dko paramdko)
  {
    AppMethodBeat.i(49308);
    if (paramdko == null)
    {
      AppMethodBeat.o(49308);
      return;
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", new Object[] { Integer.valueOf(paramInt), paramdko.gTT, paramdko.MOA, Integer.valueOf(paramdko.nHh), paramdko.nHd });
    if (this.ofq.containsKey(paramdko.nHd))
    {
      paramdko = (aap)this.ofq.get(paramdko.nHd);
      paramdko.LlU += 1;
      AppMethodBeat.o(49308);
      return;
    }
    aap localaap = c(paramInt, paramdko);
    localaap.LlU = 1;
    localaap.LlV = 0;
    this.ofq.put(paramdko.nHd, localaap);
    this.ofp.add(localaap);
    AppMethodBeat.o(49308);
  }
  
  public final void b(int paramInt, dko paramdko)
  {
    AppMethodBeat.i(49309);
    if (paramdko == null)
    {
      AppMethodBeat.o(49309);
      return;
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", new Object[] { Integer.valueOf(paramInt), paramdko.gTT, paramdko.MOA, Integer.valueOf(paramdko.nHh), paramdko.nHd });
    if (this.ofq.containsKey(paramdko.nHd))
    {
      paramdko = (aap)this.ofq.get(paramdko.nHd);
      paramdko.LlV += 1;
      AppMethodBeat.o(49309);
      return;
    }
    aap localaap = c(paramInt, paramdko);
    localaap.LlU = 0;
    localaap.LlV = 1;
    this.ofq.put(paramdko.nHd, localaap);
    this.ofp.add(localaap);
    AppMethodBeat.o(49309);
  }
  
  public final void bYX()
  {
    AppMethodBeat.i(49301);
    bYY();
    AppMethodBeat.o(49301);
  }
  
  public final void bYZ()
  {
    AppMethodBeat.i(49303);
    this.ofl = Util.nowSecond();
    AppMethodBeat.o(49303);
  }
  
  public final void bZa()
  {
    AppMethodBeat.i(49304);
    this.ofm = (Util.nowSecond() - this.ofl + this.ofm);
    this.ofl = Util.nowSecond();
    AppMethodBeat.o(49304);
  }
  
  public final void d(int paramInt, dko paramdko)
  {
    AppMethodBeat.i(49311);
    if (this.ofo.containsKey(paramdko.nHd))
    {
      localakf = (akf)this.ofo.get(paramdko.nHd);
      localakf.count += 1;
      this.ofo.put(paramdko.nHd, localakf);
      AppMethodBeat.o(49311);
      return;
    }
    akf localakf = new akf();
    localakf.username = paramdko.gTT;
    localakf.count = 1;
    localakf.nHd = paramdko.nHd;
    localakf.nHe = paramdko.nHe;
    localakf.Ltp = 0;
    localakf.nHf = paramdko.nHf;
    localakf.nHg = paramdko.nHg;
    localakf.nHh = paramdko.nHh;
    localakf.nHi = paramdko.nHi;
    localakf.position = (paramInt + 1);
    WxaAttributes localWxaAttributes = n.buC().d(paramdko.gTT, new String[0]);
    if (localWxaAttributes != null) {
      localakf.dNI = localWxaAttributes.field_appId;
    }
    this.ofo.put(paramdko.nHd, localakf);
    AppMethodBeat.o(49311);
  }
  
  public final void iU(boolean paramBoolean)
  {
    this.ofn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */