package com.tencent.mm.plugin.account.friend.a;

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
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends q
  implements m
{
  public static int mWG = 1;
  public static int mWH = 2;
  public static int mWI = 3;
  public static int mWJ = 4;
  private i callback;
  private d rr;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(131093);
    d.a locala = new d.a();
    locala.lBU = new zy();
    locala.lBV = new zz();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.funcId = 254;
    locala.lBW = 131;
    locala.respCmdId = 1000000131;
    this.rr = locala.bgN();
    ((zy)d.b.b(this.rr.lBR)).Hly = paramInt;
    AppMethodBeat.o(131093);
  }
  
  public final String byt()
  {
    AppMethodBeat.i(131095);
    try
    {
      String str = ((zz)d.c.b(this.rr.lBS)).Smm;
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
  
  public final zz byu()
  {
    AppMethodBeat.i(194157);
    zz localzz = (zz)d.c.b(this.rr.lBS);
    AppMethodBeat.o(194157);
    return localzz;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131094);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aa
 * JD-Core Version:    0.7.0.1
 */