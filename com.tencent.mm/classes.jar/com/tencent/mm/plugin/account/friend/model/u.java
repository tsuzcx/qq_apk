package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends p
  implements m
{
  public static int pTc = 0;
  public static int pTd = 1;
  public static int pTe = -85;
  private h callback;
  private int pTf;
  private String pTg;
  private int pTh;
  private final c rr;
  
  public u(a parama, String paramString, int paramInt)
  {
    AppMethodBeat.i(131086);
    this.pTf = -1;
    this.pTh = 0;
    switch (1.pTi[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.pTg = paramString;
      this.pTh = paramInt;
      parama = new c.a();
      parama.otE = new mq();
      parama.otF = new mr();
      parama.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
      parama.funcId = 487;
      parama.otG = 0;
      parama.respCmdId = 0;
      this.rr = parama.bEF();
      AppMethodBeat.o(131086);
      return;
      this.pTf = 1;
      continue;
      this.pTf = 2;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131087);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramh;
    paramh = (mq)c.b.b(this.rr.otB);
    paramh.YKH = this.pTf;
    paramh.YNO = this.pTg;
    paramh.YNP = this.pTh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131087);
    return i;
  }
  
  public final int getType()
  {
    return 487;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131088);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131088);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(131085);
      pTj = new a("MM_BIND_GCONTACT_OPCODE_BIND", 0);
      pTk = new a("MM_BIND_GCONTACT_OPCODE_UNBIND", 1);
      pTl = new a[] { pTj, pTk };
      AppMethodBeat.o(131085);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.u
 * JD-Core Version:    0.7.0.1
 */