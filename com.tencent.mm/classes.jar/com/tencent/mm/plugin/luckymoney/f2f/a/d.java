package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;

public final class d
  extends n
  implements com.tencent.mm.network.k, j
{
  private g callback;
  public String dcE;
  private b iaa;
  public String sZn;
  private afc taE;
  private afd taF;
  public String taG;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65044);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new afc();
    ((b.a)localObject).gUV = new afd();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.iaa = ((b.a)localObject).atI();
    this.taE = ((afc)this.iaa.gUS.gUX);
    this.taE.nTB = paramInt1;
    this.taE.uxV = paramInt2;
    this.taE.dDN = paramInt3;
    this.taE.Dff = paramInt4;
    localObject = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    if (localObject != null)
    {
      this.taE.latitude = ((az)localObject).latitude;
      this.taE.longitude = ((az)localObject).longitude;
    }
    AppMethodBeat.o(65044);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65046);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(65046);
    return i;
  }
  
  public final int getType()
  {
    return 1970;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65045);
    ad.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.taF = ((afd)((b)paramq).gUT.gUX);
    this.dcE = this.taF.rcq;
    this.sZn = this.taF.sZn;
    this.taG = this.taF.tfK;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */