package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public class i
  extends c<cgb>
{
  public i(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44686);
    this.rr = a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).atI();
    AppMethodBeat.o(44686);
  }
  
  static b.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44687);
    ad.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    b.a locala = new b.a();
    cga localcga = new cga();
    Object localObject = new chn();
    chl localchl = new chl();
    ((chn)localObject).bTj = paramAppBrandRecommendStatObj.sessionId;
    wq localwq = new wq();
    localwq.CYL = ay.getNetTypeString(aj.getContext());
    localwq.longitude = paramAppBrandRecommendStatObj.dqQ;
    localwq.latitude = paramAppBrandRecommendStatObj.dpb;
    localcga.EbO = ((chn)localObject);
    localcga.EbP = localchl;
    localchl.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new bxv();
      ((bxv)localObject).username = paramAppBrandRecommendStatObj.username;
      ((bxv)localObject).lpv = paramAppBrandRecommendStatObj.lpv;
      ((bxv)localObject).hea = System.currentTimeMillis();
      ((bxv)localObject).lpw = paramAppBrandRecommendStatObj.lpw;
      ((bxv)localObject).dlB = paramAppBrandRecommendStatObj.dlB;
      ((bxv)localObject).lpA = paramAppBrandRecommendStatObj.lpA;
      ((bxv)localObject).position = paramAppBrandRecommendStatObj.position;
      ((bxv)localObject).DUo = ((int)paramLong1);
      ((bxv)localObject).Cyr = ((int)paramLong2);
      localchl.EcS = ((bxv)localObject);
    }
    for (;;)
    {
      locala.gUU = localcga;
      locala.gUV = new cgb();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(44687);
      return locala;
      localObject = new ec();
      ((ec)localObject).username = paramAppBrandRecommendStatObj.username;
      ((ec)localObject).hea = System.currentTimeMillis();
      ((ec)localObject).lpw = paramAppBrandRecommendStatObj.lpw;
      ((ec)localObject).dlB = paramAppBrandRecommendStatObj.dlB;
      ((ec)localObject).lpA = paramAppBrandRecommendStatObj.lpA;
      ((ec)localObject).position = paramAppBrandRecommendStatObj.position;
      ((ec)localObject).Cyr = ((int)paramLong2);
      localchl.EcT = ((ec)localObject);
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
    e.bqm().postToWorker(new i.1(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj));
    AppMethodBeat.o(44688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i
 * JD-Core Version:    0.7.0.1
 */