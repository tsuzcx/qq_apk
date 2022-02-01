package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.protocal.protobuf.duh;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public class i
  extends c<dsp>
{
  public i(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44686);
    c(a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).bgN());
    AppMethodBeat.o(44686);
  }
  
  private static d.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44687);
    Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    d.a locala = new d.a();
    dso localdso = new dso();
    Object localObject = new duh();
    dua localdua = new dua();
    ((duh)localObject).Tkj = paramAppBrandRecommendStatObj.sessionId;
    aaz localaaz = new aaz();
    localaaz.Snp = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    localaaz.longitude = paramAppBrandRecommendStatObj.longitude;
    localaaz.latitude = paramAppBrandRecommendStatObj.latitude;
    localdso.TYW = ((duh)localObject);
    localdso.TYX = localdua;
    localdua.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new dhv();
      ((dhv)localObject).username = paramAppBrandRecommendStatObj.username;
      ((dhv)localObject).qJp = paramAppBrandRecommendStatObj.qJp;
      ((dhv)localObject).request_id = System.currentTimeMillis();
      ((dhv)localObject).qJq = paramAppBrandRecommendStatObj.qJq;
      ((dhv)localObject).appid = paramAppBrandRecommendStatObj.appid;
      ((dhv)localObject).qJu = paramAppBrandRecommendStatObj.qJu;
      ((dhv)localObject).position = paramAppBrandRecommendStatObj.position;
      ((dhv)localObject).TOR = ((int)paramLong1);
      ((dhv)localObject).RJC = ((int)paramLong2);
      localdua.Uag = ((dhv)localObject);
    }
    for (;;)
    {
      locala.lBU = localdso;
      locala.lBV = new dsp();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(44687);
      return locala;
      localObject = new es();
      ((es)localObject).username = paramAppBrandRecommendStatObj.username;
      ((es)localObject).request_id = System.currentTimeMillis();
      ((es)localObject).qJq = paramAppBrandRecommendStatObj.qJq;
      ((es)localObject).appid = paramAppBrandRecommendStatObj.appid;
      ((es)localObject).qJu = paramAppBrandRecommendStatObj.qJu;
      ((es)localObject).position = paramAppBrandRecommendStatObj.position;
      ((es)localObject).RJC = ((int)paramLong2);
      localdua.Uah = ((es)localObject);
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
    h.clV().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44685);
        if (this.nRO == 1)
        {
          IPCRunCgi.a(i.c(this.nRO, paramLong1, paramAppBrandRecommendStatObj, this.nRR).bgN(), new IPCRunCgi.a()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, d paramAnonymous2d)
            {
              AppMethodBeat.i(44683);
              Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                AppMethodBeat.o(44683);
                return;
              }
              Log.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
              AppMethodBeat.o(44683);
            }
          });
          AppMethodBeat.o(44685);
          return;
        }
        new i(this.nRO, paramLong1, paramAppBrandRecommendStatObj, this.nRR) {}.bhW();
        AppMethodBeat.o(44685);
      }
    });
    AppMethodBeat.o(44688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i
 * JD-Core Version:    0.7.0.1
 */