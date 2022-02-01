package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends n
  implements k
{
  private g callback;
  public String hNH;
  public String hNQ;
  public String hNR;
  private final b rr;
  
  public q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151225);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new djj();
    ((b.a)localObject).gUV = new djk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((b.a)localObject).funcId = 853;
    this.rr = ((b.a)localObject).atI();
    this.hNH = paramString1;
    this.hNQ = paramString2;
    localObject = (djj)this.rr.gUS.gUX;
    ((djj)localObject).hNH = paramString1;
    ((djj)localObject).hNQ = paramString2;
    ad.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151225);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151227);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151227);
    return i;
  }
  
  public final int getType()
  {
    return 853;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151226);
    ad.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hNH });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.q
 * JD-Core Version:    0.7.0.1
 */