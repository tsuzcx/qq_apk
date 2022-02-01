package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ebv;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.protocal.protobuf.ebx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Locale;

public final class b
  extends n
  implements k
{
  private f gzH;
  private com.tencent.mm.al.b hKw;
  private ebw lVe;
  
  public b()
  {
    AppMethodBeat.i(47749);
    b.a locala = new b.a();
    locala.hNM = new ebv();
    locala.hNN = new ebw();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.hKw = locala.aDC();
    AppMethodBeat.o(47749);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(47750);
    ad.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.gzH = paramf;
    int i = dispatch(parame, this.hKw, this);
    AppMethodBeat.o(47750);
    return i;
  }
  
  public final int getType()
  {
    return 1170;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(47751);
    ad.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lVe = ((ebw)this.hKw.hNL.hNQ);
    if (this.gzH != null) {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.lVe.HOq == null)
    {
      AppMethodBeat.o(47751);
      return;
    }
    paramString = g.ajC().ajl();
    paramString.set(al.a.IxI, Locale.getDefault().getLanguage());
    paramString.set(al.a.IxJ, this.lVe.HOq.uOt);
    paramString.set(al.a.IxM, this.lVe.HOq.HOt);
    paramString.set(al.a.IxN, Long.valueOf(System.currentTimeMillis()));
    paramString.set(al.a.IxK, this.lVe.HOr.uOt);
    paramString.set(al.a.IxL, this.lVe.HOs.uOt);
    AppMethodBeat.o(47751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.b
 * JD-Core Version:    0.7.0.1
 */