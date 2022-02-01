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
import com.tencent.mm.plugin.game.protobuf.bx;
import com.tencent.mm.plugin.game.protobuf.by;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class ar
  extends q
  implements m
{
  private i callback;
  public final d hhm;
  
  public ar(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(41613);
    Log.i("MicroMsg.NetSceneGetMoreGameList", "offset: %d, limit: %d, type: %d, cat: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(15), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bx();
    ((d.a)localObject).iLO = new by();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetmoregamelist";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (bx)this.hhm.iLK.iLR;
    ((bx)localObject).xLV = paramInt1;
    ((bx)localObject).xLW = 15;
    ((bx)localObject).xLl = LocaleUtil.getApplicationLanguage();
    ((bx)localObject).xMd = paramInt2;
    ((bx)localObject).xMe = paramInt3;
    AppMethodBeat.o(41613);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41614);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(41614);
    return i;
  }
  
  public final int getType()
  {
    return 1220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41615);
    Log.i("MicroMsg.NetSceneGetMoreGameList", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ar
 * JD-Core Version:    0.7.0.1
 */