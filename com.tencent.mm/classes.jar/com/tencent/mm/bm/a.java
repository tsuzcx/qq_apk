package com.tencent.mm.bm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.api.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
  extends n
  implements k
{
  private f callback;
  private bce iHb;
  public bcf iHc;
  public h iHd;
  private String iHe;
  private b rr;
  
  public a(h paramh)
  {
    AppMethodBeat.i(114107);
    this.callback = null;
    this.iHe = null;
    if (paramh == null)
    {
      AppMethodBeat.o(114107);
      return;
    }
    this.iHd = paramh;
    ae.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { paramh.field_cgi, Integer.valueOf(paramh.field_cmdid), paramh.field_functionmsgid });
    b.a locala = new b.a();
    locala.hQF = new bce();
    locala.hQG = new bcf();
    locala.funcId = 825;
    locala.uri = paramh.field_cgi;
    locala.hQH = paramh.field_cmdid;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.iHb = ((bce)this.rr.hQD.hQJ);
    this.iHb.GRY = paramh.field_functionmsgid;
    if (paramh.field_custombuff != null) {
      this.iHb.GRZ = paramh.field_custombuff;
    }
    this.iHb.GSa = paramh.field_businessInfo;
    AppMethodBeat.o(114107);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(114108);
    if (this.iHd != null)
    {
      ae.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.iHd.field_functionmsgid });
      this.iHd.field_status = 1;
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
    this.iHc = ((bcf)((b)paramq).hQE.hQJ);
    this.iHe = this.iHc.GRZ;
    ae.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.iHc.OpCode), Boolean.valueOf(bu.isNullOrNil(this.iHe)), Long.valueOf(this.iHc.GNP) });
    if (!bu.isNullOrNil(this.iHe))
    {
      this.iHb = ((bce)this.rr.hQD.hQJ);
      this.iHb.GRZ = this.iHe;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        ae.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(114109);
        return;
      }
      ae.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114109);
      return;
    }
    g.yxI.idkeyStat(this.iHd.field_reportid, this.iHd.field_successkey, 1L, false);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bm.a
 * JD-Core Version:    0.7.0.1
 */