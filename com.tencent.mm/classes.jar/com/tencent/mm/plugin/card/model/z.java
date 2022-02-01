package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public CardGiftInfo wuB;
  
  public z(int paramInt, String paramString)
  {
    AppMethodBeat.i(112834);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cgj();
    ((c.a)localObject).otF = new cgk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
    ((c.a)localObject).funcId = 1165;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cgj)c.b.b(this.rr.otB);
    ((cgj)localObject).YBh = paramInt;
    ((cgj)localObject).YBi = paramString;
    AppMethodBeat.o(112834);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112836);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112836);
    return i;
  }
  
  public final int getType()
  {
    return 1165;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112835);
    Log.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.wuB = CardGiftInfo.a((cgk)c.c.b(this.rr.otC));
      Log.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[] { this.wuB.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.z
 * JD-Core Version:    0.7.0.1
 */