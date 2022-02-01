package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.protocal.protobuf.lo;

public final class e
  extends q
  implements m
{
  public static int mZR = 1;
  public static int mZS = 2;
  private i callback;
  private d rr;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(127829);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ln();
    ((d.a)localObject).lBV = new lo();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindemail";
    ((d.a)localObject).funcId = 256;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ln)d.b.b(this.rr.lBR);
    ((ln)localObject).RLe = paramInt;
    ((ln)localObject).RQx = paramString;
    AppMethodBeat.o(127829);
  }
  
  public final int ZB()
  {
    AppMethodBeat.i(220049);
    int i = ((ln)d.b.b(this.rr.lBR)).RLe;
    AppMethodBeat.o(220049);
    return i;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127830);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(127830);
    return i;
  }
  
  public final int getType()
  {
    return 256;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127831);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.e
 * JD-Core Version:    0.7.0.1
 */