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
import com.tencent.mm.plugin.game.protobuf.bk;
import com.tencent.mm.plugin.game.protobuf.bl;
import com.tencent.mm.sdk.platformtools.Log;

public final class am
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public am(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(41598);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bk();
    ((d.a)localObject).lBV = new bl();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (bk)d.b.b(this.jTk.lBR);
    ((bk)localObject).CPt = paramString1;
    ((bk)localObject).jUi = paramString2;
    ((bk)localObject).CPx = paramBoolean;
    ((bk)localObject).CPz = true;
    AppMethodBeat.o(41598);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41599);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(41599);
    return i;
  }
  
  public final int getType()
  {
    return 1217;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41600);
    Log.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.am
 * JD-Core Version:    0.7.0.1
 */