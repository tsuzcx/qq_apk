package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  public dcw EVV;
  public int action;
  private i callback;
  private final d rr;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(213344);
    Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString1, ""), Util.nullAs(paramString1, ""), Util.secPrint(paramString3) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/notautosucceed";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBU = new dcv();
    ((d.a)localObject).lBV = new dcw();
    this.rr = ((d.a)localObject).bgN();
    this.action = paramInt;
    localObject = (dcv)d.b.b(this.rr.lBR);
    ((dcv)localObject).TKH = Util.nullAs(paramString1, "");
    ((dcv)localObject).TKI = Util.nullAs(paramString2, "");
    ((dcv)localObject).TKJ = Util.nullAs(paramString3, "");
    ((dcv)localObject).action = paramInt;
    AppMethodBeat.o(213344);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(213348);
    this.callback = parami;
    this.EVV = ((dcw)d.c.b(this.rr.lBS));
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(213348);
    return i;
  }
  
  public final int getType()
  {
    return 3713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(213351);
    Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(213351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */