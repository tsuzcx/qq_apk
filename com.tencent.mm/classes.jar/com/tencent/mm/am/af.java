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
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.ad;

public final class af
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public af(nl paramnl, Object paramObject)
  {
    AppMethodBeat.i(124146);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dby();
    ((b.a)localObject).hNN = new dbz();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((b.a)localObject).funcId = 1228;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dby)this.rr.hNK.hNQ;
    ((dby)localObject).GvG = paramnl;
    ((dby)localObject).mask = 17;
    ((dby)localObject).GvE = 1;
    this.data = paramObject;
    AppMethodBeat.o(124146);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124148);
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
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
    ad.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.af
 * JD-Core Version:    0.7.0.1
 */