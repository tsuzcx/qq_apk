package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.sdk.platformtools.ad;

public final class am
  extends n
  implements k
{
  private g callback;
  public final b fUF;
  
  public am(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(41598);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new az();
    ((b.a)localObject).gUV = new ba();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/newgetgamedetail";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    localObject = (az)this.fUF.gUS.gUX;
    ((az)localObject).sbA = paramString1;
    ((az)localObject).fVC = paramString2;
    ((az)localObject).sbQ = paramBoolean;
    ((az)localObject).sbS = true;
    AppMethodBeat.o(41598);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41599);
    this.callback = paramg;
    int i = dispatch(parame, this.fUF, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.am
 * JD-Core Version:    0.7.0.1
 */