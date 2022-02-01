package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

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
    AppMethodBeat.i(190915);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new aed();
    paramg.gUV = new aee();
    paramg.uri = "/cgi-bin/mmexptappsvr-bin/reportexptdebug";
    paramg.funcId = 2743;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    paramg = paramg.atI();
    aed localaed = (aed)paramg.gUS.gUX;
    localaed.mBH = this.type;
    if (this.scene == 0) {}
    for (int i = (int)bt.aGK();; i = this.scene)
    {
      localaed.Scene = i;
      localaed.vJz = this.key;
      localaed.gKr = this.content;
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(190915);
      return i;
    }
  }
  
  public final int getType()
  {
    return 2743;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190916);
    ad.i("MicroMsg.NetSceneDebugReport", "send expt debug info ongynetend type[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(190916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.b
 * JD-Core Version:    0.7.0.1
 */