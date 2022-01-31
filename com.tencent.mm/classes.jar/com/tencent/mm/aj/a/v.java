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
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.sdk.platformtools.ab;

public final class v
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public v(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(11636);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bqy();
    ((b.a)localObject).fsY = new bqz();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
    ((b.a)localObject).funcId = 1361;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bqy)this.rr.fsV.fta;
    ((bqy)localObject).wyh = paramString1;
    ((bqy)localObject).wyb = paramString2;
    ((bqy)localObject).time_stamp = paramInt;
    AppMethodBeat.o(11636);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11638);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11638);
    return i;
  }
  
  public final int getType()
  {
    return 1361;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11637);
    ab.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.a.v
 * JD-Core Version:    0.7.0.1
 */