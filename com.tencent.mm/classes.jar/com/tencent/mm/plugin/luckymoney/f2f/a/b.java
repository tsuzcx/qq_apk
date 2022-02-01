package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  public int dcG;
  private com.tencent.mm.al.b iaa;
  public String nTK;
  private aew tap;
  private aex taq;
  
  public b(String paramString)
  {
    AppMethodBeat.i(65038);
    Object localObject = new b.a();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).gUU = new aew();
    ((b.a)localObject).gUV = new aex();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.iaa = ((b.a)localObject).atI();
    this.tap = ((aew)this.iaa.gUS.gUX);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    if (localObject != null)
    {
      this.tap.latitude = ((az)localObject).latitude;
      this.tap.longitude = ((az)localObject).longitude;
    }
    this.tap.DeY = paramString;
    AppMethodBeat.o(65038);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65039);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    ad.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.taq = ((aex)((com.tencent.mm.al.b)paramq).gUT.gUX);
    this.dcG = this.taq.dcG;
    this.nTK = this.taq.nTK;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.taq.dcG, this.taq.nTK, this);
    }
    AppMethodBeat.o(65040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */