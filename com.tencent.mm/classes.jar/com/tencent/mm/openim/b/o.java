package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.sdk.platformtools.ae;

public final class o
  extends n
  implements k
{
  private f callback;
  private String iKt;
  private final b rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(218745);
    this.iKt = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new das();
    ((b.a)localObject).hQG = new dat();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
    ((b.a)localObject).funcId = 243;
    this.rr = ((b.a)localObject).aDS();
    localObject = (das)this.rr.hQD.hQJ;
    ((das)localObject).iKt = paramString1;
    ((das)localObject).HJU = paramString2;
    ((das)localObject).FNU = paramString3;
    ((das)localObject).FNV = paramInt;
    ae.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(218745);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151220);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iKt });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.o
 * JD-Core Version:    0.7.0.1
 */