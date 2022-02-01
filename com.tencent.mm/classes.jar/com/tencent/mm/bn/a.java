package com.tencent.mm.bn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.api.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends n
  implements k
{
  private f callback;
  private bbo iEi;
  public bbp iEj;
  public h iEk;
  private String iEl;
  private b rr;
  
  public a(h paramh)
  {
    AppMethodBeat.i(114107);
    this.callback = null;
    this.iEl = null;
    if (paramh == null)
    {
      AppMethodBeat.o(114107);
      return;
    }
    this.iEk = paramh;
    ad.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { paramh.field_cgi, Integer.valueOf(paramh.field_cmdid), paramh.field_functionmsgid });
    b.a locala = new b.a();
    locala.hNM = new bbo();
    locala.hNN = new bbp();
    locala.funcId = 825;
    locala.uri = paramh.field_cgi;
    locala.hNO = paramh.field_cmdid;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.iEi = ((bbo)this.rr.hNK.hNQ);
    this.iEi.Gyy = paramh.field_functionmsgid;
    if (paramh.field_custombuff != null) {
      this.iEi.Gyz = paramh.field_custombuff;
    }
    this.iEi.GyA = paramh.field_businessInfo;
    AppMethodBeat.o(114107);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(114108);
    if (this.iEk != null)
    {
      ad.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.iEk.field_functionmsgid });
      this.iEk.field_status = 1;
    }
    this.callback = paramf;
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
    this.iEj = ((bbp)((b)paramq).hNL.hNQ);
    this.iEl = this.iEj.Gyz;
    ad.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.iEj.OpCode), Boolean.valueOf(bt.isNullOrNil(this.iEl)), Long.valueOf(this.iEj.Guq) });
    if (!bt.isNullOrNil(this.iEl))
    {
      this.iEi = ((bbo)this.rr.hNK.hNQ);
      this.iEi.Gyz = this.iEl;
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
    g.yhR.idkeyStat(this.iEk.field_reportid, this.iEk.field_successkey, 1L, false);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bn.a
 * JD-Core Version:    0.7.0.1
 */