package com.tencent.mm.bi;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.fgt;
import com.tencent.mm.protocal.protobuf.fgw;
import com.tencent.mm.protocal.protobuf.fgx;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends p
  implements m
{
  private com.tencent.mm.am.h mAY;
  private int pqA;
  private int pqB;
  private int pqC;
  private int pqD;
  private fgt pqE;
  private fgt pqF;
  private String pqG;
  private b pqz;
  private c rr;
  
  public a(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, fgt paramfgt1, fgt paramfgt2, String paramString)
  {
    AppMethodBeat.i(20678);
    this.rr = null;
    this.pqz = paramb;
    this.pqA = paramInt1;
    this.pqB = paramInt2;
    this.pqC = paramInt3;
    this.pqD = paramInt4;
    this.pqE = paramfgt1;
    this.pqF = paramfgt2;
    this.pqG = paramString;
    paramb = new c.a();
    paramb.otE = new fgw();
    paramb.otF = new fgx();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.otG = 996;
    paramb.respCmdId = 1000000996;
    paramb.newExtFlag = 0;
    paramb.transferHeader = null;
    this.rr = paramb.bEF();
    AppMethodBeat.o(20678);
  }
  
  private static String bRG()
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(20679);
    this.mAY = paramh;
    paramh = (fgw)c.b.b(this.rr.otB);
    paramh.aaPP = this.pqz;
    paramh.abHf = this.pqA;
    paramh.abHg = this.pqB;
    paramh.abHh = this.pqC;
    paramh.abHi = this.pqD;
    paramh.abHk = this.pqE;
    paramh.abHj = this.pqF;
    Object localObject;
    int i;
    if ("dual".equals(this.pqG))
    {
      localObject = paramh.abHj.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label515;
      }
      i = 1;
      if (i != 0)
      {
        paramh.abHk.ip = bRG();
        Log.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + paramh.abHk.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      paramh.abHc = "NONET";
    }
    for (;;)
    {
      localObject = new StringBuilder("device info:");
      ((StringBuilder)localObject).append(d.Yxa);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(d.Yxb);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(d.Yxd);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(d.Yxe);
      paramh.abHe = ((StringBuilder)localObject).toString();
      Log.d("MicroMsg.MMNewSpeedTest", "speed test " + paramh.abHe + ",networktype: " + paramh.abHc + ",network_info: " + paramh.abHd + ",conn_time: " + paramh.abHf + ",conn_retcode: " + paramh.abHg + ",trans_time: " + paramh.abHh + ",trans_time: " + paramh.abHi + ",cookie: " + paramh.aaPP.toString() + ",cookie size: " + paramh.aaPP.Op.length + ",size: " + paramh.computeSize() + ",client ip: " + paramh.abHk.ip + ",client port: " + paramh.abHk.port + ",server ip: " + paramh.abHj.ip + ",server port: " + paramh.abHj.port);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(20679);
      return i;
      label515:
      i = 0;
      break;
      paramh.abHc = "WIFI";
      paramh.abHd = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      continue;
      switch (PlatformComm.C2Java.getStatisticsNetType())
      {
      default: 
        paramh.abHc = "EDGE";
      }
      for (;;)
      {
        localObject = PlatformComm.C2Java.getCurSIMInfo();
        if (localObject == null) {
          break label641;
        }
        paramh.abHd = ((PlatformComm.SIMInfo)localObject).ispCode;
        break;
        paramh.abHc = "2G";
        continue;
        paramh.abHc = "3G";
        continue;
        paramh.abHc = "4G";
        continue;
        paramh.abHc = "EDGE";
      }
      label641:
      paramh.abHd = "unknown_netinfo";
      continue;
      paramh.abHc = "NONET";
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
      com.tencent.mm.plugin.report.service.h.OAn.kJ(317, 26);
    }
    for (;;)
    {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20680);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.kJ(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bi.a
 * JD-Core Version:    0.7.0.1
 */