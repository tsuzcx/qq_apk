package com.tencent.mm.bh;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.api.j;
import com.tencent.mm.bw.e;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private cki png;
  public ckj pnh;
  private e pni;
  public j pnj;
  private String pnk;
  private c rr;
  
  public a(j paramj, e parame)
  {
    AppMethodBeat.i(231441);
    this.pni = null;
    this.callback = null;
    this.pnk = null;
    if (paramj == null)
    {
      AppMethodBeat.o(231441);
      return;
    }
    this.pni = parame;
    this.pnj = paramj;
    Log.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { paramj.field_cgi, Integer.valueOf(paramj.field_cmdid), paramj.field_functionmsgid });
    parame = new c.a();
    parame.otE = new cki();
    parame.otF = new ckj();
    parame.funcId = 825;
    parame.uri = paramj.field_cgi;
    parame.otG = paramj.field_cmdid;
    parame.respCmdId = 0;
    this.rr = parame.bEF();
    this.png = ((cki)c.b.b(this.rr.otB));
    this.png.aasF = paramj.field_functionmsgid;
    if (paramj.field_custombuff != null) {
      this.png.aasG = paramj.field_custombuff;
    }
    this.png.aasH = paramj.field_businessInfo;
    paramj = this.png.aasF;
    long l = this.png.aasH.YYv;
    if (this.png.aasH.YYw != null) {}
    for (int i = this.png.aasH.YYw.Op.length;; i = 0)
    {
      Log.i("MicroMsg.NetSceneGetFuncMsg", "NetSceneGetFuncMsg request FunctionMsgID[%s] BusinessId[%d, %d]", new Object[] { paramj, Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(231441);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(114108);
    if (this.pnj != null)
    {
      Log.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.pnj.field_functionmsgid });
      this.pnj.field_status = 1;
    }
    this.callback = paramh;
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
    this.pnh = ((ckj)c.c.b(((c)params).otC));
    this.pnk = this.pnh.aasG;
    Log.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s, functionMsgId: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.pnh.YIq), Boolean.valueOf(Util.isNullOrNil(this.pnk)), Long.valueOf(this.pnh.aanC), this.pnj.field_functionmsgid });
    if (!Util.isNullOrNil(this.pnk))
    {
      this.png = ((cki)c.b.b(this.rr.otB));
      this.png.aasG = this.pnk;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0)) {
      if (paramInt2 == 4)
      {
        Log.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        if (this.pni != null) {
          this.pni.a(paramInt3, paramString, this);
        }
      }
    }
    for (;;)
    {
      this.pni = null;
      AppMethodBeat.o(114109);
      return;
      Log.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.pni != null)
      {
        this.pni.a(paramInt3, paramString, this);
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(this.pnj.field_reportid, this.pnj.field_successkey, 1L, false);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        if (this.pni != null) {
          this.pni.a(paramInt3, paramString, this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bh.a
 * JD-Core Version:    0.7.0.1
 */