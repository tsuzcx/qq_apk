package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class an
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public an(String paramString)
  {
    AppMethodBeat.i(131145);
    d.a locala = new d.a();
    locala.iLN = new dwc();
    locala.iLO = new dwd();
    locala.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
    locala.funcId = 382;
    locala.iLP = 181;
    locala.respCmdId = 1000000181;
    this.rr = locala.aXF();
    ((dwc)this.rr.iLK.iLR).KQi = Util.getCutPasswordMD5(paramString);
    Log.d("MicroMsg.NetSceneSetEmailPwd", "md5 ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(131145);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131146);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131146);
    return i;
  }
  
  public final int getType()
  {
    return 382;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131147);
    Log.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.an
 * JD-Core Version:    0.7.0.1
 */