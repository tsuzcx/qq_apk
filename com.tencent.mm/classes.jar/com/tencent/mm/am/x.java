package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;

public final class x
  extends n
  implements k
{
  private g callback;
  Object data;
  public b rr;
  
  public x(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(124126);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aqp();
    ((b.a)localObject).gUV = new aqq();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((b.a)localObject).funcId = 1343;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (aqp)this.rr.gUS.gUX;
    ((aqp)localObject).CIQ = paramString;
    ((aqp)localObject).Dry = paramInt;
    if (ac.eFu().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((aqp)localObject).Drz = paramInt;
      this.data = paramObject;
      AppMethodBeat.o(124126);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124128);
    this.callback = paramg;
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
 * Qualified Name:     com.tencent.mm.am.x
 * JD-Core Version:    0.7.0.1
 */