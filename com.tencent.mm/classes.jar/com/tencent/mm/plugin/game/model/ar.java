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
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;

public final class ar
  extends n
  implements k
{
  private g callback;
  public final b fYA;
  
  public ar(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(41613);
    ac.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(15), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bn();
    ((b.a)localObject).hvu = new bo();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (bn)this.fYA.hvr.hvw;
    ((bn)localObject).tkr = paramInt1;
    ((bn)localObject).tks = 15;
    ((bn)localObject).tju = ab.eUO();
    ((bn)localObject).tkz = paramInt2;
    ((bn)localObject).tkA = paramInt3;
    AppMethodBeat.o(41613);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41614);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
    AppMethodBeat.o(41614);
    return i;
  }
  
  public final int getType()
  {
    return 1220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41615);
    ac.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ar
 * JD-Core Version:    0.7.0.1
 */