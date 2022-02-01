package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends p
  implements m
{
  private h mAY;
  private String yqR;
  private com.tencent.mm.am.c ysd;
  
  public v(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(23404);
    this.mAY = null;
    this.ysd = null;
    this.yqR = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cze();
    ((c.a)localObject).otF = new czf();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
    ((c.a)localObject).funcId = 1090;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.ysd = ((c.a)localObject).bEF();
    localObject = (cze)c.b.b(this.ysd.otB);
    ((cze)localObject).YMs = b.bsj(paramString2);
    ((cze)localObject).YMq = b.bsj(paramString3);
    ((cze)localObject).muC = paramInt;
    this.yqR = paramString1;
    AppMethodBeat.o(23404);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23406);
    this.mAY = paramh;
    int i = dispatch(paramg, this.ysd, this);
    AppMethodBeat.o(23406);
    return i;
  }
  
  public final int getType()
  {
    return 1090;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23405);
    Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    ah.dFO().apI(this.yqR);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = ((czf)c.c.b(this.ysd.otC)).getBaseResponse().Idd;
      Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + paramInt1 + ",msg=" + paramString);
    }
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.v
 * JD-Core Version:    0.7.0.1
 */