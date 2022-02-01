package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.ad;

public final class at
  extends n
  implements k
{
  private f callback;
  final b grW;
  
  public at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41622);
    ad.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cyh();
    ((b.a)localObject).hNN = new cyi();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/searchgamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (cyh)this.grW.hNK.hNQ;
    ((cyh)localObject).uiv = paramInt1;
    ((cyh)localObject).uiw = paramInt2;
    AppMethodBeat.o(41622);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41623);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(41623);
    return i;
  }
  
  public final int getType()
  {
    return 1215;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41624);
    ad.i("MicroMsg.NetSceneSearchGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.at
 * JD-Core Version:    0.7.0.1
 */