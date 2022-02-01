package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.game.report.c.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends p
  implements m
{
  private h callback;
  private final c mtC;
  
  public e(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175995);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new com.tencent.mm.game.report.c.e();
    ((c.a)localObject).otF = new f();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (com.tencent.mm.game.report.c.e)c.b.b(this.mtC.otB);
    ((com.tencent.mm.game.report.c.e)localObject).muA = paramString1;
    ((com.tencent.mm.game.report.c.e)localObject).muC = paramInt1;
    ((com.tencent.mm.game.report.c.e)localObject).muD = paramInt2;
    ((com.tencent.mm.game.report.c.e)localObject).muE = paramString2;
    ((com.tencent.mm.game.report.c.e)localObject).muF = paramString3;
    ((com.tencent.mm.game.report.c.e)localObject).muB = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175995);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(175996);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
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