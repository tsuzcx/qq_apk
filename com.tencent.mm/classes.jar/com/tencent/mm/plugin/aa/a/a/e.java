package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends m
  implements k
{
  private f callback;
  private b goo;
  private d goq;
  public com.tencent.mm.protocal.protobuf.e gor;
  public int scene;
  
  public e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(40644);
    b.a locala = new b.a();
    locala.fsX = new d();
    locala.fsY = new com.tencent.mm.protocal.protobuf.e();
    locala.funcId = 1530;
    locala.uri = "/cgi-bin/mmpay-bin/newaaclose";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.goq = ((d)this.goo.fsV.fta);
    this.goq.wjX = paramString2;
    this.goq.wjW = paramString1;
    this.goq.scene = paramInt;
    this.scene = paramInt;
    ab.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[] { this.goq.wjW, Integer.valueOf(paramInt) });
    AppMethodBeat.o(40644);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(40645);
    ab.i("MicroMsg.NetSceneAAClose", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40645);
    return i;
  }
  
  public final int getType()
  {
    return 1530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40646);
    ab.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.gor = ((com.tencent.mm.protocal.protobuf.e)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.gor.cnK), this.gor.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(40646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.e
 * JD-Core Version:    0.7.0.1
 */