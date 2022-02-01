package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
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
  private s lCW;
  private int maD;
  private int maE;
  private int maF;
  private String maG;
  private eae maH;
  private byte[] maI;
  private String uri;
  
  private ag(int paramInt1, int paramInt2, String paramString, int paramInt3, eae parameae, byte[] paramArrayOfByte, int paramInt4)
  {
    AppMethodBeat.i(186428);
    int i;
    if (parameae == null)
    {
      i = -1;
      if (paramArrayOfByte != null) {
        break label150;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", new Object[] { Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j) });
      this.maD = paramInt1;
      this.maF = paramInt2;
      this.maG = paramString;
      this.businessType = paramInt3;
      this.maH = parameae;
      this.maI = paramArrayOfByte;
      this.lCW = new y(paramInt2, paramString, paramInt3, parameae, paramArrayOfByte);
      this.maE = paramInt4;
      this.uri = paramString;
      AppMethodBeat.o(186428);
      return;
      i = parameae.Ufv;
      break;
      label150:
      j = paramArrayOfByte.length;
    }
  }
  
  public ag(hv paramhv)
  {
    this(paramhv.CQK, paramhv.RNn, paramhv.RNp, paramhv.CQK, paramhv.RNl, paramhv.RNo.Tkb.UH, 0);
    AppMethodBeat.i(134207);
    AppMethodBeat.o(134207);
  }
  
  private static void wM(int paramInt)
  {
    AppMethodBeat.i(134211);
    switch (paramInt)
    {
    default: 
      f.Iyx.idkeyStat(148L, 138L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case 0: 
      f.Iyx.idkeyStat(148L, 130L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -1: 
      f.Iyx.idkeyStat(148L, 132L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -2: 
      f.Iyx.idkeyStat(148L, 133L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -3: 
      f.Iyx.idkeyStat(148L, 134L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -13: 
      f.Iyx.idkeyStat(148L, 135L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    case -104: 
      f.Iyx.idkeyStat(148L, 136L, 1L, false);
      AppMethodBeat.o(134211);
      return;
    }
    f.Iyx.idkeyStat(148L, 137L, 1L, false);
    AppMethodBeat.o(134211);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(134209);
    this.callback = parami;
    this.maE += 1;
    Log.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", new Object[] { parami, Integer.valueOf(this.maE), this.uri });
    f.Iyx.idkeyStat(148L, 129L, 1L, false);
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(134209);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134208);
    int i = this.lCW.getType();
    AppMethodBeat.o(134208);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134210);
    Log.i("MicroMsg.NetsceneAxAuth", "summerauthax type [%d], onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.maE), this.uri });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.maE < 3))
    {
      wM(paramInt3);
      if ((paramInt3 == -1) || (paramInt3 == -446))
      {
        Log.i("MicroMsg.NetsceneAxAuth", "summerauth do NetsceneAxAuth");
        if (!h.aGY().a(new ag(this.maD, this.maF, this.maG, this.businessType, this.maH, this.maI, this.maE), 0))
        {
          Log.i("MicroMsg.NetsceneAxAuth", "send axauth failed %s ", new Object[] { this.uri });
          this.callback.onSceneEnd(3, -1, "", this);
          AppMethodBeat.o(134210);
          return;
        }
      }
    }
    if (this.maE >= 3) {
      Log.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", new Object[] { Integer.valueOf(this.maE), this.uri });
    }
    params = ((y.b)params.getRespObj()).RCe;
    h.aGY().a(new bv(new bv.a()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(134205);
        if (paramAnonymousg == null)
        {
          Log.w("MicroMsg.NetsceneAxAuth", "dispatcher null");
          AppMethodBeat.o(134205);
          return;
        }
        if (paramAnonymousg.biw() == null)
        {
          Log.w("MicroMsg.NetsceneAxAuth", "getAccInfo null");
          AppMethodBeat.o(134205);
          return;
        }
        try
        {
          paramAnonymousg.biw().b(ag.a(ag.this), params.toByteArray(), paramArrayOfByte);
          Log.i("MicroMsg.NetsceneAxAuth", "set axauth session btype[%d], session length [%d], cookie length[%d]", new Object[] { Integer.valueOf(ag.a(ag.this)), Integer.valueOf(params.toByteArray().length), Integer.valueOf(paramArrayOfByte.length) });
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
      f.Iyx.idkeyStat(148L, 131L, 1L, false);
    }
    AppMethodBeat.o(134210);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ag
 * JD-Core Version:    0.7.0.1
 */