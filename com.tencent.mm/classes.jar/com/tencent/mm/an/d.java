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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  extends n
  implements k
{
  public static long hBI;
  private static Map<String, d.a> hBJ;
  private com.tencent.mm.ak.g callback;
  private String hBK;
  private final b rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(150429);
    hBI = 0L;
    hBJ = new HashMap();
    AppMethodBeat.o(150429);
  }
  
  protected d(int paramInt)
  {
    AppMethodBeat.i(150424);
    this.startTime = 0L;
    this.scene = 0;
    this.hBK = "";
    ac.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), bs.eWi() });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aub();
    ((b.a)localObject).hvu = new auc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((b.a)localObject).funcId = 379;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.scene = paramInt;
    localObject = (aub)this.rr.hvr.hvw;
    ((aub)localObject).EMG = "";
    ((aub)localObject).Scene = paramInt;
    AppMethodBeat.o(150424);
  }
  
  private static CdnLogic.CdnInfoParams a(qf paramqf)
  {
    AppMethodBeat.i(150427);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramqf.EgV;
    localCdnInfoParams.c2CrwtimeoutMs = paramqf.EgX;
    localCdnInfoParams.c2CshowErrorDelayMs = paramqf.EgT;
    localCdnInfoParams.snsretryIntervalMs = paramqf.EgW;
    localCdnInfoParams.snsrwtimeoutMs = paramqf.EgY;
    localCdnInfoParams.snsshowErrorDelayMs = paramqf.EgU;
    AppMethodBeat.o(150427);
    return localCdnInfoParams;
  }
  
  private static String aDz()
  {
    AppMethodBeat.i(150426);
    if (!ax.isConnected(ai.getContext()))
    {
      AppMethodBeat.o(150426);
      return null;
    }
    if (ax.isWifi(ai.getContext())) {}
    for (String str = "wifi_" + ax.iL(ai.getContext());; str = "mobile_" + ax.getNetTypeString(ai.getContext()) + "_" + ax.getISPCode(ai.getContext()))
    {
      ac.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[] { str });
      if ((str != null) && (str.length() >= 2)) {
        break;
      }
      AppMethodBeat.o(150426);
      return null;
    }
    str = String.format("%x", new Object[] { Integer.valueOf(str.hashCode()) });
    StringBuilder localStringBuilder = new StringBuilder();
    f.aDA();
    str = f.aDB() + str;
    AppMethodBeat.o(150426);
    return str;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150425);
    this.callback = paramg;
    com.tencent.mm.kernel.g.agP();
    int i = com.tencent.mm.kernel.a.getUin();
    if (i == 0)
    {
      ac.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(150425);
      return -1;
    }
    if (hBI != i)
    {
      hBI = i;
      hBJ.clear();
    }
    long l = bs.aNx();
    d.a locala;
    if (this.scene == 0)
    {
      this.hBK = bs.bG(aDz(), "");
      locala = (d.a)hBJ.get(this.hBK);
      paramg = locala;
      if (locala == null)
      {
        paramg = new d.a();
        hBJ.put(this.hBK, paramg);
        ac.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { paramg, this.hBK });
      }
      if (paramg.hBL)
      {
        paramg.hBM = l;
        paramg.hBN = l;
        paramg.hBO = 0L;
      }
      ac.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - paramg.hBM), Long.valueOf(l - paramg.hBN), Long.valueOf(paramg.hBO) });
      if ((l > paramg.hBM) && (l - paramg.hBM < 10L))
      {
        ac.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramg.hBM), paramg });
        AppMethodBeat.o(150425);
        return -1;
      }
      if ((l > paramg.hBN) && (l - paramg.hBN < 3600L) && (paramg.hBO >= 90L))
      {
        ac.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramg.hBN), paramg });
        AppMethodBeat.o(150425);
        return -1;
      }
      paramg.hBM = l;
      if ((l < paramg.hBN) || (l - paramg.hBO > 3600L))
      {
        paramg.hBN = l;
        paramg.hBO = 0L;
        this.startTime = l;
        paramg = h.wUl;
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
      paramg.hBO += 1L;
      break;
      this.hBK = "";
      paramg = hBJ.values().iterator();
      if (paramg == null) {
        break;
      }
      while (paramg.hasNext())
      {
        locala = (d.a)paramg.next();
        if (locala != null)
        {
          locala.hBM = l;
          if ((l < locala.hBN) || (l - locala.hBO > 3600L))
          {
            locala.hBN = l;
            locala.hBO = 0L;
          }
          else
          {
            locala.hBO += 1L;
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
    ac.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    auc localauc = (auc)((b)paramq).hvs.hvw;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localauc.DZh == null))
    {
      h.wUl.f(10769, new Object[] { Integer.valueOf(c.hBH), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localauc.DZh == null) {}
      for (bool = true;; bool = false)
      {
        ac.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(150428);
        return;
      }
    }
    paramq = aDz();
    if ((!bs.isNullOrNil(paramq)) && (!bs.isNullOrNil(this.hBK)) && (!paramq.equals(this.hBK)))
    {
      ac.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { paramq, this.hBK });
      h.wUl.idkeyStat(546L, 6L, 1L, true);
    }
    hBJ.clear();
    paramArrayOfByte = null;
    paramq = paramArrayOfByte;
    if (localauc.DZk != null)
    {
      paramq = paramArrayOfByte;
      if (localauc.DZk.getILen() > 0)
      {
        ac.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localauc.DZk.getILen()) });
        paramq = z.a(localauc.DZk);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localauc.DZl != null)
    {
      paramArrayOfByte = localObject;
      if (localauc.DZl.getILen() > 0)
      {
        ac.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localauc.DZl.getILen()) });
        paramArrayOfByte = z.a(localauc.DZl);
      }
    }
    ac.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localauc.DZm });
    if (localauc.DZm != null) {
      ac.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localauc.DZm.pAs), localauc.DZm.Ehf });
    }
    if (!f.aDE().a(localauc.DZh, localauc.DZi, localauc.DZj, paramq, paramArrayOfByte, localauc.DZm))
    {
      ac.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
    ac.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localauc.DZo, localauc.DZp, Integer.valueOf(localauc.DZn) });
    if ((localauc.DZo != null) && (localauc.DZp != null)) {
      CdnLogic.setCdnInfoParams(a(localauc.DZo), a(localauc.DZp), localauc.DZn);
    }
    if (localauc.EMH == 1) {}
    for (boolean bool = true;; bool = false)
    {
      CdnLogic.setUseIPv6Cdn(bool);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150428);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.d
 * JD-Core Version:    0.7.0.1
 */