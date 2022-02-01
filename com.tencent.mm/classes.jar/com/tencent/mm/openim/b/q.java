package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends n
  implements k
{
  private f callback;
  public String iHA;
  public String iHJ;
  public String iHK;
  private final b rr;
  
  public q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195293);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dup();
    ((b.a)localObject).hNN = new duq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((b.a)localObject).funcId = 853;
    this.rr = ((b.a)localObject).aDC();
    this.iHA = paramString1;
    this.iHJ = paramString2;
    localObject = (dup)this.rr.hNK.hNQ;
    ((dup)localObject).iHA = paramString1;
    ((dup)localObject).iHJ = paramString2;
    ((dup)localObject).Fvx = paramInt;
    ad.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(195293);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151227);
    this.callback = paramf;
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
    ad.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iHA });
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