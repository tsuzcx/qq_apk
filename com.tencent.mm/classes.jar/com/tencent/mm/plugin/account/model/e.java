package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.mp;

public final class e
  extends p
  implements m
{
  public static int pWA = 1;
  public static int pWB = 2;
  private h callback;
  private c rr;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(127829);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new mo();
    ((c.a)localObject).otF = new mp();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/bindemail";
    ((c.a)localObject).funcId = 256;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (mo)c.b.b(this.rr.otB);
    ((mo)localObject).YIq = paramInt;
    ((mo)localObject).YNN = paramString;
    AppMethodBeat.o(127829);
  }
  
  public final int bIO()
  {
    AppMethodBeat.i(304868);
    int i = ((mo)c.b.b(this.rr.otB)).YIq;
    AppMethodBeat.o(304868);
    return i;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(127830);
    this.callback = paramh;
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