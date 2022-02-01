package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.vfs.i;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private int cUq;
  private com.tencent.mm.ak.g callback;
  private String clientId;
  private String dmK;
  public String hQO;
  private int hux;
  private com.tencent.mm.ak.b rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(90688);
    this.username = paramString;
    this.hux = 0;
    this.cUq = 0;
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    this.clientId = (a.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(90688);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.dmK = paramString2;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(90690);
    this.callback = paramg;
    if ((this.dmK == null) || (this.dmK.length() == 0))
    {
      ac.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(90690);
      return -1;
    }
    if (!i.eA(this.dmK))
    {
      ac.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.dmK);
      AppMethodBeat.o(90690);
      return -1;
    }
    if (this.hux == 0) {
      this.hux = ((int)new com.tencent.mm.vfs.e(this.dmK).length());
    }
    paramg = new b.a();
    paramg.hvt = new dmo();
    paramg.hvu = new dmp();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    paramg.funcId = 575;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.aAz();
    int i = Math.min(this.hux - this.cUq, 32768);
    paramg = i.aU(this.dmK, this.cUq, i);
    if (paramg == null)
    {
      ac.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(90690);
      return -1;
    }
    ac.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramg.length), Integer.valueOf(this.hux) });
    dmo localdmo = (dmo)this.rr.hvr.hvw;
    localdmo.EuR = this.username;
    localdmo.vTH = this.hux;
    localdmo.vTI = this.cUq;
    localdmo.vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
    localdmo.vTJ = localdmo.vTK.getILen();
    localdmo.hkN = this.clientId;
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(90690);
    return i;
  }
  
  public final int getType()
  {
    return 575;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90691);
    ac.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(90691);
      return;
    }
    paramq = (dmp)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    this.hQO = paramq.FkT;
    this.cUq = paramq.vTI;
    if (this.cUq < this.hux)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ac.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      ac.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
      AppMethodBeat.o(90691);
      return;
    }
    if (!bs.isNullOrNil(this.hQO))
    {
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.username);
      if ((paramq != null) && ((int)paramq.fLJ > 0) && (com.tencent.mm.n.b.ln(paramq.field_type)))
      {
        paramq.qI(this.hQO);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(this.username, paramq);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90691);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(90689);
    if ((this.dmK == null) || (this.dmK.length() == 0))
    {
      paramq = n.b.hwb;
      AppMethodBeat.o(90689);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(90689);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bd.b
 * JD-Core Version:    0.7.0.1
 */