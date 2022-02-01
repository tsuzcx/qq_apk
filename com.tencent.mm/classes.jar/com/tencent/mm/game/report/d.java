package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private final b gux;
  
  public d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175995);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new com.tencent.mm.game.report.c.e();
    ((b.a)localObject).hQG = new com.tencent.mm.game.report.c.f();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (com.tencent.mm.game.report.c.e)this.gux.hQD.hQJ;
    ((com.tencent.mm.game.report.c.e)localObject).gvv = paramString1;
    ((com.tencent.mm.game.report.c.e)localObject).gvx = paramInt1;
    ((com.tencent.mm.game.report.c.e)localObject).gvy = paramInt2;
    ((com.tencent.mm.game.report.c.e)localObject).gvz = paramString2;
    ((com.tencent.mm.game.report.c.e)localObject).gvA = paramString3;
    ((com.tencent.mm.game.report.c.e)localObject).gvw = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175995);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(175996);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneGetGameIndex", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(175997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.d
 * JD-Core Version:    0.7.0.1
 */