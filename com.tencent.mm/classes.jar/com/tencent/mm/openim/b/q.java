package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  extends n
  implements k
{
  private f callback;
  public String iKC;
  public String iKD;
  public String iKt;
  private final b rr;
  
  public q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(218746);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dvm();
    ((b.a)localObject).hQG = new dvn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((b.a)localObject).funcId = 853;
    this.rr = ((b.a)localObject).aDS();
    this.iKt = paramString1;
    this.iKC = paramString2;
    localObject = (dvm)this.rr.hQD.hQJ;
    ((dvm)localObject).iKt = paramString1;
    ((dvm)localObject).iKC = paramString2;
    ((dvm)localObject).FNV = paramInt;
    ae.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(218746);
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
    ae.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iKt });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.b.q
 * JD-Core Version:    0.7.0.1
 */