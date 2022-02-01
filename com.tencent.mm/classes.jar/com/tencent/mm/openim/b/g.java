package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  private i callback;
  private final String dOe;
  private final d rr;
  
  public g(String paramString)
  {
    AppMethodBeat.i(151196);
    d.a locala = new d.a();
    locala.iLN = new brm();
    locala.iLO = new brn();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomqrcode";
    locala.funcId = 890;
    this.rr = locala.aXF();
    this.dOe = paramString;
    ((brm)this.rr.iLK.iLR).jHa = paramString;
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(151196);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(151198);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151198);
    return i;
  }
  
  public final int getType()
  {
    return 890;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151197);
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dOe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.g
 * JD-Core Version:    0.7.0.1
 */