package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ah
  extends p
  implements m
{
  private int businessType;
  private com.tencent.mm.am.h callback;
  private int oTu;
  private int oTv;
  private int oTw;
  private String oTx;
  private gol oTy;
  private byte[] oTz;
  private com.tencent.mm.network.s ouH;
  private String uri;
  
  private ah(int paramInt1, int paramInt2, String paramString, int paramInt3, gol paramgol, byte[] paramArrayOfByte, int paramInt4)
  {
    AppMethodBeat.i(236694);
    int i;
    if (paramgol == null)
    {
      i = -1;
      if (paramArrayOfByte != null) {
        break label150;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", new Object[] { Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j) });
      this.oTu = paramInt1;
      this.oTw = paramInt2;
      this.oTx = paramString;
      this.businessType = paramInt3;
      this.oTy = paramgol;
      this.oTz = paramArrayOfByte;
      this.ouH = new y(paramInt2, paramString, paramInt3, paramgol, paramArrayOfByte);
      this.oTv = paramInt4;
      this.uri = paramString;
      AppMethodBeat.o(236694);
      return;
      i = paramgol.abwJ;
      break;
      label150:
      j = paramArrayOfByte.length;
    }
  }
  
  public ah(ir paramir)
  {
    this(paramir.IKW, paramir.YKB, paramir.YKD, paramir.IKW, paramir.YKz, paramir.YKC.aaxD.Op, 0);
    AppMethodBeat.i(134207);
    AppMethodBeat.o(134207);
  }
  
  private static void wM(int paramInt)
  {
    AppMethodBeat.i(134211);
    switch (paramInt)
    {
    default: 
      f.Ozc.idkeyStat(148L, 138L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case 0: 
      f.Ozc.idkeyStat(148L, 130L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -1: 
      f.Ozc.idkeyStat(148L, 132L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -2: 
      f.Ozc.idkeyStat(148L, 133L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -3: 
      f.Ozc.idkeyStat(148L, 134L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -13: 
      f.Ozc.idkeyStat(148L, 135L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -104: 
      f.Ozc.idkeyStat(148L, 136L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    }
    f.Ozc.idkeyStat(148L, 137L, 1L, false);
    AppMethodBeat.o(134211);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(134209);
    this.callback = paramh;
    this.oTv += 1;
    Log.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", new Object[] { paramh, Integer.valueOf(this.oTv), this.uri });
    f.Ozc.idkeyStat(148L, 129L, 1L, false);
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(134209);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134208);
    int i = this.ouH.getType();
    AppMethodBeat.o(134208);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final com.tencent.mm.network.s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134210);
    Log.i("MicroMsg.NetsceneAxAuth", "summerauthax type [%d], onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.oTv), this.uri });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.oTv < 3))
    {
      wM(paramInt3);
      if ((paramInt3 == -1) || (paramInt3 == -446))
      {
        Log.i("MicroMsg.NetsceneAxAuth", "summerauth do NetsceneAxAuth");
        if (!com.tencent.mm.kernel.h.aZW().a(new ah(this.oTu, this.oTw, this.oTx, this.businessType, this.oTy, this.oTz, this.oTv), 0))
        {
          Log.i("MicroMsg.NetsceneAxAuth", "send axauth failed %s ", new Object[] { this.uri });
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134210);
          return;
        }
      }
    }
    if (this.oTv >= 3) {
      Log.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", new Object[] { Integer.valueOf(this.oTv), this.uri });
    }
    params = ((y.b)params.getRespObj()).YyG;
    com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
    {
      public final void b(g paramAnonymousg)
      {
        AppMethodBeat.i(134205);
        if (paramAnonymousg == null)
        {
          Log.w("MicroMsg.NetsceneAxAuth", "dispatcher null");
          AppMethodBeat.o(134205);
          return;
        }
        if (paramAnonymousg.bGg() == null)
        {
          Log.w("MicroMsg.NetsceneAxAuth", "getAccInfo null");
          AppMethodBeat.o(134205);
          return;
        }
        try
        {
          paramAnonymousg.bGg().b(ah.a(ah.this), params.toByteArray(), paramArrayOfByte);
          Log.i("MicroMsg.NetsceneAxAuth", "set axauth session btype[%d], session length [%d], cookie length[%d]", new Object[] { Integer.valueOf(ah.a(ah.this)), Integer.valueOf(params.toByteArray().length), Integer.valueOf(paramArrayOfByte.length) });
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
    wM(paramInt2);
    if (paramInt2 != 0) {
      f.Ozc.idkeyStat(148L, 131L, 1L, false);
    }
    AppMethodBeat.o(134210);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ah
 * JD-Core Version:    0.7.0.1
 */