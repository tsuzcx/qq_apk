package com.tencent.mm.ak;

import android.net.wifi.WifiInfo;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ada;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  extends m
  implements k
{
  public static long ejf = 0L;
  private static Map<String, d.a> ejg = new HashMap();
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private String ejh = "";
  int scene = 0;
  public long startTime = 0L;
  
  protected d(int paramInt)
  {
    y.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), bk.csb() });
    b.a locala = new b.a();
    locala.ecH = new ada();
    locala.ecI = new adb();
    locala.uri = "/cgi-bin/micromsg-bin/getcdndns";
    locala.ecG = 379;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.scene = paramInt;
    ((ada)this.dmK.ecE.ecN).tbD = "";
  }
  
  private static String MZ()
  {
    if (!aq.isConnected(ae.getContext())) {
      return null;
    }
    if (aq.isWifi(ae.getContext()))
    {
      localObject = aq.getWifiInfo(ae.getContext());
      if (localObject == null) {
        return null;
      }
    }
    for (Object localObject = "wifi_" + ((WifiInfo)localObject).getSSID();; localObject = "mobile_" + aq.getNetTypeString(ae.getContext()) + "_" + aq.getISPCode(ae.getContext()))
    {
      y.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[] { localObject });
      if ((localObject != null) && (((String)localObject).length() >= 2)) {
        break;
      }
      return null;
    }
    localObject = String.format("%x", new Object[] { Integer.valueOf(((String)localObject).hashCode()) });
    StringBuilder localStringBuilder = new StringBuilder();
    f.Na();
    return f.Nb() + (String)localObject;
  }
  
  private static CdnLogic.CdnInfoParams a(lc paramlc)
  {
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramlc.sGl;
    localCdnInfoParams.c2CrwtimeoutMs = paramlc.sGn;
    localCdnInfoParams.c2CshowErrorDelayMs = paramlc.sGj;
    localCdnInfoParams.snsretryIntervalMs = paramlc.sGm;
    localCdnInfoParams.snsrwtimeoutMs = paramlc.sGo;
    localCdnInfoParams.snsshowErrorDelayMs = paramlc.sGk;
    return localCdnInfoParams;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    g.DN();
    int i = com.tencent.mm.kernel.a.CK();
    if (i == 0)
    {
      y.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      return -1;
    }
    if (ejf != i)
    {
      ejf = i;
      ejg.clear();
    }
    long l = bk.UX();
    d.a locala;
    if (this.scene == 0)
    {
      this.ejh = bk.aM(MZ(), "");
      locala = (d.a)ejg.get(this.ejh);
      paramf = locala;
      if (locala == null)
      {
        paramf = new d.a();
        ejg.put(this.ejh, paramf);
        y.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { paramf, this.ejh });
      }
      if (paramf.eji)
      {
        paramf.ejj = l;
        paramf.ejk = l;
        paramf.ejl = 0L;
      }
      y.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - paramf.ejj), Long.valueOf(l - paramf.ejk), Long.valueOf(paramf.ejl) });
      if ((l > paramf.ejj) && (l - paramf.ejj < 10L))
      {
        y.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.ejj), paramf });
        return -1;
      }
      if ((l > paramf.ejk) && (l - paramf.ejk < 3600L) && (paramf.ejl >= 90L))
      {
        y.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.ejk), paramf });
        return -1;
      }
      paramf.ejj = l;
      if ((l < paramf.ejk) || (l - paramf.ejl > 3600L))
      {
        paramf.ejk = l;
        paramf.ejl = 0L;
        this.startTime = l;
        paramf = h.nFQ;
        if (this.scene != 0) {
          break label545;
        }
      }
    }
    label545:
    for (l = 0L;; l = 1L)
    {
      paramf.a(546L, l, 1L, true);
      return a(parame, this.dmK, this);
      paramf.ejl += 1L;
      break;
      this.ejh = "";
      paramf = ejg.values().iterator();
      if (paramf == null) {
        break;
      }
      while (paramf.hasNext())
      {
        locala = (d.a)paramf.next();
        if (locala != null)
        {
          locala.ejj = l;
          if ((l < locala.ejk) || (l - locala.ejl > 3600L))
          {
            locala.ejk = l;
            locala.ejl = 0L;
          }
          else
          {
            locala.ejl += 1L;
          }
        }
      }
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    adb localadb = (adb)((b)paramq).ecF.ecN;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localadb.sCd == null))
    {
      h.nFQ.f(10769, new Object[] { Integer.valueOf(c.eje), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localadb.sCd == null) {}
      for (boolean bool = true;; bool = false)
      {
        y.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    }
    paramq = MZ();
    if ((!bk.bl(paramq)) && (!bk.bl(this.ejh)) && (!paramq.equals(this.ejh)))
    {
      y.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { paramq, this.ejh });
      h.nFQ.a(546L, 6L, 1L, true);
    }
    ejg.clear();
    paramArrayOfByte = null;
    paramq = paramArrayOfByte;
    if (localadb.sCg != null)
    {
      paramq = paramArrayOfByte;
      if (localadb.sCg.tFK > 0)
      {
        y.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localadb.sCg.tFK) });
        paramq = aa.a(localadb.sCg);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localadb.sCh != null)
    {
      paramArrayOfByte = localObject;
      if (localadb.sCh.tFK > 0)
      {
        y.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localadb.sCh.tFK) });
        paramArrayOfByte = aa.a(localadb.sCh);
      }
    }
    y.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localadb.sCi });
    if (localadb.sCi != null) {
      y.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localadb.sCi.jwX), localadb.sCi.sGv });
    }
    if (!f.Ne().a(localadb.sCd, localadb.sCe, localadb.sCf, paramq, paramArrayOfByte, localadb.sCi))
    {
      y.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localadb.sCk, localadb.sCl, Integer.valueOf(localadb.sCj) });
    if ((localadb.sCk != null) && (localadb.sCl != null)) {
      CdnLogic.setCdnInfoParams(a(localadb.sCk), a(localadb.sCl), localadb.sCj);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 379;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.d
 * JD-Core Version:    0.7.0.1
 */