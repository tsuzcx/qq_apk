package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
  extends q
  implements m
{
  private int businessType;
  private i callback;
  private s iMO;
  int jkC;
  private int jkD;
  private int jkE;
  private String jkF;
  private SKBuiltinBuffer_t jkG;
  private byte[] jkH;
  private String uri;
  
  private ag(int paramInt1, int paramInt2, String paramString, int paramInt3, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte, int paramInt4)
  {
    AppMethodBeat.i(222851);
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
      Log.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", new Object[] { Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j) });
      this.jkC = paramInt1;
      this.jkE = paramInt2;
      this.jkF = paramString;
      this.businessType = paramInt3;
      this.jkG = paramSKBuiltinBuffer_t;
      this.jkH = paramArrayOfByte;
      this.iMO = new y(paramInt2, paramString, paramInt3, paramSKBuiltinBuffer_t, paramArrayOfByte);
      this.jkD = paramInt4;
      this.uri = paramString;
      AppMethodBeat.o(222851);
      return;
      i = paramSKBuiltinBuffer_t.getILen();
      break;
      label150:
      j = paramArrayOfByte.length;
    }
  }
  
  public ag(if paramif)
  {
    this(paramif.xMB, paramif.KMq, paramif.KMs, paramif.xMB, paramif.KMo, paramif.KMr.getBufferToBytes(), 0);
    AppMethodBeat.i(134207);
    AppMethodBeat.o(134207);
  }
  
  private static void tM(int paramInt)
  {
    AppMethodBeat.i(134211);
    switch (paramInt)
    {
    default: 
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 138L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case 0: 
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 130L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -1: 
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 132L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -2: 
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 133L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -3: 
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 134L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -13: 
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 135L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -104: 
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 136L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    }
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 137L, 1L, false);
    AppMethodBeat.o(134211);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(134209);
    this.callback = parami;
    this.jkD += 1;
    Log.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", new Object[] { parami, Integer.valueOf(this.jkD), this.uri });
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 129L, 1L, false);
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(134209);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134208);
    int i = this.iMO.getType();
    AppMethodBeat.o(134208);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134210);
    Log.i("MicroMsg.NetsceneAxAuth", "summerauthax type [%d], onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.jkD), this.uri });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.jkD < 3))
    {
      tM(paramInt3);
      if ((paramInt3 == -1) || (paramInt3 == -446))
      {
        Log.i("MicroMsg.NetsceneAxAuth", "summerauth do NetsceneAxAuth");
        if (!com.tencent.mm.kernel.g.azz().a(new ag(this.jkC, this.jkE, this.jkF, this.businessType, this.jkG, this.jkH, this.jkD), 0))
        {
          Log.i("MicroMsg.NetsceneAxAuth", "send axauth failed %s ", new Object[] { this.uri });
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134210);
          return;
        }
      }
    }
    if (this.jkD >= 3) {
      Log.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", new Object[] { Integer.valueOf(this.jkD), this.uri });
    }
    params = ((y.b)params.getRespObj()).KAo;
    com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
    {
      public final void a(com.tencent.mm.network.g paramAnonymousg)
      {
        AppMethodBeat.i(134205);
        if (paramAnonymousg == null)
        {
          Log.w("MicroMsg.NetsceneAxAuth", "dispatcher null");
          AppMethodBeat.o(134205);
          return;
        }
        if (paramAnonymousg.aZh() == null)
        {
          Log.w("MicroMsg.NetsceneAxAuth", "getAccInfo null");
          AppMethodBeat.o(134205);
          return;
        }
        try
        {
          paramAnonymousg.aZh().b(ag.this.jkC, params.toByteArray(), paramArrayOfByte);
          Log.i("MicroMsg.NetsceneAxAuth", "set axauth session btype[%d], session length [%d], cookie length[%d]", new Object[] { Integer.valueOf(ag.this.jkC), Integer.valueOf(params.toByteArray().length), Integer.valueOf(paramArrayOfByte.length) });
          AppMethodBeat.o(134205);
          return;
        }
        catch (Exception paramAnonymousg)
        {
          Log.e("MicroMsg.NetsceneAxAuth", "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousg) });
          AppMethodBeat.o(134205);
        }
      }
    }), 0);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    tM(paramInt2);
    if (paramInt2 != 0) {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 131L, 1L, false);
    }
    AppMethodBeat.o(134210);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */