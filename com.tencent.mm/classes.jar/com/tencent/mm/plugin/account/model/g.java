package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  private i callback;
  public d iUB;
  
  public g()
  {
    AppMethodBeat.i(196849);
    d.a locala = new d.a();
    locala.iLN = new yc();
    locala.iLO = new yd();
    locala.uri = "/cgi-bin/micromsg-bin/checkcansetalias";
    locala.funcId = getType();
    this.iUB = locala.aXF();
    AppMethodBeat.o(196849);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(196850);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(196850);
    return i;
  }
  
  public final int getType()
  {
    return 926;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196851);
    Log.i("MicroMsg.NetSceneCheckModifyAlias", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(196851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.g
 * JD-Core Version:    0.7.0.1
 */