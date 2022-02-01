package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class w
  extends q
  implements m
{
  private i callback;
  public int opType;
  private d rr;
  
  public w(int paramInt, String paramString)
  {
    AppMethodBeat.i(131079);
    this.opType = paramInt;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new alw();
    ((d.a)localObject).iLO = new alx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((d.a)localObject).funcId = 183;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    alw localalw = (alw)this.rr.iLK.iLR;
    localObject = paramString;
    if (Util.isNullOrNil(paramString)) {
      localObject = "";
    }
    localalw.Luy = ((String)localObject);
    localalw.him = paramInt;
    AppMethodBeat.o(131079);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
      params = (alx)this.rr.iLL.iLR;
      paramInt1 = params.getBaseResponse().Ret;
      if (paramInt1 != 0)
      {
        Log.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(paramInt1)));
        this.callback.onSceneEnd(4, paramInt1, paramString, this);
        AppMethodBeat.o(131081);
        return;
      }
      Log.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + params.LuA + ", fbusername = " + params.LuB);
      if ((this.opType == 0) || (this.opType == 1))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(65825, params.LuA);
        c.LX(params.LuA);
        com.tencent.mm.kernel.g.aAh().azQ().set(65826, params.LuB);
        com.tencent.mm.kernel.g.aAh().azQ().gBI();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.w
 * JD-Core Version:    0.7.0.1
 */