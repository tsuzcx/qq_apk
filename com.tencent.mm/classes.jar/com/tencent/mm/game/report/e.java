package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.game.report.c.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private final d jTk;
  
  public e(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175995);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new com.tencent.mm.game.report.c.e();
    ((d.a)localObject).lBV = new f();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (com.tencent.mm.game.report.c.e)d.b.b(this.jTk.lBR);
    ((com.tencent.mm.game.report.c.e)localObject).jUi = paramString1;
    ((com.tencent.mm.game.report.c.e)localObject).jUk = paramInt1;
    ((com.tencent.mm.game.report.c.e)localObject).jUl = paramInt2;
    ((com.tencent.mm.game.report.c.e)localObject).jUm = paramString2;
    ((com.tencent.mm.game.report.c.e)localObject).jUn = paramString3;
    ((com.tencent.mm.game.report.c.e)localObject).jUj = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175995);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(175996);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(175996);
    return i;
  }
  
  public final int getType()
  {
    return 1223;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(175997);
    Log.i("MicroMsg.NetSceneGetGameIndex", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(175997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.e
 * JD-Core Version:    0.7.0.1
 */