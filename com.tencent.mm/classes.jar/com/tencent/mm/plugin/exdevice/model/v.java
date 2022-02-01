package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.sdk.platformtools.ad;

public final class v
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public v(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23413);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cyy();
    ((b.a)localObject).hNN = new cyz();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
    ((b.a)localObject).funcId = 1270;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cyy)this.rr.hNK.hNQ;
    ((cyy)localObject).FDx = new bnj();
    ((cyy)localObject).FDx.FzJ = paramString1;
    ((cyy)localObject).FDx.nDr = paramString2;
    ((cyy)localObject).HpI = paramString3;
    AppMethodBeat.o(23413);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23415);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23415);
    return i;
  }
  
  public final int getType()
  {
    return 1270;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23414);
    ad.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.v
 * JD-Core Version:    0.7.0.1
 */