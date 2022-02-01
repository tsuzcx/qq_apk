package com.tencent.mm.plugin.account.friend.model;

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
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends p
  implements m
{
  public static int pTn = 1;
  public static int pTo = 2;
  public static int pTp = 3;
  public static int pTq = 4;
  private h callback;
  private c rr;
  
  public x(int paramInt)
  {
    AppMethodBeat.i(131093);
    c.a locala = new c.a();
    locala.otE = new aby();
    locala.otF = new abz();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.funcId = 254;
    locala.otG = 131;
    locala.respCmdId = 1000000131;
    this.rr = locala.bEF();
    ((aby)c.b.b(this.rr.otB)).Njm = paramInt;
    AppMethodBeat.o(131093);
  }
  
  public final String bXh()
  {
    AppMethodBeat.i(131095);
    try
    {
      String str = ((abz)c.c.b(this.rr.otC)).Zky;
      Log.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
      AppMethodBeat.o(131095);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", localException, "", new Object[0]);
      AppMethodBeat.o(131095);
    }
    return null;
  }
  
  public final abz bXi()
  {
    AppMethodBeat.i(304794);
    abz localabz = (abz)c.c.b(this.rr.otC);
    AppMethodBeat.o(304794);
    return localabz;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131094);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131094);
    return i;
  }
  
  public final int getType()
  {
    return 254;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131096);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.x
 * JD-Core Version:    0.7.0.1
 */