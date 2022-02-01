package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.protocal.protobuf.ly;

public final class e
  extends q
  implements m
{
  public static int kir = 1;
  public static int kis = 2;
  private i callback;
  private d rr;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(127829);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new lx();
    ((d.a)localObject).iLO = new ly();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindemail";
    ((d.a)localObject).funcId = 256;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (lx)this.rr.iLK.iLR;
    ((lx)localObject).OpCode = paramInt;
    ((lx)localObject).KPz = paramString;
    AppMethodBeat.o(127829);
  }
  
  public final int Vj()
  {
    return ((lx)this.rr.iLK.iLR).OpCode;
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