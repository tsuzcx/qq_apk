package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.protocal.protobuf.uu;
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

public final class i
  extends p
  implements m
{
  public static long oAW;
  private static Map<String, i.a> oAX;
  private com.tencent.mm.am.h callback;
  private String oAY;
  private final c rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(150429);
    oAW = 0L;
    oAX = new HashMap();
    AppMethodBeat.o(150429);
  }
  
  protected i(int paramInt)
  {
    AppMethodBeat.i(150424);
    this.startTime = 0L;
    this.scene = 0;
    this.oAY = "";
    Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cfz();
    ((c.a)localObject).otF = new cga();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((c.a)localObject).funcId = 379;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.scene = paramInt;
    localObject = (cfz)c.b.b(this.rr.otB);
    ((cfz)localObject).aapl = "";
    ((cfz)localObject).IJG = paramInt;
    AppMethodBeat.o(150424);
  }
  
  private static CdnLogic.CdnInfoParams a(ut paramut)
  {
    AppMethodBeat.i(150427);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramut.Zai;
    localCdnInfoParams.c2CrwtimeoutMs = paramut.Zak;
    localCdnInfoParams.c2CshowErrorDelayMs = paramut.Zag;
    localCdnInfoParams.snsretryIntervalMs = paramut.Zaj;
    localCdnInfoParams.snsrwtimeoutMs = paramut.Zal;
    localCdnInfoParams.snsshowErrorDelayMs = paramut.Zah;
    AppMethodBeat.o(150427);
    return localCdnInfoParams;
  }
  
  private static String bHR()
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
    k.bHT();
    str = k.bHU() + str;
    AppMethodBeat.o(150426);
    return str;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150425);
    this.callback = paramh;
    com.tencent.mm.kernel.h.baC();
    int i = b.getUin();
    if (i == 0)
    {
      Log.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(150425);
      return -1;
    }
    if (oAW != i)
    {
      oAW = i;
      oAX.clear();
    }
    long l = Util.nowSecond();
    i.a locala;
    if (this.scene == 0)
    {
      this.oAY = Util.nullAs(bHR(), "");
      locala = (i.a)oAX.get(this.oAY);
      paramh = locala;
      if (locala == null)
      {
        paramh = new i.a();
        oAX.put(this.oAY, paramh);
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { paramh, this.oAY });
      }
      if (paramh.oAZ)
      {
        paramh.oBa = l;
        paramh.oBb = l;
        paramh.oBc = 0L;
      }
      Log.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - paramh.oBa), Long.valueOf(l - paramh.oBb), Long.valueOf(paramh.oBc) });
      if ((l > paramh.oBa) && (l - paramh.oBa < 10L))
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramh.oBa), paramh });
        AppMethodBeat.o(150425);
        return -1;
      }
      if ((l > paramh.oBb) && (l - paramh.oBb < 3600L) && (paramh.oBc >= 90L))
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramh.oBb), paramh });
        AppMethodBeat.o(150425);
        return -1;
      }
      paramh.oBa = l;
      if ((l < paramh.oBb) || (l - paramh.oBc > 3600L))
      {
        paramh.oBb = l;
        paramh.oBc = 0L;
        this.startTime = l;
        paramh = com.tencent.mm.plugin.report.service.h.OAn;
        if (this.scene != 0) {
          break label577;
        }
      }
    }
    label577:
    for (l = 0L;; l = 1L)
    {
      paramh.idkeyStat(546L, l, 1L, true);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(150425);
      return i;
      paramh.oBc += 1L;
      break;
      this.oAY = "";
      paramh = oAX.values().iterator();
      if (paramh == null) {
        break;
      }
      while (paramh.hasNext())
      {
        locala = (i.a)paramh.next();
        if (locala != null)
        {
          locala.oBa = l;
          if ((l < locala.oBb) || (l - locala.oBc > 3600L))
          {
            locala.oBb = l;
            locala.oBc = 0L;
          }
          else
          {
            locala.oBc += 1L;
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
    cga localcga = (cga)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localcga.YPa == null))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(10769, new Object[] { Integer.valueOf(h.oAU), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localcga.YPa == null) {}
      for (bool = true;; bool = false)
      {
        Log.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(150428);
        return;
      }
    }
    params = bHR();
    if ((!Util.isNullOrNil(params)) && (!Util.isNullOrNil(this.oAY)) && (!params.equals(this.oAY)))
    {
      Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { params, this.oAY });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(546L, 6L, 1L, true);
    }
    oAX.clear();
    paramArrayOfByte = null;
    params = paramArrayOfByte;
    if (localcga.YPd != null)
    {
      params = paramArrayOfByte;
      if (localcga.YPd.abwJ > 0)
      {
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localcga.YPd.abwJ) });
        params = w.a(localcga.YPd);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localcga.YPe != null)
    {
      paramArrayOfByte = localObject;
      if (localcga.YPe.abwJ > 0)
      {
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localcga.YPe.abwJ) });
        paramArrayOfByte = w.a(localcga.YPe);
      }
    }
    Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localcga.YPf });
    if (localcga.YPf != null) {
      Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localcga.YPf.yth), localcga.YPf.Zas });
    }
    if (!k.bHX().a(localcga.YPa, localcga.YPb, localcga.YPc, params, paramArrayOfByte, localcga.YPf))
    {
      Log.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
    Log.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localcga.YPh, localcga.YPi, Integer.valueOf(localcga.YPg) });
    if ((localcga.YPh != null) && (localcga.YPi != null)) {
      CdnLogic.setCdnInfoParams(a(localcga.YPh), a(localcga.YPi), localcga.YPg);
    }
    if (localcga.aapm == 1) {}
    for (boolean bool = true;; bool = false)
    {
      CdnLogic.setUseIPv6Cdn(bool);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.i
 * JD-Core Version:    0.7.0.1
 */