package com.tencent.mm.plugin.game.commlib;

import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;

public final class c
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b lFp;
  
  public c()
  {
    AppMethodBeat.i(59403);
    Object localObject = new com.tencent.mm.ai.b.a();
    ((com.tencent.mm.ai.b.a)localObject).fsX = new ax();
    ((com.tencent.mm.ai.b.a)localObject).fsY = new ay();
    ((com.tencent.mm.ai.b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
    ((com.tencent.mm.ai.b.a)localObject).funcId = getType();
    ((com.tencent.mm.ai.b.a)localObject).reqCmdId = 0;
    ((com.tencent.mm.ai.b.a)localObject).respCmdId = 0;
    this.lFp = ((com.tencent.mm.ai.b.a)localObject).ado();
    ax localax = (ax)this.lFp.fsV.fta;
    localax.nsa = aa.dsG();
    String str = com.tencent.mm.plugin.game.api.b.a.bEX().bEN();
    localObject = str;
    if (bo.isNullOrNil(str)) {
      localObject = bo.hi(ah.getContext());
    }
    localax.gwY = ((String)localObject);
    localax.nsb = g.bWu;
    localax.nsc = new d();
    localax.nsc.npX = Build.VERSION.SDK_INT;
    localax.nsc.npY = YearClass.get(ah.getContext());
    ab.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", new Object[] { localax.nsa, localax.gwY, Integer.valueOf(localax.nsb), Integer.valueOf(localax.nsc.npX), Integer.valueOf(localax.nsc.npY) });
    AppMethodBeat.o(59403);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(59405);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(59405);
    return i;
  }
  
  public final int getType()
  {
    return 1311;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59404);
    ab.i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(59404);
      return;
    }
    paramq = (ay)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramq == null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(59404);
      return;
    }
    a.a(paramq);
    com.tencent.mm.plugin.game.commlib.c.a.boB();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(59404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.c
 * JD-Core Version:    0.7.0.1
 */