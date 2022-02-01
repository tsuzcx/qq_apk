package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class t
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public int opType;
  private c rr;
  
  public t(int paramInt, String paramString)
  {
    AppMethodBeat.i(131079);
    this.opType = paramInt;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aqq();
    ((c.a)localObject).otF = new aqr();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((c.a)localObject).funcId = 183;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    aqq localaqq = (aqq)c.b.b(this.rr.otB);
    localObject = paramString;
    if (Util.isNullOrNil(paramString)) {
      localObject = "";
    }
    localaqq.ZxK = ((String)localObject);
    localaqq.muC = paramInt;
    AppMethodBeat.o(131079);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131080);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131080);
    return i;
  }
  
  public final int getType()
  {
    return 183;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131081);
    updateDispatchId(paramInt1);
    Log.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (aqr)c.c.b(this.rr.otC);
      paramInt1 = params.getBaseResponse().Idd;
      if (paramInt1 != 0)
      {
        Log.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(paramInt1)));
        this.callback.onSceneEnd(4, paramInt1, paramString, this);
        AppMethodBeat.o(131081);
        return;
      }
      Log.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + params.ZxM + ", fbusername = " + params.ZxN);
      if ((this.opType == 0) || (this.opType == 1))
      {
        com.tencent.mm.kernel.h.baE().ban().B(65825, params.ZxM);
        d.Lu(params.ZxM);
        com.tencent.mm.kernel.h.baE().ban().B(65826, params.ZxN);
        com.tencent.mm.kernel.h.baE().ban().iZy();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.t
 * JD-Core Version:    0.7.0.1
 */