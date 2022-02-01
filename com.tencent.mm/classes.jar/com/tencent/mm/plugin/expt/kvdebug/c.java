package com.tencent.mm.plugin.expt.kvdebug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends p
  implements m
{
  private h callback;
  String content;
  int key;
  private int scene = 0;
  int type;
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(299472);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new aox();
    paramh.otF = new aoy();
    paramh.uri = "/cgi-bin/mmexptappsvr-bin/reportexptdebug";
    paramh.funcId = 2743;
    paramh.otG = 0;
    paramh.respCmdId = 0;
    paramh = paramh.bEF();
    aox localaox = (aox)c.b.b(paramh.otB);
    localaox.vhJ = this.type;
    if (this.scene == 0) {}
    for (int i = (int)Util.nowSecond();; i = this.scene)
    {
      localaox.IJG = i;
      localaox.OzG = this.key;
      localaox.nUB = this.content;
      i = dispatch(paramg, paramh, this);
      AppMethodBeat.o(299472);
      return i;
    }
  }
  
  public final int getType()
  {
    return 2743;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(299476);
    Log.i("MicroMsg.NetSceneDebugReport", "send expt debug info ongynetend type[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(299476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.kvdebug.c
 * JD-Core Version:    0.7.0.1
 */