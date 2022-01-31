package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.sdk.platformtools.ab;

public final class u
  extends m
  implements k
{
  private f callback;
  public String fwO;
  public b rr;
  
  public u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11450);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ayo();
    ((b.a)localObject).fsY = new ayp();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((b.a)localObject).funcId = 674;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ayo)this.rr.fsV.fta;
    ((ayo)localObject).xok = paramString1;
    ((ayo)localObject).xol = paramString2;
    this.fwO = paramString1;
    AppMethodBeat.o(11450);
  }
  
  public final ayp afd()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (ayp)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11452);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneKFGetBindList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11452);
    return i;
  }
  
  public final int getType()
  {
    return 674;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11451);
    ab.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.u
 * JD-Core Version:    0.7.0.1
 */