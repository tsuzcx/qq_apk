package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dvw;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.sdk.platformtools.Log;

public final class af
  extends q
  implements m
{
  private i callback;
  Object data;
  public d rr;
  
  public af(og paramog, Object paramObject)
  {
    AppMethodBeat.i(124146);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dvw();
    ((d.a)localObject).iLO = new dvx();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((d.a)localObject).funcId = 1228;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dvw)this.rr.iLK.iLR;
    ((dvw)localObject).LTl = paramog;
    ((dvw)localObject).mask = 17;
    ((dvw)localObject).LTj = 1;
    this.data = paramObject;
    AppMethodBeat.o(124146);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124148);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124148);
    return i;
  }
  
  public final int getType()
  {
    return 1228;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124147);
    Log.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.af
 * JD-Core Version:    0.7.0.1
 */