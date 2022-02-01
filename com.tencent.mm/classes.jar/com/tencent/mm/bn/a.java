package com.tencent.mm.bn;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.mars.comm.PlatformComm.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ebz;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends q
  implements com.tencent.mm.network.m
{
  private i heq;
  private int jGA;
  private int jGB;
  private ebz jGC;
  private ebz jGD;
  private String jGE;
  private b jGx;
  private int jGy;
  private int jGz;
  private d rr;
  
  public a(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ebz paramebz1, ebz paramebz2, String paramString)
  {
    AppMethodBeat.i(20678);
    this.rr = null;
    this.jGx = paramb;
    this.jGy = paramInt1;
    this.jGz = paramInt2;
    this.jGA = paramInt3;
    this.jGB = paramInt4;
    this.jGC = paramebz1;
    this.jGD = paramebz2;
    this.jGE = paramString;
    paramb = new d.a();
    paramb.iLN = new ecb();
    paramb.iLO = new ecc();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.iLP = 996;
    paramb.respCmdId = 1000000996;
    paramb.newExtFlag = 0;
    paramb.transferHeader = null;
    this.rr = paramb.aXF();
    AppMethodBeat.o(20678);
  }
  
  private static String bku()
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
    this.heq = parami;
    parami = (ecb)this.rr.iLK.iLR;
    parami.Mpw = this.jGx;
    parami.Ncf = this.jGy;
    parami.Ncg = this.jGz;
    parami.Nch = this.jGA;
    parami.Nci = this.jGB;
    parami.Nck = this.jGC;
    parami.Ncj = this.jGD;
    Object localObject;
    int i;
    if ("dual".equals(this.jGE))
    {
      localObject = parami.Ncj.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label529;
      }
      i = 1;
      if (i != 0)
      {
        parami.Nck.ip = bku();
        Log.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + parami.Nck.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      parami.Ncc = "NONET";
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.freewifi.m.dMM();
      StringBuilder localStringBuilder = new StringBuilder("device info:");
      localStringBuilder.append(((ahc)localObject).deviceBrand);
      localStringBuilder.append(" ");
      localStringBuilder.append(((ahc)localObject).deviceModel);
      localStringBuilder.append(" ");
      localStringBuilder.append(((ahc)localObject).osName);
      localStringBuilder.append(" ");
      localStringBuilder.append(((ahc)localObject).osVersion);
      parami.Nce = localStringBuilder.toString();
      Log.d("MicroMsg.MMNewSpeedTest", "speed test " + parami.Nce + ",networktype: " + parami.Ncc + ",network_info: " + parami.Ncd + ",conn_time: " + parami.Ncf + ",conn_retcode: " + parami.Ncg + ",trans_time: " + parami.Nch + ",trans_time: " + parami.Nci + ",cookie: " + parami.Mpw.toString() + ",cookie size: " + parami.Mpw.zy.length + ",size: " + parami.computeSize() + ",client ip: " + parami.Nck.ip + ",client port: " + parami.Nck.port + ",server ip: " + parami.Ncj.ip + ",server port: " + parami.Ncj.port);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(20679);
      return i;
      label529:
      i = 0;
      break;
      parami.Ncc = "WIFI";
      localObject = PlatformComm.C2Java.getCurWifiInfo();
      if (localObject != null)
      {
        parami.Ncd = ((PlatformComm.WifiInfo)localObject).ssid;
      }
      else
      {
        parami.Ncd = "unknown_netinfo";
        continue;
        switch (PlatformComm.C2Java.getStatisticsNetType())
        {
        default: 
          parami.Ncc = "EDGE";
        }
        for (;;)
        {
          localObject = PlatformComm.C2Java.getCurSIMInfo();
          if (localObject == null) {
            break label677;
          }
          parami.Ncd = ((PlatformComm.SIMInfo)localObject).ispCode;
          break;
          parami.Ncc = "2G";
          continue;
          parami.Ncc = "3G";
          continue;
          parami.Ncc = "4G";
          continue;
          parami.Ncc = "EDGE";
        }
        label677:
        parami.Ncd = "unknown_netinfo";
        continue;
        parami.Ncc = "NONET";
      }
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
      h.CyF.dN(317, 26);
    }
    for (;;)
    {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20680);
      return;
      h.CyF.dN(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bn.a
 * JD-Core Version:    0.7.0.1
 */