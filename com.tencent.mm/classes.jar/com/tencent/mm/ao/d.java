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
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.rx;
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
  public static long hUo;
  private static Map<String, a> hUp;
  private com.tencent.mm.al.f callback;
  private String hUq;
  private final b rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(150429);
    hUo = 0L;
    hUp = new HashMap();
    AppMethodBeat.o(150429);
  }
  
  protected d(int paramInt)
  {
    AppMethodBeat.i(150424);
    this.startTime = 0L;
    this.scene = 0;
    this.hUq = "";
    ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), bt.flS() });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new axz();
    ((b.a)localObject).hNN = new aya();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((b.a)localObject).funcId = 379;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.scene = paramInt;
    localObject = (axz)this.rr.hNK.hNQ;
    ((axz)localObject).GvK = "";
    ((axz)localObject).Scene = paramInt;
    AppMethodBeat.o(150424);
  }
  
  private static CdnLogic.CdnInfoParams a(rw paramrw)
  {
    AppMethodBeat.i(150427);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramrw.FOc;
    localCdnInfoParams.c2CrwtimeoutMs = paramrw.FOe;
    localCdnInfoParams.c2CshowErrorDelayMs = paramrw.FOa;
    localCdnInfoParams.snsretryIntervalMs = paramrw.FOd;
    localCdnInfoParams.snsrwtimeoutMs = paramrw.FOf;
    localCdnInfoParams.snsshowErrorDelayMs = paramrw.FOb;
    AppMethodBeat.o(150427);
    return localCdnInfoParams;
  }
  
  private static String aGE()
  {
    AppMethodBeat.i(150426);
    if (!ay.isConnected(aj.getContext()))
    {
      AppMethodBeat.o(150426);
      return null;
    }
    if (ay.isWifi(aj.getContext())) {}
    for (String str = "wifi_" + ay.iV(aj.getContext());; str = "mobile_" + ay.getNetTypeString(aj.getContext()) + "_" + ay.getISPCode(aj.getContext()))
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
    f.aGF();
    str = f.aGG() + str;
    AppMethodBeat.o(150426);
    return str;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(150425);
    this.callback = paramf;
    com.tencent.mm.kernel.g.ajA();
    int i = com.tencent.mm.kernel.a.getUin();
    if (i == 0)
    {
      ad.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(150425);
      return -1;
    }
    if (hUo != i)
    {
      hUo = i;
      hUp.clear();
    }
    long l = bt.aQJ();
    a locala;
    if (this.scene == 0)
    {
      this.hUq = bt.bI(aGE(), "");
      locala = (a)hUp.get(this.hUq);
      paramf = locala;
      if (locala == null)
      {
        paramf = new a();
        hUp.put(this.hUq, paramf);
        ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { paramf, this.hUq });
      }
      if (paramf.hUr)
      {
        paramf.hUs = l;
        paramf.hUt = l;
        paramf.hUu = 0L;
      }
      ad.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - paramf.hUs), Long.valueOf(l - paramf.hUt), Long.valueOf(paramf.hUu) });
      if ((l > paramf.hUs) && (l - paramf.hUs < 10L))
      {
        ad.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.hUs), paramf });
        AppMethodBeat.o(150425);
        return -1;
      }
      if ((l > paramf.hUt) && (l - paramf.hUt < 3600L) && (paramf.hUu >= 90L))
      {
        ad.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.hUt), paramf });
        AppMethodBeat.o(150425);
        return -1;
      }
      paramf.hUs = l;
      if ((l < paramf.hUt) || (l - paramf.hUu > 3600L))
      {
        paramf.hUt = l;
        paramf.hUu = 0L;
        this.startTime = l;
        paramf = com.tencent.mm.plugin.report.service.g.yhR;
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
      paramf.hUu += 1L;
      break;
      this.hUq = "";
      paramf = hUp.values().iterator();
      if (paramf == null) {
        break;
      }
      while (paramf.hasNext())
      {
        locala = (a)paramf.next();
        if (locala != null)
        {
          locala.hUs = l;
          if ((l < locala.hUt) || (l - locala.hUu > 3600L))
          {
            locala.hUt = l;
            locala.hUu = 0L;
          }
          else
          {
            locala.hUu += 1L;
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
    aya localaya = (aya)((b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localaya.FED == null))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10769, new Object[] { Integer.valueOf(c.hUn), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localaya.FED == null) {}
      for (bool = true;; bool = false)
      {
        ad.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(150428);
        return;
      }
    }
    paramq = aGE();
    if ((!bt.isNullOrNil(paramq)) && (!bt.isNullOrNil(this.hUq)) && (!paramq.equals(this.hUq)))
    {
      ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { paramq, this.hUq });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(546L, 6L, 1L, true);
    }
    hUp.clear();
    paramArrayOfByte = null;
    paramq = paramArrayOfByte;
    if (localaya.FEG != null)
    {
      paramq = paramArrayOfByte;
      if (localaya.FEG.getILen() > 0)
      {
        ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localaya.FEG.getILen()) });
        paramq = z.a(localaya.FEG);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localaya.FEH != null)
    {
      paramArrayOfByte = localObject;
      if (localaya.FEH.getILen() > 0)
      {
        ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localaya.FEH.getILen()) });
        paramArrayOfByte = z.a(localaya.FEH);
      }
    }
    ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localaya.FEI });
    if (localaya.FEI != null) {
      ad.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localaya.FEI.qdX), localaya.FEI.FOm });
    }
    if (!f.aGJ().a(localaya.FED, localaya.FEE, localaya.FEF, paramq, paramArrayOfByte, localaya.FEI))
    {
      ad.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
    ad.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localaya.FEK, localaya.FEL, Integer.valueOf(localaya.FEJ) });
    if ((localaya.FEK != null) && (localaya.FEL != null)) {
      CdnLogic.setCdnInfoParams(a(localaya.FEK), a(localaya.FEL), localaya.FEJ);
    }
    if (localaya.GvL == 1) {}
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
    boolean hUr = false;
    long hUs = 0L;
    long hUt = 0L;
    long hUu = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(150423);
      String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hUr), Long.valueOf(this.hUs), Long.valueOf(this.hUt), Long.valueOf(this.hUu) });
      AppMethodBeat.o(150423);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.d
 * JD-Core Version:    0.7.0.1
 */