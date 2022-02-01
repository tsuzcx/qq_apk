package com.tencent.mm.bm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private bnq jDk;
  public bnr jDl;
  public com.tencent.mm.api.i jDm;
  private String jDn;
  private d rr;
  
  public a(com.tencent.mm.api.i parami)
  {
    AppMethodBeat.i(114107);
    this.callback = null;
    this.jDn = null;
    if (parami == null)
    {
      AppMethodBeat.o(114107);
      return;
    }
    this.jDm = parami;
    Log.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { parami.field_cgi, Integer.valueOf(parami.field_cmdid), parami.field_functionmsgid });
    d.a locala = new d.a();
    locala.iLN = new bnq();
    locala.iLO = new bnr();
    locala.funcId = 825;
    locala.uri = parami.field_cgi;
    locala.iLP = parami.field_cmdid;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.jDk = ((bnq)this.rr.iLK.iLR);
    this.jDk.LWd = parami.field_functionmsgid;
    if (parami.field_custombuff != null) {
      this.jDk.LWe = parami.field_custombuff;
    }
    this.jDk.LWf = parami.field_businessInfo;
    AppMethodBeat.o(114107);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(114108);
    if (this.jDm != null)
    {
      Log.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.jDm.field_functionmsgid });
      this.jDm.field_status = 1;
    }
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(114108);
    return i;
  }
  
  public final int getType()
  {
    return 825;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114109);
    this.jDl = ((bnr)((d)params).iLL.iLR);
    this.jDn = this.jDl.LWe;
    Log.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.jDl.OpCode), Boolean.valueOf(Util.isNullOrNil(this.jDn)), Long.valueOf(this.jDl.LRV) });
    if (!Util.isNullOrNil(this.jDn))
    {
      this.jDk = ((bnq)this.rr.iLK.iLR);
      this.jDk.LWe = this.jDn;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        Log.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(114109);
        return;
      }
      Log.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(114109);
      return;
    }
    h.CyF.idkeyStat(this.jDm.field_reportid, this.jDm.field_successkey, 1L, false);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bm.a
 * JD-Core Version:    0.7.0.1
 */