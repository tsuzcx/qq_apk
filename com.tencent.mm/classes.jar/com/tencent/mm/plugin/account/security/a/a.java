package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class a
  extends q
  implements m
{
  private i callback;
  private String dGL;
  private d rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(125511);
    this.dGL = paramString;
    d.a locala = new d.a();
    locala.iLN = new afx();
    locala.iLO = new afy();
    locala.uri = "/cgi-bin/micromsg-bin/delsafedevice";
    locala.funcId = 362;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((afx)this.rr.iLK.iLR).Lke = paramString;
    AppMethodBeat.o(125511);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(125513);
    if (Util.isNullOrNil(this.dGL))
    {
      Log.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
      AppMethodBeat.o(125513);
      return -1;
    }
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125513);
    return i;
  }
  
  public final int getType()
  {
    return 362;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125512);
    Log.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (afy)this.rr.iLL.iLR;
      com.tencent.mm.kernel.g.aAh().azQ().set(64, Integer.valueOf(params.KEf));
      Log.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + params.KEf);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.a
 * JD-Core Version:    0.7.0.1
 */