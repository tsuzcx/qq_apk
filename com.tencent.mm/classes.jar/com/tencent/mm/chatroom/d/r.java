package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class r
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public r(String paramString)
  {
    AppMethodBeat.i(12482);
    this.callback = null;
    c.a locala = new c.a();
    locala.otE = new cxs();
    locala.otF = new cxt();
    locala.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
    locala.funcId = 339;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((cxs)c.b.b(this.rr.otB)).IMg = paramString;
    Log.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(paramString)));
    AppMethodBeat.o(12482);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(12483);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12483);
    return i;
  }
  
  public final int getType()
  {
    return 339;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12484);
    Log.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + paramInt2 + " " + paramInt3 + "  " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12484);
      return;
    }
    paramInt1 = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(135176, Integer.valueOf(0))).intValue();
    if (paramInt1 - 1 >= 0) {
      com.tencent.mm.kernel.h.baE().ban().B(135176, Integer.valueOf(paramInt1 - 1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.r
 * JD-Core Version:    0.7.0.1
 */