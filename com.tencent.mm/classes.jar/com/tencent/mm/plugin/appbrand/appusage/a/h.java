package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.elk;
import com.tencent.mm.protocal.protobuf.emy;
import com.tencent.mm.protocal.protobuf.enf;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public class h
  extends b<elk>
{
  public h(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44686);
    c(a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).bEF());
    AppMethodBeat.o(44686);
  }
  
  private static c.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44687);
    Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    c.a locala = new c.a();
    elj localelj = new elj();
    Object localObject = new enf();
    emy localemy = new emy();
    ((enf)localObject).aaxM = paramAppBrandRecommendStatObj.sessionId;
    acz localacz = new acz();
    localacz.ZlB = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    localacz.longitude = paramAppBrandRecommendStatObj.longitude;
    localacz.latitude = paramAppBrandRecommendStatObj.latitude;
    localelj.abpT = ((enf)localObject);
    localelj.abpU = localemy;
    localemy.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new eaf();
      ((eaf)localObject).username = paramAppBrandRecommendStatObj.username;
      ((eaf)localObject).tNS = paramAppBrandRecommendStatObj.tNS;
      ((eaf)localObject).request_id = System.currentTimeMillis();
      ((eaf)localObject).tNT = paramAppBrandRecommendStatObj.tNT;
      ((eaf)localObject).appid = paramAppBrandRecommendStatObj.appid;
      ((eaf)localObject).tNX = paramAppBrandRecommendStatObj.tNX;
      ((eaf)localObject).position = paramAppBrandRecommendStatObj.position;
      ((eaf)localObject).abfn = ((int)paramLong1);
      ((eaf)localObject).YGW = ((int)paramLong2);
      localemy.abri = ((eaf)localObject);
    }
    for (;;)
    {
      locala.otE = localelj;
      locala.otF = new elk();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(44687);
      return locala;
      localObject = new fm();
      ((fm)localObject).username = paramAppBrandRecommendStatObj.username;
      ((fm)localObject).request_id = System.currentTimeMillis();
      ((fm)localObject).tNT = paramAppBrandRecommendStatObj.tNT;
      ((fm)localObject).appid = paramAppBrandRecommendStatObj.appid;
      ((fm)localObject).tNX = paramAppBrandRecommendStatObj.tNX;
      ((fm)localObject).position = paramAppBrandRecommendStatObj.position;
      ((fm)localObject).YGW = ((int)paramLong2);
      localemy.abrj = ((fm)localObject);
    }
  }
  
  public static void b(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44688);
    if (paramAppBrandRecommendStatObj == null)
    {
      AppMethodBeat.o(44688);
      return;
    }
    l.cNm().postToWorker(new h.1(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj));
    AppMethodBeat.o(44688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h
 * JD-Core Version:    0.7.0.1
 */