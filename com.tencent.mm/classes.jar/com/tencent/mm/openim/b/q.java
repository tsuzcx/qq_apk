package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.sdk.platformtools.ac;

public final class q
  extends n
  implements k
{
  private g callback;
  public String iod;
  public String iom;
  public String ion;
  private final b rr;
  
  public q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151225);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new doy();
    ((b.a)localObject).hvu = new doz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((b.a)localObject).funcId = 853;
    this.rr = ((b.a)localObject).aAz();
    this.iod = paramString1;
    this.iom = paramString2;
    localObject = (doy)this.rr.hvr.hvw;
    ((doy)localObject).iod = paramString1;
    ((doy)localObject).iom = paramString2;
    ac.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
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
    ac.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iod });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.q
 * JD-Core Version:    0.7.0.1
 */