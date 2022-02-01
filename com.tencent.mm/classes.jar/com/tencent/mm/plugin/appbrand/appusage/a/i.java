package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public class i
  extends c<cle>
{
  public i(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44686);
    this.rr = a(paramInt, paramLong1, paramLong2, paramAppBrandRecommendStatObj).aAz();
    AppMethodBeat.o(44686);
  }
  
  static b.a a(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj)
  {
    AppMethodBeat.i(44687);
    ac.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramAppBrandRecommendStatObj.toString() });
    b.a locala = new b.a();
    cld localcld = new cld();
    Object localObject = new cmq();
    cmo localcmo = new cmo();
    ((cmq)localObject).bQR = paramAppBrandRecommendStatObj.sessionId;
    xc localxc = new xc();
    localxc.Erw = ax.getNetTypeString(ai.getContext());
    localxc.longitude = paramAppBrandRecommendStatObj.doB;
    localxc.latitude = paramAppBrandRecommendStatObj.dmL;
    localcld.FyJ = ((cmq)localObject);
    localcld.FyK = localcmo;
    localcmo.type = paramInt;
    if (paramInt == 1)
    {
      localObject = new ccq();
      ((ccq)localObject).username = paramAppBrandRecommendStatObj.username;
      ((ccq)localObject).lRr = paramAppBrandRecommendStatObj.lRr;
      ((ccq)localObject).hED = System.currentTimeMillis();
      ((ccq)localObject).lRs = paramAppBrandRecommendStatObj.lRs;
      ((ccq)localObject).djj = paramAppBrandRecommendStatObj.djj;
      ((ccq)localObject).lRw = paramAppBrandRecommendStatObj.lRw;
      ((ccq)localObject).position = paramAppBrandRecommendStatObj.position;
      ((ccq)localObject).Frb = ((int)paramLong1);
      ((ccq)localObject).DQN = ((int)paramLong2);
      localcmo.FzN = ((ccq)localObject);
    }
    for (;;)
    {
      locala.hvt = localcld;
      locala.hvu = new cle();
      locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
      locala.funcId = 2799;
      AppMethodBeat.o(44687);
      return locala;
      localObject = new ee();
      ((ee)localObject).username = paramAppBrandRecommendStatObj.username;
      ((ee)localObject).hED = System.currentTimeMillis();
      ((ee)localObject).lRs = paramAppBrandRecommendStatObj.lRs;
      ((ee)localObject).djj = paramAppBrandRecommendStatObj.djj;
      ((ee)localObject).lRw = paramAppBrandRecommendStatObj.lRw;
      ((ee)localObject).position = paramAppBrandRecommendStatObj.position;
      ((ee)localObject).DQN = ((int)paramLong2);
      localcmo.FzO = ((ee)localObject);
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
    e.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44685);
        if (this.jxs == 1)
        {
          IPCRunCgi.a(i.a(this.jxs, paramLong1, paramAppBrandRecommendStatObj, this.jxv).aAz(), new IPCRunCgi.a()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, b paramAnonymous2b)
            {
              AppMethodBeat.i(44683);
              ac.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
              {
                ac.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                AppMethodBeat.o(44683);
                return;
              }
              ac.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
              AppMethodBeat.o(44683);
            }
          });
          AppMethodBeat.o(44685);
          return;
        }
        new i(this.jxs, paramLong1, paramAppBrandRecommendStatObj, this.jxv) {}.aBB();
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