package com.tencent.mm.aq;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
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
  public static long lIw;
  private static Map<String, a> lIx;
  private i callback;
  private String lIy;
  private final com.tencent.mm.an.d rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(150429);
    lIw = 0L;
    lIx = new HashMap();
    AppMethodBeat.o(150429);
  }
  
  protected d(int paramInt)
  {
    AppMethodBeat.i(150424);
    this.startTime = 0L;
    this.scene = 0;
    this.lIy = "";
    Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
    Object localObject = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject).lBU = new bri();
    ((com.tencent.mm.an.d.a)localObject).lBV = new brj();
    ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((com.tencent.mm.an.d.a)localObject).funcId = 379;
    ((com.tencent.mm.an.d.a)localObject).lBW = 0;
    ((com.tencent.mm.an.d.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.an.d.a)localObject).bgN();
    this.scene = paramInt;
    localObject = (bri)d.b.b(this.rr.lBR);
    ((bri)localObject).TbZ = "";
    ((bri)localObject).CPw = paramInt;
    AppMethodBeat.o(150424);
  }
  
  private static CdnLogic.CdnInfoParams a(td paramtd)
  {
    AppMethodBeat.i(150427);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramtd.Scq;
    localCdnInfoParams.c2CrwtimeoutMs = paramtd.Scs;
    localCdnInfoParams.c2CshowErrorDelayMs = paramtd.Sco;
    localCdnInfoParams.snsretryIntervalMs = paramtd.Scr;
    localCdnInfoParams.snsrwtimeoutMs = paramtd.Sct;
    localCdnInfoParams.snsshowErrorDelayMs = paramtd.Scp;
    AppMethodBeat.o(150427);
    return localCdnInfoParams;
  }
  
  private static String bkb()
  {
    AppMethodBeat.i(150426);
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(150426);
      return null;
    }
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {}
    for (String str = "wifi_" + ConnectivityCompat.Companion.getFormattedWiFiSsid();; str = "mobile_" + NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()) + "_" + NetStatusUtil.getISPCode(MMApplicationContext.getContext()))
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
    f.bkd();
    str = f.bke() + str;
    AppMethodBeat.o(150426);
    return str;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150425);
    this.callback = parami;
    com.tencent.mm.kernel.h.aHE();
    int i = b.getUin();
    if (i == 0)
    {
      Log.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(150425);
      return -1;
    }
    if (lIw != i)
    {
      lIw = i;
      lIx.clear();
    }
    long l = Util.nowSecond();
    a locala;
    if (this.scene == 0)
    {
      this.lIy = Util.nullAs(bkb(), "");
      locala = (a)lIx.get(this.lIy);
      parami = locala;
      if (locala == null)
      {
        parami = new a();
        lIx.put(this.lIy, parami);
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { parami, this.lIy });
      }
      if (parami.lIz)
      {
        parami.lIA = l;
        parami.lIB = l;
        parami.lIC = 0L;
      }
      Log.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - parami.lIA), Long.valueOf(l - parami.lIB), Long.valueOf(parami.lIC) });
      if ((l > parami.lIA) && (l - parami.lIA < 10L))
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - parami.lIA), parami });
        AppMethodBeat.o(150425);
        return -1;
      }
      if ((l > parami.lIB) && (l - parami.lIB < 3600L) && (parami.lIC >= 90L))
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - parami.lIB), parami });
        AppMethodBeat.o(150425);
        return -1;
      }
      parami.lIA = l;
      if ((l < parami.lIB) || (l - parami.lIC > 3600L))
      {
        parami.lIB = l;
        parami.lIC = 0L;
        this.startTime = l;
        parami = com.tencent.mm.plugin.report.service.h.IzE;
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
      parami.lIC += 1L;
      break;
      this.lIy = "";
      parami = lIx.values().iterator();
      if (parami == null) {
        break;
      }
      while (parami.hasNext())
      {
        locala = (a)parami.next();
        if (locala != null)
        {
          locala.lIA = l;
          if ((l < locala.lIB) || (l - locala.lIC > 3600L))
          {
            locala.lIB = l;
            locala.lIC = 0L;
          }
          else
          {
            locala.lIC += 1L;
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
    brj localbrj = (brj)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localbrj.RRI == null))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10769, new Object[] { Integer.valueOf(c.lIv), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localbrj.RRI == null) {}
      for (bool = true;; bool = false)
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(150428);
        return;
      }
    }
    params = bkb();
    if ((!Util.isNullOrNil(params)) && (!Util.isNullOrNil(this.lIy)) && (!params.equals(this.lIy)))
    {
      Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { params, this.lIy });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(546L, 6L, 1L, true);
    }
    lIx.clear();
    paramArrayOfByte = null;
    params = paramArrayOfByte;
    if (localbrj.RRL != null)
    {
      params = paramArrayOfByte;
      if (localbrj.RRL.Ufv > 0)
      {
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localbrj.RRL.Ufv) });
        params = z.a(localbrj.RRL);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localbrj.RRM != null)
    {
      paramArrayOfByte = localObject;
      if (localbrj.RRM.Ufv > 0)
      {
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localbrj.RRM.Ufv) });
        paramArrayOfByte = z.a(localbrj.RRM);
      }
    }
    Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localbrj.RRN });
    if (localbrj.RRN != null) {
      Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localbrj.RRN.vhf), localbrj.RRN.ScA });
    }
    if (!f.bkh().a(localbrj.RRI, localbrj.RRJ, localbrj.RRK, params, paramArrayOfByte, localbrj.RRN))
    {
      Log.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
    Log.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localbrj.RRP, localbrj.RRQ, Integer.valueOf(localbrj.RRO) });
    if ((localbrj.RRP != null) && (localbrj.RRQ != null)) {
      CdnLogic.setCdnInfoParams(a(localbrj.RRP), a(localbrj.RRQ), localbrj.RRO);
    }
    if (localbrj.Tca == 1) {}
    for (boolean bool = true;; bool = false)
    {
      CdnLogic.setUseIPv6Cdn(bool);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
  }
  
  static final class a
  {
    long lIA = 0L;
    long lIB = 0L;
    long lIC = 0L;
    boolean lIz = false;
    
    public final String toString()
    {
      AppMethodBeat.i(150423);
      String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.lIz), Long.valueOf(this.lIA), Long.valueOf(this.lIB), Long.valueOf(this.lIC) });
      AppMethodBeat.o(150423);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.d
 * JD-Core Version:    0.7.0.1
 */