package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private b goo;
  public String lHq;
  public String ojA;
  private abi okR;
  private abj okS;
  public String okT;
  public String okU;
  public int okV;
  
  public e()
  {
    AppMethodBeat.i(42157);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new abi();
    ((b.a)localObject).fsY = new abj();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.goo = ((b.a)localObject).ado();
    this.okR = ((abi)this.goo.fsV.fta);
    this.okR.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    if (localObject != null)
    {
      this.okR.latitude = ((aw)localObject).latitude;
      this.okR.longitude = ((aw)localObject).longitude;
    }
    AppMethodBeat.o(42157);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(42159);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(42159);
    return i;
  }
  
  public final int getType()
  {
    return 1990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42158);
    ab.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.okS = ((abj)((b)paramq).fsW.fta);
    this.ojA = this.okS.ojA;
    this.lHq = this.okS.lHq;
    this.okV = this.okS.wRM;
    this.okT = this.okS.okT;
    this.okU = this.okS.okU;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.okS.cnK, this.okS.kNv, this);
    }
    AppMethodBeat.o(42158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */