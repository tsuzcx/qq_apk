package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public class i
  extends a<cqe>
{
  public i(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44686);
    c(a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).aDC());
    AppMethodBeat.o(44686);
  }
  
  static b.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44687);
    ad.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    b.a locala = new b.a();
    cqd localcqd = new cqd();
    Object localObject = new crt();
    crp localcrp = new crp();
    ((crt)localObject).cbe = paramAppBrandRecommendStatObj.sessionId;
    zb localzb = new zb();
    localzb.FYG = ay.getNetTypeString(aj.getContext());
    localzb.longitude = paramAppBrandRecommendStatObj.dAp;
    localzb.latitude = paramAppBrandRecommendStatObj.dyz;
    localcqd.HiO = ((crt)localObject);
    localcqd.HiP = localcrp;
    localcrp.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new chi();
      ((chi)localObject).username = paramAppBrandRecommendStatObj.username;
      ((chi)localObject).mrh = paramAppBrandRecommendStatObj.mrh;
      ((chi)localObject).hXi = System.currentTimeMillis();
      ((chi)localObject).mri = paramAppBrandRecommendStatObj.mri;
      ((chi)localObject).duW = paramAppBrandRecommendStatObj.duW;
      ((chi)localObject).mrm = paramAppBrandRecommendStatObj.mrm;
      ((chi)localObject).position = paramAppBrandRecommendStatObj.position;
      ((chi)localObject).HaK = ((int)paramLong1);
      ((chi)localObject).Fwf = ((int)paramLong2);
      localcrp.HjV = ((chi)localObject);
    }
    for (;;)
    {
      locala.hNM = localcqd;
      locala.hNN = new cqe();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(44687);
      return locala;
      localObject = new ei();
      ((ei)localObject).username = paramAppBrandRecommendStatObj.username;
      ((ei)localObject).hXi = System.currentTimeMillis();
      ((ei)localObject).mri = paramAppBrandRecommendStatObj.mri;
      ((ei)localObject).duW = paramAppBrandRecommendStatObj.duW;
      ((ei)localObject).mrm = paramAppBrandRecommendStatObj.mrm;
      ((ei)localObject).position = paramAppBrandRecommendStatObj.position;
      ((ei)localObject).Fwf = ((int)paramLong2);
      localcrp.HjW = ((ei)localObject);
    }
  }
  
  public static void b(int paramInt, final long paramLong1, long paramLong2, final AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44688);
    if (paramAppBrandRecommendStatObj == null)
    {
      AppMethodBeat.o(44688);
      return;
    }
    e.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44685);
        if (this.jRo == 1)
        {
          IPCRunCgi.a(i.a(this.jRo, paramLong1, paramAppBrandRecommendStatObj, this.jRr).aDC(), new IPCRunCgi.a()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, b paramAnonymous2b)
            {
              AppMethodBeat.i(44683);
              ad.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                ad.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                AppMethodBeat.o(44683);
                return;
              }
              ad.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
              AppMethodBeat.o(44683);
            }
          });
          AppMethodBeat.o(44685);
          return;
        }
        new i(this.jRo, paramLong1, paramAppBrandRecommendStatObj, this.jRr) {}.aED();
        AppMethodBeat.o(44685);
      }
    });
    AppMethodBeat.o(44688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i
 * JD-Core Version:    0.7.0.1
 */