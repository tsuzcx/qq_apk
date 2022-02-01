package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.vfs.i;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private int cWU;
  private com.tencent.mm.al.g callback;
  private String clientId;
  private String dpa;
  private int gTY;
  public String hqm;
  private com.tencent.mm.al.b rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(90688);
    this.username = paramString;
    this.gTY = 0;
    this.cWU = 0;
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    this.clientId = (a.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(90688);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.dpa = paramString2;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(90690);
    this.callback = paramg;
    if ((this.dpa == null) || (this.dpa.length() == 0))
    {
      ad.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(90690);
      return -1;
    }
    if (!i.eK(this.dpa))
    {
      ad.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.dpa);
      AppMethodBeat.o(90690);
      return -1;
    }
    if (this.gTY == 0) {
      this.gTY = ((int)new com.tencent.mm.vfs.e(this.dpa).length());
    }
    paramg = new b.a();
    paramg.gUU = new dgz();
    paramg.gUV = new dha();
    paramg.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    paramg.funcId = 575;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    this.rr = paramg.atI();
    int i = Math.min(this.gTY - this.cWU, 32768);
    paramg = i.aR(this.dpa, this.cWU, i);
    if (paramg == null)
    {
      ad.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(90690);
      return -1;
    }
    ad.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramg.length), Integer.valueOf(this.gTY) });
    dgz localdgz = (dgz)this.rr.gUS.gUX;
    localdgz.DbL = this.username;
    localdgz.uKQ = this.gTY;
    localdgz.uKR = this.cWU;
    localdgz.uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
    localdgz.uKS = localdgz.uKT.getILen();
    localdgz.gKn = this.clientId;
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
    ad.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(90691);
      return;
    }
    paramq = (dha)((com.tencent.mm.al.b)paramq).gUT.gUX;
    this.hqm = paramq.DOC;
    this.cWU = paramq.uKR;
    if (this.cWU < this.gTY)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ad.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      ad.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
      AppMethodBeat.o(90691);
      return;
    }
    if (!bt.isNullOrNil(this.hqm))
    {
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.username);
      if ((paramq != null) && ((int)paramq.fId > 0) && (com.tencent.mm.n.b.ls(paramq.field_type)))
      {
        paramq.nC(this.hqm);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(this.username, paramq);
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
    if ((this.dpa == null) || (this.dpa.length() == 0))
    {
      paramq = n.b.gVC;
      AppMethodBeat.o(90689);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(90689);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.b
 * JD-Core Version:    0.7.0.1
 */