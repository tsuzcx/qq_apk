package com.tencent.mm.bn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
  implements k
{
  private g callback;
  private aug hKu;
  public auh hKv;
  public com.tencent.mm.api.h hKw;
  private String hKx;
  private b rr;
  
  public a(com.tencent.mm.api.h paramh)
  {
    AppMethodBeat.i(114107);
    this.callback = null;
    this.hKx = null;
    if (paramh == null)
    {
      AppMethodBeat.o(114107);
      return;
    }
    this.hKw = paramh;
    ad.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { paramh.field_cgi, Integer.valueOf(paramh.field_cmdid), paramh.field_functionmsgid });
    b.a locala = new b.a();
    locala.gUU = new aug();
    locala.gUV = new auh();
    locala.funcId = 825;
    locala.uri = paramh.field_cgi;
    locala.reqCmdId = paramh.field_cmdid;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.hKu = ((aug)this.rr.gUS.gUX);
    this.hKu.Due = paramh.field_functionmsgid;
    if (paramh.field_custombuff != null) {
      this.hKu.Duf = paramh.field_custombuff;
    }
    this.hKu.Dug = paramh.field_businessInfo;
    AppMethodBeat.o(114107);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(114108);
    if (this.hKw != null)
    {
      ad.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.hKw.field_functionmsgid });
      this.hKw.field_status = 1;
    }
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(114108);
    return i;
  }
  
  public final int getType()
  {
    return 825;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114109);
    this.hKv = ((auh)((b)paramq).gUT.gUX);
    this.hKx = this.hKv.Duf;
    ad.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.hKv.OpCode), Boolean.valueOf(bt.isNullOrNil(this.hKx)), Long.valueOf(this.hKv.Dql) });
    if (!bt.isNullOrNil(this.hKx))
    {
      this.hKu = ((aug)this.rr.gUS.gUX);
      this.hKu.Duf = this.hKx;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        ad.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(114109);
        return;
      }
      ad.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114109);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(this.hKw.field_reportid, this.hKw.field_successkey, 1L, false);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bn.a
 * JD-Core Version:    0.7.0.1
 */