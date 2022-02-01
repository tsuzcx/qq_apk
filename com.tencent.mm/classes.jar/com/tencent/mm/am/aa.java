package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.sdk.platformtools.ad;

public final class aa
  extends n
  implements k
{
  private g callback;
  public String gXY;
  public b rr;
  
  public aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124135);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bjw();
    ((b.a)localObject).gUV = new bjx();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((b.a)localObject).funcId = 674;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bjw)this.rr.gUS.gUX;
    ((bjw)localObject).DHX = paramString1;
    ((bjw)localObject).DHY = paramString2;
    this.gXY = paramString1;
    AppMethodBeat.o(124135);
  }
  
  public final bjx avZ()
  {
    if ((this.rr != null) && (this.rr.gUT.gUX != null)) {
      return (bjx)this.rr.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124137);
    this.callback = paramg;
    ad.i("MicroMsg.NetSceneKFGetBindList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124137);
    return i;
  }
  
  public final int getType()
  {
    return 674;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124136);
    ad.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.aa
 * JD-Core Version:    0.7.0.1
 */