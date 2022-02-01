package com.tencent.mm.an;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  extends n
  implements k
{
  public static long hXg;
  private static Map<String, a> hXh;
  private com.tencent.mm.ak.f callback;
  private String hXi;
  private final b rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(150429);
    hXg = 0L;
    hXh = new HashMap();
    AppMethodBeat.o(150429);
  }
  
  protected d(int paramInt)
  {
    AppMethodBeat.i(150424);
    this.startTime = 0L;
    this.scene = 0;
    this.hXi = "";
    ae.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), bu.fpN() });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ayp();
    ((b.a)localObject).hQG = new ayq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((b.a)localObject).funcId = 379;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.scene = paramInt;
    localObject = (ayp)this.rr.hQD.hQJ;
    ((ayp)localObject).GPj = "";
    ((ayp)localObject).Scene = paramInt;
    AppMethodBeat.o(150424);
  }
  
  private static CdnLogic.CdnInfoParams a(ry paramry)
  {
    AppMethodBeat.i(150427);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramry.GgB;
    localCdnInfoParams.c2CrwtimeoutMs = paramry.GgD;
    localCdnInfoParams.c2CshowErrorDelayMs = paramry.Ggz;
    localCdnInfoParams.snsretryIntervalMs = paramry.GgC;
    localCdnInfoParams.snsrwtimeoutMs = paramry.GgE;
    localCdnInfoParams.snsshowErrorDelayMs = paramry.GgA;
    AppMethodBeat.o(150427);
    return localCdnInfoParams;
  }
  
  private static String aGV()
  {
    AppMethodBeat.i(150426);
    if (!az.isConnected(ak.getContext()))
    {
      AppMethodBeat.o(150426);
      return null;
    }
    if (az.isWifi(ak.getContext())) {}
    for (String str = "wifi_" + az.ja(ak.getContext());; str = "mobile_" + az.getNetTypeString(ak.getContext()) + "_" + az.getISPCode(ak.getContext()))
    {
      ae.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[] { str });
      if ((str != null) && (str.length() >= 2)) {
        break;
      }
      AppMethodBeat.o(150426);
      return null;
    }
    str = String.format("%x", new Object[] { Integer.valueOf(str.hashCode()) });
    StringBuilder localStringBuilder = new StringBuilder();
    f.aGW();
    str = f.aGX() + str;
    AppMethodBeat.o(150426);
    return str;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(150425);
    this.callback = paramf;
    com.tencent.mm.kernel.g.ajP();
    int i = com.tencent.mm.kernel.a.getUin();
    if (i == 0)
    {
      ae.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(150425);
      return -1;
    }
    if (hXg != i)
    {
      hXg = i;
      hXh.clear();
    }
    long l = bu.aRi();
    a locala;
    if (this.scene == 0)
    {
      this.hXi = bu.bI(aGV(), "");
      locala = (a)hXh.get(this.hXi);
      paramf = locala;
      if (locala == null)
      {
        paramf = new a();
        hXh.put(this.hXi, paramf);
        ae.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { paramf, this.hXi });
      }
      if (paramf.hXj)
      {
        paramf.hXk = l;
        paramf.hXl = l;
        paramf.hXm = 0L;
      }
      ae.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - paramf.hXk), Long.valueOf(l - paramf.hXl), Long.valueOf(paramf.hXm) });
      if ((l > paramf.hXk) && (l - paramf.hXk < 10L))
      {
        ae.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.hXk), paramf });
        AppMethodBeat.o(150425);
        return -1;
      }
      if ((l > paramf.hXl) && (l - paramf.hXl < 3600L) && (paramf.hXm >= 90L))
      {
        ae.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.hXl), paramf });
        AppMethodBeat.o(150425);
        return -1;
      }
      paramf.hXk = l;
      if ((l < paramf.hXl) || (l - paramf.hXm > 3600L))
      {
        paramf.hXl = l;
        paramf.hXm = 0L;
        this.startTime = l;
        paramf = com.tencent.mm.plugin.report.service.g.yxI;
        if (this.scene != 0) {
          break label577;
        }
      }
    }
    label577:
    for (l = 0L;; l = 1L)
    {
      paramf.idkeyStat(546L, l, 1L, true);
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(150425);
      return i;
      paramf.hXm += 1L;
      break;
      this.hXi = "";
      paramf = hXh.values().iterator();
      if (paramf == null) {
        break;
      }
      while (paramf.hasNext())
      {
        locala = (a)paramf.next();
        if (locala != null)
        {
          locala.hXk = l;
          if ((l < locala.hXl) || (l - locala.hXm > 3600L))
          {
            locala.hXl = l;
            locala.hXm = 0L;
          }
          else
          {
            locala.hXm += 1L;
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
    ae.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    ayq localayq = (ayq)((b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localayq.FWY == null))
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10769, new Object[] { Integer.valueOf(c.hXf), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localayq.FWY == null) {}
      for (bool = true;; bool = false)
      {
        ae.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(150428);
        return;
      }
    }
    paramq = aGV();
    if ((!bu.isNullOrNil(paramq)) && (!bu.isNullOrNil(this.hXi)) && (!paramq.equals(this.hXi)))
    {
      ae.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { paramq, this.hXi });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(546L, 6L, 1L, true);
    }
    hXh.clear();
    paramArrayOfByte = null;
    paramq = paramArrayOfByte;
    if (localayq.FXb != null)
    {
      paramq = paramArrayOfByte;
      if (localayq.FXb.getILen() > 0)
      {
        ae.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localayq.FXb.getILen()) });
        paramq = z.a(localayq.FXb);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localayq.FXc != null)
    {
      paramArrayOfByte = localObject;
      if (localayq.FXc.getILen() > 0)
      {
        ae.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localayq.FXc.getILen()) });
        paramArrayOfByte = z.a(localayq.FXc);
      }
    }
    ae.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localayq.FXd });
    if (localayq.FXd != null) {
      ae.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localayq.FXd.qkC), localayq.FXd.GgL });
    }
    if (!f.aHa().a(localayq.FWY, localayq.FWZ, localayq.FXa, paramq, paramArrayOfByte, localayq.FXd))
    {
      ae.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
    ae.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localayq.FXf, localayq.FXg, Integer.valueOf(localayq.FXe) });
    if ((localayq.FXf != null) && (localayq.FXg != null)) {
      CdnLogic.setCdnInfoParams(a(localayq.FXf), a(localayq.FXg), localayq.FXe);
    }
    if (localayq.GPk == 1) {}
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
    boolean hXj = false;
    long hXk = 0L;
    long hXl = 0L;
    long hXm = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(150423);
      String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hXj), Long.valueOf(this.hXk), Long.valueOf(this.hXl), Long.valueOf(this.hXm) });
      AppMethodBeat.o(150423);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.d
 * JD-Core Version:    0.7.0.1
 */