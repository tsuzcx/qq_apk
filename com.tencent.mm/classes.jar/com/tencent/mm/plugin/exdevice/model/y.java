package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.ewl;
import com.tencent.mm.protocal.protobuf.ewm;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23413);
    this.callback = null;
    this.rr = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ewl();
    ((c.a)localObject).otF = new ewm();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
    ((c.a)localObject).funcId = 1270;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ewl)c.b.b(this.rr.otB);
    ((ewl)localObject).YNR = new cyx();
    ((ewl)localObject).YNR.YJY = paramString1;
    ((ewl)localObject).YNR.vgV = paramString2;
    ((ewl)localObject).abyO = paramString3;
    AppMethodBeat.o(23413);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23415);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.y
 * JD-Core Version:    0.7.0.1
 */