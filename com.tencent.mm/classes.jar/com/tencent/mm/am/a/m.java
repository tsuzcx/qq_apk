package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private g callback;
  private Object data;
  public b rr;
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124292);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new mi();
    ((b.a)localObject).gUV = new mj();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((b.a)localObject).funcId = 1364;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (mi)this.rr.gUS.gUX;
    ((mi)localObject).CIQ = paramString1;
    ((mi)localObject).dcm = paramString2;
    ((mi)localObject).offset = paramInt;
    this.data = null;
    AppMethodBeat.o(124292);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124294);
    this.callback = paramg;
    ad.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124294);
    return i;
  }
  
  public final int getType()
  {
    return 1364;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124293);
    ad.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.m
 * JD-Core Version:    0.7.0.1
 */