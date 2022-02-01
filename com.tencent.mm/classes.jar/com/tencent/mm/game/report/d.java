package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.game.report.c.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  private final b grW;
  
  public d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175995);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new c();
    ((b.a)localObject).hNN = new com.tencent.mm.game.report.c.d();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (c)this.grW.hNK.hNQ;
    ((c)localObject).gsT = paramString1;
    ((c)localObject).gsV = paramInt1;
    ((c)localObject).gsW = paramInt2;
    ((c)localObject).gsX = paramString2;
    ((c)localObject).gsY = paramString3;
    ((c)localObject).gsU = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175995);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(175996);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(175996);
    return i;
  }
  
  public final int getType()
  {
    return 1223;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(175997);
    ad.i("MicroMsg.NetSceneGetGameIndex", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(175997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.d
 * JD-Core Version:    0.7.0.1
 */