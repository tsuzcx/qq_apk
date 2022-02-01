package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private f callback;
  private b rr;
  public cmx uNr;
  public cmy uNs;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25475);
    this.rr = null;
    this.uNr = null;
    this.uNs = null;
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cmx();
    ((b.a)localObject).hNN = new cmy();
    ((b.a)localObject).funcId = 991;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    long l = System.currentTimeMillis();
    int i = c.dfd();
    localObject = (cmx)this.rr.hNK.hNQ;
    ((cmx)localObject).ukj = u.aAm();
    ((cmx)localObject).HfY = paramString2;
    ((cmx)localObject).uki = paramString1;
    ((cmx)localObject).HfX = paramInt1;
    ((cmx)localObject).FYc = i;
    ((cmx)localObject).Hgg = 1;
    ((cmx)localObject).HfW = l;
    ((cmx)localObject).Hgf = paramInt2;
    ((cmx)localObject).Hgh = paramInt3;
    this.uNr = ((cmx)localObject);
    ad.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(25475);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25476);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25476);
    return i;
  }
  
  public final int getType()
  {
    return 991;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25477);
    ad.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNs = ((cmy)((b)paramq).hNL.hNQ);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(25477);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.i
 * JD-Core Version:    0.7.0.1
 */