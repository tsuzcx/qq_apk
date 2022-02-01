package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.game.report.c.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  private final b fUF;
  
  public c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175995);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new com.tencent.mm.game.report.c.c();
    ((b.a)localObject).gUV = new d();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    localObject = (com.tencent.mm.game.report.c.c)this.fUF.gUS.gUX;
    ((com.tencent.mm.game.report.c.c)localObject).fVC = paramString1;
    ((com.tencent.mm.game.report.c.c)localObject).fVE = paramInt1;
    ((com.tencent.mm.game.report.c.c)localObject).fVF = paramInt2;
    ((com.tencent.mm.game.report.c.c)localObject).fVG = paramString2;
    ((com.tencent.mm.game.report.c.c)localObject).fVH = paramString3;
    ((com.tencent.mm.game.report.c.c)localObject).fVD = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175995);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(175996);
    this.callback = paramg;
    int i = dispatch(parame, this.fUF, this);
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
 * Qualified Name:     com.tencent.mm.game.report.c
 * JD-Core Version:    0.7.0.1
 */