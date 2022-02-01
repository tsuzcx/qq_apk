package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  public int dae;
  private com.tencent.mm.ak.b gvE;
  public String oxf;
  private afv uiE;
  private afw uiF;
  
  public b(String paramString)
  {
    AppMethodBeat.i(65038);
    Object localObject = new b.a();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).hvt = new afv();
    ((b.a)localObject).hvu = new afw();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.gvE = ((b.a)localObject).aAz();
    this.uiE = ((afv)this.gvE.hvr.hvw);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.ero();
    if (localObject != null)
    {
      this.uiE.latitude = ((bb)localObject).latitude;
      this.uiE.longitude = ((bb)localObject).longitude;
    }
    this.uiE.Eye = paramString;
    AppMethodBeat.o(65038);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65039);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.uiF = ((afw)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    this.dae = this.uiF.dae;
    this.oxf = this.uiF.oxf;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.uiF.dae, this.uiF.oxf, this);
    }
    AppMethodBeat.o(65040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */