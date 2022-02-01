package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(20765);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new abj();
    ((b.a)localObject).gUV = new abk();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
    ((b.a)localObject).funcId = 1194;
    this.rr = ((b.a)localObject).atI();
    localObject = (abj)this.rr.gUS.gUX;
    ((abj)localObject).DbM = "invoice_info";
    ((abj)localObject).DbN = paramInt;
    ((abj)localObject).dep = 2;
    AppMethodBeat.o(20765);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20767);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20767);
    return i;
  }
  
  public final int getType()
  {
    return 1194;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20766);
    ad.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.a
 * JD-Core Version:    0.7.0.1
 */