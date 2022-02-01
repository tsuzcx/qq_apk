package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  private long rgV;
  private long rgW;
  private long rgX;
  private boolean rgY;
  private HashMap<String, ali> rgZ;
  private LinkedList<aau> rha;
  private HashMap<String, aau> rhb;
  
  public h()
  {
    AppMethodBeat.i(49300);
    this.rgV = 0L;
    this.rgW = 0L;
    this.rgX = 0L;
    this.rgY = false;
    this.rgZ = new HashMap();
    this.rha = new LinkedList();
    this.rhb = new HashMap();
    AppMethodBeat.o(49300);
  }
  
  private static void a(LinkedList<aau> paramLinkedList, LinkedList<ali> paramLinkedList1)
  {
    AppMethodBeat.i(49307);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (aau)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((aau)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((aau)localObject).qJp).append(",");
        localStringBuilder.append("item_count:").append(((aau)localObject).Sne).append(",");
        localStringBuilder.append("footnote_count:").append(((aau)localObject).Snf).append(",");
        localStringBuilder.append("strategy_info:").append(((aau)localObject).qJq).append(",");
        localStringBuilder.append("appid:").append(((aau)localObject).appid).append(",");
        localStringBuilder.append("page_path:").append(((aau)localObject).qJr).append(",");
        localStringBuilder.append("page_param:").append(((aau)localObject).qJs).append(",");
        localStringBuilder.append("card_type:").append(((aau)localObject).qJt).append(",");
        localStringBuilder.append("pass_str:").append(((aau)localObject).qJu).append(",");
        localStringBuilder.append("},");
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (ali)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.qJp).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.qJq).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.SvN).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.appid).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.qJr).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.qJs).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.qJt).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.qJu).append(",");
        ((StringBuilder)localObject).append("},");
        Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(49307);
  }
  
  private static aau c(int paramInt, dud paramdud)
  {
    AppMethodBeat.i(49310);
    aau localaau = new aau();
    localaau.username = paramdud.jEx;
    localaau.qJp = paramdud.qJp;
    localaau.qJq = paramdud.qJq;
    localaau.qJr = paramdud.qJr;
    localaau.qJs = paramdud.qJs;
    localaau.qJt = paramdud.qJt;
    localaau.qJu = paramdud.qJu;
    localaau.position = (paramInt + 1);
    paramdud = m.bFF().c(paramdud.jEx, new String[0]);
    if (paramdud != null) {
      localaau.appid = paramdud.field_appId;
    }
    AppMethodBeat.o(49310);
    return localaau;
  }
  
  private void clH()
  {
    AppMethodBeat.i(49302);
    this.rgW = Util.nowSecond();
    this.rgV = this.rgW;
    this.rgY = false;
    this.rgZ.clear();
    this.rha.clear();
    this.rhb.clear();
    this.rgX = 0L;
    AppMethodBeat.o(49302);
  }
  
  private LinkedList<ali> clK()
  {
    AppMethodBeat.i(49305);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.rgZ.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.rgZ.get(str));
    }
    Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.rgZ.size()) });
    AppMethodBeat.o(49305);
    return localLinkedList;
  }
  
  public final void HE(long paramLong)
  {
    long l1 = 86400L;
    AppMethodBeat.i(49306);
    if (this.rha.size() == 0)
    {
      if (this.rgZ.size() > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        AppMethodBeat.o(49306);
        return;
      }
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
    long l2 = Util.nowSecond() - this.rgW;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (l2 >= 86400L)
    {
      localLinkedList1 = new LinkedList();
      localLinkedList1.addAll(this.rha);
      localLinkedList2 = clK();
      if (!this.rgY) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.rha.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(this.rgV) });
      a(this.rha, localLinkedList2);
      int j = (int)l1;
      int k = (int)this.rgV;
      Log.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
      com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(new f.1(paramLong, localLinkedList2, localLinkedList1, i, j, k));
      clH();
      AppMethodBeat.o(49306);
      return;
      l1 = this.rgX + l2;
      break;
    }
  }
  
  public final void W(String paramString, long paramLong)
  {
    AppMethodBeat.i(49312);
    if (this.rgZ.containsKey(paramString))
    {
      ali localali = (ali)this.rgZ.get(paramString);
      localali.SvN = ((int)(localali.SvN + paramLong));
      this.rgZ.put(paramString, localali);
    }
    AppMethodBeat.o(49312);
  }
  
  public final void a(int paramInt, dud paramdud)
  {
    AppMethodBeat.i(49308);
    if (paramdud == null)
    {
      AppMethodBeat.o(49308);
      return;
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", new Object[] { Integer.valueOf(paramInt), paramdud.jEx, paramdud.Uau, Integer.valueOf(paramdud.qJt), paramdud.qJp });
    if (this.rhb.containsKey(paramdud.qJp))
    {
      paramdud = (aau)this.rhb.get(paramdud.qJp);
      paramdud.Sne += 1;
      AppMethodBeat.o(49308);
      return;
    }
    aau localaau = c(paramInt, paramdud);
    localaau.Sne = 1;
    localaau.Snf = 0;
    this.rhb.put(paramdud.qJp, localaau);
    this.rha.add(localaau);
    AppMethodBeat.o(49308);
  }
  
  public final void b(int paramInt, dud paramdud)
  {
    AppMethodBeat.i(49309);
    if (paramdud == null)
    {
      AppMethodBeat.o(49309);
      return;
    }
    Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", new Object[] { Integer.valueOf(paramInt), paramdud.jEx, paramdud.Uau, Integer.valueOf(paramdud.qJt), paramdud.qJp });
    if (this.rhb.containsKey(paramdud.qJp))
    {
      paramdud = (aau)this.rhb.get(paramdud.qJp);
      paramdud.Snf += 1;
      AppMethodBeat.o(49309);
      return;
    }
    aau localaau = c(paramInt, paramdud);
    localaau.Sne = 0;
    localaau.Snf = 1;
    this.rhb.put(paramdud.qJp, localaau);
    this.rha.add(localaau);
    AppMethodBeat.o(49309);
  }
  
  public final void clG()
  {
    AppMethodBeat.i(49301);
    clH();
    AppMethodBeat.o(49301);
  }
  
  public final void clI()
  {
    AppMethodBeat.i(49303);
    this.rgW = Util.nowSecond();
    AppMethodBeat.o(49303);
  }
  
  public final void clJ()
  {
    AppMethodBeat.i(49304);
    this.rgX = (Util.nowSecond() - this.rgW + this.rgX);
    this.rgW = Util.nowSecond();
    AppMethodBeat.o(49304);
  }
  
  public final void d(int paramInt, dud paramdud)
  {
    AppMethodBeat.i(49311);
    if (this.rgZ.containsKey(paramdud.qJp))
    {
      localali = (ali)this.rgZ.get(paramdud.qJp);
      localali.count += 1;
      this.rgZ.put(paramdud.qJp, localali);
      AppMethodBeat.o(49311);
      return;
    }
    ali localali = new ali();
    localali.username = paramdud.jEx;
    localali.count = 1;
    localali.qJp = paramdud.qJp;
    localali.qJq = paramdud.qJq;
    localali.SvN = 0;
    localali.qJr = paramdud.qJr;
    localali.qJs = paramdud.qJs;
    localali.qJt = paramdud.qJt;
    localali.qJu = paramdud.qJu;
    localali.position = (paramInt + 1);
    WxaAttributes localWxaAttributes = m.bFF().c(paramdud.jEx, new String[0]);
    if (localWxaAttributes != null) {
      localali.appid = localWxaAttributes.field_appId;
    }
    this.rgZ.put(paramdud.qJp, localali);
    AppMethodBeat.o(49311);
  }
  
  public final void jR(boolean paramBoolean)
  {
    this.rgY = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */