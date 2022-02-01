package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ae;

public final class aa
  extends n
  implements k
{
  public static int jhd = 1;
  public static int jhe = 2;
  public static int jhf = 3;
  public static int jhg = 4;
  private f callback;
  private b rr;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(131093);
    b.a locala = new b.a();
    locala.hQF = new yg();
    locala.hQG = new yh();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.funcId = 254;
    locala.hQH = 131;
    locala.respCmdId = 1000000131;
    this.rr = locala.aDS();
    ((yg)this.rr.hQD.hQJ).xrc = paramInt;
    AppMethodBeat.o(131093);
  }
  
  public final String aTy()
  {
    AppMethodBeat.i(131095);
    try
    {
      String str = ((yh)this.rr.hQE.hQJ).Gql;
      ae.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
      AppMethodBeat.o(131095);
      return str;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", localException, "", new Object[0]);
      AppMethodBeat.o(131095);
    }
    return null;
  }
  
  public final yh aTz()
  {
    return (yh)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131094);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131094);
    return i;
  }
  
  public final int getType()
  {
    return 254;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131096);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aa
 * JD-Core Version:    0.7.0.1
 */