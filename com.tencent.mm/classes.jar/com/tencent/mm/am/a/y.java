package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.ad;

public final class y
  extends n
  implements k
{
  private g callback;
  Object data;
  public b rr;
  
  public y(String paramString1, String paramString2, mg parammg1, mg parammg2, Object paramObject)
  {
    AppMethodBeat.i(124328);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dfo();
    ((b.a)localObject).gUV = new dfp();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
    ((b.a)localObject).funcId = 1357;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (dfo)this.rr.gUS.gUX;
    ((dfo)localObject).CIQ = paramString1;
    ((dfo)localObject).CIJ = paramString2;
    ((dfo)localObject).EwT = parammg1;
    ((dfo)localObject).EwU = parammg2;
    this.data = paramObject;
    AppMethodBeat.o(124328);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124330);
    this.callback = paramg;
    ad.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
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
    ad.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.y
 * JD-Core Version:    0.7.0.1
 */