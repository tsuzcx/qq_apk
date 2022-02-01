package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.enb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  long uoR;
  long uoS;
  long uoT;
  boolean uoU;
  HashMap<String, aot> uoV;
  LinkedList<acu> uoW;
  HashMap<String, acu> uoX;
  
  public h()
  {
    AppMethodBeat.i(49300);
    this.uoR = 0L;
    this.uoS = 0L;
    this.uoT = 0L;
    this.uoU = false;
    this.uoV = new HashMap();
    this.uoW = new LinkedList();
    this.uoX = new HashMap();
    AppMethodBeat.o(49300);
  }
  
  static acu a(int paramInt, enb paramenb)
  {
    AppMethodBeat.i(49310);
    acu localacu = new acu();
    localacu.username = paramenb.met;
    localacu.tNS = paramenb.tNS;
    localacu.tNT = paramenb.tNT;
    localacu.tNU = paramenb.tNU;
    localacu.tNV = paramenb.tNV;
    localacu.tNW = paramenb.tNW;
    localacu.tNX = paramenb.tNX;
    localacu.position = (paramInt + 1);
    paramenb = n.cfc().d(paramenb.met, new String[0]);
    if (paramenb != null) {
      localacu.appid = paramenb.field_appId;
    }
    AppMethodBeat.o(49310);
    return localacu;
  }
  
  static void a(LinkedList<acu> paramLinkedList, LinkedList<aot> paramLinkedList1)
  {
    AppMethodBeat.i(49307);
    Object localObject;
    if (paramLinkedList.size() > 0)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (acu)paramLinkedList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{");
        localStringBuilder.append("username:").append(((acu)localObject).username).append(",");
        localStringBuilder.append("recommend_id:").append(((acu)localObject).tNS).append(",");
        localStringBuilder.append("item_count:").append(((acu)localObject).Zlq).append(",");
        localStringBuilder.append("footnote_count:").append(((acu)localObject).Zlr).append(",");
        localStringBuilder.append("strategy_info:").append(((acu)localObject).tNT).append(",");
        localStringBuilder.append("appid:").append(((acu)localObject).appid).append(",");
        localStringBuilder.append("page_path:").append(((acu)localObject).tNU).append(",");
        localStringBuilder.append("page_param:").append(((acu)localObject).tNV).append(",");
        localStringBuilder.append("card_type:").append(((acu)localObject).tNW).append(",");
        localStringBuilder.append("pass_str:").append(((acu)localObject).tNX).append(",");
        localStringBuilder.append("},");
        Log.i("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData clickData:%s", new Object[] { localStringBuilder.toString() });
      }
    }
    if (paramLinkedList1.size() > 0)
    {
      paramLinkedList = paramLinkedList1.iterator();
      while (paramLinkedList.hasNext())
      {
        paramLinkedList1 = (aot)paramLinkedList.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{");
        ((StringBuilder)localObject).append("username:").append(paramLinkedList1.username).append(",");
        ((StringBuilder)localObject).append("recommend_id:").append(paramLinkedList1.tNS).append(",");
        ((StringBuilder)localObject).append("count:").append(paramLinkedList1.count).append(",");
        ((StringBuilder)localObject).append("strategy_info:").append(paramLinkedList1.tNT).append(",");
        ((StringBuilder)localObject).append("expose_millisecond:").append(paramLinkedList1.ZvW).append(",");
        ((StringBuilder)localObject).append("appid:").append(paramLinkedList1.appid).append(",");
        ((StringBuilder)localObject).append("page_path:").append(paramLinkedList1.tNU).append(",");
        ((StringBuilder)localObject).append("page_param:").append(paramLinkedList1.tNV).append(",");
        ((StringBuilder)localObject).append("card_type:").append(paramLinkedList1.tNW).append(",");
        ((StringBuilder)localObject).append("pass_str:").append(paramLinkedList1.tNX).append(",");
        ((StringBuilder)localObject).append("},");
        Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "doReportData exposureData:%s", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
    AppMethodBeat.o(49307);
  }
  
  public final void cNb()
  {
    AppMethodBeat.i(49302);
    this.uoS = Util.nowSecond();
    this.uoR = this.uoS;
    this.uoU = false;
    this.uoV.clear();
    this.uoW.clear();
    this.uoX.clear();
    this.uoT = 0L;
    AppMethodBeat.o(49302);
  }
  
  final LinkedList<aot> cNc()
  {
    AppMethodBeat.i(49305);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.uoV.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add((aot)this.uoV.get(str));
    }
    Log.d("MicroMsg.Recommend.AppBrandRecommendReport", "exposureNodeMap size:%d", new Object[] { Integer.valueOf(this.uoV.size()) });
    AppMethodBeat.o(49305);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.h
 * JD-Core Version:    0.7.0.1
 */