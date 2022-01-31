package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

public final class ar
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public ar(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111448);
    ab.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(15), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bn();
    ((b.a)localObject).fsY = new bo();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (bn)this.lFp.fsV.fta;
    ((bn)localObject).nsV = paramInt1;
    ((bn)localObject).nsW = 15;
    ((bn)localObject).nsa = aa.dsG();
    ((bn)localObject).ntd = paramInt2;
    ((bn)localObject).nte = paramInt3;
    AppMethodBeat.o(111448);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111449);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111449);
    return i;
  }
  
  public final int getType()
  {
    return 1220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111450);
    ab.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ar
 * JD-Core Version:    0.7.0.1
 */