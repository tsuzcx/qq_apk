package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private f callback;
  private String iHA;
  private final b rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(195292);
    this.iHA = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new czy();
    ((b.a)localObject).hNN = new czz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
    ((b.a)localObject).funcId = 243;
    this.rr = ((b.a)localObject).aDC();
    localObject = (czy)this.rr.hNK.hNQ;
    ((czy)localObject).iHA = paramString1;
    ((czy)localObject).Hqs = paramString2;
    ((czy)localObject).Fvw = paramString3;
    ((czy)localObject).Fvx = paramInt;
    ad.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(195292);
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
    ad.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iHA });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.o
 * JD-Core Version:    0.7.0.1
 */