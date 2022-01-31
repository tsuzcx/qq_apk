package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class a
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(13317);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new jq();
    ((b.a)localObject).fsY = new jr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (jq)this.rr.fsV.fta;
    ((jq)localObject).wsW = 1;
    ((jq)localObject).wvy = paramInt;
    ((jq)localObject).wvz = paramString1;
    ((jq)localObject).wvA = paramString2;
    ((jq)localObject).wvB = paramString3;
    ((jq)localObject).wvC = paramString4;
    ((jq)localObject).wvD = paramString5;
    ((jq)localObject).wvE = paramString6;
    ((jq)localObject).wvF = paramString7;
    AppMethodBeat.o(13317);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(13318);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13318);
    return i;
  }
  
  public final int getType()
  {
    return 549;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13319);
    ab.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (jq)this.rr.fsV.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.RL().Ru().set(286722, paramq.wvA);
      g.RL().Ru().set(286721, paramq.wvz);
      g.RL().Ru().set(286723, paramq.wvB);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(13319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */