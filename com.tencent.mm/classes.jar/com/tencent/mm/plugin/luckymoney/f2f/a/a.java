package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.abd;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  private b goo;
  private abd okA;
  private abc okz;
  
  public a(String paramString)
  {
    AppMethodBeat.i(42145);
    b.a locala = new b.a();
    locala.fsX = new abc();
    locala.fsY = new abd();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.goo = locala.ado();
    this.okz = ((abc)this.goo.fsV.fta);
    this.okz.ojA = paramString;
    AppMethodBeat.o(42145);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(42147);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(42147);
    return i;
  }
  
  public final int getType()
  {
    return 1987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42146);
    this.okA = ((abd)((b)paramq).fsW.fta);
    ab.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.okA.cnK), this.okA.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.okA.cnK, this.okA.kNv, this);
    }
    AppMethodBeat.o(42146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */