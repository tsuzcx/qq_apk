package com.tencent.mm.aq;

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
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  private f callback;
  private final b hZD;
  public Object tag;
  
  public c(String paramString)
  {
    AppMethodBeat.i(104520);
    b.a locala = new b.a();
    locala.hQF = new bsp();
    locala.hQG = new bsq();
    locala.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
    locala.funcId = 666;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hZD = locala.aDS();
    ((bsp)this.hZD.hQD.hQJ).Url = paramString;
    AppMethodBeat.o(104520);
  }
  
  public final bsq aHK()
  {
    return (bsq)this.hZD.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(104521);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(104521);
    return i;
  }
  
  public final int getType()
  {
    return 666;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104522);
    ae.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ae.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aq.c
 * JD-Core Version:    0.7.0.1
 */