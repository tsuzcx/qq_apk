package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.edm;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Locale;

public final class b
  extends n
  implements k
{
  private f gCo;
  private com.tencent.mm.ak.b hNp;
  private edn lZH;
  
  public b()
  {
    AppMethodBeat.i(47749);
    b.a locala = new b.a();
    locala.hQF = new edm();
    locala.hQG = new edn();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.hNp = locala.aDS();
    AppMethodBeat.o(47749);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(47750);
    ae.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.gCo = paramf;
    int i = dispatch(parame, this.hNp, this);
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
    ae.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lZH = ((edn)this.hNp.hQE.hQJ);
    if (this.gCo != null) {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.lZH.Iix == null)
    {
      AppMethodBeat.o(47751);
      return;
    }
    paramString = g.ajR().ajA();
    paramString.set(am.a.ISg, Locale.getDefault().getLanguage());
    paramString.set(am.a.ISh, this.lZH.Iix.urq);
    paramString.set(am.a.ISk, this.lZH.Iix.IiA);
    paramString.set(am.a.ISl, Long.valueOf(System.currentTimeMillis()));
    paramString.set(am.a.ISi, this.lZH.Iiy.urq);
    paramString.set(am.a.ISj, this.lZH.Iiz.urq);
    AppMethodBeat.o(47751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.b
 * JD-Core Version:    0.7.0.1
 */