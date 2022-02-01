package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private String dNI;
  private final d rr;
  
  private i()
  {
    AppMethodBeat.i(24811);
    d.a locala = new d.a();
    locala.iLN = new cw();
    locala.iLO = new cx();
    locala.uri = "/cgi-bin/mmo2o-bin/addcontact";
    locala.funcId = 1703;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24811);
  }
  
  public i(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this();
    AppMethodBeat.i(24812);
    this.dNI = paramString1;
    cw localcw = (cw)this.rr.iLK.iLR;
    localcw.KGX = paramString1;
    localcw.Url = paramString2;
    localcw.KCx = paramInt;
    localcw.KCy = paramString3;
    Log.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[] { paramString1 });
    AppMethodBeat.o(24812);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(24814);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(24814);
    return i;
  }
  
  public final int getType()
  {
    return 1703;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24813);
    Log.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dNI });
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