package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.protocal.protobuf.evy;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends q
  implements m
{
  Object bnW;
  private i callback;
  public d rr;
  
  public x(String paramString, nj paramnj, Object paramObject)
  {
    AppMethodBeat.i(124325);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new evx();
    ((d.a)localObject).lBV = new evy();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
    ((d.a)localObject).funcId = 1356;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (evx)d.b.b(this.rr.lBR);
    ((evx)localObject).RUp = paramString;
    ((evx)localObject).SXD = paramnj;
    this.bnW = paramObject;
    AppMethodBeat.o(124325);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124327);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124327);
    return i;
  }
  
  public final int getType()
  {
    return 1356;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124326);
    Log.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.a.x
 * JD-Core Version:    0.7.0.1
 */