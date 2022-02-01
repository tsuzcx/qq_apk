package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;

public final class d
  extends n
  implements com.tencent.mm.network.k, j
{
  private f callback;
  public String dlu;
  private b gPp;
  public String vkl;
  private air vlB;
  private ais vlC;
  public String vlD;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65044);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new air();
    ((b.a)localObject).hNN = new ais();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.gPp = ((b.a)localObject).aDC();
    this.vlB = ((air)this.gPp.hNK.hNQ);
    this.vlB.par = paramInt1;
    this.vlB.wNV = paramInt2;
    this.vlB.dNM = paramInt3;
    this.vlB.GfX = paramInt4;
    localObject = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    if (localObject != null)
    {
      this.vlB.latitude = ((bb)localObject).latitude;
      this.vlB.longitude = ((bb)localObject).longitude;
    }
    AppMethodBeat.o(65044);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65046);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    this.vlC = ((ais)((b)paramq).hNL.hNQ);
    this.dlu = this.vlC.thm;
    this.vkl = this.vlC.vkl;
    this.vlD = this.vlC.vqD;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(65045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */