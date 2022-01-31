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
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.sdk.platformtools.ab;

public final class au
  extends m
  implements k
{
  private f callback;
  final b lFp;
  
  public au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111457);
    ab.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bxm();
    ((b.a)localObject).fsY = new bxn();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/searchgamelist";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (bxm)this.lFp.fsV.fta;
    ((bxm)localObject).nsV = paramInt1;
    ((bxm)localObject).nsW = paramInt2;
    AppMethodBeat.o(111457);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111458);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111458);
    return i;
  }
  
  public final int getType()
  {
    return 1215;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111459);
    ab.i("MicroMsg.NetSceneSearchGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */