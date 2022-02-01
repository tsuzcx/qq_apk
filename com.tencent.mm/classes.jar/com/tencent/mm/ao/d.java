package com.tencent.mm.ao;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  extends n
  implements k
{
  public static long hbh;
  private static Map<String, a> hbi;
  private com.tencent.mm.al.g callback;
  private String hbj;
  private final b rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(150429);
    hbh = 0L;
    hbi = new HashMap();
    AppMethodBeat.o(150429);
  }
  
  protected d(int paramInt)
  {
    AppMethodBeat.i(150424);
    this.startTime = 0L;
    this.scene = 0;
    this.hbj = "";
    ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), bt.eGN() });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aqx();
    ((b.a)localObject).gUV = new aqy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((b.a)localObject).funcId = 379;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    this.scene = paramInt;
    localObject = (aqx)this.rr.gUS.gUX;
    ((aqx)localObject).DrE = "";
    ((aqx)localObject).Scene = paramInt;
    AppMethodBeat.o(150424);
  }
  
  private static CdnLogic.CdnInfoParams a(pv parampv)
  {
    AppMethodBeat.i(150427);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = parampv.COk;
    localCdnInfoParams.c2CrwtimeoutMs = parampv.COm;
    localCdnInfoParams.c2CshowErrorDelayMs = parampv.COi;
    localCdnInfoParams.snsretryIntervalMs = parampv.COl;
    localCdnInfoParams.snsrwtimeoutMs = parampv.COn;
    localCdnInfoParams.snsshowErrorDelayMs = parampv.COj;
    AppMethodBeat.o(150427);
    return localCdnInfoParams;
  }
  
  private static String awH()
  {
    AppMethodBeat.i(150426);
    if (!ay.isConnected(aj.getContext()))
    {
      AppMethodBeat.o(150426);
      return null;
    }
    if (ay.isWifi(aj.getContext())) {}
    for (String str = "wifi_" + ay.iA(aj.getContext());; str = "mobile_" + ay.getNetTypeString(aj.getContext()) + "_" + ay.getISPCode(aj.getContext()))
    {
      ad.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[] { str });
      if ((str != null) && (str.length() >= 2)) {
        break;
      }
      AppMethodBeat.o(150426);
      return null;
    }
    str = String.format("%x", new Object[] { Integer.valueOf(str.hashCode()) });
    StringBuilder localStringBuilder = new StringBuilder();
    f.awI();
    str = f.awJ() + str;
    AppMethodBeat.o(150426);
    return str;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150425);
    this.callback = paramg;
    com.tencent.mm.kernel.g.afz();
    int i = com.tencent.mm.kernel.a.getUin();
    if (i == 0)
    {
      ad.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(150425);
      return -1;
    }
    if (hbh != i)
    {
      hbh = i;
      hbi.clear();
    }
    long l = bt.aGK();
    a locala;
    if (this.scene == 0)
    {
      this.hbj = bt.by(awH(), "");
      locala = (a)hbi.get(this.hbj);
      paramg = locala;
      if (locala == null)
      {
        paramg = new a();
        hbi.put(this.hbj, paramg);
        ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { paramg, this.hbj });
      }
      if (paramg.hbk)
      {
        paramg.hbl = l;
        paramg.hbm = l;
        paramg.hbn = 0L;
      }
      ad.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - paramg.hbl), Long.valueOf(l - paramg.hbm), Long.valueOf(paramg.hbn) });
      if ((l > paramg.hbl) && (l - paramg.hbl < 10L))
      {
        ad.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramg.hbl), paramg });
        AppMethodBeat.o(150425);
        return -1;
      }
      if ((l > paramg.hbm) && (l - paramg.hbm < 3600L) && (paramg.hbn >= 90L))
      {
        ad.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramg.hbm), paramg });
        AppMethodBeat.o(150425);
        return -1;
      }
      paramg.hbl = l;
      if ((l < paramg.hbm) || (l - paramg.hbn > 3600L))
      {
        paramg.hbm = l;
        paramg.hbn = 0L;
        this.startTime = l;
        paramg = h.vKh;
        if (this.scene != 0) {
          break label577;
        }
      }
    }
    label577:
    for (l = 0L;; l = 1L)
    {
      paramg.idkeyStat(546L, l, 1L, true);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(150425);
      return i;
      paramg.hbn += 1L;
      break;
      this.hbj = "";
      paramg = hbi.values().iterator();
      if (paramg == null) {
        break;
      }
      while (paramg.hasNext())
      {
        locala = (a)paramg.next();
        if (locala != null)
        {
          locala.hbl = l;
          if ((l < locala.hbm) || (l - locala.hbn > 3600L))
          {
            locala.hbm = l;
            locala.hbn = 0L;
          }
          else
          {
            locala.hbn += 1L;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150428);
    ad.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    aqy localaqy = (aqy)((b)paramq).gUT.gUX;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localaqy.CGH == null))
    {
      h.vKh.f(10769, new Object[] { Integer.valueOf(c.hbg), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localaqy.CGH == null) {}
      for (bool = true;; bool = false)
      {
        ad.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(150428);
        return;
      }
    }
    paramq = awH();
    if ((!bt.isNullOrNil(paramq)) && (!bt.isNullOrNil(this.hbj)) && (!paramq.equals(this.hbj)))
    {
      ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { paramq, this.hbj });
      h.vKh.idkeyStat(546L, 6L, 1L, true);
    }
    hbi.clear();
    paramArrayOfByte = null;
    paramq = paramArrayOfByte;
    if (localaqy.CGK != null)
    {
      paramq = paramArrayOfByte;
      if (localaqy.CGK.getILen() > 0)
      {
        ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localaqy.CGK.getILen()) });
        paramq = z.a(localaqy.CGK);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localaqy.CGL != null)
    {
      paramArrayOfByte = localObject;
      if (localaqy.CGL.getILen() > 0)
      {
        ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localaqy.CGL.getILen()) });
        paramArrayOfByte = z.a(localaqy.CGL);
      }
    }
    ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localaqy.CGM });
    if (localaqy.CGM != null) {
      ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localaqy.CGM.oXh), localaqy.CGM.COu });
    }
    if (!f.awM().a(localaqy.CGH, localaqy.CGI, localaqy.CGJ, paramq, paramArrayOfByte, localaqy.CGM))
    {
      ad.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
    ad.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localaqy.CGO, localaqy.CGP, Integer.valueOf(localaqy.CGN) });
    if ((localaqy.CGO != null) && (localaqy.CGP != null)) {
      CdnLogic.setCdnInfoParams(a(localaqy.CGO), a(localaqy.CGP), localaqy.CGN);
    }
    if (localaqy.DrF == 1) {}
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
    boolean hbk = false;
    long hbl = 0L;
    long hbm = 0L;
    long hbn = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(150423);
      String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hbk), Long.valueOf(this.hbl), Long.valueOf(this.hbm), Long.valueOf(this.hbn) });
      AppMethodBeat.o(150423);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.d
 * JD-Core Version:    0.7.0.1
 */