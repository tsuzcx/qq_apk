package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;

public final class d
  extends com.tencent.mm.ai.m
  implements k, i
{
  private f callback;
  public String cnI;
  private b goo;
  public String ojA;
  private abk okO;
  private abl okP;
  public String okQ;
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42154);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new abk();
    ((b.a)localObject).fsY = new abl();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
    this.goo = ((b.a)localObject).ado();
    this.okO = ((abk)this.goo.fsV.fta);
    this.okO.kNn = paramInt1;
    this.okO.pwn = paramInt2;
    this.okO.cMP = paramInt3;
    this.okO.wRN = paramInt4;
    localObject = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    if (localObject != null)
    {
      this.okO.latitude = ((aw)localObject).latitude;
      this.okO.longitude = ((aw)localObject).longitude;
    }
    AppMethodBeat.o(42154);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(42156);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(42156);
    return i;
  }
  
  public final int getType()
  {
    return 1970;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42155);
    ab.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.okP = ((abl)((b)paramq).fsW.fta);
    this.cnI = this.okP.opy;
    this.ojA = this.okP.ojA;
    this.okQ = this.okP.opF;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(42155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.d
 * JD-Core Version:    0.7.0.1
 */