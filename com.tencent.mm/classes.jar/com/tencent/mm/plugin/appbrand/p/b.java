package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.dqf;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Locale;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.al.b gRE;
  private com.tencent.mm.al.g gbr;
  private dqf kUh;
  
  public b()
  {
    AppMethodBeat.i(47749);
    b.a locala = new b.a();
    locala.gUU = new dqe();
    locala.gUV = new dqf();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gRE = locala.atI();
    AppMethodBeat.o(47749);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(47750);
    ad.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.gbr = paramg;
    int i = dispatch(parame, this.gRE, this);
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
    this.kUh = ((dqf)this.gRE.gUT.gUX);
    if (this.gbr != null) {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.kUh.EFY == null)
    {
      AppMethodBeat.o(47751);
      return;
    }
    paramString = com.tencent.mm.kernel.g.afB().afk();
    paramString.set(ae.a.FnB, Locale.getDefault().getLanguage());
    paramString.set(ae.a.FnC, this.kUh.EFY.sDZ);
    paramString.set(ae.a.FnF, this.kUh.EFY.EGb);
    paramString.set(ae.a.FnG, Long.valueOf(System.currentTimeMillis()));
    paramString.set(ae.a.FnD, this.kUh.EFZ.sDZ);
    paramString.set(ae.a.FnE, this.kUh.EGa.sDZ);
    AppMethodBeat.o(47751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.b
 * JD-Core Version:    0.7.0.1
 */