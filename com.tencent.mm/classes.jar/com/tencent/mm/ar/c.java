package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private f callback;
  private final b hWL;
  public Object tag;
  
  public c(String paramString)
  {
    AppMethodBeat.i(104520);
    b.a locala = new b.a();
    locala.hNM = new brv();
    locala.hNN = new brw();
    locala.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
    locala.funcId = 666;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hWL = locala.aDC();
    ((brv)this.hWL.hNK.hNQ).Url = paramString;
    AppMethodBeat.o(104520);
  }
  
  public final brw aHt()
  {
    return (brw)this.hWL.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(104521);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    ad.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(104522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ar.c
 * JD-Core Version:    0.7.0.1
 */