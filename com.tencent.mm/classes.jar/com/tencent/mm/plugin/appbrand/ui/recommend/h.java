package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.a.f.1;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  private long mNd;
  private long mNe;
  private long mNf;
  private boolean mNg;
  private HashMap<String, ahj> mNh;
  private LinkedList<yx> mNi;
  private HashMap<String, yx> mNj;
  
  public h()
  {
    AppMethodBeat.i(49300);
    this.mNd = 0L;
    this.mNe = 0L;
    this.mNf = 0L;
    this.mNg = false;
    this.mNh = new HashMap();
    this.mNi = new LinkedList();
    this.mNj = new HashMap();
    AppMethodBeat.o(49300);
  }
  
  private static void a(LinkedList<yx> paramLinkedList, LinkedList<ahj> paramLinkedList1)
  {
    AppMethodBeat.i(49307);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (yx)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((yx)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((yx)localObject).mrh).append(",");
        localStringBuilder.append("item_count:").append(((yx)localObject).FYz).append(",");
        localStringBuilder.append("footnote_count:").append(((yx)localObject).FYA).append(",");
        localStringBuilder.append("strategy_info:").append(((yx)localObject).mri).append(",");
        localStringBuilder.append("appid:").append(((yx)localObject).duW).append(",");
        localStringBuilder.append("page_path:").append(((yx)localObject).mrj).append(",");
        localStringBuilder.append("page_param:").append(((yx)localObject).mrk).append(",");
        localStringBuilder.append("card_type:").append(((yx)localObject).mrl).append(",");
        localStringBuilder.append("pass_str:").append(((yx)localObject).mrm).append(",");
        localStringBuilder.append("},");
        ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (ahj)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.mrh).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.mri).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.GeY).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.duW).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.mrj).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.mrk).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.mrl).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.mrm).append(",");
        ((StringBuilder)localObject).append("},");
        ad.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(49307);
  }
  
  private void bBb()
  {
    AppMethodBeat.i(49302);
    this.mNe = bt.aQJ();
    this.mNd = this.mNe;
    this.mNg = false;
    this.mNh.clear();
    this.mNi.clear();
    this.mNj.clear();
    this.mNf = 0L;
    AppMethodBeat.o(49302);
  }
  
  private LinkedList<ahj> bBe()
  {
    AppMethodBeat.i(49305);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mNh.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.mNh.get(str));
    }
    ad.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.mNh.size()) });
    AppMethodBeat.o(49305);
    return localLinkedList;
  }
  
  private static yx c(int paramInt, crr paramcrr)
  {
    AppMethodBeat.i(49310);
    yx localyx = new yx();
    localyx.username = paramcrr.GMM;
    localyx.mrh = paramcrr.mrh;
    localyx.mri = paramcrr.mri;
    localyx.mrj = paramcrr.mrj;
    localyx.mrk = paramcrr.mrk;
    localyx.mrl = paramcrr.mrl;
    localyx.mrm = paramcrr.mrm;
    localyx.position = (paramInt + 1);
    paramcrr = j.aYP().d(paramcrr.GMM, new String[0]);
    if (paramcrr != null) {
      localyx.duW = paramcrr.field_appId;
    }
    AppMethodBeat.o(49310);
    return localyx;
  }
  
  public final void W(String paramString, long paramLong)
  {
    AppMethodBeat.i(49312);
    if (this.mNh.containsKey(paramString))
    {
      ahj localahj = (ahj)this.mNh.get(paramString);
      localahj.GeY = ((int)(localahj.GeY + paramLong));
      this.mNh.put(paramString, localahj);
    }
    AppMethodBeat.o(49312);
  }
  
  public final void a(int paramInt, crr paramcrr)
  {
    AppMethodBeat.i(49308);
    if (paramcrr == null)
    {
      AppMethodBeat.o(49308);
      return;
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportContentClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommend_id:%s", new Object[] { Integer.valueOf(paramInt), paramcrr.GMM, paramcrr.Hkg, Integer.valueOf(paramcrr.mrl), paramcrr.mrh });
    if (this.mNj.containsKey(paramcrr.mrh))
    {
      paramcrr = (yx)this.mNj.get(paramcrr.mrh);
      paramcrr.FYz += 1;
      AppMethodBeat.o(49308);
      return;
    }
    yx localyx = c(paramInt, paramcrr);
    localyx.FYz = 1;
    localyx.FYA = 0;
    this.mNj.put(paramcrr.mrh, localyx);
    this.mNi.add(localyx);
    AppMethodBeat.o(49308);
  }
  
  public final void b(int paramInt, crr paramcrr)
  {
    AppMethodBeat.i(49309);
    if (paramcrr == null)
    {
      AppMethodBeat.o(49309);
      return;
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "reportFooterClick position:%d, app_user_name:%s, app_nick_name:%s, card_type:%d, recommendId:%s", new Object[] { Integer.valueOf(paramInt), paramcrr.GMM, paramcrr.Hkg, Integer.valueOf(paramcrr.mrl), paramcrr.mrh });
    if (this.mNj.containsKey(paramcrr.mrh))
    {
      paramcrr = (yx)this.mNj.get(paramcrr.mrh);
      paramcrr.FYA += 1;
      AppMethodBeat.o(49309);
      return;
    }
    yx localyx = c(paramInt, paramcrr);
    localyx.FYz = 0;
    localyx.FYA = 1;
    this.mNj.put(paramcrr.mrh, localyx);
    this.mNi.add(localyx);
    AppMethodBeat.o(49309);
  }
  
  public final void bBa()
  {
    AppMethodBeat.i(49301);
    bBb();
    AppMethodBeat.o(49301);
  }
  
  public final void bBc()
  {
    AppMethodBeat.i(49303);
    this.mNe = bt.aQJ();
    AppMethodBeat.o(49303);
  }
  
  public final void bBd()
  {
    AppMethodBeat.i(49304);
    this.mNf = (bt.aQJ() - this.mNe + this.mNf);
    this.mNe = bt.aQJ();
    AppMethodBeat.o(49304);
  }
  
  public final void d(int paramInt, crr paramcrr)
  {
    AppMethodBeat.i(49311);
    if (this.mNh.containsKey(paramcrr.mrh))
    {
      localahj = (ahj)this.mNh.get(paramcrr.mrh);
      localahj.count += 1;
      this.mNh.put(paramcrr.mrh, localahj);
      AppMethodBeat.o(49311);
      return;
    }
    ahj localahj = new ahj();
    localahj.username = paramcrr.GMM;
    localahj.count = 1;
    localahj.mrh = paramcrr.mrh;
    localahj.mri = paramcrr.mri;
    localahj.GeY = 0;
    localahj.mrj = paramcrr.mrj;
    localahj.mrk = paramcrr.mrk;
    localahj.mrl = paramcrr.mrl;
    localahj.mrm = paramcrr.mrm;
    localahj.position = (paramInt + 1);
    WxaAttributes localWxaAttributes = j.aYP().d(paramcrr.GMM, new String[0]);
    if (localWxaAttributes != null) {
      localahj.duW = localWxaAttributes.field_appId;
    }
    this.mNh.put(paramcrr.mrh, localahj);
    AppMethodBeat.o(49311);
  }
  
  public final void hP(boolean paramBoolean)
  {
    this.mNg = paramBoolean;
  }
  
  public final void sY(long paramLong)
  {
    long l1 = 86400L;
    AppMethodBeat.i(49306);
    if (this.mNi.size() == 0)
    {
      if (this.mNh.size() > 0) {}
      for (i = 1; i == 0; i = 0)
      {
        ad.e("MicroMsg.Recommend.AppBrandRecommendReport", "none data report");
        AppMethodBeat.o(49306);
        return;
      }
    }
    ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData");
    long l2 = bt.aQJ() - this.mNe;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    if (l2 >= 86400L)
    {
      localLinkedList1 = new LinkedList();
      localLinkedList1.addAll(this.mNi);
      localLinkedList2 = bBe();
      if (!this.mNg) {
        break label264;
      }
    }
    label264:
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData sessionId:%d, click_node_list size :%d, exposureNodeList size:%d, exposureSceneType:%d, stayTime:%d, startRecordTime:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.mNi.size()), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(this.mNd) });
      a(this.mNi, localLinkedList2);
      int j = (int)l1;
      int k = (int)this.mNd;
      ad.d("MicroMsg.Recommend.AppBrandReportRecommendLogic", "reportReportRecommendWxa");
      e.bBp().postToWorker(new f.1(paramLong, localLinkedList2, localLinkedList1, i, j, k));
      bBb();
      AppMethodBeat.o(49306);
      return;
      l1 = this.mNf + l2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */