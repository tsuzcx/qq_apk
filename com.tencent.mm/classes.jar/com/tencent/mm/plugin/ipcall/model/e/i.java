package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends n
  implements k
{
  private g callback;
  private b rr;
  public chx tKE;
  public chy tKF;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25475);
    this.rr = null;
    this.tKE = null;
    this.tKF = null;
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new chx();
    ((b.a)localObject).hvu = new chy();
    ((b.a)localObject).funcId = 991;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    long l = System.currentTimeMillis();
    int i = c.cVS();
    localObject = (chx)this.rr.hvr.hvw;
    ((chx)localObject).tlK = u.axw();
    ((chx)localObject).FvS = paramString2;
    ((chx)localObject).tlJ = paramString1;
    ((chx)localObject).FvR = paramInt1;
    ((chx)localObject).EqS = i;
    ((chx)localObject).Fwa = 1;
    ((chx)localObject).FvQ = l;
    ((chx)localObject).FvZ = paramInt2;
    ((chx)localObject).Fwb = paramInt3;
    this.tKE = ((chx)localObject);
    ac.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
    ac.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKF = ((chy)((b)paramq).hvs.hvw);
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