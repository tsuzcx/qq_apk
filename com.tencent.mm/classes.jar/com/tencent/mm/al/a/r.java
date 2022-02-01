package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.sdk.platformtools.ae;

public final class r
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(124307);
    b.a locala = new b.a();
    locala.hQF = new ayd();
    locala.hQG = new aye();
    locala.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
    locala.funcId = 1354;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((ayd)this.rr.hQD.hQJ).FZx = paramString;
    this.data = paramObject;
    AppMethodBeat.o(124307);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124309);
    this.callback = paramf;
    ae.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
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
    ae.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.r
 * JD-Core Version:    0.7.0.1
 */