package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  public b rr;
  
  public k(String paramString, LinkedList<bbm> paramLinkedList)
  {
    AppMethodBeat.i(13855);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bbp();
    ((b.a)localObject).fsY = new bbq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
    ((b.a)localObject).funcId = 1030;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bbp)this.rr.fsV.fta;
    ((bbp)localObject).xli = paramString;
    ((bbp)localObject).xqK = paramLinkedList;
    AppMethodBeat.o(13855);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(13857);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13857);
    return i;
  }
  
  public final int getType()
  {
    return 1030;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13856);
    ab.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(13856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */