package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class ag
  extends n
  implements k
{
  private int businessType;
  private f callback;
  private com.tencent.mm.network.q hRG;
  private byte[] ipA;
  int ipv;
  private int ipw;
  private int ipx;
  private String ipy;
  private SKBuiltinBuffer_t ipz;
  private String uri;
  
  private ag(int paramInt1, int paramInt2, String paramString, int paramInt3, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte, int paramInt4)
  {
    AppMethodBeat.i(220273);
    int i;
    if (paramSKBuiltinBuffer_t == null)
    {
      i = -1;
      if (paramArrayOfByte != null) {
        break label150;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", new Object[] { Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j) });
      this.ipv = paramInt1;
      this.ipx = paramInt2;
      this.ipy = paramString;
      this.businessType = paramInt3;
      this.ipz = paramSKBuiltinBuffer_t;
      this.ipA = paramArrayOfByte;
      this.hRG = new y(paramInt2, paramString, paramInt3, paramSKBuiltinBuffer_t, paramArrayOfByte);
      this.ipw = paramInt4;
      this.uri = paramString;
      AppMethodBeat.o(220273);
      return;
      i = paramSKBuiltinBuffer_t.getILen();
      break;
      label150:
      j = paramArrayOfByte.length;
    }
  }
  
  public ag(hs paramhs)
  {
    this(paramhs.uuz, paramhs.FSH, paramhs.FSJ, paramhs.uuz, paramhs.FSF, paramhs.FSI.getBufferToBytes(), 0);
    AppMethodBeat.i(134207);
    AppMethodBeat.o(134207);
  }
  
  private static void pX(int paramInt)
  {
    AppMethodBeat.i(134211);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 138L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case 0: 
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 130L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -1: 
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 132L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -2: 
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 133L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -3: 
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 134L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -13: 
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 135L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -104: 
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 136L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    }
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 137L, 1L, false);
    AppMethodBeat.o(134211);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(134209);
    this.callback = paramf;
    this.ipw += 1;
    ae.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", new Object[] { paramf, Integer.valueOf(this.ipw), this.uri });
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 129L, 1L, false);
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(134209);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134208);
    int i = this.hRG.getType();
    AppMethodBeat.o(134208);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134210);
    ae.i("MicroMsg.NetsceneAxAuth", "summerauthax type [%d], onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.ipw), this.uri });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.ipw < 3))
    {
      pX(paramInt3);
      if ((paramInt3 == -1) || (paramInt3 == -446))
      {
        ae.i("MicroMsg.NetsceneAxAuth", "summerauth do NetsceneAxAuth");
        if (!g.ajj().a(new ag(this.ipv, this.ipx, this.ipy, this.businessType, this.ipz, this.ipA, this.ipw), 0))
        {
          ae.i("MicroMsg.NetsceneAxAuth", "send axauth failed %s ", new Object[] { this.uri });
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134210);
          return;
        }
      }
    }
    if (this.ipw >= 3) {
      ae.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", new Object[] { Integer.valueOf(this.ipw), this.uri });
    }
    paramq = ((y.b)paramq.getRespObj()).FHd;
    g.ajj().a(new bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(134205);
        if (paramAnonymouse == null)
        {
          ae.w("MicroMsg.NetsceneAxAuth", "dispatcher null");
          AppMethodBeat.o(134205);
          return;
        }
        if (paramAnonymouse.aFs() == null)
        {
          ae.w("MicroMsg.NetsceneAxAuth", "getAccInfo null");
          AppMethodBeat.o(134205);
          return;
        }
        try
        {
          paramAnonymouse.aFs().b(ag.this.ipv, paramq.toByteArray(), paramArrayOfByte);
          ae.i("MicroMsg.NetsceneAxAuth", "set axauth session btype[%d], session length [%d], cookie length[%d]", new Object[] { Integer.valueOf(ag.this.ipv), Integer.valueOf(paramq.toByteArray().length), Integer.valueOf(paramArrayOfByte.length) });
          AppMethodBeat.o(134205);
          return;
        }
        catch (Exception paramAnonymouse)
        {
          ae.e("MicroMsg.NetsceneAxAuth", "exception:%s", new Object[] { bu.o(paramAnonymouse) });
          AppMethodBeat.o(134205);
        }
      }
    }), 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    pX(paramInt2);
    if (paramInt2 != 0) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 131L, 1L, false);
    }
    AppMethodBeat.o(134210);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */