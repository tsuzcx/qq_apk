package com.tencent.mm.al;

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
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.sdk.platformtools.ac;

public final class aa
  extends n
  implements k
{
  private g callback;
  public String hyx;
  public b rr;
  
  public aa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124135);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bnq();
    ((b.a)localObject).hvu = new bnr();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((b.a)localObject).funcId = 674;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bnq)this.rr.hvr.hvw;
    ((bnq)localObject).Fds = paramString1;
    ((bnq)localObject).Fdt = paramString2;
    this.hyx = paramString1;
    AppMethodBeat.o(124135);
  }
  
  public final bnr aCR()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (bnr)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124137);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneKFGetBindList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124137);
    return i;
  }
  
  public final int getType()
  {
    return 674;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124136);
    ac.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.aa
 * JD-Core Version:    0.7.0.1
 */