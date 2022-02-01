package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.protobuf.dx;
import com.tencent.mm.plugin.game.protobuf.dy;
import com.tencent.mm.sdk.platformtools.Log;

public final class au
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public au(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(41625);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dx();
    ((d.a)localObject).lBV = new dy();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (dx)d.b.b(this.jTk.lBR);
    ((dx)localObject).jUi = paramString1;
    ((dx)localObject).CPt = paramString2;
    ((dx)localObject).CML = paramString3;
    ((dx)localObject).CMZ = paramBoolean;
    AppMethodBeat.o(41625);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41626);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(41626);
    return i;
  }
  
  public final int getType()
  {
    return 1219;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41627);
    Log.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.au
 * JD-Core Version:    0.7.0.1
 */