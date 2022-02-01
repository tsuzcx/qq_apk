package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.sdk.platformtools.ae;

public final class p
  extends n
  implements k
{
  private f callback;
  boolean hVn;
  public b rr;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124301);
    this.hVn = false;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ayb();
    ((b.a)localObject).hQG = new ayc();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
    ((b.a)localObject).funcId = 1352;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ayb)this.rr.hQD.hQJ;
    ((ayb)localObject).FZq = paramString1;
    ((ayb)localObject).FZx = paramString2;
    this.hVn = true;
    AppMethodBeat.o(124301);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124303);
    this.callback = paramf;
    ae.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124303);
    return i;
  }
  
  public final int getType()
  {
    return 1352;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124302);
    ae.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.p
 * JD-Core Version:    0.7.0.1
 */