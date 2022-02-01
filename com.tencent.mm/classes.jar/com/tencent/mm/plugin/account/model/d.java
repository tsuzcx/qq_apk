package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;

public final class d
  extends n
  implements k
{
  public static int iOm = 1;
  public static int iOn = 2;
  private g callback;
  private b rr;
  
  public d(int paramInt, String paramString)
  {
    AppMethodBeat.i(127829);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new kw();
    ((b.a)localObject).hvu = new kx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindemail";
    ((b.a)localObject).funcId = 256;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (kw)this.rr.hvr.hvw;
    ((kw)localObject).OpCode = paramInt;
    ((kw)localObject).DXX = paramString;
    AppMethodBeat.o(127829);
  }
  
  public final int Js()
  {
    return ((kw)this.rr.hvr.hvw).OpCode;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127830);
    this.callback = paramg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.d
 * JD-Core Version:    0.7.0.1
 */