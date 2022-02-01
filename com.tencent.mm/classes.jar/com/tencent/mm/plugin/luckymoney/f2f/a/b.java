package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  public int dmy;
  private com.tencent.mm.ak.b gRX;
  public String phe;
  private aiv vxr;
  private aiw vxs;
  
  public b(String paramString)
  {
    AppMethodBeat.i(65038);
    Object localObject = new b.a();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).hQF = new aiv();
    ((b.a)localObject).hQG = new aiw();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.gRX = ((b.a)localObject).aDS();
    this.vxr = ((aiv)this.gRX.hQD.hQJ);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.eIV();
    if (localObject != null)
    {
      this.vxr.latitude = ((bb)localObject).latitude;
      this.vxr.longitude = ((bb)localObject).longitude;
    }
    this.vxr.Gyy = paramString;
    AppMethodBeat.o(65038);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65039);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(65039);
    return i;
  }
  
  public final int getType()
  {
    return 1971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65040);
    ae.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vxs = ((aiw)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    this.dmy = this.vxs.dmy;
    this.phe = this.vxs.phe;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vxs.dmy, this.vxs.phe, this);
    }
    AppMethodBeat.o(65040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */