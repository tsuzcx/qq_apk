package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends p
  implements m
{
  private h callback;
  public final c rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(269817);
    c.a locala = new c.a();
    km localkm = new km();
    localkm.YMx = paramLinkedList;
    localkm.nUz = e.xOd;
    locala.otE = localkm;
    locala.otF = new kn();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(269817);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(269822);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(269822);
    return i;
  }
  
  public final int getType()
  {
    return 697;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(269828);
    Log.i("MicroMsg.emoji.NetSceneCheckEmoijExistByp", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(269828);
      return;
    }
    params = (kn)c.c.b(this.rr.otC);
    if ((params.YMz == null) || (params.YMz.size() <= 0)) {
      Log.i("MicroMsg.emoji.NetSceneCheckEmoijExistByp", "Change MD5 to URL failed.");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(269828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */