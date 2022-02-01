package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lh;

public final class d
  extends n
  implements k
{
  public static int jko = 1;
  public static int jkp = 2;
  private f callback;
  private b rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(127829);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new lg();
    ((b.a)localObject).hQG = new lh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindemail";
    ((b.a)localObject).funcId = 256;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (lg)this.rr.hQD.hQJ;
    ((lg)localObject).OpCode = paramInt;
    ((lg)localObject).FVO = paramString;
    AppMethodBeat.o(127829);
  }
  
  public final int KZ()
  {
    return ((lg)this.rr.hQD.hQJ).OpCode;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127830);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127830);
    return i;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127831);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.d
 * JD-Core Version:    0.7.0.1
 */