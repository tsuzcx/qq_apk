package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends n
  implements k
{
  private f callback;
  private b rr;
  public cnr uZe;
  public cns uZf;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25475);
    this.rr = null;
    this.uZe = null;
    this.uZf = null;
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cnr();
    ((b.a)localObject).hQG = new cns();
    ((b.a)localObject).funcId = 991;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    long l = System.currentTimeMillis();
    int i = c.dhV();
    localObject = (cnr)this.rr.hQD.hQJ;
    ((cnr)localObject).uvG = v.aAC();
    ((cnr)localObject).Hzy = paramString2;
    ((cnr)localObject).uvF = paramString1;
    ((cnr)localObject).Hzx = paramInt1;
    ((cnr)localObject).GqB = i;
    ((cnr)localObject).HzG = 1;
    ((cnr)localObject).Hzw = l;
    ((cnr)localObject).HzF = paramInt2;
    ((cnr)localObject).HzH = paramInt3;
    this.uZe = ((cnr)localObject);
    ae.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
    ae.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZf = ((cns)((b)paramq).hQE.hQJ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.i
 * JD-Core Version:    0.7.0.1
 */