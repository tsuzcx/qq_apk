package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private g callback;
  private String dlB;
  private final b rr;
  
  private i()
  {
    AppMethodBeat.i(24811);
    b.a locala = new b.a();
    locala.gUU = new ck();
    locala.gUV = new cl();
    locala.uri = "/cgi-bin/mmo2o-bin/addcontact";
    locala.funcId = 1703;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24811);
  }
  
  public i(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this();
    AppMethodBeat.i(24812);
    this.dlB = paramString1;
    ck localck = (ck)this.rr.gUS.gUX;
    localck.Cxj = paramString1;
    localck.Url = paramString2;
    localck.Ctl = paramInt;
    localck.Ctm = paramString3;
    ad.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[] { paramString1 });
    AppMethodBeat.o(24812);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(24814);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(24814);
    return i;
  }
  
  public final int getType()
  {
    return 1703;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24813);
    ad.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dlB });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(24813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.i
 * JD-Core Version:    0.7.0.1
 */