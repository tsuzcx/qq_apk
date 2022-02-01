package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends n
  implements k
{
  private g callback;
  String content;
  int key;
  private int scene = 0;
  int type;
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(195312);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new afc();
    paramg.hvu = new afd();
    paramg.uri = "/cgi-bin/mmexptappsvr-bin/reportexptdebug";
    paramg.funcId = 2743;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    paramg = paramg.aAz();
    afc localafc = (afc)paramg.hvr.hvw;
    localafc.ndI = this.type;
    if (this.scene == 0) {}
    for (int i = (int)bs.aNx();; i = this.scene)
    {
      localafc.Scene = i;
      localafc.wTD = this.key;
      localafc.hkR = this.content;
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(195312);
      return i;
    }
  }
  
  public final int getType()
  {
    return 2743;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195313);
    ac.i("MicroMsg.NetSceneDebugReport", "send expt debug info ongynetend type[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(195313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.b
 * JD-Core Version:    0.7.0.1
 */