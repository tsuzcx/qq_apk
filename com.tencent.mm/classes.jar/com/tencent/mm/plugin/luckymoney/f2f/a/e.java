package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b gPp;
  public String qeQ;
  public String vkl;
  private aip vlE;
  private aiq vlF;
  public String vlG;
  public String vlH;
  public int vlI;
  
  public e()
  {
    AppMethodBeat.i(65047);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aip();
    ((b.a)localObject).hNN = new aiq();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.gPp = ((b.a)localObject).aDC();
    this.vlE = ((aip)this.gPp.hNK.hNQ);
    this.vlE.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    if (localObject != null)
    {
      this.vlE.latitude = ((bb)localObject).latitude;
      this.vlE.longitude = ((bb)localObject).longitude;
    }
    AppMethodBeat.o(65047);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(65049);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    this.vlF = ((aiq)((b)paramq).hNL.hNQ);
    this.vkl = this.vlF.vkl;
    this.qeQ = this.vlF.qeQ;
    this.vlI = this.vlF.GfW;
    this.vlG = this.vlF.vlG;
    this.vlH = this.vlF.vlH;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vlF.dlw, this.vlF.paA, this);
    }
    AppMethodBeat.o(65048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */