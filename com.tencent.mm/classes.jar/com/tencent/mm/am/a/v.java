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
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124319);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cft();
    ((b.a)localObject).gUV = new cfu();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
    ((b.a)localObject).funcId = 1358;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cft)this.rr.gUS.gUX;
    ((cft)localObject).CIQ = paramString1;
    ((cft)localObject).CIJ = paramString2;
    AppMethodBeat.o(124319);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124321);
    this.callback = paramg;
    ad.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124321);
    return i;
  }
  
  public final int getType()
  {
    return 1358;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124320);
    ad.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a.v
 * JD-Core Version:    0.7.0.1
 */