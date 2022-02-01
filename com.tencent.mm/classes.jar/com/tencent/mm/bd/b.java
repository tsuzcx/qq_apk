package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dtc;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.o;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String clientId;
  private int dgI;
  private String dzD;
  private int hPI;
  public String imV;
  private com.tencent.mm.ak.b rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(90688);
    this.username = paramString;
    this.hPI = 0;
    this.dgI = 0;
    paramString = new StringBuilder();
    g.ajP();
    this.clientId = (a.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(90688);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.dzD = paramString2;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(90690);
    this.callback = paramf;
    if ((this.dzD == null) || (this.dzD.length() == 0))
    {
      ae.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(90690);
      return -1;
    }
    if (!o.fB(this.dzD))
    {
      ae.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.dzD);
      AppMethodBeat.o(90690);
      return -1;
    }
    if (this.hPI == 0) {
      this.hPI = ((int)new com.tencent.mm.vfs.k(this.dzD).length());
    }
    paramf = new b.a();
    paramf.hQF = new dtc();
    paramf.hQG = new dtd();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    paramf.funcId = 575;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDS();
    int i = Math.min(this.hPI - this.dgI, 32768);
    paramf = o.bb(this.dzD, this.dgI, i);
    if (paramf == null)
    {
      ae.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(90690);
      return -1;
    }
    ae.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(this.hPI) });
    dtc localdtc = (dtc)this.rr.hQD.hQJ;
    localdtc.GuS = this.username;
    localdtc.xsB = this.hPI;
    localdtc.xsC = this.dgI;
    localdtc.xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
    localdtc.xsD = localdtc.xsE.getILen();
    localdtc.hFO = this.clientId;
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
    ae.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(90691);
      return;
    }
    paramq = (dtd)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    this.imV = paramq.Hoc;
    this.dgI = paramq.xsC;
    if (this.dgI < this.hPI)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ae.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      ae.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
      AppMethodBeat.o(90691);
      return;
    }
    if (!bu.isNullOrNil(this.imV))
    {
      paramq = ((l)g.ab(l.class)).azF().BH(this.username);
      if ((paramq != null) && ((int)paramq.ght > 0) && (c.lO(paramq.field_type)))
      {
        paramq.tN(this.imV);
        ((l)g.ab(l.class)).azF().c(this.username, paramq);
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
    if ((this.dzD == null) || (this.dzD.length() == 0))
    {
      paramq = n.b.hRj;
      AppMethodBeat.o(90689);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(90689);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.b
 * JD-Core Version:    0.7.0.1
 */