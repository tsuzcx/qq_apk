package com.tencent.mm.bk;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private b dmK;
  private f dmL = null;
  private afx eNp;
  public afy eNq;
  public com.tencent.mm.api.e eNr;
  private String eNs = null;
  
  public a(com.tencent.mm.api.e parame)
  {
    if (parame == null) {
      return;
    }
    this.eNr = parame;
    y.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", new Object[] { parame.field_cgi, Integer.valueOf(parame.field_cmdid), parame.field_functionmsgid });
    b.a locala = new b.a();
    locala.ecH = new afx();
    locala.ecI = new afy();
    locala.ecG = 825;
    locala.uri = parame.field_cgi;
    locala.ecJ = parame.field_cmdid;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.eNp = ((afx)this.dmK.ecE.ecN);
    this.eNp.tdL = parame.field_functionmsgid;
    if (parame.field_custombuff != null) {
      this.eNp.tdM = parame.field_custombuff;
    }
    this.eNp.tdN = parame.field_businessInfo;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    if (this.eNr != null)
    {
      y.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", new Object[] { this.eNr.field_functionmsgid });
      this.eNr.field_status = 1;
    }
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.eNq = ((afy)((b)paramq).ecF.ecN);
    this.eNs = this.eNq.tdM;
    y.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.eNq.ssq), Boolean.valueOf(bk.bl(this.eNs)), Long.valueOf(this.eNq.tdO) });
    if (!bk.bl(this.eNs))
    {
      this.eNp = ((afx)this.dmK.ecE.ecN);
      this.eNp.tdM = this.eNs;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (paramInt2 == 4)
      {
        y.i("MicroMsg.NetSceneGetFuncMsg", "server error");
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      y.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    h.nFQ.a(this.eNr.field_reportid, this.eNr.field_successkey, 1L, false);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 825;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bk.a
 * JD-Core Version:    0.7.0.1
 */