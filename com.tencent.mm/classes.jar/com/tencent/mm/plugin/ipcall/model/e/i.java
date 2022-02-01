package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private g callback;
  private b rr;
  public ccu sCW;
  public ccv sCX;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25475);
    this.rr = null;
    this.sCW = null;
    this.sCX = null;
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ccu();
    ((b.a)localObject).gUV = new ccv();
    ((b.a)localObject).funcId = 991;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    long l = System.currentTimeMillis();
    int i = c.cIH();
    localObject = (ccu)this.rr.gUS.gUX;
    ((ccu)localObject).sdQ = u.aqG();
    ((ccu)localObject).DYW = paramString2;
    ((ccu)localObject).sdP = paramString1;
    ((ccu)localObject).DYV = paramInt1;
    ((ccu)localObject).CYi = i;
    ((ccu)localObject).DZe = 1;
    ((ccu)localObject).DYU = l;
    ((ccu)localObject).DZd = paramInt2;
    ((ccu)localObject).DZf = paramInt3;
    this.sCW = ((ccu)localObject);
    ad.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(25475);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25476);
    this.callback = paramg;
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
    this.sCX = ((ccv)((b)paramq).gUT.gUX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.i
 * JD-Core Version:    0.7.0.1
 */