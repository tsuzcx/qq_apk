package com.tencent.mm.al;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.ahr;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d
  extends m
  implements k
{
  public static long fzj;
  private static Map<String, d.a> fzk;
  private com.tencent.mm.ai.f callback;
  private String fzl;
  private final b rr;
  int scene;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(78071);
    fzj = 0L;
    fzk = new HashMap();
    AppMethodBeat.o(78071);
  }
  
  protected d(int paramInt)
  {
    AppMethodBeat.i(78066);
    this.startTime = 0L;
    this.scene = 0;
    this.fzl = "";
    ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", new Object[] { Integer.valueOf(paramInt), bo.dtY() });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ahq();
    ((b.a)localObject).fsY = new ahr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcdndns";
    ((b.a)localObject).funcId = 379;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.scene = paramInt;
    localObject = (ahq)this.rr.fsV.fta;
    ((ahq)localObject).wZP = "";
    ((ahq)localObject).Scene = paramInt;
    AppMethodBeat.o(78066);
  }
  
  private static CdnLogic.CdnInfoParams a(nq paramnq)
  {
    AppMethodBeat.i(78069);
    CdnLogic.CdnInfoParams localCdnInfoParams = new CdnLogic.CdnInfoParams();
    localCdnInfoParams.c2CretryIntervalMs = paramnq.wCJ;
    localCdnInfoParams.c2CrwtimeoutMs = paramnq.wCL;
    localCdnInfoParams.c2CshowErrorDelayMs = paramnq.wCH;
    localCdnInfoParams.snsretryIntervalMs = paramnq.wCK;
    localCdnInfoParams.snsrwtimeoutMs = paramnq.wCM;
    localCdnInfoParams.snsshowErrorDelayMs = paramnq.wCI;
    AppMethodBeat.o(78069);
    return localCdnInfoParams;
  }
  
  private static String afK()
  {
    AppMethodBeat.i(78068);
    if (!at.isConnected(ah.getContext()))
    {
      AppMethodBeat.o(78068);
      return null;
    }
    if (at.isWifi(ah.getContext())) {}
    for (String str = "wifi_" + at.gX(ah.getContext());; str = "mobile_" + at.getNetTypeString(ah.getContext()) + "_" + at.getISPCode(ah.getContext()))
    {
      ab.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", new Object[] { str });
      if ((str != null) && (str.length() >= 2)) {
        break;
      }
      AppMethodBeat.o(78068);
      return null;
    }
    str = String.format("%x", new Object[] { Integer.valueOf(str.hashCode()) });
    StringBuilder localStringBuilder = new StringBuilder();
    f.afL();
    str = f.afM() + str;
    AppMethodBeat.o(78068);
    return str;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(78067);
    this.callback = paramf;
    g.RJ();
    int i = com.tencent.mm.kernel.a.getUin();
    if (i == 0)
    {
      ab.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
      AppMethodBeat.o(78067);
      return -1;
    }
    if (fzj != i)
    {
      fzj = i;
      fzk.clear();
    }
    long l = bo.aox();
    d.a locala;
    if (this.scene == 0)
    {
      this.fzl = bo.bf(afK(), "");
      locala = (d.a)fzk.get(this.fzl);
      paramf = locala;
      if (locala == null)
      {
        paramf = new d.a();
        fzk.put(this.fzl, paramf);
        ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", new Object[] { paramf, this.fzl });
      }
      if (paramf.fzm)
      {
        paramf.fzn = l;
        paramf.fzo = l;
        paramf.fzp = 0L;
      }
      ab.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", new Object[] { Long.valueOf(l - paramf.fzn), Long.valueOf(l - paramf.fzo), Long.valueOf(paramf.fzp) });
      if ((l > paramf.fzn) && (l - paramf.fzn < 10L))
      {
        ab.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.fzn), paramf });
        AppMethodBeat.o(78067);
        return -1;
      }
      if ((l > paramf.fzo) && (l - paramf.fzo < 3600L) && (paramf.fzp >= 90L))
      {
        ab.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", new Object[] { Long.valueOf(l - paramf.fzo), paramf });
        AppMethodBeat.o(78067);
        return -1;
      }
      paramf.fzn = l;
      if ((l < paramf.fzo) || (l - paramf.fzp > 3600L))
      {
        paramf.fzo = l;
        paramf.fzp = 0L;
        this.startTime = l;
        paramf = h.qsU;
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
      AppMethodBeat.o(78067);
      return i;
      paramf.fzp += 1L;
      break;
      this.fzl = "";
      paramf = fzk.values().iterator();
      if (paramf == null) {
        break;
      }
      while (paramf.hasNext())
      {
        locala = (d.a)paramf.next();
        if (locala != null)
        {
          locala.fzn = l;
          if ((l < locala.fzo) || (l - locala.fzp > 3600L))
          {
            locala.fzo = l;
            locala.fzp = 0L;
          }
          else
          {
            locala.fzp += 1L;
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
    AppMethodBeat.i(78070);
    ab.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    ahr localahr = (ahr)((b)paramq).fsW.fta;
    if ((paramInt2 != 0) || (paramInt3 != 0) || (localahr.wwy == null))
    {
      h.qsU.e(10769, new Object[] { Integer.valueOf(c.fzi), Integer.valueOf(0), Long.valueOf(this.startTime) });
      if (localahr.wwy == null) {}
      for (bool = true;; bool = false)
      {
        ab.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(78070);
        return;
      }
    }
    paramq = afK();
    if ((!bo.isNullOrNil(paramq)) && (!bo.isNullOrNil(this.fzl)) && (!paramq.equals(this.fzl)))
    {
      ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", new Object[] { paramq, this.fzl });
      h.qsU.idkeyStat(546L, 6L, 1L, true);
    }
    fzk.clear();
    paramArrayOfByte = null;
    paramq = paramArrayOfByte;
    if (localahr.wwB != null)
    {
      paramq = paramArrayOfByte;
      if (localahr.wwB.getILen() > 0)
      {
        ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", new Object[] { Integer.valueOf(localahr.wwB.getILen()) });
        paramq = aa.a(localahr.wwB);
      }
    }
    Object localObject = null;
    paramArrayOfByte = localObject;
    if (localahr.wwC != null)
    {
      paramArrayOfByte = localObject;
      if (localahr.wwC.getILen() > 0)
      {
        ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[] { Integer.valueOf(localahr.wwC.getILen()) });
        paramArrayOfByte = aa.a(localahr.wwC);
      }
    }
    ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", new Object[] { localahr.wwD });
    if (localahr.wwD != null) {
      ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", new Object[] { Integer.valueOf(localahr.wwD.lGw), localahr.wwD.wCT });
    }
    if (!f.afP().a(localahr.wwy, localahr.wwz, localahr.wwA, paramq, paramArrayOfByte, localahr.wwD))
    {
      ab.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78070);
      return;
    }
    ab.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", new Object[] { localahr.wwF, localahr.wwG, Integer.valueOf(localahr.wwE) });
    if ((localahr.wwF != null) && (localahr.wwG != null)) {
      CdnLogic.setCdnInfoParams(a(localahr.wwF), a(localahr.wwG), localahr.wwE);
    }
    if (localahr.wZQ == 1) {}
    for (boolean bool = true;; bool = false)
    {
      CdnLogic.setUseIPv6Cdn(bool);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78070);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.al.d
 * JD-Core Version:    0.7.0.1
 */