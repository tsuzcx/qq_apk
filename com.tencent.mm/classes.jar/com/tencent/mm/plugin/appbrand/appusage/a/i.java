package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

public class i
  extends a<cqy>
{
  public i(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44686);
    c(a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).aDS());
    AppMethodBeat.o(44686);
  }
  
  static b.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44687);
    ae.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    b.a locala = new b.a();
    cqx localcqx = new cqx();
    Object localObject = new csn();
    csj localcsj = new csj();
    ((csn)localObject).cbe = paramAppBrandRecommendStatObj.sessionId;
    ze localze = new ze();
    localze.Grf = az.getNetTypeString(ak.getContext());
    localze.longitude = paramAppBrandRecommendStatObj.dBu;
    localze.latitude = paramAppBrandRecommendStatObj.dzE;
    localcqx.HCo = ((csn)localObject);
    localcqx.HCp = localcsj;
    localcsj.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new cic();
      ((cic)localObject).username = paramAppBrandRecommendStatObj.username;
      ((cic)localObject).mwf = paramAppBrandRecommendStatObj.mwf;
      ((cic)localObject).iaa = System.currentTimeMillis();
      ((cic)localObject).mwg = paramAppBrandRecommendStatObj.mwg;
      ((cic)localObject).dwb = paramAppBrandRecommendStatObj.dwb;
      ((cic)localObject).mwk = paramAppBrandRecommendStatObj.mwk;
      ((cic)localObject).position = paramAppBrandRecommendStatObj.position;
      ((cic)localObject).Huk = ((int)paramLong1);
      ((cic)localObject).FOD = ((int)paramLong2);
      localcsj.HDv = ((cic)localObject);
    }
    for (;;)
    {
      locala.hQF = localcqx;
      locala.hQG = new cqy();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(44687);
      return locala;
      localObject = new ei();
      ((ei)localObject).username = paramAppBrandRecommendStatObj.username;
      ((ei)localObject).iaa = System.currentTimeMillis();
      ((ei)localObject).mwg = paramAppBrandRecommendStatObj.mwg;
      ((ei)localObject).dwb = paramAppBrandRecommendStatObj.dwb;
      ((ei)localObject).mwk = paramAppBrandRecommendStatObj.mwk;
      ((ei)localObject).position = paramAppBrandRecommendStatObj.position;
      ((ei)localObject).FOD = ((int)paramLong2);
      localcsj.HDw = ((ei)localObject);
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
    f.bCj().postToWorker(new i.1(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj));
    AppMethodBeat.o(44688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i
 * JD-Core Version:    0.7.0.1
 */