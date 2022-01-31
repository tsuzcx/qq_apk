package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ab;

public final class y
  extends m
  implements k
{
  public static int gxX = 1;
  public static int gxY = 2;
  public static int gxZ = 3;
  public static int gya = 4;
  private f callback;
  private b rr;
  
  public y(int paramInt)
  {
    AppMethodBeat.i(108432);
    b.a locala = new b.a();
    locala.fsX = new tb();
    locala.fsY = new tc();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.funcId = 254;
    locala.reqCmdId = 131;
    locala.respCmdId = 1000000131;
    this.rr = locala.ado();
    ((tb)this.rr.fsV.fta).wLA = paramInt;
    AppMethodBeat.o(108432);
  }
  
  public final String aqB()
  {
    AppMethodBeat.i(108434);
    try
    {
      String str = ((tc)this.rr.fsW.fta).wLB;
      ab.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
      AppMethodBeat.o(108434);
      return str;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", localException, "", new Object[0]);
      AppMethodBeat.o(108434);
    }
    return null;
  }
  
  public final tc aqC()
  {
    return (tc)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108433);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108433);
    return i;
  }
  
  public final int getType()
  {
    return 254;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108435);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.y
 * JD-Core Version:    0.7.0.1
 */