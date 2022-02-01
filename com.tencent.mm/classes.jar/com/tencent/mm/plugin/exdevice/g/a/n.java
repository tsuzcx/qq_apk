package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.frs;
import com.tencent.mm.protocal.protobuf.frt;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends p
  implements m
{
  private h callback;
  public String coverUrl;
  private c rr;
  public String ytY;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23537);
    this.callback = null;
    this.rr = null;
    this.coverUrl = paramString1;
    this.ytY = paramString2;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new frs();
    ((c.a)localObject).otF = new frt();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
    ((c.a)localObject).funcId = 1040;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (frs)c.b.b(this.rr.otB);
    ((frs)localObject).aaAt = paramString1;
    ((frs)localObject).ytY = paramString2;
    AppMethodBeat.o(23537);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23538);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.n
 * JD-Core Version:    0.7.0.1
 */