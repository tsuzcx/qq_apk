package com.tencent.mm.am.a;

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
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private g callback;
  Object data;
  public b rr;
  
  public o(String paramString, amv paramamv, Object paramObject)
  {
    AppMethodBeat.i(124298);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new yv();
    ((b.a)localObject).gUV = new yw();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((b.a)localObject).funcId = 1355;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (yv)this.rr.gUS.gUX;
    ((yv)localObject).CIQ = paramString;
    ((yv)localObject).DaY = paramamv;
    this.data = paramObject;
    AppMethodBeat.o(124298);
  }
  
  public final yv awA()
  {
    if ((this.rr != null) && (this.rr.gUS.gUX != null)) {
      return (yv)this.rr.gUS.gUX;
    }
    return null;
  }
  
  public final yw awz()
  {
    if ((this.rr != null) && (this.rr.gUT.gUX != null)) {
      return (yw)this.rr.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124300);
    this.callback = paramg;
    ad.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124300);
    return i;
  }
  
  public final int getType()
  {
    return 1355;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124299);
    ad.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.o
 * JD-Core Version:    0.7.0.1
 */