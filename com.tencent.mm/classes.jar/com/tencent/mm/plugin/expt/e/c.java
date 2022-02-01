package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends q
  implements m
{
  private i callback;
  String content;
  int key;
  private int scene = 0;
  int type;
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(255288);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new alm();
    parami.lBV = new aln();
    parami.uri = "/cgi-bin/mmexptappsvr-bin/reportexptdebug";
    parami.funcId = 2743;
    parami.lBW = 0;
    parami.respCmdId = 0;
    parami = parami.bgN();
    alm localalm = (alm)d.b.b(parami.lBR);
    localalm.rWu = this.type;
    if (this.scene == 0) {}
    for (int i = (int)Util.nowSecond();; i = this.scene)
    {
      localalm.CPw = i;
      localalm.IyZ = this.key;
      localalm.lpy = this.content;
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(255288);
      return i;
    }
  }
  
  public final int getType()
  {
    return 2743;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(255289);
    Log.i("MicroMsg.NetSceneDebugReport", "send expt debug info ongynetend type[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(255289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.c
 * JD-Core Version:    0.7.0.1
 */