package com.tencent.mm.bq;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ema;
import com.tencent.mm.protocal.protobuf.emc;
import com.tencent.mm.protocal.protobuf.emd;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends q
  implements m
{
  private i jQg;
  private b mxa;
  private int mxb;
  private int mxc;
  private int mxd;
  private int mxe;
  private ema mxf;
  private ema mxg;
  private String mxh;
  private com.tencent.mm.an.d rr;
  
  public a(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ema paramema1, ema paramema2, String paramString)
  {
    AppMethodBeat.i(20678);
    this.rr = null;
    this.mxa = paramb;
    this.mxb = paramInt1;
    this.mxc = paramInt2;
    this.mxd = paramInt3;
    this.mxe = paramInt4;
    this.mxf = paramema1;
    this.mxg = paramema2;
    this.mxh = paramString;
    paramb = new d.a();
    paramb.lBU = new emc();
    paramb.lBV = new emd();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.lBW = 996;
    paramb.respCmdId = 1000000996;
    paramb.newExtFlag = 0;
    paramb.transferHeader = null;
    this.rr = paramb.bgN();
    AppMethodBeat.o(20678);
  }
  
  private static String bud()
  {
    AppMethodBeat.i(20681);
    String str1 = "";
    String str2 = str1;
    label106:
    for (;;)
    {
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        str2 = str1;
        if (localEnumeration1.hasMoreElements())
        {
          str2 = str1;
          Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          str2 = str1;
          if (!localEnumeration2.hasMoreElements()) {
            break label106;
          }
          str2 = str1;
          InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
          str2 = str1;
          if (!(localInetAddress instanceof Inet6Address)) {
            continue;
          }
          str2 = str1;
          str1 = localInetAddress.getHostAddress().toString();
          continue;
        }
        AppMethodBeat.o(20681);
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(20681);
        return str2;
      }
      return localException;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20679);
    this.jQg = parami;
    parami = (emc)d.b.b(this.rr.lBR);
    parami.TAB = this.mxa;
    parami.UoB = this.mxb;
    parami.UoC = this.mxc;
    parami.UoD = this.mxd;
    parami.UoE = this.mxe;
    parami.UoG = this.mxf;
    parami.UoF = this.mxg;
    Object localObject;
    int i;
    if ("dual".equals(this.mxh))
    {
      localObject = parami.UoF.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label515;
      }
      i = 1;
      if (i != 0)
      {
        parami.UoG.ip = bud();
        Log.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + parami.UoG.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      parami.Uoy = "NONET";
    }
    for (;;)
    {
      localObject = new StringBuilder("device info:");
      ((StringBuilder)localObject).append(com.tencent.mm.protocal.d.RAw);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(com.tencent.mm.protocal.d.RAx);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(com.tencent.mm.protocal.d.RAz);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(com.tencent.mm.protocal.d.RAA);
      parami.UoA = ((StringBuilder)localObject).toString();
      Log.d("MicroMsg.MMNewSpeedTest", "speed test " + parami.UoA + ",networktype: " + parami.Uoy + ",network_info: " + parami.Uoz + ",conn_time: " + parami.UoB + ",conn_retcode: " + parami.UoC + ",trans_time: " + parami.UoD + ",trans_time: " + parami.UoE + ",cookie: " + parami.TAB.toString() + ",cookie size: " + parami.TAB.UH.length + ",size: " + parami.computeSize() + ",client ip: " + parami.UoG.ip + ",client port: " + parami.UoG.port + ",server ip: " + parami.UoF.ip + ",server port: " + parami.UoF.port);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(20679);
      return i;
      label515:
      i = 0;
      break;
      parami.Uoy = "WIFI";
      parami.Uoz = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      continue;
      switch (PlatformComm.C2Java.getStatisticsNetType())
      {
      default: 
        parami.Uoy = "EDGE";
      }
      for (;;)
      {
        localObject = PlatformComm.C2Java.getCurSIMInfo();
        if (localObject == null) {
          break label641;
        }
        parami.Uoz = ((PlatformComm.SIMInfo)localObject).ispCode;
        break;
        parami.Uoy = "2G";
        continue;
        parami.Uoy = "3G";
        continue;
        parami.Uoy = "4G";
        continue;
        parami.Uoy = "EDGE";
      }
      label641:
      parami.Uoz = "unknown_netinfo";
      continue;
      parami.Uoy = "NONET";
    }
  }
  
  public final int getType()
  {
    return 271;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20680);
    Log.d("MicroMsg.MMNewSpeedTest", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt3 == 0) && (paramInt2 == 0)) {
      h.IzE.el(317, 26);
    }
    for (;;)
    {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20680);
      return;
      h.IzE.el(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bq.a
 * JD-Core Version:    0.7.0.1
 */