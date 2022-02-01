package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.eb;
import com.tencent.mm.plugin.game.protobuf.ec;
import com.tencent.mm.sdk.platformtools.Log;

public final class au
  extends p
  implements m
{
  private h callback;
  public final c mtC;
  
  public au(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(41625);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eb();
    ((c.a)localObject).otF = new ec();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (eb)c.b.b(this.mtC.otB);
    ((eb)localObject).muA = paramString1;
    ((eb)localObject).IJD = paramString2;
    ((eb)localObject).IGQ = paramString3;
    ((eb)localObject).IHe = paramBoolean;
    AppMethodBeat.o(41625);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(41626);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41626);
    return i;
  }
  
  public final int getType()
  {
    return 1219;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41627);
    Log.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */