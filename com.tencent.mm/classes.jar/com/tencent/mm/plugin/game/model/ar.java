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
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;

public final class ar
  extends n
  implements k
{
  private f callback;
  public final b gux;
  
  public ar(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(41613);
    ae.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(15), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bx();
    ((b.a)localObject).hQG = new by();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (bx)this.gux.hQD.hQJ;
    ((bx)localObject).utT = paramInt1;
    ((bx)localObject).utU = 15;
    ((bx)localObject).usS = ad.fom();
    ((bx)localObject).uub = paramInt2;
    ((bx)localObject).uuc = paramInt3;
    AppMethodBeat.o(41613);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41614);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ar
 * JD-Core Version:    0.7.0.1
 */