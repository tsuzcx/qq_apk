package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.sdk.platformtools.Log;

public final class at
  extends q
  implements m
{
  private i callback;
  final d hhm;
  
  public at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41622);
    Log.i("MicroMsg.NetSceneSearchGameList", "offset: %d, limit: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dsc();
    ((d.a)localObject).iLO = new dsd();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/searchgamelist";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (dsc)this.hhm.iLK.iLR;
    ((dsc)localObject).xLV = paramInt1;
    ((dsc)localObject).xLW = paramInt2;
    AppMethodBeat.o(41622);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41623);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
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