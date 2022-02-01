package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ewd;
import com.tencent.mm.protocal.protobuf.ewe;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  public String coverUrl;
  private d rr;
  public String vhX;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23537);
    this.callback = null;
    this.rr = null;
    this.coverUrl = paramString1;
    this.vhX = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ewd();
    ((d.a)localObject).lBV = new ewe();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
    ((d.a)localObject).funcId = 1040;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ewd)d.b.b(this.rr.lBR);
    ((ewd)localObject).Tmm = paramString1;
    ((ewd)localObject).vhX = paramString2;
    AppMethodBeat.o(23537);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23538);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23538);
    return i;
  }
  
  public final int getType()
  {
    return 1040;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23539);
    Log.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.n
 * JD-Core Version:    0.7.0.1
 */