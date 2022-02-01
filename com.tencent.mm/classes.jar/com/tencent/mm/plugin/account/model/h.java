package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  private i callback;
  private d hJu;
  private der kit;
  
  public h(int paramInt, String paramString)
  {
    AppMethodBeat.i(127832);
    d.a locala = new d.a();
    locala.iLN = new der();
    locala.iLO = new des();
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
    this.hJu = locala.aXF();
    this.kit = ((der)this.hJu.iLK.iLR);
    this.kit.MJM = paramInt;
    this.kit.keh = paramString;
    AppMethodBeat.o(127832);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127833);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(127833);
    return i;
  }
  
  public final int getType()
  {
    return 268;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127834);
    Log.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(127834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.h
 * JD-Core Version:    0.7.0.1
 */