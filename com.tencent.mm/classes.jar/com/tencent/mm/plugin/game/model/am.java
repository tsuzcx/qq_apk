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
import com.tencent.mm.plugin.game.protobuf.bl;
import com.tencent.mm.plugin.game.protobuf.bm;
import com.tencent.mm.sdk.platformtools.Log;

public final class am
  extends p
  implements m
{
  private h callback;
  public final c mtC;
  
  public am(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(41598);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new bl();
    ((c.a)localObject).otF = new bm();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (bl)c.b.b(this.mtC.otB);
    ((bl)localObject).IJD = paramString1;
    ((bl)localObject).muA = paramString2;
    ((bl)localObject).IJH = paramBoolean;
    ((bl)localObject).IJJ = true;
    AppMethodBeat.o(41598);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(41599);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.am
 * JD-Core Version:    0.7.0.1
 */