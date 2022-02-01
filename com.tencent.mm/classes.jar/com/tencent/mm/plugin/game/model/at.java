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
import com.tencent.mm.protocal.protobuf.evp;
import com.tencent.mm.protocal.protobuf.evq;
import com.tencent.mm.sdk.platformtools.Log;

public final class at
  extends p
  implements m
{
  private h callback;
  final c mtC;
  
  public at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41622);
    Log.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new evp();
    ((c.a)localObject).otF = new evq();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/searchgamelist";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (evp)c.b.b(this.mtC.otB);
    ((evp)localObject).IKo = paramInt1;
    ((evp)localObject).IKp = paramInt2;
    AppMethodBeat.o(41622);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(41623);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(41623);
    return i;
  }
  
  public final int getType()
  {
    return 1215;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41624);
    Log.i("MicroMsg.NetSceneSearchGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.at
 * JD-Core Version:    0.7.0.1
 */