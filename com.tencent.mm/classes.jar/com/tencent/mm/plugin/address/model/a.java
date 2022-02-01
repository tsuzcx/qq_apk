package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(20765);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aei();
    ((b.a)localObject).hNN = new aej();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
    ((b.a)localObject).funcId = 1194;
    this.rr = ((b.a)localObject).aDC();
    localObject = (aei)this.rr.hNK.hNQ;
    ((aei)localObject).Gcm = "invoice_info";
    ((aei)localObject).Gcn = paramInt;
    ((aei)localObject).dnh = 2;
    AppMethodBeat.o(20765);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20767);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.a
 * JD-Core Version:    0.7.0.1
 */