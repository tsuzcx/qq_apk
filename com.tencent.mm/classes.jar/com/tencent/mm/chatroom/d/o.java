package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class o
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(12482);
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new bzx();
    locala.iLO = new bzy();
    locala.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
    locala.funcId = 339;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bzx)this.rr.iLK.iLR).xNG = paramString;
    Log.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(paramString)));
    AppMethodBeat.o(12482);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(12483);
    this.callback = parami;
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
    paramInt1 = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(135176, Integer.valueOf(0))).intValue();
    if (paramInt1 - 1 >= 0) {
      com.tencent.mm.kernel.g.aAh().azQ().set(135176, Integer.valueOf(paramInt1 - 1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.o
 * JD-Core Version:    0.7.0.1
 */