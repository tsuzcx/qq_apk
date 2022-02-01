package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class as
  extends n
  implements k
{
  private String appId;
  private g callback;
  final b fUF;
  
  public as(String paramString)
  {
    AppMethodBeat.i(41616);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bfd();
    ((b.a)localObject).gUV = new bfe();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.appId = paramString;
    this.fUF = ((b.a)localObject).atI();
    localObject = (bfd)this.fUF.gUS.gUX;
    ((bfd)localObject).sbA = ac.eFu();
    ((bfd)localObject).ijV = bt.iL(aj.getContext());
    ((bfd)localObject).hnC = paramString;
    ad.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[] { ((bfd)localObject).sbA, ((bfd)localObject).ijV, ((bfd)localObject).hnC });
    AppMethodBeat.o(41616);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41618);
    this.callback = paramg;
    int i = dispatch(parame, this.fUF, this);
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
    if ((bfe)((b)paramq).gUT.gUX == null)
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