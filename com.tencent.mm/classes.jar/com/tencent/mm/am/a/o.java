package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private f callback;
  Object data;
  public b rr;
  
  public o(String paramString, att paramatt, Object paramObject)
  {
    AppMethodBeat.i(124298);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new abq();
    ((b.a)localObject).hNN = new abr();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((b.a)localObject).funcId = 1355;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (abq)this.rr.hNK.hNQ;
    ((abq)localObject).FHb = paramString;
    ((abq)localObject).Gbn = paramatt;
    this.data = paramObject;
    AppMethodBeat.o(124298);
  }
  
  public final abr aGu()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (abr)this.rr.hNL.hNQ;
    }
    return null;
  }
  
  public final abq aGv()
  {
    if ((this.rr != null) && (this.rr.hNK.hNQ != null)) {
      return (abq)this.rr.hNK.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124300);
    this.callback = paramf;
    ad.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124300);
    return i;
  }
  
  public final int getType()
  {
    return 1355;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124299);
    ad.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.o
 * JD-Core Version:    0.7.0.1
 */