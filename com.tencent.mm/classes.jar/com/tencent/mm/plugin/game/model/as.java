package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class as
  extends n
  implements k
{
  private String appId;
  private f callback;
  final b grW;
  
  public as(String paramString)
  {
    AppMethodBeat.i(41616);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bnd();
    ((b.a)localObject).hNN = new bne();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.appId = paramString;
    this.grW = ((b.a)localObject).aDC();
    localObject = (bnd)this.grW.hNK.hNQ;
    ((bnd)localObject).uhu = ac.fks();
    ((bnd)localObject).jdl = bt.jg(aj.getContext());
    ((bnd)localObject).iht = paramString;
    ad.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[] { ((bnd)localObject).uhu, ((bnd)localObject).jdl, ((bnd)localObject).iht });
    AppMethodBeat.o(41616);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41618);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(41618);
    return i;
  }
  
  public final int getType()
  {
    return 1369;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41617);
    ad.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(41617);
      return;
    }
    if ((bne)((b)paramq).hNL.hNQ == null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(41617);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.as
 * JD-Core Version:    0.7.0.1
 */