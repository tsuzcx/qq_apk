package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(16722);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new yb();
    ((b.a)localObject).fsY = new yc();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
    ((b.a)localObject).funcId = 1194;
    this.rr = ((b.a)localObject).ado();
    localObject = (yb)this.rr.fsV.fta;
    ((yb)localObject).wPi = "invoice_info";
    ((yb)localObject).wPj = paramInt;
    ((yb)localObject).cpt = 2;
    AppMethodBeat.o(16722);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16724);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16724);
    return i;
  }
  
  public final int getType()
  {
    return 1194;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16723);
    ab.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ab.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.a
 * JD-Core Version:    0.7.0.1
 */