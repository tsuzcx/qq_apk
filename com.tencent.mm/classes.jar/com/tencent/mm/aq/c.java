package com.tencent.mm.aq;

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
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  private final b hEg;
  public Object tag;
  
  public c(String paramString)
  {
    AppMethodBeat.i(104520);
    b.a locala = new b.a();
    locala.hvt = new bnk();
    locala.hvu = new bnl();
    locala.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
    locala.funcId = 666;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hEg = locala.aAz();
    ((bnk)this.hEg.hvr.hvw).Url = paramString;
    AppMethodBeat.o(104520);
  }
  
  public final bnl aEo()
  {
    return (bnl)this.hEg.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(104521);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ac.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aq.c
 * JD-Core Version:    0.7.0.1
 */