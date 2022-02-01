package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class w
  extends q
  implements m
{
  private i callback;
  public int opType;
  private com.tencent.mm.an.d rr;
  
  public w(int paramInt, String paramString)
  {
    AppMethodBeat.i(131079);
    this.opType = paramInt;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new amx();
    ((d.a)localObject).lBV = new amy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((d.a)localObject).funcId = 183;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    amx localamx = (amx)d.b.b(this.rr.lBR);
    localObject = paramString;
    if (Util.isNullOrNil(paramString)) {
      localObject = "";
    }
    localamx.SwW = ((String)localObject);
    localamx.jUk = paramInt;
    AppMethodBeat.o(131079);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131080);
    this.callback = parami;
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
      params = (amy)d.c.b(this.rr.lBS);
      paramInt1 = params.getBaseResponse().CqV;
      if (paramInt1 != 0)
      {
        Log.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(paramInt1)));
        this.callback.onSceneEnd(4, paramInt1, paramString, this);
        AppMethodBeat.o(131081);
        return;
      }
      Log.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + params.SwY + ", fbusername = " + params.SwZ);
      if ((this.opType == 0) || (this.opType == 1))
      {
        h.aHG().aHp().i(65825, params.SwY);
        com.tencent.mm.am.d.Ts(params.SwY);
        h.aHG().aHp().i(65826, params.SwZ);
        h.aHG().aHp().hxT();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.w
 * JD-Core Version:    0.7.0.1
 */