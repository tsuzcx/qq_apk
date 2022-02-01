package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends n
  implements k
{
  private g callback;
  Object data;
  public b rr;
  
  public r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(124307);
    b.a locala = new b.a();
    locala.gUU = new aql();
    locala.gUV = new aqm();
    locala.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
    locala.funcId = 1354;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((aql)this.rr.gUS.gUX).CIQ = paramString;
    this.data = paramObject;
    AppMethodBeat.o(124307);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124309);
    this.callback = paramg;
    ad.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124309);
    return i;
  }
  
  public final int getType()
  {
    return 1354;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124308);
    ad.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.r
 * JD-Core Version:    0.7.0.1
 */