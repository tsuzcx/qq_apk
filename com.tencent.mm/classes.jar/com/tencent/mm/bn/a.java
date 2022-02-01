package com.tencent.mm.bn;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.mars.comm.PlatformComm.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.sdk.platformtools.ac;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends n
  implements k
{
  private g gfX;
  private com.tencent.mm.bw.b inG;
  private int inH;
  private int inI;
  private int inJ;
  private int inK;
  private dch inL;
  private dch inM;
  private String inN;
  private com.tencent.mm.ak.b rr;
  
  public a(com.tencent.mm.bw.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, dch paramdch1, dch paramdch2, String paramString)
  {
    AppMethodBeat.i(20678);
    this.rr = null;
    this.inG = paramb;
    this.inH = paramInt1;
    this.inI = paramInt2;
    this.inJ = paramInt3;
    this.inK = paramInt4;
    this.inL = paramdch1;
    this.inM = paramdch2;
    this.inN = paramString;
    paramb = new b.a();
    paramb.hvt = new dcj();
    paramb.hvu = new dck();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.reqCmdId = 996;
    paramb.respCmdId = 1000000996;
    this.rr = paramb.aAz();
    AppMethodBeat.o(20678);
  }
  
  private static String aMm()
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
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20679);
    this.gfX = paramg;
    paramg = (dcj)this.rr.hvr.hvw;
    paramg.Fgp = this.inG;
    paramg.FLW = this.inH;
    paramg.FLX = this.inI;
    paramg.FLY = this.inJ;
    paramg.FLZ = this.inK;
    paramg.FMb = this.inL;
    paramg.FMa = this.inM;
    Object localObject;
    int i;
    if ("dual".equals(this.inN))
    {
      localObject = paramg.FMa.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label527;
      }
      i = 1;
      if (i != 0)
      {
        paramg.FMb.ip = aMm();
        ac.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + paramg.FMb.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      paramg.FLT = "NONET";
    }
    for (;;)
    {
      localObject = m.cIJ();
      StringBuilder localStringBuilder = new StringBuilder("device info:");
      localStringBuilder.append(((acp)localObject).deviceBrand);
      localStringBuilder.append(" ");
      localStringBuilder.append(((acp)localObject).deviceModel);
      localStringBuilder.append(" ");
      localStringBuilder.append(((acp)localObject).osName);
      localStringBuilder.append(" ");
      localStringBuilder.append(((acp)localObject).osVersion);
      paramg.FLV = localStringBuilder.toString();
      ac.d("MicroMsg.MMNewSpeedTest", "speed test " + paramg.FLV + ",networktype: " + paramg.FLT + ",network_info: " + paramg.FLU + ",conn_time: " + paramg.FLW + ",conn_retcode: " + paramg.FLX + ",trans_time: " + paramg.FLY + ",trans_time: " + paramg.FLZ + ",cookie: " + paramg.Fgp.toString() + ",cookie size: " + paramg.Fgp.xy.length + ",size: " + paramg.computeSize() + ",client ip: " + paramg.FMb.ip + ",client port: " + paramg.FMb.port + ",server ip: " + paramg.FMa.ip + ",server port: " + paramg.FMa.port);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(20679);
      return i;
      label527:
      i = 0;
      break;
      paramg.FLT = "WIFI";
      localObject = PlatformComm.C2Java.getCurWifiInfo();
      if (localObject != null)
      {
        paramg.FLU = ((PlatformComm.WifiInfo)localObject).ssid;
      }
      else
      {
        paramg.FLU = "unknown_netinfo";
        continue;
        switch (PlatformComm.C2Java.getStatisticsNetType())
        {
        default: 
          paramg.FLT = "EDGE";
        }
        for (;;)
        {
          localObject = PlatformComm.C2Java.getCurSIMInfo();
          if (localObject == null) {
            break label673;
          }
          paramg.FLU = ((PlatformComm.SIMInfo)localObject).ispCode;
          break;
          paramg.FLT = "2G";
          continue;
          paramg.FLT = "3G";
          continue;
          paramg.FLT = "4G";
          continue;
          paramg.FLT = "EDGE";
        }
        label673:
        paramg.FLU = "unknown_netinfo";
        continue;
        paramg.FLT = "NONET";
      }
    }
  }
  
  public final int getType()
  {
    return 271;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20680);
    ac.d("MicroMsg.MMNewSpeedTest", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt3 == 0) && (paramInt2 == 0)) {
      h.wUl.dB(317, 26);
    }
    for (;;)
    {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20680);
      return;
      h.wUl.dB(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bn.a
 * JD-Core Version:    0.7.0.1
 */