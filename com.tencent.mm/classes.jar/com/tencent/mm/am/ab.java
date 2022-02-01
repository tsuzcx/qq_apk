package com.tencent.mm.am;

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
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.sdk.platformtools.ad;

public final class ab
  extends n
  implements k
{
  private f callback;
  public String hQR;
  public b rr;
  
  public ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124135);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bsb();
    ((b.a)localObject).hNN = new bsc();
    ((b.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((b.a)localObject).funcId = 674;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bsb)this.rr.hNK.hNQ;
    ((bsb)localObject).GMV = paramString1;
    ((bsb)localObject).GMW = paramString2;
    this.hQR = paramString1;
    AppMethodBeat.o(124135);
  }
  
  public final bsc aFU()
  {
    if ((this.rr != null) && (this.rr.hNL.hNQ != null)) {
      return (bsc)this.rr.hNL.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124137);
    this.callback = paramf;
    ad.i("MicroMsg.NetSceneKFGetBindList", "do scene");
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
    ad.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.ab
 * JD-Core Version:    0.7.0.1
 */