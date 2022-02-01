package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b iaa;
  public String oYa;
  public String sZn;
  private afa taH;
  private afb taI;
  public String taJ;
  public String taK;
  public int taL;
  
  public e()
  {
    AppMethodBeat.i(65047);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new afa();
    ((b.a)localObject).gUV = new afb();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.iaa = ((b.a)localObject).atI();
    this.taH = ((afa)this.iaa.gUS.gUX);
    this.taH.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.ebS();
    if (localObject != null)
    {
      this.taH.latitude = ((az)localObject).latitude;
      this.taH.longitude = ((az)localObject).longitude;
    }
    AppMethodBeat.o(65047);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(65049);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(65049);
    return i;
  }
  
  public final int getType()
  {
    return 1990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65048);
    ad.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.taI = ((afb)((b)paramq).gUT.gUX);
    this.sZn = this.taI.sZn;
    this.oYa = this.taI.oYa;
    this.taL = this.taI.Dfe;
    this.taJ = this.taI.taJ;
    this.taK = this.taI.taK;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.taI.dcG, this.taI.nTK, this);
    }
    AppMethodBeat.o(65048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */