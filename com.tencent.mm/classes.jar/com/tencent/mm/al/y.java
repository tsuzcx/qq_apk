package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;

public final class y
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public y(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(124126);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ayh();
    ((b.a)localObject).hQG = new ayi();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((b.a)localObject).funcId = 1343;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ayh)this.rr.hQD.hQJ;
    ((ayh)localObject).FZx = paramString;
    ((ayh)localObject).GPd = paramInt;
    if (ad.fom().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((ayh)localObject).GPe = paramInt;
      this.data = paramObject;
      AppMethodBeat.o(124126);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124128);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124128);
    return i;
  }
  
  public final int getType()
  {
    return 1343;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124127);
    ae.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.y
 * JD-Core Version:    0.7.0.1
 */