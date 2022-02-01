package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.sdk.platformtools.ae;

public final class o
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public o(String paramString, auj paramauj, Object paramObject)
  {
    AppMethodBeat.i(124298);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new abz();
    ((b.a)localObject).hQG = new aca();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((b.a)localObject).funcId = 1355;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (abz)this.rr.hQD.hQJ;
    ((abz)localObject).FZx = paramString;
    ((abz)localObject).GtU = paramauj;
    this.data = paramObject;
    AppMethodBeat.o(124298);
  }
  
  public final aca aGK()
  {
    if ((this.rr != null) && (this.rr.hQE.hQJ != null)) {
      return (aca)this.rr.hQE.hQJ;
    }
    return null;
  }
  
  public final abz aGL()
  {
    if ((this.rr != null) && (this.rr.hQD.hQJ != null)) {
      return (abz)this.rr.hQD.hQJ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124300);
    this.callback = paramf;
    ae.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
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
    ae.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.o
 * JD-Core Version:    0.7.0.1
 */