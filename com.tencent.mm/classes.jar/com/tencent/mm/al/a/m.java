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
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k
{
  private f callback;
  private Object data;
  public b rr;
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124292);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ng();
    ((b.a)localObject).hQG = new nh();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((b.a)localObject).funcId = 1364;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ng)this.rr.hQD.hQJ;
    ((ng)localObject).FZx = paramString1;
    ((ng)localObject).dmf = paramString2;
    ((ng)localObject).offset = paramInt;
    this.data = null;
    AppMethodBeat.o(124292);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124294);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
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
    ae.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.m
 * JD-Core Version:    0.7.0.1
 */