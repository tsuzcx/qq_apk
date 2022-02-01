package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends n
  implements k
{
  private g callback;
  private String iod;
  private final b rr;
  
  public o(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151219);
    this.iod = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cuo();
    ((b.a)localObject).hvu = new cup();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
    ((b.a)localObject).funcId = 243;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cuo)this.rr.hvr.hvw;
    ((cuo)localObject).iod = paramString1;
    ((cuo)localObject).FFT = paramString2;
    ((cuo)localObject).DQi = paramString3;
    ac.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(151219);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151220);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151220);
    return i;
  }
  
  public final int getType()
  {
    return 243;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151221);
    ac.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iod });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.o
 * JD-Core Version:    0.7.0.1
 */