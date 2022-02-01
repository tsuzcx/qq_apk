package com.tencent.mm.bo;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.mars.comm.PlatformComm.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.ad;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends n
  implements k
{
  private g gbr;
  private com.tencent.mm.bx.b hNk;
  private int hNl;
  private int hNm;
  private int hNn;
  private int hNo;
  private cwv hNp;
  private cwv hNq;
  private String hNr;
  private com.tencent.mm.al.b rr;
  
  public a(com.tencent.mm.bx.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, cwv paramcwv1, cwv paramcwv2, String paramString)
  {
    AppMethodBeat.i(20678);
    this.rr = null;
    this.hNk = paramb;
    this.hNl = paramInt1;
    this.hNm = paramInt2;
    this.hNn = paramInt3;
    this.hNo = paramInt4;
    this.hNp = paramcwv1;
    this.hNq = paramcwv2;
    this.hNr = paramString;
    paramb = new b.a();
    paramb.gUU = new cwx();
    paramb.gUV = new cwy();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.reqCmdId = 996;
    paramb.respCmdId = 1000000996;
    this.rr = paramb.atI();
    AppMethodBeat.o(20678);
  }
  
  private static String aFv()
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
    this.gbr = paramg;
    paramg = (cwx)this.rr.gUS.gUX;
    paramg.DKa = this.hNk;
    paramg.EoX = this.hNl;
    paramg.EoY = this.hNm;
    paramg.EoZ = this.hNn;
    paramg.Epa = this.hNo;
    paramg.Epc = this.hNp;
    paramg.Epb = this.hNq;
    Object localObject;
    int i;
    if ("dual".equals(this.hNr))
    {
      localObject = paramg.Epb.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label527;
      }
      i = 1;
      if (i != 0)
      {
        paramg.Epc.ip = aFv();
        ad.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + paramg.Epc.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      paramg.EoU = "NONET";
    }
    for (;;)
    {
      localObject = m.cvx();
      StringBuilder localStringBuilder = new StringBuilder("device info:");
      localStringBuilder.append(((abq)localObject).deviceBrand);
      localStringBuilder.append(" ");
      localStringBuilder.append(((abq)localObject).deviceModel);
      localStringBuilder.append(" ");
      localStringBuilder.append(((abq)localObject).osName);
      localStringBuilder.append(" ");
      localStringBuilder.append(((abq)localObject).osVersion);
      paramg.EoW = localStringBuilder.toString();
      ad.d("MicroMsg.MMNewSpeedTest", "speed test " + paramg.EoW + ",networktype: " + paramg.EoU + ",network_info: " + paramg.EoV + ",conn_time: " + paramg.EoX + ",conn_retcode: " + paramg.EoY + ",trans_time: " + paramg.EoZ + ",trans_time: " + paramg.Epa + ",cookie: " + paramg.DKa.toString() + ",cookie size: " + paramg.DKa.wA.length + ",size: " + paramg.computeSize() + ",client ip: " + paramg.Epc.ip + ",client port: " + paramg.Epc.port + ",server ip: " + paramg.Epb.ip + ",server port: " + paramg.Epb.port);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(20679);
      return i;
      label527:
      i = 0;
      break;
      paramg.EoU = "WIFI";
      localObject = PlatformComm.C2Java.getCurWifiInfo();
      if (localObject != null)
      {
        paramg.EoV = ((PlatformComm.WifiInfo)localObject).ssid;
      }
      else
      {
        paramg.EoV = "unknown_netinfo";
        continue;
        switch (PlatformComm.C2Java.getStatisticsNetType())
        {
        default: 
          paramg.EoU = "EDGE";
        }
        for (;;)
        {
          localObject = PlatformComm.C2Java.getCurSIMInfo();
          if (localObject == null) {
            break label673;
          }
          paramg.EoV = ((PlatformComm.SIMInfo)localObject).ispCode;
          break;
          paramg.EoU = "2G";
          continue;
          paramg.EoU = "3G";
          continue;
          paramg.EoU = "4G";
          continue;
          paramg.EoU = "EDGE";
        }
        label673:
        paramg.EoV = "unknown_netinfo";
        continue;
        paramg.EoU = "NONET";
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
    ad.d("MicroMsg.MMNewSpeedTest", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt3 == 0) && (paramInt2 == 0)) {
      h.vKh.dB(317, 26);
    }
    for (;;)
    {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20680);
      return;
      h.vKh.dB(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bo.a
 * JD-Core Version:    0.7.0.1
 */