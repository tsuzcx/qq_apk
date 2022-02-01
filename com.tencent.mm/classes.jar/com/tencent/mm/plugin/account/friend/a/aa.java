package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.ad;

public final class aa
  extends n
  implements k
{
  public static int ikU = 1;
  public static int ikV = 2;
  public static int ikW = 3;
  public static int ikX = 4;
  private g callback;
  private b rr;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(131093);
    b.a locala = new b.a();
    locala.gUU = new vu();
    locala.gUV = new vv();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.funcId = 254;
    locala.reqCmdId = 131;
    locala.respCmdId = 1000000131;
    this.rr = locala.atI();
    ((vu)this.rr.gUS.gUX).CXS = paramInt;
    AppMethodBeat.o(131093);
  }
  
  public final String aIW()
  {
    AppMethodBeat.i(131095);
    try
    {
      String str = ((vv)this.rr.gUT.gUX).CXT;
      ad.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
      AppMethodBeat.o(131095);
      return str;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", localException, "", new Object[0]);
      AppMethodBeat.o(131095);
    }
    return null;
  }
  
  public final vv aIX()
  {
    return (vv)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(131094);
    this.callback = paramg;
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