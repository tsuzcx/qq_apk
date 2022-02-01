package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends q
  implements m
{
  public static int kfh = 1;
  public static int kfi = 2;
  public static int kfj = 3;
  public static int kfk = 4;
  private i callback;
  private d rr;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(131093);
    d.a locala = new d.a();
    locala.iLN = new zu();
    locala.iLO = new zv();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.funcId = 254;
    locala.iLP = 131;
    locala.respCmdId = 1000000131;
    this.rr = locala.aXF();
    ((zu)this.rr.iLK.iLR).Brf = paramInt;
    AppMethodBeat.o(131093);
  }
  
  public final String bok()
  {
    AppMethodBeat.i(131095);
    try
    {
      String str = ((zv)this.rr.iLL.iLR).Lld;
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
  
  public final zv bol()
  {
    return (zv)this.rr.iLL.iLR;
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