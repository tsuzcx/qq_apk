package com.tencent.mm.bl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private akq gcV;
  public akr gcW;
  public com.tencent.mm.api.f gcX;
  private String gcY;
  private b rr;
  
  public a(com.tencent.mm.api.f paramf)
  {
    AppMethodBeat.i(35455);
    this.callback = null;
    this.gcY = null;
    if (paramf == null)
    {
      AppMethodBeat.o(35455);
      return;
    }
    this.gcX = paramf;
    ab.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { paramf.field_cgi, Integer.valueOf(paramf.field_cmdid), paramf.field_functionmsgid });
    b.a locala = new b.a();
    locala.fsX = new akq();
    locala.fsY = new akr();
    locala.funcId = 825;
    locala.uri = paramf.field_cgi;
    locala.reqCmdId = paramf.field_cmdid;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.gcV = ((akq)this.rr.fsV.fta);
    this.gcV.xbK = paramf.field_functionmsgid;
    if (paramf.field_custombuff != null) {
      this.gcV.xbL = paramf.field_custombuff;
    }
    this.gcV.xbM = paramf.field_businessInfo;
    AppMethodBeat.o(35455);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(35456);
    if (this.gcX != null)
    {
      ab.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.gcX.field_functionmsgid });
      this.gcX.field_status = 1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(35456);
    return i;
  }
  
  public final int getType()
  {
    return 825;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(35457);
    this.gcW = ((akr)((b)paramq).fsW.fta);
    this.gcY = this.gcW.xbL;
    ab.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.gcW.OpCode), Boolean.valueOf(bo.isNullOrNil(this.gcY)), Long.valueOf(this.gcW.xbN) });
    if (!bo.isNullOrNil(this.gcY))
    {
      this.gcV = ((akq)this.rr.fsV.fta);
      this.gcV.xbL = this.gcY;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        ab.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(35457);
        return;
      }
      ab.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(35457);
      return;
    }
    h.qsU.idkeyStat(this.gcX.field_reportid, this.gcX.field_successkey, 1L, false);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(35457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bl.a
 * JD-Core Version:    0.7.0.1
 */