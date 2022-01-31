package com.tencent.mm.bm;

import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mars.comm.PlatformComm.SIMInfo;
import com.tencent.mars.comm.PlatformComm.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a
  extends com.tencent.mm.ai.m
  implements k
{
  private f eGj;
  private com.tencent.mm.bv.b gfp;
  private int gfq;
  private int gfr;
  private int gfs;
  private int gft;
  private cfv gfu;
  private cfv gfv;
  private String gfw;
  private com.tencent.mm.ai.b rr;
  
  public a(com.tencent.mm.bv.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, cfv paramcfv1, cfv paramcfv2, String paramString)
  {
    AppMethodBeat.i(153483);
    this.rr = null;
    this.gfp = paramb;
    this.gfq = paramInt1;
    this.gfr = paramInt2;
    this.gfs = paramInt3;
    this.gft = paramInt4;
    this.gfu = paramcfv1;
    this.gfv = paramcfv2;
    this.gfw = paramString;
    paramb = new b.a();
    paramb.fsX = new cfx();
    paramb.fsY = new cfy();
    paramb.funcId = 271;
    paramb.uri = "/cgi-bin/micromsg-bin/speedtestreport";
    paramb.reqCmdId = 996;
    paramb.respCmdId = 1000000996;
    this.rr = paramb.ado();
    AppMethodBeat.o(153483);
  }
  
  private static String anN()
  {
    AppMethodBeat.i(153486);
    String str1 = "";
    String str2 = str1;
    label103:
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
            break label103;
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
        AppMethodBeat.o(153486);
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(153486);
        return str2;
      }
      return localException;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(153484);
    this.eGj = paramf;
    paramf = (cfx)this.rr.fsV.fta;
    paramf.xpR = this.gfp;
    paramf.xQC = this.gfq;
    paramf.xQD = this.gfr;
    paramf.xQE = this.gfs;
    paramf.xQF = this.gft;
    paramf.xQH = this.gfu;
    paramf.xQG = this.gfv;
    Object localObject;
    int i;
    if ("dual".equals(this.gfw))
    {
      localObject = paramf.xQG.ip;
      if ((localObject == null) || (((String)localObject).length() <= 0) || (((String)localObject).contains("."))) {
        break label527;
      }
      i = 1;
      if (i != 0)
      {
        paramf.xQH.ip = anN();
        ab.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + paramf.xQH.ip);
      }
    }
    switch (PlatformComm.C2Java.getNetInfo())
    {
    case 0: 
    default: 
      paramf.xQz = "NONET";
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.freewifi.m.bAj();
      StringBuilder localStringBuilder = new StringBuilder("device info:");
      localStringBuilder.append(((yi)localObject).deviceBrand);
      localStringBuilder.append(" ");
      localStringBuilder.append(((yi)localObject).deviceModel);
      localStringBuilder.append(" ");
      localStringBuilder.append(((yi)localObject).osName);
      localStringBuilder.append(" ");
      localStringBuilder.append(((yi)localObject).osVersion);
      paramf.xQB = localStringBuilder.toString();
      ab.d("MicroMsg.MMNewSpeedTest", "speed test " + paramf.xQB + ",networktype: " + paramf.xQz + ",network_info: " + paramf.xQA + ",conn_time: " + paramf.xQC + ",conn_retcode: " + paramf.xQD + ",trans_time: " + paramf.xQE + ",trans_time: " + paramf.xQF + ",cookie: " + paramf.xpR.toString() + ",cookie size: " + paramf.xpR.pW.length + ",size: " + paramf.computeSize() + ",client ip: " + paramf.xQH.ip + ",client port: " + paramf.xQH.port + ",server ip: " + paramf.xQG.ip + ",server port: " + paramf.xQG.port);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(153484);
      return i;
      label527:
      i = 0;
      break;
      paramf.xQz = "WIFI";
      paramf.xQA = PlatformComm.C2Java.getCurWifiInfo().ssid;
      continue;
      switch (PlatformComm.C2Java.getStatisticsNetType())
      {
      default: 
        paramf.xQz = "EDGE";
      }
      for (;;)
      {
        localObject = PlatformComm.C2Java.getCurSIMInfo();
        if (localObject == null) {
          break;
        }
        paramf.xQA = ((PlatformComm.SIMInfo)localObject).ispCode;
        break;
        paramf.xQz = "2G";
        continue;
        paramf.xQz = "3G";
        continue;
        paramf.xQz = "4G";
        continue;
        paramf.xQz = "EDGE";
      }
      paramf.xQz = "NONET";
    }
  }
  
  public final int getType()
  {
    return 271;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(153485);
    ab.d("MicroMsg.MMNewSpeedTest", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt3 == 0) && (paramInt2 == 0)) {
      h.qsU.cT(317, 26);
    }
    for (;;)
    {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(153485);
      return;
      h.qsU.cT(317, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bm.a
 * JD-Core Version:    0.7.0.1
 */