package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.sdk.platformtools.ac;

public final class am
  extends n
  implements k
{
  private g callback;
  public final b fYA;
  
  public am(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(41598);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new az();
    ((b.a)localObject).hvu = new ba();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (az)this.fYA.hvr.hvw;
    ((az)localObject).tju = paramString1;
    ((az)localObject).fZx = paramString2;
    ((az)localObject).tjK = paramBoolean;
    ((az)localObject).tjM = true;
    AppMethodBeat.o(41598);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41599);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneGetGameDetailNew", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.am
 * JD-Core Version:    0.7.0.1
 */