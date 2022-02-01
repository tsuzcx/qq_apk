package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  public int fSo;
  public String lnp;
  private d rr;
  public String vil;
  
  public m(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23534);
    this.callback = null;
    this.rr = null;
    this.vil = paramString3;
    this.lnp = paramString2;
    this.fSo = paramInt;
    this.vil = paramString3;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cqy();
    ((d.a)localObject).lBV = new cqz();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/addlike";
    ((d.a)localObject).funcId = 1041;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cqy)d.b.b(this.rr.lBR);
    ((cqy)localObject).vpp = paramString2;
    ((cqy)localObject).username = paramString1;
    ((cqy)localObject).fSo = paramInt;
    ((cqy)localObject).lmG = paramString3;
    AppMethodBeat.o(23534);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23535);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23535);
    return i;
  }
  
  public final int getType()
  {
    return 1041;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23536);
    Log.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.m
 * JD-Core Version:    0.7.0.1
 */