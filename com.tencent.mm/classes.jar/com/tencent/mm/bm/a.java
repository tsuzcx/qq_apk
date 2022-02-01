package com.tencent.mm.bm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends n
  implements k
{
  private g callback;
  private axm ikR;
  public axn ikS;
  public com.tencent.mm.api.h ikT;
  private String ikU;
  private b rr;
  
  public a(com.tencent.mm.api.h paramh)
  {
    AppMethodBeat.i(114107);
    this.callback = null;
    this.ikU = null;
    if (paramh == null)
    {
      AppMethodBeat.o(114107);
      return;
    }
    this.ikT = paramh;
    ac.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { paramh.field_cgi, Integer.valueOf(paramh.field_cmdid), paramh.field_functionmsgid });
    b.a locala = new b.a();
    locala.hvt = new axm();
    locala.hvu = new axn();
    locala.funcId = 825;
    locala.uri = paramh.field_cgi;
    locala.reqCmdId = paramh.field_cmdid;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.ikR = ((axm)this.rr.hvr.hvw);
    this.ikR.EPn = paramh.field_functionmsgid;
    if (paramh.field_custombuff != null) {
      this.ikR.EPo = paramh.field_custombuff;
    }
    this.ikR.EPp = paramh.field_businessInfo;
    AppMethodBeat.o(114107);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(114108);
    if (this.ikT != null)
    {
      ac.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.ikT.field_functionmsgid });
      this.ikT.field_status = 1;
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
    this.ikS = ((axn)((b)paramq).hvs.hvw);
    this.ikU = this.ikS.EPo;
    ac.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.ikS.OpCode), Boolean.valueOf(bs.isNullOrNil(this.ikU)), Long.valueOf(this.ikS.ELn) });
    if (!bs.isNullOrNil(this.ikU))
    {
      this.ikR = ((axm)this.rr.hvr.hvw);
      this.ikR.EPo = this.ikU;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        ac.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(114109);
        return;
      }
      ac.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114109);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(this.ikT.field_reportid, this.ikT.field_successkey, 1L, false);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bm.a
 * JD-Core Version:    0.7.0.1
 */