package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;

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
    ((b.a)localObject).hNM = new axr();
    ((b.a)localObject).hNN = new axs();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((b.a)localObject).funcId = 1343;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (axr)this.rr.hNK.hNQ;
    ((axr)localObject).FHb = paramString;
    ((axr)localObject).GvE = paramInt;
    if (ac.fks().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((axr)localObject).GvF = paramInt;
      this.data = paramObject;
      AppMethodBeat.o(124126);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124128);
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
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
    ad.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.y
 * JD-Core Version:    0.7.0.1
 */