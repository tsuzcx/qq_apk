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
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.sdk.platformtools.ab;

public final class at
  extends m
  implements k
{
  private f callback;
  private final b lFp;
  
  public at(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(111454);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new au();
    ((b.a)localObject).fsY = new av();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (au)this.lFp.fsV.fta;
    ((au)localObject).npZ = paramString1;
    ((au)localObject).nrS = paramInt1;
    ((au)localObject).nrT = paramInt2;
    ((au)localObject).nrU = paramString2;
    ((au)localObject).nrV = paramString3;
    ((au)localObject).nrR = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(111454);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111455);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111455);
    return i;
  }
  
  public final int getType()
  {
    return 1223;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111456);
    ab.i("MicroMsg.NetSceneGetGameIndex", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.at
 * JD-Core Version:    0.7.0.1
 */