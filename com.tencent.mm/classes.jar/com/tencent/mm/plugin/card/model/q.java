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
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public CardGiftInfo wuB;
  
  public q(int paramInt, String paramString1, String paramString2, Boolean paramBoolean)
  {
    AppMethodBeat.i(112805);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ar();
    ((c.a)localObject).otF = new as();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
    ((c.a)localObject).funcId = 1136;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ar)c.b.b(this.rr.otB);
    ((ar)localObject).YBh = paramInt;
    ((ar)localObject).YBi = paramString1;
    ((ar)localObject).chatroom_name = paramString2;
    ((ar)localObject).YBj = paramBoolean.booleanValue();
    AppMethodBeat.o(112805);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112807);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112807);
    return i;
  }
  
  public final int getType()
  {
    return 1136;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112806);
    Log.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.wuB = CardGiftInfo.a((as)c.c.b(this.rr.otC));
      Log.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[] { this.wuB.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.q
 * JD-Core Version:    0.7.0.1
 */