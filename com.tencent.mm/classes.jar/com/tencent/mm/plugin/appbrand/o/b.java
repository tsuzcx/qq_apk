package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.protocal.protobuf.dvw;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Locale;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.ak.g gfX;
  private com.tencent.mm.ak.b hse;
  private dvw lvR;
  
  public b()
  {
    AppMethodBeat.i(47749);
    b.a locala = new b.a();
    locala.hvt = new dvv();
    locala.hvu = new dvw();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.hse = locala.aAz();
    AppMethodBeat.o(47749);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(47750);
    ac.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.gfX = paramg;
    int i = dispatch(parame, this.hse, this);
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
    ac.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lvR = ((dvw)this.hse.hvs.hvw);
    if (this.gfX != null) {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.lvR.Gdk == null)
    {
      AppMethodBeat.o(47751);
      return;
    }
    paramString = com.tencent.mm.kernel.g.agR().agA();
    paramString.set(ah.a.GLq, Locale.getDefault().getLanguage());
    paramString.set(ah.a.GLr, this.lvR.Gdk.tLG);
    paramString.set(ah.a.GLu, this.lvR.Gdk.Gdn);
    paramString.set(ah.a.GLv, Long.valueOf(System.currentTimeMillis()));
    paramString.set(ah.a.GLs, this.lvR.Gdl.tLG);
    paramString.set(ah.a.GLt, this.lvR.Gdm.tLG);
    AppMethodBeat.o(47751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.b
 * JD-Core Version:    0.7.0.1
 */