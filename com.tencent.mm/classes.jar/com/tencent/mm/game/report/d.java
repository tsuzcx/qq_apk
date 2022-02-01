package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.c.e;
import com.tencent.mm.game.report.c.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.ak.d hhm;
  
  public d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(175995);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new e();
    ((d.a)localObject).iLO = new f();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamereport";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (e)this.hhm.iLK.iLR;
    ((e)localObject).hik = paramString1;
    ((e)localObject).him = paramInt1;
    ((e)localObject).hin = paramInt2;
    ((e)localObject).hio = paramString2;
    ((e)localObject).hip = paramString3;
    ((e)localObject).hil = ((int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(175995);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(175996);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
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
 * Qualified Name:     com.tencent.mm.game.report.d
 * JD-Core Version:    0.7.0.1
 */