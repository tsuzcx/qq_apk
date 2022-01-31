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
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends m
  implements k
{
  private f callback;
  private Object data;
  public b rr;
  
  public l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(11606);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ku();
    ((b.a)localObject).fsY = new kv();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((b.a)localObject).funcId = 1364;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ku)this.rr.fsV.fta;
    ((ku)localObject).wyh = paramString1;
    ((ku)localObject).cnv = paramString2;
    ((ku)localObject).offset = paramInt;
    this.data = null;
    AppMethodBeat.o(11606);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11608);
    this.callback = paramf;
    ab.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11608);
    return i;
  }
  
  public final int getType()
  {
    return 1364;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11607);
    ab.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.a.l
 * JD-Core Version:    0.7.0.1
 */