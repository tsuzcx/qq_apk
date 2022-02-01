package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

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
    AppMethodBeat.i(196187);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new ahx();
    paramf.hQG = new ahy();
    paramf.uri = "/cgi-bin/mmexptappsvr-bin/reportexptdebug";
    paramf.funcId = 2743;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    paramf = paramf.aDS();
    ahx localahx = (ahx)paramf.hQD.hQJ;
    localahx.nJA = this.type;
    if (this.scene == 0) {}
    for (int i = (int)bu.aRi();; i = this.scene)
    {
      localahx.Scene = i;
      localahx.yxe = this.key;
      localahx.hFS = this.content;
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(196187);
      return i;
    }
  }
  
  public final int getType()
  {
    return 2743;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196188);
    ae.i("MicroMsg.NetSceneDebugReport", "send expt debug info ongynetend type[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(196188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.c
 * JD-Core Version:    0.7.0.1
 */