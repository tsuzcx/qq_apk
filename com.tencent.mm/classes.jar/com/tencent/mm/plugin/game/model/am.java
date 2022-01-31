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
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.sdk.platformtools.ab;

public final class am
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public am(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(111433);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new az();
    ((b.a)localObject).fsY = new ba();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (az)this.lFp.fsV.fta;
    ((az)localObject).nsa = paramString1;
    ((az)localObject).npZ = paramString2;
    ((az)localObject).nso = paramBoolean;
    ((az)localObject).nsq = true;
    AppMethodBeat.o(111433);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111434);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111434);
    return i;
  }
  
  public final int getType()
  {
    return 1217;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111435);
    ab.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.am
 * JD-Core Version:    0.7.0.1
 */