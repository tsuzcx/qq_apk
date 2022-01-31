package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
  extends m
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public q(String paramString, Object paramObject)
  {
    AppMethodBeat.i(11621);
    b.a locala = new b.a();
    locala.fsX = new ahe();
    locala.fsY = new ahf();
    locala.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
    locala.funcId = 1354;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((ahe)this.rr.fsV.fta).wyh = paramString;
    this.data = paramObject;
    AppMethodBeat.o(11621);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11623);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11623);
    return i;
  }
  
  public final int getType()
  {
    return 1354;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11622);
    ab.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a.q
 * JD-Core Version:    0.7.0.1
 */