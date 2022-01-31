package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public s(String paramString)
  {
    AppMethodBeat.i(11627);
    b.a locala = new b.a();
    locala.fsX = new akk();
    locala.fsY = new akl();
    locala.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
    locala.funcId = 1367;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((akk)this.rr.fsV.fta).wyh = paramString;
    AppMethodBeat.o(11627);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11629);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11629);
    return i;
  }
  
  public final int getType()
  {
    return 1367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11628);
    ab.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.aj.a.s
 * JD-Core Version:    0.7.0.1
 */