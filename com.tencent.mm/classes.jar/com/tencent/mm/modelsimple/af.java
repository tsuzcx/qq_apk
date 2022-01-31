package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.protocal.w;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class af
  extends m
  implements k
{
  private f callback;
  int fQe;
  private int fQf;
  private q ftU;
  private String uri;
  
  private af(int paramInt1, int paramInt2, String paramString, int paramInt3, SKBuiltinBuffer_t paramSKBuiltinBuffer_t, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154517);
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
      ab.i("MicroMsg.NetsceneAxAuth", "summerauthax NetsceneAxAuth funcId[%d] uri[%s], bType[%d] ticket[%d] randomKey[%d]", new Object[] { Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j) });
      this.fQe = paramInt1;
      this.ftU = new w(paramInt2, paramString, paramInt3, paramSKBuiltinBuffer_t, paramArrayOfByte);
      this.fQf = 0;
      this.uri = paramString;
      AppMethodBeat.o(154517);
      return;
      i = paramSKBuiltinBuffer_t.getILen();
      break;
      label121:
      j = paramArrayOfByte.length;
    }
  }
  
  public af(gk paramgk)
  {
    this(paramgk.wsK, paramgk.wsN, paramgk.wsP, paramgk.wsK, paramgk.wsL, paramgk.wsO.getBufferToBytes());
    AppMethodBeat.i(154518);
    AppMethodBeat.o(154518);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(154520);
    this.callback = paramf;
    this.fQf += 1;
    ab.i("MicroMsg.NetsceneAxAuth", "summerauthax doScene callback[%s] retry count %d , uri %s ", new Object[] { paramf, Integer.valueOf(this.fQf), this.uri });
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 129L, 1L, false);
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(154520);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(154519);
    int i = this.ftU.getType();
    AppMethodBeat.o(154519);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154521);
    ab.i("MicroMsg.NetsceneAxAuth", "summerauthax onGYNetEnd [%d, %d, %s], retry count %d, uri %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.fQf), this.uri });
    if (((paramInt2 != 0) || (paramInt3 != 0)) && (this.fQf < 3))
    {
      paramInt1 = doScene(dispatcher(), this.callback);
      if (paramInt1 < 0)
      {
        ab.i("MicroMsg.NetsceneAxAuth", "send axauth failed %d , %s ", new Object[] { Integer.valueOf(paramInt1), this.uri });
        this.callback.onSceneEnd(3, -1, "", this);
        AppMethodBeat.o(154521);
        return;
      }
      AppMethodBeat.o(154521);
      return;
    }
    if (this.fQf >= 3) {
      ab.e("MicroMsg.NetsceneAxAuth", "axauth retry reach max times %d, uri is %s ", new Object[] { Integer.valueOf(this.fQf), this.uri });
    }
    if ((paramInt3 == -3) || (paramInt3 == -104)) {
      g.Rc().a(new bk(new af.1(this)), 0);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 130L, 1L, false);
      AppMethodBeat.o(154521);
      return;
      paramq = ((w.b)paramq.getRespObj()).wiU;
      g.Rc().a(new bk(new af.2(this, paramq, paramArrayOfByte)), 0);
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 131L, 1L, false);
    AppMethodBeat.o(154521);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af
 * JD-Core Version:    0.7.0.1
 */