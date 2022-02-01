package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  Object data;
  public String hSu;
  public b rr;
  
  public n(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(124295);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new abh();
    ((b.a)localObject).hNN = new abi();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((b.a)localObject).funcId = 1315;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (abh)this.rr.hNK.hNQ;
    ((abh)localObject).GaY = paramString1;
    ((abh)localObject).Gba = paramString2;
    ((abh)localObject).GaZ = paramString3;
    this.data = paramObject;
    AppMethodBeat.o(124295);
  }
  
  public final abi aGt()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (abi)this.rr.hNL.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124297);
    this.callback = paramf;
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