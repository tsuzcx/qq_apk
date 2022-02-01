package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class as
  extends n
  implements k
{
  private String appId;
  private f callback;
  final b gux;
  
  public as(String paramString)
  {
    AppMethodBeat.i(41616);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bnv();
    ((b.a)localObject).hQG = new bnw();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.appId = paramString;
    this.gux = ((b.a)localObject).aDS();
    localObject = (bnv)this.gux.hQD.hQJ;
    ((bnv)localObject).usS = ad.fom();
    ((bnv)localObject).jge = bu.jm(ak.getContext());
    ((bnv)localObject).ikm = paramString;
    ae.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[] { ((bnv)localObject).usS, ((bnv)localObject).jge, ((bnv)localObject).ikm });
    AppMethodBeat.o(41616);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41618);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(41617);
      return;
    }
    if ((bnw)((b)paramq).hQE.hQJ == null)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(41617);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.as
 * JD-Core Version:    0.7.0.1
 */