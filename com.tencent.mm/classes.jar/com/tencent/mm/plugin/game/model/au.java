package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.df;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.sdk.platformtools.ac;

public final class au
  extends n
  implements k
{
  private g callback;
  public final b fYA;
  
  public au(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(41625);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new df();
    ((b.a)localObject).hvu = new dg();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (df)this.fYA.hvr.hvw;
    ((df)localObject).fZx = paramString1;
    ((df)localObject).tju = paramString2;
    ((df)localObject).thm = paramString3;
    ((df)localObject).thA = paramBoolean;
    AppMethodBeat.o(41625);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41626);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
    AppMethodBeat.o(41626);
    return i;
  }
  
  public final int getType()
  {
    return 1219;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41627);
    ac.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */