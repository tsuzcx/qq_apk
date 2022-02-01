package com.tencent.mm.plugin.appbrand.networking;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.ss;
import com.tencent.mm.bx.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.gkt;
import com.tencent.mm.protocal.protobuf.glq;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "appId", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "startElapsedTime", "", "startTimestamp", "call", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "onBeforeRunCgi", "Lcom/tencent/mm/wx/WxPipeline;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "run", "assertNotNullForDebug", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "calibrateToSystemTimestamp", "Lcom/tencent/mm/protocal/protobuf/CgiProfile;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<T extends esc>
  extends com.tencent.mm.am.b<T>
{
  private final String appId;
  private long tpS;
  private long tpT;
  private final String userName;
  
  public b(byte paramByte)
  {
    this();
  }
  
  public b(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.userName = paramString2;
  }
  
  private static void c(aeo paramaeo)
  {
    AppMethodBeat.i(317270);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      kotlin.g.b.s.checkNotNull(paramaeo);
    }
    AppMethodBeat.o(317270);
  }
  
  public void a(int paramInt1, final int paramInt2, String paramString, final T paramT, final p paramp)
  {
    AppMethodBeat.i(317278);
    super.a(paramInt1, paramInt2, paramString, paramT, paramp);
    if (paramp != null) {
      com.tencent.threadpool.h.ahAA.bm((Runnable)new a(this, paramT, paramInt2, paramp));
    }
    label107:
    label125:
    long l2;
    long l1;
    if (paramp != null)
    {
      paramString = paramp.getReqResp();
      if (paramString != null)
      {
        paramString = paramString.getRespObj();
        if (paramString != null)
        {
          paramT = paramString.getProfile();
          if (paramT != null)
          {
            paramString = paramp.getReqResp();
            if (!(paramString instanceof com.tencent.mm.am.c)) {
              break label525;
            }
            paramString = (com.tencent.mm.am.c)paramString;
            if (paramString != null) {
              break label530;
            }
            paramString = null;
            if (paramString != null) {
              break label541;
            }
            paramInt1 = paramp.getReqResp().getReqObj().getCmdId();
            l2 = Util.nowMilliSecond();
            l1 = com.tencent.mm.kernel.h.baD().mCm.oun.getMarsTimestamp();
            l1 = Util.nowMilliSecond() - l1;
            paramT.startConnectTime += l1;
            paramT.connectSuccessfulTime += l1;
            paramT.startHandshakeTime += l1;
            paramT.handshakeSuccessfulTime += l1;
            paramT.startSendPacketTime += l1;
            paramT.startReadPacketTime += l1;
            paramT.readPacketFinishedTime += l1;
            paramT.taskStartTime = (l1 + paramT.taskStartTime);
            l1 = paramT.channelType;
            if (l1 != 2L) {
              break label549;
            }
            l1 = paramT.readPacketFinishedTime - paramT.startConnectTime;
          }
        }
      }
    }
    for (;;)
    {
      paramString = new StringBuilder();
      paramString.append("report profile, url:").append(paramp.getReqResp().getUri()).append(", cmdid:").append(paramInt1).append(", businessCgiSendTime:").append(this.tpS).append(", businessCgiFinishTime:").append(l2).append(", businessCgiCostTime:").append(l2 - this.tpS).append(", profile: profileCostTime:").append(l1).append(", startConnectTime:").append(paramT.startConnectTime).append(", connectSuccessfulTime:").append(paramT.connectSuccessfulTime).append(", startHandshakeTime:").append(paramT.startHandshakeTime).append(", handshakeSuccessfulTime:").append(paramT.handshakeSuccessfulTime).append(", startSendPacketTime:").append(paramT.startSendPacketTime).append(", startReadPacketTime:");
      paramString.append(paramT.startReadPacketTime).append(", readPacketFinishedTime:").append(paramT.readPacketFinishedTime).append(", taskStartTime:").append(paramT.taskStartTime).append(", rtt:").append(paramT.rtt).append(", channelType:").append(paramT.channelType);
      Log.i("MicroMsg.AppBrandCgiWithSpeedReport", paramString.toString());
      AppMethodBeat.o(317278);
      return;
      label525:
      paramString = null;
      break;
      label530:
      paramString = Integer.valueOf(paramString.getType());
      break label107;
      label541:
      paramInt1 = paramString.intValue();
      break label125;
      label549:
      if (l1 == 1L) {
        l1 = paramT.readPacketFinishedTime - paramT.taskStartTime;
      } else {
        l1 = 0L;
      }
    }
  }
  
  public f<com.tencent.mm.am.b.a<T>> bFJ()
  {
    AppMethodBeat.i(317280);
    Log.i("MicroMsg.AppBrandCgiWithSpeedReport", "run() url:" + this.rr.getUri() + ", cmdid:" + this.rr.getType());
    this.tpS = Util.nowMilliSecond();
    this.tpT = Util.currentTicks();
    f localf = ckO();
    if (localf != null)
    {
      AppMethodBeat.o(317280);
      return localf;
    }
    localf = super.bFJ();
    kotlin.g.b.s.s(localf, "super.run()");
    AppMethodBeat.o(317280);
    return localf;
  }
  
  public com.tencent.mm.am.b.a<T> cAG()
  {
    AppMethodBeat.i(317276);
    this.tpS = Util.nowMilliSecond();
    this.tpT = Util.currentTicks();
    com.tencent.mm.am.b.a locala = aa.c((com.tencent.mm.am.b)this);
    AppMethodBeat.o(317276);
    return locala;
  }
  
  public f<com.tencent.mm.am.b.a<T>> ckO()
  {
    AppMethodBeat.i(317282);
    a locala = c.b.b(this.rr.otB);
    if ((locala instanceof gkt)) {
      c(((gkt)locala).YMR);
    }
    for (;;)
    {
      AppMethodBeat.o(317282);
      return null;
      if ((locala instanceof dgt)) {
        c(((dgt)locala).YMR);
      } else if ((locala instanceof glq)) {
        c(((glq)locala).YMR);
      } else if ((locala instanceof cwt)) {
        c(((cwt)locala).YMR);
      } else if ((locala instanceof ky)) {
        c(((ky)locala).YMR);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport$onCgiBack$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.threadpool.i.j
  {
    a(b<T> paramb, T paramT, int paramInt, p paramp) {}
    
    public final String getKey()
    {
      return "";
    }
    
    public final boolean isLogging()
    {
      return false;
    }
    
    public final void run()
    {
      AppMethodBeat.i(317275);
      long l1 = System.currentTimeMillis();
      long l2 = SystemClock.elapsedRealtime();
      long l3 = b.a(this.tpU);
      ss localss = new ss();
      Object localObject2 = this.tpU;
      Object localObject3 = paramT;
      int i = paramInt2;
      Object localObject1 = paramp;
      localss.jzy = b.d((b)localObject2);
      localss.jzz = l1;
      localss.iQF = (l2 - l3);
      localss.zl(com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext()));
      if (localObject3 == null)
      {
        l1 = -1L;
        localss.jzA = l1;
        localss.jzB = i;
        if (localObject3 != null) {
          break label289;
        }
        i = -2147483648;
        label122:
        localss.jzC = i;
        localss.jzD = ((p)localObject1).getType();
        com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
        localObject1 = b.b(this.tpU);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        localObject1 = b.c(this.tpU);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        kotlin.g.b.s.u(localss, "weAppQualityCGISpeedStruct");
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.afZ((String)localObject3);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Object localObject4;
          label289:
          String str = "";
          continue;
          continue;
        }
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = "";
        }
        localss.zj((String)localObject4);
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        localss.zi((String)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localss.zk((String)localObject1);
        localss.bMH();
        AppMethodBeat.o(317275);
        return;
        l1 = ((esc)localObject3).computeSize();
        break;
        localObject2 = ((esc)localObject3).BaseResponse;
        if (localObject2 == null)
        {
          i = -2147483648;
          break label122;
        }
        i = ((kd)localObject2).Idd;
        break label122;
        localObject1 = ((QualitySessionRuntime)localObject1).eup;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.b
 * JD-Core Version:    0.7.0.1
 */