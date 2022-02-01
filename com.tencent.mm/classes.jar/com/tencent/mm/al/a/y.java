package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.sdk.platformtools.ae;

public final class y
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public y(String paramString1, String paramString2, ne paramne1, ne paramne2, Object paramObject)
  {
    AppMethodBeat.i(124328);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new drr();
    ((b.a)localObject).hQG = new drs();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((b.a)localObject).funcId = 1357;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (drr)this.rr.hQD.hQJ;
    ((drr)localObject).FZx = paramString1;
    ((drr)localObject).FZq = paramString2;
    ((drr)localObject).HYw = paramne1;
    ((drr)localObject).HYx = paramne2;
    this.data = paramObject;
    AppMethodBeat.o(124328);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124330);
    this.callback = paramf;
    ae.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124330);
    return i;
  }
  
  public final int getType()
  {
    return 1357;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124329);
    ae.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.y
 * JD-Core Version:    0.7.0.1
 */