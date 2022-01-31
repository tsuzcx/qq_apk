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
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.game.d.df;
import com.tencent.mm.sdk.platformtools.ab;

public final class av
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public av(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(111460);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new de();
    ((b.a)localObject).fsY = new df();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newsubscribenewgame";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (de)this.lFp.fsV.fta;
    ((de)localObject).npZ = paramString1;
    ((de)localObject).nsa = paramString2;
    ((de)localObject).npW = paramString3;
    ((de)localObject).nql = paramBoolean;
    AppMethodBeat.o(111460);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111461);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111461);
    return i;
  }
  
  public final int getType()
  {
    return 1219;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111462);
    ab.i("MicroMsg.NetSceneGameSubscription", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.av
 * JD-Core Version:    0.7.0.1
 */