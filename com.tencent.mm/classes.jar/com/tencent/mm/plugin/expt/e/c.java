package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends n
  implements k
{
  private f callback;
  String content;
  int key;
  private int scene = 0;
  int type;
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(210520);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new ahn();
    paramf.hNN = new aho();
    paramf.uri = "/cgi-bin/mmexptappsvr-bin/reportexptdebug";
    paramf.funcId = 2743;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    paramf = paramf.aDC();
    ahn localahn = (ahn)paramf.hNK.hNQ;
    localahn.nEf = this.type;
    if (this.scene == 0) {}
    for (int i = (int)bt.aQJ();; i = this.scene)
    {
      localahn.Scene = i;
      localahn.yhn = this.key;
      localahn.hDa = this.content;
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(210520);
      return i;
    }
  }
  
  public final int getType()
  {
    return 2743;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210521);
    ad.i("MicroMsg.NetSceneDebugReport", "send expt debug info ongynetend type[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(210521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.c
 * JD-Core Version:    0.7.0.1
 */