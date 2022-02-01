package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.sdk.platformtools.ad;

public final class l
  extends n
  implements k
{
  private f callback;
  public int dFJ;
  public String hBg;
  public String qfc;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23534);
    this.callback = null;
    this.rr = null;
    this.qfc = paramString3;
    this.hBg = paramString2;
    this.dFJ = paramInt;
    this.qfc = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bub();
    ((b.a)localObject).hNN = new buc();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/addlike";
    ((b.a)localObject).funcId = 1041;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bub)this.rr.hNK.hNQ;
    ((bub)localObject).qmb = paramString2;
    ((bub)localObject).username = paramString1;
    ((bub)localObject).dFJ = paramInt;
    ((bub)localObject).hAy = paramString3;
    AppMethodBeat.o(23534);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23535);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23535);
    return i;
  }
  
  public final int getType()
  {
    return 1041;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23536);
    ad.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.l
 * JD-Core Version:    0.7.0.1
 */