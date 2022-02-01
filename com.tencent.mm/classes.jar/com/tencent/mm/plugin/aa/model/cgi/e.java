package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private f callback;
  private b gPp;
  private d iTo;
  public com.tencent.mm.protocal.protobuf.e iTp;
  public int scene;
  
  public e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63375);
    b.a locala = new b.a();
    locala.hNM = new d();
    locala.hNN = new com.tencent.mm.protocal.protobuf.e();
    locala.funcId = 1530;
    locala.uri = "/cgi-bin/mmpay-bin/newaaclose";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.iTo = ((d)this.gPp.hNK.hNQ);
    this.iTo.FpH = paramString2;
    this.iTo.FpG = paramString1;
    this.iTo.scene = paramInt;
    this.scene = paramInt;
    ad.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", new Object[] { this.iTo.FpG, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63375);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63376);
    ad.i("MicroMsg.NetSceneAAClose", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(63376);
    return i;
  }
  
  public final int getType()
  {
    return 1530;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63377);
    ad.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iTp = ((com.tencent.mm.protocal.protobuf.e)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iTp.dlw), this.iTp.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */