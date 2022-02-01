package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.sdk.platformtools.ae;

public final class ab
  extends n
  implements k
{
  private f callback;
  public String hTJ;
  public b rr;
  
  public ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124135);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bsv();
    ((b.a)localObject).hQG = new bsw();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((b.a)localObject).funcId = 674;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bsv)this.rr.hQD.hQJ;
    ((bsv)localObject).Hgv = paramString1;
    ((bsv)localObject).Hgw = paramString2;
    this.hTJ = paramString1;
    AppMethodBeat.o(124135);
  }
  
  public final bsw aGk()
  {
    if ((this.rr != null) && (this.rr.hQE.hQJ != null)) {
      return (bsw)this.rr.hQE.hQJ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124137);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneKFGetBindList", "do scene");
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
    ae.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.ab
 * JD-Core Version:    0.7.0.1
 */