package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.euy;
import com.tencent.mm.protocal.protobuf.euz;
import com.tencent.mm.sdk.platformtools.Log;

public final class w
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public w(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23407);
    this.callback = null;
    this.rr = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new euy();
    ((c.a)localObject).otF = new euz();
    ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
    ((c.a)localObject).funcId = 1706;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (euy)c.b.b(this.rr.otB);
    ((euy)localObject).mac = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((euy)localObject).userName = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    ((euy)localObject).kDf = paramString1;
    AppMethodBeat.o(23407);
  }
  
  public final euz dFK()
  {
    AppMethodBeat.i(274628);
    euz localeuz = (euz)c.c.b(this.rr.otC);
    AppMethodBeat.o(274628);
    return localeuz;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23409);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23409);
    return i;
  }
  
  public final int getType()
  {
    return 1706;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23408);
    Log.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */