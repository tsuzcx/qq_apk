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
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.ae;

public final class af
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public af(nn paramnn, Object paramObject)
  {
    AppMethodBeat.i(124146);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dcs();
    ((b.a)localObject).hQG = new dct();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((b.a)localObject).funcId = 1228;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dcs)this.rr.hQD.hQJ;
    ((dcs)localObject).GPf = paramnn;
    ((dcs)localObject).mask = 17;
    ((dcs)localObject).GPd = 1;
    this.data = paramObject;
    AppMethodBeat.o(124146);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124148);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124148);
    return i;
  }
  
  public final int getType()
  {
    return 1228;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124147);
    ae.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.af
 * JD-Core Version:    0.7.0.1
 */