package com.tencent.mm.bp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private bvg mtN;
  public bvh mtO;
  public com.tencent.mm.api.i mtP;
  private String mtQ;
  private d rr;
  
  public a(com.tencent.mm.api.i parami)
  {
    AppMethodBeat.i(114107);
    this.callback = null;
    this.mtQ = null;
    if (parami == null)
    {
      AppMethodBeat.o(114107);
      return;
    }
    this.mtP = parami;
    Log.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { parami.field_cgi, Integer.valueOf(parami.field_cmdid), parami.field_functionmsgid });
    d.a locala = new d.a();
    locala.lBU = new bvg();
    locala.lBV = new bvh();
    locala.funcId = 825;
    locala.uri = parami.field_cgi;
    locala.lBW = parami.field_cmdid;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.mtN = ((bvg)d.b.b(this.rr.lBR));
    this.mtN.Tfl = parami.field_functionmsgid;
    if (parami.field_custombuff != null) {
      this.mtN.Tfm = parami.field_custombuff;
    }
    this.mtN.Tfn = parami.field_businessInfo;
    parami = this.mtN.Tfl;
    long l = this.mtN.Tfn.Saw;
    if (this.mtN.Tfn.Sax != null) {}
    for (int i = this.mtN.Tfn.Sax.UH.length;; i = 0)
    {
      Log.i("MicroMsg.NetSceneGetFuncMsg", "NetSceneGetFuncMsg request FunctionMsgID[%s] BusinessId[%d, %d]", new Object[] { parami, Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(114107);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(114108);
    if (this.mtP != null)
    {
      Log.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.mtP.field_functionmsgid });
      this.mtP.field_status = 1;
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
    this.mtO = ((bvh)d.c.b(((d)params).lBS));
    this.mtQ = this.mtO.Tfm;
    Log.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.mtO.RLe), Boolean.valueOf(Util.isNullOrNil(this.mtQ)), Long.valueOf(this.mtO.TaE) });
    if (!Util.isNullOrNil(this.mtQ))
    {
      this.mtN = ((bvg)d.b.b(this.rr.lBR));
      this.mtN.Tfm = this.mtQ;
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
    h.IzE.idkeyStat(this.mtP.field_reportid, this.mtP.field_successkey, 1L, false);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(114109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bp.a
 * JD-Core Version:    0.7.0.1
 */