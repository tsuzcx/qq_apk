package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zk;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends p
  implements m
{
  private h callback;
  public String kDc;
  private c oDw;
  
  public f(String paramString)
  {
    AppMethodBeat.i(304858);
    c.a locala = new c.a();
    zk localzk = new zk();
    localzk.kDc = paramString;
    this.kDc = paramString;
    locala.otE = localzk;
    locala.otF = new zl();
    locala.uri = "/cgi-bin/micromsg-bin/checkaliasvalid";
    locala.funcId = getType();
    this.oDw = locala.bEF();
    AppMethodBeat.o(304858);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(304861);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(304861);
    return i;
  }
  
  public final int getType()
  {
    return 3516;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(304865);
    Log.i("MicroMsg.NetSceneCheckAliasValid", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(304865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.f
 * JD-Core Version:    0.7.0.1
 */