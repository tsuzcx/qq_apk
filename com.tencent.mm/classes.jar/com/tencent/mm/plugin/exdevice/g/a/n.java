package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.protocal.protobuf.ely;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  public String coverUrl;
  public String rCp;
  private d rr;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(23537);
    this.callback = null;
    this.rr = null;
    this.coverUrl = paramString1;
    this.rCp = paramString2;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new elx();
    ((d.a)localObject).iLO = new ely();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
    ((d.a)localObject).funcId = 1040;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (elx)this.rr.iLK.iLR;
    ((elx)localObject).McL = paramString1;
    ((elx)localObject).rCp = paramString2;
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