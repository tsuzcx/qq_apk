package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  private i callback;
  public final d rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(199782);
    d.a locala = new d.a();
    ka localka = new ka();
    localka.KOo = paramLinkedList;
    localka.ReqType = e.rcw;
    locala.iLN = localka;
    locala.iLO = new kb();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
    locala.funcId = 697;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(199782);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(199783);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(199783);
    return i;
  }
  
  public final int getType()
  {
    return 697;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199784);
    Log.i("MicroMsg.emoji.NetSceneCheckEmoijExistByp", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(199784);
      return;
    }
    params = (kb)this.rr.iLL.iLR;
    if ((params.KOp == null) || (params.KOp.size() <= 0)) {
      Log.i("MicroMsg.emoji.NetSceneCheckEmoijExistByp", "Change MD5 to URL failed.");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(199784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */