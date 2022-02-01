package com.tencent.mm.bn;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.mars.comm.PlatformComm.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.sdk.platformtools.ae;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends n
  implements k
{
  private f gCo;
  private com.tencent.mm.bw.b iJR;
  private int iJS;
  private int iJT;
  private int iJU;
  private int iJV;
  private dip iJW;
  private dip iJX;
  private String iJY;
  private com.tencent.mm.ak.b rr;
  
  public a(com.tencent.mm.bw.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, dip paramdip1, dip paramdip2, String paramString)
  {
    AppMethodBeat.i(20678);
    this.rr = null;
    this.iJR = paramb;
    this.iJS = paramInt1;
    this.iJT = paramInt2;
    this.iJU = paramInt3;
    this.iJV = paramInt4;
    this.iJW = paramdip1;
    this.iJX = paramdip2;
    this.iJY = paramString;
    paramb = new b.a();
    paramb.hQF = new dir();
    paramb.hQG = new dis();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.hQH = 996;
    paramb.respCmdId = 1000000996;
    paramb.newExtFlag = 0;
    paramb.transferHeader = null;
    this.rr = paramb.aDS();
    AppMethodBeat.o(20678);
  }
  
  private static String aPS()
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
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20679);
    this.gCo = paramf;
    paramf = (dir)this.rr.hQD.hQJ;
    paramf.Hjt = this.iJR;
    paramf.HQn = this.iJS;
    paramf.HQo = this.iJT;
    paramf.HQp = this.iJU;
    paramf.HQq = this.iJV;
    paramf.HQs = this.iJW;
    paramf.HQr = this.iJX;
    Object localObject;
    int i;
    if ("dual".equals(this.iJY))
    {
      localObject = paramf.HQr.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label529;
      }
      i = 1;
      if (i != 0)
      {
        paramf.HQs.ip = aPS();
        ae.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + paramf.HQs.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      paramf.HQk = "NONET";
    }
    for (;;)
    {
      localObject = m.cTD();
      StringBuilder localStringBuilder = new StringBuilder("device info:");
      localStringBuilder.append(((aey)localObject).deviceBrand);
      localStringBuilder.append(" ");
      localStringBuilder.append(((aey)localObject).deviceModel);
      localStringBuilder.append(" ");
      localStringBuilder.append(((aey)localObject).osName);
      localStringBuilder.append(" ");
      localStringBuilder.append(((aey)localObject).osVersion);
      paramf.HQm = localStringBuilder.toString();
      ae.d("MicroMsg.MMNewSpeedTest", "speed test " + paramf.HQm + ",networktype: " + paramf.HQk + ",network_info: " + paramf.HQl + ",conn_time: " + paramf.HQn + ",conn_retcode: " + paramf.HQo + ",trans_time: " + paramf.HQp + ",trans_time: " + paramf.HQq + ",cookie: " + paramf.Hjt.toString() + ",cookie size: " + paramf.Hjt.zr.length + ",size: " + paramf.computeSize() + ",client ip: " + paramf.HQs.ip + ",client port: " + paramf.HQs.port + ",server ip: " + paramf.HQr.ip + ",server port: " + paramf.HQr.port);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(20679);
      return i;
      label529:
      i = 0;
      break;
      paramf.HQk = "WIFI";
      localObject = PlatformComm.C2Java.getCurWifiInfo();
      if (localObject != null)
      {
        paramf.HQl = ((PlatformComm.WifiInfo)localObject).ssid;
      }
      else
      {
        paramf.HQl = "unknown_netinfo";
        continue;
        switch (PlatformComm.C2Java.getStatisticsNetType())
        {
        default: 
          paramf.HQk = "EDGE";
        }
        for (;;)
        {
          localObject = PlatformComm.C2Java.getCurSIMInfo();
          if (localObject == null) {
            break label677;
          }
          paramf.HQl = ((PlatformComm.SIMInfo)localObject).ispCode;
          break;
          paramf.HQk = "2G";
          continue;
          paramf.HQk = "3G";
          continue;
          paramf.HQk = "4G";
          continue;
          paramf.HQk = "EDGE";
        }
        label677:
        paramf.HQl = "unknown_netinfo";
        continue;
        paramf.HQk = "NONET";
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
    ae.d("MicroMsg.MMNewSpeedTest", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt3 == 0) && (paramInt2 == 0)) {
      g.yxI.dD(317, 26);
    }
    for (;;)
    {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20680);
      return;
      g.yxI.dD(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bn.a
 * JD-Core Version:    0.7.0.1
 */