package com.tencent.mm.plugin.luckymoney.f2f.a;

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
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  private g callback;
  private b gvE;
  private aft uiC;
  private afu uiD;
  
  public a(String paramString)
  {
    AppMethodBeat.i(65035);
    b.a locala = new b.a();
    locala.hvt = new aft();
    locala.hvu = new afu();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
    this.gvE = locala.aAz();
    this.uiC = ((aft)this.gvE.hvr.hvw);
    this.uiC.uhB = paramString;
    AppMethodBeat.o(65035);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(65037);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(65037);
    return i;
  }
  
  public final int getType()
  {
    return 1987;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65036);
    this.uiD = ((afu)((b)paramq).hvs.hvw);
    ac.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.uiD.dae), this.uiD.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.uiD.dae, this.uiD.oxf, this);
    }
    AppMethodBeat.o(65036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.a
 * JD-Core Version:    0.7.0.1
 */