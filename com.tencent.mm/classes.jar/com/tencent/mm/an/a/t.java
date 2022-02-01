package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public t(String paramString)
  {
    AppMethodBeat.i(124313);
    c.a locala = new c.a();
    locala.otE = new cjy();
    locala.otF = new cjz();
    locala.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
    locala.funcId = 1367;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((cjy)c.b.b(this.rr.otB)).YRQ = paramString;
    AppMethodBeat.o(124313);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124315);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124315);
    return i;
  }
  
  public final int getType()
  {
    return 1367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124314);
    Log.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.a.t
 * JD-Core Version:    0.7.0.1
 */