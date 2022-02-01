package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private f callback;
  private String duW;
  private final b rr;
  
  private i()
  {
    AppMethodBeat.i(24811);
    b.a locala = new b.a();
    locala.hNM = new cn();
    locala.hNN = new co();
    locala.uri = "/cgi-bin/mmo2o-bin/addcontact";
    locala.funcId = 1703;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24811);
  }
  
  public i(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this();
    AppMethodBeat.i(24812);
    this.duW = paramString1;
    cn localcn = (cn)this.rr.hNK.hNQ;
    localcn.FuU = paramString1;
    localcn.Url = paramString2;
    localcn.FqH = paramInt;
    localcn.FqI = paramString3;
    ad.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[] { paramString1 });
    AppMethodBeat.o(24812);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(24814);
    this.callback = paramf;
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
    ad.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.duW });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(24813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.i
 * JD-Core Version:    0.7.0.1
 */