package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends n
  implements k
{
  private g callback;
  Object data;
  public b rr;
  
  public o(String paramString, apz paramapz, Object paramObject)
  {
    AppMethodBeat.i(124298);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new zq();
    ((b.a)localObject).hvu = new zr();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((b.a)localObject).funcId = 1355;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (zq)this.rr.hvr.hvw;
    ((zq)localObject).Ebs = paramString;
    ((zq)localObject).EtV = paramapz;
    this.data = paramObject;
    AppMethodBeat.o(124298);
  }
  
  public final zr aDr()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (zr)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final zq aDs()
  {
    if ((this.rr != null) && (this.rr.hvr.hvw != null)) {
      return (zq)this.rr.hvr.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124300);
    this.callback = paramg;
    ac.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
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
    ac.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.o
 * JD-Core Version:    0.7.0.1
 */