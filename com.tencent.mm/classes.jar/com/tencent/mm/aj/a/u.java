package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.sdk.platformtools.ab;

public final class u
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11633);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bqu();
    ((b.a)localObject).fsY = new bqv();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
    ((b.a)localObject).funcId = 1358;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bqu)this.rr.fsV.fta;
    ((bqu)localObject).wyh = paramString1;
    ((bqu)localObject).wyb = paramString2;
    AppMethodBeat.o(11633);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11635);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11635);
    return i;
  }
  
  public final int getType()
  {
    return 1358;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11634);
    ab.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.a.u
 * JD-Core Version:    0.7.0.1
 */