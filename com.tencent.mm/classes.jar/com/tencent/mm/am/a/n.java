package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  Object data;
  public String gZA;
  public b rr;
  
  public n(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(124295);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ym();
    ((b.a)localObject).gUV = new yn();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((b.a)localObject).funcId = 1315;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ym)this.rr.gUS.gUX;
    ((ym)localObject).DaJ = paramString1;
    ((ym)localObject).DaL = paramString2;
    ((ym)localObject).DaK = paramString3;
    this.data = paramObject;
    AppMethodBeat.o(124295);
  }
  
  public final yn awy()
  {
    if ((this.rr != null) && (this.rr.gUT.gUX != null)) {
      return (yn)this.rr.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124297);
    this.callback = paramg;
    ad.i("MicroMsg.NetSceneConvertBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124297);
    return i;
  }
  
  public final int getType()
  {
    return 1315;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124296);
    ad.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a.n
 * JD-Core Version:    0.7.0.1
 */