package com.tencent.mm.plugin.messenger.c;

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
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends p
  implements m
{
  public dup KRv;
  public int action;
  private h callback;
  private final c rr;
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(288518);
    Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString1, ""), Util.nullAs(paramString1, ""), Util.secPrint(paramString3) });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/notautosucceed";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otE = new duo();
    ((c.a)localObject).otF = new dup();
    this.rr = ((c.a)localObject).bEF();
    this.action = paramInt;
    localObject = (duo)c.b.b(this.rr.otB);
    ((duo)localObject).abaA = Util.nullAs(paramString1, "");
    ((duo)localObject).abaB = Util.nullAs(paramString2, "");
    ((duo)localObject).abaC = Util.nullAs(paramString3, "");
    ((duo)localObject).action = paramInt;
    AppMethodBeat.o(288518);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(288525);
    this.callback = paramh;
    this.KRv = ((dup)c.c.b(this.rr.otC));
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(288525);
    return i;
  }
  
  public final int getType()
  {
    return 3713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(288528);
    Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(288528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.c.a
 * JD-Core Version:    0.7.0.1
 */