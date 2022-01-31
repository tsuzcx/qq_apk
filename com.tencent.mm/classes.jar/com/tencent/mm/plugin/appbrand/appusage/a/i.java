package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;

public class i
  extends a<brc>
{
  public i(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(129755);
    this.rr = a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).ado();
    AppMethodBeat.o(129755);
  }
  
  static b.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(129756);
    ab.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    b.a locala = new b.a();
    brb localbrb = new brb();
    Object localObject = new bsj();
    bsh localbsh = new bsh();
    ((bsj)localObject).bqN = paramAppBrandRecommendStatObj.sessionId;
    ts localts = new ts();
    localts.wMo = at.getNetTypeString(ah.getContext());
    localts.longitude = paramAppBrandRecommendStatObj.cAH;
    localts.latitude = paramAppBrandRecommendStatObj.cyV;
    localbrb.xEO = ((bsj)localObject);
    localbrb.xEP = localbsh;
    localbsh.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new bkg();
      ((bkg)localObject).username = paramAppBrandRecommendStatObj.username;
      ((bkg)localObject).iFH = paramAppBrandRecommendStatObj.iFH;
      ((bkg)localObject).fBA = System.currentTimeMillis();
      ((bkg)localObject).iFI = paramAppBrandRecommendStatObj.iFI;
      ((bkg)localObject).cwc = paramAppBrandRecommendStatObj.cwc;
      ((bkg)localObject).iFM = paramAppBrandRecommendStatObj.iFM;
      ((bkg)localObject).position = paramAppBrandRecommendStatObj.position;
      ((bkg)localObject).xyI = ((int)paramLong1);
      ((bkg)localObject).wpE = ((int)paramLong2);
      localbsh.xFI = ((bkg)localObject);
    }
    for (;;)
    {
      locala.fsX = localbrb;
      locala.fsY = new brc();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(129756);
      return locala;
      localObject = new dp();
      ((dp)localObject).username = paramAppBrandRecommendStatObj.username;
      ((dp)localObject).fBA = System.currentTimeMillis();
      ((dp)localObject).iFI = paramAppBrandRecommendStatObj.iFI;
      ((dp)localObject).cwc = paramAppBrandRecommendStatObj.cwc;
      ((dp)localObject).iFM = paramAppBrandRecommendStatObj.iFM;
      ((dp)localObject).position = paramAppBrandRecommendStatObj.position;
      ((dp)localObject).wpE = ((int)paramLong2);
      localbsh.xFJ = ((dp)localObject);
    }
  }
  
  public static void b(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(129757);
    if (paramAppBrandRecommendStatObj == null)
    {
      AppMethodBeat.o(129757);
      return;
    }
    e.aNS().ac(new i.1(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj));
    AppMethodBeat.o(129757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i
 * JD-Core Version:    0.7.0.1
 */