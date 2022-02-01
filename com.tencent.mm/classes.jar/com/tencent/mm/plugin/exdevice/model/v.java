package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.dsw;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public v(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23413);
    this.callback = null;
    this.rr = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dsw();
    ((d.a)localObject).iLO = new dsx();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
    ((d.a)localObject).funcId = 1270;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dsw)this.rr.iLK.iLR;
    ((dsw)localObject).KPD = new cat();
    ((dsw)localObject).KPD.KLO = paramString1;
    ((dsw)localObject).KPD.oTH = paramString2;
    ((dsw)localObject).MUY = paramString3;
    AppMethodBeat.o(23413);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23415);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23415);
    return i;
  }
  
  public final int getType()
  {
    return 1270;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23414);
    Log.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.v
 * JD-Core Version:    0.7.0.1
 */