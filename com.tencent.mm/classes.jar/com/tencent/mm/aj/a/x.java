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
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.sdk.platformtools.ab;

public final class x
  extends m
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public x(String paramString1, String paramString2, ks paramks1, ks paramks2, Object paramObject)
  {
    AppMethodBeat.i(11642);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cmo();
    ((b.a)localObject).fsY = new cmp();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((b.a)localObject).funcId = 1357;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cmo)this.rr.fsV.fta;
    ((cmo)localObject).wyh = paramString1;
    ((cmo)localObject).wyb = paramString2;
    ((cmo)localObject).xWq = paramks1;
    ((cmo)localObject).xWr = paramks2;
    this.data = paramObject;
    AppMethodBeat.o(11642);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11644);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11644);
    return i;
  }
  
  public final int getType()
  {
    return 1357;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11643);
    ab.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(11643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a.x
 * JD-Core Version:    0.7.0.1
 */