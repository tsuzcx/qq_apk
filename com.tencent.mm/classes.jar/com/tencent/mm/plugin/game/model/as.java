package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class as
  extends n
  implements k
{
  private String appId;
  private g callback;
  final b fYA;
  
  public as(String paramString)
  {
    AppMethodBeat.i(41616);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new biv();
    ((b.a)localObject).hvu = new biw();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.appId = paramString;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (biv)this.fYA.hvr.hvw;
    ((biv)localObject).tju = ab.eUO();
    ((biv)localObject).iKc = bs.iW(ai.getContext());
    ((biv)localObject).hOf = paramString;
    ac.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[] { ((biv)localObject).tju, ((biv)localObject).iKc, ((biv)localObject).hOf });
    AppMethodBeat.o(41616);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41618);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(41617);
      return;
    }
    if ((biw)((b)paramq).hvs.hvw == null)
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