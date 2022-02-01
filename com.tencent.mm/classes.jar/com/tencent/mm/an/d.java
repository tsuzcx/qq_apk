package com.tencent.mm.an;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  extends q
  implements m
{
  public static long iSe;
  private static Map<String, d.a> iSf;
  private i callback;
  private String iSg;
  private final com.tencent.mm.ak.d rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(150429);
    iSe = 0L;
    iSf = new HashMap();
    AppMethodBeat.o(150429);
  }
  
  protected d(int paramInt)
  {
    AppMethodBeat.i(150424);
    this.startTime = 0L;
    this.scene = 0;
    this.iSg = "";
    Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
    Object localObject = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject).iLN = new bjz();
    ((com.tencent.mm.ak.d.a)localObject).iLO = new bka();
    ((com.tencent.mm.ak.d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((com.tencent.mm.ak.d.a)localObject).funcId = 379;
    ((com.tencent.mm.ak.d.a)localObject).iLP = 0;
    ((com.tencent.mm.ak.d.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.ak.d.a)localObject).aXF();
    this.scene = paramInt;
    localObject = (bjz)this.rr.iLK.iLR;
    ((bjz)localObject).LTp = "";
    ((bjz)localObject).Scene = paramInt;
    AppMethodBeat.o(150424);
  }
  
  private static CdnLogic.CdnInfoParams a(tb paramtb)
  {
    AppMethodBeat.i(150427);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramtb.Lbe;
    localCdnInfoParams.c2CrwtimeoutMs = paramtb.Lbg;
    localCdnInfoParams.c2CshowErrorDelayMs = paramtb.Lbc;
    localCdnInfoParams.snsretryIntervalMs = paramtb.Lbf;
    localCdnInfoParams.snsrwtimeoutMs = paramtb.Lbh;
    localCdnInfoParams.snsshowErrorDelayMs = paramtb.Lbd;
    AppMethodBeat.o(150427);
    return localCdnInfoParams;
  }
  
  private static String baM()
  {
    AppMethodBeat.i(150426);
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(150426);
      return null;
    }
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (String str = "wifi_" + NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());; str = "mobile_" + NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()) + "_" + NetStatusUtil.getISPCode(MMApplicationContext.getContext()))
    {
      Log.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[] { str });
      if ((str != null) && (str.length() >= 2)) {
        break;
      }
      AppMethodBeat.o(150426);
      return null;
    }
    str = String.format("%x", new Object[] { Integer.valueOf(str.hashCode()) });
    StringBuilder localStringBuilder = new StringBuilder();
    f.baN();
    str = f.baO() + str;
    AppMethodBeat.o(150426);
    return str;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150425);
    this.callback = parami;
    com.tencent.mm.kernel.g.aAf();
    int i = com.tencent.mm.kernel.a.getUin();
    if (i == 0)
    {
      Log.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(150425);
      return -1;
    }
    if (iSe != i)
    {
      iSe = i;
      iSf.clear();
    }
    long l = Util.nowSecond();
    d.a locala;
    if (this.scene == 0)
    {
      this.iSg = Util.nullAs(baM(), "");
      locala = (d.a)iSf.get(this.iSg);
      parami = locala;
      if (locala == null)
      {
        parami = new d.a();
        iSf.put(this.iSg, parami);
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { parami, this.iSg });
      }
      if (parami.iSh)
      {
        parami.iSi = l;
        parami.iSj = l;
        parami.iSk = 0L;
      }
      Log.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - parami.iSi), Long.valueOf(l - parami.iSj), Long.valueOf(parami.iSk) });
      if ((l > parami.iSi) && (l - parami.iSi < 10L))
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - parami.iSi), parami });
        AppMethodBeat.o(150425);
        return -1;
      }
      if ((l > parami.iSj) && (l - parami.iSj < 3600L) && (parami.iSk >= 90L))
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - parami.iSj), parami });
        AppMethodBeat.o(150425);
        return -1;
      }
      parami.iSi = l;
      if ((l < parami.iSj) || (l - parami.iSk > 3600L))
      {
        parami.iSj = l;
        parami.iSk = 0L;
        this.startTime = l;
        parami = h.CyF;
        if (this.scene != 0) {
          break label577;
        }
      }
    }
    label577:
    for (l = 0L;; l = 1L)
    {
      parami.idkeyStat(546L, l, 1L, true);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(150425);
      return i;
      parami.iSk += 1L;
      break;
      this.iSg = "";
      parami = iSf.values().iterator();
      if (parami == null) {
        break;
      }
      while (parami.hasNext())
      {
        locala = (d.a)parami.next();
        if (locala != null)
        {
          locala.iSi = l;
          if ((l < locala.iSj) || (l - locala.iSk > 3600L))
          {
            locala.iSj = l;
            locala.iSk = 0L;
          }
          else
          {
            locala.iSk += 1L;
          }
        }
      }
      break;
    }
  }
  
  public final int getType()
  {
    return 379;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150428);
    Log.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    bka localbka = (bka)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localbka.KQK == null))
    {
      h.CyF.a(10769, new Object[] { Integer.valueOf(c.iSd), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localbka.KQK == null) {}
      for (bool = true;; bool = false)
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(150428);
        return;
      }
    }
    params = baM();
    if ((!Util.isNullOrNil(params)) && (!Util.isNullOrNil(this.iSg)) && (!params.equals(this.iSg)))
    {
      Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { params, this.iSg });
      h.CyF.idkeyStat(546L, 6L, 1L, true);
    }
    iSf.clear();
    paramArrayOfByte = null;
    params = paramArrayOfByte;
    if (localbka.KQN != null)
    {
      params = paramArrayOfByte;
      if (localbka.KQN.getILen() > 0)
      {
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localbka.KQN.getILen()) });
        params = z.a(localbka.KQN);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localbka.KQO != null)
    {
      paramArrayOfByte = localObject;
      if (localbka.KQO.getILen() > 0)
      {
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localbka.KQO.getILen()) });
        paramArrayOfByte = z.a(localbka.KQO);
      }
    }
    Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localbka.KQP });
    if (localbka.KQP != null) {
      Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localbka.KQP.rBx), localbka.KQP.Lbo });
    }
    if (!f.baR().a(localbka.KQK, localbka.KQL, localbka.KQM, params, paramArrayOfByte, localbka.KQP))
    {
      Log.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
    Log.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localbka.KQR, localbka.KQS, Integer.valueOf(localbka.KQQ) });
    if ((localbka.KQR != null) && (localbka.KQS != null)) {
      CdnLogic.setCdnInfoParams(a(localbka.KQR), a(localbka.KQS), localbka.KQQ);
    }
    if (localbka.LTq == 1) {}
    for (boolean bool = true;; bool = false)
    {
      CdnLogic.setUseIPv6Cdn(bool);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.an.d
 * JD-Core Version:    0.7.0.1
 */