package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.protocal.protobuf.dqx;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ad;

public final class x
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public x(String paramString, mz parammz, Object paramObject)
  {
    AppMethodBeat.i(124325);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dqw();
    ((b.a)localObject).hNN = new dqx();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
    ((b.a)localObject).funcId = 1356;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dqw)this.rr.hNK.hNQ;
    ((dqw)localObject).FHb = paramString;
    ((dqw)localObject).GrN = parammz;
    this.data = paramObject;
    AppMethodBeat.o(124325);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124327);
    this.callback = paramf;
    ad.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124327);
    return i;
  }
  
  public final int getType()
  {
    return 1356;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124326);
    ad.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.x
 * JD-Core Version:    0.7.0.1
 */