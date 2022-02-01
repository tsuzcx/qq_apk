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
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.sdk.platformtools.ac;

public final class at
  extends n
  implements k
{
  private g callback;
  final b fYA;
  
  public at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41622);
    ac.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new csx();
    ((b.a)localObject).hvu = new csy();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/searchgamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (csx)this.fYA.hvr.hvw;
    ((csx)localObject).tkr = paramInt1;
    ((csx)localObject).tks = paramInt2;
    AppMethodBeat.o(41622);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41623);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneSearchGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.at
 * JD-Core Version:    0.7.0.1
 */