package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.sdk.platformtools.ac;

public final class p
  extends n
  implements k
{
  private g callback;
  boolean hAa;
  public b rr;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124301);
    this.hAa = false;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new atn();
    ((b.a)localObject).hvu = new ato();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
    ((b.a)localObject).funcId = 1352;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (atn)this.rr.hvr.hvw;
    ((atn)localObject).Ebl = paramString1;
    ((atn)localObject).Ebs = paramString2;
    this.hAa = true;
    AppMethodBeat.o(124301);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124303);
    this.callback = paramg;
    ac.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
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
    ac.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.p
 * JD-Core Version:    0.7.0.1
 */