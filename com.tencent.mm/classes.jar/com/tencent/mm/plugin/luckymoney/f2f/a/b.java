package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public int cnK;
  private com.tencent.mm.ai.b goo;
  public String kNv;
  private abe okB;
  private abf okC;
  
  public b(String paramString)
  {
    AppMethodBeat.i(42148);
    Object localObject = new b.a();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).fsX = new abe();
    ((b.a)localObject).fsY = new abf();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.goo = ((b.a)localObject).ado();
    this.okB = ((abe)this.goo.fsV.fta);
    localObject = com.tencent.mm.plugin.wallet_core.model.m.cTC();
    if (localObject != null)
    {
      this.okB.latitude = ((aw)localObject).latitude;
      this.okB.longitude = ((aw)localObject).longitude;
    }
    this.okB.wRG = paramString;
    AppMethodBeat.o(42148);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(42149);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(42149);
    return i;
  }
  
  public final int getType()
  {
    return 1971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42150);
    ab.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.okC = ((abf)((com.tencent.mm.ai.b)paramq).fsW.fta);
    this.cnK = this.okC.cnK;
    this.kNv = this.okC.kNv;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.okC.cnK, this.okC.kNv, this);
    }
    AppMethodBeat.o(42150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */