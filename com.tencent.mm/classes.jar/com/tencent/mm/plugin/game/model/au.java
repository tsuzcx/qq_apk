package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.dw;
import com.tencent.mm.plugin.game.d.dx;
import com.tencent.mm.sdk.platformtools.ae;

public final class au
  extends n
  implements k
{
  private f callback;
  public final b gux;
  
  public au(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(41625);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dw();
    ((b.a)localObject).hQG = new dx();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (dw)this.gux.hQD.hQJ;
    ((dw)localObject).gvv = paramString1;
    ((dw)localObject).usS = paramString2;
    ((dw)localObject).uqn = paramString3;
    ((dw)localObject).uqB = paramBoolean;
    AppMethodBeat.o(41625);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41626);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */