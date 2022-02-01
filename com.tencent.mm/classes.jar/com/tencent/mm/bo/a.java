package com.tencent.mm.bo;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.mars.comm.PlatformComm.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.ad;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends n
  implements k
{
  private f gzH;
  private com.tencent.mm.bx.b iGY;
  private int iGZ;
  private int iHa;
  private int iHb;
  private int iHc;
  private dhu iHd;
  private dhu iHe;
  private String iHf;
  private com.tencent.mm.al.b rr;
  
  public a(com.tencent.mm.bx.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, dhu paramdhu1, dhu paramdhu2, String paramString)
  {
    AppMethodBeat.i(20678);
    this.rr = null;
    this.iGY = paramb;
    this.iGZ = paramInt1;
    this.iHa = paramInt2;
    this.iHb = paramInt3;
    this.iHc = paramInt4;
    this.iHd = paramdhu1;
    this.iHe = paramdhu2;
    this.iHf = paramString;
    paramb = new b.a();
    paramb.hNM = new dhw();
    paramb.hNN = new dhx();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.hNO = 996;
    paramb.respCmdId = 1000000996;
    paramb.newExtFlag = 0;
    paramb.transferHeader = null;
    this.rr = paramb.aDC();
    AppMethodBeat.o(20678);
  }
  
  private static String aPu()
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
    this.gzH = paramf;
    paramf = (dhw)this.rr.hNK.hNQ;
    paramf.GPR = this.iGY;
    paramf.HwE = this.iGZ;
    paramf.HwF = this.iHa;
    paramf.HwG = this.iHb;
    paramf.HwH = this.iHc;
    paramf.HwJ = this.iHd;
    paramf.HwI = this.iHe;
    Object localObject;
    int i;
    if ("dual".equals(this.iHf))
    {
      localObject = paramf.HwI.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label529;
      }
      i = 1;
      if (i != 0)
      {
        paramf.HwJ.ip = aPu();
        ad.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + paramf.HwJ.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      paramf.HwB = "NONET";
    }
    for (;;)
    {
      localObject = m.cQY();
      StringBuilder localStringBuilder = new StringBuilder("device info:");
      localStringBuilder.append(((aep)localObject).deviceBrand);
      localStringBuilder.append(" ");
      localStringBuilder.append(((aep)localObject).deviceModel);
      localStringBuilder.append(" ");
      localStringBuilder.append(((aep)localObject).osName);
      localStringBuilder.append(" ");
      localStringBuilder.append(((aep)localObject).osVersion);
      paramf.HwD = localStringBuilder.toString();
      ad.d("MicroMsg.MMNewSpeedTest", "speed test " + paramf.HwD + ",networktype: " + paramf.HwB + ",network_info: " + paramf.HwC + ",conn_time: " + paramf.HwE + ",conn_retcode: " + paramf.HwF + ",trans_time: " + paramf.HwG + ",trans_time: " + paramf.HwH + ",cookie: " + paramf.GPR.toString() + ",cookie size: " + paramf.GPR.zr.length + ",size: " + paramf.computeSize() + ",client ip: " + paramf.HwJ.ip + ",client port: " + paramf.HwJ.port + ",server ip: " + paramf.HwI.ip + ",server port: " + paramf.HwI.port);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(20679);
      return i;
      label529:
      i = 0;
      break;
      paramf.HwB = "WIFI";
      localObject = PlatformComm.C2Java.getCurWifiInfo();
      if (localObject != null)
      {
        paramf.HwC = ((PlatformComm.WifiInfo)localObject).ssid;
      }
      else
      {
        paramf.HwC = "unknown_netinfo";
        continue;
        switch (PlatformComm.C2Java.getStatisticsNetType())
        {
        default: 
          paramf.HwB = "EDGE";
        }
        for (;;)
        {
          localObject = PlatformComm.C2Java.getCurSIMInfo();
          if (localObject == null) {
            break label677;
          }
          paramf.HwC = ((PlatformComm.SIMInfo)localObject).ispCode;
          break;
          paramf.HwB = "2G";
          continue;
          paramf.HwB = "3G";
          continue;
          paramf.HwB = "4G";
          continue;
          paramf.HwB = "EDGE";
        }
        label677:
        paramf.HwC = "unknown_netinfo";
        continue;
        paramf.HwB = "NONET";
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
      g.yhR.dD(317, 26);
    }
    for (;;)
    {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20680);
      return;
      g.yhR.dD(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bo.a
 * JD-Core Version:    0.7.0.1
 */