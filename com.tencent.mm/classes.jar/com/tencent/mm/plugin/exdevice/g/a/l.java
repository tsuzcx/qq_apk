package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.sdk.platformtools.ae;

public final class l
  extends n
  implements k
{
  private f callback;
  public int dGO;
  public String hDU;
  public String qlH;
  private b rr;
  
  public l(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23534);
    this.callback = null;
    this.rr = null;
    this.qlH = paramString3;
    this.hDU = paramString2;
    this.dGO = paramInt;
    this.qlH = paramString3;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new buv();
    ((b.a)localObject).hQG = new buw();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/addlike";
    ((b.a)localObject).funcId = 1041;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (buv)this.rr.hQD.hQJ;
    ((buv)localObject).qsG = paramString2;
    ((buv)localObject).username = paramString1;
    ((buv)localObject).dGO = paramInt;
    ((buv)localObject).hDm = paramString3;
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
    ae.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.l
 * JD-Core Version:    0.7.0.1
 */