package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class af
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.network.q gVZ;
  int hsI;
  private int hsJ;
  private String uri;
  
  private af(int paramInt1, int paramInt2, String paramString, int paramInt3, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134206);
    int i;
    if (paramSKBuiltinBuffer_t == null)
    {
      i = -1;
      if (paramArrayOfByte != null) {
        break label121;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", new Object[] { Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j) });
      this.hsI = paramInt1;
      this.gVZ = new y(paramInt2, paramString, paramInt3, paramSKBuiltinBuffer_t, paramArrayOfByte);
      this.hsJ = 0;
      this.uri = paramString;
      AppMethodBeat.o(134206);
      return;
      i = paramSKBuiltinBuffer_t.getILen();
      break;
      label121:
      j = paramArrayOfByte.length;
    }
  }
  
  public af(hh paramhh)
  {
    this(paramhh.CCp, paramhh.CCs, paramhh.CCu, paramhh.CCp, paramhh.CCq, paramhh.CCt.getBufferToBytes());
    AppMethodBeat.i(134207);
    AppMethodBeat.o(134207);
  }
  
  private static void oD(int paramInt)
  {
    AppMethodBeat.i(134211);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 138L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case 0: 
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 130L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -1: 
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 132L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -2: 
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 133L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -3: 
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 134L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -13: 
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 135L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -104: 
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 136L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    }
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 137L, 1L, false);
    AppMethodBeat.o(134211);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(134209);
    this.callback = paramg;
    this.hsJ += 1;
    ad.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", new Object[] { paramg, Integer.valueOf(this.hsJ), this.uri });
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 129L, 1L, false);
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(134209);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134208);
    int i = this.gVZ.getType();
    AppMethodBeat.o(134208);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134210);
    ad.i("MicroMsg.NetsceneAxAuth", "summerauthax type [%d], onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.hsJ), this.uri });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.hsJ < 3))
    {
      oD(paramInt3);
      if ((paramInt3 == -1) || (paramInt3 == -446))
      {
        paramInt1 = doScene(dispatcher(), this.callback);
        if (paramInt1 < 0)
        {
          ad.i("MicroMsg.NetsceneAxAuth", "send axauth failed %d , %s ", new Object[] { Integer.valueOf(paramInt1), this.uri });
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134210);
          return;
        }
      }
    }
    if (this.hsJ >= 3) {
      ad.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", new Object[] { Integer.valueOf(this.hsJ), this.uri });
    }
    paramq = ((y.b)paramq.getRespObj()).Crg;
    com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(134205);
        if (paramAnonymouse == null)
        {
          ad.w("MicroMsg.NetsceneAxAuth", "dispatcher null");
          AppMethodBeat.o(134205);
          return;
        }
        if (paramAnonymouse.avg() == null)
        {
          ad.w("MicroMsg.NetsceneAxAuth", "getAccInfo null");
          AppMethodBeat.o(134205);
          return;
        }
        try
        {
          paramAnonymouse.avg().b(af.this.hsI, paramq.toByteArray(), paramArrayOfByte);
          ad.i("MicroMsg.NetsceneAxAuth", "set axauth session btype[%d], session length [%d], cookie length[%d]", new Object[] { Integer.valueOf(af.this.hsI), Integer.valueOf(paramq.toByteArray().length), Integer.valueOf(paramArrayOfByte.length) });
          AppMethodBeat.o(134205);
          return;
        }
        catch (Exception paramAnonymouse)
        {
          ad.e("MicroMsg.NetsceneAxAuth", "exception:%s", new Object[] { bt.m(paramAnonymouse) });
          AppMethodBeat.o(134205);
        }
      }
    }), 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    oD(paramInt2);
    if (paramInt2 != 0) {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 131L, 1L, false);
    }
    AppMethodBeat.o(134210);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af
 * JD-Core Version:    0.7.0.1
 */