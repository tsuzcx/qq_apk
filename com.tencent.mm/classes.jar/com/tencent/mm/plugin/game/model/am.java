package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.sdk.platformtools.ad;

public final class am
  extends n
  implements k
{
  private f callback;
  public final b grW;
  
  public am(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(41598);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bc();
    ((b.a)localObject).hNN = new bd();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (bc)this.grW.hNK.hNQ;
    ((bc)localObject).uhu = paramString1;
    ((bc)localObject).gsT = paramString2;
    ((bc)localObject).uhM = paramBoolean;
    ((bc)localObject).uhO = true;
    AppMethodBeat.o(41598);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41599);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(41599);
    return i;
  }
  
  public final int getType()
  {
    return 1217;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41600);
    ad.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.am
 * JD-Core Version:    0.7.0.1
 */