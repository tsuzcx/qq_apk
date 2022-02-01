package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.cyj;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public class i
  extends c<dix>
{
  public i(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44686);
    c(a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).aXF());
    AppMethodBeat.o(44686);
  }
  
  static d.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44687);
    Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    d.a locala = new d.a();
    diw localdiw = new diw();
    Object localObject = new dks();
    dkl localdkl = new dkl();
    ((dks)localObject).clK = paramAppBrandRecommendStatObj.sessionId;
    aat localaat = new aat();
    localaat.Lmb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    localaat.longitude = paramAppBrandRecommendStatObj.dTj;
    localaat.latitude = paramAppBrandRecommendStatObj.latitude;
    localdiw.MNc = ((dks)localObject);
    localdiw.MNd = localdkl;
    localdkl.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new cyj();
      ((cyj)localObject).username = paramAppBrandRecommendStatObj.username;
      ((cyj)localObject).nHd = paramAppBrandRecommendStatObj.nHd;
      ((cyj)localObject).request_id = System.currentTimeMillis();
      ((cyj)localObject).nHe = paramAppBrandRecommendStatObj.nHe;
      ((cyj)localObject).dNI = paramAppBrandRecommendStatObj.dNI;
      ((cyj)localObject).nHi = paramAppBrandRecommendStatObj.nHi;
      ((cyj)localObject).position = paramAppBrandRecommendStatObj.position;
      ((cyj)localObject).MDi = ((int)paramLong1);
      ((cyj)localObject).KIl = ((int)paramLong2);
      localdkl.MOn = ((cyj)localObject);
    }
    for (;;)
    {
      locala.iLN = localdiw;
      locala.iLO = new dix();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(44687);
      return locala;
      localObject = new ev();
      ((ev)localObject).username = paramAppBrandRecommendStatObj.username;
      ((ev)localObject).request_id = System.currentTimeMillis();
      ((ev)localObject).nHe = paramAppBrandRecommendStatObj.nHe;
      ((ev)localObject).dNI = paramAppBrandRecommendStatObj.dNI;
      ((ev)localObject).nHi = paramAppBrandRecommendStatObj.nHi;
      ((ev)localObject).position = paramAppBrandRecommendStatObj.position;
      ((ev)localObject).KIl = ((int)paramLong2);
      localdkl.MOo = ((ev)localObject);
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
    f.bZn().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44685);
        if (this.kXC == 1)
        {
          IPCRunCgi.a(i.a(this.kXC, paramLong1, paramAppBrandRecommendStatObj, this.kXF).aXF(), new IPCRunCgi.a()
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
        new i(this.kXC, paramLong1, paramAppBrandRecommendStatObj, this.kXF) {}.aYI();
        AppMethodBeat.o(44685);
      }
    });
    AppMethodBeat.o(44688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i
 * JD-Core Version:    0.7.0.1
 */