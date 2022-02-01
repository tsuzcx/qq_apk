package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class af
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  int hTk;
  private int hTl;
  private com.tencent.mm.network.q hwy;
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
      ac.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", new Object[] { Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j) });
      this.hTk = paramInt1;
      this.hwy = new y(paramInt2, paramString, paramInt3, paramSKBuiltinBuffer_t, paramArrayOfByte);
      this.hTl = 0;
      this.uri = paramString;
      AppMethodBeat.o(134206);
      return;
      i = paramSKBuiltinBuffer_t.getILen();
      break;
      label121:
      j = paramArrayOfByte.length;
    }
  }
  
  public af(hl paramhl)
  {
    this(paramhl.DUM, paramhl.DUP, paramhl.DUR, paramhl.DUM, paramhl.DUN, paramhl.DUQ.getBufferToBytes());
    AppMethodBeat.i(134207);
    AppMethodBeat.o(134207);
  }
  
  private static void pr(int paramInt)
  {
    AppMethodBeat.i(134211);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 138L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case 0: 
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 130L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -1: 
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 132L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -2: 
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 133L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -3: 
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 134L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -13: 
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 135L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -104: 
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 136L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 137L, 1L, false);
    AppMethodBeat.o(134211);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(134209);
    this.callback = paramg;
    this.hTl += 1;
    ac.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", new Object[] { paramg, Integer.valueOf(this.hTl), this.uri });
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 129L, 1L, false);
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(134209);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134208);
    int i = this.hwy.getType();
    AppMethodBeat.o(134208);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134210);
    ac.i("MicroMsg.NetsceneAxAuth", "summerauthax type [%d], onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.hTl), this.uri });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.hTl < 3))
    {
      pr(paramInt3);
      if ((paramInt3 == -1) || (paramInt3 == -446))
      {
        paramInt1 = doScene(dispatcher(), this.callback);
        if (paramInt1 < 0)
        {
          ac.i("MicroMsg.NetsceneAxAuth", "send axauth failed %d , %s ", new Object[] { Integer.valueOf(paramInt1), this.uri });
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134210);
          return;
        }
      }
    }
    if (this.hTl >= 3) {
      ac.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", new Object[] { Integer.valueOf(this.hTl), this.uri });
    }
    paramq = ((y.b)paramq.getRespObj()).DJy;
    com.tencent.mm.kernel.g.agi().a(new bn(new bn.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(134205);
        if (paramAnonymouse == null)
        {
          ac.w("MicroMsg.NetsceneAxAuth", "dispatcher null");
          AppMethodBeat.o(134205);
          return;
        }
        if (paramAnonymouse.aBZ() == null)
        {
          ac.w("MicroMsg.NetsceneAxAuth", "getAccInfo null");
          AppMethodBeat.o(134205);
          return;
        }
        try
        {
          paramAnonymouse.aBZ().b(af.this.hTk, paramq.toByteArray(), paramArrayOfByte);
          ac.i("MicroMsg.NetsceneAxAuth", "set axauth session btype[%d], session length [%d], cookie length[%d]", new Object[] { Integer.valueOf(af.this.hTk), Integer.valueOf(paramq.toByteArray().length), Integer.valueOf(paramArrayOfByte.length) });
          AppMethodBeat.o(134205);
          return;
        }
        catch (Exception paramAnonymouse)
        {
          ac.e("MicroMsg.NetsceneAxAuth", "exception:%s", new Object[] { bs.m(paramAnonymouse) });
          AppMethodBeat.o(134205);
        }
      }
    }), 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    pr(paramInt2);
    if (paramInt2 != 0) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 131L, 1L, false);
    }
    AppMethodBeat.o(134210);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af
 * JD-Core Version:    0.7.0.1
 */