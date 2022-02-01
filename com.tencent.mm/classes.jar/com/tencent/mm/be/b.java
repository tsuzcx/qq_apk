package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.protocal.protobuf.dsg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.i;

public final class b
  extends n
  implements k
{
  private f callback;
  private String clientId;
  private int dfG;
  private String dyy;
  private int hMP;
  public String ikc;
  private com.tencent.mm.al.b rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(90688);
    this.username = paramString;
    this.hMP = 0;
    this.dfG = 0;
    paramString = new StringBuilder();
    g.ajA();
    this.clientId = (a.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(90688);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.dyy = paramString2;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(90690);
    this.callback = paramf;
    if ((this.dyy == null) || (this.dyy.length() == 0))
    {
      ad.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(90690);
      return -1;
    }
    if (!i.fv(this.dyy))
    {
      ad.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.dyy);
      AppMethodBeat.o(90690);
      return -1;
    }
    if (this.hMP == 0) {
      this.hMP = ((int)new com.tencent.mm.vfs.e(this.dyy).length());
    }
    paramf = new b.a();
    paramf.hNM = new dsf();
    paramf.hNN = new dsg();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    paramf.funcId = 575;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.aDC();
    int i = Math.min(this.hMP - this.dfG, 32768);
    paramf = i.aY(this.dyy, this.dfG, i);
    if (paramf == null)
    {
      ad.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(90690);
      return -1;
    }
    ad.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(this.hMP) });
    dsf localdsf = (dsf)this.rr.hNK.hNQ;
    localdsf.Gcl = this.username;
    localdsf.xcK = this.hMP;
    localdsf.xcL = this.dfG;
    localdsf.xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
    localdsf.xcM = localdsf.xcN.getILen();
    localdsf.hCW = this.clientId;
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
    paramq = (dsg)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    this.ikc = paramq.GUB;
    this.dfG = paramq.xcL;
    if (this.dfG < this.hMP)
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
    if (!bt.isNullOrNil(this.ikc))
    {
      paramq = ((l)g.ab(l.class)).azp().Bf(this.username);
      if ((paramq != null) && ((int)paramq.gfj > 0) && (com.tencent.mm.o.b.lM(paramq.field_type)))
      {
        paramq.ts(this.ikc);
        ((l)g.ab(l.class)).azp().c(this.username, paramq);
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
    if ((this.dyy == null) || (this.dyy.length() == 0))
    {
      paramq = n.b.hOq;
      AppMethodBeat.o(90689);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(90689);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.b
 * JD-Core Version:    0.7.0.1
 */