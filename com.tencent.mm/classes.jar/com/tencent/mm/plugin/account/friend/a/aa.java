package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.we;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.sdk.platformtools.ac;

public final class aa
  extends n
  implements k
{
  public static int iLb = 1;
  public static int iLc = 2;
  public static int iLd = 3;
  public static int iLe = 4;
  private g callback;
  private b rr;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(131093);
    b.a locala = new b.a();
    locala.hvt = new we();
    locala.hvu = new wf();
    locala.uri = "/cgi-bin/micromsg-bin/checkunbind";
    locala.funcId = 254;
    locala.reqCmdId = 131;
    locala.respCmdId = 1000000131;
    this.rr = locala.aAz();
    ((we)this.rr.hvr.hvw).EqB = paramInt;
    AppMethodBeat.o(131093);
  }
  
  public final String aPN()
  {
    AppMethodBeat.i(131095);
    try
    {
      String str = ((wf)this.rr.hvs.hvw).EqC;
      ac.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
      AppMethodBeat.o(131095);
      return str;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", localException, "", new Object[0]);
      AppMethodBeat.o(131095);
    }
    return null;
  }
  
  public final wf aPO()
  {
    return (wf)this.rr.hvs.hvw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aa
 * JD-Core Version:    0.7.0.1
 */