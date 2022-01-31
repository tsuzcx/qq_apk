package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class l
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public l(String paramString)
  {
    AppMethodBeat.i(103937);
    this.callback = null;
    b.a locala = new b.a();
    locala.fsX = new atn();
    locala.fsY = new ato();
    locala.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
    locala.funcId = 339;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((atn)this.rr.fsV.fta).nul = paramString;
    ab.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(paramString)));
    AppMethodBeat.o(103937);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103938);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103938);
    return i;
  }
  
  public final int getType()
  {
    return 339;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103939);
    ab.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + paramInt2 + " " + paramInt3 + "  " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103939);
      return;
    }
    paramInt1 = ((Integer)g.RL().Ru().get(135176, Integer.valueOf(0))).intValue();
    if (paramInt1 - 1 >= 0) {
      g.RL().Ru().set(135176, Integer.valueOf(paramInt1 - 1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.l
 * JD-Core Version:    0.7.0.1
 */