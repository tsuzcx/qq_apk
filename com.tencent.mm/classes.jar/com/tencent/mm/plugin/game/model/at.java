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
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.sdk.platformtools.ae;

public final class at
  extends n
  implements k
{
  private f callback;
  final b gux;
  
  public at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41622);
    ae.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new czb();
    ((b.a)localObject).hQG = new czc();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/searchgamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (czb)this.gux.hQD.hQJ;
    ((czb)localObject).utT = paramInt1;
    ((czb)localObject).utU = paramInt2;
    AppMethodBeat.o(41622);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41623);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneSearchGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.at
 * JD-Core Version:    0.7.0.1
 */